package com.facebook.ads.redexgen.X;

import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.Et  reason: case insensitive filesystem */
public final class C0377Et extends AbstractC0690Re {
    public C0377Et(C0820Wh wh, C00571k r2) {
        super(wh, r2);
    }

    private AbstractC00440x A00(Runnable runnable) {
        return new C0692Rg(this, runnable);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0690Re
    public final void A0N() {
        ((RE) this.A02).A0B();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0690Re
    public final void A0Q(AbstractC00340n r13, AnonymousClass90 r14, C02408y r15, Map<String, Object> map) {
        RE re = (RE) r13;
        C0691Rf rf = new C0691Rf(this, map, re);
        A0G().postDelayed(rf, (long) r14.A05().A05());
        re.A0A(this.A0C, A00(rf), map, this.A08.A09, this.A08.A03, this.A08.A04, this.A08.A01);
    }
}
