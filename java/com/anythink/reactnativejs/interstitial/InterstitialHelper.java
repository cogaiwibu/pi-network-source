package com.anythink.reactnativejs.interstitial;

import android.text.TextUtils;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.AdError;
import com.anythink.interstitial.api.ATInterstitial;
import com.anythink.interstitial.api.ATInterstitialListener;
import com.anythink.reactnativejs.AnythinkReactContextBaseJavaModule;
import com.anythink.reactnativejs.utils.BaseHelper;
import com.anythink.reactnativejs.utils.Const;
import com.anythink.reactnativejs.utils.MsgTools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import java.util.HashMap;
import org.json.JSONObject;

public class InterstitialHelper extends BaseHelper {
    private static final String TAG = InterstitialHelper.class.getSimpleName();
    boolean isReady = false;
    ATInterstitial mInterstitialAd;
    String mPlacementId;

    public InterstitialHelper(AnythinkReactContextBaseJavaModule anythinkReactContextBaseJavaModule) {
        super(anythinkReactContextBaseJavaModule);
        MsgTools.pirntMsg(TAG + " >>> " + this);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void initInterstitial(String str) {
        this.mPlacementId = str;
        MsgTools.pirntMsg("initInterstitial  >>> " + this.mPlacementId);
        ATInterstitial aTInterstitial = new ATInterstitial(getActivity(), str);
        this.mInterstitialAd = aTInterstitial;
        aTInterstitial.setAdListener(new ATInterstitialListener() {
            /* class com.anythink.reactnativejs.interstitial.InterstitialHelper.AnonymousClass1 */

            public void onInterstitialAdLoaded() {
                MsgTools.pirntMsg("onInterstitialAdLoaded .." + InterstitialHelper.this.mPlacementId);
                WritableMap createMap = Arguments.createMap();
                createMap.putString("placementId", InterstitialHelper.this.mPlacementId);
                InterstitialHelper.this.sendEvent(Const.InterstitialCallback.LoadedCallbackKey, createMap);
            }

            public void onInterstitialAdLoadFail(AdError adError) {
                MsgTools.pirntMsg("onInterstitialAdLoadFail >> " + InterstitialHelper.this.mPlacementId + ", " + adError.printStackTrace());
                WritableMap createMap = Arguments.createMap();
                createMap.putString("placementId", InterstitialHelper.this.mPlacementId);
                createMap.putString(Const.CallbackKey.ErrorMsg, adError.getFullErrorInfo());
                InterstitialHelper.this.sendEvent(Const.InterstitialCallback.LoadFailCallbackKey, createMap);
            }

            public void onInterstitialAdClicked(ATAdInfo aTAdInfo) {
                MsgTools.pirntMsg("onInterstitialAdClicked .." + InterstitialHelper.this.mPlacementId);
                WritableMap createMap = Arguments.createMap();
                createMap.putString("placementId", InterstitialHelper.this.mPlacementId);
                createMap.putString(Const.CallbackKey.AdInfo, aTAdInfo.toString());
                InterstitialHelper.this.sendEvent(Const.InterstitialCallback.ClickCallbackKey, createMap);
            }

            public void onInterstitialAdShow(ATAdInfo aTAdInfo) {
                MsgTools.pirntMsg("onInterstitialAdShow .." + InterstitialHelper.this.mPlacementId);
                WritableMap createMap = Arguments.createMap();
                createMap.putString("placementId", InterstitialHelper.this.mPlacementId);
                createMap.putString(Const.CallbackKey.AdInfo, aTAdInfo.toString());
                InterstitialHelper.this.sendEvent(Const.InterstitialCallback.ShowCallbackKey, createMap);
            }

            public void onInterstitialAdClose(ATAdInfo aTAdInfo) {
                MsgTools.pirntMsg("onInterstitialAdClose .." + InterstitialHelper.this.mPlacementId);
                WritableMap createMap = Arguments.createMap();
                createMap.putString("placementId", InterstitialHelper.this.mPlacementId);
                createMap.putString(Const.CallbackKey.AdInfo, aTAdInfo.toString());
                InterstitialHelper.this.sendEvent(Const.InterstitialCallback.CloseCallbackKey, createMap);
            }

            public void onInterstitialAdVideoStart(ATAdInfo aTAdInfo) {
                MsgTools.pirntMsg("onInterstitialAdVideoStart .." + InterstitialHelper.this.mPlacementId);
                WritableMap createMap = Arguments.createMap();
                createMap.putString("placementId", InterstitialHelper.this.mPlacementId);
                createMap.putString(Const.CallbackKey.AdInfo, aTAdInfo.toString());
                InterstitialHelper.this.sendEvent(Const.InterstitialCallback.PlayStartCallbackKey, createMap);
            }

            public void onInterstitialAdVideoEnd(ATAdInfo aTAdInfo) {
                MsgTools.pirntMsg("onInterstitialAdVideoEnd .." + InterstitialHelper.this.mPlacementId);
                WritableMap createMap = Arguments.createMap();
                createMap.putString("placementId", InterstitialHelper.this.mPlacementId);
                createMap.putString(Const.CallbackKey.AdInfo, aTAdInfo.toString());
                InterstitialHelper.this.sendEvent(Const.InterstitialCallback.PlayEndCallbackKey, createMap);
            }

            public void onInterstitialAdVideoError(AdError adError) {
                MsgTools.pirntMsg("onInterstitialAdVideoError .." + InterstitialHelper.this.mPlacementId + ", " + adError.printStackTrace());
                WritableMap createMap = Arguments.createMap();
                createMap.putString("placementId", InterstitialHelper.this.mPlacementId);
                createMap.putString(Const.CallbackKey.ErrorMsg, adError.getFullErrorInfo());
                InterstitialHelper.this.sendEvent(Const.InterstitialCallback.PlayFailCallbackKey, createMap);
            }
        });
    }

    public void loadInterstitial(final String str, final String str2) {
        MsgTools.pirntMsg("loadInterstitial >>> " + str + ", settings >>> " + str2);
        runOnUiThread(new Runnable() {
            /* class com.anythink.reactnativejs.interstitial.InterstitialHelper.AnonymousClass2 */

            public void run() {
                if (InterstitialHelper.this.mInterstitialAd == null) {
                    InterstitialHelper.this.initInterstitial(str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        HashMap hashMap = new HashMap();
                        if (jSONObject.has(Const.Interstital.UseRewardedVideoAsInterstitial) && ((Boolean) jSONObject.get(Const.Interstital.UseRewardedVideoAsInterstitial)).booleanValue()) {
                            hashMap.put("is_use_rewarded_video_as_interstitial", true);
                        }
                        InterstitialHelper.fillMapFromJsonObject(hashMap, jSONObject);
                        InterstitialHelper.this.mInterstitialAd.setLocalExtra(hashMap);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                InterstitialHelper.this.mInterstitialAd.load();
            }
        });
    }

    public void showInterstitial(final String str) {
        MsgTools.pirntMsg("showInterstitial >>> " + this.mPlacementId + ", scenario >>> " + str);
        runOnUiThread(new Runnable() {
            /* class com.anythink.reactnativejs.interstitial.InterstitialHelper.AnonymousClass3 */

            public void run() {
                if (InterstitialHelper.this.mInterstitialAd != null) {
                    InterstitialHelper.this.isReady = false;
                    InterstitialHelper.this.mInterstitialAd.show(InterstitialHelper.this.getActivity(), str);
                    return;
                }
                MsgTools.pirntMsg("showInterstitial error  ..you must call loadRewardVideo first, placementId" + InterstitialHelper.this.mPlacementId);
                WritableMap createMap = Arguments.createMap();
                createMap.putString("placementId", InterstitialHelper.this.mPlacementId);
                createMap.putString(Const.CallbackKey.ErrorMsg, "you must call loadRewardVideo first");
                InterstitialHelper.this.sendEvent(Const.InterstitialCallback.LoadFailCallbackKey, createMap);
            }
        });
    }

    public boolean isAdReady() {
        MsgTools.pirntMsg("interstitial isAdReady >>> " + this.mPlacementId);
        try {
            if (this.mInterstitialAd != null) {
                boolean isAdReady = this.mInterstitialAd.isAdReady();
                MsgTools.pirntMsg("interstitial isAdReady >>> " + this.mPlacementId + ", " + isAdReady);
                return isAdReady;
            }
            MsgTools.pirntMsg("interstitial isAdReady error  ..you must call loadInterstitial first " + this.mPlacementId);
            MsgTools.pirntMsg("interstitial isAdReady >end>> " + this.mPlacementId);
            return this.isReady;
        } catch (Throwable th) {
            MsgTools.pirntMsg("interstitial isAdReady >Throwable>> " + th.getMessage());
            return this.isReady;
        }
    }

    public String checkAdStatus() {
        MsgTools.pirntMsg("interstitial checkAdStatus >>> " + this.mPlacementId);
        try {
            if (this.mInterstitialAd != null) {
                ATAdStatusInfo checkAdStatus = this.mInterstitialAd.checkAdStatus();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isLoading", checkAdStatus.isLoading());
                jSONObject.put("isReady", checkAdStatus.isReady());
                jSONObject.put("adInfo", checkAdStatus.getATTopAdInfo());
                String jSONObject2 = jSONObject.toString();
                MsgTools.pirntMsg("interstitial checkAdStatus >>> " + this.mPlacementId + ", " + jSONObject2);
                return jSONObject2;
            }
            MsgTools.pirntMsg("interstitial checkAdStatus error  ..you must call loadInterstitial first " + this.mPlacementId);
            MsgTools.pirntMsg("interstitial checkAdStatus >end>> " + this.mPlacementId);
            return "";
        } catch (Throwable th) {
            MsgTools.pirntMsg("interstitial checkAdStatus >Throwable>> " + th.getMessage());
            return "";
        }
    }
}
