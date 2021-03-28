package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Arrays;

public final class H9 {
    public static String[] A03;
    public int A00;
    public final int A01;
    public final H8[] A02;

    static {
        A00();
    }

    public static void A00() {
        A03 = new String[]{"uPzvf3DrMkTy6OC2", "H2eIGrw6YlTuEfUMB", "p11InAYoC", "jGz94J", "ZtEJrdVWV1XC8XFg6mMZlCv5mMRi1ND1", "Ub1YY0rlTcSKb3yBclMaPE0dIwwpm8Yp", "Au1lLpT3HfOHruCfEBskEQ20fDVmu", "jui1pWNgNEO"};
    }

    public H9(H8... h8Arr) {
        this.A02 = h8Arr;
        this.A01 = h8Arr.length;
    }

    @Nullable
    public final H8 A01(int i) {
        return this.A02[i];
    }

    public final H8[] A02() {
        return (H8[]) this.A02.clone();
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        H9 h9 = (H9) obj;
        String[] strArr = A03;
        if (strArr[1].length() != strArr[6].length()) {
            String[] strArr2 = A03;
            strArr2[5] = "VymNKk7BYdZfYlSqFiIbjljOXHtGYALy";
            strArr2[4] = "eUsLwIc5zFGsQcnFIY6bSbYyt6aFMI1L";
            return Arrays.equals(this.A02, h9.A02);
        }
        throw new RuntimeException();
    }

    public final int hashCode() {
        if (this.A00 == 0) {
            this.A00 = (17 * 31) + Arrays.hashCode(this.A02);
        }
        return this.A00;
    }
}
