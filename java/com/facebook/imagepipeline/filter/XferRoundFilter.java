package com.facebook.imagepipeline.filter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import androidx.core.view.ViewCompat;
import com.facebook.common.internal.Preconditions;

public final class XferRoundFilter {
    private XferRoundFilter() {
    }

    public static void xferRoundBitmap(Bitmap bitmap, Bitmap bitmap2, boolean z) {
        Paint paint;
        Paint paint2;
        Preconditions.checkNotNull(bitmap2);
        Preconditions.checkNotNull(bitmap);
        bitmap.setHasAlpha(true);
        if (z) {
            paint = new Paint(1);
            paint2 = new Paint(1);
        } else {
            paint = new Paint();
            paint2 = new Paint();
        }
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        Canvas canvas = new Canvas(bitmap);
        float width = ((float) bitmap2.getWidth()) / 2.0f;
        float height = ((float) bitmap2.getHeight()) / 2.0f;
        canvas.drawCircle(width, height, Math.min(width, height), paint);
        canvas.drawBitmap(bitmap2, 0.0f, 0.0f, paint2);
    }

    public static boolean canUseXferRoundFilter() {
        return Build.VERSION.SDK_INT >= 12;
    }
}
