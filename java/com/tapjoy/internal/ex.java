package com.tapjoy.internal;

import com.tapjoy.internal.eh;
import com.tapjoy.internal.ej;

public final class ex extends eh {
    public static final ej c = new b();
    public static final ey d = ey.APP;
    public final ey e;
    public final String f;
    public final String g;

    public ex(ey eyVar, String str, String str2, iu iuVar) {
        super(c, iuVar);
        this.e = eyVar;
        this.f = str;
        this.g = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ex)) {
            return false;
        }
        ex exVar = (ex) obj;
        return a().equals(exVar.a()) && this.e.equals(exVar.e) && this.f.equals(exVar.f) && eo.a(this.g, exVar.g);
    }

    public final int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int hashCode = ((((a().hashCode() * 37) + this.e.hashCode()) * 37) + this.f.hashCode()) * 37;
        String str = this.g;
        int hashCode2 = hashCode + (str != null ? str.hashCode() : 0);
        this.b = hashCode2;
        return hashCode2;
    }

    @Override // com.tapjoy.internal.eh
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", type=");
        sb.append(this.e);
        sb.append(", name=");
        sb.append(this.f);
        if (this.g != null) {
            sb.append(", category=");
            sb.append(this.g);
        }
        StringBuilder replace = sb.replace(0, 2, "EventGroup{");
        replace.append('}');
        return replace.toString();
    }

    public static final class a extends eh.a {
        public ey c;
        public String d;
        public String e;

        public final ex b() {
            if (this.c != null && this.d != null) {
                return new ex(this.c, this.d, this.e, super.a());
            }
            throw eo.a(this.c, "type", this.d, "name");
        }
    }

    static final class b extends ej {
        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ int a(Object obj) {
            ex exVar = (ex) obj;
            return ey.ADAPTER.a(1, exVar.e) + ej.p.a(2, exVar.f) + (exVar.g != null ? ej.p.a(3, exVar.g) : 0) + exVar.a().c();
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ Object a(ek ekVar) {
            return b(ekVar);
        }

        @Override // com.tapjoy.internal.ej
        public final /* bridge */ /* synthetic */ void a(el elVar, Object obj) {
            ex exVar = (ex) obj;
            ey.ADAPTER.a(elVar, 1, exVar.e);
            ej.p.a(elVar, 2, exVar.f);
            if (exVar.g != null) {
                ej.p.a(elVar, 3, exVar.g);
            }
            elVar.a(exVar.a());
        }

        b() {
            super(eg.LENGTH_DELIMITED, ex.class);
        }

        private static ex b(ek ekVar) {
            a aVar = new a();
            long a = ekVar.a();
            while (true) {
                int b = ekVar.b();
                if (b == -1) {
                    ekVar.a(a);
                    return aVar.b();
                } else if (b == 1) {
                    try {
                        aVar.c = (ey) ey.ADAPTER.a(ekVar);
                    } catch (ej.a e) {
                        aVar.a(b, eg.VARINT, Long.valueOf((long) e.a));
                    }
                } else if (b == 2) {
                    aVar.d = (String) ej.p.a(ekVar);
                } else if (b != 3) {
                    eg c = ekVar.c();
                    aVar.a(b, c, c.a().a(ekVar));
                } else {
                    aVar.e = (String) ej.p.a(ekVar);
                }
            }
        }
    }
}
