package com.facebook.ads.redexgen.X;

import android.view.MotionEvent;
import android.view.View;

public class PX implements View.OnTouchListener {
    public final /* synthetic */ GC A00;

    public PX(GC gc) {
        this.A00 = gc;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (GC.A00(this.A00) != null && motionEvent.getAction() == 1) {
            if (GC.A00(this.A00).isShowing()) {
                GC.A00(this.A00).hide();
            } else {
                GC.A00(this.A00).show();
            }
        }
        return true;
    }
}
