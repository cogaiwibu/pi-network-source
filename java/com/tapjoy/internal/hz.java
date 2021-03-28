package com.tapjoy.internal;

import com.anythink.reactnativejs.utils.Const;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tapjoy.TapjoyConstants;

public final class hz {
    public static final bi n = new bi() {
        /* class com.tapjoy.internal.hz.AnonymousClass1 */

        @Override // com.tapjoy.internal.bi
        public final /* synthetic */ Object a(bn bnVar) {
            return new hz(bnVar);
        }
    };
    public ib a;
    public ib b;
    public ib c;
    public ib d;
    public int e = 9;
    public int f = 10;
    public String g;
    public String h;
    public String i;
    public boolean j = false;
    public String k;
    public hx l;
    public hx m;

    public hz(bn bnVar) {
        bnVar.h();
        while (bnVar.j()) {
            String l2 = bnVar.l();
            if (Const.X.equals(l2)) {
                this.a = ib.a(bnVar.m());
            } else if (Const.Y.equals(l2)) {
                this.b = ib.a(bnVar.m());
            } else if ("width".equals(l2)) {
                this.c = ib.a(bnVar.m());
            } else if ("height".equals(l2)) {
                this.d = ib.a(bnVar.m());
            } else if ("url".equals(l2)) {
                this.g = bnVar.m();
            } else if (TapjoyConstants.TJC_REDIRECT_URL.equals(l2)) {
                this.h = bnVar.m();
            } else if ("ad_content".equals(l2)) {
                this.i = bnVar.m();
            } else if (TapjoyConstants.TJC_FULLSCREEN_AD_DISMISS_URL.equals(l2)) {
                this.j = bnVar.n();
            } else if ("value".equals(l2)) {
                this.k = bnVar.m();
            } else if (MessengerShareContentUtility.MEDIA_IMAGE.equals(l2)) {
                this.l = (hx) hx.e.a(bnVar);
            } else if ("image_clicked".equals(l2)) {
                this.m = (hx) hx.e.a(bnVar);
            } else if ("align".equals(l2)) {
                String m2 = bnVar.m();
                if ("left".equals(m2)) {
                    this.e = 9;
                } else if ("right".equals(m2)) {
                    this.e = 11;
                } else if ("center".equals(m2)) {
                    this.e = 14;
                } else {
                    bnVar.s();
                }
            } else if ("valign".equals(l2)) {
                String m3 = bnVar.m();
                if ("top".equals(m3)) {
                    this.f = 10;
                } else if ("middle".equals(m3)) {
                    this.f = 15;
                } else if ("bottom".equals(m3)) {
                    this.f = 12;
                } else {
                    bnVar.s();
                }
            } else {
                bnVar.s();
            }
        }
        bnVar.i();
    }
}
