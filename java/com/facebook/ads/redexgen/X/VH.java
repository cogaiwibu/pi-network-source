package com.facebook.ads.redexgen.X;

import android.os.Build;

public class VH implements AbstractC01816i {
    public final /* synthetic */ VI A00;

    public VH(VI vi) {
        this.A00 = vi;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        if (Build.VERSION.SDK_INT < 16) {
            return this.A00.A08(EnumC01926t.A05);
        }
        if (this.A00.A00 == null) {
            return this.A00.A08(EnumC01926t.A07);
        }
        VI vi = this.A00;
        return vi.A0G(vi.A00.isKeyguardSecure());
    }
}
