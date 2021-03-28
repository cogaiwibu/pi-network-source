package androidx.interpolator.view.animation;

import android.view.animation.Interpolator;

/* access modifiers changed from: package-private */
public abstract class LookupTableInterpolator implements Interpolator {
    private final float mStepSize;
    private final float[] mValues;

    protected LookupTableInterpolator(float[] fArr) {
        this.mValues = fArr;
        this.mStepSize = 1.0f / ((float) (fArr.length - 1));
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.mValues;
        int min = Math.min((int) (((float) (fArr.length - 1)) * f), fArr.length - 2);
        float f2 = this.mStepSize;
        float f3 = (f - (((float) min) * f2)) / f2;
        float[] fArr2 = this.mValues;
        return fArr2[min] + (f3 * (fArr2[min + 1] - fArr2[min]));
    }
}
