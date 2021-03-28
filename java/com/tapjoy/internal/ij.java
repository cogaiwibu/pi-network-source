package com.tapjoy.internal;

import android.content.Context;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import java.util.List;
import java.util.Map;

public final class ij extends ii {
    public final String c;
    public boolean d = false;
    private final gz e;
    private final fa f;
    private final eu g;
    private final fh h;
    private Context i;

    @Override // com.tapjoy.internal.ca
    public final String c() {
        return IronSourceConstants.EVENTS_PLACEMENT_NAME;
    }

    public ij(gz gzVar, fa faVar, eu euVar, fh fhVar, String str, Context context) {
        this.e = gzVar;
        this.f = faVar;
        this.g = euVar;
        this.h = fhVar;
        this.c = str;
        this.i = context;
    }

    @Override // com.tapjoy.internal.ca, com.tapjoy.internal.ii
    public final Map e() {
        Map e2 = super.e();
        e2.put(TJAdUnitConstants.String.VIDEO_INFO, new bm(hp.a(this.f)));
        e2.put(TapjoyConstants.TJC_APP_PLACEMENT, new bm(hp.a(this.g)));
        e2.put("user", new bm(hp.a(this.h)));
        e2.put(IronSourceConstants.EVENTS_PLACEMENT_NAME, this.c);
        return e2;
    }

    public static class a {
        public hg a;
        public final List b;

        public a(hg hgVar, List list) {
            this.a = hgVar;
            this.b = list;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tapjoy.internal.bz, com.tapjoy.internal.ii
    public final /* synthetic */ Object a(bn bnVar) {
        bnVar.h();
        hu huVar = null;
        hr hrVar = null;
        List list = null;
        while (bnVar.j()) {
            String l = bnVar.l();
            if (IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE.equals(l)) {
                huVar = (hu) bnVar.a(hu.n);
            } else if ("contextual_button".equals(l)) {
                hrVar = (hr) bnVar.a(hr.d);
            } else if ("enabled_placements".equals(l)) {
                list = bnVar.c();
            } else {
                bnVar.s();
            }
        }
        bnVar.i();
        if (huVar != null && (huVar.a() || huVar.b())) {
            return new a(new he(this.e, this.c, huVar, this.i), list);
        }
        if (hrVar != null) {
            return new a(new gv(this.e, this.c, hrVar, this.i), list);
        }
        return new a(new hf(), list);
    }

    /* access modifiers changed from: protected */
    @Override // com.tapjoy.internal.ca, com.tapjoy.internal.ii
    public final /* synthetic */ Object f() {
        a aVar = (a) super.f();
        if (!(aVar.a instanceof hf)) {
            aVar.a.b();
            if (!aVar.a.c()) {
                aVar.a = new hf();
            }
        }
        return aVar;
    }
}
