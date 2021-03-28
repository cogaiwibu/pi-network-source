package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.TapjoyConstants;

public final class ge {
    private static final ge e;
    private static ge f;
    public Boolean a = null;
    public String b = null;
    public Boolean c = null;
    public boolean d = false;
    private Context g;

    static {
        ge geVar = new ge();
        e = geVar;
        f = geVar;
    }

    public static ge a() {
        return f;
    }

    public final synchronized void a(Context context) {
        if (context != null) {
            if (this.g == null) {
                this.g = context;
            }
        }
        ge geVar = f;
        if (geVar.g != null) {
            SharedPreferences sharedPreferences = geVar.g.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0);
            if (geVar.a == null && sharedPreferences.contains("gdpr")) {
                geVar.a = Boolean.valueOf(sharedPreferences.getBoolean("gdpr", false));
            }
            if (geVar.b == null) {
                geVar.b = sharedPreferences.getString("cgdpr", "");
            }
            if (geVar.c == null && sharedPreferences.contains(TapjoyConstants.PREF_BELOW_CONSENT_AGE)) {
                geVar.c = Boolean.valueOf(sharedPreferences.getBoolean(TapjoyConstants.PREF_BELOW_CONSENT_AGE, false));
            }
        }
        if (this.d) {
            this.d = false;
            ge geVar2 = f;
            if (geVar2.g != null) {
                if (geVar2.a != null) {
                    geVar2.b();
                }
                if (geVar2.b != null) {
                    geVar2.c();
                }
                if (geVar2.c != null) {
                    geVar2.d();
                }
            }
        }
    }

    public final boolean b() {
        Context context = this.g;
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0).edit();
        edit.putBoolean("gdpr", this.a.booleanValue());
        edit.apply();
        return true;
    }

    public final boolean c() {
        Context context = this.g;
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0).edit();
        edit.putString("cgdpr", this.b);
        edit.apply();
        return true;
    }

    public final boolean d() {
        Context context = this.g;
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0).edit();
        edit.putBoolean(TapjoyConstants.PREF_BELOW_CONSENT_AGE, this.c.booleanValue());
        edit.apply();
        TapjoyConnectCore.setAdTrackingEnabled();
        return true;
    }
}
