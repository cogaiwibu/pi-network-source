package com.tapjoy.internal;

import javax.annotation.Nullable;

public final class cc implements Runnable {
    private final ca a;
    @Nullable
    private final cf b;

    protected cc(ca caVar, @Nullable cf cfVar) {
        this.a = caVar;
        this.b = cfVar;
    }

    public final void run() {
        try {
            Object f = this.a.f();
            cf cfVar = this.b;
            if (cfVar != null && !(cfVar instanceof cg)) {
                cfVar.a(this.a, f);
            }
        } catch (Throwable unused) {
            cf cfVar2 = this.b;
            if (cfVar2 != null && !(cfVar2 instanceof cg)) {
                cfVar2.a(this.a);
            }
        }
    }
}
