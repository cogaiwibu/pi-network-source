package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.g.l;
import com.bytedance.sdk.openadsdk.g.p;
import com.bytedance.sdk.openadsdk.multipro.b;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Locale;

/* compiled from: IdUtils */
public class h {
    private static String a;
    private static String b;
    private static String c;
    private static String d;
    private static String e;
    private static String f;
    private static String g;
    private static String h;
    private static boolean i;

    private static Context f(Context context) {
        return context == null ? j.a() : context;
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(a) && !i) {
            synchronized (h.class) {
                if (!i) {
                    g(context);
                }
            }
        }
        try {
            if (TextUtils.isEmpty(a) && b.b()) {
                a = d.a(f(context)).b("did", (String) null);
            }
        } catch (Exception unused) {
        }
        return a;
    }

    public static String b(Context context) {
        if (f == null && !i) {
            synchronized (h.class) {
                if (!i) {
                    g(context);
                }
            }
        }
        return f;
    }

    public static String c(Context context) {
        if (TextUtils.isEmpty(b) && !i) {
            synchronized (h.class) {
                if (!i) {
                    g(context);
                }
            }
        }
        return b;
    }

    public static String d(Context context) {
        if (TextUtils.isEmpty(g) && !i) {
            synchronized (h.class) {
                if (!i) {
                    g(context);
                }
            }
        }
        return g;
    }

    public static String e(Context context) {
        if (TextUtils.isEmpty(h) && !i) {
            synchronized (h.class) {
                if (!i) {
                    g(context);
                }
            }
        }
        return h;
    }

    public static void a(Context context, String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(a)) {
            d.a(context).a("did", str);
            a = str;
        }
    }

    private static void g(Context context) {
        Context f2;
        if (!i && (f2 = f(context)) != null) {
            try {
                WifiManager wifiManager = (WifiManager) f2.getSystemService("wifi");
                WifiInfo connectionInfo = wifiManager != null ? wifiManager.getConnectionInfo() : null;
                if (connectionInfo != null) {
                    c = connectionInfo.getSSID();
                    if (Build.VERSION.SDK_INT < 23) {
                        d = connectionInfo.getMacAddress();
                    } else {
                        d = a();
                    }
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    h = Build.getSerial();
                } else {
                    h = Build.SERIAL;
                }
            } catch (Exception unused) {
            }
            b = a(f2, true);
            a = d.a(f2).b("did", (String) null);
            e = c();
            f = String.valueOf(Build.TIME);
            g = d.a(f2).b("uuid", (String) null);
            i = true;
        }
    }

    public static String a() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i2])));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return "02:00:00:00:00:00";
        } catch (Exception e2) {
            l.b(e2.toString());
            return "02:00:00:00:00:00";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0028, code lost:
        if (r2.length() >= 13) goto L_0x008c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized java.lang.String a(android.content.Context r6, boolean r7) {
        /*
        // Method dump skipped, instructions count: 147
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.h.a(android.content.Context, boolean):java.lang.String");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:(2:21|22)|23|24|25) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:11|12|13|(2:18|(4:(2:21|22)|23|24|25))|27|(2:29|30)|31|32|33) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0086 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x009b */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a8 A[SYNTHETIC, Splitter:B:40:0x00a8] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00af A[SYNTHETIC, Splitter:B:44:0x00af] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b6 A[SYNTHETIC, Splitter:B:52:0x00b6] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00bd A[SYNTHETIC, Splitter:B:56:0x00bd] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.lang.String r7, java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 193
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.h.a(java.lang.String, java.lang.String):java.lang.String");
    }

    private static boolean a(String str) {
        int length;
        if (str == null || (length = str.length()) < 13 || length > 128) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if ((charAt < '0' || charAt > '9') && ((charAt < 'a' || charAt > 'f') && ((charAt < 'A' || charAt > 'F') && charAt != '-'))) {
                return false;
            }
        }
        return true;
    }

    private static String c() {
        StringBuilder sb = new StringBuilder();
        try {
            if (p.e()) {
                sb.append("MIUI-");
            } else if (p.b()) {
                sb.append("FLYME-");
            } else {
                String n = p.n();
                if (p.a(n)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(n)) {
                    sb.append(n);
                    sb.append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
        } catch (Exception unused) {
        }
        return sb.toString();
    }

    public static String b() {
        Locale locale;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = LocaleList.getDefault().get(0);
            } else {
                locale = Locale.getDefault();
            }
            String language = locale.getLanguage();
            if (!"zh".equals(language)) {
                return language;
            }
            if (locale.toString().equals(Locale.SIMPLIFIED_CHINESE.toString())) {
                return "zh";
            }
            return "zh-Hant";
        } catch (Throwable unused) {
            return "";
        }
    }
}
