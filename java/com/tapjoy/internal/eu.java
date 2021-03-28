package com.tapjoy.internal;

import com.tapjoy.internal.eh;

public final class eu extends eh {
    public static final ej c = new b();
    public static final Integer d = 0;
    public final String e;
    public final Integer f;
    public final String g;
    public final String h;
    public final String i;

    public eu(String str, Integer num, String str2, String str3, String str4, iu iuVar) {
        super(c, iuVar);
        this.e = str;
        this.f = num;
        this.g = str2;
        this.h = str3;
        this.i = str4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof eu)) {
            return false;
        }
        eu euVar = (eu) obj;
        return a().equals(euVar.a()) && eo.a(this.e, euVar.e) && eo.a(this.f, euVar.f) && eo.a(this.g, euVar.g) && eo.a(this.h, euVar.h) && eo.a(this.i, euVar.i);
    }

    public final int hashCode() {
        int i2 = this.b;
        if (i2 != 0) {
            return i2;
        }
        int hashCode = a().hashCode() * 37;
        String str = this.e;
        int i3 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.f;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.g;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.h;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.i;
        if (str4 != null) {
            i3 = str4.hashCode();
        }
        int i4 = hashCode5 + i3;
        this.b = i4;
        return i4;
    }

    @Override // com.tapjoy.internal.eh
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.e != null) {
            sb.append(", pkgVer=");
            sb.append(this.e);
        }
        if (this.f != null) {
            sb.append(", pkgRev=");
            sb.append(this.f);
        }
        if (this.g != null) {
            sb.append(", dataVer=");
            sb.append(this.g);
        }
        if (this.h != null) {
            sb.append(", installer=");
            sb.append(this.h);
        }
        if (this.i != null) {
            sb.append(", store=");
            sb.append(this.i);
        }
        StringBuilder replace = sb.replace(0, 2, "App{");
        replace.append('}');
        return replace.toString();
    }

    public static final class a extends eh.a {
        public String c;
        public Integer d;
        public String e;
        public String f;
        public String g;

        public final eu b() {
            return new eu(this.c, this.d, this.e, this.f, this.g, super.a());
        }
    }

    static final class b extends ej {
        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ int a(Object obj) {
            eu euVar = (eu) obj;
            int i = 0;
            int a = (euVar.e != null ? ej.p.a(1, euVar.e) : 0) + (euVar.f != null ? ej.d.a(2, euVar.f) : 0) + (euVar.g != null ? ej.p.a(3, euVar.g) : 0) + (euVar.h != null ? ej.p.a(4, euVar.h) : 0);
            if (euVar.i != null) {
                i = ej.p.a(5, euVar.i);
            }
            return a + i + euVar.a().c();
        }

        @Override // com.tapjoy.internal.ej
        public final /* bridge */ /* synthetic */ void a(el elVar, Object obj) {
            eu euVar = (eu) obj;
            if (euVar.e != null) {
                ej.p.a(elVar, 1, euVar.e);
            }
            if (euVar.f != null) {
                ej.d.a(elVar, 2, euVar.f);
            }
            if (euVar.g != null) {
                ej.p.a(elVar, 3, euVar.g);
            }
            if (euVar.h != null) {
                ej.p.a(elVar, 4, euVar.h);
            }
            if (euVar.i != null) {
                ej.p.a(elVar, 5, euVar.i);
            }
            elVar.a(euVar.a());
        }

        b() {
            super(eg.LENGTH_DELIMITED, eu.class);
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
                    aVar.d = (Integer) ej.d.a(ekVar);
                } else if (b == 3) {
                    aVar.e = (String) ej.p.a(ekVar);
                } else if (b == 4) {
                    aVar.f = (String) ej.p.a(ekVar);
                } else if (b != 5) {
                    eg c = ekVar.c();
                    aVar.a(b, c, c.a().a(ekVar));
                } else {
                    aVar.g = (String) ej.p.a(ekVar);
                }
            }
        }
    }
}
