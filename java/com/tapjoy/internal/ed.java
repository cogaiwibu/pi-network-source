package com.tapjoy.internal;

import com.tapjoy.internal.dy;
import org.json.JSONObject;

public final class ed implements dy.b {
    final dz a;
    private JSONObject b;

    public ed(dz dzVar) {
        this.a = dzVar;
    }

    @Override // com.tapjoy.internal.dy.b
    public final JSONObject a() {
        return this.b;
    }

    @Override // com.tapjoy.internal.dy.b
    public final void a(JSONObject jSONObject) {
        this.b = jSONObject;
    }

    public final void b() {
        this.a.a(new ea(this));
    }
}
