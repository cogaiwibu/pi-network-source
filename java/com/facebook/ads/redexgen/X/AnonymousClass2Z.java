package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.2Z  reason: invalid class name */
public final class AnonymousClass2Z extends A3 {
    public final int A00;
    public final int A01;
    public final AbstractC0441Hh<? super HM> A02;
    public final String A03;
    public final boolean A04;

    public AnonymousClass2Z(String str, AbstractC0441Hh<? super HM> hh) {
        this(str, hh, 8000, 8000, false);
    }

    public AnonymousClass2Z(String str, AbstractC0441Hh<? super HM> hh, int i, int i2, boolean z) {
        this.A03 = str;
        this.A02 = hh;
        this.A00 = i;
        this.A01 = i2;
        this.A04 = z;
    }

    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final A5 A01(HW hw) {
        return new A5(this.A03, null, this.A02, this.A00, this.A01, this.A04, hw);
    }
}
