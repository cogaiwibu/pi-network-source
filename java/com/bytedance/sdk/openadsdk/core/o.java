package com.bytedance.sdk.openadsdk.core;

import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.core.c.g;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;

/* compiled from: SingleAppData */
public class o {
    private static o a;
    private c b;
    private boolean c = true;
    private g d;
    private TTRewardVideoAd.RewardAdInteractionListener e;
    private TTFullScreenVideoAd.FullScreenVideoAdInteractionListener f;
    private boolean g = false;

    private o() {
    }

    public static o a() {
        if (a == null) {
            a = new o();
        }
        return a;
    }

    public c b() {
        return this.b;
    }

    public void a(c cVar) {
        this.b = cVar;
        this.c = false;
    }

    public void a(boolean z) {
        this.c = z;
    }

    public boolean c() {
        return this.c;
    }

    public g d() {
        return this.d;
    }

    public void a(g gVar) {
        this.d = gVar;
    }

    public TTRewardVideoAd.RewardAdInteractionListener e() {
        return this.e;
    }

    public TTFullScreenVideoAd.FullScreenVideoAdInteractionListener f() {
        return this.f;
    }

    public void a(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.f = fullScreenVideoAdInteractionListener;
    }

    public void a(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.e = rewardAdInteractionListener;
    }

    public boolean g() {
        return this.g;
    }

    public void b(boolean z) {
        this.g = z;
    }

    public void h() {
        this.b = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = false;
        this.c = true;
    }
}
