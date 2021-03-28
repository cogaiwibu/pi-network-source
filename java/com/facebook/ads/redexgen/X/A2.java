package com.facebook.ads.redexgen.X;

import java.util.Comparator;
import java.util.TreeSet;

public final class A2 implements AbstractC0973ay, Comparator<C0449Hp> {
    public static String[] A03;
    public long A00;
    public final long A01;
    public final TreeSet<C0449Hp> A02 = new TreeSet<>(this);

    static {
        A01();
    }

    public static void A01() {
        A03 = new String[]{"qrCZDebBZXOMsu5PI8FdamZv", "usPTrKdLrE7MLvxS6mJMRwkls4hZpcPz", "BDrpv9J1bckqz2zbQbGMwvdv", "cHdTuf55w1r5Lcr9n47avjSAGBdp9rLc", "v1mI", "NFtkBlX9Mz", "lz", "jBDMosIM65rjrOuIbY8WA7ZUxyDm84U3"};
    }

    public A2(long j) {
        this.A01 = j;
    }

    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final int compare(C0449Hp hp, C0449Hp hp2) {
        if (hp.A00 - hp2.A00 == 0) {
            return hp.compareTo(hp2);
        }
        return hp.A00 < hp2.A00 ? -1 : 1;
    }

    private void A02(AbstractC0445Hl hl, long j) {
        while (this.A00 + j > this.A01) {
            boolean isEmpty = this.A02.isEmpty();
            if (A03[4].length() != 25) {
                String[] strArr = A03;
                strArr[0] = "3qXh8T5e4LOlD1IWJEc6SNWF";
                strArr[2] = "YJzC3pPkQPrTmiUzc4g95RWz";
                if (!isEmpty) {
                    try {
                        hl.ACO(this.A02.first());
                    } catch (C0443Hj unused) {
                    }
                } else {
                    return;
                }
            } else {
                throw new RuntimeException();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0444Hk
    public final void AAy(AbstractC0445Hl hl, C0449Hp hp) {
        this.A02.add(hp);
        this.A00 += hp.A01;
        A02(hl, 0);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0444Hk
    public final void AAz(AbstractC0445Hl hl, C0449Hp hp) {
        this.A02.remove(hp);
        this.A00 -= hp.A01;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0444Hk
    public final void AB0(AbstractC0445Hl hl, C0449Hp hp, C0449Hp hp2) {
        AAz(hl, hp);
        AAy(hl, hp2);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0973ay
    public final void AB1(AbstractC0445Hl hl, String str, long j, long j2) {
        A02(hl, j2);
    }
}
