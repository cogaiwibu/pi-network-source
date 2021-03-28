package com.bytedance.sdk.openadsdk.core.video.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.b.d;
import com.bytedance.sdk.openadsdk.core.ErrorCode;
import com.bytedance.sdk.openadsdk.core.c.g;
import com.bytedance.sdk.openadsdk.core.c.h;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.video.b.c;
import com.bytedance.sdk.openadsdk.g.l;
import com.bytedance.sdk.openadsdk.g.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: RewardVideoLoadManager */
public class e {
    private static volatile e a;
    private Context b;
    private final k c = j.c();
    private AtomicBoolean d = new AtomicBoolean(false);
    private List<a> e = Collections.synchronizedList(new ArrayList());
    private ExecutorService f = Executors.newSingleThreadExecutor();
    private final BroadcastReceiver g = new BroadcastReceiver() {
        /* class com.bytedance.sdk.openadsdk.core.video.b.e.AnonymousClass2 */

        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && m.c(e.this.b) != 0) {
                Iterator it = e.this.e.iterator();
                while (it.hasNext()) {
                    e.this.f.execute((Runnable) it.next());
                    it.remove();
                }
            }
        }
    };

    public static e a(Context context) {
        if (a == null) {
            synchronized (e.class) {
                if (a == null) {
                    a = new e(context);
                }
            }
        }
        return a;
    }

    private e(Context context) {
        this.b = context == null ? j.a() : context.getApplicationContext();
        a();
    }

    public void a(AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        l.b("RewardVideoLoadManager", "load reward vide: " + String.valueOf(adSlot));
        c.a(this.b).a(adSlot);
        a(adSlot, false, rewardVideoAdListener);
    }

    public void a(AdSlot adSlot) {
        l.b("RewardVideoLoadManager", "preload reward video: " + String.valueOf(adSlot));
        a(adSlot, true, null);
    }

    private void a(AdSlot adSlot, boolean z, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        if (z) {
            b(adSlot, true, rewardVideoAdListener);
            return;
        }
        g c2 = c.a(this.b).c(adSlot.getCodeId());
        if (c2 != null) {
            f fVar = new f(this.b, c2, adSlot, rewardVideoAdListener);
            fVar.a(c.a(this.b).a(c2));
            d.a(c2);
            if (rewardVideoAdListener != null) {
                rewardVideoAdListener.onRewardVideoAdLoad(fVar);
                rewardVideoAdListener.onRewardVideoCached();
            }
            l.b("RewardVideoLoadManager", "get cache data success");
            return;
        }
        b(adSlot, false, rewardVideoAdListener);
    }

    private void b(final AdSlot adSlot, final boolean z, final TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        h hVar = new h();
        hVar.b = z ? 2 : 1;
        this.c.a(adSlot, hVar, 7, new k.a() {
            /* class com.bytedance.sdk.openadsdk.core.video.b.e.AnonymousClass1 */

            @Override // com.bytedance.sdk.openadsdk.core.k.a
            public void a(int i, String str) {
                TTAdNative.RewardVideoAdListener rewardVideoAdListener;
                if (!z && (rewardVideoAdListener = rewardVideoAdListener) != null) {
                    rewardVideoAdListener.onError(i, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.k.a
            public void a(com.bytedance.sdk.openadsdk.core.c.a aVar) {
                TTAdNative.RewardVideoAdListener rewardVideoAdListener;
                TTAdNative.RewardVideoAdListener rewardVideoAdListener2;
                TTAdNative.RewardVideoAdListener rewardVideoAdListener3;
                if (aVar.c() != null && !aVar.c().isEmpty()) {
                    l.b("RewardVideoLoadManager", "get material data success: " + z);
                    final g gVar = aVar.c().get(0);
                    final f fVar = new f(e.this.b, gVar, adSlot, rewardVideoAdListener);
                    if (!z && (rewardVideoAdListener3 = rewardVideoAdListener) != null) {
                        rewardVideoAdListener3.onRewardVideoAdLoad(fVar);
                    }
                    if (gVar.B()) {
                        if (!z || j.e().e(adSlot.getCodeId()).d != 1) {
                            c.a(e.this.b).a(gVar, new c.a<Object>() {
                                /* class com.bytedance.sdk.openadsdk.core.video.b.e.AnonymousClass1.AnonymousClass1 */

                                @Override // com.bytedance.sdk.openadsdk.core.video.b.c.a
                                public void a(boolean z, Object obj) {
                                    l.b("RewardVideoLoadManager", "download video file: " + z + ", preload: " + z);
                                    if (z) {
                                        fVar.a(c.a(e.this.b).a(gVar));
                                    }
                                    if (!z) {
                                        d.a(gVar);
                                        if (z && rewardVideoAdListener != null) {
                                            rewardVideoAdListener.onRewardVideoCached();
                                        }
                                    } else if (z) {
                                        c.a(e.this.b).a(adSlot, gVar);
                                    }
                                }
                            });
                        } else if (!m.d(e.this.b)) {
                            e eVar = e.this;
                            eVar.a((e) new a(gVar, adSlot));
                        }
                    } else if (!z && (rewardVideoAdListener2 = rewardVideoAdListener) != null) {
                        rewardVideoAdListener2.onError(-4, ErrorCode.message(-4));
                    }
                } else if (!z && (rewardVideoAdListener = rewardVideoAdListener) != null) {
                    rewardVideoAdListener.onError(-3, ErrorCode.message(-3));
                }
            }
        });
    }

    public void a(String str) {
        c.a(this.b).a(str);
    }

    public AdSlot b(String str) {
        return c.a(this.b).b(str);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(a aVar) {
        if (aVar != null) {
            if (this.e.size() >= 1) {
                this.e.remove(0);
            }
            this.e.add(aVar);
        }
    }

    private void a() {
        if (!this.d.get()) {
            this.d.set(true);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            try {
                this.b.registerReceiver(this.g, intentFilter);
            } catch (Exception unused) {
            }
        }
    }

    private void b() {
        if (this.d.get()) {
            this.d.set(false);
            try {
                this.b.unregisterReceiver(this.g);
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        b();
    }

    /* access modifiers changed from: private */
    /* compiled from: RewardVideoLoadManager */
    public class a implements Runnable {
        g a;
        AdSlot b;

        a(g gVar, AdSlot adSlot) {
            this.a = gVar;
            this.b = adSlot;
        }

        public void run() {
            c.a(e.this.b).a(this.a, new c.a<Object>() {
                /* class com.bytedance.sdk.openadsdk.core.video.b.e.a.AnonymousClass1 */

                @Override // com.bytedance.sdk.openadsdk.core.video.b.c.a
                public void a(boolean z, Object obj) {
                    if (z) {
                        c.a(e.this.b).a(a.this.b, a.this.a);
                    }
                }
            });
        }
    }
}
