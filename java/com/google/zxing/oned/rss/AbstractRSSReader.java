package com.google.zxing.oned.rss;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.oned.OneDReader;

public abstract class AbstractRSSReader extends OneDReader {
    private static final float MAX_AVG_VARIANCE = 0.2f;
    private static final float MAX_FINDER_PATTERN_RATIO = 0.89285713f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.45f;
    private static final float MIN_FINDER_PATTERN_RATIO = 0.7916667f;
    private final int[] dataCharacterCounters;
    private final int[] decodeFinderCounters = new int[4];
    private final int[] evenCounts;
    private final float[] evenRoundingErrors;
    private final int[] oddCounts;
    private final float[] oddRoundingErrors;

    protected AbstractRSSReader() {
        int[] iArr = new int[8];
        this.dataCharacterCounters = iArr;
        this.oddRoundingErrors = new float[4];
        this.evenRoundingErrors = new float[4];
        this.oddCounts = new int[(iArr.length / 2)];
        this.evenCounts = new int[(iArr.length / 2)];
    }

    /* access modifiers changed from: protected */
    public final int[] getDecodeFinderCounters() {
        return this.decodeFinderCounters;
    }

    /* access modifiers changed from: protected */
    public final int[] getDataCharacterCounters() {
        return this.dataCharacterCounters;
    }

    /* access modifiers changed from: protected */
    public final float[] getOddRoundingErrors() {
        return this.oddRoundingErrors;
    }

    /* access modifiers changed from: protected */
    public final float[] getEvenRoundingErrors() {
        return this.evenRoundingErrors;
    }

    /* access modifiers changed from: protected */
    public final int[] getOddCounts() {
        return this.oddCounts;
    }

    /* access modifiers changed from: protected */
    public final int[] getEvenCounts() {
        return this.evenCounts;
    }

    protected static int parseFinderValue(int[] iArr, int[][] iArr2) throws NotFoundException {
        for (int i = 0; i < iArr2.length; i++) {
            if (patternMatchVariance(iArr, iArr2[i], MAX_INDIVIDUAL_VARIANCE) < MAX_AVG_VARIANCE) {
                return i;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Deprecated
    protected static int count(int[] iArr) {
        return MathUtils.sum(iArr);
    }

    protected static void increment(int[] iArr, float[] fArr) {
        int i = 0;
        float f = fArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] > f) {
                f = fArr[i2];
                i = i2;
            }
        }
        iArr[i] = iArr[i] + 1;
    }

    protected static void decrement(int[] iArr, float[] fArr) {
        int i = 0;
        float f = fArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] < f) {
                f = fArr[i2];
                i = i2;
            }
        }
        iArr[i] = iArr[i] - 1;
    }

    protected static boolean isFinderPattern(int[] iArr) {
        int i = iArr[0] + iArr[1];
        float f = ((float) i) / ((float) ((iArr[2] + i) + iArr[3]));
        if (f >= MIN_FINDER_PATTERN_RATIO && f <= MAX_FINDER_PATTERN_RATIO) {
            int i2 = Integer.MAX_VALUE;
            int i3 = Integer.MIN_VALUE;
            for (int i4 : iArr) {
                if (i4 > i3) {
                    i3 = i4;
                }
                if (i4 < i2) {
                    i2 = i4;
                }
            }
            if (i3 < i2 * 10) {
                return true;
            }
        }
        return false;
    }
}
