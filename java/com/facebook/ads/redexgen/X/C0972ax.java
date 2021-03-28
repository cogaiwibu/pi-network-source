package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.ax  reason: case insensitive filesystem */
public final class C0972ax implements HL {
    public final int A00;
    public final HJ A01;
    public final HL A02;
    public final HL A03;
    public final AbstractC0445Hl A04;
    public final AbstractC0447Hn A05;

    public C0972ax(AbstractC0445Hl hl, HL hl2, HL hl3, HJ hj, int i, AbstractC0447Hn hn) {
        this.A04 = hl;
        this.A03 = hl2;
        this.A02 = hl3;
        this.A01 = hj;
        this.A00 = i;
        this.A05 = hn;
    }

    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final C0971aw A4D() {
        AbstractC0445Hl hl = this.A04;
        HM A4D = this.A03.A4D();
        HM A4D2 = this.A02.A4D();
        HJ hj = this.A01;
        return new C0971aw(hl, A4D, A4D2, hj != null ? hj.createDataSink() : null, this.A00, this.A05);
    }
}
