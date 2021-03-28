package com.facebook.ads.redexgen.X;

import android.util.Log;
import androidx.annotation.Nullable;
import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;

public final class D7 {
    public static byte[] A05;
    public static String[] A06;
    public final int A00;
    public final CV A01;
    @Nullable
    public final String A02;
    public final boolean A03;
    public final byte[] A04;

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A06;
            if (strArr[5].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[2] = "3n0Xyqau0qpDSx89MxSLBxd";
            strArr2[0] = "tz3h4DDpAPGNu8T48YqRwIi";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 103);
            i4++;
        }
    }

    public static void A02() {
        A05 = new byte[]{118, ByteCompanionObject.MAX_VALUE, 113, 16, 34, 34, 36, 60, 56, 63, 54, 113, 16, 20, 2, 124, 18, 5, 3, 113, 72, 110, 125, ByteCompanionObject.MAX_VALUE, 119, 89, 114, ByteCompanionObject.MAX_VALUE, 110, 101, 108, 104, 117, 115, 114, 94, 115, 100, 58, 1, 28, 26, 31, 31, 0, 29, 27, 10, 11, 79, 31, 29, 0, 27, 10, 12, 27, 6, 0, 1, 79, 28, 12, 7, 10, 2, 10, 79, 27, 22, 31, 10, 79, 72, 114, 115, 114, 32, 2, 3, 2, 18, 95, 89, 82, 95, 32, 38, 45, 48, 1, 16, 27, 18, 22, 13, 66, 15, 13, 6, 7, 76};
    }

    public static void A03() {
        A06 = new String[]{"C09qkhbo3vRSWUJSgSkEV0X", "WA1yWV5061NHQxIGBHZdG7C7pKjO5Y9H", "pYBemDtXYAadS99Nmeaz8GF", "NyHZMe4zCbCNgYs1LmeICE7hAZM3ASIf", "", "Aq1CtCEX8aJa", "3dQVxpobetg6gtuImvAOL3PNXFyzfQ27", "PtQ4b0lS5cBc"};
    }

    public D7(boolean z, @Nullable String str, int i, byte[] bArr, int i2, int i3, @Nullable byte[] bArr2) {
        boolean z2;
        boolean z3 = true;
        if (i == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        I1.A03((bArr2 != null ? false : z3) ^ z2);
        this.A03 = z;
        this.A02 = str;
        this.A00 = i;
        this.A04 = bArr2;
        this.A01 = new CV(A00(str), bArr, i2, i3);
    }

    public static int A00(@Nullable String str) {
        if (str == null) {
            return 1;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case 3046605:
                if (str.equals(A01(74, 4, 118))) {
                    c = 2;
                    break;
                }
                break;
            case 3046671:
                if (str.equals(A01(78, 4, 6))) {
                    c = 3;
                    break;
                }
                break;
            case 3049879:
                if (str.equals(A01(82, 4, 91))) {
                    c = 0;
                    break;
                }
                break;
            case 3049895:
                if (str.equals(A01(86, 4, 36))) {
                    c = 1;
                    break;
                }
                break;
        }
        if (c == 0 || c == 1) {
            return 1;
        }
        if (c == 2 || c == 3) {
            return 2;
        }
        Log.w(A01(20, 18, 123), A01(38, 36, 8) + str + A01(0, 20, 54) + A01(90, 12, 5));
        return 1;
    }
}
