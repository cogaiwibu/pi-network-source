package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.7n  reason: invalid class name and case insensitive filesystem */
public class C02097n extends IC {
    public final /* synthetic */ C0442Hi A00;

    public C02097n(C0442Hi hi) {
        this.A00 = hi;
    }

    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final void A04(IF r5) {
        if (this.A00.A01 != null && !(this.A00.A03) && r5.A00().getAction() == 0) {
            this.A00.A05.removeCallbacksAndMessages(null);
            if (this.A00.A0E(PD.A05)) {
                this.A00.A03();
                this.A00.A07(true, false);
            }
            if (this.A00.A02) {
                this.A00.A05.postDelayed(new C0446Hm(this), (long) this.A00.A00);
            }
        }
    }
}
