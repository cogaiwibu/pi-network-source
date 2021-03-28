package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;

public class OX implements View.OnTouchListener {
    public final /* synthetic */ OY A00;

    public OX(OY oy) {
        this.A00 = oy;
    }

    public /* synthetic */ OX(OY oy, AnonymousClass82 r2) {
        this(oy);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1) {
            return false;
        }
        this.A00.A01 = System.currentTimeMillis();
        OY.A00(this.A00);
        this.A00.A06.A8A(this.A00.A03.A0Q(), new NU().A04(this.A00.getViewabilityChecker()).A03(this.A00.getTouchDataRecorder()).A06());
        return false;
    }
}
