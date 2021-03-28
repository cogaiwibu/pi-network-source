package com.facebook.ads.redexgen.X;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.facebook.ads.redexgen.X.Fq  reason: case insensitive filesystem */
public class C0398Fq implements AbstractC0647Pn {
    public final /* synthetic */ C0392Fi A00;
    public final /* synthetic */ CountDownLatch A01;
    public final /* synthetic */ AtomicReference A02;
    public final /* synthetic */ AtomicReference A03;

    public C0398Fq(C0392Fi fi, AtomicReference atomicReference, AtomicReference atomicReference2, CountDownLatch countDownLatch) {
        this.A00 = fi;
        this.A03 = atomicReference;
        this.A02 = atomicReference2;
        this.A01 = countDownLatch;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0647Pn
    public final void A9C(AbstractC0645Pl pl) {
        C0392Fi.A08(pl.A5U(), this.A03, this.A02);
        this.A01.countDown();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0647Pn
    public final void A9Y(Exception exc) {
        this.A02.set(exc);
        this.A01.countDown();
    }
}
