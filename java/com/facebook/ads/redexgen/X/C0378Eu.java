package com.facebook.ads.redexgen.X;

import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.Eu  reason: case insensitive filesystem */
public final class C0378Eu extends AbstractC0690Re {
    public C0331Cv A00;

    public C0378Eu(C0331Cv cv, C00571k r2) {
        super(cv, r2);
        this.A00 = cv;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0690Re
    public final void A0N() {
        if (super.A00 != null) {
            this.A00.A0A().A3o();
            this.A07.A0D(super.A00);
            return;
        }
        this.A00.A0A().A3p();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0690Re
    public final void A0Q(AbstractC00340n r11, AnonymousClass90 r12, C02408y r13, Map<String, Object> map) {
        this.A00.A0A().A3i();
        RD rd = (RD) r11;
        RZ rz = new RZ(this, map, rd);
        A0G().postDelayed(rz, (long) r12.A05().A05());
        rd.A0D(this.A00, this.A09, this.A08.A06, new C0686Ra(this, rz), map);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0690Re
    public final void A0S(String str) {
        boolean z;
        AbstractC0685Qz A0F = this.A00.A0A();
        if (str != null) {
            z = true;
        } else {
            z = false;
        }
        A0F.A3n(z);
        super.A0S(str);
    }
}
