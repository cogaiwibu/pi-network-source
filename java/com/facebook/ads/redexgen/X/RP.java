package com.facebook.ads.redexgen.X;

import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.facebook.proguard.annotations.DoNotStrip;
import java.util.List;

public abstract class RP extends AnonymousClass43<C0895Zf> {
    public static final int A05 = ((int) (C0535Le.A01 * 4.0f));
    @Nullable
    public AnonymousClass15 A00;
    public final List<C1007bZ> A01;
    public final int A02;
    public final C0820Wh A03;
    @DoNotStrip
    public final AbstractC0640Pg A04 = new RN(this);

    public RP(AnonymousClass1U r2, List<C1007bZ> list, C0820Wh wh) {
        this.A03 = wh;
        this.A02 = r2.getChildSpacing();
        this.A01 = list;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass43
    private ViewGroup.MarginLayoutParams A04(int i) {
        int i2;
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -1);
        int i3 = this.A02;
        if (i == 0) {
            i3 *= 2;
        }
        if (i >= this.A01.size() - 1) {
            i2 = this.A02 * 2;
        } else {
            i2 = this.A02;
        }
        marginLayoutParams.setMargins(i3, 0, i2, 0);
        return marginLayoutParams;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass43
    public final int A0E() {
        return this.A01.size();
    }

    public final void A0G(ImageView imageView, int i) {
        C1007bZ bZVar = this.A01.get(i);
        JZ A0z = bZVar.getAdCoverImage();
        if (A0z != null) {
            AsyncTaskC0831Ws A052 = new AsyncTaskC0831Ws(imageView, this.A03).A05();
            A052.A07(new RO(this, i, bZVar));
            A052.A08(A0z.getUrl());
        }
    }

    public final void A0H(AnonymousClass15 r1) {
        this.A00 = r1;
    }

    /* renamed from: A0I */
    public void A0F(C0895Zf zf, int i) {
        zf.A0m().setLayoutParams(A04(i));
    }
}
