package com.facebook.ads.redexgen.X;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Zn  reason: case insensitive filesystem */
public final class C0902Zn extends M1 {
    public static byte[] A06;
    public static String[] A07;
    public static final int A08 = Color.parseColor(A02(0, 9, 75));
    public static final int A09 = ((int) (C0535Le.A01 * 16.0f));
    @Nullable
    public M0 A00;
    public final C0820Wh A01;
    public final JL A02;
    public final C0556Lz A03;
    public final Zm A04;
    public final M6 A05;

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A07[4].length() != 19) {
                String[] strArr = A07;
                strArr[4] = "L2RboTZhxjQ9awTRnLbhSQGg6v";
                strArr[4] = "L2RboTZhxjQ9awTRnLbhSQGg6v";
                if (i4 >= length) {
                    return new String(copyOfRange);
                }
                copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 127);
                i4++;
            } else {
                throw new RuntimeException();
            }
        }
    }

    public static void A03() {
        A06 = new byte[]{-19, -2, 14, -6, -6, -6, -6, -6, -6, 25, 74, 61, -8, 81, 71, 77, -8, 75, 77, 74, 61, -8, 81, 71, 77, -8, 79, 57, 70, 76, -8, 76, 71, -8, 75, 67, 65, 72, -8, 76, 64, 61, -8, 57, 60, 23, -8, 49, 71, 77, -8, 79, 65, 68, 68, -8, 68, 71, 75, 61, -8, 81, 71, 77, 74, -8, 74, 61, 79, 57, 74, 60, 6, 36, 77, 80, 84, 70, 1, 34, 69, -22, -3, 11, 13, 5, -3, -72, -39, -4, -11, 13, 11, 18, -62, -29, 6, 66, 90, 88, 95, 15, 48, 83, 15, 80, 93, 83, 15, 59, 94, 98, 84, 15, 65, 84, 102, 80, 97, 83};
    }

    public static void A04() {
        A07 = new String[]{"DSMXyIjmw5HclhajbHNu0bHfM2UoxQfV", "VI8qELbWvj15goD4sBQF3Ikg1AZrbLrB", "e65oiusvVwGlpJBKbHqtCRVJnI6YlHd3", "IRi9ljHD5lnLVRZZd0Abks", "cwd6", "joZNq3IpHeg70E", "Xkn9HJi", "Qn9IhJ0zzYM2Lk7aXz3vW7M0LF"};
    }

    static {
        A04();
        A03();
    }

    public C0902Zn(C0820Wh wh, M6 m6, JL jl, int i, int i2) {
        super(wh);
        this.A01 = wh;
        this.A05 = m6;
        this.A02 = jl;
        setGravity(16);
        this.A04 = new Zm(wh, i);
        this.A04.setBackgroundColor(A08);
        this.A04.setContentDescription(A02(73, 8, 98));
        this.A04.setActionClickListener(new M3(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        View view = new View(wh);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        layoutParams2.weight = 1.0f;
        this.A03 = new C0556Lz(wh, i2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        int i3 = A09;
        layoutParams3.setMargins(i3, 0, i3, 0);
        this.A03.setBackgroundColor(A08);
        if (J8.A1N(wh)) {
            addView(this.A03, layoutParams3);
            addView(view, layoutParams2);
            addView(this.A04, layoutParams);
            return;
        }
        addView(this.A04, layoutParams);
        addView(view, layoutParams2);
        addView(this.A03, layoutParams3);
    }

    @Override // com.facebook.ads.redexgen.X.M1
    public final void A05(AnonymousClass1H r1, boolean z) {
    }

    @Override // com.facebook.ads.redexgen.X.M1
    public final void A06(MQ mq) {
        Activity A092 = this.A01.A09();
        if (A092 != null) {
            DialogC0909Zw zw = new DialogC0909Zw(this.A01, A092);
            setUpSkipDialog(zw, mq);
            zw.show();
        }
    }

    @Override // com.facebook.ads.redexgen.X.M1
    public final boolean A07() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.M1
    public int getToolbarHeight() {
        return M1.A00;
    }

    @Override // com.facebook.ads.redexgen.X.M1
    public void setAdReportingVisible(boolean z) {
    }

    @Override // com.facebook.ads.redexgen.X.M1
    public void setPageDetails(AnonymousClass1Q r4, String str, int i, AnonymousClass1X r7) {
        this.A04.setInitialUnskippableSeconds(i);
        this.A03.setAdDetails(r4, str, this.A02, this.A05);
    }

    @Override // com.facebook.ads.redexgen.X.M1
    public void setPageDetailsVisible(boolean z) {
    }

    @Override // com.facebook.ads.redexgen.X.M1
    public void setProgress(float f) {
        this.A04.setProgress(f);
    }

    @Override // com.facebook.ads.redexgen.X.M1
    public void setToolbarActionMessage(String str) {
    }

    @Override // com.facebook.ads.redexgen.X.M1
    public void setToolbarActionMode(int i) {
        this.A04.setToolbarActionMode(i);
    }

    @Override // com.facebook.ads.redexgen.X.M1
    public void setToolbarListener(M0 m0) {
        this.A00 = m0;
    }

    private void setUpSkipDialog(DialogC0909Zw zw, MQ mq) {
        zw.A08(A02(97, 23, 112));
        zw.A05(A02(9, 64, 89));
        zw.A06(A02(90, 7, 35));
        zw.A07(A02(81, 9, 25));
        zw.A03(new M4(this, mq, zw));
        zw.A04(new M5(this, mq, zw));
    }
}
