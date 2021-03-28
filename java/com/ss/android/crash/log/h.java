package com.ss.android.crash.log;

import android.content.Context;
import java.lang.Thread;

/* compiled from: CrashHandler */
public class h implements Thread.UncaughtExceptionHandler {
    private static a c;
    private Thread.UncaughtExceptionHandler a = null;
    private Context b;

    /* compiled from: CrashHandler */
    public interface a {
        boolean a(Throwable th);
    }

    public static void a(a aVar) {
        if (c == null) {
            c = aVar;
        }
    }

    h(Context context) {
        this.b = context.getApplicationContext();
        this.a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        try {
            if (c == null) {
                i.b().a(l.a(this.b, thread, th));
            } else if (c.a(th)) {
                i.b().a(l.a(this.b, thread, th));
            }
            uncaughtExceptionHandler = this.a;
            if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == this) {
                return;
            }
        } catch (Throwable unused) {
            uncaughtExceptionHandler = this.a;
            if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == this) {
                return;
            }
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }
}
