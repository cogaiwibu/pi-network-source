package com.facebook.ads.redexgen.X;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;

/* renamed from: com.facebook.ads.redexgen.X.Ay  reason: case insensitive filesystem */
public final class C0291Ay extends AbstractC0896Zg implements FD {
    public long A00;
    public boolean A01;
    public final int A02;
    public final int A03;
    public final Uri A04;
    public final CN A05;
    public final HL A06;
    @Nullable
    public final Object A07;
    public final String A08;

    public C0291Ay(Uri uri, HL hl, CN cn, int i, @Nullable String str, int i2, @Nullable Object obj) {
        this.A04 = uri;
        this.A06 = hl;
        this.A05 = cn;
        this.A03 = i;
        this.A08 = str;
        this.A02 = i2;
        this.A00 = -9223372036854775807L;
        this.A07 = obj;
    }

    private void A00(long j, boolean z) {
        this.A00 = j;
        this.A01 = z;
        A01(new C0911Zy(this.A00, this.A01, false, this.A07), null);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0896Zg
    public final void A02() {
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0896Zg
    public final void A03(AbstractC0842Xd xd, boolean z) {
        A00(this.A00, false);
    }

    @Override // com.facebook.ads.redexgen.X.FI
    public final AbstractC0907Zu A4P(FG fg, HE he) {
        boolean z;
        if (fg.A02 == 0) {
            z = true;
        } else {
            z = false;
        }
        I1.A03(z);
        return new C0292Az(this.A04, this.A06.A4D(), this.A05.A4H(), this.A03, A00(fg), this, he, this.A08, this.A02);
    }

    @Override // com.facebook.ads.redexgen.X.FI
    public final void A8W() throws IOException {
    }

    @Override // com.facebook.ads.redexgen.X.FD
    public final void AAw(long j, boolean z) {
        if (j == -9223372036854775807L) {
            j = this.A00;
        }
        if (this.A00 != j || this.A01 != z) {
            A00(j, z);
        }
    }

    @Override // com.facebook.ads.redexgen.X.FI
    public final void ACI(AbstractC0907Zu zu) {
        ((C0292Az) zu).A0S();
    }
}
