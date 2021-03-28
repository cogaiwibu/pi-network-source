package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.DemandOnlySmash;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.AdapterConfig;
import com.ironsource.mediationsdk.model.ProviderSettings;
import com.ironsource.mediationsdk.sdk.DemandOnlyIsManagerListener;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;
import org.json.JSONObject;

public class DemandOnlyIsSmash extends DemandOnlySmash implements InterstitialSmashListener {
    private DemandOnlyIsManagerListener mListener;
    private long mLoadStartTime;

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdShowSucceeded() {
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialInitFailed(IronSourceError ironSourceError) {
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialInitSuccess() {
    }

    public DemandOnlyIsSmash(String str, String str2, ProviderSettings providerSettings, DemandOnlyIsManagerListener demandOnlyIsManagerListener, int i, AbstractAdapter abstractAdapter) {
        super(new AdapterConfig(providerSettings, providerSettings.getInterstitialSettings()), abstractAdapter);
        this.mListener = demandOnlyIsManagerListener;
        this.mLoadTimeoutSecs = i;
        this.mAdapter.initInterstitial(str, str2, this.mAdUnitSettings, this);
    }

    public void loadInterstitial(String str, String str2, JSONObject jSONObject, List<String> list) {
        logInternal("loadInterstitial state=" + getStateString());
        DemandOnlySmash.SMASH_STATE compareAndSetState = compareAndSetState(new DemandOnlySmash.SMASH_STATE[]{DemandOnlySmash.SMASH_STATE.NOT_LOADED, DemandOnlySmash.SMASH_STATE.LOADED}, DemandOnlySmash.SMASH_STATE.LOAD_IN_PROGRESS);
        if (compareAndSetState == DemandOnlySmash.SMASH_STATE.NOT_LOADED || compareAndSetState == DemandOnlySmash.SMASH_STATE.LOADED) {
            this.mLoadStartTime = new Date().getTime();
            startLoadTimer();
            if (isBidder()) {
                this.mAuctionId = str2;
                this.mGenericParams = jSONObject;
                this.mBUrl = list;
                this.mAdapter.loadInterstitialForBidding(this.mAdUnitSettings, this, str);
                return;
            }
            this.mAdapter.loadInterstitial(this.mAdUnitSettings, this);
        } else if (compareAndSetState == DemandOnlySmash.SMASH_STATE.LOAD_IN_PROGRESS) {
            this.mListener.onInterstitialAdLoadFailed(new IronSourceError(IronSourceError.ERROR_DO_IS_LOAD_ALREADY_IN_PROGRESS, "load already in progress"), this, 0);
        } else {
            this.mListener.onInterstitialAdLoadFailed(new IronSourceError(IronSourceError.ERROR_DO_IS_LOAD_ALREADY_IN_PROGRESS, "cannot load because show is in progress"), this, 0);
        }
    }

    public void showInterstitial() {
        logInternal("showInterstitial state=" + getStateString());
        if (compareAndSetState(DemandOnlySmash.SMASH_STATE.LOADED, DemandOnlySmash.SMASH_STATE.SHOW_IN_PROGRESS)) {
            this.mAdapter.showInterstitial(this.mAdUnitSettings, this);
            return;
        }
        this.mListener.onInterstitialAdShowFailed(new IronSourceError(IronSourceError.ERROR_DO_IS_CALL_LOAD_BEFORE_SHOW, "load must be called before show"), this);
    }

    public boolean isInterstitialReady() {
        return this.mAdapter.isInterstitialReady(this.mAdUnitSettings);
    }

    private void startLoadTimer() {
        logInternal("start timer");
        startTimer(new TimerTask() {
            /* class com.ironsource.mediationsdk.DemandOnlyIsSmash.AnonymousClass1 */

            public void run() {
                DemandOnlyIsSmash demandOnlyIsSmash = DemandOnlyIsSmash.this;
                demandOnlyIsSmash.logInternal("load timed out state=" + DemandOnlyIsSmash.this.getStateString());
                if (DemandOnlyIsSmash.this.compareAndSetState(DemandOnlySmash.SMASH_STATE.LOAD_IN_PROGRESS, DemandOnlySmash.SMASH_STATE.NOT_LOADED)) {
                    DemandOnlyIsSmash.this.mListener.onInterstitialAdLoadFailed(new IronSourceError(IronSourceError.ERROR_DO_IS_LOAD_TIMED_OUT, "load timed out"), DemandOnlyIsSmash.this, new Date().getTime() - DemandOnlyIsSmash.this.mLoadStartTime);
                }
            }
        });
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdReady() {
        logAdapterCallback("onInterstitialAdReady state=" + getStateString());
        stopTimer();
        if (compareAndSetState(DemandOnlySmash.SMASH_STATE.LOAD_IN_PROGRESS, DemandOnlySmash.SMASH_STATE.LOADED)) {
            this.mListener.onInterstitialAdReady(this, new Date().getTime() - this.mLoadStartTime);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdLoadFailed(IronSourceError ironSourceError) {
        logAdapterCallback("onInterstitialAdLoadFailed error=" + ironSourceError.getErrorMessage() + " state=" + getStateString());
        stopTimer();
        if (compareAndSetState(DemandOnlySmash.SMASH_STATE.LOAD_IN_PROGRESS, DemandOnlySmash.SMASH_STATE.NOT_LOADED)) {
            this.mListener.onInterstitialAdLoadFailed(ironSourceError, this, new Date().getTime() - this.mLoadStartTime);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdOpened() {
        logAdapterCallback("onInterstitialAdOpened");
        this.mListener.onInterstitialAdOpened(this);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdClosed() {
        setState(DemandOnlySmash.SMASH_STATE.NOT_LOADED);
        logAdapterCallback("onInterstitialAdClosed");
        this.mListener.onInterstitialAdClosed(this);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdShowFailed(IronSourceError ironSourceError) {
        setState(DemandOnlySmash.SMASH_STATE.NOT_LOADED);
        logAdapterCallback("onInterstitialAdShowFailed error=" + ironSourceError.getErrorMessage());
        this.mListener.onInterstitialAdShowFailed(ironSourceError, this);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdClicked() {
        logAdapterCallback("onInterstitialAdClicked");
        this.mListener.onInterstitialAdClicked(this);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdVisible() {
        logAdapterCallback("onInterstitialAdVisible");
        this.mListener.onInterstitialAdVisible(this);
    }

    private void logAdapterCallback(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "DemandOnlyInterstitialSmash " + this.mAdapterConfig.getProviderName() + " : " + str, 0);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void logInternal(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "DemandOnlyInterstitialSmash " + this.mAdapterConfig.getProviderName() + " : " + str, 0);
    }
}
