package com.facebook.ads.redexgen.X;

import android.os.Build;

/* renamed from: com.facebook.ads.redexgen.X.Vm  reason: case insensitive filesystem */
public class C0799Vm implements AbstractC01816i {
    public final /* synthetic */ C0801Vo A00;

    public C0799Vm(C0801Vo vo) {
        this.A00 = vo;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        if (Build.VERSION.SDK_INT < 23) {
            return this.A00.A08(EnumC01926t.A05);
        }
        if (this.A00.A00 == null) {
            return this.A00.A08(EnumC01926t.A07);
        }
        C0801Vo vo = this.A00;
        return vo.A0G(vo.A00.isDeviceIdleMode());
    }
}
