package com.facebook.ads.redexgen.X;

import androidx.annotation.NonNull;

/* renamed from: com.facebook.ads.redexgen.X.Gs  reason: case insensitive filesystem */
public final class C0426Gs implements Comparable<C0426Gs> {
    public final int A00;
    public final C0422Go A01;

    public C0426Gs(int i, C0422Go go) {
        this.A00 = i;
        this.A01 = go;
    }

    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final int compareTo(@NonNull C0426Gs gs) {
        return this.A00 - gs.A00;
    }
}
