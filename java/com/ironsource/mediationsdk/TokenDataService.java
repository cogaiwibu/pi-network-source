package com.ironsource.mediationsdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.ironsource.environment.ApplicationContext;
import com.ironsource.environment.DeviceStatus;
import com.ironsource.environment.StringUtils;
import com.ironsource.environment.TokenConstants;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.ContextProvider;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.SessionDepthManager;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class TokenDataService {
    private static TokenDataService mInstance;
    private JSONObject tokenData = new JSONObject();

    public static synchronized TokenDataService getInstance() {
        TokenDataService tokenDataService;
        synchronized (TokenDataService.class) {
            if (mInstance == null) {
                mInstance = new TokenDataService();
            }
            tokenDataService = mInstance;
        }
        return tokenDataService;
    }

    private TokenDataService() {
    }

    /* access modifiers changed from: package-private */
    public JSONObject getTokenData() {
        collectDataFromDevice();
        return this.tokenData;
    }

    /* access modifiers changed from: package-private */
    public synchronized void add(String str, Object obj) {
        try {
            this.tokenData.put(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateTokenData(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            add(next, jSONObject.opt(next));
        }
    }

    private void collectDataFromDevice() {
        updateTokenData(fetchPermanentData());
        updateTokenData(fetchMutableData());
    }

    /* access modifiers changed from: package-private */
    public void collectAdvertisingData() {
        try {
            new Thread(new Runnable() {
                /* class com.ironsource.mediationsdk.TokenDataService.AnonymousClass1 */

                public void run() {
                    try {
                        TokenDataService.this.updateTokenData(TokenDataService.this.fetchAdvertisingId());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject fetchAdvertisingId() {
        /*
        // Method dump skipped, instructions count: 126
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.TokenDataService.fetchAdvertisingId():org.json.JSONObject");
    }

    /* access modifiers changed from: package-private */
    public JSONObject fetchMutableData() {
        JSONObject jSONObject = new JSONObject();
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        int displayWidth = DeviceStatus.getDisplayWidth();
        int displayHeight = DeviceStatus.getDisplayHeight();
        float deviceDensity = DeviceStatus.getDeviceDensity();
        if (applicationContext != null) {
            try {
                ConcurrentHashMap<String, List<String>> metaData = AdapterRepository.getInstance().getMetaData();
                metaData.putAll(IronsourceObjectPublisherDataHolder.getInstance().getMediationMetaData());
                JSONObject jSONObject2 = new JSONObject();
                for (Map.Entry<String, List<String>> entry : metaData.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                Boolean consent = IronSourceObject.getInstance().getConsent();
                if (consent != null) {
                    jSONObject.put("consent", consent.booleanValue());
                }
                jSONObject.put(TokenConstants.MINIMIZED_CONNECTION_TYPE, IronSourceUtils.getConnectionType(applicationContext));
                jSONObject.put(TokenConstants.DEVICE_VOLUME_MINIMIZED, (double) DeviceStatus.getSystemVolumePercent(applicationContext));
                jSONObject.put(TokenConstants.MINIMIZED_IS_ROOT_DEVICE, DeviceStatus.isRootedDevice());
                jSONObject.put(TokenConstants.MINIMIZED_BATTERY_LEVEL, DeviceStatus.getBatteryLevel(applicationContext));
                jSONObject.put(TokenConstants.MINIMIZED_DISK_FREE_SIZE, DeviceStatus.getAvailableInternalMemorySizeInMegaBytes());
                jSONObject.put(TokenConstants.MINIMIZED_META_DATA, jSONObject2);
                jSONObject.put(TokenConstants.MINIMIZED_CLIENT_TIMESTAMP, new Date().getTime());
                jSONObject.put(TokenConstants.MINIMIZED_DEVICE_WIDTH, displayWidth);
                jSONObject.put(TokenConstants.MINIMIZED_DEVICE_HEIGHT, displayHeight);
                jSONObject.put(TokenConstants.DEVICE_SCREEN_SCALE_MINIMIZED, String.valueOf(deviceDensity));
                jSONObject.put(TokenConstants.MINIMIZED_SESSION_DEPTH_IS, SessionDepthManager.getInstance().getSessionDepth(2));
                jSONObject.put(TokenConstants.MINIMIZED_SESSION_DEPTH_RV, SessionDepthManager.getInstance().getSessionDepth(1));
            } catch (JSONException e) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.error("got the following error " + e.getMessage());
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    public JSONObject fetchPermanentData() {
        JSONObject jSONObject = new JSONObject();
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        if (applicationContext != null) {
            try {
                String language = applicationContext.getResources().getConfiguration().locale.getLanguage();
                if (!TextUtils.isEmpty(language)) {
                    jSONObject.put(TokenConstants.MINIMIZED_DEVICE_LANGUAGE, StringUtils.toUpperCase(language));
                }
                String pluginType = ConfigFile.getConfigFile().getPluginType();
                if (!TextUtils.isEmpty(pluginType)) {
                    jSONObject.put(TokenConstants.MINIMIZED_SDK_PLUGIN_TYPE, pluginType);
                }
                String androidOsVersion = DeviceStatus.getAndroidOsVersion();
                if (androidOsVersion != null) {
                    jSONObject.put(TokenConstants.MINIMIZED_DEVICE_OS_VERSION_FULL, androidOsVersion);
                    jSONObject.put(TokenConstants.MINIMIZED_DEVICE_OS_VERSION, androidOsVersion.replaceAll("[^0-9/.]", ""));
                }
                jSONObject.put(TokenConstants.MINIMIZED_SESSION_ID, IronSourceUtils.getSessionId());
                jSONObject.put("appKey", IronSourceObject.getInstance().getIronSourceAppKey());
                jSONObject.put(TokenConstants.MINIMIZED_MOBILE_CARRIER, DeviceStatus.getMobileCarrier(applicationContext));
                jSONObject.put(TokenConstants.MINIMIZED_MEDIATION_SDK_VERSION, IronSourceUtils.getSDKVersion());
                jSONObject.put(TokenConstants.MINIMIZED_DEVICE_MODEL, Build.MODEL);
                jSONObject.put(TokenConstants.MINIMIZED_DEVICE_OS, "android");
                jSONObject.put(TokenConstants.MINIMIZED_DEVICE_MAKE, Build.MANUFACTURER);
                jSONObject.put(TokenConstants.MINIMIZED_DEVICE_API_LEVEL, String.valueOf(Build.VERSION.SDK_INT));
                jSONObject.put(TokenConstants.MINIMIZED_BUNDLE_ID, applicationContext.getPackageName());
                jSONObject.put(TokenConstants.MINIMIZED_APPLICATION_VERSION, ApplicationContext.getPublisherApplicationVersion(applicationContext, applicationContext.getPackageName()));
                jSONObject.put(TokenConstants.MINIMIZED_APPLICATION_USER_ID, IronSourceObject.getInstance().getIronSourceUserId());
            } catch (JSONException e) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.error("got the following error " + e.getMessage());
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
