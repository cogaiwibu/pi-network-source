package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

public final class YQ implements AbstractC0312Cc {
    public static byte[] A07;
    public int A00;
    public int A01;
    public long A02;
    public AbstractC0314Ce A03;
    public final C0319Cj A04 = new C0319Cj();
    public final ArrayDeque<C0311Cb> A05 = new ArrayDeque<>();
    public final byte[] A06 = new byte[8];

    static {
        A05();
    }

    public static String A03(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 28);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A07 = new byte[]{101, -118, -110, 125, -120, -123, ByteCompanionObject.MIN_VALUE, 60, -127, -120, -127, -119, -127, -118, -112, 60, -112, -107, -116, -127, 60, -73, -36, -28, -49, -38, -41, -46, -114, -44, -38, -35, -49, -30, -114, -31, -41, -24, -45, -88, -114, -95, -58, -50, -71, -60, -63, -68, 120, -63, -58, -52, -67, -65, -67, -54, 120, -53, -63, -46, -67, -110, 120, -64, -31, -33, -42, -37, -44, -115, -46, -39, -46, -38, -46, -37, -31, -115, -32, -42, -25, -46, -89, -115};
    }

    private double A00(CL cl, int i) throws IOException, InterruptedException {
        long A022 = A02(cl, i);
        if (i == 4) {
            return (double) Float.intBitsToFloat((int) A022);
        }
        return Double.longBitsToDouble(A022);
    }

    private long A01(CL cl) throws IOException, InterruptedException {
        cl.ACa();
        while (true) {
            cl.ABZ(this.A06, 0, 4);
            int A002 = C0319Cj.A00(this.A06[0]);
            if (A002 != -1 && A002 <= 4) {
                int A012 = (int) C0319Cj.A01(this.A06, A002, false);
                if (this.A03.A7e(A012)) {
                    cl.ADG(A002);
                    return (long) A012;
                }
            }
            cl.ADG(1);
        }
    }

    private long A02(CL cl, int i) throws IOException, InterruptedException {
        cl.readFully(this.A06, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | ((long) (this.A06[i2] & UByte.MAX_VALUE));
        }
        return j;
    }

    private String A04(CL cl, int trimmedLength) throws IOException, InterruptedException {
        if (trimmedLength == 0) {
            return A03(0, 0, 34);
        }
        byte[] bArr = new byte[trimmedLength];
        cl.readFully(bArr, 0, trimmedLength);
        while (trimmedLength > 0 && bArr[trimmedLength - 1] == 0) {
            trimmedLength--;
        }
        return new String(bArr, 0, trimmedLength);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0312Cc
    public final void A7R(AbstractC0314Ce ce) {
        this.A03 = ce;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0312Cc
    public final boolean ABz(CL cl) throws IOException, InterruptedException {
        boolean z;
        if (this.A03 != null) {
            z = true;
        } else {
            z = false;
        }
        I1.A04(z);
        while (true) {
            if (this.A05.isEmpty() || cl.A6m() < this.A05.peek().A01) {
                if (this.A01 == 0) {
                    long A052 = this.A04.A05(cl, true, false, 4);
                    if (A052 == -2) {
                        A052 = A01(cl);
                    }
                    if (A052 == -1) {
                        return false;
                    }
                    this.A00 = (int) A052;
                    this.A01 = 1;
                }
                if (this.A01 == 1) {
                    this.A02 = this.A04.A05(cl, false, true, 8);
                    this.A01 = 2;
                }
                int A66 = this.A03.A66(this.A00);
                if (A66 == 0) {
                    cl.ADG((int) this.A02);
                    this.A01 = 0;
                } else if (A66 == 1) {
                    long A6m = cl.A6m();
                    this.A05.push(new C0311Cb(this.A00, A6m + this.A02));
                    this.A03.ADK(this.A00, A6m, this.A02);
                    this.A01 = 0;
                    return true;
                } else if (A66 == 2) {
                    long j = this.A02;
                    if (j <= 8) {
                        this.A03.A7T(this.A00, A02(cl, (int) j));
                        this.A01 = 0;
                        return true;
                    }
                    throw new AN(A03(41, 22, 60) + this.A02);
                } else if (A66 == 3) {
                    long j2 = this.A02;
                    if (j2 <= 2147483647L) {
                        this.A03.ADR(this.A00, A04(cl, (int) j2));
                        this.A01 = 0;
                        return true;
                    }
                    throw new AN(A03(63, 21, 81) + this.A02);
                } else if (A66 == 4) {
                    this.A03.A3r(this.A00, (int) this.A02, cl);
                    this.A01 = 0;
                    return true;
                } else if (A66 == 5) {
                    long j3 = this.A02;
                    if (j3 == 4 || j3 == 8) {
                        this.A03.A58(this.A00, A00(cl, (int) this.A02));
                        this.A01 = 0;
                        return true;
                    }
                    throw new AN(A03(21, 20, 82) + this.A02);
                } else {
                    throw new AN(A03(0, 21, 0) + A66);
                }
            } else {
                this.A03.A4v(this.A05.pop().A00);
                return true;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0312Cc
    public final void reset() {
        this.A01 = 0;
        this.A05.clear();
        this.A04.A06();
    }
}
