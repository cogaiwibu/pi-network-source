package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.facebook.ads.redexgen.X.8G  reason: invalid class name */
public final class AnonymousClass8G {
    public static final AtomicReference<C0821Wi> A00 = new AtomicReference<>();

    @Nullable
    public static C0821Wi A00() {
        return A00.get();
    }

    public static void A01(C0821Wi wi) {
        if (wi != null) {
            A00.compareAndSet(null, wi);
        }
    }
}
