package com.facebook.ads.redexgen.X;

import android.os.Build;

/* renamed from: com.facebook.ads.redexgen.X.Vl  reason: case insensitive filesystem */
public class C0798Vl implements AbstractC01816i {
    public final /* synthetic */ C0801Vo A00;

    public C0798Vl(C0801Vo vo) {
        this.A00 = vo;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        if (this.A00.A00 == null || Build.VERSION.SDK_INT < 7) {
            return this.A00.A08(EnumC01926t.A07);
        }
        C0801Vo vo = this.A00;
        return vo.A0G(vo.A04());
    }
}
