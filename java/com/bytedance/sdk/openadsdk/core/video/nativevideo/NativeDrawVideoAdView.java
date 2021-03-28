package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.view.View;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.e.b;
import com.bytedance.sdk.openadsdk.g.t;
import com.bytedance.sdk.openadsdk.g.u;
import java.util.concurrent.atomic.AtomicBoolean;

public class NativeDrawVideoAdView extends NativeVideoAdView implements View.OnClickListener {
    private boolean k;
    private AtomicBoolean l;

    /* access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoAdView
    public void a() {
        this.d = false;
        this.i = "draw_ad";
        j.e().f(String.valueOf(t.c(this.a.u())));
        super.a();
    }

    /* access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoAdView
    public void b() {
        if (this.k) {
            super.b();
        }
    }

    public void setCanInterruptVideoPlay(boolean z) {
        this.k = z;
    }

    /* access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoAdView
    public void onWindowVisibilityChanged(int i) {
        f();
        if (this.g == null || this.g.getVisibility() != 0) {
            super.onWindowVisibilityChanged(i);
        } else {
            g();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoAdView
    public void onWindowFocusChanged(boolean z) {
        f();
        if (this.g == null || this.g.getVisibility() != 0) {
            super.onWindowFocusChanged(z);
        } else {
            g();
        }
    }

    private void e() {
        u.a(this.e, 0);
        u.a(this.f, 0);
        u.a(this.h, 8);
    }

    private void f() {
        if (!this.l.get() && g.b().q() != null) {
            this.h.setImageBitmap(g.b().q());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.h.getLayoutParams();
            int a = (int) u.a(getContext(), (float) this.j);
            layoutParams.width = a;
            layoutParams.height = a;
            this.h.setLayoutParams(layoutParams);
            this.l.set(true);
        }
    }

    private void g() {
        if (this.e.getVisibility() != 0) {
            b.a(getContext()).a(this.a.e().f(), this.f);
            e();
        }
    }

    public void onClick(View view) {
        if (this.g != null && this.g.getVisibility() == 0) {
            u.d(this.e);
        }
        b();
    }
}
