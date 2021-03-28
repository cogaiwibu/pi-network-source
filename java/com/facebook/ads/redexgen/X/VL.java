package com.facebook.ads.redexgen.X;

import android.os.Build;
import java.util.Locale;

public class VL implements AbstractC01816i {
    public final /* synthetic */ VN A00;

    public VL(VN vn) {
        this.A00 = vn;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        if (Build.VERSION.SDK_INT < 21) {
            return this.A00.A08(EnumC01926t.A05);
        }
        return this.A00.A09(Locale.getDefault().getScript());
    }
}
