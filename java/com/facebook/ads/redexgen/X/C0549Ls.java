package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.concurrent.Executor;

/* renamed from: com.facebook.ads.redexgen.X.Ls  reason: case insensitive filesystem */
public final class C0549Ls {
    @Nullable
    public static C0549Ls A02;
    public final C0910Zx A00;
    public final C0551Lu A01;

    public C0549Ls(C0820Wh wh, Executor executor, AnonymousClass90 r4) {
        this.A01 = new C0551Lu(wh);
        this.A00 = new C0910Zx(executor, r4, wh);
    }

    private void A00() {
        this.A01.A03(this.A00);
    }

    public static void A01(C0820Wh wh, Executor executor, AnonymousClass90 r3) {
        if (J8.A0v(wh)) {
            C0549Ls ls = A02;
            if (ls == null) {
                A02 = new C0549Ls(wh, executor, r3);
                A02.A00();
                return;
            }
            ls.A02(r3);
        }
    }

    private void A02(AnonymousClass90 r2) {
        C0910Zx.A08(this.A00, r2);
    }
}
