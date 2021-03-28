package com.facebook.ads.redexgen.X;

import android.net.Uri;

/* renamed from: com.facebook.ads.redexgen.X.Fp  reason: case insensitive filesystem */
public final class C0397Fp {
    public final int A00;
    public final int[] A01;
    public final long[] A02;
    public final Uri[] A03;

    public C0397Fp() {
        this(-1, new int[0], new Uri[0], new long[0]);
    }

    public C0397Fp(int i, int[] iArr, Uri[] uriArr, long[] jArr) {
        boolean z;
        if (iArr.length == uriArr.length) {
            z = true;
        } else {
            z = false;
        }
        I1.A03(z);
        this.A00 = i;
        this.A01 = iArr;
        this.A03 = uriArr;
        this.A02 = jArr;
    }

    public final int A00() {
        return A01(-1);
    }

    public final int A01(int i) {
        int i2 = i + 1;
        while (true) {
            int[] iArr = this.A01;
            if (i2 >= iArr.length || iArr[i2] == 0 || iArr[i2] == 1) {
                return i2;
            }
            i2++;
        }
        return i2;
    }

    public final boolean A02() {
        return this.A00 == -1 || A00() < this.A00;
    }
}
