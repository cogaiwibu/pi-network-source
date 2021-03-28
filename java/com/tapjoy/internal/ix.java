package com.tapjoy.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;

/* access modifiers changed from: package-private */
public final class ix implements it {
    public final ir a = new ir();
    public final jc b;
    boolean c;

    ix(jc jcVar) {
        if (jcVar != null) {
            this.b = jcVar;
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.tapjoy.internal.jc
    public final long b(ir irVar, long j) {
        if (irVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.c) {
            throw new IllegalStateException("closed");
        } else if (this.a.b == 0 && this.b.b(this.a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        } else {
            return this.a.b(irVar, Math.min(j, this.a.b));
        }
    }

    @Override // com.tapjoy.internal.it
    public final boolean b() {
        if (!this.c) {
            return this.a.b() && this.b.b(this.a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1;
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.tapjoy.internal.it
    public final byte c() {
        a(1);
        return this.a.c();
    }

    @Override // com.tapjoy.internal.it
    public final iu b(long j) {
        a(j);
        return this.a.b(j);
    }

    @Override // com.tapjoy.internal.it
    public final String c(long j) {
        a(j);
        return this.a.c(j);
    }

    @Override // com.tapjoy.internal.it
    public final int e() {
        a(4);
        return je.a(this.a.d());
    }

    @Override // com.tapjoy.internal.it
    public final long f() {
        a(8);
        return this.a.f();
    }

    @Override // com.tapjoy.internal.it
    public final void d(long j) {
        if (!this.c) {
            while (j > 0) {
                if (this.a.b == 0 && this.b.b(this.a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j, this.a.b);
                this.a.d(min);
                j -= min;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.tapjoy.internal.jc, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (!this.c) {
            this.c = true;
            this.b.close();
            ir irVar = this.a;
            try {
                irVar.d(irVar.b);
            } catch (EOFException e) {
                throw new AssertionError(e);
            }
        }
    }

    public final String toString() {
        return "buffer(" + this.b + ")";
    }

    @Override // com.tapjoy.internal.it
    public final void a(long j) {
        boolean z;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (!this.c) {
            while (true) {
                if (this.a.b < j) {
                    if (this.b.b(this.a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                        z = false;
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
            if (!z) {
                throw new EOFException();
            }
        } else {
            throw new IllegalStateException("closed");
        }
    }
}
