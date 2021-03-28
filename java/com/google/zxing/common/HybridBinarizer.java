package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;
import java.lang.reflect.Array;
import kotlin.UByte;

public final class HybridBinarizer extends GlobalHistogramBinarizer {
    private static final int BLOCK_SIZE = 8;
    private static final int BLOCK_SIZE_MASK = 7;
    private static final int BLOCK_SIZE_POWER = 3;
    private static final int MINIMUM_DIMENSION = 40;
    private static final int MIN_DYNAMIC_RANGE = 24;
    private BitMatrix matrix;

    private static int cap(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    public HybridBinarizer(LuminanceSource luminanceSource) {
        super(luminanceSource);
    }

    @Override // com.google.zxing.common.GlobalHistogramBinarizer, com.google.zxing.Binarizer
    public BitMatrix getBlackMatrix() throws NotFoundException {
        BitMatrix bitMatrix = this.matrix;
        if (bitMatrix != null) {
            return bitMatrix;
        }
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        int height = luminanceSource.getHeight();
        if (width < 40 || height < 40) {
            this.matrix = super.getBlackMatrix();
        } else {
            byte[] matrix2 = luminanceSource.getMatrix();
            int i = width >> 3;
            if ((width & 7) != 0) {
                i++;
            }
            int i2 = height >> 3;
            if ((height & 7) != 0) {
                i2++;
            }
            int[][] calculateBlackPoints = calculateBlackPoints(matrix2, i, i2, width, height);
            BitMatrix bitMatrix2 = new BitMatrix(width, height);
            calculateThresholdForBlock(matrix2, i, i2, width, height, calculateBlackPoints, bitMatrix2);
            this.matrix = bitMatrix2;
        }
        return this.matrix;
    }

    @Override // com.google.zxing.common.GlobalHistogramBinarizer, com.google.zxing.Binarizer
    public Binarizer createBinarizer(LuminanceSource luminanceSource) {
        return new HybridBinarizer(luminanceSource);
    }

    private static void calculateThresholdForBlock(byte[] bArr, int i, int i2, int i3, int i4, int[][] iArr, BitMatrix bitMatrix) {
        int i5 = i4 - 8;
        int i6 = i3 - 8;
        for (int i7 = 0; i7 < i2; i7++) {
            int i8 = i7 << 3;
            int i9 = i8 > i5 ? i5 : i8;
            int cap = cap(i7, 2, i2 - 3);
            for (int i10 = 0; i10 < i; i10++) {
                int i11 = i10 << 3;
                int i12 = i11 > i6 ? i6 : i11;
                int cap2 = cap(i10, 2, i - 3);
                int i13 = 0;
                for (int i14 = -2; i14 <= 2; i14++) {
                    int[] iArr2 = iArr[cap + i14];
                    i13 += iArr2[cap2 - 2] + iArr2[cap2 - 1] + iArr2[cap2] + iArr2[cap2 + 1] + iArr2[cap2 + 2];
                }
                thresholdBlock(bArr, i12, i9, i13 / 25, i3, bitMatrix);
            }
        }
    }

    private static void thresholdBlock(byte[] bArr, int i, int i2, int i3, int i4, BitMatrix bitMatrix) {
        int i5 = (i2 * i4) + i;
        int i6 = 0;
        while (i6 < 8) {
            for (int i7 = 0; i7 < 8; i7++) {
                if ((bArr[i5 + i7] & UByte.MAX_VALUE) <= i3) {
                    bitMatrix.set(i + i7, i2 + i6);
                }
            }
            i6++;
            i5 += i4;
        }
    }

    private static int[][] calculateBlackPoints(byte[] bArr, int i, int i2, int i3, int i4) {
        int i5 = 8;
        int i6 = i4 - 8;
        int i7 = i3 - 8;
        int[] iArr = new int[2];
        iArr[1] = i;
        iArr[0] = i2;
        int[][] iArr2 = (int[][]) Array.newInstance(int.class, iArr);
        int i8 = 0;
        while (i8 < i2) {
            int i9 = i8 << 3;
            if (i9 > i6) {
                i9 = i6;
            }
            int i10 = 0;
            while (i10 < i) {
                int i11 = i10 << 3;
                if (i11 > i7) {
                    i11 = i7;
                }
                int i12 = (i9 * i3) + i11;
                int i13 = 255;
                int i14 = 0;
                int i15 = 0;
                int i16 = 0;
                while (i14 < i5) {
                    int i17 = i16;
                    int i18 = 0;
                    while (i18 < i5) {
                        int i19 = bArr[i12 + i18] & UByte.MAX_VALUE;
                        i15 += i19;
                        if (i19 < i13) {
                            i13 = i19;
                        }
                        if (i19 > i17) {
                            i17 = i19;
                        }
                        i18++;
                        i5 = 8;
                    }
                    if (i17 - i13 <= 24) {
                        i14++;
                        i12 += i3;
                        i16 = i17;
                        i5 = 8;
                    }
                    while (true) {
                        i14++;
                        i12 += i3;
                        if (i14 >= 8) {
                            break;
                        }
                        int i20 = 0;
                        for (int i21 = 8; i20 < i21; i21 = 8) {
                            i15 += bArr[i12 + i20] & UByte.MAX_VALUE;
                            i20++;
                        }
                    }
                    i14++;
                    i12 += i3;
                    i16 = i17;
                    i5 = 8;
                }
                int i22 = i15 >> 6;
                if (i16 - i13 <= 24) {
                    i22 = i13 / 2;
                    if (i8 > 0 && i10 > 0) {
                        int i23 = i8 - 1;
                        int i24 = i10 - 1;
                        int i25 = ((iArr2[i23][i10] + (iArr2[i8][i24] * 2)) + iArr2[i23][i24]) / 4;
                        if (i13 < i25) {
                            i22 = i25;
                        }
                        iArr2[i8][i10] = i22;
                        i10++;
                        i5 = 8;
                    }
                }
                iArr2[i8][i10] = i22;
                i10++;
                i5 = 8;
            }
            i8++;
            i5 = 8;
        }
        return iArr2;
    }
}
