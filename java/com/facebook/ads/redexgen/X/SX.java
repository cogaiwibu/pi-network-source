package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import java.util.Arrays;

public class SX extends AnonymousClass4S {
    public static byte[] A06;
    public static String[] A07;
    public int A00 = 0;
    public int A01 = 0;
    public PointF A02;
    public final float A03;
    public final DecelerateInterpolator A04 = new DecelerateInterpolator();
    public final LinearInterpolator A05 = new LinearInterpolator();

    static {
        A07();
        A05();
    }

    public static String A04(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 35);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A06 = new byte[]{41, 12, 11, 0, 4, 23, 54, 8, 10, 10, 17, 13, 54, 6, 23, 10, 9, 9, 0, 23, 21, 35, 57, 108, 63, 36, 35, 57, 32, 40, 108, 35, 58, 41, 62, 62, 37, 40, 41, 108, 47, 35, 33, 60, 57, 56, 41, 31, 47, 62, 35, 32, 32, 26, 41, 47, 56, 35, 62, 10, 35, 62, 28, 35, 63, 37, 56, 37, 35, 34, 108, 59, 36, 41, 34, 108, 56, 36, 41, 108, 0, 45, 53, 35, 57, 56, 1, 45, 34, 45, 43, 41, 62, 108, 40, 35, 41, 63, 108, 34, 35, 56, 108, 37, 33, 60, 32, 41, 33, 41, 34, 56, 108, 42, 55, 56, 41, 121, 41, 43, 60, 63, 60, 43, 60, 55, 58, 60, 121, 42, 49, 54, 44, 53, 61, 121, 59, 60, 121, 54, 55, 60, 121, 54, 63, 121, 45, 49, 60, 121, 58, 54, 55, 42, 45, 56, 55, 45, 42, 121, 61, 60, 63, 48, 55, 60, 61, 121, 48, 55, 121, 10, 52, 54, 54, 45, 49, 10, 58, 43, 54, 53, 53, 60, 43, 117, 121, 42, 45, 56, 43, 45, 48, 55, 62, 121, 46, 48, 45, 49, 121, 10, 23, 24, 9, 6};
    }

    public static void A07() {
        A07 = new String[]{"vpHxNEEeQqkPH9sKp8BAFlo", "ddQd8aXmX57TCv5syYSnMf6Vla22KopM", "0YXj", "UC9R5IJXbgu82zo5LhenPlKKwn23Fltm", "uFeOec4n0AGL9Kfrmk6ECW0KKbKvD", "RgZAHFrUyN4TqtmKiyvyL8Y", "g7LT7F9fn5p79lPzLzvRECTowfucfQY3", "UaBPk1errz52kF5dIu80Mei9ciV9Nkpb"};
    }

    public SX(Context context) {
        this.A03 = A0K(context.getResources().getDisplayMetrics());
    }

    private final int A00() {
        PointF pointF = this.A02;
        if (pointF == null || pointF.y == 0.0f) {
            return 0;
        }
        return this.A02.y > 0.0f ? 1 : -1;
    }

    private int A01(int i, int i2) {
        int i3 = i - i2;
        if (i * i3 <= 0) {
            return 0;
        }
        return i3;
    }

    private final int A03(View view, int top) {
        AnonymousClass4F A09 = A09();
        if (A09 == null || !A09.A26()) {
            return 0;
        }
        AnonymousClass4G r1 = (AnonymousClass4G) view.getLayoutParams();
        return A0O(A09.A0p(view) - r1.topMargin, A09.A0k(view) + r1.bottomMargin, A09.A0h(), A09.A0Y() - A09.A0e(), top);
    }

    /* JADX INFO: Multiple debug info for r6v0 com.facebook.ads.redexgen.X.4Q: [D('target' int), D('time' int)] */
    private final void A08(AnonymousClass4Q r6) {
        PointF A0Q = A0Q(A08());
        if (A0Q == null || (A0Q.x == 0.0f && A0Q.y == 0.0f)) {
            r6.A04(A08());
            A0A();
            return;
        }
        A0C(A0Q);
        this.A02 = A0Q;
        this.A00 = (int) (A0Q.x * 10000.0f);
        this.A01 = (int) (A0Q.y * 10000.0f);
        r6.A05((int) (((float) this.A00) * 1.2f), (int) (((float) this.A01) * 1.2f), (int) (((float) A0M(10000)) * 1.2f), this.A05);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4S
    public final void A0H() {
        this.A01 = 0;
        this.A00 = 0;
        this.A02 = null;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4S
    public final void A0I(int i, int i2, AnonymousClass4U r4, AnonymousClass4Q r5) {
        if (A07() == 0) {
            A0A();
            return;
        }
        this.A00 = A01(this.A00, i);
        this.A01 = A01(this.A01, i2);
        if (this.A00 == 0 && this.A01 == 0) {
            A08(r5);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4S
    public void A0J(View view, AnonymousClass4U r8, AnonymousClass4Q r9) {
        int A0P = A0P(view, A0L());
        int A032 = A03(view, A00());
        int A0N = A0N((int) Math.sqrt((double) ((A0P * A0P) + (A032 * A032))));
        if (A0N > 0) {
            r9.A05(-A0P, -A032, A0N, this.A04);
        }
    }

    public float A0K(DisplayMetrics displayMetrics) {
        return 25.0f / ((float) displayMetrics.densityDpi);
    }

    public int A0L() {
        PointF pointF = this.A02;
        if (pointF == null || pointF.x == 0.0f) {
            return 0;
        }
        return this.A02.x > 0.0f ? 1 : -1;
    }

    public int A0M(int i) {
        return (int) Math.ceil((double) (((float) Math.abs(i)) * this.A03));
    }

    public final int A0N(int i) {
        return (int) Math.ceil(((double) A0M(i)) / 0.3356d);
    }

    public final int A0O(int i, int i2, int i3, int i4, int i5) {
        if (i5 == -1) {
            return i3 - i;
        }
        if (i5 == 0) {
            int i6 = i3 - i;
            if (i6 > 0) {
                return i6;
            }
            int i7 = i4 - i2;
            if (i7 < 0) {
                return i7;
            }
            String[] strArr = A07;
            if (strArr[3].charAt(24) != strArr[6].charAt(24)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[7] = "99CH8cQKDxQi0SdQwcjuhFHBueIBqbiA";
            strArr2[4] = "Y2Wuw9nWVBLC0K9LHKlenTQ1gtNyD";
            return 0;
        } else if (i5 == 1) {
            return i4 - i2;
        } else {
            throw new IllegalArgumentException(A04(113, 93, 122));
        }
    }

    public int A0P(View view, int left) {
        AnonymousClass4F A09 = A09();
        if (A09 == null || !A09.A25()) {
            return 0;
        }
        AnonymousClass4G r1 = (AnonymousClass4G) view.getLayoutParams();
        return A0O(A09.A0l(view) - r1.leftMargin, A09.A0o(view) + r1.rightMargin, A09.A0f(), A09.A0i() - A09.A0g(), left);
    }

    @Nullable
    public PointF A0Q(int i) {
        AnonymousClass4F A09 = A09();
        if (A09 instanceof AnonymousClass4R) {
            return ((AnonymousClass4R) A09).A45(i);
        }
        Log.w(A04(0, 20, 70), A04(20, 93, 111) + AnonymousClass4R.class.getCanonicalName());
        return null;
    }
}
