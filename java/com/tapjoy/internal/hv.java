package com.tapjoy.internal;

import android.graphics.Point;
import com.anythink.reactnativejs.utils.Const;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.net.URL;

public final class hv {
    public static final bi d = new bi() {
        /* class com.tapjoy.internal.hv.AnonymousClass1 */

        private static Point b(bn bnVar) {
            bnVar.h();
            Point point = null;
            while (bnVar.j()) {
                if ("offset".equals(bnVar.l())) {
                    bnVar.h();
                    int i = 0;
                    int i2 = 0;
                    while (bnVar.j()) {
                        String l = bnVar.l();
                        if (Const.X.equals(l)) {
                            i = bnVar.r();
                        } else if (Const.Y.equals(l)) {
                            i2 = bnVar.r();
                        } else {
                            bnVar.s();
                        }
                    }
                    bnVar.i();
                    point = new Point(i, i2);
                } else {
                    bnVar.s();
                }
            }
            bnVar.i();
            return point;
        }

        @Override // com.tapjoy.internal.bi
        public final /* synthetic */ Object a(bn bnVar) {
            bnVar.h();
            hx hxVar = null;
            Point point = null;
            Point point2 = null;
            while (bnVar.j()) {
                String l = bnVar.l();
                if (MessengerShareContentUtility.MEDIA_IMAGE.equals(l)) {
                    String m = bnVar.m();
                    if (!jq.c(m)) {
                        hxVar = new hx(new URL(m));
                    }
                } else if ("landscape".equals(l)) {
                    point = b(bnVar);
                } else if ("portrait".equals(l)) {
                    point2 = b(bnVar);
                } else {
                    bnVar.s();
                }
            }
            bnVar.i();
            return new hv(hxVar, point, point2);
        }
    };
    public final hx a;
    public final Point b;
    public final Point c;

    public hv(hx hxVar, Point point, Point point2) {
        this.a = hxVar;
        this.b = point;
        this.c = point2;
    }
}
