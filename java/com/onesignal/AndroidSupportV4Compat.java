package com.onesignal;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.util.Log;

class AndroidSupportV4Compat {

    /* access modifiers changed from: package-private */
    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int i);
    }

    AndroidSupportV4Compat() {
    }

    /* access modifiers changed from: package-private */
    public static class ContextCompat {
        ContextCompat() {
        }

        static int checkSelfPermission(Context context, String str) {
            try {
                return context.checkPermission(str, Process.myPid(), Process.myUid());
            } catch (Throwable unused) {
                Log.e("OneSignal", "checkSelfPermission failed, returning PERMISSION_DENIED");
                return -1;
            }
        }

        static int getColor(Context context, int i) {
            if (Build.VERSION.SDK_INT > 22) {
                return context.getColor(i);
            }
            return context.getResources().getColor(i);
        }
    }

    static class ActivityCompat {
        ActivityCompat() {
        }

        static void requestPermissions(Activity activity, String[] strArr, int i) {
            ActivityCompatApi23.requestPermissions(activity, strArr, i);
        }

        static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
            return ActivityCompatApi23.shouldShowRequestPermissionRationale(activity, str);
        }
    }

    static class ActivityCompatApi23 {
        ActivityCompatApi23() {
        }

        static void requestPermissions(Activity activity, String[] strArr, int i) {
            if (activity instanceof RequestPermissionsRequestCodeValidator) {
                ((RequestPermissionsRequestCodeValidator) activity).validateRequestPermissionsRequestCode(i);
            }
            activity.requestPermissions(strArr, i);
        }

        static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
            return androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale(activity, str);
        }
    }
}
