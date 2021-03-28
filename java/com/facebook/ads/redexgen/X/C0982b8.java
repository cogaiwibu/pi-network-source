package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* renamed from: com.facebook.ads.redexgen.X.b8  reason: case insensitive filesystem */
public final class C0982b8 implements IE {
    public final Handler A00;

    public C0982b8(Handler handler) {
        this.A00 = handler;
    }

    @Override // com.facebook.ads.redexgen.X.IE
    public final Looper A6U() {
        return this.A00.getLooper();
    }

    @Override // com.facebook.ads.redexgen.X.IE
    public final Message A8c(int i, int i2, int i3) {
        return this.A00.obtainMessage(i, i2, i3);
    }

    @Override // com.facebook.ads.redexgen.X.IE
    public final Message A8d(int i, int i2, int i3, Object obj) {
        return this.A00.obtainMessage(i, i2, i3, obj);
    }

    @Override // com.facebook.ads.redexgen.X.IE
    public final Message A8e(int i, Object obj) {
        return this.A00.obtainMessage(i, obj);
    }

    @Override // com.facebook.ads.redexgen.X.IE
    public final void ACN(int i) {
        this.A00.removeMessages(i);
    }

    @Override // com.facebook.ads.redexgen.X.IE
    public final boolean ACp(int i) {
        return this.A00.sendEmptyMessage(i);
    }

    @Override // com.facebook.ads.redexgen.X.IE
    public final boolean ACq(int i, long j) {
        return this.A00.sendEmptyMessageAtTime(i, j);
    }
}
