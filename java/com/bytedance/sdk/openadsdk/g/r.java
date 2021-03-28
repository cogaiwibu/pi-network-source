package com.bytedance.sdk.openadsdk.g;

import android.content.res.Configuration;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.j;

/* compiled from: SimUtils */
public class r {
    private static boolean a = false;
    private static String b = null;
    private static String c = null;
    private static String d = null;
    private static boolean e = true;

    private static void d() {
        String str;
        String str2;
        String str3;
        if (j.a() != null && !a) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) j.a().getSystemService("phone");
                try {
                    int simState = telephonyManager.getSimState();
                    if (simState == 0) {
                        e = false;
                    } else if (simState == 1) {
                        e = false;
                    }
                    l.e("MCC", e ? "有SIM卡" : "无SIM卡");
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                String str4 = null;
                try {
                    str = telephonyManager.getSimOperatorName();
                } catch (Throwable unused) {
                    str = null;
                }
                try {
                    str2 = telephonyManager.getNetworkOperator();
                } catch (Throwable unused2) {
                    str2 = null;
                }
                if (str2 == null || str2.length() < 5) {
                    try {
                        str2 = telephonyManager.getSimOperator();
                    } catch (Throwable unused3) {
                    }
                }
                if (TextUtils.isEmpty(str2) || str2.length() <= 4) {
                    str3 = null;
                } else {
                    str4 = str2.substring(0, 3);
                    str3 = str2.substring(3);
                }
                if (!TextUtils.isEmpty(str)) {
                    b = str;
                }
                if (!TextUtils.isEmpty(str4)) {
                    c = str4;
                }
                if (!TextUtils.isEmpty(str3)) {
                    d = str3;
                }
            } catch (Throwable unused4) {
            }
            a = true;
        }
    }

    public static String a() {
        if (!a) {
            d();
        }
        return b;
    }

    public static String b() {
        try {
            if (!a) {
                d();
            }
            Configuration configuration = j.a().getResources().getConfiguration();
            String valueOf = configuration.mcc != 0 ? String.valueOf(configuration.mcc) : c;
            l.e("MCC", "config=" + configuration.mcc + ",sMCC=" + c);
            if (e) {
                return valueOf;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("getMCC");
            sb.append(e ? "有SIM卡" : "无SIM卡,MCC返回null");
            l.e("MCC", sb.toString());
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String c() {
        if (!a) {
            d();
        }
        return d;
    }
}
