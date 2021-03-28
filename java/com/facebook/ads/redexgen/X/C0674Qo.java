package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Qo  reason: case insensitive filesystem */
public class C0674Qo implements NH {
    public final /* synthetic */ C0672Qm A00;

    public C0674Qo(C0672Qm qm) {
        this.A00 = qm;
    }

    @Override // com.facebook.ads.redexgen.X.NH
    public final void AAL(String str) {
        this.A00.A0I = false;
        this.A00.A0C.setProgress(100);
        C0535Le.A0Q(this.A00.A0C, 8);
    }

    @Override // com.facebook.ads.redexgen.X.NH
    public final void AAN(String str) {
        this.A00.A0I = true;
        C0535Le.A0Q(this.A00.A0C, 0);
        this.A00.A0B.setUrl(str);
    }

    @Override // com.facebook.ads.redexgen.X.NH
    public final void AAd(int i) {
        if (this.A00.A0I) {
            this.A00.A0C.setProgress(i);
        }
    }

    @Override // com.facebook.ads.redexgen.X.NH
    public final void AAi(String str) {
        this.A00.A0B.setTitle(str);
    }
}
