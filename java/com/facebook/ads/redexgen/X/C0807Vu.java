package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.Vu  reason: case insensitive filesystem */
public final class C0807Vu extends AnonymousClass6Z {
    public final Context A00;

    public C0807Vu(Context context, C01725z r2) {
        super(context, r2);
        this.A00 = context;
    }

    /* access modifiers changed from: private */
    @SuppressLint({"Nullable Dereference"})
    public AbstractC01966x A03(HashMap<String, C0806Vt> hashMap) {
        return new WY(SystemClock.elapsedRealtime(), A03(), hashMap, EnumC01956w.A0C);
    }

    public final AbstractC01816i A0H(List<C01806h> list, EnumC01776e r3) {
        return new C0805Vs(this, list, r3);
    }
}
