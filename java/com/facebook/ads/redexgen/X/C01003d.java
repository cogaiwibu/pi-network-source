package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.3d  reason: invalid class name and case insensitive filesystem */
public final class C01003d {
    public static byte[] A03;
    public static String[] A04;
    public final C00983b A00 = new C00983b();
    public final AbstractC00993c A01;
    public final List<View> A02 = new ArrayList();

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 78);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        if (A04[5].charAt(2) != 'B') {
            throw new RuntimeException();
        }
        String[] strArr = A04;
        strArr[1] = "YzFnrN17WwgSKMGcQI3u7PJ5Pdf81qGi";
        strArr[1] = "YzFnrN17WwgSKMGcQI3u7PJ5Pdf81qGi";
        A03 = new byte[]{-81, -93, -21, -20, -25, -25, -24, -15, -93, -17, -20, -10, -9, -67, -23, -25, -18, -34, -29, -36, -107, -23, -28, -107, -22, -29, -35, -34, -39, -38, -107, -42, -107, -21, -34, -38, -20, -107, -23, -35, -42, -23, -107, -20, -42, -24, -107, -29, -28, -23, -107, -35, -34, -39, -39, -38, -29, -35, -48, -52, -34, -121, -48, -38, -121, -43, -42, -37, -121, -56, -121, -54, -49, -48, -45, -53, -109, -121, -54, -56, -43, -43, -42, -37, -121, -49, -48, -53, -52, -121};
    }

    public static void A03() {
        A04 = new String[]{"QoGKHhEqLDc7cPbroRD", "LQzzwNJ4o6QHlfYkxXGOUA5ejYw8qpDj", "6ipC3ASGLl4rMOedI", "OPBJh0aCf", "l4bQelOwEyQeTpTSi", "DWBJmVB67PV4ItRyT2e9caL16z1NK91I", "0G1mJvoVA", "nRnK55wdJbrp31Rh0MWe0TNMbF4aeg8Y"};
    }

    public C01003d(AbstractC00993c r2) {
        this.A01 = r2;
    }

    private int A00(int limit) {
        if (limit < 0) {
            return -1;
        }
        int A5e = this.A01.A5e();
        int i = limit;
        while (i < A5e) {
            int removedBefore = limit - (i - this.A00.A04(i));
            if (removedBefore == 0) {
                while (this.A00.A09(i)) {
                    i++;
                }
                return i;
            }
            i += removedBefore;
        }
        return -1;
    }

    private void A04(View view) {
        this.A02.add(view);
        this.A01.A9V(view);
    }

    private boolean A05(View view) {
        if (!this.A02.remove(view)) {
            return false;
        }
        this.A01.A9v(view);
        return true;
    }

    public final int A06() {
        return this.A01.A5e() - this.A02.size();
    }

    public final int A07() {
        return this.A01.A5e();
    }

    public final int A08(View view) {
        int A7P = this.A01.A7P(view);
        if (A7P != -1 && !this.A00.A09(A7P)) {
            return A7P - this.A00.A04(A7P);
        }
        return -1;
    }

    public final View A09(int i) {
        int size = this.A02.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.A02.get(i2);
            AnonymousClass4X A5h = this.A01.A5h(view);
            if (!(A5h.A0J() != i || A5h.A0c() || A5h.A0d())) {
                return view;
            }
        }
        return null;
    }

    public final View A0A(int i) {
        return this.A01.A5d(A00(i));
    }

    public final View A0B(int i) {
        return this.A01.A5d(i);
    }

    public final void A0C() {
        this.A00.A05();
        for (int size = this.A02.size() - 1; size >= 0; size--) {
            this.A01.A9v(this.A02.get(size));
            this.A02.remove(size);
        }
        this.A01.ACL();
    }

    public final void A0D(int i) {
        int A002 = A00(i);
        this.A00.A0A(A002);
        this.A01.A4j(A002);
    }

    public final void A0E(int i) {
        int A002 = A00(i);
        View A5d = this.A01.A5d(A002);
        if (A5d != null) {
            if (this.A00.A0A(A002)) {
                A05(A5d);
            }
            this.A01.ACP(A002);
            if (A04[4].length() != 16) {
                String[] strArr = A04;
                strArr[7] = "KJlsfCUfVwwQNNRDjM0AzdkkAy1m1QjD";
                strArr[7] = "KJlsfCUfVwwQNNRDjM0AzdkkAy1m1QjD";
                return;
            }
            throw new RuntimeException();
        }
    }

    public final void A0F(View view) {
        int A7P = this.A01.A7P(view);
        if (A7P >= 0) {
            this.A00.A07(A7P);
            A04(view);
            return;
        }
        throw new IllegalArgumentException(A01(57, 33, 25) + view);
    }

    public final void A0G(View view) {
        int A7P = this.A01.A7P(view);
        if (A7P >= 0) {
            if (this.A00.A0A(A7P)) {
                A05(view);
            }
            this.A01.ACP(A7P);
        }
    }

    public final void A0H(View view) {
        int A7P = this.A01.A7P(view);
        if (A7P < 0) {
            throw new IllegalArgumentException(A01(57, 33, 25) + view);
        } else if (this.A00.A09(A7P)) {
            this.A00.A06(A7P);
            A05(view);
        } else {
            throw new RuntimeException(A01(14, 43, 39) + view);
        }
    }

    public final void A0I(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int A002;
        if (i < 0) {
            A002 = this.A01.A5e();
        } else {
            A002 = A00(i);
        }
        C00983b r4 = this.A00;
        if (A04[5].charAt(2) != 'B') {
            throw new RuntimeException();
        }
        String[] strArr = A04;
        strArr[1] = "KHr0McsaN13zWmBdzhmfm62h5mt8zSB0";
        strArr[1] = "KHr0McsaN13zWmBdzhmfm62h5mt8zSB0";
        r4.A08(A002, z);
        if (z) {
            A04(view);
        }
        this.A01.A3U(view, A002, layoutParams);
    }

    public final void A0J(View view, int i, boolean z) {
        int A002;
        if (i < 0) {
            A002 = this.A01.A5e();
        } else {
            A002 = A00(i);
        }
        this.A00.A08(A002, z);
        if (z) {
            A04(view);
        }
        this.A01.addView(view, A002);
    }

    public final void A0K(View view, boolean z) {
        A0J(view, -1, z);
    }

    public final boolean A0L(View view) {
        return this.A02.contains(view);
    }

    public final boolean A0M(View view) {
        int A7P = this.A01.A7P(view);
        if (A7P == -1) {
            A05(view);
            if (A04[5].charAt(2) != 'B') {
                throw new RuntimeException();
            }
            String[] strArr = A04;
            strArr[0] = "HipCYWSrBpzIS13Odtj";
            strArr[0] = "HipCYWSrBpzIS13Odtj";
            return true;
        } else if (!this.A00.A09(A7P)) {
            return false;
        } else {
            this.A00.A0A(A7P);
            A05(view);
            this.A01.ACP(A7P);
            return true;
        }
    }

    public final String toString() {
        return this.A00.toString() + A01(0, 14, 53) + this.A02.size();
    }
}
