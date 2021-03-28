package com.facebook.ads.redexgen.X;

public class KR extends AnonymousClass9K<AnonymousClass7v> {
    public final /* synthetic */ AnonymousClass7w A00;

    public KR(AnonymousClass7w r1) {
        this.A00 = r1;
    }

    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final void A04(AnonymousClass7v r4) {
        int A002 = r4.A00();
        int A01 = r4.A01();
        if (this.A00.A00 > 0 && A002 == A01 && A01 > this.A00.A00) {
            return;
        }
        if (A01 >= A002 + 500) {
            this.A00.A0e(A002);
        } else if (A01 == 0) {
            AnonymousClass7w r1 = this.A00;
            r1.A0e(r1.A00);
        } else {
            this.A00.A0e(A01);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass9K
    public final Class<AnonymousClass7v> A01() {
        return AnonymousClass7v.class;
    }
}
