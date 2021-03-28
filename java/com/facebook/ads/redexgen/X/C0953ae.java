package com.facebook.ads.redexgen.X;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.ae  reason: case insensitive filesystem */
public final class C0953ae implements HM {
    public static byte[] A05;
    public static String[] A06;
    public long A00;
    public Uri A01;
    public RandomAccessFile A02;
    public boolean A03;
    public final AbstractC0441Hh<? super C0953ae> A04;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 31);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{37};
    }

    public static void A02() {
        A06 = new String[]{"l2rBvT9KAEY6yl2SIp", "0cRN39km0cT", "q9WvQr", "pX7zul93kCJ6F7tIXqRnEpKrjeNmhaPh", "ddKujtHDPllkfb3cyYepVcXFvJyDikdo", "gNoa3Z", "AdKzyhJyCrP", "aoyUT4m5l2MLf3LhSWprSpj54sdxW1uC"};
    }

    public C0953ae() {
        this(null);
    }

    public C0953ae(AbstractC0441Hh<? super C0953ae> hh) {
        this.A04 = hh;
    }

    @Override // com.facebook.ads.redexgen.X.HM
    public final Uri A7C() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.HM
    public final long ABP(HQ hq) throws HT {
        long j;
        try {
            this.A01 = hq.A04;
            this.A02 = new RandomAccessFile(hq.A04.getPath(), A00(0, 1, 72));
            this.A02.seek(hq.A03);
            if (hq.A02 == -1) {
                j = this.A02.length() - hq.A03;
            } else {
                j = hq.A02;
            }
            this.A00 = j;
            if (this.A00 >= 0) {
                this.A03 = true;
                AbstractC0441Hh<? super C0953ae> hh = this.A04;
                if (hh != null) {
                    hh.ABA(this, hq);
                }
                long j2 = this.A00;
                if (A06[0].length() != 18) {
                    throw new RuntimeException();
                }
                String[] strArr = A06;
                strArr[7] = "qz0up6ppIELboyns2CZBgMvSr8RDOOhA";
                strArr[3] = "iQKzkqELqDYakLKWZdfSUnFo9DHl6nVv";
                return j2;
            }
            throw new EOFException();
        } catch (IOException e) {
            throw new HT(e);
        }
    }

    @Override // com.facebook.ads.redexgen.X.HM
    public final void close() throws HT {
        this.A01 = null;
        try {
            if (this.A02 != null) {
                this.A02.close();
            }
            this.A02 = null;
            if (this.A03) {
                this.A03 = false;
                AbstractC0441Hh<? super C0953ae> hh = this.A04;
                if (hh != null) {
                    hh.AB9(this);
                }
            }
        } catch (IOException e) {
            throw new HT(e);
        } catch (Throwable th) {
            this.A02 = null;
            if (this.A03) {
                this.A03 = false;
                AbstractC0441Hh<? super C0953ae> hh2 = this.A04;
                if (hh2 != null) {
                    hh2.AB9(this);
                }
            }
            throw th;
        }
    }

    @Override // com.facebook.ads.redexgen.X.HM
    public final int read(byte[] bArr, int i, int i2) throws HT {
        if (i2 == 0) {
            return 0;
        }
        long j = this.A00;
        if (j == 0) {
            return -1;
        }
        try {
            int read = this.A02.read(bArr, i, (int) Math.min(j, (long) i2));
            if (read > 0) {
                this.A00 -= (long) read;
                AbstractC0441Hh<? super C0953ae> hh = this.A04;
                if (hh != null) {
                    hh.A95(this, read);
                }
            }
            return read;
        } catch (IOException e) {
            throw new HT(e);
        }
    }
}
