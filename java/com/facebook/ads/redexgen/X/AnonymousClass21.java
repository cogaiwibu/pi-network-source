package com.facebook.ads.redexgen.X;

import java.io.Serializable;

/* renamed from: com.facebook.ads.redexgen.X.21  reason: invalid class name */
public class AnonymousClass21 implements Serializable {
    public double A00;
    public double A01;
    public double A02;
    public double A03;
    public double A04;
    public double A05;
    public double A06;
    public double A07;
    public double A08;
    public double A09;
    public int A0A;

    public AnonymousClass21(double d) {
        this.A04 = d;
    }

    public final double A00() {
        return this.A00;
    }

    public final double A01() {
        return this.A03;
    }

    public final double A02() {
        return this.A05;
    }

    public final double A03() {
        return this.A06;
    }

    public final double A04() {
        return this.A07;
    }

    public final double A05() {
        if (this.A0A == 0) {
            return 0.0d;
        }
        return this.A08;
    }

    public final void A06() {
        this.A00 = 0.0d;
        this.A02 = 0.0d;
        this.A03 = 0.0d;
        this.A05 = 0.0d;
        this.A0A = 0;
        this.A07 = 0.0d;
        this.A08 = 1.0d;
        this.A09 = 0.0d;
    }

    public final void A07() {
        this.A01 = 0.0d;
    }

    public final void A08(double d, double d2) {
        this.A0A++;
        this.A07 += d;
        this.A02 = d2;
        this.A09 += d2 * d;
        this.A00 = this.A09 / this.A07;
        this.A08 = Math.min(this.A08, d2);
        this.A05 = Math.max(this.A05, d2);
        if (d2 >= this.A04) {
            this.A03 += d;
            this.A01 += d;
            this.A06 = Math.max(this.A06, this.A01);
            return;
        }
        this.A01 = 0.0d;
    }
}
