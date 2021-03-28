package com.facebook.ads.redexgen.X;

import android.view.MotionEvent;
import android.view.View;

public class N5 implements View.OnTouchListener {
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            C0535Le.A0P(view, N9.A08);
        } else if (action == 1) {
            C0535Le.A0P(view, 0);
        }
        return false;
    }
}
