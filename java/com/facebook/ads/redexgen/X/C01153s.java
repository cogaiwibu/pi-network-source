package com.facebook.ads.redexgen.X;

import android.view.View;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.3s  reason: invalid class name and case insensitive filesystem */
public class C01153s {
    public static byte[] A05;
    public int A00;
    public int A01;
    public boolean A02;
    public boolean A03;
    public final /* synthetic */ SW A04;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 124);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{13, 1, 76, 98, 78, 78, 83, 69, 72, 79, 64, 85, 68, 28, 111, 99, 46, 15, 34, 58, 44, 54, 55, 5, 49, 44, 46, 6, 45, 39, 126, 91, 87, 26, 33, 22, 27, 30, 19, 74, 116, 91, 86, 93, 90, 71, 124, 91, 83, 90, 78, 88, 101, 90, 70, 92, 65, 92, 90, 91, 8};
    }

    public C01153s(SW sw) {
        this.A04 = sw;
        A03();
    }

    public final void A02() {
        int A0A;
        if (this.A02) {
            A0A = this.A04.A04.A07();
        } else {
            A0A = this.A04.A04.A0A();
        }
        this.A00 = A0A;
    }

    public final void A03() {
        this.A01 = -1;
        this.A00 = Integer.MIN_VALUE;
        this.A02 = false;
        this.A03 = false;
    }

    public final void A04(View view) {
        if (this.A02) {
            this.A00 = this.A04.A04.A0C(view) + this.A04.A04.A05();
        } else {
            this.A00 = this.A04.A04.A0F(view);
        }
        this.A01 = this.A04.A0q(view);
    }

    /* JADX INFO: Multiple debug info for r7v0 android.view.View: [D('childStart' int), D('prevLayoutEnd' int)] */
    /* JADX INFO: Multiple debug info for r0v33 int: [D('childSize' int), D('childEnd' int)] */
    /* JADX INFO: Multiple debug info for r0v41 int: [D('layoutStart' int), D('startReference' int)] */
    public final void A05(View view) {
        int estimatedEnd = this.A04.A04.A05();
        if (estimatedEnd >= 0) {
            A04(view);
            return;
        }
        this.A01 = this.A04.A0q(view);
        if (this.A02) {
            int A07 = (this.A04.A04.A07() - estimatedEnd) - this.A04.A04.A0C(view);
            this.A00 = this.A04.A04.A07() - A07;
            if (A07 > 0) {
                int previousEndMargin = this.A00 - this.A04.A04.A0D(view);
                int A0A = this.A04.A04.A0A();
                int previousEndMargin2 = previousEndMargin - (Math.min(this.A04.A04.A0F(view) - A0A, 0) + A0A);
                if (previousEndMargin2 < 0) {
                    this.A00 += Math.min(A07, -previousEndMargin2);
                    return;
                }
                return;
            }
            return;
        }
        int A0F = this.A04.A04.A0F(view);
        int A0A2 = A0F - this.A04.A04.A0A();
        this.A00 = A0F;
        if (A0A2 > 0) {
            int estimatedEnd2 = (this.A04.A04.A07() - Math.min(0, (this.A04.A04.A07() - estimatedEnd) - this.A04.A04.A0C(view))) - (this.A04.A04.A0D(view) + A0F);
            if (estimatedEnd2 < 0) {
                this.A00 -= Math.min(A0A2, -estimatedEnd2);
            }
        }
    }

    public final boolean A06(View view, AnonymousClass4U r4) {
        AnonymousClass4G r1 = (AnonymousClass4G) view.getLayoutParams();
        return !r1.A02() && r1.A00() >= 0 && r1.A00() < r4.A03();
    }

    public final String toString() {
        return A00(40, 21, 73) + this.A01 + A00(0, 14, 93) + this.A00 + A00(14, 17, 63) + this.A02 + A00(31, 9, 11) + this.A03 + '}';
    }
}
