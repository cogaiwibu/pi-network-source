package com.tapjoy.internal;

import com.tapjoy.internal.eh;
import java.util.List;

public final class ew extends eh {
    public static final ej c = new b();
    public final List d;

    public ew(List list, iu iuVar) {
        super(c, iuVar);
        this.d = eo.a("events", list);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ew)) {
            return false;
        }
        ew ewVar = (ew) obj;
        return a().equals(ewVar.a()) && this.d.equals(ewVar.d);
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
            sb.append(", events=");
            sb.append(this.d);
        }
        StringBuilder replace = sb.replace(0, 2, "EventBatch{");
        replace.append('}');
        return replace.toString();
    }

    public static final class a extends eh.a {
        public List c = eo.a();

        public final ew b() {
            return new ew(this.c, super.a());
        }
    }

    static final class b extends ej {
        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ int a(Object obj) {
            ew ewVar = (ew) obj;
            return ev.c.a().a(1, ewVar.d) + ewVar.a().c();
        }

        @Override // com.tapjoy.internal.ej
        public final /* bridge */ /* synthetic */ void a(el elVar, Object obj) {
            ew ewVar = (ew) obj;
            ev.c.a().a(elVar, 1, ewVar.d);
            elVar.a(ewVar.a());
        }

        b() {
            super(eg.LENGTH_DELIMITED, ew.class);
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
                    aVar.c.add(ev.c.a(ekVar));
                }
            }
        }
    }
}
