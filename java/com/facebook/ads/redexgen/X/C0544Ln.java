package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;

/* renamed from: com.facebook.ads.redexgen.X.Ln  reason: case insensitive filesystem */
public final class C0544Ln {
    public static Bitmap A00(EnumC0543Lm lm) {
        byte[] decode = Base64.decode(lm.A01(C0535Le.A01), 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public static Drawable A01(C0820Wh wh, EnumC0543Lm lm) {
        return new BitmapDrawable(wh.getResources(), A00(lm));
    }
}
