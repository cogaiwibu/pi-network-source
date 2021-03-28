package com.tapjoy.internal;

import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.internal.eh;
import com.tapjoy.internal.ej;
import java.util.List;

public final class ev extends eh {
    public static final ej c = new b();
    public static final ey d = ey.APP;
    public static final Long e = 0L;
    public static final Long f = 0L;
    public static final Long g = 0L;
    public static final Long h = 0L;
    public static final Integer i = 0;
    public static final Integer j = 0;
    public static final Integer k = 0;
    public static final Long l = 0L;
    public static final Long m = 0L;
    public final fd A;
    public final String B;
    public final String C;
    public final fc D;
    public final String E;
    public final String F;
    public final String G;
    public final List H;
    public final String I;
    public final Integer J;
    public final Long K;
    public final Long L;
    public final ey n;
    public final String o;
    public final Long p;
    public final Long q;
    public final String r;
    public final Long s;
    public final Long t;
    public final fa u;
    public final eu v;
    public final fh w;
    public final Integer x;
    public final Integer y;
    public final ex z;

    public ev(ey eyVar, String str, Long l2, Long l3, String str2, Long l4, Long l5, fa faVar, eu euVar, fh fhVar, Integer num, Integer num2, ex exVar, fd fdVar, String str3, String str4, fc fcVar, String str5, String str6, String str7, List list, String str8, Integer num3, Long l6, Long l7, iu iuVar) {
        super(c, iuVar);
        this.n = eyVar;
        this.o = str;
        this.p = l2;
        this.q = l3;
        this.r = str2;
        this.s = l4;
        this.t = l5;
        this.u = faVar;
        this.v = euVar;
        this.w = fhVar;
        this.x = num;
        this.y = num2;
        this.z = exVar;
        this.A = fdVar;
        this.B = str3;
        this.C = str4;
        this.D = fcVar;
        this.E = str5;
        this.F = str6;
        this.G = str7;
        this.H = eo.a(TJAdUnitConstants.String.USAGE_TRACKER_VALUES, list);
        this.I = str8;
        this.J = num3;
        this.K = l6;
        this.L = l7;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ev)) {
            return false;
        }
        ev evVar = (ev) obj;
        return a().equals(evVar.a()) && this.n.equals(evVar.n) && this.o.equals(evVar.o) && this.p.equals(evVar.p) && eo.a(this.q, evVar.q) && eo.a(this.r, evVar.r) && eo.a(this.s, evVar.s) && eo.a(this.t, evVar.t) && eo.a(this.u, evVar.u) && eo.a(this.v, evVar.v) && eo.a(this.w, evVar.w) && eo.a(this.x, evVar.x) && eo.a(this.y, evVar.y) && eo.a(this.z, evVar.z) && eo.a(this.A, evVar.A) && eo.a(this.B, evVar.B) && eo.a(this.C, evVar.C) && eo.a(this.D, evVar.D) && eo.a(this.E, evVar.E) && eo.a(this.F, evVar.F) && eo.a(this.G, evVar.G) && this.H.equals(evVar.H) && eo.a(this.I, evVar.I) && eo.a(this.J, evVar.J) && eo.a(this.K, evVar.K) && eo.a(this.L, evVar.L);
    }

    public final int hashCode() {
        int i2 = this.b;
        if (i2 != 0) {
            return i2;
        }
        int hashCode = ((((((a().hashCode() * 37) + this.n.hashCode()) * 37) + this.o.hashCode()) * 37) + this.p.hashCode()) * 37;
        Long l2 = this.q;
        int i3 = 0;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str = this.r;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Long l3 = this.s;
        int hashCode4 = (hashCode3 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.t;
        int hashCode5 = (hashCode4 + (l4 != null ? l4.hashCode() : 0)) * 37;
        fa faVar = this.u;
        int hashCode6 = (hashCode5 + (faVar != null ? faVar.hashCode() : 0)) * 37;
        eu euVar = this.v;
        int hashCode7 = (hashCode6 + (euVar != null ? euVar.hashCode() : 0)) * 37;
        fh fhVar = this.w;
        int hashCode8 = (hashCode7 + (fhVar != null ? fhVar.hashCode() : 0)) * 37;
        Integer num = this.x;
        int hashCode9 = (hashCode8 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.y;
        int hashCode10 = (hashCode9 + (num2 != null ? num2.hashCode() : 0)) * 37;
        ex exVar = this.z;
        int hashCode11 = (hashCode10 + (exVar != null ? exVar.hashCode() : 0)) * 37;
        fd fdVar = this.A;
        int hashCode12 = (hashCode11 + (fdVar != null ? fdVar.hashCode() : 0)) * 37;
        String str2 = this.B;
        int hashCode13 = (hashCode12 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.C;
        int hashCode14 = (hashCode13 + (str3 != null ? str3.hashCode() : 0)) * 37;
        fc fcVar = this.D;
        int hashCode15 = (hashCode14 + (fcVar != null ? fcVar.hashCode() : 0)) * 37;
        String str4 = this.E;
        int hashCode16 = (hashCode15 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.F;
        int hashCode17 = (hashCode16 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.G;
        int hashCode18 = (((hashCode17 + (str6 != null ? str6.hashCode() : 0)) * 37) + this.H.hashCode()) * 37;
        String str7 = this.I;
        int hashCode19 = (hashCode18 + (str7 != null ? str7.hashCode() : 0)) * 37;
        Integer num3 = this.J;
        int hashCode20 = (hashCode19 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l5 = this.K;
        int hashCode21 = (hashCode20 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Long l6 = this.L;
        if (l6 != null) {
            i3 = l6.hashCode();
        }
        int i4 = hashCode21 + i3;
        this.b = i4;
        return i4;
    }

    @Override // com.tapjoy.internal.eh
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", type=");
        sb.append(this.n);
        sb.append(", name=");
        sb.append(this.o);
        sb.append(", time=");
        sb.append(this.p);
        if (this.q != null) {
            sb.append(", systemTime=");
            sb.append(this.q);
        }
        if (this.r != null) {
            sb.append(", instanceId=");
            sb.append(this.r);
        }
        if (this.s != null) {
            sb.append(", elapsedRealtime=");
            sb.append(this.s);
        }
        if (this.t != null) {
            sb.append(", duration=");
            sb.append(this.t);
        }
        if (this.u != null) {
            sb.append(", info=");
            sb.append(this.u);
        }
        if (this.v != null) {
            sb.append(", app=");
            sb.append(this.v);
        }
        if (this.w != null) {
            sb.append(", user=");
            sb.append(this.w);
        }
        if (this.x != null) {
            sb.append(", xxx_session_seq=");
            sb.append(this.x);
        }
        if (this.y != null) {
            sb.append(", eventSeq=");
            sb.append(this.y);
        }
        if (this.z != null) {
            sb.append(", eventPrev=");
            sb.append(this.z);
        }
        if (this.A != null) {
            sb.append(", purchase=");
            sb.append(this.A);
        }
        if (this.B != null) {
            sb.append(", exception=");
            sb.append(this.B);
        }
        if (this.C != null) {
            sb.append(", metaBase=");
            sb.append(this.C);
        }
        if (this.D != null) {
            sb.append(", meta=");
            sb.append(this.D);
        }
        if (this.E != null) {
            sb.append(", category=");
            sb.append(this.E);
        }
        if (this.F != null) {
            sb.append(", p1=");
            sb.append(this.F);
        }
        if (this.G != null) {
            sb.append(", p2=");
            sb.append(this.G);
        }
        if (!this.H.isEmpty()) {
            sb.append(", values=");
            sb.append(this.H);
        }
        if (this.I != null) {
            sb.append(", dimensions=");
            sb.append(this.I);
        }
        if (this.J != null) {
            sb.append(", count=");
            sb.append(this.J);
        }
        if (this.K != null) {
            sb.append(", firstTime=");
            sb.append(this.K);
        }
        if (this.L != null) {
            sb.append(", lastTime=");
            sb.append(this.L);
        }
        StringBuilder replace = sb.replace(0, 2, "Event{");
        replace.append('}');
        return replace.toString();
    }

    public static final class a extends eh.a {
        public Long A;
        public ey c;
        public String d;
        public Long e;
        public Long f;
        public String g;
        public Long h;
        public Long i;
        public fa j;
        public eu k;
        public fh l;
        public Integer m;
        public Integer n;
        public ex o;
        public fd p;
        public String q;
        public String r;
        public fc s;
        public String t;
        public String u;
        public String v;
        public List w = eo.a();
        public String x;
        public Integer y;
        public Long z;

        public final ev b() {
            if (this.c != null && this.d != null && this.e != null) {
                return new ev(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, super.a());
            }
            throw eo.a(this.c, "type", this.d, "name", this.e, "time");
        }
    }

    static final class b extends ej {
        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ int a(Object obj) {
            ev evVar = (ev) obj;
            int i = 0;
            int a = ey.ADAPTER.a(1, evVar.n) + ej.p.a(2, evVar.o) + ej.i.a(3, evVar.p) + (evVar.q != null ? ej.i.a(19, evVar.q) : 0) + (evVar.r != null ? ej.p.a(20, evVar.r) : 0) + (evVar.s != null ? ej.i.a(21, evVar.s) : 0) + (evVar.t != null ? ej.i.a(4, evVar.t) : 0) + (evVar.u != null ? fa.c.a(5, evVar.u) : 0) + (evVar.v != null ? eu.c.a(6, evVar.v) : 0) + (evVar.w != null ? fh.c.a(7, evVar.w) : 0) + (evVar.x != null ? ej.d.a(8, evVar.x) : 0) + (evVar.y != null ? ej.d.a(9, evVar.y) : 0) + (evVar.z != null ? ex.c.a(10, evVar.z) : 0) + (evVar.A != null ? fd.c.a(11, evVar.A) : 0) + (evVar.B != null ? ej.p.a(12, evVar.B) : 0) + (evVar.C != null ? ej.p.a(13, evVar.C) : 0) + (evVar.D != null ? fc.c.a(18, evVar.D) : 0) + (evVar.E != null ? ej.p.a(14, evVar.E) : 0) + (evVar.F != null ? ej.p.a(15, evVar.F) : 0) + (evVar.G != null ? ej.p.a(16, evVar.G) : 0) + ez.c.a().a(17, evVar.H) + (evVar.I != null ? ej.p.a(22, evVar.I) : 0) + (evVar.J != null ? ej.d.a(23, evVar.J) : 0) + (evVar.K != null ? ej.i.a(24, evVar.K) : 0);
            if (evVar.L != null) {
                i = ej.i.a(25, evVar.L);
            }
            return a + i + evVar.a().c();
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ Object a(ek ekVar) {
            return b(ekVar);
        }

        @Override // com.tapjoy.internal.ej
        public final /* bridge */ /* synthetic */ void a(el elVar, Object obj) {
            ev evVar = (ev) obj;
            ey.ADAPTER.a(elVar, 1, evVar.n);
            ej.p.a(elVar, 2, evVar.o);
            ej.i.a(elVar, 3, evVar.p);
            if (evVar.q != null) {
                ej.i.a(elVar, 19, evVar.q);
            }
            if (evVar.r != null) {
                ej.p.a(elVar, 20, evVar.r);
            }
            if (evVar.s != null) {
                ej.i.a(elVar, 21, evVar.s);
            }
            if (evVar.t != null) {
                ej.i.a(elVar, 4, evVar.t);
            }
            if (evVar.u != null) {
                fa.c.a(elVar, 5, evVar.u);
            }
            if (evVar.v != null) {
                eu.c.a(elVar, 6, evVar.v);
            }
            if (evVar.w != null) {
                fh.c.a(elVar, 7, evVar.w);
            }
            if (evVar.x != null) {
                ej.d.a(elVar, 8, evVar.x);
            }
            if (evVar.y != null) {
                ej.d.a(elVar, 9, evVar.y);
            }
            if (evVar.z != null) {
                ex.c.a(elVar, 10, evVar.z);
            }
            if (evVar.A != null) {
                fd.c.a(elVar, 11, evVar.A);
            }
            if (evVar.B != null) {
                ej.p.a(elVar, 12, evVar.B);
            }
            if (evVar.C != null) {
                ej.p.a(elVar, 13, evVar.C);
            }
            if (evVar.D != null) {
                fc.c.a(elVar, 18, evVar.D);
            }
            if (evVar.E != null) {
                ej.p.a(elVar, 14, evVar.E);
            }
            if (evVar.F != null) {
                ej.p.a(elVar, 15, evVar.F);
            }
            if (evVar.G != null) {
                ej.p.a(elVar, 16, evVar.G);
            }
            ez.c.a().a(elVar, 17, evVar.H);
            if (evVar.I != null) {
                ej.p.a(elVar, 22, evVar.I);
            }
            if (evVar.J != null) {
                ej.d.a(elVar, 23, evVar.J);
            }
            if (evVar.K != null) {
                ej.i.a(elVar, 24, evVar.K);
            }
            if (evVar.L != null) {
                ej.i.a(elVar, 25, evVar.L);
            }
            elVar.a(evVar.a());
        }

        b() {
            super(eg.LENGTH_DELIMITED, ev.class);
        }

        private static ev b(ek ekVar) {
            a aVar = new a();
            long a = ekVar.a();
            while (true) {
                int b = ekVar.b();
                if (b != -1) {
                    switch (b) {
                        case 1:
                            try {
                                aVar.c = (ey) ey.ADAPTER.a(ekVar);
                                break;
                            } catch (ej.a e) {
                                aVar.a(b, eg.VARINT, Long.valueOf((long) e.a));
                                break;
                            }
                        case 2:
                            aVar.d = (String) ej.p.a(ekVar);
                            break;
                        case 3:
                            aVar.e = (Long) ej.i.a(ekVar);
                            break;
                        case 4:
                            aVar.i = (Long) ej.i.a(ekVar);
                            break;
                        case 5:
                            aVar.j = (fa) fa.c.a(ekVar);
                            break;
                        case 6:
                            aVar.k = (eu) eu.c.a(ekVar);
                            break;
                        case 7:
                            aVar.l = (fh) fh.c.a(ekVar);
                            break;
                        case 8:
                            aVar.m = (Integer) ej.d.a(ekVar);
                            break;
                        case 9:
                            aVar.n = (Integer) ej.d.a(ekVar);
                            break;
                        case 10:
                            aVar.o = (ex) ex.c.a(ekVar);
                            break;
                        case 11:
                            aVar.p = (fd) fd.c.a(ekVar);
                            break;
                        case 12:
                            aVar.q = (String) ej.p.a(ekVar);
                            break;
                        case 13:
                            aVar.r = (String) ej.p.a(ekVar);
                            break;
                        case 14:
                            aVar.t = (String) ej.p.a(ekVar);
                            break;
                        case 15:
                            aVar.u = (String) ej.p.a(ekVar);
                            break;
                        case 16:
                            aVar.v = (String) ej.p.a(ekVar);
                            break;
                        case 17:
                            aVar.w.add(ez.c.a(ekVar));
                            break;
                        case 18:
                            aVar.s = (fc) fc.c.a(ekVar);
                            break;
                        case 19:
                            aVar.f = (Long) ej.i.a(ekVar);
                            break;
                        case 20:
                            aVar.g = (String) ej.p.a(ekVar);
                            break;
                        case 21:
                            aVar.h = (Long) ej.i.a(ekVar);
                            break;
                        case 22:
                            aVar.x = (String) ej.p.a(ekVar);
                            break;
                        case 23:
                            aVar.y = (Integer) ej.d.a(ekVar);
                            break;
                        case 24:
                            aVar.z = (Long) ej.i.a(ekVar);
                            break;
                        case 25:
                            aVar.A = (Long) ej.i.a(ekVar);
                            break;
                        default:
                            eg c = ekVar.c();
                            aVar.a(b, c, c.a().a(ekVar));
                            break;
                    }
                } else {
                    ekVar.a(a);
                    return aVar.b();
                }
            }
        }
    }
}
