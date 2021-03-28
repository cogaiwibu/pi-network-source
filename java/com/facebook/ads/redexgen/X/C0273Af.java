package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.Af  reason: case insensitive filesystem */
public final class C0273Af {
    public static final C0273Af A02 = new C0273Af(Long.MAX_VALUE, Long.MAX_VALUE);
    public static final C0273Af A03 = A04;
    public static final C0273Af A04 = new C0273Af(0, 0);
    public static final C0273Af A05 = new C0273Af(0, Long.MAX_VALUE);
    public static final C0273Af A06 = new C0273Af(Long.MAX_VALUE, 0);
    public final long A00;
    public final long A01;

    public C0273Af(long j, long j2) {
        boolean z;
        boolean z2 = true;
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        I1.A03(z);
        I1.A03(j2 < 0 ? false : z2);
        this.A01 = j;
        this.A00 = j2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0273Af af = (C0273Af) obj;
        if (this.A01 == af.A01 && this.A00 == af.A00) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.A01) * 31) + ((int) this.A00);
    }
}
