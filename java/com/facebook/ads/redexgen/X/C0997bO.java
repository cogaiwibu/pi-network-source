package com.facebook.ads.redexgen.X;

import java.lang.ref.WeakReference;

/* renamed from: com.facebook.ads.redexgen.X.bO  reason: case insensitive filesystem */
public class C0997bO implements JT {
    public WeakReference<C1007bZ> A00;

    public C0997bO(C1007bZ bZVar) {
        this.A00 = new WeakReference<>(bZVar);
    }

    @Override // com.facebook.ads.redexgen.X.JT
    public final void AAP(boolean z) {
        if (this.A00.get() != null) {
            this.A00.get().A1U(z, false);
        }
    }
}
