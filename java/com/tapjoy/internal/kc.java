package com.tapjoy.internal;

import com.ironsource.sdk.constants.Constants;
import com.tapjoy.internal.kf;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;

public abstract class kc implements kf {
    private final ReentrantLock a = new ReentrantLock();
    private final a b = new a(this, (byte) 0);
    private final a c = new a(this, (byte) 0);
    private kf.a d = kf.a.NEW;
    private boolean e = false;

    /* access modifiers changed from: protected */
    public abstract void a();

    /* access modifiers changed from: protected */
    public abstract void b();

    @Override // com.tapjoy.internal.kf
    public final ke e() {
        this.a.lock();
        try {
            if (this.d == kf.a.NEW) {
                this.d = kf.a.STARTING;
                a();
            }
        } catch (Throwable th) {
            this.a.unlock();
            throw th;
        }
        this.a.unlock();
        return this.b;
    }

    private ke g() {
        this.a.lock();
        try {
            if (this.d == kf.a.NEW) {
                this.d = kf.a.TERMINATED;
                this.b.a(kf.a.TERMINATED);
                this.c.a(kf.a.TERMINATED);
            } else if (this.d == kf.a.STARTING) {
                this.e = true;
                this.b.a(kf.a.STOPPING);
            } else if (this.d == kf.a.RUNNING) {
                this.d = kf.a.STOPPING;
                b();
            }
        } catch (Throwable th) {
            this.a.unlock();
            throw th;
        }
        this.a.unlock();
        return this.c;
    }

    /* access modifiers changed from: protected */
    public final void c() {
        this.a.lock();
        try {
            if (this.d == kf.a.STARTING) {
                this.d = kf.a.RUNNING;
                if (this.e) {
                    g();
                } else {
                    this.b.a(kf.a.RUNNING);
                }
                return;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Cannot notifyStarted() when the service is " + this.d);
            a(illegalStateException);
            throw illegalStateException;
        } finally {
            this.a.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public final void d() {
        this.a.lock();
        try {
            if (this.d != kf.a.STOPPING) {
                if (this.d != kf.a.RUNNING) {
                    IllegalStateException illegalStateException = new IllegalStateException("Cannot notifyStopped() when the service is " + this.d);
                    a(illegalStateException);
                    throw illegalStateException;
                }
            }
            this.d = kf.a.TERMINATED;
            this.c.a(kf.a.TERMINATED);
        } finally {
            this.a.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public final void a(Throwable th) {
        jp.a(th);
        this.a.lock();
        try {
            if (this.d == kf.a.STARTING) {
                this.b.a(th);
                this.c.a((Throwable) new Exception("Service failed to start.", th));
            } else if (this.d == kf.a.STOPPING) {
                this.c.a(th);
            } else if (this.d == kf.a.RUNNING) {
                this.c.a((Throwable) new Exception("Service failed while running", th));
            } else if (this.d == kf.a.NEW || this.d == kf.a.TERMINATED) {
                throw new IllegalStateException("Failed while in state:" + this.d, th);
            }
            this.d = kf.a.FAILED;
        } finally {
            this.a.unlock();
        }
    }

    @Override // com.tapjoy.internal.kf
    public final kf.a f() {
        kf.a aVar;
        this.a.lock();
        try {
            if (!this.e || this.d != kf.a.STARTING) {
                aVar = this.d;
            } else {
                aVar = kf.a.STOPPING;
            }
            return aVar;
        } finally {
            this.a.unlock();
        }
    }

    public String toString() {
        return getClass().getSimpleName() + " [" + f() + Constants.RequestParameters.RIGHT_BRACKETS;
    }

    /* access modifiers changed from: package-private */
    public class a extends kb {
        private a() {
        }

        /* synthetic */ a(kc kcVar, byte b) {
            this();
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public kf.a get(long j, TimeUnit timeUnit) {
            try {
                return (kf.a) super.get(j, timeUnit);
            } catch (TimeoutException unused) {
                throw new TimeoutException(kc.this.toString());
            }
        }
    }
}
