package com.tapjoy.internal;

import android.os.Build;
import android.webkit.WebView;
import com.ironsource.sdk.constants.Constants;
import com.tapjoy.TapjoyConstants;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class ds {
    public dr a = new dr(null);
    public cr b;
    public dc c;
    public int d;
    public long e;

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    public static final class a extends Enum {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        private static final /* synthetic */ int[] d = {1, 2, 3};
    }

    public ds() {
        d();
    }

    public void a() {
    }

    /* access modifiers changed from: package-private */
    public final void a(WebView webView) {
        this.a = new dr(webView);
    }

    public final void a(String str) {
        dg.a().a(c(), str, (JSONObject) null);
    }

    public final void a(String str, JSONObject jSONObject) {
        dg.a().a(c(), str, jSONObject);
    }

    public void b() {
        this.a.clear();
    }

    public final WebView c() {
        return (WebView) this.a.get();
    }

    public final void a(cz czVar, cu cuVar) {
        String str = czVar.f;
        JSONObject jSONObject = new JSONObject();
        dm.a(jSONObject, "environment", TapjoyConstants.TJC_APP_PLACEMENT);
        dm.a(jSONObject, "adSessionType", cuVar.f);
        JSONObject jSONObject2 = new JSONObject();
        dm.a(jSONObject2, "deviceType", Build.MANUFACTURER + "; " + Build.MODEL);
        dm.a(jSONObject2, "osVersion", Integer.toString(Build.VERSION.SDK_INT));
        dm.a(jSONObject2, "os", Constants.JAVASCRIPT_INTERFACE_NAME);
        dm.a(jSONObject, "deviceInfo", jSONObject2);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        dm.a(jSONObject, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        dm.a(jSONObject3, "partnerName", cuVar.a.a);
        dm.a(jSONObject3, "partnerVersion", cuVar.a.b);
        dm.a(jSONObject, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        dm.a(jSONObject4, "libraryVersion", "1.2.19-Tapjoy");
        dm.a(jSONObject4, "appId", df.a().a.getApplicationContext().getPackageName());
        dm.a(jSONObject, TapjoyConstants.TJC_APP_PLACEMENT, jSONObject4);
        if (cuVar.e != null) {
            dm.a(jSONObject, "customReferenceData", cuVar.e);
        }
        JSONObject jSONObject5 = new JSONObject();
        for (cy cyVar : Collections.unmodifiableList(cuVar.c)) {
            dm.a(jSONObject5, cyVar.a, cyVar.c);
        }
        dg.a().a(c(), "startSession", str, jSONObject, jSONObject5);
    }

    public final void a(float f) {
        dg.a().a(c(), "setDeviceVolume", Float.valueOf(f));
    }

    public final void d() {
        this.e = System.nanoTime();
        this.d = a.a;
    }
}
