package com.facebook.ads.redexgen.X;

import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.Ne  reason: case insensitive filesystem */
public final class C0586Ne extends LinearLayout {
    public static String[] A05;
    public int A00 = -1;
    public List<GradientDrawable> A01;
    public final int A02;
    public final int A03;
    public final int A04;

    static {
        A00();
    }

    public static void A00() {
        A05 = new String[]{"JiUd07qZ", "phaLMHqUBlp6P5RZzzm", "VtPMRXbuUkVLmtGCwM", "RgvNiIo52t", "FYi9K2JmgPw1hqWSXD3EPgcEPQmLRiB", "yPPKnDMDveXTdnfoUUkFxo3t2NtgVDwK", "Cr", "5lHXxybE2bQiDNmNKuHItJ8Sueck67l"};
    }

    public C0586Ne(C0820Wh wh, AnonymousClass1H r11, int dotSize) {
        super(wh);
        setOrientation(0);
        setGravity(17);
        float f = C0535Le.A01;
        int i = (int) (8.0f * f);
        int i2 = (int) (6.0f * f);
        this.A02 = (int) (1.0f * f);
        this.A04 = r11.A04(false);
        this.A03 = AnonymousClass2G.A01(this.A04, 128);
        this.A01 = new ArrayList();
        for (int i3 = 0; i3 < dotSize; i3++) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setSize(i, i);
            gradientDrawable.setStroke(this.A02, 0);
            ImageView imageView = new ImageView(wh);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, i2, 0);
            layoutParams.gravity = 17;
            imageView.setLayoutParams(layoutParams);
            imageView.setImageDrawable(gradientDrawable);
            this.A01.add(gradientDrawable);
            addView(imageView);
        }
        A01(0);
    }

    public final void A01(int i) {
        int i2;
        int i3;
        if (this.A00 != i) {
            this.A00 = i;
            if (A05[2].length() != 22) {
                String[] strArr = A05;
                strArr[4] = "BJqXxH8n0fuaHx3JVwGHjWVcPjmBGjI";
                strArr[7] = "ZUGfW6Md7SIL60yz7Eq8Bq3LU56iFcm";
                for (int i4 = 0; i4 < this.A01.size(); i4++) {
                    if (i4 == i) {
                        i2 = this.A04;
                        i3 = this.A04;
                    } else {
                        i2 = this.A03;
                        i3 = 0;
                    }
                    this.A01.get(i4).setStroke(this.A02, i3);
                    this.A01.get(i4).setColor(i2);
                    this.A01.get(i4).invalidateSelf();
                }
                return;
            }
            throw new RuntimeException();
        }
    }
}
