package com.facebook.ads.redexgen.X;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Ox  reason: case insensitive filesystem */
public class C0631Ox implements O4 {
    public final /* synthetic */ C0630Ow A00;

    public C0631Ox(C0630Ow ow) {
        this.A00 = ow;
    }

    @Override // com.facebook.ads.redexgen.X.O4
    public final void ABK(View view) {
        if (this.A00.A07) {
            this.A00.A05 = false;
        }
    }

    @Override // com.facebook.ads.redexgen.X.O4
    public final void ABL(View view) {
        AbstractC0670Qk qk = (AbstractC0670Qk) view;
        qk.A0g();
        if (this.A00.A07) {
            this.A00.A05 = true;
        }
        if (this.A00.A0E.A0b() && ((Integer) qk.getTag(-1593835536)).intValue() == 0) {
            this.A00.A0E.A0W();
        }
    }
}
