package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;

public final class AP {
    public static final AP A04 = new AP(1.0f);
    public final float A00;
    public final float A01;
    public final boolean A02;
    public final int A03;

    public AP(float f) {
        this(f, 1.0f, false);
    }

    public AP(float f, float f2, boolean z) {
        boolean z2;
        boolean z3 = true;
        if (f > 0.0f) {
            z2 = true;
        } else {
            z2 = false;
        }
        I1.A03(z2);
        I1.A03(f2 <= 0.0f ? false : z3);
        this.A01 = f;
        this.A00 = f2;
        this.A02 = z;
        this.A03 = Math.round(1000.0f * f);
    }

    public final long A00(long j) {
        return ((long) this.A03) * j;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AP ap = (AP) obj;
        if (this.A01 == ap.A01 && this.A00 == ap.A00 && this.A02 == ap.A02) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((((17 * 31) + Float.floatToRawIntBits(this.A01)) * 31) + Float.floatToRawIntBits(this.A00)) * 31) + (this.A02 ? 1 : 0);
    }
}
