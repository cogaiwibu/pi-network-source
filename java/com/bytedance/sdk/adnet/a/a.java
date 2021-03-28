package com.bytedance.sdk.adnet.a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.LruCache;
import android.widget.ImageView;
import com.bytedance.sdk.adnet.a.d;
import com.bytedance.sdk.adnet.core.n;

/* compiled from: DefaultImageCache */
public class a implements d.b {
    protected LruCache<String, Bitmap> a = new LruCache<String, Bitmap>(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16) {
        /* class com.bytedance.sdk.adnet.a.a.AnonymousClass1 */

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int sizeOf(String str, Bitmap bitmap) {
            return bitmap.getRowBytes() * bitmap.getHeight();
        }
    };

    @Override // com.bytedance.sdk.adnet.a.d.b
    public String a(String str, int i, int i2, ImageView.ScaleType scaleType) {
        return null;
    }

    @Override // com.bytedance.sdk.adnet.a.d.b
    public Bitmap a(String str) {
        try {
            return this.a.get(str);
        } catch (Throwable th) {
            n.a(th, "DefaultImageCache get bitmap error", new Object[0]);
            return null;
        }
    }

    @Override // com.bytedance.sdk.adnet.a.d.b
    public void a(String str, Bitmap bitmap) {
        if (!TextUtils.isEmpty(str) && bitmap != null) {
            try {
                this.a.put(str, bitmap);
            } catch (Throwable th) {
                n.a(th, "DefaultImageCache put bitmap error", new Object[0]);
            }
        }
    }
}
