package com.tapjoy.internal;

import android.app.Activity;
import android.app.Notification;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Build;
import com.facebook.react.views.scroll.ReactScrollViewHelper;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.tapjoy.FiveRocksIntegration;
import com.tapjoy.TJAdUnit;
import com.tapjoy.TJAwardCurrencyListener;
import com.tapjoy.TJConnectListener;
import com.tapjoy.TJCurrency;
import com.tapjoy.TJEarnedCurrencyListener;
import com.tapjoy.TJEventOptimizer;
import com.tapjoy.TJGetCurrencyBalanceListener;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJPlacementManager;
import com.tapjoy.TJSetUserIDListener;
import com.tapjoy.TJSpendCurrencyListener;
import com.tapjoy.TJVideoListener;
import com.tapjoy.TapjoyAppSettings;
import com.tapjoy.TapjoyCache;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.TapjoyConnectFlag;
import com.tapjoy.TapjoyConstants;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.TapjoyException;
import com.tapjoy.TapjoyIntegrationException;
import com.tapjoy.TapjoyLog;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* access modifiers changed from: package-private */
public class es extends er {
    private boolean c = false;
    private String d = "";
    private TJCurrency e = null;
    private TapjoyCache f = null;

    @Override // com.tapjoy.internal.er
    public final String b() {
        return TapjoyConstants.TJC_LIBRARY_VERSION_NUMBER;
    }

    es() {
    }

    @Override // com.tapjoy.internal.er
    public final void a(boolean z) {
        TapjoyLog.setDebugEnabled(z);
    }

    @Override // com.tapjoy.internal.er
    public final boolean a(Context context, String str) {
        return a(context, str, (Hashtable) null, (TJConnectListener) null);
    }

    @Override // com.tapjoy.internal.er
    public synchronized boolean a(final Context context, String str, Hashtable hashtable, final TJConnectListener tJConnectListener) {
        String valueOf;
        if (hashtable != null) {
            Object obj = hashtable.get(TapjoyConnectFlag.ENABLE_LOGGING);
            if (obj != null) {
                TapjoyLog.setDebugEnabled("true".equals(obj.toString()));
            }
        }
        TapjoyConnectCore.setSDKType("event");
        boolean z = false;
        if (context == null) {
            TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "The application context is NULL"));
            if (tJConnectListener != null) {
                tJConnectListener.onConnectFailure();
            }
            return false;
        } else if (jq.c(str)) {
            TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "The SDK key is NULL. A valid SDK key is required to connect successfully to Tapjoy"));
            if (tJConnectListener != null) {
                tJConnectListener.onConnectFailure();
            }
            return false;
        } else {
            FiveRocksIntegration.a();
            try {
                TapjoyAppSettings.init(context);
                TapjoyConnectCore.requestTapjoyConnect(context, str, hashtable, new TJConnectListener() {
                    /* class com.tapjoy.internal.es.AnonymousClass1 */

                    @Override // com.tapjoy.TJConnectListener
                    public final void onConnectSuccess() {
                        es.this.e = new TJCurrency(context);
                        es.this.f = new TapjoyCache(context);
                        try {
                            TJEventOptimizer.init(context);
                            es.this.a = true;
                            TJConnectListener tJConnectListener = tJConnectListener;
                            if (tJConnectListener != null) {
                                tJConnectListener.onConnectSuccess();
                            }
                        } catch (InterruptedException unused) {
                            onConnectFailure();
                        } catch (RuntimeException e) {
                            TapjoyLog.w("TapjoyAPI", e.getMessage());
                            onConnectFailure();
                        }
                    }

                    @Override // com.tapjoy.TJConnectListener
                    public final void onConnectFailure() {
                        TJConnectListener tJConnectListener = tJConnectListener;
                        if (tJConnectListener != null) {
                            tJConnectListener.onConnectFailure();
                        }
                    }
                });
                this.c = true;
                if (Build.VERSION.SDK_INT < 14) {
                    TapjoyLog.i("TapjoyAPI", "Automatic session tracking is not available on this device.");
                } else {
                    if (!(hashtable == null || (valueOf = String.valueOf(hashtable.get(TapjoyConnectFlag.DISABLE_AUTOMATIC_SESSION_TRACKING))) == null || !valueOf.equalsIgnoreCase("true"))) {
                        z = true;
                    }
                    if (!z) {
                        fl.a(context);
                    } else {
                        TapjoyLog.i("TapjoyAPI", "Automatic session tracking is disabled.");
                    }
                }
                return true;
            } catch (TapjoyIntegrationException e2) {
                TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, e2.getMessage()));
                if (tJConnectListener != null) {
                    tJConnectListener.onConnectFailure();
                }
                return false;
            } catch (TapjoyException e3) {
                TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, e3.getMessage()));
                if (tJConnectListener != null) {
                    tJConnectListener.onConnectFailure();
                }
                return false;
            }
        }
    }

    @Override // com.tapjoy.internal.er
    public final synchronized boolean a(final Context context, String str, final TJConnectListener tJConnectListener) {
        TapjoyConnectCore.setSDKType("event");
        if (context == null) {
            TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "The application context is NULL"));
            if (tJConnectListener != null) {
                tJConnectListener.onConnectFailure();
            }
            return false;
        } else if (jq.c(str)) {
            TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "The limited SDK key is NULL. A valid limited SDK key is required to connect successfully to Tapjoy"));
            if (tJConnectListener != null) {
                tJConnectListener.onConnectFailure();
            }
            return false;
        } else {
            try {
                TapjoyConnectCore.requestLimitedTapjoyConnect(context, str, new TJConnectListener() {
                    /* class com.tapjoy.internal.es.AnonymousClass2 */

                    @Override // com.tapjoy.TJConnectListener
                    public final void onConnectSuccess() {
                        es.this.f = new TapjoyCache(context);
                        es.this.b = true;
                        TJConnectListener tJConnectListener = tJConnectListener;
                        if (tJConnectListener != null) {
                            tJConnectListener.onConnectSuccess();
                        }
                    }

                    @Override // com.tapjoy.TJConnectListener
                    public final void onConnectFailure() {
                        TJConnectListener tJConnectListener = tJConnectListener;
                        if (tJConnectListener != null) {
                            tJConnectListener.onConnectFailure();
                        }
                    }
                });
                return true;
            } catch (TapjoyIntegrationException e2) {
                TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, e2.getMessage()));
                if (tJConnectListener != null) {
                    tJConnectListener.onConnectFailure();
                }
                return false;
            } catch (TapjoyException e3) {
                TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, e3.getMessage()));
                if (tJConnectListener != null) {
                    tJConnectListener.onConnectFailure();
                }
                return false;
            }
        }
    }

    @Override // com.tapjoy.internal.er
    public final TJPlacement a(String str, TJPlacementListener tJPlacementListener) {
        return TJPlacementManager.a(str, "", "", tJPlacementListener);
    }

    @Override // com.tapjoy.internal.er
    public final TJPlacement b(String str, TJPlacementListener tJPlacementListener) {
        return TJPlacementManager.b(str, "", "", tJPlacementListener);
    }

    @Override // com.tapjoy.internal.er
    public final void a(Activity activity) {
        if (activity != null) {
            b.a(activity);
        } else {
            TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "Cannot set activity to NULL"));
        }
    }

    @Override // com.tapjoy.internal.er
    public final void a(float f2) {
        if (l("setCurrencyMultiplier")) {
            TapjoyConnectCore.getInstance().setCurrencyMultiplier(f2);
        }
    }

    @Override // com.tapjoy.internal.er
    public final float c() {
        if (l("getCurrencyMultiplier")) {
            return TapjoyConnectCore.getInstance().getCurrencyMultiplier();
        }
        return 1.0f;
    }

    @Override // com.tapjoy.internal.er
    public final void e(String str) {
        if (k("actionComplete")) {
            TapjoyConnectCore.getInstance().actionComplete(str);
        }
    }

    @Override // com.tapjoy.internal.er
    public final void a(TJGetCurrencyBalanceListener tJGetCurrencyBalanceListener) {
        if (this.e != null && k("getCurrencyBalance")) {
            this.e.getCurrencyBalance(tJGetCurrencyBalanceListener);
        }
    }

    @Override // com.tapjoy.internal.er
    public final void a(int i, TJSpendCurrencyListener tJSpendCurrencyListener) {
        if (this.e != null && k("spendCurrency")) {
            this.e.spendCurrency(i, tJSpendCurrencyListener);
        }
    }

    @Override // com.tapjoy.internal.er
    public final void a(int i, TJAwardCurrencyListener tJAwardCurrencyListener) {
        if (this.e != null && k("awardCurrency")) {
            this.e.awardCurrency(i, tJAwardCurrencyListener);
        }
    }

    @Override // com.tapjoy.internal.er
    public final void a(TJEarnedCurrencyListener tJEarnedCurrencyListener) {
        if (this.e != null && k("setEarnedCurrencyListener")) {
            this.e.setEarnedCurrencyListener(tJEarnedCurrencyListener);
        }
    }

    @Override // com.tapjoy.internal.er
    public final void a(TJVideoListener tJVideoListener) {
        if (l("setVideoListener")) {
            TJAdUnit.a = tJVideoListener;
        }
    }

    @Override // com.tapjoy.internal.er
    public final void a(String str, String str2, String str3, String str4) {
        gn.a(str, str2, str3, str4);
    }

    @Override // com.tapjoy.internal.er
    public final void a(String str, String str2) {
        gn.a(str, null, null, str2);
    }

    @Override // com.tapjoy.internal.er
    public final void a(String str) {
        gn.a(null, str, null, null, 0);
    }

    @Override // com.tapjoy.internal.er
    public final void a(String str, long j) {
        gn.a(null, str, null, null, j);
    }

    @Override // com.tapjoy.internal.er
    public final void a(String str, String str2, long j) {
        gn.a(str, str2, null, null, j);
    }

    @Override // com.tapjoy.internal.er
    public final void b(String str, String str2, String str3, String str4) {
        gn.a(str, str2, str3, str4, 0);
    }

    @Override // com.tapjoy.internal.er
    public final void a(String str, String str2, String str3, String str4, long j) {
        gn.a(str, str2, str3, str4, j);
    }

    @Override // com.tapjoy.internal.er
    public final void a(String str, String str2, String str3, String str4, String str5, long j) {
        gn.a(str, str2, str3, str4, str5, j, null, 0, null, 0);
    }

    @Override // com.tapjoy.internal.er
    public final void a(String str, String str2, String str3, String str4, String str5, long j, String str6, long j2) {
        gn.a(str, str2, str3, str4, str5, j, str6, j2, null, 0);
    }

    @Override // com.tapjoy.internal.er
    public final void a(String str, String str2, String str3, String str4, String str5, long j, String str6, long j2, String str7, long j3) {
        gn.a(str, str2, str3, str4, str5, j, str6, j2, str7, j3);
    }

    @Override // com.tapjoy.internal.er
    public final void d() {
        if (l("startSession")) {
            if (Build.VERSION.SDK_INT >= 14) {
                fl.a();
            }
            TapjoyConnectCore.getInstance().appResume();
            gn.a();
        }
    }

    @Override // com.tapjoy.internal.er
    public final void e() {
        if (l("endSession")) {
            if (Build.VERSION.SDK_INT >= 14) {
                fl.a();
            }
            gz.a().n = false;
            TapjoyConnectCore.getInstance().appPause();
            gn.b();
        }
    }

    @Override // com.tapjoy.internal.er
    public final void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 14) {
            fl.a();
        }
        gz.a().n = true;
        gn.a(activity);
    }

    @Override // com.tapjoy.internal.er
    public final void c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 14) {
            fl.a();
        }
        gn.b(activity);
    }

    @Override // com.tapjoy.internal.er
    public final void a(String str, TJSetUserIDListener tJSetUserIDListener) {
        if (l("setUserID")) {
            TapjoyConnectCore.setUserID(str, tJSetUserIDListener);
            gz a = gz.a();
            if (a.d("setUserId")) {
                a.f.b(gu.a(str));
            }
        } else if (tJSetUserIDListener != null) {
            tJSetUserIDListener.onSetUserIDFailure(this.d);
        }
    }

    @Override // com.tapjoy.internal.er
    public final void j(String str) {
        TapjoyConnectCore.setCustomParameter(str);
    }

    @Override // com.tapjoy.internal.er
    public final String l() {
        return TapjoyConnectCore.getCustomParameter();
    }

    @Override // com.tapjoy.internal.er
    public final Set f() {
        return gz.a().c();
    }

    @Override // com.tapjoy.internal.er
    public final void a(Set set) {
        gz.a().a(set);
    }

    @Override // com.tapjoy.internal.er
    public final void g() {
        gz.a().a((Set) null);
    }

    @Override // com.tapjoy.internal.er
    public final void c(String str) {
        if (!jq.c(str)) {
            gz a = gz.a();
            Set c2 = a.c();
            if (c2.add(str)) {
                a.a(c2);
            }
        }
    }

    @Override // com.tapjoy.internal.er
    public final void d(String str) {
        if (!jq.c(str)) {
            gz a = gz.a();
            Set c2 = a.c();
            if (c2.remove(str)) {
                a.a(c2);
            }
        }
    }

    @Override // com.tapjoy.internal.er
    public final boolean h() {
        gz a = gz.a();
        if (!a.d("isPushNotificationDisabled")) {
            return false;
        }
        boolean f2 = a.f.f();
        gw.a("isPushNotificationDisabled = {}", Boolean.valueOf(f2));
        return f2;
    }

    @Override // com.tapjoy.internal.er
    public final void b(boolean z) {
        String str;
        Object[] objArr;
        String str2;
        gz a = gz.a();
        if (a.d("setPushNotificationDisabled")) {
            boolean a2 = a.f.a(z);
            char c2 = 0;
            String str3 = "setPushNotificationDisabled({}) called, but it is already {}";
            if (a2) {
                objArr = new Object[1];
                str = Boolean.valueOf(z);
                str3 = "setPushNotificationDisabled({}) called";
            } else {
                Object[] objArr2 = new Object[2];
                objArr2[0] = Boolean.valueOf(z);
                str = z ? "disabled" : "enabled";
                objArr = objArr2;
                c2 = 1;
            }
            objArr[c2] = str;
            gw.a(str3, objArr);
            if (a2 && a.k && !jq.c(a.d)) {
                if (a.o != null) {
                    str2 = null;
                } else {
                    hb b = hb.b(a.e);
                    str2 = jq.b(b.b.b(b.a));
                }
                a.a(str2);
            }
        }
    }

    @Override // com.tapjoy.internal.er
    public final boolean i() {
        return this.a;
    }

    @Override // com.tapjoy.internal.er
    public final boolean j() {
        return this.b;
    }

    @Override // com.tapjoy.internal.er
    public final String g(String str) {
        if (k("getSupportURL")) {
            return TapjoyConnectCore.getSupportURL(str);
        }
        return null;
    }

    @Override // com.tapjoy.internal.er
    public final String k() {
        return TapjoyConnectCore.getUserToken();
    }

    @Override // com.tapjoy.internal.er
    public final void i(String str) {
        gz.a().a(str);
    }

    @Override // com.tapjoy.internal.er
    public final void a(Context context, Map map) {
        gz a = gz.a();
        if (a.e == null) {
            a.b(context);
        }
        hb.b(a.e);
        Context context2 = a.e;
        String str = (String) map.get("fiverocks");
        if (str == null) {
            return;
        }
        if (hc.a(context2).f()) {
            gz.a(context2).b(str);
            return;
        }
        String str2 = (String) map.get("title");
        String str3 = (String) map.get("message");
        if (str3 != null) {
            String str4 = (String) map.get("rich");
            String str5 = (String) map.get("sound");
            String str6 = (String) map.get(MessengerShareContentUtility.ATTACHMENT_PAYLOAD);
            String str7 = (String) map.get(ReactScrollViewHelper.OVER_SCROLL_ALWAYS);
            boolean z = "true".equals(str7) || Boolean.TRUE.equals(str7);
            String str8 = (String) map.get("repeatable");
            boolean z2 = "true".equals(str8) || Boolean.TRUE.equals(str8);
            String str9 = (String) map.get(IronSourceConstants.EVENTS_PLACEMENT_NAME);
            int b = hb.b(map.get("nid"));
            String str10 = (String) map.get("channel_id");
            if (z || !gz.a(context2).d()) {
                Notification a2 = hb.a(context2, str, jq.a(str2), str3, hb.a((Object) str4), hb.a((Object) str5), str6, str9, b, str10);
                if (gz.a(context2).a(context2, str, z2)) {
                    hb.a(context2, b, a2);
                }
            }
        }
    }

    private boolean k(String str) {
        if (this.a) {
            return true;
        }
        TapjoyLog.w("TapjoyAPI", "Can not call " + str + " because Tapjoy SDK has not successfully connected.");
        return false;
    }

    private boolean l(String str) {
        if (this.c) {
            return true;
        }
        this.d = "Can not call " + str + " because Tapjoy SDK is not initialized.";
        TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, this.d));
        return false;
    }

    @Override // com.tapjoy.internal.er
    public final void c(boolean z) {
        ge a = ge.a();
        a.a = Boolean.valueOf(z);
        if (!a.b()) {
            a.d = true;
        }
    }

    @Override // com.tapjoy.internal.er
    public final void h(String str) {
        ge a = ge.a();
        if (!al.a(str)) {
            a.b = str;
            if (!a.c()) {
                a.d = true;
            }
        }
    }

    @Override // com.tapjoy.internal.er
    public final void d(boolean z) {
        ge a = ge.a();
        a.c = Boolean.valueOf(z);
        if (!a.d()) {
            a.d = true;
        }
    }

    @Override // com.tapjoy.internal.er
    public final void a(String str, String str2, double d2, String str3) {
        String a;
        String a2;
        gz a3 = gz.a();
        if (a3.c("trackPurchase") && (a = gu.a(str, "trackPurchase", "productId")) != null && (a2 = gu.a(str2, "trackPurchase", "currencyCode")) != null) {
            if (a2.length() != 3) {
                gw.a("trackPurchase", "currencyCode", "invalid currency code");
                return;
            }
            a3.g.a(a, a2.toUpperCase(Locale.US), d2, (String) null, (String) null, gu.b(str3));
            gw.a("trackPurchase called");
        }
    }

    @Override // com.tapjoy.internal.er
    public final void a(String str, String str2, String str3, String str4, Map map) {
        gz a = gz.a();
        if (a.c("trackEvent") && !jq.c(str2)) {
            LinkedHashMap b = ju.b();
            if (map != null && map.size() > 0) {
                for (Map.Entry entry : map.entrySet()) {
                    Object key = entry.getKey();
                    if (key == null) {
                        if (gw.a) {
                            x.a("Tapjoy", "{}: {} must not be null", "trackEvent", "key in values map");
                            return;
                        }
                        return;
                    } else if (key instanceof String) {
                        String a2 = gu.a((String) key, "trackEvent", "key in values map");
                        if (a2 != null) {
                            Object value = entry.getValue();
                            if (value instanceof Number) {
                                b.put(a2, Long.valueOf(((Number) value).longValue()));
                            } else {
                                gw.a("trackEvent", "value in values map", "must be a long");
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
            }
            a.g.a(str, str2, str3, str4, b);
            gw.a("trackEvent category:{}, name:{}, p1:{}, p2:{}, values:{} called", str, str2, str3, str4, b);
        }
    }

    @Override // com.tapjoy.internal.er
    public final void a(int i) {
        gz a = gz.a();
        if (a.d("setUserLevel")) {
            gw.a("setUserLevel({}) called", Integer.valueOf(i));
            a.f.a(i >= 0 ? Integer.valueOf(i) : null);
        }
    }

    @Override // com.tapjoy.internal.er
    public final void b(int i) {
        gz a = gz.a();
        if (a.d("setUserFriendCount")) {
            gw.a("setUserFriendCount({}) called", Integer.valueOf(i));
            a.f.b(i >= 0 ? Integer.valueOf(i) : null);
        }
    }

    @Override // com.tapjoy.internal.er
    public final void b(String str) {
        gz a = gz.a();
        if (a.d("setAppDataVersion")) {
            a.f.a(gu.a(str));
        }
    }

    @Override // com.tapjoy.internal.er
    public final void a(int i, String str) {
        gz a = gz.a();
        if (a.d("setUserCohortVariable")) {
            boolean z = i > 0 && i <= 5;
            if (gw.a && !z) {
                gw.b("setCohortVariable: variableIndex is out of range");
            }
            if (z) {
                gw.a("setUserCohortVariable({}, {}) called", Integer.valueOf(i), str);
                a.f.a(i, gu.a(str));
            }
        }
    }

    @Override // com.tapjoy.internal.er
    public final void f(String str) {
        gz a = gz.a();
        gw.a("setGcmSender({}) called", str);
        a.d = jq.a(str);
        a.b();
    }

    @Override // com.tapjoy.internal.er
    public final void a(GLSurfaceView gLSurfaceView) {
        gz.a();
        gz.a(gLSurfaceView);
    }
}
