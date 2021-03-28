package com.tapjoy.internal;

import com.tapjoy.internal.eh;
import java.util.List;

public final class ff extends eh {
    public static final ej c = new b();
    public final List d;

    public ff(List list) {
        this(list, iu.b);
    }

    public ff(List list, iu iuVar) {
        super(c, iuVar);
        this.d = eo.a("pushes", list);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ff)) {
            return false;
        }
        ff ffVar = (ff) obj;
        return a().equals(ffVar.a()) && this.d.equals(ffVar.d);
    }

    public final int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int hashCode = (a().hashCode() * 37) + this.d.hashCode();
        this.b = hashCode;
        return hashCode;
    }

    @Override // com.tapjoy.internal.eh
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.d.isEmpty()) {
            sb.append(", pushes=");
            sb.append(this.d);
        }
        StringBuilder replace = sb.replace(0, 2, "PushList{");
        replace.append('}');
        return replace.toString();
    }

    public static final class a extends eh.a {
        public List c = eo.a();

        public final ff b() {
            return new ff(this.c, super.a());
        }
    }

    static final class b extends ej {
        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ int a(Object obj) {
            ff ffVar = (ff) obj;
            return fe.c.a().a(1, ffVar.d) + ffVar.a().c();
        }

        @Override // com.tapjoy.internal.ej
        public final /* bridge */ /* synthetic */ void a(el elVar, Object obj) {
            ff ffVar = (ff) obj;
            fe.c.a().a(elVar, 1, ffVar.d);
            elVar.a(ffVar.a());
        }

        b() {
            super(eg.LENGTH_DELIMITED, ff.class);
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
                } else if (b != 1) {
                    eg c = ekVar.c();
                    aVar.a(b, c, c.a().a(ekVar));
                } else {
                    aVar.c.add(fe.c.a(ekVar));
                }
            }
        }
    }
}
