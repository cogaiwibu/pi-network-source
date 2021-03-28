package com.bytedance.sdk.openadsdk.core.video.b;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.b.d;
import com.bytedance.sdk.openadsdk.core.c.g;
import com.bytedance.sdk.openadsdk.g.t;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Map;

/* compiled from: FullScreenVideoController */
public class b extends a {
    public b(Context context, ViewGroup viewGroup, g gVar) {
        super(context, viewGroup, gVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    public void a(int i, int i2) {
        if (this.b != null && i != 308) {
            boolean s = s();
            String str = s ? "play_error" : "play_start_error";
            Map<String, Object> a = t.a(this.b, i, i2, n());
            if (s) {
                a.put(IronSourceConstants.EVENTS_DURATION, Long.valueOf(i()));
                a.put("percent", Integer.valueOf(k()));
                a.put("buffers_time", Long.valueOf(h()));
            }
            d.c((Context) this.a.get(), this.b, "fullscreen_interstitial_ad", str, a);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    public void v() {
        d.a((Context) this.a.get(), this.b, "fullscreen_interstitial_ad", "feed_over", this.c, 100, u());
    }

    /* access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    public void w() {
        d.a((Context) this.a.get(), this.b, "fullscreen_interstitial_ad", "play_pause", i(), k(), u());
    }

    /* access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    public void x() {
        d.a((Context) this.a.get(), this.b, "fullscreen_interstitial_ad", "continue_play", this.g, k(), u());
    }

    /* access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    public void y() {
        d.b((Context) this.a.get(), this.b, "fullscreen_interstitial_ad", "feed_play", t());
    }

    /* access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    public void z() {
        d.b((Context) this.a.get(), this.b, "fullscreen_interstitial_ad", "feed_play", t());
    }
}
