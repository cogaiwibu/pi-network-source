package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.view.View;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Sw  reason: case insensitive filesystem */
public final class C0731Sw extends AbstractC00350o {
    public static byte[] A03;
    public View A00;
    public final C01444w A01;
    public final C0331Cv A02;

    static {
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 53);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A03 = new byte[]{-23, 7, 20, 20, 21, 26, -58, 22, 24, 11, 25, 11, 20, 26, -58, 20, 27, 18, 18, -58, 7, 10, -4, 15, 11, 29};
    }

    public C0731Sw(C01444w r2) {
        this.A02 = r2.A0A();
        this.A01 = r2;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00350o
    public final void A0B() {
        this.A02.A0A().A3e();
        KT.A00(new C0729Su(this));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00350o
    public final void A0C() {
        this.A02.A0A().A3h();
        KT.A00(new C0730Sv(this));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00350o
    public final void A0D(View view) {
        if (view != null) {
            this.A02.A0A().A3g();
            this.A00 = view;
            this.A01.A08().removeAllViews();
            this.A01.A08().addView(this.A00);
            if (this.A00 instanceof C0838Wz) {
                C0502Ju.A04(this.A01.A06(), this.A00, this.A01.A0B());
            }
            C0378Eu A09 = this.A01.A09();
            if (A09 != null) {
                A09.A0J();
            }
            KT.A00(new C0728St(this));
            C01444w r2 = this.A01;
            r2.A0C(r2.A08(), this.A00);
            if (Build.VERSION.SDK_INT >= 18 && J8.A0q(this.A01.A08().getContext())) {
                NS ns = new NS();
                this.A01.A0D(ns);
                ns.A0D(this.A01.getPlacementId());
                ns.A0C(this.A01.A08().getContext().getPackageName());
                if (!(this.A01.A09() == null || this.A01.A09().A0H() == null)) {
                    ns.A0A(this.A01.A09().A0H().A0C());
                }
                View view2 = this.A00;
                if (view2 instanceof C0838Wz) {
                    ns.A0B(((C0838Wz) view2).getViewabilityChecker());
                }
                this.A00.setOnLongClickListener(new AnonymousClass55(this, ns));
                this.A00.getOverlay().add(ns);
                return;
            }
            return;
        }
        throw new IllegalStateException(A02(0, 26, 113));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00350o
    public final void A0E(AbstractC00340n r3) {
        boolean z;
        AbstractC0685Qz A0F = this.A02.A0A();
        if (this.A01.A09() != null) {
            z = true;
        } else {
            z = false;
        }
        A0F.A3f(z);
        if (this.A01.A09() != null) {
            this.A01.A09().A0K();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00350o
    public final void A0F(C0495Jm jm) {
        this.A02.A0A().A2d(LW.A01(this.A01.A05()), jm.A04().getErrorCode(), jm.A05());
        KT.A00(new C0727Ss(this, jm));
    }
}
