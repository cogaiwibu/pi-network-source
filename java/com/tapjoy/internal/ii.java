package com.tapjoy.internal;

import com.ironsource.eventsTracker.NativeEventsConstants;
import com.ironsource.sdk.constants.Events;
import com.tapjoy.TapjoyConstants;
import java.util.Map;
import javax.annotation.Nullable;

public abstract class ii extends bz {
    @Override // com.tapjoy.internal.ca
    public final String b() {
        return NativeEventsConstants.HTTP_METHOD_POST;
    }

    @Override // com.tapjoy.internal.ca
    public final String d() {
        return Events.APP_JSON;
    }

    @Override // com.tapjoy.internal.ca
    public Map e() {
        Map e = super.e();
        gz a = gz.a();
        e.put("sdk_ver", a.m + "/Android");
        e.put(TapjoyConstants.TJC_API_KEY, a.l);
        if (gw.a) {
            e.put("debug", true);
        }
        return e;
    }

    /* access modifiers changed from: protected */
    @Override // com.tapjoy.internal.ca
    public Object f() {
        try {
            return super.f();
        } catch (Exception e) {
            throw e;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tapjoy.internal.bz
    @Nullable
    public Object a(bn bnVar) {
        bnVar.s();
        return null;
    }
}
