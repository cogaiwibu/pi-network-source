package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.decoder.SimpleDecoder;
import com.facebook.ads.redexgen.X.AbstractC0862Xx;
import com.facebook.ads.redexgen.X.C0861Xw;
import java.lang.Exception;
import java.util.ArrayDeque;

/* renamed from: com.facebook.ads.redexgen.X.Xy  reason: case insensitive filesystem */
public abstract class AbstractC0863Xy<I extends C0861Xw, O extends AbstractC0862Xx, E extends Exception> implements AbstractC0296Bd<I, O, E> {
    public static String[] A0D;
    public int A00;
    public int A01;
    public int A02;
    public I A03;
    public E A04;
    public boolean A05;
    public boolean A06;
    public final Object A07 = new Object();
    public final Thread A08;
    public final ArrayDeque<I> A09 = new ArrayDeque<>();
    public final ArrayDeque<O> A0A = new ArrayDeque<>();
    public final I[] A0B;
    public final O[] A0C;

    static {
        A0O();
    }

    public static void A0O() {
        A0D = new String[]{"Gkl", "qMMBfBKIWMYZs", "JMr5TMdVlQ7lAxQbe7gmsO3TMTXZHZrx", "k", "fplFQmQDWPfBEKatf3t9LdZAMaYE90Yr", "qk38PGrA", "BZh", "ypodQLxrY5Mqx0yNqiahJYpo"};
    }

    public abstract I A0V();

    public abstract O A0X();

    public abstract E A0Y(I i, O o, boolean z);

    public abstract E A0Z(Throwable th);

    public AbstractC0863Xy(I[] iArr, O[] oArr) {
        this.A0B = iArr;
        this.A00 = iArr.length;
        for (int i = 0; i < this.A00; i++) {
            this.A0B[i] = A0V();
        }
        this.A0C = oArr;
        this.A01 = oArr.length;
        for (int i2 = 0; i2 < this.A01; i2++) {
            this.A0C[i2] = A0X();
        }
        this.A08 = new C0298Bg(this);
        this.A08.start();
    }

    private void A0L() {
        if (A0S()) {
            this.A07.notify();
        }
    }

    private void A0M() throws Exception {
        SimpleDecoder<I, O, E> simpleDecoder = this.A04;
        if (simpleDecoder != null) {
            throw simpleDecoder;
        }
    }

    /* access modifiers changed from: private */
    public void A0N() {
        while (A0T()) {
            try {
            } catch (InterruptedException e) {
                throw new IllegalStateException((Throwable) e);
            }
        }
    }

    private void A0P(I i) {
        i.A07();
        I[] iArr = this.A0B;
        int i2 = this.A00;
        this.A00 = i2 + 1;
        iArr[i2] = i;
    }

    private void A0Q(O o) {
        o.A07();
        O[] oArr = this.A0C;
        int i = this.A01;
        this.A01 = i + 1;
        oArr[i] = o;
    }

    private boolean A0S() {
        return !this.A09.isEmpty() && this.A01 > 0;
    }

    /* JADX INFO: Multiple debug info for r8v0 'this'  com.facebook.ads.redexgen.X.Xy<I extends com.facebook.ads.redexgen.X.Xw, O extends com.facebook.ads.redexgen.X.Xx, E extends java.lang.Exception>: [D('e' java.lang.OutOfMemoryError), D('e' java.lang.RuntimeException)] */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (r4.A04() == false) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        r3.A00(4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0059, code lost:
        if (r4.A03() == false) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005b, code lost:
        r3.A00(Integer.MIN_VALUE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r8.A04 = A0Y(r4, r3, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0067, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0068, code lost:
        r8.A04 = A0Z(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006f, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0070, code lost:
        r2 = com.facebook.ads.redexgen.X.AbstractC0863Xy.A0D;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0080, code lost:
        if (r2[1].length() != r2[7].length()) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0082, code lost:
        r2 = com.facebook.ads.redexgen.X.AbstractC0863Xy.A0D;
        r2[1] = "JmdauonVcnINF";
        r2[7] = "vppaV7cv17cCxaH2hgZaXUeE";
        r8.A04 = A0Z(r6);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean A0T() throws java.lang.InterruptedException {
        /*
        // Method dump skipped, instructions count: 220
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC0863Xy.A0T():boolean");
    }

    /* renamed from: A0U */
    public final I A4h() throws Exception {
        SimpleDecoder<I, O, E> simpleDecoder;
        SimpleDecoder<I, O, E> simpleDecoder2;
        synchronized (this.A07) {
            A0M();
            I1.A04(this.A03 == null);
            if (this.A00 == 0) {
                simpleDecoder = null;
            } else {
                SimpleDecoder<I, O, E>[] simpleDecoderArr = this.A0B;
                int i = this.A00 - 1;
                this.A00 = i;
                simpleDecoder = simpleDecoderArr[i];
            }
            this.A03 = simpleDecoder;
            simpleDecoder2 = this.A03;
        }
        return simpleDecoder2;
    }

    /* renamed from: A0W */
    public final O A4i() throws Exception {
        synchronized (this.A07) {
            A0M();
            if (this.A0A.isEmpty()) {
                return null;
            }
            return this.A0A.removeFirst();
        }
    }

    /* JADX INFO: Multiple debug info for r0v4 I extends com.facebook.ads.redexgen.X.Xw: [D('this' com.facebook.ads.internal.exoplayer2.decoder.SimpleDecoder<I extends com.facebook.ads.redexgen.X.Xw, O extends com.facebook.ads.redexgen.X.Xx, E extends java.lang.Exception>), D('inputBuffer' I extends com.facebook.ads.redexgen.X.Xw)] */
    public final void A0a(int i) {
        boolean z;
        if (this.A00 == this.A0B.length) {
            z = true;
        } else {
            z = false;
        }
        I1.A04(z);
        for (I inputBuffer : this.A0B) {
            inputBuffer.A09(i);
        }
    }

    /* renamed from: A0b */
    public final void ABw(I i) throws Exception {
        synchronized (this.A07) {
            A0M();
            I1.A03(i == this.A03);
            this.A09.addLast(i);
            A0L();
            this.A03 = null;
        }
    }

    public void A0c(O o) {
        synchronized (this.A07) {
            A0Q(o);
            A0L();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0296Bd
    public final void ACD() {
        synchronized (this.A07) {
            this.A06 = true;
            this.A07.notify();
        }
        try {
            this.A08.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0296Bd
    public final void flush() {
        synchronized (this.A07) {
            this.A05 = true;
            this.A02 = 0;
            if (this.A03 != null) {
                A0P(this.A03);
                this.A03 = null;
            }
            while (!this.A09.isEmpty()) {
                A0P(this.A09.removeFirst());
            }
            while (!this.A0A.isEmpty()) {
                A0Q(this.A0A.removeFirst());
            }
        }
    }
}
