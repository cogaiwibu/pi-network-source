package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.AbstractSmash;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.ProviderSettings;
import com.ironsource.mediationsdk.sdk.InterstitialManagerListener;
import com.ironsource.mediationsdk.sdk.InterstitialSmashApi;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

public class InterstitialSmash extends AbstractSmash implements InterstitialSmashListener, InterstitialSmashApi {
    private JSONObject mInterstitialAdapterConfigs;
    private InterstitialManagerListener mInterstitialManagerListener;
    private long mLoadStartTime;
    private int mTimeout;

    /* access modifiers changed from: protected */
    @Override // com.ironsource.mediationsdk.AbstractSmash
    public String getAdUnitString() {
        return IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE;
    }

    InterstitialSmash(ProviderSettings providerSettings, int i) {
        super(providerSettings);
        JSONObject interstitialSettings = providerSettings.getInterstitialSettings();
        this.mInterstitialAdapterConfigs = interstitialSettings;
        this.mMaxAdsPerIteration = interstitialSettings.optInt("maxAdsPerIteration", 99);
        this.mMaxAdsPerSession = this.mInterstitialAdapterConfigs.optInt("maxAdsPerSession", 99);
        this.mMaxAdsPerDay = this.mInterstitialAdapterConfigs.optInt("maxAdsPerDay", 99);
        this.mIsMultipleInstances = providerSettings.isMultipleInstances();
        this.mSpId = providerSettings.getSubProviderId();
        this.mTimeout = i;
    }

    /* access modifiers changed from: package-private */
    @Override // com.ironsource.mediationsdk.AbstractSmash
    public void completeIteration() {
        this.mIterationShowCounter = 0;
        setMediationState(AbstractSmash.MEDIATION_STATE.INITIATED);
    }

    /* access modifiers changed from: package-private */
    @Override // com.ironsource.mediationsdk.AbstractSmash
    public void startInitTimer() {
        try {
            stopInitTimer();
            this.mInitTimer = new Timer();
            this.mInitTimer.schedule(new TimerTask() {
                /* class com.ironsource.mediationsdk.InterstitialSmash.AnonymousClass1 */

                public void run() {
                    cancel();
                    if (InterstitialSmash.this.mMediationState == AbstractSmash.MEDIATION_STATE.INIT_PENDING && InterstitialSmash.this.mInterstitialManagerListener != null) {
                        InterstitialSmash.this.setMediationState(AbstractSmash.MEDIATION_STATE.INIT_FAILED);
                        InterstitialSmash.this.mInterstitialManagerListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("Timeout", "Interstitial"), InterstitialSmash.this);
                    }
                }
            }, (long) (this.mTimeout * 1000));
        } catch (Exception e) {
            logException("startInitTimer", e.getLocalizedMessage());
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.ironsource.mediationsdk.AbstractSmash
    public void startLoadTimer() {
        try {
            stopLoadTimer();
            this.mLoadTimer = new Timer();
            this.mLoadTimer.schedule(new TimerTask() {
                /* class com.ironsource.mediationsdk.InterstitialSmash.AnonymousClass2 */

                public void run() {
                    cancel();
                    if (InterstitialSmash.this.mMediationState == AbstractSmash.MEDIATION_STATE.LOAD_PENDING && InterstitialSmash.this.mInterstitialManagerListener != null) {
                        InterstitialSmash.this.setMediationState(AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE);
                        InterstitialSmash.this.mInterstitialManagerListener.onInterstitialAdLoadFailed(ErrorBuilder.buildLoadFailedError("Timeout"), InterstitialSmash.this, new Date().getTime() - InterstitialSmash.this.mLoadStartTime);
                    }
                }
            }, (long) (this.mTimeout * 1000));
        } catch (Exception e) {
            logException("startLoadTimer", e.getLocalizedMessage());
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashApi
    public void initInterstitial(String str, String str2) {
        startInitTimer();
        if (this.mAdapter != null) {
            this.mAdapter.addInterstitialListener(this);
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_API;
            ironSourceLoggerManager.log(ironSourceTag, getInstanceName() + ":initInterstitial()", 1);
            this.mAdapter.initInterstitial(str, str2, this.mInterstitialAdapterConfigs, this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashApi
    public void loadInterstitial() {
        startLoadTimer();
        if (this.mAdapter != null) {
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_API;
            ironSourceLoggerManager.log(ironSourceTag, getInstanceName() + ":loadInterstitial()", 1);
            this.mLoadStartTime = new Date().getTime();
            this.mAdapter.loadInterstitial(this.mInterstitialAdapterConfigs, this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashApi
    public void showInterstitial() {
        if (this.mAdapter != null) {
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_API;
            ironSourceLoggerManager.log(ironSourceTag, getInstanceName() + ":showInterstitial()", 1);
            preShow();
            this.mAdapter.showInterstitial(this.mInterstitialAdapterConfigs, this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashApi
    public boolean isInterstitialReady() {
        if (this.mAdapter == null) {
            return false;
        }
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_API;
        ironSourceLoggerManager.log(ironSourceTag, getInstanceName() + ":isInterstitialReady()", 1);
        return this.mAdapter.isInterstitialReady(this.mInterstitialAdapterConfigs);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashApi
    public void setInterstitialManagerListener(InterstitialManagerListener interstitialManagerListener) {
        this.mInterstitialManagerListener = interstitialManagerListener;
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialInitSuccess() {
        stopInitTimer();
        if (this.mMediationState == AbstractSmash.MEDIATION_STATE.INIT_PENDING) {
            setMediationState(AbstractSmash.MEDIATION_STATE.INITIATED);
            InterstitialManagerListener interstitialManagerListener = this.mInterstitialManagerListener;
            if (interstitialManagerListener != null) {
                interstitialManagerListener.onInterstitialInitSuccess(this);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialInitFailed(IronSourceError ironSourceError) {
        stopInitTimer();
        if (this.mMediationState == AbstractSmash.MEDIATION_STATE.INIT_PENDING) {
            setMediationState(AbstractSmash.MEDIATION_STATE.INIT_FAILED);
            InterstitialManagerListener interstitialManagerListener = this.mInterstitialManagerListener;
            if (interstitialManagerListener != null) {
                interstitialManagerListener.onInterstitialInitFailed(ironSourceError, this);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdReady() {
        stopLoadTimer();
        if (this.mMediationState == AbstractSmash.MEDIATION_STATE.LOAD_PENDING && this.mInterstitialManagerListener != null) {
            this.mInterstitialManagerListener.onInterstitialAdReady(this, new Date().getTime() - this.mLoadStartTime);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdLoadFailed(IronSourceError ironSourceError) {
        stopLoadTimer();
        if (this.mMediationState == AbstractSmash.MEDIATION_STATE.LOAD_PENDING && this.mInterstitialManagerListener != null) {
            this.mInterstitialManagerListener.onInterstitialAdLoadFailed(ironSourceError, this, new Date().getTime() - this.mLoadStartTime);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdOpened() {
        InterstitialManagerListener interstitialManagerListener = this.mInterstitialManagerListener;
        if (interstitialManagerListener != null) {
            interstitialManagerListener.onInterstitialAdOpened(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdClosed() {
        InterstitialManagerListener interstitialManagerListener = this.mInterstitialManagerListener;
        if (interstitialManagerListener != null) {
            interstitialManagerListener.onInterstitialAdClosed(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdShowSucceeded() {
        InterstitialManagerListener interstitialManagerListener = this.mInterstitialManagerListener;
        if (interstitialManagerListener != null) {
            interstitialManagerListener.onInterstitialAdShowSucceeded(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdShowFailed(IronSourceError ironSourceError) {
        InterstitialManagerListener interstitialManagerListener = this.mInterstitialManagerListener;
        if (interstitialManagerListener != null) {
            interstitialManagerListener.onInterstitialAdShowFailed(ironSourceError, this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdClicked() {
        InterstitialManagerListener interstitialManagerListener = this.mInterstitialManagerListener;
        if (interstitialManagerListener != null) {
            interstitialManagerListener.onInterstitialAdClicked(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdVisible() {
        InterstitialManagerListener interstitialManagerListener = this.mInterstitialManagerListener;
        if (interstitialManagerListener != null) {
            interstitialManagerListener.onInterstitialAdVisible(this);
        }
    }
}
