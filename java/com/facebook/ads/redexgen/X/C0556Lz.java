package com.facebook.ads.redexgen.X;

import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Lz  reason: case insensitive filesystem */
public final class C0556Lz extends LinearLayout {
    public static byte[] A03;
    public static final int A04 = ((int) (C0535Le.A01 * 10.0f));
    public static final int A05 = ((int) (C0535Le.A01 * 20.0f));
    public static final int A06 = ((int) (C0535Le.A01 * 12.0f));
    public static final int A07 = ((int) (C0535Le.A01 * 50.0f));
    public static final int A08 = ((int) (C0535Le.A01 * 4.0f));
    public final ImageView A00;
    public final ImageView A01;
    public final C0820Wh A02;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 91);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{118, 83};
    }

    static {
        A02();
    }

    public C0556Lz(C0820Wh wh, int i) {
        super(wh);
        this.A02 = wh;
        setOrientation(0);
        this.A00 = new ImageView(wh);
        this.A01 = new ImageView(wh);
        A03(i);
    }

    /* JADX INFO: Multiple debug info for r7v0 'this'  com.facebook.ads.redexgen.X.Lz: [D('textViewParams' android.widget.LinearLayout$LayoutParams), D('infoIconImage' com.facebook.ads.redexgen.X.Lm)] */
    private void A03(int i) {
        EnumC0543Lm lm;
        A04(this.A00, EnumC0543Lm.AD_CHOICES_ICON);
        if (i == 2) {
            int i2 = A04;
            setPadding(i2, i2 / 3, i2, i2 / 3);
            TextView textView = new TextView(this.A02);
            textView.setText(A01(0, 2, 108));
            textView.setTextColor(-1);
            int i3 = A04;
            textView.setPadding(0, i3 / 2, i3 / 2, i3 / 2);
            C0535Le.A0b(textView, true, 13);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            addView(textView, layoutParams);
            int i4 = A06;
            LinearLayout.LayoutParams adChoicesIconParams = new LinearLayout.LayoutParams(i4, i4);
            adChoicesIconParams.gravity = 16;
            addView(this.A00, adChoicesIconParams);
            return;
        }
        int i5 = A04;
        setPadding(i5, i5, i5, i5);
        if (i == 1) {
            lm = EnumC0543Lm.AN_INFO_ICON;
        } else {
            lm = EnumC0543Lm.DEFAULT_INFO_ICON;
        }
        A04(this.A01, lm);
        int i6 = A05;
        LinearLayout.LayoutParams infoButtonParams = new LinearLayout.LayoutParams(i6, i6);
        infoButtonParams.gravity = 17;
        addView(this.A01, infoButtonParams);
        int i7 = A05;
        LinearLayout.LayoutParams infoButtonParams2 = new LinearLayout.LayoutParams(i7, i7);
        infoButtonParams2.setMargins(A08, 0, 0, 0);
        infoButtonParams2.gravity = 17;
        addView(this.A00, infoButtonParams2);
    }

    public static void A04(ImageView imageView, EnumC0543Lm lm) {
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setImageBitmap(C0544Ln.A00(lm));
        imageView.setColorFilter(-1);
    }

    public void setAdDetails(AnonymousClass1Q r7, String str, JL jl, M6 m6) {
        setOnClickListener(new View$OnClickListenerC0555Ly(this, jl, m6, str, r7));
    }

    public void setBackgroundColor(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius((float) A07);
        gradientDrawable.setColor(i);
        C0535Le.A0W(this, gradientDrawable);
    }

    public void setIconColors(int i) {
        this.A00.setColorFilter(i);
        this.A01.setColorFilter(i);
    }
}
