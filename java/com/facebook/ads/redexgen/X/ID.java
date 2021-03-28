package com.facebook.ads.redexgen.X;

public final class ID {
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final long A07;

    public ID(byte[] bArr, int i) {
        IP ip = new IP(bArr);
        ip.A08(i * 8);
        this.A04 = ip.A05(16);
        this.A02 = ip.A05(16);
        this.A05 = ip.A05(24);
        this.A03 = ip.A05(24);
        this.A06 = ip.A05(20);
        this.A01 = ip.A05(3) + 1;
        this.A00 = ip.A05(5) + 1;
        this.A07 = ((((long) ip.A05(4)) & 15) << 32) | (((long) ip.A05(32)) & 4294967295L);
    }

    public final int A00() {
        return this.A00 * this.A06;
    }

    public final long A01() {
        return (this.A07 * 1000000) / ((long) this.A06);
    }
}
