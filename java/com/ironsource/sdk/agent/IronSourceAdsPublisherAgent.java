package com.ironsource.sdk.agent;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.sdk.Events.ISNEventParams;
import com.ironsource.sdk.Events.ISNEventsTracker;
import com.ironsource.sdk.Events.ISNEventsUtils;
import com.ironsource.sdk.Events.SDK5Events;
import com.ironsource.sdk.ISAdSize;
import com.ironsource.sdk.ISNAdView.ISNAdView;
import com.ironsource.sdk.IronSourceAdInstance;
import com.ironsource.sdk.IronSourceNetworkAPI;
import com.ironsource.sdk.SSAPublisher;
import com.ironsource.sdk.constants.Constants;
import com.ironsource.sdk.constants.Events;
import com.ironsource.sdk.controller.ContextProvider;
import com.ironsource.sdk.controller.ControllerManager;
import com.ironsource.sdk.controller.DemandSourceManager;
import com.ironsource.sdk.controller.FeaturesManager;
import com.ironsource.sdk.data.AdUnitsReady;
import com.ironsource.sdk.data.DemandSource;
import com.ironsource.sdk.data.ISNEnums;
import com.ironsource.sdk.listeners.OnBannerListener;
import com.ironsource.sdk.listeners.OnInterstitialListener;
import com.ironsource.sdk.listeners.OnOfferWallListener;
import com.ironsource.sdk.listeners.OnRewardedVideoListener;
import com.ironsource.sdk.listeners.internals.DSAdProductListener;
import com.ironsource.sdk.listeners.internals.DSBannerListener;
import com.ironsource.sdk.listeners.internals.DSInterstitialListener;
import com.ironsource.sdk.listeners.internals.DSRewardedVideoListener;
import com.ironsource.sdk.service.TokenService;
import com.ironsource.sdk.utils.DeviceProperties;
import com.ironsource.sdk.utils.IronSourceSharedPrefHelper;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class IronSourceAdsPublisherAgent implements SSAPublisher, DSRewardedVideoListener, DSInterstitialListener, DSAdProductListener, DSBannerListener, IronSourceNetworkAPI, OnPauseOnResumeHandler {
    private static final String TAG = "IronSourceAdsPublisherAgent";
    private static IronSourceAdsPublisherAgent sInstance;
    private final String SUPERSONIC_ADS = IronSourceConstants.SUPERSONIC_CONFIG_NAME;
    private long adViewContainerCounter;
    private String mApplicationKey;
    private ContextProvider mContextProvider;
    private ControllerManager mControllerManager;
    private DemandSourceManager mDemandSourceManager;
    private boolean mEnableLifeCycleListeners = false;
    private TokenService mTokenService;
    private String mUserId;

    private IronSourceAdsPublisherAgent(Context context, int i) {
        initPublisherAgent(context);
    }

    IronSourceAdsPublisherAgent(String str, String str2, Context context) {
        this.mApplicationKey = str;
        this.mUserId = str2;
        initPublisherAgent(context);
    }

    private void initPublisherAgent(Context context) {
        try {
            IronSourceSharedPrefHelper.getSupersonicPrefHelper(context);
            this.mTokenService = createToken(context);
            this.mDemandSourceManager = new DemandSourceManager();
            ContextProvider contextProvider = new ContextProvider();
            this.mContextProvider = contextProvider;
            if (context instanceof Activity) {
                contextProvider.updateActivityContext((Activity) context);
            }
            this.mControllerManager = new ControllerManager(context, this.mContextProvider, this.mTokenService, this.mDemandSourceManager);
            Logger.enableLogging(FeaturesManager.getInstance().getDebugMode());
            Logger.i(TAG, "C'tor");
            decideOnListeningToApplicationLifeCycleEvents(context, SDKUtils.getNetworkConfiguration());
            this.adViewContainerCounter = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private TokenService createToken(Context context) {
        TokenService instance = TokenService.getInstance();
        instance.fetchIndependentData();
        instance.fetchDependentData(context, this.mApplicationKey, this.mUserId);
        return instance;
    }

    public static IronSourceNetworkAPI createInstance(Context context, String str, String str2) {
        return getInstance(str, str2, context);
    }

    public static synchronized IronSourceNetworkAPI getInstance(String str, String str2, Context context) {
        IronSourceAdsPublisherAgent ironSourceAdsPublisherAgent;
        synchronized (IronSourceAdsPublisherAgent.class) {
            if (sInstance == null) {
                ISNEventsTracker.logEvent(SDK5Events.initSDK);
                sInstance = new IronSourceAdsPublisherAgent(str, str2, context);
            } else {
                TokenService.getInstance().collectApplicationKey(str);
                TokenService.getInstance().collectApplicationUserId(str2);
            }
            ironSourceAdsPublisherAgent = sInstance;
        }
        return ironSourceAdsPublisherAgent;
    }

    public static synchronized IronSourceAdsPublisherAgent getInstance(Context context) throws Exception {
        IronSourceAdsPublisherAgent instance;
        synchronized (IronSourceAdsPublisherAgent.class) {
            instance = getInstance(context, 0);
        }
        return instance;
    }

    public static synchronized IronSourceAdsPublisherAgent getInstance(Context context, int i) throws Exception {
        IronSourceAdsPublisherAgent ironSourceAdsPublisherAgent;
        synchronized (IronSourceAdsPublisherAgent.class) {
            Logger.i(TAG, "getInstance()");
            if (sInstance == null) {
                sInstance = new IronSourceAdsPublisherAgent(context, i);
            }
            ironSourceAdsPublisherAgent = sInstance;
        }
        return ironSourceAdsPublisherAgent;
    }

    public ControllerManager getControllerManager() {
        return this.mControllerManager;
    }

    private OnRewardedVideoListener getAdProductListenerAsRVListener(DemandSource demandSource) {
        if (demandSource == null) {
            return null;
        }
        return (OnRewardedVideoListener) demandSource.getListener();
    }

    private OnInterstitialListener getAdProductListenerAsISListener(DemandSource demandSource) {
        if (demandSource == null) {
            return null;
        }
        return (OnInterstitialListener) demandSource.getListener();
    }

    private OnBannerListener getAdProductListenerAsBNListener(DemandSource demandSource) {
        if (demandSource == null) {
            return null;
        }
        return (OnBannerListener) demandSource.getListener();
    }

    @Override // com.ironsource.sdk.SSAPublisher
    public void initRewardedVideo(final String str, final String str2, String str3, Map<String, String> map, OnRewardedVideoListener onRewardedVideoListener) {
        this.mApplicationKey = str;
        this.mUserId = str2;
        final DemandSource createDemandSource = this.mDemandSourceManager.createDemandSource(ISNEnums.ProductType.RewardedVideo, str3, map, onRewardedVideoListener);
        this.mControllerManager.executeCommand(new Runnable() {
            /* class com.ironsource.sdk.agent.IronSourceAdsPublisherAgent.AnonymousClass1 */

            public void run() {
                IronSourceAdsPublisherAgent.this.mControllerManager.initRewardedVideo(str, str2, createDemandSource, IronSourceAdsPublisherAgent.this);
            }
        });
    }

    @Override // com.ironsource.sdk.SSAPublisher
    public void showRewardedVideo(final JSONObject jSONObject) {
        this.mControllerManager.executeCommand(new Runnable() {
            /* class com.ironsource.sdk.agent.IronSourceAdsPublisherAgent.AnonymousClass2 */

            public void run() {
                IronSourceAdsPublisherAgent.this.mControllerManager.showRewardedVideo(jSONObject, IronSourceAdsPublisherAgent.this);
            }
        });
    }

    @Override // com.ironsource.sdk.SSAPublisher
    public void initOfferWall(final String str, final String str2, final Map<String, String> map, final OnOfferWallListener onOfferWallListener) {
        this.mApplicationKey = str;
        this.mUserId = str2;
        this.mControllerManager.executeCommand(new Runnable() {
            /* class com.ironsource.sdk.agent.IronSourceAdsPublisherAgent.AnonymousClass3 */

            public void run() {
                IronSourceAdsPublisherAgent.this.mControllerManager.initOfferWall(str, str2, map, onOfferWallListener);
            }
        });
    }

    @Override // com.ironsource.sdk.IronSourceNetworkAds
    public void initOfferWall(final Map<String, String> map, final OnOfferWallListener onOfferWallListener) {
        this.mControllerManager.executeCommand(new Runnable() {
            /* class com.ironsource.sdk.agent.IronSourceAdsPublisherAgent.AnonymousClass4 */

            public void run() {
                IronSourceAdsPublisherAgent.this.mControllerManager.initOfferWall(IronSourceAdsPublisherAgent.this.mApplicationKey, IronSourceAdsPublisherAgent.this.mUserId, map, onOfferWallListener);
            }
        });
    }

    @Override // com.ironsource.sdk.SSAPublisher, com.ironsource.sdk.IronSourceNetworkAds
    public void showOfferWall(final Map<String, String> map) {
        this.mControllerManager.executeCommand(new Runnable() {
            /* class com.ironsource.sdk.agent.IronSourceAdsPublisherAgent.AnonymousClass5 */

            public void run() {
                IronSourceAdsPublisherAgent.this.mControllerManager.showOfferWall(map);
            }
        });
    }

    @Override // com.ironsource.sdk.SSAPublisher
    public void getOfferWallCredits(final String str, final String str2, final OnOfferWallListener onOfferWallListener) {
        this.mApplicationKey = str;
        this.mUserId = str2;
        this.mControllerManager.executeCommand(new Runnable() {
            /* class com.ironsource.sdk.agent.IronSourceAdsPublisherAgent.AnonymousClass6 */

            public void run() {
                IronSourceAdsPublisherAgent.this.mControllerManager.getOfferWallCredits(str, str2, onOfferWallListener);
            }
        });
    }

    @Override // com.ironsource.sdk.IronSourceNetworkAds
    public void getOfferWallCredits(final OnOfferWallListener onOfferWallListener) {
        this.mControllerManager.executeCommand(new Runnable() {
            /* class com.ironsource.sdk.agent.IronSourceAdsPublisherAgent.AnonymousClass7 */

            public void run() {
                IronSourceAdsPublisherAgent.this.mControllerManager.getOfferWallCredits(IronSourceAdsPublisherAgent.this.mApplicationKey, IronSourceAdsPublisherAgent.this.mUserId, onOfferWallListener);
            }
        });
    }

    @Override // com.ironsource.sdk.SSAPublisher
    public void initInterstitial(final String str, final String str2, String str3, Map<String, String> map, OnInterstitialListener onInterstitialListener) {
        this.mApplicationKey = str;
        this.mUserId = str2;
        final DemandSource createDemandSource = this.mDemandSourceManager.createDemandSource(ISNEnums.ProductType.Interstitial, str3, map, onInterstitialListener);
        this.mControllerManager.executeCommand(new Runnable() {
            /* class com.ironsource.sdk.agent.IronSourceAdsPublisherAgent.AnonymousClass8 */

            public void run() {
                IronSourceAdsPublisherAgent.this.mControllerManager.initInterstitial(str, str2, createDemandSource, IronSourceAdsPublisherAgent.this);
            }
        });
    }

    @Override // com.ironsource.sdk.SSAPublisher
    public void loadInterstitial(JSONObject jSONObject) {
        if (jSONObject != null) {
            final String optString = jSONObject.optString("demandSourceName");
            if (!TextUtils.isEmpty(optString)) {
                this.mControllerManager.executeCommand(new Runnable() {
                    /* class com.ironsource.sdk.agent.IronSourceAdsPublisherAgent.AnonymousClass9 */

                    public void run() {
                        IronSourceAdsPublisherAgent.this.mControllerManager.loadInterstitial(optString, IronSourceAdsPublisherAgent.this);
                    }
                });
            }
        }
    }

    @Override // com.ironsource.sdk.SSAPublisher
    public boolean isInterstitialAdAvailable(String str) {
        return this.mControllerManager.isInterstitialAdAvailable(str);
    }

    @Override // com.ironsource.sdk.SSAPublisher
    public void showInterstitial(final JSONObject jSONObject) {
        this.mControllerManager.executeCommand(new Runnable() {
            /* class com.ironsource.sdk.agent.IronSourceAdsPublisherAgent.AnonymousClass10 */

            public void run() {
                IronSourceAdsPublisherAgent.this.mControllerManager.showInterstitial(jSONObject, IronSourceAdsPublisherAgent.this);
            }
        });
    }

    @Override // com.ironsource.sdk.SSAPublisher
    public void initBanner(final String str, final String str2, String str3, Map<String, String> map, OnBannerListener onBannerListener) {
        this.mApplicationKey = str;
        this.mUserId = str2;
        final DemandSource createDemandSource = this.mDemandSourceManager.createDemandSource(ISNEnums.ProductType.Banner, str3, map, onBannerListener);
        this.mControllerManager.executeCommand(new Runnable() {
            /* class com.ironsource.sdk.agent.IronSourceAdsPublisherAgent.AnonymousClass11 */

            public void run() {
                IronSourceAdsPublisherAgent.this.mControllerManager.initBanner(str, str2, createDemandSource, IronSourceAdsPublisherAgent.this);
            }
        });
    }

    @Override // com.ironsource.sdk.IronSourceNetworkAds
    public void initBanner(String str, Map<String, String> map, OnBannerListener onBannerListener) {
        final DemandSource createDemandSource = this.mDemandSourceManager.createDemandSource(ISNEnums.ProductType.Banner, str, map, onBannerListener);
        this.mControllerManager.executeCommand(new Runnable() {
            /* class com.ironsource.sdk.agent.IronSourceAdsPublisherAgent.AnonymousClass12 */

            public void run() {
                IronSourceAdsPublisherAgent.this.mControllerManager.initBanner(IronSourceAdsPublisherAgent.this.mApplicationKey, IronSourceAdsPublisherAgent.this.mUserId, createDemandSource, IronSourceAdsPublisherAgent.this);
            }
        });
    }

    @Override // com.ironsource.sdk.SSAPublisher, com.ironsource.sdk.IronSourceNetworkAds
    public void loadBanner(final JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mControllerManager.executeCommand(new Runnable() {
                /* class com.ironsource.sdk.agent.IronSourceAdsPublisherAgent.AnonymousClass13 */

                public void run() {
                    IronSourceAdsPublisherAgent.this.mControllerManager.loadBanner(jSONObject, IronSourceAdsPublisherAgent.this);
                }
            });
        }
    }

    @Override // com.ironsource.sdk.SSAPublisher, com.ironsource.sdk.IronSourceNetworkAPI
    public void onResume(Activity activity) {
        if (!this.mEnableLifeCycleListeners) {
            handleOnResume(activity);
        }
    }

    @Override // com.ironsource.sdk.SSAPublisher, com.ironsource.sdk.IronSourceNetworkAPI
    public void onPause(Activity activity) {
        if (!this.mEnableLifeCycleListeners) {
            handleOnPause(activity);
        }
    }

    @Override // com.ironsource.sdk.SSAPublisher, com.ironsource.sdk.IronSourceNetworkAPI
    public void release(Activity activity) {
        try {
            Logger.i(TAG, "release()");
            DeviceProperties.release();
            this.mControllerManager.unregisterConnectionReceiver(activity);
            this.mControllerManager.destroy();
            this.mControllerManager = null;
        } catch (Exception unused) {
        }
        sInstance = null;
    }

    @Override // com.ironsource.sdk.listeners.internals.DSAdProductListener
    public void onAdProductInitSuccess(ISNEnums.ProductType productType, String str, AdUnitsReady adUnitsReady) {
        OnBannerListener adProductListenerAsBNListener;
        DemandSource demandSourceByName = getDemandSourceByName(productType, str);
        if (demandSourceByName != null) {
            demandSourceByName.setDemandSourceInitState(2);
            if (productType == ISNEnums.ProductType.RewardedVideo) {
                OnRewardedVideoListener adProductListenerAsRVListener = getAdProductListenerAsRVListener(demandSourceByName);
                if (adProductListenerAsRVListener != null) {
                    adProductListenerAsRVListener.onRVInitSuccess(adUnitsReady);
                }
            } else if (productType == ISNEnums.ProductType.Interstitial) {
                OnInterstitialListener adProductListenerAsISListener = getAdProductListenerAsISListener(demandSourceByName);
                if (adProductListenerAsISListener != null) {
                    adProductListenerAsISListener.onInterstitialInitSuccess();
                }
            } else if (productType == ISNEnums.ProductType.Banner && (adProductListenerAsBNListener = getAdProductListenerAsBNListener(demandSourceByName)) != null) {
                adProductListenerAsBNListener.onBannerInitSuccess();
            }
        }
    }

    @Override // com.ironsource.sdk.listeners.internals.DSAdProductListener
    public void onAdProductInitFailed(ISNEnums.ProductType productType, String str, String str2) {
        OnBannerListener adProductListenerAsBNListener;
        DemandSource demandSourceByName = getDemandSourceByName(productType, str);
        ISNEventParams addPair = new ISNEventParams().addPair(Events.DEMAND_SOURCE_NAME, str).addPair(Events.PRODUCT_TYPE, productType).addPair(Events.CALL_FAILED_REASON, str2);
        if (demandSourceByName != null) {
            addPair.addPair(Events.IS_BIDDING_INSTANCE, Boolean.valueOf(ISNEventsUtils.getIsBiddingInstance(demandSourceByName)));
            demandSourceByName.setDemandSourceInitState(3);
            if (productType == ISNEnums.ProductType.RewardedVideo) {
                OnRewardedVideoListener adProductListenerAsRVListener = getAdProductListenerAsRVListener(demandSourceByName);
                if (adProductListenerAsRVListener != null) {
                    adProductListenerAsRVListener.onRVInitFail(str2);
                }
            } else if (productType == ISNEnums.ProductType.Interstitial) {
                OnInterstitialListener adProductListenerAsISListener = getAdProductListenerAsISListener(demandSourceByName);
                if (adProductListenerAsISListener != null) {
                    adProductListenerAsISListener.onInterstitialInitFailed(str2);
                }
            } else if (productType == ISNEnums.ProductType.Banner && (adProductListenerAsBNListener = getAdProductListenerAsBNListener(demandSourceByName)) != null) {
                adProductListenerAsBNListener.onBannerInitFailed(str2);
            }
        }
        ISNEventsTracker.logEvent(SDK5Events.initProductFailed, addPair.getData());
    }

    @Override // com.ironsource.sdk.listeners.internals.DSRewardedVideoListener
    public void onRVNoMoreOffers(String str) {
        OnRewardedVideoListener adProductListenerAsRVListener;
        DemandSource demandSourceByName = getDemandSourceByName(ISNEnums.ProductType.RewardedVideo, str);
        if (demandSourceByName != null && (adProductListenerAsRVListener = getAdProductListenerAsRVListener(demandSourceByName)) != null) {
            adProductListenerAsRVListener.onRVNoMoreOffers();
        }
    }

    @Override // com.ironsource.sdk.listeners.internals.DSRewardedVideoListener
    public void onRVAdCredited(String str, int i) {
        OnRewardedVideoListener adProductListenerAsRVListener;
        DemandSource demandSourceByName = getDemandSourceByName(ISNEnums.ProductType.RewardedVideo, str);
        if (demandSourceByName != null && (adProductListenerAsRVListener = getAdProductListenerAsRVListener(demandSourceByName)) != null) {
            adProductListenerAsRVListener.onRVAdCredited(i);
        }
    }

    @Override // com.ironsource.sdk.listeners.internals.DSAdProductListener
    public void onAdProductClose(ISNEnums.ProductType productType, String str) {
        OnInterstitialListener adProductListenerAsISListener;
        DemandSource demandSourceByName = getDemandSourceByName(productType, str);
        if (demandSourceByName == null) {
            return;
        }
        if (productType == ISNEnums.ProductType.RewardedVideo) {
            OnRewardedVideoListener adProductListenerAsRVListener = getAdProductListenerAsRVListener(demandSourceByName);
            if (adProductListenerAsRVListener != null) {
                adProductListenerAsRVListener.onRVAdClosed();
            }
        } else if (productType == ISNEnums.ProductType.Interstitial && (adProductListenerAsISListener = getAdProductListenerAsISListener(demandSourceByName)) != null) {
            adProductListenerAsISListener.onInterstitialClose();
        }
    }

    @Override // com.ironsource.sdk.listeners.internals.DSRewardedVideoListener
    public void onRVShowFail(String str, String str2) {
        OnRewardedVideoListener adProductListenerAsRVListener;
        DemandSource demandSourceByName = getDemandSourceByName(ISNEnums.ProductType.RewardedVideo, str);
        if (demandSourceByName != null && (adProductListenerAsRVListener = getAdProductListenerAsRVListener(demandSourceByName)) != null) {
            adProductListenerAsRVListener.onRVShowFail(str2);
        }
    }

    @Override // com.ironsource.sdk.listeners.internals.DSAdProductListener
    public void onAdProductClick(ISNEnums.ProductType productType, String str) {
        OnBannerListener adProductListenerAsBNListener;
        DemandSource demandSourceByName = getDemandSourceByName(productType, str);
        if (demandSourceByName == null) {
            return;
        }
        if (productType == ISNEnums.ProductType.RewardedVideo) {
            OnRewardedVideoListener adProductListenerAsRVListener = getAdProductListenerAsRVListener(demandSourceByName);
            if (adProductListenerAsRVListener != null) {
                adProductListenerAsRVListener.onRVAdClicked();
            }
        } else if (productType == ISNEnums.ProductType.Interstitial) {
            OnInterstitialListener adProductListenerAsISListener = getAdProductListenerAsISListener(demandSourceByName);
            if (adProductListenerAsISListener != null) {
                adProductListenerAsISListener.onInterstitialClick();
            }
        } else if (productType == ISNEnums.ProductType.Banner && (adProductListenerAsBNListener = getAdProductListenerAsBNListener(demandSourceByName)) != null) {
            adProductListenerAsBNListener.onBannerClick();
        }
    }

    @Override // com.ironsource.sdk.listeners.internals.DSAdProductListener
    public void onAdProductEventNotificationReceived(ISNEnums.ProductType productType, String str, String str2, JSONObject jSONObject) {
        OnRewardedVideoListener adProductListenerAsRVListener;
        DemandSource demandSourceByName = getDemandSourceByName(productType, str);
        if (demandSourceByName != null) {
            try {
                if (productType == ISNEnums.ProductType.Interstitial) {
                    OnInterstitialListener adProductListenerAsISListener = getAdProductListenerAsISListener(demandSourceByName);
                    if (adProductListenerAsISListener != null) {
                        jSONObject.put("demandSourceName", str);
                        adProductListenerAsISListener.onInterstitialEventNotificationReceived(str2, jSONObject);
                    }
                } else if (productType == ISNEnums.ProductType.RewardedVideo && (adProductListenerAsRVListener = getAdProductListenerAsRVListener(demandSourceByName)) != null) {
                    jSONObject.put("demandSourceName", str);
                    adProductListenerAsRVListener.onRVEventNotificationReceived(str2, jSONObject);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ironsource.sdk.listeners.internals.DSAdProductListener
    public void onAdProductOpen(ISNEnums.ProductType productType, String str) {
        OnRewardedVideoListener adProductListenerAsRVListener;
        DemandSource demandSourceByName = getDemandSourceByName(productType, str);
        if (demandSourceByName == null) {
            return;
        }
        if (productType == ISNEnums.ProductType.Interstitial) {
            OnInterstitialListener adProductListenerAsISListener = getAdProductListenerAsISListener(demandSourceByName);
            if (adProductListenerAsISListener != null) {
                adProductListenerAsISListener.onInterstitialOpen();
            }
        } else if (productType == ISNEnums.ProductType.RewardedVideo && (adProductListenerAsRVListener = getAdProductListenerAsRVListener(demandSourceByName)) != null) {
            adProductListenerAsRVListener.onRVAdOpened();
        }
    }

    @Override // com.ironsource.sdk.listeners.internals.DSInterstitialListener
    public void onInterstitialLoadSuccess(String str) {
        DemandSource demandSourceByName = getDemandSourceByName(ISNEnums.ProductType.Interstitial, str);
        ISNEventParams addPair = new ISNEventParams().addPair(Events.DEMAND_SOURCE_NAME, str);
        if (demandSourceByName != null) {
            addPair.addPair(Events.PRODUCT_TYPE, ISNEventsUtils.getProductType(demandSourceByName, ISNEnums.ProductType.Interstitial)).addPair(Events.IS_BIDDING_INSTANCE, Boolean.valueOf(ISNEventsUtils.getIsBiddingInstance(demandSourceByName)));
            OnInterstitialListener adProductListenerAsISListener = getAdProductListenerAsISListener(demandSourceByName);
            if (adProductListenerAsISListener != null) {
                adProductListenerAsISListener.onInterstitialLoadSuccess();
            }
        }
        ISNEventsTracker.logEvent(SDK5Events.loadAdSuccess, addPair.getData());
    }

    @Override // com.ironsource.sdk.listeners.internals.DSInterstitialListener
    public void onInterstitialLoadFailed(String str, String str2) {
        DemandSource demandSourceByName = getDemandSourceByName(ISNEnums.ProductType.Interstitial, str);
        ISNEventParams iSNEventParams = new ISNEventParams();
        iSNEventParams.addPair(Events.CALL_FAILED_REASON, str2).addPair(Events.DEMAND_SOURCE_NAME, str);
        if (demandSourceByName != null) {
            iSNEventParams.addPair(Events.PRODUCT_TYPE, ISNEventsUtils.getProductType(demandSourceByName, ISNEnums.ProductType.Interstitial)).addPair(Events.GENERAL_MSG, demandSourceByName.getDemandSourceInitState() == 2 ? Events.INTIALIZED : Events.UNINTIALIZED).addPair(Events.IS_BIDDING_INSTANCE, Boolean.valueOf(ISNEventsUtils.getIsBiddingInstance(demandSourceByName)));
            OnInterstitialListener adProductListenerAsISListener = getAdProductListenerAsISListener(demandSourceByName);
            if (adProductListenerAsISListener != null) {
                adProductListenerAsISListener.onInterstitialLoadFailed(str2);
            }
        }
        ISNEventsTracker.logEvent(SDK5Events.loadAdFailed, iSNEventParams.getData());
    }

    @Override // com.ironsource.sdk.listeners.internals.DSInterstitialListener
    public void onInterstitialShowSuccess(String str) {
        OnInterstitialListener adProductListenerAsISListener;
        DemandSource demandSourceByName = getDemandSourceByName(ISNEnums.ProductType.Interstitial, str);
        if (demandSourceByName != null && (adProductListenerAsISListener = getAdProductListenerAsISListener(demandSourceByName)) != null) {
            adProductListenerAsISListener.onInterstitialShowSuccess();
        }
    }

    @Override // com.ironsource.sdk.listeners.internals.DSInterstitialListener
    public void onInterstitialShowFailed(String str, String str2) {
        OnInterstitialListener adProductListenerAsISListener;
        DemandSource demandSourceByName = getDemandSourceByName(ISNEnums.ProductType.Interstitial, str);
        if (demandSourceByName != null && (adProductListenerAsISListener = getAdProductListenerAsISListener(demandSourceByName)) != null) {
            adProductListenerAsISListener.onInterstitialShowFailed(str2);
        }
    }

    @Override // com.ironsource.sdk.listeners.internals.DSInterstitialListener
    public void onInterstitialAdRewarded(String str, int i) {
        DemandSource demandSourceByName = getDemandSourceByName(ISNEnums.ProductType.Interstitial, str);
        OnInterstitialListener adProductListenerAsISListener = getAdProductListenerAsISListener(demandSourceByName);
        if (demandSourceByName != null && adProductListenerAsISListener != null) {
            adProductListenerAsISListener.onInterstitialAdRewarded(str, i);
        }
    }

    private DemandSource getDemandSourceByName(ISNEnums.ProductType productType, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mDemandSourceManager.getDemandSourceById(productType, str);
    }

    @Override // com.ironsource.sdk.SSAPublisher
    public void setMediationState(String str, String str2, int i) {
        ISNEnums.ProductType productType;
        DemandSource demandSourceById;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (productType = SDKUtils.getProductType(str)) != null && (demandSourceById = this.mDemandSourceManager.getDemandSourceById(productType, str2)) != null) {
            demandSourceById.setMediationState(i);
        }
    }

    @Override // com.ironsource.sdk.SSAPublisher, com.ironsource.sdk.IronSourceNetworkAPI
    public void updateConsentInfo(final JSONObject jSONObject) {
        updateConsentInToken(jSONObject);
        this.mControllerManager.executeCommand(new Runnable() {
            /* class com.ironsource.sdk.agent.IronSourceAdsPublisherAgent.AnonymousClass14 */

            public void run() {
                IronSourceAdsPublisherAgent.this.mControllerManager.updateConsentInfo(jSONObject);
            }
        });
    }

    private void updateConsentInToken(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has(Constants.RequestParameters.GDPR_CONSENT_STATUS)) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("consent", Boolean.parseBoolean(jSONObject.getString(Constants.RequestParameters.GDPR_CONSENT_STATUS)));
                this.mTokenService.updateData(jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ironsource.sdk.SSAPublisher, com.ironsource.sdk.IronSourceNetworkAds
    public ISNAdView createBanner(Activity activity, ISAdSize iSAdSize) {
        this.adViewContainerCounter++;
        ISNAdView iSNAdView = new ISNAdView(activity, "SupersonicAds_" + this.adViewContainerCounter, iSAdSize);
        this.mControllerManager.setCommunicationWithAdView(iSNAdView);
        return iSNAdView;
    }

    @Override // com.ironsource.sdk.listeners.internals.DSBannerListener
    public void onBannerLoadSuccess(String str) {
        OnBannerListener adProductListenerAsBNListener;
        DemandSource demandSourceByName = getDemandSourceByName(ISNEnums.ProductType.Banner, str);
        if (demandSourceByName != null && (adProductListenerAsBNListener = getAdProductListenerAsBNListener(demandSourceByName)) != null) {
            adProductListenerAsBNListener.onBannerLoadSuccess();
        }
    }

    @Override // com.ironsource.sdk.listeners.internals.DSBannerListener
    public void onBannerLoadFail(String str, String str2) {
        OnBannerListener adProductListenerAsBNListener;
        DemandSource demandSourceByName = getDemandSourceByName(ISNEnums.ProductType.Banner, str);
        if (demandSourceByName != null && (adProductListenerAsBNListener = getAdProductListenerAsBNListener(demandSourceByName)) != null) {
            adProductListenerAsBNListener.onBannerLoadFail(str2);
        }
    }

    @Override // com.ironsource.sdk.IronSourceNetworkAds
    public void loadAd(Activity activity, IronSourceAdInstance ironSourceAdInstance, Map<String, String> map) {
        this.mContextProvider.updateActivityContext(activity);
        ISNEventParams iSNEventParams = new ISNEventParams();
        iSNEventParams.addPair(Events.IS_BIDDING_INSTANCE, Boolean.valueOf(ironSourceAdInstance.isInAppBidding())).addPair(Events.DEMAND_SOURCE_NAME, ironSourceAdInstance.getName()).addPair(Events.PRODUCT_TYPE, ironSourceAdInstance.isRewarded() ? ISNEnums.ProductType.RewardedVideo : ISNEnums.ProductType.Interstitial);
        ISNEventsTracker.logEvent(SDK5Events.loadAd, iSNEventParams.getData());
        Logger.d(TAG, "loadAd " + ironSourceAdInstance.getId());
        if (ironSourceAdInstance.isInAppBidding()) {
            loadInAppBiddingAd(ironSourceAdInstance, map);
        } else {
            loadInstance(ironSourceAdInstance, map);
        }
    }

    private void loadInAppBiddingAd(IronSourceAdInstance ironSourceAdInstance, Map<String, String> map) {
        try {
            map = decodeADM(map);
        } catch (Exception e) {
            ISNEventsTracker.logEvent(SDK5Events.parseAdmFailed, new ISNEventParams().addPair(Events.CALL_FAILED_REASON, e.getMessage()).addPair(Events.GENERAL_MSG, ironSourceAdInstance.isInitialized() ? Events.INTIALIZED : Events.UNINTIALIZED).addPair(Events.IS_BIDDING_INSTANCE, Boolean.valueOf(ironSourceAdInstance.isInAppBidding())).addPair(Events.DEMAND_SOURCE_NAME, ironSourceAdInstance.getName()).addPair(Events.PRODUCT_TYPE, ironSourceAdInstance.isRewarded() ? ISNEnums.ProductType.RewardedVideo : ISNEnums.ProductType.Interstitial).getData());
            e.printStackTrace();
            Logger.d(TAG, "loadInAppBiddingAd failed decoding  ADM " + e.getMessage());
        }
        loadInstance(ironSourceAdInstance, map);
    }

    private void loadInstance(IronSourceAdInstance ironSourceAdInstance, Map<String, String> map) {
        if (ironSourceAdInstance.isInitialized()) {
            loadInitializedInstance(ironSourceAdInstance, map);
        } else {
            loadUninitializedInstance(ironSourceAdInstance, map);
        }
    }

    private Map<String, String> decodeADM(Map<String, String> map) {
        map.put(Constants.ParametersKeys.ADM, SDKUtils.decodeString(map.get(Constants.ParametersKeys.ADM)));
        return map;
    }

    private void loadInitializedInstance(final IronSourceAdInstance ironSourceAdInstance, final Map<String, String> map) {
        Logger.d(TAG, "loadOnInitializedInstance " + ironSourceAdInstance.getId());
        this.mControllerManager.executeCommand(new Runnable() {
            /* class com.ironsource.sdk.agent.IronSourceAdsPublisherAgent.AnonymousClass15 */

            public void run() {
                DemandSource demandSourceById = IronSourceAdsPublisherAgent.this.mDemandSourceManager.getDemandSourceById(ISNEnums.ProductType.Interstitial, ironSourceAdInstance.getId());
                if (demandSourceById != null) {
                    IronSourceAdsPublisherAgent.this.mControllerManager.loadInterstitial(demandSourceById, map, IronSourceAdsPublisherAgent.this);
                }
            }
        });
    }

    private void loadUninitializedInstance(final IronSourceAdInstance ironSourceAdInstance, final Map<String, String> map) {
        Logger.d(TAG, "loadOnNewInstance " + ironSourceAdInstance.getId());
        this.mControllerManager.executeCommand(new Runnable() {
            /* class com.ironsource.sdk.agent.IronSourceAdsPublisherAgent.AnonymousClass16 */

            public void run() {
                DemandSource createDemandSource = IronSourceAdsPublisherAgent.this.mDemandSourceManager.createDemandSource(ISNEnums.ProductType.Interstitial, ironSourceAdInstance);
                ISNEventParams iSNEventParams = new ISNEventParams();
                iSNEventParams.addPair(Events.IS_BIDDING_INSTANCE, Boolean.valueOf(ironSourceAdInstance.isInAppBidding())).addPair(Events.DEMAND_SOURCE_NAME, ironSourceAdInstance.getName()).addPair(Events.PRODUCT_TYPE, ironSourceAdInstance.isRewarded() ? ISNEnums.ProductType.RewardedVideo : ISNEnums.ProductType.Interstitial);
                ISNEventsTracker.logEvent(SDK5Events.initProduct, iSNEventParams.getData());
                IronSourceAdsPublisherAgent.this.mControllerManager.initInterstitial(IronSourceAdsPublisherAgent.this.mApplicationKey, IronSourceAdsPublisherAgent.this.mUserId, createDemandSource, IronSourceAdsPublisherAgent.this);
                ironSourceAdInstance.setInitialized(true);
                IronSourceAdsPublisherAgent.this.mControllerManager.loadInterstitial(createDemandSource, map, IronSourceAdsPublisherAgent.this);
            }
        });
    }

    @Override // com.ironsource.sdk.IronSourceNetworkAds
    public void showAd(IronSourceAdInstance ironSourceAdInstance, final Map<String, String> map) {
        Logger.i(TAG, "showAd " + ironSourceAdInstance.getId());
        final DemandSource demandSourceById = this.mDemandSourceManager.getDemandSourceById(ISNEnums.ProductType.Interstitial, ironSourceAdInstance.getId());
        if (demandSourceById != null) {
            this.mControllerManager.executeCommand(new Runnable() {
                /* class com.ironsource.sdk.agent.IronSourceAdsPublisherAgent.AnonymousClass17 */

                public void run() {
                    IronSourceAdsPublisherAgent.this.mControllerManager.showInterstitial(demandSourceById, map, IronSourceAdsPublisherAgent.this);
                }
            });
        }
    }

    @Override // com.ironsource.sdk.IronSourceNetworkAds
    public boolean isAdAvailable(IronSourceAdInstance ironSourceAdInstance) {
        Logger.d(TAG, "isAdAvailable " + ironSourceAdInstance.getId());
        DemandSource demandSourceById = this.mDemandSourceManager.getDemandSourceById(ISNEnums.ProductType.Interstitial, ironSourceAdInstance.getId());
        if (demandSourceById == null) {
            return false;
        }
        return demandSourceById.getAvailabilityState();
    }

    public void decideOnListeningToApplicationLifeCycleEvents(Context context, JSONObject jSONObject) {
        boolean optBoolean = jSONObject.optBoolean(Constants.ControllerConfigurationKeys.ENABLE_LIFE_CYCLE_EVENT_LISTENRS_KEY, false);
        this.mEnableLifeCycleListeners = optBoolean;
        if (optBoolean) {
            try {
                ((Application) context).registerActivityLifecycleCallbacks(new ActivityLifeCycleListener(this));
            } catch (Throwable th) {
                ISNEventParams iSNEventParams = new ISNEventParams();
                iSNEventParams.addPair(Events.GENERAL_MSG, th.getMessage());
                ISNEventsTracker.logEvent(SDK5Events.failedRegisterActivityLifecycle, iSNEventParams.getData());
            }
        }
    }

    @Override // com.ironsource.sdk.agent.OnPauseOnResumeHandler
    public void handleOnPause(Activity activity) {
        try {
            this.mControllerManager.enterBackground();
            this.mControllerManager.unregisterConnectionReceiver(activity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.ironsource.sdk.agent.OnPauseOnResumeHandler
    public void handleOnResume(Activity activity) {
        this.mControllerManager.enterForeground();
        this.mControllerManager.registerConnectionReceiver(activity);
    }
}
