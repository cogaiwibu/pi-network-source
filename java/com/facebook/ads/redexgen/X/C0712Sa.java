package com.facebook.ads.redexgen.X;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.Sa  reason: case insensitive filesystem */
public class C0712Sa implements AbstractC01264e {
    public final /* synthetic */ ES A00;

    public C0712Sa(ES es) {
        this.A00 = es;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01264e
    public final void ABn(AnonymousClass4X r2, AnonymousClass4A r3, AnonymousClass4A r4) {
        this.A00.A1o(r2, r3, r4);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01264e
    public final void ABp(AnonymousClass4X r2, @NonNull AnonymousClass4A r3, @Nullable AnonymousClass4A r4) {
        this.A00.A0r.A0d(r2);
        this.A00.A1p(r2, r3, r4);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01264e
    public final void ABr(AnonymousClass4X r2, @NonNull AnonymousClass4A r3, @NonNull AnonymousClass4A r4) {
        r2.A0a(false);
        if (this.A00.A0C) {
            if (this.A00.A05.A0L(r2, r2, r3, r4)) {
                this.A00.A1O();
            }
        } else if (this.A00.A05.A0K(r2, r3, r4)) {
            this.A00.A1O();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01264e
    public final void ADd(AnonymousClass4X r4) {
        this.A00.A06.A1E(r4.A0H, this.A00.A0r);
    }
}
