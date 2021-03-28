package com.facebook.ads.redexgen.X;

import java.util.LinkedList;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.Jj  reason: case insensitive filesystem */
public final class C0493Jj {
    public long A00;
    public final int A01 = 110;
    public final int A02 = 106;
    public final int A03 = 104;
    public final int A04 = 107;
    public final int A05 = 108;
    public final int A06 = 109;
    public final int A07 = 101;
    public final int A08 = 103;
    public final int A09 = 105;
    public final int A0A = 102;
    public final AbstractC0491Jh A0B;
    public final String A0C = C0493Jj.class.getSimpleName();
    public final List<C0492Ji> A0D;
    public final boolean A0E;
    public final boolean A0F;

    public C0493Jj(AnonymousClass8H r8, AbstractC0491Jh jh) {
        boolean z = false;
        this.A0E = false;
        this.A00 = -1;
        this.A0D = new LinkedList();
        int A0D2 = J9.A0D(r8);
        if (A0D2 < 1) {
            this.A0F = false;
        } else {
            this.A0F = r8.A05().A00() < 1.0d / ((double) A0D2) ? true : z;
        }
        this.A0B = jh;
    }

    private int A00() {
        return this.A0B.A5s();
    }

    private int A01() {
        if (this.A00 > 0) {
            return (int) (System.currentTimeMillis() - this.A00);
        }
        return -1;
    }

    private void A03(C0492Ji ji) {
        synchronized (this.A0D) {
            this.A0D.add(ji);
        }
    }

    public final void A04() {
        if (this.A0F) {
            A03(new C0492Ji(A01(), 110, A00(), null));
        }
    }

    public final void A05() {
        if (this.A0F) {
            A03(new C0492Ji(A01(), 106, A00(), null));
        }
    }

    public final void A06() {
        if (this.A0F) {
            A03(new C0492Ji(A01(), 104, A00(), null));
        }
    }

    public final void A07() {
        if (this.A0F) {
            A03(new C0492Ji(A01(), 109, -1, null));
        }
    }

    public final void A08() {
        if (this.A0F) {
            A03(new C0492Ji(A01(), 107, A00(), null));
        }
    }

    public final void A09() {
        if (this.A0F) {
            A03(new C0492Ji(A01(), 108, A00(), null));
        }
    }

    public final void A0A() {
        if (this.A0F) {
            this.A00 = System.currentTimeMillis();
            A03(new C0492Ji(0, 101, -1, null));
        }
    }

    public final void A0B() {
        if (this.A0F) {
            A03(new C0492Ji(A01(), 105, A00(), null));
        }
    }

    public final void A0C() {
        if (this.A0F) {
            A03(new C0492Ji(A01(), 102, A00(), null));
        }
    }

    public final void A0D(AnonymousClass8H r6, String str) {
        if (this.A0F) {
            A03(new C0492Ji(A01(), 103, A00(), null));
            ExecutorC0540Lj.A06.execute(new RunnableC0490Jg(this, str, r6));
        }
    }
}
