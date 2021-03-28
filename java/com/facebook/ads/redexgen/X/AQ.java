package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.source.TrackGroup;

public final class AQ extends AbstractC0938aP {
    public final int A00;
    @Nullable
    public final Object A01;

    public AQ(TrackGroup trackGroup, int i) {
        this(trackGroup, i, 0, null);
    }

    public AQ(TrackGroup trackGroup, int i, int i2, @Nullable Object obj) {
        super(trackGroup, i);
        this.A00 = i2;
        this.A01 = obj;
    }

    @Override // com.facebook.ads.redexgen.X.H8
    public final int A6u() {
        return 0;
    }
}
