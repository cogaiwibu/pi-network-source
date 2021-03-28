package com.facebook.imagepipeline.filter;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;

public final class InPlaceRoundFilter {
    private InPlaceRoundFilter() {
    }

    public static void roundBitmapInPlace(Bitmap bitmap) {
        Preconditions.checkNotNull(bitmap);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int min = Math.min(width, height) / 2;
        int i = width / 2;
        int i2 = height / 2;
        if (min != 0) {
            Preconditions.checkArgument(min >= 1);
            Preconditions.checkArgument(width > 0 && ((float) width) <= 2048.0f);
            Preconditions.checkArgument(height > 0 && ((float) height) <= 2048.0f);
            Preconditions.checkArgument(i > 0 && i < width);
            Preconditions.checkArgument(i2 > 0 && i2 < height);
            int[] iArr = new int[(width * height)];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            int i3 = min - 1;
            Preconditions.checkArgument(i - i3 >= 0 && i2 - i3 >= 0 && i + i3 < width && i2 + i3 < height);
            int i4 = (-min) * 2;
            int[] iArr2 = new int[width];
            int i5 = i4 + 1;
            int i6 = 0;
            int i7 = 1;
            int i8 = 1;
            while (i3 >= i6) {
                int i9 = i + i3;
                int i10 = i - i3;
                int i11 = i + i6;
                int i12 = i - i6;
                int i13 = i2 + i3;
                int i14 = i2 - i3;
                int i15 = i2 + i6;
                int i16 = i2 - i6;
                Preconditions.checkArgument(i3 >= 0 && i11 < width && i12 >= 0 && i15 < height && i16 >= 0);
                int i17 = i15 * width;
                int i18 = width * i16;
                int i19 = width * i13;
                int i20 = width * i14;
                System.arraycopy(iArr2, 0, iArr, i17, i10);
                System.arraycopy(iArr2, 0, iArr, i18, i10);
                System.arraycopy(iArr2, 0, iArr, i19, i12);
                System.arraycopy(iArr2, 0, iArr, i20, i12);
                int i21 = width - i9;
                System.arraycopy(iArr2, 0, iArr, i17 + i9, i21);
                System.arraycopy(iArr2, 0, iArr, i18 + i9, i21);
                int i22 = width - i11;
                System.arraycopy(iArr2, 0, iArr, i19 + i11, i22);
                System.arraycopy(iArr2, 0, iArr, i20 + i11, i22);
                if (i5 <= 0) {
                    i6++;
                    i8 += 2;
                    i5 += i8;
                }
                if (i5 > 0) {
                    i3--;
                    i7 += 2;
                    i5 += i7 + i4;
                    min = min;
                    i4 = i4;
                } else {
                    min = min;
                    i4 = i4;
                    i7 = i7;
                }
                i = i;
                i2 = i2;
                height = height;
            }
            for (int i23 = i2 - min; i23 >= 0; i23--) {
                System.arraycopy(iArr2, 0, iArr, i23 * width, width);
            }
            for (int i24 = i2 + min; i24 < height; i24++) {
                System.arraycopy(iArr2, 0, iArr, i24 * width, width);
            }
            bitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        }
    }
}
