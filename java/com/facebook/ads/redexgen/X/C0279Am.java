package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.Am  reason: case insensitive filesystem */
public final class C0279Am {
    public final int A00;
    public final FG A01;

    public C0279Am(int i, FG fg) {
        this.A00 = i;
        this.A01 = fg;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0279Am am = (C0279Am) obj;
        if (this.A00 != am.A00 || !this.A01.equals(am.A01)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (this.A00 * 31) + this.A01.hashCode();
    }
}
