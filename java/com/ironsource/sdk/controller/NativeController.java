package com.ironsource.sdk.controller;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.ironsource.sdk.ISNAdView.ISNAdView;
import com.ironsource.sdk.data.DemandSource;
import com.ironsource.sdk.data.ISNEnums;
import com.ironsource.sdk.listeners.OnOfferWallListener;
import com.ironsource.sdk.listeners.internals.DSBannerListener;
import com.ironsource.sdk.listeners.internals.DSInterstitialListener;
import com.ironsource.sdk.listeners.internals.DSRewardedVideoListener;
import java.util.Map;
import org.json.JSONObject;

public class NativeController implements IronSourceController {
    private static final Handler mUiHandler = new Handler(Looper.getMainLooper());
    private String mFailedControllerReason = "";
    private OnOfferWallListener mOfferwallListener;

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void destroy() {
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void enterBackground() {
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void enterForeground() {
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public boolean isInterstitialAdAvailable(String str) {
        return false;
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void registerConnectionReceiver(Context context) {
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void restoreSavedState() {
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void setCommunicationWithAdView(ISNAdView iSNAdView) {
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void unregisterConnectionReceiver(Context context) {
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void updateConsentInfo(JSONObject jSONObject) {
    }

    NativeController(final ControllerEventListener controllerEventListener) {
        mUiHandler.post(new Runnable() {
            /* class com.ironsource.sdk.controller.NativeController.AnonymousClass1 */

            public void run() {
                controllerEventListener.handleControllerReady();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void setFailedControllerReason(String str) {
        this.mFailedControllerReason = str;
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public ISNEnums.ControllerType getType() {
        return ISNEnums.ControllerType.Native;
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void initOfferWall(String str, String str2, Map<String, String> map, OnOfferWallListener onOfferWallListener) {
        if (onOfferWallListener != null) {
            this.mOfferwallListener = onOfferWallListener;
            mUiHandler.post(new Runnable() {
                /* class com.ironsource.sdk.controller.NativeController.AnonymousClass2 */

                public void run() {
                    NativeController.this.mOfferwallListener.onOfferwallInitFail(NativeController.this.mFailedControllerReason);
                }
            });
        }
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void showOfferWall(Map<String, String> map) {
        if (this.mOfferwallListener != null) {
            mUiHandler.post(new Runnable() {
                /* class com.ironsource.sdk.controller.NativeController.AnonymousClass3 */

                public void run() {
                    NativeController.this.mOfferwallListener.onOWShowFail(NativeController.this.mFailedControllerReason);
                }
            });
        }
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void getOfferWallCredits(String str, String str2, final OnOfferWallListener onOfferWallListener) {
        if (onOfferWallListener != null) {
            mUiHandler.post(new Runnable() {
                /* class com.ironsource.sdk.controller.NativeController.AnonymousClass4 */

                public void run() {
                    onOfferWallListener.onGetOWCreditsFailed(NativeController.this.mFailedControllerReason);
                }
            });
        }
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void initRewardedVideo(String str, String str2, final DemandSource demandSource, final DSRewardedVideoListener dSRewardedVideoListener) {
        if (dSRewardedVideoListener != null) {
            mUiHandler.post(new Runnable() {
                /* class com.ironsource.sdk.controller.NativeController.AnonymousClass5 */

                public void run() {
                    dSRewardedVideoListener.onAdProductInitFailed(ISNEnums.ProductType.RewardedVideo, demandSource.getDemandSourceName(), NativeController.this.mFailedControllerReason);
                }
            });
        }
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void showRewardedVideo(final JSONObject jSONObject, final DSRewardedVideoListener dSRewardedVideoListener) {
        if (dSRewardedVideoListener != null) {
            mUiHandler.post(new Runnable() {
                /* class com.ironsource.sdk.controller.NativeController.AnonymousClass6 */

                public void run() {
                    dSRewardedVideoListener.onRVShowFail(jSONObject.optString("demandSourceName"), NativeController.this.mFailedControllerReason);
                }
            });
        }
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void initInterstitial(String str, String str2, final DemandSource demandSource, final DSInterstitialListener dSInterstitialListener) {
        if (dSInterstitialListener != null) {
            mUiHandler.post(new Runnable() {
                /* class com.ironsource.sdk.controller.NativeController.AnonymousClass7 */

                public void run() {
                    dSInterstitialListener.onAdProductInitFailed(ISNEnums.ProductType.Interstitial, demandSource.getDemandSourceName(), NativeController.this.mFailedControllerReason);
                }
            });
        }
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void loadInterstitial(final String str, final DSInterstitialListener dSInterstitialListener) {
        if (dSInterstitialListener != null) {
            mUiHandler.post(new Runnable() {
                /* class com.ironsource.sdk.controller.NativeController.AnonymousClass8 */

                public void run() {
                    dSInterstitialListener.onInterstitialLoadFailed(str, NativeController.this.mFailedControllerReason);
                }
            });
        }
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void loadInterstitial(final DemandSource demandSource, Map<String, String> map, final DSInterstitialListener dSInterstitialListener) {
        if (dSInterstitialListener != null) {
            mUiHandler.post(new Runnable() {
                /* class com.ironsource.sdk.controller.NativeController.AnonymousClass9 */

                public void run() {
                    dSInterstitialListener.onInterstitialLoadFailed(demandSource.getId(), NativeController.this.mFailedControllerReason);
                }
            });
        }
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void showInterstitial(final JSONObject jSONObject, final DSInterstitialListener dSInterstitialListener) {
        if (dSInterstitialListener != null) {
            mUiHandler.post(new Runnable() {
                /* class com.ironsource.sdk.controller.NativeController.AnonymousClass10 */

                public void run() {
                    dSInterstitialListener.onInterstitialShowFailed(jSONObject.optString("demandSourceName"), NativeController.this.mFailedControllerReason);
                }
            });
        }
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void showInterstitial(final DemandSource demandSource, Map<String, String> map, final DSInterstitialListener dSInterstitialListener) {
        if (dSInterstitialListener != null) {
            mUiHandler.post(new Runnable() {
                /* class com.ironsource.sdk.controller.NativeController.AnonymousClass11 */

                public void run() {
                    dSInterstitialListener.onInterstitialShowFailed(demandSource.getDemandSourceName(), NativeController.this.mFailedControllerReason);
                }
            });
        }
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void initBanner(String str, String str2, DemandSource demandSource, DSBannerListener dSBannerListener) {
        if (dSBannerListener != null) {
            dSBannerListener.onAdProductInitFailed(ISNEnums.ProductType.Banner, demandSource.getDemandSourceName(), this.mFailedControllerReason);
        }
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void loadBanner(final JSONObject jSONObject, final DSBannerListener dSBannerListener) {
        if (dSBannerListener != null) {
            mUiHandler.post(new Runnable() {
                /* class com.ironsource.sdk.controller.NativeController.AnonymousClass12 */

                public void run() {
                    dSBannerListener.onBannerLoadFail(jSONObject.optString("demandSourceName"), NativeController.this.mFailedControllerReason);
                }
            });
        }
    }
}
