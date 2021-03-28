package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.7p  reason: invalid class name and case insensitive filesystem */
public class C02117p extends AbstractC0494Jk {
    public final /* synthetic */ C0442Hi A00;

    public C02117p(C0442Hi hi) {
        this.A00 = hi;
    }

    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final void A04(C0501Jt jt) {
        if ((this.A00.A03) && (this.A00.A02)) {
            this.A00.A03 = false;
            if ((this.A00.A0E(PD.A04)) || (this.A00.A04)) {
                this.A00.A04 = false;
                this.A00.A05.postDelayed(new C0448Ho(this), (long) this.A00.A00);
            } else if (this.A00.A0E(PD.A03)) {
                this.A00.A03();
                this.A00.A07(true, true);
            }
        }
    }
}
