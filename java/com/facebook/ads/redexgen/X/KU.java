package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class KU {
    public static final Set<Object> A00 = Collections.newSetFromMap(new WeakHashMap());
    public static final AtomicBoolean A01 = new AtomicBoolean(true);
    public static final AtomicReference<KS> A02 = new AtomicReference<>();

    @SuppressLint({"RethrownThrowableArgument"})
    public static void A00(Throwable th, Object obj) throws Throwable {
        if (A01.get()) {
            A00.add(obj);
            C0517Kj.A00().A7t(IronSourceConstants.BN_INSTANCE_LOAD_NO_FILL, th);
            KS ks = A02.get();
            if (ks != null) {
                ks.ACR(th, obj);
                return;
            }
            return;
        }
        throw th;
    }

    public static void A01(boolean z, KS ks) {
        A01.set(z);
        A02.set(ks);
    }

    public static boolean A02(Object obj) {
        return A00.contains(obj);
    }
}
