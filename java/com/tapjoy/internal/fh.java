package com.tapjoy.internal;

import com.onesignal.UserState;
import com.tapjoy.internal.eh;
import java.util.List;

public final class fh extends eh {
    public static final ej c = new b();
    public static final Long d = 0L;
    public static final Integer e = 0;
    public static final Integer f = 0;
    public static final Integer g = 0;
    public static final Long h = 0L;
    public static final Long i = 0L;
    public static final Long j = 0L;
    public static final Integer k = 0;
    public static final Double l;
    public static final Long m = 0L;
    public static final Double n;
    public static final Boolean o = false;
    public static final Integer p = 0;
    public static final Integer q = 0;
    public static final Boolean r = false;
    public final Long A;
    public final String B;
    public final Integer C;
    public final Double D;
    public final Long E;
    public final Double F;
    public final String G;
    public final Boolean H;
    public final String I;
    public final Integer J;
    public final Integer K;
    public final String L;
    public final String M;
    public final String N;
    public final String O;
    public final String P;
    public final List Q;
    public final Boolean R;
    public final Long s;
    public final String t;
    public final Integer u;
    public final Integer v;
    public final List w;
    public final Integer x;
    public final Long y;
    public final Long z;

    static {
        Double valueOf = Double.valueOf(0.0d);
        l = valueOf;
        n = valueOf;
    }

    public fh(Long l2, String str, Integer num, Integer num2, List list, Integer num3, Long l3, Long l4, Long l5, String str2, Integer num4, Double d2, Long l6, Double d3, String str3, Boolean bool, String str4, Integer num5, Integer num6, String str5, String str6, String str7, String str8, String str9, List list2, Boolean bool2, iu iuVar) {
        super(c, iuVar);
        this.s = l2;
        this.t = str;
        this.u = num;
        this.v = num2;
        this.w = eo.a("pushes", list);
        this.x = num3;
        this.y = l3;
        this.z = l4;
        this.A = l5;
        this.B = str2;
        this.C = num4;
        this.D = d2;
        this.E = l6;
        this.F = d3;
        this.G = str3;
        this.H = bool;
        this.I = str4;
        this.J = num5;
        this.K = num6;
        this.L = str5;
        this.M = str6;
        this.N = str7;
        this.O = str8;
        this.P = str9;
        this.Q = eo.a(UserState.TAGS, list2);
        this.R = bool2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof fh)) {
            return false;
        }
        fh fhVar = (fh) obj;
        return a().equals(fhVar.a()) && eo.a(this.s, fhVar.s) && eo.a(this.t, fhVar.t) && eo.a(this.u, fhVar.u) && eo.a(this.v, fhVar.v) && this.w.equals(fhVar.w) && eo.a(this.x, fhVar.x) && eo.a(this.y, fhVar.y) && eo.a(this.z, fhVar.z) && eo.a(this.A, fhVar.A) && eo.a(this.B, fhVar.B) && eo.a(this.C, fhVar.C) && eo.a(this.D, fhVar.D) && eo.a(this.E, fhVar.E) && eo.a(this.F, fhVar.F) && eo.a(this.G, fhVar.G) && eo.a(this.H, fhVar.H) && eo.a(this.I, fhVar.I) && eo.a(this.J, fhVar.J) && eo.a(this.K, fhVar.K) && eo.a(this.L, fhVar.L) && eo.a(this.M, fhVar.M) && eo.a(this.N, fhVar.N) && eo.a(this.O, fhVar.O) && eo.a(this.P, fhVar.P) && this.Q.equals(fhVar.Q) && eo.a(this.R, fhVar.R);
    }

    public final int hashCode() {
        int i2 = this.b;
        if (i2 != 0) {
            return i2;
        }
        int hashCode = a().hashCode() * 37;
        Long l2 = this.s;
        int i3 = 0;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str = this.t;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.u;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.v;
        int hashCode5 = (((hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37) + this.w.hashCode()) * 37;
        Integer num3 = this.x;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l3 = this.y;
        int hashCode7 = (hashCode6 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.z;
        int hashCode8 = (hashCode7 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.A;
        int hashCode9 = (hashCode8 + (l5 != null ? l5.hashCode() : 0)) * 37;
        String str2 = this.B;
        int hashCode10 = (hashCode9 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num4 = this.C;
        int hashCode11 = (hashCode10 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Double d2 = this.D;
        int hashCode12 = (hashCode11 + (d2 != null ? d2.hashCode() : 0)) * 37;
        Long l6 = this.E;
        int hashCode13 = (hashCode12 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Double d3 = this.F;
        int hashCode14 = (hashCode13 + (d3 != null ? d3.hashCode() : 0)) * 37;
        String str3 = this.G;
        int hashCode15 = (hashCode14 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Boolean bool = this.H;
        int hashCode16 = (hashCode15 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str4 = this.I;
        int hashCode17 = (hashCode16 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num5 = this.J;
        int hashCode18 = (hashCode17 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.K;
        int hashCode19 = (hashCode18 + (num6 != null ? num6.hashCode() : 0)) * 37;
        String str5 = this.L;
        int hashCode20 = (hashCode19 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.M;
        int hashCode21 = (hashCode20 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.N;
        int hashCode22 = (hashCode21 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.O;
        int hashCode23 = (hashCode22 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.P;
        int hashCode24 = (((hashCode23 + (str9 != null ? str9.hashCode() : 0)) * 37) + this.Q.hashCode()) * 37;
        Boolean bool2 = this.R;
        if (bool2 != null) {
            i3 = bool2.hashCode();
        }
        int i4 = hashCode24 + i3;
        this.b = i4;
        return i4;
    }

    @Override // com.tapjoy.internal.eh
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.s != null) {
            sb.append(", installed=");
            sb.append(this.s);
        }
        if (this.t != null) {
            sb.append(", referrer=");
            sb.append(this.t);
        }
        if (this.u != null) {
            sb.append(", fq7=");
            sb.append(this.u);
        }
        if (this.v != null) {
            sb.append(", fq30=");
            sb.append(this.v);
        }
        if (!this.w.isEmpty()) {
            sb.append(", pushes=");
            sb.append(this.w);
        }
        if (this.x != null) {
            sb.append(", sessionTotalCount=");
            sb.append(this.x);
        }
        if (this.y != null) {
            sb.append(", sessionTotalDuration=");
            sb.append(this.y);
        }
        if (this.z != null) {
            sb.append(", sessionLastTime=");
            sb.append(this.z);
        }
        if (this.A != null) {
            sb.append(", sessionLastDuration=");
            sb.append(this.A);
        }
        if (this.B != null) {
            sb.append(", purchaseCurrency=");
            sb.append(this.B);
        }
        if (this.C != null) {
            sb.append(", purchaseTotalCount=");
            sb.append(this.C);
        }
        if (this.D != null) {
            sb.append(", purchaseTotalPrice=");
            sb.append(this.D);
        }
        if (this.E != null) {
            sb.append(", purchaseLastTime=");
            sb.append(this.E);
        }
        if (this.F != null) {
            sb.append(", purchaseLastPrice=");
            sb.append(this.F);
        }
        if (this.G != null) {
            sb.append(", idfa=");
            sb.append(this.G);
        }
        if (this.H != null) {
            sb.append(", idfaOptout=");
            sb.append(this.H);
        }
        if (this.I != null) {
            sb.append(", userId=");
            sb.append(this.I);
        }
        if (this.J != null) {
            sb.append(", userLevel=");
            sb.append(this.J);
        }
        if (this.K != null) {
            sb.append(", friendCount=");
            sb.append(this.K);
        }
        if (this.L != null) {
            sb.append(", uv1=");
            sb.append(this.L);
        }
        if (this.M != null) {
            sb.append(", uv2=");
            sb.append(this.M);
        }
        if (this.N != null) {
            sb.append(", uv3=");
            sb.append(this.N);
        }
        if (this.O != null) {
            sb.append(", uv4=");
            sb.append(this.O);
        }
        if (this.P != null) {
            sb.append(", uv5=");
            sb.append(this.P);
        }
        if (!this.Q.isEmpty()) {
            sb.append(", tags=");
            sb.append(this.Q);
        }
        if (this.R != null) {
            sb.append(", pushOptout=");
            sb.append(this.R);
        }
        StringBuilder replace = sb.replace(0, 2, "User{");
        replace.append('}');
        return replace.toString();
    }

    public static final class a extends eh.a {
        public List A = eo.a();
        public Boolean B;
        public Long c;
        public String d;
        public Integer e;
        public Integer f;
        public List g = eo.a();
        public Integer h;
        public Long i;
        public Long j;
        public Long k;
        public String l;
        public Integer m;
        public Double n;
        public Long o;
        public Double p;
        public String q;
        public Boolean r;
        public String s;
        public Integer t;
        public Integer u;
        public String v;
        public String w;
        public String x;
        public String y;
        public String z;

        public final fh b() {
            return new fh(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, super.a());
        }
    }

    static final class b extends ej {
        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ int a(Object obj) {
            fh fhVar = (fh) obj;
            int i = 0;
            int a = (fhVar.s != null ? ej.i.a(1, fhVar.s) : 0) + (fhVar.t != null ? ej.p.a(2, fhVar.t) : 0) + (fhVar.u != null ? ej.d.a(13, fhVar.u) : 0) + (fhVar.v != null ? ej.d.a(14, fhVar.v) : 0) + fe.c.a().a(15, fhVar.w) + (fhVar.x != null ? ej.d.a(16, fhVar.x) : 0) + (fhVar.y != null ? ej.i.a(17, fhVar.y) : 0) + (fhVar.z != null ? ej.i.a(18, fhVar.z) : 0) + (fhVar.A != null ? ej.i.a(19, fhVar.A) : 0) + (fhVar.B != null ? ej.p.a(20, fhVar.B) : 0) + (fhVar.C != null ? ej.d.a(3, fhVar.C) : 0) + (fhVar.D != null ? ej.o.a(21, fhVar.D) : 0) + (fhVar.E != null ? ej.i.a(4, fhVar.E) : 0) + (fhVar.F != null ? ej.o.a(22, fhVar.F) : 0) + (fhVar.G != null ? ej.p.a(23, fhVar.G) : 0) + (fhVar.H != null ? ej.c.a(24, fhVar.H) : 0) + (fhVar.I != null ? ej.p.a(5, fhVar.I) : 0) + (fhVar.J != null ? ej.d.a(6, fhVar.J) : 0) + (fhVar.K != null ? ej.d.a(7, fhVar.K) : 0) + (fhVar.L != null ? ej.p.a(8, fhVar.L) : 0) + (fhVar.M != null ? ej.p.a(9, fhVar.M) : 0) + (fhVar.N != null ? ej.p.a(10, fhVar.N) : 0) + (fhVar.O != null ? ej.p.a(11, fhVar.O) : 0) + (fhVar.P != null ? ej.p.a(12, fhVar.P) : 0) + ej.p.a().a(26, fhVar.Q);
            if (fhVar.R != null) {
                i = ej.c.a(25, fhVar.R);
            }
            return a + i + fhVar.a().c();
        }

        @Override // com.tapjoy.internal.ej
        public final /* bridge */ /* synthetic */ void a(el elVar, Object obj) {
            fh fhVar = (fh) obj;
            if (fhVar.s != null) {
                ej.i.a(elVar, 1, fhVar.s);
            }
            if (fhVar.t != null) {
                ej.p.a(elVar, 2, fhVar.t);
            }
            if (fhVar.u != null) {
                ej.d.a(elVar, 13, fhVar.u);
            }
            if (fhVar.v != null) {
                ej.d.a(elVar, 14, fhVar.v);
            }
            fe.c.a().a(elVar, 15, fhVar.w);
            if (fhVar.x != null) {
                ej.d.a(elVar, 16, fhVar.x);
            }
            if (fhVar.y != null) {
                ej.i.a(elVar, 17, fhVar.y);
            }
            if (fhVar.z != null) {
                ej.i.a(elVar, 18, fhVar.z);
            }
            if (fhVar.A != null) {
                ej.i.a(elVar, 19, fhVar.A);
            }
            if (fhVar.B != null) {
                ej.p.a(elVar, 20, fhVar.B);
            }
            if (fhVar.C != null) {
                ej.d.a(elVar, 3, fhVar.C);
            }
            if (fhVar.D != null) {
                ej.o.a(elVar, 21, fhVar.D);
            }
            if (fhVar.E != null) {
                ej.i.a(elVar, 4, fhVar.E);
            }
            if (fhVar.F != null) {
                ej.o.a(elVar, 22, fhVar.F);
            }
            if (fhVar.G != null) {
                ej.p.a(elVar, 23, fhVar.G);
            }
            if (fhVar.H != null) {
                ej.c.a(elVar, 24, fhVar.H);
            }
            if (fhVar.I != null) {
                ej.p.a(elVar, 5, fhVar.I);
            }
            if (fhVar.J != null) {
                ej.d.a(elVar, 6, fhVar.J);
            }
            if (fhVar.K != null) {
                ej.d.a(elVar, 7, fhVar.K);
            }
            if (fhVar.L != null) {
                ej.p.a(elVar, 8, fhVar.L);
            }
            if (fhVar.M != null) {
                ej.p.a(elVar, 9, fhVar.M);
            }
            if (fhVar.N != null) {
                ej.p.a(elVar, 10, fhVar.N);
            }
            if (fhVar.O != null) {
                ej.p.a(elVar, 11, fhVar.O);
            }
            if (fhVar.P != null) {
                ej.p.a(elVar, 12, fhVar.P);
            }
            ej.p.a().a(elVar, 26, fhVar.Q);
            if (fhVar.R != null) {
                ej.c.a(elVar, 25, fhVar.R);
            }
            elVar.a(fhVar.a());
        }

        b() {
            super(eg.LENGTH_DELIMITED, fh.class);
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ Object a(ek ekVar) {
            a aVar = new a();
            long a = ekVar.a();
            while (true) {
                int b = ekVar.b();
                if (b != -1) {
                    switch (b) {
                        case 1:
                            aVar.c = (Long) ej.i.a(ekVar);
                            break;
                        case 2:
                            aVar.d = (String) ej.p.a(ekVar);
                            break;
                        case 3:
                            aVar.m = (Integer) ej.d.a(ekVar);
                            break;
                        case 4:
                            aVar.o = (Long) ej.i.a(ekVar);
                            break;
                        case 5:
                            aVar.s = (String) ej.p.a(ekVar);
                            break;
                        case 6:
                            aVar.t = (Integer) ej.d.a(ekVar);
                            break;
                        case 7:
                            aVar.u = (Integer) ej.d.a(ekVar);
                            break;
                        case 8:
                            aVar.v = (String) ej.p.a(ekVar);
                            break;
                        case 9:
                            aVar.w = (String) ej.p.a(ekVar);
                            break;
                        case 10:
                            aVar.x = (String) ej.p.a(ekVar);
                            break;
                        case 11:
                            aVar.y = (String) ej.p.a(ekVar);
                            break;
                        case 12:
                            aVar.z = (String) ej.p.a(ekVar);
                            break;
                        case 13:
                            aVar.e = (Integer) ej.d.a(ekVar);
                            break;
                        case 14:
                            aVar.f = (Integer) ej.d.a(ekVar);
                            break;
                        case 15:
                            aVar.g.add(fe.c.a(ekVar));
                            break;
                        case 16:
                            aVar.h = (Integer) ej.d.a(ekVar);
                            break;
                        case 17:
                            aVar.i = (Long) ej.i.a(ekVar);
                            break;
                        case 18:
                            aVar.j = (Long) ej.i.a(ekVar);
                            break;
                        case 19:
                            aVar.k = (Long) ej.i.a(ekVar);
                            break;
                        case 20:
                            aVar.l = (String) ej.p.a(ekVar);
                            break;
                        case 21:
                            aVar.n = (Double) ej.o.a(ekVar);
                            break;
                        case 22:
                            aVar.p = (Double) ej.o.a(ekVar);
                            break;
                        case 23:
                            aVar.q = (String) ej.p.a(ekVar);
                            break;
                        case 24:
                            aVar.r = (Boolean) ej.c.a(ekVar);
                            break;
                        case 25:
                            aVar.B = (Boolean) ej.c.a(ekVar);
                            break;
                        case 26:
                            aVar.A.add(ej.p.a(ekVar));
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
