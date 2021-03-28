package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.c.j;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.d;
import com.bytedance.sdk.openadsdk.g.o;
import com.bytedance.sdk.openadsdk.g.u;

/* compiled from: VideoTrafficTipLayout */
public class c {
    private View a;
    private TextView b;
    private Context c;
    private d d;
    private b e;
    private boolean f = false;
    private j g;

    /* compiled from: VideoTrafficTipLayout */
    public enum a {
        PAUSE_VIDEO,
        RELEASE_VIDEO,
        START_VIDEO
    }

    /* compiled from: VideoTrafficTipLayout */
    public interface b {
        boolean m();

        void o();
    }

    public void a(Context context, View view) {
        if (context != null && (view instanceof ViewGroup)) {
            this.c = com.bytedance.sdk.openadsdk.core.j.a().getApplicationContext();
            View inflate = LayoutInflater.from(context).inflate(o.f(context, "tt_video_traffic_tip"), (ViewGroup) view, true);
            this.a = inflate.findViewById(o.e(context, "tt_video_traffic_tip_layout"));
            this.b = (TextView) inflate.findViewById(o.e(context, "tt_video_traffic_tip_tv"));
            inflate.findViewById(o.e(context, "tt_video_traffic_continue_play_btn")).setOnClickListener(new View.OnClickListener() {
                /* class com.bytedance.sdk.openadsdk.core.widget.c.AnonymousClass1 */

                public void onClick(View view) {
                    c.this.c();
                    if (c.this.d != null) {
                        c.this.d.a(a.START_VIDEO, (String) null);
                    }
                }
            });
        }
    }

    public void a(d dVar, b bVar) {
        this.e = bVar;
        this.d = dVar;
    }

    private void b() {
        this.g = null;
    }

    public boolean a(int i, j jVar) {
        if (this.c == null || jVar == null) {
            return true;
        }
        this.g = jVar;
        if (i == 1 || i == 2) {
            return a(i);
        }
        return true;
    }

    private boolean a(int i) {
        b bVar;
        if (a() || this.f) {
            return true;
        }
        if (!(this.d == null || (bVar = this.e) == null)) {
            if (bVar.m()) {
                this.d.e(null, null);
            }
            this.d.a(a.PAUSE_VIDEO, (String) null);
        }
        a(this.g, true);
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void c() {
        if (this.c != null) {
            d();
        }
    }

    public void a(boolean z) {
        if (z) {
            b();
        }
        d();
    }

    public boolean a() {
        View view = this.a;
        return view != null && view.getVisibility() == 0;
    }

    private void d() {
        this.a.setVisibility(8);
    }

    private void a(j jVar, boolean z) {
        View view;
        String str;
        if (jVar != null && (view = this.a) != null && this.c != null && view.getVisibility() != 0) {
            b bVar = this.e;
            if (bVar != null) {
                bVar.o();
            }
            double c2 = (double) jVar.c();
            Double.isNaN(c2);
            int ceil = (int) Math.ceil((c2 * 1.0d) / 1048576.0d);
            if (z) {
                str = o.a(this.c, "tt_video_without_wifi_tips") + ceil + o.a(this.c, "tt_video_bytesize_MB") + o.a(this.c, "tt_video_bytesize");
            } else {
                str = o.a(this.c, "tt_video_without_wifi_tips") + o.a(this.c, "tt_video_bytesize");
            }
            u.a(this.a, 0);
            u.a(this.b, str);
            if (u.c(this.a)) {
                this.a.bringToFront();
            }
        }
    }
}
