package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Zs  reason: case insensitive filesystem */
public final class C0905Zs extends NX {
    public static byte[] A0E;
    public static String[] A0F;
    public static final int A0G = ((int) (C0535Le.A01 * 3.0f));
    public static final int A0H = ((int) (C0535Le.A01 * 2.0f));
    public static final int A0I = ((int) (C0535Le.A01 * 8.0f));
    public static final int A0J = ((int) (C0535Le.A01 * 8.0f));
    public static final int A0K = ((int) (C0535Le.A01 * 48.0f));
    public static final int A0L = ((int) (C0535Le.A01 * 82.0f));
    public static final int A0M = ((int) (C0535Le.A01 * 16.0f));
    public static final int A0N = ((int) (C0535Le.A01 * 2.0f));
    public AnonymousClass1G A00;
    public boolean A01 = false;
    public boolean A02 = false;
    public final ImageView A03;
    public final LinearLayout.LayoutParams A04 = new LinearLayout.LayoutParams(-1, 0);
    public final LinearLayout.LayoutParams A05 = new LinearLayout.LayoutParams(-1, 0);
    public final LinearLayout A06;
    public final LinearLayout A07;
    public final RelativeLayout.LayoutParams A08 = new RelativeLayout.LayoutParams(-2, -1);
    public final RelativeLayout.LayoutParams A09 = new RelativeLayout.LayoutParams(-1, -2);
    public final TextView A0A;
    public final TextView A0B;
    public final TextView A0C;
    public final TextView A0D;

    public static String A04(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0E, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A0F;
            if (strArr[6].charAt(12) != strArr[7].charAt(12)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0F;
            strArr2[3] = "CFHt0yNdC2PEY9oUs7GHhr9LuJSrb6a";
            strArr2[3] = "CFHt0yNdC2PEY9oUs7GHhr9LuJSrb6a";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 89);
            i4++;
        }
    }

    public static void A08() {
        A0E = new byte[]{-63, 19, 6, 23, 10, 6, 24, 20};
    }

    public static void A09() {
        A0F = new String[]{"Qaz6s2rZ", "AcoknuDDmNnfRhvATxJBAe7psr5ZdYIV", "xUaT3nis", "3ZYb8Y0gA5eZOJbeDVtSAHPMCBzrwI9S", "CaGCkJyqrjmkUmEgaxYP5OnLIzM2aaQv", "YMuz8", "po4IGEuOfM3V3RWL9cKG7EahlbwG6cRm", "tP1qXeWZ1rY33RxSca4DZNHo6L2lNWeK"};
    }

    static {
        A09();
        A08();
    }

    public C0905Zs(C0820Wh wh, int i, AnonymousClass1H r10, String str, JE je, M6 m6, C0641Ph ph, LX lx) {
        super(wh, i, r10, str, je, m6, ph, lx);
        boolean z = true;
        setOrientation(1);
        int i2 = A0J;
        C0535Le.A0U(this, -1087164882, new float[]{0.0f, 0.0f, 0.0f, 0.0f, (float) i2, (float) i2, (float) i2, (float) i2});
        setPadding(0, 0, 0, A0I);
        this.A09.addRule(12);
        RelativeLayout.LayoutParams layoutParams = this.A09;
        int i3 = A0M;
        layoutParams.setMargins(i3, 0, i3, i3);
        this.A03 = new ImageView(wh);
        this.A03.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.A03.setColorFilter(-1);
        this.A03.setImageBitmap(C0544Ln.A00(EnumC0543Lm.STAR));
        this.A0B = new TextView(wh);
        this.A0C = new TextView(wh);
        this.A0D = new TextView(wh);
        this.A0A = new TextView(wh);
        this.A06 = new LinearLayout(wh);
        this.A06.setOrientation(1);
        this.A07 = new LinearLayout(wh);
        this.A07.setOrientation(0);
        if (!(wh.A09() == null || wh.A09().getWindow() == null)) {
            wh.A09().getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new M2(this));
        }
        setupMetadataContainer(getResources().getConfiguration().orientation != 1 ? false : z);
    }

    private RelativeLayout.LayoutParams A01(View view) {
        C0535Le.A0P(this, 0);
        this.A08.setMargins(0, 0, 0, 0);
        this.A08.addRule(1, view.getId());
        A05();
        return this.A08;
    }

    private void A05() {
        super.A01.removeAllViews();
        removeView(super.A03);
        setGravity(16);
        this.A04.setMargins(0, 0, A0M * 3, 0);
        C0535Le.A0b(this.A0D, true, 18);
        this.A05.setMargins(0, 0, A0M * 3, 0);
        this.A0A.setVisibility(0);
        this.A07.setLayoutParams(this.A04);
        this.A0D.setLayoutParams(this.A05);
        int i = A0L;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
        int i2 = A0M;
        layoutParams.setMargins(i2, 0, i2, 0);
        layoutParams.addRule(9);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, A0L);
        layoutParams2.addRule(1, super.A04.getId());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        int i3 = A0M;
        layoutParams3.setMargins(i3, i3, i3 * 3, 0);
        layoutParams3.addRule(3, super.A04.getId());
        super.A01.addView(super.A04, layoutParams);
        super.A01.addView(this.A06, layoutParams2);
        super.A01.addView(super.A03, layoutParams3);
    }

    private void A06() {
        int i;
        super.A01.removeAllViews();
        removeView(super.A03);
        this.A04.setMargins(0, 0, A0M, 0);
        TextView textView = this.A0D;
        if (this.A01) {
            i = 18;
        } else {
            i = 15;
        }
        C0535Le.A0b(textView, true, i);
        this.A05.setMargins(0, 0, A0M, 0);
        this.A0A.setVisibility(8);
        this.A07.setLayoutParams(this.A04);
        this.A0D.setLayoutParams(this.A05);
        int i2 = A0K;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i2);
        int i3 = A0M;
        layoutParams.setMargins(i3, 0, i3, 0);
        layoutParams.addRule(9);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, A0K);
        layoutParams2.addRule(1, super.A04.getId());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        int i4 = A0M;
        layoutParams3.setMargins(i4, A0I, i4, 0);
        super.A01.addView(super.A04, layoutParams);
        super.A01.addView(this.A06, layoutParams2);
        addView(super.A03, layoutParams3);
    }

    /* JADX INFO: Multiple debug info for r7v0 'this'  com.facebook.ads.redexgen.X.Zs: [D('wrapSpec' int), D('reviewsCountText' java.lang.String)] */
    private void A07() {
        this.A0D.setText(this.A00.A06());
        this.A0A.setText(this.A00.A05());
        if (!this.A00.A03().isEmpty()) {
            TextView textView = this.A0B;
            String A032 = this.A00.A03();
            if (A0F[5].length() != 5) {
                throw new RuntimeException();
            }
            String[] strArr = A0F;
            strArr[1] = "A4j7vT1O3iieC5LYKxgUzJw3IAPRsZqa";
            strArr[4] = "kbxlqPL3bcSaGLfdPxpm8hIEsv0pbZnU";
            textView.setText(A032);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            this.A0B.measure(makeMeasureSpec, makeMeasureSpec);
        } else {
            this.A0B.setVisibility(8);
            this.A03.setVisibility(8);
        }
        if (!this.A00.A02().isEmpty()) {
            this.A0C.setText(this.A00.A02() + A04(0, 8, 72));
            return;
        }
        this.A0C.setVisibility(8);
        if (this.A00.A03().isEmpty()) {
            this.A07.setVisibility(8);
            C0535Le.A0b(this.A0D, true, 18);
            this.A0D.setMaxLines(2);
            LinearLayout.LayoutParams layoutParams = this.A05;
            layoutParams.weight = 2.0f;
            this.A0D.setLayoutParams(layoutParams);
            this.A0A.setGravity(48);
            C0535Le.A0b(this.A0A, false, 15);
            this.A01 = true;
        }
    }

    @Override // com.facebook.ads.redexgen.X.NX
    public final RelativeLayout.LayoutParams A0B(View view) {
        int i;
        if (getResources().getConfiguration().orientation == 1) {
            A06();
            C0535Le.A0R(this, -1087164882, A0J);
            RelativeLayout.LayoutParams layoutParams = this.A09;
            int i2 = A0M;
            if (this.A02) {
                i = i2 * 3;
            } else {
                i = i2;
            }
            layoutParams.setMargins(i2, 0, i2, i);
            int i3 = A0I;
            setPadding(0, i3, 0, i3);
            return this.A09;
        }
        this.A08.setMargins(0, 0, 0, 0);
        this.A08.addRule(1, view.getId());
        C0535Le.A0P(this, -1087164882);
        A05();
        return this.A08;
    }

    @Override // com.facebook.ads.redexgen.X.NX
    public final RelativeLayout.LayoutParams A0C(View view) {
        bringToFront();
        addView(super.A01);
        C0535Le.A0N(this.A0C);
        C0535Le.A0N(super.A04);
        C0535Le.A0N(this.A0D);
        C0535Le.A0N(this.A0B);
        C0535Le.A0N(this.A03);
        C0535Le.A0N(super.A03);
        C0535Le.A0N(this.A0A);
        C0535Le.A0N(this.A06);
        C0535Le.A0N(this.A07);
        if (getResources().getConfiguration().orientation == 1) {
            return getPortraitLayoutParams();
        }
        return A01(view);
    }

    @Override // com.facebook.ads.redexgen.X.NX
    public final void A0D(int i) {
    }

    @Override // com.facebook.ads.redexgen.X.NX
    public final void A0E(boolean z) {
    }

    private RelativeLayout.LayoutParams getPortraitLayoutParams() {
        int i;
        int i2 = A0J;
        C0535Le.A0U(this, -1087164882, new float[]{0.0f, 0.0f, 0.0f, 0.0f, (float) i2, (float) i2, (float) i2, (float) i2});
        RelativeLayout.LayoutParams layoutParams = this.A09;
        int i3 = A0M;
        if (this.A02) {
            i = i3 * 3;
        } else {
            i = i3;
        }
        layoutParams.setMargins(i3, 0, i3, i);
        A06();
        return this.A09;
    }

    @Override // com.facebook.ads.redexgen.X.NX
    public void setInfo(AnonymousClass1G r1, AnonymousClass1I r2, String str, String str2, @Nullable AbstractC0582Na na) {
        super.setInfo(r1, r2, str, str2, na);
        this.A00 = r1;
        A07();
    }

    private void setupMetadataContainer(boolean z) {
        float f;
        int i;
        int i2;
        int i3;
        int i4;
        this.A06.removeAllViews();
        this.A07.removeAllViews();
        LinearLayout.LayoutParams layoutParams = this.A04;
        layoutParams.weight = 1.0f;
        int i5 = A0M;
        if (!z) {
            i5 *= 3;
        }
        int i6 = 0;
        layoutParams.setMargins(0, 0, i5, 0);
        LinearLayout.LayoutParams layoutParams2 = this.A05;
        if (this.A01) {
            f = 2.0f;
        } else {
            f = 1.0f;
        }
        layoutParams2.weight = f;
        TextView textView = this.A0D;
        if (this.A01) {
            i = 2;
        } else {
            i = 1;
        }
        textView.setMaxLines(i);
        TextView textView2 = this.A0D;
        int i7 = 15;
        if (this.A01 || !z) {
            i2 = 18;
        } else {
            i2 = 15;
        }
        C0535Le.A0b(textView2, true, i2);
        this.A0D.setTextColor(-1);
        this.A0D.setEllipsize(TextUtils.TruncateAt.END);
        this.A0D.setGravity(16);
        LinearLayout.LayoutParams layoutParams3 = this.A05;
        int i8 = A0M;
        if (!z) {
            i8 *= 3;
        }
        layoutParams3.setMargins(0, 0, i8, 0);
        TextView textView3 = this.A0A;
        if (z) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        textView3.setVisibility(i3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams4.weight = 1.0f;
        this.A0A.setMaxLines(1);
        this.A0A.setTextColor(-1);
        TextView textView4 = this.A0A;
        if (this.A01) {
            i4 = 48;
        } else {
            i4 = 16;
        }
        textView4.setGravity(i4);
        TextView textView5 = this.A0A;
        if (!this.A01) {
            i7 = 13;
        }
        C0535Le.A0b(textView5, false, i7);
        this.A0A.setEllipsize(TextUtils.TruncateAt.END);
        layoutParams4.setMargins(0, 0, A0M * 3, 0);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -1);
        this.A0B.setTextColor(-1);
        C0535Le.A0b(this.A0B, true, 13);
        this.A0B.setGravity(16);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -1);
        int i9 = A0N;
        layoutParams6.setMargins(0, i9, 0, i9);
        LinearLayout.LayoutParams reviewsCountViewParams = new LinearLayout.LayoutParams(-2, -1);
        this.A0C.setMaxLines(1);
        this.A0C.setTextColor(-1);
        this.A0C.setEllipsize(TextUtils.TruncateAt.END);
        this.A0C.setGravity(16);
        C0535Le.A0b(this.A0C, false, 13);
        this.A07.addView(this.A0B, layoutParams5);
        this.A07.addView(this.A03, layoutParams6);
        this.A07.addView(this.A0C, reviewsCountViewParams);
        LinearLayout linearLayout = this.A07;
        if (this.A01) {
            i6 = 8;
        }
        linearLayout.setVisibility(i6);
        this.A06.addView(this.A0D, this.A05);
        this.A06.addView(this.A07, this.A04);
        this.A06.addView(this.A0A, layoutParams4);
    }
}
