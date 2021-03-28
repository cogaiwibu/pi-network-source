package com.facebook.ads.redexgen.X;

import android.content.Context;

/* renamed from: com.facebook.ads.redexgen.X.ab  reason: case insensitive filesystem */
public final class C0950ab implements HL {
    public final Context A00;
    public final HL A01;
    public final AbstractC0441Hh<? super HM> A02;

    public C0950ab(Context context, AbstractC0441Hh<? super HM> hh, HL hl) {
        this.A00 = context.getApplicationContext();
        this.A02 = hh;
        this.A01 = hl;
    }

    public C0950ab(Context context, String str, AbstractC0441Hh<? super HM> hh) {
        this(context, hh, (HL) new AnonymousClass2Z(str, hh));
    }

    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final C0949aa A4D() {
        return new C0949aa(this.A00, this.A02, this.A01.A4D());
    }
}
