package com.ironsource.environment;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.support.v4.media.session.PlaybackStateCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;

public class DeviceStatus {
    private static final String CACHED_UUID_KEY = "cachedUUID";
    private static final String DEVICE_OS = "android";
    private static final String GOOGLE_PLAY_SERVICES_CLASS_NAME = "com.google.android.gms.ads.identifier.AdvertisingIdClient";
    private static final String GOOGLE_PLAY_SERVICES_GET_AID_INFO_METHOD_NAME = "getAdvertisingIdInfo";
    private static final String GOOGLE_PLAY_SERVICES_GET_AID_METHOD_NAME = "getId";
    private static final String GOOGLE_PLAY_SERVICES_IS_LIMITED_AD_TRACKING_METHOD_NAME = "isLimitAdTrackingEnabled";
    private static final String MEDIATION_SHARED_PREFS = "Mediation_Shared_Preferences";
    public static final String UUID_ENABLED = "uuidEnabled";
    private static String uniqueId;

    public static String getDeviceOs() {
        return "android";
    }

    public static long getDeviceLocalTime() {
        return Calendar.getInstance(TimeZone.getDefault()).getTime().getTime();
    }

    public static int getDeviceTimeZoneOffsetInMinutes() {
        return -(TimeZone.getDefault().getOffset(getDeviceLocalTime()) / 60000);
    }

    public static String[] getAdvertisingIdInfo(Context context) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> cls = Class.forName(GOOGLE_PLAY_SERVICES_CLASS_NAME);
        Object invoke = cls.getMethod(GOOGLE_PLAY_SERVICES_GET_AID_INFO_METHOD_NAME, Context.class).invoke(cls, context);
        Method method = invoke.getClass().getMethod(GOOGLE_PLAY_SERVICES_GET_AID_METHOD_NAME, new Class[0]);
        Method method2 = invoke.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]);
        String obj = method.invoke(invoke, new Object[0]).toString();
        boolean booleanValue = ((Boolean) method2.invoke(invoke, new Object[0])).booleanValue();
        return new String[]{obj, "" + booleanValue};
    }

    public static String getDeviceLanguage(Context context) throws Exception {
        return context.getResources().getConfiguration().locale.getLanguage();
    }

    public static String getDeviceLocalCountry(Context context) throws Exception {
        return context.getResources().getConfiguration().locale.getCountry();
    }

    public static boolean getIsTablet(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return false;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        if (((float) displayMetrics.widthPixels) / displayMetrics.density >= 600.0f) {
            return true;
        }
        return false;
    }

    private static long getFreeStorageInBytes(File file) {
        long j;
        long j2;
        StatFs statFs = new StatFs(file.getPath());
        if (Build.VERSION.SDK_INT < 19) {
            j2 = (long) statFs.getAvailableBlocks();
            j = (long) statFs.getBlockSize();
        } else {
            j2 = statFs.getAvailableBlocksLong();
            j = statFs.getBlockSizeLong();
        }
        return (j2 * j) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
    }

    public static boolean isExternalMemoryAvailableWritable() {
        return "mounted".equals(Environment.getExternalStorageState()) && Environment.isExternalStorageRemovable();
    }

    public static long getTotalDeviceRAM(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        if (activityManager == null) {
            return -1;
        }
        activityManager.getMemoryInfo(memoryInfo);
        if (Build.VERSION.SDK_INT >= 16) {
            return memoryInfo.totalMem;
        }
        return -1;
    }

    public static boolean isCharging(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int i = -1;
        if (registerReceiver != null) {
            i = registerReceiver.getIntExtra("status", -1);
        }
        return i == 2 || i == 5;
    }

    public static int chargingType(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            return registerReceiver.getIntExtra("plugged", -1);
        }
        return -1;
    }

    public static boolean isAirplaneMode(Context context) {
        try {
            if (Build.VERSION.SDK_INT < 17 || Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) == 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isStayOnWhenPluggedIn(Context context) {
        try {
            if (Build.VERSION.SDK_INT < 17 || Settings.Global.getInt(context.getContentResolver(), "stay_on_while_plugged_in", 0) == 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String getMobileCarrier(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return telephonyManager != null ? telephonyManager.getNetworkOperatorName() : "";
    }

    public static String getAndroidOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static int getAndroidAPIVersion() {
        return Build.VERSION.SDK_INT;
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static String getDeviceOEM() {
        return Build.MANUFACTURER;
    }

    public static boolean isRootedDevice() {
        return findBinary("su");
    }

    private static boolean findBinary(String str) {
        try {
            String[] strArr = {"/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"};
            for (int i = 0; i < 8; i++) {
                String str2 = strArr[i];
                if (new File(str2 + str).exists()) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isRTL(Context context) {
        return Build.VERSION.SDK_INT >= 17 && context.getResources().getConfiguration().getLayoutDirection() == 1;
    }

    public static int getApplicationRotation(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
    }

    public static float getSystemVolumePercent(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        try {
            return ((float) audioManager.getStreamVolume(3)) / ((float) audioManager.getStreamMaxVolume(3));
        } catch (Exception e) {
            e.printStackTrace();
            return -1.0f;
        }
    }

    public static int getDisplayWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getDisplayHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static int getDeviceWidth() {
        return getDisplayWidth();
    }

    public static int getDeviceHeight() {
        return getDisplayHeight();
    }

    public static int getActivityRequestedOrientation(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).getRequestedOrientation();
        }
        return -1;
    }

    public static int getDeviceDefaultOrientation(Context context) {
        int applicationRotation = getApplicationRotation(context);
        int deviceOrientation = getDeviceOrientation(context);
        return (((applicationRotation == 0 || applicationRotation == 2) && deviceOrientation == 2) || ((applicationRotation == 1 || applicationRotation == 3) && deviceOrientation == 1)) ? 2 : 1;
    }

    public static int getDeviceOrientation(Context context) {
        return context.getResources().getConfiguration().orientation;
    }

    public static float getDeviceDensity() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static List<ApplicationInfo> getInstalledApplications(Context context) {
        return context.getPackageManager().getInstalledApplications(0);
    }

    public static boolean isDeviceOrientationLocked(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation", 0) != 1;
    }

    public static File getExternalCacheDir(Context context) {
        return context.getExternalCacheDir();
    }

    public static String getInternalCacheDirPath(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            return cacheDir.getPath();
        }
        return null;
    }

    public static long getAvailableInternalMemorySizeInMegaBytes() {
        return getFreeStorageInBytes(Environment.getDataDirectory());
    }

    public static long getAvailableMemorySizeInMegaBytes(String str) {
        return getFreeStorageInBytes(new File(str));
    }

    public static long getAvailableExternalMemorySizeInMegaBytes() {
        if (isExternalMemoryAvailableWritable()) {
            return getFreeStorageInBytes(Environment.getExternalStorageDirectory());
        }
        return 0;
    }

    public static boolean isImmersiveSupported(Activity activity) {
        int systemUiVisibility = activity.getWindow().getDecorView().getSystemUiVisibility();
        return (systemUiVisibility | 4096) == systemUiVisibility || (systemUiVisibility | 2048) == systemUiVisibility;
    }

    public static int getBatteryLevel(Context context) {
        try {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int i = 0;
            int intExtra = registerReceiver != null ? registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1) : 0;
            if (registerReceiver != null) {
                i = registerReceiver.getIntExtra("scale", -1);
            }
            if (intExtra == -1 || i == -1) {
                return -1;
            }
            return (int) ((((float) intExtra) / ((float) i)) * 100.0f);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static synchronized String getOrGenerateOnceUniqueIdentifier(Context context) {
        synchronized (DeviceStatus.class) {
            if (!TextUtils.isEmpty(uniqueId)) {
                return uniqueId;
            }
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences(MEDIATION_SHARED_PREFS, 0);
                if (sharedPreferences.getBoolean(UUID_ENABLED, true)) {
                    String string = sharedPreferences.getString(CACHED_UUID_KEY, "");
                    if (TextUtils.isEmpty(string)) {
                        uniqueId = UUID.randomUUID().toString();
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString(CACHED_UUID_KEY, uniqueId);
                        edit.apply();
                    } else {
                        uniqueId = string;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return uniqueId;
        }
    }

    public static int getScreenBrightness(Context context) {
        if (context != null) {
            return Settings.System.getInt(context.getContentResolver(), "screen_brightness", -1);
        }
        return -1;
    }
}
