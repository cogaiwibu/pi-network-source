package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.source.TrackGroup;

/* renamed from: com.facebook.ads.redexgen.X.aO  reason: case insensitive filesystem */
public final class C0937aO implements H7 {
    public final float A00;
    public final float A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final long A05;
    public final HH A06;
    public final I4 A07;

    public C0937aO(HH hh) {
        this(hh, 10000, 25000, 25000, 0.75f, 0.75f, 2000, I4.A00);
    }

    public C0937aO(HH hh, int i, int i2, int i3, float f, float f2, long j, I4 i4) {
        this.A06 = hh;
        this.A03 = i;
        this.A02 = i2;
        this.A04 = i3;
        this.A00 = f;
        this.A01 = f2;
        this.A05 = j;
        this.A07 = i4;
    }

    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final AT A4T(TrackGroup trackGroup, int... iArr) {
        return new AT(trackGroup, iArr, this.A06, (long) this.A03, (long) this.A02, (long) this.A04, this.A00, this.A01, this.A05, this.A07);
    }
}
