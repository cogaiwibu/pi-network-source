package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.source.TrackGroup;

public final class AT extends AbstractC0938aP {
    public float A00 = 1.0f;
    public int A01 = 1;
    public int A02 = A00(Long.MIN_VALUE);
    public long A03 = -9223372036854775807L;
    public final float A04;
    public final float A05;
    public final long A06;
    public final long A07;
    public final long A08;
    public final long A09;
    public final HH A0A;
    public final I4 A0B;

    public AT(TrackGroup trackGroup, int[] iArr, HH hh, long j, long j2, long j3, float f, float f2, long j4, I4 i4) {
        super(trackGroup, iArr);
        this.A0A = hh;
        this.A07 = j * 1000;
        this.A06 = j2 * 1000;
        this.A08 = 1000 * j3;
        this.A04 = f;
        this.A05 = f2;
        this.A09 = j4;
        this.A0B = i4;
    }

    private int A00(long j) {
        long A5S = (long) (((float) this.A0A.A5S()) * this.A04);
        int i = 0;
        for (int i2 = 0; i2 < super.A03; i2++) {
            if (j == Long.MIN_VALUE || !A02(i2, j)) {
                if (((long) Math.round(((float) A6J(i2).A04) * this.A00)) <= A5S) {
                    return i2;
                }
                i = i2;
            }
        }
        return i;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0938aP, com.facebook.ads.redexgen.X.H8
    public final void A4s() {
        this.A03 = -9223372036854775807L;
    }

    @Override // com.facebook.ads.redexgen.X.H8
    public final int A6u() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0938aP, com.facebook.ads.redexgen.X.H8
    public final void AAU(float f) {
        this.A00 = f;
    }
}
