package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.g.u;

public class TTCornersWebView extends WebView {
    private int a;
    private int b;
    private int c;
    private int d;
    private Paint e;
    private Paint f;
    private float[] g = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};

    public TTCornersWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public TTCornersWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        Paint paint = new Paint();
        this.e = paint;
        paint.setColor(-1);
        this.e.setAntiAlias(true);
        this.e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.f = paint2;
        paint2.setXfermode(null);
        this.f.setAntiAlias(true);
        float a2 = u.a(context, 14.0f);
        a(a2, a2, 0.0f, 0.0f);
    }

    public void a(float f2, float f3, float f4, float f5) {
        float[] fArr = this.g;
        fArr[0] = f2;
        fArr[1] = f2;
        fArr[2] = f3;
        fArr[3] = f3;
        fArr[4] = f4;
        fArr[5] = f4;
        fArr[6] = f5;
        fArr[7] = f5;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.a = getMeasuredWidth();
        this.b = getMeasuredHeight();
    }

    public void onDraw(Canvas canvas) {
        this.c = getScrollX();
        this.d = getScrollY();
        Path path = new Path();
        int i = this.d;
        path.addRoundRect(new RectF(0.0f, (float) i, (float) (this.c + this.a), (float) (i + this.b)), this.g, Path.Direction.CW);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }
}
