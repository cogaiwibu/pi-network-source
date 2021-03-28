package com.tapjoy.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.mediationsdk.utils.IronSourceConstants;

/* access modifiers changed from: package-private */
public final class hy extends ho implements gq {
    public static final bi a = new bi() {
        /* class com.tapjoy.internal.hy.AnonymousClass1 */

        @Override // com.tapjoy.internal.bi
        public final /* synthetic */ Object a(bn bnVar) {
            bnVar.h();
            String str = null;
            String str2 = null;
            String str3 = null;
            int i = 1;
            while (bnVar.j()) {
                String l = bnVar.l();
                if ("id".equals(l)) {
                    str = bnVar.m();
                } else if ("name".equals(l)) {
                    str2 = bnVar.m();
                } else if (FirebaseAnalytics.Param.QUANTITY.equals(l)) {
                    i = bnVar.r();
                } else if (IronSourceConstants.IRONSOURCE_BIDDING_TOKEN_KEY.equals(l)) {
                    str3 = bnVar.m();
                } else {
                    bnVar.s();
                }
            }
            bnVar.i();
            return new hy(str, str2, i, str3);
        }
    };
    private final String b;
    private final String c;
    private final int d;
    private final String e;

    hy(String str, String str2, int i, String str3) {
        this.b = str;
        this.c = str2;
        this.d = i;
        this.e = str3;
    }

    @Override // com.tapjoy.internal.gq
    public final String a() {
        return this.b;
    }

    @Override // com.tapjoy.internal.gq
    public final String b() {
        return this.c;
    }

    @Override // com.tapjoy.internal.gq
    public final int c() {
        return this.d;
    }

    @Override // com.tapjoy.internal.gq
    public final String d() {
        return this.e;
    }
}
