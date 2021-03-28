package com.ss.android.crash.log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: TTExcutor */
public class p {
    private static volatile p a;
    private static ExecutorService b;

    public static p a() {
        if (a == null) {
            synchronized (p.class) {
                if (a == null) {
                    a = new p();
                }
            }
        }
        return a;
    }

    private p() {
        b = Executors.newSingleThreadExecutor();
    }

    public void a(Runnable runnable) {
        ExecutorService executorService = b;
        if (executorService != null) {
            executorService.submit(runnable);
        }
    }
}
