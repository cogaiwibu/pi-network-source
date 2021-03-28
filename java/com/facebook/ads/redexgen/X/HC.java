package com.facebook.ads.redexgen.X;

public final class HC {
    public final int A00;
    public final H9 A01;
    public final Object A02;
    public final C0271Ad[] A03;

    public HC(C0271Ad[] adArr, H8[] h8Arr, Object obj) {
        this.A03 = adArr;
        this.A01 = new H9(h8Arr);
        this.A02 = obj;
        this.A00 = adArr.length;
    }

    public final boolean A00(int i) {
        return this.A03[i] != null;
    }

    public final boolean A01(HC hc) {
        if (hc == null || hc.A01.A01 != this.A01.A01) {
            return false;
        }
        for (int i = 0; i < this.A01.A01; i++) {
            if (!A02(hc, i)) {
                return false;
            }
        }
        return true;
    }

    public final boolean A02(HC hc, int i) {
        if (hc != null && C0466Ig.A0h(this.A03[i], hc.A03[i]) && C0466Ig.A0h(this.A01.A01(i), hc.A01.A01(i))) {
            return true;
        }
        return false;
    }
}
