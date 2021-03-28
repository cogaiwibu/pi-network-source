package com.facebook.ads.redexgen.X;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.HashMap;

public abstract class NX extends LinearLayout {
    public static final int A05 = ((int) (C0535Le.A01 * 8.0f));
    public static final LinearLayout.LayoutParams A06 = new LinearLayout.LayoutParams(-2, -2);
    public final int A00;
    public final RelativeLayout A01;
    public final C0820Wh A02;
    public final View$OnClickListenerC0827Wo A03;
    public final C0587Nf A04;

    public abstract void A0D(int i);

    public abstract void A0E(boolean z);

    public NX(C0820Wh wh, int i, AnonymousClass1H r14, String str, JE je, M6 m6, C0641Ph ph, LX lx) {
        super(wh);
        C0535Le.A0N(this);
        this.A02 = wh;
        this.A00 = i;
        this.A04 = new C0587Nf(wh);
        C0535Le.A0P(this.A04, 0);
        C0535Le.A0N(this.A04);
        this.A03 = new View$OnClickListenerC0827Wo(wh, str, r14, je, m6, ph, lx);
        C0535Le.A0J(1001, this.A03);
        this.A01 = new RelativeLayout(wh);
        this.A01.setLayoutParams(A06);
        C0535Le.A0N(this.A01);
    }

    public int A09(int i) {
        return 0;
    }

    public RelativeLayout.LayoutParams A0B(View view) {
        return new RelativeLayout.LayoutParams(-1, -2);
    }

    public RelativeLayout.LayoutParams A0C(View view) {
        return new RelativeLayout.LayoutParams(-1, -2);
    }

    public final View$OnClickListenerC0827Wo getCTAButton() {
        return this.A03;
    }

    public View getExpandableLayout() {
        return null;
    }

    @VisibleForTesting
    public final ImageView getIconView() {
        return this.A04;
    }

    public void setInfo(AnonymousClass1G r4, AnonymousClass1I r5, String str, String str2, @Nullable AbstractC0582Na na) {
        this.A03.setCta(r5, str, new HashMap(), na);
        AsyncTaskC0831Ws ws = new AsyncTaskC0831Ws(this.A04, this.A02);
        int i = this.A00;
        ws.A06(i, i).A08(str2);
    }
}
