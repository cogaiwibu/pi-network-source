package com.facebook.ads.redexgen.X;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;

public final class DC {
    public static byte[] A0B;
    public static String[] A0C;
    public static final int A0D = C0466Ig.A08(A00(0, 4, 115));
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public long A05;
    public long A06;
    public long A07;
    public long A08;
    public final int[] A09 = new int[255];
    public final IQ A0A = new IQ(255);

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0B, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 17);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A0B = new byte[]{-45, -21, -21, -41, -44, -25, -33, -44, -46, -29, -44, -45, -113, -66, -42, -42, -62, -113, -46, -48, -33, -29, -28, -31, -44, -113, -33, -48, -29, -29, -44, -31, -35, -113, -48, -29, -113, -47, -44, -42, -40, -35, -113, -34, -43, -113, -33, -48, -42, -44, -43, -50, -45, -43, -48, -48, -49, -46, -44, -59, -60, ByteCompanionObject.MIN_VALUE, -62, -55, -44, ByteCompanionObject.MIN_VALUE, -45, -44, -46, -59, -63, -51, ByteCompanionObject.MIN_VALUE, -46, -59, -42, -55, -45, -55, -49, -50};
    }

    public static void A02() {
        A0C = new String[]{"YzvHsTMmTYxxNxJ4BW4C6XDVYqyEhqwg", "DyykeCXSXWzexqWWFpwTB51jr5MdfDQh", "", "oCxSUOHtl", "W", "ErMglUai0WMQZxUcBU3ghNmJAn5UMHWP", "evjJZ0tguMh0jPrsPzma", "Y35IcPuc1nzeTRP5nOJ1bVO3GyCkNnWr"};
    }

    static {
        A02();
        A01();
    }

    public final void A03() {
        this.A03 = 0;
        this.A04 = 0;
        this.A05 = 0;
        this.A08 = 0;
        this.A07 = 0;
        this.A06 = 0;
        this.A02 = 0;
        this.A01 = 0;
        this.A00 = 0;
    }

    public final boolean A04(CL cl, boolean z) throws IOException, InterruptedException {
        boolean z2;
        this.A0A.A0W();
        A03();
        if (cl.A6T() == -1 || cl.A6T() - cl.A6h() >= 27) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 && cl.ABa(this.A0A.A00, 0, 27, true)) {
            long A0N = this.A0A.A0N();
            long j = (long) A0D;
            if (A0C[1].charAt(3) != 'Q') {
                String[] strArr = A0C;
                strArr[6] = "TY8Cxf5ha5PO6yS0Ln5J";
                strArr[4] = "Y";
                if (A0N == j) {
                    this.A03 = this.A0A.A0F();
                    if (this.A03 == 0) {
                        this.A04 = this.A0A.A0F();
                        this.A05 = this.A0A.A0K();
                        this.A08 = this.A0A.A0L();
                        this.A07 = this.A0A.A0L();
                        this.A06 = this.A0A.A0L();
                        this.A02 = this.A0A.A0F();
                        this.A01 = this.A02 + 27;
                        this.A0A.A0W();
                        cl.ABZ(this.A0A.A00, 0, this.A02);
                        int i = 0;
                        while (true) {
                            int i2 = this.A02;
                            if (A0C[2].length() == 23) {
                                break;
                            }
                            String[] strArr2 = A0C;
                            strArr2[6] = "f6Qtv0ouqQGkepRa7Y7s";
                            strArr2[4] = "L";
                            if (i >= i2) {
                                return true;
                            }
                            this.A09[i] = this.A0A.A0F();
                            this.A00 += this.A09[i];
                            i++;
                        }
                    } else if (z) {
                        return false;
                    } else {
                        throw new AN(A00(50, 31, 79));
                    }
                } else if (z) {
                    return false;
                } else {
                    throw new AN(A00(4, 46, 94));
                }
            }
            throw new RuntimeException();
        } else if (z) {
            return false;
        } else {
            throw new EOFException();
        }
    }
}
