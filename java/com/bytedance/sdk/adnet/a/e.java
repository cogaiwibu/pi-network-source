package com.bytedance.sdk.adnet.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.bytedance.sdk.adnet.b.b;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.j;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.core.n;

/* compiled from: ImageRequest */
public class e extends Request<Bitmap> {
    private static final Object i = new Object();
    private final Object c = new Object();
    private m.a<Bitmap> d;
    private final Bitmap.Config e;
    private final int f;
    private final int g;
    private final ImageView.ScaleType h;

    public e(String str, m.a<Bitmap> aVar, int i2, int i3, ImageView.ScaleType scaleType, Bitmap.Config config) {
        super(0, str, aVar);
        setRetryPolicy(new com.bytedance.sdk.adnet.core.e(1000, 2, 2.0f));
        this.d = aVar;
        this.e = config;
        this.f = i2;
        this.g = i3;
        this.h = scaleType;
        setShouldCache(false);
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public Request.b getPriority() {
        return Request.b.LOW;
    }

    private static int a(int i2, int i3, int i4, int i5, ImageView.ScaleType scaleType) {
        if (i2 == 0 && i3 == 0) {
            return i4;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i2 == 0 ? i4 : i2;
        }
        if (i2 == 0) {
            double d2 = (double) i3;
            double d3 = (double) i5;
            Double.isNaN(d2);
            Double.isNaN(d3);
            double d4 = (double) i4;
            Double.isNaN(d4);
            return (int) (d4 * (d2 / d3));
        } else if (i3 == 0) {
            return i2;
        } else {
            double d5 = (double) i5;
            double d6 = (double) i4;
            Double.isNaN(d5);
            Double.isNaN(d6);
            double d7 = d5 / d6;
            if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                double d8 = (double) i2;
                Double.isNaN(d8);
                double d9 = (double) i3;
                if (d8 * d7 >= d9) {
                    return i2;
                }
                Double.isNaN(d9);
                return (int) (d9 / d7);
            }
            double d10 = (double) i2;
            Double.isNaN(d10);
            double d11 = (double) i3;
            if (d10 * d7 <= d11) {
                return i2;
            }
            Double.isNaN(d11);
            return (int) (d11 / d7);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.bytedance.sdk.adnet.core.Request
    public m<Bitmap> a(j jVar) {
        m<Bitmap> b;
        synchronized (i) {
            try {
                b = b(jVar);
            } catch (OutOfMemoryError e2) {
                n.c("Caught OOM for %d byte image, url=%s", Integer.valueOf(jVar.b.length), getUrl());
                return m.a(new com.bytedance.sdk.adnet.err.e(e2));
            } catch (Throwable th) {
                throw th;
            }
        }
        return b;
    }

    private m<Bitmap> b(j jVar) {
        Bitmap bitmap;
        byte[] bArr = jVar.b;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.f == 0 && this.g == 0) {
            options.inPreferredConfig = this.e;
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i2 = options.outWidth;
            int i3 = options.outHeight;
            int a = a(this.f, this.g, i2, i3, this.h);
            int a2 = a(this.g, this.f, i3, i2, this.h);
            options.inJustDecodeBounds = false;
            options.inSampleSize = a(i2, i3, a, a2);
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmap != null && (bitmap.getWidth() > a || bitmap.getHeight() > a2)) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, a, a2, true);
                bitmap.recycle();
                bitmap = createScaledBitmap;
            }
        }
        if (bitmap == null) {
            return m.a(new com.bytedance.sdk.adnet.err.e(jVar));
        }
        return m.a(bitmap, b.a(jVar));
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public void cancel() {
        super.cancel();
        synchronized (this.c) {
            this.d = null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.bytedance.sdk.adnet.core.Request
    public void a(m<Bitmap> mVar) {
        m.a<Bitmap> aVar;
        synchronized (this.c) {
            aVar = this.d;
        }
        if (aVar != null) {
            aVar.a(mVar);
        }
    }

    static int a(int i2, int i3, int i4, int i5) {
        double d2 = (double) i2;
        double d3 = (double) i4;
        Double.isNaN(d2);
        Double.isNaN(d3);
        double d4 = (double) i3;
        double d5 = (double) i5;
        Double.isNaN(d4);
        Double.isNaN(d5);
        double min = Math.min(d2 / d3, d4 / d5);
        float f2 = 1.0f;
        while (true) {
            float f3 = 2.0f * f2;
            if (((double) f3) > min) {
                return (int) f2;
            }
            f2 = f3;
        }
    }
}
