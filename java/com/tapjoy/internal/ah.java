package com.tapjoy.internal;

import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

public final class ah {
    protected int a = 0;
    protected float b = 0.0f;
    protected int c = 0;
    protected float d = 0.0f;
    protected int e = 0;
    protected float f = 0.0f;
    protected int g = 0;
    protected float h = 0.0f;

    public final Animation a() {
        return new TranslateAnimation(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
    }

    public final ah a(float f2) {
        this.a = 1;
        this.b = f2;
        return this;
    }

    public final ah b(float f2) {
        this.e = 1;
        this.f = f2;
        return this;
    }
}
