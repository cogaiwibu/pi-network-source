package com.facebook.ads.redexgen.X;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public abstract class AV implements AbstractC0923aA {
    public static String[] A06;
    public long A00;
    public long A01;
    public C00882p A02;
    public final ArrayDeque<C00882p> A03 = new ArrayDeque<>();
    public final ArrayDeque<AbstractC0269Ab> A04;
    public final PriorityQueue<C00882p> A05;

    static {
        A0L();
    }

    public static void A0L() {
        A06 = new String[]{"xrToQ1M30eypgaiDt2KcbeXQSJmH4zEy", "FOMm0GJvPogulFgRKU73d9QQGInBRxBZ", "DAifx7fz7Oznb", "tEspMkbIuGZVzgapMfnbK02RMeMH6P5b", "hnmT", "jbKY175w2AZdEkpyONR9SNFucMTvW6Vd", "vt70xpgsPpIXmuxmiV", "wsDuhCL"};
    }

    public abstract GG A0N();

    public abstract void A0R(C0283Aq aq);

    public abstract boolean A0T();

    public AV() {
        for (int i = 0; i < 10; i++) {
            this.A03.add(new C00882p());
        }
        this.A04 = new ArrayDeque<>();
        for (int i2 = 0; i2 < 2; i2++) {
            this.A04.add(new C00872o(this));
        }
        this.A05 = new PriorityQueue<>();
    }

    private void A0M(C00882p r2) {
        r2.A07();
        this.A03.add(r2);
    }

    /* renamed from: A0O */
    public C0283Aq A4h() throws GH {
        boolean z;
        if (this.A02 == null) {
            z = true;
        } else {
            z = false;
        }
        I1.A04(z);
        if (this.A03.isEmpty()) {
            return null;
        }
        this.A02 = this.A03.pollFirst();
        return this.A02;
    }

    /* renamed from: A0P */
    public AbstractC0269Ab A4i() throws GH {
        if (this.A04.isEmpty()) {
            return null;
        }
        while (!this.A05.isEmpty() && ((C0861Xw) this.A05.peek()).A00 <= this.A00) {
            C00882p poll = this.A05.poll();
            if (poll.A04()) {
                AbstractC0269Ab pollFirst = this.A04.pollFirst();
                pollFirst.A00(4);
                if (A06[6].length() != 18) {
                    throw new RuntimeException();
                }
                String[] strArr = A06;
                strArr[4] = "hAEA";
                strArr[4] = "hAEA";
                A0M(poll);
                return pollFirst;
            }
            A0R(poll);
            if (A0T()) {
                GG A0N = A0N();
                if (!poll.A03()) {
                    AbstractC0269Ab pollFirst2 = this.A04.pollFirst();
                    pollFirst2.A09(((C0861Xw) poll).A00, A0N, Long.MAX_VALUE);
                    A0M(poll);
                    return pollFirst2;
                }
            }
            A0M(poll);
        }
        return null;
    }

    /* renamed from: A0Q */
    public void ABw(C0283Aq aq) throws GH {
        boolean z;
        if (aq == this.A02) {
            z = true;
        } else {
            z = false;
        }
        I1.A03(z);
        if (aq.A03()) {
            C00882p r3 = this.A02;
            String[] strArr = A06;
            if (strArr[5].charAt(10) != strArr[3].charAt(10)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[5] = "0mhI93daunZi59PwiuGO0KbLyKVCPwQH";
            strArr2[3] = "r2E3xZENv7Zr1SQt92aJBQoSxSc5nrbU";
            A0M(r3);
        } else {
            C00882p r4 = this.A02;
            long j = this.A01;
            this.A01 = 1 + j;
            C00882p.A01(r4, j);
            this.A05.add(this.A02);
        }
        this.A02 = null;
    }

    public final void A0S(AbstractC0269Ab ab) {
        ab.A07();
        this.A04.add(ab);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0296Bd
    public void ACD() {
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0923aA
    public void AD4(long j) {
        this.A00 = j;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0296Bd
    public void flush() {
        this.A01 = 0;
        this.A00 = 0;
        while (!this.A05.isEmpty()) {
            A0M(this.A05.poll());
        }
        C00882p r0 = this.A02;
        if (r0 != null) {
            A0M(r0);
            this.A02 = null;
        }
    }
}
