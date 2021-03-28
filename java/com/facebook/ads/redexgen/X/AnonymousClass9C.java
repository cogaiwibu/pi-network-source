package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.9C  reason: invalid class name */
public final class AnonymousClass9C {
    public static AnonymousClass9C A00 = new AnonymousClass9C();

    public static AnonymousClass9C A00() {
        return A00;
    }

    @SuppressLint({"InstanceMethodCanBeStatic"})
    public final AnonymousClass9B A01(AnonymousClass8H r3, boolean z) {
        return new XJ(r3, z, new C01665t());
    }

    @SuppressLint({"CatchGeneralException"})
    public final Map<String, String> A02(AnonymousClass8H r3) {
        try {
            return A01(r3, false).A69();
        } catch (Throwable th) {
            r3.A04().A3S(th);
            return AnonymousClass98.A01(r3);
        }
    }
}
