package com.tapjoy.internal;

public final class cr {
    private final cz a;

    private cr(cz czVar) {
        this.a = czVar;
    }

    public static cr a(cs csVar) {
        cz czVar = (cz) csVar;
        Cdo.a(csVar, "AdSession is null");
        if (czVar.c.b == null) {
            Cdo.a(czVar);
            cr crVar = new cr(czVar);
            czVar.c.b = crVar;
            return crVar;
        }
        throw new IllegalStateException("AdEvents already exists for AdSession");
    }

    public final void a() {
        Cdo.a(this.a);
        if (cw.NATIVE == this.a.a.a) {
            if (!this.a.d()) {
                try {
                    this.a.a();
                } catch (Exception unused) {
                }
            }
            if (this.a.d()) {
                cz czVar = this.a;
                if (!czVar.g) {
                    dg.a().a(czVar.c.c(), "publishImpressionEvent", new Object[0]);
                    czVar.g = true;
                    return;
                }
                throw new IllegalStateException("Impression event can only be sent once");
            }
            return;
        }
        throw new IllegalStateException("Impression event is not expected from the Native AdSession");
    }
}
