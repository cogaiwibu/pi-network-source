package com.tapjoy.internal;

import org.json.JSONException;
import org.json.JSONObject;

public final class db {
    private final boolean a = false;
    private final Float b = null;
    private final boolean c = false;
    private final da d;

    private db(da daVar) {
        this.d = daVar;
    }

    public static db a(da daVar) {
        Cdo.a(daVar, "Position is null");
        return new db(daVar);
    }

    /* access modifiers changed from: package-private */
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("skippable", this.a);
            if (this.a) {
                jSONObject.put("skipOffset", this.b);
            }
            jSONObject.put("autoPlay", this.c);
            jSONObject.put("position", this.d);
        } catch (JSONException e) {
            dn.a("VastProperties: JSON error", e);
        }
        return jSONObject;
    }
}
