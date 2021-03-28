package com.bytedance.sdk.openadsdk.core.video.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.a.b;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.b.d;
import com.bytedance.sdk.openadsdk.core.c.g;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.g.h;
import com.bytedance.sdk.openadsdk.g.l;
import com.bytedance.sdk.openadsdk.g.s;
import com.bytedance.sdk.openadsdk.g.t;
import com.facebook.appevents.AppEventsConstants;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: RewardVideoCache */
public class c {
    private static volatile c a;
    private Context b;
    private b c = new b();
    private Map<g, Long> d = Collections.synchronizedMap(new HashMap());

    /* access modifiers changed from: package-private */
    /* compiled from: RewardVideoCache */
    public interface a<T> {
        void a(boolean z, T t);
    }

    public void a(String str) {
        this.c.d(str);
    }

    public void a(AdSlot adSlot, g gVar) {
        a(adSlot);
        if (gVar != null) {
            try {
                this.c.a(adSlot.getCodeId(), gVar.C().toString());
            } catch (Exception unused) {
            }
        }
    }

    public AdSlot b(String str) {
        return this.c.e(str);
    }

    public void a(AdSlot adSlot) {
        this.c.a(adSlot);
    }

    public static c a(Context context) {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c(context);
                }
            }
        }
        return a;
    }

    private c(Context context) {
        this.b = context == null ? j.a() : context.getApplicationContext();
    }

    public String a(g gVar) {
        if (gVar == null || gVar.e() == null || TextUtils.isEmpty(gVar.e().g())) {
            return null;
        }
        return a(gVar.e().g(), String.valueOf(t.c(gVar.u())));
    }

    public String a(String str, String str2) {
        File a2;
        if (!TextUtils.isEmpty(str) && (a2 = a(this.b, a(String.valueOf(str2), com.bytedance.sdk.openadsdk.multipro.b.b()), com.bytedance.sdk.openadsdk.g.g.a(str))) != null && a2.exists() && a2.isFile()) {
            return a2.getAbsolutePath();
        }
        return null;
    }

    private String a(String str, boolean z) {
        if (z) {
            return "reward_video_cache_" + str + "/";
        }
        return "/reward_video_cache_" + str + "/";
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(boolean z, g gVar, long j, m mVar) {
        long j2;
        Long remove = this.d.remove(gVar);
        if (remove == null) {
            j2 = 0;
        } else {
            j2 = SystemClock.elapsedRealtime() - remove.longValue();
        }
        d.a(this.b, gVar, "rewarded_video", z ? "load_video_success" : "load_video_error", t.a(z, gVar, j2, j, (z || mVar == null || mVar.c == null) ? null : mVar.c.getMessage()));
    }

    public g c(String str) {
        g b2;
        long b3 = this.c.b(str);
        boolean c2 = this.c.c(str);
        if (!(System.currentTimeMillis() - b3 < 10800000) || c2) {
            return null;
        }
        try {
            String a2 = this.c.a(str);
            if (TextUtils.isEmpty(a2) || (b2 = com.bytedance.sdk.openadsdk.core.c.b(new JSONObject(a2))) == null || b2.e() == null || TextUtils.isEmpty(a(b2.e().g(), str))) {
                return null;
            }
            return b2;
        } catch (Exception unused) {
            return null;
        }
    }

    public void a(final g gVar, final a<Object> aVar) {
        this.d.put(gVar, Long.valueOf(SystemClock.elapsedRealtime()));
        if (gVar == null || gVar.e() == null || TextUtils.isEmpty(gVar.e().g())) {
            if (aVar != null) {
                aVar.a(false, null);
            }
            a(false, gVar, -1, null);
            return;
        }
        String g = gVar.e().g();
        final String a2 = com.bytedance.sdk.openadsdk.g.g.a(g);
        int c2 = t.c(gVar.u());
        l.e("wzj", "ritId:" + c2);
        String a3 = a(String.valueOf(c2), com.bytedance.sdk.openadsdk.multipro.b.b());
        l.e("wzj", "cacheDirPath=" + a3);
        final File a4 = a(this.b, a3, a2);
        com.bytedance.sdk.openadsdk.e.b.a(this.b).a(g, new b.a() {
            /* class com.bytedance.sdk.openadsdk.core.video.b.c.AnonymousClass1 */

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
                    return com.bytedance.sdk.openadsdk.core.g.b().o().a(a2, parentFile);
                } catch (IOException e2) {
                    l.e("RewardVideoCache", "datastoreGet throw IOException : " + e2.toString());
                    return null;
                }
            }

            @Override // com.bytedance.sdk.adnet.a.b.a
            public void a(String str, File file) {
                if (file != null) {
                    c.this.a((c) file);
                }
            }

            @Override // com.bytedance.sdk.adnet.a.b.a
            public File b(String str) {
                return a4;
            }

            @Override // com.bytedance.sdk.adnet.core.m.a
            public void a(m<File> mVar) {
                if (mVar == null || mVar.a == null) {
                    a aVar = aVar;
                    if (aVar != null) {
                        aVar.a(false, null);
                    }
                    c.this.a(false, gVar, mVar == null ? -3 : mVar.f, mVar);
                    return;
                }
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(true, null);
                }
                c.this.a(true, gVar, 0, mVar);
            }

            @Override // com.bytedance.sdk.adnet.core.m.a
            public void b(m<File> mVar) {
                a aVar = aVar;
                if (aVar != null) {
                    aVar.a(false, null);
                }
                c.this.a(false, gVar, mVar == null ? -2 : mVar.f, mVar);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(File file) {
        try {
            com.bytedance.sdk.openadsdk.core.g.b().o().a(file);
        } catch (IOException e) {
            l.e("RewardVideoCache", "trimFileCache IOException:" + e.toString());
        }
    }

    private File a(Context context, String str, String str2) {
        return h.a(context, str, str2);
    }

    /* access modifiers changed from: private */
    /* compiled from: RewardVideoCache */
    public class b {
        private b() {
        }

        private SharedPreferences f(String str) {
            return c.this.b.getSharedPreferences(g(str), 0);
        }

        private String g(String str) {
            if (TextUtils.isEmpty(str)) {
                str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            return "sp_reward_video_cache__" + str;
        }

        /* access modifiers changed from: package-private */
        public String a(String str) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                return com.bytedance.sdk.openadsdk.multipro.d.a.b(g(str), "material_data", null);
            }
            return f(str).getString("material_data", null);
        }

        /* access modifiers changed from: package-private */
        public long b(String str) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                return com.bytedance.sdk.openadsdk.multipro.d.a.a(g(str), "create_time", 0L);
            }
            return f(str).getLong("create_time", 0);
        }

        /* access modifiers changed from: package-private */
        public boolean c(String str) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                return com.bytedance.sdk.openadsdk.multipro.d.a.a(g(str), "has_played", true);
            }
            return f(str).getBoolean("has_played", true);
        }

        /* access modifiers changed from: package-private */
        public void a(String str, String str2) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a(g(str), "has_played", (Boolean) false);
                com.bytedance.sdk.openadsdk.multipro.d.a.a(g(str), "create_time", Long.valueOf(System.currentTimeMillis()));
                com.bytedance.sdk.openadsdk.multipro.d.a.a(g(str), "material_data", str2);
                return;
            }
            f(str).edit().putBoolean("has_played", false).putLong("create_time", System.currentTimeMillis()).putString("material_data", str2).apply();
        }

        /* access modifiers changed from: package-private */
        public void d(String str) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a(g(str));
            } else {
                f(str).edit().clear().apply();
            }
        }

        /* access modifiers changed from: package-private */
        public AdSlot e(String str) {
            String str2;
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                str2 = com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_reward_video_adslot", str, null);
            } else {
                str2 = c.this.b.getSharedPreferences("sp_reward_video_adslot", 0).getString(str, null);
            }
            return s.a(str2);
        }

        /* access modifiers changed from: package-private */
        public void a(AdSlot adSlot) {
            if (adSlot != null && !TextUtils.isEmpty(adSlot.getCodeId())) {
                String a2 = s.a(adSlot);
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_reward_video_adslot", adSlot.getCodeId(), a2);
                } else {
                    c.this.b.getSharedPreferences("sp_reward_video_adslot", 0).edit().putString(adSlot.getCodeId(), a2).apply();
                }
            }
        }
    }
}
