package com.facebook.ads.redexgen.X;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class AB implements Comparable<AB> {
    public int A00;
    public long A01;
    @Nullable
    public Object A02;
    public final C0268Aa A03;

    public AB(C0268Aa aa) {
        this.A03 = aa;
    }

    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final int compareTo(@NonNull AB ab) {
        boolean z;
        boolean z2;
        if (this.A02 == null) {
            z = true;
        } else {
            z = false;
        }
        if (ab.A02 == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z != z2) {
            if (this.A02 != null) {
                return -1;
            }
            return 1;
        } else if (this.A02 == null) {
            return 0;
        } else {
            int i = this.A00 - ab.A00;
            if (i != 0) {
                return i;
            }
            return C0466Ig.A07(this.A01, ab.A01);
        }
    }

    public final void A01(int i, long j, Object obj) {
        this.A00 = i;
        this.A01 = j;
        this.A02 = obj;
    }
}
