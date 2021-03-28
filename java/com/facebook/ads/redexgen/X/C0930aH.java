package com.facebook.ads.redexgen.X;

import java.util.Collections;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.aH  reason: case insensitive filesystem */
public final class C0930aH implements GG {
    public final long[] A00;
    public final GF[] A01;

    public C0930aH(GF[] gfArr, long[] jArr) {
        this.A01 = gfArr;
        this.A00 = jArr;
    }

    @Override // com.facebook.ads.redexgen.X.GG
    public final List<GF> A5p(long j) {
        int A0B = C0466Ig.A0B(this.A00, j, true, false);
        if (A0B != -1) {
            GF[] gfArr = this.A01;
            if (gfArr[A0B] != null) {
                return Collections.singletonList(gfArr[A0B]);
            }
        }
        return Collections.emptyList();
    }

    @Override // com.facebook.ads.redexgen.X.GG
    public final long A6E(int i) {
        boolean z;
        boolean z2 = true;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        I1.A03(z);
        if (i >= this.A00.length) {
            z2 = false;
        }
        I1.A03(z2);
        return this.A00[i];
    }

    @Override // com.facebook.ads.redexgen.X.GG
    public final int A6F() {
        return this.A00.length;
    }

    @Override // com.facebook.ads.redexgen.X.GG
    public final int A6Y(long j) {
        int A0A = C0466Ig.A0A(this.A00, j, false, false);
        if (A0A < this.A00.length) {
            return A0A;
        }
        return -1;
    }
}
