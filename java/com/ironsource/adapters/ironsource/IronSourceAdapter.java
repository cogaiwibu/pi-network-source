package com.ironsource.adapters.ironsource;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.facebook.appevents.AppEventsConstants;
import com.ironsource.adapters.supersonicads.SupersonicConfig;
import com.ironsource.environment.TokenConstants;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.AuctionDataUtils;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.IronSourceObject;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.metadata.MetaDataConstants;
import com.ironsource.mediationsdk.metadata.MetaDataUtils;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.sdk.InternalOfferwallListener;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.sdk.OfferwallAdapterApi;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.ContextProvider;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.SessionDepthManager;
import com.ironsource.sdk.ISNAdView.ISNAdView;
import com.ironsource.sdk.IronSourceAdInstance;
import com.ironsource.sdk.IronSourceAdInstanceBuilder;
import com.ironsource.sdk.IronSourceNetwork;
import com.ironsource.sdk.constants.Constants;
import com.ironsource.sdk.constants.Events;
import com.ironsource.sdk.data.ISNEnums;
import com.ironsource.sdk.data.ISNError;
import com.ironsource.sdk.listeners.OnBannerListener;
import com.ironsource.sdk.listeners.OnInterstitialListener;
import com.ironsource.sdk.listeners.OnNetworkSDKInitListener;
import com.ironsource.sdk.listeners.OnOfferWallListener;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IronSourceAdapter extends AbstractAdapter implements OfferwallAdapterApi, OnOfferWallListener, ContextProvider.ContextLifeCycleListener {
    private static final int IS_LOAD_EXCEPTION = 1000;
    private static final int IS_SHOW_EXCEPTION = 1001;
    private static final int RV_LOAD_EXCEPTION = 1002;
    private static final int RV_SHOW_EXCEPTION = 1003;
    private static final String VERSION = "7.1.1";
    private static AtomicBoolean mDidInitSdk = new AtomicBoolean(false);
    private static ISNAdView mIsnAdView;
    private static String mediationSegment;
    private final String ADM_KEY = Constants.ParametersKeys.ADM;
    private final String CUSTOM_SEGMENT = "custom_Segment";
    private final String DEMAND_SOURCE_NAME = "demandSourceName";
    private final String DYNAMIC_CONTROLLER_CONFIG = Constants.RequestParameters.CONTROLLER_CONFIG;
    private final String DYNAMIC_CONTROLLER_DEBUG_MODE = Constants.FeaturesManager.DEBUG_MODE;
    private final String DYNAMIC_CONTROLLER_URL = "controllerUrl";
    private final String IN_APP_BIDDING_KEY = "inAppBidding";
    private final String IN_APP_BIDDING_VALUE = "true";
    private final String LWS_SUPPORT_STATE = "isSupportedLWS";
    private final String OW_CLIENT_SIDE_CALLBACKS = "useClientSideCallbacks";
    private final String OW_PLACEMENT_ID = "placementId";
    private final String SDK_PLUGIN_TYPE = TokenConstants.SDK_PLUGIN_TYPE;
    private final String SESSION_ID = Events.SESSION_ID;
    private ConcurrentHashMap<String, BannerSmashListener> mDemandSourceToBNSmash;
    private ConcurrentHashMap<String, IronSourceAdInstance> mDemandSourceToISAd;
    private ConcurrentHashMap<String, InterstitialSmashListener> mDemandSourceToISSmash;
    private ConcurrentHashMap<String, IronSourceAdInstance> mDemandSourceToRvAd;
    private ConcurrentHashMap<String, RewardedVideoSmashListener> mDemandSourceToRvSmash;
    private boolean mIsAlreadyShowing;
    private InternalOfferwallListener mOfferwallListener;

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getVersion() {
        return "7.1.1";
    }

    @Override // com.ironsource.mediationsdk.sdk.OfferwallAdapterApi
    public boolean isOfferwallAvailable() {
        return true;
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerAdapterApi, com.ironsource.mediationsdk.AbstractAdapter
    public boolean shouldBindBannerViewOnReload() {
        return true;
    }

    public static IronSourceAdapter startAdapter(String str) {
        return new IronSourceAdapter(str);
    }

    private IronSourceAdapter(String str) {
        super(str);
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(str + ": new instance");
        this.mDemandSourceToRvAd = new ConcurrentHashMap<>();
        this.mDemandSourceToRvSmash = new ConcurrentHashMap<>();
        this.mDemandSourceToISAd = new ConcurrentHashMap<>();
        this.mDemandSourceToISSmash = new ConcurrentHashMap<>();
        this.mDemandSourceToBNSmash = new ConcurrentHashMap<>();
        mediationSegment = null;
        ContextProvider.getInstance().registerLifeCycleListener(this);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getCoreSDKVersion() {
        return SDKUtils.getSDKVersion();
    }

    @Override // com.ironsource.mediationsdk.utils.ContextProvider.ContextLifeCycleListener
    public void onPause(Activity activity) {
        IronLog.ADAPTER_API.verbose("IronSourceNetwork.onPause");
        IronSourceNetwork.onPause(activity);
    }

    @Override // com.ironsource.mediationsdk.utils.ContextProvider.ContextLifeCycleListener
    public void onResume(Activity activity) {
        IronLog.ADAPTER_API.verbose("IronSourceNetwork.onResume");
        IronSourceNetwork.onResume(activity);
    }

    /* access modifiers changed from: protected */
    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public void setConsent(boolean z) {
        IronLog ironLog = IronLog.ADAPTER_API;
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(z ? "true" : "false");
        sb.append(")");
        ironLog.verbose(sb.toString());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("consent", z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            IronSourceNetwork.updateMetadata(jSONObject);
        } catch (JSONException e) {
            IronLog ironLog2 = IronLog.ADAPTER_API;
            ironLog2.error("exception " + e.getMessage());
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.BaseApi
    public void setMediationSegment(String str) {
        mediationSegment = str;
    }

    private HashMap<String, String> getInitParams() {
        HashMap<String, String> hashMap = new HashMap<>();
        String pluginType = getPluginType();
        if (!TextUtils.isEmpty(pluginType)) {
            hashMap.put(TokenConstants.SDK_PLUGIN_TYPE, pluginType);
        }
        if (!TextUtils.isEmpty(mediationSegment)) {
            hashMap.put("custom_Segment", mediationSegment);
        }
        if (!TextUtils.isEmpty(IronSourceObject.getInstance().getSessionId())) {
            hashMap.put(Events.SESSION_ID, IronSourceObject.getInstance().getSessionId());
        }
        return hashMap;
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public JSONObject getPlayerBiddingData() {
        JSONObject jSONObject;
        IronLog.ADAPTER_API.verbose("");
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject = IronSourceNetwork.getRawToken(ContextProvider.getInstance().getApplicationContext());
        } catch (Exception e) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.error("getRawToken exception: " + e.getLocalizedMessage());
            jSONObject = null;
        }
        if (jSONObject != null) {
            return jSONObject;
        }
        IronLog.ADAPTER_API.error("Player's bidding token is null");
        return jSONObject2;
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public void earlyInit(String str, String str2, JSONObject jSONObject) {
        if (str != null) {
            IronSourceUtils.sendAutomationLog(getDemandSourceName(jSONObject) + ": earlyInit");
            initSDK(str, jSONObject);
            return;
        }
        IronLog.ADAPTER_API.error("Appkey is null for early init");
    }

    private void initSDK(String str, JSONObject jSONObject) {
        if (mDidInitSdk.compareAndSet(false, true)) {
            String mediationUserId = IronSourceUtils.getMediationUserId();
            int optInt = jSONObject.optInt(Constants.FeaturesManager.DEBUG_MODE, 0);
            if (isAdaptersDebugEnabled()) {
                optInt = 3;
            }
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose("setting debug mode to " + optInt);
            SDKUtils.setDebugMode(optInt);
            SDKUtils.setControllerUrl(jSONObject.optString("controllerUrl"));
            IronLog ironLog2 = IronLog.ADAPTER_API;
            ironLog2.verbose("IronSourceNetwork setting controller url to  " + jSONObject.optString("controllerUrl"));
            SDKUtils.setControllerConfig(jSONObject.optString(Constants.RequestParameters.CONTROLLER_CONFIG));
            IronLog ironLog3 = IronLog.ADAPTER_API;
            ironLog3.verbose("IronSourceNetwork setting controller config to  " + jSONObject.optString(Constants.RequestParameters.CONTROLLER_CONFIG));
            HashMap<String, String> initParams = getInitParams();
            IronLog ironLog4 = IronLog.ADAPTER_API;
            ironLog4.verbose("with appKey=" + str + " userId=" + mediationUserId + " parameters " + initParams);
            IronSourceNetwork.setInitListener(new OnNetworkSDKInitListener() {
                /* class com.ironsource.adapters.ironsource.IronSourceAdapter.AnonymousClass1 */

                @Override // com.ironsource.sdk.listeners.OnNetworkSDKInitListener
                public void onSuccess() {
                    IronLog.ADAPTER_API.verbose("OnNetworkSDKInitListener success");
                }

                @Override // com.ironsource.sdk.listeners.OnNetworkSDKInitListener
                public void onFail(ISNError iSNError) {
                    IronLog ironLog = IronLog.ADAPTER_API;
                    ironLog.verbose("OnNetworkSDKInitListener fail - code:" + iSNError.getCode() + " message:" + iSNError.getMessage());
                }
            });
            IronSourceNetwork.initSDK(ContextProvider.getInstance().getApplicationContext(), str, mediationUserId, initParams);
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public Map<String, Object> getRewardedVideoBiddingData(JSONObject jSONObject) {
        return getBiddingData();
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public void initRewardedVideoForBidding(String str, String str2, JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(demandSourceName + ": demandSourceName=" + demandSourceName);
        initRewardedVideoInternal(str, jSONObject, rewardedVideoSmashListener, demandSourceName);
        rewardedVideoSmashListener.onRewardedVideoInitSuccess();
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public void initRewardedVideoForDemandOnly(String str, String str2, JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(demandSourceName + ": demandSourceName=" + demandSourceName);
        initRewardedVideoInternal(str, jSONObject, rewardedVideoSmashListener, demandSourceName);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoAdapterApi
    public void initRewardedVideo(String str, String str2, JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(demandSourceName + ": demandSourceName=" + demandSourceName);
        initRewardedVideoInternal(str, jSONObject, rewardedVideoSmashListener, demandSourceName);
        fetchRewardedVideoForAutomaticLoad(jSONObject, rewardedVideoSmashListener);
    }

    private void initRewardedVideoInternal(String str, JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener, String str2) {
        initSDK(str, jSONObject);
        this.mDemandSourceToRvSmash.put(str2, rewardedVideoSmashListener);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoAdapterApi
    public void fetchRewardedVideoForAutomaticLoad(JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog.ADAPTER_API.verbose(demandSourceName);
        try {
            loadAdInternal(demandSourceName, null, false, false, true);
        } catch (Exception e) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.error("exception " + e.getMessage());
            RewardedVideoSmashListener rewardedVideoSmashListener2 = this.mDemandSourceToRvSmash.get(demandSourceName);
            if (rewardedVideoSmashListener2 != null) {
                IronLog ironLog2 = IronLog.ADAPTER_API;
                ironLog2.error("exception " + e.getMessage());
                rewardedVideoSmashListener2.onRewardedVideoLoadFailed(new IronSourceError(1002, e.getMessage()));
                rewardedVideoSmashListener2.onRewardedVideoAvailabilityChanged(false);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public void loadRewardedVideoForDemandOnly(JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        IronLog.ADAPTER_API.verbose(getDemandSourceName(jSONObject));
        try {
            loadAdInternal(getDemandSourceName(jSONObject), null, true, false, true);
        } catch (Exception e) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.error("exception " + e.getMessage());
            rewardedVideoSmashListener.onRewardedVideoLoadFailed(new IronSourceError(1002, e.getMessage()));
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public void loadRewardedVideoForDemandOnlyForBidding(JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener, String str) {
        IronLog.ADAPTER_API.verbose(getDemandSourceName(jSONObject));
        try {
            loadAdInternal(getDemandSourceName(jSONObject), str, true, true, true);
        } catch (Exception e) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.error("exception " + e.getMessage());
            rewardedVideoSmashListener.onRewardedVideoLoadFailed(new IronSourceError(1002, e.getMessage()));
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public void loadRewardedVideoForBidding(JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener, String str) {
        IronLog.ADAPTER_API.verbose(getDemandSourceName(jSONObject));
        try {
            loadAdInternal(getDemandSourceName(jSONObject), str, false, true, true);
        } catch (Exception e) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.error("exception " + e.getMessage());
            rewardedVideoSmashListener.onRewardedVideoLoadFailed(new IronSourceError(1002, e.getMessage()));
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoAdapterApi
    public void showRewardedVideo(JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        try {
            showAdInternal(this.mDemandSourceToRvAd.get(getDemandSourceName(jSONObject)), 1);
        } catch (Exception e) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.error("exception " + e.getMessage());
            rewardedVideoSmashListener.onRewardedVideoAdShowFailed(new IronSourceError(1003, e.getMessage()));
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoAdapterApi
    public boolean isRewardedVideoAvailable(JSONObject jSONObject) {
        IronSourceAdInstance ironSourceAdInstance = this.mDemandSourceToRvAd.get(getDemandSourceName(jSONObject));
        return ironSourceAdInstance != null && IronSourceNetwork.isAdAvailableForInstance(ironSourceAdInstance);
    }

    /* access modifiers changed from: package-private */
    public Map<String, Object> getBiddingData() {
        IronLog.ADAPTER_API.verbose("");
        HashMap hashMap = new HashMap();
        String token = IronSourceNetwork.getToken(ContextProvider.getInstance().getApplicationContext());
        if (token != null) {
            hashMap.put(IronSourceConstants.IRONSOURCE_BIDDING_TOKEN_KEY, token);
        } else {
            IronLog.ADAPTER_API.error("bidding token is null");
            hashMap.put(IronSourceConstants.IRONSOURCE_BIDDING_TOKEN_KEY, "");
        }
        return hashMap;
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public Map<String, Object> getInterstitialBiddingData(JSONObject jSONObject) {
        return getBiddingData();
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public void initInterstitialForBidding(String str, String str2, JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(demandSourceName + ": demandSourceName=" + demandSourceName);
        initInterstitialInternal(str, jSONObject, interstitialSmashListener, demandSourceName);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialAdapterApi
    public void initInterstitial(String str, String str2, JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(demandSourceName + ": demandSourceName=" + demandSourceName);
        initInterstitialInternal(str, jSONObject, interstitialSmashListener, demandSourceName);
    }

    private void initInterstitialInternal(String str, JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener, String str2) {
        initSDK(str, jSONObject);
        this.mDemandSourceToISSmash.put(str2, interstitialSmashListener);
        interstitialSmashListener.onInterstitialInitSuccess();
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public void loadInterstitialForBidding(JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener, String str) {
        IronLog.ADAPTER_API.verbose(getDemandSourceName(jSONObject));
        try {
            loadAdInternal(getDemandSourceName(jSONObject), str, false, true, false);
        } catch (Exception e) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.error("for bidding exception " + e.getMessage());
            interstitialSmashListener.onInterstitialAdLoadFailed(new IronSourceError(1000, e.getMessage()));
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialAdapterApi
    public void loadInterstitial(JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        IronLog.ADAPTER_API.verbose(getDemandSourceName(jSONObject));
        try {
            loadAdInternal(getDemandSourceName(jSONObject), null, false, false, false);
        } catch (Exception e) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.error("exception " + e.getMessage());
            interstitialSmashListener.onInterstitialAdLoadFailed(new IronSourceError(1000, e.getMessage()));
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialAdapterApi
    public void showInterstitial(JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        IronLog.ADAPTER_API.verbose(getDemandSourceName(jSONObject));
        try {
            showAdInternal(this.mDemandSourceToISAd.get(getDemandSourceName(jSONObject)), 2);
        } catch (Exception e) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.error("exception " + e.getMessage());
            interstitialSmashListener.onInterstitialAdShowFailed(new IronSourceError(1001, e.getMessage()));
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialAdapterApi
    public boolean isInterstitialReady(JSONObject jSONObject) {
        IronSourceAdInstance ironSourceAdInstance = this.mDemandSourceToISAd.get(getDemandSourceName(jSONObject));
        return ironSourceAdInstance != null && IronSourceNetwork.isAdAvailableForInstance(ironSourceAdInstance);
    }

    @Override // com.ironsource.mediationsdk.sdk.OfferwallAdapterApi
    public void setInternalOfferwallListener(InternalOfferwallListener internalOfferwallListener) {
        this.mOfferwallListener = internalOfferwallListener;
    }

    @Override // com.ironsource.mediationsdk.sdk.OfferwallAdapterApi
    public void showOfferwall(String str, JSONObject jSONObject) {
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose(getProviderName() + " showOfferWall");
        try {
            HashMap<String, String> offerwallExtraParams = getOfferwallExtraParams();
            offerwallExtraParams.put("placementId", str);
            IronSourceNetwork.showOfferWall(offerwallExtraParams);
        } catch (Exception e) {
            IronLog ironLog2 = IronLog.ADAPTER_API;
            ironLog2.error("exception " + e.getMessage());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private HashMap<String, String> getOfferwallExtraParams() {
        HashMap<String, String> initParams = getInitParams();
        initParams.put("useClientSideCallbacks", String.valueOf(SupersonicConfig.getConfigObj().getClientSideCallbacks()));
        Map<String, String> offerwallCustomParams = SupersonicConfig.getConfigObj().getOfferwallCustomParams();
        if (offerwallCustomParams != null && !offerwallCustomParams.isEmpty()) {
            initParams.putAll(offerwallCustomParams);
        }
        return initParams;
    }

    @Override // com.ironsource.mediationsdk.sdk.OfferwallAdapterApi
    public void getOfferwallCredits() {
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose(getProviderName() + " getOfferwallCredits");
        try {
            IronSourceNetwork.getOfferWallCredits(this);
        } catch (Exception e) {
            IronLog ironLog2 = IronLog.ADAPTER_API;
            ironLog2.error("exception " + e.getMessage());
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.OfferwallAdapterApi
    public void initOfferwall(String str, String str2, JSONObject jSONObject) {
        initSDK(str, jSONObject);
        IronLog.ADAPTER_API.verbose(":initOfferwall");
        postOnUIThread(new Runnable() {
            /* class com.ironsource.adapters.ironsource.IronSourceAdapter.AnonymousClass2 */

            public void run() {
                try {
                    IronSourceNetwork.initOfferWall(IronSourceAdapter.this.getOfferwallExtraParams(), IronSourceAdapter.this);
                } catch (Exception e) {
                    IronLog ironLog = IronLog.ADAPTER_API;
                    ironLog.error(IronSourceAdapter.this.getProviderName() + ":initOfferwall " + e);
                    InternalOfferwallListener internalOfferwallListener = IronSourceAdapter.this.mOfferwallListener;
                    internalOfferwallListener.onOfferwallAvailable(false, ErrorBuilder.buildInitFailedError("Adapter initialization failure - " + IronSourceAdapter.this.getProviderName() + " - " + e.getMessage(), IronSourceConstants.OFFERWALL_AD_UNIT));
                }
            }
        });
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public Map<String, Object> getBannerBiddingData(JSONObject jSONObject) {
        return getBiddingData();
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerAdapterApi, com.ironsource.mediationsdk.AbstractAdapter
    public void initBanners(String str, String str2, JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose(demandSourceName + ": demandSourceName=" + demandSourceName);
        initSDK(str, jSONObject);
        this.mDemandSourceToBNSmash.put(demandSourceName, bannerSmashListener);
        try {
            IronSourceNetwork.initBanner(demandSourceName, getInitParams(), new IronSourceBannerListener(bannerSmashListener, demandSourceName));
        } catch (Exception e) {
            bannerSmashListener.onBannerInitFailed(ErrorBuilder.buildInitFailedError(e.getMessage(), IronSourceConstants.BANNER_AD_UNIT));
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerAdapterApi, com.ironsource.mediationsdk.AbstractAdapter
    public void loadBanner(IronSourceBannerLayout ironSourceBannerLayout, JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose(demandSourceName + ": demandSourceName=" + demandSourceName);
        if (!this.mIsAlreadyShowing) {
            destroyBannerInternal();
            mIsnAdView = createBanner(ironSourceBannerLayout.getActivity(), ironSourceBannerLayout.getSize(), bannerSmashListener);
        }
        try {
            loadBannerInternal(mIsnAdView, bannerSmashListener, null);
        } catch (Exception e) {
            bannerSmashListener.onBannerAdLoadFailed(ErrorBuilder.buildLoadFailedError("Banner Load Fail, " + getProviderName() + " - " + e.getMessage()));
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public void initBannerForBidding(String str, String str2, JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose(demandSourceName + ": demandSourceName=" + demandSourceName);
        initSDK(str, jSONObject);
        this.mDemandSourceToBNSmash.put(demandSourceName, bannerSmashListener);
        bannerSmashListener.onBannerInitSuccess();
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public void loadBannerForBidding(IronSourceBannerLayout ironSourceBannerLayout, JSONObject jSONObject, BannerSmashListener bannerSmashListener, String str) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose(demandSourceName + ": demandSourceName=" + demandSourceName);
        try {
            if (!this.mIsAlreadyShowing) {
                destroyBannerInternal();
                mIsnAdView = createBanner(ironSourceBannerLayout.getActivity(), ironSourceBannerLayout.getSize(), bannerSmashListener);
            }
            HashMap<String, String> initParams = getInitParams();
            initParams.put("inAppBidding", "true");
            IronSourceNetwork.initBanner(demandSourceName, initParams, new IronSourceBannerListener(bannerSmashListener, demandSourceName));
            loadBannerInternal(mIsnAdView, bannerSmashListener, str);
        } catch (Exception e) {
            bannerSmashListener.onBannerAdLoadFailed(ErrorBuilder.buildLoadFailedError("Banner Load Fail, " + getProviderName() + " - " + e.getMessage()));
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerAdapterApi, com.ironsource.mediationsdk.AbstractAdapter
    public void reloadBanner(IronSourceBannerLayout ironSourceBannerLayout, JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose(demandSourceName + ": demandSourceName=" + demandSourceName);
        loadBannerInternal(mIsnAdView, bannerSmashListener, null);
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerAdapterApi, com.ironsource.mediationsdk.AbstractAdapter
    public void destroyBanner(JSONObject jSONObject) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose(demandSourceName + ": demandSourceName=" + demandSourceName);
        this.mIsAlreadyShowing = false;
        destroyBannerInternal();
    }

    private void destroyBannerInternal() {
        if (mIsnAdView != null) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose(getProviderName() + " bannerView.performCleanup");
            mIsnAdView.performCleanup();
            mIsnAdView = null;
        }
    }

    private void loadBannerInternal(ISNAdView iSNAdView, BannerSmashListener bannerSmashListener, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("demandSourceName", getProviderName());
            jSONObject.put(Constants.ParametersKeys.PRODUCT_TYPE, ISNEnums.ProductType.Banner);
            if (str != null) {
                jSONObject.put(Constants.ParametersKeys.ADM, AuctionDataUtils.getInstance().getAdmFromServerData(str));
                jSONObject.put("inAppBidding", "true");
                JSONObject jSONObject2 = new JSONObject(AuctionDataUtils.getInstance().getAuctionResponseServerDataParams(str));
                JSONArray names = jSONObject2.names();
                for (int i = 0; i < names.length(); i++) {
                    jSONObject.put(names.getString(i), jSONObject2.get(names.getString(i)));
                }
            }
            if (iSNAdView != null) {
                try {
                    IronLog.ADAPTER_API.verbose("bannerView.loadAd");
                    iSNAdView.loadAd(jSONObject);
                } catch (Exception e) {
                    bannerSmashListener.onBannerAdLoadFailed(ErrorBuilder.buildLoadFailedError("Banner Load Fail, " + getProviderName() + " - " + e.getMessage()));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public class IronSourceRewardedVideoListener implements OnInterstitialListener {
        private String mDemandSourceName;
        boolean mIsRvDemandOnly;
        RewardedVideoSmashListener mListener;

        IronSourceRewardedVideoListener(RewardedVideoSmashListener rewardedVideoSmashListener, String str) {
            this.mDemandSourceName = str;
            this.mListener = rewardedVideoSmashListener;
            this.mIsRvDemandOnly = false;
        }

        IronSourceRewardedVideoListener(RewardedVideoSmashListener rewardedVideoSmashListener, String str, boolean z) {
            this.mDemandSourceName = str;
            this.mListener = rewardedVideoSmashListener;
            this.mIsRvDemandOnly = z;
        }

        @Override // com.ironsource.sdk.listeners.OnInterstitialListener
        public void onInterstitialInitSuccess() {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " rewardedVideoListener");
        }

        @Override // com.ironsource.sdk.listeners.OnInterstitialListener
        public void onInterstitialInitFailed(String str) {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " rewardedVideoListener");
        }

        @Override // com.ironsource.sdk.listeners.OnInterstitialListener
        public void onInterstitialLoadSuccess() {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " rewardedVideoListener");
            if (this.mIsRvDemandOnly) {
                this.mListener.onRewardedVideoLoadSuccess();
            } else {
                this.mListener.onRewardedVideoAvailabilityChanged(true);
            }
        }

        @Override // com.ironsource.sdk.listeners.OnInterstitialListener
        public void onInterstitialLoadFailed(String str) {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " rewardedVideoListener " + str);
            this.mListener.onRewardedVideoLoadFailed(ErrorBuilder.buildLoadFailedError(str));
            if (!this.mIsRvDemandOnly) {
                this.mListener.onRewardedVideoAvailabilityChanged(false);
            }
        }

        @Override // com.ironsource.sdk.listeners.OnInterstitialListener
        public void onInterstitialOpen() {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " rewardedVideoListener");
            this.mListener.onRewardedVideoAdOpened();
        }

        @Override // com.ironsource.sdk.listeners.OnInterstitialListener
        public void onInterstitialAdRewarded(String str, int i) {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " rewardedVideoListener demandSourceId=" + str + " amount=" + i);
            this.mListener.onRewardedVideoAdRewarded();
        }

        @Override // com.ironsource.sdk.listeners.OnInterstitialListener
        public void onInterstitialClose() {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " rewardedVideoListener");
            this.mListener.onRewardedVideoAdClosed();
        }

        @Override // com.ironsource.sdk.listeners.OnInterstitialListener
        public void onInterstitialShowSuccess() {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " rewardedVideoListener");
            if (!this.mIsRvDemandOnly) {
                this.mListener.onRewardedVideoAvailabilityChanged(false);
            }
        }

        @Override // com.ironsource.sdk.listeners.OnInterstitialListener
        public void onInterstitialShowFailed(String str) {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + "rewardedVideoListener " + str);
            this.mListener.onRewardedVideoAdShowFailed(ErrorBuilder.buildShowFailedError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT, str));
        }

        @Override // com.ironsource.sdk.listeners.OnInterstitialListener
        public void onInterstitialClick() {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " rewardedVideoListener");
            this.mListener.onRewardedVideoAdClicked();
        }

        @Override // com.ironsource.sdk.listeners.OnInterstitialListener
        public void onInterstitialEventNotificationReceived(String str, JSONObject jSONObject) {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " rewardedVideoListener eventName=" + str);
            this.mListener.onRewardedVideoAdVisible();
        }
    }

    /* access modifiers changed from: private */
    public class IronSourceInterstitialListener implements OnInterstitialListener {
        private String mDemandSourceName;
        private InterstitialSmashListener mListener;

        IronSourceInterstitialListener(InterstitialSmashListener interstitialSmashListener, String str) {
            this.mDemandSourceName = str;
            this.mListener = interstitialSmashListener;
        }

        @Override // com.ironsource.sdk.listeners.OnInterstitialListener
        public void onInterstitialInitSuccess() {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " interstitialListener");
        }

        @Override // com.ironsource.sdk.listeners.OnInterstitialListener
        public void onInterstitialInitFailed(String str) {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " interstitialListener");
        }

        @Override // com.ironsource.sdk.listeners.OnInterstitialListener
        public void onInterstitialLoadSuccess() {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " interstitialListener");
            this.mListener.onInterstitialAdReady();
        }

        @Override // com.ironsource.sdk.listeners.OnInterstitialListener
        public void onInterstitialLoadFailed(String str) {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " interstitialListener " + str);
            this.mListener.onInterstitialAdLoadFailed(ErrorBuilder.buildLoadFailedError(str));
        }

        @Override // com.ironsource.sdk.listeners.OnInterstitialListener
        public void onInterstitialOpen() {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " interstitialListener");
            this.mListener.onInterstitialAdOpened();
        }

        @Override // com.ironsource.sdk.listeners.OnInterstitialListener
        public void onInterstitialAdRewarded(String str, int i) {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " interstitialListener demandSourceId=" + str + " amount=" + i);
        }

        @Override // com.ironsource.sdk.listeners.OnInterstitialListener
        public void onInterstitialClose() {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " interstitialListener");
            this.mListener.onInterstitialAdClosed();
        }

        @Override // com.ironsource.sdk.listeners.OnInterstitialListener
        public void onInterstitialShowSuccess() {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " interstitialListener");
            this.mListener.onInterstitialAdShowSucceeded();
        }

        @Override // com.ironsource.sdk.listeners.OnInterstitialListener
        public void onInterstitialShowFailed(String str) {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " interstitialListener " + str);
            this.mListener.onInterstitialAdShowFailed(ErrorBuilder.buildShowFailedError("Interstitial", str));
        }

        @Override // com.ironsource.sdk.listeners.OnInterstitialListener
        public void onInterstitialClick() {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " interstitialListener");
            this.mListener.onInterstitialAdClicked();
        }

        @Override // com.ironsource.sdk.listeners.OnInterstitialListener
        public void onInterstitialEventNotificationReceived(String str, JSONObject jSONObject) {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " interstitialListener eventName=" + str);
            this.mListener.onInterstitialAdVisible();
        }
    }

    private class IronSourceBannerListener implements OnBannerListener {
        private String mDemandSourceName;
        private BannerSmashListener mListener;

        IronSourceBannerListener(BannerSmashListener bannerSmashListener, String str) {
            this.mDemandSourceName = str;
            this.mListener = bannerSmashListener;
        }

        @Override // com.ironsource.sdk.listeners.OnBannerListener
        public void onBannerInitSuccess() {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " bannerListener");
            this.mListener.onBannerInitSuccess();
        }

        @Override // com.ironsource.sdk.listeners.OnBannerListener
        public void onBannerInitFailed(String str) {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " bannerListener");
            this.mListener.onBannerInitFailed(new IronSourceError(IronSourceError.ERROR_BN_INSTANCE_INIT_ERROR, str));
        }

        @Override // com.ironsource.sdk.listeners.OnBannerListener
        public void onBannerClick() {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " bannerListener");
            this.mListener.onBannerAdClicked();
        }

        @Override // com.ironsource.sdk.listeners.OnBannerListener
        public void onBannerLoadSuccess() {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " bannerListener");
            IronSourceAdapter.this.mIsAlreadyShowing = true;
            if (IronSourceAdapter.mIsnAdView != null && IronSourceAdapter.mIsnAdView.getAdViewSize() != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(IronSourceAdapter.mIsnAdView.getAdViewSize().getWidth(), IronSourceAdapter.mIsnAdView.getAdViewSize().getHeight());
                layoutParams.gravity = 17;
                this.mListener.onBannerAdLoaded(IronSourceAdapter.mIsnAdView, layoutParams);
                this.mListener.onBannerAdShown();
            }
        }

        @Override // com.ironsource.sdk.listeners.OnBannerListener
        public void onBannerLoadFail(String str) {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " bannerListener");
            BannerSmashListener bannerSmashListener = this.mListener;
            bannerSmashListener.onBannerAdLoadFailed(ErrorBuilder.buildLoadFailedError(IronSourceAdapter.this.getProviderName() + " load failed - error = " + str));
        }
    }

    private void loadAdInternal(String str, String str2, boolean z, boolean z2, boolean z3) throws Exception {
        HashMap hashMap = new HashMap();
        if (str2 != null) {
            hashMap.put(Constants.ParametersKeys.ADM, AuctionDataUtils.getInstance().getAdmFromServerData(str2));
            hashMap.putAll(AuctionDataUtils.getInstance().getAuctionResponseServerDataParams(str2));
        }
        IronSourceAdInstance adInstance = getAdInstance(str, z, z2, z3);
        printInstanceExtraParams(hashMap);
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("demandSourceName=" + adInstance.getName());
        IronSourceNetwork.loadAd(ContextProvider.getInstance().getCurrentActiveActivity(), adInstance, hashMap);
    }

    private void showAdInternal(IronSourceAdInstance ironSourceAdInstance, int i) throws Exception {
        int sessionDepth = SessionDepthManager.getInstance().getSessionDepth(i);
        HashMap hashMap = new HashMap();
        hashMap.put("sessionDepth", String.valueOf(sessionDepth));
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("demandSourceName=" + ironSourceAdInstance.getName() + " showParams=" + hashMap);
        IronSourceNetwork.showAd(ironSourceAdInstance, hashMap);
    }

    private IronSourceAdInstance getAdInstance(String str, boolean z, boolean z2, boolean z3) {
        IronSourceAdInstance ironSourceAdInstance;
        IronSourceAdInstanceBuilder ironSourceAdInstanceBuilder;
        if (z3) {
            ironSourceAdInstance = this.mDemandSourceToRvAd.get(str);
        } else {
            ironSourceAdInstance = this.mDemandSourceToISAd.get(str);
        }
        if (ironSourceAdInstance == null) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose("creating ad instance for " + str + " isDemandOnlyForRv=" + z + " isBidder=" + z2 + " isRewarded=" + z3);
            if (z3) {
                ironSourceAdInstanceBuilder = new IronSourceAdInstanceBuilder(str, new IronSourceRewardedVideoListener(this.mDemandSourceToRvSmash.get(str), str, z)).setExtraParams(getInitParams());
                ironSourceAdInstanceBuilder.setRewarded();
            } else {
                ironSourceAdInstanceBuilder = new IronSourceAdInstanceBuilder(str, new IronSourceInterstitialListener(this.mDemandSourceToISSmash.get(str), str)).setExtraParams(getInitParams());
            }
            if (z2) {
                ironSourceAdInstanceBuilder.setInAppBidding();
            }
            ironSourceAdInstance = ironSourceAdInstanceBuilder.build();
            if (z3) {
                this.mDemandSourceToRvAd.put(str, ironSourceAdInstance);
            } else {
                this.mDemandSourceToISAd.put(str, ironSourceAdInstance);
            }
        }
        return ironSourceAdInstance;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0081, code lost:
        if (r11 != false) goto L_0x0086;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.ironsource.sdk.ISNAdView.ISNAdView createBanner(android.app.Activity r10, com.ironsource.mediationsdk.ISBannerSize r11, com.ironsource.mediationsdk.sdk.BannerSmashListener r12) {
        /*
        // Method dump skipped, instructions count: 216
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adapters.ironsource.IronSourceAdapter.createBanner(android.app.Activity, com.ironsource.mediationsdk.ISBannerSize, com.ironsource.mediationsdk.sdk.BannerSmashListener):com.ironsource.sdk.ISNAdView.ISNAdView");
    }

    @Override // com.ironsource.sdk.listeners.OnOfferWallListener
    public void onOWShowSuccess(String str) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(getProviderName() + ":onOWShowSuccess(placementId:" + str + ")");
        InternalOfferwallListener internalOfferwallListener = this.mOfferwallListener;
        if (internalOfferwallListener != null) {
            internalOfferwallListener.onOfferwallOpened();
        }
    }

    @Override // com.ironsource.sdk.listeners.OnOfferWallListener
    public void onOWShowFail(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        if (this.mOfferwallListener != null) {
            this.mOfferwallListener.onOfferwallShowFailed(ErrorBuilder.buildGenericError(str));
        }
    }

    @Override // com.ironsource.sdk.listeners.OnOfferWallListener
    public boolean onOWAdCredited(int i, int i2, boolean z) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        InternalOfferwallListener internalOfferwallListener = this.mOfferwallListener;
        return internalOfferwallListener != null && internalOfferwallListener.onOfferwallAdCredited(i, i2, z);
    }

    @Override // com.ironsource.sdk.listeners.OnOfferWallListener
    public void onGetOWCreditsFailed(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        if (this.mOfferwallListener != null) {
            this.mOfferwallListener.onGetOfferwallCreditsFailed(ErrorBuilder.buildGenericError(str));
        }
    }

    @Override // com.ironsource.sdk.listeners.OnOfferWallListener
    public void onOWAdClosed() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        InternalOfferwallListener internalOfferwallListener = this.mOfferwallListener;
        if (internalOfferwallListener != null) {
            internalOfferwallListener.onOfferwallClosed();
        }
    }

    @Override // com.ironsource.sdk.listeners.OnOfferWallListener
    public void onOfferwallInitSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        InternalOfferwallListener internalOfferwallListener = this.mOfferwallListener;
        if (internalOfferwallListener != null) {
            internalOfferwallListener.onOfferwallAvailable(true);
        }
    }

    @Override // com.ironsource.sdk.listeners.OnOfferWallListener
    public void onOfferwallInitFail(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        if (this.mOfferwallListener != null) {
            this.mOfferwallListener.onOfferwallAvailable(false, ErrorBuilder.buildGenericError(str));
        }
    }

    @Override // com.ironsource.sdk.listeners.OnOfferWallListener
    public void onOfferwallEventNotificationReceived(String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        }
    }

    private String getDemandSourceName(JSONObject jSONObject) {
        if (!TextUtils.isEmpty(jSONObject.optString("demandSourceName"))) {
            return jSONObject.optString("demandSourceName");
        }
        return getProviderName();
    }

    private boolean isValidMetaData(String str, String str2) {
        if (str.equals(MetaDataConstants.META_DATA_CCPA_KEY)) {
            return MetaDataUtils.isValidCCPAMetaData(str, str2);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public void setMetaData(String str, String str2) {
        if (!mDidInitSdk.get()) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose("key=" + str + ", value=" + str2);
            if (!isValidMetaData(str, str2)) {
                IronLog.ADAPTER_API.verbose("MetaData not valid");
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(str, str2);
                IronSourceNetwork.updateMetadata(jSONObject);
            } catch (JSONException e) {
                IronLog ironLog2 = IronLog.ADAPTER_API;
                ironLog2.error("error - " + e);
                e.printStackTrace();
            }
        }
    }

    private void printInstanceExtraParams(Map<String, String> map) {
        if (map != null && map.size() > 0) {
            IronLog.ADAPTER_API.verbose("instance extra params:");
            for (String str : map.keySet()) {
                IronLog ironLog = IronLog.ADAPTER_API;
                ironLog.verbose(str + Constants.RequestParameters.EQUAL + map.get(str));
            }
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public LoadWhileShowSupportState getLoadWhileShowSupportState(JSONObject jSONObject) {
        LoadWhileShowSupportState loadWhileShowSupportState = this.mLWSSupportState;
        return (jSONObject == null || !jSONObject.optBoolean("isSupportedLWS")) ? loadWhileShowSupportState : LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_INSTANCE;
    }
}
