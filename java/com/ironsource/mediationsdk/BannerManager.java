package com.ironsource.mediationsdk;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.anythink.reactnativejs.utils.Const;
import com.ironsource.eventsmodule.EventData;
import com.ironsource.mediationsdk.events.InterstitialEventsManager;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.BannerPlacement;
import com.ironsource.mediationsdk.model.ProviderSettings;
import com.ironsource.mediationsdk.sdk.BannerManagerListener;
import com.ironsource.mediationsdk.utils.CappingManager;
import com.ironsource.mediationsdk.utils.ContextProvider;
import com.ironsource.mediationsdk.utils.DurationMeasurement;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.SessionDepthManager;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class BannerManager implements BannerManagerListener {
    private BannerSmash mActiveSmash;
    private String mAppKey;
    private BannerPlacement mCurrentPlacement;
    AtomicBoolean mDidImplementOnPause = new AtomicBoolean();
    AtomicBoolean mDidImplementOnResume = new AtomicBoolean();
    private DurationMeasurement mInstanceLoadDuration;
    private IronSourceBannerLayout mIronsourceBanner;
    private Boolean mIsInForeground = true;
    private DurationMeasurement mLoadDuration;
    private int mLoadingBannerSessionDepth;
    private IronSourceLoggerManager mLoggerManager = IronSourceLoggerManager.getLogger();
    private int mPresentedBannerSessionDepth;
    private long mReloadInterval;
    private Timer mReloadTimer;
    private final CopyOnWriteArrayList<BannerSmash> mSmashArray = new CopyOnWriteArrayList<>();
    private BANNER_STATE mState = BANNER_STATE.NOT_INITIATED;
    private String mUserId;

    /* access modifiers changed from: private */
    public enum BANNER_STATE {
        NOT_INITIATED,
        READY_TO_LOAD,
        FIRST_LOAD_IN_PROGRESS,
        LOAD_IN_PROGRESS,
        RELOAD_IN_PROGRESS
    }

    public BannerManager(List<ProviderSettings> list, String str, String str2, long j, int i, int i2) {
        this.mAppKey = str;
        this.mUserId = str2;
        this.mReloadInterval = (long) i;
        BannerCallbackThrottler.getInstance().setDelayLoadFailureNotificationInSeconds(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            ProviderSettings providerSettings = list.get(i3);
            AbstractAdapter adapter = AdapterRepository.getInstance().getAdapter(providerSettings, providerSettings.getBannerSettings());
            if (adapter == null || !AdaptersCompatibilityHandler.getInstance().isBannerAdapterCompatible(adapter)) {
                debugLog(providerSettings.getProviderInstanceName() + " can't load adapter or wrong version");
            } else {
                this.mSmashArray.add(new BannerSmash(this, providerSettings, adapter, j, i3 + 1));
            }
        }
        this.mCurrentPlacement = null;
        setState(BANNER_STATE.READY_TO_LOAD);
    }

    public synchronized void loadBanner(IronSourceBannerLayout ironSourceBannerLayout, BannerPlacement bannerPlacement) {
        if (ironSourceBannerLayout != null) {
            try {
                if (!ironSourceBannerLayout.isDestroyed()) {
                    if (bannerPlacement != null) {
                        if (!TextUtils.isEmpty(bannerPlacement.getPlacementName())) {
                            if (this.mState == BANNER_STATE.READY_TO_LOAD) {
                                if (!BannerCallbackThrottler.getInstance().hasPendingInvocation()) {
                                    this.mLoadingBannerSessionDepth = SessionDepthManager.getInstance().getSessionDepth(3);
                                    setState(BANNER_STATE.FIRST_LOAD_IN_PROGRESS);
                                    this.mIronsourceBanner = ironSourceBannerLayout;
                                    this.mCurrentPlacement = bannerPlacement;
                                    sendMediationEvent(3001);
                                    if (CappingManager.isBnPlacementCapped(ContextProvider.getInstance().getCurrentActiveActivity(), bannerPlacement.getPlacementName())) {
                                        BannerCallbackThrottler instance = BannerCallbackThrottler.getInstance();
                                        instance.sendBannerAdLoadFailed(ironSourceBannerLayout, new IronSourceError(IronSourceError.ERROR_BN_LOAD_PLACEMENT_CAPPED, "placement " + bannerPlacement.getPlacementName() + " is capped"));
                                        sendMediationEvent(IronSourceConstants.BN_CALLBACK_LOAD_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf((int) IronSourceError.ERROR_BN_LOAD_PLACEMENT_CAPPED)}});
                                        setState(BANNER_STATE.READY_TO_LOAD);
                                        return;
                                    }
                                    this.mLoadDuration = new DurationMeasurement();
                                    Iterator<BannerSmash> it = this.mSmashArray.iterator();
                                    while (it.hasNext()) {
                                        it.next().setReadyToLoad(true);
                                    }
                                    this.mInstanceLoadDuration = new DurationMeasurement();
                                    BannerSmash bannerSmash = this.mSmashArray.get(0);
                                    sendProviderEvent(3002, bannerSmash);
                                    bannerSmash.loadBanner(ironSourceBannerLayout, this.mAppKey, this.mUserId);
                                    return;
                                }
                            }
                            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "A banner is already loaded", 3);
                            return;
                        }
                    }
                    Object[] objArr = new Object[1];
                    objArr[0] = bannerPlacement == null ? "placement is null" : "placement name is empty";
                    this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, String.format("can't load banner - %s", objArr), 3);
                    return;
                }
            } catch (Exception e) {
                BannerCallbackThrottler instance2 = BannerCallbackThrottler.getInstance();
                instance2.sendBannerAdLoadFailed(ironSourceBannerLayout, new IronSourceError(IronSourceError.ERROR_BN_LOAD_EXCEPTION, "loadBanner() failed " + e.getMessage()));
                sendMediationEvent(IronSourceConstants.BN_CALLBACK_LOAD_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf((int) IronSourceError.ERROR_BN_LOAD_EXCEPTION)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, e.getMessage()}});
                setState(BANNER_STATE.READY_TO_LOAD);
            }
        }
        Object[] objArr2 = new Object[1];
        objArr2[0] = ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed";
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, String.format("can't load banner - %s", objArr2), 3);
        return;
    }

    public synchronized void destroyBanner(IronSourceBannerLayout ironSourceBannerLayout) {
        if (ironSourceBannerLayout == null) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "destroyBanner banner cannot be null", 3);
        } else if (ironSourceBannerLayout.isDestroyed()) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Banner is already destroyed and can't be used anymore. Please create a new one using IronSource.createBanner API", 3);
        } else {
            sendMediationEvent(IronSourceConstants.BN_DESTROY, null, this.mPresentedBannerSessionDepth);
            stopReloadTimer();
            if (this.mActiveSmash != null) {
                sendProviderEvent(IronSourceConstants.BN_INSTANCE_DESTROY, this.mActiveSmash);
                this.mActiveSmash.destroyBanner();
                this.mActiveSmash = null;
            }
            ironSourceBannerLayout.destroyBanner();
            this.mIronsourceBanner = null;
            this.mCurrentPlacement = null;
            setState(BANNER_STATE.READY_TO_LOAD);
        }
    }

    private void errorLog(String str) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        ironSourceLoggerManager.log(ironSourceTag, "BannerManager " + str, 3);
    }

    private void debugLog(String str) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        ironSourceLoggerManager.log(ironSourceTag, "BannerManager " + str, 0);
    }

    private void setState(BANNER_STATE banner_state) {
        this.mState = banner_state;
        debugLog("state=" + banner_state.name());
    }

    private void bindView(BannerSmash bannerSmash, View view, FrameLayout.LayoutParams layoutParams) {
        this.mActiveSmash = bannerSmash;
        this.mIronsourceBanner.addViewWithFrameLayoutParams(view, layoutParams);
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerManagerListener
    public void onBannerAdLoaded(BannerSmash bannerSmash, View view, FrameLayout.LayoutParams layoutParams) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.info("smash - " + bannerSmash.getName());
        if (this.mState == BANNER_STATE.FIRST_LOAD_IN_PROGRESS) {
            sendProviderEvent(3005, bannerSmash, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(DurationMeasurement.getMeasuredDuration(this.mInstanceLoadDuration))}});
            bindView(bannerSmash, view, layoutParams);
            BannerPlacement bannerPlacement = this.mCurrentPlacement;
            String placementName = bannerPlacement != null ? bannerPlacement.getPlacementName() : "";
            CappingManager.incrementBnShowCounter(ContextProvider.getInstance().getCurrentActiveActivity(), placementName);
            if (CappingManager.isBnPlacementCapped(ContextProvider.getInstance().getCurrentActiveActivity(), placementName)) {
                sendMediationEvent(IronSourceConstants.BN_PLACEMENT_CAPPED);
            }
            sendMediationEvent(IronSourceConstants.BN_CALLBACK_LOAD_SUCCESS, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(DurationMeasurement.getMeasuredDuration(this.mLoadDuration))}});
            this.mIronsourceBanner.sendBannerAdLoaded(bannerSmash.getName());
            this.mPresentedBannerSessionDepth = SessionDepthManager.getInstance().getSessionDepth(3);
            SessionDepthManager.getInstance().increaseSessionDepth(3);
            setState(BANNER_STATE.RELOAD_IN_PROGRESS);
            startReloadTimer();
        } else if (this.mState == BANNER_STATE.LOAD_IN_PROGRESS) {
            setState(BANNER_STATE.RELOAD_IN_PROGRESS);
            onBannerReloadSuccess(bannerSmash, view, layoutParams, true);
        } else {
            sendProviderEvent(IronSourceConstants.BN_INSTANCE_UNEXPECTED_LOAD_SUCCESS, bannerSmash);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerManagerListener
    public void onBannerAdLoadFailed(IronSourceError ironSourceError, BannerSmash bannerSmash, boolean z) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.info("error = " + ironSourceError.getErrorMessage() + " smash - " + bannerSmash.getName());
        if (this.mState == BANNER_STATE.FIRST_LOAD_IN_PROGRESS || this.mState == BANNER_STATE.LOAD_IN_PROGRESS) {
            if (z) {
                sendProviderEvent(IronSourceConstants.BN_INSTANCE_LOAD_NO_FILL, bannerSmash, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(DurationMeasurement.getMeasuredDuration(this.mInstanceLoadDuration))}});
            } else {
                sendProviderEvent(IronSourceConstants.BN_INSTANCE_LOAD_ERROR, bannerSmash, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(DurationMeasurement.getMeasuredDuration(this.mInstanceLoadDuration))}});
            }
            if (!loadNextSmash()) {
                if (this.mState == BANNER_STATE.FIRST_LOAD_IN_PROGRESS) {
                    BannerCallbackThrottler.getInstance().sendBannerAdLoadFailed(this.mIronsourceBanner, new IronSourceError(IronSourceError.ERROR_BN_LOAD_NO_FILL, "No ads to show"));
                    sendMediationEvent(IronSourceConstants.BN_CALLBACK_LOAD_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf((int) IronSourceError.ERROR_BN_LOAD_NO_FILL)}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(DurationMeasurement.getMeasuredDuration(this.mLoadDuration))}});
                    setState(BANNER_STATE.READY_TO_LOAD);
                    return;
                }
                sendMediationEvent(IronSourceConstants.BN_RELOAD_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(DurationMeasurement.getMeasuredDuration(this.mLoadDuration))}});
                setState(BANNER_STATE.RELOAD_IN_PROGRESS);
                startReloadTimer();
                return;
            }
            return;
        }
        debugLog("onBannerAdLoadFailed " + bannerSmash.getName() + " wrong state=" + this.mState.name());
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerManagerListener
    public void onBannerAdReloaded(BannerSmash bannerSmash, View view, FrameLayout.LayoutParams layoutParams, boolean z) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.info("smash - " + bannerSmash.getName());
        if (this.mState != BANNER_STATE.RELOAD_IN_PROGRESS) {
            debugLog("onBannerAdReloaded " + bannerSmash.getName() + " wrong state=" + this.mState.name());
            sendProviderEvent(IronSourceConstants.BN_INSTANCE_UNEXPECTED_RELOAD_SUCCESS, bannerSmash);
            return;
        }
        IronSourceUtils.sendAutomationLog("bannerReloadSucceeded");
        onBannerReloadSuccess(bannerSmash, view, layoutParams, z);
    }

    private void onBannerReloadSuccess(BannerSmash bannerSmash, View view, FrameLayout.LayoutParams layoutParams, boolean z) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.info("bindView = " + z + " smash - " + bannerSmash.getName());
        sendProviderEvent(IronSourceConstants.BN_INSTANCE_RELOAD_SUCCESS, bannerSmash, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(DurationMeasurement.getMeasuredDuration(this.mInstanceLoadDuration))}});
        sendMediationEvent(IronSourceConstants.BN_CALLBACK_RELOAD_SUCCESS, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(DurationMeasurement.getMeasuredDuration(this.mLoadDuration))}});
        this.mPresentedBannerSessionDepth = SessionDepthManager.getInstance().getSessionDepth(3);
        SessionDepthManager.getInstance().increaseSessionDepth(3);
        if (z) {
            bindView(bannerSmash, view, layoutParams);
        }
        startReloadTimer();
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerManagerListener
    public void onBannerAdReloadFailed(IronSourceError ironSourceError, BannerSmash bannerSmash, boolean z) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.info("error = " + ironSourceError.getErrorMessage() + " smash - " + bannerSmash.getName());
        if (this.mState != BANNER_STATE.RELOAD_IN_PROGRESS) {
            debugLog("onBannerAdReloadFailed " + bannerSmash.getName() + " wrong state=" + this.mState.name());
            return;
        }
        if (z) {
            sendProviderEvent(IronSourceConstants.BN_INSTANCE_RELOAD_NO_FILL, bannerSmash, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(DurationMeasurement.getMeasuredDuration(this.mInstanceLoadDuration))}});
        } else {
            sendProviderEvent(IronSourceConstants.BN_INSTANCE_RELOAD_ERROR, bannerSmash, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(DurationMeasurement.getMeasuredDuration(this.mInstanceLoadDuration))}});
        }
        if (this.mSmashArray.size() == 1) {
            sendMediationEvent(IronSourceConstants.BN_RELOAD_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(DurationMeasurement.getMeasuredDuration(this.mLoadDuration))}});
            startReloadTimer();
            return;
        }
        setState(BANNER_STATE.LOAD_IN_PROGRESS);
        resetIteration();
        loadNextSmash();
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerManagerListener
    public void onBannerAdClicked(BannerSmash bannerSmash) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.info("smash - " + bannerSmash.getName());
        Object[][] objArr = null;
        if (canSendBannerCallbacks()) {
            this.mIronsourceBanner.sendBannerAdClicked();
        } else {
            objArr = new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "banner is destroyed"}};
        }
        sendMediationEvent(IronSourceConstants.BN_CALLBACK_CLICK, objArr, this.mPresentedBannerSessionDepth);
        sendProviderEvent(IronSourceConstants.BN_INSTANCE_CLICK, bannerSmash, objArr, this.mPresentedBannerSessionDepth);
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerManagerListener
    public void onBannerAdScreenDismissed(BannerSmash bannerSmash) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.info("smash - " + bannerSmash.getName());
        Object[][] objArr = null;
        if (canSendBannerCallbacks()) {
            this.mIronsourceBanner.sendBannerAdScreenDismissed();
        } else {
            objArr = new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "banner is destroyed"}};
        }
        sendMediationEvent(IronSourceConstants.BN_CALLBACK_DISMISS_SCREEN, objArr, this.mPresentedBannerSessionDepth);
        sendProviderEvent(IronSourceConstants.BN_INSTANCE_DISMISS_SCREEN, bannerSmash, objArr, this.mPresentedBannerSessionDepth);
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerManagerListener
    public void onBannerAdScreenPresented(BannerSmash bannerSmash) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.info("smash - " + bannerSmash.getName());
        Object[][] objArr = null;
        if (canSendBannerCallbacks()) {
            this.mIronsourceBanner.sendBannerAdScreenPresented();
        } else {
            objArr = new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "banner is destroyed"}};
        }
        sendMediationEvent(IronSourceConstants.BN_CALLBACK_PRESENT_SCREEN, objArr, this.mPresentedBannerSessionDepth);
        sendProviderEvent(IronSourceConstants.BN_INSTANCE_PRESENT_SCREEN, bannerSmash, objArr, this.mPresentedBannerSessionDepth);
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerManagerListener
    public void onBannerAdLeftApplication(BannerSmash bannerSmash) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.info("smash - " + bannerSmash.getName());
        Object[][] objArr = null;
        if (canSendBannerCallbacks()) {
            this.mIronsourceBanner.sendBannerAdLeftApplication();
        } else {
            objArr = new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "banner is destroyed"}};
        }
        sendMediationEvent(IronSourceConstants.BN_CALLBACK_LEAVE_APP, objArr, this.mPresentedBannerSessionDepth);
        sendProviderEvent(IronSourceConstants.BN_INSTANCE_LEAVE_APP, bannerSmash, objArr, this.mPresentedBannerSessionDepth);
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerManagerListener
    public void onBannerAdShown(BannerSmash bannerSmash) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.info("smash - " + bannerSmash.getName());
        sendMediationEvent(IronSourceConstants.BN_CALLBACK_SHOW);
        sendProviderEvent(IronSourceConstants.BN_INSTANCE_SHOW, bannerSmash);
    }

    private boolean canSendBannerCallbacks() {
        IronSourceBannerLayout ironSourceBannerLayout = this.mIronsourceBanner;
        return ironSourceBannerLayout != null && !ironSourceBannerLayout.isDestroyed();
    }

    private void sendMediationEvent(int i) {
        sendMediationEvent(i, null);
    }

    private void sendMediationEvent(int i, Object[][] objArr) {
        sendMediationEvent(i, objArr, this.mLoadingBannerSessionDepth);
    }

    private void sendMediationEvent(int i, Object[][] objArr, int i2) {
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
        try {
            if (this.mIronsourceBanner != null) {
                addEventSizeFields(mediationAdditionalData, this.mIronsourceBanner.getSize());
            }
            if (this.mCurrentPlacement != null) {
                mediationAdditionalData.put(IronSourceConstants.EVENTS_PLACEMENT_NAME, this.mCurrentPlacement.getPlacementName());
            }
            mediationAdditionalData.put("sessionDepth", i2);
            if (objArr != null) {
                for (Object[] objArr2 : objArr) {
                    mediationAdditionalData.put(objArr2[0].toString(), objArr2[1]);
                }
            }
        } catch (Exception e) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, "sendMediationEvent " + Log.getStackTraceString(e), 3);
        }
        InterstitialEventsManager.getInstance().log(new EventData(i, mediationAdditionalData));
    }

    private void addEventSizeFields(JSONObject jSONObject, ISBannerSize iSBannerSize) {
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
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            ironSourceLoggerManager.log(ironSourceTag, "sendProviderEvent " + Log.getStackTraceString(e), 3);
        }
    }

    private void sendProviderEvent(int i, BannerSmash bannerSmash) {
        sendProviderEvent(i, bannerSmash, null);
    }

    private void sendProviderEvent(int i, BannerSmash bannerSmash, Object[][] objArr) {
        sendProviderEvent(i, bannerSmash, objArr, this.mLoadingBannerSessionDepth);
    }

    private void sendProviderEvent(int i, BannerSmash bannerSmash, Object[][] objArr, int i2) {
        JSONObject providerAdditionalData = IronSourceUtils.getProviderAdditionalData(bannerSmash);
        try {
            if (this.mIronsourceBanner != null) {
                addEventSizeFields(providerAdditionalData, this.mIronsourceBanner.getSize());
            }
            if (this.mCurrentPlacement != null) {
                providerAdditionalData.put(IronSourceConstants.EVENTS_PLACEMENT_NAME, this.mCurrentPlacement.getPlacementName());
            }
            providerAdditionalData.put("sessionDepth", i2);
            if (objArr != null) {
                for (Object[] objArr2 : objArr) {
                    providerAdditionalData.put(objArr2[0].toString(), objArr2[1]);
                }
            }
        } catch (Exception e) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, "sendProviderEvent " + Log.getStackTraceString(e), 3);
        }
        InterstitialEventsManager.getInstance().log(new EventData(i, providerAdditionalData));
    }

    private void resetIteration() {
        Iterator<BannerSmash> it = this.mSmashArray.iterator();
        while (it.hasNext()) {
            it.next().setReadyToLoad(true);
        }
    }

    private boolean loadNextSmash() {
        Iterator<BannerSmash> it = this.mSmashArray.iterator();
        while (it.hasNext()) {
            BannerSmash next = it.next();
            if (next.isReadyToLoad() && this.mActiveSmash != next) {
                if (this.mState == BANNER_STATE.FIRST_LOAD_IN_PROGRESS) {
                    sendProviderEvent(3002, next);
                } else {
                    sendProviderEvent(IronSourceConstants.BN_INSTANCE_RELOAD, next);
                }
                this.mInstanceLoadDuration = new DurationMeasurement();
                next.loadBanner(this.mIronsourceBanner, this.mAppKey, this.mUserId);
                return true;
            }
        }
        return false;
    }

    public void onPause() {
        this.mIsInForeground = false;
    }

    public void onResume() {
        this.mIsInForeground = true;
    }

    private void startReloadTimer() {
        try {
            stopReloadTimer();
            if (this.mReloadInterval > 0) {
                Timer timer = new Timer();
                this.mReloadTimer = timer;
                timer.schedule(new TimerTask() {
                    /* class com.ironsource.mediationsdk.BannerManager.AnonymousClass1 */

                    public void run() {
                        BannerManager.this.onReloadTimer();
                    }
                }, this.mReloadInterval * 1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void stopReloadTimer() {
        Timer timer = this.mReloadTimer;
        if (timer != null) {
            timer.cancel();
            this.mReloadTimer = null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onReloadTimer() {
        if (this.mState != BANNER_STATE.RELOAD_IN_PROGRESS) {
            debugLog("onReloadTimer wrong state=" + this.mState.name());
        } else if (this.mIsInForeground.booleanValue()) {
            this.mLoadingBannerSessionDepth = SessionDepthManager.getInstance().getSessionDepth(3);
            sendMediationEvent(IronSourceConstants.BN_RELOAD);
            sendProviderEvent(IronSourceConstants.BN_INSTANCE_RELOAD, this.mActiveSmash);
            this.mLoadDuration = new DurationMeasurement();
            this.mInstanceLoadDuration = new DurationMeasurement();
            this.mActiveSmash.reloadBanner();
        } else {
            sendMediationEvent(IronSourceConstants.BN_SKIP_RELOAD, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf((int) IronSourceError.ERROR_BN_RELOAD_SKIP_BACKGROUND)}});
            startReloadTimer();
        }
    }
}
