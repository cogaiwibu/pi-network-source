package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.a.b;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity;
import com.bytedance.sdk.openadsdk.b.d;
import com.bytedance.sdk.openadsdk.core.c.g;
import com.bytedance.sdk.openadsdk.g.h;
import com.bytedance.sdk.openadsdk.g.l;
import com.bytedance.sdk.openadsdk.g.t;
import com.bytedance.sdk.openadsdk.multipro.aidl.a;
import com.bytedance.sdk.openadsdk.multipro.b;
import java.io.File;
import java.io.IOException;

/* compiled from: TTFullScreenVideoAdImpl */
class s implements TTFullScreenVideoAd {
    private final Context a;
    private final g b;
    private final AdSlot c;
    private TTFullScreenVideoAd.FullScreenVideoAdInteractionListener d;
    private boolean e = true;
    private boolean f;
    private final TTAdNative.FullScreenVideoAdListener g;
    private String h;
    private long i = -1;

    s(Context context, g gVar, AdSlot adSlot, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        this.a = context;
        this.b = gVar;
        this.c = adSlot;
        this.g = fullScreenVideoAdListener;
    }

    private String a(String str, boolean z) {
        if (z) {
            return "full_screen_video_cache_" + str + "/";
        }
        return "/full_screen_video_cache_" + str + "/";
    }

    public void a() {
        d.a(this.b);
        String g2 = this.b.e().g();
        final String a2 = com.bytedance.sdk.openadsdk.g.g.a(g2);
        String codeId = this.c.getCodeId();
        l.e("wzj", "TTFullScreenVideoAdImpl - ritId:" + codeId);
        String a3 = a(String.valueOf(codeId), b.b());
        l.e("wzj", "TTFullScreenVideoAdImpl - cacheDirPath=" + a3);
        this.i = SystemClock.elapsedRealtime();
        final File a4 = a(this.a, a3, a2 == null ? "tt_full_screen_video_cache" : a2);
        com.bytedance.sdk.openadsdk.e.b.a(this.a).a(g2, new b.a() {
            /* class com.bytedance.sdk.openadsdk.core.s.AnonymousClass1 */

            @Override // com.bytedance.sdk.adnet.a.c.a
            public void a(long j, long j2) {
            }

            @Override // com.bytedance.sdk.adnet.a.b.a
            public File a(String str) {
                try {
                    File parentFile = a4.getParentFile();
                    if (parentFile == null || !parentFile.exists()) {
                        return null;
                    }
                    return g.b().o().a(a2, parentFile);
                } catch (IOException e) {
                    l.e("TTFullScreenVideoAdImpl", "datastoreGet throw IOException : " + e.toString());
                    return null;
                }
            }

            @Override // com.bytedance.sdk.adnet.a.b.a
            public void a(String str, File file) {
                if (file != null) {
                    s.this.a((s) file);
                }
            }

            @Override // com.bytedance.sdk.adnet.a.b.a
            public File b(String str) {
                return a4;
            }

            @Override // com.bytedance.sdk.adnet.core.m.a
            public void a(m<File> mVar) {
                if (!(mVar == null || mVar.a == null)) {
                    s.this.f = true;
                }
                if (s.this.g != null) {
                    s.this.g.onFullScreenVideoCached();
                }
                if (mVar == null || mVar.a == null) {
                    s.this.a((s) false, (boolean) (mVar == null ? -3 : mVar.f), (long) mVar);
                } else {
                    s.this.a((s) true, false, (long) mVar);
                }
            }

            @Override // com.bytedance.sdk.adnet.core.m.a
            public void b(m<File> mVar) {
                if (s.this.g != null) {
                    s.this.g.onFullScreenVideoCached();
                }
                s.this.a((s) false, (boolean) (mVar == null ? -2 : mVar.f), (long) mVar);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(boolean z, long j, m mVar) {
        if (this.b != null) {
            long j2 = 0;
            if (this.i >= 0) {
                j2 = SystemClock.elapsedRealtime() - this.i;
            }
            d.a(this.a, this.b, "fullscreen_interstitial_ad", z ? "load_video_success" : "load_video_error", t.a(z, this.b, j2, j, (z || mVar == null || mVar.c == null) ? null : mVar.c.getMessage()));
        }
    }

    private File a(Context context, String str, String str2) {
        return h.a(context, str, str2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(File file) {
        try {
            g.b().o().a(file);
        } catch (IOException e2) {
            l.e("TTFullScreenVideoAdImpl", "trimFileCache IOException:" + e2.toString());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setFullScreenVideoAdInteractionListener(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.d = fullScreenVideoAdInteractionListener;
        a(1);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getInteractionType() {
        g gVar = this.b;
        if (gVar == null) {
            return -1;
        }
        return gVar.g();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity) {
        if (!activity.isFinishing()) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                Intent intent = new Intent(activity, TTFullScreenVideoActivity.class);
                intent.putExtra("show_download_bar", this.e);
                intent.putExtra("orientation", this.c.getOrientation());
                if (!TextUtils.isEmpty(this.h)) {
                    intent.putExtra("rit_scene", this.h);
                }
                boolean z = this.f;
                if (z && z) {
                    g gVar = this.b;
                    if (gVar != null && gVar.e() != null) {
                        String a2 = com.bytedance.sdk.openadsdk.g.g.a(this.b.e().g());
                        intent.putExtra("video_cache_url", a(this.a, a(String.valueOf(String.valueOf(t.c(this.b.u()))), com.bytedance.sdk.openadsdk.multipro.b.b()), a2).toString());
                    } else {
                        return;
                    }
                }
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, this.b.C().toString());
                } else {
                    o.a().h();
                    o.a().a(this.b);
                    o.a().a(this.d);
                }
                activity.startActivity(intent);
                return;
            }
            throw new IllegalStateException("不能在子线程调用 TTFullScreenVideoAd.showFullScreenVideoAd");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        if (ritScenes == null) {
            l.e("TTFullScreenVideoAdImpl", "The param ritScenes can not be null!");
            return;
        }
        if (ritScenes == TTAdConstant.RitScenes.CUSTOMIZE_SCENES) {
            this.h = str;
        } else {
            this.h = ritScenes.getScenesName();
        }
        showFullScreenVideoAd(activity);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setShowDownLoadBar(boolean z) {
        this.e = z;
    }

    private void a(final int i2) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            new Thread(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.core.s.AnonymousClass2 */

                public void run() {
                    a a2 = a.a(s.this.a);
                    if (i2 == 1 && s.this.d != null) {
                        l.b("MultiProcess", "start registerFullScreenVideoListener ! ");
                        com.bytedance.sdk.openadsdk.multipro.aidl.b.a aVar = new com.bytedance.sdk.openadsdk.multipro.aidl.b.a(s.this.d);
                        IListenerManager asInterface = com.bytedance.sdk.openadsdk.multipro.aidl.a.d.asInterface(a2.a(1));
                        if (asInterface != null) {
                            try {
                                asInterface.registerFullVideoListener(aVar);
                                l.b("MultiProcess", "end registerFullScreenVideoListener ! ");
                            } catch (RemoteException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }).start();
        }
    }
}
