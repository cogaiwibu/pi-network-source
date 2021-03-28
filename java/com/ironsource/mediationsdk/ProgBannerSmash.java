package com.ironsource.mediationsdk;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.anythink.reactnativejs.utils.Const;
import com.ironsource.eventsmodule.EventData;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.events.InterstitialEventsManager;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.AdapterConfig;
import com.ironsource.mediationsdk.model.BannerPlacement;
import com.ironsource.mediationsdk.model.ProviderSettings;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.timer.BannerTimeoutTimer;
import com.ironsource.mediationsdk.utils.DurationMeasurement;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Map;
import org.json.JSONObject;

public class ProgBannerSmash extends ProgSmash implements BannerSmashListener, BannerTimeoutTimer.TimeoutInterface {
    private String mAuctionFallback;
    private String mAuctionId;
    private int mAuctionTrial;
    private IronSourceBannerLayout mBannerLayout;
    private BannerData mData;
    private JSONObject mGenericParams;
    private boolean mIsReload;
    private ProgBannerManagerListener mListener;
    private DurationMeasurement mLoadDuration;
    private BannerPlacement mPlacement;
    private BannerSmashState mState;
    private final Object mStateLock;
    private BannerTimeoutTimer mTimer;

    /* access modifiers changed from: protected */
    public enum BannerSmashState {
        NONE,
        INIT_IN_PROGRESS,
        READY_TO_LOAD,
        LOADING,
        LOADED,
        LOAD_FAILED,
        DESTROYED
    }

    private boolean shouldAddAuctionParams(int i) {
        return i == 3005 || i == 3002 || i == 3008 || i == 3305 || i == 3300 || i == 3302 || i == 3303 || i == 3304 || i == 3009;
    }

    ProgBannerSmash(BannerData bannerData, ProgBannerManagerListener progBannerManagerListener, ProviderSettings providerSettings, AbstractAdapter abstractAdapter, int i, boolean z) {
        this(bannerData, progBannerManagerListener, providerSettings, abstractAdapter, i, "", null, 0, "", z);
    }

    ProgBannerSmash(BannerData bannerData, ProgBannerManagerListener progBannerManagerListener, ProviderSettings providerSettings, AbstractAdapter abstractAdapter, int i, String str, JSONObject jSONObject, int i2, String str2, boolean z) {
        super(new AdapterConfig(providerSettings, providerSettings.getBannerSettings()), abstractAdapter);
        this.mStateLock = new Object();
        this.mState = BannerSmashState.NONE;
        this.mData = bannerData;
        this.mTimer = new BannerTimeoutTimer(bannerData.getBannerLoadTimeOutInMillis());
        this.mListener = progBannerManagerListener;
        this.mSessionDepth = i;
        this.mAuctionId = str;
        this.mAuctionTrial = i2;
        this.mAuctionFallback = str2;
        this.mGenericParams = jSONObject;
        this.mIsReload = z;
        this.mAdapter.addBannerListener(this);
        if (isBidder()) {
            init();
        }
    }

    public String getName() {
        if (this.mAdapterConfig.getProviderSettings().isMultipleInstances()) {
            return this.mAdapterConfig.getProviderSettings().getProviderTypeForReflection();
        }
        return this.mAdapterConfig.getProviderSettings().getProviderName();
    }

    public String getAdSourceNameForEvents() {
        if (!TextUtils.isEmpty(this.mAdapterConfig.getProviderSettings().getAdSourceNameForEvents())) {
            return this.mAdapterConfig.getProviderSettings().getAdSourceNameForEvents();
        }
        return getName();
    }

    public String getSubProviderId() {
        return this.mAdapterConfig.getSubProviderId();
    }

    public AbstractAdapter getAdapter() {
        return this.mAdapter;
    }

    private void init() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(getLogPrefix() + "isBidder = " + isBidder());
        setState(BannerSmashState.INIT_IN_PROGRESS);
        setCustomParams();
        try {
            if (isBidder()) {
                this.mAdapter.initBannerForBidding(this.mData.getAppKey(), this.mData.getUserId(), this.mAdUnitSettings, this);
            } else {
                this.mAdapter.initBanners(this.mData.getAppKey(), this.mData.getUserId(), this.mAdUnitSettings, this);
            }
        } catch (Throwable th) {
            IronLog ironLog2 = IronLog.INTERNAL;
            ironLog2.error("exception = " + th.getLocalizedMessage());
            onBannerInitFailed(new IronSourceError(IronSourceError.ERROR_BN_INSTANCE_INIT_ERROR, th.getLocalizedMessage()));
        }
    }

    public void loadBanner(IronSourceBannerLayout ironSourceBannerLayout, BannerPlacement bannerPlacement, String str) {
        IronLog.INTERNAL.verbose(getInstanceSignature());
        this.mPlacement = bannerPlacement;
        if (!BannerUtils.isBannerLayoutReady(ironSourceBannerLayout)) {
            String str2 = ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed";
            IronLog.INTERNAL.verbose(str2);
            this.mListener.onBannerLoadFailed(new IronSourceError(IronSourceError.ERROR_BN_INSTANCE_LOAD_EMPTY_BANNER, str2), this, false);
        } else if (this.mAdapter == null) {
            IronLog.INTERNAL.verbose("mAdapter is null");
            this.mListener.onBannerLoadFailed(new IronSourceError(IronSourceError.ERROR_BN_INSTANCE_LOAD_EMPTY_ADAPTER, "mAdapter is null"), this, false);
        } else {
            this.mBannerLayout = ironSourceBannerLayout;
            this.mTimer.startTimeoutTimer(this);
            try {
                if (isBidder()) {
                    loadBannerInternal(str);
                } else {
                    init();
                }
            } catch (Throwable th) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.error("exception = " + th.getLocalizedMessage());
                th.printStackTrace();
            }
        }
    }

    private void loadBannerInternal(String str) {
        IronLog.INTERNAL.verbose(getInstanceSignature());
        if (compareStateAndSetIfTrue(BannerSmashState.READY_TO_LOAD, BannerSmashState.LOADING)) {
            this.mLoadDuration = new DurationMeasurement();
            sendProviderEvent(this.mIsReload ? IronSourceConstants.BN_INSTANCE_RELOAD : 3002);
            if (isBidder()) {
                this.mAdapter.loadBannerForBidding(this.mBannerLayout, this.mAdUnitSettings, this, str);
            } else {
                this.mAdapter.loadBanner(this.mBannerLayout, this.mAdUnitSettings, this);
            }
        } else {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("wrong state - state = " + this.mState);
        }
    }

    public void destroyBanner() {
        IronLog.INTERNAL.verbose(getInstanceSignature());
        setState(BannerSmashState.DESTROYED);
        if (this.mAdapter == null) {
            IronLog.INTERNAL.warning("mAdapter == null");
            return;
        }
        this.mAdapter.destroyBanner(this.mAdapterConfig.getProviderSettings().getBannerSettings());
        sendProviderEvent(IronSourceConstants.BN_INSTANCE_DESTROY);
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
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose("exception - " + e.toString());
            }
        }
    }

    private boolean compareStateAndSetIfTrue(BannerSmashState bannerSmashState, BannerSmashState bannerSmashState2) {
        boolean z;
        synchronized (this.mStateLock) {
            if (this.mState == bannerSmashState) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose(getLogPrefix() + "set state from '" + this.mState + "' to '" + bannerSmashState2 + "'");
                z = true;
                this.mState = bannerSmashState2;
            } else {
                z = false;
            }
        }
        return z;
    }

    private void setState(BannerSmashState bannerSmashState) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(getLogPrefix() + "state = " + bannerSmashState.name());
        synchronized (this.mStateLock) {
            this.mState = bannerSmashState;
        }
    }

    @Override // com.ironsource.mediationsdk.timer.BannerTimeoutTimer.TimeoutInterface
    public void onTimeout() {
        IronSourceError ironSourceError;
        IronLog.INTERNAL.verbose(getInstanceSignature());
        if (compareStateAndSetIfTrue(BannerSmashState.INIT_IN_PROGRESS, BannerSmashState.LOAD_FAILED)) {
            IronLog.INTERNAL.verbose("init timed out");
            ironSourceError = new IronSourceError(IronSourceError.ERROR_BN_INSTANCE_INIT_TIMEOUT, "Timed out");
        } else if (compareStateAndSetIfTrue(BannerSmashState.LOADING, BannerSmashState.LOAD_FAILED)) {
            IronLog.INTERNAL.verbose("load timed out");
            ironSourceError = new IronSourceError(IronSourceError.ERROR_BN_INSTANCE_LOAD_TIMEOUT, "Timed out");
        } else {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("unexpected state - " + this.mState);
            return;
        }
        handleLoadFailed(ironSourceError);
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerInitSuccess() {
        IronLog.INTERNAL.verbose(getInstanceSignature());
        if (compareStateAndSetIfTrue(BannerSmashState.INIT_IN_PROGRESS, BannerSmashState.READY_TO_LOAD) && !isBidder()) {
            if (!BannerUtils.isBannerLayoutReady(this.mBannerLayout)) {
                this.mListener.onBannerLoadFailed(new IronSourceError(IronSourceError.ERROR_BN_LOAD_EXCEPTION, this.mBannerLayout == null ? "banner is null" : "banner is destroyed"), this, false);
            } else {
                loadBannerInternal(null);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerInitFailed(IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(getLogPrefix() + "error = " + ironSourceError);
        this.mTimer.stopTimeoutTimer();
        if (compareStateAndSetIfTrue(BannerSmashState.INIT_IN_PROGRESS, BannerSmashState.NONE)) {
            ProgBannerManagerListener progBannerManagerListener = this.mListener;
            if (progBannerManagerListener != null) {
                progBannerManagerListener.onBannerLoadFailed(new IronSourceError(IronSourceError.ERROR_BN_INSTANCE_INIT_ERROR, "Banner init failed"), this, false);
                return;
            }
            return;
        }
        IronLog ironLog2 = IronLog.INTERNAL;
        ironLog2.warning("wrong state - mState = " + this.mState);
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdLoaded(View view, FrameLayout.LayoutParams layoutParams) {
        IronLog.INTERNAL.verbose(getInstanceSignature());
        this.mTimer.stopTimeoutTimer();
        if (compareStateAndSetIfTrue(BannerSmashState.LOADING, BannerSmashState.LOADED)) {
            sendProviderEvent(this.mIsReload ? IronSourceConstants.BN_INSTANCE_RELOAD_SUCCESS : 3005, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(DurationMeasurement.getMeasuredDuration(this.mLoadDuration))}});
            ProgBannerManagerListener progBannerManagerListener = this.mListener;
            if (progBannerManagerListener != null) {
                progBannerManagerListener.onBannerLoadSuccess(this, view, layoutParams);
                return;
            }
            return;
        }
        sendProviderEvent(this.mIsReload ? IronSourceConstants.BN_INSTANCE_UNEXPECTED_RELOAD_SUCCESS : IronSourceConstants.BN_INSTANCE_UNEXPECTED_LOAD_SUCCESS);
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdLoadFailed(IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(getLogPrefix() + "error = " + ironSourceError);
        this.mTimer.stopTimeoutTimer();
        if (compareStateAndSetIfTrue(BannerSmashState.LOADING, BannerSmashState.LOAD_FAILED)) {
            handleLoadFailed(ironSourceError);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdClicked() {
        IronLog.INTERNAL.verbose(getInstanceSignature());
        sendProviderEvent(IronSourceConstants.BN_INSTANCE_CLICK);
        ProgBannerManagerListener progBannerManagerListener = this.mListener;
        if (progBannerManagerListener != null) {
            progBannerManagerListener.onBannerClicked(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdScreenPresented() {
        IronLog.INTERNAL.verbose(getInstanceSignature());
        sendProviderEvent(IronSourceConstants.BN_INSTANCE_PRESENT_SCREEN);
        ProgBannerManagerListener progBannerManagerListener = this.mListener;
        if (progBannerManagerListener != null) {
            progBannerManagerListener.onBannerScreenPresented(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdScreenDismissed() {
        IronLog.INTERNAL.verbose(getInstanceSignature());
        sendProviderEvent(IronSourceConstants.BN_INSTANCE_DISMISS_SCREEN);
        ProgBannerManagerListener progBannerManagerListener = this.mListener;
        if (progBannerManagerListener != null) {
            progBannerManagerListener.onBannerScreenDismissed(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdLeftApplication() {
        IronLog.INTERNAL.verbose(getInstanceSignature());
        sendProviderEvent(IronSourceConstants.BN_INSTANCE_LEAVE_APP);
        ProgBannerManagerListener progBannerManagerListener = this.mListener;
        if (progBannerManagerListener != null) {
            progBannerManagerListener.onBannerLeftApplication(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdShown() {
        IronLog.INTERNAL.verbose(getInstanceSignature());
        sendProviderEvent(IronSourceConstants.BN_INSTANCE_SHOW);
        ProgBannerManagerListener progBannerManagerListener = this.mListener;
        if (progBannerManagerListener != null) {
            progBannerManagerListener.onBannerShown(this);
        }
    }

    public String getAuctionId() {
        return this.mAuctionId;
    }

    public Map<String, Object> getBiddingData() {
        try {
            if (isBidder()) {
                return this.mAdapter.getBannerBiddingData(this.mAdUnitSettings);
            }
            return null;
        } catch (Throwable th) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("getBiddingData exception: " + th.getLocalizedMessage());
            th.printStackTrace();
            return null;
        }
    }

    public String getInstanceSignature() {
        return String.format("%s %s", getName(), Integer.valueOf(hashCode()));
    }

    public String getLogPrefix() {
        return String.format("%s - ", getInstanceSignature());
    }

    private boolean isBannerLayoutDestroyed() {
        IronSourceBannerLayout ironSourceBannerLayout = this.mBannerLayout;
        return ironSourceBannerLayout == null || ironSourceBannerLayout.isDestroyed();
    }

    private void handleLoadFailed(IronSourceError ironSourceError) {
        boolean z = ironSourceError.getErrorCode() == 606;
        if (z) {
            sendProviderEvent(IronSourceConstants.BN_INSTANCE_LOAD_NO_FILL, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(DurationMeasurement.getMeasuredDuration(this.mLoadDuration))}});
        } else {
            sendProviderEvent(this.mIsReload ? IronSourceConstants.BN_INSTANCE_RELOAD_ERROR : IronSourceConstants.BN_INSTANCE_LOAD_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(DurationMeasurement.getMeasuredDuration(this.mLoadDuration))}});
        }
        ProgBannerManagerListener progBannerManagerListener = this.mListener;
        if (progBannerManagerListener != null) {
            progBannerManagerListener.onBannerLoadFailed(ironSourceError, this, z);
        }
    }

    private void addEventSizeFields(Map<String, Object> map, ISBannerSize iSBannerSize) {
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
                map.put("bannerAdSize", 1);
            } else if (c == 1) {
                map.put("bannerAdSize", 2);
            } else if (c == 2) {
                map.put("bannerAdSize", 3);
            } else if (c == 3) {
                map.put("bannerAdSize", 5);
            } else if (c == 4) {
                map.put("bannerAdSize", 6);
                map.put("custom_banner_size", iSBannerSize.getWidth() + Const.X + iSBannerSize.getHeight());
            }
        } catch (Exception e) {
            IronLog.INTERNAL.error(Log.getStackTraceString(e));
        }
    }

    public void sendProviderEvent(int i) {
        sendProviderEvent(i, null);
    }

    private void sendProviderEvent(int i, Object[][] objArr) {
        Map<String, Object> providerEventData = getProviderEventData();
        if (isBannerLayoutDestroyed()) {
            providerEventData.put(IronSourceConstants.EVENTS_ERROR_REASON, "banner is destroyed");
        } else {
            addEventSizeFields(providerEventData, this.mBannerLayout.getSize());
        }
        if (!TextUtils.isEmpty(this.mAuctionId)) {
            providerEventData.put("auctionId", this.mAuctionId);
        }
        JSONObject jSONObject = this.mGenericParams;
        if (jSONObject != null && jSONObject.length() > 0) {
            providerEventData.put("genericParams", this.mGenericParams);
        }
        BannerPlacement bannerPlacement = this.mPlacement;
        if (bannerPlacement != null) {
            providerEventData.put(IronSourceConstants.EVENTS_PLACEMENT_NAME, bannerPlacement.getPlacementName());
        }
        if (shouldAddAuctionParams(i)) {
            InterstitialEventsManager.getInstance().setEventAuctionParams(providerEventData, this.mAuctionTrial, this.mAuctionFallback);
        }
        providerEventData.put("sessionDepth", Integer.valueOf(this.mSessionDepth));
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    providerEventData.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e) {
                IronLog.INTERNAL.error(getInstanceName() + " smash: BN sendMediationEvent " + Log.getStackTraceString(e));
            }
        }
        InterstitialEventsManager.getInstance().log(new EventData(i, new JSONObject(providerEventData)));
    }
}
