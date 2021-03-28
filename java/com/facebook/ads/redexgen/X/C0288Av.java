package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import androidx.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.Av  reason: case insensitive filesystem */
public final class C0288Av {
    public static final C0288Av A04 = new C0287Au().A00();
    public AudioAttributes A00;
    public final int A01;
    public final int A02;
    public final int A03;

    public C0288Av(int i, int i2, int i3) {
        this.A01 = i;
        this.A02 = i2;
        this.A03 = i3;
    }

    @TargetApi(21)
    public final AudioAttributes A00() {
        if (this.A00 == null) {
            this.A00 = new AudioAttributes.Builder().setContentType(this.A01).setFlags(this.A02).setUsage(this.A03).build();
        }
        return this.A00;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0288Av av = (C0288Av) obj;
        if (this.A01 == av.A01 && this.A02 == av.A02 && this.A03 == av.A03) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((((17 * 31) + this.A01) * 31) + this.A02) * 31) + this.A03;
    }
}
