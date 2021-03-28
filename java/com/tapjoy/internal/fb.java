package com.tapjoy.internal;

import com.tapjoy.internal.eh;

public final class fb extends eh {
    public static final ej c = new b();
    public final fa d;
    public final eu e;
    public final fh f;

    public fb(fa faVar, eu euVar, fh fhVar) {
        this(faVar, euVar, fhVar, iu.b);
    }

    public fb(fa faVar, eu euVar, fh fhVar, iu iuVar) {
        super(c, iuVar);
        this.d = faVar;
        this.e = euVar;
        this.f = fhVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof fb)) {
            return false;
        }
        fb fbVar = (fb) obj;
        return a().equals(fbVar.a()) && eo.a(this.d, fbVar.d) && eo.a(this.e, fbVar.e) && eo.a(this.f, fbVar.f);
    }

    public final int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int hashCode = a().hashCode() * 37;
        fa faVar = this.d;
        int i2 = 0;
        int hashCode2 = (hashCode + (faVar != null ? faVar.hashCode() : 0)) * 37;
        eu euVar = this.e;
        int hashCode3 = (hashCode2 + (euVar != null ? euVar.hashCode() : 0)) * 37;
        fh fhVar = this.f;
        if (fhVar != null) {
            i2 = fhVar.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.b = i3;
        return i3;
    }

    @Override // com.tapjoy.internal.eh
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.d != null) {
            sb.append(", info=");
            sb.append(this.d);
        }
        if (this.e != null) {
            sb.append(", app=");
            sb.append(this.e);
        }
        if (this.f != null) {
            sb.append(", user=");
            sb.append(this.f);
        }
        StringBuilder replace = sb.replace(0, 2, "InfoSet{");
        replace.append('}');
        return replace.toString();
    }

    public static final class a extends eh.a {
        public fa c;
        public eu d;
        public fh e;

        public final fb b() {
            return new fb(this.c, this.d, this.e, super.a());
        }
    }

    static final class b extends ej {
        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ int a(Object obj) {
            fb fbVar = (fb) obj;
            int i = 0;
            int a = (fbVar.d != null ? fa.c.a(1, fbVar.d) : 0) + (fbVar.e != null ? eu.c.a(2, fbVar.e) : 0);
            if (fbVar.f != null) {
                i = fh.c.a(3, fbVar.f);
            }
            return a + i + fbVar.a().c();
        }

        @Override // com.tapjoy.internal.ej
        public final /* bridge */ /* synthetic */ void a(el elVar, Object obj) {
            fb fbVar = (fb) obj;
            if (fbVar.d != null) {
                fa.c.a(elVar, 1, fbVar.d);
            }
            if (fbVar.e != null) {
                eu.c.a(elVar, 2, fbVar.e);
            }
            if (fbVar.f != null) {
                fh.c.a(elVar, 3, fbVar.f);
            }
            elVar.a(fbVar.a());
        }

        b() {
            super(eg.LENGTH_DELIMITED, fb.class);
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
                    aVar.c = (fa) fa.c.a(ekVar);
                } else if (b == 2) {
                    aVar.d = (eu) eu.c.a(ekVar);
                } else if (b != 3) {
                    eg c = ekVar.c();
                    aVar.a(b, c, c.a().a(ekVar));
                } else {
                    aVar.e = (fh) fh.c.a(ekVar);
                }
            }
        }
    }
}
