package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.aq  reason: case insensitive filesystem */
public final class C0965aq implements HM {
    public static byte[] A07;
    public static String[] A08;
    public long A00;
    public AssetFileDescriptor A01;
    public Uri A02;
    public InputStream A03;
    public boolean A04;
    public final Resources A05;
    public final AbstractC0441Hh<? super C0965aq> A06;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 108);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A07 = new byte[]{70, 113, 103, 123, 97, 102, 119, 113, 52, 125, 112, 113, 122, 96, 125, 114, 125, 113, 102, 52, 121, 97, 103, 96, 52, 118, 113, 52, 117, 122, 52, 125, 122, 96, 113, 115, 113, 102, 58, 7, 0, 27, 114, 63, 39, 33, 38, 114, 39, 33, 55, 114, 33, 49, 58, 55, 63, 55, 114, 32, 51, 37, 32, 55, 33, 61, 39, 32, 49, 55, 117, 102, 112, 117, 98, 116, 104, 114, 117, 100, 98};
    }

    public static void A02() {
        A08 = new String[]{"bSKnstrcEyUtH2EUzSuh7p", "TJp7broMG9ALkddxCeG8bg", "OUGN6fd13DTUK57USEtQiA6N8BMR4vG7", "MPCQ8AeafYWdEx3u0S1dfC5VpPwXU5er", "I2tJ7ud2NszgocKkHkmClXbQ6vlHE0Sp", "WRhnMtRu3VoUyGpCORxDhLZcb6GbN7Pt", "ionJv1BxfCrQS8AxzLJ8Tcnsr6gm7Nx1", "YblFDiTYESfr8ZIRtB8BAyjauKLHc0qm"};
    }

    public C0965aq(Context context, AbstractC0441Hh<? super C0965aq> hh) {
        this.A05 = context.getResources();
        this.A06 = hh;
    }

    @Override // com.facebook.ads.redexgen.X.HM
    public final Uri A7C() {
        return this.A02;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0090, code lost:
        if (r1 != -1) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00a1, code lost:
        if (r1 != -1) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00a8, code lost:
        r2 = r7.A01.getLength();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00b0, code lost:
        if (r2 != -1) goto L_0x00b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00b2, code lost:
        r7.A00 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00b5, code lost:
        r4 = r2 - r8.A03;
     */
    @Override // com.facebook.ads.redexgen.X.HM
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long ABP(com.facebook.ads.redexgen.X.HQ r8) throws com.facebook.ads.redexgen.X.C0440Hg {
        /*
        // Method dump skipped, instructions count: 283
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0965aq.ABP(com.facebook.ads.redexgen.X.HQ):long");
    }

    @Override // com.facebook.ads.redexgen.X.HM
    public final void close() throws C0440Hg {
        this.A02 = null;
        try {
            if (this.A03 != null) {
                this.A03.close();
            }
            this.A03 = null;
            try {
                if (this.A01 != null) {
                    this.A01.close();
                }
                this.A01 = null;
                if (this.A04) {
                    this.A04 = false;
                    AbstractC0441Hh<? super C0965aq> hh = this.A06;
                    if (hh != null) {
                        hh.AB9(this);
                    }
                }
            } catch (IOException e) {
                throw new C0440Hg(e);
            } catch (Throwable th) {
                this.A01 = null;
                if (this.A04) {
                    this.A04 = false;
                    AbstractC0441Hh<? super C0965aq> hh2 = this.A06;
                    if (hh2 != null) {
                        hh2.AB9(this);
                    }
                }
                throw th;
            }
        } catch (IOException e2) {
            throw new C0440Hg(e2);
        } catch (Throwable th2) {
            this.A03 = null;
            try {
                if (this.A01 != null) {
                    this.A01.close();
                }
                this.A01 = null;
                if (this.A04) {
                    this.A04 = false;
                    AbstractC0441Hh<? super C0965aq> hh3 = this.A06;
                    if (hh3 != null) {
                        hh3.AB9(this);
                    }
                }
                throw th2;
            } catch (IOException e3) {
                throw new C0440Hg(e3);
            } catch (Throwable th3) {
                this.A01 = null;
                if (this.A04) {
                    this.A04 = false;
                    AbstractC0441Hh<? super C0965aq> hh4 = this.A06;
                    if (hh4 != null) {
                        hh4.AB9(this);
                    }
                }
                throw th3;
            }
        }
    }

    /* JADX INFO: Multiple debug info for r8v0 'this'  com.facebook.ads.redexgen.X.aq: [D('bytesToRead' int), D('bytesRead' int)] */
    @Override // com.facebook.ads.redexgen.X.HM
    public final int read(byte[] bArr, int i, int i2) throws C0440Hg {
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
                throw new C0440Hg(e);
            }
        }
        int read = this.A03.read(bArr, i, i2);
        if (read != -1) {
            long j2 = this.A00;
            if (j2 != -1) {
                this.A00 = j2 - ((long) read);
            }
            AbstractC0441Hh<? super C0965aq> hh = this.A06;
            if (hh != null) {
                hh.A95(this, read);
            }
            return read;
        } else if (this.A00 == -1) {
            return -1;
        } else {
            throw new C0440Hg(new EOFException());
        }
    }
}
