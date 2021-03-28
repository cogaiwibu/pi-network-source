package com.tapjoy.internal;

import android.os.SystemClock;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.annotation.Nullable;

public abstract class gf {
    @Nullable
    static Set a = null;
    private static final ThreadLocal b = new ThreadLocal() {
        /* class com.tapjoy.internal.gf.AnonymousClass1 */

        /* access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public final /* synthetic */ Object initialValue() {
            return new HashMap();
        }
    };
    private static gf c;
    private static volatile boolean d = false;

    /* access modifiers changed from: protected */
    public abstract void a();

    /* access modifiers changed from: protected */
    public abstract void a(long j);

    /* access modifiers changed from: protected */
    public abstract void a(long j, String str, @Nullable String str2, @Nullable Map map);

    public static void a(gh ghVar) {
        if (c == null) {
            c = ghVar;
            if (d) {
                ghVar.a(v.b());
            }
        }
    }

    public static void a(boolean z) {
        if (d != z) {
            d = z;
            gf gfVar = c;
            if (gfVar == null) {
                return;
            }
            if (z) {
                gfVar.a(v.b());
            } else {
                gfVar.a();
            }
        }
    }

    public static void a(Collection collection) {
        if (collection == null || collection.isEmpty()) {
            a = null;
        } else {
            a = new HashSet(collection);
        }
    }

    /* access modifiers changed from: private */
    public static void b(String str, @Nullable String str2, @Nullable Map map) {
        gf gfVar;
        Set set = a;
        if ((set == null || !set.contains(str)) && d && (gfVar = c) != null) {
            gfVar.a(v.b(), str, str2, map);
        }
    }

    public static void a(String str, @Nullable TreeMap treeMap, @Nullable Map map) {
        b(str, treeMap != null ? bh.a((Object) treeMap) : null, map);
    }

    public static a a(String str) {
        a a2 = new a(str).a();
        ((Map) b.get()).put(str, a2);
        return a2;
    }

    public static a b(String str) {
        a aVar = (a) ((Map) b.get()).remove(str);
        return aVar != null ? aVar.b() : new a(str);
    }

    public static a c(String str) {
        return (a) ((Map) b.get()).get(str);
    }

    public static a d(String str) {
        return (a) ((Map) b.get()).remove(str);
    }

    public static void a(String str, a aVar) {
        if (aVar == null) {
            return;
        }
        if (str.equals(aVar.a)) {
            ((Map) b.get()).put(str, aVar);
        } else {
            String str2 = aVar.a;
        }
    }

    public static a e(String str) {
        return new a(str);
    }

    public static final class a {
        final String a;
        private final TreeMap b = new TreeMap();
        private final Map c = new HashMap();
        private volatile long d;

        a(String str) {
            this.a = str;
        }

        public final a a() {
            try {
                this.d = SystemClock.elapsedRealtime();
            } catch (NullPointerException unused) {
                this.d = -1;
            }
            return this;
        }

        public final a b() {
            long j = this.d;
            if (j != -1) {
                try {
                    a("spent_time", SystemClock.elapsedRealtime() - j);
                } catch (NullPointerException unused) {
                }
            }
            return this;
        }

        public final a a(String str, Object obj) {
            this.b.put(str, obj);
            return this;
        }

        public final a a(Map map) {
            if (map != null) {
                this.b.putAll(map);
            }
            return this;
        }

        public final a a(String str) {
            this.b.put("failure", str);
            return this;
        }

        public final a b(String str) {
            this.b.put("misuse", str);
            return this;
        }

        public final a a(String str, long j) {
            this.c.put(str, Long.valueOf(j));
            return this;
        }

        public final a b(Map map) {
            if (map != null) {
                this.c.putAll(map);
            }
            return this;
        }

        public final void c() {
            String str = this.a;
            Map map = null;
            String a2 = this.b.size() > 0 ? bh.a((Object) this.b) : null;
            if (this.c.size() > 0) {
                map = this.c;
            }
            gf.b(str, a2, map);
        }
    }
}
