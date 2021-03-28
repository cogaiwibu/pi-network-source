package com.bytedance.sdk.openadsdk.b;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.c.g;
import com.bytedance.sdk.openadsdk.g.l;
import com.bytedance.sdk.openadsdk.g.t;
import com.ironsource.sdk.precache.DownloadManager;
import java.io.Serializable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: OpenAppSuccEvent */
public class j {
    private static volatile j a;
    private HandlerThread b;
    private final Handler c;
    private final Executor d = Executors.newCachedThreadPool();
    private b e = b.a();

    public static j a() {
        if (a == null) {
            synchronized (j.class) {
                if (a == null) {
                    a = new j();
                }
            }
        }
        return a;
    }

    private j() {
        if (this.b == null) {
            HandlerThread handlerThread = new HandlerThread("OpenAppSuccEvent_HandlerThread", 10);
            this.b = handlerThread;
            handlerThread.start();
        }
        this.c = new Handler(this.b.getLooper(), new Handler.Callback() {
            /* class com.bytedance.sdk.openadsdk.b.j.AnonymousClass1 */

            public boolean handleMessage(Message message) {
                if (message.what != 100) {
                    return true;
                }
                a aVar = null;
                if (message.obj != null && (message.obj instanceof a)) {
                    aVar = (a) message.obj;
                }
                if (aVar == null) {
                    return true;
                }
                j.this.b(aVar);
                return true;
            }
        });
    }

    public void a(g gVar, String str) {
        Message obtainMessage = this.c.obtainMessage();
        obtainMessage.what = 100;
        obtainMessage.obj = a.a(gVar, str);
        obtainMessage.sendToTarget();
    }

    private void a(a aVar) {
        if (aVar != null) {
            aVar.b();
            if (aVar.a() * this.e.a > this.e.b) {
                c(aVar.a(false));
                return;
            }
            Message obtainMessage = this.c.obtainMessage();
            obtainMessage.what = 100;
            obtainMessage.obj = aVar;
            this.c.sendMessageDelayed(obtainMessage, (long) this.e.a);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b(a aVar) {
        if (aVar != null) {
            Context a2 = com.bytedance.sdk.openadsdk.core.j.a();
            if (t.c(a2, a2.getPackageName())) {
                a(aVar);
            } else {
                c(aVar.a(true));
            }
        }
    }

    private void c(a aVar) {
        if (aVar != null) {
            this.d.execute(aVar);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: OpenAppSuccEvent */
    public static class a implements Serializable, Runnable {
        public final AtomicInteger a = new AtomicInteger(0);
        public final AtomicBoolean b = new AtomicBoolean(false);
        public g c;
        public String d;

        public static a a(g gVar, String str) {
            return new a(gVar, str);
        }

        public a() {
        }

        public a(g gVar, String str) {
            this.c = gVar;
            this.d = str;
        }

        public a a(boolean z) {
            this.b.set(z);
            return this;
        }

        public int a() {
            return this.a.get();
        }

        public void b() {
            this.a.incrementAndGet();
        }

        public void run() {
            if (this.c == null || TextUtils.isEmpty(this.d)) {
                l.a("materialMeta or eventTag is null, pls check");
            } else {
                d.b(com.bytedance.sdk.openadsdk.core.j.a(), this.c, this.d, this.b.get() ? "dpl_success" : "dpl_failed");
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: OpenAppSuccEvent */
    public static class b {
        public int a = 500;
        public int b = DownloadManager.OPERATION_TIMEOUT;

        public static b a() {
            return new b();
        }
    }
}
