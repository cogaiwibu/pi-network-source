package com.bytedance.sdk.openadsdk.h;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.sdk.openadsdk.g.l;
import com.bytedance.sdk.openadsdk.h.a.b;
import com.bytedance.sdk.openadsdk.h.m;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* access modifiers changed from: package-private */
/* compiled from: HttpProxyCacheServerClients */
public final class g {
    private final AtomicInteger a = new AtomicInteger(0);
    private String b;
    private volatile e c;
    private final List<b> d = new CopyOnWriteArrayList();
    private final Map<String, m.a> e = new ConcurrentHashMap();
    private final Map<String, p> f = new ConcurrentHashMap();
    private final b g;
    private final c h;

    public g(String str, c cVar) {
        this.b = (String) l.a(str);
        l.e("HttpProxyCacheServerClients", "before substring url=" + str);
        if (str.contains("hasPrefix=false")) {
            this.b = str.substring(0, str.lastIndexOf("?size="));
        } else if (str.contains("hasPrefix=true")) {
            this.b = str.substring(0, str.lastIndexOf("&size="));
        }
        l.e("HttpProxyCacheServerClients", "after substring url=" + this.b);
        this.h = (c) l.a(cVar);
        this.g = new a(this.b, this.d);
    }

    public void a(d dVar, Socket socket) throws n, IOException {
        a(dVar.e);
        if (!dVar.e && this.c != null) {
            this.c.a(this.f.get(com.bytedance.sdk.openadsdk.g.g.a(this.b)));
        }
        try {
            this.a.incrementAndGet();
            this.c.a(dVar, socket);
        } finally {
            a();
            if (this.e.get(com.bytedance.sdk.openadsdk.g.g.a(this.b)) != null) {
                this.e.get(com.bytedance.sdk.openadsdk.g.g.a(this.b)).a(this.b, -1);
            }
        }
    }

    private synchronized void a(boolean z) throws n {
        this.c = this.c == null ? b(z) : this.c;
    }

    public synchronized void a() {
        if (this.a.decrementAndGet() <= 0) {
            l.d("HttpProxyCacheServerClients", "finishProcessRequest..........停止数据请求或传输，thread:" + Thread.currentThread().getId() + "," + Thread.currentThread().getName());
            if (this.c != null) {
                this.c.a();
                this.c = null;
            }
        }
    }

    public void a(b bVar) {
        this.d.add(bVar);
    }

    public void a(p pVar) {
        this.f.put(com.bytedance.sdk.openadsdk.g.g.a(this.b), pVar);
    }

    public void a(String str) {
        this.f.remove(com.bytedance.sdk.openadsdk.g.g.a(str));
        if (this.c != null) {
            this.c.a((p) null);
        }
    }

    public void b() {
        this.d.clear();
        if (this.c != null) {
            this.c.a((b) null);
            this.c.a();
            this.c = null;
        }
        this.a.set(0);
    }

    public int c() {
        return this.a.get();
    }

    private e b(boolean z) throws n {
        h hVar = new h(this.b, this.h.d, this.h.e);
        hVar.b = z;
        e eVar = new e(hVar, new b(this.h.a(this.b), this.h.c));
        if (z) {
            eVar.a(this.e.get(com.bytedance.sdk.openadsdk.g.g.a(this.b)));
        }
        eVar.a(this.g);
        return eVar;
    }

    /* compiled from: HttpProxyCacheServerClients */
    private static final class a extends Handler implements b {
        private final String a;
        private final List<b> b;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.a = str;
            this.b = list;
        }

        @Override // com.bytedance.sdk.openadsdk.h.b
        public void a(File file, String str, int i) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i;
            obtainMessage.obj = file;
            sendMessage(obtainMessage);
        }

        public void handleMessage(Message message) {
            for (b bVar : this.b) {
                bVar.a((File) message.obj, this.a, message.arg1);
            }
        }
    }
}
