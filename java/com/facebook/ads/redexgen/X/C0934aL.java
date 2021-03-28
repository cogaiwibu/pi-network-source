package com.facebook.ads.redexgen.X;

import java.util.Collections;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.aL  reason: case insensitive filesystem */
public final class C0934aL implements GG {
    public final List<GF> A00;

    public C0934aL(List<GF> list) {
        this.A00 = Collections.unmodifiableList(list);
    }

    @Override // com.facebook.ads.redexgen.X.GG
    public final List<GF> A5p(long j) {
        return j >= 0 ? this.A00 : Collections.emptyList();
    }

    @Override // com.facebook.ads.redexgen.X.GG
    public final long A6E(int i) {
        boolean z;
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        I1.A03(z);
        return 0;
    }

    @Override // com.facebook.ads.redexgen.X.GG
    public final int A6F() {
        return 1;
    }

    @Override // com.facebook.ads.redexgen.X.GG
    public final int A6Y(long j) {
        return j < 0 ? 0 : -1;
    }
}
