package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import java.util.Map;

public class OL extends AbstractC0640Pg {
    public final /* synthetic */ JE A00;
    public final /* synthetic */ LX A01;
    public final /* synthetic */ OQ A02;
    public final /* synthetic */ C0592Nk A03;
    public final /* synthetic */ String A04;
    public final /* synthetic */ Map A05;

    public OL(C0592Nk nk, String str, OQ oq, JE je, Map map, LX lx) {
        this.A03 = nk;
        this.A04 = str;
        this.A02 = oq;
        this.A00 = je;
        this.A05 = map;
        this.A01 = lx;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0640Pg
    public final void A04() {
        if (!C0592Nk.A04(this.A03).A0b() && !TextUtils.isEmpty(this.A04) && !C0592Nk.A03(this.A03).get(this.A02.A02())) {
            this.A00.A86(this.A04, new NU(this.A05).A04(C0592Nk.A05(this.A03)).A03(this.A01).A06());
            C0592Nk.A03(this.A03).put(this.A02.A02(), true);
        }
    }
}
