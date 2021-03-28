package com.facebook.ads.redexgen.X;

import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.ads.AdSize;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.Ju  reason: case insensitive filesystem */
public final class C0502Ju {
    public static String[] A00;
    public static final Map<EnumC0499Jr, EnumC0500Js> A01 = new HashMap();

    public static void A03() {
        A00 = new String[]{"aUzGFJWT9JUej7dfFIRBXB2Am5SKhp0L", "Lg", "z6uS01sVSQZKuOHXwfbCrotAFRq98Mhk", "s6upF4yW2rVlVN4uyEeLi2N0Ec6ZN78T", "eH22UAfKgSlQJvnKnPkmgNwQr7bKVvHo", "ohZIQy", "XInXF4zeGGrmw79hhTd", "dMAEap8Em2lp2DdLAyvSKUklRkWZ0JXT"};
    }

    static {
        A03();
        A01.put(EnumC0499Jr.A09, EnumC0500Js.A09);
        A01.put(EnumC0499Jr.A07, EnumC0500Js.A0B);
        A01.put(EnumC0499Jr.A06, EnumC0500Js.A0A);
    }

    public static AdSize A00(EnumC0500Js js) {
        for (Map.Entry<EnumC0499Jr, EnumC0500Js> entry : A01.entrySet()) {
            if (entry.getValue() == js) {
                EnumC0499Jr key = entry.getKey();
                if (A00[5].length() != 27) {
                    String[] strArr = A00;
                    strArr[2] = "sySRfG1wiaC9q3S7uTxa3ZVw3iXf1vjk";
                    strArr[2] = "sySRfG1wiaC9q3S7uTxa3ZVw3iXf1vjk";
                    return key.A06();
                }
                throw new RuntimeException();
            }
        }
        return AdSize.BANNER_320_50;
    }

    public static EnumC0500Js A01(DisplayMetrics displayMetrics) {
        int i = (int) (((float) displayMetrics.widthPixels) / displayMetrics.density);
        int i2 = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        if (LA.A04(i, i2)) {
            return EnumC0500Js.A0E;
        }
        if (i2 > i) {
            return EnumC0500Js.A0G;
        }
        return EnumC0500Js.A0D;
    }

    public static EnumC0500Js A02(EnumC0499Jr jr) {
        EnumC0500Js js = A01.get(jr);
        if (js == null) {
            return EnumC0500Js.A0C;
        }
        return js;
    }

    public static void A04(DisplayMetrics displayMetrics, View view, EnumC0499Jr jr) {
        int ceil;
        if (((int) (((float) displayMetrics.widthPixels) / displayMetrics.density)) >= jr.getWidth()) {
            ceil = displayMetrics.widthPixels;
        } else {
            ceil = (int) Math.ceil((double) (((float) jr.getWidth()) * displayMetrics.density));
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ceil, (int) Math.ceil((double) (((float) jr.getHeight()) * displayMetrics.density)));
        layoutParams.addRule(14, -1);
        view.setLayoutParams(layoutParams);
    }
}
