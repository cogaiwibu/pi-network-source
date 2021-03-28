package com.tapjoy.internal;

import com.tapjoy.internal.dy;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class dz implements dy.a {
    private final BlockingQueue a = new LinkedBlockingQueue();
    private final ThreadPoolExecutor b = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.a);
    private final ArrayDeque c = new ArrayDeque();
    private dy d = null;

    @Override // com.tapjoy.internal.dy.a
    public final void a() {
        this.d = null;
        b();
    }

    public final void a(dy dyVar) {
        dyVar.d = this;
        this.c.add(dyVar);
        if (this.d == null) {
            b();
        }
    }

    private void b() {
        dy dyVar = (dy) this.c.poll();
        this.d = dyVar;
        if (dyVar != null) {
            dyVar.executeOnExecutor(this.b, new Object[0]);
        }
    }
}
