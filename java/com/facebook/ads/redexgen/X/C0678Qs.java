package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.Nullable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

@SuppressLint({"BadMethodUse-java.lang.String.length"})
/* renamed from: com.facebook.ads.redexgen.X.Qs  reason: case insensitive filesystem */
public final class C0678Qs implements AnonymousClass00 {
    public static byte[] A09;
    public static String[] A0A;
    public static final String A0B = C0678Qs.class.getSimpleName();
    public final int A00;
    public final int A01;
    public final AnonymousClass08 A02;
    public final AnonymousClass0A A03;
    public final AnonymousClass0M A04;
    public final AnonymousClass8H A05;
    public final Map<String, File> A06 = Collections.synchronizedMap(new HashMap());
    public final Map<String, Semaphore> A07 = new HashMap();
    public final boolean A08;

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A09, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            int i5 = copyOfRange[i4] - i3;
            String[] strArr = A0A;
            if (strArr[5].length() != strArr[7].length()) {
                String[] strArr2 = A0A;
                strArr2[5] = "m9U6X0moZlc";
                strArr2[7] = "IfCNkNm6kG";
                copyOfRange[i4] = (byte) (i5 - 76);
            } else {
                throw new RuntimeException();
            }
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A09 = new byte[]{-105, -33, -40, -22, -105, -39, -36, -36, -27, -105, -32, -27, -21, -36, -23, -23, -20, -25, -21, -36, -37, -91, -63, -75, -5, -2, 1, -6, -75, -8, 1, -6, -10, 3, -6, -7, -49, -75, -125, 117, -106, -55, -55, -70, -62, -59, -55, -113, 117, -7, 23, 25, 30, 31, 36, 29, -42, 28, 31, 34, 27, -42, 25, 37, 35, 38, 34, 27, 42, 27, 4, 34, 36, 41, 42, 47, 40, -31, 39, 42, 45, 38, -31, 47, 48, 53, -31, 36, 48, 46, 49, 45, 38, 53, 38, -31, -91, -61, -59, -54, -53, -48, -55, -126, -47, -56, -126, -32, -2, 11, -60, 17, -67, 0, 9, 12, 16, 2, -67, 0, -2, 0, 5, 2, -67, 3, 6, 9, 2, -53, -80, -50, -37, -108, -31, -115, -33, -46, -50, -47, -115, -50, -32, -32, -46, -31, -32, -101, -69, -39, -26, -97, -20, -104, -22, -35, -39, -36, -104, -28, -35, -26, -33, -20, -32, -104, -25, -34, -104, -72, -39, -32, -39, -24, -35, -30, -37, -108, -41, -43, -41, -36, -39, -108, -38, -35, -32, -39, -108, -43, -38, -24, -39, -26, -108, -39, -20, -41, -39, -39, -40, -35, -30, -37, -108, -26, -39, -24, -26, -19, -108, -43, -24, -24, -39, -31, -28, -24, -25, -82, -108, -43, 2, 2, -1, 2, -80, -13, -15, -13, -8, -7, -2, -9, -80, 4, -8, -11, -80, -10, -7, -4, -11, -54, -9, -9, -12, -9, -91, -24, -15, -22, -26, -13, -18, -13, -20, -91, -21, -18, -15, -22, -72, -27, -27, -30, -27, -109, -42, -33, -30, -26, -36, -31, -38, -109, -26, -30, -24, -27, -42, -40, -72, -35, -46, -34, -36, -33, -37, -44, -29, -44, -113, -31, -44, -30, -33, -34, -35, -30, -44, -99, -65, -35, -28, -44, -39, -46, -117, -33, -38, -117, -35, -48, -52, -49, -117, -73, -55, -55, -69, -54, -112, -123, -123, -123, -13, -10, -7, -14, -57, -68, -68, -68, -18, -5, -15, -1, -4, -10, -15, -20, -18, 0, 0, -14, 1, -68};
        String[] strArr = A0A;
        if (strArr[1].charAt(5) != strArr[3].charAt(5)) {
            String[] strArr2 = A0A;
            strArr2[6] = "1YrvosXM8zHw8wsMUb3ulJ8Xgx5scBHO";
            strArr2[6] = "1YrvosXM8zHw8wsMUb3ulJ8Xgx5scBHO";
            return;
        }
        throw new RuntimeException();
    }

    public static void A04() {
        A0A = new String[]{"2hmAfzTadn", "1uDqsMr9wv4o5ZghfCOZg4FuDp7sllqp", "nT1KYDstdBBAZ5nN", "UVqk4rMzzgqbiyaJgpoGMOUy0jQCoEBq", "ewXxsmpHr", "rT44HeCpkJQ", "C3kiv90mrVS0BL1BSM5Dfu9lHf0n3Csl", "grgxNBq6hb"};
    }

    static {
        A04();
        A03();
    }

    public C0678Qs(AnonymousClass8H r2, AnonymousClass08 r3, AnonymousClass0M r4) {
        this.A05 = r2;
        this.A08 = r3.A02();
        this.A00 = r3.A00();
        this.A04 = r4;
        this.A03 = new AnonymousClass0A();
        this.A01 = r3.A01();
        this.A02 = r3;
    }

    public static AnonymousClass0L A00(Context context, String str) throws AnonymousClass0I {
        try {
            InputStream open = context.getAssets().open(str);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr, 0, bArr.length);
                if (read == -1) {
                    return new C0680Qu(byteArrayOutputStream.toByteArray());
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (IOException e) {
            throw new AnonymousClass0I(A02(130, 18, 33), e);
        }
    }

    @Nullable
    private File A01(AnonymousClass06 r17, String str, String str2, int i, AnonymousClass09 r21) {
        C0682Qw qw;
        AnonymousClass0I e;
        String A022 = A02(221, 22, 68);
        String str3 = str;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            File file = new File(AnonymousClass0B.A00(this.A05), str2);
            C0682Qw qw2 = new C0682Qw(file, new C0391Fh(J8.A0K(this.A05)));
            if (qw2.A0A()) {
                if (this.A08) {
                    String str4 = A02(49, 21, 106) + qw2.A00.getName();
                }
                this.A06.put(str3, file);
                qw2.A07();
                this.A04.AC7(str3, true, r17);
                return file;
            }
            if (this.A08) {
                String str5 = A02(70, 26, 117) + qw2.A00.getName();
            }
            if (!r21.A04()) {
                return null;
            }
            int i2 = 0;
            this.A04.AC7(str3, false, r17);
            while (true) {
                if (i2 >= this.A00) {
                    qw = qw2;
                    break;
                }
                try {
                    str3 = str3;
                    qw = qw2;
                    try {
                        A05(this.A05, qw2, str3, i, i2, currentTimeMillis);
                        break;
                    } catch (AnonymousClass0I e2) {
                        e = e2;
                    }
                } catch (AnonymousClass0I e3) {
                    e = e3;
                    qw = qw2;
                    if (i2 == this.A00 - 1) {
                        A06(qw);
                        if (e instanceof C0681Qv) {
                            throw ((C0681Qv) e);
                        } else if (e instanceof C0684Qy) {
                            throw ((C0684Qy) e);
                        }
                    }
                    i2++;
                    qw2 = qw;
                }
                i2++;
                qw2 = qw;
            }
            int A042 = qw.A04();
            qw.A07();
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            r21.A00().A4B(file, this.A04);
            this.A06.put(str3, file);
            this.A04.AC6(str3, 2112, null, Integer.valueOf(A042), Long.valueOf(currentTimeMillis2), r17);
            return file;
        } catch (C0681Qv e4) {
            this.A04.AC6(str3, 2119, e4.toString(), null, null, r17);
            if (!this.A08) {
                return null;
            }
            Log.e(A0B, A022, e4);
            return null;
        } catch (C0684Qy e5) {
            this.A04.AC6(str3, 2113, e5.toString(), null, null, r17);
            if (!this.A08) {
                return null;
            }
            Log.e(A0B, A022, e5);
            return null;
        }
    }

    /* JADX INFO: Multiple debug info for r0v3 com.facebook.ads.redexgen.X.0L: [D('source' com.facebook.ads.redexgen.X.0L), D('code' int)] */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01ad, code lost:
        if (r5 != false) goto L_0x01af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01b5, code lost:
        if (r5 != false) goto L_0x01af;
     */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0165  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void A05(android.content.Context r24, com.facebook.ads.redexgen.X.C0682Qw r25, java.lang.String r26, int r27, int r28, long r29) throws com.facebook.ads.redexgen.X.AnonymousClass0I {
        /*
        // Method dump skipped, instructions count: 440
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0678Qs.A05(android.content.Context, com.facebook.ads.redexgen.X.Qw, java.lang.String, int, int, long):void");
    }

    /* JADX INFO: Multiple debug info for r6v0 'this'  com.facebook.ads.redexgen.X.Qs: [D('e' java.lang.Exception), D('cacheFile' java.io.File)] */
    @SuppressLint({"CatchGeneralException"})
    private void A06(C0682Qw qw) {
        try {
            File A052 = qw.A05();
            if (A052.exists()) {
                qw.A07();
                boolean delete = A052.delete();
                if (this.A08) {
                    String str = A0B;
                    Log.i(str, A02(169, 52, 40) + delete);
                }
            }
        } catch (Exception e) {
            if (this.A08) {
                Log.e(A0B, A02(107, 23, 81), e);
            }
        }
    }

    private boolean A07(C0682Qw qw) {
        try {
            qw.A06();
            return true;
        } catch (C0684Qy e) {
            boolean z = this.A08;
            if (A0A[6].charAt(7) != 'U') {
                String[] strArr = A0A;
                strArr[6] = "AEs2mSbxTVyMZvMH4XlDgcN9VznTkYzp";
                strArr[6] = "AEs2mSbxTVyMZvMH4XlDgcN9VznTkYzp";
                if (!z) {
                    return false;
                }
                Log.e(A0B, A02(243, 19, 57), e);
                return false;
            }
            throw new RuntimeException();
        }
    }

    /* JADX INFO: Multiple debug info for r12v0 'this'  com.facebook.ads.redexgen.X.Qs: [D('cachedFile' java.io.File), D('baseUrl' java.lang.String)] */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c4, code lost:
        if (r12.A08 != false) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c6, code lost:
        r0 = ((java.lang.String) A02(96, 11, 22)) + r8 + ((java.lang.String) A02(0, 22, 43));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ea, code lost:
        r2 = new com.facebook.ads.redexgen.X.AnonymousClass02<>(false, null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ef, code lost:
        r3.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00f4, code lost:
        monitor-enter(r12.A07);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r12.A07.remove(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00fb, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ff, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0100, code lost:
        r3.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0105, code lost:
        monitor-enter(r12.A07);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        r12.A07.remove(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x010c, code lost:
        throw r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00c2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> com.facebook.ads.redexgen.X.AnonymousClass02<T> A08(com.facebook.ads.redexgen.X.AnonymousClass06 r13, com.facebook.ads.redexgen.X.AnonymousClass09<T> r14) {
        /*
        // Method dump skipped, instructions count: 275
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0678Qs.A08(com.facebook.ads.redexgen.X.06, com.facebook.ads.redexgen.X.09):com.facebook.ads.redexgen.X.02");
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass00
    public final AnonymousClass02<Bitmap> ACX(AnonymousClass06 r9, boolean z) {
        return A08(r9, new AnonymousClass09(new C0676Qq(r9.A01, r9.A00, this.A02.A04(), this.A02.A03(), z)));
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass00
    @Nullable
    public final String ACY(AnonymousClass06 r3) {
        return (String) A08(r3, new AnonymousClass09(new C0677Qr())).A00();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass00
    @Nullable
    public final String ACZ(AnonymousClass06 r3) {
        AnonymousClass09 r1 = new AnonymousClass09(new C0677Qr());
        r1.A01(true);
        r1.A02(false);
        return (String) A08(r3, r1).A00();
    }
}
