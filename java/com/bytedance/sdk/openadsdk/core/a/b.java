package com.bytedance.sdk.openadsdk.core.a;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.b.d;
import com.bytedance.sdk.openadsdk.core.c.c;
import com.bytedance.sdk.openadsdk.core.c.g;
import com.bytedance.sdk.openadsdk.core.u;
import com.bytedance.sdk.openadsdk.g.t;
import com.tapjoy.TJAdUnitConstants;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: ClickListener */
public class b extends c {
    protected final Context b;
    protected final g c;
    protected final String d;
    protected final int e;
    protected WeakReference<View> f;
    protected WeakReference<View> g;
    protected c h;
    protected a i;
    protected TTNativeAd j;
    protected com.bytedance.sdk.openadsdk.core.video.nativevideo.c k;
    protected boolean l = false;
    protected com.com.bytedance.overseas.sdk.download.b m;
    protected Map<String, Object> n;

    /* compiled from: ClickListener */
    public interface a {
        void a(View view, int i);
    }

    public void a(com.com.bytedance.overseas.sdk.download.b bVar) {
        this.m = bVar;
    }

    public void a(Map<String, Object> map) {
        this.n = map;
    }

    public void c(boolean z) {
        this.l = z;
    }

    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar) {
        this.k = cVar;
    }

    public b(Context context, g gVar, String str, int i2) {
        this.b = context.getApplicationContext();
        this.c = gVar;
        this.d = str;
        this.e = i2;
    }

    public void a(View view) {
        this.f = new WeakReference<>(view);
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.c
    public void b(View view, int i2, int i3, int i4, int i5) {
        View view2;
        g gVar;
        if (this.b != null) {
            long j2 = this.s;
            long j3 = this.t;
            WeakReference<View> weakReference = this.f;
            if (weakReference == null) {
                view2 = null;
            } else {
                view2 = weakReference.get();
            }
            WeakReference<View> weakReference2 = this.g;
            this.h = a(i2, i3, i4, i5, j2, j3, view2, weakReference2 == null ? null : weakReference2.get());
            a aVar = this.i;
            if (aVar != null) {
                aVar.a(view, -1);
            }
            Context context = this.b;
            g gVar2 = this.c;
            int i6 = this.e;
            boolean a2 = u.a(context, gVar2, i6, this.k, this.j, t.a(i6), this.m);
            if (a2 || (gVar = this.c) == null || gVar.t() == null || this.c.t().c() != 2) {
                d.a(this.b, TJAdUnitConstants.String.CLICK, this.c, this.h, this.d, a2, this.n);
            }
        }
    }

    /* access modifiers changed from: protected */
    public c a(int i2, int i3, int i4, int i5, long j2, long j3, View view, View view2) {
        return new c.a().d(i2).c(i3).b(i4).a(i5).b(j2).a(j3).b(com.bytedance.sdk.openadsdk.g.u.a(view)).a(com.bytedance.sdk.openadsdk.g.u.a(view2)).c(com.bytedance.sdk.openadsdk.g.u.b(view)).d(com.bytedance.sdk.openadsdk.g.u.b(view2)).e(this.u).f(this.v).g(this.w).a();
    }
}
