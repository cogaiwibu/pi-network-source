package com.facebook.ads.redexgen.X;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

public final class YD implements CL {
    public int A00;
    public int A01;
    public long A02;
    public byte[] A03 = new byte[65536];
    public final long A04;
    public final HM A05;
    public final byte[] A06 = new byte[4096];

    public YD(HM hm, long j, long j2) {
        this.A05 = hm;
        this.A02 = j;
        this.A04 = j2;
    }

    private int A00(int i) {
        int min = Math.min(this.A00, i);
        A05(min);
        return min;
    }

    private int A01(byte[] bArr, int i, int i2) {
        int i3 = this.A00;
        if (i3 == 0) {
            return 0;
        }
        int min = Math.min(i3, i2);
        System.arraycopy(this.A03, 0, bArr, i, min);
        A05(min);
        return min;
    }

    private int A02(byte[] bArr, int i, int i2, int i3, boolean z) throws InterruptedException, IOException {
        if (!Thread.interrupted()) {
            int read = this.A05.read(bArr, i + i3, i2 - i3);
            if (read != -1) {
                return i3 + read;
            }
            if (i3 == 0 && z) {
                return -1;
            }
            throw new EOFException();
        }
        throw new InterruptedException();
    }

    private void A03(int i) {
        if (i != -1) {
            this.A02 += (long) i;
        }
    }

    private void A04(int i) {
        int i2 = this.A01 + i;
        byte[] bArr = this.A03;
        if (i2 > bArr.length) {
            this.A03 = Arrays.copyOf(this.A03, C0466Ig.A06(bArr.length * 2, 65536 + i2, 524288 + i2));
        }
    }

    private void A05(int i) {
        this.A00 -= i;
        this.A01 = 0;
        byte[] bArr = this.A03;
        int i2 = this.A00;
        if (i2 < this.A03.length - 524288) {
            bArr = new byte[(i2 + 65536)];
        }
        System.arraycopy(this.A03, i, bArr, 0, this.A00);
        this.A03 = bArr;
    }

    public final boolean A06(int i, boolean z) throws IOException, InterruptedException {
        A04(i);
        int min = Math.min(this.A00 - this.A01, i);
        while (min < i) {
            min = A02(this.A03, this.A01, i, min, z);
            if (min == -1) {
                return false;
            }
        }
        this.A01 += i;
        this.A00 = Math.max(this.A00, this.A01);
        return true;
    }

    public final boolean A07(int i, boolean z) throws IOException, InterruptedException {
        int A002 = A00(i);
        while (A002 < i && A002 != -1) {
            A002 = A02(this.A06, -A002, Math.min(i, this.A06.length + A002), A002, z);
        }
        A03(A002);
        return A002 != -1;
    }

    @Override // com.facebook.ads.redexgen.X.CL
    public final void A3M(int i) throws IOException, InterruptedException {
        A06(i, false);
    }

    @Override // com.facebook.ads.redexgen.X.CL
    public final long A6T() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.CL
    public final long A6h() {
        return this.A02 + ((long) this.A01);
    }

    @Override // com.facebook.ads.redexgen.X.CL
    public final long A6m() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.CL
    public final void ABZ(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        ABa(bArr, i, i2, false);
    }

    @Override // com.facebook.ads.redexgen.X.CL
    public final boolean ABa(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException {
        if (!A06(i2, z)) {
            return false;
        }
        System.arraycopy(this.A03, this.A01 - i2, bArr, i, i2);
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.CL
    public final boolean AC2(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException {
        int A012 = A01(bArr, i, i2);
        while (A012 < i2 && A012 != -1) {
            A012 = A02(bArr, i, i2, A012, z);
        }
        A03(A012);
        return A012 != -1;
    }

    @Override // com.facebook.ads.redexgen.X.CL
    public final void ACa() {
        this.A01 = 0;
    }

    @Override // com.facebook.ads.redexgen.X.CL
    public final int ADD(int i) throws IOException, InterruptedException {
        int A002 = A00(i);
        if (A002 == 0) {
            byte[] bArr = this.A06;
            A002 = A02(bArr, 0, Math.min(i, bArr.length), 0, true);
        }
        A03(A002);
        return A002;
    }

    @Override // com.facebook.ads.redexgen.X.CL
    public final void ADG(int i) throws IOException, InterruptedException {
        A07(i, false);
    }

    @Override // com.facebook.ads.redexgen.X.CL
    public final int read(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        int A012 = A01(bArr, i, i2);
        if (A012 == 0) {
            A012 = A02(bArr, i, i2, 0, true);
        }
        A03(A012);
        return A012;
    }

    @Override // com.facebook.ads.redexgen.X.CL
    public final void readFully(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        AC2(bArr, i, i2, false);
    }
}
