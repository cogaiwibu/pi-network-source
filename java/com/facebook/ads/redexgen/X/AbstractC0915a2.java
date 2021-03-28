package com.facebook.ads.redexgen.X;

import java.lang.ref.WeakReference;

/* renamed from: com.facebook.ads.redexgen.X.a2  reason: case insensitive filesystem */
public abstract class AbstractC0915a2<T> extends AbstractRunnableC0510Kc {
    public final WeakReference<T> A00;

    public AbstractC0915a2(T t) {
        this.A00 = new WeakReference<>(t);
    }

    public final T A08() {
        return this.A00.get();
    }
}
