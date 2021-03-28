package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.Ad  reason: case insensitive filesystem */
public final class C0271Ad {
    public static final C0271Ad A01 = new C0271Ad(0);
    public final int A00;

    public C0271Ad(int i) {
        this.A00 = i;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && this.A00 == ((C0271Ad) obj).A00) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.A00;
    }
}
