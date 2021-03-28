package com.ironsource.adapters.supersonicads;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.google.firebase.messaging.Constants;
import com.ironsource.environment.TokenConstants;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.AbstractSmash;
import com.ironsource.mediationsdk.IntegrationData;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.IronSourceObject;
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
import com.ironsource.sdk.IronSourceNetwork;
import com.ironsource.sdk.SSAFactory;
import com.ironsource.sdk.SSAPublisher;
import com.ironsource.sdk.constants.Constants;
import com.ironsource.sdk.constants.Events;
import com.ironsource.sdk.data.AdUnitsReady;
import com.ironsource.sdk.data.ISNEnums;
import com.ironsource.sdk.listeners.OnBannerListener;
import com.ironsource.sdk.listeners.OnInterstitialListener;
import com.ironsource.sdk.listeners.OnOfferWallListener;
import com.ironsource.sdk.listeners.OnRewardedVideoListener;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

class SupersonicAdsAdapter extends AbstractAdapter implements OfferwallAdapterApi, OnOfferWallListener, OnInterstitialListener, OnRewardedVideoListener, OnBannerListener, ContextProvider.ContextLifeCycleListener {
    private static final String VERSION = "7.1.1";
    private static AtomicBoolean mDidInitSdk = new AtomicBoolean(false);
    private static AtomicBoolean mDidSetInitParams = new AtomicBoolean(false);
    private final String AD_VISIBLE_EVENT_NAME = "impressions";
    private final String APPLICATION_PRIVATE_KEY = "privateKey";
    private final String CAMPAIGN_ID = Constants.FirelogAnalytics.PARAM_CAMPAIGN_ID;
    private final String CLIENT_SIDE_CALLBACKS = "useClientSideCallbacks";
    private final String CUSTOM_PARAM_PREFIX = "custom_";
    private final String CUSTOM_SEGMENT = "custom_Segment";
    private final String DYNAMIC_CONTROLLER_CONFIG = Constants.RequestParameters.CONTROLLER_CONFIG;
    private final String DYNAMIC_CONTROLLER_DEBUG_MODE = Constants.FeaturesManager.DEBUG_MODE;
    private final String DYNAMIC_CONTROLLER_URL = "controllerUrl";
    private final String ITEM_COUNT = "itemCount";
    private final String ITEM_NAME = "itemName";
    private final String ITEM_SIGNATURE = "itemSignature";
    private final String LANGUAGE = "language";
    private final String MAX_VIDEO_LENGTH = "maxVideoLength";
    private final String OW_PLACEMENT_ID = "placementId";
    private final String SDK_PLUGIN_TYPE = TokenConstants.SDK_PLUGIN_TYPE;
    private final String SESSION_ID = Events.SESSION_ID;
    private final String SUPERSONIC_ADS = IronSourceConstants.SUPERSONIC_CONFIG_NAME;
    private final String TIMESTAMP = "timestamp";
    private AtomicBoolean isRVInitiated;
    private boolean mConsent;
    private boolean mDidSetConsent;
    private boolean mIsAlreadyShowing;
    private boolean mIsRVAvailable = false;
    private ISNAdView mIsnAdView;
    private String mMediationSegment;
    private InternalOfferwallListener mOfferwallListener;
    private SSAPublisher mSSAPublisher;

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getVersion() {
        return "7.1.1";
    }

    @Override // com.ironsource.mediationsdk.sdk.OfferwallAdapterApi
    public boolean isOfferwallAvailable() {
        return true;
    }

    @Override // com.ironsource.sdk.listeners.OnInterstitialListener
    public void onInterstitialAdRewarded(String str, int i) {
    }

    public static SupersonicAdsAdapter startAdapter(String str) {
        return new SupersonicAdsAdapter(str);
    }

    private SupersonicAdsAdapter(String str) {
        super(str);
        IronLog.INTERNAL.verbose("");
        this.isRVInitiated = new AtomicBoolean(false);
        ContextProvider.getInstance().registerLifeCycleListener(this);
        this.mIsAlreadyShowing = false;
    }

    public static IntegrationData getIntegrationData(Activity activity) {
        IntegrationData integrationData = new IntegrationData(IronSourceConstants.SUPERSONIC_CONFIG_NAME, "7.1.1");
        integrationData.activities = new String[]{"com.ironsource.sdk.controller.ControllerActivity", "com.ironsource.sdk.controller.InterstitialActivity", "com.ironsource.sdk.controller.OpenUrlActivity"};
        integrationData.providers = new String[]{"com.ironsource.lifecycle.IronsourceLifecycleProvider"};
        return integrationData;
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getCoreSDKVersion() {
        return SDKUtils.getSDKVersion();
    }

    public static String getAdapterSDKVersion() {
        return SDKUtils.getSDKVersion();
    }

    @Override // com.ironsource.mediationsdk.utils.ContextProvider.ContextLifeCycleListener
    public void onPause(Activity activity) {
        if (this.mSSAPublisher != null) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose(getProviderName() + " mSSAPublisher.onPause");
            this.mSSAPublisher.onPause(activity);
        }
    }

    @Override // com.ironsource.mediationsdk.utils.ContextProvider.ContextLifeCycleListener
    public void onResume(Activity activity) {
        if (this.mSSAPublisher != null) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose(getProviderName() + " mSSAPublisher.onResume");
            this.mSSAPublisher.onResume(activity);
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.BaseApi
    public void setMediationSegment(String str) {
        this.mMediationSegment = str;
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoAdapterApi
    public void initRewardedVideo(final String str, String str2, final JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        if (this.isRVInitiated.compareAndSet(false, true)) {
            setParamsBeforeInit(jSONObject);
            postOnUIThread(new Runnable() {
                /* class com.ironsource.adapters.supersonicads.SupersonicAdsAdapter.AnonymousClass1 */

                public void run() {
                    try {
                        String mediationUserId = IronSourceUtils.getMediationUserId();
                        SupersonicAdsAdapter.this.mSSAPublisher = SSAFactory.getPublisherInstance(ContextProvider.getInstance().getCurrentActiveActivity());
                        HashMap rewardedVideoExtraParams = SupersonicAdsAdapter.this.getRewardedVideoExtraParams(jSONObject);
                        if (SupersonicAdsAdapter.this.mDidSetConsent) {
                            SupersonicAdsAdapter.this.applyConsent(SupersonicAdsAdapter.this.mConsent);
                        }
                        IronLog ironLog = IronLog.ADAPTER_API;
                        ironLog.verbose(SupersonicAdsAdapter.this.getProviderName() + " mSSAPublisher.initRewardedVideo userId=" + mediationUserId);
                        SupersonicAdsAdapter.this.mSSAPublisher.initRewardedVideo(str, mediationUserId, SupersonicAdsAdapter.this.getProviderName(), rewardedVideoExtraParams, SupersonicAdsAdapter.this);
                        SupersonicAdsAdapter.mDidInitSdk.set(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                        SupersonicAdsAdapter.this.onRVInitFail(Constants.JSMethods.INIT_REWARDED_VIDEO);
                    }
                }
            });
            return;
        }
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose(getProviderName() + " adapter already initiated");
        fetchRewardedVideoForAutomaticLoad(jSONObject, rewardedVideoSmashListener);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoAdapterApi
    public void fetchRewardedVideoForAutomaticLoad(JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        IronLog.ADAPTER_API.verbose(getProviderName());
        Iterator it = this.mAllRewardedVideoSmashes.iterator();
        while (it.hasNext()) {
            RewardedVideoSmashListener rewardedVideoSmashListener2 = (RewardedVideoSmashListener) it.next();
            if (rewardedVideoSmashListener2 != null) {
                rewardedVideoSmashListener2.onRewardedVideoAvailabilityChanged(this.mIsRVAvailable);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoAdapterApi
    public void showRewardedVideo(JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        this.mActiveRewardedVideoSmash = rewardedVideoSmashListener;
        if (this.mSSAPublisher != null) {
            int sessionDepth = SessionDepthManager.getInstance().getSessionDepth(1);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("demandSourceName", getProviderName());
                jSONObject2.put("sessionDepth", sessionDepth);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose(getProviderName() + " mSSAPublisher.showRewardedVideo");
            this.mSSAPublisher.showRewardedVideo(jSONObject2);
            return;
        }
        this.mIsRVAvailable = false;
        if (this.mActiveRewardedVideoSmash != null) {
            this.mActiveRewardedVideoSmash.onRewardedVideoAdShowFailed(ErrorBuilder.buildNoAdsToShowError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
        }
        Iterator it = this.mAllRewardedVideoSmashes.iterator();
        while (it.hasNext()) {
            RewardedVideoSmashListener rewardedVideoSmashListener2 = (RewardedVideoSmashListener) it.next();
            if (rewardedVideoSmashListener2 != null) {
                rewardedVideoSmashListener2.onRewardedVideoAvailabilityChanged(false);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoAdapterApi
    public boolean isRewardedVideoAvailable(JSONObject jSONObject) {
        return this.mIsRVAvailable;
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialAdapterApi
    public void initInterstitial(final String str, String str2, JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        setParamsBeforeInit(jSONObject);
        postOnUIThread(new Runnable() {
            /* class com.ironsource.adapters.supersonicads.SupersonicAdsAdapter.AnonymousClass2 */

            public void run() {
                try {
                    String mediationUserId = IronSourceUtils.getMediationUserId();
                    SupersonicAdsAdapter.this.mSSAPublisher = SSAFactory.getPublisherInstance(ContextProvider.getInstance().getCurrentActiveActivity());
                    HashMap interstitialExtraParams = SupersonicAdsAdapter.this.getInterstitialExtraParams();
                    if (SupersonicAdsAdapter.this.mDidSetConsent) {
                        SupersonicAdsAdapter.this.applyConsent(SupersonicAdsAdapter.this.mConsent);
                    }
                    IronLog ironLog = IronLog.ADAPTER_API;
                    ironLog.verbose(SupersonicAdsAdapter.this.getProviderName() + " mSSAPublisher.initInterstitial userId=" + mediationUserId);
                    SupersonicAdsAdapter.this.mSSAPublisher.initInterstitial(str, mediationUserId, SupersonicAdsAdapter.this.getProviderName(), interstitialExtraParams, SupersonicAdsAdapter.this);
                    SupersonicAdsAdapter.mDidInitSdk.set(true);
                } catch (Exception e) {
                    e.printStackTrace();
                    SupersonicAdsAdapter.this.onInterstitialInitFailed(e.getMessage());
                }
            }
        });
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialAdapterApi
    public void loadInterstitial(JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        if (this.mSSAPublisher != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("demandSourceName", getProviderName());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose(getProviderName() + " mSSAPublisher.loadInterstitial");
            this.mSSAPublisher.loadInterstitial(jSONObject2);
            return;
        }
        IronLog.INTERNAL.error("Please call initInterstitial before calling loadInterstitial");
        Iterator it = this.mAllInterstitialSmashes.iterator();
        while (it.hasNext()) {
            InterstitialSmashListener interstitialSmashListener2 = (InterstitialSmashListener) it.next();
            if (interstitialSmashListener2 != null) {
                interstitialSmashListener2.onInterstitialAdLoadFailed(ErrorBuilder.buildLoadFailedError("Load was called before Init"));
            }
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialAdapterApi
    public void showInterstitial(JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        this.mActiveInterstitialSmash = interstitialSmashListener;
        if (this.mSSAPublisher != null) {
            int sessionDepth = SessionDepthManager.getInstance().getSessionDepth(2);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("demandSourceName", getProviderName());
                jSONObject2.put("sessionDepth", sessionDepth);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose(getProviderName() + " mSSAPublisher.showInterstitial");
            this.mSSAPublisher.showInterstitial(jSONObject2);
            return;
        }
        IronLog.INTERNAL.error("Please call loadInterstitialForBidding before calling showInterstitial");
        if (this.mActiveInterstitialSmash != null) {
            this.mActiveInterstitialSmash.onInterstitialAdShowFailed(ErrorBuilder.buildNoAdsToShowError("Interstitial"));
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialAdapterApi
    public boolean isInterstitialReady(JSONObject jSONObject) {
        SSAPublisher sSAPublisher = this.mSSAPublisher;
        return sSAPublisher != null && sSAPublisher.isInterstitialAdAvailable(getProviderName());
    }

    @Override // com.ironsource.mediationsdk.sdk.OfferwallAdapterApi
    public void setInternalOfferwallListener(InternalOfferwallListener internalOfferwallListener) {
        this.mOfferwallListener = internalOfferwallListener;
    }

    @Override // com.ironsource.mediationsdk.sdk.OfferwallAdapterApi
    public void initOfferwall(final String str, final String str2, final JSONObject jSONObject) {
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose(getProviderName() + " userId=" + str2);
        setParamsBeforeInit(jSONObject);
        postOnUIThread(new Runnable() {
            /* class com.ironsource.adapters.supersonicads.SupersonicAdsAdapter.AnonymousClass3 */

            public void run() {
                try {
                    HashMap offerwallExtraParams = SupersonicAdsAdapter.this.getOfferwallExtraParams(jSONObject);
                    SupersonicAdsAdapter.this.mSSAPublisher = SSAFactory.getPublisherInstance(ContextProvider.getInstance().getCurrentActiveActivity());
                    if (SupersonicAdsAdapter.this.mDidSetConsent) {
                        SupersonicAdsAdapter.this.applyConsent(SupersonicAdsAdapter.this.mConsent);
                    }
                    IronLog ironLog = IronLog.ADAPTER_API;
                    ironLog.verbose(SupersonicAdsAdapter.this.getProviderName() + " mSSAPublisher.initOfferWall");
                    SupersonicAdsAdapter.this.mSSAPublisher.initOfferWall(str, str2, offerwallExtraParams, SupersonicAdsAdapter.this);
                    SupersonicAdsAdapter.mDidInitSdk.set(true);
                } catch (Exception e) {
                    e.printStackTrace();
                    IronLog ironLog2 = IronLog.ADAPTER_API;
                    ironLog2.error(SupersonicAdsAdapter.this.getProviderName() + ":initOfferwall(userId:" + str2 + ")" + e);
                    InternalOfferwallListener internalOfferwallListener = SupersonicAdsAdapter.this.mOfferwallListener;
                    internalOfferwallListener.onOfferwallAvailable(false, ErrorBuilder.buildInitFailedError("Adapter initialization failure - " + SupersonicAdsAdapter.this.getProviderName() + " - " + e.getMessage(), IronSourceConstants.OFFERWALL_AD_UNIT));
                }
            }
        });
    }

    @Override // com.ironsource.mediationsdk.sdk.OfferwallAdapterApi
    public void getOfferwallCredits() {
        if (this.mSSAPublisher != null) {
            String ironSourceAppKey = IronSourceObject.getInstance().getIronSourceAppKey();
            String ironSourceUserId = IronSourceObject.getInstance().getIronSourceUserId();
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose(getProviderName() + " mSSAPublisher.getOfferWallCredits userId=" + ironSourceUserId);
            this.mSSAPublisher.getOfferWallCredits(ironSourceAppKey, ironSourceUserId, this);
            return;
        }
        IronLog.INTERNAL.error("Please call init before calling getOfferwallCredits");
    }

    @Override // com.ironsource.mediationsdk.sdk.OfferwallAdapterApi
    public void showOfferwall(String str, JSONObject jSONObject) {
        HashMap<String, String> offerwallExtraParams = getOfferwallExtraParams(jSONObject);
        if (offerwallExtraParams != null) {
            offerwallExtraParams.put("placementId", str);
        }
        if (this.mSSAPublisher != null) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose(getProviderName() + " mSSAPublisher.showOfferWall");
            this.mSSAPublisher.showOfferWall(offerwallExtraParams);
            return;
        }
        IronLog.INTERNAL.error("Please call init before calling showOfferwall");
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerAdapterApi, com.ironsource.mediationsdk.AbstractAdapter
    public void initBanners(final String str, String str2, final JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
        IronLog.ADAPTER_API.verbose(getProviderName());
        setParamsBeforeInit(jSONObject);
        postOnUIThread(new Runnable() {
            /* class com.ironsource.adapters.supersonicads.SupersonicAdsAdapter.AnonymousClass4 */

            public void run() {
                try {
                    String mediationUserId = IronSourceUtils.getMediationUserId();
                    HashMap bannerExtraParams = SupersonicAdsAdapter.this.getBannerExtraParams(jSONObject);
                    SupersonicAdsAdapter.this.mSSAPublisher = SSAFactory.getPublisherInstance(ContextProvider.getInstance().getCurrentActiveActivity());
                    if (SupersonicAdsAdapter.this.mDidSetConsent) {
                        SupersonicAdsAdapter.this.applyConsent(SupersonicAdsAdapter.this.mConsent);
                    }
                    IronLog ironLog = IronLog.ADAPTER_API;
                    ironLog.verbose(SupersonicAdsAdapter.this.getProviderName() + " mSSAPublisher.initBanner userId=" + mediationUserId);
                    SupersonicAdsAdapter.this.mSSAPublisher.initBanner(str, mediationUserId, SupersonicAdsAdapter.this.getProviderName(), bannerExtraParams, SupersonicAdsAdapter.this);
                    SupersonicAdsAdapter.mDidInitSdk.set(true);
                } catch (Exception e) {
                    e.printStackTrace();
                    SupersonicAdsAdapter.this.onBannerInitFailed(e.getMessage());
                }
            }
        });
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerAdapterApi, com.ironsource.mediationsdk.AbstractAdapter
    public void loadBanner(final IronSourceBannerLayout ironSourceBannerLayout, JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
        try {
            if (this.mSSAPublisher == null) {
                IronLog.INTERNAL.error("Please call initBanner before calling loadBanner");
                Iterator it = this.mAllBannerSmashes.iterator();
                while (it.hasNext()) {
                    BannerSmashListener bannerSmashListener2 = (BannerSmashListener) it.next();
                    if (bannerSmashListener2 != null) {
                        bannerSmashListener2.onBannerAdLoadFailed(ErrorBuilder.buildLoadFailedError("Load was called before Init"));
                    }
                }
            }
            this.mActiveBannerSmash = bannerSmashListener;
            if (this.mIsnAdView != null && !this.mIsAlreadyShowing) {
                this.mIsnAdView.performCleanup();
                this.mIsnAdView = null;
            }
            final JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("demandSourceName", getProviderName());
            jSONObject2.put(Constants.ParametersKeys.PRODUCT_TYPE, ISNEnums.ProductType.Banner);
            postOnUIThread(new Runnable() {
                /* class com.ironsource.adapters.supersonicads.SupersonicAdsAdapter.AnonymousClass5 */

                public void run() {
                    try {
                        if (!SupersonicAdsAdapter.this.mIsAlreadyShowing) {
                            SupersonicAdsAdapter.this.mIsnAdView = SupersonicAdsAdapter.this.createBanner(ironSourceBannerLayout.getActivity(), ironSourceBannerLayout.getSize(), SupersonicAdsAdapter.this.mActiveBannerSmash);
                        }
                        if (SupersonicAdsAdapter.this.mIsnAdView != null) {
                            IronLog.ADAPTER_API.verbose("mIsnAdView.loadAd");
                            SupersonicAdsAdapter.this.mIsnAdView.loadAd(jSONObject2);
                        }
                    } catch (Exception e) {
                        IronSourceError buildLoadFailedError = ErrorBuilder.buildLoadFailedError("Banner Load Fail, " + SupersonicAdsAdapter.this.getProviderName() + " - " + e.getMessage());
                        if (SupersonicAdsAdapter.this.mActiveBannerSmash != null) {
                            SupersonicAdsAdapter.this.mActiveBannerSmash.onBannerAdLoadFailed(buildLoadFailedError);
                        }
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerAdapterApi, com.ironsource.mediationsdk.AbstractAdapter
    public void reloadBanner(IronSourceBannerLayout ironSourceBannerLayout, JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
        try {
            if (this.mIsnAdView != null) {
                IronLog.ADAPTER_API.verbose("mIsnAdView.loadAd");
                this.mIsnAdView.loadAd(jSONObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error(getProviderName() + " reloadBanner Failed to reload banner ad");
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerAdapterApi, com.ironsource.mediationsdk.AbstractAdapter
    public void destroyBanner(JSONObject jSONObject) {
        this.mIsAlreadyShowing = false;
        if (this.mIsnAdView != null) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose(getProviderName() + " mIsnAdView.performCleanup");
            this.mIsnAdView.performCleanup();
            this.mIsnAdView = null;
        }
    }

    private void setParamsBeforeInit(JSONObject jSONObject) {
        if (mDidSetInitParams.compareAndSet(false, true)) {
            SDKUtils.setControllerUrl(jSONObject.optString("controllerUrl"));
            int optInt = jSONObject.optInt(Constants.FeaturesManager.DEBUG_MODE, 0);
            if (isAdaptersDebugEnabled()) {
                optInt = 3;
            }
            SDKUtils.setDebugMode(optInt);
            SDKUtils.setControllerConfig(jSONObject.optString(Constants.RequestParameters.CONTROLLER_CONFIG, ""));
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose(getProviderName() + "setting controller url to  " + jSONObject.optString("controllerUrl"));
            IronLog ironLog2 = IronLog.ADAPTER_API;
            ironLog2.verbose(getProviderName() + "setting controller config to  " + jSONObject.optString(Constants.RequestParameters.CONTROLLER_CONFIG));
            IronLog ironLog3 = IronLog.ADAPTER_API;
            ironLog3.verbose(getProviderName() + "setting debug mode to " + optInt);
        }
    }

    private HashMap<String, String> getGenenralExtraParams() {
        HashMap<String, String> hashMap = new HashMap<>();
        String pluginType = getPluginType();
        if (!TextUtils.isEmpty(pluginType)) {
            hashMap.put(TokenConstants.SDK_PLUGIN_TYPE, pluginType);
        }
        return hashMap;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private HashMap<String, String> getRewardedVideoExtraParams(JSONObject jSONObject) {
        HashMap<String, String> genenralExtraParams = getGenenralExtraParams();
        String optString = jSONObject.optString("language");
        if (!TextUtils.isEmpty(optString)) {
            genenralExtraParams.put("language", optString);
        }
        String optString2 = jSONObject.optString("maxVideoLength");
        if (!TextUtils.isEmpty(optString2)) {
            genenralExtraParams.put("maxVideoLength", optString2);
        }
        String optString3 = jSONObject.optString(Constants.FirelogAnalytics.PARAM_CAMPAIGN_ID);
        if (!TextUtils.isEmpty(optString3)) {
            genenralExtraParams.put(Constants.FirelogAnalytics.PARAM_CAMPAIGN_ID, optString3);
        }
        if (!TextUtils.isEmpty(this.mMediationSegment)) {
            genenralExtraParams.put("custom_Segment", this.mMediationSegment);
        }
        addItemNameCountSignature(genenralExtraParams, jSONObject);
        Map<String, String> rewardedVideoCustomParams = SupersonicConfig.getConfigObj().getRewardedVideoCustomParams();
        if (rewardedVideoCustomParams != null && !rewardedVideoCustomParams.isEmpty()) {
            genenralExtraParams.putAll(rewardedVideoCustomParams);
        }
        return genenralExtraParams;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private HashMap<String, String> getInterstitialExtraParams() {
        return getGenenralExtraParams();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private HashMap<String, String> getOfferwallExtraParams(JSONObject jSONObject) {
        HashMap<String, String> genenralExtraParams = getGenenralExtraParams();
        String optString = jSONObject.optString("language");
        if (!TextUtils.isEmpty(optString)) {
            genenralExtraParams.put("language", optString);
        }
        genenralExtraParams.put("useClientSideCallbacks", String.valueOf(SupersonicConfig.getConfigObj().getClientSideCallbacks()));
        Map<String, String> offerwallCustomParams = SupersonicConfig.getConfigObj().getOfferwallCustomParams();
        if (offerwallCustomParams != null && !offerwallCustomParams.isEmpty()) {
            genenralExtraParams.putAll(offerwallCustomParams);
        }
        addItemNameCountSignature(genenralExtraParams, jSONObject);
        return genenralExtraParams;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private HashMap<String, String> getBannerExtraParams(JSONObject jSONObject) {
        return getGenenralExtraParams();
    }

    private void addItemNameCountSignature(HashMap<String, String> hashMap, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("itemName");
            int optInt = jSONObject.optInt("itemCount", -1);
            String optString2 = jSONObject.optString("privateKey");
            boolean z = true;
            boolean z2 = false;
            if (TextUtils.isEmpty(optString)) {
                z = false;
            } else {
                hashMap.put("itemName", optString);
            }
            if (TextUtils.isEmpty(optString2)) {
                z = false;
            }
            if (optInt != -1) {
                hashMap.put("itemCount", String.valueOf(optInt));
                z2 = z;
            }
            if (z2) {
                int currentTimestamp = IronSourceUtils.getCurrentTimestamp();
                hashMap.put("timestamp", String.valueOf(currentTimestamp));
                hashMap.put("itemSignature", createItemSig(currentTimestamp, optString, optInt, optString2));
            }
        } catch (Exception e) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.error(" addItemNameCountSignature" + e);
        }
    }

    private String createItemSig(int i, String str, int i2, String str2) {
        return IronSourceUtils.getMD5(i + str + i2 + str2);
    }

    private String createMinimumOfferCommissionSig(double d, String str) {
        return IronSourceUtils.getMD5(d + str);
    }

    private String createUserCreationDateSig(String str, String str2, String str3) {
        return IronSourceUtils.getMD5(str + str2 + str3);
    }

    /* access modifiers changed from: private */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x007b, code lost:
        if (r10 != false) goto L_0x0080;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.ironsource.sdk.ISNAdView.ISNAdView createBanner(android.app.Activity r9, com.ironsource.mediationsdk.ISBannerSize r10, com.ironsource.mediationsdk.sdk.BannerSmashListener r11) {
        /*
        // Method dump skipped, instructions count: 170
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adapters.supersonicads.SupersonicAdsAdapter.createBanner(android.app.Activity, com.ironsource.mediationsdk.ISBannerSize, com.ironsource.mediationsdk.sdk.BannerSmashListener):com.ironsource.sdk.ISNAdView.ISNAdView");
    }

    @Override // com.ironsource.sdk.listeners.OnRewardedVideoListener
    public void onRVNoMoreOffers() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        this.mIsRVAvailable = false;
        Iterator it = this.mAllRewardedVideoSmashes.iterator();
        while (it.hasNext()) {
            RewardedVideoSmashListener rewardedVideoSmashListener = (RewardedVideoSmashListener) it.next();
            if (rewardedVideoSmashListener != null) {
                rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
            }
        }
    }

    @Override // com.ironsource.sdk.listeners.OnRewardedVideoListener
    public void onRVInitSuccess(AdUnitsReady adUnitsReady) {
        int i;
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        boolean z = false;
        try {
            i = Integer.parseInt(adUnitsReady.getNumOfAdUnits());
        } catch (NumberFormatException e) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("parseInt()" + e);
            i = 0;
        }
        if (i > 0) {
            z = true;
        }
        this.mIsRVAvailable = z;
        Iterator it = this.mAllRewardedVideoSmashes.iterator();
        while (it.hasNext()) {
            RewardedVideoSmashListener rewardedVideoSmashListener = (RewardedVideoSmashListener) it.next();
            if (rewardedVideoSmashListener != null) {
                rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(z);
            }
        }
    }

    @Override // com.ironsource.sdk.listeners.OnRewardedVideoListener
    public void onRVInitFail(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        Iterator it = this.mAllRewardedVideoSmashes.iterator();
        while (it.hasNext()) {
            RewardedVideoSmashListener rewardedVideoSmashListener = (RewardedVideoSmashListener) it.next();
            if (rewardedVideoSmashListener != null) {
                rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
            }
        }
    }

    @Override // com.ironsource.sdk.listeners.OnRewardedVideoListener
    public void onRVAdClicked() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        if (this.mActiveRewardedVideoSmash != null) {
            this.mActiveRewardedVideoSmash.onRewardedVideoAdClicked();
        }
    }

    @Override // com.ironsource.sdk.listeners.OnRewardedVideoListener
    public void onRVEventNotificationReceived(String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(getProviderName() + " " + str + " extData: " + jSONObject.toString());
        }
        if (!TextUtils.isEmpty(str) && "impressions".equals(str) && this.mActiveRewardedVideoSmash != null) {
            this.mActiveRewardedVideoSmash.onRewardedVideoAdVisible();
        }
    }

    @Override // com.ironsource.sdk.listeners.OnRewardedVideoListener
    public void onRVShowFail(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        if (this.mActiveRewardedVideoSmash != null) {
            this.mActiveRewardedVideoSmash.onRewardedVideoAdShowFailed(new IronSourceError(IronSourceError.ERROR_CODE_NO_ADS_TO_SHOW, str));
        }
    }

    @Override // com.ironsource.sdk.listeners.OnRewardedVideoListener
    public void onRVAdCredited(int i) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        if (this.mActiveRewardedVideoSmash != null) {
            this.mActiveRewardedVideoSmash.onRewardedVideoAdRewarded();
        }
    }

    @Override // com.ironsource.sdk.listeners.OnRewardedVideoListener
    public void onRVAdClosed() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        if (this.mActiveRewardedVideoSmash != null) {
            this.mActiveRewardedVideoSmash.onRewardedVideoAdClosed();
        }
    }

    @Override // com.ironsource.sdk.listeners.OnRewardedVideoListener
    public void onRVAdOpened() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        if (this.mActiveRewardedVideoSmash != null) {
            this.mActiveRewardedVideoSmash.onRewardedVideoAdOpened();
        }
    }

    @Override // com.ironsource.sdk.listeners.OnInterstitialListener
    public void onInterstitialInitSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        Iterator it = this.mAllInterstitialSmashes.iterator();
        while (it.hasNext()) {
            InterstitialSmashListener interstitialSmashListener = (InterstitialSmashListener) it.next();
            if (interstitialSmashListener != null) {
                interstitialSmashListener.onInterstitialInitSuccess();
            }
        }
    }

    @Override // com.ironsource.sdk.listeners.OnInterstitialListener
    public void onInterstitialInitFailed(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        Iterator it = this.mAllInterstitialSmashes.iterator();
        while (it.hasNext()) {
            InterstitialSmashListener interstitialSmashListener = (InterstitialSmashListener) it.next();
            if (interstitialSmashListener != null) {
                interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError(str, "Interstitial"));
            }
        }
    }

    @Override // com.ironsource.sdk.listeners.OnInterstitialListener
    public void onInterstitialLoadSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        Iterator it = this.mAllInterstitialSmashes.iterator();
        while (it.hasNext()) {
            InterstitialSmashListener interstitialSmashListener = (InterstitialSmashListener) it.next();
            if (interstitialSmashListener != null) {
                interstitialSmashListener.onInterstitialAdReady();
            }
        }
    }

    @Override // com.ironsource.sdk.listeners.OnInterstitialListener
    public void onInterstitialLoadFailed(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        Iterator it = this.mAllInterstitialSmashes.iterator();
        while (it.hasNext()) {
            InterstitialSmashListener interstitialSmashListener = (InterstitialSmashListener) it.next();
            if (interstitialSmashListener != null) {
                interstitialSmashListener.onInterstitialAdLoadFailed(ErrorBuilder.buildLoadFailedError(str));
            }
        }
    }

    @Override // com.ironsource.sdk.listeners.OnInterstitialListener
    public void onInterstitialOpen() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        if (this.mActiveInterstitialSmash != null) {
            this.mActiveInterstitialSmash.onInterstitialAdOpened();
        }
    }

    @Override // com.ironsource.sdk.listeners.OnInterstitialListener
    public void onInterstitialClose() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        if (this.mActiveInterstitialSmash != null) {
            this.mActiveInterstitialSmash.onInterstitialAdClosed();
        }
    }

    @Override // com.ironsource.sdk.listeners.OnInterstitialListener
    public void onInterstitialShowSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        if (this.mActiveInterstitialSmash != null) {
            this.mActiveInterstitialSmash.onInterstitialAdShowSucceeded();
        }
    }

    @Override // com.ironsource.sdk.listeners.OnInterstitialListener
    public void onInterstitialShowFailed(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        if (this.mActiveInterstitialSmash != null) {
            this.mActiveInterstitialSmash.onInterstitialAdShowFailed(ErrorBuilder.buildShowFailedError("Interstitial", str));
        }
    }

    @Override // com.ironsource.sdk.listeners.OnInterstitialListener
    public void onInterstitialClick() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        if (this.mActiveInterstitialSmash != null) {
            this.mActiveInterstitialSmash.onInterstitialAdClicked();
        }
    }

    @Override // com.ironsource.sdk.listeners.OnInterstitialListener
    public void onInterstitialEventNotificationReceived(String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(getProviderName() + " " + str + " extData: " + jSONObject.toString());
            if (!TextUtils.isEmpty(str) && "impressions".equals(str) && this.mActiveInterstitialSmash != null) {
                this.mActiveInterstitialSmash.onInterstitialAdVisible();
            }
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

    @Override // com.ironsource.sdk.listeners.OnOfferWallListener
    public void onOWShowSuccess(String str) {
        if (TextUtils.isEmpty(str)) {
            IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        } else {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(getProviderName() + ":onOWShowSuccess(placementId:" + str + ")");
        }
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
    public void onOWAdClosed() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        InternalOfferwallListener internalOfferwallListener = this.mOfferwallListener;
        if (internalOfferwallListener != null) {
            internalOfferwallListener.onOfferwallClosed();
        }
    }

    @Override // com.ironsource.sdk.listeners.OnOfferWallListener
    public void onGetOWCreditsFailed(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        if (this.mOfferwallListener != null) {
            this.mOfferwallListener.onGetOfferwallCreditsFailed(ErrorBuilder.buildGenericError(str));
        }
    }

    @Override // com.ironsource.sdk.listeners.OnBannerListener
    public void onBannerInitSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        Iterator it = this.mAllBannerSmashes.iterator();
        while (it.hasNext()) {
            BannerSmashListener bannerSmashListener = (BannerSmashListener) it.next();
            if (bannerSmashListener != null) {
                bannerSmashListener.onBannerInitSuccess();
            }
        }
    }

    @Override // com.ironsource.sdk.listeners.OnBannerListener
    public void onBannerInitFailed(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        Iterator it = this.mAllBannerSmashes.iterator();
        while (it.hasNext()) {
            BannerSmashListener bannerSmashListener = (BannerSmashListener) it.next();
            if (bannerSmashListener != null) {
                bannerSmashListener.onBannerInitFailed(ErrorBuilder.buildInitFailedError(str, IronSourceConstants.BANNER_AD_UNIT));
            }
        }
    }

    @Override // com.ironsource.sdk.listeners.OnBannerListener
    public void onBannerClick() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        if (this.mActiveBannerSmash != null) {
            this.mActiveBannerSmash.onBannerAdClicked();
        }
    }

    @Override // com.ironsource.sdk.listeners.OnBannerListener
    public void onBannerLoadSuccess() {
        ISNAdView iSNAdView;
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        this.mIsAlreadyShowing = true;
        Iterator it = this.mAllBannerSmashes.iterator();
        while (it.hasNext()) {
            BannerSmashListener bannerSmashListener = (BannerSmashListener) it.next();
            if (!(bannerSmashListener == null || (iSNAdView = this.mIsnAdView) == null || iSNAdView.getAdViewSize() == null)) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mIsnAdView.getAdViewSize().getWidth(), this.mIsnAdView.getAdViewSize().getHeight());
                layoutParams.gravity = 17;
                bannerSmashListener.onBannerAdLoaded(this.mIsnAdView, layoutParams);
            }
        }
        if (this.mActiveBannerSmash != null) {
            this.mActiveBannerSmash.onBannerAdShown();
        }
    }

    @Override // com.ironsource.sdk.listeners.OnBannerListener
    public void onBannerLoadFail(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        Iterator it = this.mAllBannerSmashes.iterator();
        while (it.hasNext()) {
            BannerSmashListener bannerSmashListener = (BannerSmashListener) it.next();
            if (bannerSmashListener != null) {
                bannerSmashListener.onBannerAdLoadFailed(ErrorBuilder.buildInitFailedError(str, IronSourceConstants.BANNER_AD_UNIT));
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public void addBannerListener(BannerSmashListener bannerSmashListener) {
        this.mAllBannerSmashes.add(bannerSmashListener);
    }

    /* access modifiers changed from: protected */
    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public void removeBannerListener(BannerSmashListener bannerSmashListener) {
        this.mAllBannerSmashes.remove(bannerSmashListener);
    }

    /* access modifiers changed from: protected */
    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public void setMediationState(AbstractSmash.MEDIATION_STATE mediation_state, String str) {
        if (this.mSSAPublisher != null) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose(getProviderName() + ": setMediationState(" + str + " , " + getProviderName() + " , " + mediation_state.getValue() + ")");
            this.mSSAPublisher.setMediationState(str, getProviderName(), mediation_state.getValue());
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public void setConsent(boolean z) {
        IronLog ironLog = IronLog.ADAPTER_API;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(": setConsent (");
        sb.append(z ? "true" : "false");
        sb.append(")");
        ironLog.verbose(sb.toString());
        this.mDidSetConsent = true;
        this.mConsent = z;
        applyConsent(z);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void applyConsent(boolean z) {
        if (this.mSSAPublisher != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Constants.RequestParameters.GDPR_CONSENT_STATUS, String.valueOf(z));
                jSONObject.put("demandSourceName", getProviderName());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.mSSAPublisher.updateConsentInfo(jSONObject);
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public void earlyInit(String str, String str2, JSONObject jSONObject) {
        IronSourceUtils.sendAutomationLog(getProviderName() + ": earlyInit");
        if (mDidInitSdk.compareAndSet(false, true)) {
            if (isAdaptersDebugEnabled()) {
                SDKUtils.setDebugMode(3);
            } else {
                SDKUtils.setDebugMode(jSONObject.optInt(Constants.FeaturesManager.DEBUG_MODE, 0));
            }
            SDKUtils.setControllerUrl(jSONObject.optString("controllerUrl"));
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose(getProviderName() + " IronSourceNetwork setting controller url to  " + jSONObject.optString("controllerUrl"));
            SDKUtils.setControllerConfig(jSONObject.optString(Constants.RequestParameters.CONTROLLER_CONFIG, ""));
            IronLog ironLog2 = IronLog.ADAPTER_API;
            ironLog2.verbose(getProviderName() + " IronSourceNetwork setting controller config to  " + jSONObject.optString(Constants.RequestParameters.CONTROLLER_CONFIG));
            HashMap<String, String> initParams = getInitParams();
            IronSourceNetwork.initSDK(ContextProvider.getInstance().getCurrentActiveActivity(), str, str2, initParams);
            IronLog ironLog3 = IronLog.ADAPTER_API;
            ironLog3.verbose("initSDK with appKey=" + str + " userId=" + str2 + " parameters " + initParams);
        }
    }

    private HashMap<String, String> getInitParams() {
        HashMap<String, String> hashMap = new HashMap<>();
        String pluginType = getPluginType();
        if (!TextUtils.isEmpty(pluginType)) {
            hashMap.put(TokenConstants.SDK_PLUGIN_TYPE, pluginType);
        }
        if (!TextUtils.isEmpty(this.mMediationSegment)) {
            hashMap.put("custom_Segment", this.mMediationSegment);
        }
        if (!TextUtils.isEmpty(IronSourceObject.getInstance().getSessionId())) {
            hashMap.put(Events.SESSION_ID, IronSourceObject.getInstance().getSessionId());
        }
        return hashMap;
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
                IronLog.ADAPTER_API.verbose("not valid");
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
}
