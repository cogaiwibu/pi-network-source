package com.bytedance.sdk.openadsdk.core.d;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import com.bytedance.sdk.openadsdk.g.l;

/* compiled from: MIUIPermissionUtils */
public class a {
    private static final String a = a.class.getSimpleName();

    public static boolean a(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 19) {
            return b(context, str);
        }
        return c(context, str);
    }

    private static boolean b(Context context, String str) {
        Exception e;
        String str2 = a;
        l.e(str2, "checkPermissinKITKATNew，permission：" + str);
        char c = 65535;
        boolean z = false;
        try {
            int hashCode = str.hashCode();
            if (hashCode != -1888586689) {
                if (hashCode != -63024214) {
                    if (hashCode == -5573545) {
                        if (str.equals("android.permission.READ_PHONE_STATE")) {
                            c = 2;
                        }
                    }
                } else if (str.equals("android.permission.ACCESS_COARSE_LOCATION")) {
                    c = 0;
                }
            } else if (str.equals("android.permission.ACCESS_FINE_LOCATION")) {
                c = 1;
            }
            String lowerCase = c != 0 ? c != 1 ? c != 2 ? str.replaceFirst("android.permission.", "android:").toLowerCase() : "android:read_phone_state" : "android:fine_location" : "android:coarse_location";
            int checkOp = ((AppOpsManager) context.getSystemService("appops")).checkOp(lowerCase, Binder.getCallingUid(), context.getPackageName());
            String str3 = a;
            l.e(str3, "checkPermissinKITKATNew，locationOp,permission：" + checkOp + "," + lowerCase);
            if (checkOp == 0) {
                return true;
            }
            try {
                String str4 = a;
                l.e(str4, "checkPermissinKITKATNew，false,permission：" + lowerCase);
                return false;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            z = true;
            String str5 = a;
            l.e(str5, "权限检查出错时默认返回有权限，异常代码：" + e);
            return z;
        }
    }

    private static boolean c(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
