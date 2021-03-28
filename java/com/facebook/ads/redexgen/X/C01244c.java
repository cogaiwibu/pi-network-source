package com.facebook.ads.redexgen.X;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.4c  reason: invalid class name and case insensitive filesystem */
public final class C01244c {
    public AnonymousClass4Z A00 = new AnonymousClass4Z();
    public final AbstractC01224a A01;

    public C01244c(AbstractC01224a r2) {
        this.A01 = r2;
    }

    public final View A00(int end, int next, int i, int i2) {
        int i3;
        int childStart = this.A01.A6f();
        int A6e = this.A01.A6e();
        if (next > end) {
            i3 = 1;
        } else {
            i3 = -1;
        }
        View view = null;
        while (end != next) {
            View A5d = this.A01.A5d(end);
            this.A00.A04(childStart, A6e, this.A01.A5g(A5d), this.A01.A5f(A5d));
            if (i != 0) {
                this.A00.A02();
                this.A00.A03(i);
                if (this.A00.A05()) {
                    return A5d;
                }
            }
            if (i2 != 0) {
                this.A00.A02();
                this.A00.A03(i2);
                if (this.A00.A05()) {
                    view = A5d;
                }
            }
            end += i3;
        }
        return view;
    }
}
