package com.facebook.ads.redexgen.X;

import android.view.View;
import androidx.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.Nr  reason: case insensitive filesystem */
public class C0599Nr {
    public int A00 = 1;
    public int A01 = 0;
    @Nullable
    public View A02;
    @Nullable
    public M1 A03;
    @Nullable
    public H2 A04;
    public final View A05;
    public final AnonymousClass16 A06;
    public final C0820Wh A07;
    public final JE A08;
    public final LX A09;
    public final M6 A0A;
    public final C0641Ph A0B;

    public C0599Nr(C0820Wh wh, JE je, M6 m6, AnonymousClass16 r5, View view, C0641Ph ph, LX lx) {
        this.A07 = wh;
        this.A08 = je;
        this.A0A = m6;
        this.A06 = r5;
        this.A05 = view;
        this.A0B = ph;
        this.A09 = lx;
    }

    public final C0599Nr A0C(int i) {
        this.A00 = i;
        return this;
    }

    public final C0599Nr A0D(int i) {
        this.A01 = i;
        return this;
    }

    public final C0599Nr A0E(View view) {
        this.A02 = view;
        return this;
    }

    public final C0599Nr A0F(M1 m1) {
        this.A03 = m1;
        return this;
    }

    public final C0599Nr A0G(H2 h2) {
        this.A04 = h2;
        return this;
    }

    public final C0600Ns A0H() {
        return new C0600Ns(this);
    }
}
