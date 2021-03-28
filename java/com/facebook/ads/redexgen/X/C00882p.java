package com.facebook.ads.redexgen.X;

import androidx.annotation.NonNull;

/* renamed from: com.facebook.ads.redexgen.X.2p  reason: invalid class name and case insensitive filesystem */
public final class C00882p extends C0283Aq implements Comparable<C00882p> {
    public long A00;

    public C00882p() {
    }

    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final int compareTo(@NonNull C00882p r8) {
        if (A04() == r8.A04()) {
            long j = ((C0861Xw) this).A00 - ((C0861Xw) r8).A00;
            if (j == 0) {
                j = this.A00 - r8.A00;
                if (j == 0) {
                    return 0;
                }
            }
            if (j > 0) {
                return 1;
            }
            return -1;
        } else if (A04()) {
            return 1;
        } else {
            return -1;
        }
    }
}
