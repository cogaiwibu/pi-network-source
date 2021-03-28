package com.facebook.ads.redexgen.X;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.redexgen.X.Hr  reason: case insensitive filesystem */
public final class C0451Hr {
    public static String[] A00;

    static {
        A03();
    }

    /* JADX WARNING: Error to parse debug info: 25 in method: com.facebook.ads.redexgen.X.Hr.A00(com.facebook.ads.redexgen.X.HQ, long, long, com.facebook.ads.redexgen.X.HM, byte[], com.facebook.ads.redexgen.X.IU, int, com.facebook.ads.redexgen.X.Hq):long, file: assets/audience_network.dex
    java.lang.ArrayIndexOutOfBoundsException: 25
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:149)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:111)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:569)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:44)
     */
    public static long A00(HQ hq, long j, long j2, HM hm, byte[] bArr, IU iu, int i, C0450Hq hq2) throws IOException, InterruptedException {
        while (true) {
            if (iu != null) {
                iu.A01(i);
            }
            try {
                break;
            } catch (IT unused) {
            } finally {
                C0466Ig.A0X(hm);
            }
        }
        if (!Thread.interrupted()) {
            HQ hq3 = new HQ(hq.A04, hq.A06, j, (hq.A03 + j) - hq.A01, -1, hq.A05, hq.A00 | 2);
            long ABP = hm.ABP(hq3);
            if (hq2.A01 == -1 && ABP != -1) {
                hq2.A01 = hq3.A01 + ABP;
            }
            long j3 = 0;
            while (true) {
                if (j3 == j2) {
                    break;
                } else if (!Thread.interrupted()) {
                    int read = hm.read(bArr, 0, j2 != -1 ? (int) Math.min((long) bArr.length, j2 - j3) : bArr.length);
                    if (read != -1) {
                        j3 += (long) read;
                        hq2.A02 += (long) read;
                    } else if (hq2.A01 == -1) {
                        hq2.A01 = hq3.A01 + j3;
                    }
                } else {
                    throw new InterruptedException();
                }
            }
            return j3;
        }
        throw new InterruptedException();
    }

    public static void A03() {
        A00 = new String[]{"v79OOCD3rFDrBH3Sw8ccat0nkfR9Jk8K", "zaqJSCMgPr8q8xIyOc2JWspWFv3JOD4h", "Sqp2xVCvxFHsc", "s8GBWRpegr", "t6Y6wcH7Q091ZQl7CdWm1Bgnnklpnco", "XVr0n", "MY0M4GS8ICKTpGygoaRzgsCYiOraPhWK", "Pkt85Yo8hwIimoTAGZdJTyJAkZ2fE06T"};
    }

    public static String A01(Uri uri) {
        return uri.toString();
    }

    public static String A02(HQ hq) {
        return hq.A05 != null ? hq.A05 : A01(hq.A04);
    }

    public static void A04(HQ hq, AbstractC0445Hl hl, C0971aw awVar, byte[] bArr, IU iu, int i, @Nullable C0450Hq hq2, @Nullable AtomicBoolean atomicBoolean, boolean z) throws IOException, InterruptedException {
        long left;
        long j;
        C0450Hq counters = hq2;
        I1.A01(awVar);
        I1.A01(bArr);
        if (counters != null) {
            A05(hq, hl, counters);
        } else {
            counters = new C0450Hq();
        }
        String key = A02(hq);
        long j2 = hq.A01;
        if (hq.A02 != -1) {
            left = hq.A02;
        } else {
            left = hl.A5m(key);
        }
        while (true) {
            long j3 = 0;
            if (left != 0) {
                if (atomicBoolean != null) {
                    boolean z2 = atomicBoolean.get();
                    if (A00[5].length() == 1) {
                        break;
                    }
                    String[] strArr = A00;
                    strArr[5] = "EAlW89nW7uOIImzUc5SW8CQaYz84C";
                    strArr[5] = "EAlW89nW7uOIImzUc5SW8CQaYz84C";
                    if (z2) {
                        throw new InterruptedException();
                    }
                }
                if (left != -1) {
                    j = left;
                } else {
                    j = Long.MAX_VALUE;
                }
                long A5a = hl.A5a(key, j2, j);
                if (A5a <= 0) {
                    long j4 = -A5a;
                    String[] strArr2 = A00;
                    if (strArr2[6].length() != strArr2[1].length()) {
                        break;
                    }
                    String[] strArr3 = A00;
                    strArr3[2] = "OFDha7Ysfl6kB";
                    strArr3[2] = "OFDha7Ysfl6kB";
                    A5a = j4;
                    if (A00(hq, j2, j4, awVar, bArr, iu, i, counters) < A5a) {
                        if (z && left != -1) {
                            throw new EOFException();
                        }
                        return;
                    }
                }
                j2 += A5a;
                if (left != -1) {
                    j3 = A5a;
                }
                left -= j3;
            } else {
                return;
            }
        }
        throw new RuntimeException();
    }

    public static void A05(HQ hq, AbstractC0445Hl hl, C0450Hq hq2) {
        long A5m;
        long j;
        String A02 = A02(hq);
        long j2 = hq.A01;
        if (hq.A02 != -1) {
            A5m = hq.A02;
        } else {
            A5m = hl.A5m(A02);
        }
        hq2.A01 = A5m;
        if (A00[5].length() != 1) {
            String[] strArr = A00;
            strArr[4] = "nu";
            strArr[4] = "nu";
            hq2.A00 = 0;
            hq2.A02 = 0;
            while (A5m != 0) {
                if (A5m != -1) {
                    j = A5m;
                } else {
                    j = Long.MAX_VALUE;
                }
                long start = hl.A5a(A02, j2, j);
                if (start > 0) {
                    hq2.A00 += start;
                } else {
                    start = -start;
                    if (start == Long.MAX_VALUE) {
                        return;
                    }
                }
                j2 += start;
                if (A5m == -1) {
                    start = 0;
                }
                A5m -= start;
            }
            return;
        }
        throw new RuntimeException();
    }

    public static void A06(AbstractC0445Hl hl, String str) {
        for (C0449Hp hp : hl.A5b(str)) {
            if (A00[2].length() != 13) {
                throw new RuntimeException();
            }
            String[] strArr = A00;
            strArr[4] = "R4HmvLUlpWi57h";
            strArr[4] = "R4HmvLUlpWi57h";
            try {
                hl.ACO(hp);
            } catch (C0443Hj unused) {
            }
        }
    }
}
