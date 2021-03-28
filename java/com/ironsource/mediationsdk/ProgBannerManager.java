package com.ironsource.mediationsdk;

import android.app.Activity;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.anythink.reactnativejs.utils.Const;
import com.ironsource.eventsmodule.EventData;
import com.ironsource.mediationsdk.AuctionHistory;
import com.ironsource.mediationsdk.BannerUtils;
import com.ironsource.mediationsdk.events.InterstitialEventsManager;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.BannerPlacement;
import com.ironsource.mediationsdk.model.ProviderSettings;
import com.ironsource.mediationsdk.timer.BannerReloadTimer;
import com.ironsource.mediationsdk.utils.CappingManager;
import com.ironsource.mediationsdk.utils.ContextProvider;
import com.ironsource.mediationsdk.utils.DurationMeasurement;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.SessionDepthManager;
import com.tapjoy.TapjoyAuctionFlags;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class ProgBannerManager extends BaseProgManager implements ProgBannerManagerListener, AuctionEventListener, BannerReloadTimer.ReloadIntervalInterface, ContextProvider.ContextLifeCycleListener {
    private ProgBannerSmash mActiveSmash;
    private String mAuctionFallback = "";
    private AuctionHandler mAuctionHandler;
    private AuctionHistory mAuctionHistory;
    private int mAuctionTrail;
    private String mCurrentAuctionId;
    private int mCurrentLoadingIndex;
    private BannerPlacement mCurrentPlacement;
    private int mCurrentSessionDepth;
    private BannerManagerState mCurrentState = BannerManagerState.NONE;
    private BannerData mData;
    private AuctionResponseItem mGenericNotifications;
    private JSONObject mGenericParams;
    private long mInitMangerTimeStamp;
    private IronSourceBannerLayout mIronSourceBanner;
    private AtomicBoolean mIsInForeground;
    private DurationMeasurement mLoadDuration;
    private final ConcurrentHashMap<String, ProgBannerSmash> mSmashes;
    private final Object mStateLock = new Object();
    private BannerReloadTimer mTimer;
    private CopyOnWriteArrayList<ProgBannerSmash> mWaterfall;
    private ConcurrentHashMap<String, AuctionHistory.ISAuctionPerformance> mWaterfallPerformance;
    private ConcurrentHashMap<String, AuctionResponseItem> mWaterfallServerData;

    /* access modifiers changed from: package-private */
    public enum BannerManagerState {
        NONE,
        READY_TO_LOAD,
        STARTED_LOADING,
        FIRST_AUCTION,
        AUCTION,
        LOADING,
        RELOADING,
        LOADED
    }

    private boolean shouldAddAuctionParams(int i) {
        return i == 3201 || i == 3110 || i == 3111 || i == 3116 || i == 3112 || i == 3115 || i == 3501 || i == 3502;
    }

    public ProgBannerManager(List<ProviderSettings> list, BannerData bannerData, HashSet<ImpressionDataListener> hashSet) {
        super(hashSet);
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("isAuctionEnabled = " + bannerData.isAuctionEnabled());
        this.mData = bannerData;
        this.mTimer = new BannerReloadTimer(bannerData.getBannerRefreshIntervalInSeconds());
        this.mSmashes = new ConcurrentHashMap<>();
        this.mWaterfall = new CopyOnWriteArrayList<>();
        this.mWaterfallServerData = new ConcurrentHashMap<>();
        this.mWaterfallPerformance = new ConcurrentHashMap<>();
        this.mCurrentSessionDepth = SessionDepthManager.getInstance().getSessionDepth(3);
        BannerCallbackThrottler.getInstance().setDelayLoadFailureNotificationInSeconds(this.mData.getBannerDelayLoadFailureInSeconds());
        if (this.mData.isAuctionEnabled()) {
            this.mAuctionHandler = new AuctionHandler("banner", this.mData.getAuctionSettings(), this);
        }
        initAuctionHistory(list);
        setSmashMap(list);
        this.mIsInForeground = new AtomicBoolean(true);
        ContextProvider.getInstance().registerLifeCycleListener(this);
        this.mInitMangerTimeStamp = new Date().getTime();
        setState(BannerManagerState.READY_TO_LOAD);
    }

    private void initAuctionHistory(List<ProviderSettings> list) {
        ArrayList arrayList = new ArrayList();
        for (ProviderSettings providerSettings : list) {
            arrayList.add(providerSettings.getProviderName());
        }
        this.mAuctionHistory = new AuctionHistory(arrayList, this.mData.getAuctionSettings().getAuctionSavedHistoryLimit());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean compareStateAndSetIfTrue(BannerManagerState bannerManagerState, BannerManagerState bannerManagerState2) {
        boolean z;
        synchronized (this.mStateLock) {
            if (this.mCurrentState == bannerManagerState) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose("set state from '" + this.mCurrentState + "' to '" + bannerManagerState2 + "'");
                z = true;
                this.mCurrentState = bannerManagerState2;
            } else {
                z = false;
            }
        }
        return z;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setState(BannerManagerState bannerManagerState) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("from '" + this.mCurrentState + "' to '" + bannerManagerState + "'");
        synchronized (this.mStateLock) {
            this.mCurrentState = bannerManagerState;
        }
    }

    public void loadBanner(final IronSourceBannerLayout ironSourceBannerLayout, final BannerPlacement bannerPlacement) {
        IronLog.INTERNAL.verbose("");
        if (!compareStateAndSetIfTrue(BannerManagerState.READY_TO_LOAD, BannerManagerState.STARTED_LOADING)) {
            IronLog.API.error("can't load banner - loadBanner already called and still in progress");
        } else if (!BannerCallbackThrottler.getInstance().hasPendingInvocation()) {
            BannerUtils.verifyLoadBanner(ironSourceBannerLayout, bannerPlacement, new BannerUtils.VerifyBannerListener() {
                /* class com.ironsource.mediationsdk.ProgBannerManager.AnonymousClass1 */

                @Override // com.ironsource.mediationsdk.BannerUtils.VerifyBannerListener
                public void success() {
                    IronLog ironLog = IronLog.INTERNAL;
                    ironLog.verbose("placement = " + bannerPlacement.getPlacementName());
                    ProgBannerManager.this.mIronSourceBanner = ironSourceBannerLayout;
                    ProgBannerManager.this.mCurrentPlacement = bannerPlacement;
                    if (CappingManager.isBnPlacementCapped(ContextProvider.getInstance().getCurrentActiveActivity(), bannerPlacement.getPlacementName())) {
                        IronLog.INTERNAL.verbose("placement is capped");
                        BannerCallbackThrottler instance = BannerCallbackThrottler.getInstance();
                        IronSourceBannerLayout ironSourceBannerLayout = ironSourceBannerLayout;
                        instance.sendBannerAdLoadFailed(ironSourceBannerLayout, new IronSourceError(IronSourceError.ERROR_BN_LOAD_PLACEMENT_CAPPED, "placement '" + bannerPlacement.getPlacementName() + "' is capped"));
                        ProgBannerManager.this.sendMediationEvent(IronSourceConstants.BN_CALLBACK_LOAD_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf((int) IronSourceError.ERROR_BN_LOAD_PLACEMENT_CAPPED)}});
                        ProgBannerManager.this.setState(BannerManagerState.READY_TO_LOAD);
                        return;
                    }
                    ProgBannerManager.this.startLoadingBanner(false);
                }

                @Override // com.ironsource.mediationsdk.BannerUtils.VerifyBannerListener
                public void failed(String str) {
                    IronLog ironLog = IronLog.API;
                    ironLog.error("can't load banner - errorMessage = " + str);
                }
            });
        } else {
            IronLog.INTERNAL.verbose("can't load banner - already has pending invocation");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void startLoadingBanner(boolean z) {
        BannerManagerState bannerManagerState;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("current state = " + this.mCurrentState);
        if (this.mData.isAuctionEnabled()) {
            bannerManagerState = z ? BannerManagerState.AUCTION : BannerManagerState.FIRST_AUCTION;
        } else {
            bannerManagerState = z ? BannerManagerState.RELOADING : BannerManagerState.LOADING;
        }
        if (compareStateAndSetIfTrue(BannerManagerState.STARTED_LOADING, bannerManagerState)) {
            this.mLoadDuration = new DurationMeasurement();
            this.mCurrentAuctionId = "";
            this.mGenericParams = null;
            this.mCurrentLoadingIndex = 0;
            this.mCurrentSessionDepth = SessionDepthManager.getInstance().getSessionDepth(3);
            if (z) {
                sendMediationEvent(IronSourceConstants.BN_RELOAD);
            } else {
                sendMediationEvent(3001);
            }
            if (this.mData.isAuctionEnabled()) {
                makeAuction();
                return;
            }
            updateWaterfallToNonBidding();
            loadNextSmash();
            return;
        }
        IronLog ironLog2 = IronLog.INTERNAL;
        ironLog2.error("wrong state - " + this.mCurrentState);
    }

    public void destroyBanner(final IronSourceBannerLayout ironSourceBannerLayout) {
        IronLog.INTERNAL.verbose("");
        BannerUtils.verifyDestroyBanner(ironSourceBannerLayout, new BannerUtils.VerifyBannerListener() {
            /* class com.ironsource.mediationsdk.ProgBannerManager.AnonymousClass2 */

            @Override // com.ironsource.mediationsdk.BannerUtils.VerifyBannerListener
            public void success() {
                IronLog.INTERNAL.verbose("destroying banner");
                ProgBannerManager.this.mTimer.stopReloadTimer();
                ProgBannerManager.this.sendMediationEvent(IronSourceConstants.BN_DESTROY, null, ProgBannerManager.this.mActiveSmash != null ? ProgBannerManager.this.mActiveSmash.getSessionDepth() : ProgBannerManager.this.mCurrentSessionDepth);
                ProgBannerManager.this.destroyActiveSmash();
                ironSourceBannerLayout.destroyBanner();
                ProgBannerManager.this.mIronSourceBanner = null;
                ProgBannerManager.this.mCurrentPlacement = null;
                ProgBannerManager.this.setState(BannerManagerState.READY_TO_LOAD);
            }

            @Override // com.ironsource.mediationsdk.BannerUtils.VerifyBannerListener
            public void failed(String str) {
                IronLog ironLog = IronLog.API;
                ironLog.error("destroy banner failed - errorMessage = " + str);
            }
        });
    }

    @Override // com.ironsource.mediationsdk.utils.ContextProvider.ContextLifeCycleListener
    public void onResume(Activity activity) {
        this.mIsInForeground.set(true);
    }

    @Override // com.ironsource.mediationsdk.utils.ContextProvider.ContextLifeCycleListener
    public void onPause(Activity activity) {
        this.mIsInForeground.set(false);
    }

    @Override // com.ironsource.mediationsdk.AuctionEventListener
    public void onAuctionSuccess(List<AuctionResponseItem> list, String str, AuctionResponseItem auctionResponseItem, JSONObject jSONObject, int i, long j) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("auctionId = " + str);
        if (isWaitingForAuctionResponse()) {
            this.mAuctionFallback = "";
            this.mCurrentAuctionId = str;
            this.mAuctionTrail = i;
            this.mGenericNotifications = auctionResponseItem;
            this.mGenericParams = jSONObject;
            sendMediationEvent(IronSourceConstants.BN_AUCTION_SUCCESS, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j)}});
            setState(this.mCurrentState == BannerManagerState.FIRST_AUCTION ? BannerManagerState.LOADING : BannerManagerState.RELOADING);
            sendMediationEvent(IronSourceConstants.BN_AUCTION_RESPONSE_WATERFALL, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, updateWaterfall(list)}});
            loadNextSmash();
            return;
        }
        IronLog ironLog2 = IronLog.INTERNAL;
        ironLog2.warning("wrong state - mCurrentState = " + this.mCurrentState);
    }

    @Override // com.ironsource.mediationsdk.AuctionEventListener
    public void onAuctionFailed(int i, String str, int i2, String str2, long j) {
        String str3 = "Auction failed | moving to fallback waterfall (error " + i + " - " + str + ")";
        IronLog.INTERNAL.verbose(str3);
        IronSourceUtils.sendAutomationLog("BN: " + str3);
        if (isWaitingForAuctionResponse()) {
            this.mAuctionFallback = str2;
            this.mAuctionTrail = i2;
            this.mGenericParams = null;
            updateWaterfallToNonBidding();
            sendMediationEvent(IronSourceConstants.BN_AUCTION_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j)}, new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, str}});
            setState(this.mCurrentState == BannerManagerState.FIRST_AUCTION ? BannerManagerState.LOADING : BannerManagerState.RELOADING);
            loadNextSmash();
            return;
        }
        IronLog.INTERNAL.warning("wrong state - mCurrentState = " + this.mCurrentState);
    }

    @Override // com.ironsource.mediationsdk.ProgBannerManagerListener
    public void onBannerLoadSuccess(ProgBannerSmash progBannerSmash, View view, FrameLayout.LayoutParams layoutParams) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("smash = " + progBannerSmash.getInstanceSignature());
        if (isWaitingForLoadResponse()) {
            this.mActiveSmash = progBannerSmash;
            bindView(view, layoutParams);
            this.mWaterfallPerformance.put(progBannerSmash.getInstanceName(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceShowedSuccessfully);
            if (this.mData.isAuctionEnabled()) {
                AuctionResponseItem auctionResponseItem = this.mWaterfallServerData.get(progBannerSmash.getInstanceName());
                if (auctionResponseItem != null) {
                    this.mAuctionHandler.reportLoadSuccess(auctionResponseItem, progBannerSmash.getInstanceType(), this.mGenericNotifications);
                    this.mAuctionHandler.reportAuctionLose(this.mWaterfall, this.mWaterfallServerData, progBannerSmash.getInstanceType(), this.mGenericNotifications, auctionResponseItem);
                    this.mAuctionHandler.reportImpression(auctionResponseItem, progBannerSmash.getInstanceType(), this.mGenericNotifications, getCurrentPlacementName());
                    reportImpressionDataToPublisher(this.mWaterfallServerData.get(progBannerSmash.getInstanceName()), getCurrentPlacementName());
                } else {
                    String instanceName = progBannerSmash.getInstanceName();
                    IronLog ironLog2 = IronLog.INTERNAL;
                    ironLog2.error("onLoadSuccess winner instance " + instanceName + " missing from waterfall. auctionId = " + this.mCurrentAuctionId);
                    sendMediationEvent(IronSourceConstants.TROUBLESHOOTING_BN_NOTIFICATIONS_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "Loaded missing"}, new Object[]{IronSourceConstants.EVENTS_EXT1, instanceName}});
                }
            }
            if (this.mCurrentState == BannerManagerState.LOADING) {
                this.mIronSourceBanner.sendBannerAdLoaded(progBannerSmash.getInstanceName());
                sendMediationEvent(IronSourceConstants.BN_CALLBACK_LOAD_SUCCESS, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(DurationMeasurement.getMeasuredDuration(this.mLoadDuration))}});
            } else {
                sendMediationEvent(IronSourceConstants.BN_CALLBACK_RELOAD_SUCCESS, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(DurationMeasurement.getMeasuredDuration(this.mLoadDuration))}});
            }
            handlePlacementCapping();
            SessionDepthManager.getInstance().increaseSessionDepth(3);
            setState(BannerManagerState.LOADED);
            this.mTimer.startReloadTimer(this);
            return;
        }
        IronLog ironLog3 = IronLog.INTERNAL;
        ironLog3.warning("wrong state - mCurrentState = " + this.mCurrentState);
    }

    @Override // com.ironsource.mediationsdk.ProgBannerManagerListener
    public void onBannerLoadFailed(IronSourceError ironSourceError, ProgBannerSmash progBannerSmash, boolean z) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("error = " + ironSourceError);
        if (isWaitingForLoadResponse()) {
            this.mWaterfallPerformance.put(progBannerSmash.getInstanceName(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceFailedToLoad);
            loadNextSmash();
            return;
        }
        IronLog ironLog2 = IronLog.INTERNAL;
        ironLog2.warning("wrong state - mCurrentState = " + this.mCurrentState);
    }

    @Override // com.ironsource.mediationsdk.ProgBannerManagerListener
    public void onBannerClicked(ProgBannerSmash progBannerSmash) {
        IronLog.INTERNAL.verbose(progBannerSmash.getInstanceSignature());
        Object[][] objArr = null;
        if (canSendBannerCallbacks()) {
            this.mIronSourceBanner.sendBannerAdClicked();
        } else {
            objArr = new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "banner is destroyed"}};
        }
        sendMediationEvent(IronSourceConstants.BN_CALLBACK_CLICK, objArr, progBannerSmash.getSessionDepth());
    }

    @Override // com.ironsource.mediationsdk.ProgBannerManagerListener
    public void onBannerScreenDismissed(ProgBannerSmash progBannerSmash) {
        IronLog.INTERNAL.verbose(progBannerSmash.getInstanceSignature());
        Object[][] objArr = null;
        if (canSendBannerCallbacks()) {
            this.mIronSourceBanner.sendBannerAdScreenDismissed();
        } else {
            objArr = new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "banner is destroyed"}};
        }
        sendMediationEvent(IronSourceConstants.BN_CALLBACK_DISMISS_SCREEN, objArr, progBannerSmash.getSessionDepth());
    }

    @Override // com.ironsource.mediationsdk.ProgBannerManagerListener
    public void onBannerScreenPresented(ProgBannerSmash progBannerSmash) {
        IronLog.INTERNAL.verbose(progBannerSmash.getInstanceSignature());
        Object[][] objArr = null;
        if (canSendBannerCallbacks()) {
            this.mIronSourceBanner.sendBannerAdScreenPresented();
        } else {
            objArr = new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "banner is destroyed"}};
        }
        sendMediationEvent(IronSourceConstants.BN_CALLBACK_PRESENT_SCREEN, objArr, progBannerSmash.getSessionDepth());
    }

    @Override // com.ironsource.mediationsdk.ProgBannerManagerListener
    public void onBannerLeftApplication(ProgBannerSmash progBannerSmash) {
        IronLog.INTERNAL.verbose(progBannerSmash.getInstanceSignature());
        Object[][] objArr = null;
        if (canSendBannerCallbacks()) {
            this.mIronSourceBanner.sendBannerAdLeftApplication();
        } else {
            objArr = new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "banner is destroyed"}};
        }
        sendMediationEvent(IronSourceConstants.BN_CALLBACK_LEAVE_APP, objArr, progBannerSmash.getSessionDepth());
    }

    @Override // com.ironsource.mediationsdk.ProgBannerManagerListener
    public void onBannerShown(ProgBannerSmash progBannerSmash) {
        IronLog.INTERNAL.verbose(progBannerSmash.getInstanceSignature());
        sendMediationEvent(IronSourceConstants.BN_CALLBACK_SHOW);
    }

    @Override // com.ironsource.mediationsdk.timer.BannerReloadTimer.ReloadIntervalInterface
    public void onReloadInterval() {
        if (!this.mIsInForeground.get()) {
            IronLog.INTERNAL.verbose("app in background - start reload timer");
            sendMediationEvent(IronSourceConstants.BN_SKIP_RELOAD, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf((int) IronSourceError.ERROR_BN_RELOAD_SKIP_BACKGROUND)}});
            this.mTimer.startReloadTimer(this);
        } else if (compareStateAndSetIfTrue(BannerManagerState.LOADED, BannerManagerState.STARTED_LOADING)) {
            IronLog.INTERNAL.verbose("start loading");
            startLoadingBanner(true);
        } else {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("wrong state = " + this.mCurrentState);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void makeAuction() {
        IronLog.INTERNAL.verbose("");
        AsyncTask.execute(new Runnable() {
            /* class com.ironsource.mediationsdk.ProgBannerManager.AnonymousClass3 */

            public void run() {
                ProgBannerManager.this.storeWaterfallPerformance();
                if (!ProgBannerManager.this.waitBeforeAuction()) {
                    ProgBannerManager.this.sendMediationEvent(IronSourceConstants.BN_AUCTION_REQUEST);
                    BannerUtils.createAuctionCandidates(ProgBannerManager.this.getCurrentPlacementName(), ProgBannerManager.this.mSmashes, new BannerUtils.CreateCandidatesListener() {
                        /* class com.ironsource.mediationsdk.ProgBannerManager.AnonymousClass3.AnonymousClass1 */

                        @Override // com.ironsource.mediationsdk.BannerUtils.CreateCandidatesListener
                        public void onFinish(Map<String, Object> map, List<String> list, StringBuilder sb) {
                            IronLog ironLog = IronLog.INTERNAL;
                            ironLog.verbose("auction waterfallString = " + ((Object) sb));
                            if (map.size() == 0 && list.size() == 0) {
                                ProgBannerManager.this.sendMediationEvent(IronSourceConstants.BN_AUCTION_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1005}, new Object[]{IronSourceConstants.EVENTS_DURATION, 0}});
                                if (ProgBannerManager.this.compareStateAndSetIfTrue(BannerManagerState.AUCTION, BannerManagerState.LOADED)) {
                                    ProgBannerManager.this.mTimer.startReloadTimer(ProgBannerManager.this);
                                    return;
                                }
                                BannerCallbackThrottler.getInstance().sendBannerAdLoadFailed(ProgBannerManager.this.mIronSourceBanner, new IronSourceError(1005, "No candidates available for auctioning"));
                                ProgBannerManager.this.sendMediationEvent(IronSourceConstants.BN_CALLBACK_LOAD_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1005}});
                                ProgBannerManager.this.setState(BannerManagerState.READY_TO_LOAD);
                                return;
                            }
                            ProgBannerManager.this.sendMediationEvent(IronSourceConstants.BN_AUCTION_REQUEST_WATERFALL, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, sb.toString()}});
                            if (ProgBannerManager.this.mAuctionHandler != null) {
                                ProgBannerManager.this.mAuctionHandler.executeAuction(ContextProvider.getInstance().getApplicationContext(), map, list, ProgBannerManager.this.mAuctionHistory, ProgBannerManager.this.mCurrentSessionDepth, ProgBannerManager.this.getBannerSizeForAuction());
                            } else {
                                IronLog.INTERNAL.error("mAuctionHandler is null");
                            }
                        }
                    });
                }
            }
        });
    }

    private void setSmashMap(List<ProviderSettings> list) {
        for (int i = 0; i < list.size(); i++) {
            ProviderSettings providerSettings = list.get(i);
            AbstractAdapter adapter = AdapterRepository.getInstance().getAdapter(providerSettings, providerSettings.getBannerSettings());
            if (adapter != null) {
                ProgBannerSmash progBannerSmash = new ProgBannerSmash(this.mData, this, providerSettings, adapter, this.mCurrentSessionDepth, isReload());
                this.mSmashes.put(progBannerSmash.getInstanceName(), progBannerSmash);
            } else {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose(providerSettings.getProviderInstanceName() + " can't load adapter");
            }
        }
    }

    private void loadNextSmash() {
        for (int i = this.mCurrentLoadingIndex; i < this.mWaterfall.size(); i++) {
            ProgBannerSmash progBannerSmash = this.mWaterfall.get(i);
            if (progBannerSmash.getIsLoadCandidate()) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose("loading smash - " + progBannerSmash.getInstanceSignature());
                this.mCurrentLoadingIndex = i + 1;
                loadSmash(progBannerSmash);
                return;
            }
        }
        handleEndOfWaterfallWithoutLoading();
    }

    private void loadSmash(ProgBannerSmash progBannerSmash) {
        String str;
        if (progBannerSmash.isBidder()) {
            str = this.mWaterfallServerData.get(progBannerSmash.getInstanceName()).getServerData();
            progBannerSmash.setDynamicDemandSourceIdByServerData(str);
        } else {
            str = null;
        }
        progBannerSmash.loadBanner(this.mIronSourceBanner, this.mCurrentPlacement, str);
    }

    private void handleEndOfWaterfallWithoutLoading() {
        String str = this.mWaterfall.isEmpty() ? "Empty waterfall" : "No candidates left to load";
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("errorReason = " + str);
        if (compareStateAndSetIfTrue(BannerManagerState.LOADING, BannerManagerState.READY_TO_LOAD)) {
            sendMediationEvent(IronSourceConstants.BN_CALLBACK_LOAD_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf((int) IronSourceError.ERROR_BN_LOAD_NO_FILL)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, str}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(DurationMeasurement.getMeasuredDuration(this.mLoadDuration))}});
            BannerCallbackThrottler.getInstance().sendBannerAdLoadFailed(this.mIronSourceBanner, new IronSourceError(IronSourceError.ERROR_BN_LOAD_NO_FILL, str));
        } else if (compareStateAndSetIfTrue(BannerManagerState.RELOADING, BannerManagerState.LOADED)) {
            sendMediationEvent(IronSourceConstants.BN_RELOAD_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(DurationMeasurement.getMeasuredDuration(this.mLoadDuration))}});
            this.mTimer.startReloadTimer(this);
        } else {
            setState(BannerManagerState.READY_TO_LOAD);
            IronLog ironLog2 = IronLog.INTERNAL;
            ironLog2.error("wrong state = " + this.mCurrentState);
        }
    }

    private void bindView(View view, FrameLayout.LayoutParams layoutParams) {
        this.mIronSourceBanner.addViewWithFrameLayoutParams(view, layoutParams);
    }

    private String updateWaterfall(List<AuctionResponseItem> list) {
        IronLog.INTERNAL.verbose("waterfall.size() = " + list.size());
        this.mWaterfall.clear();
        this.mWaterfallServerData.clear();
        this.mWaterfallPerformance.clear();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            AuctionResponseItem auctionResponseItem = list.get(i);
            addSmashToWaterfall(auctionResponseItem);
            sb.append(createWaterfallStringFromAuctionItem(auctionResponseItem));
            if (i != list.size() - 1) {
                sb.append(",");
            }
        }
        String str = "updateWaterfall() - next waterfall is " + sb.toString();
        IronLog.INTERNAL.verbose(str);
        IronSourceUtils.sendAutomationLog("BN: " + str);
        return sb.toString();
    }

    private void addSmashToWaterfall(AuctionResponseItem auctionResponseItem) {
        ProgBannerSmash progBannerSmash = this.mSmashes.get(auctionResponseItem.getInstanceName());
        if (progBannerSmash != null) {
            AbstractAdapter createAdapter = AdapterRepository.getInstance().createAdapter(progBannerSmash.mAdapterConfig.getProviderSettings());
            if (createAdapter != null) {
                ProgBannerSmash progBannerSmash2 = new ProgBannerSmash(this.mData, this, progBannerSmash.mAdapterConfig.getProviderSettings(), createAdapter, this.mCurrentSessionDepth, this.mCurrentAuctionId, this.mGenericParams, this.mAuctionTrail, this.mAuctionFallback, isReload());
                progBannerSmash2.setIsLoadCandidate(true);
                this.mWaterfall.add(progBannerSmash2);
                this.mWaterfallServerData.put(progBannerSmash2.getInstanceName(), auctionResponseItem);
                this.mWaterfallPerformance.put(auctionResponseItem.getInstanceName(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceDidntAttemptToLoad);
                return;
            }
            return;
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.error("could not find matching smash for auction response item - item = " + auctionResponseItem.getInstanceName());
    }

    private void updateWaterfallToNonBidding() {
        List<AuctionResponseItem> extractNonBidderProvidersFromWaterfall = extractNonBidderProvidersFromWaterfall();
        this.mCurrentAuctionId = getAuctionFallbackId();
        updateWaterfall(extractNonBidderProvidersFromWaterfall);
    }

    private List<AuctionResponseItem> extractNonBidderProvidersFromWaterfall() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (ProgBannerSmash progBannerSmash : this.mSmashes.values()) {
            if (!progBannerSmash.isBidder() && !CappingManager.isBnPlacementCapped(ContextProvider.getInstance().getCurrentActiveActivity(), getCurrentPlacementName())) {
                copyOnWriteArrayList.add(new AuctionResponseItem(progBannerSmash.getInstanceName()));
            }
        }
        return copyOnWriteArrayList;
    }

    private void handlePlacementCapping() {
        String currentPlacementName = getCurrentPlacementName();
        CappingManager.incrementBnShowCounter(ContextProvider.getInstance().getCurrentActiveActivity(), currentPlacementName);
        if (CappingManager.isBnPlacementCapped(ContextProvider.getInstance().getCurrentActiveActivity(), currentPlacementName)) {
            sendMediationEvent(IronSourceConstants.BN_PLACEMENT_CAPPED);
        }
    }

    private String createWaterfallStringFromAuctionItem(AuctionResponseItem auctionResponseItem) {
        ProgBannerSmash progBannerSmash = this.mSmashes.get(auctionResponseItem.getInstanceName());
        String str = "1";
        if (progBannerSmash == null ? !TextUtils.isEmpty(auctionResponseItem.getServerData()) : progBannerSmash.isBidder()) {
            str = TapjoyAuctionFlags.AUCTION_TYPE_SECOND_PRICE;
        }
        return str + auctionResponseItem.getInstanceName();
    }

    private boolean canSendBannerCallbacks() {
        IronSourceBannerLayout ironSourceBannerLayout = this.mIronSourceBanner;
        return ironSourceBannerLayout != null && !ironSourceBannerLayout.isDestroyed();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void storeWaterfallPerformance() {
        if (!this.mWaterfallPerformance.isEmpty()) {
            this.mAuctionHistory.storeWaterfallPerformance(this.mWaterfallPerformance);
            this.mWaterfallPerformance.clear();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void destroyActiveSmash() {
        if (this.mActiveSmash != null) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose("mActiveSmash = " + this.mActiveSmash.getInstanceSignature());
            this.mActiveSmash.destroyBanner();
            this.mActiveSmash = null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean waitBeforeAuction() {
        long timeToWaitBeforeFirstAuction = BannerUtils.getTimeToWaitBeforeFirstAuction(this.mInitMangerTimeStamp, this.mData.getTimeToWaitBeforeFirstAuctionInMillis());
        if (timeToWaitBeforeFirstAuction <= 0) {
            return false;
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("waiting before auction - timeToWaitBeforeAuction = " + timeToWaitBeforeFirstAuction);
        new Timer().schedule(new TimerTask() {
            /* class com.ironsource.mediationsdk.ProgBannerManager.AnonymousClass4 */

            public void run() {
                ProgBannerManager.this.makeAuction();
            }
        }, timeToWaitBeforeFirstAuction);
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void sendMediationEvent(int i) {
        sendMediationEvent(i, null);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void sendMediationEvent(int i, Object[][] objArr) {
        sendMediationEvent(i, objArr, this.mCurrentSessionDepth);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void sendMediationEvent(int i, Object[][] objArr, int i2) {
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, 1);
        try {
            ISBannerSize currentBannerSize = getCurrentBannerSize();
            if (currentBannerSize != null) {
                addEventSizeFields(mediationAdditionalData, currentBannerSize);
            }
            if (this.mCurrentPlacement != null) {
                mediationAdditionalData.put(IronSourceConstants.EVENTS_PLACEMENT_NAME, getCurrentPlacementName());
            }
            mediationAdditionalData.put("sessionDepth", i2);
            if (!TextUtils.isEmpty(this.mCurrentAuctionId)) {
                mediationAdditionalData.put("auctionId", this.mCurrentAuctionId);
            }
            if (this.mGenericParams != null && this.mGenericParams.length() > 0) {
                mediationAdditionalData.put("genericParams", this.mGenericParams);
            }
            if (shouldAddAuctionParams(i)) {
                mediationAdditionalData.put(IronSourceConstants.AUCTION_TRIALS, this.mAuctionTrail);
                if (!TextUtils.isEmpty(this.mAuctionFallback)) {
                    mediationAdditionalData.put(IronSourceConstants.AUCTION_FALLBACK, this.mAuctionFallback);
                }
            }
            if (objArr != null) {
                for (Object[] objArr2 : objArr) {
                    mediationAdditionalData.put(objArr2[0].toString(), objArr2[1]);
                }
            }
        } catch (Exception e) {
            IronLog.INTERNAL.error(Log.getStackTraceString(e));
        }
        InterstitialEventsManager.getInstance().log(new EventData(i, mediationAdditionalData));
    }

    private static void addEventSizeFields(JSONObject jSONObject, ISBannerSize iSBannerSize) {
        try {
            String description = iSBannerSize.getDescription();
            char c = 65535;
            switch (description.hashCode()) {
                case -387072689:
                    if (description.equals("RECTANGLE")) {
                        c = 2;
                        break;
                    }
                    break;
                case 72205083:
                    if (description.equals("LARGE")) {
                        c = 1;
                        break;
                    }
                    break;
                case 79011241:
                    if (description.equals("SMART")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1951953708:
                    if (description.equals("BANNER")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1999208305:
                    if (description.equals("CUSTOM")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                jSONObject.put("bannerAdSize", 1);
            } else if (c == 1) {
                jSONObject.put("bannerAdSize", 2);
            } else if (c == 2) {
                jSONObject.put("bannerAdSize", 3);
            } else if (c == 3) {
                jSONObject.put("bannerAdSize", 5);
            } else if (c == 4) {
                jSONObject.put("bannerAdSize", 6);
                jSONObject.put("custom_banner_size", iSBannerSize.getWidth() + Const.X + iSBannerSize.getHeight());
            }
        } catch (Exception e) {
            IronLog.INTERNAL.error(Log.getStackTraceString(e));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ISBannerSize getBannerSizeForAuction() {
        IronSourceBannerLayout ironSourceBannerLayout = this.mIronSourceBanner;
        if (ironSourceBannerLayout == null || ironSourceBannerLayout.getSize() == null) {
            return null;
        }
        if (!this.mIronSourceBanner.getSize().isSmart()) {
            return this.mIronSourceBanner.getSize();
        }
        if (AdapterUtils.isLargeScreen(ContextProvider.getInstance().getCurrentActiveActivity())) {
            return ISBannerSize.LEADERBOARD;
        }
        return ISBannerSize.BANNER;
    }

    private ISBannerSize getCurrentBannerSize() {
        IronSourceBannerLayout ironSourceBannerLayout = this.mIronSourceBanner;
        if (ironSourceBannerLayout != null) {
            return ironSourceBannerLayout.getSize();
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String getCurrentPlacementName() {
        BannerPlacement bannerPlacement = this.mCurrentPlacement;
        return bannerPlacement != null ? bannerPlacement.getPlacementName() : "";
    }

    private boolean isWaitingForLoadResponse() {
        boolean z;
        synchronized (this.mStateLock) {
            if (this.mCurrentState != BannerManagerState.LOADING) {
                if (this.mCurrentState != BannerManagerState.RELOADING) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    private boolean isWaitingForAuctionResponse() {
        boolean z;
        synchronized (this.mStateLock) {
            if (this.mCurrentState != BannerManagerState.FIRST_AUCTION) {
                if (this.mCurrentState != BannerManagerState.AUCTION) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    private boolean isReload() {
        return this.mCurrentState == BannerManagerState.RELOADING || this.mCurrentState == BannerManagerState.AUCTION;
    }
}
