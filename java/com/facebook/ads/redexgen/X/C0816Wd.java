package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.redexgen.X.Wd  reason: case insensitive filesystem */
public class C0816Wd extends AbstractRunnableC0510Kc {
    public final /* synthetic */ AnonymousClass79 A00;
    public final /* synthetic */ AnonymousClass7A A01;
    public final /* synthetic */ AnonymousClass7H A02;
    public final /* synthetic */ ArrayList A03;
    public final /* synthetic */ ArrayList A04;

    public C0816Wd(AnonymousClass7H r1, ArrayList arrayList, AnonymousClass79 r3, AnonymousClass7A r4, ArrayList arrayList2) {
        this.A02 = r1;
        this.A03 = arrayList;
        this.A00 = r3;
        this.A01 = r4;
        this.A04 = arrayList2;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0510Kc
    public final void A07() {
        AtomicBoolean atomicBoolean = AnonymousClass7H.A0B(this.A03);
        if (this.A02.A04 instanceof C0820Wh) {
            C0820Wh wh = (C0820Wh) this.A02.A04;
            if (atomicBoolean.get()) {
                wh.A0A().A3w(LW.A01(this.A02.A00));
            } else {
                wh.A0A().A3v(LW.A01(this.A02.A00));
            }
        }
        this.A02.A02.post(new C0815Wc(this, atomicBoolean));
        AtomicBoolean unused = AnonymousClass7H.A0B(this.A04);
    }
}
