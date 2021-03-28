package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.core.c.a;
import com.bytedance.sdk.openadsdk.core.c.g;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.video.b.e;
import com.bytedance.sdk.openadsdk.g.n;

/* compiled from: TTAdNativeImpl */
class q implements TTAdNative {
    private final k a = j.c();
    private final Context b;

    q(Context context) {
        this.b = context;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadRewardVideoAd(AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        b(adSlot);
        e.a(this.b).a(adSlot, rewardVideoAdListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadFullScreenVideoAd(final AdSlot adSlot, final TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        a(adSlot);
        this.a.a(adSlot, null, 8, new k.a() {
            /* class com.bytedance.sdk.openadsdk.core.q.AnonymousClass1 */

            @Override // com.bytedance.sdk.openadsdk.core.k.a
            public void a(int i, String str) {
                fullScreenVideoAdListener.onError(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.k.a
            public void a(a aVar) {
                if (aVar.c() == null || aVar.c().isEmpty()) {
                    fullScreenVideoAdListener.onError(-3, ErrorCode.message(-3));
                    return;
                }
                g gVar = aVar.c().get(0);
                if (gVar.B()) {
                    s sVar = new s(q.this.b, gVar, adSlot, fullScreenVideoAdListener);
                    sVar.a();
                    fullScreenVideoAdListener.onFullScreenVideoAdLoad(sVar);
                    return;
                }
                fullScreenVideoAdListener.onError(-4, ErrorCode.message(-4));
            }
        });
    }

    private void a(AdSlot adSlot) {
        boolean z = true;
        n.a(adSlot.getImgAcceptedWidth() > 0, "必须设置图片素材尺寸");
        if (adSlot.getImgAcceptedHeight() <= 0) {
            z = false;
        }
        n.a(z, "必须设置图片素材尺寸");
    }

    private void b(AdSlot adSlot) {
        a(adSlot);
        n.a(adSlot.getNativeAdType() == 0, "请求非原生广告的类型，请勿调用setNativeAdType()方法");
    }
}
