package com.bytedance.sdk.adnet.core;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.adnet.face.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: RequestQueue */
public class l {
    private final AtomicInteger a;
    private final Set<Request<?>> b;
    private final PriorityBlockingQueue<Request<?>> c;
    private final PriorityBlockingQueue<Request<?>> d;
    private final com.bytedance.sdk.adnet.face.a e;
    private final com.bytedance.sdk.adnet.face.b f;
    private final c g;
    private final i[] h;
    private d i;
    private final List<b> j;
    private final List<a> k;

    /* compiled from: RequestQueue */
    public interface a {
        void a(Request<?> request, int i);
    }

    @Deprecated
    /* compiled from: RequestQueue */
    public interface b<T> {
        void a(Request<T> request);
    }

    public l(com.bytedance.sdk.adnet.face.a aVar, com.bytedance.sdk.adnet.face.b bVar, int i2, c cVar) {
        this.a = new AtomicInteger();
        this.b = new HashSet();
        this.c = new PriorityBlockingQueue<>();
        this.d = new PriorityBlockingQueue<>();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.e = aVar;
        this.f = bVar;
        this.h = new i[i2];
        this.g = cVar;
    }

    public l(com.bytedance.sdk.adnet.face.a aVar, com.bytedance.sdk.adnet.face.b bVar, int i2) {
        this(aVar, bVar, i2, new g(new Handler(Looper.getMainLooper())));
    }

    public l(com.bytedance.sdk.adnet.face.a aVar, com.bytedance.sdk.adnet.face.b bVar) {
        this(aVar, bVar, 4);
    }

    public void a() {
        b();
        d dVar = new d(this.c, this.d, this.e, this.g);
        this.i = dVar;
        dVar.start();
        for (int i2 = 0; i2 < this.h.length; i2++) {
            i iVar = new i(this.d, this.f, this.e, this.g);
            this.h[i2] = iVar;
            iVar.start();
        }
    }

    public void b() {
        d dVar = this.i;
        if (dVar != null) {
            dVar.a();
        }
        i[] iVarArr = this.h;
        for (i iVar : iVarArr) {
            if (iVar != null) {
                iVar.a();
            }
        }
    }

    public int c() {
        return this.a.incrementAndGet();
    }

    public c d() {
        return this.g;
    }

    public <T> Request<T> a(Request<T> request) {
        request.setStartTime();
        request.setRequestQueue(this);
        synchronized (this.b) {
            this.b.add(request);
        }
        request.setSequence(c());
        request.addMarker("add-to-queue");
        a(request, 0);
        if (!request.shouldCache()) {
            this.d.add(request);
            return request;
        }
        this.c.add(request);
        return request;
    }

    /* access modifiers changed from: package-private */
    public <T> void b(Request<T> request) {
        synchronized (this.b) {
            this.b.remove(request);
        }
        synchronized (this.j) {
            for (b bVar : this.j) {
                bVar.a(request);
            }
        }
        a(request, 5);
    }

    /* access modifiers changed from: package-private */
    public void a(Request<?> request, int i2) {
        synchronized (this.k) {
            for (a aVar : this.k) {
                aVar.a(request, i2);
            }
        }
    }
}
