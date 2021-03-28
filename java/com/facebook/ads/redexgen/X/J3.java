package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;

public final class J3 {
    @Nullable
    public final Handler A00;
    @Nullable
    public final J4 A01;

    public J3(@Nullable Handler handler, @Nullable J4 j4) {
        Handler handler2;
        if (j4 != null) {
            handler2 = (Handler) I1.A01(handler);
        } else {
            handler2 = null;
        }
        this.A00 = handler2;
        this.A01 = j4;
    }

    public final void A01(int i, int i2, int i3, float f) {
        if (this.A01 != null) {
            this.A00.post(new J0(this, i, i2, i3, f));
        }
    }

    public final void A02(int i, long j) {
        if (this.A01 != null) {
            this.A00.post(new RunnableC0483Iz(this, i, j));
        }
    }

    public final void A03(Surface surface) {
        if (this.A01 != null) {
            this.A00.post(new J1(this, surface));
        }
    }

    public final void A04(Format format) {
        if (this.A01 != null) {
            this.A00.post(new RunnableC0482Iy(this, format));
        }
    }

    public final void A05(C0297Be be) {
        if (this.A01 != null) {
            this.A00.post(new J2(this, be));
        }
    }

    public final void A06(C0297Be be) {
        if (this.A01 != null) {
            this.A00.post(new RunnableC0480Iw(this, be));
        }
    }

    public final void A07(String str, long j, long j2) {
        if (this.A01 != null) {
            this.A00.post(new RunnableC0481Ix(this, str, j, j2));
        }
    }
}
