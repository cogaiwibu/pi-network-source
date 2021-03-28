package com.facebook.ads.redexgen.X;

import java.util.EnumSet;
import javax.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.6f  reason: invalid class name and case insensitive filesystem */
public final class C01786f {
    public final int A00;
    public final AbstractC01816i A01;
    public final EnumSet<EnumC01856m> A02;

    public C01786f(int i, EnumSet<EnumC01856m> enumSet, AbstractC01816i r3) {
        this.A00 = i;
        this.A02 = enumSet;
        this.A01 = r3;
    }

    public final int A00() {
        return this.A00;
    }

    @Nullable
    public final AbstractC01816i A01() {
        if (this.A02.contains(EnumC01856m.A07)) {
            return this.A01;
        }
        return null;
    }

    @Nullable
    public final AbstractC01816i A02(EnumC01826j r2) {
        if (A04(r2)) {
            return this.A01;
        }
        return null;
    }

    public final EnumSet<EnumC01856m> A03() {
        return this.A02;
    }

    public final boolean A04(EnumC01826j r3) {
        return AnonymousClass76.A0F(r3) && this.A02.contains(EnumC01856m.A00(r3.A03()));
    }
}
