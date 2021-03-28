package com.google.android.gms.internal.base;

import android.graphics.drawable.Drawable;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public final class zah extends Drawable.ConstantState {
    int mChangingConfigurations;
    int zaoa;

    zah(zah zah) {
        if (zah != null) {
            this.mChangingConfigurations = zah.mChangingConfigurations;
            this.zaoa = zah.zaoa;
        }
    }

    public final Drawable newDrawable() {
        return new zae(this);
    }

    public final int getChangingConfigurations() {
        return this.mChangingConfigurations;
    }
}
