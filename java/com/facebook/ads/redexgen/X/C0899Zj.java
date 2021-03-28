package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Zj  reason: case insensitive filesystem */
public class C0899Zj implements NH {
    public final /* synthetic */ C0898Zi A00;

    public C0899Zj(C0898Zi zi) {
        this.A00 = zi;
    }

    @Override // com.facebook.ads.redexgen.X.NH
    public final void AAL(String str) {
        this.A00.A0A.setProgress(100);
        this.A00.A05 = false;
    }

    @Override // com.facebook.ads.redexgen.X.NH
    public final void AAN(String str) {
        this.A00.A05 = true;
        this.A00.A09.setUrl(str);
    }

    @Override // com.facebook.ads.redexgen.X.NH
    public final void AAd(int i) {
        if (this.A00.A05) {
            this.A00.A0A.setProgress(i);
        }
    }

    @Override // com.facebook.ads.redexgen.X.NH
    public final void AAi(String str) {
        this.A00.A09.setTitle(str);
    }
}
