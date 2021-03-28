package com.facebook.ads.redexgen.X;

import kotlin.UByte;

public final class IR {
    public static String[] A04;
    public int A00;
    public int A01;
    public int A02;
    public byte[] A03;

    static {
        A02();
    }

    public static void A02() {
        A04 = new String[]{"c84vrcH31LBgkMTCK1bohHlXVMnz9AJR", "d1OdysF2oEJNIHjT9033ROKyCX5j9bI3", "fxcqndjlyXUHbVpCK9jm", "aT6eQk8J7bmxuuGVWtHexoeTGFRtLCio", "ywK9OdvkymoDgjlaSqX1MXgGISTKD1G", "kvGKIZl1lyVjOHyD1SwfLq7Qy0hyNYJA", "P5ZowT1yJlaZidguBbmn", "kEUPdIGxbWMHKqV30QNAKk8CqZCFjcZl"};
    }

    public IR(byte[] bArr, int i, int i2) {
        A09(bArr, i, i2);
    }

    private int A00() {
        int i = 0;
        while (!A0B()) {
            i++;
        }
        int i2 = (1 << i) - 1;
        if (A04[5].charAt(7) != 'Z') {
            String[] strArr = A04;
            strArr[1] = "EO6sj55N530JbeetbwPxyBKxcCLP9BzL";
            strArr[0] = "oyZlo8wPjIkpHiFdOrp6pSDhzRhw9ZCk";
            return i2 + (i > 0 ? A06(i) : 0);
        }
        throw new RuntimeException();
    }

    private void A01() {
        boolean z;
        int i;
        int i2 = this.A02;
        if (i2 < 0 || (i2 >= (i = this.A01) && !(i2 == i && this.A00 == 0))) {
            z = false;
        } else {
            z = true;
        }
        I1.A04(z);
    }

    private boolean A03(int i) {
        if (2 <= i && i < this.A01) {
            byte[] bArr = this.A03;
            return bArr[i] == 3 && bArr[i + -2] == 0 && bArr[i + -1] == 0;
        }
    }

    public final int A04() {
        int A002 = A00();
        return (A002 % 2 == 0 ? -1 : 1) * ((A002 + 1) / 2);
    }

    public final int A05() {
        return A00();
    }

    public final int A06(int i) {
        int i2;
        int i3;
        int i4 = 0;
        this.A00 += i;
        while (true) {
            i2 = this.A00;
            i3 = 2;
            if (i2 <= 8) {
                break;
            }
            this.A00 = i2 - 8;
            byte[] bArr = this.A03;
            int i5 = this.A02;
            i4 |= (bArr[i5] & UByte.MAX_VALUE) << this.A00;
            if (!A03(i5 + 1)) {
                i3 = 1;
            }
            this.A02 = i5 + i3;
        }
        byte[] bArr2 = this.A03;
        int i6 = this.A02;
        int i7 = (i4 | ((bArr2[i6] & UByte.MAX_VALUE) >> (8 - i2))) & (-1 >>> (32 - i));
        if (i2 == 8) {
            this.A00 = 0;
            if (!A03(i6 + 1)) {
                i3 = 1;
            }
            this.A02 = i6 + i3;
        }
        A01();
        String[] strArr = A04;
        if (strArr[6].length() != strArr[2].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[1] = "VwcsjLhlZd9I2ct9XMdPqerwWVhD9SnY";
        strArr2[0] = "SEOCmBzyD2oxYau0L8QhU7fYZrlA9WRm";
        return i7;
    }

    public final void A07() {
        int i = 1;
        int i2 = this.A00 + 1;
        this.A00 = i2;
        if (i2 == 8) {
            this.A00 = 0;
            int i3 = this.A02;
            if (A03(i3 + 1)) {
                i = 2;
            }
            this.A02 = i3 + i;
        }
        A01();
    }

    public final void A08(int numBytes) {
        int i = this.A02;
        int i2 = numBytes / 8;
        this.A02 += i2;
        this.A00 += numBytes - (i2 * 8);
        int i3 = this.A00;
        if (i3 > 7) {
            this.A02++;
            this.A00 = i3 - 8;
        }
        while (true) {
            i++;
            int i4 = this.A02;
            String[] strArr = A04;
            if (strArr[6].length() != strArr[2].length()) {
                break;
            }
            String[] strArr2 = A04;
            strArr2[7] = "16ru2e8lXVuKccLj62CTuGGODJDTLMLs";
            strArr2[3] = "ss2rTXlJnNbrcKU9GLjWVNttz382myoQ";
            if (i <= i4) {
                boolean A032 = A03(i);
                String[] strArr3 = A04;
                if (strArr3[6].length() != strArr3[2].length()) {
                    break;
                }
                String[] strArr4 = A04;
                strArr4[6] = "8iP0ukDWZhsNH03XWb9d";
                strArr4[2] = "2ETrOFK8hCpKH2QuP6pQ";
                if (A032) {
                    this.A02++;
                    i += 2;
                }
            } else {
                A01();
                return;
            }
        }
        throw new RuntimeException();
    }

    public final void A09(byte[] bArr, int i, int i2) {
        this.A03 = bArr;
        this.A02 = i;
        this.A01 = i2;
        this.A00 = 0;
        A01();
    }

    public final boolean A0A() {
        boolean z;
        int initialBitOffset = this.A02;
        int leadingZeros = this.A00;
        int i = 0;
        while (this.A02 < this.A01 && !A0B()) {
            i++;
        }
        if (this.A02 == this.A01) {
            z = true;
        } else {
            z = false;
        }
        this.A02 = initialBitOffset;
        this.A00 = leadingZeros;
        if (A04[5].charAt(7) != 'Z') {
            String[] strArr = A04;
            strArr[7] = "4CnifSrgKpd7e7K0x8WVIkfErouhzSPT";
            strArr[3] = "4ZydgevgZqNlOfL3PtmcBBhuPOTZ7C4b";
            if (z || !A0C((i * 2) + 1)) {
                return false;
            }
            return true;
        }
        throw new RuntimeException();
    }

    public final boolean A0B() {
        boolean z;
        if ((this.A03[this.A02] & (128 >> this.A00)) != 0) {
            z = true;
        } else {
            z = false;
        }
        A07();
        return z;
    }

    public final boolean A0C(int numBytes) {
        int newByteOffset = this.A02;
        int i = numBytes / 8;
        int i2 = this.A02 + i;
        int i3 = (this.A00 + numBytes) - (i * 8);
        if (i3 > 7) {
            i2++;
            i3 -= 8;
        }
        int i4 = newByteOffset + 1;
        while (i4 <= i2 && i2 < this.A01) {
            if (A03(i4)) {
                i2++;
                i4 += 2;
            }
            i4++;
        }
        int newBitOffset = this.A01;
        if (i2 < newBitOffset) {
            return true;
        }
        if (i2 == newBitOffset && i3 == 0) {
            return true;
        }
        return false;
    }
}
