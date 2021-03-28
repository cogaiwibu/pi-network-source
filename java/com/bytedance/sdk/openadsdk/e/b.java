package com.bytedance.sdk.openadsdk.e;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.sdk.adnet.a.b;
import com.bytedance.sdk.adnet.a.d;
import com.bytedance.sdk.adnet.core.e;
import com.bytedance.sdk.adnet.core.l;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.face.IHttpStack;
import com.bytedance.sdk.openadsdk.core.j;

/* compiled from: TTNetClient */
public class b {
    private static volatile b a;
    private static IHttpStack c;
    private Context b;
    private l d;
    private com.bytedance.sdk.adnet.a.b e;
    private l f;
    private d g;

    public static IHttpStack a() {
        return c;
    }

    public static void a(IHttpStack iHttpStack) {
        c = iHttpStack;
    }

    public static e b() {
        return new e();
    }

    public static b a(Context context) {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b(context);
                }
            }
        }
        return a;
    }

    private b(Context context) {
        this.b = context == null ? j.a() : context.getApplicationContext();
    }

    public void a(String str, b.a aVar) {
        e();
        if (this.e == null) {
            this.e = new com.bytedance.sdk.adnet.a.b(this.b, this.d);
        }
        this.e.a(str, aVar);
    }

    public l c() {
        f();
        return this.f;
    }

    public void a(String str, ImageView imageView) {
        a(str, imageView, a(str, imageView, 0, 0));
    }

    public void a(String str, ImageView imageView, d.AbstractC0001d dVar) {
        d();
        this.g.a(str, dVar);
    }

    public static a a(String str, ImageView imageView, int i, int i2) {
        return new a(imageView, str, i, i2);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: TTNetClient */
    public static class a implements d.AbstractC0001d {
        private ImageView a;
        private final String b;
        private final int c;
        private final int d;

        @Override // com.bytedance.sdk.adnet.core.m.a
        public void a(m<Bitmap> mVar) {
        }

        a(ImageView imageView, String str, int i, int i2) {
            this.a = imageView;
            this.b = str;
            this.c = i;
            this.d = i2;
            if (imageView != null) {
                imageView.setTag(1094453505, str);
            }
        }

        @Override // com.bytedance.sdk.adnet.a.d.AbstractC0001d
        public void a() {
            int i;
            ImageView imageView = this.a;
            if ((imageView == null || !(imageView.getContext() instanceof Activity) || !((Activity) this.a.getContext()).isFinishing()) && this.a != null && c() && (i = this.c) != 0) {
                this.a.setImageResource(i);
            }
        }

        @Override // com.bytedance.sdk.adnet.a.d.AbstractC0001d
        public void a(d.c cVar, boolean z) {
            ImageView imageView = this.a;
            if ((imageView == null || !(imageView.getContext() instanceof Activity) || !((Activity) this.a.getContext()).isFinishing()) && this.a != null && c() && cVar.a() != null) {
                this.a.setImageBitmap(cVar.a());
            }
        }

        @Override // com.bytedance.sdk.adnet.a.d.AbstractC0001d
        public void b() {
            this.a = null;
        }

        @Override // com.bytedance.sdk.adnet.core.m.a
        public void b(m<Bitmap> mVar) {
            ImageView imageView = this.a;
            if ((imageView == null || !(imageView.getContext() instanceof Activity) || !((Activity) this.a.getContext()).isFinishing()) && this.a != null && this.d != 0 && c()) {
                this.a.setImageResource(this.d);
            }
        }

        private boolean c() {
            Object tag;
            ImageView imageView = this.a;
            if (imageView == null || (tag = imageView.getTag(1094453505)) == null || !tag.equals(this.b)) {
                return false;
            }
            return true;
        }
    }

    private void d() {
        if (this.g == null) {
            f();
            this.g = new d(this.f, a.a());
        }
    }

    private void e() {
        if (this.d == null) {
            this.d = com.bytedance.sdk.adnet.a.a(this.b, a());
        }
    }

    private void f() {
        if (this.f == null) {
            this.f = com.bytedance.sdk.adnet.a.a(this.b, a());
        }
    }
}
