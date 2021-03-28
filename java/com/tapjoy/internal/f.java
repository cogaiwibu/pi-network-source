package com.tapjoy.internal;

import com.google.firebase.messaging.Constants;

public final class f {
    public String a;
    public String b;
    public String c;
    public long d;
    public int e;
    public String f;
    public String g;

    public f(String str) {
        bn b2 = bn.b(str);
        b2.h();
        while (b2.j()) {
            String l = b2.l();
            if ("orderId".equals(l)) {
                this.a = b2.m();
            } else if (Constants.FirelogAnalytics.PARAM_PACKAGE_NAME.equals(l)) {
                this.b = b2.m();
            } else if ("productId".equals(l)) {
                this.c = b2.m();
            } else if ("purchaseTime".equals(l)) {
                this.d = b2.q();
            } else if ("purchaseState".equals(l)) {
                this.e = b2.r();
            } else if ("developerPayload".equals(l)) {
                this.f = b2.m();
            } else if ("purchaseToken".equals(l)) {
                this.g = b2.m();
            } else {
                b2.s();
            }
        }
        b2.i();
    }
}
