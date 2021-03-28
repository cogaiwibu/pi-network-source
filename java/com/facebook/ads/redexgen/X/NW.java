package com.facebook.ads.redexgen.X;

import android.view.ViewGroup;
import java.util.List;

public final class NW extends AnonymousClass43<C0566Mj> {
    public static final int A05 = ((int) (C0535Le.A01 * 250.0f));
    public int A00 = 0;
    public boolean A01 = false;
    public final int A02;
    public final C0820Wh A03;
    public final List<String> A04;

    public NW(C0820Wh wh, List<String> list, int i) {
        this.A04 = list;
        this.A02 = i;
        this.A03 = wh;
    }

    /* access modifiers changed from: private */
    /* renamed from: A01 */
    public final C0566Mj A07(ViewGroup viewGroup, int i) {
        return new C0566Mj(new NG(this.A03));
    }

    /* access modifiers changed from: private */
    /* renamed from: A02 */
    public final void A0F(C0566Mj mj, int startSpacing) {
        int i;
        int i2;
        String str = this.A04.get(startSpacing);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -1);
        if (this.A00 != 2 || !this.A01) {
            i = this.A02 * 4;
        } else {
            i = A05;
        }
        if (startSpacing != 0) {
            i = this.A02;
        }
        if (startSpacing >= A0E() - 1) {
            i2 = this.A02 * 4;
        } else {
            i2 = this.A02;
        }
        marginLayoutParams.setMargins(i, 0, i2, 0);
        mj.A0m().setLayoutParams(marginLayoutParams);
        mj.A0m().A00(str);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass43
    public final int A0E() {
        return this.A04.size();
    }

    public final void A0G(int i, boolean z) {
        this.A00 = i;
        this.A01 = z;
    }
}
