package com.ironsource.sdk.service;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.iab.omid.library.ironsrc.Omid;
import com.ironsource.environment.DeviceStatus;
import com.ironsource.environment.TokenConstants;
import com.ironsource.sdk.analytics.omid.OMIDManager;
import com.ironsource.sdk.utils.IronSourceQaProperties;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class TokenService {
    private static TokenService mInstance;
    private JSONObject tokenData = new JSONObject();

    public static synchronized TokenService getInstance() {
        TokenService tokenService;
        synchronized (TokenService.class) {
            if (mInstance == null) {
                mInstance = new TokenService();
            }
            tokenService = mInstance;
        }
        return tokenService;
    }

    private TokenService() {
    }

    public void collectOmidParameters() {
        HashMap hashMap = new HashMap();
        hashMap.put("omidVersion", Omid.getVersion());
        hashMap.put("omidPartnerVersion", OMIDManager.OMID_PARTNER_VERSION);
        mInstance.collectDataFromExternalParams(hashMap);
    }

    public void collectQaParameters() {
        if (IronSourceQaProperties.isInitialized()) {
            mInstance.collectDataFromExternalParams(IronSourceQaProperties.getInstance().getParameters());
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void put(String str, Object obj) {
        try {
            this.tokenData.put(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return;
    }

    public void collectApplicationUserId(String str) {
        if (str != null) {
            put("applicationUserId", SDKUtils.encodeString(str));
        }
    }

    public void collectApplicationKey(String str) {
        if (str != null) {
            put("applicationKey", SDKUtils.encodeString(str));
        }
    }

    public void collectDataFromActivity(Activity activity) {
        if (activity != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                put(SDKUtils.encodeString("immersiveMode"), Boolean.valueOf(DeviceStatus.isImmersiveSupported(activity)));
            }
            put("appOrientation", SDKUtils.translateRequestedOrientation(DeviceStatus.getActivityRequestedOrientation(activity)));
        }
    }

    public void collectAdvertisingID(final Context context) {
        if (context != null) {
            try {
                new Thread(new Runnable() {
                    /* class com.ironsource.sdk.service.TokenService.AnonymousClass1 */

                    public void run() {
                        try {
                            TokenService.this.updateData(DeviceData.fetchAdvertiserIdData(context));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void collectDataFromDevice(Context context) {
        if (context != null) {
            updateData(DeviceData.fetchPermanentData(context));
            updateData(DeviceData.fetchMutableData(context));
        }
    }

    public void collectDataFromExternalParams(Map<String, String> map) {
        if (map == null) {
            Log.d("TokenService", "collectDataFromExternalParams params=null");
            return;
        }
        for (String str : map.keySet()) {
            put(str, SDKUtils.encodeString(map.get(str)));
        }
    }

    public void collectDataFromControllerConfig(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                put(TokenConstants.CHINA_CDN, new JSONObject(str).opt(TokenConstants.CHINA_CDN));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateData(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            put(next, jSONObject.opt(next));
        }
    }

    public void updateMetaData(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            put(TokenConstants.METADATA_KEY_PREFIX + next, jSONObject.opt(next));
        }
    }

    public String getToken(Context context) {
        try {
            return Gibberish.encode(getRawToken(context).toString());
        } catch (Exception unused) {
            return Gibberish.encode(new JSONObject().toString());
        }
    }

    public JSONObject getRawToken(Context context) {
        fetchIndependentData();
        collectDataFromDevice(context);
        try {
            return new JSONObject(this.tokenData.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONObject();
        }
    }

    public void fetchDependentData(Context context, String str, String str2) {
        collectAdvertisingID(context);
        if (context instanceof Activity) {
            collectDataFromActivity((Activity) context);
        }
        collectDataFromDevice(context);
        collectApplicationUserId(str2);
        collectApplicationKey(str);
    }

    public void fetchIndependentData() {
        collectDataFromControllerConfig(SDKUtils.getControllerConfig());
        collectDataFromExternalParams(SDKUtils.getInitSDKParams());
        collectQaParameters();
        collectOmidParameters();
    }
}
