package com.facebook.imagepipeline.filter;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;

public abstract class IterativeBoxBlurFilter {
    private static final String TAG = "IterativeBoxBlurFilter";

    private static int bound(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    public static void boxBlurBitmapInPlace(Bitmap bitmap, int i, int i2) {
        Preconditions.checkNotNull(bitmap);
        Preconditions.checkArgument(bitmap.isMutable());
        Preconditions.checkArgument(((float) bitmap.getHeight()) <= 2048.0f);
        Preconditions.checkArgument(((float) bitmap.getWidth()) <= 2048.0f);
        Preconditions.checkArgument(i2 > 0 && i2 <= 25);
        Preconditions.checkArgument(i > 0);
        try {
            fastBoxBlur(bitmap, i, i2);
        } catch (OutOfMemoryError e) {
            FLog.e(TAG, String.format(null, "OOM: %d iterations on %dx%d with %d radius", Integer.valueOf(i), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(i2)));
            throw e;
        }
    }

    private static void fastBoxBlur(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[(width * height)];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i3 = i2 + 1;
        int i4 = i3 + i2;
        int[] iArr2 = new int[(i4 * 256)];
        int i5 = 1;
        while (true) {
            if (i5 > 255) {
                break;
            }
            for (int i6 = 0; i6 < i4; i6++) {
                iArr2[i3] = i5;
                i3++;
            }
            i5++;
        }
        int[] iArr3 = new int[Math.max(width, height)];
        for (int i7 = 0; i7 < i; i7++) {
            for (int i8 = 0; i8 < height; i8++) {
                internalHorizontalBlur(iArr, iArr3, width, i8, i4, iArr2);
                System.arraycopy(iArr3, 0, iArr, i8 * width, width);
            }
            for (int i9 = 0; i9 < width; i9++) {
                internalVerticalBlur(iArr, iArr3, width, height, i9, i4, iArr2);
                int i10 = i9;
                for (int i11 = 0; i11 < height; i11++) {
                    iArr[i10] = iArr3[i11];
                    i10 += width;
                }
            }
        }
        bitmap.setPixels(iArr, 0, width, 0, 0, width, height);
    }

    private static void internalHorizontalBlur(int[] iArr, int[] iArr2, int i, int i2, int i3, int[] iArr3) {
        int i4 = i * i2;
        int i5 = ((i2 + 1) * i) - 1;
        int i6 = i3 >> 1;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = -i6; i11 < i + i6; i11++) {
            int i12 = iArr[bound(i4 + i11, i4, i5)];
            i7 += (i12 >> 16) & 255;
            i8 += (i12 >> 8) & 255;
            i9 += i12 & 255;
            i10 += i12 >>> 24;
            if (i11 >= i6) {
                iArr2[i11 - i6] = (iArr3[i10] << 24) | (iArr3[i7] << 16) | (iArr3[i8] << 8) | iArr3[i9];
                int i13 = iArr[bound((i11 - (i3 - 1)) + i4, i4, i5)];
                i7 -= (i13 >> 16) & 255;
                i8 -= (i13 >> 8) & 255;
                i9 -= i13 & 255;
                i10 -= i13 >>> 24;
            }
        }
    }

    private static void internalVerticalBlur(int[] iArr, int[] iArr2, int i, int i2, int i3, int i4, int[] iArr3) {
        int i5 = ((i2 - 1) * i) + i3;
        int i6 = (i4 >> 1) * i;
        int i7 = (i4 - 1) * i;
        int i8 = i3 - i6;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i8 <= i5 + i6) {
            int i14 = iArr[bound(i8, i3, i5)];
            i9 += (i14 >> 16) & 255;
            i10 += (i14 >> 8) & 255;
            i11 += i14 & 255;
            i12 += i14 >>> 24;
            if (i8 - i6 >= i3) {
                iArr2[i13] = (iArr3[i12] << 24) | (iArr3[i9] << 16) | (iArr3[i10] << 8) | iArr3[i11];
                i13++;
                int i15 = iArr[bound(i8 - i7, i3, i5)];
                i9 -= (i15 >> 16) & 255;
                i10 -= (i15 >> 8) & 255;
                i11 -= i15 & 255;
                i12 -= i15 >>> 24;
            }
            i8 += i;
        }
    }
}
