package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public final class OP extends LinearLayout {
    public static final int A04 = ((int) (C0535Le.A01 * 32.0f));
    public static final int A05 = ((int) (C0535Le.A01 * 8.0f));
    public TextView A00;
    public TextView A01;
    public C0587Nf A02;
    public final C0820Wh A03;

    public OP(C0820Wh wh) {
        super(wh);
        this.A03 = wh;
        A00(wh);
    }

    private final void A00(C0820Wh wh) {
        setGravity(16);
        this.A02 = new C0587Nf(wh);
        this.A02.setFullCircleCorners(true);
        int i = A04;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
        layoutParams.setMargins(0, 0, A05, 0);
        addView(this.A02, layoutParams);
        LinearLayout linearLayout = new LinearLayout(wh);
        linearLayout.setOrientation(1);
        this.A00 = new TextView(wh);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        C0535Le.A0b(this.A00, true, 16);
        this.A00.setEllipsize(TextUtils.TruncateAt.END);
        this.A00.setSingleLine(true);
        this.A01 = new TextView(wh);
        C0535Le.A0b(this.A01, false, 14);
        linearLayout.addView(this.A00);
        linearLayout.addView(this.A01);
        addView(linearLayout, layoutParams2);
    }

    public final void A01(int i, int i2) {
        this.A00.setTextColor(i);
        this.A01.setTextColor(i2);
    }

    public void setPageDetails(AnonymousClass1Q r4) {
        AsyncTaskC0831Ws ws = new AsyncTaskC0831Ws(this.A02, this.A03);
        int i = A04;
        ws.A06(i, i);
        ws.A08(r4.A01());
        this.A00.setText(r4.A02());
        this.A01.setText(r4.A03());
    }
}
