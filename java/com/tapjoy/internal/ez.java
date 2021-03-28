package com.tapjoy.internal;

import com.tapjoy.internal.eh;

public final class ez extends eh {
    public static final ej c = new b();
    public static final Long d = 0L;
    public final String e;
    public final Long f;

    public ez(String str, Long l) {
        this(str, l, iu.b);
    }

    public ez(String str, Long l, iu iuVar) {
        super(c, iuVar);
        this.e = str;
        this.f = l;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ez)) {
            return false;
        }
        ez ezVar = (ez) obj;
        return a().equals(ezVar.a()) && this.e.equals(ezVar.e) && this.f.equals(ezVar.f);
    }

    public final int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int hashCode = (((a().hashCode() * 37) + this.e.hashCode()) * 37) + this.f.hashCode();
        this.b = hashCode;
        return hashCode;
    }

    @Override // com.tapjoy.internal.eh
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", name=");
        sb.append(this.e);
        sb.append(", value=");
        sb.append(this.f);
        StringBuilder replace = sb.replace(0, 2, "EventValue{");
        replace.append('}');
        return replace.toString();
    }

    public static final class a extends eh.a {
        public String c;
        public Long d;

        public final ez b() {
            if (this.c != null && this.d != null) {
                return new ez(this.c, this.d, super.a());
            }
            throw eo.a(this.c, "name", this.d, "value");
        }
    }

    static final class b extends ej {
        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ int a(Object obj) {
            ez ezVar = (ez) obj;
            return ej.p.a(1, ezVar.e) + ej.i.a(2, ezVar.f) + ezVar.a().c();
        }

        @Override // com.tapjoy.internal.ej
        public final /* bridge */ /* synthetic */ void a(el elVar, Object obj) {
            ez ezVar = (ez) obj;
            ej.p.a(elVar, 1, ezVar.e);
            ej.i.a(elVar, 2, ezVar.f);
            elVar.a(ezVar.a());
        }

        b() {
            super(eg.LENGTH_DELIMITED, ez.class);
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
                } else if (b != 2) {
                    eg c = ekVar.c();
                    aVar.a(b, c, c.a().a(ekVar));
                } else {
                    aVar.d = (Long) ej.i.a(ekVar);
                }
            }
        }
    }
}
