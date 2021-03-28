package com.bytedance.sdk.adnet.core;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: VNetLog */
public class n {
    public static boolean a = Log.isLoggable("VNetLog", 2);
    private static String b = "VNetLog";

    public static void a(String str, Object... objArr) {
        if (a) {
            Log.v(b, e(str, objArr));
        }
    }

    public static void b(String str, Object... objArr) {
        Log.d(b, e(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        Log.e(b, e(str, objArr));
    }

    public static void a(Throwable th, String str, Object... objArr) {
        Log.e(b, e(str, objArr), th);
    }

    public static void d(String str, Object... objArr) {
        Log.wtf(b, e(str, objArr));
    }

    private static String e(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (!stackTrace[i].getClassName().equals("com.bytedance.sdk.adnet.VNetLog")) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                str2 = substring.substring(substring.lastIndexOf(36) + 1) + "." + stackTrace[i].getMethodName();
                break;
            } else {
                i++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: VNetLog */
    public static class a {
        public static final boolean a = n.a;
        private final List<C0002a> b = new ArrayList();
        private boolean c = false;

        a() {
        }

        /* access modifiers changed from: private */
        /* renamed from: com.bytedance.sdk.adnet.core.n$a$a  reason: collision with other inner class name */
        /* compiled from: VNetLog */
        public static class C0002a {
            public final String a;
            public final long b;
            public final long c;

            public C0002a(String str, long j, long j2) {
                this.a = str;
                this.b = j;
                this.c = j2;
            }
        }

        public synchronized void a(String str, long j) {
            if (!this.c) {
                this.b.add(new C0002a(str, j, SystemClock.elapsedRealtime()));
            } else {
                throw new IllegalStateException("Marker added to finished log");
            }
        }

        public synchronized void a(String str) {
            this.c = true;
            long a2 = a();
            if (a2 > 0) {
                long j = this.b.get(0).c;
                n.b("(%-4d ms) %s", Long.valueOf(a2), str);
                for (C0002a aVar : this.b) {
                    long j2 = aVar.c;
                    n.b("(+%-4d) [%2d] %s", Long.valueOf(j2 - j), Long.valueOf(aVar.b), aVar.a);
                    j = j2;
                }
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() throws Throwable {
            if (!this.c) {
                a("Request on the loose");
                n.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }

        private long a() {
            if (this.b.size() == 0) {
                return 0;
            }
            long j = this.b.get(0).c;
            List<C0002a> list = this.b;
            return list.get(list.size() - 1).c - j;
        }
    }
}
