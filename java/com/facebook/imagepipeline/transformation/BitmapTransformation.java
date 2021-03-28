package com.facebook.imagepipeline.transformation;

import android.graphics.Bitmap;

public interface BitmapTransformation {
    boolean modifiesTransparency();

    void transform(Bitmap bitmap);
}
