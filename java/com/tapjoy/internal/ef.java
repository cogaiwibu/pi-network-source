package com.tapjoy.internal;

import com.tapjoy.internal.ej;

public abstract class ef extends ej {
    public abstract em a(int i);

    @Override // com.tapjoy.internal.ej
    public final /* bridge */ /* synthetic */ int a(Object obj) {
        return el.a(((em) obj).a());
    }

    @Override // com.tapjoy.internal.ej
    public final /* synthetic */ void a(el elVar, Object obj) {
        elVar.c(((em) obj).a());
    }

    protected ef(Class cls) {
        super(eg.VARINT, cls);
    }

    @Override // com.tapjoy.internal.ej
    public final /* synthetic */ Object a(ek ekVar) {
        int d = ekVar.d();
        em a = a(d);
        if (a != null) {
            return a;
        }
        throw new ej.a(d, this.a);
    }
}
