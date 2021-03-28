package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.protocol.AdPlacementType;

/* renamed from: com.facebook.ads.redexgen.X.0s  reason: invalid class name and case insensitive filesystem */
public final class C00390s {
    public static AbstractC00340n A00;

    public final AbstractC00340n A00(AdPlacementType adPlacementType) {
        AbstractC00340n r0 = A00;
        if (r0 != null) {
            return r0;
        }
        int i = C00380r.A00[adPlacementType.ordinal()];
        if (i == 1) {
            return new RD();
        }
        if (i == 2) {
            return new RE();
        }
        if (i == 3) {
            return new RG();
        }
        if (i == 4) {
            return new C0383Ez();
        }
        if (i != 5) {
            return null;
        }
        return new C0381Ex();
    }
}
