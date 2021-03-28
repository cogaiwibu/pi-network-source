package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.0N  reason: invalid class name */
public final class AnonymousClass0N {
    public static byte[] A00;

    static {
        A06();
    }

    public static String A04(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 61);
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        A00 = new byte[]{46, 33, 36, 45, 114, 103, 103};
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
        options.inSampleSize = A00(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeStream(r3, null, options);
    }

    @SuppressLint({"CatchGeneralException"})
    public static Bitmap A02(String str, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = A00(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    @Nullable
    @SuppressLint({"CatchGeneralException"})
    public static Bitmap A03(String str, int i, int i2, boolean z) throws IOException {
        Bitmap bitmap;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(new File(str));
            if (i <= 0 || i2 <= 0) {
                bitmap = BitmapFactory.decodeStream(fileInputStream);
            } else if (z) {
                bitmap = A01(fileInputStream, i, i2);
            } else {
                bitmap = A02(str, i, i2);
            }
            return bitmap;
        } finally {
            A07(fileInputStream);
        }
    }

    @Nullable
    public static String A05(@Nullable File file) {
        if (file == null) {
            return null;
        }
        return A04(0, 7, 117) + file.getPath();
    }

    public static void A07(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
