package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.extractor.Extractor;
import java.lang.reflect.Constructor;
import java.util.Arrays;

public final class YE implements CN {
    public static byte[] A06;
    public static final Constructor<? extends CK> A07;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05 = 1;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 75);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A06 = new byte[]{4, 51, 51, 46, 51, 97, 40, 47, 50, 53, 32, 47, 53, 40, 32, 53, 40, 47, 38, 97, 7, 13, 0, 2, 97, 36, 57, 53, 36, 47, 50, 40, 46, 47, 37, 30, 21, 8, 0, 21, 19, 4, 21, 20, 80, 21, 2, 2, 31, 2, 80, 19, 2, 21, 17, 4, 25, 30, 23, 80, 54, 60, 49, 51, 80, 21, 8, 4, 2, 17, 19, 4, 31, 2, 98, 110, 108, 47, 103, 96, 98, 100, 99, 110, 110, 106, 47, 96, 101, 114, 47, 104, 111, 117, 100, 115, 111, 96, 109, 47, 100, 121, 110, 113, 109, 96, 120, 100, 115, 51, 47, 100, 121, 117, 47, 103, 109, 96, 98, 47, 71, 109, 96, 98, 68, 121, 117, 115, 96, 98, 117, 110, 115};
    }

    static {
        A01();
        Constructor<? extends Extractor> flacExtractorConstructor = null;
        try {
            flacExtractorConstructor = Class.forName(A00(74, 59, 74)).asSubclass(CK.class).getConstructor(new Class[0]);
        } catch (ClassNotFoundException unused) {
        } catch (Exception e) {
            throw new RuntimeException(A00(0, 34, 10), e);
        }
        A07 = flacExtractorConstructor;
    }

    @Override // com.facebook.ads.redexgen.X.CN
    public final synchronized CK[] A4H() {
        CK[] ckArr;
        ckArr = new CK[(A07 == null ? 12 : 13)];
        ckArr[0] = new YT(this.A01);
        ckArr[1] = new C0868Yd(this.A00);
        ckArr[2] = new C0870Yf(this.A03);
        ckArr[3] = new YW(this.A02);
        ckArr[4] = new C0885Yu();
        ckArr[5] = new C0882Yr();
        ckArr[6] = new ZD(this.A05, this.A04);
        ckArr[7] = new YM();
        ckArr[8] = new C0876Yl();
        ckArr[9] = new Z7();
        ckArr[10] = new ZF();
        ckArr[11] = new YJ();
        if (A07 != null) {
            try {
                ckArr[12] = (CK) A07.newInstance(new Object[0]);
            } catch (Exception e) {
                throw new IllegalStateException(A00(34, 40, 59), e);
            }
        }
        return ckArr;
    }
}
