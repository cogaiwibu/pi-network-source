package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Sc  reason: case insensitive filesystem */
public class C0713Sc implements AnonymousClass3Z {
    public final /* synthetic */ ES A00;

    public C0713Sc(ES es) {
        this.A00 = es;
    }

    private final void A00(C00973a r6) {
        int i = r6.A00;
        if (i == 1) {
            this.A00.A06.A1R(this.A00, r6.A02, r6.A01);
        } else if (i == 2) {
            this.A00.A06.A1S(this.A00, r6.A02, r6.A01);
        } else if (i == 4) {
            this.A00.A06.A1U(this.A00, r6.A02, r6.A01, r6.A03);
        } else if (i == 8) {
            this.A00.A06.A1T(this.A00, r6.A02, r6.A01, 1);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass3Z
    public final AnonymousClass4X A57(int i) {
        AnonymousClass4X A1H = this.A00.A1H(i, true);
        if (A1H != null && !this.A00.A01.A0L(A1H.A0H)) {
            return A1H;
        }
        return null;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass3Z
    public final void A8S(int i, int i2, Object obj) {
        this.A00.A1g(i, i2, obj);
        this.A00.A0H = true;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass3Z
    public final void A8g(int i, int i2) {
        this.A00.A1d(i, i2);
        this.A00.A0G = true;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass3Z
    public final void A8h(int i, int i2) {
        this.A00.A1e(i, i2);
        this.A00.A0G = true;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass3Z
    public final void A8i(int i, int i2) {
        this.A00.A1h(i, i2, true);
        ES es = this.A00;
        es.A0G = true;
        es.A0s.A00 += i2;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass3Z
    public final void A8j(int i, int i2) {
        this.A00.A1h(i, i2, false);
        this.A00.A0G = true;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass3Z
    public final void A9K(C00973a r1) {
        A00(r1);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass3Z
    public final void A9M(C00973a r1) {
        A00(r1);
    }
}
