package com.tapjoy.internal;

import android.graphics.Rect;
import com.tapjoy.TapjoyConstants;

public final class hs {
    public static final bi h = new bi() {
        /* class com.tapjoy.internal.hs.AnonymousClass1 */

        @Override // com.tapjoy.internal.bi
        public final /* synthetic */ Object a(bn bnVar) {
            bnVar.h();
            Rect rect = null;
            String str = null;
            String str2 = null;
            String str3 = null;
            ho hoVar = null;
            String str4 = "";
            boolean z = false;
            while (bnVar.j()) {
                String l = bnVar.l();
                if ("region".equals(l)) {
                    rect = (Rect) bj.b.a(bnVar);
                } else if ("value".equals(l)) {
                    str = bnVar.m();
                } else if (TapjoyConstants.TJC_FULLSCREEN_AD_DISMISS_URL.equals(l)) {
                    z = bnVar.n();
                } else if ("url".equals(l)) {
                    str4 = bnVar.m();
                } else if (TapjoyConstants.TJC_REDIRECT_URL.equals(l)) {
                    str2 = bnVar.b();
                } else if ("ad_content".equals(l)) {
                    str3 = bnVar.b();
                } else if (ho.a(l)) {
                    hoVar = ho.a(l, bnVar);
                } else {
                    bnVar.s();
                }
            }
            bnVar.i();
            return new hs(rect, str, z, str4, str2, str3, hoVar);
        }
    };
    public final Rect a;
    public final String b;
    public final boolean c;
    public final String d;
    public String e;
    public String f;
    public final gl g;

    hs(Rect rect, String str, boolean z, String str2, String str3, String str4, gl glVar) {
        this.a = rect;
        this.b = str;
        this.c = z;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = glVar;
    }
}
