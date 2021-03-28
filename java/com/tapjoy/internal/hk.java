package com.tapjoy.internal;

import android.os.SystemClock;

public abstract class hk {
    protected static a a;
    private static hk b;

    public abstract void a(a aVar);

    public abstract boolean b();

    public static class a {
        public final String a;
        public final String b;
        public final long c = SystemClock.elapsedRealtime();
        public final fi d = new fi(60000);

        public a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }
    }

    protected static void a(hk hkVar) {
        synchronized (hk.class) {
            b = hkVar;
            a aVar = a;
            if (aVar != null) {
                a = null;
                hkVar.a(aVar);
            }
        }
    }

    public static void a(String str, String str2) {
        synchronized (hk.class) {
            a aVar = new a(str, str2);
            if (b != null) {
                a = null;
                b.a(aVar);
            } else {
                a = aVar;
            }
        }
    }

    public static boolean c() {
        hk hkVar = b;
        if (hkVar != null && hkVar.b()) {
            return true;
        }
        a aVar = a;
        if (aVar == null || aVar.d.a()) {
            return false;
        }
        return true;
    }
}
