package com.facebook.ads.redexgen.X;

import android.content.DialogInterface;
import java.util.Map;

public class NZ implements DialogInterface.OnClickListener {
    public final /* synthetic */ C0583Nb A00;
    public final /* synthetic */ String A01;
    public final /* synthetic */ Map A02;

    public NZ(C0583Nb nb, String str, Map map) {
        this.A00 = nb;
        this.A01 = str;
        this.A02 = map;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.A00.A04.A8L(this.A01, this.A02);
    }
}
