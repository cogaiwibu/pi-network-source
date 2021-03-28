package com.facebook.ads.redexgen.X;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.RequiresApi;
import java.util.Arrays;

@RequiresApi(21)
/* renamed from: com.facebook.ads.redexgen.X.Ek  reason: case insensitive filesystem */
public class C0370Ek extends SK {
    public static byte[] A00;
    public static String[] A01;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A01[7].length() != 21) {
                String[] strArr = A01;
                strArr[7] = "QKmrPpG47xHIA";
                strArr[7] = "QKmrPpG47xHIA";
                if (i4 >= length) {
                    return new String(copyOfRange);
                }
                copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 58);
                i4++;
            } else {
                throw new RuntimeException();
            }
        }
    }

    public static void A01() {
        A00 = new byte[]{79, 11, 0, 10, 28, 79, 1, 0, 27, 79, 6, 2, 31, 3, 10, 2, 10, 1, 27, 79, 6, 1, 27, 10, 29, 9, 14, 12, 10, 79, 11, 52, 56, 42, 13, 60, 47, 56, 51, 41, 125, 115, 76, 64, 82, 117, 68, 87, 64, 75, 81, 102, 74, 72, 85, 68, 81, 78, 70, 87, 75, 76, 71, 3, 76, 77, 109, 70, 80, 87, 70, 71, 101, 79, 74, 77, 68, 110, 102, 119, 107, 108, 103, 35, 108, 109, 77, 102, 112, 119, 102, 103, 83, 113, 102, 69, 111, 106, 109, 100, 28, 20, 5, 25, 30, 21, 81, 30, 31, 63, 20, 2, 5, 20, 21, 33, 3, 20, 34, 18, 3, 30, 29, 29, 98, 106, 123, 103, 96, 107, 47, 96, 97, 65, 106, 124, 123, 106, 107, 92, 108, 125, 96, 99, 99, 112, 120, 105, 117, 114, 121, 61, 114, 115, 83, 120, 110, 105, 120, 121, 78, 126, 111, 114, 113, 113, 92, 126, 126, 120, 109, 105, 120, 121, 107, 99, 114, 110, 105, 98, 38, 105, 104, 85, 114, 103, 116, 114, 72, 99, 117, 114, 99, 98, 85, 101, 116, 105, 106, 106, 83, 91, 74, 86, 81, 90, 30, 81, 80, 109, 74, 81, 78, 112, 91, 77, 74, 91, 90, 109, 93, 76, 81, 82, 82};
    }

    public static void A02() {
        A01 = new String[]{"lLTnlT7kdgZgpONat", "d79paUk3eSzGphhSN42PN5Aq8dj9iVyl", "SPt342n", "OIl1JjPDUNYuj0Z8zSbytdcas", "BSu1Ds7nymHwzPjWE4jzwGDd8JkRRJPQ", "PB1eQ9fbEyjMYRd9wV6iR7DUEeVSeCVP", "JUVWQPWt2QIcAEqAV6T0sxDALqwyj", "zKN2MvPWkZddLmlUYuVLkoywXLI"};
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass39
    public final void A03(ViewParent viewParent, View view) {
        try {
            viewParent.onStopNestedScroll(view);
        } catch (AbstractMethodError e) {
            Log.e(A00(41, 16, 31), A00(30, 11, 103) + viewParent + A00(0, 30, 85) + A00(200, 25, 4), e);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass39
    public final void A04(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
        try {
            viewParent.onNestedScroll(view, i, i2, i3, i4);
        } catch (AbstractMethodError e) {
            Log.e(A00(41, 16, 31), A00(30, 11, 103) + viewParent + A00(0, 30, 85) + A00(124, 21, 53), e);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass39
    public final void A05(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
        try {
            viewParent.onNestedPreScroll(view, i, i2, iArr);
        } catch (AbstractMethodError e) {
            Log.e(A00(41, 16, 31), A00(30, 11, 103) + viewParent + A00(0, 30, 85) + A00(100, 24, 75), e);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass39
    public final void A06(ViewParent viewParent, View view, View view2, int i) {
        try {
            viewParent.onNestedScrollAccepted(view, view2, i);
        } catch (AbstractMethodError e) {
            Log.e(A00(41, 16, 31), A00(30, 11, 103) + viewParent + A00(0, 30, 85) + A00(145, 29, 39), e);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass39
    public final boolean A07(ViewParent viewParent, View view, float f, float f2) {
        try {
            return viewParent.onNestedPreFling(view, f, f2);
        } catch (AbstractMethodError e) {
            Log.e(A00(41, 16, 31), A00(30, 11, 103) + viewParent + A00(0, 30, 85) + A00(77, 23, 57), e);
            return false;
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass39
    public final boolean A08(ViewParent viewParent, View view, float f, float f2, boolean z) {
        try {
            return viewParent.onNestedFling(view, f, f2, z);
        } catch (AbstractMethodError e) {
            Log.e(A00(41, 16, 31), A00(30, 11, 103) + viewParent + A00(0, 30, 85) + A00(57, 20, 25), e);
            return false;
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass39
    public final boolean A09(ViewParent viewParent, View view, View view2, int i) {
        try {
            return viewParent.onStartNestedScroll(view, view2, i);
        } catch (AbstractMethodError e) {
            Log.e(A00(41, 16, 31), A00(30, 11, 103) + viewParent + A00(0, 30, 85) + A00(174, 26, 60), e);
            return false;
        }
    }
}
