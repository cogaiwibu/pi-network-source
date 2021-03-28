package com.tapjoy.internal;

import com.tapjoy.internal.eh;

public final class fc extends eh {
    public static final ej c = new b();
    public final String d;
    public final String e;
    public final String f;

    public fc(String str, String str2, String str3) {
        this(str, str2, str3, iu.b);
    }

    public fc(String str, String str2, String str3, iu iuVar) {
        super(c, iuVar);
        this.d = str;
        this.e = str2;
        this.f = str3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof fc)) {
            return false;
        }
        fc fcVar = (fc) obj;
        return a().equals(fcVar.a()) && eo.a(this.d, fcVar.d) && eo.a(this.e, fcVar.e) && eo.a(this.f, fcVar.f);
    }

    public final int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int hashCode = a().hashCode() * 37;
        String str = this.d;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.e;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.f;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.b = i3;
        return i3;
    }

    @Override // com.tapjoy.internal.eh
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.d != null) {
            sb.append(", fq7Change=");
            sb.append(this.d);
        }
        if (this.e != null) {
            sb.append(", fq30Change=");
            sb.append(this.e);
        }
        if (this.f != null) {
            sb.append(", pushId=");
            sb.append(this.f);
        }
        StringBuilder replace = sb.replace(0, 2, "Meta{");
        replace.append('}');
        return replace.toString();
    }

    public static final class a extends eh.a {
        public String c;
        public String d;
        public String e;

        public final fc b() {
            return new fc(this.c, this.d, this.e, super.a());
        }
    }

    static final class b extends ej {
        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ int a(Object obj) {
            fc fcVar = (fc) obj;
            int i = 0;
            int a = (fcVar.d != null ? ej.p.a(1, fcVar.d) : 0) + (fcVar.e != null ? ej.p.a(2, fcVar.e) : 0);
            if (fcVar.f != null) {
                i = ej.p.a(3, fcVar.f);
            }
            return a + i + fcVar.a().c();
        }

        @Override // com.tapjoy.internal.ej
        public final /* bridge */ /* synthetic */ void a(el elVar, Object obj) {
            fc fcVar = (fc) obj;
            if (fcVar.d != null) {
                ej.p.a(elVar, 1, fcVar.d);
            }
            if (fcVar.e != null) {
                ej.p.a(elVar, 2, fcVar.e);
            }
            if (fcVar.f != null) {
                ej.p.a(elVar, 3, fcVar.f);
            }
            elVar.a(fcVar.a());
        }

        b() {
            super(eg.LENGTH_DELIMITED, fc.class);
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
