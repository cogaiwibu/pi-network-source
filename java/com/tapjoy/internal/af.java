package com.tapjoy.internal;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public final class af extends Animation {
    private final boolean a;
    private final float b;
    private final float c;
    private final int d;
    private final float e;
    private final int f;
    private final float g;
    private float h;
    private float i;
    private Camera j;

    public af(boolean z, float f2, float f3, int i2, float f4, int i3, float f5) {
        this.a = z;
        this.b = f2;
        this.c = f3;
        this.d = i2;
        this.e = f4;
        this.f = i3;
        this.g = f5;
    }

    public final void initialize(int i2, int i3, int i4, int i5) {
        super.initialize(i2, i3, i4, i5);
        this.h = resolveSize(this.d, this.e, i2, i4);
        this.i = resolveSize(this.f, this.g, i3, i5);
        this.j = new Camera();
    }

    /* access modifiers changed from: protected */
    public final void applyTransformation(float f2, Transformation transformation) {
        float f3 = this.b;
        float f4 = f3 + ((this.c - f3) * f2);
        Matrix matrix = transformation.getMatrix();
        Camera camera = this.j;
        camera.save();
        if (this.a) {
            camera.rotateX(f4);
        } else {
            camera.rotateY(f4);
        }
        camera.getMatrix(matrix);
        camera.restore();
        float f5 = this.h;
        float f6 = this.i;
        matrix.preTranslate(-f5, -f6);
        matrix.postTranslate(f5, f6);
    }
}
