package com.facebook.ads.redexgen.X;

import android.text.TextUtils;

public class YB implements OW {
    public final /* synthetic */ YA A00;

    public YB(YA ya) {
        this.A00 = ya;
    }

    public /* synthetic */ YB(YA ya, ZV zv) {
        this(ya);
    }

    @Override // com.facebook.ads.redexgen.X.OW
    public final void A9G() {
        this.A00.A0V(true);
    }

    @Override // com.facebook.ads.redexgen.X.OW
    public final void A9i() {
        if (!TextUtils.isEmpty(this.A00.A09.A0Q())) {
            this.A00.A0D.A86(this.A00.A09.A0Q(), new NU().A04(this.A00.A06.getViewabilityChecker()).A03(this.A00.A06.getTouchDataRecorder()).A06());
            this.A00.A0C.A0A().A2a();
        }
        this.A00.A0H.A3s(this.A00.A0I.A6N());
    }

    @Override // com.facebook.ads.redexgen.X.OW
    public final void AA2() {
        this.A00.A0H.A3s(this.A00.A0I.A6C());
    }
}
