package com.onesignal;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import com.google.android.gms.common.GoogleApiAvailability;

class GooglePlayServicesUpgradePrompt {
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;

    GooglePlayServicesUpgradePrompt() {
    }

    private static boolean isGooglePlayStoreInstalled() {
        try {
            PackageManager packageManager = OneSignal.appContext.getPackageManager();
            return !((String) packageManager.getPackageInfo("com.google.android.gms", 128).applicationInfo.loadLabel(packageManager)).equals("Market");
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    static void showUpdateGPSDialog() {
        if (OSUtils.isAndroidDeviceType() && isGooglePlayStoreInstalled() && !OneSignalPrefs.getBool(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_GT_DO_NOT_SHOW_MISSING_GPS, false)) {
            OSUtils.runOnMainUIThread(new Runnable() {
                /* class com.onesignal.GooglePlayServicesUpgradePrompt.AnonymousClass1 */

                public void run() {
                    final Activity activity = ActivityLifecycleHandler.curActivity;
                    if (activity != null && !OneSignal.mInitBuilder.mDisableGmsMissingPrompt) {
                        String resourceString = OSUtils.getResourceString(activity, "onesignal_gms_missing_alert_text", "To receive push notifications please press 'Update' to enable 'Google Play services'.");
                        String resourceString2 = OSUtils.getResourceString(activity, "onesignal_gms_missing_alert_button_update", "Update");
                        String resourceString3 = OSUtils.getResourceString(activity, "onesignal_gms_missing_alert_button_skip", "Skip");
                        new AlertDialog.Builder(activity).setMessage(resourceString).setPositiveButton(resourceString2, new DialogInterface.OnClickListener() {
                            /* class com.onesignal.GooglePlayServicesUpgradePrompt.AnonymousClass1.AnonymousClass2 */

                            public void onClick(DialogInterface dialogInterface, int i) {
                                GooglePlayServicesUpgradePrompt.OpenPlayStoreToApp(activity);
                            }
                        }).setNegativeButton(resourceString3, new DialogInterface.OnClickListener() {
                            /* class com.onesignal.GooglePlayServicesUpgradePrompt.AnonymousClass1.AnonymousClass1 */

                            public void onClick(DialogInterface dialogInterface, int i) {
                                OneSignalPrefs.saveBool(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_GT_DO_NOT_SHOW_MISSING_GPS, true);
                            }
                        }).setNeutralButton(OSUtils.getResourceString(activity, "onesignal_gms_missing_alert_button_close", "Close"), (DialogInterface.OnClickListener) null).create().show();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static void OpenPlayStoreToApp(Activity activity) {
        try {
            GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
            PendingIntent errorResolutionPendingIntent = instance.getErrorResolutionPendingIntent(activity, instance.isGooglePlayServicesAvailable(OneSignal.appContext), PLAY_SERVICES_RESOLUTION_REQUEST);
            if (errorResolutionPendingIntent != null) {
                errorResolutionPendingIntent.send();
            }
        } catch (PendingIntent.CanceledException e) {
            e.printStackTrace();
        }
    }
}
