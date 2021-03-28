package com.facebook.ads.redexgen.X;

import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.UByte;

public final class IQ {
    public static byte[] A03;
    public static String[] A04;
    public byte[] A00;
    public int A01;
    public int A02;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 24);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{-33, 4, 12, -9, 2, -1, -6, -74, -21, -22, -36, -61, -50, -74, 9, -5, 7, 11, -5, 4, -7, -5, -74, -7, 5, 4, 10, -1, 4, 11, -9, 10, -1, 5, 4, -74, -8, 15, 10, -5, -48, -74, -67, -30, -22, -43, -32, -35, -40, -108, -55, -56, -70, -95, -84, -108, -25, -39, -27, -23, -39, -30, -41, -39, -108, -38, -35, -26, -25, -24, -108, -42, -19, -24, -39, -82, -108, -113, -86, -85, 91, -99, -92, -81, 91, -87, -86, -81, 91, -75, -96, -83, -86, 117, 91, -49, -50, -64, -89, -78};
    }

    public static void A02() {
        A04 = new String[]{"HJCnnsvFRKCxDDAbEWuhDIcdg3xeT1pm", "aXWy8CvsRXCMVcJtmBA1wVRdgUuSFZpH", "GQPvM", "pDI65rPXKWggiakX8tUTXOsWDv9apWvH", "LM6A01RjpialbK5Oi", "vEfQavrNrAXrkYYeEOthMrPonFtv4Upj", "EEXi7u9hiAizt85cGACEO5SSNblzx1I5", "5Jpn3XfqvoPj"};
    }

    public IQ() {
    }

    public IQ(int i) {
        this.A00 = new byte[i];
        this.A01 = i;
    }

    public IQ(byte[] bArr) {
        this.A00 = bArr;
        this.A01 = bArr.length;
    }

    public IQ(byte[] bArr, int i) {
        this.A00 = bArr;
        this.A01 = i;
    }

    public final char A03() {
        byte[] bArr = this.A00;
        int i = this.A02;
        return (char) ((bArr[i + 1] & UByte.MAX_VALUE) | ((bArr[i] & UByte.MAX_VALUE) << 8));
    }

    public final double A04() {
        return Double.longBitsToDouble(A0M());
    }

    public final int A05() {
        return this.A01 - this.A02;
    }

    public final int A06() {
        byte[] bArr = this.A00;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public final int A07() {
        return this.A02;
    }

    public final int A08() {
        return this.A01;
    }

    public final int A09() {
        byte[] bArr = this.A00;
        int i = this.A02;
        this.A02 = i + 1;
        int i2 = (bArr[i] & UByte.MAX_VALUE) << 24;
        int i3 = this.A02;
        this.A02 = i3 + 1;
        int i4 = i2 | ((bArr[i3] & UByte.MAX_VALUE) << 16);
        int i5 = this.A02;
        this.A02 = i5 + 1;
        int i6 = i4 | ((bArr[i5] & UByte.MAX_VALUE) << 8);
        int i7 = this.A02;
        this.A02 = i7 + 1;
        return (bArr[i7] & UByte.MAX_VALUE) | i6;
    }

    public final int A0A() {
        byte[] bArr = this.A00;
        int i = this.A02;
        this.A02 = i + 1;
        int i2 = ((bArr[i] & UByte.MAX_VALUE) << 24) >> 8;
        int i3 = this.A02;
        this.A02 = i3 + 1;
        int i4 = i2 | ((bArr[i3] & UByte.MAX_VALUE) << 8);
        int i5 = this.A02;
        this.A02 = i5 + 1;
        return (bArr[i5] & UByte.MAX_VALUE) | i4;
    }

    public final int A0B() {
        byte[] bArr = this.A00;
        int i = this.A02;
        this.A02 = i + 1;
        int i2 = bArr[i] & UByte.MAX_VALUE;
        int i3 = this.A02;
        this.A02 = i3 + 1;
        int i4 = i2 | ((bArr[i3] & UByte.MAX_VALUE) << 8);
        int i5 = this.A02;
        this.A02 = i5 + 1;
        int i6 = i4 | ((bArr[i5] & UByte.MAX_VALUE) << 16);
        int i7 = this.A02;
        this.A02 = i7 + 1;
        return ((bArr[i7] & UByte.MAX_VALUE) << 24) | i6;
    }

    public final int A0C() {
        int A0B = A0B();
        if (A0B >= 0) {
            return A0B;
        }
        throw new IllegalStateException(A00(77, 18, 35) + A0B);
    }

    public final int A0D() {
        byte[] bArr = this.A00;
        int i = this.A02;
        this.A02 = i + 1;
        int i2 = bArr[i] & UByte.MAX_VALUE;
        int i3 = this.A02;
        this.A02 = i3 + 1;
        return ((bArr[i3] & UByte.MAX_VALUE) << 8) | i2;
    }

    public final int A0E() {
        return (A0F() << 21) | (A0F() << 14) | (A0F() << 7) | A0F();
    }

    public final int A0F() {
        byte[] bArr = this.A00;
        int i = this.A02;
        this.A02 = i + 1;
        return bArr[i] & UByte.MAX_VALUE;
    }

    public final int A0G() {
        byte[] bArr = this.A00;
        int i = this.A02;
        this.A02 = i + 1;
        int i2 = (bArr[i] & UByte.MAX_VALUE) << 8;
        int i3 = this.A02;
        this.A02 = i3 + 1;
        int i4 = (bArr[i3] & UByte.MAX_VALUE) | i2;
        this.A02 += 2;
        return i4;
    }

    public final int A0H() {
        byte[] bArr = this.A00;
        int i = this.A02;
        this.A02 = i + 1;
        int i2 = (bArr[i] & UByte.MAX_VALUE) << 16;
        int i3 = this.A02;
        this.A02 = i3 + 1;
        int i4 = i2 | ((bArr[i3] & UByte.MAX_VALUE) << 8);
        int i5 = this.A02;
        this.A02 = i5 + 1;
        return (bArr[i5] & UByte.MAX_VALUE) | i4;
    }

    public final int A0I() {
        int A09 = A09();
        if (A09 >= 0) {
            return A09;
        }
        throw new IllegalStateException(A00(77, 18, 35) + A09);
    }

    public final int A0J() {
        byte[] bArr = this.A00;
        int i = this.A02;
        this.A02 = i + 1;
        int i2 = (bArr[i] & UByte.MAX_VALUE) << 8;
        int i3 = this.A02;
        this.A02 = i3 + 1;
        return (bArr[i3] & UByte.MAX_VALUE) | i2;
    }

    public final long A0K() {
        byte[] bArr = this.A00;
        int i = this.A02;
        this.A02 = i + 1;
        int i2 = this.A02;
        this.A02 = i2 + 1;
        int i3 = this.A02;
        this.A02 = i3 + 1;
        int i4 = this.A02;
        this.A02 = i4 + 1;
        int i5 = this.A02;
        this.A02 = i5 + 1;
        int i6 = this.A02;
        this.A02 = i6 + 1;
        int i7 = this.A02;
        this.A02 = i7 + 1;
        int i8 = this.A02;
        this.A02 = i8 + 1;
        return (((long) bArr[i]) & 255) | ((((long) bArr[i2]) & 255) << 8) | ((((long) bArr[i3]) & 255) << 16) | ((((long) bArr[i4]) & 255) << 24) | ((((long) bArr[i5]) & 255) << 32) | ((((long) bArr[i6]) & 255) << 40) | ((((long) bArr[i7]) & 255) << 48) | ((255 & ((long) bArr[i8])) << 56);
    }

    public final long A0L() {
        byte[] bArr = this.A00;
        int i = this.A02;
        this.A02 = i + 1;
        int i2 = this.A02;
        this.A02 = i2 + 1;
        int i3 = this.A02;
        this.A02 = i3 + 1;
        int i4 = this.A02;
        this.A02 = i4 + 1;
        return (((long) bArr[i]) & 255) | ((((long) bArr[i2]) & 255) << 8) | ((((long) bArr[i3]) & 255) << 16) | ((255 & ((long) bArr[i4])) << 24);
    }

    public final long A0M() {
        byte[] bArr = this.A00;
        int i = this.A02;
        this.A02 = i + 1;
        int i2 = this.A02;
        this.A02 = i2 + 1;
        int i3 = this.A02;
        this.A02 = i3 + 1;
        int i4 = this.A02;
        this.A02 = i4 + 1;
        int i5 = this.A02;
        this.A02 = i5 + 1;
        int i6 = this.A02;
        this.A02 = i6 + 1;
        int i7 = this.A02;
        this.A02 = i7 + 1;
        int i8 = this.A02;
        this.A02 = i8 + 1;
        return ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i2]) & 255) << 48) | ((((long) bArr[i3]) & 255) << 40) | ((((long) bArr[i4]) & 255) << 32) | ((((long) bArr[i5]) & 255) << 24) | ((((long) bArr[i6]) & 255) << 16) | ((((long) bArr[i7]) & 255) << 8) | (255 & ((long) bArr[i8]));
    }

    public final long A0N() {
        byte[] bArr = this.A00;
        int i = this.A02;
        this.A02 = i + 1;
        int i2 = this.A02;
        this.A02 = i2 + 1;
        int i3 = this.A02;
        this.A02 = i3 + 1;
        int i4 = this.A02;
        this.A02 = i4 + 1;
        return ((((long) bArr[i]) & 255) << 24) | ((((long) bArr[i2]) & 255) << 16) | ((((long) bArr[i3]) & 255) << 8) | (255 & ((long) bArr[i4]));
    }

    public final long A0O() {
        long A0M = A0M();
        if (A0M >= 0) {
            return A0M;
        }
        throw new IllegalStateException(A00(77, 18, 35) + A0M);
    }

    public final long A0P() {
        int i = 0;
        long j = (long) this.A00[this.A02];
        int i2 = 7;
        while (true) {
            if (i2 < 0) {
                break;
            }
            int i3 = ((((long) (1 << i2)) & j) > 0 ? 1 : ((((long) (1 << i2)) & j) == 0 ? 0 : -1));
            if (A04[3].charAt(7) != 'H') {
                String[] strArr = A04;
                strArr[7] = "lhGNf9ZIwuKG";
                strArr[7] = "lhGNf9ZIwuKG";
                if (i3 != 0) {
                    i2--;
                } else if (i2 < 6) {
                    j &= (long) ((1 << i2) - 1);
                    i = 7 - i2;
                } else if (i2 == 7) {
                    i = 1;
                }
            } else {
                throw new RuntimeException();
            }
        }
        if (i != 0) {
            int i4 = 1;
            while (i4 < i) {
                byte b = this.A00[this.A02 + i4];
                if ((b & 192) == 128) {
                    long j2 = j << 6;
                    String[] strArr2 = A04;
                    if (strArr2[5].charAt(9) != strArr2[6].charAt(9)) {
                        String[] strArr3 = A04;
                        strArr3[7] = "BvJ8XuqLfWkj";
                        strArr3[7] = "BvJ8XuqLfWkj";
                        j = j2 | ((long) (b & 63));
                        i4 += 0;
                    } else {
                        String[] strArr4 = A04;
                        strArr4[7] = "bl64THqm1YbP";
                        strArr4[7] = "bl64THqm1YbP";
                        j = j2 | ((long) (b & 63));
                        i4++;
                    }
                } else {
                    throw new NumberFormatException(A00(0, 42, 126) + j);
                }
            }
            this.A02 += i;
            return j;
        }
        throw new NumberFormatException(A00(42, 35, 92) + j);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0096, code lost:
        if (r6.A02 == r3) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a7, code lost:
        if (r6.A02 == r3) goto L_0x0098;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String A0Q() {
        /*
        // Method dump skipped, instructions count: 185
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.IQ.A0Q():java.lang.String");
    }

    public final String A0R() {
        if (A05() == 0) {
            return null;
        }
        int i = this.A02;
        while (i < this.A01 && this.A00[i] != 0) {
            i++;
        }
        byte[] bArr = this.A00;
        int i2 = this.A02;
        String A0R = C0466Ig.A0R(bArr, i2, i - i2);
        this.A02 = i;
        int i3 = this.A02;
        if (i3 < this.A01) {
            this.A02 = i3 + 1;
        }
        return A0R;
    }

    public final String A0S(int lastIndex) {
        if (lastIndex == 0) {
            return A00(0, 0, 47);
        }
        int i = lastIndex;
        int i2 = (this.A02 + lastIndex) - 1;
        if (i2 < this.A01 && this.A00[i2] == 0) {
            i--;
        }
        String A0R = C0466Ig.A0R(this.A00, this.A02, i);
        this.A02 += lastIndex;
        return A0R;
    }

    public final String A0T(int i) {
        return A0U(i, Charset.forName(A00(95, 5, 98)));
    }

    public final String A0U(int i, Charset charset) {
        String str = new String(this.A00, this.A02, i, charset);
        this.A02 += i;
        return str;
    }

    public final short A0V() {
        byte[] bArr = this.A00;
        int i = this.A02;
        this.A02 = i + 1;
        int i2 = (bArr[i] & UByte.MAX_VALUE) << 8;
        int i3 = this.A02;
        this.A02 = i3 + 1;
        return (short) ((bArr[i3] & UByte.MAX_VALUE) | i2);
    }

    public final void A0W() {
        this.A02 = 0;
        this.A01 = 0;
    }

    public final void A0X(int i) {
        byte[] bArr;
        if (A06() < i) {
            bArr = new byte[i];
        } else {
            bArr = this.A00;
        }
        A0c(bArr, i);
    }

    public final void A0Y(int i) {
        boolean z;
        if (i < 0 || i > this.A00.length) {
            z = false;
        } else {
            z = true;
        }
        I1.A03(z);
        this.A01 = i;
    }

    public final void A0Z(int i) {
        boolean z;
        if (i < 0 || i > this.A01) {
            z = false;
        } else {
            z = true;
        }
        I1.A03(z);
        this.A02 = i;
    }

    public final void A0a(int i) {
        A0Z(this.A02 + i);
    }

    public final void A0b(IP ip, int i) {
        A0d(ip.A00, 0, i);
        ip.A08(0);
    }

    public final void A0c(byte[] bArr, int i) {
        this.A00 = bArr;
        this.A01 = i;
        this.A02 = 0;
    }

    public final void A0d(byte[] bArr, int i, int i2) {
        System.arraycopy(this.A00, this.A02, bArr, i, i2);
        this.A02 += i2;
    }
}
