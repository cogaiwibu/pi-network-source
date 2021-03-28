package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RoundImageView extends ImageView {
    private int a = 0;
    private int b = 0;

    public RoundImageView(Context context) {
        super(context);
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Drawable drawable = getDrawable();
        if (drawable != null && getWidth() != 0 && getHeight() != 0) {
            measure(0, 0);
            if (drawable.getClass() != NinePatchDrawable.class && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                try {
                    bitmap2 = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                } catch (Throwable unused) {
                    bitmap2 = null;
                }
                if (bitmap2 == null) {
                    super.onDraw(canvas);
                    return;
                }
                if (this.a == 0) {
                    this.a = getWidth();
                }
                if (this.b == 0) {
                    this.b = getHeight();
                }
                int i = this.a;
                int i2 = this.b;
                if (i >= i2) {
                    i = i2;
                }
                int i3 = i / 2;
                try {
                    bitmap3 = a(bitmap2, i3);
                } catch (Throwable unused2) {
                    bitmap3 = null;
                }
                if (bitmap3 == null) {
                    super.onDraw(canvas);
                } else {
                    canvas.drawBitmap(bitmap3, (float) ((this.a / 2) - i3), (float) ((this.b / 2) - i3), (Paint) null);
                }
            }
        }
    }

    private Bitmap a(Bitmap bitmap, int i) {
        Bitmap bitmap2;
        int i2 = i * 2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (height > width) {
            bitmap2 = Bitmap.createBitmap(bitmap, 0, (height - width) / 2, width, width);
        } else {
            bitmap2 = height < width ? Bitmap.createBitmap(bitmap, (width - height) / 2, 0, height, height) : null;
        }
        if (bitmap2 != null) {
            bitmap = bitmap2;
        }
        if (!(bitmap.getWidth() == i2 && bitmap.getHeight() == i2)) {
            bitmap = Bitmap.createScaledBitmap(bitmap, i2, i2, true);
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle((float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() / 2), (float) (bitmap.getWidth() / 2), paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }
}
