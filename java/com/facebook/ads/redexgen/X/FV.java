package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;

public final class FV {
    public final int A00;
    public final int A01;
    public final int A02;
    public final long A03;
    public final long A04;
    @Nullable
    public final Format A05;
    @Nullable
    public final Object A06;

    public FV(int i, int i2, @Nullable Format format, int i3, @Nullable Object obj, long j, long j2) {
        this.A00 = i;
        this.A02 = i2;
        this.A05 = format;
        this.A01 = i3;
        this.A06 = obj;
        this.A04 = j;
        this.A03 = j2;
    }
}
