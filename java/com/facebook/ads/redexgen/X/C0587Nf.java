package com.facebook.ads.redexgen.X;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.widget.ImageView;

/* renamed from: com.facebook.ads.redexgen.X.Nf  reason: case insensitive filesystem */
public class C0587Nf extends ImageView {
    public static final int A04 = ((int) (C0535Le.A01 * 8.0f));
    public static final float[] A05;
    public boolean A00 = false;
    public float[] A01 = A05;
    public final Path A02 = new Path();
    public final RectF A03 = new RectF();

    static {
        int i = A04;
        A05 = new float[]{(float) i, (float) i, (float) i, (float) i, (float) i, (float) i, (float) i, (float) i};
    }

    public C0587Nf(C0820Wh wh) {
        super(wh);
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    private float[] getRadiiForCircularImage() {
        int min = Math.min(getWidth(), getHeight()) / 2;
        return new float[]{(float) min, (float) min, (float) min, (float) min, (float) min, (float) min, (float) min, (float) min};
    }

    public final void onDraw(Canvas canvas) {
        float[] fArr;
        this.A03.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        this.A02.reset();
        if (this.A00) {
            fArr = getRadiiForCircularImage();
        } else {
            fArr = this.A01;
        }
        this.A02.addRoundRect(this.A03, fArr, Path.Direction.CW);
        canvas.clipPath(this.A02);
        super.onDraw(canvas);
    }

    public void setFullCircleCorners(boolean z) {
        this.A00 = z;
    }

    public void setRadius(int i) {
        int i2 = (int) (((float) i) * C0535Le.A01);
        this.A01 = new float[]{(float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2};
    }

    public void setRadius(float[] fArr) {
        this.A01 = fArr;
    }
}
