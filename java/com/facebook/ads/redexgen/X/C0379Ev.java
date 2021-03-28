package com.facebook.ads.redexgen.X;

import android.view.ViewGroup;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.Ev  reason: case insensitive filesystem */
public final class C0379Ev extends RP {
    public final C0820Wh A00;

    public C0379Ev(AnonymousClass1U r1, List<C1007bZ> list, C0820Wh wh) {
        super(r1, list, wh);
        this.A00 = wh;
    }

    /* access modifiers changed from: private */
    /* renamed from: A01 */
    public final C0895Zf A07(ViewGroup viewGroup, int i) {
        return new C0895Zf(new MC(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.RP
    /* renamed from: A0I */
    public final void A0F(C0895Zf zf, int i) {
        super.A0F(zf, i);
        MC mc = (MC) zf.A0m();
        MR mr = (MR) mc.getImageCardView();
        mr.setImageDrawable(null);
        A0G(mr, i);
        C1007bZ bZVar = ((RP) this).A01.get(i);
        bZVar.A0x().A0D(this.A00);
        bZVar.A1H(mc, mc);
    }
}
