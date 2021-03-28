package com.bytedance.sdk.openadsdk.g;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.j;
import com.com.bytedance.overseas.sdk.a.a;
import com.tapjoy.TapjoyConstants;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DeviceUtils */
public class f {
    public static String a() {
        String a = a("wlan0");
        if (TextUtils.isEmpty(a)) {
            a = a("eth0");
        }
        return TextUtils.isEmpty(a) ? "DU:MM:YA:DD:RE:SS" : a;
    }

    private static String a(String str) {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (str == null || networkInterface.getName().equalsIgnoreCase(str)) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i])));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public static String a(boolean z) {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                Iterator it = Collections.list(networkInterface.getInetAddresses()).iterator();
                while (true) {
                    if (it.hasNext()) {
                        InetAddress inetAddress = (InetAddress) it.next();
                        if (!inetAddress.isLoopbackAddress()) {
                            boolean z2 = inetAddress instanceof Inet4Address;
                            String upperCase = inetAddress.getHostAddress().toUpperCase();
                            if (z) {
                                if (z2) {
                                    return upperCase;
                                }
                            } else if (!z2) {
                                int indexOf = upperCase.indexOf(37);
                                return indexOf < 0 ? upperCase : upperCase.substring(0, indexOf);
                            }
                        }
                    }
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean a(Context context) {
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean b(Context context) {
        try {
            return (context.getResources().getConfiguration().uiMode & 15) == 4;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int c(Context context) {
        if (b(context)) {
            return 3;
        }
        return a(context) ? 2 : 1;
    }

    private static void a(JSONObject jSONObject) throws JSONException {
        int g = g.b().g();
        if (j.e().b() == 1 && g == 0) {
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("gaid", a.a().c());
            return;
        }
        boolean z = false;
        boolean z2 = j.e().b() == 1 && (g == 1 || g == -1);
        if (j.e().b() == -1 && g == 1) {
            z = true;
        }
        if (!z2 && !z && g.b().h() != 1) {
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("gaid", a.a().c());
        }
    }

    public static JSONObject d(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            a(jSONObject);
            jSONObject.put("type", c(context));
            jSONObject.put("os", 1);
            jSONObject.put(TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME, Build.VERSION.RELEASE + "");
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("conn_type", m.b(context));
            jSONObject.put("screen_width", u.b(context));
            jSONObject.put("screen_height", u.c(context));
            jSONObject.put("power_on_time", SystemClock.elapsedRealtime() + "");
            jSONObject.put(TapjoyConstants.TJC_ANDROID_ID, h.c(context));
            jSONObject.put("uuid", h.d(context));
            jSONObject.put("rom_version", p.a());
            jSONObject.put("sys_compiling_time", h.b(context));
            jSONObject.put(TapjoyConstants.TJC_DEVICE_TIMEZONE, t.m());
            jSONObject.put("language", h.b());
            jSONObject.put("gp_version", a.a().b());
            jSONObject.put(TapjoyConstants.TJC_CARRIER_NAME, r.a());
            jSONObject.put("mnc", r.c());
            jSONObject.put("mcc", r.b());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static JSONObject e(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("gaid", a.a().c());
            jSONObject.put("type", c(context));
            jSONObject.put("os", 1);
            jSONObject.put(TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME, Build.VERSION.RELEASE + "");
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("conn_type", m.b(context));
            jSONObject.put("screen_width", u.b(context));
            jSONObject.put("screen_height", u.c(context));
            jSONObject.put("power_on_time", SystemClock.elapsedRealtime() + "");
            jSONObject.put(TapjoyConstants.TJC_ANDROID_ID, h.c(context));
            jSONObject.put("uuid", h.d(context));
            jSONObject.put("rom_version", p.a());
            jSONObject.put("sys_compiling_time", h.b(context));
            jSONObject.put(TapjoyConstants.TJC_DEVICE_TIMEZONE, t.m());
            jSONObject.put("language", h.b());
            jSONObject.put("gp_version", a.a().b());
            jSONObject.put(TapjoyConstants.TJC_CARRIER_NAME, r.a());
            jSONObject.put("mnc", r.c());
            jSONObject.put("mcc", r.b());
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
