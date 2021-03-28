package com.tapjoy.internal;

/* access modifiers changed from: package-private */
public final class iw implements is {
    public final ir a = new ir();
    public final jb b;
    boolean c;

    iw(jb jbVar) {
        if (jbVar != null) {
            this.b = jbVar;
            return;
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // com.tapjoy.internal.jb
    public final void a(ir irVar, long j) {
        if (!this.c) {
            this.a.a(irVar, j);
            b();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.tapjoy.internal.is
    public final is b(iu iuVar) {
        if (!this.c) {
            this.a.b(iuVar);
            return b();
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.tapjoy.internal.is
    public final is b(String str) {
        if (!this.c) {
            this.a.b(str);
            return b();
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.tapjoy.internal.is
    public final is e(int i) {
        if (!this.c) {
            this.a.e(i);
            return b();
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.tapjoy.internal.is
    public final is d(int i) {
        if (!this.c) {
            this.a.d(i);
            return b();
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.tapjoy.internal.is
    public final is f(long j) {
        if (!this.c) {
            this.a.f(j);
            return b();
        }
        throw new IllegalStateException("closed");
    }

    private is b() {
        if (!this.c) {
            ir irVar = this.a;
            long j = irVar.b;
            if (j == 0) {
                j = 0;
            } else {
                iy iyVar = irVar.a.g;
                if (iyVar.c < 8192 && iyVar.e) {
                    j -= (long) (iyVar.c - iyVar.b);
                }
            }
            if (j > 0) {
                this.b.a(this.a, j);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.tapjoy.internal.is
    public final is a() {
        if (!this.c) {
            long j = this.a.b;
            if (j > 0) {
                this.b.a(this.a, j);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.tapjoy.internal.jb, java.io.Flushable
    public final void flush() {
        if (!this.c) {
            if (this.a.b > 0) {
                jb jbVar = this.b;
                ir irVar = this.a;
                jbVar.a(irVar, irVar.b);
            }
            this.b.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.tapjoy.internal.jb, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (!this.c) {
            Throwable th = null;
            try {
                if (this.a.b > 0) {
                    this.b.a(this.a, this.a.b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.c = true;
            if (th != null) {
                je.a(th);
            }
        }
    }

    public final String toString() {
        return "buffer(" + this.b + ")";
    }
}
