package com.tapjoy.internal;

import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class hr extends hq {
    public static final bi d = new bi() {
        /* class com.tapjoy.internal.hr.AnonymousClass1 */

        @Override // com.tapjoy.internal.bi
        public final /* synthetic */ Object a(bn bnVar) {
            return new hr(bnVar);
        }
    };
    public ArrayList a = new ArrayList();
    public Map b;
    public float c;

    public hr(bn bnVar) {
        bnVar.h();
        String str = null;
        String str2 = null;
        while (bnVar.j()) {
            String l = bnVar.l();
            if ("layouts".equals(l)) {
                bnVar.a(this.a, ia.d);
            } else if ("meta".equals(l)) {
                this.b = bnVar.d();
            } else if ("max_show_time".equals(l)) {
                this.c = (float) bnVar.p();
            } else if ("ad_content".equals(l)) {
                str = bnVar.b();
            } else if (TapjoyConstants.TJC_REDIRECT_URL.equals(l)) {
                str2 = bnVar.b();
            } else {
                bnVar.s();
            }
        }
        bnVar.i();
        ArrayList arrayList = this.a;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ia iaVar = (ia) it.next();
                if (iaVar.c != null) {
                    Iterator it2 = iaVar.c.iterator();
                    while (it2.hasNext()) {
                        hz hzVar = (hz) it2.next();
                        if (hzVar.i == null) {
                            hzVar.i = str;
                        }
                        if (hzVar.h == null) {
                            hzVar.h = str2;
                        }
                    }
                }
            }
        }
    }
}
