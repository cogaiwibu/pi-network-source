package com.ironsource.mediationsdk;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.ProviderSettings;
import com.ironsource.mediationsdk.sdk.BannerManagerListener;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.sdk.constants.Constants;
import java.util.Timer;
import java.util.TimerTask;

public class BannerSmash implements BannerSmashListener {
    private AbstractAdapter mAdapter;
    private ProviderSettings mAdapterConfigs;
    private IronSourceBannerLayout mBannerLayout;
    private boolean mIsReadyToLoad;
    private BannerManagerListener mListener;
    private long mLoadTimeoutMilisecs;
    private int mProviderPriority;
    private BANNER_SMASH_STATE mState = BANNER_SMASH_STATE.NO_INIT;
    private Timer mTimer;

    /* access modifiers changed from: protected */
    public enum BANNER_SMASH_STATE {
        NO_INIT,
        INIT_IN_PROGRESS,
        LOAD_IN_PROGRESS,
        LOADED,
        LOAD_FAILED,
        DESTROYED
    }

    BannerSmash(BannerManagerListener bannerManagerListener, ProviderSettings providerSettings, AbstractAdapter abstractAdapter, long j, int i) {
        this.mProviderPriority = i;
        this.mListener = bannerManagerListener;
        this.mAdapter = abstractAdapter;
        this.mAdapterConfigs = providerSettings;
        this.mLoadTimeoutMilisecs = j;
        abstractAdapter.addBannerListener(this);
    }

    public boolean isReadyToLoad() {
        return this.mIsReadyToLoad;
    }

    public void setReadyToLoad(boolean z) {
        this.mIsReadyToLoad = z;
    }

    public int getProviderPriority() {
        return this.mProviderPriority;
    }

    public String getName() {
        if (this.mAdapterConfigs.isMultipleInstances()) {
            return this.mAdapterConfigs.getProviderTypeForReflection();
        }
        return this.mAdapterConfigs.getProviderName();
    }

    public String getAdSourceNameForEvents() {
        if (!TextUtils.isEmpty(this.mAdapterConfigs.getAdSourceNameForEvents())) {
            return this.mAdapterConfigs.getAdSourceNameForEvents();
        }
        return getName();
    }

    public String getSubProviderId() {
        return this.mAdapterConfigs.getSubProviderId();
    }

    public AbstractAdapter getAdapter() {
        return this.mAdapter;
    }

    public void loadBanner(IronSourceBannerLayout ironSourceBannerLayout, String str, String str2) {
        log(Constants.JSMethods.LOAD_BANNER);
        this.mIsReadyToLoad = false;
        if (ironSourceBannerLayout == null || ironSourceBannerLayout.isDestroyed()) {
            log("loadBanner - bannerLayout is null or destroyed");
            this.mListener.onBannerAdLoadFailed(new IronSourceError(IronSourceError.ERROR_BN_INSTANCE_LOAD_EMPTY_BANNER, ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed"), this, false);
        } else if (this.mAdapter == null) {
            log("loadBanner - mAdapter is null");
            this.mListener.onBannerAdLoadFailed(new IronSourceError(IronSourceError.ERROR_BN_INSTANCE_LOAD_EMPTY_ADAPTER, "adapter==null"), this, false);
        } else {
            this.mBannerLayout = ironSourceBannerLayout;
            startLoadTimer();
            if (this.mState == BANNER_SMASH_STATE.NO_INIT) {
                setState(BANNER_SMASH_STATE.INIT_IN_PROGRESS);
                setCustomParams();
                this.mAdapter.initBanners(str, str2, this.mAdapterConfigs.getBannerSettings(), this);
                return;
            }
            setState(BANNER_SMASH_STATE.LOAD_IN_PROGRESS);
            this.mAdapter.loadBanner(ironSourceBannerLayout, this.mAdapterConfigs.getBannerSettings(), this);
        }
    }

    public void reloadBanner() {
        log("reloadBanner()");
        IronSourceBannerLayout ironSourceBannerLayout = this.mBannerLayout;
        if (ironSourceBannerLayout == null || ironSourceBannerLayout.isDestroyed()) {
            this.mListener.onBannerAdLoadFailed(new IronSourceError(IronSourceError.ERROR_BN_INSTANCE_LOAD_EMPTY_BANNER, this.mBannerLayout == null ? "banner is null" : "banner is destroyed"), this, false);
            return;
        }
        startLoadTimer();
        setState(BANNER_SMASH_STATE.LOADED);
        this.mAdapter.reloadBanner(this.mBannerLayout, this.mAdapterConfigs.getBannerSettings(), this);
    }

    public void destroyBanner() {
        log("destroyBanner()");
        AbstractAdapter abstractAdapter = this.mAdapter;
        if (abstractAdapter == null) {
            log("destroyBanner() mAdapter == null");
            return;
        }
        abstractAdapter.destroyBanner(this.mAdapterConfigs.getBannerSettings());
        setState(BANNER_SMASH_STATE.DESTROYED);
    }

    private void setCustomParams() {
        if (this.mAdapter != null) {
            try {
                String mediationSegment = IronSourceObject.getInstance().getMediationSegment();
                if (!TextUtils.isEmpty(mediationSegment)) {
                    this.mAdapter.setMediationSegment(mediationSegment);
                }
                String pluginType = ConfigFile.getConfigFile().getPluginType();
                if (!TextUtils.isEmpty(pluginType)) {
                    this.mAdapter.setPluginData(pluginType, ConfigFile.getConfigFile().getPluginFrameworkVersion());
                }
            } catch (Exception e) {
                log(":setCustomParams():" + e.toString());
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setState(BANNER_SMASH_STATE banner_smash_state) {
        this.mState = banner_smash_state;
        log("state=" + banner_smash_state.name());
    }

    private void stopLoadTimer() {
        try {
            if (this.mTimer != null) {
                this.mTimer.cancel();
            }
        } catch (Exception e) {
            logException("stopLoadTimer", e.getLocalizedMessage());
        } catch (Throwable th) {
            this.mTimer = null;
            throw th;
        }
        this.mTimer = null;
    }

    private void startLoadTimer() {
        try {
            stopLoadTimer();
            Timer timer = new Timer();
            this.mTimer = timer;
            timer.schedule(new TimerTask() {
                /* class com.ironsource.mediationsdk.BannerSmash.AnonymousClass1 */

                public void run() {
                    cancel();
                    if (BannerSmash.this.mState == BANNER_SMASH_STATE.INIT_IN_PROGRESS) {
                        BannerSmash.this.setState(BANNER_SMASH_STATE.NO_INIT);
                        BannerSmash.this.log("init timed out");
                        BannerSmash.this.mListener.onBannerAdLoadFailed(new IronSourceError(IronSourceError.ERROR_BN_INSTANCE_INIT_TIMEOUT, "Timed out"), BannerSmash.this, false);
                    } else if (BannerSmash.this.mState == BANNER_SMASH_STATE.LOAD_IN_PROGRESS) {
                        BannerSmash.this.setState(BANNER_SMASH_STATE.LOAD_FAILED);
                        BannerSmash.this.log("load timed out");
                        BannerSmash.this.mListener.onBannerAdLoadFailed(new IronSourceError(IronSourceError.ERROR_BN_INSTANCE_LOAD_TIMEOUT, "Timed out"), BannerSmash.this, false);
                    } else if (BannerSmash.this.mState == BANNER_SMASH_STATE.LOADED) {
                        BannerSmash.this.setState(BANNER_SMASH_STATE.LOAD_FAILED);
                        BannerSmash.this.log("reload timed out");
                        BannerSmash.this.mListener.onBannerAdReloadFailed(new IronSourceError(IronSourceError.ERROR_BN_INSTANCE_RELOAD_TIMEOUT, "Timed out"), BannerSmash.this, false);
                    }
                }
            }, this.mLoadTimeoutMilisecs);
        } catch (Exception e) {
            logException("startLoadTimer", e.getLocalizedMessage());
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerInitSuccess() {
        stopLoadTimer();
        if (this.mState == BANNER_SMASH_STATE.INIT_IN_PROGRESS) {
            IronSourceBannerLayout ironSourceBannerLayout = this.mBannerLayout;
            if (ironSourceBannerLayout == null || ironSourceBannerLayout.isDestroyed()) {
                this.mListener.onBannerAdLoadFailed(new IronSourceError(IronSourceError.ERROR_BN_LOAD_EXCEPTION, this.mBannerLayout == null ? "banner is null" : "banner is destroyed"), this, false);
                return;
            }
            startLoadTimer();
            setState(BANNER_SMASH_STATE.LOAD_IN_PROGRESS);
            this.mAdapter.loadBanner(this.mBannerLayout, this.mAdapterConfigs.getBannerSettings(), this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerInitFailed(IronSourceError ironSourceError) {
        stopLoadTimer();
        if (this.mState == BANNER_SMASH_STATE.INIT_IN_PROGRESS) {
            this.mListener.onBannerAdLoadFailed(new IronSourceError(IronSourceError.ERROR_BN_INSTANCE_INIT_ERROR, "Banner init failed"), this, false);
            setState(BANNER_SMASH_STATE.NO_INIT);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdLoaded(View view, FrameLayout.LayoutParams layoutParams) {
        log("onBannerAdLoaded()");
        stopLoadTimer();
        if (this.mState == BANNER_SMASH_STATE.LOAD_IN_PROGRESS) {
            setState(BANNER_SMASH_STATE.LOADED);
            this.mListener.onBannerAdLoaded(this, view, layoutParams);
        } else if (this.mState == BANNER_SMASH_STATE.LOADED) {
            this.mListener.onBannerAdReloaded(this, view, layoutParams, this.mAdapter.shouldBindBannerViewOnReload());
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdLoadFailed(IronSourceError ironSourceError) {
        log("onBannerAdLoadFailed()");
        stopLoadTimer();
        boolean z = ironSourceError.getErrorCode() == 606;
        if (this.mState == BANNER_SMASH_STATE.LOAD_IN_PROGRESS) {
            setState(BANNER_SMASH_STATE.LOAD_FAILED);
            this.mListener.onBannerAdLoadFailed(ironSourceError, this, z);
        } else if (this.mState == BANNER_SMASH_STATE.LOADED) {
            this.mListener.onBannerAdReloadFailed(ironSourceError, this, z);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdClicked() {
        BannerManagerListener bannerManagerListener = this.mListener;
        if (bannerManagerListener != null) {
            bannerManagerListener.onBannerAdClicked(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdScreenPresented() {
        BannerManagerListener bannerManagerListener = this.mListener;
        if (bannerManagerListener != null) {
            bannerManagerListener.onBannerAdScreenPresented(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdScreenDismissed() {
        BannerManagerListener bannerManagerListener = this.mListener;
        if (bannerManagerListener != null) {
            bannerManagerListener.onBannerAdScreenDismissed(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdLeftApplication() {
        BannerManagerListener bannerManagerListener = this.mListener;
        if (bannerManagerListener != null) {
            bannerManagerListener.onBannerAdLeftApplication(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdShown() {
        BannerManagerListener bannerManagerListener = this.mListener;
        if (bannerManagerListener != null) {
            bannerManagerListener.onBannerAdShown(this);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void log(String str) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_API;
        logger.log(ironSourceTag, "BannerSmash " + getName() + " " + str, 1);
    }

    private void logException(String str, String str2) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, str + " Banner exception: " + getName() + " | " + str2, 3);
    }
}
