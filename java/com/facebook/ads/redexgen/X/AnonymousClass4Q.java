package com.facebook.ads.redexgen.X;

import android.view.animation.Interpolator;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.4Q  reason: invalid class name */
public class AnonymousClass4Q {
    public static byte[] A07;
    public static String[] A08;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public Interpolator A05;
    public boolean A06;

    static {
        A03();
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 35);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A07 = new byte[]{111, 64, 6, 95, 73, 83, 6, 86, 84, 73, 80, 79, 66, 67, 6, 71, 72, 6, 79, 72, 82, 67, 84, 86, 73, 74, 71, 82, 73, 84, 10, 6, 95, 73, 83, 6, 75, 83, 85, 82, 6, 85, 67, 82, 6, 71, 6, 86, 73, 85, 79, 82, 79, 80, 67, 6, 66, 83, 84, 71, 82, 79, 73, 72, 8, 63, 57, 35, 57, 54, 63, 40, 12, 51, 63, 45, 30, 46, 63, 34, 33, 33, 109, 41, 56, 63, 44, 57, 36, 34, 35, 109, 32, 56, 62, 57, 109, 47, 40, 109, 44, 109, 61, 34, 62, 36, 57, 36, 59, 40, 109, 35, 56, 32, 47, 40, 63, 102, 88, 90, 90, 65, 93, 21, 102, 86, 71, 90, 89, 89, 21, 84, 86, 65, 92, 90, 91, 21, 92, 70, 21, 87, 80, 92, 91, 82, 21, 64, 69, 81, 84, 65, 80, 81, 21, 65, 90, 90, 21, 83, 71, 80, 68, 64, 80, 91, 65, 89, 76, 27, 21, 120, 84, 94, 80, 21, 70, 64, 71, 80, 21, 76, 90, 64, 21, 84, 71, 80, 21, 91, 90, 65, 21, 86, 93, 84, 91, 82, 92, 91, 82, 21, 92, 65, 21, 64, 91, 89, 80, 70, 70, 21, 91, 80, 86, 80, 70, 70, 84, 71, 76};
    }

    public static void A03() {
        A08 = new String[]{"mhxsSpCIE", "HPHd8ajTElCt4xjey", "7Zb31Oi", "DD", "BNYok10xEf4gIs6uNCWHihSbJqoYG9kt", "IDmLc2m45tKSy5LkWISCl9o5476O0eoP", "nkkzGeiOD1wUj3jYejs7CProiVmlcOmv", "T15Acsoxou"};
    }

    public AnonymousClass4Q(int i, int i2) {
        this(i, i2, Integer.MIN_VALUE, null);
    }

    public AnonymousClass4Q(int i, int i2, int i3, Interpolator interpolator) {
        this.A04 = -1;
        this.A06 = false;
        this.A00 = 0;
        this.A02 = i;
        this.A03 = i2;
        this.A01 = i3;
        this.A05 = interpolator;
    }

    private void A01() {
        if (this.A05 != null && this.A01 < 1) {
            throw new IllegalStateException(A00(0, 64, 5));
        } else if (this.A01 < 1) {
            throw new IllegalStateException(A00(76, 41, 110));
        }
    }

    public final void A04(int i) {
        this.A04 = i;
    }

    public final void A05(int i, int i2, int i3, Interpolator interpolator) {
        this.A02 = i;
        this.A03 = i2;
        this.A01 = i3;
        this.A05 = interpolator;
        this.A06 = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0057, code lost:
        if (r4 == Integer.MIN_VALUE) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0094, code lost:
        if (r4 == Integer.MIN_VALUE) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0097, code lost:
        r7.A08.A0C(r6.A02, r6.A03, r6.A01);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void A06(com.facebook.ads.redexgen.X.ES r7) {
        /*
        // Method dump skipped, instructions count: 186
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass4Q.A06(com.facebook.ads.redexgen.X.ES):void");
    }

    public final boolean A07() {
        return this.A04 >= 0;
    }
}
