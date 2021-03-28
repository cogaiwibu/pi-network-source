package com.ironsource.mediationsdk;

import android.util.Log;
import com.ironsource.eventsmodule.EventData;
import com.ironsource.mediationsdk.AbstractSmash;
import com.ironsource.mediationsdk.events.RewardedVideoEventsManager;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.ProviderSettings;
import com.ironsource.mediationsdk.sdk.RewardedVideoManagerListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashApi;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class RewardedVideoSmash extends AbstractSmash implements RewardedVideoSmashListener, RewardedVideoSmashApi {
    private final String REQUEST_URL_KEY = IronSourceConstants.REQUEST_URL;
    private long mLoadStartTime;
    private String mRequestUrl;
    private JSONObject mRewardedVideoAdapterConfigs;
    private RewardedVideoManagerListener mRewardedVideoManagerListener;
    public int mSessionDepth;
    private AtomicBoolean mShouldSendLoadEvents;
    private int mTimeout;

    /* access modifiers changed from: protected */
    @Override // com.ironsource.mediationsdk.AbstractSmash
    public String getAdUnitString() {
        return IronSourceConstants.AD_UNIT_RV_MEDIATION_STATE;
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoInitFailed(IronSourceError ironSourceError) {
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoInitSuccess() {
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoLoadSuccess() {
    }

    /* access modifiers changed from: package-private */
    @Override // com.ironsource.mediationsdk.AbstractSmash
    public void startLoadTimer() {
    }

    RewardedVideoSmash(ProviderSettings providerSettings, int i) {
        super(providerSettings);
        JSONObject rewardedVideoSettings = providerSettings.getRewardedVideoSettings();
        this.mRewardedVideoAdapterConfigs = rewardedVideoSettings;
        this.mMaxAdsPerIteration = rewardedVideoSettings.optInt("maxAdsPerIteration", 99);
        this.mMaxAdsPerSession = this.mRewardedVideoAdapterConfigs.optInt("maxAdsPerSession", 99);
        this.mMaxAdsPerDay = this.mRewardedVideoAdapterConfigs.optInt("maxAdsPerDay", 99);
        this.mRequestUrl = this.mRewardedVideoAdapterConfigs.optString(IronSourceConstants.REQUEST_URL);
        this.mShouldSendLoadEvents = new AtomicBoolean(false);
        this.mTimeout = i;
    }

    /* access modifiers changed from: package-private */
    @Override // com.ironsource.mediationsdk.AbstractSmash
    public void completeIteration() {
        this.mIterationShowCounter = 0;
        setMediationState(isRewardedVideoAvailable() ? AbstractSmash.MEDIATION_STATE.AVAILABLE : AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE);
    }

    /* access modifiers changed from: package-private */
    @Override // com.ironsource.mediationsdk.AbstractSmash
    public void startInitTimer() {
        try {
            stopInitTimer();
            this.mInitTimer = new Timer();
            this.mInitTimer.schedule(new TimerTask() {
                /* class com.ironsource.mediationsdk.RewardedVideoSmash.AnonymousClass1 */

                public void run() {
                    synchronized (RewardedVideoSmash.this) {
                        cancel();
                        if (RewardedVideoSmash.this.mRewardedVideoManagerListener != null) {
                            String str = "Timeout for " + RewardedVideoSmash.this.getInstanceName();
                            RewardedVideoSmash.this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, str, 0);
                            RewardedVideoSmash.this.setMediationState(AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE);
                            long time = new Date().getTime() - RewardedVideoSmash.this.mLoadStartTime;
                            if (RewardedVideoSmash.this.mShouldSendLoadEvents.compareAndSet(true, false)) {
                                RewardedVideoSmash.this.sendProviderEvent(IronSourceConstants.RV_INSTANCE_LOAD_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1025}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(time)}});
                                RewardedVideoSmash.this.sendProviderEvent(IronSourceConstants.RV_INSTANCE_LOAD_FAILED_REASON, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1025}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, str}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(time)}});
                            } else {
                                RewardedVideoSmash.this.sendProviderEvent(IronSourceConstants.RV_INSTANCE_AVAILABILITY_FALSE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1025}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(time)}});
                            }
                            RewardedVideoSmash.this.mRewardedVideoManagerListener.onRewardedVideoAvailabilityChanged(false, RewardedVideoSmash.this);
                        }
                    }
                }
            }, (long) (this.mTimeout * 1000));
        } catch (Exception e) {
            logException("startInitTimer", e.getLocalizedMessage());
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashApi
    public void initRewardedVideo(String str, String str2) {
        startInitTimer();
        if (this.mAdapter != null) {
            this.mShouldSendLoadEvents.set(true);
            this.mLoadStartTime = new Date().getTime();
            this.mAdapter.addRewardedVideoListener(this);
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            ironSourceLoggerManager.log(ironSourceTag, getInstanceName() + ":initRewardedVideo()", 1);
            this.mAdapter.initRewardedVideo(str, str2, this.mRewardedVideoAdapterConfigs, this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashApi
    public void fetchRewardedVideo() {
        this.expirationTimestamp = null;
        if (this.mAdapter != null) {
            if (!(getMediationState() == AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY || getMediationState() == AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION)) {
                this.mShouldSendLoadEvents.set(true);
                this.mLoadStartTime = new Date().getTime();
            }
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            ironSourceLoggerManager.log(ironSourceTag, getInstanceName() + ":fetchRewardedVideoForAutomaticLoad()", 1);
            this.mAdapter.fetchRewardedVideoForAutomaticLoad(this.mRewardedVideoAdapterConfigs, this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashApi
    public void showRewardedVideo() {
        if (this.mAdapter != null) {
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            ironSourceLoggerManager.log(ironSourceTag, getInstanceName() + ":showRewardedVideo()", 1);
            preShow();
            this.mAdapter.showRewardedVideo(this.mRewardedVideoAdapterConfigs, this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashApi
    public boolean isRewardedVideoAvailable() {
        if (this.mAdapter == null) {
            return false;
        }
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        ironSourceLoggerManager.log(ironSourceTag, getInstanceName() + ":isRewardedVideoAvailable()", 1);
        return this.mAdapter.isRewardedVideoAvailable(this.mRewardedVideoAdapterConfigs);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashApi
    public void setRewardedVideoManagerListener(RewardedVideoManagerListener rewardedVideoManagerListener) {
        this.mRewardedVideoManagerListener = rewardedVideoManagerListener;
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdShowFailed(IronSourceError ironSourceError) {
        RewardedVideoManagerListener rewardedVideoManagerListener = this.mRewardedVideoManagerListener;
        if (rewardedVideoManagerListener != null) {
            rewardedVideoManagerListener.onRewardedVideoAdShowFailed(ironSourceError, this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdOpened() {
        RewardedVideoManagerListener rewardedVideoManagerListener = this.mRewardedVideoManagerListener;
        if (rewardedVideoManagerListener != null) {
            rewardedVideoManagerListener.onRewardedVideoAdOpened(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdClosed() {
        RewardedVideoManagerListener rewardedVideoManagerListener = this.mRewardedVideoManagerListener;
        if (rewardedVideoManagerListener != null) {
            rewardedVideoManagerListener.onRewardedVideoAdClosed(this);
        }
        fetchRewardedVideo();
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public synchronized void onRewardedVideoAvailabilityChanged(boolean z) {
        stopInitTimer();
        if (this.mShouldSendLoadEvents.compareAndSet(true, false)) {
            sendProviderEvent(z ? 1002 : IronSourceConstants.RV_INSTANCE_LOAD_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(new Date().getTime() - this.mLoadStartTime)}});
        } else {
            sendProviderEvent(z ? IronSourceConstants.RV_INSTANCE_AVAILABILITY_TRUE : IronSourceConstants.RV_INSTANCE_AVAILABILITY_FALSE);
        }
        if (!isMediationAvailable()) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.info(this.mInstanceName + ": is capped or exhausted");
        } else if ((!z || this.mMediationState == AbstractSmash.MEDIATION_STATE.AVAILABLE) && (z || this.mMediationState == AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE)) {
            IronLog ironLog2 = IronLog.INTERNAL;
            ironLog2.info(this.mInstanceName + ": state remains " + z + " in smash, mediation remains unchanged");
        } else {
            setMediationState(z ? AbstractSmash.MEDIATION_STATE.AVAILABLE : AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE);
            if (z) {
                this.adLoadSuccessTimeStamp = Long.valueOf(System.currentTimeMillis());
            }
            if (this.mRewardedVideoManagerListener != null) {
                this.mRewardedVideoManagerListener.onRewardedVideoAvailabilityChanged(z, this);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdStarted() {
        RewardedVideoManagerListener rewardedVideoManagerListener = this.mRewardedVideoManagerListener;
        if (rewardedVideoManagerListener != null) {
            rewardedVideoManagerListener.onRewardedVideoAdStarted(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdEnded() {
        RewardedVideoManagerListener rewardedVideoManagerListener = this.mRewardedVideoManagerListener;
        if (rewardedVideoManagerListener != null) {
            rewardedVideoManagerListener.onRewardedVideoAdEnded(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdRewarded() {
        RewardedVideoManagerListener rewardedVideoManagerListener = this.mRewardedVideoManagerListener;
        if (rewardedVideoManagerListener != null) {
            rewardedVideoManagerListener.onRewardedVideoAdRewarded(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdClicked() {
        RewardedVideoManagerListener rewardedVideoManagerListener = this.mRewardedVideoManagerListener;
        if (rewardedVideoManagerListener != null) {
            rewardedVideoManagerListener.onRewardedVideoAdClicked(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdVisible() {
        RewardedVideoManagerListener rewardedVideoManagerListener = this.mRewardedVideoManagerListener;
        if (rewardedVideoManagerListener != null) {
            rewardedVideoManagerListener.onRewardedVideoAdVisible(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoLoadFailed(IronSourceError ironSourceError) {
        long time = new Date().getTime() - this.mLoadStartTime;
        if (ironSourceError.getErrorCode() == 1058) {
            sendProviderEvent(IronSourceConstants.RV_INSTANCE_LOAD_NO_FILL, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(time)}});
            return;
        }
        if (ironSourceError.getErrorCode() == 1057) {
            this.expirationTimestamp = Long.valueOf(System.currentTimeMillis());
        }
        sendProviderEvent(IronSourceConstants.RV_INSTANCE_LOAD_FAILED_REASON, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(time)}});
    }

    private void sendProviderEvent(int i) {
        sendProviderEvent(i, null);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void sendProviderEvent(int i, Object[][] objArr) {
        JSONObject providerAdditionalData = IronSourceUtils.getProviderAdditionalData(this);
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    providerAdditionalData.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, "RewardedVideoSmash logProviderEvent " + Log.getStackTraceString(e), 3);
            }
        }
        RewardedVideoEventsManager.getInstance().log(new EventData(i, providerAdditionalData));
    }

    /* access modifiers changed from: package-private */
    public String getRequestUrl() {
        return this.mRequestUrl;
    }
}
