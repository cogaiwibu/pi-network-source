package com.facebook.ads.redexgen.X;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class TZ extends AnonymousClass6V {
    public final List<C01786f> A00 = new ArrayList();

    public TZ(Context context, C01725z r3) {
        super(context, r3);
    }

    public final List<C01786f> A03() {
        return Collections.unmodifiableList(this.A00);
    }

    public final void A04(C01786f r3) {
        if (r3.A03().contains(EnumC01856m.A0B)) {
            this.A00.add(r3);
        }
    }

    public final void A05(EnumC01826j r2) {
        A02(r2, this.A00);
    }
}
