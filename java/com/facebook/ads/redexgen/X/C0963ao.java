package com.facebook.ads.redexgen.X;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;

/* renamed from: com.facebook.ads.redexgen.X.ao  reason: case insensitive filesystem */
public final class C0963ao implements HM {
    public final int A00;
    public final HM A01;
    public final IU A02;

    public C0963ao(HM hm, IU iu, int i) {
        this.A01 = (HM) I1.A01(hm);
        this.A02 = (IU) I1.A01(iu);
        this.A00 = i;
    }

    @Override // com.facebook.ads.redexgen.X.HM
    @Nullable
    public final Uri A7C() {
        return this.A01.A7C();
    }

    @Override // com.facebook.ads.redexgen.X.HM
    public final long ABP(HQ hq) throws IOException {
        this.A02.A02(this.A00);
        return this.A01.ABP(hq);
    }

    @Override // com.facebook.ads.redexgen.X.HM
    public final void close() throws IOException {
        this.A01.close();
    }

    @Override // com.facebook.ads.redexgen.X.HM
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        this.A02.A02(this.A00);
        return this.A01.read(bArr, i, i2);
    }
}
