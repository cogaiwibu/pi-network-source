package com.ironsource.mediationsdk;

import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import com.ironsource.environment.NetworkStateReceiver;
import com.ironsource.environment.NetworkStateReceiverListener;
import com.ironsource.eventsmodule.EventData;
import com.ironsource.mediationsdk.AbstractSmash;
import com.ironsource.mediationsdk.events.RewardedVideoEventsManager;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.ListenersWrapper;
import com.ironsource.mediationsdk.sdk.RewardedVideoManagerListener;
import com.ironsource.mediationsdk.server.Server;
import com.ironsource.mediationsdk.utilities.IronsourceMapUtilities;
import com.ironsource.mediationsdk.utils.CappingManager;
import com.ironsource.mediationsdk.utils.ContextProvider;
import com.ironsource.mediationsdk.utils.DailyCappingListener;
import com.ironsource.mediationsdk.utils.DailyCappingManager;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.SessionDepthManager;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class RewardedVideoManager extends AbstractAdUnitManager implements RewardedVideoManagerListener, NetworkStateReceiverListener, DailyCappingListener, IRewardedManager {
    private final String TAG = getClass().getSimpleName();
    private Placement mCurrentPlacement;
    private boolean mIsCurrentlyShowing = false;
    private boolean mIsUltraEventsEnabled = false;
    private ListenersWrapper mListenersWrapper;
    private long mLoadStartTime = new Date().getTime();
    private int mManualLoadInterval;
    private NetworkStateReceiver mNetworkStateReceiver;
    private boolean mPauseSmartLoadDueToNetworkUnavailability = false;
    private boolean mShouldSendMediationLoadSuccessEvent = false;
    private List<AbstractSmash.MEDIATION_STATE> mStatesToIgnore = Arrays.asList(AbstractSmash.MEDIATION_STATE.INIT_FAILED, AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION, AbstractSmash.MEDIATION_STATE.EXHAUSTED, AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY);
    private Timer mTimer = null;

    RewardedVideoManager() {
        this.mDailyCappingManager = new DailyCappingManager("rewarded_video", this);
    }

    public void setRewardedVideoListener(ListenersWrapper listenersWrapper) {
        this.mListenersWrapper = listenersWrapper;
    }

    public synchronized void initRewardedVideo(String str, String str2) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, this.TAG + ":initRewardedVideo(appKey: " + str + ", userId: " + str2 + ")", 1);
        long time = new Date().getTime();
        logMediationEvent(IronSourceConstants.RV_MANAGER_INIT_STARTED);
        this.mAppKey = str;
        this.mUserId = str2;
        Iterator it = this.mSmashArray.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            AbstractSmash abstractSmash = (AbstractSmash) it.next();
            if (this.mDailyCappingManager.shouldSendCapReleasedEvent(abstractSmash)) {
                logProviderEvent(IronSourceConstants.REWARDED_VIDEO_DAILY_CAPPED, abstractSmash, new Object[][]{new Object[]{"status", "false"}});
            }
            if (this.mDailyCappingManager.isCapped(abstractSmash)) {
                abstractSmash.setMediationState(AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY);
                i2++;
            }
        }
        if (i2 == this.mSmashArray.size()) {
            this.mListenersWrapper.onRewardedVideoAvailabilityChanged(false);
            return;
        }
        logMediationEvent(1000);
        this.mListenersWrapper.setRvPlacement(null);
        this.mShouldSendMediationLoadSuccessEvent = true;
        this.mLoadStartTime = new Date().getTime();
        logMediationEvent(IronSourceConstants.RV_MANAGER_INIT_ENDED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(new Date().getTime() - time)}});
        prepareSDK5();
        while (i < this.mSmartLoadAmount && i < this.mSmashArray.size() && loadNextAdapter() != null) {
            i++;
        }
    }

    public synchronized void showRewardedVideo(String str) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, this.TAG + ":showRewardedVideo(placementName: " + str + ")", 1);
        this.mListenersWrapper.setRvPlacement(str);
        logMediationEvent(IronSourceConstants.RV_API_SHOW_CALLED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_PLACEMENT_NAME, str}});
        if (this.mIsCurrentlyShowing) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "showRewardedVideo error: can't show ad while an ad is already showing", 3);
            this.mListenersWrapper.onRewardedVideoAdShowFailed(new IronSourceError(IronSourceError.ERROR_RV_SHOW_CALLED_DURING_SHOW, "showRewardedVideo error: can't show ad while an ad is already showing"));
        } else if (!this.mShouldTrackNetworkState || IronSourceUtils.isNetworkConnected(ContextProvider.getInstance().getCurrentActiveActivity())) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < this.mSmashArray.size(); i++) {
                AbstractSmash abstractSmash = (AbstractSmash) this.mSmashArray.get(i);
                IronSourceLoggerManager ironSourceLoggerManager2 = this.mLoggerManager;
                IronSourceLogger.IronSourceTag ironSourceTag2 = IronSourceLogger.IronSourceTag.INTERNAL;
                ironSourceLoggerManager2.log(ironSourceTag2, "showRewardedVideo, iterating on: " + abstractSmash.getInstanceName() + ", Status: " + abstractSmash.getMediationState(), 0);
                if (abstractSmash.getMediationState() == AbstractSmash.MEDIATION_STATE.AVAILABLE) {
                    if (((RewardedVideoSmash) abstractSmash).isRewardedVideoAvailable()) {
                        showAdapter(abstractSmash, i);
                        if (this.mCanShowPremium && !abstractSmash.equals(getPremiumSmash())) {
                            disablePremiumForCurrentSession();
                        }
                        if (abstractSmash.isCappedPerSession()) {
                            abstractSmash.setMediationState(AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION);
                            logProviderEvent(IronSourceConstants.RV_CAP_SESSION, abstractSmash, null);
                            completeAdapterCap();
                        } else if (this.mDailyCappingManager.isCapped(abstractSmash)) {
                            abstractSmash.setMediationState(AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY);
                            logProviderEvent(IronSourceConstants.REWARDED_VIDEO_DAILY_CAPPED, abstractSmash, new Object[][]{new Object[]{"status", "true"}});
                            completeAdapterCap();
                        } else if (abstractSmash.isExhausted()) {
                            loadNextAdapter();
                            completeIterationRound();
                        }
                        return;
                    }
                    if (abstractSmash.getExpirationTimestamp() != null) {
                        stringBuffer.append(abstractSmash.getInstanceName() + ":" + abstractSmash.getExpirationTimestamp() + ",");
                    }
                    onRewardedVideoAvailabilityChanged(false, (RewardedVideoSmash) abstractSmash);
                    Exception exc = new Exception("FailedToShowVideoException");
                    IronSourceLoggerManager ironSourceLoggerManager3 = this.mLoggerManager;
                    IronSourceLogger.IronSourceTag ironSourceTag3 = IronSourceLogger.IronSourceTag.INTERNAL;
                    ironSourceLoggerManager3.logException(ironSourceTag3, abstractSmash.getInstanceName() + " Failed to show video", exc);
                }
            }
            if (isBackFillAvailable()) {
                showAdapter(getBackfillSmash(), this.mSmashArray.size());
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put(IronSourceConstants.EVENTS_EXT1, stringBuffer.toString());
                this.mListenersWrapper.onRewardedVideoAdShowFailed(ErrorBuilder.buildNoAdsToShowError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT), hashMap);
            }
        } else {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "showRewardedVideo error: can't show ad when there's no internet connection", 3);
            this.mListenersWrapper.onRewardedVideoAdShowFailed(ErrorBuilder.buildNoInternetConnectionShowFailError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
        }
    }

    public synchronized boolean isRewardedVideoAvailable() {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, this.TAG + ":isRewardedVideoAvailable()", 1);
        if (this.mShouldTrackNetworkState && !IronSourceUtils.isNetworkConnected(ContextProvider.getInstance().getCurrentActiveActivity())) {
            return false;
        }
        Iterator it = this.mSmashArray.iterator();
        while (it.hasNext()) {
            AbstractSmash abstractSmash = (AbstractSmash) it.next();
            if (abstractSmash.isMediationAvailable() && ((RewardedVideoSmash) abstractSmash).isRewardedVideoAvailable()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoManagerListener
    public void onRewardedVideoAdShowFailed(IronSourceError ironSourceError, RewardedVideoSmash rewardedVideoSmash) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        ironSourceLoggerManager.log(ironSourceTag, rewardedVideoSmash.getInstanceName() + ":onRewardedVideoAdShowFailed(" + ironSourceError + ")", 1);
        this.mIsCurrentlyShowing = false;
        logProviderEvent(IronSourceConstants.RV_INSTANCE_SHOW_FAILED, rewardedVideoSmash, new Object[][]{new Object[]{IronSourceConstants.EVENTS_PLACEMENT_NAME, getCurrentPlacementName()}, new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}, new Object[]{"sessionDepth", Integer.valueOf(rewardedVideoSmash != null ? rewardedVideoSmash.mSessionDepth : SessionDepthManager.getInstance().getSessionDepth(1))}});
        sendMediationLoadEvents(false);
        this.mListenersWrapper.onRewardedVideoAdShowFailed(ironSourceError);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoManagerListener
    public void onRewardedVideoAdOpened(RewardedVideoSmash rewardedVideoSmash) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        ironSourceLoggerManager.log(ironSourceTag, rewardedVideoSmash.getInstanceName() + ":onRewardedVideoAdOpened()", 1);
        logProviderEvent(1005, rewardedVideoSmash, new Object[][]{new Object[]{IronSourceConstants.EVENTS_PLACEMENT_NAME, getCurrentPlacementName()}, new Object[]{"sessionDepth", Integer.valueOf(rewardedVideoSmash.mSessionDepth)}});
        this.mListenersWrapper.onRewardedVideoAdOpened();
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoManagerListener
    public void onRewardedVideoAdClosed(RewardedVideoSmash rewardedVideoSmash) {
        String str;
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, rewardedVideoSmash.getInstanceName() + ":onRewardedVideoAdClosed()", 1);
        this.mIsCurrentlyShowing = false;
        StringBuilder sb = new StringBuilder();
        try {
            Iterator it = this.mSmashArray.iterator();
            while (it.hasNext()) {
                AbstractSmash abstractSmash = (AbstractSmash) it.next();
                if (((RewardedVideoSmash) abstractSmash).isRewardedVideoAvailable()) {
                    sb.append(abstractSmash.getInstanceName() + ";");
                }
            }
        } catch (Throwable unused) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, "Failed to check RV availability", 0);
        }
        Object[][] objArr = new Object[3][];
        objArr[0] = new Object[]{IronSourceConstants.EVENTS_PLACEMENT_NAME, getCurrentPlacementName()};
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
        objArr[1] = objArr2;
        objArr[2] = new Object[]{"sessionDepth", Integer.valueOf(rewardedVideoSmash.mSessionDepth)};
        logProviderEvent(IronSourceConstants.RV_INSTANCE_CLOSED, rewardedVideoSmash, objArr);
        SessionDepthManager.getInstance().increaseSessionDepth(1);
        if (!rewardedVideoSmash.isCappedPerSession() && !this.mDailyCappingManager.isCapped(rewardedVideoSmash)) {
            logProviderEvent(1001, rewardedVideoSmash, null);
        }
        sendMediationLoadEvents(false);
        this.mListenersWrapper.onRewardedVideoAdClosed();
        startExpirationTimerWithRellevantDelta();
        Iterator it2 = this.mSmashArray.iterator();
        while (it2.hasNext()) {
            AbstractSmash abstractSmash2 = (AbstractSmash) it2.next();
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, "Fetch on ad closed, iterating on: " + abstractSmash2.getInstanceName() + ", Status: " + abstractSmash2.getMediationState(), 0);
            if (abstractSmash2.getMediationState() == AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE || abstractSmash2.getMediationState() == AbstractSmash.MEDIATION_STATE.NEEDS_RELOAD) {
                try {
                    if (!abstractSmash2.getInstanceName().equals(rewardedVideoSmash.getInstanceName())) {
                        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, abstractSmash2.getInstanceName() + ":reload smash", 1);
                        ((RewardedVideoSmash) abstractSmash2).fetchRewardedVideo();
                        logProviderEvent(1001, abstractSmash2, null);
                    }
                } catch (Throwable th) {
                    this.mLoggerManager.log(IronSourceLogger.IronSourceTag.NATIVE, abstractSmash2.getInstanceName() + " Failed to call fetchVideo(), " + th.getLocalizedMessage(), 1);
                }
            }
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoManagerListener
    public synchronized void onRewardedVideoAvailabilityChanged(boolean z, RewardedVideoSmash rewardedVideoSmash) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        ironSourceLoggerManager.log(ironSourceTag, rewardedVideoSmash.getInstanceName() + ": onRewardedVideoAvailabilityChanged(available:" + z + ")", 1);
        if (!this.mPauseSmartLoadDueToNetworkUnavailability) {
            if (z && this.mShouldSendMediationLoadSuccessEvent) {
                this.mShouldSendMediationLoadSuccessEvent = false;
                logMediationEvent(1003, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(new Date().getTime() - this.mLoadStartTime)}});
                startExpirationTimerWithRellevantDelta();
            }
            try {
                if (rewardedVideoSmash.equals(getBackfillSmash())) {
                    if (shouldNotifyAvailabilityChanged(z, false)) {
                        this.mListenersWrapper.onRewardedVideoAvailabilityChanged(this.mLastMediationAvailabilityState.booleanValue());
                    }
                    return;
                }
                if (rewardedVideoSmash.equals(getPremiumSmash())) {
                    IronSourceLoggerManager ironSourceLoggerManager2 = this.mLoggerManager;
                    IronSourceLogger.IronSourceTag ironSourceTag2 = IronSourceLogger.IronSourceTag.INTERNAL;
                    ironSourceLoggerManager2.log(ironSourceTag2, rewardedVideoSmash.getInstanceName() + " is a premium adapter, canShowPremium: " + canShowPremium(), 1);
                    if (!canShowPremium()) {
                        rewardedVideoSmash.setMediationState(AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION);
                        if (shouldNotifyAvailabilityChanged(false, false)) {
                            this.mListenersWrapper.onRewardedVideoAvailabilityChanged(this.mLastMediationAvailabilityState.booleanValue());
                        }
                        return;
                    }
                }
                if (!this.mDailyCappingManager.isCapped(rewardedVideoSmash)) {
                    if (!z || !rewardedVideoSmash.isMediationAvailable()) {
                        if (shouldNotifyAvailabilityChanged(false, false)) {
                            notifyAvailabilityChange(null);
                        }
                        loadNextAdapter();
                        completeIterationRound();
                    } else if (shouldNotifyAvailabilityChanged(true, false)) {
                        this.mListenersWrapper.onRewardedVideoAvailabilityChanged(this.mLastMediationAvailabilityState.booleanValue());
                    }
                }
            } catch (Throwable th) {
                IronSourceLoggerManager ironSourceLoggerManager3 = this.mLoggerManager;
                IronSourceLogger.IronSourceTag ironSourceTag3 = IronSourceLogger.IronSourceTag.INTERNAL;
                ironSourceLoggerManager3.logException(ironSourceTag3, "onRewardedVideoAvailabilityChanged(available:" + z + ", provider:" + rewardedVideoSmash.getName() + ")", th);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoManagerListener
    public void onRewardedVideoAdStarted(RewardedVideoSmash rewardedVideoSmash) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        ironSourceLoggerManager.log(ironSourceTag, rewardedVideoSmash.getInstanceName() + ":onRewardedVideoAdStarted()", 1);
        logProviderEvent(IronSourceConstants.RV_INSTANCE_STARTED, rewardedVideoSmash, new Object[][]{new Object[]{IronSourceConstants.EVENTS_PLACEMENT_NAME, getCurrentPlacementName()}, new Object[]{"sessionDepth", Integer.valueOf(rewardedVideoSmash.mSessionDepth)}});
        this.mListenersWrapper.onRewardedVideoAdStarted();
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoManagerListener
    public void onRewardedVideoAdEnded(RewardedVideoSmash rewardedVideoSmash) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        ironSourceLoggerManager.log(ironSourceTag, rewardedVideoSmash.getInstanceName() + ":onRewardedVideoAdEnded()", 1);
        logProviderEvent(IronSourceConstants.RV_INSTANCE_ENDED, rewardedVideoSmash, new Object[][]{new Object[]{IronSourceConstants.EVENTS_PLACEMENT_NAME, getCurrentPlacementName()}, new Object[]{"sessionDepth", Integer.valueOf(rewardedVideoSmash.mSessionDepth)}});
        this.mListenersWrapper.onRewardedVideoAdEnded();
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoManagerListener
    public void onRewardedVideoAdRewarded(RewardedVideoSmash rewardedVideoSmash) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        ironSourceLoggerManager.log(ironSourceTag, rewardedVideoSmash.getInstanceName() + ":onRewardedVideoAdRewarded()", 1);
        if (this.mCurrentPlacement == null) {
            this.mCurrentPlacement = IronSourceObject.getInstance().getCurrentServerResponse().getConfigurations().getRewardedVideoConfigurations().getDefaultRewardedVideoPlacement();
        }
        JSONObject providerAdditionalData = IronSourceUtils.getProviderAdditionalData(rewardedVideoSmash);
        try {
            providerAdditionalData.put("sessionDepth", rewardedVideoSmash.mSessionDepth);
            if (this.mCurrentPlacement != null) {
                providerAdditionalData.put(IronSourceConstants.EVENTS_PLACEMENT_NAME, getCurrentPlacementName());
                providerAdditionalData.put(IronSourceConstants.EVENTS_REWARD_NAME, this.mCurrentPlacement.getRewardName());
                providerAdditionalData.put(IronSourceConstants.EVENTS_REWARD_AMOUNT, this.mCurrentPlacement.getRewardAmount());
            } else {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, "mCurrentPlacement is null", 3);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        EventData eventData = new EventData(1010, providerAdditionalData);
        if (!TextUtils.isEmpty(this.mAppKey)) {
            eventData.addToAdditionalData(IronSourceConstants.EVENTS_TRANS_ID, IronSourceUtils.getTransId("" + Long.toString(eventData.getTimeStamp()) + this.mAppKey + rewardedVideoSmash.getName()));
            if (!TextUtils.isEmpty(IronSourceObject.getInstance().getDynamicUserId())) {
                eventData.addToAdditionalData(IronSourceConstants.EVENTS_DYNAMIC_USER_ID, IronSourceObject.getInstance().getDynamicUserId());
            }
            Map<String, String> rvServerParams = IronSourceObject.getInstance().getRvServerParams();
            if (rvServerParams != null) {
                for (String str : rvServerParams.keySet()) {
                    eventData.addToAdditionalData("custom_" + str, rvServerParams.get(str));
                }
            }
        }
        RewardedVideoEventsManager.getInstance().log(eventData);
        Placement placement = this.mCurrentPlacement;
        if (placement != null) {
            this.mListenersWrapper.onRewardedVideoAdRewarded(placement);
        } else {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, "mCurrentPlacement is null", 3);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoManagerListener
    public void onRewardedVideoAdClicked(RewardedVideoSmash rewardedVideoSmash) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        ironSourceLoggerManager.log(ironSourceTag, rewardedVideoSmash.getInstanceName() + ":onRewardedVideoAdClicked()", 1);
        if (this.mCurrentPlacement == null) {
            this.mCurrentPlacement = IronSourceObject.getInstance().getCurrentServerResponse().getConfigurations().getRewardedVideoConfigurations().getDefaultRewardedVideoPlacement();
        }
        if (this.mCurrentPlacement == null) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, "mCurrentPlacement is null", 3);
            return;
        }
        logProviderEvent(1006, rewardedVideoSmash, new Object[][]{new Object[]{IronSourceConstants.EVENTS_PLACEMENT_NAME, getCurrentPlacementName()}, new Object[]{"sessionDepth", Integer.valueOf(rewardedVideoSmash.mSessionDepth)}});
        this.mListenersWrapper.onRewardedVideoAdClicked(this.mCurrentPlacement);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoManagerListener
    public void onRewardedVideoAdVisible(RewardedVideoSmash rewardedVideoSmash) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        ironSourceLoggerManager.log(ironSourceTag, rewardedVideoSmash.getInstanceName() + ":onRewardedVideoAdVisible()", 1);
        if (this.mCurrentPlacement != null) {
            logProviderEvent(IronSourceConstants.RV_INSTANCE_VISIBLE, rewardedVideoSmash, new Object[][]{new Object[]{IronSourceConstants.EVENTS_PLACEMENT_NAME, getCurrentPlacementName()}, new Object[]{"sessionDepth", Integer.valueOf(rewardedVideoSmash.mSessionDepth)}});
            return;
        }
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, "mCurrentPlacement is null", 3);
    }

    @Override // com.ironsource.environment.NetworkStateReceiverListener
    public void onNetworkAvailabilityChanged(boolean z) {
        if (this.mShouldTrackNetworkState) {
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            ironSourceLoggerManager.log(ironSourceTag, "Network Availability Changed To: " + z, 0);
            if (shouldNotifyNetworkAvailabilityChanged(z)) {
                this.mPauseSmartLoadDueToNetworkUnavailability = !z;
                this.mListenersWrapper.onRewardedVideoAvailabilityChanged(z);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.ironsource.mediationsdk.AbstractAdUnitManager
    public void shouldTrackNetworkState(Context context, boolean z) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        ironSourceLoggerManager.log(ironSourceTag, this.TAG + " Should Track Network State: " + z, 0);
        this.mShouldTrackNetworkState = z;
        if (this.mShouldTrackNetworkState) {
            if (this.mNetworkStateReceiver == null) {
                this.mNetworkStateReceiver = new NetworkStateReceiver(context, this);
            }
            context.getApplicationContext().registerReceiver(this.mNetworkStateReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } else if (this.mNetworkStateReceiver != null) {
            context.getApplicationContext().unregisterReceiver(this.mNetworkStateReceiver);
        }
    }

    private boolean shouldNotifyNetworkAvailabilityChanged(boolean z) {
        if (this.mLastMediationAvailabilityState == null) {
            return false;
        }
        if (z && !this.mLastMediationAvailabilityState.booleanValue() && hasAvailableSmash()) {
            this.mLastMediationAvailabilityState = true;
        } else if (z || !this.mLastMediationAvailabilityState.booleanValue()) {
            return false;
        } else {
            this.mLastMediationAvailabilityState = false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void setIsUltraEventsEnabled(boolean z) {
        this.mIsUltraEventsEnabled = z;
    }

    private void reportFalseImpressionsOnHigherPriority(int i, int i2) {
        int i3 = 0;
        while (i3 < i && i3 < this.mSmashArray.size()) {
            if (!this.mStatesToIgnore.contains(((AbstractSmash) this.mSmashArray.get(i3)).getMediationState())) {
                reportImpression(((RewardedVideoSmash) this.mSmashArray.get(i3)).getRequestUrl(), false, i2);
            }
            i3++;
        }
    }

    private synchronized void reportImpression(String str, boolean z, int i) {
        String str2 = "";
        try {
            str2 = (str2 + str) + "&sdkVersion=" + IronSourceUtils.getSDKVersion();
            Server.callAsyncRequestURL(str2, z, i);
        } catch (Throwable th) {
            this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.NETWORK, "reportImpression:(providerURL:" + str2 + ", hit:" + z + ")", th);
        }
    }

    /* access modifiers changed from: package-private */
    public void setCurrentPlacement(Placement placement) {
        this.mCurrentPlacement = placement;
        this.mListenersWrapper.setRvPlacement(placement.getPlacementName());
    }

    /* access modifiers changed from: protected */
    @Override // com.ironsource.mediationsdk.AbstractAdUnitManager
    public synchronized void disablePremiumForCurrentSession() {
        super.disablePremiumForCurrentSession();
        Iterator it = this.mSmashArray.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AbstractSmash abstractSmash = (AbstractSmash) it.next();
            if (abstractSmash.equals(getPremiumSmash())) {
                abstractSmash.setMediationState(AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION);
                loadNextAdapter();
                break;
            }
        }
    }

    private synchronized AbstractAdapter startAdapter(RewardedVideoSmash rewardedVideoSmash) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
        ironSourceLoggerManager.log(ironSourceTag, this.TAG + ":startAdapter(" + rewardedVideoSmash.getInstanceName() + ")", 1);
        AbstractAdapter adapter = AdapterRepository.getInstance().getAdapter(rewardedVideoSmash.mAdapterConfigs, rewardedVideoSmash.mAdapterConfigs.getRewardedVideoSettings());
        if (adapter == null) {
            IronSourceLoggerManager ironSourceLoggerManager2 = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag2 = IronSourceLogger.IronSourceTag.API;
            ironSourceLoggerManager2.log(ironSourceTag2, rewardedVideoSmash.getInstanceName() + " is configured in IronSource's platform, but the adapter is not integrated", 2);
            return null;
        }
        rewardedVideoSmash.setAdapterForSmash(adapter);
        rewardedVideoSmash.setMediationState(AbstractSmash.MEDIATION_STATE.INITIATED);
        setCustomParams(rewardedVideoSmash);
        logProviderEvent(1001, rewardedVideoSmash, null);
        try {
            rewardedVideoSmash.initRewardedVideo(this.mAppKey, this.mUserId);
            return adapter;
        } catch (Throwable th) {
            IronSourceLoggerManager ironSourceLoggerManager3 = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag3 = IronSourceLogger.IronSourceTag.API;
            ironSourceLoggerManager3.logException(ironSourceTag3, this.TAG + "failed to init adapter: " + rewardedVideoSmash.getName() + "v", th);
            rewardedVideoSmash.setMediationState(AbstractSmash.MEDIATION_STATE.INIT_FAILED);
            return null;
        }
    }

    private AbstractAdapter loadNextAdapter() {
        AbstractAdapter abstractAdapter = null;
        int i = 0;
        for (int i2 = 0; i2 < this.mSmashArray.size() && abstractAdapter == null; i2++) {
            if (((AbstractSmash) this.mSmashArray.get(i2)).getMediationState() == AbstractSmash.MEDIATION_STATE.AVAILABLE || ((AbstractSmash) this.mSmashArray.get(i2)).getMediationState() == AbstractSmash.MEDIATION_STATE.INITIATED) {
                i++;
                if (i >= this.mSmartLoadAmount) {
                    break;
                }
            } else if (((AbstractSmash) this.mSmashArray.get(i2)).getMediationState() == AbstractSmash.MEDIATION_STATE.NOT_INITIATED && (abstractAdapter = startAdapter((RewardedVideoSmash) this.mSmashArray.get(i2))) == null) {
                ((AbstractSmash) this.mSmashArray.get(i2)).setMediationState(AbstractSmash.MEDIATION_STATE.INIT_FAILED);
            }
        }
        return abstractAdapter;
    }

    private synchronized void showAdapter(AbstractSmash abstractSmash, int i) {
        Object[][] objArr;
        CappingManager.incrementShowCounter(ContextProvider.getInstance().getCurrentActiveActivity(), this.mCurrentPlacement);
        if (CappingManager.isRvPlacementCapped(ContextProvider.getInstance().getCurrentActiveActivity(), getCurrentPlacementName())) {
            logMediationEvent(IronSourceConstants.RV_CAP_PLACEMENT, new Object[][]{new Object[]{IronSourceConstants.EVENTS_PLACEMENT_NAME, getCurrentPlacementName()}});
        }
        this.mDailyCappingManager.increaseShowCounter(abstractSmash);
        if (this.mCurrentPlacement != null) {
            if (this.mIsUltraEventsEnabled) {
                reportImpression(((RewardedVideoSmash) abstractSmash).getRequestUrl(), true, this.mCurrentPlacement.getPlacementId());
                reportFalseImpressionsOnHigherPriority(i, this.mCurrentPlacement.getPlacementId());
            }
            sendShowChanceEvents(abstractSmash, i, getCurrentPlacementName());
        } else {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, "mCurrentPlacement is null", 3);
        }
        if (this.mCurrentPlacement != null) {
            objArr = new Object[][]{new Object[]{IronSourceConstants.EVENTS_PLACEMENT_NAME, getCurrentPlacementName()}};
        } else {
            objArr = null;
        }
        logProviderEvent(IronSourceConstants.RV_INSTANCE_SHOW, abstractSmash, objArr);
        this.mIsCurrentlyShowing = true;
        ExpiredRvAdsManager.getInstance().cancelExpirationScheduler();
        ((RewardedVideoSmash) abstractSmash).mSessionDepth = SessionDepthManager.getInstance().getSessionDepth(1);
        ((RewardedVideoSmash) abstractSmash).showRewardedVideo();
    }

    /* access modifiers changed from: package-private */
    public void setManualLoadInterval(int i) {
        this.mManualLoadInterval = i;
    }

    public void setExpiredDurationInMinutes(int i) {
        ExpiredRvAdsManager.getInstance().initialize(this, i);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void scheduleFetchTimer() {
        if (this.mManualLoadInterval <= 0) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, "load interval is not set, ignoring", 1);
            return;
        }
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
        }
        Timer timer2 = new Timer();
        this.mTimer = timer2;
        timer2.schedule(new TimerTask() {
            /* class com.ironsource.mediationsdk.RewardedVideoManager.AnonymousClass1 */

            public void run() {
                cancel();
                RewardedVideoManager.this.loadRewardedVideoForTimer();
                RewardedVideoManager.this.scheduleFetchTimer();
            }
        }, (long) (this.mManualLoadInterval * 1000));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void loadRewardedVideoForTimer() {
        if (IronSourceUtils.isNetworkConnected(ContextProvider.getInstance().getCurrentActiveActivity())) {
            if (this.mLastMediationAvailabilityState != null) {
                if (!this.mLastMediationAvailabilityState.booleanValue()) {
                    logMediationEvent(102);
                    logMediationEvent(1000);
                    this.mShouldSendMediationLoadSuccessEvent = true;
                    Iterator it = this.mSmashArray.iterator();
                    while (it.hasNext()) {
                        AbstractSmash abstractSmash = (AbstractSmash) it.next();
                        if (abstractSmash.getMediationState() == AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE) {
                            try {
                                IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
                                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
                                ironSourceLoggerManager.log(ironSourceTag, "Fetch from timer: " + abstractSmash.getInstanceName() + ":reload smash", 1);
                                logProviderEvent(1001, abstractSmash, null);
                                ((RewardedVideoSmash) abstractSmash).fetchRewardedVideo();
                            } catch (Throwable th) {
                                IronSourceLoggerManager ironSourceLoggerManager2 = this.mLoggerManager;
                                IronSourceLogger.IronSourceTag ironSourceTag2 = IronSourceLogger.IronSourceTag.NATIVE;
                                ironSourceLoggerManager2.log(ironSourceTag2, abstractSmash.getInstanceName() + " Failed to call fetchVideo(), " + th.getLocalizedMessage(), 1);
                            }
                        }
                    }
                }
            }
        }
    }

    private synchronized boolean shouldNotifyAvailabilityChanged(boolean z, boolean z2) {
        boolean z3;
        z3 = false;
        if (this.mLastMediationAvailabilityState == null) {
            scheduleFetchTimer();
            if (z) {
                this.mLastMediationAvailabilityState = true;
            } else if (!isBackFillAvailable() && isAllAdaptersInactive()) {
                this.mLastMediationAvailabilityState = false;
            }
        } else if (z && !this.mLastMediationAvailabilityState.booleanValue()) {
            this.mLastMediationAvailabilityState = true;
        } else if (!z && this.mLastMediationAvailabilityState.booleanValue() && ((!hasAvailableSmash() || z2) && !isBackFillAvailable())) {
            this.mLastMediationAvailabilityState = false;
        }
        z3 = true;
        return z3;
    }

    private synchronized boolean isAllAdaptersInactive() {
        boolean z;
        Iterator it = this.mSmashArray.iterator();
        z = false;
        int i = 0;
        while (it.hasNext()) {
            AbstractSmash abstractSmash = (AbstractSmash) it.next();
            if (abstractSmash.getMediationState() == AbstractSmash.MEDIATION_STATE.INIT_FAILED || abstractSmash.getMediationState() == AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY || abstractSmash.getMediationState() == AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION || abstractSmash.getMediationState() == AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE || abstractSmash.getMediationState() == AbstractSmash.MEDIATION_STATE.NEEDS_RELOAD || abstractSmash.getMediationState() == AbstractSmash.MEDIATION_STATE.EXHAUSTED) {
                i++;
            }
        }
        if (this.mSmashArray.size() == i) {
            z = true;
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x000d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean isAvailableAdaptersToLoad() {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.concurrent.CopyOnWriteArrayList r0 = r4.mSmashArray     // Catch:{ all -> 0x0049 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0049 }
        L_0x0007:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0049 }
            if (r1 == 0) goto L_0x0046
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0049 }
            com.ironsource.mediationsdk.AbstractSmash r1 = (com.ironsource.mediationsdk.AbstractSmash) r1     // Catch:{ all -> 0x0049 }
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r2 = r1.getMediationState()     // Catch:{ all -> 0x0049 }
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r3 = com.ironsource.mediationsdk.AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE     // Catch:{ all -> 0x0049 }
            if (r2 == r3) goto L_0x0043
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r2 = r1.getMediationState()     // Catch:{ all -> 0x0049 }
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r3 = com.ironsource.mediationsdk.AbstractSmash.MEDIATION_STATE.NEEDS_RELOAD     // Catch:{ all -> 0x0049 }
            if (r2 == r3) goto L_0x0043
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r2 = r1.getMediationState()     // Catch:{ all -> 0x0049 }
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r3 = com.ironsource.mediationsdk.AbstractSmash.MEDIATION_STATE.AVAILABLE     // Catch:{ all -> 0x0049 }
            if (r2 == r3) goto L_0x0043
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r2 = r1.getMediationState()     // Catch:{ all -> 0x0049 }
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r3 = com.ironsource.mediationsdk.AbstractSmash.MEDIATION_STATE.INITIATED     // Catch:{ all -> 0x0049 }
            if (r2 == r3) goto L_0x0043
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r2 = r1.getMediationState()     // Catch:{ all -> 0x0049 }
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r3 = com.ironsource.mediationsdk.AbstractSmash.MEDIATION_STATE.INIT_PENDING     // Catch:{ all -> 0x0049 }
            if (r2 == r3) goto L_0x0043
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r1 = r1.getMediationState()     // Catch:{ all -> 0x0049 }
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r2 = com.ironsource.mediationsdk.AbstractSmash.MEDIATION_STATE.LOAD_PENDING     // Catch:{ all -> 0x0049 }
            if (r1 != r2) goto L_0x0007
        L_0x0043:
            r0 = 1
            monitor-exit(r4)
            return r0
        L_0x0046:
            r0 = 0
            monitor-exit(r4)
            return r0
        L_0x0049:
            r0 = move-exception
            monitor-exit(r4)
            goto L_0x004d
        L_0x004c:
            throw r0
        L_0x004d:
            goto L_0x004c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.RewardedVideoManager.isAvailableAdaptersToLoad():boolean");
    }

    private synchronized boolean hasAvailableSmash() {
        boolean z;
        z = false;
        Iterator it = this.mSmashArray.iterator();
        while (true) {
            if (it.hasNext()) {
                if (((AbstractSmash) it.next()).getMediationState() == AbstractSmash.MEDIATION_STATE.AVAILABLE) {
                    z = true;
                    break;
                }
            } else {
                break;
            }
        }
        return z;
    }

    private synchronized boolean isBackFillAvailable() {
        if (getBackfillSmash() == null) {
            return false;
        }
        return ((RewardedVideoSmash) getBackfillSmash()).isRewardedVideoAvailable();
    }

    private void sendShowChanceEvents(AbstractSmash abstractSmash, int i, String str) {
        logProviderEvent(IronSourceConstants.RV_INSTANCE_SHOW_CHANCE, abstractSmash, new Object[][]{new Object[]{IronSourceConstants.EVENTS_PLACEMENT_NAME, str}, new Object[]{"status", "true"}});
        int i2 = 0;
        while (i2 < this.mSmashArray.size() && i2 < i) {
            AbstractSmash abstractSmash2 = (AbstractSmash) this.mSmashArray.get(i2);
            if (abstractSmash2.getMediationState() == AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE || abstractSmash2.getMediationState() == AbstractSmash.MEDIATION_STATE.NEEDS_RELOAD) {
                logProviderEvent(IronSourceConstants.RV_INSTANCE_SHOW_CHANCE, abstractSmash2, new Object[][]{new Object[]{IronSourceConstants.EVENTS_PLACEMENT_NAME, str}, new Object[]{"status", "false"}});
            }
            i2++;
        }
    }

    private synchronized void notifyAvailabilityChange(Map<String, Object> map) {
        if (getBackfillSmash() != null && !this.mBackFillInitStarted) {
            this.mBackFillInitStarted = true;
            if (startAdapter((RewardedVideoSmash) getBackfillSmash()) == null) {
                this.mListenersWrapper.onRewardedVideoAvailabilityChanged(this.mLastMediationAvailabilityState.booleanValue());
            }
        } else if (!isBackFillAvailable()) {
            this.mListenersWrapper.onRewardedVideoAvailabilityChanged(this.mLastMediationAvailabilityState.booleanValue(), map);
        } else if (shouldNotifyAvailabilityChanged(true, false)) {
            this.mListenersWrapper.onRewardedVideoAvailabilityChanged(this.mLastMediationAvailabilityState.booleanValue());
        }
    }

    private synchronized void completeAdapterCap() {
        if (loadNextAdapter() == null) {
            if (smashesCount(AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE, AbstractSmash.MEDIATION_STATE.NEEDS_RELOAD, AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION, AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY) < this.mSmashArray.size()) {
                completeIterationRound();
                return;
            }
            if (shouldNotifyAvailabilityChanged(false, false)) {
                notifyAvailabilityChange(null);
            }
        }
    }

    private synchronized void completeIterationRound() {
        if (isIterationRoundComplete()) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, "Reset Iteration", 0);
            Iterator it = this.mSmashArray.iterator();
            boolean z = false;
            while (it.hasNext()) {
                AbstractSmash abstractSmash = (AbstractSmash) it.next();
                if (abstractSmash.getMediationState() == AbstractSmash.MEDIATION_STATE.EXHAUSTED) {
                    abstractSmash.completeIteration();
                }
                if (abstractSmash.getMediationState() == AbstractSmash.MEDIATION_STATE.AVAILABLE) {
                    z = true;
                }
            }
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, "End of Reset Iteration", 0);
            if (shouldNotifyAvailabilityChanged(z, false)) {
                this.mListenersWrapper.onRewardedVideoAvailabilityChanged(this.mLastMediationAvailabilityState.booleanValue());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x000d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean isIterationRoundComplete() {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.concurrent.CopyOnWriteArrayList r0 = r4.mSmashArray     // Catch:{ all -> 0x0031 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0031 }
        L_0x0007:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0031 }
            if (r1 == 0) goto L_0x002e
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0031 }
            com.ironsource.mediationsdk.AbstractSmash r1 = (com.ironsource.mediationsdk.AbstractSmash) r1     // Catch:{ all -> 0x0031 }
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r2 = r1.getMediationState()     // Catch:{ all -> 0x0031 }
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r3 = com.ironsource.mediationsdk.AbstractSmash.MEDIATION_STATE.NOT_INITIATED     // Catch:{ all -> 0x0031 }
            if (r2 == r3) goto L_0x002b
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r2 = r1.getMediationState()     // Catch:{ all -> 0x0031 }
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r3 = com.ironsource.mediationsdk.AbstractSmash.MEDIATION_STATE.INITIATED     // Catch:{ all -> 0x0031 }
            if (r2 == r3) goto L_0x002b
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r1 = r1.getMediationState()     // Catch:{ all -> 0x0031 }
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r2 = com.ironsource.mediationsdk.AbstractSmash.MEDIATION_STATE.AVAILABLE     // Catch:{ all -> 0x0031 }
            if (r1 != r2) goto L_0x0007
        L_0x002b:
            r0 = 0
            monitor-exit(r4)
            return r0
        L_0x002e:
            r0 = 1
            monitor-exit(r4)
            return r0
        L_0x0031:
            r0 = move-exception
            monitor-exit(r4)
            goto L_0x0035
        L_0x0034:
            throw r0
        L_0x0035:
            goto L_0x0034
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.RewardedVideoManager.isIterationRoundComplete():boolean");
    }

    private void logMediationEvent(int i) {
        logMediationEvent(i, null);
    }

    private void logMediationEvent(int i, Object[][] objArr) {
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    mediationAdditionalData.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, "RewardedVideoManager logMediationEvent " + Log.getStackTraceString(e), 3);
            }
        }
        RewardedVideoEventsManager.getInstance().log(new EventData(i, mediationAdditionalData));
    }

    private void logProviderEvent(int i, AbstractSmash abstractSmash, Object[][] objArr) {
        JSONObject providerAdditionalData = IronSourceUtils.getProviderAdditionalData(abstractSmash);
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    providerAdditionalData.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, "RewardedVideoManager logProviderEvent " + Log.getStackTraceString(e), 3);
            }
        }
        RewardedVideoEventsManager.getInstance().log(new EventData(i, providerAdditionalData));
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

    private void sendMediationLoadEvents(boolean z) {
        if (!z && isRewardedVideoAvailable()) {
            logMediationEvent(1000);
            logMediationEvent(1003, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, 0}});
            this.mShouldSendMediationLoadSuccessEvent = false;
        } else if (isAvailableAdaptersToLoad()) {
            logMediationEvent(1000);
            this.mShouldSendMediationLoadSuccessEvent = true;
            this.mLoadStartTime = new Date().getTime();
        }
    }

    @Override // com.ironsource.mediationsdk.utils.DailyCappingListener
    public void onDailyCapReleased() {
        Iterator it = this.mSmashArray.iterator();
        boolean z = false;
        while (it.hasNext()) {
            AbstractSmash abstractSmash = (AbstractSmash) it.next();
            if (abstractSmash.getMediationState() == AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY) {
                logProviderEvent(IronSourceConstants.REWARDED_VIDEO_DAILY_CAPPED, abstractSmash, new Object[][]{new Object[]{"status", "false"}});
                abstractSmash.setMediationState(AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE);
                if (((RewardedVideoSmash) abstractSmash).isRewardedVideoAvailable() && abstractSmash.isMediationAvailable()) {
                    abstractSmash.setMediationState(AbstractSmash.MEDIATION_STATE.AVAILABLE);
                    z = true;
                }
            }
        }
        if (z && shouldNotifyAvailabilityChanged(true, false)) {
            this.mListenersWrapper.onRewardedVideoAvailabilityChanged(true);
        }
    }

    private void prepareSDK5() {
        for (int i = 0; i < this.mSmashArray.size(); i++) {
            String providerTypeForReflection = ((AbstractSmash) this.mSmashArray.get(i)).mAdapterConfigs.getProviderTypeForReflection();
            if (providerTypeForReflection.equalsIgnoreCase(IronSourceConstants.IRONSOURCE_CONFIG_NAME) || providerTypeForReflection.equalsIgnoreCase(IronSourceConstants.SUPERSONIC_CONFIG_NAME)) {
                AdapterRepository.getInstance().getAdapter(((AbstractSmash) this.mSmashArray.get(i)).mAdapterConfigs, ((AbstractSmash) this.mSmashArray.get(i)).mAdapterConfigs.getRewardedVideoSettings());
                return;
            }
        }
    }

    private String getCurrentPlacementName() {
        Placement placement = this.mCurrentPlacement;
        if (placement == null) {
            return "";
        }
        return placement.getPlacementName();
    }

    @Override // com.ironsource.mediationsdk.IRewardedManager
    public void reloadRewardedVideos() {
        if (!IronSourceUtils.isNetworkConnected(ContextProvider.getInstance().getApplicationContext()) || this.mLastMediationAvailabilityState == null) {
            IronLog.INTERNAL.info("while reloading mediation due to expiration, internet loss occurred");
            logMediationEvent(IronSourceConstants.TROUBLESHOOTING_RV_TRADITIONAL_RELOAD_FAILED_INTERNET_LOSS);
            return;
        }
        if (shouldNotifyAvailabilityChanged(false, true)) {
            notifyAvailabilityChange(IronsourceMapUtilities.createMap(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf((int) IronSourceError.ERROR_RV_EXPIRED_ADS)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "loaded ads are expired"}}));
        }
        sendMediationLoadEvents(true);
        Iterator it = this.mSmashArray.iterator();
        while (it.hasNext()) {
            AbstractSmash abstractSmash = (AbstractSmash) it.next();
            if (abstractSmash.getMediationState() == AbstractSmash.MEDIATION_STATE.AVAILABLE || abstractSmash.getMediationState() == AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE) {
                abstractSmash.setMediationState(AbstractSmash.MEDIATION_STATE.NEEDS_RELOAD);
            }
        }
        Iterator it2 = this.mSmashArray.iterator();
        while (it2.hasNext()) {
            AbstractSmash abstractSmash2 = (AbstractSmash) it2.next();
            if (abstractSmash2.getMediationState() == AbstractSmash.MEDIATION_STATE.NEEDS_RELOAD) {
                try {
                    IronLog ironLog = IronLog.INTERNAL;
                    ironLog.info(abstractSmash2.getInstanceName() + ":reload smash");
                    logProviderEvent(1001, abstractSmash2, null);
                    ((RewardedVideoSmash) abstractSmash2).fetchRewardedVideo();
                } catch (Throwable th) {
                    IronLog ironLog2 = IronLog.INTERNAL;
                    ironLog2.error(abstractSmash2.getInstanceName() + " Failed to call fetchVideo(), " + th.getLocalizedMessage());
                }
            }
        }
    }

    private void startExpirationTimerWithRellevantDelta() {
        Iterator it = this.mSmashArray.iterator();
        long j = Long.MAX_VALUE;
        while (it.hasNext()) {
            AbstractSmash abstractSmash = (AbstractSmash) it.next();
            if (abstractSmash.getMediationState() == AbstractSmash.MEDIATION_STATE.AVAILABLE && abstractSmash.getAdLoadSuccessTimeStamp() != null && abstractSmash.getAdLoadSuccessTimeStamp().longValue() < j) {
                j = abstractSmash.getAdLoadSuccessTimeStamp().longValue();
            }
        }
        if (j != Long.MAX_VALUE) {
            ExpiredRvAdsManager.getInstance().startExpirationTimerForAds(System.currentTimeMillis() - j);
        }
    }
}
