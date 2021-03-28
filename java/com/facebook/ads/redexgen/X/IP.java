package com.facebook.ads.redexgen.X;

import androidx.core.view.MotionEventCompat;
import kotlin.UByte;

public final class IP {
    public static String[] A04;
    public byte[] A00;
    public int A01;
    public int A02;
    public int A03;

    static {
        A01();
    }

    public static void A01() {
        A04 = new String[]{"RHSjJGYddlOPzslamo8j", "no2wrOKISs4wdINa", "E7xZIMZbElFQthX5cbe1zXMBiqq9Oct2", "NQ4djAykaRRiHV2nkQWoiztobM3LGBfO", "EDikhWaymQH2jtWvDyx1vViO84FhvN", "TllFBKS94wZfNNX6FcczOhdwmX6snrOZ", "CS63JXje", "QpZzHKHty24GTaxrVVV4B8DIrBZ4Gw8P"};
    }

    public IP() {
    }

    public IP(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public IP(byte[] bArr, int i) {
        this.A00 = bArr;
        this.A02 = i;
    }

    private void A00() {
        boolean z;
        int i;
        int i2 = this.A03;
        if (i2 < 0 || (i2 >= (i = this.A02) && !(i2 == i && this.A01 == 0))) {
            z = false;
        } else {
            z = true;
        }
        I1.A04(z);
    }

    public final int A02() {
        return ((this.A02 - this.A03) * 8) - this.A01;
    }

    public final int A03() {
        boolean z;
        if (this.A01 == 0) {
            z = true;
        } else {
            z = false;
        }
        I1.A04(z);
        return this.A03;
    }

    public final int A04() {
        return (this.A03 * 8) + this.A01;
    }

    public final int A05(int returnValue) {
        int i;
        if (returnValue == 0) {
            return 0;
        }
        int i2 = 0;
        this.A01 += returnValue;
        while (true) {
            i = this.A01;
            if (i <= 8) {
                break;
            }
            this.A01 = i - 8;
            byte[] bArr = this.A00;
            int i3 = this.A03;
            this.A03 = i3 + 1;
            i2 |= (bArr[i3] & UByte.MAX_VALUE) << this.A01;
        }
        byte[] bArr2 = this.A00;
        int i4 = this.A03;
        int i5 = (i2 | ((bArr2[i4] & UByte.MAX_VALUE) >> (8 - i))) & (-1 >>> (32 - returnValue));
        if (i == 8) {
            this.A01 = 0;
            this.A03 = i4 + 1;
        }
        A00();
        return i5;
    }

    public final void A06() {
        if (this.A01 != 0) {
            this.A01 = 0;
            this.A03++;
            A00();
        }
    }

    public final void A07() {
        int i = this.A01 + 1;
        this.A01 = i;
        if (i == 8) {
            this.A01 = 0;
            this.A03++;
        }
        A00();
    }

    public final void A08(int i) {
        this.A03 = i / 8;
        this.A01 = i - (this.A03 * 8);
        A00();
    }

    public final void A09(int i) {
        int i2 = i / 8;
        this.A03 += i2;
        this.A01 += i - (i2 * 8);
        int i3 = this.A01;
        if (i3 > 7) {
            this.A03++;
            this.A01 = i3 - 8;
        }
        A00();
    }

    public final void A0A(int i) {
        boolean z;
        if (this.A01 == 0) {
            z = true;
        } else {
            z = false;
        }
        I1.A04(z);
        this.A03 += i;
        A00();
    }

    /* JADX INFO: Multiple debug info for r10v0 int: [D('firstByteReadSize' int), D('lastByteRightPaddingSize' int)] */
    public final void A0B(int i, int lastByteRightPaddingSize) {
        if (lastByteRightPaddingSize < 32) {
            i &= (1 << lastByteRightPaddingSize) - 1;
        }
        int min = Math.min(8 - this.A01, lastByteRightPaddingSize);
        int firstByteRightPaddingSize = this.A01;
        int i2 = (8 - firstByteRightPaddingSize) - min;
        int i3 = (MotionEventCompat.ACTION_POINTER_INDEX_MASK >> firstByteRightPaddingSize) | ((1 << i2) - 1);
        byte[] bArr = this.A00;
        int i4 = this.A03;
        bArr[i4] = (byte) (bArr[i4] & i3);
        bArr[i4] = (byte) (bArr[i4] | ((i >>> (lastByteRightPaddingSize - min)) << i2));
        int i5 = lastByteRightPaddingSize - min;
        int i6 = i4 + 1;
        while (i5 > 8) {
            this.A00[i6] = (byte) (i >>> (i5 - 8));
            i5 -= 8;
            i6++;
        }
        int currentByteIndex = 8 - i5;
        byte[] bArr2 = this.A00;
        bArr2[i6] = (byte) (bArr2[i6] & ((1 << currentByteIndex) - 1));
        byte b = (byte) (bArr2[i6] | ((i & ((1 << i5) - 1)) << currentByteIndex));
        if (A04[3].charAt(20) != 'i') {
            throw new RuntimeException();
        }
        String[] strArr = A04;
        strArr[4] = "HDn8cIfTWSkx257fNKtZvpUDi4vYZW";
        strArr[6] = "YQkUGCO4";
        bArr2[i6] = b;
        A09(lastByteRightPaddingSize);
        A00();
    }

    public final void A0C(byte[] bArr) {
        A0D(bArr, bArr.length);
    }

    public final void A0D(byte[] bArr, int i) {
        this.A00 = bArr;
        this.A03 = 0;
        this.A01 = 0;
        this.A02 = i;
    }

    /* JADX INFO: Multiple debug info for r10v0 byte[]: [D('i' int), D('bitsLeft' int)] */
    public final void A0E(byte[] bArr, int i, int i2) {
        int i3 = (i2 >> 3) + i;
        while (i < i3) {
            byte[] bArr2 = this.A00;
            int i4 = this.A03;
            this.A03 = i4 + 1;
            byte b = bArr2[i4];
            int i5 = this.A01;
            bArr[i] = (byte) (b << i5);
            bArr[i] = (byte) (((255 & bArr2[this.A03]) >> (8 - i5)) | bArr[i]);
            i++;
        }
        int i6 = i2 & 7;
        if (i6 != 0) {
            bArr[i3] = (byte) (bArr[i3] & (255 >> i6));
            int i7 = this.A01;
            if (i7 + i6 > 8) {
                byte b2 = bArr[i3];
                byte[] bArr3 = this.A00;
                int i8 = this.A03;
                this.A03 = i8 + 1;
                bArr[i3] = (byte) (b2 | ((bArr3[i8] & UByte.MAX_VALUE) << i7));
                this.A01 = i7 - 8;
            }
            this.A01 += i6;
            byte[] bArr4 = this.A00;
            int i9 = this.A03;
            int i10 = this.A01;
            bArr[i3] = (byte) (bArr[i3] | ((byte) (((255 & bArr4[i9]) >> (8 - i10)) << (8 - i6))));
            if (i10 == 8) {
                this.A01 = 0;
                this.A03 = i9 + 1;
            }
            A00();
        }
    }

    public final void A0F(byte[] bArr, int i, int i2) {
        boolean z;
        if (this.A01 == 0) {
            z = true;
        } else {
            z = false;
        }
        I1.A04(z);
        System.arraycopy(this.A00, this.A03, bArr, i, i2);
        this.A03 += i2;
        A00();
    }

    public final boolean A0G() {
        boolean z;
        if ((this.A00[this.A03] & (128 >> this.A01)) != 0) {
            z = true;
        } else {
            z = false;
        }
        A07();
        return z;
    }
}
