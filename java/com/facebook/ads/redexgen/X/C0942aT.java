package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.aT  reason: case insensitive filesystem */
public final class C0942aT implements HM {
    public static byte[] A06;
    public static String[] A07;
    public long A00;
    public Uri A01;
    public InputStream A02;
    public boolean A03;
    public final AssetManager A04;
    public final AbstractC0441Hh<? super C0942aT> A05;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 54);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A06 = new byte[]{107, 98, 44, 35, 41, 63, 34, 36, 41, 18, 44, 62, 62, 40, 57, 98};
    }

    public static void A02() {
        A07 = new String[]{"pM08nT1ncmNJ", "g85", "nscQf0o4Li7UcF904CUq0pnhLdimh0nx", "F8VXv1qVoFp68OVo6WPqVPomjNx", "ZQ8cSAnJS", "Qhc2B", "YeRFTalD9", "SLGuxMrf5R7JWBKvcRLC7wUDDVq2YQ4u"};
    }

    public C0942aT(Context context, AbstractC0441Hh<? super C0942aT> hh) {
        this.A04 = context.getAssets();
        this.A05 = hh;
    }

    @Override // com.facebook.ads.redexgen.X.HM
    public final Uri A7C() {
        return this.A01;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0087, code lost:
        if (r3 != 0) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0096, code lost:
        if (r3 != 0) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x009d, code lost:
        r8.A00 = (long) r8.A02.available();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00ad, code lost:
        if (r8.A00 != 2147483647L) goto L_0x00b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00af, code lost:
        r8.A00 = -1;
     */
    @Override // com.facebook.ads.redexgen.X.HM
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long ABP(com.facebook.ads.redexgen.X.HQ r9) throws com.facebook.ads.redexgen.X.HF {
        /*
        // Method dump skipped, instructions count: 202
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0942aT.ABP(com.facebook.ads.redexgen.X.HQ):long");
    }

    @Override // com.facebook.ads.redexgen.X.HM
    public final void close() throws HF {
        this.A01 = null;
        try {
            if (this.A02 != null) {
                this.A02.close();
            }
            this.A02 = null;
            if (this.A03) {
                this.A03 = false;
                AbstractC0441Hh<? super C0942aT> hh = this.A05;
                if (hh != null) {
                    hh.AB9(this);
                }
            }
        } catch (IOException e) {
            throw new HF(e);
        } catch (Throwable th) {
            this.A02 = null;
            if (this.A03) {
                this.A03 = false;
                AbstractC0441Hh<? super C0942aT> hh2 = this.A05;
                if (hh2 != null) {
                    hh2.AB9(this);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Multiple debug info for r8v0 'this'  com.facebook.ads.redexgen.X.aT: [D('bytesToRead' int), D('bytesRead' int)] */
    @Override // com.facebook.ads.redexgen.X.HM
    public final int read(byte[] bArr, int i, int i2) throws HF {
        if (i2 == 0) {
            return 0;
        }
        long j = this.A00;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, (long) i2);
            } catch (IOException e) {
                throw new HF(e);
            }
        }
        int read = this.A02.read(bArr, i, i2);
        if (read != -1) {
            long j2 = this.A00;
            if (j2 != -1) {
                this.A00 = j2 - ((long) read);
            }
            AbstractC0441Hh<? super C0942aT> hh = this.A05;
            if (hh != null) {
                hh.A95(this, read);
            }
            return read;
        } else if (this.A00 == -1) {
            return -1;
        } else {
            throw new HF(new EOFException());
        }
    }
}
