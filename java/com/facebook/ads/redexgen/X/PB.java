package com.facebook.ads.redexgen.X;

import android.graphics.Paint;

public class PB extends Paint {
    public final /* synthetic */ PC A00;
    public final /* synthetic */ boolean A01;

    public PB(PC pc, boolean z) {
        int i;
        this.A00 = pc;
        this.A01 = z;
        setStyle(Paint.Style.FILL_AND_STROKE);
        setStrokeCap(Paint.Cap.ROUND);
        setStrokeWidth(3.0f);
        setAntiAlias(true);
        if (this.A01) {
            i = -1;
        } else {
            i = -10066330;
        }
        setColor(i);
    }
}
