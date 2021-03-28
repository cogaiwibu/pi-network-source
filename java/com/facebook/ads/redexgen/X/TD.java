package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdError;

public class TD extends KP {
    public final /* synthetic */ AnonymousClass5Q A00;

    public TD(AnonymousClass5Q r1) {
        this.A00 = r1;
    }

    @Override // com.facebook.ads.redexgen.X.KP
    public final void A04() {
        if (this.A00.A01 != null) {
            this.A00.A01.onError(this.A00.A03, AdError.SHOW_CALLED_BEFORE_LOAD_ERROR);
        }
    }
}
