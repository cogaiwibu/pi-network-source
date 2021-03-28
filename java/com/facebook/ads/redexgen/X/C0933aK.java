package com.facebook.ads.redexgen.X;

import java.util.Collections;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.aK  reason: case insensitive filesystem */
public final class C0933aK implements GG {
    public static final C0933aK A01 = new C0933aK();
    public final List<GF> A00;

    public C0933aK() {
        this.A00 = Collections.emptyList();
    }

    public C0933aK(GF gf) {
        this.A00 = Collections.singletonList(gf);
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
