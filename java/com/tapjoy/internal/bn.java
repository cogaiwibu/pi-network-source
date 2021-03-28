package com.tapjoy.internal;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

public abstract class bn implements bk, bp {
    private HashMap a;

    public static bn a(InputStream inputStream) {
        return a.a().a(inputStream);
    }

    public static bn b(String str) {
        return a.a().a(str);
    }

    public static abstract class a {
        private static a a;

        public static a a() {
            a aVar = a;
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = bo.a;
            a = aVar2;
            return aVar2;
        }

        public final bn a(InputStream inputStream) {
            return a(new InputStreamReader(inputStream, jm.c));
        }

        public bn a(Reader reader) {
            return a(jy.a(reader));
        }

        public bn a(String str) {
            return a(new ByteArrayInputStream(str.getBytes(jm.c.name())));
        }
    }

    @Override // com.tapjoy.internal.bk
    public final Object a(String str) {
        HashMap hashMap = this.a;
        if (hashMap != null) {
            return hashMap.get(str);
        }
        return null;
    }

    @Override // com.tapjoy.internal.bk
    public final void a(String str, Object obj) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(str, obj);
    }

    public final boolean a() {
        return k() == bs.BEGIN_OBJECT;
    }

    private boolean t() {
        if (k() != bs.NULL) {
            return false;
        }
        o();
        return true;
    }

    public final String b() {
        if (t()) {
            return null;
        }
        return m();
    }

    public final String c(String str) {
        if (t()) {
            return str;
        }
        return m();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tapjoy.internal.bn$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.tapjoy.internal.bs[] r0 = com.tapjoy.internal.bs.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.tapjoy.internal.bn.AnonymousClass1.a = r0
                com.tapjoy.internal.bs r1 = com.tapjoy.internal.bs.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = com.tapjoy.internal.bn.AnonymousClass1.a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tapjoy.internal.bs r1 = com.tapjoy.internal.bs.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = com.tapjoy.internal.bn.AnonymousClass1.a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tapjoy.internal.bs r1 = com.tapjoy.internal.bs.NULL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = com.tapjoy.internal.bn.AnonymousClass1.a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.tapjoy.internal.bs r1 = com.tapjoy.internal.bs.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = com.tapjoy.internal.bn.AnonymousClass1.a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.tapjoy.internal.bs r1 = com.tapjoy.internal.bs.NUMBER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = com.tapjoy.internal.bn.AnonymousClass1.a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.tapjoy.internal.bs r1 = com.tapjoy.internal.bs.STRING     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.bn.AnonymousClass1.<clinit>():void");
        }
    }

    private Object u() {
        bs k = k();
        switch (AnonymousClass1.a[k.ordinal()]) {
            case 1:
                return c();
            case 2:
                return d();
            case 3:
                o();
                return null;
            case 4:
                return Boolean.valueOf(n());
            case 5:
                return new ci(m());
            case 6:
                return m();
            default:
                throw new IllegalStateException("Expected a value but was " + k);
        }
    }

    public final List c() {
        LinkedList linkedList = new LinkedList();
        a(linkedList);
        return linkedList;
    }

    private void a(List list) {
        f();
        while (j()) {
            list.add(u());
        }
        g();
    }

    public final Map d() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        a(linkedHashMap);
        return linkedHashMap;
    }

    public final void a(Map map) {
        h();
        while (j()) {
            map.put(l(), u());
        }
        i();
    }

    @Nullable
    public final Object a(bi biVar) {
        if (t()) {
            return null;
        }
        return biVar.a(this);
    }

    public final void a(List list, bi biVar) {
        f();
        while (j()) {
            list.add(biVar.a(this));
        }
        g();
    }

    private static URI d(String str) {
        try {
            return new URI(str);
        } catch (URISyntaxException e) {
            throw new bv(e);
        }
    }

    public final URL e() {
        URI uri = (URI) a("BASE_URI");
        if (uri != null) {
            return uri.resolve(d(m())).toURL();
        }
        return new URL(m());
    }
}
