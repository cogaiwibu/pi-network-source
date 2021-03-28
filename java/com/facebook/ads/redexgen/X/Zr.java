package com.facebook.ads.redexgen.X;

import android.net.Uri;
import androidx.annotation.Nullable;

public final class Zr implements G4 {
    public int A00 = 1048576;
    public int A01 = -1;
    @Nullable
    public CN A02;
    @Nullable
    public Object A03;
    @Nullable
    public String A04;
    public boolean A05;
    public final HL A06;

    public Zr(HL hl) {
        this.A06 = hl;
    }

    public final C0291Ay A00(Uri uri) {
        this.A05 = true;
        if (this.A02 == null) {
            this.A02 = new YE();
        }
        return new C0291Ay(uri, this.A06, this.A02, this.A01, this.A04, this.A00, this.A03);
    }
}
