package com.facebook.ads.redexgen.X;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.Arrays;

public final class HQ {
    public static byte[] A07;
    public final int A00;
    public final long A01;
    public final long A02;
    public final long A03;
    public final Uri A04;
    @Nullable
    public final String A05;
    @Nullable
    public final byte[] A06;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 28);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A07 = new byte[]{-110, -122, 122, -105, -86, -105, -119, -90, -101, -103, -111, -60};
    }

    public HQ(Uri uri, long j, long j2, long j3, @Nullable String str, int i) {
        this(uri, null, j, j2, j3, str, i);
    }

    public HQ(Uri uri, long j, long j2, @Nullable String str) {
        this(uri, j, j, j2, str, 0);
    }

    public HQ(Uri uri, long j, long j2, @Nullable String str, int i) {
        this(uri, j, j, j2, str, i);
    }

    public HQ(Uri uri, @Nullable byte[] bArr, long j, long j2, long j3, @Nullable String str, int i) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        I1.A03(z);
        if (j2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        I1.A03(z2);
        if (j3 <= 0 && j3 != -1) {
            z3 = false;
        }
        I1.A03(z3);
        this.A04 = uri;
        this.A06 = bArr;
        this.A01 = j;
        this.A03 = j2;
        this.A02 = j3;
        this.A05 = str;
        this.A00 = i;
    }

    public final boolean A02(int i) {
        return (this.A00 & i) == i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(A00(2, 9, 26));
        sb.append(this.A04);
        String A002 = A00(0, 2, 74);
        sb.append(A002);
        sb.append(Arrays.toString(this.A06));
        sb.append(A002);
        sb.append(this.A01);
        sb.append(A002);
        sb.append(this.A03);
        sb.append(A002);
        sb.append(this.A02);
        sb.append(A002);
        sb.append(this.A05);
        sb.append(A002);
        sb.append(this.A00);
        sb.append(A00(11, 1, 75));
        return sb.toString();
    }
}
