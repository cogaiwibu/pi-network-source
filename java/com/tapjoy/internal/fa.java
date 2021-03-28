package com.tapjoy.internal;

import com.tapjoy.internal.eh;

public final class fa extends eh {
    public static final ej c = new b();
    public static final Integer d = 0;
    public static final Integer e = 0;
    public static final Integer f = 0;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final Integer m;
    public final Integer n;
    public final Integer o;
    public final String p;
    public final String q;
    public final String r;
    public final String s;
    public final String t;
    public final String u;
    public final String v;
    public final String w;
    public final String x;

    public fa(String str, String str2, String str3, String str4, String str5, String str6, Integer num, Integer num2, Integer num3, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, iu iuVar) {
        super(c, iuVar);
        this.g = str;
        this.h = str2;
        this.i = str3;
        this.j = str4;
        this.k = str5;
        this.l = str6;
        this.m = num;
        this.n = num2;
        this.o = num3;
        this.p = str7;
        this.q = str8;
        this.r = str9;
        this.s = str10;
        this.t = str11;
        this.u = str12;
        this.v = str13;
        this.w = str14;
        this.x = str15;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof fa)) {
            return false;
        }
        fa faVar = (fa) obj;
        return a().equals(faVar.a()) && eo.a(this.g, faVar.g) && eo.a(this.h, faVar.h) && eo.a(this.i, faVar.i) && eo.a(this.j, faVar.j) && eo.a(this.k, faVar.k) && eo.a(this.l, faVar.l) && eo.a(this.m, faVar.m) && eo.a(this.n, faVar.n) && eo.a(this.o, faVar.o) && eo.a(this.p, faVar.p) && eo.a(this.q, faVar.q) && eo.a(this.r, faVar.r) && eo.a(this.s, faVar.s) && eo.a(this.t, faVar.t) && eo.a(this.u, faVar.u) && eo.a(this.v, faVar.v) && eo.a(this.w, faVar.w) && eo.a(this.x, faVar.x);
    }

    public final int hashCode() {
        int i2 = this.b;
        if (i2 != 0) {
            return i2;
        }
        int hashCode = a().hashCode() * 37;
        String str = this.g;
        int i3 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.h;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.i;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.j;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.k;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.l;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 37;
        Integer num = this.m;
        int hashCode8 = (hashCode7 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.n;
        int hashCode9 = (hashCode8 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.o;
        int hashCode10 = (hashCode9 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str7 = this.p;
        int hashCode11 = (hashCode10 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.q;
        int hashCode12 = (hashCode11 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.r;
        int hashCode13 = (hashCode12 + (str9 != null ? str9.hashCode() : 0)) * 37;
        String str10 = this.s;
        int hashCode14 = (hashCode13 + (str10 != null ? str10.hashCode() : 0)) * 37;
        String str11 = this.t;
        int hashCode15 = (hashCode14 + (str11 != null ? str11.hashCode() : 0)) * 37;
        String str12 = this.u;
        int hashCode16 = (hashCode15 + (str12 != null ? str12.hashCode() : 0)) * 37;
        String str13 = this.v;
        int hashCode17 = (hashCode16 + (str13 != null ? str13.hashCode() : 0)) * 37;
        String str14 = this.w;
        int hashCode18 = (hashCode17 + (str14 != null ? str14.hashCode() : 0)) * 37;
        String str15 = this.x;
        if (str15 != null) {
            i3 = str15.hashCode();
        }
        int i4 = hashCode18 + i3;
        this.b = i4;
        return i4;
    }

    @Override // com.tapjoy.internal.eh
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.g != null) {
            sb.append(", mac=");
            sb.append(this.g);
        }
        if (this.h != null) {
            sb.append(", deviceId=");
            sb.append(this.h);
        }
        if (this.i != null) {
            sb.append(", deviceMaker=");
            sb.append(this.i);
        }
        if (this.j != null) {
            sb.append(", deviceModel=");
            sb.append(this.j);
        }
        if (this.k != null) {
            sb.append(", osName=");
            sb.append(this.k);
        }
        if (this.l != null) {
            sb.append(", osVer=");
            sb.append(this.l);
        }
        if (this.m != null) {
            sb.append(", displayD=");
            sb.append(this.m);
        }
        if (this.n != null) {
            sb.append(", displayW=");
            sb.append(this.n);
        }
        if (this.o != null) {
            sb.append(", displayH=");
            sb.append(this.o);
        }
        if (this.p != null) {
            sb.append(", locale=");
            sb.append(this.p);
        }
        if (this.q != null) {
            sb.append(", timezone=");
            sb.append(this.q);
        }
        if (this.r != null) {
            sb.append(", pkgId=");
            sb.append(this.r);
        }
        if (this.s != null) {
            sb.append(", pkgSign=");
            sb.append(this.s);
        }
        if (this.t != null) {
            sb.append(", sdk=");
            sb.append(this.t);
        }
        if (this.u != null) {
            sb.append(", countrySim=");
            sb.append(this.u);
        }
        if (this.v != null) {
            sb.append(", countryNet=");
            sb.append(this.v);
        }
        if (this.w != null) {
            sb.append(", imei=");
            sb.append(this.w);
        }
        if (this.x != null) {
            sb.append(", androidId=");
            sb.append(this.x);
        }
        StringBuilder replace = sb.replace(0, 2, "Info{");
        replace.append('}');
        return replace.toString();
    }

    public static final class a extends eh.a {
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public Integer i;
        public Integer j;
        public Integer k;
        public String l;
        public String m;
        public String n;
        public String o;
        public String p;
        public String q;
        public String r;
        public String s;
        public String t;

        public final fa b() {
            return new fa(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, super.a());
        }
    }

    static final class b extends ej {
        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ int a(Object obj) {
            fa faVar = (fa) obj;
            int i = 0;
            int a = (faVar.g != null ? ej.p.a(1, faVar.g) : 0) + (faVar.h != null ? ej.p.a(2, faVar.h) : 0) + (faVar.i != null ? ej.p.a(3, faVar.i) : 0) + (faVar.j != null ? ej.p.a(4, faVar.j) : 0) + (faVar.k != null ? ej.p.a(5, faVar.k) : 0) + (faVar.l != null ? ej.p.a(6, faVar.l) : 0) + (faVar.m != null ? ej.d.a(7, faVar.m) : 0) + (faVar.n != null ? ej.d.a(8, faVar.n) : 0) + (faVar.o != null ? ej.d.a(9, faVar.o) : 0) + (faVar.p != null ? ej.p.a(10, faVar.p) : 0) + (faVar.q != null ? ej.p.a(11, faVar.q) : 0) + (faVar.r != null ? ej.p.a(12, faVar.r) : 0) + (faVar.s != null ? ej.p.a(13, faVar.s) : 0) + (faVar.t != null ? ej.p.a(14, faVar.t) : 0) + (faVar.u != null ? ej.p.a(15, faVar.u) : 0) + (faVar.v != null ? ej.p.a(16, faVar.v) : 0) + (faVar.w != null ? ej.p.a(17, faVar.w) : 0);
            if (faVar.x != null) {
                i = ej.p.a(18, faVar.x);
            }
            return a + i + faVar.a().c();
        }

        @Override // com.tapjoy.internal.ej
        public final /* bridge */ /* synthetic */ void a(el elVar, Object obj) {
            fa faVar = (fa) obj;
            if (faVar.g != null) {
                ej.p.a(elVar, 1, faVar.g);
            }
            if (faVar.h != null) {
                ej.p.a(elVar, 2, faVar.h);
            }
            if (faVar.i != null) {
                ej.p.a(elVar, 3, faVar.i);
            }
            if (faVar.j != null) {
                ej.p.a(elVar, 4, faVar.j);
            }
            if (faVar.k != null) {
                ej.p.a(elVar, 5, faVar.k);
            }
            if (faVar.l != null) {
                ej.p.a(elVar, 6, faVar.l);
            }
            if (faVar.m != null) {
                ej.d.a(elVar, 7, faVar.m);
            }
            if (faVar.n != null) {
                ej.d.a(elVar, 8, faVar.n);
            }
            if (faVar.o != null) {
                ej.d.a(elVar, 9, faVar.o);
            }
            if (faVar.p != null) {
                ej.p.a(elVar, 10, faVar.p);
            }
            if (faVar.q != null) {
                ej.p.a(elVar, 11, faVar.q);
            }
            if (faVar.r != null) {
                ej.p.a(elVar, 12, faVar.r);
            }
            if (faVar.s != null) {
                ej.p.a(elVar, 13, faVar.s);
            }
            if (faVar.t != null) {
                ej.p.a(elVar, 14, faVar.t);
            }
            if (faVar.u != null) {
                ej.p.a(elVar, 15, faVar.u);
            }
            if (faVar.v != null) {
                ej.p.a(elVar, 16, faVar.v);
            }
            if (faVar.w != null) {
                ej.p.a(elVar, 17, faVar.w);
            }
            if (faVar.x != null) {
                ej.p.a(elVar, 18, faVar.x);
            }
            elVar.a(faVar.a());
        }

        b() {
            super(eg.LENGTH_DELIMITED, fa.class);
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
                            aVar.c = (String) ej.p.a(ekVar);
                            break;
                        case 2:
                            aVar.d = (String) ej.p.a(ekVar);
                            break;
                        case 3:
                            aVar.e = (String) ej.p.a(ekVar);
                            break;
                        case 4:
                            aVar.f = (String) ej.p.a(ekVar);
                            break;
                        case 5:
                            aVar.g = (String) ej.p.a(ekVar);
                            break;
                        case 6:
                            aVar.h = (String) ej.p.a(ekVar);
                            break;
                        case 7:
                            aVar.i = (Integer) ej.d.a(ekVar);
                            break;
                        case 8:
                            aVar.j = (Integer) ej.d.a(ekVar);
                            break;
                        case 9:
                            aVar.k = (Integer) ej.d.a(ekVar);
                            break;
                        case 10:
                            aVar.l = (String) ej.p.a(ekVar);
                            break;
                        case 11:
                            aVar.m = (String) ej.p.a(ekVar);
                            break;
                        case 12:
                            aVar.n = (String) ej.p.a(ekVar);
                            break;
                        case 13:
                            aVar.o = (String) ej.p.a(ekVar);
                            break;
                        case 14:
                            aVar.p = (String) ej.p.a(ekVar);
                            break;
                        case 15:
                            aVar.q = (String) ej.p.a(ekVar);
                            break;
                        case 16:
                            aVar.r = (String) ej.p.a(ekVar);
                            break;
                        case 17:
                            aVar.s = (String) ej.p.a(ekVar);
                            break;
                        case 18:
                            aVar.t = (String) ej.p.a(ekVar);
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
