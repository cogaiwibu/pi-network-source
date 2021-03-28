package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import androidx.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.Gy  reason: case insensitive filesystem */
public final class C0432Gy {
    public static String[] A03;
    public final int A00;
    public final int A01;
    @Nullable
    public final String A02;

    static {
        A00();
    }

    public static void A00() {
        A03 = new String[]{"JpQuEMJyhkDDwoW2qnimD48iH4", "zq20t8z5PSjLxyVHdDvtiCtXPLpdqU3i", "so9HDpzw9NbS3t5s7rLQl2iaR2XAJ3iQ", "SPSQ89YBqvY9lwFZlxdH4ztJ", "r8lQcfIA9xflC1biO54W", "tOh5wxE3", "g5QR5HO0jbZc71FO4Igm6aH5aV", "ocODke0nsuLbpuPtat5dt9ny7kJ7l6fu"};
    }

    public C0432Gy(int i, int i2, @Nullable String str) {
        this.A00 = i;
        this.A01 = i2;
        this.A02 = str;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        String[] strArr = A03;
        if (strArr[5].length() != strArr[4].length()) {
            String[] strArr2 = A03;
            strArr2[7] = "ASeEdSOeJHMbddf2fOqd0PFHGr8KWkVO";
            strArr2[7] = "ASeEdSOeJHMbddf2fOqd0PFHGr8KWkVO";
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0432Gy gy = (C0432Gy) obj;
            if (this.A00 == gy.A00 && this.A01 == gy.A01 && TextUtils.equals(this.A02, gy.A02)) {
                return true;
            }
            return false;
        }
        throw new RuntimeException();
    }

    public final int hashCode() {
        int result;
        int i = ((this.A00 * 31) + this.A01) * 31;
        String str = this.A02;
        if (str != null) {
            result = str.hashCode();
        } else {
            result = 0;
        }
        return i + result;
    }
}
