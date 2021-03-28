package com.tapjoy.internal;

import com.tapjoy.internal.ew;
import java.util.Map;

public final class ik extends ii {
    private final ew.a c = new ew.a();
    private ey d = null;

    @Override // com.tapjoy.internal.ca
    public final String c() {
        return this.d == ey.USAGES ? "api/v1/usages" : "api/v1/cevs";
    }

    public final boolean a(ev evVar) {
        if (this.d == null) {
            this.d = evVar.n;
        } else if (evVar.n != this.d) {
            return false;
        }
        this.c.c.add(evVar);
        return true;
    }

    public final int g() {
        return this.c.c.size();
    }

    @Override // com.tapjoy.internal.ca, com.tapjoy.internal.ii
    public final Map e() {
        Map e = super.e();
        e.put("events", new bm(hp.a(this.c.b())));
        return e;
    }
}
