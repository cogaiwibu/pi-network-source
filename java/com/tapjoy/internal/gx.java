package com.tapjoy.internal;

import java.io.File;

public final class gx implements Runnable {
    final hl a;
    cd b;
    private final Object c;
    private final Thread d;
    private boolean e;

    public gx(File file) {
        hl hlVar = new hl(file);
        this.a = hlVar;
        this.c = hlVar;
        Integer.valueOf(hlVar.b());
        Thread thread = new Thread(this, "5Rocks");
        this.d = thread;
        thread.start();
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:50:0x00dc */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        // Method dump skipped, instructions count: 292
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.gx.run():void");
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z) {
        synchronized (this.c) {
            this.e = z;
            this.c.notify();
        }
    }

    public final void a() {
        if (this.b != null && !this.a.c()) {
            a(true);
        }
    }
}
