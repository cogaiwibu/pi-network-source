package com.tapjoy.internal;

import android.graphics.Bitmap;
import com.tapjoy.internal.ic;
import javax.annotation.Nonnull;

/* access modifiers changed from: package-private */
public final class ih implements ic.a {
    ih() {
    }

    @Override // com.tapjoy.internal.ic.a
    @Nonnull
    public final Bitmap a(int i, int i2, Bitmap.Config config) {
        return Bitmap.createBitmap(i, i2, config);
    }

    @Override // com.tapjoy.internal.ic.a
    public final byte[] a(int i) {
        return new byte[i];
    }

    @Override // com.tapjoy.internal.ic.a
    public final int[] b(int i) {
        return new int[i];
    }
}
