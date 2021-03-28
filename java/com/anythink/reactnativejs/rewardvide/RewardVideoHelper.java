package com.anythink.reactnativejs.rewardvide;

import android.text.TextUtils;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.AdError;
import com.anythink.reactnativejs.ATRewardedVideoRNSDKModule;
import com.anythink.reactnativejs.AnythinkReactContextBaseJavaModule;
import com.anythink.reactnativejs.utils.BaseHelper;
import com.anythink.reactnativejs.utils.Const;
import com.anythink.reactnativejs.utils.MsgTools;
import com.anythink.rewardvideo.api.ATRewardVideoAd;
import com.anythink.rewardvideo.api.ATRewardVideoListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import org.json.JSONObject;

public class RewardVideoHelper extends BaseHelper {
    private static final String TAG = RewardVideoHelper.class.getSimpleName();
    boolean isReady = false;
    ATRewardedVideoRNSDKModule mATRewardedVideoRNSDKModule;
    String mPlacementId;
    ATRewardVideoAd mRewardVideoAd;

    public RewardVideoHelper(AnythinkReactContextBaseJavaModule anythinkReactContextBaseJavaModule) {
        super(anythinkReactContextBaseJavaModule);
        MsgTools.pirntMsg(TAG + " >>> " + this);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void initVideo(String str) {
        this.mPlacementId = str;
        MsgTools.pirntMsg("initVideo placementId >>> " + this.mPlacementId);
        ATRewardVideoAd aTRewardVideoAd = new ATRewardVideoAd(getActivity(), str);
        this.mRewardVideoAd = aTRewardVideoAd;
        aTRewardVideoAd.setAdListener(new ATRewardVideoListener() {
            /* class com.anythink.reactnativejs.rewardvide.RewardVideoHelper.AnonymousClass1 */

            public void onRewardedVideoAdLoaded() {
                MsgTools.pirntMsg("onRewardedVideoAdLoaded .." + RewardVideoHelper.this.mPlacementId);
                WritableMap createMap = Arguments.createMap();
                createMap.putString("placementId", RewardVideoHelper.this.mPlacementId);
                RewardVideoHelper.this.sendEvent(Const.RewardVideoCallback.LoadedCallbackKey, createMap);
            }

            public void onRewardedVideoAdFailed(AdError adError) {
                MsgTools.pirntMsg("onRewardedVideoAdFailed >> " + RewardVideoHelper.this.mPlacementId + ", " + adError.printStackTrace());
                WritableMap createMap = Arguments.createMap();
                createMap.putString("placementId", RewardVideoHelper.this.mPlacementId);
                createMap.putString(Const.CallbackKey.ErrorMsg, adError.getFullErrorInfo());
                RewardVideoHelper.this.sendEvent(Const.RewardVideoCallback.LoadFailCallbackKey, createMap);
            }

            public void onRewardedVideoAdPlayStart(ATAdInfo aTAdInfo) {
                MsgTools.pirntMsg("onRewardedVideoAdPlayStart .." + RewardVideoHelper.this.mPlacementId);
                WritableMap createMap = Arguments.createMap();
                createMap.putString("placementId", RewardVideoHelper.this.mPlacementId);
                createMap.putString(Const.CallbackKey.AdInfo, aTAdInfo.toString());
                RewardVideoHelper.this.sendEvent(Const.RewardVideoCallback.PlayStartCallbackKey, createMap);
            }

            public void onRewardedVideoAdPlayEnd(ATAdInfo aTAdInfo) {
                MsgTools.pirntMsg("onRewardedVideoAdPlayEnd .." + RewardVideoHelper.this.mPlacementId);
                WritableMap createMap = Arguments.createMap();
                createMap.putString("placementId", RewardVideoHelper.this.mPlacementId);
                createMap.putString(Const.CallbackKey.AdInfo, aTAdInfo.toString());
                RewardVideoHelper.this.sendEvent(Const.RewardVideoCallback.PlayEndCallbackKey, createMap);
            }

            public void onRewardedVideoAdPlayFailed(AdError adError, ATAdInfo aTAdInfo) {
                MsgTools.pirntMsg("onRewardedVideoAdPlayFailed .." + RewardVideoHelper.this.mPlacementId + ", " + adError.printStackTrace());
                WritableMap createMap = Arguments.createMap();
                createMap.putString("placementId", RewardVideoHelper.this.mPlacementId);
                createMap.putString(Const.CallbackKey.ErrorMsg, adError.getFullErrorInfo());
                createMap.putString(Const.CallbackKey.AdInfo, aTAdInfo.toString());
                RewardVideoHelper.this.sendEvent(Const.RewardVideoCallback.PlayFailCallbackKey, createMap);
            }

            public void onRewardedVideoAdClosed(ATAdInfo aTAdInfo) {
                MsgTools.pirntMsg("onRewardedVideoAdClosed .." + RewardVideoHelper.this.mPlacementId);
                WritableMap createMap = Arguments.createMap();
                createMap.putString("placementId", RewardVideoHelper.this.mPlacementId);
                createMap.putString(Const.CallbackKey.AdInfo, aTAdInfo.toString());
                RewardVideoHelper.this.sendEvent(Const.RewardVideoCallback.CloseCallbackKey, createMap);
            }

            public void onRewardedVideoAdPlayClicked(ATAdInfo aTAdInfo) {
                MsgTools.pirntMsg("onRewardedVideoAdPlayClicked .." + RewardVideoHelper.this.mPlacementId);
                WritableMap createMap = Arguments.createMap();
                createMap.putString("placementId", RewardVideoHelper.this.mPlacementId);
                createMap.putString(Const.CallbackKey.AdInfo, aTAdInfo.toString());
                RewardVideoHelper.this.sendEvent(Const.RewardVideoCallback.ClickCallbackKey, createMap);
            }

            public void onReward(ATAdInfo aTAdInfo) {
                MsgTools.pirntMsg("onReward .." + RewardVideoHelper.this.mPlacementId);
                WritableMap createMap = Arguments.createMap();
                createMap.putString("placementId", RewardVideoHelper.this.mPlacementId);
                createMap.putString(Const.CallbackKey.AdInfo, aTAdInfo.toString());
                RewardVideoHelper.this.sendEvent(Const.RewardVideoCallback.RewardCallbackKey, createMap);
            }
        });
    }

    public void loadRewardedVideo(final String str, final String str2) {
        MsgTools.pirntMsg("loadRewardedVideo >>> " + str + ", settings >>> " + str2);
        runOnUiThread(new Runnable() {
            /* class com.anythink.reactnativejs.rewardvide.RewardVideoHelper.AnonymousClass2 */

            public void run() {
                String str;
                Exception e;
                String str2 = "";
                if (RewardVideoHelper.this.mRewardVideoAd == null) {
                    RewardVideoHelper.this.initVideo(str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        str = jSONObject.has(Const.USER_ID) ? jSONObject.optString(Const.USER_ID) : str2;
                        try {
                            if (jSONObject.has(Const.USER_DATA)) {
                                str2 = jSONObject.optString(Const.USER_DATA);
                            }
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            RewardVideoHelper.this.mRewardVideoAd.setUserData(str, str2);
                            RewardVideoHelper.this.mRewardVideoAd.load();
                        }
                    } catch (Exception e3) {
                        e = e3;
                        str = str2;
                        e.printStackTrace();
                        RewardVideoHelper.this.mRewardVideoAd.setUserData(str, str2);
                        RewardVideoHelper.this.mRewardVideoAd.load();
                    }
                    RewardVideoHelper.this.mRewardVideoAd.setUserData(str, str2);
                }
                RewardVideoHelper.this.mRewardVideoAd.load();
            }
        });
    }

    public void showVideo(final String str) {
        MsgTools.pirntMsg("showVideo >>> " + this.mPlacementId + ", scenario >>> " + str);
        runOnUiThread(new Runnable() {
            /* class com.anythink.reactnativejs.rewardvide.RewardVideoHelper.AnonymousClass3 */

            public void run() {
                if (RewardVideoHelper.this.mRewardVideoAd != null) {
                    RewardVideoHelper.this.isReady = false;
                    RewardVideoHelper.this.mRewardVideoAd.show(RewardVideoHelper.this.getActivity(), str);
                    return;
                }
                MsgTools.pirntMsg("showVideo error  ..you must call loadRewardVideo first " + RewardVideoHelper.this.mPlacementId);
                WritableMap createMap = Arguments.createMap();
                createMap.putString("placementId", RewardVideoHelper.this.mPlacementId);
                createMap.putString(Const.CallbackKey.ErrorMsg, "you must call loadRewardVideo first");
                RewardVideoHelper.this.sendEvent(Const.RewardVideoCallback.LoadFailCallbackKey, createMap);
            }
        });
    }

    public boolean isAdReady() {
        MsgTools.pirntMsg("video isAdReady >>> " + this.mPlacementId);
        try {
            if (this.mRewardVideoAd != null) {
                boolean isAdReady = this.mRewardVideoAd.isAdReady();
                MsgTools.pirntMsg("video isAdReady >>> " + this.mPlacementId + ", " + isAdReady);
                return isAdReady;
            }
            MsgTools.pirntMsg("video isAdReady error  ..you must call loadRewardedVideo first " + this.mPlacementId);
            MsgTools.pirntMsg("video isAdReady >end>> " + this.mPlacementId);
            return this.isReady;
        } catch (Throwable th) {
            MsgTools.pirntMsg("video isAdReady >Throwable>> " + th.getMessage());
            return this.isReady;
        }
    }

    public String checkAdStatus() {
        MsgTools.pirntMsg("video checkAdStatus >>> " + this.mPlacementId);
        try {
            if (this.mRewardVideoAd != null) {
                ATAdStatusInfo checkAdStatus = this.mRewardVideoAd.checkAdStatus();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isLoading", checkAdStatus.isLoading());
                jSONObject.put("isReady", checkAdStatus.isReady());
                jSONObject.put("adInfo", checkAdStatus.getATTopAdInfo());
                String jSONObject2 = jSONObject.toString();
                MsgTools.pirntMsg("video checkAdStatus >>> " + this.mPlacementId + ", " + jSONObject2);
                return jSONObject2;
            }
            MsgTools.pirntMsg("video checkAdStatus error  ..you must call loadRewardedVideo first " + this.mPlacementId);
            MsgTools.pirntMsg("video checkAdStatus >end>> " + this.mPlacementId);
            return "";
        } catch (Throwable th) {
            MsgTools.pirntMsg("video checkAdStatus >Throwable>> " + th.getMessage());
            return "";
        }
    }
}
