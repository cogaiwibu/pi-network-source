package com.ss.android.crash.log;

import android.content.Context;

/* compiled from: CrashANRHandler */
public class g {
    private static volatile g a;
    private final c b;

    public static g a(Context context) {
        if (a == null) {
            synchronized (g.class) {
                if (a == null) {
                    a = new g(context);
                }
            }
        }
        return a;
    }

    private g(Context context) {
        if (context != null) {
            this.b = new c(context);
            return;
        }
        throw new IllegalArgumentException("context is not be null");
    }

    public void a() {
        this.b.a();
    }
}
