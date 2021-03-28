package com.tapjoy.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public final class in extends View {
    public boolean a = false;
    private Bitmap b = null;
    private Rect c = null;
    private Rect d = null;
    private Rect e = null;
    private Rect f = new Rect();

    public in(Context context) {
        super(context);
    }

    public final void setImageBitmap(Bitmap bitmap) {
        this.b = bitmap;
        int width = bitmap.getWidth();
        int height = this.b.getHeight();
        int i = width / 2;
        this.d = new Rect(0, 0, i, height);
        this.c = new Rect(i, 0, width, height);
        a();
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        if (this.a) {
            this.e = this.c;
        } else {
            this.e = this.d;
        }
    }

    public final void onDraw(Canvas canvas) {
        if (this.e != null && this.b != null) {
            getDrawingRect(this.f);
            canvas.drawBitmap(this.b, this.e, this.f, (Paint) null);
        }
    }
}
