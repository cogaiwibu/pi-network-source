package com.facebook.ads.redexgen.X;

import android.database.ContentObserver;
import android.os.Handler;

/* renamed from: com.facebook.ads.redexgen.X.Or  reason: case insensitive filesystem */
public final class C0625Or extends ContentObserver {
    public final K7 A00;

    public C0625Or(Handler handler, K7 k7) {
        super(handler);
        this.A00 = k7;
    }

    public final boolean deliverSelfNotifications() {
        return false;
    }

    public final void onChange(boolean z) {
        this.A00.A0a();
    }
}
