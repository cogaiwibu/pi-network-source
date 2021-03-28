package com.facebook.ads.redexgen.X;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.Nl  reason: case insensitive filesystem */
public final class C0593Nl extends LinearLayout {
    public static String[] A04;
    public static final float A05 = Resources.getSystem().getDisplayMetrics().density;
    public static final int A06;
    public static final int A07;
    public boolean A00;
    public final TextView A01;
    public final TextView A02;
    public final TextView A03;

    public static void A00() {
        A04 = new String[]{"lF8IVPZcS3mZAefsIaNZ6E9xMmjOqdH7", "idkW2", "HbWJiF6R60B06srsOI5ot4Pv3KsUxfPN", "7f3O1w3Qg3dv0DYXPvEPDd2nNc", "nnNATfNTHr6hSEkqMWy2MP3i9vksRg0T", "pai30RxYeYeDatKriEp6xPPXjxDmZE6E", "MhBAxeK5XElhMNsb", "N4hTYih9SgQSzhMEA04rsaAJRIerHLwS"};
    }

    static {
        A00();
        float f = A05;
        A07 = (int) (6.0f * f);
        A06 = (int) (f * 8.0f);
    }

    public C0593Nl(C0820Wh wh, AnonymousClass1H r7, boolean z, int i, int i2, int i3) {
        super(wh);
        this.A00 = false;
        setOrientation(1);
        this.A03 = new TextView(wh);
        C0535Le.A0b(this.A03, true, i);
        this.A03.setEllipsize(TextUtils.TruncateAt.END);
        this.A03.setLineSpacing((float) A07, 1.0f);
        this.A02 = new TextView(wh);
        this.A01 = new TextView(wh);
        C0535Le.A0b(this.A01, false, i2);
        this.A01.setEllipsize(TextUtils.TruncateAt.END);
        this.A01.setLineSpacing((float) A07, 1.0f);
        addView(this.A03, new LinearLayout.LayoutParams(-1, -2));
        addView(this.A02, new LinearLayout.LayoutParams(-1, -2));
        this.A02.setVisibility(8);
        A01(r7, z);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, i3, 0, 0);
        addView(this.A01, layoutParams);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C0593Nl(com.facebook.ads.redexgen.X.C0820Wh r8, com.facebook.ads.redexgen.X.AnonymousClass1H r9, boolean r10, boolean r11, boolean r12) {
        /*
            r7 = this;
            if (r11 == 0) goto L_0x0019
            r4 = 18
        L_0x0004:
            if (r11 == 0) goto L_0x0016
            r5 = 14
        L_0x0008:
            int r6 = com.facebook.ads.redexgen.X.C0593Nl.A06
            if (r12 == 0) goto L_0x000e
            int r6 = r6 / 2
        L_0x000e:
            r0 = r7
            r2 = r9
            r3 = r10
            r1 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        L_0x0016:
            r5 = 16
            goto L_0x0008
        L_0x0019:
            r4 = 22
            goto L_0x0004
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0593Nl.<init>(com.facebook.ads.redexgen.X.Wh, com.facebook.ads.redexgen.X.1H, boolean, boolean, boolean):void");
    }

    public final void A01(AnonymousClass1H r3, boolean z) {
        this.A03.setTextColor(r3.A06(z));
        this.A02.setTextColor(r3.A04(z));
        this.A01.setTextColor(r3.A05(z));
    }

    public final void A02(String str, String str2, @Nullable String str3, boolean z, boolean z2) {
        int i;
        int i2 = 1;
        boolean z3 = !TextUtils.isEmpty(str);
        boolean z4 = !TextUtils.isEmpty(str2);
        TextView textView = this.A03;
        if (!z3) {
            str = str2;
        }
        textView.setText(str);
        if (str3 != null) {
            this.A02.setText(str3);
        }
        TextView textView2 = this.A01;
        if (!z3) {
            str2 = "";
        }
        textView2.setText(str2);
        if (A04[4].charAt(18) != 'y') {
            throw new RuntimeException();
        }
        String[] strArr = A04;
        strArr[4] = "cGsHRNQKRzUTXMDBZCyzngEN4Bg1pclE";
        strArr[4] = "cGsHRNQKRzUTXMDBZCyzngEN4Bg1pclE";
        int i3 = 3;
        if (!z3 || !z4) {
            TextView textView3 = this.A03;
            if (z) {
                i3 = 2;
            } else if (z2) {
                i3 = 4;
            }
            textView3.setMaxLines(i3);
            return;
        }
        TextView textView4 = this.A03;
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        textView4.setMaxLines(i);
        TextView textView5 = this.A01;
        if (!z) {
            i2 = z2 ? 3 : 2;
        }
        textView5.setMaxLines(i2);
    }

    public TextView getDescriptionTextView() {
        return this.A01;
    }

    public TextView getTitleTextView() {
        return this.A03;
    }

    public final void onConfigurationChanged(Configuration configuration) {
        boolean z;
        float f;
        float f2;
        super.onConfigurationChanged(configuration);
        if (this.A00) {
            if (configuration.orientation == 2) {
                z = true;
            } else {
                z = false;
            }
            TextView textView = this.A03;
            if (z) {
                f = 18.0f;
            } else {
                f = 22.0f;
            }
            textView.setTextSize(f);
            TextView textView2 = this.A01;
            if (z) {
                f2 = 14.0f;
            } else {
                f2 = 16.0f;
            }
            textView2.setTextSize(f2);
        }
    }

    public void setAlignment(int i) {
        this.A03.setGravity(i);
        this.A01.setGravity(i);
    }

    public void setDescriptionVisibility(int i) {
        this.A01.setVisibility(i);
    }

    public void setUseNewLandscapeEndCard(boolean z) {
        this.A00 = z;
    }
}
