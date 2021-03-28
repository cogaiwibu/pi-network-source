package com.bytedance.sdk.adnet.a;

import android.os.SystemClock;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.m;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: RequestFuture */
public class i<T> implements m.a<T>, Future<m<T>> {
    private Request<?> a;
    private boolean b = false;
    private m<T> c;

    public static <E> i<E> a() {
        return new i<>();
    }

    private i() {
    }

    public synchronized boolean cancel(boolean z) {
        if (this.a == null) {
            return false;
        }
        if (isDone()) {
            return false;
        }
        this.a.cancel();
        return true;
    }

    /* renamed from: b */
    public m<T> get() throws InterruptedException {
        try {
            return a((Long) null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: a */
    public m<T> get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        return a(Long.valueOf(TimeUnit.MILLISECONDS.convert(j, timeUnit)));
    }

    private synchronized m<T> a(Long l) throws InterruptedException, TimeoutException {
        if (this.b) {
            return this.c;
        }
        if (l == null) {
            while (!isDone()) {
                wait(0);
            }
        } else if (l.longValue() > 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            long longValue = l.longValue() + uptimeMillis;
            while (!isDone() && uptimeMillis < longValue) {
                wait(longValue - uptimeMillis);
                uptimeMillis = SystemClock.uptimeMillis();
            }
        }
        if (this.b) {
            return this.c;
        }
        throw new TimeoutException();
    }

    public boolean isCancelled() {
        Request<?> request = this.a;
        if (request == null) {
            return false;
        }
        return request.isCanceled();
    }

    public synchronized boolean isDone() {
        return this.b || isCancelled();
    }

    @Override // com.bytedance.sdk.adnet.core.m.a
    public synchronized void a(m<T> mVar) {
        this.b = true;
        this.c = mVar;
        notifyAll();
    }

    @Override // com.bytedance.sdk.adnet.core.m.a
    public synchronized void b(m<T> mVar) {
        this.b = true;
        this.c = mVar;
        notifyAll();
    }
}
