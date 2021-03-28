package com.facebook.ads.redexgen.X;

import android.content.DialogInterface;

/* renamed from: com.facebook.ads.redexgen.X.Zz  reason: case insensitive filesystem */
public class C0912Zz extends AbstractRunnableC0510Kc {
    public static String[] A02;
    public final /* synthetic */ DialogInterface A00;
    public final /* synthetic */ DialogInterface$OnClickListenerC0548Lr A01;

    static {
        A00();
    }

    public static void A00() {
        A02 = new String[]{"r", "tRYI", "7UJuVMqBcP2QEoAe5I9ReZPElv0qEy55", "leQvAr8Bdm", "IrxDcEzjLLQBxw", "x58zC904VQqUCNnuzCjkyAfM", "58DZzAqOGTGaE", "1xO3"};
    }

    public C0912Zz(DialogInterface$OnClickListenerC0548Lr lr, DialogInterface dialogInterface) {
        this.A01 = lr;
        this.A00 = dialogInterface;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0510Kc
    public final void A07() {
        if (this.A01.A01.A01 != null) {
            this.A01.A01.A01.ABd(KJ.A01(), new Q0().A06(this.A01.A01.A03(this.A01.A00.getText().toString())).A09());
        }
        DialogInterface dialogInterface = this.A00;
        if (A02[6].length() != 13) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[6] = "1hADnGgCLejuT";
        strArr[6] = "1hADnGgCLejuT";
        dialogInterface.cancel();
    }
}
