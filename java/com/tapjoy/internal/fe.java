package com.tapjoy.internal;

import com.tapjoy.internal.eh;

public final class fe extends eh {
    public static final ej c = new b();
    public static final Long d = 0L;
    public static final Long e = 0L;
    public final String f;
    public final Long g;
    public final Long h;

    public fe(String str, Long l) {
        this(str, l, null, iu.b);
    }

    public fe(String str, Long l, Long l2, iu iuVar) {
        super(c, iuVar);
        this.f = str;
        this.g = l;
        this.h = l2;
    }

    public final a b() {
        a aVar = new a();
        aVar.c = this.f;
        aVar.d = this.g;
        aVar.e = this.h;
        aVar.a(a());
        return aVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof fe)) {
            return false;
        }
        fe feVar = (fe) obj;
        return a().equals(feVar.a()) && this.f.equals(feVar.f) && this.g.equals(feVar.g) && eo.a(this.h, feVar.h);
    }

    public final int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int hashCode = ((((a().hashCode() * 37) + this.f.hashCode()) * 37) + this.g.hashCode()) * 37;
        Long l = this.h;
        int hashCode2 = hashCode + (l != null ? l.hashCode() : 0);
        this.b = hashCode2;
        return hashCode2;
    }

    @Override // com.tapjoy.internal.eh
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", id=");
        sb.append(this.f);
        sb.append(", received=");
        sb.append(this.g);
        if (this.h != null) {
            sb.append(", clicked=");
            sb.append(this.h);
        }
        StringBuilder replace = sb.replace(0, 2, "Push{");
        replace.append('}');
        return replace.toString();
    }

    public static final class a extends eh.a {
        public String c;
        public Long d;
        public Long e;

        public final fe b() {
            if (this.c != null && this.d != null) {
                return new fe(this.c, this.d, this.e, super.a());
            }
            throw eo.a(this.c, "id", this.d, "received");
        }
    }

    static final class b extends ej {
        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ int a(Object obj) {
            fe feVar = (fe) obj;
            return ej.p.a(1, feVar.f) + ej.i.a(2, feVar.g) + (feVar.h != null ? ej.i.a(3, feVar.h) : 0) + feVar.a().c();
        }

        @Override // com.tapjoy.internal.ej
        public final /* bridge */ /* synthetic */ void a(el elVar, Object obj) {
            fe feVar = (fe) obj;
            ej.p.a(elVar, 1, feVar.f);
            ej.i.a(elVar, 2, feVar.g);
            if (feVar.h != null) {
                ej.i.a(elVar, 3, feVar.h);
            }
            elVar.a(feVar.a());
        }

        b() {
            super(eg.LENGTH_DELIMITED, fe.class);
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ Object a(ek ekVar) {
            a aVar = new a();
            long a = ekVar.a();
            while (true) {
                int b = ekVar.b();
                if (b == -1) {
                    ekVar.a(a);
                    return aVar.b();
                } else if (b == 1) {
                    aVar.c = (String) ej.p.a(ekVar);
                } else if (b == 2) {
                    aVar.d = (Long) ej.i.a(ekVar);
                } else if (b != 3) {
                    eg c = ekVar.c();
                    aVar.a(b, c, c.a().a(ekVar));
                } else {
                    aVar.e = (Long) ej.i.a(ekVar);
                }
            }
        }
    }
}
