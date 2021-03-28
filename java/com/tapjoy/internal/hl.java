package com.tapjoy.internal;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import javax.annotation.Nullable;

public final class hl implements Flushable {
    final Object a = this;
    ax b;
    private final File c;

    public hl(File file) {
        this.c = file;
        try {
            this.b = au.a(new g(file, new bd() {
                /* class com.tapjoy.internal.hl.AnonymousClass1 */

                @Override // com.tapjoy.internal.bf
                public final /* bridge */ /* synthetic */ void a(OutputStream outputStream, Object obj) {
                    ev.c.a(outputStream, (ev) obj);
                }

                @Override // com.tapjoy.internal.be
                public final /* synthetic */ Object b(InputStream inputStream) {
                    return (ev) ev.c.a(inputStream);
                }
            }));
        } catch (Exception unused) {
            a();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.c.delete();
        ax axVar = this.b;
        if (axVar instanceof Closeable) {
            try {
                ((Closeable) axVar).close();
            } catch (Exception unused) {
            }
        }
        this.b = new av(new LinkedList());
    }

    @Override // java.io.Flushable
    public final void flush() {
        synchronized (this.a) {
            if (this.b instanceof Flushable) {
                try {
                    ((Flushable) this.b).flush();
                } catch (Exception unused) {
                    a();
                }
            }
        }
    }

    public final int b() {
        int size;
        synchronized (this.a) {
            try {
                size = this.b.size();
            } catch (Exception unused) {
                a();
                return 0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return size;
    }

    public final boolean c() {
        boolean isEmpty;
        synchronized (this.a) {
            try {
                isEmpty = this.b.isEmpty();
            } catch (Exception unused) {
                a();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
        return isEmpty;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x000b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.a
            monitor-enter(r0)
            com.tapjoy.internal.ax r1 = r2.b     // Catch:{ Exception -> 0x000b }
            r1.b(r3)     // Catch:{ Exception -> 0x000b }
            goto L_0x000e
        L_0x0009:
            r3 = move-exception
            goto L_0x0010
        L_0x000b:
            r2.a()     // Catch:{ all -> 0x0009 }
        L_0x000e:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            return
        L_0x0010:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.hl.a(int):void");
    }

    @Nullable
    public final ev b(int i) {
        ev evVar;
        synchronized (this.a) {
            try {
                evVar = (ev) this.b.a(i);
            } catch (Exception unused) {
                a();
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return evVar;
    }
}
