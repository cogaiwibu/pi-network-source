package com.facebook.ads.redexgen.X;

import android.util.SparseArray;

public final class GW {
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final int A07;
    public final int A08;
    public final SparseArray<GX> A09;
    public final boolean A0A;

    public GW(int i, boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, SparseArray<GX> sparseArray) {
        this.A03 = i;
        this.A0A = z;
        this.A08 = i2;
        this.A02 = i3;
        this.A04 = i4;
        this.A01 = i5;
        this.A00 = i6;
        this.A07 = i7;
        this.A06 = i8;
        this.A05 = i9;
        this.A09 = sparseArray;
    }

    public final void A00(GW gw) {
        if (gw != null) {
            SparseArray<GX> sparseArray = gw.A09;
            for (int i = 0; i < sparseArray.size(); i++) {
                this.A09.put(sparseArray.keyAt(i), sparseArray.valueAt(i));
            }
        }
    }
}
