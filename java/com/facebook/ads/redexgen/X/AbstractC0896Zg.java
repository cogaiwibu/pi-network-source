package com.facebook.ads.redexgen.X;

import android.os.Handler;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.facebook.ads.redexgen.X.Zg  reason: case insensitive filesystem */
public abstract class AbstractC0896Zg implements FI {
    public AbstractC0842Xd A00;
    public AbstractC0276Aj A01;
    public Object A02;
    public final FT A03 = new FT();
    public final ArrayList<FH> A04 = new ArrayList<>(1);

    public abstract void A02();

    public abstract void A03(AbstractC0842Xd xd, boolean z);

    public final FT A00(@Nullable FG fg) {
        return this.A03.A03(0, fg, 0);
    }

    public final void A01(AbstractC0276Aj aj, @Nullable Object obj) {
        this.A01 = aj;
        this.A02 = obj;
        Iterator<FH> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().AAx(this, aj, obj);
        }
    }

    @Override // com.facebook.ads.redexgen.X.FI
    public final void A3F(Handler handler, FW fw) {
        this.A03.A08(handler, fw);
    }

    @Override // com.facebook.ads.redexgen.X.FI
    public final void ABl(AbstractC0842Xd xd, boolean z, FH fh) {
        boolean z2;
        AbstractC0842Xd xd2 = this.A00;
        if (xd2 == null || xd2 == xd) {
            z2 = true;
        } else {
            z2 = false;
        }
        I1.A03(z2);
        this.A04.add(fh);
        if (this.A00 == null) {
            this.A00 = xd;
            A03(xd, z);
            return;
        }
        AbstractC0276Aj aj = this.A01;
        if (aj != null) {
            fh.AAx(this, aj, this.A02);
        }
    }

    @Override // com.facebook.ads.redexgen.X.FI
    public final void ACK(FH fh) {
        this.A04.remove(fh);
        if (this.A04.isEmpty()) {
            this.A00 = null;
            this.A01 = null;
            this.A02 = null;
            A02();
        }
    }

    @Override // com.facebook.ads.redexgen.X.FI
    public final void ACM(FW fw) {
        this.A03.A0E(fw);
    }
}
