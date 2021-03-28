package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;

public final class FG {
    public static String[] A04;
    public final int A00;
    public final int A01;
    public final int A02;
    public final long A03;

    static {
        A00();
    }

    public static void A00() {
        A04 = new String[]{"QAVxR1pm4g3OMy63NQvftsN2xqVHZpJs", "AzW64QlkVBQHB9f6Xzc9fy5MjwuFwf", "EYWLKn1ZI2FgvzG2Y3WEpQG0rKYdGsmO", "8MKSyYZIic", "8HCh", "B2G9RsjiNaG6Fd9EDgK8ZSLtpMYMPZWp", "0LWAgqDnvmn5Zl5Tjazxu4DQCyM2IyoB", "wKpHaIMIJd"};
    }

    public FG(int i) {
        this(i, -1);
    }

    public FG(int i, int i2, int i3, long j) {
        this.A02 = i;
        this.A00 = i2;
        this.A01 = i3;
        this.A03 = j;
    }

    public FG(int i, long j) {
        this(i, -1, -1, j);
    }

    public final FG A01(int i) {
        return this.A02 == i ? this : new FG(i, this.A00, this.A01, this.A03);
    }

    public final boolean A02() {
        return this.A00 != -1;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FG fg = (FG) obj;
        if (this.A02 == fg.A02 && this.A00 == fg.A00) {
            int i = this.A01;
            int i2 = fg.A01;
            if (A04[6].charAt(12) != 'Y') {
                String[] strArr = A04;
                strArr[6] = "oyJ32Yzo0dJhSwoxIDwlIRMSMQ1R6SLA";
                strArr[6] = "oyJ32Yzo0dJhSwoxIDwlIRMSMQ1R6SLA";
                if (i == i2 && this.A03 == fg.A03) {
                    return true;
                }
                return false;
            }
            throw new RuntimeException();
        }
        return false;
    }

    public final int hashCode() {
        return (((((((17 * 31) + this.A02) * 31) + this.A00) * 31) + this.A01) * 31) + ((int) this.A03);
    }
}
