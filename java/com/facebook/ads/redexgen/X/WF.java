package com.facebook.ads.redexgen.X;

import android.icu.util.TimeZone;
import android.os.Build;

public class WF implements AbstractC01816i {
    public final /* synthetic */ WI A00;

    public WF(WI wi) {
        this.A00 = wi;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        if (Build.VERSION.SDK_INT < 24) {
            return this.A00.A08(EnumC01926t.A05);
        }
        return this.A00.A09(TimeZone.getDefault().getID());
    }
}
