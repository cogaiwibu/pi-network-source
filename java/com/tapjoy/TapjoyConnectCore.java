package com.tapjoy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.facebook.appevents.AppEventsConstants;
import com.ironsource.sdk.constants.Constants;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.internal.al;
import com.tapjoy.internal.bh;
import com.tapjoy.internal.bn;
import com.tapjoy.internal.eu;
import com.tapjoy.internal.fa;
import com.tapjoy.internal.fb;
import com.tapjoy.internal.fh;
import com.tapjoy.internal.fo;
import com.tapjoy.internal.fs;
import com.tapjoy.internal.ga;
import com.tapjoy.internal.ge;
import com.tapjoy.internal.gz;
import com.tapjoy.internal.hc;
import com.tapjoy.internal.hn;
import com.tapjoy.internal.jq;
import com.tapjoy.internal.jz;
import com.tapjoy.internal.v;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import org.w3c.dom.Document;

public class TapjoyConnectCore {
    private static float A = 1.0f;
    private static int B = 1;
    private static String C = "";
    private static String D = "";
    public static final float DEFAULT_CURRENCY_MULTIPLIER = 1.0f;
    private static String E = "";
    private static String F = "";
    private static String G = "";
    private static String H = "";
    private static String I = "";
    private static String J = "";
    private static String K = "";
    private static String L = "";
    private static String M = "";
    private static String N = "";
    private static String O = "native";
    private static String P = "";
    private static String Q = "";
    private static float R = 1.0f;
    private static boolean S = false;
    private static String T = "";
    private static String U = "";
    private static String V = "";
    private static String W = "";
    private static String X = null;
    protected static int a = 0;
    private static Integer aA;
    private static Long aB;
    private static Long aC;
    private static Long aD;
    private static String aE;
    private static Integer aF;
    private static Double aG;
    private static Double aH;
    private static Long aI;
    private static Integer aJ;
    private static Integer aK;
    private static Integer aL;
    private static String aM;
    private static String aN;
    private static String aO;
    private static String aP = "";
    private static String aQ = "";
    private static String aR = "";
    private static boolean aS = false;
    private static TJConnectListener aT = null;
    private static boolean aU = false;
    private static long aa = 0;
    private static boolean ac;
    private static PackageManager ad;
    private static TapjoyGpsHelper ae;
    private static Hashtable af = TapjoyConnectFlag.CONNECT_FLAG_DEFAULTS;
    private static Map ag = new ConcurrentHashMap();
    private static String ah;
    private static String ai;
    private static String aj;
    private static String ak;
    private static Integer al;
    private static String am;
    private static String an;
    private static Long ao;
    private static String ap;
    private static Integer aq;
    private static Integer ar;
    private static String as;
    private static String at;
    private static String au;
    private static String av;
    private static String aw;
    private static Set ax;
    private static Integer ay;
    private static Integer az;
    protected static int b = 0;
    protected static String c = "";
    protected static boolean d;
    protected static String e = "";
    protected static String f = "";
    private static Context g;
    private static String h;
    private static TapjoyConnectCore i;
    private static TapjoyURLConnection j;
    private static TJConnectListener k;
    private static TJSetUserIDListener l;
    private static Vector m = new Vector(Arrays.asList(TapjoyConstants.dependencyClassNames));
    private static String n = "";
    private static String o = "";
    private static String p = "";
    private static String q = "";
    private static String r = "";
    private static String s = "";
    private static String t = "";
    private static String u = "";
    private static String v = "";
    private static String w = "";
    private static String x = "";
    private static String y = "";
    private static int z = 1;
    private long Y = 0;
    private boolean Z = false;
    private boolean ab = false;

    public static String getConnectURL() {
        return TapjoyConfig.TJC_CONNECT_SERVICE_URL;
    }

    public static TapjoyConnectCore getInstance() {
        return i;
    }

    public static void requestTapjoyConnect(Context context, String str) {
        requestTapjoyConnect(context, str, null);
    }

    public static void requestTapjoyConnect(Context context, String str, Hashtable hashtable) {
        requestTapjoyConnect(context, str, hashtable, null);
    }

    public static void requestTapjoyConnect(Context context, String str, Hashtable hashtable, TJConnectListener tJConnectListener) {
        try {
            fo foVar = new fo(str);
            if (foVar.a == fo.a.SDK_ANDROID) {
                h = str;
                v = foVar.b;
                M = foVar.c;
                N = foVar.d;
                if (hashtable != null) {
                    af.putAll(hashtable);
                    ga.b().a(hashtable);
                }
                gz.a(context).j = str;
                k = tJConnectListener;
                if (i == null) {
                    i = new TapjoyConnectCore();
                }
                TapjoyConnectCore tapjoyConnectCore = i;
                try {
                    a(context);
                    new Thread(new Runnable() {
                        /* class com.tapjoy.TapjoyConnectCore.AnonymousClass1 */

                        public final void run() {
                            TapjoyConnectCore.a();
                            TapjoyConnectCore.this.completeConnectCall();
                        }
                    }).start();
                    tapjoyConnectCore.ab = true;
                } catch (TapjoyIntegrationException e2) {
                    TapjoyLog.e("TapjoyConnect", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, e2.getMessage()));
                    d();
                    fs.b.notifyObservers(Boolean.FALSE);
                } catch (TapjoyException e3) {
                    TapjoyLog.e("TapjoyConnect", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, e3.getMessage()));
                    d();
                    fs.b.notifyObservers(Boolean.FALSE);
                }
            } else {
                throw new IllegalArgumentException("The given API key was not for Android.");
            }
        } catch (IllegalArgumentException e4) {
            throw new TapjoyIntegrationException(e4.getMessage());
        }
    }

    public static void requestLimitedTapjoyConnect(Context context, String str, TJConnectListener tJConnectListener) {
        try {
            fo foVar = new fo(str);
            if (foVar.a == fo.a.SDK_ANDROID) {
                aP = foVar.b;
                aQ = foVar.c;
                if (i == null) {
                    i = new TapjoyConnectCore();
                }
                aT = tJConnectListener;
                TapjoyConnectCore tapjoyConnectCore = i;
                try {
                    a(context);
                    new Thread(new Runnable() {
                        /* class com.tapjoy.TapjoyConnectCore.AnonymousClass2 */

                        public final void run() {
                            TapjoyConnectCore.a();
                            TapjoyConnectCore.this.completeLimitedConnectCall();
                        }
                    }).start();
                } catch (TapjoyIntegrationException e2) {
                    TapjoyLog.e("TapjoyConnect", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, e2.getMessage()));
                    e();
                    fs.b.notifyObservers(Boolean.FALSE);
                } catch (TapjoyException e3) {
                    TapjoyLog.e("TapjoyConnect", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, e3.getMessage()));
                    e();
                    fs.b.notifyObservers(Boolean.FALSE);
                }
                TapjoyLog.d("TapjoyConnect", "requestTapjoyConnect function complete");
                return;
            }
            throw new IllegalArgumentException("The given API key was not for Android.");
        } catch (IllegalArgumentException e4) {
            TapjoyLog.d("TapjoyConnect", e4.getMessage());
            throw new TapjoyIntegrationException(e4.getMessage());
        }
    }

    private static void d() {
        if (!jq.c(N)) {
            gz.a().a(g, h, TapjoyConstants.TJC_LIBRARY_VERSION_NUMBER, TapjoyConfig.TJC_ANALYTICS_SERVICE_URL, N, M);
        }
        TJConnectListener tJConnectListener = k;
        if (tJConnectListener != null) {
            tJConnectListener.onConnectFailure();
        }
    }

    private static void e() {
        TJConnectListener tJConnectListener = aT;
        if (tJConnectListener != null) {
            tJConnectListener.onConnectFailure();
        }
    }

    public void appPause() {
        this.Z = true;
    }

    public void appResume() {
        if (this.Z) {
            p();
            this.Z = false;
        }
    }

    public static Map getURLParams() {
        Map genericURLParams = getGenericURLParams();
        genericURLParams.putAll(getTimeStampAndVerifierParams());
        return genericURLParams;
    }

    public static Map getLimitedURLParams() {
        Map limitedGenericURLParams = getLimitedGenericURLParams();
        limitedGenericURLParams.putAll(getLimitedTimeStampAndVerifierParams());
        return limitedGenericURLParams;
    }

    public static Map getGenericURLParams() {
        Map f2 = f();
        TapjoyUtil.safePut(f2, "app_id", v, true);
        return f2;
    }

    public static Map getLimitedGenericURLParams() {
        Map f2 = f();
        TapjoyUtil.safePut(f2, "app_id", aP, true);
        TapjoyUtil.safePut(f2, TapjoyConstants.TJC_APP_GROUP_ID, aR, true);
        TapjoyUtil.safePut(f2, TapjoyConstants.TJC_LIMITED, "true", true);
        return f2;
    }

    private static Map f() {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        TapjoyUtil.safePut(hashMap3, TapjoyConstants.TJC_PLUGIN, O, true);
        TapjoyUtil.safePut(hashMap3, TapjoyConstants.TJC_SDK_TYPE, P, true);
        TapjoyUtil.safePut(hashMap3, "app_id", v, true);
        TapjoyUtil.safePut(hashMap3, TapjoyConstants.TJC_LIBRARY_VERSION, x, true);
        TapjoyUtil.safePut(hashMap3, TapjoyConstants.TJC_LIBRARY_REVISION, TapjoyRevision.GIT_REVISION, true);
        TapjoyUtil.safePut(hashMap3, TapjoyConstants.TJC_BRIDGE_VERSION, y, true);
        TapjoyUtil.safePut(hashMap3, TapjoyConstants.TJC_APP_VERSION_NAME, w, true);
        hashMap2.putAll(hashMap3);
        HashMap hashMap4 = new HashMap();
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_DEVICE_NAME, r, true);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_PLATFORM, E, true);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME, u, true);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_DEVICE_MANUFACTURER, s, true);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_DEVICE_TYPE_NAME, t, true);
        StringBuilder sb = new StringBuilder();
        sb.append(B);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_DEVICE_SCREEN_LAYOUT_SIZE, sb.toString(), true);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_STORE_NAME, L, true);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_STORE_VIEW, String.valueOf(S), true);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_CARRIER_NAME, F, true);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_CARRIER_COUNTRY_CODE, G, true);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_MOBILE_NETWORK_CODE, I, true);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_MOBILE_COUNTRY_CODE, H, true);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_DEVICE_COUNTRY_CODE, Locale.getDefault().getCountry(), true);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_DEVICE_LANGUAGE, Locale.getDefault().getLanguage(), true);
        String connectionType = getConnectionType();
        J = connectionType;
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_CONNECTION_TYPE, connectionType, true);
        String connectionSubType = getConnectionSubType();
        K = connectionSubType;
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_CONNECTION_SUBTYPE, connectionSubType, true);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(z);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_DEVICE_SCREEN_DENSITY, sb2.toString(), true);
        hashMap2.putAll(hashMap4);
        HashMap hashMap5 = new HashMap();
        if (m()) {
            TapjoyUtil.safePut(hashMap5, TapjoyConstants.TJC_ADVERTISING_ID, c, true);
            TapjoyUtil.safePut(hashMap5, TapjoyConstants.TJC_AD_TRACKING_ENABLED, String.valueOf(d), true);
        }
        if ((n() && !m()) || !o()) {
            TapjoyUtil.safePut(hashMap5, TapjoyConstants.TJC_ANDROID_ID, n, true);
            TapjoyUtil.safePut(hashMap5, TapjoyConstants.TJC_DEVICE_MAC_ADDRESS, p, true);
        }
        TapjoyUtil.safePut(hashMap5, TapjoyConstants.TJC_INSTALL_ID, q, true);
        TapjoyUtil.safePut(hashMap5, TapjoyConstants.TJC_USER_ID, C, true);
        TapjoyUtil.safePut(hashMap5, TapjoyConstants.TJC_ADVERTISING_ID_CHECK_DISABLED, e, true);
        TapjoyUtil.safePut(hashMap5, TapjoyConstants.TJC_LEGACY_ID_FALLBACK_ALLOWED, f, true);
        int i2 = a;
        if (i2 != 0) {
            TapjoyUtil.safePut(hashMap5, TapjoyConstants.TJC_PACKAGED_GOOGLE_PLAY_SERVICES_VERSION, Integer.toString(i2), true);
        }
        int i3 = b;
        if (i3 != 0) {
            TapjoyUtil.safePut(hashMap5, TapjoyConstants.TJC_DEVICE_GOOGLE_PLAY_SERVICES_VERSION, Integer.toString(i3), true);
        }
        String str = o;
        if (str == null || str.length() == 0 || System.currentTimeMillis() - aa > TapjoyConstants.SESSION_ID_INACTIVITY_TIME) {
            o = p();
        } else {
            aa = System.currentTimeMillis();
        }
        TapjoyUtil.safePut(hashMap5, TapjoyConstants.TJC_SESSION_ID, o, true);
        hashMap2.putAll(hashMap5);
        HashMap hashMap6 = new HashMap();
        TapjoyUtil.safePut(hashMap6, TapjoyConstants.TJC_APP_GROUP_ID, T, true);
        TapjoyUtil.safePut(hashMap6, "store", U, true);
        TapjoyUtil.safePut(hashMap6, TapjoyConstants.TJC_ANALYTICS_API_KEY, V, true);
        TapjoyUtil.safePut(hashMap6, TapjoyConstants.TJC_MANAGED_DEVICE_ID, W, true);
        hashMap2.putAll(hashMap6);
        ge a2 = ge.a();
        HashMap hashMap7 = new HashMap();
        if (a2.a != null) {
            TapjoyUtil.safePut(hashMap7, "gdpr", a2.a.booleanValue() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO, true);
        }
        if (!al.a(a2.b)) {
            TapjoyUtil.safePut(hashMap7, "cgdpr", a2.b, true);
        }
        hashMap2.putAll(hashMap7);
        if (!(TapjoyCache.getInstance() == null || TapjoyCache.getInstance().getCachedOfferIDs() == null || TapjoyCache.getInstance().getCachedOfferIDs().length() <= 0)) {
            TapjoyUtil.safePut(hashMap2, TapjoyConstants.TJC_CACHED_OFFERS, TapjoyCache.getInstance().getCachedOfferIDs(), true);
        }
        TapjoyUtil.safePut(hashMap2, TapjoyConstants.TJC_CURRENCY_MULTIPLIER, Float.toString(R), true);
        hashMap.putAll(hashMap2);
        HashMap hashMap8 = new HashMap();
        h();
        HashMap hashMap9 = new HashMap();
        TapjoyUtil.safePut(hashMap9, TapjoyConstants.TJC_ANALYTICS_ID, ah, true);
        TapjoyUtil.safePut(hashMap9, TapjoyConstants.TJC_PACKAGE_ID, ai, true);
        TapjoyUtil.safePut(hashMap9, TapjoyConstants.TJC_PACKAGE_SIGN, aj, true);
        TapjoyUtil.safePut(hashMap9, TapjoyConstants.TJC_DEVICE_DISPLAY_DENSITY, aJ);
        TapjoyUtil.safePut(hashMap9, TapjoyConstants.TJC_DEVICE_DISPLAY_WIDTH, aK);
        TapjoyUtil.safePut(hashMap9, TapjoyConstants.TJC_DEVICE_DISPLAY_HEIGHT, aL);
        TapjoyUtil.safePut(hashMap9, TapjoyConstants.TJC_DEVICE_COUNTRY_SIM, aM, true);
        TapjoyUtil.safePut(hashMap9, TapjoyConstants.TJC_DEVICE_TIMEZONE, aN, true);
        hashMap8.putAll(hashMap9);
        HashMap hashMap10 = new HashMap();
        TapjoyUtil.safePut(hashMap10, TapjoyConstants.TJC_PACKAGE_VERSION, ak, true);
        TapjoyUtil.safePut(hashMap10, TapjoyConstants.TJC_PACKAGE_REVISION, al);
        TapjoyUtil.safePut(hashMap10, TapjoyConstants.TJC_PACKAGE_DATA_VERSION, am, true);
        TapjoyUtil.safePut(hashMap10, TapjoyConstants.TJC_INSTALLER, an, true);
        if (jq.c(L)) {
            TapjoyUtil.safePut(hashMap10, TapjoyConstants.TJC_STORE_NAME, aO, true);
        }
        hashMap8.putAll(hashMap10);
        hashMap8.putAll(g());
        hashMap.putAll(hashMap8);
        return hashMap;
    }

    public static Map getTimeStampAndVerifierParams() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String a2 = a(currentTimeMillis);
        HashMap hashMap = new HashMap();
        TapjoyUtil.safePut(hashMap, "timestamp", String.valueOf(currentTimeMillis), true);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_VERIFIER, a2, true);
        return hashMap;
    }

    public static Map getLimitedTimeStampAndVerifierParams() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String b2 = b(currentTimeMillis);
        HashMap hashMap = new HashMap();
        TapjoyUtil.safePut(hashMap, "timestamp", String.valueOf(currentTimeMillis), true);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_VERIFIER, b2, true);
        return hashMap;
    }

    private static Map g() {
        HashMap hashMap = new HashMap();
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_INSTALLED, ao);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_REFERRER, ap, true);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_USER_LEVEL, aq);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_USER_FRIEND_COUNT, ar);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_USER_VARIABLE_1, as, true);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_USER_VARIABLE_2, at, true);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_USER_VARIABLE_3, au, true);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_USER_VARIABLE_4, av, true);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_USER_VARIABLE_5, aw, true);
        int i2 = 0;
        for (String str : ax) {
            StringBuilder sb = new StringBuilder("user_tags[");
            int i3 = i2 + 1;
            sb.append(i2);
            sb.append(Constants.RequestParameters.RIGHT_BRACKETS);
            TapjoyUtil.safePut(hashMap, sb.toString(), str, true);
            i2 = i3;
        }
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_USER_WEEKLY_FREQUENCY, ay);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_USER_MONTHLY_FREQUENCY, az);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_SESSION_TOTAL_COUNT, aA);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_SESSION_TOTAL_LENGTH, aB);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_SESSION_LAST_AT, aC);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_SESSION_LAST_LENGTH, aD);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_PURCHASE_CURRENCY, aE, true);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_PURCHASE_TOTAL_COUNT, aF);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_PURCHASE_TOTAL_PRICE, aG);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_PURCHASE_LAST_PRICE, aH);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_PURCHASE_LAST_AT, aI);
        return hashMap;
    }

    private static boolean a(Context context) {
        WifiInfo connectionInfo;
        g = context;
        ad = context.getPackageManager();
        ge.a().a(context);
        ga.a().a(context);
        ae = new TapjoyGpsHelper(g);
        if (j == null) {
            j = new TapjoyURLConnection();
        }
        if (af == null) {
            af = new Hashtable();
        }
        j();
        int identifier = g.getResources().getIdentifier("raw/tapjoy_config", null, g.getPackageName());
        Properties properties = new Properties();
        try {
            properties.load(g.getResources().openRawResource(identifier));
            a(properties);
        } catch (Exception unused) {
        }
        if (jq.c(getConnectFlagValue("unit_test_mode"))) {
            k();
        }
        String string = Settings.Secure.getString(g.getContentResolver(), TapjoyConstants.TJC_ANDROID_ID);
        n = string;
        if (string != null) {
            n = string.toLowerCase();
        }
        try {
            boolean z2 = false;
            w = ad.getPackageInfo(g.getPackageName(), 0).versionName;
            t = "android";
            E = "android";
            r = Build.MODEL;
            s = Build.MANUFACTURER;
            u = Build.VERSION.RELEASE;
            x = TapjoyConstants.TJC_LIBRARY_VERSION_NUMBER;
            y = TapjoyConstants.TJC_BRIDGE_VERSION_NUMBER;
            try {
                if (Build.VERSION.SDK_INT > 3) {
                    TapjoyDisplayMetricsUtil tapjoyDisplayMetricsUtil = new TapjoyDisplayMetricsUtil(g);
                    z = tapjoyDisplayMetricsUtil.getScreenDensityDPI();
                    A = tapjoyDisplayMetricsUtil.getScreenDensityScale();
                    B = tapjoyDisplayMetricsUtil.getScreenLayoutSize();
                }
            } catch (Exception e2) {
                TapjoyLog.e("TapjoyConnect", "Error getting screen density/dimensions/layout: " + e2.toString());
            }
            if (e("android.permission.ACCESS_WIFI_STATE")) {
                try {
                    WifiManager wifiManager = (WifiManager) g.getSystemService("wifi");
                    if (!(wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null)) {
                        String macAddress = connectionInfo.getMacAddress();
                        p = macAddress;
                        if (macAddress != null) {
                            p = macAddress.replace(":", "").toLowerCase();
                        }
                    }
                } catch (Exception e3) {
                    TapjoyLog.e("TapjoyConnect", "Error getting device mac address: " + e3.toString());
                }
            } else {
                TapjoyLog.d("TapjoyConnect", "*** ignore macAddress");
            }
            TelephonyManager telephonyManager = (TelephonyManager) g.getSystemService("phone");
            if (telephonyManager != null) {
                F = telephonyManager.getNetworkOperatorName();
                G = telephonyManager.getNetworkCountryIso();
                String networkOperator = telephonyManager.getNetworkOperator();
                if (networkOperator != null && (networkOperator.length() == 5 || networkOperator.length() == 6)) {
                    H = networkOperator.substring(0, 3);
                    I = networkOperator.substring(3);
                }
            }
            SharedPreferences sharedPreferences = g.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0);
            String string2 = sharedPreferences.getString(TapjoyConstants.PREF_INSTALL_ID, "");
            q = string2;
            if (string2 == null || string2.length() == 0) {
                try {
                    q = TapjoyUtil.SHA256(UUID.randomUUID().toString() + System.currentTimeMillis());
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString(TapjoyConstants.PREF_INSTALL_ID, q);
                    edit.apply();
                } catch (Exception e4) {
                    TapjoyLog.e("TapjoyConnect", "Error generating install id: " + e4.toString());
                }
            }
            if (getConnectFlagValue(TapjoyConnectFlag.STORE_NAME) != null && getConnectFlagValue(TapjoyConnectFlag.STORE_NAME).length() > 0) {
                L = getConnectFlagValue(TapjoyConnectFlag.STORE_NAME);
                if (!new ArrayList(Arrays.asList(TapjoyConnectFlag.STORE_ARRAY)).contains(L)) {
                    TapjoyLog.w("TapjoyConnect", "Warning -- undefined STORE_NAME: " + L);
                }
            }
            try {
                String str = L;
                Intent intent = new Intent("android.intent.action.VIEW");
                if (str.length() <= 0) {
                    intent.setData(Uri.parse("market://details"));
                    if (ad.queryIntentActivities(intent, 0).size() > 0) {
                        z2 = true;
                    }
                }
                S = z2;
            } catch (Exception e5) {
                TapjoyLog.e("TapjoyConnect", "Error trying to detect store intent on devicee: " + e5.toString());
            }
            h();
            if (getConnectFlagValue(TapjoyConnectFlag.ALLOW_LEGACY_ID_FALLBACK) != null && getConnectFlagValue(TapjoyConnectFlag.ALLOW_LEGACY_ID_FALLBACK).length() > 0) {
                f = getConnectFlagValue(TapjoyConnectFlag.ALLOW_LEGACY_ID_FALLBACK);
            }
            if (getConnectFlagValue(TapjoyConnectFlag.DISABLE_ADVERTISING_ID_CHECK) != null && getConnectFlagValue(TapjoyConnectFlag.DISABLE_ADVERTISING_ID_CHECK).length() > 0) {
                e = getConnectFlagValue(TapjoyConnectFlag.DISABLE_ADVERTISING_ID_CHECK);
            }
            if (getConnectFlagValue(TapjoyConnectFlag.USER_ID) != null && getConnectFlagValue(TapjoyConnectFlag.USER_ID).length() > 0) {
                TapjoyLog.i("TapjoyConnect", "Setting userID to: " + getConnectFlagValue(TapjoyConnectFlag.USER_ID));
                setUserID(getConnectFlagValue(TapjoyConnectFlag.USER_ID), null);
            }
            Q = TapjoyUtil.getRedirectDomain(getConnectFlagValue(TapjoyConnectFlag.SERVICE_URL));
            if (af != null) {
                i();
            }
            return true;
        } catch (PackageManager.NameNotFoundException e6) {
            throw new TapjoyException(e6.getMessage());
        }
    }

    private static void h() {
        fb a2 = gz.a(g).a(true);
        fa faVar = a2.d;
        ah = faVar.h;
        ai = faVar.r;
        aj = faVar.s;
        aJ = faVar.m;
        aK = faVar.n;
        aL = faVar.o;
        aM = faVar.u;
        aN = faVar.q;
        eu euVar = a2.e;
        ak = euVar.e;
        al = euVar.f;
        am = euVar.g;
        an = euVar.h;
        aO = euVar.i;
        fh fhVar = a2.f;
        ao = fhVar.s;
        ap = fhVar.t;
        aq = fhVar.J;
        ar = fhVar.K;
        as = fhVar.L;
        at = fhVar.M;
        au = fhVar.N;
        av = fhVar.O;
        aw = fhVar.P;
        ax = new HashSet(fhVar.Q);
        ay = fhVar.u;
        az = fhVar.v;
        aA = fhVar.x;
        aB = fhVar.y;
        aC = fhVar.z;
        aD = fhVar.A;
        aE = fhVar.B;
        aF = fhVar.C;
        aG = fhVar.D;
        aH = fhVar.F;
        aI = fhVar.E;
    }

    private static void i() {
        TapjoyLog.i("TapjoyConnect", "Connect Flags:");
        TapjoyLog.i("TapjoyConnect", "--------------------");
        for (Map.Entry entry : af.entrySet()) {
            TapjoyLog.i("TapjoyConnect", "key: " + ((String) entry.getKey()) + ", value: " + Uri.encode(entry.getValue().toString()));
        }
        TapjoyLog.i("TapjoyConnect", "hostURL: [" + getConnectFlagValue(TapjoyConnectFlag.SERVICE_URL) + Constants.RequestParameters.RIGHT_BRACKETS);
        TapjoyLog.i("TapjoyConnect", "redirectDomain: [" + Q + Constants.RequestParameters.RIGHT_BRACKETS);
        TapjoyLog.i("TapjoyConnect", "--------------------");
    }

    private static void j() {
        try {
            if (ad != null) {
                ApplicationInfo applicationInfo = ad.getApplicationInfo(g.getPackageName(), 128);
                if (applicationInfo == null || applicationInfo.metaData == null) {
                    TapjoyLog.d("TapjoyConnect", "No metadata present.");
                    return;
                }
                String[] strArr = TapjoyConnectFlag.FLAG_ARRAY;
                for (String str : strArr) {
                    String string = applicationInfo.metaData.getString("tapjoy." + str);
                    if (string != null) {
                        TapjoyLog.d("TapjoyConnect", "Found manifest flag: " + str + ", " + string);
                        a(str, string);
                    }
                }
                TapjoyLog.d("TapjoyConnect", "Metadata successfully loaded");
            }
        } catch (Exception e2) {
            TapjoyLog.e("TapjoyConnect", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, "Error reading manifest meta-data -- " + e2.toString()));
        }
    }

    private static void a(Properties properties) {
        Enumeration keys = properties.keys();
        while (keys.hasMoreElements()) {
            try {
                String str = (String) keys.nextElement();
                a(str, (String) properties.get(str));
            } catch (ClassCastException unused) {
                TapjoyLog.e("TapjoyConnect", "Error parsing configuration properties in tapjoy_config.txt");
            }
        }
    }

    private static void k() {
        try {
            List<ActivityInfo> asList = Arrays.asList(ad.getPackageInfo(g.getPackageName(), 1).activities);
            if (asList != null) {
                for (ActivityInfo activityInfo : asList) {
                    if (m.contains(activityInfo.name)) {
                        int indexOf = m.indexOf(activityInfo.name);
                        try {
                            Class.forName((String) m.get(indexOf));
                            Vector vector = new Vector();
                            if ((activityInfo.configChanges & 128) != 128) {
                                vector.add("orientation");
                            }
                            if ((activityInfo.configChanges & 32) != 32) {
                                vector.add("keyboardHidden");
                            }
                            if (vector.size() == 0) {
                                if (Build.VERSION.SDK_INT >= 13 && (activityInfo.configChanges & 1024) != 1024) {
                                    TapjoyLog.w("TapjoyConnect", "WARNING -- screenSize property is not specified in manifest configChanges for " + ((String) m.get(indexOf)));
                                }
                                if (Build.VERSION.SDK_INT >= 11 && activityInfo.name.equals("com.tapjoy.TJAdUnitActivity")) {
                                    if ((activityInfo.flags & 512) != 512) {
                                        throw new TapjoyIntegrationException("'hardwareAccelerated' property not specified in manifest for " + ((String) m.get(indexOf)));
                                    }
                                }
                                m.remove(indexOf);
                            } else if (vector.size() == 1) {
                                throw new TapjoyIntegrationException(vector.toString() + " property is not specified in manifest configChanges for " + ((String) m.get(indexOf)));
                            } else {
                                throw new TapjoyIntegrationException(vector.toString() + " properties are not specified in manifest configChanges for " + ((String) m.get(indexOf)));
                            }
                        } catch (ClassNotFoundException unused) {
                            throw new TapjoyIntegrationException("[ClassNotFoundException] Could not find dependency class " + ((String) m.get(indexOf)));
                        }
                    }
                }
            }
            if (m.size() == 0) {
                l();
                try {
                    try {
                        Class.forName("com.tapjoy.TJAdUnitJSBridge").getMethod(TJAdUnitConstants.String.CLOSE_REQUESTED, Boolean.class);
                        if (getConnectFlagValue(TapjoyConnectFlag.DISABLE_ADVERTISING_ID_CHECK) == null || !getConnectFlagValue(TapjoyConnectFlag.DISABLE_ADVERTISING_ID_CHECK).equals("true")) {
                            ae.checkGooglePlayIntegration();
                        } else {
                            TapjoyLog.i("TapjoyConnect", "Skipping integration check for Google Play Services and Advertising ID. Do this only if you do not have access to Google Play Services.");
                        }
                    } catch (NoSuchMethodException unused2) {
                        throw new TapjoyIntegrationException("Try configuring Proguard or other code obfuscators to ignore com.tapjoy classes. Visit http://dev.tapjoy.comfor more information.");
                    }
                } catch (ClassNotFoundException unused3) {
                    throw new TapjoyIntegrationException("ClassNotFoundException: com.tapjoy.TJAdUnitJSBridge was not found.");
                }
            } else if (m.size() == 1) {
                throw new TapjoyIntegrationException("Missing " + m.size() + " dependency class in manifest: " + m.toString());
            } else {
                throw new TapjoyIntegrationException("Missing " + m.size() + " dependency classes in manifest: " + m.toString());
            }
        } catch (Exception unused4) {
            throw new TapjoyIntegrationException("Error while getting package info.");
        }
    }

    private static void l() {
        Vector vector = new Vector();
        String[] strArr = TapjoyConstants.dependencyPermissions;
        for (String str : strArr) {
            if (!e(str)) {
                vector.add(str);
            }
        }
        if (vector.size() == 0) {
            Vector vector2 = new Vector();
            String[] strArr2 = TapjoyConstants.optionalPermissions;
            for (String str2 : strArr2) {
                if (!e(str2)) {
                    vector2.add(str2);
                }
            }
            if (vector2.size() == 0) {
                return;
            }
            if (vector2.size() == 1) {
                TapjoyLog.w("TapjoyConnect", "WARNING -- " + vector2.toString() + " permission was not found in manifest. The exclusion of this permission could cause problems.");
                return;
            }
            TapjoyLog.w("TapjoyConnect", "WARNING -- " + vector2.toString() + " permissions were not found in manifest. The exclusion of these permissions could cause problems.");
        } else if (vector.size() == 1) {
            throw new TapjoyIntegrationException("Missing 1 permission in manifest: " + vector.toString());
        } else {
            throw new TapjoyIntegrationException("Missing " + vector.size() + " permissions in manifest: " + vector.toString());
        }
    }

    private static boolean m() {
        String str = c;
        return str != null && str.length() > 0;
    }

    private static boolean n() {
        return getConnectFlagValue(TapjoyConnectFlag.ALLOW_LEGACY_ID_FALLBACK) != null && getConnectFlagValue(TapjoyConnectFlag.ALLOW_LEGACY_ID_FALLBACK).equals("true");
    }

    private static boolean o() {
        return (ae.isGooglePlayServicesAvailable() && ae.isGooglePlayManifestConfigured()) || getConnectFlagValue(TapjoyConnectFlag.DISABLE_ADVERTISING_ID_CHECK) == null || !getConnectFlagValue(TapjoyConnectFlag.DISABLE_ADVERTISING_ID_CHECK).equals("true");
    }

    private static boolean a(String str, boolean z2) {
        bn bnVar;
        Throwable th;
        IOException e2;
        RuntimeException e3;
        long j2;
        try {
            bn b2 = bn.b(str);
            try {
                Map d2 = b2.d();
                String a2 = jq.a((String) d2.get(TapjoyConstants.TJC_APP_GROUP_ID));
                String a3 = jq.a((String) d2.get("store"));
                String a4 = jq.a((String) d2.get(TapjoyConstants.TJC_ANALYTICS_API_KEY));
                String a5 = jq.a((String) d2.get(TapjoyConstants.TJC_MANAGED_DEVICE_ID));
                Object obj = d2.get("cache_max_age");
                fo foVar = new fo(a4);
                if (foVar.a == fo.a.RPC_ANALYTICS) {
                    String a6 = fo.a(foVar.b);
                    String str2 = foVar.c;
                    if (a2 == null) {
                        a2 = a6;
                    }
                    gz.a().a(g, a4, TapjoyConstants.TJC_LIBRARY_VERSION_NUMBER, TapjoyConfig.TJC_ANALYTICS_SERVICE_URL, a6, str2);
                    T = a2;
                    U = a3;
                    V = a4;
                    W = a5;
                    b2.close();
                    if (!z2) {
                        if (obj instanceof String) {
                            try {
                                j2 = Long.parseLong(((String) obj).trim());
                            } catch (NumberFormatException unused) {
                            }
                        } else {
                            if (obj instanceof Number) {
                                j2 = ((Number) obj).longValue();
                            }
                            j2 = 0;
                        }
                        if (j2 <= 0) {
                            TapjoyAppSettings.getInstance().removeConnectResult();
                        } else {
                            TapjoyAppSettings.getInstance().saveConnectResultAndParams(str, r(), (j2 * 1000) + v.b());
                        }
                        ga a7 = ga.a();
                        Object obj2 = d2.get(TapjoyConstants.PREF_SERVER_PROVIDED_CONFIGURATIONS);
                        if (obj2 instanceof Map) {
                            try {
                                a7.a.a((Map) obj2);
                                a7.c().edit().putString(TapjoyConstants.PREF_SERVER_PROVIDED_CONFIGURATIONS, bh.a(obj2)).apply();
                            } catch (Exception unused2) {
                            }
                        } else if (obj2 == null) {
                            a7.a.a((Map) null);
                            a7.c().edit().remove(TapjoyConstants.PREF_SERVER_PROVIDED_CONFIGURATIONS).apply();
                        }
                    }
                    jz.a(null);
                    return true;
                }
                throw new IOException("Invalid analytics_api_key");
            } catch (IOException e4) {
                e2 = e4;
                bnVar = b2;
                TapjoyLog.v("TapjoyConnect", e2.getMessage());
                jz.a(bnVar);
                return false;
            } catch (RuntimeException e5) {
                e3 = e5;
                bnVar = b2;
                TapjoyLog.v("TapjoyConnect", e3.getMessage());
                jz.a(bnVar);
                return false;
            } catch (Throwable th2) {
                th = th2;
                bnVar = b2;
                jz.a(bnVar);
                throw th;
            }
        } catch (IOException e6) {
            e2 = e6;
            bnVar = null;
            TapjoyLog.v("TapjoyConnect", e2.getMessage());
            jz.a(bnVar);
            return false;
        } catch (RuntimeException e7) {
            e3 = e7;
            bnVar = null;
            TapjoyLog.v("TapjoyConnect", e3.getMessage());
            jz.a(bnVar);
            return false;
        } catch (Throwable th3) {
            th = th3;
            jz.a(bnVar);
            throw th;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:1:0x0003 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r9v10, types: [com.tapjoy.internal.bn] */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean c(java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 142
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.TapjoyConnectCore.c(java.lang.String):boolean");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:1:0x0003 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r4v11, types: [com.tapjoy.internal.bn] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean d(java.lang.String r4) {
        /*
            java.lang.String r0 = "TapjoyConnect"
            r1 = 0
            com.tapjoy.internal.bn r4 = com.tapjoy.internal.bn.b(r4)     // Catch:{ IOException -> 0x0039, RuntimeException -> 0x002d, all -> 0x002b }
            boolean r2 = r4.a()     // Catch:{ IOException -> 0x0029, RuntimeException -> 0x0027 }
            if (r2 == 0) goto L_0x001d
            r4.s()     // Catch:{ IOException -> 0x0029, RuntimeException -> 0x0027 }
            java.lang.String r2 = "Successfully sent completed Pay-Per-Action to Tapjoy server."
            com.tapjoy.TapjoyLog.d(r0, r2)     // Catch:{ IOException -> 0x0029, RuntimeException -> 0x0027 }
            r4.close()     // Catch:{ IOException -> 0x0029, RuntimeException -> 0x0027 }
            com.tapjoy.internal.jz.a(r1)
            r4 = 1
            return r4
        L_0x001d:
            r4.close()
            com.tapjoy.internal.jz.a(r1)
            goto L_0x0047
        L_0x0024:
            r0 = move-exception
            r1 = r4
            goto L_0x0055
        L_0x0027:
            r1 = move-exception
            goto L_0x0031
        L_0x0029:
            r1 = move-exception
            goto L_0x003d
        L_0x002b:
            r0 = move-exception
            goto L_0x0055
        L_0x002d:
            r4 = move-exception
            r3 = r1
            r1 = r4
            r4 = r3
        L_0x0031:
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0024 }
            com.tapjoy.TapjoyLog.v(r0, r1)     // Catch:{ all -> 0x0024 }
            goto L_0x0044
        L_0x0039:
            r4 = move-exception
            r3 = r1
            r1 = r4
            r4 = r3
        L_0x003d:
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0024 }
            com.tapjoy.TapjoyLog.v(r0, r1)     // Catch:{ all -> 0x0024 }
        L_0x0044:
            com.tapjoy.internal.jz.a(r4)
        L_0x0047:
            com.tapjoy.TapjoyErrorMessage r4 = new com.tapjoy.TapjoyErrorMessage
            com.tapjoy.TapjoyErrorMessage$ErrorType r1 = com.tapjoy.TapjoyErrorMessage.ErrorType.SDK_ERROR
            java.lang.String r2 = "Completed Pay-Per-Action call failed."
            r4.<init>(r1, r2)
            com.tapjoy.TapjoyLog.e(r0, r4)
            r4 = 0
            return r4
        L_0x0055:
            com.tapjoy.internal.jz.a(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.TapjoyConnectCore.d(java.lang.String):boolean");
    }

    public void release() {
        i = null;
        j = null;
        TapjoyLog.d("TapjoyConnect", "Releasing core static instance.");
    }

    public static String getAppID() {
        return v;
    }

    public static String getLimitedAppID() {
        return aP;
    }

    public static String getUserID() {
        return C;
    }

    public static String getHostURL() {
        return getConnectFlagValue(TapjoyConnectFlag.SERVICE_URL);
    }

    public static String getPlacementURL() {
        return getConnectFlagValue(TapjoyConnectFlag.PLACEMENT_URL);
    }

    public static String getRedirectDomain() {
        return Q;
    }

    public static String getCarrierName() {
        return F;
    }

    public static String getConnectionType() {
        String str = "";
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) g.getSystemService("connectivity");
            if (!(connectivityManager == null || connectivityManager.getActiveNetworkInfo() == null)) {
                int type = connectivityManager.getActiveNetworkInfo().getType();
                str = (type == 1 || type == 6) ? "wifi" : TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE;
                TapjoyLog.d("TapjoyConnect", "connectivity: " + connectivityManager.getActiveNetworkInfo().getType());
                TapjoyLog.d("TapjoyConnect", "connection_type: " + str);
            }
        } catch (Exception e2) {
            TapjoyLog.e("TapjoyConnect", "getConnectionType error: " + e2.toString());
        }
        return str;
    }

    public static String getConnectionSubType() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) g.getSystemService("connectivity");
            if (connectivityManager == null) {
                return "";
            }
            String subtypeName = connectivityManager.getActiveNetworkInfo().getSubtypeName();
            TapjoyLog.d("TapjoyConnect", "connection_sub_type: " + subtypeName);
            return subtypeName;
        } catch (Exception e2) {
            TapjoyLog.e("TapjoyConnect", "getConnectionSubType error: " + e2.toString());
            return "";
        }
    }

    private static String p() {
        TapjoyLog.i("TapjoyConnect", "generating sessionID...");
        String str = null;
        try {
            str = TapjoyUtil.SHA256((System.currentTimeMillis() / 1000) + v);
            aa = System.currentTimeMillis();
            return str;
        } catch (Exception e2) {
            TapjoyLog.e("TapjoyConnect", "unable to generate session id: " + e2.toString());
            return str;
        }
    }

    public static Context getContext() {
        return g;
    }

    private static String q() {
        if (m()) {
            return c;
        }
        if (n() || !o()) {
            String str = p;
            boolean z2 = true;
            if (str != null && str.length() > 0) {
                return p;
            }
            String str2 = n;
            if (str2 == null || str2.length() <= 0) {
                z2 = false;
            }
            if (z2) {
                return n;
            }
        }
        TapjoyLog.e("TapjoyConnect", "Error -- no valid device identifier");
        return null;
    }

    private static String a(long j2) {
        try {
            return TapjoyUtil.SHA256(v + ":" + q() + ":" + j2 + ":" + M);
        } catch (Exception e2) {
            TapjoyErrorMessage.ErrorType errorType = TapjoyErrorMessage.ErrorType.SDK_ERROR;
            TapjoyLog.e("TapjoyConnect", new TapjoyErrorMessage(errorType, "Error in computing verifier value -- " + e2.toString()));
            return "";
        }
    }

    private static String b(long j2) {
        try {
            return TapjoyUtil.SHA256(aP + ":" + q() + ":" + j2 + ":" + aQ);
        } catch (Exception e2) {
            TapjoyErrorMessage.ErrorType errorType = TapjoyErrorMessage.ErrorType.SDK_ERROR;
            TapjoyLog.e("TapjoyConnect", new TapjoyErrorMessage(errorType, "Error in computing verifier value -- " + e2.toString()));
            return "";
        }
    }

    public static String getAwardCurrencyVerifier(long j2, int i2, String str) {
        try {
            return TapjoyUtil.SHA256(v + ":" + q() + ":" + j2 + ":" + M + ":" + i2 + ":" + str);
        } catch (Exception e2) {
            TapjoyErrorMessage.ErrorType errorType = TapjoyErrorMessage.ErrorType.SDK_ERROR;
            TapjoyLog.e("TapjoyConnect", new TapjoyErrorMessage(errorType, "Error in computing awardCurrencyVerifier -- " + e2.toString()));
            return "";
        }
    }

    public boolean isInitialized() {
        return this.ab;
    }

    public static void setPlugin(String str) {
        O = str;
    }

    public static void setSDKType(String str) {
        P = str;
    }

    public static void setUserID(String str, TJSetUserIDListener tJSetUserIDListener) {
        C = str;
        l = tJSetUserIDListener;
        TapjoyLog.d("TapjoyConnect", "URL parameters: " + getURLParams());
        new Thread(new Runnable() {
            /* class com.tapjoy.TapjoyConnectCore.AnonymousClass3 */

            public final void run() {
                TapjoyLog.i("TapjoyConnect", "Setting userID to " + TapjoyConnectCore.C);
                TapjoyURLConnection tapjoyURLConnection = TapjoyConnectCore.j;
                TapjoyHttpURLResponse responseFromURL = tapjoyURLConnection.getResponseFromURL(TapjoyConnectCore.getHostURL() + TapjoyConstants.TJC_USER_ID_URL_PATH, TapjoyConnectCore.getURLParams());
                TapjoyConnectCore.a(responseFromURL.response != null ? TapjoyConnectCore.a(responseFromURL.response) : false);
            }
        }).start();
    }

    public static void viewDidClose(String str) {
        TapjoyLog.d("TapjoyConnect", "viewDidClose: " + str);
        ag.remove(str);
        fs.e.notifyObservers();
    }

    public static void viewWillOpen(String str, int i2) {
        TapjoyLog.d("TapjoyConnect", "viewWillOpen: " + str);
        ag.put(str, Integer.valueOf(i2));
    }

    public static boolean isViewOpen() {
        TapjoyLog.d("TapjoyConnect", "isViewOpen: " + ag.size());
        return !ag.isEmpty();
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0010  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isFullScreenViewOpen() {
        /*
            java.util.Map r0 = com.tapjoy.TapjoyConnectCore.ag
            java.util.Collection r0 = r0.values()
            java.util.Iterator r0 = r0.iterator()
        L_0x000a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0022
            java.lang.Object r1 = r0.next()
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r2 = 1
            if (r1 == r2) goto L_0x0021
            r3 = 2
            if (r1 == r3) goto L_0x0021
            goto L_0x000a
        L_0x0021:
            return r2
        L_0x0022:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.TapjoyConnectCore.isFullScreenViewOpen():boolean");
    }

    public static void setViewShowing(boolean z2) {
        if (z2) {
            ag.put("", 1);
        } else {
            ag.clear();
        }
    }

    private static void a(String str, String str2) {
        if ((str.equals(TapjoyConnectFlag.SERVICE_URL) || str.equals(TapjoyConnectFlag.PLACEMENT_URL)) && !str2.endsWith("/")) {
            str2 = str2 + "/";
        }
        af.put(str, str2);
    }

    private static boolean e(String str) {
        return ad.checkPermission(str, g.getPackageName()) == 0;
    }

    public void actionComplete(String str) {
        TapjoyLog.i("TapjoyConnect", "actionComplete: " + str);
        Map f2 = f();
        TapjoyUtil.safePut(f2, "app_id", str, true);
        f2.putAll(getTimeStampAndVerifierParams());
        TapjoyLog.d("TapjoyConnect", "PPA URL parameters: " + f2);
        new Thread(new PPAThread(f2)).start();
    }

    public void completeConnectCall() {
        boolean z2;
        String connectResult;
        TapjoyLog.d("TapjoyConnect", "starting connect call...");
        String hostURL = getHostURL() != TapjoyConfig.TJC_SERVICE_URL ? getHostURL() : TapjoyConfig.TJC_CONNECT_SERVICE_URL;
        if (isConnected() || (connectResult = TapjoyAppSettings.getInstance().getConnectResult(r(), v.b())) == null || !a(connectResult, true)) {
            z2 = false;
        } else {
            TapjoyLog.i("TapjoyConnect", "Connect using stored connect result");
            ac = true;
            TJConnectListener tJConnectListener = k;
            if (tJConnectListener != null) {
                tJConnectListener.onConnectSuccess();
            }
            fs.a.notifyObservers();
            z2 = true;
        }
        TapjoyURLConnection tapjoyURLConnection = j;
        TapjoyHttpURLResponse responseFromURL = tapjoyURLConnection.getResponseFromURL(hostURL + TapjoyConstants.TJC_CONNECT_URL_PATH, (Map) null, (Map) null, getURLParams());
        if (responseFromURL == null || responseFromURL.statusCode != 200) {
            if (!z2) {
                d();
            }
            fs.b.notifyObservers(Boolean.FALSE);
        } else if (a(responseFromURL.response, false)) {
            TapjoyLog.i("TapjoyConnect", "Successfully connected to Tapjoy");
            ac = true;
            for (Map.Entry entry : getGenericURLParams().entrySet()) {
                TapjoyLog.d("TapjoyConnect", ((String) entry.getKey()) + ": " + ((String) entry.getValue()));
            }
            if (!z2) {
                TJConnectListener tJConnectListener2 = k;
                if (tJConnectListener2 != null) {
                    tJConnectListener2.onConnectSuccess();
                }
                fs.a.notifyObservers();
            }
            fs.b.notifyObservers(Boolean.TRUE);
        } else {
            if (!z2) {
                d();
            }
            fs.b.notifyObservers(Boolean.FALSE);
        }
    }

    public void completeLimitedConnectCall() {
        String hostURL = getHostURL() != TapjoyConfig.TJC_SERVICE_URL ? getHostURL() : TapjoyConfig.TJC_CONNECT_SERVICE_URL;
        Map limitedURLParams = getLimitedURLParams();
        TapjoyURLConnection tapjoyURLConnection = j;
        TapjoyHttpURLResponse responseFromURL = tapjoyURLConnection.getResponseFromURL(hostURL + TapjoyConstants.TJC_CONNECT_URL_PATH, (Map) null, (Map) null, limitedURLParams);
        if (responseFromURL == null || responseFromURL.statusCode != 200) {
            e();
            fs.b.notifyObservers(Boolean.FALSE);
        } else if (c(responseFromURL.response)) {
            TapjoyLog.i("TapjoyConnect", "Successfully connected to Tapjoy");
            aS = true;
            for (Map.Entry entry : getLimitedGenericURLParams().entrySet()) {
                TapjoyLog.d("TapjoyConnect", ((String) entry.getKey()) + ": " + ((String) entry.getValue()));
            }
            TJConnectListener tJConnectListener = aT;
            if (tJConnectListener != null) {
                tJConnectListener.onConnectSuccess();
            }
            fs.a.notifyObservers();
            fs.b.notifyObservers(Boolean.TRUE);
        } else {
            e();
            fs.b.notifyObservers(Boolean.FALSE);
        }
    }

    public class PPAThread implements Runnable {
        private Map b;

        public PPAThread(Map map) {
            this.b = map;
        }

        public void run() {
            TapjoyURLConnection tapjoyURLConnection = TapjoyConnectCore.j;
            TapjoyHttpURLResponse responseFromURL = tapjoyURLConnection.getResponseFromURL(TapjoyConnectCore.getHostURL() + TapjoyConstants.TJC_CONNECT_URL_PATH, (Map) null, (Map) null, this.b);
            if (responseFromURL.response != null) {
                TapjoyConnectCore.d(responseFromURL.response);
            }
        }
    }

    public void setCurrencyMultiplier(float f2) {
        TapjoyLog.i("TapjoyConnect", "setVirtualCurrencyMultiplier: " + f2);
        R = f2;
    }

    public float getCurrencyMultiplier() {
        return R;
    }

    public static String getConnectFlagValue(String str) {
        Hashtable hashtable = af;
        return (hashtable == null || hashtable.get(str) == null) ? "" : af.get(str).toString();
    }

    public static String getSecretKey() {
        return M;
    }

    public static String getAndroidID() {
        return n;
    }

    public static String getSha1MacAddress() {
        try {
            return TapjoyUtil.SHA1(p);
        } catch (Exception e2) {
            TapjoyLog.e("TapjoyConnect", "Error generating sha1 of macAddress: " + e2.toString());
            return null;
        }
    }

    public static String getMacAddress() {
        return p;
    }

    public static float getDeviceScreenDensityScale() {
        return A;
    }

    public static String getSupportURL(String str) {
        if (str == null) {
            str = v;
        }
        return getHostURL() + "support_requests/new?currency_id=" + str + "&app_id=" + v + "&udid=" + W + "&language_code=" + Locale.getDefault().getLanguage();
    }

    public static String getUserToken() {
        if (jq.c(C)) {
            return W;
        }
        return W + ":" + C;
    }

    public static boolean isConnected() {
        return ac;
    }

    public static boolean isLimitedConnected() {
        return aS;
    }

    public static boolean isUnitTestMode() {
        return getConnectFlagValue("unit_test_mode") == "true";
    }

    private static String r() {
        String str = v + w + x + c + q;
        try {
            return TapjoyUtil.SHA1(str);
        } catch (Exception unused) {
            return str;
        }
    }

    public static void setAdTrackingEnabled() {
        boolean z2;
        if (ge.a() != null) {
            ge a2 = ge.a();
            if (a2.c == null) {
                z2 = false;
            } else {
                z2 = a2.c.booleanValue();
            }
            if (z2) {
                d = false;
                return;
            }
        }
        TapjoyGpsHelper tapjoyGpsHelper = ae;
        if (tapjoyGpsHelper != null) {
            d = tapjoyGpsHelper.isAdTrackingEnabled();
        }
    }

    public static void setCustomParameter(String str) {
        D = str;
    }

    public static String getCustomParameter() {
        return D;
    }

    static /* synthetic */ void a() {
        if (!aU) {
            try {
                ae.loadAdvertisingId(!n());
                if (ae.isGooglePlayServicesAvailable() && ae.isGooglePlayManifestConfigured()) {
                    b = ae.getDeviceGooglePlayServicesVersion();
                    a = ae.getPackagedGooglePlayServicesVersion();
                }
                if (ae.isAdIdAvailable()) {
                    setAdTrackingEnabled();
                    c = ae.getAdvertisingId();
                    gz a2 = gz.a();
                    String str = c;
                    boolean z2 = !d;
                    hc hcVar = a2.f;
                    String a3 = hcVar.c.A.a();
                    hcVar.b.q = str;
                    hcVar.b.r = Boolean.valueOf(z2);
                    hcVar.c.A.a(str);
                    hcVar.c.B.a(z2);
                    hn.a(str, z2);
                    if (!jq.c(a3) && !str.equals(a3)) {
                        hcVar.c.a(false);
                    }
                }
            } catch (Exception e2) {
                TapjoyLog.i("TapjoyConnect", "Error fetching advertising id: " + e2.toString());
                e2.printStackTrace();
            }
            aU = true;
        }
    }

    static /* synthetic */ boolean a(String str) {
        Document buildDocument = TapjoyUtil.buildDocument(str);
        if (buildDocument == null) {
            return true;
        }
        String nodeTrimValue = TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("Success"));
        return nodeTrimValue != null && nodeTrimValue.equals("true");
    }

    static /* synthetic */ void a(boolean z2) {
        if (z2) {
            TapjoyLog.i("TapjoyConnect", "Set userID is successful");
            TJSetUserIDListener tJSetUserIDListener = l;
            if (tJSetUserIDListener != null) {
                tJSetUserIDListener.onSetUserIDSuccess();
                return;
            }
            return;
        }
        TapjoyLog.e("TapjoyConnect", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, "Failed to set userID"));
        TJSetUserIDListener tJSetUserIDListener2 = l;
        if (tJSetUserIDListener2 != null) {
            tJSetUserIDListener2.onSetUserIDFailure("Failed to set userID");
        }
    }
}
