package com.ironsource.sdk.service;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.ironsource.environment.DeviceStatus;
import com.ironsource.sdk.Events.ISNEventParams;
import com.ironsource.sdk.Events.ISNEventsTracker;
import com.ironsource.sdk.Events.SDK5Events;
import com.ironsource.sdk.constants.Constants;
import com.ironsource.sdk.constants.Events;
import com.ironsource.sdk.utils.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class PackagesInstallationService {
    private static final String TAG = PackagesInstallationService.class.getSimpleName();
    private static final ArrayList<String> googlePlayAppPackageNames = new ArrayList<String>() {
        /* class com.ironsource.sdk.service.PackagesInstallationService.AnonymousClass1 */

        {
            add(Constants.AppPackageNames.GOOGLE_MARKET);
            add("com.android.vending");
        }
    };

    private static JSONObject getGooglePlayAppPackagesInstallationData(Context context) {
        return checkInstalledPackages(context, googlePlayAppPackageNames);
    }

    public static boolean isGooglePlayInstalled(Context context) {
        JSONObject googlePlayAppPackagesInstallationData = getGooglePlayAppPackagesInstallationData(context);
        Iterator<String> keys = googlePlayAppPackagesInstallationData.keys();
        while (keys.hasNext()) {
            JSONObject optJSONObject = googlePlayAppPackagesInstallationData.optJSONObject(keys.next());
            if (optJSONObject != null && optJSONObject.optBoolean(Constants.ParametersKeys.IS_PACKAGE_INSTALLED)) {
                return true;
            }
        }
        return false;
    }

    private static JSONObject checkInstalledPackages(Context context, ArrayList<String> arrayList) {
        JSONObject jSONObject = new JSONObject();
        try {
            ArrayList<String> installedPackageNamesOnDevice = getInstalledPackageNamesOnDevice(context);
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                jSONObject.put(next, buildAppPackageInstallationObject(installedPackageNamesOnDevice.contains(next.trim().toLowerCase())));
            }
        } catch (Exception e) {
            ISNEventsTracker.logEvent(SDK5Events.extractInstalledPackagesFailed, new ISNEventParams().addPair(Events.CALL_FAILED_REASON, e.getMessage()).addPair(Events.GENERAL_MSG, arrayList.toString()).getData());
            Logger.d(TAG, "Error while extracting packages installation data");
        }
        return jSONObject;
    }

    private static JSONObject buildAppPackageInstallationObject(final boolean z) throws JSONException {
        return new JSONObject() {
            /* class com.ironsource.sdk.service.PackagesInstallationService.AnonymousClass2 */

            {
                put(Constants.ParametersKeys.IS_PACKAGE_INSTALLED, z);
            }
        };
    }

    private static ArrayList<String> getInstalledPackageNamesOnDevice(Context context) {
        List<ApplicationInfo> installedApplications = DeviceStatus.getInstalledApplications(context);
        ArrayList<String> arrayList = new ArrayList<>();
        for (ApplicationInfo applicationInfo : installedApplications) {
            if (applicationInfo != null) {
                arrayList.add(applicationInfo.packageName.toLowerCase());
            }
        }
        return arrayList;
    }
}
