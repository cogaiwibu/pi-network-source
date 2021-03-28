package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.hardware.display.DisplayManager;

@TargetApi(17)
/* renamed from: com.facebook.ads.redexgen.X.Is  reason: case insensitive filesystem */
public final class C0476Is implements DisplayManager.DisplayListener {
    public final DisplayManager A00;
    public final /* synthetic */ C0478Iu A01;

    public C0476Is(C0478Iu iu, DisplayManager displayManager) {
        this.A01 = iu;
        this.A00 = displayManager;
    }

    public final void A00() {
        this.A00.registerDisplayListener(this, null);
    }

    public final void A01() {
        this.A00.unregisterDisplayListener(this);
    }

    public final void onDisplayAdded(int i) {
    }

    public final void onDisplayChanged(int i) {
        if (i == 0) {
            this.A01.A03();
        }
    }

    public final void onDisplayRemoved(int i) {
    }
}
