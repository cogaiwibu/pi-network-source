package com.facebook.ads.redexgen.X;

import java.util.Comparator;

/* renamed from: com.facebook.ads.redexgen.X.3o  reason: invalid class name and case insensitive filesystem */
public class C01113o implements Comparator<C01123p> {
    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final int compare(C01123p r5, C01123p r6) {
        boolean z;
        boolean z2;
        if (r5.A03 == null) {
            z = true;
        } else {
            z = false;
        }
        if (r6.A03 == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z != z2) {
            if (r5.A03 == null) {
                return 1;
            }
            return -1;
        } else if (r5.A04 == r6.A04) {
            int i = r6.A02 - r5.A02;
            if (i != 0) {
                return i;
            }
            int i2 = r5.A00 - r6.A00;
            if (i2 != 0) {
                return i2;
            }
            return 0;
        } else if (r5.A04) {
            return -1;
        } else {
            return 1;
        }
    }
}
