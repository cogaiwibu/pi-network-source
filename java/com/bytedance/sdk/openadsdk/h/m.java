package com.bytedance.sdk.openadsdk.h;

import com.bytedance.sdk.openadsdk.g.l;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ProxyCache */
public class m {
    p a;
    private final q b;
    private final a c;
    private final Object d = new Object();
    private final Object e = new Object();
    private final AtomicInteger f;
    private volatile Thread g;
    private volatile boolean h;
    private volatile int i = -1;
    private a j;

    /* compiled from: ProxyCache */
    public interface a {
        void a(String str, long j);
    }

    /* access modifiers changed from: protected */
    public void a(int i2) {
    }

    public m(q qVar, a aVar) {
        this.b = (q) l.a(qVar);
        this.c = (a) l.a(aVar);
        this.f = new AtomicInteger();
    }

    public int a(byte[] bArr, long j2, int i2) throws n {
        o.a(bArr, j2, i2);
        while (!this.c.d() && this.c.a() < ((long) i2) + j2 && !this.h) {
            if (this.c.a() > ((long) this.b.c()) && this.b.d()) {
                return -1;
            }
            c();
            d();
            b();
        }
        int a2 = this.c.a(bArr, j2, i2);
        if (this.c.d() && this.i != 100) {
            this.i = 100;
            a(100);
        }
        return a2;
    }

    private void b() throws n {
        int i2 = this.f.get();
        if (i2 >= 1) {
            this.f.set(0);
            throw new n("Error reading source " + i2 + " times");
        }
    }

    public void a() {
        synchronized (this.e) {
            l.b("ProxyCache", "Shutdown proxy for " + this.b);
            try {
                this.h = true;
                if (this.g != null) {
                    this.g.interrupt();
                }
                this.c.b();
                this.j = null;
                this.a = null;
            } catch (n e2) {
                if (l.c()) {
                    e2.printStackTrace();
                }
                a(e2);
            }
        }
    }

    private synchronized void c() throws n {
        boolean z = (this.g == null || this.g.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.h && !this.c.d() && !z) {
            b bVar = new b();
            this.g = new Thread(bVar, "Source reader for " + this.b);
            this.g.start();
        }
    }

    private void d() throws n {
        synchronized (this.d) {
            try {
                this.d.wait(1000);
            } catch (InterruptedException e2) {
                if (l.c()) {
                    e2.printStackTrace();
                }
                throw new n("Waiting source data is interrupted!", e2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void b(long j2, long j3) {
        a(j2, j3);
        synchronized (this.d) {
            this.d.notifyAll();
        }
    }

    /* access modifiers changed from: protected */
    public void a(long j2, long j3) {
        boolean z = true;
        int i2 = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1)) == 0 ? 100 : (int) ((((float) j2) / ((float) j3)) * 100.0f);
        boolean z2 = i2 != this.i;
        if (j3 < 0) {
            z = false;
        }
        if (z && z2) {
            a(i2);
        }
        this.i = i2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void e() {
        long j2 = -1;
        long j3 = 0;
        try {
            j3 = this.c.a();
            this.b.a(j3);
            j2 = this.b.a();
            byte[] bArr = new byte[8192];
            while (true) {
                int a2 = this.b.a(bArr);
                if (a2 != -1) {
                    synchronized (this.e) {
                        if (h()) {
                            i();
                            b(j3, j2);
                            return;
                        }
                        this.c.a(bArr, a2);
                        l.b("ProxyCache", "cache.available()=" + this.c.a() + ",preloadSize=" + this.b.c() + ",isPreload=" + this.b.d());
                        if (this.c.a() > ((long) this.b.c()) && this.b.d()) {
                            if (this.j != null) {
                                l.e("ProxyCache", "preLoadCompleteListener 被回调了....");
                                this.j.a(this.b.f(), this.c.a());
                            }
                            this.h = true;
                        }
                    }
                } else if (!this.b.d()) {
                    g();
                    f();
                }
                j3 += (long) a2;
                b(j3, j2);
            }
        } catch (Throwable unused) {
        }
        i();
        b(j3, j2);
    }

    private void f() {
        this.i = 100;
        a(this.i);
    }

    private void g() throws n {
        synchronized (this.e) {
            if (!h() && this.c.a() == this.b.a()) {
                this.c.c();
            }
        }
    }

    private boolean h() {
        return Thread.currentThread().isInterrupted() || this.h;
    }

    private void i() {
        try {
            this.b.b();
        } catch (n e2) {
            if (l.c()) {
                e2.printStackTrace();
            }
            a(new n("Error closing source " + this.b, e2));
        }
    }

    /* access modifiers changed from: protected */
    public final void a(Throwable th) {
        if (th instanceof j) {
            l.b("ProxyCache", "ProxyCache is interrupted");
        } else {
            l.b("ProxyCache", "ProxyCache error", th);
        }
    }

    public void a(p pVar) {
        l.e("ProxyCache", "setRetryPlayerListener 设置回调监听");
        this.a = pVar;
    }

    /* access modifiers changed from: private */
    /* compiled from: ProxyCache */
    public class b implements Runnable {
        public b() {
        }

        public void run() {
            m.this.e();
        }
    }

    public void a(a aVar) {
        l.e("ProxyCache", "proxyCache---setPreLoadCompleteListener--++isPreloadRequest=" + this.b.d());
        if (this.b.d()) {
            this.j = aVar;
        }
    }
}
