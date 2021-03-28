package com.facebook.ads.redexgen.X;

import android.view.MotionEvent;
import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.4o  reason: invalid class name and case insensitive filesystem */
public class View$OnTouchListenerC01364o implements View.OnTouchListener {
    public final /* synthetic */ C01414t A00;

    public View$OnTouchListenerC01364o(C01414t r1) {
        this.A00 = r1;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        if (this.A00.A02) {
            C1007bZ.A0J(this.A00.A05.getInternalNativeAd()).A1D();
            return true;
        }
        this.A00.A06();
        return true;
    }
}
