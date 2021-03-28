package com.tapjoy;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.WebView;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.internal.gw;
import com.tapjoy.internal.gz;

public class TapjoyLog {
    private static final String a = TapjoyLog.class.getSimpleName();
    private static int b = 6;
    private static int c = 4;
    private static int d = 2;
    private static boolean e = false;
    private static int f = 6;

    public static void setDebugEnabled(boolean z) {
        boolean z2;
        e = z;
        gz a2 = gz.a();
        if (gw.a != z) {
            gw.a = z;
            if (z) {
                gw.a("The debug mode has been enabled");
            } else {
                gw.a("The debug mode has been disabled");
            }
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 && z && a2.k) {
            a2.i.a();
        }
        if (e) {
            a(TapjoyConstants.LOG_LEVEL_DEBUG_ON, false);
        } else {
            a(TapjoyConstants.LOG_LEVEL_DEBUG_OFF, false);
        }
    }

    public static void setInternalLogging(boolean z) {
        if (z) {
            a(TapjoyConstants.LOG_LEVEL_INTERNAL, true);
        }
    }

    static void a(String str, boolean z) {
        if (z || TapjoyAppSettings.getInstance() == null || TapjoyAppSettings.getInstance().a == null) {
            if (str.equals(TapjoyConstants.LOG_LEVEL_INTERNAL)) {
                f = d;
                if (Build.VERSION.SDK_INT >= 19) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        /* class com.tapjoy.TapjoyLog.AnonymousClass1 */

                        public final void run() {
                            TapjoyLog.d(TapjoyLog.a, "Enabling WebView debugging");
                            WebView.setWebContentsDebuggingEnabled(true);
                        }
                    });
                }
            } else if (str.equals(TapjoyConstants.LOG_LEVEL_DEBUG_ON)) {
                f = c;
            } else if (str.equals(TapjoyConstants.LOG_LEVEL_DEBUG_OFF)) {
                f = b;
            } else {
                String str2 = a;
                d(str2, "unrecognized loggingLevel: " + str);
                f = b;
            }
            String str3 = a;
            d(str3, "logThreshold=" + f);
            return;
        }
        d(a, "setLoggingLevel -- log setting already persisted");
    }

    public static boolean isLoggingEnabled() {
        return e;
    }

    public static void i(String str, String str2) {
        a(4, str, str2);
    }

    public static void e(String str, String str2) {
        e(str, new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTERNAL_ERROR, str2));
    }

    public static void e(String str, TapjoyErrorMessage tapjoyErrorMessage) {
        if (tapjoyErrorMessage == null) {
            return;
        }
        if (f == d || tapjoyErrorMessage.getType() != TapjoyErrorMessage.ErrorType.INTERNAL_ERROR) {
            a(6, str, tapjoyErrorMessage.toString());
        }
    }

    public static void w(String str, String str2) {
        a(5, str, str2);
    }

    public static void d(String str, String str2) {
        a(3, str, str2);
    }

    public static void v(String str, String str2) {
        a(2, str, str2);
    }

    private static void a(int i, String str, String str2) {
        String str3 = a + ":" + str;
        if (f > i) {
            return;
        }
        if (str2.length() > 4096) {
            int i2 = 0;
            while (i2 <= str2.length() / 4096) {
                int i3 = i2 * 4096;
                i2++;
                int i4 = i2 * 4096;
                if (i4 > str2.length()) {
                    i4 = str2.length();
                }
                Log.println(i, str3, str2.substring(i3, i4));
            }
            return;
        }
        Log.println(i, str3, str2);
    }
}
