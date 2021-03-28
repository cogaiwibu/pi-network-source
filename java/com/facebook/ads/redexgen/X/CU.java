package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;

public final class CU {
    public static byte[] A02;
    public static String[] A03;
    public static final CU A04 = new CU(0, 0);
    public final long A00;
    public final long A01;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 52);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{108, 96, 48, 47, 51, 41, 52, 41, 47, 46, 125, 77, 98, ByteCompanionObject.MAX_VALUE, 123, 115, 67, 101, 43, 45};
    }

    public static void A02() {
        A03 = new String[]{"cQLvPfcjFfYJvX4XY3", "uIOH2wHfxCa8KV3", "FH84zRbfI70JKMZ4FU0vq663g5qgVVhf", "rAS8R46BE4hr4L2BuvPBBTIYPMpqY", "3BFkdmsCGoZH4fXk29OjuKfr1IH2YrFg", "mQzkGmJwq71pGAE", "g0LYTBuRUFd8u9nYrg", "Ct1y1JOzLdrho3HlQk4TLP9PG3jGo5Mx"};
    }

    static {
        A02();
        A01();
    }

    public CU(long j, long j2) {
        this.A01 = j;
        this.A00 = j2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        String[] strArr = A03;
        if (strArr[0].length() != strArr[6].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A03;
        strArr2[5] = "kVmnPrTsp7Csw7b";
        strArr2[1] = "Hha8DC9juDwuQlk";
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CU cu = (CU) obj;
        if (this.A01 == cu.A01 && this.A00 == cu.A00) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.A01) * 31) + ((int) this.A00);
    }

    public final String toString() {
        return A00(11, 8, 34) + this.A01 + A00(0, 11, 116) + this.A00 + A00(19, 1, 68);
    }
}
