package com.facebook.ads.redexgen.X;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Nt  reason: case insensitive filesystem */
public class View$OnClickListenerC0601Nt implements View.OnClickListener {
    public final /* synthetic */ C02429a A00;

    public View$OnClickListenerC0601Nt(C02429a r1) {
        this.A00 = r1;
    }

    public final void onClick(View view) {
        if (!KU.A02(this)) {
            try {
                C02429a.A0H(this.A00, false);
                if (C02429a.A01(this.A00) != null) {
                    C0535Le.A0O(C02429a.A01(this.A00));
                }
                C0535Le.A0Q(C02429a.A03(this.A00), 0);
                C0535Le.A0Q(C02429a.A05(this.A00), 0);
                C0535Le.A0Q(this.A00.getAdDetailsView(), 0);
                C0535Le.A0M(C02429a.A00(this.A00));
                C02429a.A03(this.A00).A0Y(EnumC0626Os.A03, 14);
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
