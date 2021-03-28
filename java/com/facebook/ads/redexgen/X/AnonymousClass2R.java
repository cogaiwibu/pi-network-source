package com.facebook.ads.redexgen.X;

import android.os.Build;

/* renamed from: com.facebook.ads.redexgen.X.2R  reason: invalid class name */
public final class AnonymousClass2R extends ES {
    public AnonymousClass2R(C0820Wh wh) {
        super(wh);
        setCarouselLayoutManager(wh);
    }

    @Override // com.facebook.ads.redexgen.X.ES
    public SW getLayoutManager() {
        return (SW) super.getLayoutManager();
    }

    private void setCarouselLayoutManager(C0820Wh wh) {
        SW sw = new SW(wh, 0, false);
        if (Build.VERSION.SDK_INT >= 24) {
            sw.A1W(true);
        }
        super.setLayoutManager(sw);
    }

    @Override // com.facebook.ads.redexgen.X.ES
    public void setLayoutManager(AnonymousClass4F r1) {
    }
}
