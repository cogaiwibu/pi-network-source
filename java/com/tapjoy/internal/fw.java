package com.tapjoy.internal;

import com.tapjoy.internal.gf;

public final class fw {
    public fq a;
    public volatile gf.a b;
    public int c;
    public volatile gf.a d;
    public volatile gf.a e;

    public final void a() {
        a(16);
        gf.a aVar = this.d;
        if (aVar != null) {
            this.d = null;
            aVar.b().c();
        }
    }

    public final synchronized void a(int i) {
        gf.a aVar = this.b;
        if (aVar != null && this.c < i) {
            int i2 = i | this.c;
            this.c = i2;
            aVar.a("state", Integer.valueOf(i2)).b().c();
        }
    }
}
