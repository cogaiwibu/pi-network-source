package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.tapjoy.TapjoyConstants;
import java.io.File;
import java.io.IOException;

public final class hj {
    public final o A = new o(this.b, "idfa");
    public final h B = new h(this.b, "idfa.optout");
    final h C = new h(this.b, "push.optout");
    final o D = new o(this.b, "appId");
    final Context a;
    final SharedPreferences b;
    final o c;
    final o d = new o(this.b, "ir");
    final k e = new k(this.b, "fql", 0);
    final k f = new k(this.b, "fq", 0);
    final o g = new o(this.b, "push");
    final k h = new k(this.b, "ss", 0);
    final l i = new l(this.b, "std");
    final l j = new l(this.b, "slt");
    final l k = new l(this.b, "sld");
    final o l = new o(this.b, "ptc");
    final k m = new k(this.b, "pc", 0);
    final i n = new i(this.b, "ptp");
    final l o = new l(this.b, "lpt");
    final i p = new i(this.b, "plp");
    final o q = new o(this.b, "adv");
    final o r = new o(this.b, "ui");
    final k s = new k(this.b, "ul", -1);
    final k t = new k(this.b, "uf", -1);
    final o u = new o(this.b, TapjoyConstants.TJC_USER_VARIABLE_1);
    final o v = new o(this.b, TapjoyConstants.TJC_USER_VARIABLE_2);
    final o w = new o(this.b, TapjoyConstants.TJC_USER_VARIABLE_3);
    final o x = new o(this.b, TapjoyConstants.TJC_USER_VARIABLE_4);
    final o y = new o(this.b, TapjoyConstants.TJC_USER_VARIABLE_5);
    final o z = new o(this.b, "utags");

    public static hj a(Context context) {
        return new hj(context);
    }

    private hj(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("fiverocks", 0);
        this.b = sharedPreferences;
        this.c = new o(sharedPreferences, "sdk");
    }

    /* access modifiers changed from: package-private */
    public final SharedPreferences.Editor a() {
        return this.b.edit();
    }

    public final String b() {
        String string = this.b.getString("ir", null);
        if (string == null) {
            File file = new File(gz.c(this.a), TapjoyConstants.TJC_REFERRER);
            if (file.exists()) {
                try {
                    string = bg.a(file, ak.c);
                } catch (IOException unused) {
                }
            }
            this.b.edit().putString("ir", string != null ? string : "").apply();
            if (string == null || string.length() <= 0) {
                return null;
            }
            return string;
        } else if (string.length() > 0) {
            return string;
        } else {
            return null;
        }
    }

    public final void a(boolean z2) {
        n.a(this.b, "gcm.onServer", z2);
    }
}
