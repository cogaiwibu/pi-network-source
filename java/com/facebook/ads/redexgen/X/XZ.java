package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;

public final class XZ implements IH {
    public static byte[] A04;
    @Nullable
    public AbstractC0844Xf A00;
    @Nullable
    public IH A01;
    public final A1 A02;
    public final C0980b6 A03;

    static {
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 59);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A04 = new byte[]{95, 103, 126, 102, 123, 98, 126, 119, 50, 96, 119, 124, 118, 119, 96, 119, 96, 50, ByteCompanionObject.MAX_VALUE, 119, 118, 123, 115, 50, 113, 126, 125, 113, 121, 97, 50, 119, 124, 115, 112, 126, 119, 118, 60};
    }

    public XZ(A1 a1, I4 i4) {
        this.A02 = a1;
        this.A03 = new C0980b6(i4);
    }

    private void A01() {
        this.A03.A03(this.A01.A6o());
        AP playbackParameters = this.A01.A6l();
        if (!playbackParameters.equals(this.A03.A6l())) {
            this.A03.AD3(playbackParameters);
            this.A02.AAT(playbackParameters);
        }
    }

    private boolean A03() {
        AbstractC0844Xf xf = this.A00;
        return xf != null && !xf.A7Z() && (this.A00.A7i() || !this.A00.A7K());
    }

    public final long A04() {
        if (!A03()) {
            return this.A03.A6o();
        }
        A01();
        return this.A01.A6o();
    }

    public final void A05() {
        this.A03.A01();
    }

    public final void A06() {
        this.A03.A02();
    }

    public final void A07(long j) {
        this.A03.A03(j);
    }

    public final void A08(AbstractC0844Xf xf) {
        if (xf == this.A00) {
            this.A01 = null;
            this.A00 = null;
        }
    }

    public final void A09(AbstractC0844Xf xf) throws A4 {
        IH ih;
        IH A6V = xf.A6V();
        if (A6V != null && A6V != (ih = this.A01)) {
            if (ih == null) {
                this.A01 = A6V;
                this.A00 = xf;
                this.A01.AD3(this.A03.A6l());
                A01();
                return;
            }
            throw A4.A02(new IllegalStateException(A00(0, 39, 41)));
        }
    }

    @Override // com.facebook.ads.redexgen.X.IH
    public final AP A6l() {
        IH ih = this.A01;
        if (ih != null) {
            return ih.A6l();
        }
        return this.A03.A6l();
    }

    @Override // com.facebook.ads.redexgen.X.IH
    public final long A6o() {
        if (A03()) {
            return this.A01.A6o();
        }
        return this.A03.A6o();
    }

    @Override // com.facebook.ads.redexgen.X.IH
    public final AP AD3(AP ap) {
        IH ih = this.A01;
        if (ih != null) {
            ap = ih.AD3(ap);
        }
        this.A03.AD3(ap);
        this.A02.AAT(ap);
        return ap;
    }
}
