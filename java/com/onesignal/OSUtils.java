package com.onesignal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import androidx.core.app.NotificationManagerCompat;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.common.util.UriUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.location.LocationListener;
import com.google.firebase.messaging.FirebaseMessaging;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.location.LocationCallback;
import com.onesignal.OneSignal;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import kotlin.UByte;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class OSUtils {
    private static final int HMS_AVAILABLE_SUCCESSFUL = 0;
    private static final String HMS_CORE_SERVICES_PACKAGE = "com.huawei.hwid";
    public static int MAX_NETWORK_REQUEST_ATTEMPT_COUNT = 3;
    static final int[] NO_RETRY_NETWROK_REQUEST_STATUS_CODES = {401, 402, 403, 404, 410};
    public static final int UNINITIALIZABLE_STATUS = -999;

    OSUtils() {
    }

    public enum SchemaType {
        DATA("data"),
        HTTPS(UriUtil.HTTPS_SCHEME),
        HTTP(UriUtil.HTTP_SCHEME);
        
        private final String text;

        private SchemaType(String str) {
            this.text = str;
        }

        public static SchemaType fromString(String str) {
            SchemaType[] values = values();
            for (SchemaType schemaType : values) {
                if (schemaType.text.equalsIgnoreCase(str)) {
                    return schemaType;
                }
            }
            return null;
        }
    }

    public static boolean shouldRetryNetworkRequest(int i) {
        for (int i2 : NO_RETRY_NETWROK_REQUEST_STATUS_CODES) {
            if (i == i2) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public int initializationChecker(Context context, String str) {
        Integer checkForGooglePushLibrary;
        int deviceType = getDeviceType();
        try {
            UUID.fromString(str);
            if ("b2f7f966-d8cc-11e4-bed1-df8f05be55ba".equals(str) || "5eb5a37e-b458-11e3-ac11-000c2940e62c".equals(str)) {
                OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "OneSignal Example AppID detected, please update to your app's id found on OneSignal.com");
            }
            int i = 1;
            if (deviceType == 1 && (checkForGooglePushLibrary = checkForGooglePushLibrary()) != null) {
                i = checkForGooglePushLibrary.intValue();
            }
            Integer checkAndroidSupportLibrary = checkAndroidSupportLibrary(context);
            if (checkAndroidSupportLibrary != null) {
                return checkAndroidSupportLibrary.intValue();
            }
            return i;
        } catch (Throwable th) {
            OneSignal.Log(OneSignal.LOG_LEVEL.FATAL, "OneSignal AppId format is invalid.\nExample: 'b2f7f966-d8cc-11e4-bed1-df8f05be55ba'\n", th);
            return UNINITIALIZABLE_STATUS;
        }
    }

    static boolean hasFCMLibrary() {
        try {
            FirebaseMessaging.class.getName();
            return true;
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }

    private static boolean hasGCMLibrary() {
        try {
            GoogleCloudMessaging.class.getName();
            return true;
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }

    static boolean hasGMSLocationLibrary() {
        try {
            LocationListener.class.getName();
            return true;
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }

    private static boolean hasHMSAvailabilityLibrary() {
        try {
            HuaweiApiAvailability.class.getName();
            return true;
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }

    private static boolean hasHMSPushKitLibrary() {
        try {
            HmsInstanceId.class.getName();
            return true;
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }

    private static boolean hasHMSAGConnectLibrary() {
        try {
            AGConnectServicesConfig.class.getName();
            return true;
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }

    static boolean hasHMSLocationLibrary() {
        try {
            LocationCallback.class.getName();
            return true;
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }

    static boolean hasAllHMSLibrariesForPushKit() {
        return hasHMSAGConnectLibrary() && hasHMSPushKitLibrary();
    }

    /* access modifiers changed from: package-private */
    public Integer checkForGooglePushLibrary() {
        boolean hasFCMLibrary = hasFCMLibrary();
        boolean hasGCMLibrary = hasGCMLibrary();
        if (hasFCMLibrary || hasGCMLibrary) {
            if (hasGCMLibrary && !hasFCMLibrary) {
                OneSignal.Log(OneSignal.LOG_LEVEL.WARN, "GCM Library detected, please upgrade to Firebase FCM library as GCM is deprecated!");
            }
            if (!hasGCMLibrary || !hasFCMLibrary) {
                return null;
            }
            OneSignal.Log(OneSignal.LOG_LEVEL.WARN, "Both GCM & FCM Libraries detected! Please remove the deprecated GCM library.");
            return null;
        }
        OneSignal.Log(OneSignal.LOG_LEVEL.FATAL, "The Firebase FCM library is missing! Please make sure to include it in your project.");
        return -4;
    }

    private static boolean hasWakefulBroadcastReceiver() {
        return true;
    }

    private static boolean hasNotificationManagerCompat() {
        return true;
    }

    private static boolean hasJobIntentService() {
        return true;
    }

    private Integer checkAndroidSupportLibrary(Context context) {
        boolean hasWakefulBroadcastReceiver = hasWakefulBroadcastReceiver();
        boolean hasNotificationManagerCompat = hasNotificationManagerCompat();
        if (!hasWakefulBroadcastReceiver && !hasNotificationManagerCompat) {
            OneSignal.Log(OneSignal.LOG_LEVEL.FATAL, "Could not find the Android Support Library. Please make sure it has been correctly added to your project.");
            return -3;
        } else if (!hasWakefulBroadcastReceiver || !hasNotificationManagerCompat) {
            OneSignal.Log(OneSignal.LOG_LEVEL.FATAL, "The included Android Support Library is to old or incomplete. Please update to the 26.0.0 revision or newer.");
            return -5;
        } else if (Build.VERSION.SDK_INT < 26 || getTargetSdkVersion(context) < 26 || hasJobIntentService()) {
            return null;
        } else {
            OneSignal.Log(OneSignal.LOG_LEVEL.FATAL, "The included Android Support Library is to old or incomplete. Please update to the 26.0.0 revision or newer.");
            return -5;
        }
    }

    private static boolean packageInstalledAndEnabled(String str) {
        try {
            return OneSignal.appContext.getPackageManager().getPackageInfo(str, 128).applicationInfo.enabled;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    static boolean isGMSInstalledAndEnabled() {
        return packageInstalledAndEnabled("com.google.android.gms");
    }

    private static boolean isHMSCoreInstalledAndEnabled() {
        return HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(OneSignal.appContext) == 0;
    }

    private static boolean isHMSCoreInstalledAndEnabledFallback() {
        return packageInstalledAndEnabled(HMS_CORE_SERVICES_PACKAGE);
    }

    private boolean supportsADM() {
        try {
            Class.forName("com.amazon.device.messaging.ADM");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private boolean supportsHMS() {
        if (!hasHMSAvailabilityLibrary() || !hasAllHMSLibrariesForPushKit()) {
            return false;
        }
        return isHMSCoreInstalledAndEnabled();
    }

    private boolean supportsGooglePush() {
        if (hasFCMLibrary() || hasGCMLibrary()) {
            return isGMSInstalledAndEnabled();
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public int getDeviceType() {
        if (supportsADM()) {
            return 2;
        }
        if (supportsGooglePush()) {
            return 1;
        }
        if (supportsHMS()) {
            return 13;
        }
        if (!isGMSInstalledAndEnabled() && isHMSCoreInstalledAndEnabledFallback()) {
            return 13;
        }
        return 1;
    }

    static boolean isAndroidDeviceType() {
        return new OSUtils().getDeviceType() == 1;
    }

    static boolean isFireOSDeviceType() {
        return new OSUtils().getDeviceType() == 2;
    }

    static boolean isHuaweiDeviceType() {
        return new OSUtils().getDeviceType() == 13;
    }

    /* access modifiers changed from: package-private */
    public Integer getNetType() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) OneSignal.appContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return null;
        }
        int type = activeNetworkInfo.getType();
        if (type == 1 || type == 9) {
            return 0;
        }
        return 1;
    }

    /* access modifiers changed from: package-private */
    public String getCarrierName() {
        try {
            String networkOperatorName = ((TelephonyManager) OneSignal.appContext.getSystemService("phone")).getNetworkOperatorName();
            if ("".equals(networkOperatorName)) {
                return null;
            }
            return networkOperatorName;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    static String getManifestMeta(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString(str);
        } catch (Throwable th) {
            OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "", th);
            return null;
        }
    }

    static String getResourceString(Context context, String str, String str2) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(str, "string", context.getPackageName());
        return identifier != 0 ? resources.getString(identifier) : str2;
    }

    static String getCorrectedLanguage() {
        String language = Locale.getDefault().getLanguage();
        if (language.equals("iw")) {
            return "he";
        }
        if (language.equals("in")) {
            return "id";
        }
        if (language.equals("ji")) {
            return "yi";
        }
        if (!language.equals("zh")) {
            return language;
        }
        return language + "-" + Locale.getDefault().getCountry();
    }

    static boolean isValidEmail(String str) {
        if (str == null) {
            return false;
        }
        return Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$").matcher(str).matches();
    }

    static boolean areNotificationsEnabled(Context context) {
        try {
            return NotificationManagerCompat.from(OneSignal.appContext).areNotificationsEnabled();
        } catch (Throwable unused) {
            return true;
        }
    }

    static boolean isRunningOnMainThread() {
        return Thread.currentThread().equals(Looper.getMainLooper().getThread());
    }

    static void runOnMainUIThread(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    static void runOnMainThreadDelayed(Runnable runnable, int i) {
        new Handler(Looper.getMainLooper()).postDelayed(runnable, (long) i);
    }

    static int getTargetSdkVersion(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).targetSdkVersion;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 15;
        }
    }

    static boolean isValidResourceName(String str) {
        return str != null && !str.matches("^[0-9]");
    }

    static Uri getSoundUri(Context context, String str) {
        int identifier;
        Resources resources = context.getResources();
        String packageName = context.getPackageName();
        if (!isValidResourceName(str) || (identifier = resources.getIdentifier(str, "raw", packageName)) == 0) {
            int identifier2 = resources.getIdentifier("onesignal_default_sound", "raw", packageName);
            if (identifier2 == 0) {
                return null;
            }
            return Uri.parse("android.resource://" + packageName + "/" + identifier2);
        }
        return Uri.parse("android.resource://" + packageName + "/" + identifier);
    }

    static long[] parseVibrationPattern(JSONObject jSONObject) {
        JSONArray jSONArray;
        try {
            Object opt = jSONObject.opt("vib_pt");
            if (opt instanceof String) {
                jSONArray = new JSONArray((String) opt);
            } else {
                jSONArray = (JSONArray) opt;
            }
            long[] jArr = new long[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                jArr[i] = jSONArray.optLong(i);
            }
            return jArr;
        } catch (JSONException unused) {
            return null;
        }
    }

    static String hexDigest(String str, String str2) throws Throwable {
        MessageDigest instance = MessageDigest.getInstance(str2);
        instance.update(str.getBytes("UTF-8"));
        byte[] digest = instance.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            String hexString = Integer.toHexString(b & UByte.MAX_VALUE);
            while (hexString.length() < 2) {
                hexString = AppEventsConstants.EVENT_PARAM_VALUE_NO + hexString;
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    static void sleep(int i) {
        try {
            Thread.sleep((long) i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void openURLInBrowser(String str) {
        openURLInBrowser(Uri.parse(str.trim()));
    }

    private static void openURLInBrowser(Uri uri) {
        Intent intent;
        SchemaType fromString = uri.getScheme() != null ? SchemaType.fromString(uri.getScheme()) : null;
        if (fromString == null) {
            fromString = SchemaType.HTTP;
            if (!uri.toString().contains("://")) {
                uri = Uri.parse("http://" + uri.toString());
            }
        }
        if (AnonymousClass1.$SwitchMap$com$onesignal$OSUtils$SchemaType[fromString.ordinal()] != 1) {
            intent = new Intent("android.intent.action.VIEW", uri);
        } else {
            intent = Intent.makeMainSelectorActivity("android.intent.action.MAIN", "android.intent.category.APP_BROWSER");
            intent.setData(uri);
        }
        intent.addFlags(1476919296);
        OneSignal.appContext.startActivity(intent);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.onesignal.OSUtils$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$onesignal$OSUtils$SchemaType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.onesignal.OSUtils$SchemaType[] r0 = com.onesignal.OSUtils.SchemaType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.onesignal.OSUtils.AnonymousClass1.$SwitchMap$com$onesignal$OSUtils$SchemaType = r0
                com.onesignal.OSUtils$SchemaType r1 = com.onesignal.OSUtils.SchemaType.DATA     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = com.onesignal.OSUtils.AnonymousClass1.$SwitchMap$com$onesignal$OSUtils$SchemaType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.onesignal.OSUtils$SchemaType r1 = com.onesignal.OSUtils.SchemaType.HTTPS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = com.onesignal.OSUtils.AnonymousClass1.$SwitchMap$com$onesignal$OSUtils$SchemaType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.onesignal.OSUtils$SchemaType r1 = com.onesignal.OSUtils.SchemaType.HTTP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.OSUtils.AnonymousClass1.<clinit>():void");
        }
    }

    static <T> Set<T> newConcurrentSet() {
        return Collections.newSetFromMap(new ConcurrentHashMap());
    }

    static Set<String> newStringSetFromJSONArray(JSONArray jSONArray) throws JSONException {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < jSONArray.length(); i++) {
            hashSet.add(jSONArray.getString(i));
        }
        return hashSet;
    }

    static boolean hasConfigChangeFlag(Activity activity, int i) {
        try {
            return (activity.getPackageManager().getActivityInfo(activity.getComponentName(), 0).configChanges & i) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    static Collection<String> extractStringsFromCollection(Collection<Object> collection) {
        ArrayList arrayList = new ArrayList();
        if (collection == null) {
            return arrayList;
        }
        for (Object obj : collection) {
            if (obj instanceof String) {
                arrayList.add((String) obj);
            }
        }
        return arrayList;
    }

    static Bundle jsonStringToBundle(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle = new Bundle();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle.putString(next, jSONObject.getString(next));
            }
            return bundle;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    static boolean shouldLogMissingAppIdError(String str) {
        if (str != null) {
            return false;
        }
        OneSignal.Log(OneSignal.LOG_LEVEL.INFO, "OneSignal was not initialized, ensure to always initialize OneSignal from the onCreate of your Application class.");
        return true;
    }
}
