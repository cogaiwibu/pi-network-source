package com.bytedance.sdk.openadsdk.core.a;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: InteractionListener */
public abstract class c implements View.OnClickListener, View.OnTouchListener {
    protected int o;
    protected int p;
    protected int q;
    protected int r;
    protected long s;
    protected long t;
    protected int u;
    protected int v;
    protected int w;

    /* access modifiers changed from: protected */
    public abstract void b(View view, int i, int i2, int i3, int i4);

    public void onClick(View view) {
        b(view, this.o, this.p, this.q, this.r);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.o = (int) motionEvent.getRawX();
            this.p = (int) motionEvent.getRawY();
            this.s = System.currentTimeMillis();
            this.u = motionEvent.getToolType(0);
            this.v = motionEvent.getDeviceId();
            this.w = motionEvent.getSource();
        } else if (actionMasked == 1) {
            this.q = (int) motionEvent.getRawX();
            this.r = (int) motionEvent.getRawY();
            this.t = System.currentTimeMillis();
        }
        return false;
    }
}
