package com.tapjoy.internal;

public final class e {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public long g;

    public e(String str) {
        bn b2 = bn.b(str);
        b2.h();
        while (b2.j()) {
            String l = b2.l();
            if ("productId".equals(l)) {
                this.a = b2.m();
            } else if ("type".equals(l)) {
                this.b = b2.m();
            } else if ("price".equals(l)) {
                this.c = b2.m();
            } else if ("title".equals(l)) {
                this.d = b2.m();
            } else if ("description".equals(l)) {
                this.e = b2.m();
            } else if ("price_currency_code".equals(l)) {
                this.f = b2.m();
            } else if ("price_amount_micros".equals(l)) {
                this.g = b2.q();
            } else {
                b2.s();
            }
        }
        b2.i();
    }
}
