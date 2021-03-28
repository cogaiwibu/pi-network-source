package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.drm.DrmInitData;
import java.io.IOException;

/* renamed from: com.facebook.ads.redexgen.X.Cd  reason: case insensitive filesystem */
public abstract class AbstractC0313Cd implements AbstractC0844Xf, AbstractC0270Ac {
    public int A00;
    public int A01;
    public long A02;
    public C0271Ad A03;
    public AbstractC0387Fd A04;
    public boolean A05 = true;
    public boolean A06;
    public Format[] A07;
    public final int A08;

    public AbstractC0313Cd(int i) {
        this.A08 = i;
    }

    public static boolean A0z(@Nullable C4<?> c4, @Nullable DrmInitData drmInitData) {
        if (drmInitData == null) {
            return true;
        }
        if (c4 == null) {
            return false;
        }
        return c4.A3x(drmInitData);
    }

    public final int A10() {
        return this.A00;
    }

    public final int A11(long j) {
        return this.A04.ADF(j - this.A02);
    }

    public final int A12(AH ah, C0861Xw xw, boolean z) {
        int AC0 = this.A04.AC0(ah, xw, z);
        if (AC0 == -4) {
            if (xw.A04()) {
                this.A05 = true;
                if (this.A06) {
                    return -4;
                }
                return -3;
            }
            xw.A00 += this.A02;
        } else if (AC0 == -5) {
            Format format = ah.A00;
            if (format.A0G != Long.MAX_VALUE) {
                ah.A00 = format.A0I(format.A0G + this.A02);
            }
        }
        return AC0;
    }

    public final C0271Ad A13() {
        return this.A03;
    }

    public void A14() {
    }

    public void A15() throws A4 {
    }

    public void A16() throws A4 {
    }

    public void A17(long j, boolean z) throws A4 {
    }

    public void A18(boolean z) throws A4 {
    }

    public void A19(Format[] formatArr, long j) throws A4 {
    }

    public final boolean A1A() {
        return this.A05 ? this.A06 : this.A04.A7i();
    }

    public final Format[] A1B() {
        return this.A07;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0844Xf
    public final void A4k() {
        boolean z = true;
        if (this.A01 != 1) {
            z = false;
        }
        I1.A04(z);
        this.A01 = 0;
        this.A04 = null;
        this.A07 = null;
        this.A06 = false;
        A14();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0844Xf
    public final void A4t(C0271Ad ad, Format[] formatArr, AbstractC0387Fd fd, long j, boolean z, long j2) throws A4 {
        boolean z2;
        if (this.A01 == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        I1.A04(z2);
        this.A03 = ad;
        this.A01 = 1;
        A18(z);
        ACS(formatArr, fd, j2);
        A17(j, z);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0844Xf
    public final AbstractC0270Ac A5c() {
        return this;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0844Xf
    public IH A6V() {
        return null;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0844Xf
    public final int A70() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0844Xf
    public final AbstractC0387Fd A75() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0270Ac, com.facebook.ads.redexgen.X.AbstractC0844Xf
    public final int A7A() {
        return this.A08;
    }

    @Override // com.facebook.ads.redexgen.X.AZ
    public void A7H(int i, Object obj) throws A4 {
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0844Xf
    public final boolean A7K() {
        return this.A05;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0844Xf
    public final boolean A7W() {
        return this.A06;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0844Xf
    public final void A8X() throws IOException {
        this.A04.A8U();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0844Xf
    public final void ACS(Format[] formatArr, AbstractC0387Fd fd, long j) throws A4 {
        I1.A04(!this.A06);
        this.A04 = fd;
        this.A05 = false;
        this.A07 = formatArr;
        this.A02 = j;
        A19(formatArr, j);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0844Xf
    public final void ACb(long j) throws A4 {
        this.A06 = false;
        this.A05 = false;
        A17(j, false);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0844Xf
    public final void ACv() {
        this.A06 = true;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0844Xf
    public final void ACx(int i) {
        this.A00 = i;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0270Ac
    public int ADU() throws A4 {
        return 0;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0844Xf
    public final void start() throws A4 {
        boolean z = true;
        if (this.A01 != 1) {
            z = false;
        }
        I1.A04(z);
        this.A01 = 2;
        A15();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0844Xf
    public final void stop() throws A4 {
        boolean z;
        if (this.A01 == 2) {
            z = true;
        } else {
            z = false;
        }
        I1.A04(z);
        this.A01 = 1;
        A16();
    }
}
