package com.onesignal;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import com.onesignal.ActivityLifecycleHandler;
import com.onesignal.AndroidSupportV4Compat;
import com.onesignal.OneSignal;

public class PermissionsActivity extends Activity {
    private static final int DELAY_TIME_CALLBACK_CALL = 500;
    private static final int REQUEST_LOCATION = 2;
    private static final int REQUEST_SETTINGS = 3;
    private static final String TAG = PermissionsActivity.class.getCanonicalName();
    private static ActivityLifecycleHandler.ActivityAvailableListener activityAvailableListener;
    static boolean answered;
    static boolean fallbackToSettings;
    static boolean neverAskAgainClicked;
    static boolean waiting;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        OneSignal.setAppContext(this);
        if (bundle == null || !bundle.getBoolean("android:hasCurrentPermissionsRequest", false)) {
            requestPermission();
        } else {
            waiting = true;
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (OneSignal.isInitDone()) {
            requestPermission();
        }
    }

    private void requestPermission() {
        if (Build.VERSION.SDK_INT < 23) {
            finish();
            overridePendingTransition(R.anim.onesignal_fade_in, R.anim.onesignal_fade_out);
        } else if (!waiting) {
            waiting = true;
            neverAskAgainClicked = !AndroidSupportV4Compat.ActivityCompat.shouldShowRequestPermissionRationale(this, LocationController.requestPermission);
            AndroidSupportV4Compat.ActivityCompat.requestPermissions(this, new String[]{LocationController.requestPermission}, 2);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, final int[] iArr) {
        answered = true;
        waiting = false;
        if (i == 2) {
            new Handler().postDelayed(new Runnable() {
                /* class com.onesignal.PermissionsActivity.AnonymousClass1 */

                public void run() {
                    int[] iArr = iArr;
                    boolean z = false;
                    if (iArr.length > 0 && iArr[0] == 0) {
                        z = true;
                    }
                    LocationController.sendAndClearPromptHandlers(true, z ? OneSignal.PromptActionResult.PERMISSION_GRANTED : OneSignal.PromptActionResult.PERMISSION_DENIED);
                    if (z) {
                        LocationController.startGetLocation();
                        return;
                    }
                    PermissionsActivity.this.attemptToShowLocationPermissionSettings();
                    LocationController.fireFailedComplete();
                }
            }, 500);
        }
        ActivityLifecycleHandler.removeActivityAvailableListener(TAG);
        finish();
        overridePendingTransition(R.anim.onesignal_fade_in, R.anim.onesignal_fade_out);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void attemptToShowLocationPermissionSettings() {
        if (fallbackToSettings && neverAskAgainClicked && !AndroidSupportV4Compat.ActivityCompat.shouldShowRequestPermissionRationale(this, LocationController.requestPermission)) {
            showLocationPermissionSettings();
        }
    }

    private void showLocationPermissionSettings() {
        new AlertDialog.Builder(ActivityLifecycleHandler.curActivity).setTitle(R.string.location_not_available_title).setMessage(R.string.location_not_available_open_settings_message).setPositiveButton(R.string.location_not_available_open_settings_option, new DialogInterface.OnClickListener() {
            /* class com.onesignal.PermissionsActivity.AnonymousClass3 */

            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.parse("package:" + PermissionsActivity.this.getPackageName()));
                PermissionsActivity.this.startActivity(intent);
                LocationController.sendAndClearPromptHandlers(true, OneSignal.PromptActionResult.PERMISSION_DENIED);
            }
        }).setNegativeButton(17039369, new DialogInterface.OnClickListener() {
            /* class com.onesignal.PermissionsActivity.AnonymousClass2 */

            public void onClick(DialogInterface dialogInterface, int i) {
                LocationController.sendAndClearPromptHandlers(true, OneSignal.PromptActionResult.PERMISSION_DENIED);
            }
        }).show();
    }

    static void startPrompt(boolean z) {
        if (!waiting && !answered) {
            fallbackToSettings = z;
            AnonymousClass4 r1 = new ActivityLifecycleHandler.ActivityAvailableListener() {
                /* class com.onesignal.PermissionsActivity.AnonymousClass4 */

                @Override // com.onesignal.ActivityLifecycleHandler.ActivityAvailableListener
                public void available(Activity activity) {
                    if (!activity.getClass().equals(PermissionsActivity.class)) {
                        Intent intent = new Intent(activity, PermissionsActivity.class);
                        intent.setFlags(131072);
                        activity.startActivity(intent);
                        activity.overridePendingTransition(R.anim.onesignal_fade_in, R.anim.onesignal_fade_out);
                    }
                }
            };
            activityAvailableListener = r1;
            ActivityLifecycleHandler.setActivityAvailableListener(TAG, r1);
        }
    }
}
