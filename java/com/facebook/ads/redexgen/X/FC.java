package com.facebook.ads.redexgen.X;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

public final class FC {
    public static byte[] A03;
    public static String[] A04;
    public CK A00;
    public final CM A01;
    public final CK[] A02;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            byte b = (byte) ((copyOfRange[i4] ^ i3) ^ 114);
            String[] strArr = A04;
            if (strArr[1].charAt(6) != strArr[3].charAt(6)) {
                String[] strArr2 = A04;
                strArr2[4] = "mNEvNMISV2TsjErCZLDNSt4mIeKbSMWU";
                strArr2[2] = "pkwADRIgEHU8NI8rqtSVQew0tEayD06s";
                copyOfRange[i4] = b;
            } else {
                throw new RuntimeException();
            }
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{94, 87, 20, 24, 2, 27, 19, 87, 5, 18, 22, 19, 87, 3, 31, 18, 87, 4, 3, 5, 18, 22, 26, 89, 65, 96, 97, 106, 47, 96, 105, 47, 123, 103, 106, 47, 110, 121, 110, 102, 99, 110, 109, 99, 106, 47, 106, 119, 123, 125, 110, 108, 123, 96, 125, 124, 47, 39};
    }

    public static void A02() {
        A04 = new String[]{"bxXiKI", "1uDei3qzNnKNtNYr8Y2Djp0HGajvtEV5", "mOXymc7srnaPPj6rkYKERyI3NxuvjHfL", "eLJeQSRGsG8qXjpz5HdRmaYCfpHE06ps", "tIHnpnFG5Gy9TDLwgByCKCMlkPhTptnY", "feqrkYPgdz0GJjq4", "3AbGJoGZCQZs42EqNNbBdZ7jf", "CWkuEW"};
    }

    public FC(CK[] ckArr, CM cm) {
        this.A02 = ckArr;
        this.A01 = cm;
    }

    public final CK A03(CL cl, Uri uri) throws IOException, InterruptedException {
        CK ck = this.A00;
        if (ck != null) {
            return ck;
        }
        CK[] ckArr = this.A02;
        int length = ckArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            CK ck2 = ckArr[i];
            try {
                if (ck2.ADH(cl)) {
                    this.A00 = ck2;
                    cl.ACa();
                    break;
                }
                cl.ACa();
                i++;
            } catch (EOFException unused) {
            } catch (Throwable th) {
                cl.ACa();
                throw th;
            }
        }
        CK ck3 = this.A00;
        if (A04[6].length() != 13) {
            String[] strArr = A04;
            strArr[0] = "fQ5Ua6";
            strArr[7] = "HZXGBz";
            if (ck3 != null) {
                ck3.A7Q(this.A01);
                return this.A00;
            }
            throw new C0914a1(A00(24, 34, 125) + C0466Ig.A0S(this.A02) + A00(0, 24, 5), uri);
        }
        throw new RuntimeException();
    }

    public final void A04() {
        if (this.A00 != null) {
            this.A00 = null;
        }
    }
}
