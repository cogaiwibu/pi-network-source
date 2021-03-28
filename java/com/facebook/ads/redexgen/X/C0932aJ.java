package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.text.ttml.TtmlRegion;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.aJ  reason: case insensitive filesystem */
public final class C0932aJ implements GG {
    public final C0411Gd A00;
    public final Map<String, C0417Gj> A01;
    public final Map<String, C0412Ge> A02;
    public final long[] A03;

    public C0932aJ(C0411Gd gd, Map<String, C0417Gj> map, Map<String, C0412Ge> map2) {
        Map<String, TtmlRegion> regionMap;
        this.A00 = gd;
        this.A02 = map2;
        if (map != null) {
            regionMap = Collections.unmodifiableMap(map);
        } else {
            regionMap = Collections.emptyMap();
        }
        this.A01 = regionMap;
        this.A03 = gd.A0G();
    }

    @Override // com.facebook.ads.redexgen.X.GG
    public final List<GF> A5p(long j) {
        return this.A00.A0E(j, this.A01, this.A02);
    }

    @Override // com.facebook.ads.redexgen.X.GG
    public final long A6E(int i) {
        return this.A03[i];
    }

    @Override // com.facebook.ads.redexgen.X.GG
    public final int A6F() {
        return this.A03.length;
    }

    @Override // com.facebook.ads.redexgen.X.GG
    public final int A6Y(long j) {
        int A0A = C0466Ig.A0A(this.A03, j, false, false);
        if (A0A < this.A03.length) {
            return A0A;
        }
        return -1;
    }
}
