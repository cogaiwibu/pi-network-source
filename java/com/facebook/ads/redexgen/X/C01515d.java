package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.5d  reason: invalid class name and case insensitive filesystem */
public final class C01515d {
    public final long A00;
    public final EnumC01505c A01;
    public final String A02;
    public final boolean A03;

    public C01515d(String str, boolean z, EnumC01505c r9) {
        this(str, z, r9, System.currentTimeMillis());
    }

    public C01515d(String str, boolean z, EnumC01505c r3, long j) {
        this.A02 = str;
        this.A03 = z;
        this.A01 = r3;
        this.A00 = j;
    }

    public static C01515d A00() {
        return new C01515d("", true, EnumC01505c.A06, -1);
    }

    public final long A01() {
        return this.A00;
    }

    public final EnumC01505c A02() {
        return this.A01;
    }

    public final String A03() {
        return this.A02;
    }

    public final boolean A04() {
        return this.A03;
    }
}
