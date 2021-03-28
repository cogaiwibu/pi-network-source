package com.tapjoy.internal;

/* access modifiers changed from: package-private */
public final class hw extends ho implements gp {
    public static final bi a = new bi() {
        /* class com.tapjoy.internal.hw.AnonymousClass1 */

        @Override // com.tapjoy.internal.bi
        public final /* synthetic */ Object a(bn bnVar) {
            bnVar.h();
            String str = "";
            String str2 = str;
            while (bnVar.j()) {
                String l = bnVar.l();
                if ("campaign_id".equals(l)) {
                    str = bnVar.c("");
                } else if ("product_id".equals(l)) {
                    str2 = bnVar.c("");
                } else {
                    bnVar.s();
                }
            }
            bnVar.i();
            return new hw(str, str2);
        }
    };
    private final String b;
    private final String c;

    hw(String str, String str2) {
        this.b = str;
        this.c = str2;
    }

    @Override // com.tapjoy.internal.gp
    public final String a() {
        return this.b;
    }

    @Override // com.tapjoy.internal.gp
    public final String b() {
        return this.c;
    }
}
