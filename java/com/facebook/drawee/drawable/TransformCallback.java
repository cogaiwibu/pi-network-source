package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.RectF;

public interface TransformCallback {
    void getRootBounds(RectF rectF);

    void getTransform(Matrix matrix);
}
