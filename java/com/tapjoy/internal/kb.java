package com.tapjoy.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import javax.annotation.Nullable;

public abstract class kb implements ke {
    private final a a = new a();
    private final kd b = new kd();

    @Override // java.util.concurrent.Future
    public Object get(long j, TimeUnit timeUnit) {
        a aVar = this.a;
        if (aVar.tryAcquireSharedNanos(-1, timeUnit.toNanos(j))) {
            return aVar.a();
        }
        throw new TimeoutException("Timeout waiting for task.");
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        a aVar = this.a;
        aVar.acquireSharedInterruptibly(-1);
        return aVar.a();
    }

    public boolean isDone() {
        return this.a.b();
    }

    public boolean isCancelled() {
        return this.a.c();
    }

    public boolean cancel(boolean z) {
        if (!this.a.a(null, null, 4)) {
            return false;
        }
        this.b.a();
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean a(@Nullable Object obj) {
        boolean a2 = this.a.a(obj, null, 2);
        if (a2) {
            this.b.a();
        }
        return a2;
    }

    /* access modifiers changed from: protected */
    public final boolean a(Throwable th) {
        boolean a2 = this.a.a(null, (Throwable) jp.a(th), 2);
        if (a2) {
            this.b.a();
        }
        if (!(th instanceof Error)) {
            return a2;
        }
        throw ((Error) th);
    }

    /* access modifiers changed from: package-private */
    public static final class a extends AbstractQueuedSynchronizer {
        private Object a;
        private Throwable b;

        a() {
        }

        /* access modifiers changed from: protected */
        public final int tryAcquireShared(int i) {
            return b() ? 1 : -1;
        }

        /* access modifiers changed from: protected */
        public final boolean tryReleaseShared(int i) {
            setState(i);
            return true;
        }

        /* access modifiers changed from: package-private */
        public final Object a() {
            int state = getState();
            if (state != 2) {
                if (state != 4) {
                    throw new IllegalStateException("Error, synchronizer in invalid state: " + state);
                }
                throw new CancellationException("Task was cancelled.");
            } else if (this.b == null) {
                return this.a;
            } else {
                throw new ExecutionException(this.b);
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean b() {
            return (getState() & 6) != 0;
        }

        /* access modifiers changed from: package-private */
        public final boolean c() {
            return getState() == 4;
        }

        /* access modifiers changed from: package-private */
        public final boolean a(@Nullable Object obj, @Nullable Throwable th, int i) {
            boolean compareAndSetState = compareAndSetState(0, 1);
            if (compareAndSetState) {
                this.a = obj;
                this.b = th;
                releaseShared(i);
            } else if (getState() == 1) {
                acquireShared(-1);
            }
            return compareAndSetState;
        }
    }
}
