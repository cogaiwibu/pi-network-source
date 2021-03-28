package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.Fb  reason: case insensitive filesystem */
public final class C0385Fb {
    @Nullable
    public C0385Fb A00;
    @Nullable
    public HD A01;
    public boolean A02;
    public final long A03;
    public final long A04;

    public C0385Fb(long j, int i) {
        this.A04 = j;
        this.A03 = ((long) i) + j;
    }

    public final int A00(long j) {
        return ((int) (j - this.A04)) + this.A01.A00;
    }

    public final C0385Fb A01() {
        this.A01 = null;
        C0385Fb fb = this.A00;
        this.A00 = null;
        return fb;
    }

    public final void A02(HD hd, C0385Fb fb) {
        this.A01 = hd;
        this.A00 = fb;
        this.A02 = true;
    }
}
