package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;

public final class OF {
    public int A00 = 1000;
    public AnonymousClass1H A01 = AnonymousClass1H.A01(null);
    @Nullable
    public String A02;
    @Nullable
    public String A03;
    public final AnonymousClass1G A04;
    public final AnonymousClass1Q A05;
    public final C0820Wh A06;

    public OF(C0820Wh wh, AnonymousClass1G r3, AnonymousClass1Q r4) {
        this.A06 = wh;
        this.A04 = r3;
        this.A05 = r4;
    }

    public final OF A07(int i) {
        this.A00 = i;
        return this;
    }

    public final OF A08(AnonymousClass1H r1) {
        this.A01 = r1;
        return this;
    }

    public final OF A09(String str) {
        this.A02 = str;
        return this;
    }

    public final OF A0A(String str) {
        this.A03 = str;
        return this;
    }

    public final OH A0B() {
        return new OH(this, null);
    }
}
