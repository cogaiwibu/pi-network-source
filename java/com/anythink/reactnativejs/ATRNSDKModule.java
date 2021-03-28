package com.anythink.reactnativejs;

import android.text.TextUtils;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.NetTrafficeCallback;
import com.anythink.reactnativejs.utils.CommonUtil;
import com.anythink.reactnativejs.utils.MsgTools;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import java.util.ArrayList;

public class ATRNSDKModule extends AnythinkReactContextBaseJavaModule {
    public static final String TAG = "ATRNSDK";

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return TAG;
    }

    public ATRNSDKModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void init(String str, String str2) {
        MsgTools.pirntMsg("initSDK:" + str + ":" + str2);
        ATSDK.init(this.mApplicationContext, str, str2);
    }

    @ReactMethod
    public void getSDKVersionName(Promise promise) {
        String sDKVersionName = ATSDK.getSDKVersionName();
        MsgTools.pirntMsg("getSDKVersionName: " + sDKVersionName);
        promise.resolve(sDKVersionName);
    }

    @ReactMethod
    public void isChinaSDK(Promise promise) {
        boolean isChinaSDK = ATSDK.isChinaSDK();
        MsgTools.pirntMsg("isChinaSDK: " + isChinaSDK);
        promise.resolve(Boolean.valueOf(isChinaSDK));
    }

    @ReactMethod
    public void setExcludeMyOfferPkgList(ReadableArray readableArray) {
        if (readableArray != null) {
            ArrayList<Object> arrayList = readableArray.toArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                Object obj = arrayList.get(i);
                if (obj instanceof String) {
                    String str = (String) obj;
                    arrayList2.add(str);
                    MsgTools.pirntMsg("exclude MyOffer: " + str);
                }
            }
            ATSDK.setExcludeMyOfferPkgList(arrayList2);
        }
    }

    @ReactMethod
    public static void initCustomMap(String str) {
        MsgTools.pirntMsg("initCustomMap:" + str);
        if (!TextUtils.isEmpty(str)) {
            ATSDK.initCustomMap(CommonUtil.jsonStringToMap(str));
        }
    }

    @ReactMethod
    public static void setPlacementCustomMap(String str, String str2) {
        MsgTools.pirntMsg("setPlacementCustomMap:" + str + ":" + str2);
        if (!TextUtils.isEmpty(str2)) {
            ATSDK.initPlacementCustomMap(str, CommonUtil.jsonStringToMap(str2));
        }
    }

    @ReactMethod
    public void setGDPRLevel(int i) {
        MsgTools.pirntMsg("setGDPRLevel:" + i);
        ATSDK.setGDPRUploadDataLevel(this.mApplicationContext, i);
    }

    @ReactMethod
    public void getGDPRLevel(Promise promise) {
        int gDPRDataLevel = ATSDK.getGDPRDataLevel(this.mApplicationContext);
        MsgTools.pirntMsg("getGDPRLevel:" + gDPRDataLevel);
        promise.resolve(Integer.valueOf(gDPRDataLevel));
    }

    @ReactMethod
    public void getUserLocation(final Promise promise) {
        MsgTools.pirntMsg("getUserLocation");
        ATSDK.checkIsEuTraffic(this.mApplicationContext, new NetTrafficeCallback() {
            /* class com.anythink.reactnativejs.ATRNSDKModule.AnonymousClass1 */

            public void onResultCallback(boolean z) {
                MsgTools.pirntMsg("getUserLocation - onResultCallback: " + z);
                promise.resolve(Integer.valueOf(z ? 1 : 2));
            }

            public void onErrorCallback(String str) {
                MsgTools.pirntMsg("onErrorCallback:" + str);
                promise.resolve(2);
            }
        });
    }

    @ReactMethod
    public void showGDPRAuth() {
        MsgTools.pirntMsg("showGDPRAuth:");
        if (getCurrentActivity() != null) {
            getCurrentActivity().runOnUiThread(new Runnable() {
                /* class com.anythink.reactnativejs.ATRNSDKModule.AnonymousClass2 */

                public void run() {
                    ATSDK.showGdprAuth(ATRNSDKModule.this.mApplicationContext);
                }
            });
        }
    }

    @ReactMethod
    public void setLogDebug(boolean z) {
        MsgTools.setLogDebug(z);
        MsgTools.pirntMsg("setLogDebug:" + z);
        ATSDK.setNetworkLogDebug(z);
    }

    @ReactMethod
    public void deniedUploadDeviceInfo(ReadableArray readableArray) {
        ArrayList<Object> arrayList;
        int size;
        if (readableArray != null && (size = (arrayList = readableArray.toArrayList()).size()) > 0) {
            String[] strArr = new String[size];
            for (int i = 0; i < size; i++) {
                Object obj = arrayList.get(i);
                if (obj instanceof String) {
                    String str = (String) obj;
                    strArr[i] = str;
                    MsgTools.pirntMsg("deniedUploadDeviceInfo : " + str);
                }
            }
            ATSDK.deniedUploadDeviceInfo(strArr);
        }
    }
}
