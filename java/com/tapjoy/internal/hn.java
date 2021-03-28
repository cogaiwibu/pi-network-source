package com.tapjoy.internal;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class hn {
    public static final ScheduledExecutorService a = Executors.newScheduledThreadPool(1);
    public static final CountDownLatch b = new CountDownLatch(1);
    public static final CountDownLatch c = new CountDownLatch(1);
    private static final Runnable d = new Runnable() {
        /* class com.tapjoy.internal.hn.AnonymousClass1 */

        public final void run() {
            if (v.c()) {
                hn.b.countDown();
            } else if (v.a()) {
                hn.b.countDown();
            } else {
                hn.a.schedule(this, 300, TimeUnit.SECONDS);
            }
        }
    };
    private static String e;
    private static boolean f;

    public static void a() {
        a.execute(d);
    }

    public static void a(String str, boolean z) {
        e = str;
        f = z;
        c.countDown();
    }

    public static String b() {
        return e;
    }

    public static boolean c() {
        return f;
    }
}
