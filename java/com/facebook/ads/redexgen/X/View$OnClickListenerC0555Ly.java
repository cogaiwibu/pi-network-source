package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Ly  reason: case insensitive filesystem */
public class View$OnClickListenerC0555Ly implements View.OnClickListener {
    public final /* synthetic */ AnonymousClass1Q A00;
    public final /* synthetic */ JL A01;
    public final /* synthetic */ C0556Lz A02;
    public final /* synthetic */ M6 A03;
    public final /* synthetic */ String A04;

    public View$OnClickListenerC0555Ly(C0556Lz lz, JL jl, M6 m6, String str, AnonymousClass1Q r5) {
        this.A02 = lz;
        this.A01 = jl;
        this.A03 = m6;
        this.A04 = str;
        this.A00 = r5;
    }

    public final void onClick(View view) {
        if (!KU.A02(this)) {
            try {
                this.A01.A03(JK.A0A, null);
                if (AnonymousClass23.A0Q(this.A02.A02.A00(), true)) {
                    this.A03.A7n(this.A04, this.A00);
                } else if (!TextUtils.isEmpty(this.A00.A00())) {
                    Kw.A09(new Kw(), this.A02.A02, Uri.parse(this.A00.A00()), this.A04);
                }
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
