package com.tapjoy.internal;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.tapjoy.internal.eh;
import java.util.List;

public final class fg extends eh {
    public static final ej c = new b();
    public final List d;

    public fg(List list) {
        this(list, iu.b);
    }

    public fg(List list, iu iuVar) {
        super(c, iuVar);
        this.d = eo.a(MessengerShareContentUtility.ELEMENTS, list);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof fg)) {
            return false;
        }
        fg fgVar = (fg) obj;
        return a().equals(fgVar.a()) && this.d.equals(fgVar.d);
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
            sb.append(", elements=");
            sb.append(this.d);
        }
        StringBuilder replace = sb.replace(0, 2, "StringList{");
        replace.append('}');
        return replace.toString();
    }

    public static final class a extends eh.a {
        public List c = eo.a();

        public final fg b() {
            return new fg(this.c, super.a());
        }
    }

    static final class b extends ej {
        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ int a(Object obj) {
            fg fgVar = (fg) obj;
            return ej.p.a().a(1, fgVar.d) + fgVar.a().c();
        }

        @Override // com.tapjoy.internal.ej
        public final /* bridge */ /* synthetic */ void a(el elVar, Object obj) {
            fg fgVar = (fg) obj;
            ej.p.a().a(elVar, 1, fgVar.d);
            elVar.a(fgVar.a());
        }

        b() {
            super(eg.LENGTH_DELIMITED, fg.class);
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
                    aVar.c.add(ej.p.a(ekVar));
                }
            }
        }
    }
}
