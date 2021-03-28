package com.tapjoy.internal;

import android.graphics.PointF;
import java.util.ArrayList;

public final class ia {
    public static final bi d = new bi() {
        /* class com.tapjoy.internal.ia.AnonymousClass1 */

        @Override // com.tapjoy.internal.bi
        public final /* synthetic */ Object a(bn bnVar) {
            return new ia(bnVar);
        }
    };
    public aa a = aa.UNSPECIFIED;
    public PointF b;
    public ArrayList c = new ArrayList();

    public ia(bn bnVar) {
        bnVar.h();
        while (bnVar.j()) {
            String l = bnVar.l();
            if ("buttons".equals(l)) {
                if (bnVar.k() == bs.BEGIN_ARRAY) {
                    bnVar.a(this.c, hz.n);
                } else {
                    bnVar.s();
                }
            } else if ("window_aspect_ratio".equals(l)) {
                if (bnVar.a()) {
                    PointF pointF = new PointF();
                    bnVar.h();
                    while (bnVar.j()) {
                        String l2 = bnVar.l();
                        if ("width".equals(l2)) {
                            pointF.x = (float) bnVar.p();
                        } else if ("height".equals(l2)) {
                            pointF.y = (float) bnVar.p();
                        } else {
                            bnVar.s();
                        }
                    }
                    bnVar.i();
                    if (!(pointF.x == 0.0f || pointF.y == 0.0f)) {
                        this.b = pointF;
                    }
                } else {
                    bnVar.s();
                }
            } else if ("orientation".equals(l)) {
                String m = bnVar.m();
                if ("landscape".equals(m)) {
                    this.a = aa.LANDSCAPE;
                } else if ("portrait".equals(m)) {
                    this.a = aa.PORTRAIT;
                }
            } else {
                bnVar.s();
            }
        }
        bnVar.i();
    }
}
