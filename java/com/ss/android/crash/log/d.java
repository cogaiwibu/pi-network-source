package com.ss.android.crash.log;

import android.os.Handler;
import android.os.Looper;
import java.io.File;

/* compiled from: ANRThread */
public class d extends Thread {
    private Handler a = new Handler(Looper.getMainLooper());
    private long b = 5000;
    private long c;
    private volatile int d = 0;
    private final c e;
    private volatile long f;
    private Runnable g = new Runnable() {
        /* class com.ss.android.crash.log.d.AnonymousClass1 */

        public void run() {
            d dVar = d.this;
            dVar.d = (dVar.d + 1) % Integer.MAX_VALUE;
        }
    };

    public d(c cVar, long j) {
        this.e = cVar;
        this.b = j;
        this.c = a();
    }

    public void run() {
        super.run();
        setName("ANR_FILE_MODIFY");
        while (!isInterrupted()) {
            int i = this.d;
            this.a.post(this.g);
            e.a(this.b);
            if (i == this.d) {
                if (b()) {
                    int i2 = 0;
                    int i3 = 0;
                    while (i == this.d) {
                        if (c()) {
                            i2++;
                            this.c = a();
                            this.e.a(200, "/data/anr/traces.txt");
                            if (i2 >= 3) {
                                break;
                            }
                        } else {
                            e.a(500);
                        }
                        int i4 = i3 + 1;
                        if (i3 > 40) {
                            break;
                        }
                        i3 = i4;
                    }
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.f > 20000) {
                        this.e.a(100, (String) null);
                    }
                    this.f = currentTimeMillis;
                }
            }
        }
    }

    private long a() {
        File file = new File("/data/anr/traces.txt");
        if (file.exists()) {
            return file.lastModified();
        }
        return 0;
    }

    private boolean b() {
        File file = new File("/data/anr/traces.txt");
        return file.exists() && file.canRead();
    }

    private boolean c() {
        long a2 = a();
        if (a2 != 0) {
            long j = this.c;
            return (j == 0 || j == a2) ? false : true;
        }
    }
}
