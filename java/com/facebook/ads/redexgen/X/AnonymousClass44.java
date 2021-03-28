package com.facebook.ads.redexgen.X;

import android.database.Observable;

/* renamed from: com.facebook.ads.redexgen.X.44  reason: invalid class name */
public class AnonymousClass44 extends Observable<AnonymousClass45> {
    public final void A00() {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((AnonymousClass45) this.mObservers.get(size)).A00();
        }
    }
}
