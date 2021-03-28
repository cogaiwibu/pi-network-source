package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.widget.ImageView;

/* renamed from: com.facebook.ads.redexgen.X.Ni  reason: case insensitive filesystem */
public final class C0590Ni extends ImageView {
    public float A00 = 1.0f;
    public final int A01;
    public final int A02;
    public final Bitmap A03 = C0544Ln.A00(EnumC0543Lm.RATINGS);

    public C0590Ni(C0820Wh wh, int i, int i2) {
        super(wh);
        this.A01 = i;
        this.A02 = i2;
    }

    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint(2);
        paint.setColorFilter(new PorterDuffColorFilter(this.A01, PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(this.A03, (Rect) null, new Rect(0, 0, getWidth(), getHeight()), paint);
        paint.setColorFilter(new PorterDuffColorFilter(this.A02, PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(this.A03, new Rect(0, 0, (int) (this.A00 * ((float) this.A03.getWidth())), this.A03.getHeight()), new Rect(0, 0, (int) (this.A00 * ((float) getWidth())), getHeight()), paint);
    }

    public void setFillRatio(float f) {
        this.A00 = f;
        postInvalidate();
    }
}
