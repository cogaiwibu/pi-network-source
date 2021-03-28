package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public final class TY extends AnonymousClass6V implements AnonymousClass6Q {
    public AnonymousClass6F A00;
    public final C01725z A01;
    public final Map<Integer, C01786f> A02 = new HashMap();

    @SuppressLint({"UseSparseArrays"})
    public TY(Context context, C01725z r3) {
        super(context, r3);
        this.A01 = r3;
    }

    public final void A03(C01786f r3) {
        this.A02.put(Integer.valueOf(r3.A00()), r3);
    }

    public final void A04(EnumC01826j r3, Context context) {
        this.A00 = AnonymousClass6F.A00(context, this.A01);
        this.A00.A05(this.A02, r3);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass6Q
    public final void ABY() {
        AnonymousClass6F r0 = this.A00;
        if (r0 != null) {
            r0.A04();
        }
    }
}
