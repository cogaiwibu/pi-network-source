package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.offline.DownloadAction;
import com.ironsource.sdk.precache.DownloadManager;
import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Ef */
public final class RunnableC0365Ef implements Runnable {
    public static byte[] A08;
    public static String[] A09;
    public Thread A00;
    public Throwable A01;
    public final int A02;
    public final int A03;
    public final DownloadAction A04;
    public final C0368Ei A05;
    public volatile int A06;
    public volatile AbstractC0372Em A07;

    static {
        A0C();
        A0B();
    }

    public static String A07(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A08, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A09[2].charAt(18) != 'Y') {
                String[] strArr = A09;
                strArr[4] = "noItpERo7CNNkHWI";
                strArr[4] = "noItpERo7CNNkHWI";
                if (i4 >= length) {
                    return new String(copyOfRange);
                }
                copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 26);
                i4++;
            } else {
                throw new RuntimeException();
            }
        }
    }

    public static void A0B() {
        A08 = new byte[]{74, 97, 121, 96, 98, 97, 111, 106, 46, 107, 124, 124, 97, 124, 32, 46, 92, 107, 122, 124, 119, 46, 20, 35, 53, 35, 50, 102, 35, 52, 52, 41, 52, 102, 37, 41, 51, 40, 50, 104, 102, 34, 41, 49, 40, 42, 41, 39, 34, 35, 34, 4, 63, 50, 35, 53, 102, 123, 102, 120, 77, 95, 71, 12, 69, 95, 12, 95, 88, 77, 94, 88, 73, 72};
    }

    public static void A0C() {
        A09 = new String[]{"KOAWbsFFbfk0jNgDY62WpIsFaQMswz1L", "pC7XDjTrGSoCHMQrO1sG15bqJEuDqJQJ", "uN2VaEj4rnuk1e19MnznGB1XwQ8yCVfE", "6JBJvnr9DSzDH8E8QP73ZcoxgSr1ahx0", "ultRdxrvkIUuntIMLaCfX8e7z", "lHTnNhXeBOI0IY3AJtGeZO2cjDNAOeyF", "OUHreehzciBJFgJNDowFbwPiXi5p615H", "Ps2SQ7luP6kIA6gbjSFjdYKTtXuPzT18"};
    }

    public RunnableC0365Ef(int i, C0368Ei ei, DownloadAction downloadAction, int i2) {
        this.A02 = i;
        this.A05 = ei;
        this.A04 = downloadAction;
        this.A06 = 0;
        this.A03 = i2;
    }

    public /* synthetic */ RunnableC0365Ef(int i, C0368Ei ei, DownloadAction downloadAction, int i2, EX ex) {
        this(i, ei, downloadAction, i2);
    }

    private final float A00() {
        if (this.A07 != null) {
            return this.A07.A62();
        }
        return -1.0f;
    }

    private int A01() {
        int i = this.A06;
        if (i != 5) {
            String[] strArr = A09;
            if (strArr[7].charAt(26) != strArr[1].charAt(26)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A09;
            strArr2[6] = "vqOmrLNCQqkZmFNmkdUDZ8pThcmdYove";
            strArr2[3] = "yFowKLjp7WUTebccThRrdi4MGh2wopLF";
            if (i == 6 || i == 7) {
                return 1;
            }
            return this.A06;
        } else if (A09[2].charAt(18) != 'Y') {
            String[] strArr3 = A09;
            strArr3[7] = "PDzOFNAaWMsAK9ucradbIEZZH9uUUiPx";
            strArr3[1] = "5zRQ9og93WQ9CsswYkuffD8bWtu0S7Rl";
            return 0;
        } else {
            throw new RuntimeException();
        }
    }

    private int A02(int i) {
        return Math.min((i - 1) * 1000, (int) DownloadManager.OPERATION_TIMEOUT);
    }

    private final long A05() {
        if (this.A07 != null) {
            return this.A07.A63();
        }
        return 0;
    }

    /* access modifiers changed from: public */
    private void A08() {
        if (A0G(0, 5)) {
            this.A05.A07.post(new RunnableC0362Ec(this));
        } else if (A0G(1, 6)) {
            A09();
        }
    }

    private void A09() {
        if (this.A07 != null) {
            this.A07.cancel();
        }
        this.A00.interrupt();
    }

    /* access modifiers changed from: public */
    private void A0A() {
        if (A0G(0, 1)) {
            this.A00 = new Thread(this);
            this.A00.start();
        }
    }

    /* access modifiers changed from: public */
    private boolean A0F() {
        return this.A06 == 0;
    }

    /* access modifiers changed from: public */
    private boolean A0G(int i, int i2) {
        return A0H(i, i2, null);
    }

    /* access modifiers changed from: public */
    private boolean A0H(int i, int i2, Throwable th) {
        boolean z = false;
        if (this.A06 != i) {
            return false;
        }
        this.A06 = i2;
        this.A01 = th;
        if (this.A06 != A01()) {
            z = true;
        }
        if (!z) {
            this.A05.A0F(this);
        }
        return true;
    }

    public final C0367Eh A0L() {
        return new C0367Eh(this.A02, this.A04, A01(), A00(), A05(), this.A01, null);
    }

    public final boolean A0M() {
        return this.A06 == 5 || this.A06 == 1 || this.A06 == 7 || this.A06 == 6;
    }

    public final boolean A0N() {
        return this.A06 == 4 || this.A06 == 2 || this.A06 == 3;
    }

    public final void run() {
        if (!KU.A02(this)) {
            try {
                C0368Ei.A0K(A07(59, 15, 54), this);
                Throwable th = null;
                try {
                    this.A07 = this.A04.A08(this.A05.A0A);
                    if (this.A04.A03) {
                        this.A07.remove();
                    } else {
                        int i = 0;
                        long j = -1;
                        while (!Thread.interrupted()) {
                            try {
                                this.A07.A4q();
                                break;
                            } catch (IOException e) {
                                long A63 = this.A07.A63();
                                if (A63 != j) {
                                    C0368Ei.A0K(A07(22, 37, 92) + A63, this);
                                    j = A63;
                                    i = 0;
                                }
                                if (this.A06 != 1 || (i = i + 1) > this.A03) {
                                    throw e;
                                }
                                C0368Ei.A0K(A07(0, 22, 20) + i, this);
                                Thread.sleep((long) A02(i));
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
                this.A05.A07.post(new RunnableC0363Ed(this, th));
            } catch (Throwable th3) {
                KU.A00(th3, this);
            }
        }
    }

    public final String toString() {
        return super.toString();
    }
}
