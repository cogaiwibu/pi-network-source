package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Arrays;

public final class CV {
    public static String[] A04;
    public final int A00;
    public final int A01;
    public final int A02;
    public final byte[] A03;

    static {
        A00();
    }

    public static void A00() {
        A04 = new String[]{"mvf", "5vUSiUqvqexSVjGtqKGfn", "JwxxJCZPfqV7dBG9RK7xAyPr7ROekLAM", "", "XpEsaMQEhp4STG8PYYwcejEb1g", "Vmkb7cGbkehknCkwYPEH7uVKWZ5FPigs", "LeK9QdxXLgCTlktURPbNFMf3RZigSes2", "9odHEpKIuTJMz7KtuT4u9eB1nZm0XlV7"};
    }

    public CV(int i, byte[] bArr, int i2, int i3) {
        this.A01 = i;
        this.A03 = bArr;
        this.A02 = i2;
        this.A00 = i3;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CV cv = (CV) obj;
        if (this.A01 == cv.A01) {
            int i = this.A02;
            int i2 = cv.A02;
            String[] strArr = A04;
            if (strArr[0].length() != strArr[3].length()) {
                String[] strArr2 = A04;
                strArr2[2] = "eTvhBYpDKk9eWFXXJfKHFDj3AmOCaziB";
                strArr2[1] = "mkymkzw6fBYyEptVGXW89";
                if (i == i2 && this.A00 == cv.A00 && Arrays.equals(this.A03, cv.A03)) {
                    return true;
                }
                return false;
            }
            throw new RuntimeException();
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.A01 * 31) + Arrays.hashCode(this.A03)) * 31) + this.A02) * 31) + this.A00;
    }
}
