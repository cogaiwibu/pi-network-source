package com.tapjoy.internal;

import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import java.util.Map;

public final class il extends ii {
    private final fa c;
    private final eu d;
    private final fh e;
    private final String f;

    @Override // com.tapjoy.internal.ca
    public final String c() {
        return "api/v1/tokens";
    }

    private il(fa faVar, eu euVar, fh fhVar, String str) {
        this.c = faVar;
        this.d = euVar;
        this.e = fhVar;
        this.f = str;
    }

    public il(fb fbVar, String str) {
        this(fbVar.d, fbVar.e, fbVar.f, str);
    }

    @Override // com.tapjoy.internal.ca, com.tapjoy.internal.ii
    public final Map e() {
        Map e2 = super.e();
        e2.put(TJAdUnitConstants.String.VIDEO_INFO, new bm(hp.a(this.c)));
        e2.put(TapjoyConstants.TJC_APP_PLACEMENT, new bm(hp.a(this.d)));
        e2.put("user", new bm(hp.a(this.e)));
        if (!al.a(this.f)) {
            e2.put("push_token", this.f);
        }
        return e2;
    }
}
