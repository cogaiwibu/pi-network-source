package com.facebook.ads.redexgen.X;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.Nullable;

public class TB implements AnonymousClass5J {
    public final /* synthetic */ ImageView A00;
    public final /* synthetic */ AnonymousClass5L A01;
    public final /* synthetic */ C1007bZ A02;

    public TB(AnonymousClass5L r1, ImageView imageView, C1007bZ bZVar) {
        this.A01 = r1;
        this.A00 = imageView;
        this.A02 = bZVar;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass5J
    public final void A9h(@Nullable Drawable drawable) {
        C1007bZ.A0Z(drawable, this.A00);
        this.A02.A1E(drawable);
    }
}
