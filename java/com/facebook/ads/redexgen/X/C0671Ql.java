package com.facebook.ads.redexgen.X;

import java.lang.ref.WeakReference;

/* renamed from: com.facebook.ads.redexgen.X.Ql  reason: case insensitive filesystem */
public class C0671Ql implements NT {
    public final WeakReference<AbstractC0670Qk> A00;

    public C0671Ql(AbstractC0670Qk qk) {
        this.A00 = new WeakReference<>(qk);
    }

    public /* synthetic */ C0671Ql(AbstractC0670Qk qk, AnonymousClass9H r2) {
        this(qk);
    }

    @Override // com.facebook.ads.redexgen.X.NT
    public final void A9g(boolean z) {
        AbstractC0670Qk qk = this.A00.get();
        if (qk != null) {
            qk.A06 = z;
            qk.A01();
        }
    }
}
