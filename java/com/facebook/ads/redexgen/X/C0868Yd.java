package com.facebook.ads.redexgen.X;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.drm.DrmInitData;
import com.facebook.ads.internal.exoplayer2.extractor.mp4.Atom;
import com.facebook.ads.internal.exoplayer2.extractor.mp4.DefaultSampleValues;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.onesignal.NotificationBundleProcessor;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.ByteCompanionObject;

/* renamed from: com.facebook.ads.redexgen.X.Yd  reason: case insensitive filesystem */
public final class C0868Yd implements CK {
    public static byte[] A0X;
    public static String[] A0Y;
    public static final CN A0Z = new C0867Yc();
    public static final int A0a = C0466Ig.A08(A0A(682, 4, 24));
    public static final Format A0b = Format.A02(null, A0A(664, 18, 55), Long.MAX_VALUE);
    public static final byte[] A0c = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public long A07;
    public long A08;
    public long A09;
    public long A0A;
    public long A0B;
    public CM A0C;
    public C0333Cx A0D;
    public IQ A0E;
    public boolean A0F;
    public boolean A0G;
    public CW[] A0H;
    public CW[] A0I;
    public final int A0J;
    public final SparseArray<C0333Cx> A0K;
    @Nullable
    public final DrmInitData A0L;
    @Nullable
    public final CW A0M;
    @Nullable
    public final D6 A0N;
    public final IQ A0O;
    public final IQ A0P;
    public final IQ A0Q;
    public final IQ A0R;
    @Nullable
    public final C0462Ic A0S;
    public final ArrayDeque<YX> A0T;
    public final ArrayDeque<C0332Cw> A0U;
    public final List<Format> A0V;
    public final byte[] A0W;

    /* JADX WARNING: Error to parse debug info: 25 in method: com.facebook.ads.redexgen.X.Yd.A04(com.facebook.ads.redexgen.X.IQ, long):android.util.Pair<java.lang.Long, com.facebook.ads.redexgen.X.YC>, file: assets/audience_network.dex
    java.lang.ArrayIndexOutOfBoundsException: 25
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:221)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:127)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:111)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:569)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:44)
     */
    public static Pair<Long, YC> A04(IQ iq, long j) throws AN {
        long A0O2;
        long A0O3;
        iq.A0Z(8);
        int A012 = AbstractC0321Cl.A01(iq.A09());
        iq.A0a(4);
        long A0N2 = iq.A0N();
        if (A012 == 0) {
            A0O2 = iq.A0N();
            A0O3 = j + iq.A0N();
        } else {
            A0O2 = iq.A0O();
            A0O3 = j + iq.A0O();
        }
        long A0F2 = C0466Ig.A0F(A0O2, 1000000, A0N2);
        iq.A0a(2);
        int A0J2 = iq.A0J();
        int[] iArr = new int[A0J2];
        long[] jArr = new long[A0J2];
        long[] jArr2 = new long[A0J2];
        long[] jArr3 = new long[A0J2];
        if (A0Y[2].charAt(18) != 'K') {
            throw new RuntimeException();
        }
        String[] strArr = A0Y;
        strArr[5] = "s";
        strArr[5] = "s";
        int i = 0;
        long j2 = A0F2;
        while (i < A0J2) {
            int A092 = iq.A09();
            if ((Integer.MIN_VALUE & A092) == 0) {
                long A0N3 = iq.A0N();
                iArr[i] = Integer.MAX_VALUE & A092;
                jArr[i] = A0O3;
                jArr3[i] = j2;
                A0O2 += A0N3;
                j2 = C0466Ig.A0F(A0O2, 1000000, A0N2);
                jArr2[i] = j2 - jArr3[i];
                iq.A0a(4);
                int i2 = iArr[i];
                if (A0Y[3].length() != 6) {
                    String[] strArr2 = A0Y;
                    strArr2[1] = "dhc";
                    strArr2[1] = "dhc";
                    A0O3 += (long) i2;
                    i += 0;
                } else {
                    String[] strArr3 = A0Y;
                    strArr3[5] = "h";
                    strArr3[5] = "h";
                    A0O3 += (long) i2;
                    i++;
                }
            } else {
                throw new AN(A0A(581, 28, 75));
            }
        }
        return Pair.create(Long.valueOf(A0F2), new YC(iArr, jArr, jArr2, jArr3));
    }

    public static String A0A(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0X, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 85);
        }
        return new String(copyOfRange);
    }

    public static void A0D() {
        A0X = new byte[]{76, 64, 11, 62, 37, 39, 106, 57, 35, 48, 47, 106, 38, 47, 57, 57, 106, 62, 34, 43, 36, 106, 34, 47, 43, 46, 47, 56, 106, 38, 47, 36, 45, 62, 34, 106, 98, 63, 36, 57, 63, 58, 58, 37, 56, 62, 47, 46, 99, 100, 104, 67, 89, 95, 84, 13, 78, 66, 88, 67, 89, 13, 68, 67, 13, 94, 79, 74, 93, 13, 12, 16, 13, 28, 13, 5, 88, 67, 94, 88, 93, 93, 66, 95, 89, 72, 73, 4, 3, 5, 46, 52, 50, 57, 96, 35, 47, 53, 46, 52, 96, 41, 46, 96, 51, 39, 48, 36, 96, 97, 125, 96, 113, 96, 104, 53, 46, 51, 53, 48, 48, 47, 50, 52, 37, 36, 105, 110, 29, 41, 58, 60, 54, 62, 53, 47, 62, 63, 22, 43, 111, 30, 35, 47, 41, 58, 56, 47, 52, 41, 4, 42, 35, 34, 63, 36, 35, 42, 109, 35, 40, 42, 44, 57, 36, 59, 40, 109, 34, 43, 43, 62, 40, 57, 109, 57, 34, 109, 62, 44, 32, 61, 33, 40, 109, 41, 44, 57, 44, 99, 110, 71, 67, 68, 2, 67, 86, 77, 79, 2, 70, 71, 68, 75, 76, 71, 81, 2, 71, 90, 86, 71, 76, 70, 71, 70, 2, 67, 86, 77, 79, 2, 81, 75, 88, 71, 2, 10, 87, 76, 81, 87, 82, 82, 77, 80, 86, 71, 70, 11, 12, 38, 15, 11, 12, 74, 11, 30, 5, 7, 74, 29, 3, 30, 2, 74, 6, 15, 4, 13, 30, 2, 74, 84, 74, 88, 91, 94, 93, 94, 82, 89, 92, 94, 93, 74, 66, 31, 4, 25, 31, 26, 26, 5, 24, 30, 15, 14, 67, 68, 97, 72, 67, 74, 89, 69, 13, 64, 68, 94, 64, 76, 89, 78, 69, 23, 13, 88, 113, 113, 100, 114, 99, 55, 99, 120, 55, 114, 121, 116, 101, 110, 103, 99, 126, 120, 121, 55, 115, 118, 99, 118, 55, 96, 118, 100, 55, 121, 114, 112, 118, 99, 126, 97, 114, 57, 22, 63, 63, 42, 60, 45, 121, 45, 54, 121, 60, 55, 61, 121, 54, 63, 121, 52, 61, 56, 45, 121, 46, 56, 42, 121, 55, 60, 62, 56, 45, 48, 47, 60, 119, 84, 109, 126, 105, 105, 114, ByteCompanionObject.MAX_VALUE, 114, 117, 124, 59, 79, 105, 122, 120, 112, 94, 117, 120, 105, 98, 107, 111, 114, 116, 117, 89, 116, 99, 59, 107, 122, 105, 122, 118, 126, 111, 126, 105, 104, 59, 114, 104, 59, 110, 117, 104, 110, 107, 107, 116, 105, 111, 126, ByteCompanionObject.MAX_VALUE, 53, 107, 83, 81, 72, 72, 93, 92, 24, 72, 75, 75, 80, 24, 89, 76, 87, 85, 24, 16, 94, 89, 81, 84, 93, 92, 24, 76, 87, 24, 93, 64, 76, 74, 89, 91, 76, 24, 77, 77, 81, 92, 17, 105, 81, 83, 74, 74, 83, 84, 93, 26, 91, 78, 85, 87, 26, 77, 83, 78, 82, 26, 86, 95, 84, 93, 78, 82, 26, 4, 26, 8, 11, 14, 13, 14, 2, 9, 12, 14, 13, 26, 18, 79, 84, 73, 79, 74, 74, 85, 72, 78, 95, 94, 19, 20, 11, 48, 59, 38, 46, 59, 61, 42, 59, 58, 126, 51, 49, 49, 40, 126, 60, 49, 38, 112, 95, 100, 111, 114, 122, 111, 105, 126, 111, 110, 42, 121, 107, 99, 101, 42, 111, 100, 126, 120, 115, 42, 105, 101, ByteCompanionObject.MAX_VALUE, 100, 126, 48, 42, 75, 112, 118, ByteCompanionObject.MAX_VALUE, 112, 122, 114, 123, 122, 62, 119, 112, 122, 119, 108, 123, 125, 106, 62, 108, 123, 120, 123, 108, 123, 112, 125, 123, 41, 30, 13, 22, 30, 29, 19, 26, 95, 19, 26, 17, 24, 11, 23, 95, 27, 26, 12, 28, 13, 22, 15, 11, 22, 16, 17, 95, 22, 17, 95, 12, 24, 15, 27, 95, 25, 16, 10, 17, 27, 95, 87, 10, 17, 12, 10, 15, 15, 16, 13, 11, 26, 27, 86, 3, 18, 18, 14, 11, 1, 3, 22, 11, 13, 12, 77, 26, 79, 7, 15, 17, 5, 62, 40, 36, 42, 46, 49, 60, 61, 55, 119, 48, 61, 46, 59, 61, 34, 47, 46, 36, 100, 38, 59, ByteCompanionObject.MAX_VALUE};
    }

    public static void A0E() {
        A0Y = new String[]{"bw2Pz5UYSLOOesGIJaWlA3GOzVLZPAg", "gG3", "yjdYoV9UEi8qMqqcqGKRK6SXbov0CwAj", "4kzePG", "OMn6r0AgRGwk9BJzU", NotificationBundleProcessor.PUSH_MINIFIED_BUTTONS_LIST, "aMFqcwP4FMZJ2yTkvuTBoGT2vGZy4ax", "h66GloOgbywQ1e6PB204dGM9vAJrPucq"};
    }

    /* JADX WARNING: Error to parse debug info: 13 in method: com.facebook.ads.redexgen.X.Yd.A0N(com.facebook.ads.redexgen.X.YX, android.util.SparseArray<com.facebook.ads.redexgen.X.Cx>, int, byte[]):void, file: assets/audience_network.dex
    java.lang.ArrayIndexOutOfBoundsException: 13
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:221)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:127)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:111)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:569)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:44)
     */
    public static void A0N(YX yx, SparseArray<C0333Cx> sparseArray, int i, byte[] bArr) throws AN {
        C0333Cx A092 = A09(yx.A07(AbstractC0321Cl.A1I).A00, sparseArray);
        if (A092 != null) {
            D8 d8 = A092.A07;
            long j = d8.A06;
            A092.A05();
            if (yx.A07(AbstractC0321Cl.A1H) != null && (i & 2) == 0) {
                j = A02(yx.A07(AbstractC0321Cl.A1H).A00);
            }
            A0O(yx, A092, j, i);
            D7 A002 = A092.A05.A00(d8.A07.A02);
            YY A072 = yx.A07(AbstractC0321Cl.A0u);
            if (A072 != null) {
                A0Q(A002, A072.A00, d8);
            }
            YY A073 = yx.A07(AbstractC0321Cl.A0t);
            if (A073 != null) {
                A0T(A073.A00, d8);
            }
            YY A074 = yx.A07(AbstractC0321Cl.A10);
            if (A074 != null) {
                A0U(A074.A00, d8);
            }
            YY A075 = yx.A07(AbstractC0321Cl.A0x);
            YY A076 = yx.A07(AbstractC0321Cl.A11);
            if (!(A075 == null || A076 == null)) {
                A0W(A075.A00, A076.A00, A002 != null ? A002.A02 : null, d8);
            }
            int size = yx.A02.size();
            for (int i2 = 0; i2 < size; i2++) {
                YY yy = yx.A02.get(i2);
                int i3 = ((AbstractC0321Cl) yy).A00;
                int i4 = AbstractC0321Cl.A1Q;
                if (A0Y[7].charAt(27) != 'r') {
                    throw new RuntimeException();
                }
                String[] strArr = A0Y;
                strArr[6] = "tWuQt3qCpORkhzaHtCNFkUwj420xxTd";
                strArr[4] = "yKRRCTery0iDoE3P4";
                if (i3 == i4) {
                    A0V(yy.A00, d8, bArr);
                }
            }
        }
    }

    static {
        A0E();
        A0D();
    }

    public C0868Yd() {
        this(0);
    }

    public C0868Yd(int i) {
        this(i, null);
    }

    public C0868Yd(int i, @Nullable C0462Ic ic) {
        this(i, ic, null, null);
    }

    public C0868Yd(int i, @Nullable C0462Ic ic, @Nullable D6 d6, @Nullable DrmInitData drmInitData) {
        this(i, ic, d6, drmInitData, Collections.emptyList());
    }

    public C0868Yd(int i, @Nullable C0462Ic ic, @Nullable D6 d6, @Nullable DrmInitData drmInitData, List<Format> closedCaptionFormats) {
        this(i, ic, d6, drmInitData, closedCaptionFormats, null);
    }

    public C0868Yd(int i, @Nullable C0462Ic ic, @Nullable D6 d6, @Nullable DrmInitData drmInitData, List<Format> list, @Nullable CW cw) {
        int i2;
        if (d6 != null) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        this.A0J = i2 | i;
        this.A0S = ic;
        this.A0N = d6;
        this.A0L = drmInitData;
        this.A0V = Collections.unmodifiableList(list);
        this.A0M = cw;
        this.A0O = new IQ(16);
        this.A0R = new IQ(IM.A03);
        this.A0Q = new IQ(5);
        this.A0P = new IQ();
        this.A0W = new byte[16];
        this.A0T = new ArrayDeque<>();
        this.A0U = new ArrayDeque<>();
        this.A0K = new SparseArray<>();
        this.A08 = -9223372036854775807L;
        this.A0A = -9223372036854775807L;
        this.A0B = -9223372036854775807L;
        A0B();
    }

    /* JADX INFO: Multiple debug info for r29v0 int: [D('fullAtom' int), D('workaroundEveryVideoFrameIsSyncFrame' boolean)] */
    /* JADX INFO: Multiple debug info for r2v32 long: [D('defaultSampleValues' com.facebook.ads.redexgen.X.Cr), D('sampleIsSyncFrameTable' boolean[])] */
    /* JADX INFO: Multiple debug info for r5v1 int: [D('defaultSampleValues' com.facebook.ads.redexgen.X.Cr), D('sampleOffset' int)] */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00be, code lost:
        if (r10 != 0) goto L_0x00c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x011f, code lost:
        if (r10 != 0) goto L_0x00c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0122, code lost:
        r22 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int A00(com.facebook.ads.redexgen.X.C0333Cx r28, int r29, long r30, int r32, com.facebook.ads.redexgen.X.IQ r33, int r34) {
        /*
        // Method dump skipped, instructions count: 501
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0868Yd.A00(com.facebook.ads.redexgen.X.Cx, int, long, int, com.facebook.ads.redexgen.X.IQ, int):int");
    }

    public static long A01(IQ iq) {
        iq.A0Z(8);
        return AbstractC0321Cl.A01(iq.A09()) == 0 ? iq.A0N() : iq.A0O();
    }

    public static long A02(IQ iq) {
        iq.A0Z(8);
        return AbstractC0321Cl.A01(iq.A09()) == 1 ? iq.A0O() : iq.A0N();
    }

    public static Pair<Integer, C0327Cr> A03(IQ iq) {
        iq.A0Z(12);
        return Pair.create(Integer.valueOf(iq.A09()), new C0327Cr(iq.A0I() - 1, iq.A0I(), iq.A0I(), iq.A09()));
    }

    public static DrmInitData A05(List<YY> list) {
        ArrayList arrayList = null;
        int i = list.size();
        for (int i2 = 0; i2 < i; i2++) {
            YY yy = list.get(i2);
            if (((AbstractC0321Cl) yy).A00 == AbstractC0321Cl.A0r) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = yy.A00.A00;
                UUID A032 = D3.A03(bArr);
                if (A032 == null) {
                    Log.w(A0A(128, 22, 14), A0A(437, 42, 109));
                } else {
                    arrayList.add(new DrmInitData.SchemeData(A032, A0A(696, 9, 30), bArr));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(arrayList);
    }

    private C0327Cr A06(SparseArray<C0327Cr> sparseArray, int i) {
        if (sparseArray.size() != 1) {
            return (C0327Cr) I1.A01(sparseArray.get(i));
        }
        if (A0Y[7].charAt(27) != 'r') {
            throw new RuntimeException();
        }
        String[] strArr = A0Y;
        strArr[3] = "nw8rk4";
        strArr[3] = "nw8rk4";
        return sparseArray.valueAt(0);
    }

    /* JADX INFO: Multiple debug info for r3v1 com.facebook.ads.redexgen.X.Cx: [D('trackBundlesSize' int), D('trunOffset' long)] */
    public static C0333Cx A07(SparseArray<C0333Cx> sparseArray) {
        C0333Cx cx = null;
        long j = Long.MAX_VALUE;
        int i = sparseArray.size();
        for (int i2 = 0; i2 < i; i2++) {
            C0333Cx valueAt = sparseArray.valueAt(i2);
            if (valueAt.A02 != valueAt.A07.A02) {
                long j2 = valueAt.A07.A0G[valueAt.A02];
                if (j2 < j) {
                    cx = valueAt;
                    j = j2;
                }
            }
        }
        return cx;
    }

    @Nullable
    public static C0333Cx A08(SparseArray<C0333Cx> sparseArray, int i) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        C0333Cx cx = sparseArray.get(i);
        if (A0Y[0].length() != 21) {
            String[] strArr = A0Y;
            strArr[1] = "fYJ";
            strArr[1] = "fYJ";
            return cx;
        }
        throw new RuntimeException();
    }

    /* JADX INFO: Multiple debug info for r0v2 int: [D('trackBundles' android.util.SparseArray<com.facebook.ads.internal.exoplayer2.extractor.mp4.FragmentedMp4Extractor$TrackBundle>), D('trackId' int)] */
    public static C0333Cx A09(IQ iq, SparseArray<C0333Cx> sparseArray) {
        int i;
        int i2;
        int i3;
        int i4;
        iq.A0Z(8);
        int A002 = AbstractC0321Cl.A00(iq.A09());
        C0333Cx A082 = A08(sparseArray, iq.A09());
        if (A082 == null) {
            return null;
        }
        if ((A002 & 1) != 0) {
            long A0O2 = iq.A0O();
            A082.A07.A05 = A0O2;
            A082.A07.A04 = A0O2;
        }
        C0327Cr cr = A082.A04;
        if ((A002 & 2) != 0) {
            i = iq.A0I() - 1;
        } else {
            i = cr.A02;
        }
        if ((A002 & 8) != 0) {
            i2 = iq.A0I();
        } else {
            i2 = cr.A00;
        }
        if ((A002 & 16) != 0) {
            i3 = iq.A0I();
        } else {
            i3 = cr.A03;
        }
        if ((A002 & 32) != 0) {
            i4 = iq.A0I();
        } else {
            i4 = cr.A01;
        }
        A082.A07.A07 = new C0327Cr(i, i2, i3, i4);
        return A082;
    }

    private void A0B() {
        this.A02 = 0;
        this.A00 = 0;
    }

    /* JADX INFO: Multiple debug info for r6v0 'this'  com.facebook.ads.redexgen.X.Yd: [D('emsgTrackOutputCount' int), D('i' int)] */
    private void A0C() {
        if (this.A0I == null) {
            this.A0I = new CW[2];
            int i = 0;
            CW cw = this.A0M;
            if (cw != null) {
                this.A0I[0] = cw;
                i = 0 + 1;
            }
            if ((this.A0J & 4) != 0) {
                this.A0I[i] = this.A0C.ADY(this.A0K.size(), 4);
                i++;
            }
            this.A0I = (CW[]) Arrays.copyOf(this.A0I, i);
            for (CW cw2 : this.A0I) {
                cw2.A5A(A0b);
            }
        }
        if (this.A0H == null) {
            this.A0H = new CW[this.A0V.size()];
            for (int i2 = 0; i2 < this.A0H.length; i2++) {
                CW ADY = this.A0C.ADY(this.A0K.size() + 1 + i2, 3);
                ADY.A5A(this.A0V.get(i2));
                this.A0H[i2] = ADY;
                String[] strArr = A0Y;
                if (strArr[6].length() != strArr[4].length()) {
                    String[] strArr2 = A0Y;
                    strArr2[7] = "E0z9VN5IoStoNoHPwfepvpkncforV8p8";
                    strArr2[7] = "E0z9VN5IoStoNoHPwfepvpkncforV8p8";
                } else {
                    throw new RuntimeException();
                }
            }
        }
    }

    private void A0F(long j) {
        while (!this.A0U.isEmpty()) {
            C0332Cw removeFirst = this.A0U.removeFirst();
            this.A03 -= removeFirst.A00;
            long j2 = j + removeFirst.A01;
            C0462Ic ic = this.A0S;
            if (ic != null) {
                j2 = ic.A07(j2);
            }
            for (CW cw : this.A0I) {
                cw.ACf(j2, 1, removeFirst.A00, this.A03, null);
            }
        }
    }

    private void A0G(long j) throws AN {
        while (!this.A0T.isEmpty() && this.A0T.peek().A00 == j) {
            A0J(this.A0T.pop());
        }
        A0B();
    }

    private void A0H(CL cl) throws IOException, InterruptedException {
        int i = ((int) this.A07) - this.A00;
        IQ iq = this.A0E;
        if (iq != null) {
            cl.readFully(iq.A00, 8, i);
            A0P(new YY(this.A01, this.A0E), cl.A6m());
        } else {
            cl.ADG(i);
        }
        A0G(cl.A6m());
    }

    private void A0I(CL cl) throws IOException, InterruptedException {
        C0333Cx cx = null;
        long j = Long.MAX_VALUE;
        int size = this.A0K.size();
        for (int i = 0; i < size; i++) {
            D8 d8 = this.A0K.valueAt(i).A07;
            if (d8.A0B) {
                int i2 = (d8.A04 > j ? 1 : (d8.A04 == j ? 0 : -1));
                if (A0Y[2].charAt(18) != 'K') {
                    throw new RuntimeException();
                }
                String[] strArr = A0Y;
                strArr[3] = "TcDom5";
                strArr[3] = "TcDom5";
                if (i2 < 0) {
                    j = d8.A04;
                    cx = this.A0K.valueAt(i);
                }
            }
        }
        if (cx != null) {
            long A6m = j - cl.A6m();
            if (A0Y[3].length() != 6) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0Y;
            strArr2[0] = "Cvsa72edMITB5GhT";
            strArr2[0] = "Cvsa72edMITB5GhT";
            int bytesToSkip = (int) A6m;
            if (bytesToSkip >= 0) {
                cl.ADG(bytesToSkip);
                cx.A07.A05(cl);
                return;
            }
            throw new AN(A0A(307, 39, 66));
        } else if (A0Y[3].length() != 6) {
            throw new RuntimeException();
        } else {
            String[] strArr3 = A0Y;
            strArr3[2] = "BU1FqSGZUKIp3lmSYzKBGxc2Z86jKcpe";
            strArr3[2] = "BU1FqSGZUKIp3lmSYzKBGxc2Z86jKcpe";
            this.A02 = 3;
        }
    }

    private void A0J(YX yx) throws AN {
        if (((AbstractC0321Cl) yx).A00 == AbstractC0321Cl.A0j) {
            A0L(yx);
        } else if (((AbstractC0321Cl) yx).A00 == AbstractC0321Cl.A0i) {
            A0K(yx);
        } else if (!this.A0T.isEmpty()) {
            ArrayDeque<YX> arrayDeque = this.A0T;
            if (A0Y[1].length() != 3) {
                throw new RuntimeException();
            }
            String[] strArr = A0Y;
            strArr[7] = "6RjYlEZz613sKxZIpZ2APlvoVeArWnyB";
            strArr[7] = "6RjYlEZz613sKxZIpZ2APlvoVeArWnyB";
            arrayDeque.peek().A08(yx);
        }
    }

    private void A0K(YX yx) throws AN {
        DrmInitData A052;
        A0M(yx, this.A0K, this.A0J, this.A0W);
        if (this.A0L != null) {
            A052 = null;
        } else {
            A052 = A05(yx.A02);
        }
        if (A052 != null) {
            int i = this.A0K.size();
            for (int i2 = 0; i2 < i; i2++) {
                this.A0K.valueAt(i2).A07(A052);
            }
        }
        if (this.A0A != -9223372036854775807L) {
            int size = this.A0K.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.A0K.valueAt(i3).A06(this.A0A);
            }
            this.A0A = -9223372036854775807L;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r14v0, resolved type: com.facebook.ads.redexgen.X.Yd */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: Multiple debug info for r3v3 int: [D('duration' long), D('atom' com.facebook.ads.redexgen.X.YY)] */
    /* JADX INFO: Multiple debug info for r3v4 android.util.SparseArray: [D('trackCount' int), D('track' com.facebook.ads.redexgen.X.D6)] */
    private void A0L(YX yx) throws AN {
        boolean z;
        boolean z2;
        boolean z3;
        if (this.A0N == null) {
            z = true;
        } else {
            z = false;
        }
        I1.A06(z, A0A(532, 20, 11));
        DrmInitData drmInitData = this.A0L;
        if (drmInitData == null) {
            drmInitData = A05(yx.A02);
        }
        YX A062 = yx.A06(AbstractC0321Cl.A0m);
        SparseArray sparseArray = new SparseArray();
        long j = -9223372036854775807L;
        int size = A062.A02.size();
        for (int i = 0; i < size; i++) {
            YY yy = A062.A02.get(i);
            if (((AbstractC0321Cl) yy).A00 == AbstractC0321Cl.A1M) {
                Pair<Integer, DefaultSampleValues> trexData = A03(yy.A00);
                sparseArray.put(((Integer) trexData.first).intValue(), trexData.second);
            } else if (((AbstractC0321Cl) yy).A00 == AbstractC0321Cl.A0f) {
                j = A01(yy.A00);
            }
        }
        SparseArray sparseArray2 = new SparseArray();
        int size2 = yx.A01.size();
        for (int i2 = 0; i2 < size2; i2++) {
            YX yx2 = yx.A01.get(i2);
            if (((AbstractC0321Cl) yx2).A00 == AbstractC0321Cl.A1L) {
                YY A072 = yx.A07(AbstractC0321Cl.A0n);
                if ((this.A0J & 16) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                D6 A0C2 = C0326Cq.A0C(yx2, A072, j, drmInitData, z3, false);
                if (A0C2 != null) {
                    sparseArray2.put(A0C2.A00, A0C2);
                }
            }
        }
        int size3 = sparseArray2.size();
        if (this.A0K.size() == 0) {
            for (int i3 = 0; i3 < size3; i3++) {
                D6 d6 = (D6) sparseArray2.valueAt(i3);
                C0333Cx cx = new C0333Cx(this.A0C.ADY(i3, d6.A03));
                cx.A08(d6, A06(sparseArray, d6.A00));
                this.A0K.put(d6.A00, cx);
                this.A08 = Math.max(this.A08, d6.A04);
            }
            A0C();
            if (A0Y[5].length() != 1) {
                throw new RuntimeException();
            }
            String[] strArr = A0Y;
            strArr[5] = "d";
            strArr[5] = "d";
            this.A0C.A4w();
            return;
        }
        if (this.A0K.size() == size3) {
            z2 = true;
        } else {
            z2 = false;
        }
        I1.A04(z2);
        for (int i4 = 0; i4 < size3; i4++) {
            D6 d62 = (D6) sparseArray2.valueAt(i4);
            this.A0K.get(d62.A00).A08(d62, A06(sparseArray, d62.A00));
        }
    }

    public static void A0M(YX yx, SparseArray<C0333Cx> sparseArray, int i, byte[] bArr) throws AN {
        int size = yx.A01.size();
        for (int i2 = 0; i2 < size; i2++) {
            YX yx2 = yx.A01.get(i2);
            if (((AbstractC0321Cl) yx2).A00 == AbstractC0321Cl.A1K) {
                A0N(yx2, sparseArray, i, bArr);
            }
        }
    }

    /* JADX INFO: Multiple debug info for r7v1 'totalSampleCount'  int: [D('trunData' com.facebook.ads.redexgen.X.IQ), D('trunCount' int)] */
    public static void A0O(YX yx, C0333Cx cx, long j, int i) {
        int totalSampleCount = 0;
        int trunSampleCount = 0;
        List<Atom.LeafAtom> leafChildren = yx.A02;
        int leafChildrenSize = leafChildren.size();
        for (int trunCount = 0; trunCount < leafChildrenSize; trunCount++) {
            YY yy = (YY) leafChildren.get(trunCount);
            int i2 = ((AbstractC0321Cl) yy).A00;
            int i3 = AbstractC0321Cl.A1N;
            if (A0Y[2].charAt(18) != 'K') {
                throw new RuntimeException();
            }
            String[] strArr = A0Y;
            strArr[0] = "HX3CrwnoNkNpp8Diq6RFqVXtJKh";
            strArr[0] = "HX3CrwnoNkNpp8Diq6RFqVXtJKh";
            if (i2 == i3) {
                IQ iq = yy.A00;
                iq.A0Z(12);
                int A0I2 = iq.A0I();
                if (A0I2 > 0) {
                    trunSampleCount += A0I2;
                    totalSampleCount++;
                }
            }
        }
        cx.A02 = 0;
        cx.A00 = 0;
        cx.A01 = 0;
        cx.A07.A04(totalSampleCount, trunSampleCount);
        int i4 = 0;
        int i5 = 0;
        if (A0Y[7].charAt(27) == 'r') {
            String[] strArr2 = A0Y;
            strArr2[1] = "K2a";
            strArr2[1] = "K2a";
        }
        for (int i6 = 0; i6 < leafChildrenSize; i6++) {
            YY yy2 = (YY) leafChildren.get(i6);
            if (((AbstractC0321Cl) yy2).A00 == AbstractC0321Cl.A1N) {
                i5 = A00(cx, i4, j, i, yy2.A00, i5);
                i4++;
            }
        }
    }

    private void A0P(YY yy, long j) throws AN {
        if (!this.A0T.isEmpty()) {
            this.A0T.peek().A09(yy);
        } else if (((AbstractC0321Cl) yy).A00 == AbstractC0321Cl.A12) {
            Pair<Long, YC> A042 = A04(yy.A00, j);
            this.A0B = ((Long) A042.first).longValue();
            this.A0C.ACk((CT) A042.second);
            this.A0F = true;
        } else if (((AbstractC0321Cl) yy).A00 == AbstractC0321Cl.A0P) {
            A0R(yy.A00);
        }
    }

    /* JADX INFO: Multiple debug info for r7v1 int: [D('vectorSize' int), D('i' int)] */
    public static void A0Q(D7 d7, IQ iq, D8 d8) throws AN {
        boolean z;
        int flags = d7.A00;
        iq.A0Z(8);
        boolean z2 = true;
        if ((AbstractC0321Cl.A00(iq.A09()) & 1) == 1) {
            iq.A0a(8);
        }
        int i = iq.A0F();
        int A0I2 = iq.A0I();
        String[] strArr = A0Y;
        if (strArr[6].length() != strArr[4].length()) {
            String[] strArr2 = A0Y;
            strArr2[3] = "qY4fk5";
            strArr2[3] = "qY4fk5";
            if (A0I2 == d8.A00) {
                int i2 = 0;
                if (i == 0) {
                    boolean[] zArr = d8.A0H;
                    for (int sampleCount = 0; sampleCount < A0I2; sampleCount++) {
                        int totalSize = iq.A0F();
                        i2 += totalSize;
                        if (totalSize > flags) {
                            z = true;
                        } else {
                            z = false;
                        }
                        zArr[sampleCount] = z;
                    }
                } else {
                    if (i <= flags) {
                        z2 = false;
                    }
                    i2 = 0 + (i * A0I2);
                    Arrays.fill(d8.A0H, 0, A0I2, z2);
                }
                d8.A03(i2);
                return;
            }
            throw new AN(A0A(290, 17, 120) + A0I2 + A0A(0, 2, 53) + d8.A00);
        }
        throw new RuntimeException();
    }

    private void A0R(IQ iq) {
        CW[] cwArr = this.A0I;
        if (!(cwArr == null || cwArr.length == 0)) {
            iq.A0Z(12);
            int A052 = iq.A05();
            iq.A0R();
            iq.A0R();
            long A0F2 = C0466Ig.A0F(iq.A0N(), 1000000, iq.A0N());
            CW[] cwArr2 = this.A0I;
            for (CW cw : cwArr2) {
                iq.A0Z(12);
                cw.ACe(iq, A052);
            }
            long j = this.A0B;
            if (j != -9223372036854775807L) {
                long j2 = j + A0F2;
                C0462Ic ic = this.A0S;
                if (ic != null) {
                    j2 = ic.A07(j2);
                }
                for (CW cw2 : this.A0I) {
                    cw2.ACf(j2, 1, A052, 0, null);
                }
                return;
            }
            this.A0U.addLast(new C0332Cw(A0F2, A052));
            this.A03 += A052;
        }
    }

    public static void A0S(IQ iq, int i, D8 d8) throws AN {
        boolean z;
        iq.A0Z(i + 8);
        int A002 = AbstractC0321Cl.A00(iq.A09());
        if ((A002 & 1) == 0) {
            if ((A002 & 2) != 0) {
                z = true;
            } else {
                z = false;
            }
            int A0I2 = iq.A0I();
            int i2 = d8.A00;
            if (A0Y[2].charAt(18) != 'K') {
                throw new RuntimeException();
            }
            String[] strArr = A0Y;
            strArr[6] = "UNCiZzJs5PDRpvixsYfSSk1mhxuZgiq";
            strArr[4] = "wrSUtL8XPGusZqeHm";
            if (A0I2 == i2) {
                Arrays.fill(d8.A0H, 0, A0I2, z);
                d8.A03(iq.A05());
                d8.A06(iq);
                return;
            }
            throw new AN(A0A(290, 17, 120) + A0I2 + A0A(0, 2, 53) + d8.A00);
        }
        throw new AN(A0A(381, 56, 78));
    }

    public static void A0T(IQ iq, D8 d8) throws AN {
        long A0O2;
        iq.A0Z(8);
        int A092 = iq.A09();
        if ((AbstractC0321Cl.A00(A092) & 1) == 1) {
            iq.A0a(8);
        }
        int A0I2 = iq.A0I();
        if (A0Y[3].length() != 6) {
            throw new RuntimeException();
        }
        String[] strArr = A0Y;
        strArr[3] = "xMtqR0";
        strArr[3] = "xMtqR0";
        if (A0I2 == 1) {
            int A012 = AbstractC0321Cl.A01(A092);
            long j = d8.A04;
            if (A012 == 0) {
                A0O2 = iq.A0N();
            } else {
                A0O2 = iq.A0O();
            }
            long j2 = j + A0O2;
            String[] strArr2 = A0Y;
            if (strArr2[6].length() != strArr2[4].length()) {
                String[] strArr3 = A0Y;
                strArr3[6] = "QBYjlSuWWzNHcmXjWc7avhw4MqaHk82";
                strArr3[4] = "P5zbNSbq1MUS3wdHf";
                d8.A04 = j2;
                return;
            }
            String[] strArr4 = A0Y;
            strArr4[7] = "vg5EJJPWiTbIFzTVTJFrvfHkMClrP8RJ";
            strArr4[7] = "vg5EJJPWiTbIFzTVTJFrvfHkMClrP8RJ";
            d8.A04 = j2;
            return;
        }
        throw new AN(A0A(552, 29, 95) + A0I2);
    }

    public static void A0U(IQ iq, D8 d8) throws AN {
        A0S(iq, 0, d8);
    }

    public static void A0V(IQ iq, D8 d8, byte[] bArr) throws AN {
        iq.A0Z(8);
        iq.A0d(bArr, 0, 16);
        if (Arrays.equals(bArr, A0c)) {
            A0S(iq, 16, d8);
        }
    }

    public static void A0W(IQ iq, IQ iq2, String str, D8 d8) throws AN {
        boolean z;
        iq.A0Z(8);
        int A092 = iq.A09();
        if (iq.A09() == A0a) {
            if (AbstractC0321Cl.A01(A092) == 1) {
                iq.A0a(4);
            }
            int A093 = iq.A09();
            String[] strArr = A0Y;
            if (strArr[6].length() != strArr[4].length()) {
                String[] strArr2 = A0Y;
                strArr2[3] = "cve2FA";
                strArr2[3] = "cve2FA";
                if (A093 == 1) {
                    iq2.A0Z(8);
                    int A094 = iq2.A09();
                    if (iq2.A09() == A0a) {
                        int A012 = AbstractC0321Cl.A01(A094);
                        if (A0Y[1].length() != 3) {
                            throw new RuntimeException();
                        }
                        String[] strArr3 = A0Y;
                        strArr3[7] = "iX8BjoZjE8Q6Igd9BCVMMRG15zWrcCbA";
                        strArr3[7] = "iX8BjoZjE8Q6Igd9BCVMMRG15zWrcCbA";
                        if (A012 == 1) {
                            if (iq2.A0N() == 0) {
                                throw new AN(A0A(IronSourceError.ERROR_BN_INSTANCE_RELOAD_TIMEOUT, 55, 42));
                            }
                        } else if (A012 >= 2) {
                            iq2.A0a(4);
                        }
                        if (iq2.A0N() == 1) {
                            iq2.A0a(1);
                            int A0F2 = iq2.A0F();
                            int i = (A0F2 & 240) >> 4;
                            int i2 = A0F2 & 15;
                            if (iq2.A0F() == 1) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                int A0F3 = iq2.A0F();
                                byte[] bArr = new byte[16];
                                iq2.A0d(bArr, 0, bArr.length);
                                if (A0Y[7].charAt(27) != 114) {
                                    throw new RuntimeException();
                                }
                                String[] strArr4 = A0Y;
                                strArr4[0] = "v2evuoi5ipUorqJI1yS0NRy";
                                strArr4[0] = "v2evuoi5ipUorqJI1yS0NRy";
                                byte[] bArr2 = null;
                                if (z && A0F3 == 0) {
                                    int A0F4 = iq2.A0F();
                                    bArr2 = new byte[A0F4];
                                    iq2.A0d(bArr2, 0, A0F4);
                                }
                                d8.A0A = true;
                                d8.A08 = new D7(z, str, A0F3, bArr, i, i2, bArr2);
                                return;
                            }
                            return;
                        }
                        throw new AN(A0A(89, 39, 21));
                    }
                    return;
                }
                throw new AN(A0A(50, 39, 120));
            }
            throw new RuntimeException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
        if (r4 != r3) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0064, code lost:
        if (r4 != r3) goto L_0x0039;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean A0X(int r4) {
        /*
        // Method dump skipped, instructions count: 125
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0868Yd.A0X(int):boolean");
    }

    public static boolean A0Y(int i) {
        return i == AbstractC0321Cl.A0V || i == AbstractC0321Cl.A0c || i == AbstractC0321Cl.A0n || i == AbstractC0321Cl.A12 || i == AbstractC0321Cl.A1A || i == AbstractC0321Cl.A1H || i == AbstractC0321Cl.A1I || i == AbstractC0321Cl.A1J || i == AbstractC0321Cl.A1M || i == AbstractC0321Cl.A1N || i == AbstractC0321Cl.A0r || i == AbstractC0321Cl.A0u || i == AbstractC0321Cl.A0t || i == AbstractC0321Cl.A10 || i == AbstractC0321Cl.A1Q || i == AbstractC0321Cl.A0x || i == AbstractC0321Cl.A11 || i == AbstractC0321Cl.A0O || i == AbstractC0321Cl.A0f || i == AbstractC0321Cl.A0P;
    }

    /* JADX INFO: Multiple debug info for r10v0 'this'  com.facebook.ads.redexgen.X.Yd: [D('headerBytesRemaining' int), D('trackCount' int), D('endPosition' long)] */
    /* JADX INFO: Multiple debug info for r0v70 com.facebook.ads.redexgen.X.D8: [D('i' int), D('fragment' com.facebook.ads.redexgen.X.D8)] */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00eb, code lost:
        if (r10.A0F == false) goto L_0x00ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x011b, code lost:
        if (r10.A0F == false) goto L_0x00ed;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean A0Z(com.facebook.ads.redexgen.X.CL r11) throws java.io.IOException, java.lang.InterruptedException {
        /*
        // Method dump skipped, instructions count: 492
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0868Yd.A0Z(com.facebook.ads.redexgen.X.CL):boolean");
    }

    private boolean A0a(CL cl) throws IOException, InterruptedException {
        D7 A002;
        int ACd;
        boolean z;
        int i = 4;
        int i2 = 1;
        int i3 = 0;
        if (this.A02 == 3) {
            if (this.A0D == null) {
                C0333Cx A072 = A07(this.A0K);
                if (A072 == null) {
                    int bytesToSkip = (int) (this.A09 - cl.A6m());
                    if (bytesToSkip >= 0) {
                        cl.ADG(bytesToSkip);
                        A0B();
                        return false;
                    }
                    throw new AN(A0A(346, 35, 12));
                }
                int A6m = (int) (A072.A07.A0G[A072.A02] - cl.A6m());
                if (A6m < 0) {
                    Log.w(A0A(128, 22, 14), A0A(IronSourceConstants.REWARDED_VIDEO_DAILY_CAPPED, 40, 24));
                    A6m = 0;
                }
                cl.ADG(A6m);
                this.A0D = A072;
            }
            this.A06 = this.A0D.A07.A0D[this.A0D.A01];
            if (this.A0D.A01 < this.A0D.A03) {
                cl.ADG(this.A06);
                this.A0D.A01();
                if (!this.A0D.A09()) {
                    this.A0D = null;
                }
                this.A02 = 3;
                return true;
            }
            C0333Cx cx = this.A0D;
            if (A0Y[3].length() != 6) {
                throw new RuntimeException();
            }
            String[] strArr = A0Y;
            strArr[3] = "st8dZG";
            strArr[3] = "st8dZG";
            if (cx.A05.A02 == 1) {
                this.A06 -= 8;
                cl.ADG(8);
            }
            this.A04 = this.A0D.A04();
            this.A06 += this.A04;
            this.A02 = 4;
            this.A05 = 0;
        }
        D8 d8 = this.A0D.A07;
        D6 d6 = this.A0D.A05;
        CW cw = this.A0D.A06;
        int nalUnitLengthFieldLengthDiff = this.A0D.A01;
        long A012 = d8.A01(nalUnitLengthFieldLengthDiff) * 1000;
        C0462Ic ic = this.A0S;
        if (ic != null) {
            A012 = ic.A07(A012);
        }
        if (d6.A01 == 0) {
            while (true) {
                int i4 = this.A04;
                int i5 = this.A06;
                if (i4 >= i5) {
                    break;
                }
                this.A04 += cw.ACd(cl, i5 - i4, false);
            }
        } else {
            byte[] bArr = this.A0Q.A00;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i6 = d6.A01 + 1;
            int i7 = 4 - d6.A01;
            while (this.A04 < this.A06) {
                int i8 = this.A05;
                if (i8 == 0) {
                    cl.readFully(bArr, i7, i6);
                    this.A0Q.A0Z(i3);
                    this.A05 = this.A0Q.A0I() - i2;
                    this.A0R.A0Z(i3);
                    cw.ACe(this.A0R, i);
                    cw.ACe(this.A0Q, i2);
                    if (this.A0H.length <= 0 || !IM.A0D(d6.A07.A0O, bArr[i])) {
                        z = false;
                    } else {
                        z = true;
                    }
                    this.A0G = z;
                    this.A04 += 5;
                    this.A06 += i7;
                } else {
                    if (this.A0G) {
                        this.A0P.A0X(i8);
                        cl.readFully(this.A0P.A00, i3, this.A05);
                        cw.ACe(this.A0P, this.A05);
                        ACd = this.A05;
                        int A022 = IM.A02(this.A0P.A00, this.A0P.A08());
                        this.A0P.A0Z(A0A(686, 10, 13).equals(d6.A07.A0O) ? 1 : 0);
                        this.A0P.A0Y(A022);
                        GQ.A04(A012, this.A0P, this.A0H);
                    } else {
                        ACd = cw.ACd(cl, i8, false);
                    }
                    this.A04 += ACd;
                    this.A05 -= ACd;
                    i = 4;
                    i2 = 1;
                    i3 = 0;
                }
            }
        }
        boolean z2 = d8.A0I[nalUnitLengthFieldLengthDiff];
        CV cv = null;
        if (d8.A0A) {
            boolean z3 = z2 ? 1 : 0;
            char c = z2 ? 1 : 0;
            z2 = z3 | true;
            if (d8.A08 != null) {
                A002 = d8.A08;
            } else {
                A002 = d6.A00(d8.A07.A02);
            }
            cv = A002.A01;
        }
        int i9 = this.A06;
        int i10 = z2 ? 1 : 0;
        int i11 = z2 ? 1 : 0;
        int i12 = z2 ? 1 : 0;
        cw.ACf(A012, i10, i9, 0, cv);
        A0F(A012);
        if (!this.A0D.A09()) {
            this.A0D = null;
        }
        this.A02 = 3;
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final void A7Q(CM cm) {
        this.A0C = cm;
        D6 d6 = this.A0N;
        if (d6 != null) {
            C0333Cx cx = new C0333Cx(cm.ADY(0, d6.A03));
            cx.A08(this.A0N, new C0327Cr(0, 0, 0, 0));
            this.A0K.put(0, cx);
            A0C();
            this.A0C.A4w();
        }
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final int ABx(CL cl, CR cr) throws IOException, InterruptedException {
        while (true) {
            int i = this.A02;
            if (i != 0) {
                if (A0Y[2].charAt(18) != 'K') {
                    throw new RuntimeException();
                }
                String[] strArr = A0Y;
                strArr[2] = "Ub8SUYMnE0bQG8CZo0KwdlTNogw2mbM0";
                strArr[2] = "Ub8SUYMnE0bQG8CZo0KwdlTNogw2mbM0";
                if (i == 1) {
                    A0H(cl);
                } else if (i != 2) {
                    boolean A0a2 = A0a(cl);
                    if (A0Y[7].charAt(27) == 'r') {
                        String[] strArr2 = A0Y;
                        strArr2[5] = "b";
                        strArr2[5] = "b";
                        if (A0a2) {
                            return 0;
                        }
                    } else if (A0a2) {
                        return 0;
                    }
                } else {
                    A0I(cl);
                }
            } else if (!A0Z(cl)) {
                return -1;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final void ACj(long j, long j2) {
        int size = this.A0K.size();
        for (int i = 0; i < size; i++) {
            this.A0K.valueAt(i).A05();
        }
        this.A0U.clear();
        this.A03 = 0;
        this.A0A = j2;
        this.A0T.clear();
        A0B();
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final boolean ADH(CL cl) throws IOException, InterruptedException {
        return D4.A04(cl);
    }
}
