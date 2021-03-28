package com.facebook.ads.redexgen.X;

import android.view.MotionEvent;
import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Nw  reason: case insensitive filesystem */
public class View$OnTouchListenerC0604Nw implements View.OnTouchListener {
    public final /* synthetic */ C0672Qm A00;

    public View$OnTouchListenerC0604Nw(C0672Qm qm) {
        this.A00 = qm;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.A00.A00 = motionEvent.getY();
        } else if (actionMasked == 1) {
            if (this.A00.A00 < motionEvent.getY()) {
                this.A00.A0S(false);
            }
        }
        return true;
    }
}
