package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.DemandOnlySmash;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.AdapterConfig;
import com.ironsource.mediationsdk.model.ProviderSettings;
import com.ironsource.mediationsdk.sdk.DemandOnlyRvManagerListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;
import org.json.JSONObject;

public class DemandOnlyRvSmash extends DemandOnlySmash implements RewardedVideoSmashListener {
    private DemandOnlyRvManagerListener mListener;
    private long mLoadStartTime;

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdEnded() {
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdStarted() {
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAvailabilityChanged(boolean z) {
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoInitFailed(IronSourceError ironSourceError) {
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoInitSuccess() {
    }

    DemandOnlyRvSmash(String str, String str2, ProviderSettings providerSettings, DemandOnlyRvManagerListener demandOnlyRvManagerListener, int i, AbstractAdapter abstractAdapter) {
        super(new AdapterConfig(providerSettings, providerSettings.getInterstitialSettings()), abstractAdapter);
        this.mAdapterConfig = new AdapterConfig(providerSettings, providerSettings.getRewardedVideoSettings());
        this.mAdUnitSettings = this.mAdapterConfig.getAdUnitSetings();
        this.mAdapter = abstractAdapter;
        this.mListener = demandOnlyRvManagerListener;
        this.mLoadTimeoutSecs = i;
        this.mAdapter.initRewardedVideoForDemandOnly(str, str2, this.mAdUnitSettings, this);
    }

    public void loadRewardedVideo(String str, String str2, JSONObject jSONObject, List<String> list) {
        logInternal("loadRewardedVideo state=" + getStateString());
        DemandOnlySmash.SMASH_STATE compareAndSetState = compareAndSetState(new DemandOnlySmash.SMASH_STATE[]{DemandOnlySmash.SMASH_STATE.NOT_LOADED, DemandOnlySmash.SMASH_STATE.LOADED}, DemandOnlySmash.SMASH_STATE.LOAD_IN_PROGRESS);
        if (compareAndSetState == DemandOnlySmash.SMASH_STATE.NOT_LOADED || compareAndSetState == DemandOnlySmash.SMASH_STATE.LOADED) {
            this.mLoadStartTime = new Date().getTime();
            startLoadTimer();
            if (isBidder()) {
                this.mAuctionId = str2;
                this.mGenericParams = jSONObject;
                this.mBUrl = list;
                this.mAdapter.loadRewardedVideoForDemandOnlyForBidding(this.mAdUnitSettings, this, str);
                return;
            }
            this.mAdapter.loadRewardedVideoForDemandOnly(this.mAdUnitSettings, this);
        } else if (compareAndSetState == DemandOnlySmash.SMASH_STATE.LOAD_IN_PROGRESS) {
            this.mListener.onRewardedVideoAdLoadFailed(new IronSourceError(IronSourceError.ERROR_DO_RV_LOAD_ALREADY_IN_PROGRESS, "load already in progress"), this, 0);
        } else {
            this.mListener.onRewardedVideoAdLoadFailed(new IronSourceError(IronSourceError.ERROR_DO_RV_LOAD_DURING_SHOW, "cannot load because show is in progress"), this, 0);
        }
    }

    public void showRewardedVideo() {
        logInternal("showRewardedVideo state=" + getStateString());
        if (compareAndSetState(DemandOnlySmash.SMASH_STATE.LOADED, DemandOnlySmash.SMASH_STATE.SHOW_IN_PROGRESS)) {
            this.mAdapter.showRewardedVideo(this.mAdUnitSettings, this);
            return;
        }
        this.mListener.onRewardedVideoAdShowFailed(new IronSourceError(IronSourceError.ERROR_DO_RV_CALL_LOAD_BEFORE_SHOW, "load must be called before show"), this);
    }

    public boolean isRewardedVideoAvailable() {
        return this.mAdapter.isRewardedVideoAvailable(this.mAdUnitSettings);
    }

    private void startLoadTimer() {
        logInternal("start timer");
        startTimer(new TimerTask() {
            /* class com.ironsource.mediationsdk.DemandOnlyRvSmash.AnonymousClass1 */

            public void run() {
                DemandOnlyRvSmash demandOnlyRvSmash = DemandOnlyRvSmash.this;
                demandOnlyRvSmash.logInternal("load timed out state=" + DemandOnlyRvSmash.this.getStateString());
                if (DemandOnlyRvSmash.this.compareAndSetState(DemandOnlySmash.SMASH_STATE.LOAD_IN_PROGRESS, DemandOnlySmash.SMASH_STATE.NOT_LOADED)) {
                    DemandOnlyRvSmash.this.mListener.onRewardedVideoAdLoadFailed(new IronSourceError(IronSourceError.ERROR_DO_RV_LOAD_TIMED_OUT, "load timed out"), DemandOnlyRvSmash.this, new Date().getTime() - DemandOnlyRvSmash.this.mLoadStartTime);
                }
            }
        });
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoLoadSuccess() {
        logAdapterCallback("onRewardedVideoLoadSuccess state=" + getStateString());
        stopTimer();
        if (compareAndSetState(DemandOnlySmash.SMASH_STATE.LOAD_IN_PROGRESS, DemandOnlySmash.SMASH_STATE.LOADED)) {
            this.mListener.onRewardedVideoLoadSuccess(this, new Date().getTime() - this.mLoadStartTime);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoLoadFailed(IronSourceError ironSourceError) {
        logAdapterCallback("onRewardedVideoLoadFailed error=" + ironSourceError.getErrorMessage() + " state=" + getStateString());
        stopTimer();
        if (compareAndSetState(DemandOnlySmash.SMASH_STATE.LOAD_IN_PROGRESS, DemandOnlySmash.SMASH_STATE.NOT_LOADED)) {
            this.mListener.onRewardedVideoAdLoadFailed(ironSourceError, this, new Date().getTime() - this.mLoadStartTime);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdOpened() {
        logAdapterCallback("onRewardedVideoAdOpened");
        this.mListener.onRewardedVideoAdOpened(this);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdClosed() {
        setState(DemandOnlySmash.SMASH_STATE.NOT_LOADED);
        logAdapterCallback("onRewardedVideoAdClosed");
        this.mListener.onRewardedVideoAdClosed(this);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdShowFailed(IronSourceError ironSourceError) {
        setState(DemandOnlySmash.SMASH_STATE.NOT_LOADED);
        logAdapterCallback("onRewardedVideoAdClosed error=" + ironSourceError);
        this.mListener.onRewardedVideoAdShowFailed(ironSourceError, this);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdClicked() {
        logAdapterCallback("onRewardedVideoAdClicked");
        this.mListener.onRewardedVideoAdClicked(this);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdVisible() {
        logAdapterCallback("onRewardedVideoAdVisible");
        this.mListener.onRewardedVideoAdVisible(this);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdRewarded() {
        logAdapterCallback("onRewardedVideoAdRewarded");
        this.mListener.onRewardedVideoAdRewarded(this);
    }

    private void logAdapterCallback(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "DemandOnlyRewardedVideoSmash " + this.mAdapterConfig.getProviderName() + " : " + str, 0);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void logInternal(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "DemandOnlyRewardedVideoSmash " + this.mAdapterConfig.getProviderName() + " : " + str, 0);
    }
}
