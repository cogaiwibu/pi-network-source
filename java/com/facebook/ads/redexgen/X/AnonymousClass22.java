package com.facebook.ads.redexgen.X;

import java.io.Serializable;

/* renamed from: com.facebook.ads.redexgen.X.22  reason: invalid class name */
public final class AnonymousClass22 implements Serializable {
    public AnonymousClass21 A00;
    public AnonymousClass21 A01;

    public AnonymousClass22() {
        this(0.5d, 0.5d);
    }

    public AnonymousClass22(double d) {
        this(d, 0.5d);
    }

    public AnonymousClass22(double d, double d2) {
        this.A00 = new AnonymousClass21(d);
        this.A01 = new AnonymousClass21(d2);
        A02();
    }

    public final AnonymousClass21 A00() {
        return this.A00;
    }

    public final AnonymousClass21 A01() {
        return this.A01;
    }

    public final void A02() {
        this.A00.A06();
        this.A01.A06();
    }

    public final void A03() {
        this.A00.A07();
        this.A01.A07();
    }

    public final void A04(double d, double d2) {
        this.A00.A08(d, d2);
    }

    public final void A05(double d, double d2) {
        this.A01.A08(d, d2);
    }
}
