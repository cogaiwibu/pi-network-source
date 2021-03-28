package com.bytedance.sdk.openadsdk.f;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.a.i;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.openadsdk.g.j;
import com.bytedance.sdk.openadsdk.g.l;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: TrackAdUrlImpl */
public class b implements a {
    private final Context a;
    private final f b;
    private final ExecutorService c = Executors.newSingleThreadExecutor();

    public b(Context context, f fVar) {
        this.a = context;
        this.b = fVar;
    }

    @Override // com.bytedance.sdk.openadsdk.f.a
    public void a(List<String> list) {
        if (j.b(list)) {
            for (String str : list) {
                new a(new e(UUID.randomUUID().toString() + "_" + System.currentTimeMillis(), str, 5)).executeOnExecutor(this.c, new Void[0]);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.f.a
    public void a() {
        this.c.submit(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.f.b.AnonymousClass1 */

            public void run() {
                final List<e> a2 = b.this.b.a();
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.bytedance.sdk.openadsdk.f.b.AnonymousClass1.AnonymousClass1 */

                    public void run() {
                        b.this.b((b) a2);
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b(List<e> list) {
        if (j.b(list)) {
            for (e eVar : list) {
                new a(eVar).executeOnExecutor(this.c, new Void[0]);
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: TrackAdUrlImpl */
    public class a extends AsyncTask<Void, Void, Void> {
        private final e b;

        private a(e eVar) {
            this.b = eVar;
        }

        /* access modifiers changed from: package-private */
        public boolean a(String str) {
            return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            m mVar;
            if (!a(this.b.b())) {
                return null;
            }
            if (this.b.c() == 0) {
                b.this.b.c(this.b);
                return null;
            }
            while (true) {
                if (this.b.c() <= 0 || isCancelled()) {
                    break;
                }
                if (this.b.c() == 5) {
                    b.this.b.a(this.b);
                }
                if (!com.bytedance.sdk.openadsdk.g.m.a(b.this.a)) {
                    break;
                }
                String b2 = this.b.b();
                i a2 = i.a();
                new com.bytedance.sdk.adnet.a.j(0, b2, a2).setRetryPolicy(com.bytedance.sdk.openadsdk.e.b.b().a(10000)).build(com.bytedance.sdk.openadsdk.e.b.a(b.this.a).c());
                try {
                    mVar = a2.get();
                } catch (Throwable unused) {
                    mVar = null;
                }
                if (mVar == null || !mVar.a()) {
                    if (l.c()) {
                        l.c("trackurl", "track fail : " + this.b.b());
                    }
                    e eVar = this.b;
                    eVar.a(eVar.c() - 1);
                    if (this.b.c() == 0) {
                        b.this.b.c(this.b);
                        if (l.c()) {
                            l.c("trackurl", "track fail and delete : " + this.b.b());
                        }
                    } else {
                        b.this.b.b(this.b);
                    }
                } else {
                    b.this.b.c(this.b);
                    if (l.c()) {
                        l.c("trackurl", "track success : " + this.b.b());
                    }
                }
            }
            return null;
        }
    }
}
