package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import java.util.HashMap;

public final class VQ extends AnonymousClass6Z {
    public VQ(Context context, C01725z r2) {
        super(context, r2);
    }

    /* access modifiers changed from: private */
    @SuppressLint({"Nullable Dereference"})
    public AbstractC01966x A02(HashMap<String, VP> hashMap) {
        return new WY(SystemClock.elapsedRealtime(), A03(), hashMap, EnumC01956w.A0C);
    }

    public final AbstractC01816i A0H() {
        return new VO(this);
    }
}
