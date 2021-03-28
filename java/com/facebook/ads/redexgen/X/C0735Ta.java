package com.facebook.ads.redexgen.X;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.Ta  reason: case insensitive filesystem */
public final class C0735Ta extends AnonymousClass6V {
    public final List<C01786f> A00 = new ArrayList();

    public C0735Ta(Context context, C01725z r3) {
        super(context, r3);
    }

    public final void A03(C01786f r3) {
        if (!r3.A03().contains(EnumC01856m.A0B)) {
            this.A00.add(r3);
        }
    }

    public final void A04(EnumC01826j r2) {
        A02(r2, this.A00);
    }
}
