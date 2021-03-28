package com.ironsource.mediationsdk;

import android.content.Context;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.ironsource.environment.NetworkStateReceiver;
import com.ironsource.environment.NetworkStateReceiverListener;
import com.ironsource.eventsmodule.EventData;
import com.ironsource.mediationsdk.AuctionHistory;
import com.ironsource.mediationsdk.events.RewardedVideoEventsManager;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.model.ProviderSettings;
import com.ironsource.mediationsdk.model.RewardedVideoConfigurations;
import com.ironsource.mediationsdk.utilities.IronsourceMapUtilities;
import com.ironsource.mediationsdk.utils.AuctionSettings;
import com.ironsource.mediationsdk.utils.CappingManager;
import com.ironsource.mediationsdk.utils.ContextProvider;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.SessionCappingManager;
import com.tapjoy.TapjoyAuctionFlags;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class LWSProgRvManager extends BaseProgManager implements LWSRvManagerListener, RvLoadTriggerCallback, AuctionEventListener, IProgRvManager, IRewardedManager, NetworkStateReceiverListener {
    private boolean mAdvancedLoading;
    private String mAuctionFailedReason = "";
    private AuctionHandler mAuctionHandler;
    private AuctionHistory mAuctionHistory;
    private long mAuctionStartTime;
    private int mAuctionTrial;
    private String mCurrentPlacement;
    private AuctionResponseItem mGenericNotifications;
    private JSONObject mGenericParams;
    private boolean mIsAuctionEnabled;
    private boolean mIsShowingVideo;
    private long mLastChangedAvailabilityTime;
    private Boolean mLastReportedAvailabilityState;
    private int mMaxSmashesToLoad;
    private NetworkStateReceiver mNetworkStateReceiver;
    private RvLoadTrigger mRvLoadTrigger;
    private SessionCappingManager mSessionCappingManager;
    private int mSessionDepth = 1;
    private boolean mShouldTrackNetworkState = false;
    private RV_MEDIATION_STATE mState;
    private ConcurrentHashMap<String, AuctionHistory.ISAuctionPerformance> mWaterfallPerformance;
    private ConcurrentHashMap<String, AuctionResponseItem> mWaterfallServerData;
    private final ConcurrentHashMap<String, LWSProgRvSmash> smashes;
    private final Object stateLock = new Object();
    private WaterfallLifeCycleHolder waterfallLifeCycleHolder;

    /* access modifiers changed from: private */
    public enum RV_MEDIATION_STATE {
        RV_STATE_INITIATING,
        RV_STATE_AUCTION_IN_PROGRESS,
        RV_STATE_NOT_LOADED,
        RV_STATE_LOADING_SMASHES,
        RV_STATE_READY_TO_SHOW
    }

    private boolean shouldAddAuctionParams(int i) {
        return i == 1003 || i == 1302 || i == 1301;
    }

    public LWSProgRvManager(List<ProviderSettings> list, RewardedVideoConfigurations rewardedVideoConfigurations, String str, String str2, HashSet<ImpressionDataListener> hashSet) {
        super(hashSet);
        long time = new Date().getTime();
        sendMediationEventWithoutAuctionId(IronSourceConstants.RV_MANAGER_INIT_STARTED);
        setState(RV_MEDIATION_STATE.RV_STATE_INITIATING);
        this.mLastReportedAvailabilityState = null;
        this.mMaxSmashesToLoad = rewardedVideoConfigurations.getRewardedVideoAdaptersSmartLoadAmount();
        this.mAdvancedLoading = rewardedVideoConfigurations.getRewardedVideoAdvancedLoading();
        this.mCurrentPlacement = "";
        this.mGenericParams = null;
        AuctionSettings rewardedVideoAuctionSettings = rewardedVideoConfigurations.getRewardedVideoAuctionSettings();
        this.mIsShowingVideo = false;
        this.waterfallLifeCycleHolder = new WaterfallLifeCycleHolder(rewardedVideoConfigurations.getRewardedVideoAuctionSettings().getLoadWhileShowSupportArray(), rewardedVideoConfigurations.getRewardedVideoAuctionSettings().getTimeToDeleteOldWaterfallAfterAuction());
        this.mWaterfallServerData = new ConcurrentHashMap<>();
        this.mWaterfallPerformance = new ConcurrentHashMap<>();
        this.mLastChangedAvailabilityTime = new Date().getTime();
        boolean z = rewardedVideoAuctionSettings.getNumOfMaxTrials() > 0;
        this.mIsAuctionEnabled = z;
        if (z) {
            this.mAuctionHandler = new AuctionHandler("rewardedVideo", rewardedVideoAuctionSettings, this);
        }
        this.mRvLoadTrigger = new RvLoadTrigger(rewardedVideoAuctionSettings, this);
        this.smashes = new ConcurrentHashMap<>();
        ArrayList arrayList = new ArrayList();
        for (ProviderSettings providerSettings : list) {
            AbstractAdapter adapter = AdapterRepository.getInstance().getAdapter(providerSettings, providerSettings.getRewardedVideoSettings());
            if (adapter != null) {
                LWSProgRvSmash lWSProgRvSmash = new LWSProgRvSmash(str, str2, providerSettings, this, rewardedVideoConfigurations.getRewardedVideoAdaptersSmartLoadTimeout(), adapter, this.mSessionDepth);
                String instanceName = lWSProgRvSmash.getInstanceName();
                this.smashes.put(instanceName, lWSProgRvSmash);
                arrayList.add(instanceName);
            }
        }
        this.mAuctionHistory = new AuctionHistory(arrayList, rewardedVideoAuctionSettings.getAuctionSavedHistoryLimit());
        this.mSessionCappingManager = new SessionCappingManager(new ArrayList(this.smashes.values()));
        sendMediationEventWithoutAuctionId(IronSourceConstants.RV_MANAGER_INIT_ENDED, IronsourceMapUtilities.createMap(new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(new Date().getTime() - time)}}));
        loadRewardedVideo(rewardedVideoAuctionSettings.getTimeToWaitBeforeFirstAuctionMs());
        ExpiredRvAdsManager.getInstance().initialize(this, rewardedVideoConfigurations.getExpiredDurationInMinutes());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x01d4, code lost:
        if (r6 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x01d6, code lost:
        showVideo(r6, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return;
     */
    @Override // com.ironsource.mediationsdk.IProgRvManager
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void showRewardedVideo(com.ironsource.mediationsdk.model.Placement r10) {
        /*
        // Method dump skipped, instructions count: 479
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.LWSProgRvManager.showRewardedVideo(com.ironsource.mediationsdk.model.Placement):void");
    }

    @Override // com.ironsource.mediationsdk.IProgRvManager
    public boolean isRewardedVideoAvailable() {
        if ((!this.mShouldTrackNetworkState || IronSourceUtils.isNetworkConnected(ContextProvider.getInstance().getApplicationContext())) && this.mState == RV_MEDIATION_STATE.RV_STATE_READY_TO_SHOW && !this.mIsShowingVideo) {
            Iterator<LWSProgRvSmash> it = this.waterfallLifeCycleHolder.getCurrentWaterfall().iterator();
            while (it.hasNext()) {
                if (it.next().isReadyToShow()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.ironsource.mediationsdk.LWSRvManagerListener
    public void onLoadSuccess(LWSProgRvSmash lWSProgRvSmash) {
        synchronized (this.stateLock) {
            logInternal(lWSProgRvSmash, "onLoadSuccess mState=" + this.mState);
            if (lWSProgRvSmash.getAuctionId() == this.waterfallLifeCycleHolder.getCurrentWaterfallId()) {
                if (this.mState != RV_MEDIATION_STATE.RV_STATE_AUCTION_IN_PROGRESS) {
                    this.mWaterfallPerformance.put(lWSProgRvSmash.getInstanceName(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceLoadedSuccessfully);
                    if (this.mState == RV_MEDIATION_STATE.RV_STATE_LOADING_SMASHES) {
                        reportAvailabilityIfNeeded(true, null);
                        setState(RV_MEDIATION_STATE.RV_STATE_READY_TO_SHOW);
                        sendMediationEvent(1003, IronsourceMapUtilities.createMap(new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(new Date().getTime() - this.mAuctionStartTime)}}));
                        ExpiredRvAdsManager.getInstance().startExpirationTimerForAds(0);
                        if (this.mIsAuctionEnabled) {
                            AuctionResponseItem auctionResponseItem = this.mWaterfallServerData.get(lWSProgRvSmash.getInstanceName());
                            if (auctionResponseItem != null) {
                                this.mAuctionHandler.reportLoadSuccess(auctionResponseItem, lWSProgRvSmash.getInstanceType(), this.mGenericNotifications);
                                this.mAuctionHandler.reportAuctionLose(this.waterfallLifeCycleHolder.getCurrentWaterfall(), this.mWaterfallServerData, lWSProgRvSmash.getInstanceType(), this.mGenericNotifications, auctionResponseItem);
                            } else {
                                String instanceName = lWSProgRvSmash != null ? lWSProgRvSmash.getInstanceName() : "Smash is null";
                                logErrorInternal("onLoadSuccess winner instance " + instanceName + " missing from waterfall. auctionId: " + lWSProgRvSmash.getAuctionId() + " and the current id is " + this.waterfallLifeCycleHolder.getCurrentWaterfallId());
                                Object[] objArr = {IronSourceConstants.EVENTS_ERROR_CODE, 1010};
                                StringBuilder sb = new StringBuilder();
                                sb.append("Loaded missing ");
                                sb.append(RV_MEDIATION_STATE.RV_STATE_LOADING_SMASHES);
                                sendMediationEvent(IronSourceConstants.TROUBLESHOOTING_RV_NOTIFICATIONS_ERROR, IronsourceMapUtilities.createMap(new Object[][]{objArr, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, sb.toString()}, new Object[]{IronSourceConstants.EVENTS_EXT1, instanceName}}));
                            }
                        }
                    }
                    return;
                }
            }
            logInternal("onLoadSuccess was invoked with auctionId: " + lWSProgRvSmash.getAuctionId() + " and the current id is " + this.waterfallLifeCycleHolder.getCurrentWaterfallId());
            Object[] objArr2 = {IronSourceConstants.EVENTS_ERROR_CODE, 2};
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onLoadSuccess wrong auction ID ");
            sb2.append(this.mState);
            lWSProgRvSmash.sendProviderEvent(IronSourceConstants.RV_MANAGER_UNEXPECTED_STATE, new Object[][]{objArr2, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, sb2.toString()}});
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0122, code lost:
        r11 = r0.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x012a, code lost:
        if (r11.hasNext() == false) goto L_0x0136;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x012c, code lost:
        loadSmash((com.ironsource.mediationsdk.LWSProgRvSmash) r11.next());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0136, code lost:
        return;
     */
    @Override // com.ironsource.mediationsdk.LWSRvManagerListener
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLoadError(com.ironsource.mediationsdk.LWSProgRvSmash r11) {
        /*
        // Method dump skipped, instructions count: 409
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.LWSProgRvManager.onLoadError(com.ironsource.mediationsdk.LWSProgRvSmash):void");
    }

    @Override // com.ironsource.mediationsdk.LWSRvManagerListener
    public void onRewardedVideoAdOpened(LWSProgRvSmash lWSProgRvSmash) {
        this.waterfallLifeCycleHolder.setShowingSmash(lWSProgRvSmash);
        this.mSessionDepth++;
        logInternal(lWSProgRvSmash, "onRewardedVideoAdOpened");
        RVListenerWrapper.getInstance().onRewardedVideoAdOpened();
        if (this.mIsAuctionEnabled) {
            AuctionResponseItem auctionResponseItem = this.mWaterfallServerData.get(lWSProgRvSmash.getInstanceName());
            if (auctionResponseItem != null) {
                this.mAuctionHandler.reportImpression(auctionResponseItem, lWSProgRvSmash.getInstanceType(), this.mGenericNotifications, this.mCurrentPlacement);
                this.mWaterfallPerformance.put(lWSProgRvSmash.getInstanceName(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceShowedSuccessfully);
                reportImpressionDataToPublisher(auctionResponseItem, this.mCurrentPlacement);
            } else {
                String instanceName = lWSProgRvSmash != null ? lWSProgRvSmash.getInstanceName() : "Smash is null";
                logErrorInternal("onRewardedVideoAdOpened showing instance " + instanceName + " missing from waterfall");
                sendMediationEvent(IronSourceConstants.TROUBLESHOOTING_RV_NOTIFICATIONS_ERROR, IronsourceMapUtilities.createMap(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1011}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "Showing missing " + this.mState}, new Object[]{IronSourceConstants.EVENTS_EXT1, instanceName}}));
            }
        }
        this.mRvLoadTrigger.showStart();
    }

    @Override // com.ironsource.mediationsdk.LWSRvManagerListener
    public void onRewardedVideoAdShowFailed(IronSourceError ironSourceError, LWSProgRvSmash lWSProgRvSmash) {
        logInternal(lWSProgRvSmash, "onRewardedVideoAdShowFailed error=" + ironSourceError.getErrorMessage());
        this.mIsShowingVideo = false;
        sendMediationEventWithPlacement(IronSourceConstants.RV_CALLBACK_SHOW_FAILED, IronsourceMapUtilities.createMap(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}}));
        RVListenerWrapper.getInstance().onRewardedVideoAdShowFailed(ironSourceError);
        this.mWaterfallPerformance.put(lWSProgRvSmash.getInstanceName(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceFailedToShow);
        if (this.mState != RV_MEDIATION_STATE.RV_STATE_READY_TO_SHOW) {
            reportAvailabilityIfNeeded(false, null);
        }
        this.mRvLoadTrigger.showError();
    }

    @Override // com.ironsource.mediationsdk.LWSRvManagerListener
    public void onRewardedVideoAdClosed(LWSProgRvSmash lWSProgRvSmash) {
        String str;
        logInternal(lWSProgRvSmash, "onRewardedVideoAdClosed, mediation state: " + this.mState.name());
        RVListenerWrapper.getInstance().onRewardedVideoAdClosed();
        this.mIsShowingVideo = false;
        boolean z = this.mState == RV_MEDIATION_STATE.RV_STATE_READY_TO_SHOW;
        StringBuilder sb = new StringBuilder();
        if (z) {
            Iterator<LWSProgRvSmash> it = this.waterfallLifeCycleHolder.getCurrentWaterfall().iterator();
            while (it.hasNext()) {
                LWSProgRvSmash next = it.next();
                if (next.isLoaded()) {
                    sb.append(next.getInstanceName() + ";");
                }
            }
        }
        Object[][] objArr = new Object[1][];
        Object[] objArr2 = new Object[2];
        objArr2[0] = IronSourceConstants.EVENTS_EXT1;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("otherRVAvailable = ");
        if (sb.length() > 0) {
            str = "true|" + ((Object) sb);
        } else {
            str = "false";
        }
        sb2.append(str);
        objArr2[1] = sb2.toString();
        objArr[0] = objArr2;
        lWSProgRvSmash.sendProviderEventWithPlacement(IronSourceConstants.RV_INSTANCE_CLOSED, objArr);
        if (lWSProgRvSmash.equals(this.waterfallLifeCycleHolder.getShowingSmash())) {
            this.waterfallLifeCycleHolder.setShowingSmash(null);
            if (this.mState != RV_MEDIATION_STATE.RV_STATE_READY_TO_SHOW) {
                reportAvailabilityIfNeeded(false, null);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.LWSRvManagerListener
    public void onRewardedVideoAdStarted(LWSProgRvSmash lWSProgRvSmash) {
        logInternal(lWSProgRvSmash, "onRewardedVideoAdStarted");
        RVListenerWrapper.getInstance().onRewardedVideoAdStarted();
    }

    @Override // com.ironsource.mediationsdk.LWSRvManagerListener
    public void onRewardedVideoAdEnded(LWSProgRvSmash lWSProgRvSmash) {
        logInternal(lWSProgRvSmash, "onRewardedVideoAdEnded");
        RVListenerWrapper.getInstance().onRewardedVideoAdEnded();
    }

    @Override // com.ironsource.mediationsdk.LWSRvManagerListener
    public void onRewardedVideoAdRewarded(LWSProgRvSmash lWSProgRvSmash, Placement placement) {
        logInternal(lWSProgRvSmash, "onRewardedVideoAdRewarded");
        RVListenerWrapper.getInstance().onRewardedVideoAdRewarded(placement);
    }

    @Override // com.ironsource.mediationsdk.LWSRvManagerListener
    public void onRewardedVideoAdClicked(LWSProgRvSmash lWSProgRvSmash, Placement placement) {
        logInternal(lWSProgRvSmash, "onRewardedVideoAdClicked");
        RVListenerWrapper.getInstance().onRewardedVideoAdClicked(placement);
    }

    @Override // com.ironsource.mediationsdk.AuctionEventListener
    public void onAuctionSuccess(List<AuctionResponseItem> list, String str, AuctionResponseItem auctionResponseItem, JSONObject jSONObject, int i, long j) {
        logInternal("makeAuction(): success");
        this.mGenericNotifications = auctionResponseItem;
        this.mAuctionTrial = i;
        this.mGenericParams = jSONObject;
        this.mAuctionFailedReason = "";
        updateWaterfall(list, str, jSONObject);
        sendMediationEvent(IronSourceConstants.RV_AUCTION_SUCCESS, IronsourceMapUtilities.createMap(new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j)}}));
        loadSmashes();
    }

    @Override // com.ironsource.mediationsdk.AuctionEventListener
    public void onAuctionFailed(int i, String str, int i2, String str2, long j) {
        String str3 = "Auction failed | moving to fallback waterfall (error " + i + " - " + str + ")";
        logInternal(str3);
        IronSourceUtils.sendAutomationLog("RV: " + str3);
        this.mAuctionTrial = i2;
        this.mAuctionFailedReason = str2;
        this.mGenericParams = null;
        updateWaterfallToNonBidding();
        if (TextUtils.isEmpty(str)) {
            sendMediationEvent(IronSourceConstants.RV_AUCTION_FAILED, IronsourceMapUtilities.createMap(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i)}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j)}}));
        } else {
            sendMediationEvent(IronSourceConstants.RV_AUCTION_FAILED, IronsourceMapUtilities.createMap(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, str}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j)}}));
        }
        loadSmashes();
    }

    @Override // com.ironsource.mediationsdk.RvLoadTriggerCallback
    public void onLoadTriggered() {
        logInternal("onLoadTriggered: RV load was triggered in " + this.mState + " state");
        loadRewardedVideo(0);
    }

    private void loadRewardedVideo(long j) {
        if (this.mSessionCappingManager.areAllSmashesCapped()) {
            logInternal("all smashes are capped");
            sendMediationEvent(IronSourceConstants.TROUBLESHOOTING_RV_LOAD_FAILED, IronsourceMapUtilities.createMap(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 80001}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "all smashes are capped"}}));
            handleLoadFailure();
        } else if (this.mIsAuctionEnabled) {
            if (!this.mWaterfallPerformance.isEmpty()) {
                this.mAuctionHistory.storeWaterfallPerformance(this.mWaterfallPerformance);
                this.mWaterfallPerformance.clear();
            }
            new Timer().schedule(new TimerTask() {
                /* class com.ironsource.mediationsdk.LWSProgRvManager.AnonymousClass1 */

                public void run() {
                    LWSProgRvManager.this.makeAuction();
                }
            }, j);
        } else {
            logInternal("auction fallback flow starting");
            updateWaterfallToNonBidding();
            if (this.waterfallLifeCycleHolder.getCurrentWaterfall().isEmpty()) {
                logInternal("loadSmashes -  waterfall is empty");
                sendMediationEvent(IronSourceConstants.TROUBLESHOOTING_RV_LOAD_FAILED, IronsourceMapUtilities.createMap(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 80004}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "waterfall is empty"}}));
                handleLoadFailure();
                return;
            }
            sendMediationEventWithoutAuctionId(1000);
            loadSmashes();
        }
    }

    private void showVideo(LWSProgRvSmash lWSProgRvSmash, Placement placement) {
        logInternal("showVideo()");
        this.mSessionCappingManager.increaseShowCounter(lWSProgRvSmash);
        if (this.mSessionCappingManager.isCapped(lWSProgRvSmash)) {
            lWSProgRvSmash.setCappedPerSession();
            IronSourceUtils.sendAutomationLog(lWSProgRvSmash.getInstanceName() + " rewarded video is now session capped");
        }
        CappingManager.incrementRvShowCounter(ContextProvider.getInstance().getApplicationContext(), placement.getPlacementName());
        if (CappingManager.isRvPlacementCapped(ContextProvider.getInstance().getApplicationContext(), placement.getPlacementName())) {
            sendMediationEventWithPlacement(IronSourceConstants.RV_CAP_PLACEMENT);
        }
        ExpiredRvAdsManager.getInstance().cancelExpirationScheduler();
        lWSProgRvSmash.showVideo(placement);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void makeAuction() {
        synchronized (this.stateLock) {
            if (this.mState != RV_MEDIATION_STATE.RV_STATE_AUCTION_IN_PROGRESS) {
                setState(RV_MEDIATION_STATE.RV_STATE_AUCTION_IN_PROGRESS);
                AsyncTask.execute(new Runnable() {
                    /* class com.ironsource.mediationsdk.LWSProgRvManager.AnonymousClass2 */

                    public void run() {
                        LWSProgRvManager.this.logInternal("makeAuction()");
                        LWSProgRvManager.this.mAuctionStartTime = new Date().getTime();
                        HashMap hashMap = new HashMap();
                        ArrayList arrayList = new ArrayList();
                        StringBuilder sb = new StringBuilder();
                        for (LWSProgRvSmash lWSProgRvSmash : LWSProgRvManager.this.smashes.values()) {
                            if (!LWSProgRvManager.this.mSessionCappingManager.isCapped(lWSProgRvSmash) && LWSProgRvManager.this.waterfallLifeCycleHolder.shouldAddSmashToWaterfallRequest(lWSProgRvSmash)) {
                                if (lWSProgRvSmash.isBidder()) {
                                    Map<String, Object> biddingData = lWSProgRvSmash.getBiddingData();
                                    if (biddingData != null) {
                                        hashMap.put(lWSProgRvSmash.getInstanceName(), biddingData);
                                        sb.append(lWSProgRvSmash.getInstanceType() + lWSProgRvSmash.getInstanceName() + ",");
                                    }
                                } else {
                                    arrayList.add(lWSProgRvSmash.getInstanceName());
                                    sb.append(lWSProgRvSmash.getInstanceType() + lWSProgRvSmash.getInstanceName() + ",");
                                }
                            }
                        }
                        if (hashMap.keySet().size() == 0 && arrayList.size() == 0) {
                            LWSProgRvManager.this.sendMediationEvent(IronSourceConstants.RV_AUCTION_FAILED, IronsourceMapUtilities.createMap(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1005}, new Object[]{IronSourceConstants.EVENTS_DURATION, 0}}));
                            LWSProgRvManager.this.logInternal("makeAuction() failed - No candidates available for auctioning");
                            LWSProgRvManager.this.handleLoadFailure();
                            return;
                        }
                        LWSProgRvManager lWSProgRvManager = LWSProgRvManager.this;
                        lWSProgRvManager.logInternal("makeAuction() - request waterfall is: " + ((Object) sb));
                        LWSProgRvManager.this.sendMediationEventWithoutAuctionId(1000);
                        LWSProgRvManager.this.sendMediationEventWithoutAuctionId(IronSourceConstants.RV_AUCTION_REQUEST);
                        LWSProgRvManager.this.sendMediationEventWithoutAuctionId(IronSourceConstants.RV_AUCTION_REQUEST_WATERFALL, IronsourceMapUtilities.createMap(new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, sb.toString()}}));
                        LWSProgRvManager.this.mAuctionHandler.executeAuction(ContextProvider.getInstance().getApplicationContext(), hashMap, arrayList, LWSProgRvManager.this.mAuctionHistory, LWSProgRvManager.this.mSessionDepth);
                    }
                });
            }
        }
    }

    private void updateWaterfallToNonBidding() {
        List<AuctionResponseItem> extractNonBidderProvidersFromWaterfall = extractNonBidderProvidersFromWaterfall();
        updateWaterfall(extractNonBidderProvidersFromWaterfall, "fallback_" + System.currentTimeMillis(), this.mGenericParams);
    }

    private List<AuctionResponseItem> extractNonBidderProvidersFromWaterfall() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (LWSProgRvSmash lWSProgRvSmash : this.smashes.values()) {
            if (!lWSProgRvSmash.isBidder() && !this.mSessionCappingManager.isCapped(lWSProgRvSmash) && this.waterfallLifeCycleHolder.shouldAddSmashToWaterfallRequest(lWSProgRvSmash)) {
                copyOnWriteArrayList.add(new AuctionResponseItem(lWSProgRvSmash.getInstanceName()));
            }
        }
        return copyOnWriteArrayList;
    }

    private void updateWaterfall(List<AuctionResponseItem> list, String str, JSONObject jSONObject) {
        this.mWaterfallServerData.clear();
        this.mWaterfallPerformance.clear();
        CopyOnWriteArrayList<LWSProgRvSmash> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (AuctionResponseItem auctionResponseItem : list) {
            sb.append(getAuctionResponseItemAsStringForReporting(auctionResponseItem) + ",");
            LWSProgRvSmash lWSProgRvSmash = this.smashes.get(auctionResponseItem.getInstanceName());
            if (lWSProgRvSmash != null) {
                AbstractAdapter createAdapter = AdapterRepository.getInstance().createAdapter(lWSProgRvSmash.mAdapterConfig.getProviderSettings());
                if (createAdapter != null) {
                    LWSProgRvSmash lWSProgRvSmash2 = new LWSProgRvSmash(lWSProgRvSmash, this, createAdapter, this.mSessionDepth, str, jSONObject, this.mAuctionTrial, this.mAuctionFailedReason);
                    lWSProgRvSmash2.setIsLoadCandidate(true);
                    copyOnWriteArrayList.add(lWSProgRvSmash2);
                    this.mWaterfallServerData.put(lWSProgRvSmash2.getInstanceName(), auctionResponseItem);
                    this.mWaterfallPerformance.put(auctionResponseItem.getInstanceName(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceDidntAttemptToLoad);
                }
            } else {
                logInternal("updateWaterfall() - could not find matching smash for auction response item " + auctionResponseItem.getInstanceName());
            }
        }
        this.waterfallLifeCycleHolder.updateWaterFall(copyOnWriteArrayList, str);
        if (this.waterfallLifeCycleHolder.areWaterFallsOverMaximum()) {
            sendMediationEvent(IronSourceConstants.TROUBLESHOOTING_RV_WATERFALL_OVERHEAD, IronsourceMapUtilities.createMap(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "waterfalls hold too many with size=" + this.waterfallLifeCycleHolder.getNumberOfWaterfalls()}}));
        }
        String str2 = "updateWaterfall() - next waterfall is " + sb.toString();
        logInternal(str2);
        IronSourceUtils.sendAutomationLog("RV: " + str2);
        if (sb.length() == 0) {
            logInternal("Updated waterfall is empty");
        }
        sendMediationEvent(IronSourceConstants.RV_AUCTION_RESPONSE_WATERFALL, IronsourceMapUtilities.createMap(new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, sb.toString()}}));
    }

    private String getAuctionResponseItemAsStringForReporting(AuctionResponseItem auctionResponseItem) {
        String str;
        LWSProgRvSmash lWSProgRvSmash = this.smashes.get(auctionResponseItem.getInstanceName());
        if (lWSProgRvSmash != null) {
            str = Integer.toString(lWSProgRvSmash.getInstanceType());
        } else {
            str = TextUtils.isEmpty(auctionResponseItem.getServerData()) ? "1" : TapjoyAuctionFlags.AUCTION_TYPE_SECOND_PRICE;
        }
        return str + auctionResponseItem.getInstanceName();
    }

    private void loadSmashes() {
        if (this.waterfallLifeCycleHolder.getCurrentWaterfall().isEmpty()) {
            logInternal("loadSmashes -  waterfall is empty");
            sendMediationEvent(IronSourceConstants.TROUBLESHOOTING_RV_LOAD_FAILED, IronsourceMapUtilities.createMap(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 80004}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "waterfall is empty"}}));
            handleLoadFailure();
            return;
        }
        setState(RV_MEDIATION_STATE.RV_STATE_LOADING_SMASHES);
        int i = 0;
        for (int i2 = 0; i2 < this.waterfallLifeCycleHolder.getCurrentWaterfall().size() && i < this.mMaxSmashesToLoad; i2++) {
            LWSProgRvSmash lWSProgRvSmash = this.waterfallLifeCycleHolder.getCurrentWaterfall().get(i2);
            if (lWSProgRvSmash.getIsLoadCandidate()) {
                if (!this.mAdvancedLoading || !lWSProgRvSmash.isBidder()) {
                    loadSmash(lWSProgRvSmash);
                    i++;
                } else if (i == 0) {
                    String str = "Advanced Loading: Starting to load bidder " + lWSProgRvSmash.getInstanceName() + ". No other instances will be loaded at the same time.";
                    logInternal(str);
                    IronSourceUtils.sendAutomationLog(str);
                    loadSmash(lWSProgRvSmash);
                    return;
                } else {
                    String str2 = "Advanced Loading: Won't start loading bidder " + lWSProgRvSmash.getInstanceName() + " as a non bidder is being loaded";
                    logInternal(str2);
                    IronSourceUtils.sendAutomationLog(str2);
                    return;
                }
            }
        }
    }

    private void loadSmash(LWSProgRvSmash lWSProgRvSmash) {
        String serverData = this.mWaterfallServerData.get(lWSProgRvSmash.getInstanceName()).getServerData();
        lWSProgRvSmash.setDynamicDemandSourceIdByServerData(serverData);
        lWSProgRvSmash.loadVideo(serverData);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void handleLoadFailure() {
        setState(RV_MEDIATION_STATE.RV_STATE_NOT_LOADED);
        if (!this.mIsShowingVideo) {
            reportAvailabilityIfNeeded(false, null);
        }
        this.mRvLoadTrigger.loadError();
    }

    private void setState(RV_MEDIATION_STATE rv_mediation_state) {
        logInternal("current state=" + this.mState + ", new state=" + rv_mediation_state);
        this.mState = rv_mediation_state;
    }

    private void reportAvailabilityIfNeeded(boolean z, Map<String, Object> map) {
        synchronized (this.stateLock) {
            if (this.mLastReportedAvailabilityState == null || this.mLastReportedAvailabilityState.booleanValue() != z) {
                this.mLastReportedAvailabilityState = Boolean.valueOf(z);
                long time = new Date().getTime() - this.mLastChangedAvailabilityTime;
                this.mLastChangedAvailabilityTime = new Date().getTime();
                if (map == null) {
                    map = new HashMap<>();
                }
                map.put(IronSourceConstants.EVENTS_DURATION, Long.valueOf(time));
                sendMediationEvent(z ? IronSourceConstants.RV_CALLBACK_AVAILABILITY_TRUE : IronSourceConstants.RV_CALLBACK_AVAILABILITY_FALSE, map);
                RVListenerWrapper.getInstance().onRewardedVideoAvailabilityChanged(z);
            }
        }
    }

    private void logInternal(LWSProgRvSmash lWSProgRvSmash, String str) {
        String str2 = lWSProgRvSmash.getInstanceName() + " : " + str;
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "LWSProgRvManager: " + str2, 0);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void logInternal(String str) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "LWSProgRvManager: " + str, 0);
    }

    private void logErrorInternal(String str) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "LWSProgRvManager: " + str, 3);
    }

    private void logAPIError(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, str, 3);
    }

    private void logApi(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, str, 1);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void sendMediationEventWithoutAuctionId(int i, Map<String, Object> map) {
        sendMediationEvent(i, map, false, false);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void sendMediationEventWithoutAuctionId(int i) {
        sendMediationEvent(i, null, false, false);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void sendMediationEvent(int i, Map<String, Object> map) {
        sendMediationEvent(i, map, false, true);
    }

    private void sendMediationEventWithPlacement(int i) {
        sendMediationEvent(i, null, true, true);
    }

    private void sendMediationEventWithPlacement(int i, Map<String, Object> map) {
        sendMediationEvent(i, map, true, true);
    }

    private void sendMediationEvent(int i, Map<String, Object> map, boolean z, boolean z2) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
        hashMap.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 2);
        if (z2 && !TextUtils.isEmpty(this.waterfallLifeCycleHolder.getCurrentWaterfallId())) {
            hashMap.put("auctionId", this.waterfallLifeCycleHolder.getCurrentWaterfallId());
        }
        JSONObject jSONObject = this.mGenericParams;
        if (jSONObject != null && jSONObject.length() > 0) {
            hashMap.put("genericParams", this.mGenericParams);
        }
        if (z && !TextUtils.isEmpty(this.mCurrentPlacement)) {
            hashMap.put(IronSourceConstants.EVENTS_PLACEMENT_NAME, this.mCurrentPlacement);
        }
        if (shouldAddAuctionParams(i)) {
            RewardedVideoEventsManager.getInstance().setEventAuctionParams(hashMap, this.mAuctionTrial, this.mAuctionFailedReason);
        }
        hashMap.put("sessionDepth", Integer.valueOf(this.mSessionDepth));
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    hashMap.putAll(map);
                }
            } catch (Exception e) {
                IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
                logger.log(ironSourceTag, "LWSProgRvManager: RV sendMediationEvent " + Log.getStackTraceString(e), 3);
            }
        }
        RewardedVideoEventsManager.getInstance().log(new EventData(i, new JSONObject(hashMap)));
    }

    @Override // com.ironsource.environment.NetworkStateReceiverListener
    public void onNetworkAvailabilityChanged(boolean z) {
        if (this.mShouldTrackNetworkState) {
            IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            logger.log(ironSourceTag, "Network Availability Changed To: " + z, 1);
            if (shouldNotifyNetworkAvailabilityChanged(z)) {
                reportAvailabilityIfNeeded(z, null);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.IProgRvManager
    public void shouldTrackNetworkState(Context context, boolean z) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "LWSProgRvManager Should Track Network State: " + z, 0);
        this.mShouldTrackNetworkState = z;
        if (z) {
            if (this.mNetworkStateReceiver == null) {
                this.mNetworkStateReceiver = new NetworkStateReceiver(context, this);
            }
            context.getApplicationContext().registerReceiver(this.mNetworkStateReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } else if (this.mNetworkStateReceiver != null) {
            context.getApplicationContext().unregisterReceiver(this.mNetworkStateReceiver);
        }
    }

    private boolean shouldNotifyNetworkAvailabilityChanged(boolean z) {
        Boolean bool = this.mLastReportedAvailabilityState;
        if (bool == null) {
            return false;
        }
        if ((!z || bool.booleanValue() || !isRewardedVideoAvailable()) && (z || !this.mLastReportedAvailabilityState.booleanValue())) {
            return false;
        }
        return true;
    }

    @Override // com.ironsource.mediationsdk.IRewardedManager
    public void reloadRewardedVideos() {
        setState(RV_MEDIATION_STATE.RV_STATE_NOT_LOADED);
        reportAvailabilityIfNeeded(false, IronsourceMapUtilities.createMap(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf((int) IronSourceError.ERROR_RV_EXPIRED_ADS)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "loaded ads are expired"}}));
        loadRewardedVideo(0);
    }
}
