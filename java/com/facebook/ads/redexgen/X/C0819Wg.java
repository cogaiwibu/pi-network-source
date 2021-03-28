package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Wg  reason: case insensitive filesystem */
public class C0819Wg implements PU {
    public final /* synthetic */ AnonymousClass7C A00;

    public C0819Wg(AnonymousClass7C r1) {
        this.A00 = r1;
    }

    @Override // com.facebook.ads.redexgen.X.PU
    public final void A9N() {
        try {
            AnonymousClass7C.A01(this.A00).put(true);
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.facebook.ads.redexgen.X.PU
    public final void A9W() {
        try {
            AnonymousClass7C.A01(this.A00).put(false);
        } catch (InterruptedException unused) {
        }
    }
}
