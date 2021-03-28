package com.facebook.ads.redexgen.X;

import android.content.DialogInterface;
import android.widget.EditText;

/* renamed from: com.facebook.ads.redexgen.X.Lr  reason: case insensitive filesystem */
public class DialogInterface$OnClickListenerC0548Lr implements DialogInterface.OnClickListener {
    public final /* synthetic */ EditText A00;
    public final /* synthetic */ C0910Zx A01;

    public DialogInterface$OnClickListenerC0548Lr(C0910Zx zx, EditText editText) {
        this.A01 = zx;
        this.A00 = editText;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.A01.A02.execute(new C0912Zz(this, dialogInterface));
    }
}
