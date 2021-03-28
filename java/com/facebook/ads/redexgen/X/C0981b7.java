package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.b7  reason: case insensitive filesystem */
public final class C0981b7 implements I4 {
    @Override // com.facebook.ads.redexgen.X.I4
    public final IE A4I(Looper looper, @Nullable Handler.Callback callback) {
        return new C0982b8(new Handler(looper, callback));
    }

    @Override // com.facebook.ads.redexgen.X.I4
    public final long A4r() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.facebook.ads.redexgen.X.I4
    public final long ADf() {
        return SystemClock.uptimeMillis();
    }
}
