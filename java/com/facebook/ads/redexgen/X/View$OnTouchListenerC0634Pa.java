package com.facebook.ads.redexgen.X;

import android.view.MotionEvent;
import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Pa  reason: case insensitive filesystem */
public class View$OnTouchListenerC0634Pa implements View.OnTouchListener {
    public final /* synthetic */ GB A00;

    public View$OnTouchListenerC0634Pa(GB gb) {
        this.A00 = gb;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (!GB.A0B(this.A00) && GB.A01(this.A00) != null && motionEvent.getAction() == 1) {
            if (GB.A01(this.A00).isShowing()) {
                GB.A01(this.A00).hide();
            } else {
                GB.A01(this.A00).show();
            }
        }
        return true;
    }
}
