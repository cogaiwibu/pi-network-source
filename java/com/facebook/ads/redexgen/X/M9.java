package com.facebook.ads.redexgen.X;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.view.View;
import android.widget.RelativeLayout;

public final class M9 extends View {
    public int A00;
    public Paint A01;
    public Paint A02;
    public Paint A03;
    public boolean A04;

    public M9(C0820Wh wh) {
        this(wh, 60, true);
    }

    public M9(C0820Wh wh, int i, boolean z) {
        super(wh);
        this.A00 = i;
        this.A04 = z;
        if (z) {
            this.A02 = new Paint();
            this.A02.setColor(-3355444);
            this.A02.setStyle(Paint.Style.STROKE);
            this.A02.setStrokeWidth(3.0f);
            this.A02.setAntiAlias(true);
            this.A01 = new Paint();
            this.A01.setColor(-1287371708);
            this.A01.setStyle(Paint.Style.FILL);
            this.A01.setAntiAlias(true);
            this.A03 = new Paint();
            this.A03.setColor(-1);
            this.A03.setStyle(Paint.Style.STROKE);
            this.A03.setStrokeWidth(6.0f);
            this.A03.setAntiAlias(true);
        }
    }

    public RelativeLayout.LayoutParams getDefaultLayoutParams() {
        float f = C0535Le.A01;
        int i = this.A00;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (((float) i) * f), (int) (((float) i) * f));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        return layoutParams;
    }

    /* JADX INFO: Multiple debug info for r1v3 int: [D('startY' int), D('innerRadius' int)] */
    public final void onDraw(Canvas canvas) {
        if (this.A04) {
            if (canvas.isHardwareAccelerated() && Build.VERSION.SDK_INT < 17) {
                setLayerType(1, null);
            }
            int min = Math.min(canvas.getWidth(), canvas.getHeight());
            int i = min / 2;
            int i2 = min / 2;
            int i3 = (i * 2) / 3;
            canvas.drawCircle((float) i, (float) i2, (float) i3, this.A02);
            canvas.drawCircle((float) i, (float) i2, (float) (i3 - 2), this.A01);
            int i4 = min / 3;
            int innerRadius = min / 3;
            canvas.drawLine((float) i4, (float) innerRadius, (float) (i4 * 2), (float) (innerRadius * 2), this.A03);
            canvas.drawLine((float) (i4 * 2), (float) innerRadius, (float) i4, (float) (innerRadius * 2), this.A03);
        }
        super.onDraw(canvas);
    }
}
