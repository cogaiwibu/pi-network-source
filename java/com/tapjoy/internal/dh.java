package com.tapjoy.internal;

import com.tapjoy.internal.de;
import java.util.Collections;

public final class dh implements co, de.a {
    private static dh c;
    public float a = 0.0f;
    public cp b;
    private final cq d;
    private final cn e;
    private dd f;

    private dh(cq cqVar, cn cnVar) {
        this.d = cqVar;
        this.e = cnVar;
    }

    public static dh a() {
        if (c == null) {
            c = new dh(new cq(), new cn());
        }
        return c;
    }

    @Override // com.tapjoy.internal.de.a
    public final void a(boolean z) {
        dv.a();
        if (z) {
            dv.b();
        } else {
            dv.c();
        }
    }

    @Override // com.tapjoy.internal.co
    public final void a(float f2) {
        this.a = f2;
        if (this.f == null) {
            this.f = dd.a();
        }
        for (cz czVar : Collections.unmodifiableCollection(this.f.b)) {
            czVar.c.a(f2);
        }
    }
}
