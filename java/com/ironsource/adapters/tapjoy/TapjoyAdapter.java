package com.ironsource.adapters.tapjoy;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.IntegrationData;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.sdk.precache.DownloadManager;
import com.tapjoy.TJActionRequest;
import com.tapjoy.TJConnectListener;
import com.tapjoy.TJError;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJPlacementVideoListener;
import com.tapjoy.Tapjoy;
import com.tapjoy.TapjoyAuctionFlags;
import com.tapjoy.TapjoyConnectFlag;
import com.tapjoy.TapjoyLog;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class TapjoyAdapter extends AbstractAdapter implements TJPlacementListener, TJPlacementVideoListener {
    private static final String GitHash = "8521dbe88";
    private static final String VERSION = "4.1.10";
    private final int LOAD_ERROR_NOT_AVAILABLE = IronSourceConstants.errorCode_biddingDataException;
    private final String PLACEMENT_NAME = "placementName";
    private final int PROG_LOAD_ERROR_GET_PLACEMENT = DownloadManager.OPERATION_TIMEOUT;
    private final String SDK_KEY = "sdkKey";
    private InitState mInitState = InitState.INIT_STATE_NONE;
    private ConcurrentHashMap<String, TJPlacement> mIsPlacementToAd = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Boolean> mIsPlacementToIsReady = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, InterstitialSmashListener> mIsPlacementToListener = new ConcurrentHashMap<>();
    private CopyOnWriteArraySet<String> mProgrammaticPlacements = new CopyOnWriteArraySet<>();
    private ConcurrentHashMap<String, TJPlacement> mRvPlacementToAd = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Boolean> mRvPlacementToIsReady = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, RewardedVideoSmashListener> mRvPlacementToListener = new ConcurrentHashMap<>();
    private ExecutorService mThreadPool = Executors.newSingleThreadExecutor();
    private AtomicBoolean mWasInitCalled = new AtomicBoolean(false);

    /* access modifiers changed from: private */
    public enum InitState {
        INIT_STATE_NONE,
        INIT_STATE_IN_PROGRESS,
        INIT_STATE_SUCCESS,
        INIT_STATE_ERROR
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getVersion() {
        return VERSION;
    }

    public static TapjoyAdapter startAdapter(String str) {
        return new TapjoyAdapter(str);
    }

    private TapjoyAdapter(String str) {
        super(str);
    }

    public static IntegrationData getIntegrationData(Activity activity) {
        IntegrationData integrationData = new IntegrationData("Tapjoy", VERSION);
        integrationData.activities = new String[]{"com.tapjoy.TJAdUnitActivity", "com.tapjoy.TJContentActivity"};
        return integrationData;
    }

    public static String getAdapterSDKVersion() {
        try {
            return Tapjoy.getVersion();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getCoreSDKVersion() {
        return Tapjoy.getVersion();
    }

    /* access modifiers changed from: protected */
    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public void setConsent(boolean z) {
        Tapjoy.setUserConsent(z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
    }

    private void initSDK(final Activity activity, final String str, String str2) {
        if (this.mWasInitCalled.compareAndSet(false, true)) {
            this.mInitState = InitState.INIT_STATE_IN_PROGRESS;
            log("initSDK - sdkKey = " + str2);
            Hashtable hashtable = new Hashtable();
            if (isAdaptersDebugEnabled()) {
                hashtable.put(TapjoyConnectFlag.ENABLE_LOGGING, "true");
                Tapjoy.setDebugEnabled(true);
                TapjoyLog.setDebugEnabled(true);
            } else {
                hashtable.put(TapjoyConnectFlag.ENABLE_LOGGING, "false");
                Tapjoy.setDebugEnabled(false);
                TapjoyLog.setDebugEnabled(false);
            }
            Tapjoy.connect(activity.getApplicationContext(), str2, hashtable, new TJConnectListener() {
                /* class com.ironsource.adapters.tapjoy.TapjoyAdapter.AnonymousClass1 */

                @Override // com.tapjoy.TJConnectListener
                public void onConnectSuccess() {
                    TapjoyAdapter.this.log("onConnectSuccess");
                    if (!TextUtils.isEmpty(str)) {
                        Tapjoy.setUserID(str);
                    }
                    Tapjoy.setActivity(activity);
                    for (InterstitialSmashListener interstitialSmashListener : TapjoyAdapter.this.mIsPlacementToListener.values()) {
                        interstitialSmashListener.onInterstitialInitSuccess();
                    }
                    for (String str : TapjoyAdapter.this.mRvPlacementToListener.keySet()) {
                        RewardedVideoSmashListener rewardedVideoSmashListener = (RewardedVideoSmashListener) TapjoyAdapter.this.mRvPlacementToListener.get(str);
                        if (TapjoyAdapter.this.mProgrammaticPlacements.contains(str)) {
                            rewardedVideoSmashListener.onRewardedVideoInitSuccess();
                        } else {
                            TapjoyAdapter.this.loadVideo(str, rewardedVideoSmashListener);
                        }
                    }
                    TapjoyAdapter.this.mInitState = InitState.INIT_STATE_SUCCESS;
                }

                @Override // com.tapjoy.TJConnectListener
                public void onConnectFailure() {
                    TapjoyAdapter.this.log("onConnectFailure");
                    for (InterstitialSmashListener interstitialSmashListener : TapjoyAdapter.this.mIsPlacementToListener.values()) {
                        interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("Tapjoy sdk init failed", "Interstitial"));
                    }
                    for (String str : TapjoyAdapter.this.mRvPlacementToListener.keySet()) {
                        RewardedVideoSmashListener rewardedVideoSmashListener = (RewardedVideoSmashListener) TapjoyAdapter.this.mRvPlacementToListener.get(str);
                        if (TapjoyAdapter.this.mProgrammaticPlacements.contains(str)) {
                            rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("Tapjoy sdk init failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                        } else {
                            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
                        }
                    }
                    TapjoyAdapter.this.mInitState = InitState.INIT_STATE_ERROR;
                }
            });
        }
    }

    public Map<String, Object> getRvBiddingData(JSONObject jSONObject) {
        return getBiddingData();
    }

    public void loadVideo(JSONObject jSONObject, final RewardedVideoSmashListener rewardedVideoSmashListener, final String str) {
        final String optString = jSONObject.optString("placementName");
        this.mThreadPool.execute(new Runnable() {
            /* class com.ironsource.adapters.tapjoy.TapjoyAdapter.AnonymousClass2 */

            public void run() {
                TJPlacement auctionPlacement = TapjoyAdapter.this.getAuctionPlacement(optString, str);
                auctionPlacement.setVideoListener(TapjoyAdapter.this);
                if (auctionPlacement != null) {
                    TapjoyAdapter.this.mRvPlacementToAd.put(optString, auctionPlacement);
                    TapjoyAdapter tapjoyAdapter = TapjoyAdapter.this;
                    tapjoyAdapter.log("loadVideo - requestContent - requestContent = " + optString);
                    auctionPlacement.requestContent();
                    return;
                }
                TapjoyAdapter.this.log("loadVideo - onRewardedVideoAvailabilityChanged(false) - TJPlacement is null");
                rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
                try {
                    rewardedVideoSmashListener.onRewardedVideoLoadFailed(new IronSourceError(DownloadManager.OPERATION_TIMEOUT, "Load error"));
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void loadVideo(final String str, final RewardedVideoSmashListener rewardedVideoSmashListener) {
        this.mThreadPool.execute(new Runnable() {
            /* class com.ironsource.adapters.tapjoy.TapjoyAdapter.AnonymousClass3 */

            public void run() {
                TJPlacement placement = TapjoyAdapter.this.getPlacement(str);
                placement.setVideoListener(TapjoyAdapter.this);
                if (placement != null) {
                    TapjoyAdapter.this.mRvPlacementToAd.put(str, placement);
                    TapjoyAdapter tapjoyAdapter = TapjoyAdapter.this;
                    tapjoyAdapter.log("loadVideo - requestContent - placementName = " + str);
                    placement.requestContent();
                    return;
                }
                TapjoyAdapter.this.log("loadVideo - onRewardedVideoAvailabilityChanged(false) - TJPlacement is null");
                rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
                try {
                    rewardedVideoSmashListener.onRewardedVideoLoadFailed(new IronSourceError(DownloadManager.OPERATION_TIMEOUT, "Load error"));
                } catch (Throwable unused) {
                }
            }
        });
    }

    public void initRvForBidding(Activity activity, String str, String str2, JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        if (rewardedVideoSmashListener == null) {
            log("initRvForBidding - listener == null");
            return;
        }
        String optString = jSONObject.optString("sdkKey");
        String optString2 = jSONObject.optString("placementName");
        if (TextUtils.isEmpty(optString)) {
            rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("Missing sdkKey", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
        } else if (TextUtils.isEmpty(optString2)) {
            rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("Missing placementId", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
        } else {
            this.mRvPlacementToListener.put(optString2, rewardedVideoSmashListener);
            this.mProgrammaticPlacements.add(optString2);
            initSDK(activity, str2, optString);
            if (this.mInitState == InitState.INIT_STATE_SUCCESS) {
                log("initRvForBidding - onRewardedVideoInitSuccess");
                rewardedVideoSmashListener.onRewardedVideoInitSuccess();
            } else if (this.mInitState == InitState.INIT_STATE_ERROR) {
                log("initRvForBidding - onRewardedVideoInitFailed - SDK not connected");
                rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("sdk not connected", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            }
        }
    }

    public void initRewardedVideo(Activity activity, String str, String str2, JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        String optString = jSONObject.optString("sdkKey");
        String optString2 = jSONObject.optString("placementName");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            log("initRewardedVideo - empty sdkKey or placementName");
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
            return;
        }
        this.mRvPlacementToListener.put(optString2, rewardedVideoSmashListener);
        this.mRvPlacementToIsReady.put(optString2, false);
        initSDK(activity, str2, optString);
        if (this.mInitState == InitState.INIT_STATE_SUCCESS) {
            log("initRewardedVideo - loadVideo - placementName = " + optString2);
            loadVideo(optString2, rewardedVideoSmashListener);
        } else if (this.mInitState == InitState.INIT_STATE_ERROR) {
            log("initRewardedVideo - onRewardedVideoAvailabilityChanged(false)");
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
        }
    }

    public void fetchRewardedVideo(JSONObject jSONObject) {
        final String optString = jSONObject.optString("placementName");
        this.mRvPlacementToIsReady.put(optString, false);
        this.mThreadPool.execute(new Runnable() {
            /* class com.ironsource.adapters.tapjoy.TapjoyAdapter.AnonymousClass4 */

            public void run() {
                if (TapjoyAdapter.this.mRvPlacementToAd.containsKey(optString)) {
                    TapjoyAdapter tapjoyAdapter = TapjoyAdapter.this;
                    tapjoyAdapter.log("fetchRewardedVideo - requestContent - placementName = " + optString);
                    ((TJPlacement) TapjoyAdapter.this.mRvPlacementToAd.get(optString)).requestContent();
                } else if (TapjoyAdapter.this.mRvPlacementToListener.containsKey(optString)) {
                    TapjoyAdapter tapjoyAdapter2 = TapjoyAdapter.this;
                    tapjoyAdapter2.log("fetchRewardedVideo - onRewardedVideoAvailabilityChanged(false) - placementName = " + optString);
                    ((RewardedVideoSmashListener) TapjoyAdapter.this.mRvPlacementToListener.get(optString)).onRewardedVideoAvailabilityChanged(false);
                }
            }
        });
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoAdapterApi
    public void showRewardedVideo(final JSONObject jSONObject, final RewardedVideoSmashListener rewardedVideoSmashListener) {
        this.mRvPlacementToIsReady.put(jSONObject.optString("placementName"), false);
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            /* class com.ironsource.adapters.tapjoy.TapjoyAdapter.AnonymousClass5 */

            public void run() {
                String optString = jSONObject.optString("placementName");
                if (TapjoyAdapter.this.mRvPlacementToAd.containsKey(optString) && ((TJPlacement) TapjoyAdapter.this.mRvPlacementToAd.get(optString)).isContentReady()) {
                    TapjoyAdapter tapjoyAdapter = TapjoyAdapter.this;
                    tapjoyAdapter.log("showRewardedVideo - showContent - placementName = " + optString);
                    ((TJPlacement) TapjoyAdapter.this.mRvPlacementToAd.get(optString)).showContent();
                } else if (rewardedVideoSmashListener != null) {
                    TapjoyAdapter tapjoyAdapter2 = TapjoyAdapter.this;
                    tapjoyAdapter2.log("showRewardedVideo - onRewardedVideoAdShowFailed - placementName = " + optString);
                    rewardedVideoSmashListener.onRewardedVideoAdShowFailed(ErrorBuilder.buildNoAdsToShowError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                    rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
                }
            }
        });
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoAdapterApi
    public boolean isRewardedVideoAvailable(JSONObject jSONObject) {
        String optString = jSONObject.optString("placementName");
        return this.mRvPlacementToIsReady.containsKey(optString) && this.mRvPlacementToIsReady.get(optString).booleanValue();
    }

    public Map<String, Object> getIsBiddingData(JSONObject jSONObject) {
        return getBiddingData();
    }

    public void initInterstitialForBidding(Activity activity, String str, String str2, JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        initInterstitial(activity, str, str2, jSONObject, interstitialSmashListener);
    }

    public void initInterstitial(Activity activity, String str, String str2, JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        String optString = jSONObject.optString("sdkKey");
        String optString2 = jSONObject.optString("placementName");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            log("initInterstitial - onInterstitialInitFailed - missing params");
            interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("Missing params", "Interstitial"));
            return;
        }
        this.mIsPlacementToListener.put(optString2, interstitialSmashListener);
        initSDK(activity, str2, optString);
        if (this.mInitState == InitState.INIT_STATE_SUCCESS) {
            log("initInterstitial - onInterstitialInitSuccess - placementName = " + optString2);
            interstitialSmashListener.onInterstitialInitSuccess();
        } else if (this.mInitState == InitState.INIT_STATE_ERROR) {
            log("initInterstitial - onInterstitialInitFailed - placementName = " + optString2);
            interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("Init Failed", "Interstitial"));
        }
    }

    public void loadInterstitial(final JSONObject jSONObject, final InterstitialSmashListener interstitialSmashListener, final String str) {
        this.mIsPlacementToIsReady.put(jSONObject.optString("placementName"), false);
        this.mThreadPool.execute(new Runnable() {
            /* class com.ironsource.adapters.tapjoy.TapjoyAdapter.AnonymousClass6 */

            public void run() {
                String optString = jSONObject.optString("placementName");
                TJPlacement auctionPlacement = TapjoyAdapter.this.getAuctionPlacement(optString, str);
                if (auctionPlacement != null) {
                    TapjoyAdapter.this.mIsPlacementToAd.put(optString, auctionPlacement);
                    TapjoyAdapter tapjoyAdapter = TapjoyAdapter.this;
                    tapjoyAdapter.log("loadInterstitial - requestContent - placementName = " + optString);
                    auctionPlacement.requestContent();
                    return;
                }
                TapjoyAdapter tapjoyAdapter2 = TapjoyAdapter.this;
                tapjoyAdapter2.log("loadInterstitial - onInterstitialAdLoadFailed - TJPlacement is null for placementName = " + optString);
                interstitialSmashListener.onInterstitialAdLoadFailed(new IronSourceError(DownloadManager.OPERATION_TIMEOUT, "Load error"));
            }
        });
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialAdapterApi
    public void loadInterstitial(final JSONObject jSONObject, final InterstitialSmashListener interstitialSmashListener) {
        this.mIsPlacementToIsReady.put(jSONObject.optString("placementName"), false);
        this.mThreadPool.execute(new Runnable() {
            /* class com.ironsource.adapters.tapjoy.TapjoyAdapter.AnonymousClass7 */

            public void run() {
                String optString = jSONObject.optString("placementName");
                TJPlacement placement = TapjoyAdapter.this.getPlacement(optString);
                if (placement != null) {
                    TapjoyAdapter.this.mIsPlacementToAd.put(optString, placement);
                    TapjoyAdapter tapjoyAdapter = TapjoyAdapter.this;
                    tapjoyAdapter.log("loadInterstitial - requestContent - placementName = " + optString);
                    placement.requestContent();
                    return;
                }
                TapjoyAdapter tapjoyAdapter2 = TapjoyAdapter.this;
                tapjoyAdapter2.log("loadInterstitial - onInterstitialAdLoadFailed - TJPlacement is null for placementName = " + optString);
                interstitialSmashListener.onInterstitialAdLoadFailed(new IronSourceError(IronSourceError.ERROR_CODE_GENERIC, "Load error"));
            }
        });
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialAdapterApi
    public void showInterstitial(final JSONObject jSONObject, final InterstitialSmashListener interstitialSmashListener) {
        this.mIsPlacementToIsReady.put(jSONObject.optString("placementName"), false);
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            /* class com.ironsource.adapters.tapjoy.TapjoyAdapter.AnonymousClass8 */

            public void run() {
                String optString = jSONObject.optString("placementName");
                if (!TapjoyAdapter.this.mIsPlacementToAd.containsKey(optString) || !((TJPlacement) TapjoyAdapter.this.mIsPlacementToAd.get(optString)).isContentReady()) {
                    TapjoyAdapter tapjoyAdapter = TapjoyAdapter.this;
                    tapjoyAdapter.log("showInterstitial - onInterstitialAdShowFailed - placementName = " + optString);
                    interstitialSmashListener.onInterstitialAdShowFailed(ErrorBuilder.buildNoAdsToShowError("Interstitial"));
                    return;
                }
                TapjoyAdapter tapjoyAdapter2 = TapjoyAdapter.this;
                tapjoyAdapter2.log("showInterstitial - showContent - placementName = " + optString);
                ((TJPlacement) TapjoyAdapter.this.mIsPlacementToAd.get(optString)).showContent();
            }
        });
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialAdapterApi
    public boolean isInterstitialReady(JSONObject jSONObject) {
        String optString = jSONObject.optString("placementName");
        return this.mIsPlacementToIsReady.containsKey(optString) && this.mIsPlacementToIsReady.get(optString).booleanValue();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private TJPlacement getAuctionPlacement(String str, String str2) {
        try {
            TJPlacement placement = Tapjoy.getPlacement(str, this);
            placement.setMediationName("ironsource");
            placement.setAdapterVersion(VERSION);
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str2);
            hashMap.put("id", jSONObject.getString("id"));
            hashMap.put(TapjoyAuctionFlags.AUCTION_DATA, jSONObject.getString(TapjoyAuctionFlags.AUCTION_DATA));
            placement.setAuctionData(hashMap);
            return placement;
        } catch (Exception e) {
            log("error - generateAuctionPlacement " + e.getMessage());
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private TJPlacement getPlacement(String str) {
        TJPlacement placement = Tapjoy.getPlacement(str, this);
        if (placement != null) {
            placement.setMediationName("ironsource");
            placement.setAdapterVersion(VERSION);
            return placement;
        }
        log("error - getPlacement - TJPlacement is null");
        return null;
    }

    @Override // com.tapjoy.TJPlacementListener
    public void onRequestSuccess(final TJPlacement tJPlacement) {
        log("onRequestSuccess " + tJPlacement.getName());
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            /* class com.ironsource.adapters.tapjoy.TapjoyAdapter.AnonymousClass9 */

            public void run() {
                if (!tJPlacement.isContentAvailable()) {
                    TapjoyAdapter.this.mThreadPool.execute(new Runnable() {
                        /* class com.ironsource.adapters.tapjoy.TapjoyAdapter.AnonymousClass9.AnonymousClass1 */

                        public void run() {
                            if (TapjoyAdapter.this.mRvPlacementToListener.containsKey(tJPlacement.getName())) {
                                ((RewardedVideoSmashListener) TapjoyAdapter.this.mRvPlacementToListener.get(tJPlacement.getName())).onRewardedVideoAvailabilityChanged(false);
                                try {
                                    ((RewardedVideoSmashListener) TapjoyAdapter.this.mRvPlacementToListener.get(tJPlacement.getName())).onRewardedVideoLoadFailed(new IronSourceError(IronSourceError.ERROR_CODE_NO_ADS_TO_SHOW, "No content available"));
                                } catch (Throwable unused) {
                                }
                            }
                            if (TapjoyAdapter.this.mIsPlacementToListener.containsKey(tJPlacement.getName())) {
                                ((InterstitialSmashListener) TapjoyAdapter.this.mIsPlacementToListener.get(tJPlacement.getName())).onInterstitialAdLoadFailed(new IronSourceError(IronSourceConstants.errorCode_biddingDataException, "No content available"));
                            }
                        }
                    });
                }
            }
        });
    }

    @Override // com.tapjoy.TJPlacementListener
    public void onRequestFailure(TJPlacement tJPlacement, TJError tJError) {
        log("onRequestFailure " + tJPlacement.getName() + " " + tJError.message);
        if (this.mRvPlacementToListener.containsKey(tJPlacement.getName())) {
            this.mRvPlacementToListener.get(tJPlacement.getName()).onRewardedVideoAvailabilityChanged(false);
            try {
                this.mRvPlacementToListener.get(tJPlacement.getName()).onRewardedVideoLoadFailed(new IronSourceError(tJError.code, tJError.message + "( " + tJError + " )"));
            } catch (Throwable unused) {
            }
        }
        if (this.mIsPlacementToListener.containsKey(tJPlacement.getName())) {
            this.mIsPlacementToListener.get(tJPlacement.getName()).onInterstitialAdLoadFailed(new IronSourceError(tJError.code, tJError.message));
        }
    }

    @Override // com.tapjoy.TJPlacementListener
    public void onContentReady(TJPlacement tJPlacement) {
        String name = tJPlacement.getName();
        log("onContentReady " + name);
        if (this.mRvPlacementToListener.containsKey(name)) {
            this.mRvPlacementToListener.get(name).onRewardedVideoAvailabilityChanged(true);
            this.mRvPlacementToIsReady.put(name, true);
        }
        if (this.mIsPlacementToListener.containsKey(name)) {
            this.mIsPlacementToListener.get(name).onInterstitialAdReady();
            this.mIsPlacementToIsReady.put(name, true);
        }
    }

    @Override // com.tapjoy.TJPlacementListener
    public void onContentShow(TJPlacement tJPlacement) {
        String name = tJPlacement.getName();
        log("onContentShow " + name);
        if (this.mRvPlacementToListener.containsKey(name)) {
            this.mRvPlacementToListener.get(name).onRewardedVideoAdOpened();
        }
        if (this.mIsPlacementToListener.containsKey(name)) {
            this.mIsPlacementToListener.get(name).onInterstitialAdOpened();
            this.mIsPlacementToListener.get(name).onInterstitialAdShowSucceeded();
        }
    }

    @Override // com.tapjoy.TJPlacementListener
    public void onContentDismiss(TJPlacement tJPlacement) {
        log("onContentDismiss " + tJPlacement.getName());
        if (this.mRvPlacementToListener.containsKey(tJPlacement.getName())) {
            this.mRvPlacementToListener.get(tJPlacement.getName()).onRewardedVideoAdClosed();
        }
        if (this.mIsPlacementToListener.containsKey(tJPlacement.getName())) {
            this.mIsPlacementToListener.get(tJPlacement.getName()).onInterstitialAdClosed();
        }
    }

    @Override // com.tapjoy.TJPlacementListener
    public void onPurchaseRequest(TJPlacement tJPlacement, TJActionRequest tJActionRequest, String str) {
        log("onPurchaseRequest " + tJPlacement.getName());
    }

    @Override // com.tapjoy.TJPlacementListener
    public void onRewardRequest(TJPlacement tJPlacement, TJActionRequest tJActionRequest, String str, int i) {
        log("onRewardRequest " + tJPlacement.getName());
    }

    @Override // com.tapjoy.TJPlacementListener
    public void onClick(TJPlacement tJPlacement) {
        log("onClick " + tJPlacement.getName());
        if (this.mRvPlacementToListener.containsKey(tJPlacement.getName())) {
            this.mRvPlacementToListener.get(tJPlacement.getName()).onRewardedVideoAdClicked();
        }
        if (this.mIsPlacementToListener.containsKey(tJPlacement.getName())) {
            this.mIsPlacementToListener.get(tJPlacement.getName()).onInterstitialAdClicked();
        }
    }

    @Override // com.tapjoy.TJPlacementVideoListener
    public void onVideoStart(TJPlacement tJPlacement) {
        log("onVideoStart " + tJPlacement.getName());
        if (this.mRvPlacementToListener.containsKey(tJPlacement.getName())) {
            this.mRvPlacementToListener.get(tJPlacement.getName()).onRewardedVideoAdStarted();
        }
    }

    @Override // com.tapjoy.TJPlacementVideoListener
    public void onVideoError(TJPlacement tJPlacement, String str) {
        log("onVideoError " + tJPlacement.getName() + " " + str);
    }

    @Override // com.tapjoy.TJPlacementVideoListener
    public void onVideoComplete(TJPlacement tJPlacement) {
        log("onVideoComplete " + tJPlacement.getName());
        if (this.mRvPlacementToListener.containsKey(tJPlacement.getName())) {
            this.mRvPlacementToListener.get(tJPlacement.getName()).onRewardedVideoAdEnded();
            this.mRvPlacementToListener.get(tJPlacement.getName()).onRewardedVideoAdRewarded();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void log(String str) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "TapjoyAdapter " + str, 1);
    }

    private Map<String, Object> getBiddingData() {
        if (this.mInitState == InitState.INIT_STATE_ERROR) {
            log("returning nil as token since init failed");
            return null;
        }
        String userToken = Tapjoy.getUserToken();
        if (TextUtils.isEmpty(userToken)) {
            userToken = "";
        }
        log("token = " + userToken);
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.IRONSOURCE_BIDDING_TOKEN_KEY, userToken);
        return hashMap;
    }
}
