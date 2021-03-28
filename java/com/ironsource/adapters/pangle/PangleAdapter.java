package com.ironsource.adapters.pangle;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.AdapterUtils;
import com.ironsource.mediationsdk.IntegrationData;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class PangleAdapter extends AbstractAdapter {
    private static final String APP_ID = "appID";
    private static final String GitHash = "4bbfb8db4";
    private static final String PLACEMENT_ID = "slotID";
    private static final String VERSION = "4.1.0";
    private static AtomicBoolean mDidCallInitSDK;
    private Activity mActivity;
    private ConcurrentHashMap<String, TTFullScreenVideoAd> mPlacementIdToInterstitialAd;
    private ConcurrentHashMap<String, InterstitialSmashListener> mPlacementIdToInterstitialSmashListener;
    private ConcurrentHashMap<String, TTRewardVideoAd> mPlacementIdToRewardedVideoAd;
    private ConcurrentHashMap<String, RewardedVideoSmashListener> mPlacementIdToRewardedVideoSmashListener;
    private TTAdNative mTTAdNative;

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getVersion() {
        return VERSION;
    }

    public static PangleAdapter startAdapter(String str) {
        return new PangleAdapter(str);
    }

    private PangleAdapter(String str) {
        super(str);
        if (mDidCallInitSDK == null) {
            mDidCallInitSDK = new AtomicBoolean(false);
        }
        this.mPlacementIdToRewardedVideoSmashListener = new ConcurrentHashMap<>();
        this.mPlacementIdToRewardedVideoAd = new ConcurrentHashMap<>();
        this.mPlacementIdToInterstitialSmashListener = new ConcurrentHashMap<>();
        this.mPlacementIdToInterstitialAd = new ConcurrentHashMap<>();
    }

    public static IntegrationData getIntegrationData(Activity activity) {
        return new IntegrationData("Pangle", VERSION);
    }

    public static String getAdapterSDKVersion() {
        return TTAdSdk.getAdManager() != null ? TTAdSdk.getAdManager().getSDKVersion() : "Pangle sdk was not initiated yet";
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getCoreSDKVersion() {
        return TTAdSdk.getAdManager().getSDKVersion();
    }

    public void initInterstitial(final Activity activity, String str, String str2, JSONObject jSONObject, final InterstitialSmashListener interstitialSmashListener) {
        this.mActivity = activity;
        final String optString = jSONObject.optString(APP_ID);
        if (TextUtils.isEmpty(optString)) {
            logApi("error - missing param = appID");
            interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("app id is empty", "Interstitial"));
            return;
        }
        logApi("appId = " + optString);
        if (TextUtils.isEmpty(str2)) {
            logApi("error - missing param = slotID");
            interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("user id is empty", "Interstitial"));
            return;
        }
        String optString2 = jSONObject.optString(PLACEMENT_ID);
        if (TextUtils.isEmpty(optString2)) {
            logApi("error - missing param = slotID");
            interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("placement id is empty", "Interstitial"));
            return;
        }
        logApi("placementId = " + optString2);
        this.mPlacementIdToInterstitialSmashListener.put(optString2, interstitialSmashListener);
        runOnUiThread(new Runnable() {
            /* class com.ironsource.adapters.pangle.PangleAdapter.AnonymousClass1 */

            public void run() {
                PangleAdapter.this.initSDK(activity, optString);
                interstitialSmashListener.onInterstitialInitSuccess();
            }
        });
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialAdapterApi
    public void loadInterstitial(JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        final String optString = jSONObject.optString(PLACEMENT_ID);
        if (TextUtils.isEmpty(optString)) {
            logApi("error - missing param = slotID");
            interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("placement id is empty", "Interstitial"));
            return;
        }
        logApi("placementId = " + optString);
        runOnUiThread(new Runnable() {
            /* class com.ironsource.adapters.pangle.PangleAdapter.AnonymousClass2 */

            public void run() {
                PangleAdapter.this.mTTAdNative.loadFullScreenVideoAd(PangleAdapter.this.createAdSlot(optString), new InterstitialAdLoadListener(optString));
            }
        });
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialAdapterApi
    public void showInterstitial(JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        final String optString = jSONObject.optString(PLACEMENT_ID);
        logApi("placementId = " + optString);
        if (isInterstitialReady(jSONObject)) {
            final TTFullScreenVideoAd tTFullScreenVideoAd = this.mPlacementIdToInterstitialAd.get(optString);
            runOnUiThread(new Runnable() {
                /* class com.ironsource.adapters.pangle.PangleAdapter.AnonymousClass3 */

                public void run() {
                    tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(new InterstitialAdInteractionListener(optString));
                    tTFullScreenVideoAd.showFullScreenVideoAd(PangleAdapter.this.mActivity);
                }
            });
            return;
        }
        logApi("show failed no ad found for placement");
        interstitialSmashListener.onInterstitialAdShowFailed(ErrorBuilder.buildShowFailedError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT, getProviderName() + " - show failed no ad found"));
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialAdapterApi
    public boolean isInterstitialReady(JSONObject jSONObject) {
        return this.mPlacementIdToInterstitialAd.containsKey(jSONObject.optString(PLACEMENT_ID));
    }

    private class InterstitialAdLoadListener implements TTAdNative.FullScreenVideoAdListener {
        private String mPlacementId;

        InterstitialAdLoadListener(String str) {
            this.mPlacementId = str;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onError(int i, String str) {
            String format = String.format("load failed for placementId = %s, error code = %d, message = %s", this.mPlacementId, Integer.valueOf(i), str);
            PangleAdapter.this.logCallback(format);
            InterstitialSmashListener interstitialSmashListener = (InterstitialSmashListener) PangleAdapter.this.mPlacementIdToInterstitialSmashListener.get(this.mPlacementId);
            if (interstitialSmashListener != null) {
                interstitialSmashListener.onInterstitialAdLoadFailed(ErrorBuilder.buildLoadFailedError("Interstitial", PangleAdapter.this.getProviderName(), format));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
            PangleAdapter pangleAdapter = PangleAdapter.this;
            pangleAdapter.logCallback("placement = " + this.mPlacementId);
            InterstitialSmashListener interstitialSmashListener = (InterstitialSmashListener) PangleAdapter.this.mPlacementIdToInterstitialSmashListener.get(this.mPlacementId);
            if (interstitialSmashListener == null) {
                return;
            }
            if (tTFullScreenVideoAd == null) {
                interstitialSmashListener.onInterstitialAdLoadFailed(ErrorBuilder.buildLoadFailedError("Interstitial", PangleAdapter.this.getProviderName(), "load failed - ad is null"));
                return;
            }
            PangleAdapter.this.mPlacementIdToInterstitialAd.put(this.mPlacementId, tTFullScreenVideoAd);
            interstitialSmashListener.onInterstitialAdReady();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoCached() {
            PangleAdapter pangleAdapter = PangleAdapter.this;
            pangleAdapter.logCallback("placement = " + this.mPlacementId);
        }
    }

    private class InterstitialAdInteractionListener implements TTFullScreenVideoAd.FullScreenVideoAdInteractionListener {
        private String mPlacementId;

        InterstitialAdInteractionListener(String str) {
            this.mPlacementId = str;
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onAdShow() {
            PangleAdapter pangleAdapter = PangleAdapter.this;
            pangleAdapter.logCallback("placement = " + this.mPlacementId);
            InterstitialSmashListener interstitialSmashListener = (InterstitialSmashListener) PangleAdapter.this.mPlacementIdToInterstitialSmashListener.get(this.mPlacementId);
            if (interstitialSmashListener != null) {
                interstitialSmashListener.onInterstitialAdOpened();
                interstitialSmashListener.onInterstitialAdShowSucceeded();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onAdVideoBarClick() {
            PangleAdapter pangleAdapter = PangleAdapter.this;
            pangleAdapter.logCallback("placement = " + this.mPlacementId);
            InterstitialSmashListener interstitialSmashListener = (InterstitialSmashListener) PangleAdapter.this.mPlacementIdToInterstitialSmashListener.get(this.mPlacementId);
            if (interstitialSmashListener != null) {
                interstitialSmashListener.onInterstitialAdClicked();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onAdClose() {
            PangleAdapter pangleAdapter = PangleAdapter.this;
            pangleAdapter.logCallback("placement = " + this.mPlacementId);
            InterstitialSmashListener interstitialSmashListener = (InterstitialSmashListener) PangleAdapter.this.mPlacementIdToInterstitialSmashListener.get(this.mPlacementId);
            if (interstitialSmashListener != null) {
                interstitialSmashListener.onInterstitialAdClosed();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onVideoComplete() {
            PangleAdapter pangleAdapter = PangleAdapter.this;
            pangleAdapter.logCallback("placement = " + this.mPlacementId);
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onSkippedVideo() {
            PangleAdapter pangleAdapter = PangleAdapter.this;
            pangleAdapter.logCallback("placement = " + this.mPlacementId);
        }
    }

    public void initRewardedVideo(final Activity activity, String str, String str2, JSONObject jSONObject, final RewardedVideoSmashListener rewardedVideoSmashListener) {
        this.mActivity = activity;
        final String optString = jSONObject.optString(APP_ID);
        if (TextUtils.isEmpty(optString)) {
            logApi("error - missing param = appID");
            rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("app id is empty", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            return;
        }
        logApi("appId = " + optString);
        if (TextUtils.isEmpty(str2)) {
            logApi("error - missing param = slotID");
            rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("user id is empty", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            return;
        }
        final String optString2 = jSONObject.optString(PLACEMENT_ID);
        if (TextUtils.isEmpty(optString2)) {
            logApi("error - missing param = slotID");
            rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("placement id is empty", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            return;
        }
        logApi("placementId = " + optString2);
        this.mPlacementIdToRewardedVideoSmashListener.put(optString2, rewardedVideoSmashListener);
        runOnUiThread(new Runnable() {
            /* class com.ironsource.adapters.pangle.PangleAdapter.AnonymousClass4 */

            public void run() {
                PangleAdapter.this.initSDK(activity, optString);
                PangleAdapter.this.loadRewardedVideo(optString2, rewardedVideoSmashListener);
            }
        });
    }

    public void fetchRewardedVideo(JSONObject jSONObject) {
        String optString = jSONObject.optString(PLACEMENT_ID);
        loadRewardedVideo(optString, this.mPlacementIdToRewardedVideoSmashListener.get(optString));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void loadRewardedVideo(final String str, RewardedVideoSmashListener rewardedVideoSmashListener) {
        if (TextUtils.isEmpty(str)) {
            logApi("error - missing param = slotID");
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
            return;
        }
        logApi("placementId = " + str);
        runOnUiThread(new Runnable() {
            /* class com.ironsource.adapters.pangle.PangleAdapter.AnonymousClass5 */

            public void run() {
                PangleAdapter.this.mTTAdNative.loadRewardVideoAd(PangleAdapter.this.createAdSlot(str), new RewardedVideoAdLoadListener(str));
            }
        });
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoAdapterApi
    public void showRewardedVideo(JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        final String optString = jSONObject.optString(PLACEMENT_ID);
        logApi("placementId = " + optString);
        if (isRewardedVideoAvailable(jSONObject)) {
            final TTRewardVideoAd tTRewardVideoAd = this.mPlacementIdToRewardedVideoAd.get(optString);
            runOnUiThread(new Runnable() {
                /* class com.ironsource.adapters.pangle.PangleAdapter.AnonymousClass6 */

                public void run() {
                    tTRewardVideoAd.setRewardAdInteractionListener(new RewardedVideoAdInteractionListener(optString));
                    tTRewardVideoAd.showRewardVideoAd(PangleAdapter.this.mActivity);
                }
            });
            return;
        }
        logApi("show failed - no ad for placement");
        rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoAdapterApi
    public boolean isRewardedVideoAvailable(JSONObject jSONObject) {
        return this.mPlacementIdToRewardedVideoAd.containsKey(jSONObject.optString(PLACEMENT_ID));
    }

    private class RewardedVideoAdLoadListener implements TTAdNative.RewardVideoAdListener {
        private String mPlacementId;

        RewardedVideoAdLoadListener(String str) {
            this.mPlacementId = str;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onError(int i, String str) {
            PangleAdapter.this.logCallback(String.format("load failed for placementId = %s, error code = %d, message = %s", this.mPlacementId, Integer.valueOf(i), str));
            RewardedVideoSmashListener rewardedVideoSmashListener = (RewardedVideoSmashListener) PangleAdapter.this.mPlacementIdToRewardedVideoSmashListener.get(this.mPlacementId);
            if (rewardedVideoSmashListener != null) {
                rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
            PangleAdapter pangleAdapter = PangleAdapter.this;
            pangleAdapter.logCallback("placement = " + this.mPlacementId);
            RewardedVideoSmashListener rewardedVideoSmashListener = (RewardedVideoSmashListener) PangleAdapter.this.mPlacementIdToRewardedVideoSmashListener.get(this.mPlacementId);
            if (rewardedVideoSmashListener == null) {
                return;
            }
            if (tTRewardVideoAd == null) {
                PangleAdapter.this.logCallback("load failed - ad is null");
                rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
                return;
            }
            PangleAdapter.this.mPlacementIdToRewardedVideoAd.put(this.mPlacementId, tTRewardVideoAd);
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(true);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoCached() {
            PangleAdapter pangleAdapter = PangleAdapter.this;
            pangleAdapter.logCallback("placement = " + this.mPlacementId);
        }
    }

    private class RewardedVideoAdInteractionListener implements TTRewardVideoAd.RewardAdInteractionListener {
        private String mPlacementId;

        RewardedVideoAdInteractionListener(String str) {
            this.mPlacementId = str;
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onAdShow() {
            PangleAdapter pangleAdapter = PangleAdapter.this;
            pangleAdapter.logCallback("placement = " + this.mPlacementId);
            RewardedVideoSmashListener rewardedVideoSmashListener = (RewardedVideoSmashListener) PangleAdapter.this.mPlacementIdToRewardedVideoSmashListener.get(this.mPlacementId);
            if (rewardedVideoSmashListener != null) {
                rewardedVideoSmashListener.onRewardedVideoAdOpened();
                rewardedVideoSmashListener.onRewardedVideoAdStarted();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onAdVideoBarClick() {
            PangleAdapter pangleAdapter = PangleAdapter.this;
            pangleAdapter.logCallback("placement = " + this.mPlacementId);
            RewardedVideoSmashListener rewardedVideoSmashListener = (RewardedVideoSmashListener) PangleAdapter.this.mPlacementIdToRewardedVideoSmashListener.get(this.mPlacementId);
            if (rewardedVideoSmashListener != null) {
                rewardedVideoSmashListener.onRewardedVideoAdClicked();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onAdClose() {
            PangleAdapter pangleAdapter = PangleAdapter.this;
            pangleAdapter.logCallback("placement = " + this.mPlacementId);
            RewardedVideoSmashListener rewardedVideoSmashListener = (RewardedVideoSmashListener) PangleAdapter.this.mPlacementIdToRewardedVideoSmashListener.get(this.mPlacementId);
            if (rewardedVideoSmashListener != null) {
                rewardedVideoSmashListener.onRewardedVideoAdClosed();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onVideoComplete() {
            PangleAdapter pangleAdapter = PangleAdapter.this;
            pangleAdapter.logCallback("placement = " + this.mPlacementId);
            RewardedVideoSmashListener rewardedVideoSmashListener = (RewardedVideoSmashListener) PangleAdapter.this.mPlacementIdToRewardedVideoSmashListener.get(this.mPlacementId);
            if (rewardedVideoSmashListener != null) {
                rewardedVideoSmashListener.onRewardedVideoAdEnded();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onVideoError() {
            PangleAdapter pangleAdapter = PangleAdapter.this;
            pangleAdapter.logCallback("placement = " + this.mPlacementId);
            RewardedVideoSmashListener rewardedVideoSmashListener = (RewardedVideoSmashListener) PangleAdapter.this.mPlacementIdToRewardedVideoSmashListener.get(this.mPlacementId);
            if (rewardedVideoSmashListener != null) {
                rewardedVideoSmashListener.onRewardedVideoAdShowFailed(ErrorBuilder.buildShowFailedError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT, PangleAdapter.this.getProviderName() + " video error"));
                rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onRewardVerify(boolean z, int i, String str) {
            RewardedVideoSmashListener rewardedVideoSmashListener;
            PangleAdapter pangleAdapter = PangleAdapter.this;
            pangleAdapter.logCallback("placement = " + this.mPlacementId);
            PangleAdapter pangleAdapter2 = PangleAdapter.this;
            pangleAdapter2.logCallback("rewardVerify = " + z);
            PangleAdapter pangleAdapter3 = PangleAdapter.this;
            pangleAdapter3.logCallback("rewardAmount = " + i);
            PangleAdapter pangleAdapter4 = PangleAdapter.this;
            pangleAdapter4.logCallback("rewardName = " + str);
            if (z && (rewardedVideoSmashListener = (RewardedVideoSmashListener) PangleAdapter.this.mPlacementIdToRewardedVideoSmashListener.get(this.mPlacementId)) != null) {
                rewardedVideoSmashListener.onRewardedVideoAdRewarded();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void initSDK(Activity activity, String str) {
        if (mDidCallInitSDK.compareAndSet(false, true)) {
            logApi("appId = " + str);
            TTAdConfig.Builder builder = new TTAdConfig.Builder();
            builder.appId(str);
            builder.appName("IronSource mediation - Pangle adapter version 4.1.0");
            if (isAdaptersDebugEnabled()) {
                builder.debug(true);
            }
            TTAdSdk.init(activity, builder.build());
            this.mTTAdNative = TTAdSdk.getAdManager().createAdNative(activity);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private AdSlot createAdSlot(String str) {
        logApi("placementId = " + str);
        AdSlot.Builder builder = new AdSlot.Builder();
        builder.setCodeId(str);
        Activity activity = this.mActivity;
        int dpToPixels = AdapterUtils.dpToPixels(activity, activity.getResources().getConfiguration().screenWidthDp);
        Activity activity2 = this.mActivity;
        builder.setImageAcceptedSize(dpToPixels, AdapterUtils.dpToPixels(activity2, activity2.getResources().getConfiguration().screenHeightDp));
        return builder.build();
    }

    private void runOnUiThread(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    private void logApi(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.ADAPTER_API, createLogMessage(str), 0);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void logCallback(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, createLogMessage(str), 0);
    }

    private String createLogMessage(String str) {
        return String.format("%s %s - %s", getClass().getSimpleName(), getMethodNameForLog(), str);
    }

    private String getMethodNameForLog() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (!stackTrace[5].getMethodName().contains("access$")) {
            return stackTrace[5].getMethodName();
        }
        String[] split = stackTrace[6].getClassName().split("\\$");
        if (split.length <= 1) {
            return stackTrace[6].getMethodName();
        }
        return split[1] + "." + stackTrace[6].getMethodName();
    }
}
