package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.7L  reason: invalid class name */
public final class AnonymousClass7L {
    public static byte[] A00;

    static {
        A04();
    }

    public static String A03(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 86);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{92, 88, 84, 82, 80};
    }

    public static int A00(BitmapFactory.Options options, int width, int inSampleSize) {
        int i = options.outHeight;
        int i2 = options.outWidth;
        int height = 1;
        if (i > inSampleSize || i2 > width) {
            int i3 = i / 2;
            int halfHeight = i2 / 2;
            while (i3 / height >= inSampleSize && halfHeight / height >= width) {
                height *= 2;
            }
        }
        return height;
    }

    @Nullable
    public static Bitmap A01(InputStream inputStream, int i, int i2) throws IOException {
        if (Build.VERSION.SDK_INT < 19) {
            return BitmapFactory.decodeStream(inputStream);
        }
        AnonymousClass0O r3 = new AnonymousClass0O(inputStream);
        r3.mark(8192);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(r3, null, options);
        r3.reset();
        if (r3.A01()) {
            return BitmapFactory.decodeStream(r3);
        }
        options.inSampleSize = A00(options, i2, i);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeStream(r3, null, options);
    }

    @Nullable
    @SuppressLint({"CatchGeneralException"})
    public static Bitmap A02(String str, int i, int i2, AnonymousClass8H r5) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = A00(options, i2, i);
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        } catch (Throwable th) {
            r5.A04().A82(A03(0, 5, 99), C02248i.A1N, new C02258j(th));
            return null;
        }
    }
}
