package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.6k  reason: invalid class name and case insensitive filesystem */
public final class C01836k {
    public static long A01 = 0;
    @Nullable
    public static C01836k A02 = null;
    public final Map<Integer, AnonymousClass64<AbstractC01966x>> A00;

    public C01836k(Map<Integer, AnonymousClass64<AbstractC01966x>> map) {
        this.A00 = map;
    }

    public static synchronized long A00() {
        long j;
        synchronized (C01836k.class) {
            j = A01;
        }
        return j;
    }

    @SuppressLint({"UseSparseArrays"})
    public static C01836k A01() {
        if (A02 == null) {
            A02 = new C01836k(Collections.synchronizedMap(new HashMap()));
        }
        return A02;
    }

    private synchronized void A02(AnonymousClass64<AbstractC01966x> r6, int i) {
        int i2 = 0;
        boolean z = false;
        if (r6.A01() == 0) {
            z = true;
            i2 = ((AbstractC01966x) r6.A02()).A06();
        }
        A01 += (long) ((z ? 0 : 4) + (i - i2));
    }

    @SuppressLint({"PublicMethodReturnMutableCollection"})
    public final Map<Integer, AnonymousClass64<AbstractC01966x>> A03() {
        return this.A00;
    }

    public final synchronized void A04(int i, AnonymousClass64<AbstractC01966x> r4, int i2) {
        this.A00.put(Integer.valueOf(i), r4);
        A02(r4, i2);
    }
}
