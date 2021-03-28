package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
import java.util.Arrays;

public class Sb implements AbstractC00993c {
    public static byte[] A01;
    public static String[] A02;
    public final /* synthetic */ ES A00;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 37);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-39, -9, 2, 2, -5, -6, -74, -9, 10, 10, -9, -7, -2, -74, 5, 4, -74, -9, -74, -7, -2, -1, 2, -6, -74, 13, -2, -1, -7, -2, -74, -1, 9, -74, 4, 5, 10, -74, -6, -5, 10, -9, -7, -2, -5, -6, -48, -74, -75, -77, -66, -66, -73, -74, 114, -74, -73, -58, -77, -75, -70, 114, -63, -64, 114, -77, -64, 114, -77, -66, -60, -73, -77, -74, -53, 114, -74, -73, -58, -77, -75, -70, -73, -74, 114, -75, -70, -69, -66, -74, 114};
    }

    public static void A02() {
        A02 = new String[]{"m0v39bkLL0n2S0xNgN89hz2dGOcTpwho", "Je1TSnUfgjz87J45b10M9zAxXIUpZahJ", "5NPz60Ycb2xlrnlJbjQuqitLPDDjbzHA", "GN4TkK3T6zCNiBjoupvxTPY", "uEyRXI1LEgEguUOEBvXDLSZ", "uM6injuc1j2LJ4wHPsuMaMxVec9yzmkB", "WB5Y9xOLXhFok7BjZ8qu5ygjzkxXvdjS", "QTx8NC78KyDJtqbkFzNokRxLjqTFyIiz"};
    }

    public Sb(ES es) {
        this.A00 = es;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00993c
    public final void A3U(View view, int i, ViewGroup.LayoutParams layoutParams) {
        AnonymousClass4X A0G = ES.A0G(view);
        if (A0G != null) {
            if (A0G.A0f() || A0G.A0i()) {
                A0G.A0Q();
            } else {
                throw new IllegalArgumentException(A00(0, 48, 113) + A0G + this.A00.A1J());
            }
        }
        this.A00.attachViewToParent(view, i, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00993c
    public final void A4j(int i) {
        AnonymousClass4X A0G;
        View A5d = A5d(i);
        if (!(A5d == null || (A0G = ES.A0G(A5d)) == null)) {
            if (!A0G.A0f() || A0G.A0i()) {
                A0G.A0U(256);
            } else {
                throw new IllegalArgumentException(A00(48, 43, 45) + A0G + this.A00.A1J());
            }
        }
        this.A00.detachViewFromParent((ES) i);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00993c
    public final View A5d(int i) {
        return this.A00.getChildAt(i);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00993c
    public final int A5e() {
        return this.A00.getChildCount();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00993c
    public final AnonymousClass4X A5h(View view) {
        return ES.A0G(view);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00993c
    public final int A7P(View view) {
        return this.A00.indexOfChild(view);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00993c
    public final void A9V(View view) {
        AnonymousClass4X A0G = ES.A0G(view);
        if (A0G != null) {
            A0G.A08(this.A00);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00993c
    public final void A9v(View view) {
        AnonymousClass4X A0G = ES.A0G(view);
        if (A0G != null) {
            A0G.A09(this.A00);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00993c
    public final void ACL() {
        int i = A5e();
        for (int i2 = 0; i2 < i; i2++) {
            View A5d = A5d(i2);
            this.A00.A1j(A5d);
            A5d.clearAnimation();
        }
        this.A00.removeAllViews();
        String[] strArr = A02;
        if (strArr[3].length() != strArr[4].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[2] = "YVtNrV2twtC96zFGqk3M5li58NeZhLji";
        strArr2[2] = "YVtNrV2twtC96zFGqk3M5li58NeZhLji";
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00993c
    public final void ACP(int i) {
        View childAt = this.A00.getChildAt(i);
        if (childAt != null) {
            this.A00.A1j(childAt);
            childAt.clearAnimation();
        }
        ES es = this.A00;
        if (A02[2].charAt(25) != 'R') {
            String[] strArr = A02;
            strArr[2] = "BurwQQkBxJzMJJK1acCycPqXpvrCcXzS";
            strArr[2] = "BurwQQkBxJzMJJK1acCycPqXpvrCcXzS";
            es.removeViewAt(i);
            return;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00993c
    public final void addView(View view, int i) {
        this.A00.addView(view, i);
        this.A00.A1i(view);
    }
}
