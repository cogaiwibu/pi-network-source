package com.facebook.ads.redexgen.X;

import android.util.SparseArray;

public final class GY {
    public GS A00;
    public GU A01;
    public final int A02;
    public final int A03;
    public final SparseArray<GR> A04 = new SparseArray<>();
    public final SparseArray<GT> A05 = new SparseArray<>();
    public final SparseArray<GR> A06 = new SparseArray<>();
    public final SparseArray<GT> A07 = new SparseArray<>();
    public final SparseArray<GW> A08 = new SparseArray<>();

    public GY(int i, int i2) {
        this.A03 = i;
        this.A02 = i2;
    }

    public final void A00() {
        this.A08.clear();
        this.A06.clear();
        this.A07.clear();
        this.A04.clear();
        this.A05.clear();
        this.A00 = null;
        this.A01 = null;
    }
}
