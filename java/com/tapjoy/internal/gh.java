package com.tapjoy.internal;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class gh extends gg {
    private final ThreadPoolExecutor b = new ThreadPoolExecutor(0, 1, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public gh(File file, gy gyVar) {
        super(file, gyVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.tapjoy.internal.gg
    public final void finalize() {
        try {
            this.b.shutdown();
            this.b.awaitTermination(1, TimeUnit.SECONDS);
        } finally {
            super.finalize();
        }
    }

    /* access modifiers changed from: package-private */
    public class a implements Runnable {
        private int b;
        private long c;
        private String d;
        private String e;
        private Map f;

        a(int i, long j, String str, String str2, Map map) {
            this.b = i;
            this.c = j;
            this.d = str;
            this.e = str2;
            this.f = map;
        }

        public final void run() {
            try {
                int i = this.b;
                if (i == 1) {
                    gh.super.a((gh) this.c);
                } else if (i == 2) {
                    gh.super.a();
                } else if (i == 3) {
                    gh.super.a(this.c, this.d, this.e, this.f);
                }
            } catch (Throwable unused) {
                gh.super.a();
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tapjoy.internal.gg, com.tapjoy.internal.gf
    public final void a(long j) {
        try {
            this.b.execute(new a(1, j, null, null, null));
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tapjoy.internal.gg, com.tapjoy.internal.gf
    public final void a() {
        try {
            this.b.execute(new a(2, 0, null, null, null));
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tapjoy.internal.gg, com.tapjoy.internal.gf
    public final void a(long j, String str, String str2, Map map) {
        try {
            this.b.execute(new a(3, j, str, str2, map != null ? new HashMap(map) : null));
        } catch (Throwable unused) {
        }
    }
}
