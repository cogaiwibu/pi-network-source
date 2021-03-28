package com.facebook.ads.redexgen.X;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.Xk  reason: case insensitive filesystem */
public final class C0849Xk extends C0587Nf {
    public static String[] A01;
    @Nullable
    public ImageView.ScaleType A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"ApYQLHiJfFoQxPLev3v1RnZtjL3Htxrs", "bo2sqrskjgNWasJuJCrp16cZ2XBNeh8X", "emwWE4rUfgFwy6LExYmEfzkDvXYAedhg", "bPVrpfjvf63ND9vhKC9W9DFqAg6wIvw3", "k6ukfOYu7hE0QQIPVs49Kdk3IYXWEofH", "fvCBaRVGvF6m5ZfwhdbeNg6rR0MmpiyE", "HEJk8ccdn4XKVem16EvPwrOEFwPjrKpO", "Ip6ocVLC"};
    }

    public C0849Xk(C0820Wh wh) {
        super(wh);
    }

    public final void onMeasure(int widthSpecSize, int i) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(widthSpecSize);
        if (View.MeasureSpec.getMode(widthSpecSize) == 1073741824 && View.MeasureSpec.getMode(i) == 1073741824) {
            int min = Math.min(size2, size);
            setMeasuredDimension(min, min);
        } else if (View.MeasureSpec.getMode(widthSpecSize) == 1073741824) {
            if (size > 0) {
                size2 = Math.min(size2, size);
            }
            setMeasuredDimension(size2, size2);
        } else if (View.MeasureSpec.getMode(i) == 1073741824) {
            if (size2 > 0) {
                size = Math.min(size2, size);
            }
            setMeasuredDimension(size, size);
        } else {
            super.onMeasure(widthSpecSize, i);
        }
        ImageView.ScaleType scaleType = this.A00;
        if (A01[5].charAt(24) != 'y') {
            String[] strArr = A01;
            strArr[1] = "60jXKIpbxaQwCHoxf9ChBAtjlKdb11wg";
            strArr[1] = "60jXKIpbxaQwCHoxf9ChBAtjlKdb11wg";
            if (scaleType != null) {
                super.setScaleType(scaleType);
                return;
            }
            return;
        }
        throw new RuntimeException();
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.A00 = scaleType;
    }
}
