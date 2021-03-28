package com.tapjoy.internal;

import com.tapjoy.internal.eh;

public final class fd extends eh {
    public static final ej c = new b();
    public static final Integer d = 1;
    public static final Double e = Double.valueOf(0.0d);
    public static final Integer f = 0;
    public static final Long g = 0L;
    public final String h;
    public final Integer i;
    public final Double j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final Integer p;
    public final Long q;
    public final String r;
    public final String s;
    public final String t;
    public final String u;

    public fd(String str, Integer num, Double d2, String str2, String str3, String str4, String str5, String str6, Integer num2, Long l2, String str7, String str8, String str9, String str10, iu iuVar) {
        super(c, iuVar);
        this.h = str;
        this.i = num;
        this.j = d2;
        this.k = str2;
        this.l = str3;
        this.m = str4;
        this.n = str5;
        this.o = str6;
        this.p = num2;
        this.q = l2;
        this.r = str7;
        this.s = str8;
        this.t = str9;
        this.u = str10;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof fd)) {
            return false;
        }
        fd fdVar = (fd) obj;
        return a().equals(fdVar.a()) && this.h.equals(fdVar.h) && eo.a(this.i, fdVar.i) && eo.a(this.j, fdVar.j) && eo.a(this.k, fdVar.k) && eo.a(this.l, fdVar.l) && eo.a(this.m, fdVar.m) && eo.a(this.n, fdVar.n) && eo.a(this.o, fdVar.o) && eo.a(this.p, fdVar.p) && eo.a(this.q, fdVar.q) && eo.a(this.r, fdVar.r) && eo.a(this.s, fdVar.s) && eo.a(this.t, fdVar.t) && eo.a(this.u, fdVar.u);
    }

    public final int hashCode() {
        int i2 = this.b;
        if (i2 != 0) {
            return i2;
        }
        int hashCode = ((a().hashCode() * 37) + this.h.hashCode()) * 37;
        Integer num = this.i;
        int i3 = 0;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Double d2 = this.j;
        int hashCode3 = (hashCode2 + (d2 != null ? d2.hashCode() : 0)) * 37;
        String str = this.k;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.l;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.m;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.n;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.o;
        int hashCode8 = (hashCode7 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Integer num2 = this.p;
        int hashCode9 = (hashCode8 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l2 = this.q;
        int hashCode10 = (hashCode9 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str6 = this.r;
        int hashCode11 = (hashCode10 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.s;
        int hashCode12 = (hashCode11 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.t;
        int hashCode13 = (hashCode12 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.u;
        if (str9 != null) {
            i3 = str9.hashCode();
        }
        int i4 = hashCode13 + i3;
        this.b = i4;
        return i4;
    }

    @Override // com.tapjoy.internal.eh
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", productId=");
        sb.append(this.h);
        if (this.i != null) {
            sb.append(", productQuantity=");
            sb.append(this.i);
        }
        if (this.j != null) {
            sb.append(", productPrice=");
            sb.append(this.j);
        }
        if (this.k != null) {
            sb.append(", productPriceCurrency=");
            sb.append(this.k);
        }
        if (this.l != null) {
            sb.append(", productType=");
            sb.append(this.l);
        }
        if (this.m != null) {
            sb.append(", productTitle=");
            sb.append(this.m);
        }
        if (this.n != null) {
            sb.append(", productDescription=");
            sb.append(this.n);
        }
        if (this.o != null) {
            sb.append(", transactionId=");
            sb.append(this.o);
        }
        if (this.p != null) {
            sb.append(", transactionState=");
            sb.append(this.p);
        }
        if (this.q != null) {
            sb.append(", transactionDate=");
            sb.append(this.q);
        }
        if (this.r != null) {
            sb.append(", campaignId=");
            sb.append(this.r);
        }
        if (this.s != null) {
            sb.append(", currencyPrice=");
            sb.append(this.s);
        }
        if (this.t != null) {
            sb.append(", receipt=");
            sb.append(this.t);
        }
        if (this.u != null) {
            sb.append(", signature=");
            sb.append(this.u);
        }
        StringBuilder replace = sb.replace(0, 2, "Purchase{");
        replace.append('}');
        return replace.toString();
    }

    public static final class a extends eh.a {
        public String c;
        public Integer d;
        public Double e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public Integer k;
        public Long l;
        public String m;
        public String n;
        public String o;
        public String p;

        public final fd b() {
            String str = this.c;
            if (str != null) {
                return new fd(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, super.a());
            }
            throw eo.a(str, "productId");
        }
    }

    static final class b extends ej {
        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ int a(Object obj) {
            fd fdVar = (fd) obj;
            int i = 0;
            int a = ej.p.a(1, fdVar.h) + (fdVar.i != null ? ej.d.a(2, fdVar.i) : 0) + (fdVar.j != null ? ej.o.a(3, fdVar.j) : 0) + (fdVar.k != null ? ej.p.a(4, fdVar.k) : 0) + (fdVar.l != null ? ej.p.a(5, fdVar.l) : 0) + (fdVar.m != null ? ej.p.a(6, fdVar.m) : 0) + (fdVar.n != null ? ej.p.a(7, fdVar.n) : 0) + (fdVar.o != null ? ej.p.a(8, fdVar.o) : 0) + (fdVar.p != null ? ej.d.a(9, fdVar.p) : 0) + (fdVar.q != null ? ej.i.a(10, fdVar.q) : 0) + (fdVar.r != null ? ej.p.a(11, fdVar.r) : 0) + (fdVar.s != null ? ej.p.a(12, fdVar.s) : 0) + (fdVar.t != null ? ej.p.a(13, fdVar.t) : 0);
            if (fdVar.u != null) {
                i = ej.p.a(14, fdVar.u);
            }
            return a + i + fdVar.a().c();
        }

        @Override // com.tapjoy.internal.ej
        public final /* bridge */ /* synthetic */ void a(el elVar, Object obj) {
            fd fdVar = (fd) obj;
            ej.p.a(elVar, 1, fdVar.h);
            if (fdVar.i != null) {
                ej.d.a(elVar, 2, fdVar.i);
            }
            if (fdVar.j != null) {
                ej.o.a(elVar, 3, fdVar.j);
            }
            if (fdVar.k != null) {
                ej.p.a(elVar, 4, fdVar.k);
            }
            if (fdVar.l != null) {
                ej.p.a(elVar, 5, fdVar.l);
            }
            if (fdVar.m != null) {
                ej.p.a(elVar, 6, fdVar.m);
            }
            if (fdVar.n != null) {
                ej.p.a(elVar, 7, fdVar.n);
            }
            if (fdVar.o != null) {
                ej.p.a(elVar, 8, fdVar.o);
            }
            if (fdVar.p != null) {
                ej.d.a(elVar, 9, fdVar.p);
            }
            if (fdVar.q != null) {
                ej.i.a(elVar, 10, fdVar.q);
            }
            if (fdVar.r != null) {
                ej.p.a(elVar, 11, fdVar.r);
            }
            if (fdVar.s != null) {
                ej.p.a(elVar, 12, fdVar.s);
            }
            if (fdVar.t != null) {
                ej.p.a(elVar, 13, fdVar.t);
            }
            if (fdVar.u != null) {
                ej.p.a(elVar, 14, fdVar.u);
            }
            elVar.a(fdVar.a());
        }

        b() {
            super(eg.LENGTH_DELIMITED, fd.class);
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
                            aVar.d = (Integer) ej.d.a(ekVar);
                            break;
                        case 3:
                            aVar.e = (Double) ej.o.a(ekVar);
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
                            aVar.i = (String) ej.p.a(ekVar);
                            break;
                        case 8:
                            aVar.j = (String) ej.p.a(ekVar);
                            break;
                        case 9:
                            aVar.k = (Integer) ej.d.a(ekVar);
                            break;
                        case 10:
                            aVar.l = (Long) ej.i.a(ekVar);
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
