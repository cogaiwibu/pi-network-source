package com.ironsource.mediationsdk.integration;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.ironsource.environment.StringUtils;
import com.ironsource.mediationsdk.IntegrationData;
import com.ironsource.mediationsdk.IronSourceObject;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IntegrationHelper {
    private static final String BANNER_COMPATIBILITY_VERSION = "4.3";
    private static final String SDK_COMPATIBILITY_VERSION = "4.1";
    private static final String TAG = "IntegrationHelper";

    public static void validateIntegration(Activity activity) {
        Log.i(TAG, "Verifying Integration:");
        validatePermissions(activity);
        String[] strArr = {"AdColony", "AdMob", "Amazon", "AppLovin", "Chartboost", "Facebook", "Fyber", "HyprMX", "InMobi", IronSourceConstants.SUPERSONIC_CONFIG_NAME, "Maio", "MyTarget", "Pangle", "Smaato", "Tapjoy", "UnityAds", "Vungle"};
        for (int i = 0; i < 17; i++) {
            String str = strArr[i];
            if (isAdapterValid(activity, str)) {
                if (str.equalsIgnoreCase(IronSourceConstants.SUPERSONIC_CONFIG_NAME)) {
                    Log.i(TAG, ">>>> IronSource - VERIFIED");
                } else {
                    Log.i(TAG, ">>>> " + str + " - VERIFIED");
                }
            } else if (str.equalsIgnoreCase(IronSourceConstants.SUPERSONIC_CONFIG_NAME)) {
                Log.e(TAG, ">>>> IronSource - NOT VERIFIED");
            } else {
                Log.e(TAG, ">>>> " + str + " - NOT VERIFIED");
            }
        }
        validateGooglePlayServices(activity);
    }

    private static boolean isAdapterValid(Activity activity, String str) {
        try {
            if (str.equalsIgnoreCase(IronSourceConstants.SUPERSONIC_CONFIG_NAME)) {
                Log.i(TAG, "--------------- IronSource  --------------");
            } else {
                Log.i(TAG, "--------------- " + str + " --------------");
            }
            String str2 = "com.ironsource.adapters." + StringUtils.toLowerCase(str) + "." + str + "Adapter";
            IntegrationData integrationData = getIntegrationData(activity, str2);
            if (integrationData == null) {
                return false;
            }
            if (!str.equalsIgnoreCase(IronSourceConstants.SUPERSONIC_CONFIG_NAME) && !isAdapterVersionValid(integrationData)) {
                return false;
            }
            validateSDKVersion(str2);
            boolean isActivitiesValid = isActivitiesValid(activity, integrationData.activities);
            if (!isExternalLibsValid(integrationData.externalLibs)) {
                isActivitiesValid = false;
            }
            if (!isServicesValid(activity, integrationData.services)) {
                isActivitiesValid = false;
            }
            if (!areContentProvidersValid(activity, integrationData.providers)) {
                isActivitiesValid = false;
            }
            if (integrationData.validateWriteExternalStorage && Build.VERSION.SDK_INT <= 18) {
                if (activity.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", activity.getPackageName()) == 0) {
                    Log.i(TAG, "android.permission.WRITE_EXTERNAL_STORAGE - VERIFIED");
                } else {
                    Log.e(TAG, "android.permission.WRITE_EXTERNAL_STORAGE - MISSING");
                    return false;
                }
            }
            return isActivitiesValid;
        } catch (Exception e) {
            Log.e(TAG, "isAdapterValid " + str, e);
            return false;
        }
    }

    private static boolean isServicesValid(Activity activity, String[] strArr) {
        boolean z = true;
        if (strArr == null) {
            return true;
        }
        PackageManager packageManager = activity.getPackageManager();
        Log.i(TAG, "*** Services ***");
        for (String str : strArr) {
            try {
                if (packageManager.queryIntentServices(new Intent(activity, Class.forName(str)), 65536).size() > 0) {
                    Log.i(TAG, str + " - VERIFIED");
                } else {
                    Log.e(TAG, str + " - MISSING");
                    z = false;
                }
            } catch (ClassNotFoundException unused) {
                Log.e(TAG, str + " - MISSING");
            }
        }
        return z;
    }

    private static boolean isExternalLibsValid(ArrayList<Pair<String, String>> arrayList) {
        boolean z = true;
        if (arrayList == null) {
            return true;
        }
        Log.i(TAG, "*** External Libraries ***");
        Iterator<Pair<String, String>> it = arrayList.iterator();
        while (it.hasNext()) {
            Pair<String, String> next = it.next();
            try {
                Class.forName((String) next.first);
                Log.i(TAG, ((String) next.second) + " - VERIFIED");
            } catch (ClassNotFoundException unused) {
                z = false;
                Log.e(TAG, ((String) next.second) + " - MISSING");
            }
        }
        return z;
    }

    private static boolean isActivitiesValid(Activity activity, String[] strArr) {
        boolean z = true;
        if (strArr == null) {
            return true;
        }
        Log.i(TAG, "*** Activities ***");
        for (String str : strArr) {
            try {
                if (activity.getPackageManager().queryIntentActivities(new Intent(activity, Class.forName(str)), 65536).size() > 0) {
                    Log.i(TAG, str + " - VERIFIED");
                } else {
                    Log.e(TAG, str + " - MISSING");
                    z = false;
                }
            } catch (ClassNotFoundException unused) {
                Log.e(TAG, str + " - MISSING");
            }
        }
        return z;
    }

    private static boolean areContentProvidersValid(Context context, String[] strArr) {
        String str;
        boolean z;
        List<PackageInfo> installedPackages;
        ArrayList arrayList = new ArrayList();
        if (!(context == null || (installedPackages = context.getPackageManager().getInstalledPackages(8)) == null)) {
            for (PackageInfo packageInfo : installedPackages) {
                ProviderInfo[] providerInfoArr = packageInfo.providers;
                if (providerInfoArr != null) {
                    for (ProviderInfo providerInfo : providerInfoArr) {
                        arrayList.add(providerInfo.name);
                    }
                }
            }
        }
        boolean z2 = true;
        if (strArr != null) {
            Log.i(TAG, "*** Content Providers ***");
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                String str2 = strArr[i];
                if (!arrayList.contains(str2)) {
                    str = "- MISSING";
                    z = false;
                } else {
                    z = z2;
                    str = "- VERIFIED";
                }
                Log.d(TAG, str2 + str);
                i++;
                z2 = z;
            }
        }
        return z2;
    }

    private static void validatePermissions(Activity activity) {
        Log.i(TAG, "*** Permissions ***");
        PackageManager packageManager = activity.getPackageManager();
        if (packageManager.checkPermission("android.permission.INTERNET", activity.getPackageName()) == 0) {
            Log.i(TAG, "android.permission.INTERNET - VERIFIED");
        } else {
            Log.e(TAG, "android.permission.INTERNET - MISSING");
        }
        if (packageManager.checkPermission("android.permission.ACCESS_NETWORK_STATE", activity.getPackageName()) == 0) {
            Log.i(TAG, "android.permission.ACCESS_NETWORK_STATE - VERIFIED");
        } else {
            Log.e(TAG, "android.permission.ACCESS_NETWORK_STATE - MISSING");
        }
    }

    private static boolean isAdapterVersionValid(IntegrationData integrationData) {
        if (integrationData.version.startsWith(SDK_COMPATIBILITY_VERSION) || integrationData.version.startsWith(BANNER_COMPATIBILITY_VERSION)) {
            Log.i(TAG, "Adapter - VERIFIED");
            return true;
        }
        Log.e(TAG, integrationData.name + " adapter " + integrationData.version + " is incompatible with SDK version " + IronSourceUtils.getSDKVersion() + ", please update your adapter to version " + SDK_COMPATIBILITY_VERSION + ".*");
        return false;
    }

    private static IntegrationData getIntegrationData(Activity activity, String str) {
        try {
            IntegrationData integrationData = (IntegrationData) Class.forName(str).getMethod("getIntegrationData", Activity.class).invoke(null, activity);
            Log.i(TAG, "Adapter " + integrationData.version + " - VERIFIED");
            return integrationData;
        } catch (ClassNotFoundException unused) {
            Log.e(TAG, "Adapter - MISSING");
            return null;
        } catch (Exception unused2) {
            Log.e(TAG, "Adapter version - NOT VERIFIED");
            return null;
        }
    }

    private static void validateGooglePlayServices(final Activity activity) {
        new Thread() {
            /* class com.ironsource.mediationsdk.integration.IntegrationHelper.AnonymousClass1 */

            public void run() {
                try {
                    Log.w(IntegrationHelper.TAG, "--------------- Google Play Services --------------");
                    if (activity.getPackageManager().getApplicationInfo(activity.getPackageName(), 128).metaData.containsKey("com.google.android.gms.version")) {
                        Log.i(IntegrationHelper.TAG, "Google Play Services - VERIFIED");
                        String advertiserId = IronSourceObject.getInstance().getAdvertiserId(activity);
                        if (!TextUtils.isEmpty(advertiserId)) {
                            Log.i(IntegrationHelper.TAG, "GAID is: " + advertiserId + " (use this for test devices)");
                            return;
                        }
                        return;
                    }
                    Log.e(IntegrationHelper.TAG, "Google Play Services - MISSING");
                } catch (Exception unused) {
                    Log.e(IntegrationHelper.TAG, "Google Play Services - MISSING");
                }
            }
        }.start();
    }

    private static void validateSDKVersion(String str) {
        try {
            Log.i(TAG, "SDK Version - " + ((String) Class.forName(str).getMethod("getAdapterSDKVersion", new Class[0]).invoke(null, new Object[0])));
        } catch (Exception unused) {
            Log.w("validateSDKVersion", "Unable to get SDK version");
        }
    }
}
