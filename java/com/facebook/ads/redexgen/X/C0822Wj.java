package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import java.text.NumberFormat;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Wj  reason: case insensitive filesystem */
public final class C0822Wj extends NX {
    public static byte[] A0G;
    public static String[] A0H;
    public static final int A0I = ((int) (C0535Le.A01 * 26.0f));
    public static final int A0J = ((int) (C0535Le.A01 * 48.0f));
    public static final int A0K = ((int) (C0535Le.A01 * 144.0f));
    public static final int A0L = ((int) (C0535Le.A01 * 12.0f));
    public static final int A0M = ((int) (C0535Le.A01 * 8.0f));
    public static final int A0N = ((int) (C0535Le.A01 * 16.0f));
    public static final int A0O = AnonymousClass2G.A01(-1, 77);
    public static final int A0P = ((int) (C0535Le.A01 * 14.0f));
    public int A00;
    public int A01;
    public LinearLayout A02;
    public TextView A03;
    public TextView A04;
    public TextView A05;
    public AnonymousClass1G A06;
    public AnonymousClass1I A07;
    public C0589Nh A08;
    public boolean A09;
    public boolean A0A;
    public final LinearLayout A0B;
    public final RelativeLayout A0C;
    public final RelativeLayout A0D;
    public final TextView A0E;
    public final C0820Wh A0F;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0G, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 99);
        }
        return new String(copyOfRange);
    }

    public static void A07() {
        A0G = new byte[]{-111, -20};
    }

    public static void A08() {
        A0H = new String[]{"ZYFZvgakVe", "Z9juamcNffZ", "L6NhnuluGVbfOuIZp07EBLc1k7rVfOba", "poGipFcmqzgO1AN9d1VwktKUuwbeuE2x", "1MA0bi3k", "zUZ", "l0mlyabDLiJh1QvHe0VixDkOpEP8aZzg", "KStQaqdBmF0CfboN9Wjc4"};
    }

    static {
        A08();
        A07();
    }

    public C0822Wj(C0820Wh wh, int i, boolean z, AnonymousClass1H r15, String str, JE je, M6 m6, C0641Ph ph, LX lx) {
        this(wh, i, z, r15, str, je, m6, ph, lx, false);
    }

    public C0822Wj(C0820Wh wh, int i, boolean z, AnonymousClass1H r16, String str, JE je, M6 m6, C0641Ph ph, LX lx, boolean z2) {
        super(wh, i, r16, str, je, m6, ph, lx);
        this.A0A = false;
        this.A00 = 0;
        this.A01 = 0;
        this.A0F = wh;
        this.A09 = z2;
        super.A04.setFullCircleCorners(z);
        int i2 = A0L;
        setPadding(i2, i2, i2, A0I);
        this.A0C = new RelativeLayout(getContext());
        this.A05 = new TextView(getContext());
        this.A02 = new LinearLayout(getContext());
        this.A08 = new C0589Nh(this.A0F, A0P, 5, A0O, -1);
        this.A0D = new RelativeLayout(getContext());
        this.A0B = new LinearLayout(getContext());
        this.A04 = new TextView(getContext());
        this.A03 = new TextView(getContext());
        super.A01.addView(this.A0C);
        super.A01.addView(this.A0B);
        this.A0E = new TextView(getContext());
        C0535Le.A0V(this, wh);
        if (J8.A1L(wh)) {
            this.A03.setVisibility(8);
        }
        A05();
    }

    private void A01() {
        super.A03.setPadding(0, 0, 0, 0);
        super.A03.setLayoutParams(new LinearLayout.LayoutParams(-1, A0J));
    }

    private void A02() {
        this.A0B.setOrientation(1);
        this.A0B.setPadding(0, 0, 0, A0L);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, this.A0C.getId());
        this.A0B.setLayoutParams(layoutParams);
        this.A0B.removeAllViews();
        this.A03.setMaxLines(2);
        this.A03.setEllipsize(TextUtils.TruncateAt.END);
        this.A03.setGravity(16);
        this.A03.setTextColor(-1);
        C0535Le.A0b(this.A03, false, 16);
        this.A0B.addView(this.A03, new LinearLayout.LayoutParams(-1, -2));
    }

    private void A03() {
        this.A0C.removeAllViews();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = A0L;
        this.A0C.setLayoutParams(layoutParams);
        C0535Le.A0N(this.A0C);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(super.A00, super.A00);
        layoutParams2.addRule(15);
        layoutParams2.addRule(9);
        this.A0C.addView(super.A04, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.leftMargin = A0M;
        layoutParams3.addRule(1, super.A04.getId());
        layoutParams3.addRule(15);
        this.A0C.addView(this.A0D, layoutParams3);
        this.A0D.removeAllViews();
        C0535Le.A0N(this.A05);
        this.A05.setLayoutParams(NX.A06);
        this.A05.setTextColor(-1);
        C0535Le.A0b(this.A05, true, 18);
        this.A0D.addView(this.A05);
        this.A02.setOrientation(0);
        this.A02.setGravity(16);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, A0N);
        layoutParams4.topMargin = A0M / 2;
        layoutParams4.addRule(3, this.A05.getId());
        this.A0D.addView(this.A02, layoutParams4);
        this.A02.removeAllViews();
        this.A08.setGravity(16);
        this.A02.addView(this.A08, new LinearLayout.LayoutParams(-2, -1));
        this.A04.setTextColor(-1);
        this.A04.setGravity(16);
        this.A04.setIncludeFontPadding(false);
        C0535Le.A0b(this.A04, false, 14);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams5.leftMargin = A0M;
        this.A02.addView(this.A04, layoutParams5);
    }

    private void A04() {
        this.A0E.setMaxLines(1);
        this.A0E.setEllipsize(TextUtils.TruncateAt.END);
        this.A0E.setGravity(17);
        this.A0E.setTextColor(-1);
        this.A0E.setAllCaps(true);
        C0535Le.A0b(this.A0E, false, 12);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = A0L;
        this.A0E.setLayoutParams(layoutParams);
    }

    private void A05() {
        removeAllViews();
        super.A01.setLayoutParams(NX.A06);
        A03();
        A02();
        A01();
        A04();
        A06();
        C0535Le.A0M(super.A01);
        C0535Le.A0M(super.A03);
        C0535Le.A0M(this.A0E);
        addView(super.A01);
        addView(super.A03);
        addView(this.A0E);
    }

    private void A06() {
        AnonymousClass1G r0 = this.A06;
        if (r0 != null) {
            this.A05.setText(r0.A06());
            this.A03.setText(this.A06.A01());
            this.A0E.setText(this.A06.A04());
            if (TextUtils.isEmpty(this.A07.A03())) {
                C0535Le.A0K(super.A03);
            }
            if (TextUtils.isEmpty(this.A06.A04())) {
                C0535Le.A0K(this.A0E);
            }
            if (TextUtils.isEmpty(this.A06.A03())) {
                this.A02.setVisibility(8);
                return;
            }
            this.A02.setVisibility(0);
            C0589Nh nh = this.A08;
            String A032 = this.A06.A03();
            if (A0H[0].length() != 17) {
                String[] strArr = A0H;
                strArr[2] = "VSVKlO90K15ihGB4A0qZPRqEppX5OU7U";
                strArr[6] = "xs76xd0mQfWREabMq0mbrfEp6FCRmbTD";
                nh.setRating(Float.parseFloat(A032));
                if (this.A06.A02() != null) {
                    TextView textView = this.A04;
                    textView.setText(A00(0, 1, 6) + NumberFormat.getNumberInstance().format((long) Integer.parseInt(this.A06.A02())) + A00(1, 1, 96));
                    return;
                }
                return;
            }
            throw new RuntimeException();
        }
    }

    @Override // com.facebook.ads.redexgen.X.NX
    public final int A09(int i) {
        return this.A00 + this.A01 + A0M;
    }

    @Override // com.facebook.ads.redexgen.X.NX
    public final void A0D(int i) {
        boolean z;
        int i2 = 1;
        if (i == 1) {
            z = true;
        } else {
            z = false;
        }
        if (!this.A09 || !this.A0A) {
            if (!z) {
                i2 = 0;
            }
            setOrientation(i2);
            if (!z) {
                setWeightSum(5.0f);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 4.0f;
                layoutParams.bottomMargin = A0I - A0L;
                super.A01.setLayoutParams(layoutParams);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, A0J);
                layoutParams2.bottomMargin = A0I / 2;
                layoutParams2.weight = 1.0f;
                layoutParams2.gravity = 80;
                super.A03.setLayoutParams(layoutParams2);
                super.A03.setMinWidth(A0K);
                C0535Le.A0M(this.A0E);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
                layoutParams3.topMargin = 0;
                layoutParams3.bottomMargin = A0M;
                this.A0B.addView(this.A0E, layoutParams3);
                this.A0B.setPadding(0, 0, 0, 0);
                this.A0E.setGravity(3);
            } else {
                A05();
            }
        } else {
            setOrientation(1);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            setBackgroundResource(0);
            super.A01.setLayoutParams(layoutParams4);
            super.A03.setLayoutParams(new LinearLayout.LayoutParams(-1, A0J));
            if (!z) {
                layoutParams4.weight = 0.7f;
                C0535Le.A0P(this, -1087164882);
                A04();
                this.A0E.setGravity(3);
            } else {
                this.A0E.setGravity(1);
            }
            C0535Le.A0M(this.A0E);
            addView(this.A0E);
        }
        bringToFront();
    }

    @Override // com.facebook.ads.redexgen.X.NX
    public final void A0E(boolean z) {
        this.A0A = z;
    }

    @Override // com.facebook.ads.redexgen.X.NX
    public final View getExpandableLayout() {
        return this.A0B;
    }

    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.A00 == 0) {
            this.A00 = this.A03.getHeight();
            this.A01 = this.A0E.getHeight();
        }
    }

    @Override // com.facebook.ads.redexgen.X.NX
    public void setInfo(AnonymousClass1G r1, AnonymousClass1I r2, String str, String str2, @Nullable AbstractC0582Na na) {
        super.setInfo(r1, r2, str, str2, na);
        this.A06 = r1;
        this.A07 = r2;
        A06();
    }
}
