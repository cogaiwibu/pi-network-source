package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.facebook.ads.internal.exoplayer2.Format;
import java.util.Collections;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.32  reason: invalid class name */
public final class AnonymousClass32 extends AbstractC0313Cd implements Handler.Callback {
    public static String[] A0D;
    public int A00;
    public int A01;
    public Format A02;
    public AbstractC0923aA A03;
    public C0283Aq A04;
    public AbstractC0269Ab A05;
    public AbstractC0269Ab A06;
    public boolean A07;
    public boolean A08;
    public final Handler A09;
    public final AH A0A;
    public final GI A0B;
    public final GJ A0C;

    static {
        A05();
    }

    public static void A05() {
        A0D = new String[]{"fagSsoac43UJSJG", "PL0Df5XObPsMjoFT3sU6Lp83XbviyP8R", "k75ap2fxOZvkqr2FjEQ9d3Y", "qEZm9kPptvCV49j1bDgJYwonF92a", "8QH8MqTnW7KMzd9bL", "CjrIcpNXno9M2QOeMZvTD2WdktHrPs5P", "AfT76Pf2kDJi2th", "sZbuEqgSWLt9Albo4x4yfDH"};
    }

    public AnonymousClass32(GJ gj, Looper looper) {
        this(gj, looper, GI.A00);
    }

    public AnonymousClass32(GJ gj, Looper looper, GI gi) {
        super(3);
        Handler handler;
        this.A0C = (GJ) I1.A01(gj);
        if (looper == null) {
            handler = null;
        } else {
            handler = new Handler(looper, this);
        }
        this.A09 = handler;
        this.A0B = gi;
        this.A0A = new AH();
    }

    private long A00() {
        int i = this.A01;
        if (i == -1 || i >= this.A06.A6F()) {
            return Long.MAX_VALUE;
        }
        return this.A06.A6E(this.A01);
    }

    private void A01() {
        A07(Collections.emptyList());
    }

    private void A02() {
        this.A04 = null;
        this.A01 = -1;
        AbstractC0269Ab ab = this.A06;
        if (ab != null) {
            ab.A08();
            this.A06 = null;
        }
        AbstractC0269Ab ab2 = this.A05;
        if (ab2 != null) {
            ab2.A08();
            this.A05 = null;
        }
    }

    private void A03() {
        A02();
        this.A03.ACD();
        this.A03 = null;
        this.A00 = 0;
    }

    private void A04() {
        A03();
        this.A03 = this.A0B.A4F(this.A02);
    }

    private void A06(List<GF> list) {
        this.A0C.A9I(list);
    }

    private void A07(List<GF> list) {
        Handler handler = this.A09;
        if (handler != null) {
            handler.obtainMessage(0, list).sendToTarget();
        } else {
            A06(list);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0313Cd
    public final void A14() {
        this.A02 = null;
        A01();
        A03();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0313Cd
    public final void A17(long j, boolean z) {
        A01();
        this.A07 = false;
        this.A08 = false;
        if (this.A00 != 0) {
            A04();
            return;
        }
        A02();
        AbstractC0923aA aAVar = this.A03;
        String[] strArr = A0D;
        if (strArr[2].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0D;
        strArr2[1] = "SIdEizz9oP1X0InrrFd2Zym6xF4ie8Hi";
        strArr2[1] = "SIdEizz9oP1X0InrrFd2Zym6xF4ie8Hi";
        aAVar.flush();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0313Cd
    public final void A19(Format[] formatArr, long j) throws A4 {
        this.A02 = formatArr[0];
        if (this.A03 != null) {
            this.A00 = 1;
        } else {
            this.A03 = this.A0B.A4F(this.A02);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0844Xf
    public final boolean A7Z() {
        return this.A08;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0844Xf
    public final boolean A7i() {
        return true;
    }

    /* JADX INFO: Multiple debug info for r9v0 'this'  com.facebook.ads.redexgen.X.32: [D('textRendererNeedsUpdate' boolean), D('e' com.facebook.ads.redexgen.X.GH)] */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009c, code lost:
        if (r6 == 2) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00bd, code lost:
        if (r6 == 2) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c0, code lost:
        A02();
        r9.A08 = true;
     */
    @Override // com.facebook.ads.redexgen.X.AbstractC0844Xf
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ACQ(long r10, long r12) throws com.facebook.ads.redexgen.X.A4 {
        /*
        // Method dump skipped, instructions count: 375
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass32.ACQ(long, long):void");
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0270Ac
    public final int ADS(Format format) {
        if (this.A0B.ADT(format)) {
            return AbstractC0313Cd.A0z(null, format.A0H) ? 4 : 2;
        }
        if (IJ.A0B(format.A0O)) {
            return 1;
        }
        return 0;
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 0) {
            A06((List) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }
}
