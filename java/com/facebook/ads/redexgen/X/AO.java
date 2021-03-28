package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.source.TrackGroupArray;

public final class AO {
    public final int A00;
    public final long A01;
    public final long A02;
    public final AbstractC0276Aj A03;
    public final FG A04;
    public final TrackGroupArray A05;
    public final HC A06;
    @Nullable
    public final Object A07;
    public final boolean A08;
    public volatile long A09;
    public volatile long A0A;

    public AO(AbstractC0276Aj aj, long j, TrackGroupArray trackGroupArray, HC hc) {
        this(aj, null, new FG(0), j, -9223372036854775807L, 1, false, trackGroupArray, hc);
    }

    public AO(AbstractC0276Aj aj, @Nullable Object obj, FG fg, long j, long j2, int i, boolean z, TrackGroupArray trackGroupArray, HC hc) {
        this.A03 = aj;
        this.A07 = obj;
        this.A04 = fg;
        this.A02 = j;
        this.A01 = j2;
        this.A0A = j;
        this.A09 = j;
        this.A00 = i;
        this.A08 = z;
        this.A05 = trackGroupArray;
        this.A06 = hc;
    }

    public static void A00(AO ao, AO ao2) {
        ao2.A0A = ao.A0A;
        ao2.A09 = ao.A09;
    }

    public final AO A01(int i) {
        AO ao = new AO(this.A03, this.A07, this.A04.A01(i), this.A02, this.A01, this.A00, this.A08, this.A05, this.A06);
        A00(this, ao);
        return ao;
    }

    public final AO A02(int i) {
        AO ao = new AO(this.A03, this.A07, this.A04, this.A02, this.A01, i, this.A08, this.A05, this.A06);
        A00(this, ao);
        return ao;
    }

    public final AO A03(AbstractC0276Aj aj, Object obj) {
        AO ao = new AO(aj, obj, this.A04, this.A02, this.A01, this.A00, this.A08, this.A05, this.A06);
        A00(this, ao);
        return ao;
    }

    public final AO A04(FG fg, long j, long j2) {
        long j3 = j2;
        AbstractC0276Aj aj = this.A03;
        Object obj = this.A07;
        if (!fg.A02()) {
            j3 = -9223372036854775807L;
        }
        return new AO(aj, obj, fg, j, j3, this.A00, this.A08, this.A05, this.A06);
    }

    public final AO A05(TrackGroupArray trackGroupArray, HC hc) {
        AO ao = new AO(this.A03, this.A07, this.A04, this.A02, this.A01, this.A00, this.A08, trackGroupArray, hc);
        A00(this, ao);
        return ao;
    }

    public final AO A06(boolean z) {
        AO ao = new AO(this.A03, this.A07, this.A04, this.A02, this.A01, this.A00, z, this.A05, this.A06);
        A00(this, ao);
        return ao;
    }
}
