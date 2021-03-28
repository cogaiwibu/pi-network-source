package com.facebook.ads.redexgen.X;

import android.text.TextUtils;

public class Y4 extends AbstractC0640Pg {
    public final /* synthetic */ C0858Xt A00;

    public Y4(C0858Xt xt) {
        this.A00 = xt;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0640Pg
    public final void A04() {
        if (!this.A00.A0V.A08()) {
            this.A00.A0V.A06();
            if (!TextUtils.isEmpty(this.A00.A0P.A0Q())) {
                this.A00.A0S.A86(this.A00.A0P.A0Q(), new NU().A04(this.A00.A0f).A03(this.A00.A0V).A05(this.A00.A0P.A0S()).A06());
                this.A00.A0R.A0A().A2a();
            }
            if (this.A00.A05 != null) {
                this.A00.A05.A3s(EnumC0628Ou.A0A.A02());
            }
        }
    }
}
