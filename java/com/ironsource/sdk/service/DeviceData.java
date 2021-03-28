package com.ironsource.sdk.service;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.ironsource.environment.ApplicationContext;
import com.ironsource.environment.DeviceStatus;
import com.ironsource.network.ConnectivityService;
import com.ironsource.network.ConnectivityUtils;
import com.ironsource.sdk.constants.Constants;
import com.ironsource.sdk.utils.DeviceProperties;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import org.json.JSONObject;

public class DeviceData {
    private static final String TAG = DeviceData.class.getSimpleName();

    public static JSONObject fetchAdvertiserIdData(Context context) {
        SDKUtils.loadGoogleAdvertiserInfo(context);
        String advertiserId = SDKUtils.getAdvertiserId();
        Boolean valueOf = Boolean.valueOf(SDKUtils.isLimitAdTrackingEnabled());
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(advertiserId)) {
            try {
                Logger.i(TAG, "add AID and LAT");
                jSONObject.put("isLimitAdTrackingEnabled", valueOf);
                jSONObject.put("deviceIds" + Constants.RequestParameters.LEFT_BRACKETS + "AID" + Constants.RequestParameters.RIGHT_BRACKETS, SDKUtils.encodeString(advertiserId));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static JSONObject fetchMutableData(Context context) {
        JSONObject jSONObject = new JSONObject();
        updateWithDisplaySize(jSONObject);
        updateWithConnectionInfo(context, jSONObject);
        updateWithFreeDiskSize(context, jSONObject);
        updateWithBatteryLevel(context, jSONObject);
        updateWithDeviceVolume(context, jSONObject);
        updateWithSDCardAvailable(jSONObject);
        updateWithIsCharging(context, jSONObject);
        updateWithChargingType(context, jSONObject);
        updateWithAirplaneMode(context, jSONObject);
        updateWithStayOnWhenPluggedIn(context, jSONObject);
        return jSONObject;
    }

    private static void updateObjectWithKeyValue(JSONObject jSONObject, String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put(str, SDKUtils.encodeString(str2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean getControllerConfigFlagValue(String str) {
        return SDKUtils.getControllerConfigAsJSONObject().optBoolean(str);
    }

    private static void updateWithDisplaySize(JSONObject jSONObject) {
        try {
            updateObjectWithKeyValue(jSONObject, "displaySizeWidth", String.valueOf(DeviceStatus.getDisplayWidth()));
            updateObjectWithKeyValue(jSONObject, "displaySizeHeight", String.valueOf(DeviceStatus.getDisplayHeight()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updateWithConnectionInfo(Context context, JSONObject jSONObject) {
        try {
            String connectionType = ConnectivityUtils.getConnectionType(context);
            if (!TextUtils.isEmpty(connectionType) && !connectionType.equals("none")) {
                jSONObject.put(SDKUtils.encodeString("connectionType"), SDKUtils.encodeString(connectionType));
            }
            if (Build.VERSION.SDK_INT >= 23) {
                jSONObject.put(SDKUtils.encodeString("hasVPN"), ConnectivityUtils.hasVPN(context));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updateWithBatteryLevel(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put(SDKUtils.encodeString("batteryLevel"), DeviceStatus.getBatteryLevel(context));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updateWithDeviceVolume(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put(SDKUtils.encodeString("deviceVolume"), (double) DeviceProperties.getInstance(context).getDeviceVolume(context));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updateWithFreeDiskSize(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put(SDKUtils.encodeString("diskFreeSize"), SDKUtils.encodeString(String.valueOf(DeviceStatus.getAvailableMemorySizeInMegaBytes(IronSourceStorageUtils.getDiskCacheDirPath(context)))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updateWithSDCardAvailable(JSONObject jSONObject) {
        try {
            if (getControllerConfigFlagValue("sdCardAvailable")) {
                jSONObject.put(SDKUtils.encodeString("sdCardAvailable"), DeviceStatus.isExternalMemoryAvailableWritable());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updateWithIsCharging(Context context, JSONObject jSONObject) {
        try {
            if (getControllerConfigFlagValue("isCharging")) {
                jSONObject.put(SDKUtils.encodeString("isCharging"), DeviceStatus.isCharging(context));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updateWithChargingType(Context context, JSONObject jSONObject) {
        try {
            if (getControllerConfigFlagValue("chargingType")) {
                jSONObject.put(SDKUtils.encodeString("chargingType"), DeviceStatus.chargingType(context));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updateWithAirplaneMode(Context context, JSONObject jSONObject) {
        try {
            if (getControllerConfigFlagValue("airplaneMode")) {
                jSONObject.put(SDKUtils.encodeString("airplaneMode"), DeviceStatus.isAirplaneMode(context));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updateWithStayOnWhenPluggedIn(Context context, JSONObject jSONObject) {
        try {
            if (getControllerConfigFlagValue("stayOnWhenPluggedIn")) {
                jSONObject.put(SDKUtils.encodeString("stayOnWhenPluggedIn"), DeviceStatus.isStayOnWhenPluggedIn(context));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static JSONObject fetchPermanentData(Context context) {
        DeviceProperties instance = DeviceProperties.getInstance(context);
        JSONObject jSONObject = new JSONObject();
        try {
            String deviceOem = instance.getDeviceOem();
            if (deviceOem != null) {
                jSONObject.put(SDKUtils.encodeString("deviceOEM"), SDKUtils.encodeString(deviceOem));
            }
            String deviceModel = instance.getDeviceModel();
            if (deviceModel != null) {
                jSONObject.put(SDKUtils.encodeString("deviceModel"), SDKUtils.encodeString(deviceModel));
            }
            String deviceOsType = instance.getDeviceOsType();
            if (deviceOsType != null) {
                jSONObject.put(SDKUtils.encodeString("deviceOs"), SDKUtils.encodeString(deviceOsType));
            }
            String deviceOsVersion = instance.getDeviceOsVersion();
            if (deviceOsVersion != null) {
                jSONObject.put(SDKUtils.encodeString("deviceOSVersion"), deviceOsVersion.replaceAll("[^0-9/.]", ""));
            }
            String deviceOsVersion2 = instance.getDeviceOsVersion();
            if (deviceOsVersion2 != null) {
                jSONObject.put(SDKUtils.encodeString("deviceOSVersionFull"), SDKUtils.encodeString(deviceOsVersion2));
            }
            jSONObject.put(SDKUtils.encodeString("deviceApiLevel"), String.valueOf(instance.getDeviceApiLevel()));
            String supersonicSdkVersion = DeviceProperties.getSupersonicSdkVersion();
            if (supersonicSdkVersion != null) {
                jSONObject.put(SDKUtils.encodeString("SDKVersion"), SDKUtils.encodeString(supersonicSdkVersion));
            }
            if (instance.getDeviceCarrier() != null && instance.getDeviceCarrier().length() > 0) {
                jSONObject.put(SDKUtils.encodeString("mobileCarrier"), SDKUtils.encodeString(instance.getDeviceCarrier()));
            }
            String language = context.getResources().getConfiguration().locale.getLanguage();
            if (!TextUtils.isEmpty(language)) {
                jSONObject.put(SDKUtils.encodeString("deviceLanguage"), SDKUtils.encodeString(language.toUpperCase()));
            }
            if (getControllerConfigFlagValue("totalDeviceRAM")) {
                jSONObject.put(SDKUtils.encodeString("totalDeviceRAM"), SDKUtils.encodeString(String.valueOf(DeviceStatus.getTotalDeviceRAM(context))));
            }
            String packageName = ApplicationContext.getPackageName(context);
            if (!TextUtils.isEmpty(packageName)) {
                jSONObject.put(SDKUtils.encodeString("bundleId"), SDKUtils.encodeString(packageName));
            }
            String valueOf = String.valueOf(DeviceStatus.getDeviceDensity());
            if (!TextUtils.isEmpty(valueOf)) {
                jSONObject.put(SDKUtils.encodeString("deviceScreenScale"), SDKUtils.encodeString(valueOf));
            }
            String valueOf2 = String.valueOf(DeviceStatus.isRootedDevice());
            if (!TextUtils.isEmpty(valueOf2)) {
                jSONObject.put(SDKUtils.encodeString("unLocked"), SDKUtils.encodeString(valueOf2));
            }
            jSONObject.put(SDKUtils.encodeString(Constants.RequestParameters.GOOGLE_PLAY_INSTALLED), PackagesInstallationService.isGooglePlayInstalled(context));
            jSONObject.put(SDKUtils.encodeString("mcc"), ConnectivityService.getNetworkMCC(context));
            jSONObject.put(SDKUtils.encodeString("mnc"), ConnectivityService.getNetworkMNC(context));
            jSONObject.put(SDKUtils.encodeString("phoneType"), ConnectivityService.getPhoneType(context));
            jSONObject.put(SDKUtils.encodeString("simOperator"), SDKUtils.encodeString(ConnectivityService.getSimOperator(context)));
            jSONObject.put(SDKUtils.encodeString("lastUpdateTime"), ApplicationContext.getLastUpdateTime(context));
            jSONObject.put(SDKUtils.encodeString("firstInstallTime"), ApplicationContext.getFirstInstallTime(context));
            jSONObject.put(SDKUtils.encodeString("appVersion"), SDKUtils.encodeString(ApplicationContext.getApplicationVersionName(context)));
            String installerPackageName = ApplicationContext.getInstallerPackageName(context);
            if (!TextUtils.isEmpty(installerPackageName)) {
                jSONObject.put(SDKUtils.encodeString("installerPackageName"), SDKUtils.encodeString(installerPackageName));
            }
            jSONObject.put("localTime", SDKUtils.encodeString(String.valueOf(DeviceStatus.getDeviceLocalTime())));
            jSONObject.put("timezoneOffset", SDKUtils.encodeString(String.valueOf(DeviceStatus.getDeviceTimeZoneOffsetInMinutes())));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
