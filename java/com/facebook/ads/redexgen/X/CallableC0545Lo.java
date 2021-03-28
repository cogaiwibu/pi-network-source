package com.facebook.ads.redexgen.X;

import java.util.concurrent.Callable;

/* renamed from: com.facebook.ads.redexgen.X.Lo  reason: case insensitive filesystem */
public class CallableC0545Lo implements Callable<Void> {
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int[] A06;

    public CallableC0545Lo(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6) {
        this.A06 = iArr;
        this.A05 = i;
        this.A01 = i2;
        this.A02 = i3;
        this.A04 = i4;
        this.A00 = i5;
        this.A03 = i6;
    }

    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final Void call() throws Exception {
        C0913a0.A01(this.A06, this.A05, this.A01, this.A02, this.A04, this.A00, this.A03);
        return null;
    }
}
