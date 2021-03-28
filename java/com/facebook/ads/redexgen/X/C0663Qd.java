package com.facebook.ads.redexgen.X;

import android.text.TextUtils;

/* renamed from: com.facebook.ads.redexgen.X.Qd  reason: case insensitive filesystem */
public class C0663Qd extends AbstractC0640Pg {
    public final /* synthetic */ QZ A00;

    public C0663Qd(QZ qz) {
        this.A00 = qz;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0640Pg
    public final void A04() {
        if (!this.A00.A06.A08()) {
            this.A00.A06.A06();
            if (!TextUtils.isEmpty(this.A00.A01.A0Q())) {
                this.A00.A04.A86(this.A00.A01.A0Q(), new NU().A04(this.A00.A0A).A03(this.A00.A06).A05(this.A00.A01.A0S()).A06());
                this.A00.A03.A0A().A2a();
                this.A00.A08.A3s(this.A00.A09.A6N());
            }
        }
    }
}
