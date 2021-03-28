package com.ironsource.mediationsdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.ironsource.eventsmodule.EventData;
import com.ironsource.mediationsdk.AbstractSmash;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.MediationInitializer;
import com.ironsource.mediationsdk.events.InterstitialEventsManager;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.InterstitialPlacement;
import com.ironsource.mediationsdk.sdk.InterstitialManagerListener;
import com.ironsource.mediationsdk.sdk.ListenersWrapper;
import com.ironsource.mediationsdk.utils.CappingManager;
import com.ironsource.mediationsdk.utils.ContextProvider;
import com.ironsource.mediationsdk.utils.DailyCappingListener;
import com.ironsource.mediationsdk.utils.DailyCappingManager;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.SessionDepthManager;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class InterstitialManager extends AbstractAdUnitManager implements InterstitialManagerListener, MediationInitializer.OnMediationInitializationListener, DailyCappingListener {
    private final String TAG = getClass().getName();
    private CallbackThrottler mCallbackThrottler = CallbackThrottler.getInstance();
    private InterstitialPlacement mCurrentPlacement;
    private boolean mDidCallLoadInterstitial = false;
    private boolean mDidFinishToInitInterstitial;
    private Map<String, InterstitialSmash> mInstanceIdToSmashMap = new ConcurrentHashMap();
    private CopyOnWriteArraySet<String> mInstancesToLoad = new CopyOnWriteArraySet<>();
    private ListenersWrapper mInterstitialListenersWrapper;
    private boolean mIsCurrentlyShowing;
    private boolean mIsLoadInterstitialInProgress = false;
    private long mLoadStartTime;
    private boolean mShouldSendAdReadyEvent = false;

    @Override // com.ironsource.mediationsdk.MediationInitializer.OnMediationInitializationListener
    public void onInitSuccess(List<IronSource.AD_UNIT> list, boolean z) {
    }

    InterstitialManager() {
        this.mDailyCappingManager = new DailyCappingManager(IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE, this);
        this.mIsCurrentlyShowing = false;
    }

    public void setInterstitialListener(ListenersWrapper listenersWrapper) {
        this.mInterstitialListenersWrapper = listenersWrapper;
        this.mCallbackThrottler.setInterstitialListener(listenersWrapper);
    }

    public synchronized void initInterstitial(String str, String str2) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
        ironSourceLoggerManager.log(ironSourceTag, this.TAG + ":initInterstitial(appKey: " + str + ", userId: " + str2 + ")", 1);
        long time = new Date().getTime();
        logMediationEvent(IronSourceConstants.IS_MANAGER_INIT_STARTED);
        this.mAppKey = str;
        this.mUserId = str2;
        Iterator it = this.mSmashArray.iterator();
        int i = 0;
        while (it.hasNext()) {
            AbstractSmash abstractSmash = (AbstractSmash) it.next();
            if (this.mDailyCappingManager.shouldSendCapReleasedEvent(abstractSmash)) {
                logProviderEvent(IronSourceConstants.INTERSTITIAL_DAILY_CAPPED, abstractSmash, new Object[][]{new Object[]{"status", "false"}});
            }
            if (this.mDailyCappingManager.isCapped(abstractSmash)) {
                abstractSmash.setMediationState(AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY);
                i++;
            }
        }
        if (i == this.mSmashArray.size()) {
            this.mDidFinishToInitInterstitial = true;
        }
        prepareSDK5();
        int i2 = 0;
        while (true) {
            if (i2 >= this.mSmartLoadAmount) {
                break;
            } else if (startNextAdapter() == null) {
                break;
            } else {
                i2++;
            }
        }
        logMediationEvent(IronSourceConstants.IS_MANAGER_INIT_ENDED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(new Date().getTime() - time)}});
    }

    public synchronized void loadInterstitial() {
        try {
            if (this.mIsCurrentlyShowing) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "loadInterstitial cannot be invoked while showing an ad", 3);
                ISListenerWrapper.getInstance().onInterstitialAdLoadFailed(new IronSourceError(IronSourceError.ERROR_IS_LOAD_DURING_SHOW, "loadInterstitial cannot be invoked while showing an ad"));
                return;
            }
            this.mCurrentPlacement = null;
            this.mInterstitialListenersWrapper.setInterstitialPlacement(null);
            if (this.mIsLoadInterstitialInProgress || this.mCallbackThrottler.hasPendingInvocation()) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Load Interstitial is already in progress", 3);
                return;
            }
            MediationInitializer.EInitStatus currentInitStatus = MediationInitializer.getInstance().getCurrentInitStatus();
            if (currentInitStatus == MediationInitializer.EInitStatus.NOT_INIT) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "init() must be called before loadInterstitial()", 3);
            } else if (currentInitStatus == MediationInitializer.EInitStatus.INIT_IN_PROGRESS) {
                if (MediationInitializer.getInstance().isInProgressMoreThan15Secs()) {
                    this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "init() had failed", 3);
                    this.mCallbackThrottler.onInterstitialAdLoadFailed(ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
                } else {
                    this.mLoadStartTime = new Date().getTime();
                    logMediationEvent(2001, null);
                    this.mDidCallLoadInterstitial = true;
                    this.mShouldSendAdReadyEvent = true;
                }
            } else if (currentInitStatus == MediationInitializer.EInitStatus.INIT_FAILED) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "init() had failed", 3);
                this.mCallbackThrottler.onInterstitialAdLoadFailed(ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
            } else if (this.mSmashArray.size() == 0) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "the server response does not contain interstitial data", 3);
                this.mCallbackThrottler.onInterstitialAdLoadFailed(ErrorBuilder.buildInitFailedError("the server response does not contain interstitial data", "Interstitial"));
            } else {
                this.mLoadStartTime = new Date().getTime();
                logMediationEvent(2001, null);
                this.mShouldSendAdReadyEvent = true;
                changeStateToInitiated();
                if (smashesCount(AbstractSmash.MEDIATION_STATE.INITIATED) != 0) {
                    this.mDidCallLoadInterstitial = true;
                    this.mIsLoadInterstitialInProgress = true;
                    Iterator it = this.mSmashArray.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        AbstractSmash abstractSmash = (AbstractSmash) it.next();
                        if (abstractSmash.getMediationState() == AbstractSmash.MEDIATION_STATE.INITIATED) {
                            abstractSmash.setMediationState(AbstractSmash.MEDIATION_STATE.LOAD_PENDING);
                            loadAdapterAndSendEvent((InterstitialSmash) abstractSmash);
                            i++;
                            if (i >= this.mSmartLoadAmount) {
                                return;
                            }
                        }
                    }
                } else if (!this.mDidFinishToInitInterstitial) {
                    this.mDidCallLoadInterstitial = true;
                } else {
                    IronSourceError buildGenericError = ErrorBuilder.buildGenericError("no ads to load");
                    this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, buildGenericError.getErrorMessage(), 1);
                    this.mCallbackThrottler.onInterstitialAdLoadFailed(buildGenericError);
                    logMediationEvent(IronSourceConstants.IS_CALLBACK_LOAD_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(buildGenericError.getErrorCode())}});
                    this.mShouldSendAdReadyEvent = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            IronSourceError buildLoadFailedError = ErrorBuilder.buildLoadFailedError("loadInterstitial exception " + e.getMessage());
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, buildLoadFailedError.getErrorMessage(), 3);
            this.mCallbackThrottler.onInterstitialAdLoadFailed(buildLoadFailedError);
            if (this.mShouldSendAdReadyEvent) {
                this.mShouldSendAdReadyEvent = false;
                logMediationEvent(IronSourceConstants.IS_CALLBACK_LOAD_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(buildLoadFailedError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, e.getMessage()}});
            }
        }
    }

    public void showInterstitial(String str) {
        if (this.mIsCurrentlyShowing) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "showInterstitial error: can't show ad while an ad is already showing", 3);
            this.mInterstitialListenersWrapper.onInterstitialAdShowFailed(new IronSourceError(IronSourceError.ERROR_IS_SHOW_CALLED_DURING_SHOW, "showInterstitial error: can't show ad while an ad is already showing"));
        } else if (!this.mDidCallLoadInterstitial) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "showInterstitial failed - You need to load interstitial before showing it", 3);
            this.mInterstitialListenersWrapper.onInterstitialAdShowFailed(ErrorBuilder.buildShowFailedError("Interstitial", "showInterstitial failed - You need to load interstitial before showing it"));
        } else if (!this.mShouldTrackNetworkState || IronSourceUtils.isNetworkConnected(ContextProvider.getInstance().getCurrentActiveActivity())) {
            for (int i = 0; i < this.mSmashArray.size(); i++) {
                AbstractSmash abstractSmash = (AbstractSmash) this.mSmashArray.get(i);
                if (abstractSmash.getMediationState() == AbstractSmash.MEDIATION_STATE.AVAILABLE) {
                    CappingManager.incrementShowCounter(ContextProvider.getInstance().getCurrentActiveActivity(), this.mCurrentPlacement);
                    if (CappingManager.isPlacementCapped(ContextProvider.getInstance().getCurrentActiveActivity(), this.mCurrentPlacement) != CappingManager.ECappingStatus.NOT_CAPPED) {
                        logMediationEventWithPlacement(IronSourceConstants.IS_CAP_PLACEMENT, null);
                    }
                    logProviderEventWithPlacement(IronSourceConstants.IS_INSTANCE_SHOW, abstractSmash, null);
                    this.mIsCurrentlyShowing = true;
                    ((InterstitialSmash) abstractSmash).showInterstitial();
                    if (abstractSmash.isCappedPerSession()) {
                        logProviderEvent(IronSourceConstants.IS_CAP_SESSION, abstractSmash);
                    }
                    this.mDailyCappingManager.increaseShowCounter(abstractSmash);
                    if (this.mDailyCappingManager.isCapped(abstractSmash)) {
                        abstractSmash.setMediationState(AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY);
                        logProviderEvent(IronSourceConstants.INTERSTITIAL_DAILY_CAPPED, abstractSmash, new Object[][]{new Object[]{"status", "true"}});
                    }
                    this.mDidCallLoadInterstitial = false;
                    if (!abstractSmash.isMediationAvailable()) {
                        startNextAdapter();
                        return;
                    }
                    return;
                }
            }
            this.mInterstitialListenersWrapper.onInterstitialAdShowFailed(ErrorBuilder.buildShowFailedError("Interstitial", "showInterstitial failed - No adapters ready to show"));
        } else {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "showInterstitial error: can't show ad when there's no internet connection", 3);
            this.mInterstitialListenersWrapper.onInterstitialAdShowFailed(ErrorBuilder.buildNoInternetConnectionShowFailError("Interstitial"));
        }
    }

    public synchronized boolean isInterstitialReady() {
        if (this.mShouldTrackNetworkState && !IronSourceUtils.isNetworkConnected(ContextProvider.getInstance().getCurrentActiveActivity())) {
            return false;
        }
        Iterator it = this.mSmashArray.iterator();
        while (it.hasNext()) {
            AbstractSmash abstractSmash = (AbstractSmash) it.next();
            if (abstractSmash.getMediationState() == AbstractSmash.MEDIATION_STATE.AVAILABLE && ((InterstitialSmash) abstractSmash).isInterstitialReady()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialManagerListener
    public synchronized void onInterstitialInitSuccess(InterstitialSmash interstitialSmash) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        ironSourceLoggerManager.log(ironSourceTag, interstitialSmash.getInstanceName() + " :onInterstitialInitSuccess()", 1);
        logProviderEvent(IronSourceConstants.IS_INSTANCE_INIT_SUCCESS, interstitialSmash);
        this.mDidFinishToInitInterstitial = true;
        if (this.mDidCallLoadInterstitial) {
            if (smashesCount(AbstractSmash.MEDIATION_STATE.AVAILABLE, AbstractSmash.MEDIATION_STATE.LOAD_PENDING) < this.mSmartLoadAmount) {
                interstitialSmash.setMediationState(AbstractSmash.MEDIATION_STATE.LOAD_PENDING);
                loadAdapterAndSendEvent(interstitialSmash);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialManagerListener
    public synchronized void onInterstitialInitFailed(IronSourceError ironSourceError, InterstitialSmash interstitialSmash) {
        try {
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
            ironSourceLoggerManager.log(ironSourceTag, interstitialSmash.getInstanceName() + ":onInterstitialInitFailed(" + ironSourceError + ")", 1);
            logProviderEvent(IronSourceConstants.IS_INSTANCE_INIT_FAILED, interstitialSmash, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}});
            if (smashesCount(AbstractSmash.MEDIATION_STATE.INIT_FAILED) >= this.mSmashArray.size()) {
                IronSourceLoggerManager ironSourceLoggerManager2 = this.mLoggerManager;
                IronSourceLogger.IronSourceTag ironSourceTag2 = IronSourceLogger.IronSourceTag.NATIVE;
                ironSourceLoggerManager2.log(ironSourceTag2, "Smart Loading - initialization failed - no adapters are initiated and no more left to init, error: " + ironSourceError.getErrorMessage(), 2);
                if (this.mDidCallLoadInterstitial) {
                    this.mCallbackThrottler.onInterstitialAdLoadFailed(ErrorBuilder.buildGenericError("no ads to show"));
                    logMediationEvent(IronSourceConstants.IS_CALLBACK_LOAD_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf((int) IronSourceError.ERROR_CODE_GENERIC)}});
                    this.mShouldSendAdReadyEvent = false;
                }
                this.mDidFinishToInitInterstitial = true;
            } else {
                if (startNextAdapter() == null && this.mDidCallLoadInterstitial) {
                    if (smashesCount(AbstractSmash.MEDIATION_STATE.INIT_FAILED, AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE, AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION, AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY, AbstractSmash.MEDIATION_STATE.EXHAUSTED) >= this.mSmashArray.size()) {
                        this.mCallbackThrottler.onInterstitialAdLoadFailed(new IronSourceError(IronSourceError.ERROR_CODE_NO_ADS_TO_SHOW, "No ads to show"));
                        logMediationEvent(IronSourceConstants.IS_CALLBACK_LOAD_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf((int) IronSourceError.ERROR_CODE_NO_ADS_TO_SHOW)}});
                        this.mShouldSendAdReadyEvent = false;
                    }
                }
                completeIterationRound();
            }
        } catch (Exception e) {
            IronSourceLoggerManager ironSourceLoggerManager3 = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag3 = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
            ironSourceLoggerManager3.logException(ironSourceTag3, "onInterstitialInitFailed(error:" + ironSourceError + ", provider:" + interstitialSmash.getName() + ")", e);
        }
        return;
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialManagerListener
    public synchronized void onInterstitialAdReady(InterstitialSmash interstitialSmash, long j) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        ironSourceLoggerManager.log(ironSourceTag, interstitialSmash.getInstanceName() + ":onInterstitialAdReady()", 1);
        logProviderEvent(2003, interstitialSmash, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j)}});
        long time = new Date().getTime() - this.mLoadStartTime;
        interstitialSmash.setMediationState(AbstractSmash.MEDIATION_STATE.AVAILABLE);
        this.mIsLoadInterstitialInProgress = false;
        if (this.mShouldSendAdReadyEvent) {
            this.mShouldSendAdReadyEvent = false;
            this.mInterstitialListenersWrapper.onInterstitialAdReady();
            logMediationEvent(2004, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(time)}});
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialManagerListener
    public synchronized void onInterstitialAdLoadFailed(IronSourceError ironSourceError, InterstitialSmash interstitialSmash, long j) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        ironSourceLoggerManager.log(ironSourceTag, interstitialSmash.getInstanceName() + ":onInterstitialAdLoadFailed(" + ironSourceError + ")", 1);
        IronSourceUtils.sendAutomationLog(interstitialSmash.getInstanceName() + ":onInterstitialAdLoadFailed(" + ironSourceError + ")");
        if (ironSourceError.getErrorCode() == 1158) {
            logProviderEvent(IronSourceConstants.IS_INSTANCE_LOAD_NO_FILL, interstitialSmash, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j)}});
        } else {
            logProviderEvent(IronSourceConstants.IS_INSTANCE_LOAD_FAILED, interstitialSmash, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j)}});
        }
        interstitialSmash.setMediationState(AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE);
        int smashesCount = smashesCount(AbstractSmash.MEDIATION_STATE.AVAILABLE, AbstractSmash.MEDIATION_STATE.LOAD_PENDING);
        if (smashesCount < this.mSmartLoadAmount) {
            Iterator it = this.mSmashArray.iterator();
            while (it.hasNext()) {
                AbstractSmash abstractSmash = (AbstractSmash) it.next();
                if (abstractSmash.getMediationState() == AbstractSmash.MEDIATION_STATE.INITIATED) {
                    abstractSmash.setMediationState(AbstractSmash.MEDIATION_STATE.LOAD_PENDING);
                    loadAdapterAndSendEvent((InterstitialSmash) abstractSmash);
                    return;
                }
            }
            if (startNextAdapter() == null) {
                if (this.mDidCallLoadInterstitial) {
                    if (smashesCount + smashesCount(AbstractSmash.MEDIATION_STATE.INIT_PENDING) == 0) {
                        completeIterationRound();
                        this.mIsLoadInterstitialInProgress = false;
                        this.mCallbackThrottler.onInterstitialAdLoadFailed(new IronSourceError(IronSourceError.ERROR_CODE_NO_ADS_TO_SHOW, "No ads to show"));
                        logMediationEvent(IronSourceConstants.IS_CALLBACK_LOAD_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf((int) IronSourceError.ERROR_CODE_NO_ADS_TO_SHOW)}});
                    }
                }
            }
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialManagerListener
    public void onInterstitialAdOpened(InterstitialSmash interstitialSmash) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        ironSourceLoggerManager.log(ironSourceTag, interstitialSmash.getInstanceName() + ":onInterstitialAdOpened()", 1);
        logProviderEventWithPlacement(IronSourceConstants.IS_INSTANCE_OPENED, interstitialSmash, null);
        this.mInterstitialListenersWrapper.onInterstitialAdOpened();
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialManagerListener
    public void onInterstitialAdClosed(InterstitialSmash interstitialSmash) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        ironSourceLoggerManager.log(ironSourceTag, interstitialSmash.getInstanceName() + ":onInterstitialAdClosed()", 1);
        this.mIsCurrentlyShowing = false;
        logProviderEventWithPlacement(IronSourceConstants.IS_INSTANCE_CLOSED, interstitialSmash, new Object[][]{new Object[]{"sessionDepth", Integer.valueOf(SessionDepthManager.getInstance().getSessionDepth(2))}});
        SessionDepthManager.getInstance().increaseSessionDepth(2);
        this.mInterstitialListenersWrapper.onInterstitialAdClosed();
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialManagerListener
    public void onInterstitialAdShowSucceeded(InterstitialSmash interstitialSmash) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        ironSourceLoggerManager.log(ironSourceTag, interstitialSmash.getInstanceName() + ":onInterstitialAdShowSucceeded()", 1);
        logProviderEventWithPlacement(IronSourceConstants.IS_INSTANCE_SHOW_SUCCESS, interstitialSmash, null);
        Iterator it = this.mSmashArray.iterator();
        boolean z = false;
        while (it.hasNext()) {
            AbstractSmash abstractSmash = (AbstractSmash) it.next();
            if (abstractSmash.getMediationState() == AbstractSmash.MEDIATION_STATE.AVAILABLE) {
                completeAdapterShow(abstractSmash);
                z = true;
            }
        }
        if (!z && (interstitialSmash.getMediationState() == AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION || interstitialSmash.getMediationState() == AbstractSmash.MEDIATION_STATE.EXHAUSTED || interstitialSmash.getMediationState() == AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY)) {
            completeIterationRound();
        }
        changeStateToInitiated();
        this.mInterstitialListenersWrapper.onInterstitialAdShowSucceeded();
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialManagerListener
    public void onInterstitialAdShowFailed(IronSourceError ironSourceError, InterstitialSmash interstitialSmash) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        ironSourceLoggerManager.log(ironSourceTag, interstitialSmash.getInstanceName() + ":onInterstitialAdShowFailed(" + ironSourceError + ")", 1);
        logProviderEventWithPlacement(IronSourceConstants.IS_INSTANCE_SHOW_FAILED, interstitialSmash, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}});
        this.mIsCurrentlyShowing = false;
        completeAdapterShow(interstitialSmash);
        Iterator it = this.mSmashArray.iterator();
        while (it.hasNext()) {
            if (((AbstractSmash) it.next()).getMediationState() == AbstractSmash.MEDIATION_STATE.AVAILABLE) {
                this.mDidCallLoadInterstitial = true;
                InterstitialPlacement interstitialPlacement = this.mCurrentPlacement;
                showInterstitial(interstitialPlacement != null ? interstitialPlacement.getPlacementName() : "");
                return;
            }
        }
        this.mInterstitialListenersWrapper.onInterstitialAdShowFailed(ironSourceError);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialManagerListener
    public void onInterstitialAdClicked(InterstitialSmash interstitialSmash) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        ironSourceLoggerManager.log(ironSourceTag, interstitialSmash.getInstanceName() + ":onInterstitialAdClicked()", 1);
        logProviderEventWithPlacement(2006, interstitialSmash, null);
        this.mInterstitialListenersWrapper.onInterstitialAdClicked();
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialManagerListener
    public void onInterstitialAdVisible(InterstitialSmash interstitialSmash) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        ironSourceLoggerManager.log(ironSourceTag, interstitialSmash.getInstanceName() + ":onInterstitialAdVisible()", 1);
    }

    /* access modifiers changed from: package-private */
    @Override // com.ironsource.mediationsdk.AbstractAdUnitManager
    public void shouldTrackNetworkState(Context context, boolean z) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        ironSourceLoggerManager.log(ironSourceTag, this.TAG + " Should Track Network State: " + z, 0);
        this.mShouldTrackNetworkState = z;
    }

    @Override // com.ironsource.mediationsdk.MediationInitializer.OnMediationInitializationListener
    public void onInitFailed(String str) {
        if (this.mDidCallLoadInterstitial) {
            this.mCallbackThrottler.onInterstitialAdLoadFailed(ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
            this.mDidCallLoadInterstitial = false;
            this.mIsLoadInterstitialInProgress = false;
        }
    }

    @Override // com.ironsource.mediationsdk.MediationInitializer.OnMediationInitializationListener
    public void onStillInProgressAfter15Secs() {
        if (this.mDidCallLoadInterstitial) {
            IronSourceError buildInitFailedError = ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial");
            this.mCallbackThrottler.onInterstitialAdLoadFailed(buildInitFailedError);
            this.mDidCallLoadInterstitial = false;
            this.mIsLoadInterstitialInProgress = false;
            if (this.mShouldSendAdReadyEvent) {
                logMediationEvent(IronSourceConstants.IS_CALLBACK_LOAD_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(buildInitFailedError.getErrorCode())}});
                this.mShouldSendAdReadyEvent = false;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isIterationRoundComplete() {
        /*
            r4 = this;
            java.util.concurrent.CopyOnWriteArrayList r0 = r4.mSmashArray
            java.util.Iterator r0 = r0.iterator()
        L_0x0006:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x003c
            java.lang.Object r1 = r0.next()
            com.ironsource.mediationsdk.AbstractSmash r1 = (com.ironsource.mediationsdk.AbstractSmash) r1
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r2 = r1.getMediationState()
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r3 = com.ironsource.mediationsdk.AbstractSmash.MEDIATION_STATE.NOT_INITIATED
            if (r2 == r3) goto L_0x003a
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r2 = r1.getMediationState()
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r3 = com.ironsource.mediationsdk.AbstractSmash.MEDIATION_STATE.INIT_PENDING
            if (r2 == r3) goto L_0x003a
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r2 = r1.getMediationState()
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r3 = com.ironsource.mediationsdk.AbstractSmash.MEDIATION_STATE.INITIATED
            if (r2 == r3) goto L_0x003a
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r2 = r1.getMediationState()
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r3 = com.ironsource.mediationsdk.AbstractSmash.MEDIATION_STATE.LOAD_PENDING
            if (r2 == r3) goto L_0x003a
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r1 = r1.getMediationState()
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r2 = com.ironsource.mediationsdk.AbstractSmash.MEDIATION_STATE.AVAILABLE
            if (r1 != r2) goto L_0x0006
        L_0x003a:
            r0 = 0
            return r0
        L_0x003c:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.InterstitialManager.isIterationRoundComplete():boolean");
    }

    private void completeIterationRound() {
        if (isIterationRoundComplete()) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, "Reset Iteration", 0);
            Iterator it = this.mSmashArray.iterator();
            while (it.hasNext()) {
                AbstractSmash abstractSmash = (AbstractSmash) it.next();
                if (abstractSmash.getMediationState() == AbstractSmash.MEDIATION_STATE.EXHAUSTED) {
                    abstractSmash.completeIteration();
                }
            }
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, "End of Reset Iteration", 0);
        }
    }

    private void completeAdapterShow(AbstractSmash abstractSmash) {
        if (!abstractSmash.isMediationAvailable()) {
            startNextAdapter();
            completeIterationRound();
            return;
        }
        abstractSmash.setMediationState(AbstractSmash.MEDIATION_STATE.INITIATED);
    }

    private AbstractAdapter startNextAdapter() {
        AbstractAdapter abstractAdapter = null;
        int i = 0;
        for (int i2 = 0; i2 < this.mSmashArray.size() && abstractAdapter == null; i2++) {
            if (((AbstractSmash) this.mSmashArray.get(i2)).getMediationState() == AbstractSmash.MEDIATION_STATE.AVAILABLE || ((AbstractSmash) this.mSmashArray.get(i2)).getMediationState() == AbstractSmash.MEDIATION_STATE.INITIATED || ((AbstractSmash) this.mSmashArray.get(i2)).getMediationState() == AbstractSmash.MEDIATION_STATE.INIT_PENDING || ((AbstractSmash) this.mSmashArray.get(i2)).getMediationState() == AbstractSmash.MEDIATION_STATE.LOAD_PENDING) {
                i++;
                if (i >= this.mSmartLoadAmount) {
                    break;
                }
            } else if (((AbstractSmash) this.mSmashArray.get(i2)).getMediationState() == AbstractSmash.MEDIATION_STATE.NOT_INITIATED && (abstractAdapter = startAdapter((InterstitialSmash) this.mSmashArray.get(i2))) == null) {
                ((AbstractSmash) this.mSmashArray.get(i2)).setMediationState(AbstractSmash.MEDIATION_STATE.INIT_FAILED);
            }
        }
        return abstractAdapter;
    }

    private synchronized AbstractAdapter startAdapter(InterstitialSmash interstitialSmash) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
        ironSourceLoggerManager.log(ironSourceTag, this.TAG + ":startAdapter(" + interstitialSmash.getName() + ")", 1);
        AbstractAdapter adapter = AdapterRepository.getInstance().getAdapter(interstitialSmash.mAdapterConfigs, interstitialSmash.mAdapterConfigs.getInterstitialSettings());
        if (adapter == null) {
            IronSourceLoggerManager ironSourceLoggerManager2 = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag2 = IronSourceLogger.IronSourceTag.API;
            ironSourceLoggerManager2.log(ironSourceTag2, interstitialSmash.getInstanceName() + " is configured in IronSource's platform, but the adapter is not integrated", 2);
            return null;
        }
        interstitialSmash.setAdapterForSmash(adapter);
        interstitialSmash.setMediationState(AbstractSmash.MEDIATION_STATE.INIT_PENDING);
        setCustomParams(interstitialSmash);
        try {
            interstitialSmash.initInterstitial(this.mAppKey, this.mUserId);
            return adapter;
        } catch (Throwable th) {
            IronSourceLoggerManager ironSourceLoggerManager3 = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag3 = IronSourceLogger.IronSourceTag.API;
            ironSourceLoggerManager3.logException(ironSourceTag3, this.TAG + "failed to init adapter: " + interstitialSmash.getName() + "v", th);
            interstitialSmash.setMediationState(AbstractSmash.MEDIATION_STATE.INIT_FAILED);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void setCurrentPlacement(InterstitialPlacement interstitialPlacement) {
        this.mCurrentPlacement = interstitialPlacement;
        this.mInterstitialListenersWrapper.setInterstitialPlacement(interstitialPlacement);
    }

    private synchronized void loadAdapterAndSendEvent(InterstitialSmash interstitialSmash) {
        logProviderEvent(2002, interstitialSmash, null);
        interstitialSmash.loadInterstitial();
    }

    private synchronized void changeStateToInitiatedForInstanceId(String str) {
        AbstractSmash abstractSmash;
        Iterator it = this.mSmashArray.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            abstractSmash = (AbstractSmash) it.next();
            if (!abstractSmash.getSubProviderId().equals(str) || !(abstractSmash.getMediationState() == AbstractSmash.MEDIATION_STATE.AVAILABLE || abstractSmash.getMediationState() == AbstractSmash.MEDIATION_STATE.LOAD_PENDING || abstractSmash.getMediationState() == AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE)) {
            }
        }
        abstractSmash.setMediationState(AbstractSmash.MEDIATION_STATE.INITIATED);
    }

    private synchronized void changeStateToInitiated() {
        Iterator it = this.mSmashArray.iterator();
        while (it.hasNext()) {
            AbstractSmash abstractSmash = (AbstractSmash) it.next();
            if (abstractSmash.getMediationState() == AbstractSmash.MEDIATION_STATE.AVAILABLE || abstractSmash.getMediationState() == AbstractSmash.MEDIATION_STATE.LOAD_PENDING || abstractSmash.getMediationState() == AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE) {
                abstractSmash.setMediationState(AbstractSmash.MEDIATION_STATE.INITIATED);
            }
        }
    }

    private void logMediationEvent(int i) {
        logMediationEvent(i, null);
    }

    private void logMediationEvent(int i, Object[][] objArr) {
        logMediationEvent(i, objArr, false);
    }

    private void logMediationEventWithPlacement(int i, Object[][] objArr) {
        logMediationEvent(i, objArr, true);
    }

    private void logMediationEvent(int i, Object[][] objArr, boolean z) {
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
        if (z) {
            try {
                if (this.mCurrentPlacement != null && !TextUtils.isEmpty(this.mCurrentPlacement.getPlacementName())) {
                    mediationAdditionalData.put(IronSourceConstants.EVENTS_PLACEMENT_NAME, this.mCurrentPlacement.getPlacementName());
                }
            } catch (Exception e) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, "InterstitialManager logMediationEvent " + Log.getStackTraceString(e), 3);
            }
        }
        if (objArr != null) {
            for (Object[] objArr2 : objArr) {
                mediationAdditionalData.put(objArr2[0].toString(), objArr2[1]);
            }
        }
        InterstitialEventsManager.getInstance().log(new EventData(i, mediationAdditionalData));
    }

    private void logProviderEvent(int i, AbstractSmash abstractSmash) {
        logProviderEvent(i, abstractSmash, null);
    }

    private void logProviderEvent(int i, AbstractSmash abstractSmash, Object[][] objArr) {
        logProviderEvent(i, abstractSmash, objArr, false);
    }

    private void logProviderEventWithPlacement(int i, AbstractSmash abstractSmash, Object[][] objArr) {
        logProviderEvent(i, abstractSmash, objArr, true);
    }

    private void logProviderEvent(int i, AbstractSmash abstractSmash, Object[][] objArr, boolean z) {
        JSONObject providerAdditionalData = IronSourceUtils.getProviderAdditionalData(abstractSmash);
        if (z) {
            try {
                if (this.mCurrentPlacement != null && !TextUtils.isEmpty(this.mCurrentPlacement.getPlacementName())) {
                    providerAdditionalData.put(IronSourceConstants.EVENTS_PLACEMENT_NAME, this.mCurrentPlacement.getPlacementName());
                }
            } catch (Exception e) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, "InterstitialManager logProviderEvent " + Log.getStackTraceString(e), 3);
            }
        }
        if (objArr != null) {
            for (Object[] objArr2 : objArr) {
                providerAdditionalData.put(objArr2[0].toString(), objArr2[1]);
            }
        }
        InterstitialEventsManager.getInstance().log(new EventData(i, providerAdditionalData));
    }

    private int smashesCount(AbstractSmash.MEDIATION_STATE... mediation_stateArr) {
        Iterator it = this.mSmashArray.iterator();
        int i = 0;
        while (it.hasNext()) {
            AbstractSmash abstractSmash = (AbstractSmash) it.next();
            for (AbstractSmash.MEDIATION_STATE mediation_state : mediation_stateArr) {
                if (abstractSmash.getMediationState() == mediation_state) {
                    i++;
                }
            }
        }
        return i;
    }

    @Override // com.ironsource.mediationsdk.utils.DailyCappingListener
    public void onDailyCapReleased() {
        if (this.mSmashArray != null) {
            Iterator it = this.mSmashArray.iterator();
            while (it.hasNext()) {
                AbstractSmash abstractSmash = (AbstractSmash) it.next();
                if (abstractSmash.getMediationState() == AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY) {
                    logProviderEvent(IronSourceConstants.INTERSTITIAL_DAILY_CAPPED, abstractSmash, new Object[][]{new Object[]{"status", "false"}});
                    if (abstractSmash.isCappedPerSession()) {
                        abstractSmash.setMediationState(AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION);
                    } else if (abstractSmash.isExhausted()) {
                        abstractSmash.setMediationState(AbstractSmash.MEDIATION_STATE.EXHAUSTED);
                    } else {
                        abstractSmash.setMediationState(AbstractSmash.MEDIATION_STATE.INITIATED);
                    }
                }
            }
        }
    }

    public void setDelayLoadFailureNotificationInSeconds(int i) {
        this.mCallbackThrottler.setDelayLoadFailureNotificationInSeconds(i);
    }

    private void prepareSDK5() {
        for (int i = 0; i < this.mSmashArray.size(); i++) {
            String providerTypeForReflection = ((AbstractSmash) this.mSmashArray.get(i)).mAdapterConfigs.getProviderTypeForReflection();
            if (providerTypeForReflection.equalsIgnoreCase(IronSourceConstants.IRONSOURCE_CONFIG_NAME) || providerTypeForReflection.equalsIgnoreCase(IronSourceConstants.SUPERSONIC_CONFIG_NAME)) {
                AdapterRepository.getInstance().getAdapter(((AbstractSmash) this.mSmashArray.get(i)).mAdapterConfigs, ((AbstractSmash) this.mSmashArray.get(i)).mAdapterConfigs.getInterstitialSettings());
                return;
            }
        }
    }
}
