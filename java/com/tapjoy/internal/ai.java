package com.tapjoy.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;

public class ai extends aj {
    private int a = 0;
    private final Matrix b = new Matrix();
    private final float[] c = new float[2];

    public ai(Context context) {
        super(context);
    }

    public int getRotationCount() {
        return this.a;
    }

    public void setRotationCount(int i) {
        this.a = i & 3;
    }

    @Override // com.tapjoy.internal.aj
    public void onMeasure(int i, int i2) {
        if (this.a % 2 == 0) {
            super.onMeasure(i, i2);
            return;
        }
        super.onMeasure(i2, i);
        setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (this.a == 0) {
            super.dispatchDraw(canvas);
            return;
        }
        canvas.save();
        int width = getWidth();
        int height = getHeight();
        canvas.clipRect(0, 0, width, height);
        try {
            ViewGroup viewGroup = (ViewGroup) getParent();
            try {
                ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
                if ((viewGroup2 instanceof ScrollView) || (viewGroup2 instanceof HorizontalScrollView)) {
                    viewGroup = viewGroup2;
                }
            } catch (Exception unused) {
            }
            int left = getLeft() - viewGroup.getScrollX();
            int top = getTop() - viewGroup.getScrollY();
            canvas.clipRect(0 - left, 0 - top, viewGroup.getWidth() - left, viewGroup.getHeight() - top);
        } catch (Exception unused2) {
        }
        canvas.rotate((float) (this.a * 90));
        int i = this.a;
        if (i == 1) {
            canvas.translate(0.0f, (float) (-width));
        } else if (i == 2) {
            canvas.translate((float) (-width), (float) (-height));
        } else if (i == 3) {
            canvas.translate((float) (-height), 0.0f);
        } else {
            throw new IllegalStateException();
        }
        this.b.setRotate((float) (this.a * -90));
        int i2 = this.a;
        if (i2 == 1) {
            this.b.postTranslate(0.0f, (float) (width - 1));
        } else if (i2 == 2) {
            this.b.postTranslate((float) (width - 1), (float) (height - 1));
        } else if (i2 == 3) {
            this.b.postTranslate((float) (height - 1), 0.0f);
        } else {
            throw new IllegalStateException();
        }
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.a == 0) {
            return super.dispatchTouchEvent(motionEvent);
        }
        float[] fArr = this.c;
        fArr[0] = motionEvent.getX();
        fArr[1] = motionEvent.getY();
        this.b.mapPoints(fArr);
        motionEvent.setLocation(fArr[0], fArr[1]);
        return super.dispatchTouchEvent(motionEvent);
    }
}
