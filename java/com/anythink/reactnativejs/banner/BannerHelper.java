package com.anythink.reactnativejs.banner;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.banner.api.ATBannerListener;
import com.anythink.banner.api.ATBannerView;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.AdError;
import com.anythink.reactnativejs.AnythinkReactContextBaseJavaModule;
import com.anythink.reactnativejs.utils.BaseHelper;
import com.anythink.reactnativejs.utils.Const;
import com.anythink.reactnativejs.utils.MsgTools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import java.util.HashMap;
import org.json.JSONObject;

public class BannerHelper extends BaseHelper {
    private final String TAG = getClass().getSimpleName();
    boolean isReady;
    ATBannerView mBannerView;
    String mPlacementId;

    public BannerHelper(AnythinkReactContextBaseJavaModule anythinkReactContextBaseJavaModule) {
        super(anythinkReactContextBaseJavaModule);
        MsgTools.pirntMsg(this.TAG + " >>> " + this);
        this.mPlacementId = "";
    }

    public void initBanner(String str) {
        this.mPlacementId = str;
        MsgTools.pirntMsg("initBanner >>> " + str);
        ATBannerView aTBannerView = new ATBannerView(getActivity());
        this.mBannerView = aTBannerView;
        aTBannerView.setUnitId(this.mPlacementId);
        this.mBannerView.setBannerAdListener(new ATBannerListener() {
            /* class com.anythink.reactnativejs.banner.BannerHelper.AnonymousClass1 */

            public void onBannerLoaded() {
                BannerHelper.this.isReady = true;
                MsgTools.pirntMsg("onBannerLoaded .." + BannerHelper.this.mPlacementId);
                WritableMap createMap = Arguments.createMap();
                createMap.putString("placementId", BannerHelper.this.mPlacementId);
                BannerHelper.this.sendEvent(Const.BannerCallback.LoadedCallbackKey, createMap);
            }

            public void onBannerFailed(AdError adError) {
                BannerHelper.this.isReady = false;
                MsgTools.pirntMsg("onBannerFailed >> " + BannerHelper.this.mPlacementId + ", " + adError.getFullErrorInfo());
                WritableMap createMap = Arguments.createMap();
                createMap.putString("placementId", BannerHelper.this.mPlacementId);
                createMap.putString(Const.CallbackKey.ErrorMsg, adError.getFullErrorInfo());
                BannerHelper.this.sendEvent(Const.BannerCallback.LoadFailCallbackKey, createMap);
            }

            public void onBannerClicked(ATAdInfo aTAdInfo) {
                MsgTools.pirntMsg("onBannerClicked .." + BannerHelper.this.mPlacementId);
                WritableMap createMap = Arguments.createMap();
                createMap.putString("placementId", BannerHelper.this.mPlacementId);
                createMap.putString(Const.CallbackKey.AdInfo, aTAdInfo.toString());
                BannerHelper.this.sendEvent(Const.BannerCallback.ClickCallbackKey, createMap);
            }

            public void onBannerShow(ATAdInfo aTAdInfo) {
                BannerHelper.this.isReady = false;
                MsgTools.pirntMsg("onBannerShow .." + BannerHelper.this.mPlacementId);
                WritableMap createMap = Arguments.createMap();
                createMap.putString("placementId", BannerHelper.this.mPlacementId);
                createMap.putString(Const.CallbackKey.AdInfo, aTAdInfo.toString());
                BannerHelper.this.sendEvent(Const.BannerCallback.ShowCallbackKey, createMap);
            }

            public void onBannerClose(ATAdInfo aTAdInfo) {
                BannerHelper.this.isReady = false;
                MsgTools.pirntMsg("onBannerClose .." + BannerHelper.this.mPlacementId);
                WritableMap createMap = Arguments.createMap();
                createMap.putString("placementId", BannerHelper.this.mPlacementId);
                createMap.putString(Const.CallbackKey.AdInfo, aTAdInfo.toString());
                BannerHelper.this.sendEvent(Const.BannerCallback.CloseCallbackKey, createMap);
            }

            public void onBannerAutoRefreshed(ATAdInfo aTAdInfo) {
                MsgTools.pirntMsg("onBannerAutoRefreshed .." + BannerHelper.this.mPlacementId);
                WritableMap createMap = Arguments.createMap();
                createMap.putString("placementId", BannerHelper.this.mPlacementId);
                createMap.putString(Const.CallbackKey.AdInfo, aTAdInfo.toString());
                BannerHelper.this.sendEvent(Const.BannerCallback.RefreshCallbackKey, createMap);
            }

            public void onBannerAutoRefreshFail(AdError adError) {
                BannerHelper.this.isReady = false;
                MsgTools.pirntMsg("onBannerAutoRefreshFail .." + BannerHelper.this.mPlacementId + ", " + adError.getFullErrorInfo());
                WritableMap createMap = Arguments.createMap();
                createMap.putString("placementId", BannerHelper.this.mPlacementId);
                createMap.putString(Const.CallbackKey.ErrorMsg, adError.getFullErrorInfo());
                BannerHelper.this.sendEvent(Const.BannerCallback.RefreshFailCallbackKey, createMap);
            }
        });
    }

    public void loadBanner(final String str, final String str2) {
        MsgTools.pirntMsg("loadBanner >>> " + str + ", settings - " + str2);
        runOnUiThread(new Runnable() {
            /* class com.anythink.reactnativejs.banner.BannerHelper.AnonymousClass2 */

            public void run() {
                if (BannerHelper.this.mBannerView == null) {
                    BannerHelper.this.initBanner(str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        int optInt = jSONObject.has("width") ? jSONObject.optInt("width") : 0;
                        int optInt2 = jSONObject.has("height") ? jSONObject.optInt("height") : 0;
                        if (BannerHelper.this.mBannerView != null) {
                            MsgTools.pirntMsg("loadBanner, width: " + optInt + ", height: " + optInt2);
                            if (BannerHelper.this.mBannerView.getLayoutParams() == null) {
                                BannerHelper.this.mBannerView.setLayoutParams(new FrameLayout.LayoutParams(optInt, optInt2));
                            } else {
                                BannerHelper.this.mBannerView.getLayoutParams().width = optInt;
                                BannerHelper.this.mBannerView.getLayoutParams().height = optInt2;
                            }
                        }
                        int optInt3 = jSONObject.has(Const.Banner.AdaptiveOrientation) ? jSONObject.optInt(Const.Banner.AdaptiveOrientation) : 0;
                        int optInt4 = jSONObject.has(Const.Banner.AdaptiveWidth) ? jSONObject.optInt(Const.Banner.AdaptiveWidth) : 0;
                        if (!jSONObject.has(Const.Banner.AdaptiveType)) {
                            jSONObject.put(Const.Banner.AdaptiveType, 0);
                        }
                        jSONObject.put(Const.Banner.InlineAdaptiveOrientation, optInt3);
                        jSONObject.put(Const.Banner.InlineAdaptiveWidth, optInt4);
                        HashMap hashMap = new HashMap();
                        BannerHelper.fillMapFromJsonObject(hashMap, jSONObject);
                        if (ATSDK.isNetworkLogDebug()) {
                            MsgTools.pirntMsg("Banner localExtra: " + jSONObject.toString());
                        }
                        BannerHelper.this.mBannerView.setLocalExtra(hashMap);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                BannerHelper.this.mBannerView.loadAd();
            }
        });
    }

    public void showBannerWithRect(String str) {
        MsgTools.pirntMsg("showBannerWithRect >>> " + this.mPlacementId + ", rect >>>" + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                final int optInt = jSONObject.has(Const.X) ? jSONObject.optInt(Const.X) : 0;
                final int optInt2 = jSONObject.has(Const.Y) ? jSONObject.optInt(Const.Y) : 0;
                final int optInt3 = jSONObject.has("width") ? jSONObject.optInt("width") : 0;
                final int optInt4 = jSONObject.has("height") ? jSONObject.optInt("height") : 0;
                runOnUiThread(new Runnable() {
                    /* class com.anythink.reactnativejs.banner.BannerHelper.AnonymousClass3 */

                    public void run() {
                        if (BannerHelper.this.mBannerView != null) {
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(optInt3, optInt4);
                            layoutParams.leftMargin = optInt;
                            layoutParams.topMargin = optInt2;
                            if (BannerHelper.this.mBannerView.getParent() != null) {
                                ((ViewGroup) BannerHelper.this.mBannerView.getParent()).removeView(BannerHelper.this.mBannerView);
                            }
                            BannerHelper.this.getActivity().addContentView(BannerHelper.this.mBannerView, layoutParams);
                            return;
                        }
                        MsgTools.pirntMsg("showBannerWithRect error  ..you must call loadBanner first, placementId >>>  " + BannerHelper.this.mPlacementId);
                    }
                });
            } catch (Exception e) {
                MsgTools.pirntMsg("showBannerWithRect error  .. " + e.getMessage());
            }
        } else {
            MsgTools.pirntMsg("showBannerWithRect error without rect, placementId >>> " + this.mPlacementId);
        }
    }

    public void showBannerWithPosition(final String str) {
        MsgTools.pirntMsg("showBannerWithPostion >>> " + this.mPlacementId + ", position >>> " + str);
        runOnUiThread(new Runnable() {
            /* class com.anythink.reactnativejs.banner.BannerHelper.AnonymousClass4 */

            public void run() {
                int i;
                if (BannerHelper.this.mBannerView != null) {
                    int i2 = 0;
                    if (BannerHelper.this.mBannerView.getLayoutParams() != null) {
                        i2 = BannerHelper.this.mBannerView.getLayoutParams().width;
                        i = BannerHelper.this.mBannerView.getLayoutParams().height;
                    } else {
                        i = 0;
                    }
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i2, i);
                    if ("top".equals(str)) {
                        layoutParams.gravity = 49;
                    } else {
                        layoutParams.gravity = 81;
                    }
                    if (BannerHelper.this.mBannerView.getParent() != null) {
                        ((ViewGroup) BannerHelper.this.mBannerView.getParent()).removeView(BannerHelper.this.mBannerView);
                    }
                    BannerHelper.this.getActivity().addContentView(BannerHelper.this.mBannerView, layoutParams);
                    return;
                }
                MsgTools.pirntMsg("showBannerWithPostion error  ..you must call loadBanner first, placementId >>> " + BannerHelper.this.mPlacementId);
            }
        });
    }

    public void reshowBanner() {
        MsgTools.pirntMsg("reshowBanner >>> " + this.mPlacementId);
        runOnUiThread(new Runnable() {
            /* class com.anythink.reactnativejs.banner.BannerHelper.AnonymousClass5 */

            public void run() {
                if (BannerHelper.this.mBannerView != null) {
                    BannerHelper.this.mBannerView.setVisibility(0);
                    return;
                }
                MsgTools.pirntMsg("reshowBanner error  ..you must call loadBanner first, placementId >>> " + BannerHelper.this.mPlacementId);
            }
        });
    }

    public void hideBanner() {
        MsgTools.pirntMsg("hideBanner >>> " + this.mPlacementId);
        runOnUiThread(new Runnable() {
            /* class com.anythink.reactnativejs.banner.BannerHelper.AnonymousClass6 */

            public void run() {
                if (BannerHelper.this.mBannerView != null) {
                    BannerHelper.this.mBannerView.setVisibility(8);
                    return;
                }
                MsgTools.pirntMsg("hideBanner error  ..you must call loadBanner first, placementId >>> " + BannerHelper.this.mPlacementId);
            }
        });
    }

    public void removeBanner() {
        MsgTools.pirntMsg("removeBanner >>> " + this.mPlacementId);
        runOnUiThread(new Runnable() {
            /* class com.anythink.reactnativejs.banner.BannerHelper.AnonymousClass7 */

            public void run() {
                if (BannerHelper.this.mBannerView == null || BannerHelper.this.mBannerView.getParent() == null) {
                    MsgTools.pirntMsg("removeBanner3 >>> no banner need to be removed, placementId >>> " + BannerHelper.this.mPlacementId);
                    return;
                }
                MsgTools.pirntMsg("removeBanner2 placementId >>> " + BannerHelper.this.mPlacementId);
                ((ViewGroup) BannerHelper.this.mBannerView.getParent()).removeView(BannerHelper.this.mBannerView);
            }
        });
    }

    public boolean isAdReady() {
        MsgTools.pirntMsg("banner isAdReady >>> " + this.mPlacementId + "：" + this.isReady);
        return this.isReady;
    }
}
