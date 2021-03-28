package com.facebook.ads.redexgen.X;

import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;

public final class O1 extends FrameLayout {
    public static byte[] A04;
    public static String[] A05;
    public static final int A06 = ((int) (C0535Le.A01 * 23.0f));
    public static final int A07 = ((int) (C0535Le.A01 * 3.0f));
    public static final int A08 = ((int) (C0535Le.A01 * 8.0f));
    public static final int A09 = ((int) (C0535Le.A01 * 36.0f));
    public static final int A0A = ((int) (C0535Le.A01 * 36.0f));
    public static final int A0B = ((int) (C0535Le.A01 * 4.0f));
    public final int A00;
    public final RelativeLayout A01;
    public final View$OnClickListenerC0827Wo A02;
    public final C0600Ns A03;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 30);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        byte[] bArr = {69, 73, 75, 8, 64, 71, 69, 67, 68, 73, 73, 77, 8, 71, 66, 85, 8, 79, 72, 82, 67, 84, 85, 82, 79, 82, 79, 71, 74, 8, 69, 74, 79, 69, 77, 67, 66, 7, 16, 2, 20, 7, 17, 16, 17, 42, 3, 28, 17, 16, 26};
        String[] strArr = A05;
        if (strArr[3].charAt(15) != strArr[4].charAt(15)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A05;
        strArr2[5] = "M6cOBFfgZV5WrXqkO4ySzzXWKNERUvDd";
        strArr2[1] = "WlW2JqkldnDOleaZiTbYh0p7usvkNGUh";
        A04 = bArr;
    }

    public static void A02() {
        A05 = new String[]{"ETopWcrKoMciXJ", "1fAm0Qu4GTtFv02w82npEu9QoUOkP81a", "kVTrWQ9", "rJ2v45uLjqrwh5Cb8v0uvinsp2r56JAZ", "ea7XoHjS0E3igDkbOVl09dybSdR2gWYC", "2SqEzPP8dz4OE7L9BTgTSspAixKmYBe2", "Gvao2GnTf255Ph834nKKQFNtQ7sU5Fe8", "O3MbW7jFVfRGmhn"};
    }

    static {
        A02();
        A01();
    }

    public O1(C0600Ns ns, String str, AnonymousClass1H r17, AbstractC0582Na na) {
        super(ns.A05());
        String A002;
        this.A03 = ns;
        this.A00 = r17.A08(true);
        this.A01 = new RelativeLayout(ns.A05());
        addView(this.A01, new FrameLayout.LayoutParams(-1, -1));
        this.A01.setClickable(false);
        A04(str);
        if (ns.A04().A0T().equals(A00(37, 14, 107))) {
            A002 = EnumC0628Ou.A04.A02();
        } else {
            A002 = A00(0, 37, 56);
        }
        this.A02 = new View$OnClickListenerC0827Wo(ns.A05(), A002, null, ns.A06(), ns.A09(), ns.A0B(), ns.A07());
        this.A02.setCta(ns.A04().A0M().A0G(), ns.A04().A0Q(), new HashMap(), na);
        this.A02.setIsInAppBrowser(true);
        addView(this.A02, new FrameLayout.LayoutParams(-1, -1));
    }

    private void A03(View view) {
        ImageView imageView = new ImageView(this.A03.A05());
        imageView.setImageBitmap(C0544Ln.A00(EnumC0543Lm.MINIMIZE_ARROW));
        imageView.setRotation(180.0f);
        imageView.setClickable(false);
        imageView.setColorFilter(this.A00);
        int i = A06;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
        int i2 = A07;
        imageView.setPadding(i2, i2, i2, i2);
        layoutParams.addRule(2, view.getId());
        layoutParams.addRule(14);
        this.A01.addView(imageView, layoutParams);
    }

    private void A04(String str) {
        Button button = new Button(this.A03.A05());
        C0535Le.A0N(button);
        int i = A0A;
        button.setPadding(i, 0, i, 0);
        button.setText(str.toUpperCase(Locale.getDefault()));
        button.setTextSize(14.0f);
        button.setTypeface(Typeface.defaultFromStyle(1));
        C0535Le.A0S(button, this.A00, A0B);
        button.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, A09);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.A01.addView(button, layoutParams);
        A03(button);
    }

    public final boolean performClick() {
        return this.A02.performClick();
    }
}
