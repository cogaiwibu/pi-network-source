package com.bytedance.sdk.adnet.core;

import android.os.Process;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.face.a;
import com.bytedance.sdk.adnet.face.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* access modifiers changed from: package-private */
/* compiled from: CacheDispatcher */
public class d extends Thread {
    private static final boolean a = n.a;
    private final BlockingQueue<Request<?>> b;
    private final BlockingQueue<Request<?>> c;
    private final com.bytedance.sdk.adnet.face.a d;
    private final c e;
    private volatile boolean f = false;
    private final a g;

    public d(BlockingQueue<Request<?>> blockingQueue, BlockingQueue<Request<?>> blockingQueue2, com.bytedance.sdk.adnet.face.a aVar, c cVar) {
        this.b = blockingQueue;
        this.c = blockingQueue2;
        this.d = aVar;
        this.e = cVar;
        this.g = new a(this);
    }

    public void a() {
        this.f = true;
        interrupt();
    }

    public void run() {
        if (a) {
            n.a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.d.a();
        while (true) {
            try {
                b();
            } catch (InterruptedException unused) {
                if (this.f) {
                    Thread.currentThread().interrupt();
                    return;
                }
                n.c("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    private void b() throws InterruptedException {
        a(this.b.take());
    }

    /* access modifiers changed from: package-private */
    public void a(final Request<?> request) throws InterruptedException {
        request.addMarker("cache-queue-take");
        request.a(1);
        try {
            if (request.isCanceled()) {
                request.a("cache-discard-canceled");
                request.a(2);
                return;
            }
            a.C0003a a2 = this.d.a(request.getCacheKey());
            if (a2 == null) {
                request.addMarker("cache-miss");
                if (!this.g.b(request)) {
                    this.c.put(request);
                }
                request.a(2);
            } else if (a2.a()) {
                request.addMarker("cache-hit-expired");
                request.setCacheEntry(a2);
                if (!this.g.b(request)) {
                    this.c.put(request);
                }
                request.a(2);
            } else {
                request.addMarker("cache-hit");
                m<?> a3 = request.a(new j(a2.b, a2.h));
                request.addMarker("cache-hit-parsed");
                if (!a2.b()) {
                    this.e.a(request, a3);
                } else {
                    request.addMarker("cache-hit-refresh-needed");
                    request.setCacheEntry(a2);
                    a3.d = true;
                    if (!this.g.b(request)) {
                        this.e.a(request, a3, new Runnable() {
                            /* class com.bytedance.sdk.adnet.core.d.AnonymousClass1 */

                            public void run() {
                                try {
                                    d.this.c.put(request);
                                } catch (InterruptedException unused) {
                                    Thread.currentThread().interrupt();
                                }
                            }
                        });
                    } else {
                        this.e.a(request, a3);
                    }
                }
                request.a(2);
            }
        } catch (Throwable th) {
            request.a(2);
            throw th;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: CacheDispatcher */
    public static class a implements Request.a {
        private final Map<String, List<Request<?>>> a = new HashMap();
        private final d b;

        a(d dVar) {
            this.b = dVar;
        }

        @Override // com.bytedance.sdk.adnet.core.Request.a
        public void a(Request<?> request, m<?> mVar) {
            List<Request<?>> remove;
            if (mVar.b == null || mVar.b.a()) {
                a(request);
                return;
            }
            String cacheKey = request.getCacheKey();
            synchronized (this) {
                remove = this.a.remove(cacheKey);
            }
            if (remove != null) {
                if (n.a) {
                    n.a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), cacheKey);
                }
                for (Request<?> request2 : remove) {
                    this.b.e.a(request2, mVar);
                }
            }
        }

        @Override // com.bytedance.sdk.adnet.core.Request.a
        public synchronized void a(Request<?> request) {
            String cacheKey = request.getCacheKey();
            List<Request<?>> remove = this.a.remove(cacheKey);
            if (remove != null && !remove.isEmpty()) {
                if (n.a) {
                    n.a("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), cacheKey);
                }
                Request<?> remove2 = remove.remove(0);
                this.a.put(cacheKey, remove);
                remove2.a(this);
                try {
                    this.b.c.put(remove2);
                } catch (InterruptedException e) {
                    n.c("Couldn't add request to queue. %s", e.toString());
                    Thread.currentThread().interrupt();
                    this.b.a();
                }
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private synchronized boolean b(Request<?> request) {
            String cacheKey = request.getCacheKey();
            if (this.a.containsKey(cacheKey)) {
                List<Request<?>> list = this.a.get(cacheKey);
                if (list == null) {
                    list = new ArrayList<>();
                }
                request.addMarker("waiting-for-response");
                list.add(request);
                this.a.put(cacheKey, list);
                if (n.a) {
                    n.b("Request for cacheKey=%s is in flight, putting on hold.", cacheKey);
                }
                return true;
            }
            this.a.put(cacheKey, null);
            request.a(this);
            if (n.a) {
                n.b("new request, sending to network %s", cacheKey);
            }
            return false;
        }
    }
}
