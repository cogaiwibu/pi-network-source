package com.facebook.ads.redexgen.X;

import android.os.Build;

public class W8 implements AbstractC01816i {
    public final /* synthetic */ WE A00;

    public W8(WE we) {
        this.A00 = we;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        if (Build.VERSION.SDK_INT < 23) {
            return this.A00.A08(EnumC01926t.A05);
        }
        if (this.A00.A00 == null) {
            return this.A00.A08(EnumC01926t.A07);
        }
        WE we = this.A00;
        return we.A05(we.A00.getPhoneCount());
    }
}
