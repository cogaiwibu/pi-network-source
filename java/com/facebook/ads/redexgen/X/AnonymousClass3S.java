package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.drm.DrmInitData;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;

@TargetApi(16)
/* renamed from: com.facebook.ads.redexgen.X.3S  reason: invalid class name */
public abstract class AnonymousClass3S extends AbstractC0313Cd {
    public static byte[] A0d;
    public static String[] A0e;
    public static final byte[] A0f = C0466Ig.A0i(A0a(7, 76, 80));
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public long A05;
    public MediaCodec A06;
    public Format A07;
    public C3<Y7> A08;
    public C3<Y7> A09;
    public C0344Di A0A;
    public ByteBuffer A0B;
    public boolean A0C;
    public boolean A0D;
    public boolean A0E;
    public boolean A0F;
    public boolean A0G;
    public boolean A0H;
    public boolean A0I;
    public boolean A0J;
    public boolean A0K;
    public boolean A0L;
    public boolean A0M;
    public boolean A0N;
    public boolean A0O;
    public boolean A0P;
    public boolean A0Q;
    public boolean A0R;
    public ByteBuffer[] A0S;
    public ByteBuffer[] A0T;
    public C0297Be A0U;
    public final MediaCodec.BufferInfo A0V;
    public final AH A0W;
    public final C0861Xw A0X;
    public final C0861Xw A0Y;
    @Nullable
    public final C4<Y7> A0Z;
    public final AbstractC0350Do A0a;
    public final List<Long> A0b;
    public final boolean A0c;

    public static String A0a(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0d, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 20);
        }
        return new String(copyOfRange);
    }

    public static void A0k() {
        A0d = new byte[]{76, 64, 2, 21, 20, 64, 118, 116, 116, 116, 116, 116, 117, 114, 115, 112, 118, 7, 116, 116, 6, 0, 5, 118, 113, 125, 116, 116, 116, 116, 116, 116, 117, 114, 124, 7, 1, 116, 2, 117, 119, 118, 116, 116, 116, 116, 116, 116, 117, 114, 113, 124, 124, 124, 112, 116, 0, 7, 1, 115, 117, 117, 124, 5, 116, 116, 116, 118, 2, 6, 2, 117, 7, 119, 117, 7, 119, 118, 115, 113, 0, 115, 124, 7, 0, 18, 4, 15, 8, 26, 3, 29, 26, 8, 15, 117, 89, 85, 78, 91, 90, 34, 20, 11, 70, 21, 3, 21, 21, 15, 9, 8, 70, 20, 3, 23, 19, 15, 20, 3, 21, 70, 21, 3, 5, 19, 20, 3, 70, 2, 3, 5, 9, 2, 3, 20, 70, 0, 9, 20, 70, 62, 22, 23, 26, 18, 83, 1, 22, 2, 6, 26, 1, 22, 0, 83, 18, 83, 55, 1, 30, 32, 22, 0, 0, 26, 28, 29, 62, 18, 29, 18, 20, 22, 1, 125, 85, 84, 89, 81, 115, 95, 84, 85, 83, 98, 85, 94, 84, 85, 66, 85, 66, 125, ByteCompanionObject.MAX_VALUE, 106, 28, 119, 74, 75, 92, 93, 65, 28, 83, 68, 81, 28, 86, 87, 81, 27, 25, 12, 122, 17, 44, 45, 58, 59, 39, 122, 53, 34, 55, 122, 48, 49, 55, 122, 39, 49, 55, 33, 38, 49, 74, 72, 93, 43, 72, 81, 78, 43, 68, 80, 65, 76, 74, 43, 65, 64, 70, 74, 65, 64, 87, 43, 72, 85, 54, ByteCompanionObject.MAX_VALUE, 125, 104, 30, 125, 100, 123, 30, 102, 121, 116, 117, ByteCompanionObject.MAX_VALUE, 30, 116, 117, 115, ByteCompanionObject.MAX_VALUE, 116, 117, 98, 30, 113, 102, 115, 3, 1, 20, 98, 2, 58, 37, 40, 37, 45, 98, 36, 126, 122, 120, 98, 40, 41, 47, 35, 40, 41, 47, 45, 56, 78, 46, 22, 9, 4, 9, 1, 78, 8, 82, 86, 84, 78, 4, 5, 3, 15, 4, 5, 78, 19, 5, 3, 21, 18, 5, 121, 123, 110, 24, 101, 115, 117, 24, 87, 64, 85, 24, 82, 83, 85, 72, 74, 95, 41, 84, 66, 68, 41, 102, 113, 100, 41, 99, 98, 100, 41, 116, 98, 100, 114, 117, 98, 45, 47, 58, 76, 3, 14, 14, 21, 11, 12, 12, 7, 16, 76, 20, 11, 6, 7, 13, 76, 6, 7, 1, 13, 6, 7, 16, 76, 3, 20, 1, 1, 3, 22, 96, 47, 35, 34, 33, 41, 39, 45, 96, 47, 56, 45, 96, 42, 43, 45, 33, 42, 43, 60, 96, 47, 57, 43, 61, 33, 35, 43, 63, 61, 40, 94, 17, 29, 28, 31, 23, 25, 19, 94, 17, 6, 19, 94, 20, 21, 19, 31, 20, 21, 2, 94, 17, 7, 21, 3, 31, 29, 21, 94, 3, 21, 19, 5, 2, 21, 121, 123, 110, 24, 81, 89, 89, 81, 90, 83, 24, 87, 87, 85, 24, 82, 83, 85, 89, 82, 83, 68, 30, 28, 9, ByteCompanionObject.MAX_VALUE, 54, 62, 62, 54, 61, 52, ByteCompanionObject.MAX_VALUE, 39, 62, 35, 51, 56, 34, ByteCompanionObject.MAX_VALUE, 53, 52, 50, 62, 53, 52, 35, 2, 0, 21, 99, 63, 38, 99, 59, 36, 41, 40, 34, 18, 41, 40, 46, 34, 41, 40, 63, 99, 44, 59, 46, 112, 110, 14, 98, 22, 18, 19, 41, 55, 87, 59, 79, 72, 74, 106, 116, 20, 126, 1, 9, 9, 116, 106, 10, 109, 16, 23, 23, 79, 81, 49, 72, 41, 36, 41, 106, 97, 104, 103, 103, 108, 101, 36, 106, 102, 124, 103, 125, 63, 51, 50, 58, 53, 59, 41, 46, 57, 31, 51, 56, 57, 63, 15, 30, 9, 13, 24, 9, 47, 3, 8, 9, 15, 86, 96, 118, 101, 109, 106, 69, 106, 96, 66, 97, 97, 96, 83, 89, 90, 64, 91, 81, 80, 71, 24, 18, 17, 11, 16, 26, 27, 12, 33, 18, 10, 27, 5, 16, 13, 23, 18, 7, 16, 43, 33, 113, 115, 115, 115, 45, 32, 44, 34, 45, 49, 30, 31, 80, 3, 21, 19, 5, 2, 21, 80, 20, 21, 19, 31, 20, 21, 2, 80, 17, 6, 17, 25, 28, 17, 18, 28, 21, 94, 80, 36, 2, 9, 25, 30, 23, 80, 4, 31, 80, 0, 2, 31, 19, 21, 21, 20, 80, 7, 25, 4, 24, 80, 118, 113, 100, 119, 113, 70, 106, 97, 96, 102, 102, 123, 126, 115, 98, 123, 115, 78, 80, 93, 77, 81};
    }

    public static void A0l() {
        A0e = new String[]{"9OVkIR1fNYEoLuJhr4v44UGIqobat2iA", "rvjyAE4a8qg3Symxb7ylQnmZk1yEw18g", "yq3KpxRuPN0WZ8jbU7FQkuT3q90s4j9W", "QhWwoh5s4IWFZsopFlKjqr3qYdcDlMjY", "GXhQrMO3EYw7GpvgdmF2LLQyblaoRrya", "HarHLo3NfHHJ1sn22D42qgtNJjG4ySv5", "mWzZtnKFhVqOEEmQC7RHyJpmfpW8oE62", "x54zHbOQHTTVCgIECmCrfbqAOALLU5ir"};
    }

    public abstract int A1D(AbstractC0350Do v, C4<Y7> c4, Format format) throws C0353Dr;

    public abstract void A1P(C0344Di di, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) throws C0353Dr;

    public abstract boolean A1R(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws A4;

    static {
        A0l();
        A0k();
    }

    public AnonymousClass3S(int i, AbstractC0350Do r5, @Nullable C4<Y7> c4, boolean z) {
        super(i);
        boolean z2;
        if (C0466Ig.A02 >= 16) {
            z2 = true;
        } else {
            z2 = false;
        }
        I1.A04(z2);
        this.A0a = (AbstractC0350Do) I1.A01(r5);
        this.A0Z = c4;
        this.A0c = z;
        this.A0X = new C0861Xw(0);
        this.A0Y = C0861Xw.A02();
        this.A0W = new AH();
        this.A0b = new ArrayList();
        this.A0V = new MediaCodec.BufferInfo();
        this.A01 = 0;
        this.A02 = 0;
    }

    private int A0X(String str) {
        if (C0466Ig.A02 <= 25 && A0a(211, 25, 64).equals(str)) {
            String str2 = C0466Ig.A06;
            if (A0e[5].charAt(22) != 'm') {
                String[] strArr = A0e;
                strArr[3] = "rXHSxRetqBcaMazmAuD1LrMN32rrN6yB";
                strArr[0] = "PYELojq5TDB6rkMOhN6BPW4xOGIFZ2Jw";
                if (str2.startsWith(A0a(573, 7, 8)) || C0466Ig.A06.startsWith(A0a(545, 7, 55)) || C0466Ig.A06.startsWith(A0a(552, 7, 110)) || C0466Ig.A06.startsWith(A0a(566, 7, 51))) {
                    return 2;
                }
            }
            throw new RuntimeException();
        }
        if (C0466Ig.A02 >= 24) {
            return 0;
        }
        if (!A0a(286, 22, 88).equals(str) && !A0a(308, 29, 116).equals(str)) {
            return 0;
        }
        if (A0a(631, 8, 33).equals(C0466Ig.A03)) {
            return 1;
        }
        String str3 = C0466Ig.A03;
        String A0a2 = A0a(639, 12, 106);
        String[] strArr2 = A0e;
        if (strArr2[1].charAt(9) != strArr2[6].charAt(9)) {
            String[] strArr3 = A0e;
            strArr3[7] = "EJTrH92MD698cCrSnGocCFo99KF41O7G";
            strArr3[7] = "EJTrH92MD698cCrSnGocCFo99KF41O7G";
            if (A0a2.equals(str3)) {
                return 1;
            }
            if (A0a(651, 7, 118).equals(C0466Ig.A03)) {
                return 1;
            }
            if (A0a(732, 7, 6).equals(C0466Ig.A03)) {
                return 1;
            }
            return 0;
        }
        throw new RuntimeException();
    }

    private final long A0Y() {
        return 0;
    }

    public static MediaCodec.CryptoInfo A0Z(C0861Xw xw, int i) {
        MediaCodec.CryptoInfo A022 = xw.A02.A02();
        if (i == 0) {
            return A022;
        }
        if (A022.numBytesOfClearData == null) {
            String[] strArr = A0e;
            if (strArr[1].charAt(9) != strArr[6].charAt(9)) {
                String[] strArr2 = A0e;
                strArr2[5] = "UbtyB27B24Biu3n6sBWjRVSN4hFFB4s1";
                strArr2[5] = "UbtyB27B24Biu3n6sBWjRVSN4hFFB4s1";
                A022.numBytesOfClearData = new int[1];
            } else {
                throw new RuntimeException();
            }
        }
        int[] iArr = A022.numBytesOfClearData;
        iArr[0] = iArr[0] + i;
        return A022;
    }

    private ByteBuffer A0b(int i) {
        if (C0466Ig.A02 >= 21) {
            return this.A06.getInputBuffer(i);
        }
        return this.A0S[i];
    }

    private ByteBuffer A0c(int i) {
        if (C0466Ig.A02 >= 21) {
            return this.A06.getOutputBuffer(i);
        }
        return this.A0T[i];
    }

    private void A0d() {
        if (C0466Ig.A02 < 21) {
            this.A0S = this.A06.getInputBuffers();
            this.A0T = this.A06.getOutputBuffers();
        }
    }

    private void A0e() throws A4 {
        if (this.A02 == 2) {
            A1I();
            A1K();
            return;
        }
        this.A0N = true;
        A1J();
    }

    private void A0f() {
        if (C0466Ig.A02 < 21) {
            this.A0T = this.A06.getOutputBuffers();
        }
    }

    private void A0g() throws A4 {
        MediaFormat outputFormat = this.A06.getOutputFormat();
        if (this.A00 != 0 && outputFormat.getInteger(A0a(739, 5, 45)) == 32 && outputFormat.getInteger(A0a(664, 6, 81)) == 32) {
            this.A0O = true;
            return;
        }
        if (this.A0I) {
            outputFormat.setInteger(A0a(580, 13, 29), 1);
        }
        A1M(this.A06, outputFormat);
    }

    private void A0h() {
        if (C0466Ig.A02 < 21) {
            this.A0S = null;
            this.A0T = null;
        }
    }

    private void A0i() {
        this.A03 = -1;
        this.A0X.A01 = null;
    }

    private void A0j() {
        this.A04 = -1;
        this.A0B = null;
    }

    private void A0m(C0346Dk dk) throws A4 {
        throw A4.A01(dk, A10());
    }

    private boolean A0n() {
        if (A0a(95, 6, 32).equals(C0466Ig.A05)) {
            if (!A0a(87, 4, 90).equals(C0466Ig.A06)) {
                if (A0a(83, 4, 82).equals(C0466Ig.A06)) {
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0211, code lost:
        r16.A0X.A08();
        A1O(r16.A0X);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x021b, code lost:
        if (r6 == false) goto L_0x021e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x021e, code lost:
        r16.A06.queueInputBuffer(r16.A03, 0, r16.A0X.A01.limit(), r7, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0231, code lost:
        r16.A06.queueSecureInputBuffer(r16.A03, 0, A0Z(r16.A0X, r5), r7, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0240, code lost:
        A0i();
        r16.A0J = true;
        r16.A01 = 0;
        r16.A0U.A04++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x024e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x024f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0258, code lost:
        throw com.facebook.ads.redexgen.X.A4.A01(r1, A10());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0095, code lost:
        if (r7 != false) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c2, code lost:
        if (r7 != false) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c5, code lost:
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c8, code lost:
        if (r16.A0R == false) goto L_0x00cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ca, code lost:
        r6 = -4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00cc, code lost:
        if (r6 != -3) goto L_0x0163;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ce, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d1, code lost:
        if (r16.A01 != 1) goto L_0x0123;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d3, code lost:
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d4, code lost:
        r8 = r16.A07.A0P.size();
        r6 = com.facebook.ads.redexgen.X.AnonymousClass3S.A0e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ee, code lost:
        if (r6[1].charAt(9) == r6[6].charAt(9)) goto L_0x0112;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00f0, code lost:
        r6 = com.facebook.ads.redexgen.X.AnonymousClass3S.A0e;
        r6[7] = "0VatHXJ47YZXuQNTjh1Q4vWnAJchohqJ";
        r6[7] = "0VatHXJ47YZXuQNTjh1Q4vWnAJchohqJ";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00fc, code lost:
        if (r7 >= r8) goto L_0x0121;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00fe, code lost:
        r16.A0X.A01.put(r16.A07.A0P.get(r7));
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0112, code lost:
        r6 = com.facebook.ads.redexgen.X.AnonymousClass3S.A0e;
        r6[3] = "zOhD8BhFeW0zpu1geu8qUgn88iwXK5ep";
        r6[0] = "60rX9qlLFkokv4JD1C8g9QKhync8N1Cu";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x011e, code lost:
        if (r7 >= r8) goto L_0x0121;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0121, code lost:
        r16.A01 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0123, code lost:
        r7 = r16.A0X.A01;
        r6 = com.facebook.ads.redexgen.X.AnonymousClass3S.A0e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0139, code lost:
        if (r6[1].charAt(9) == r6[6].charAt(9)) goto L_0x0155;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x013b, code lost:
        r6 = com.facebook.ads.redexgen.X.AnonymousClass3S.A0e;
        r6[1] = "39aArsNj3IDVPnG6lUIYrUviornu3auc";
        r6[6] = "ZVN5NvQX1lR02F2nkBpRehMiTRLfpSWC";
        r5 = r7.position();
        r6 = A12(r16.A0W, r16.A0X, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0155, code lost:
        r5 = r7.position();
        r6 = A12(r16.A0W, r16.A0X, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0164, code lost:
        if (r6 != -5) goto L_0x0179;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0168, code lost:
        if (r16.A01 != 2) goto L_0x0171;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x016a, code lost:
        r16.A0X.A07();
        r16.A01 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0171, code lost:
        A1N(r16.A0W.A00);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0178, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x017f, code lost:
        if (r16.A0X.A04() == false) goto L_0x01b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0183, code lost:
        if (r16.A01 != 2) goto L_0x018c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0185, code lost:
        r16.A0X.A07();
        r16.A01 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x018c, code lost:
        r16.A0M = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0190, code lost:
        if (r16.A0J != false) goto L_0x0196;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0192, code lost:
        A0e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0195, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0198, code lost:
        if (r16.A0G == false) goto L_0x019b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x019b, code lost:
        r16.A0K = true;
        r16.A06.queueInputBuffer(r16.A03, 0, 0, 0, 4);
        A0i();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01ac, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01ad, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01b6, code lost:
        throw com.facebook.ads.redexgen.X.A4.A01(r1, A10());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01b9, code lost:
        if (r16.A0Q == false) goto L_0x01cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01c1, code lost:
        if (r16.A0X.A05() != false) goto L_0x01cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01c3, code lost:
        r16.A0X.A07();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01ca, code lost:
        if (r16.A01 != 2) goto L_0x01ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01cc, code lost:
        r16.A01 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01ce, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01cf, code lost:
        r16.A0Q = false;
        r6 = r16.A0X.A0A();
        r16.A0R = A0y(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01df, code lost:
        if (r16.A0R == false) goto L_0x01e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01e1, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01e4, code lost:
        if (r16.A0D == false) goto L_0x01fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01e6, code lost:
        if (r6 != false) goto L_0x01fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01e8, code lost:
        com.facebook.ads.redexgen.X.IM.A0B(r16.A0X.A01);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01f7, code lost:
        if (r16.A0X.A01.position() != 0) goto L_0x01fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01f9, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01fa, code lost:
        r16.A0D = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:?, code lost:
        r7 = r16.A0X.A00;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0206, code lost:
        if (r16.A0X.A03() == false) goto L_0x0211;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0208, code lost:
        r16.A0b.add(java.lang.Long.valueOf(r7));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean A0o() throws com.facebook.ads.redexgen.X.A4 {
        /*
        // Method dump skipped, instructions count: 601
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass3S.A0o():boolean");
    }

    private boolean A0p() {
        return this.A04 >= 0;
    }

    private boolean A0q(long j) {
        int size = this.A0b.size();
        for (int i = 0; i < size; i++) {
            long longValue = this.A0b.get(i).longValue();
            String[] strArr = A0e;
            if (strArr[1].charAt(9) != strArr[6].charAt(9)) {
                String[] strArr2 = A0e;
                strArr2[4] = "ML5bMotUrNJfefR5zyFOe6FKAXdvvO6A";
                strArr2[2] = "SdeYytwJjEjJxI17XZFSuNmI9VlWoLpo";
                if (longValue == j) {
                    this.A0b.remove(i);
                    if (A0e[5].charAt(22) != 'm') {
                        String[] strArr3 = A0e;
                        strArr3[4] = "PN0xo47Kt8nFjD42DkF1Rwv3kccfY0ZU";
                        strArr3[2] = "8XhLexKKIuuBUtz2cCFHUx77okN3o4VX";
                        return true;
                    }
                    String[] strArr4 = A0e;
                    strArr4[1] = "MaO0vnTK96XnVNRleRSpONjFXCjP5Eov";
                    strArr4[6] = "hUdEzwsPaliJglUJ7NraoDZ4Fn5DncmA";
                    return false;
                }
            } else {
                throw new RuntimeException();
            }
        }
        return false;
    }

    /* JADX INFO: Multiple debug info for r19v0 'this'  com.facebook.ads.redexgen.X.3S: [D('outputIndex' int), D('e' java.lang.IllegalStateException), D('processedOutputBuffer' boolean)] */
    private boolean A0r(long j, long j2) throws A4 {
        boolean z;
        boolean z2;
        int i;
        if (!A0p()) {
            if (!this.A0F || !this.A0K) {
                i = this.A06.dequeueOutputBuffer(this.A0V, A0Y());
            } else {
                try {
                    i = this.A06.dequeueOutputBuffer(this.A0V, A0Y());
                } catch (IllegalStateException unused) {
                    A0e();
                    if (this.A0N) {
                        A1I();
                    }
                    return false;
                }
            }
            if (i >= 0) {
                if (this.A0O) {
                    this.A0O = false;
                    this.A06.releaseOutputBuffer(i, false);
                    return true;
                } else if (this.A0V.size != 0 || (this.A0V.flags & 4) == 0) {
                    this.A04 = i;
                    this.A0B = A0c(i);
                    ByteBuffer byteBuffer = this.A0B;
                    if (byteBuffer != null) {
                        byteBuffer.position(this.A0V.offset);
                        this.A0B.limit(this.A0V.offset + this.A0V.size);
                    }
                    this.A0P = A0q(this.A0V.presentationTimeUs);
                } else {
                    A0e();
                    return false;
                }
            } else if (i == -2) {
                A0g();
                return true;
            } else if (i == -3) {
                A0f();
                return true;
            } else {
                if (this.A0G && (this.A0M || this.A02 == 2)) {
                    A0e();
                }
                return false;
            }
        }
        boolean z3 = this.A0F;
        String[] strArr = A0e;
        if (strArr[3].charAt(8) != strArr[0].charAt(8)) {
            String[] strArr2 = A0e;
            strArr2[3] = "H6QEdKrNS5VKUI2eiDzJYDiDaOSTSHZm";
            strArr2[0] = "qtM0JqIstAlLtY5WeeeWIRjDSmIhrDzd";
            if (!z3 || !this.A0K) {
                z = A1R(j, j2, this.A06, this.A0B, this.A04, this.A0V.flags, this.A0V.presentationTimeUs, this.A0P);
            } else {
                try {
                    z = A1R(j, j2, this.A06, this.A0B, this.A04, this.A0V.flags, this.A0V.presentationTimeUs, this.A0P);
                } catch (IllegalStateException unused2) {
                    A0e();
                    boolean z4 = this.A0N;
                    String[] strArr3 = A0e;
                    if (strArr3[4].charAt(18) == strArr3[2].charAt(18)) {
                        String[] strArr4 = A0e;
                        strArr4[3] = "kLeAoHdKyNjlIY3W2lnlzypZ7jBCZpds";
                        strArr4[0] = "12vglqLCD0wnh38LM4o4LF1q7CPuStNa";
                        if (z4) {
                            A1I();
                        }
                        return false;
                    }
                }
            }
            if (z) {
                A1L(this.A0V.presentationTimeUs);
                if ((this.A0V.flags & 4) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                A0j();
                if (!z2) {
                    return true;
                }
                A0e();
            }
            return false;
        }
        throw new RuntimeException();
    }

    public static boolean A0s(C0344Di di) {
        String str = di.A02;
        if (C0466Ig.A02 > 17 || (!A0a(521, 24, 89).equals(str) && !A0a(374, 31, 118).equals(str))) {
            if (A0a(95, 6, 32).equals(C0466Ig.A05)) {
                if (!A0a(91, 4, 72).equals(C0466Ig.A06) || !di.A05) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public static boolean A0t(String str) {
        if (C0466Ig.A02 > 23 || !A0a(496, 25, 69).equals(str)) {
            if (C0466Ig.A02 <= 19) {
                if (A0a(658, 6, 87).equals(C0466Ig.A03)) {
                    String[] strArr = A0e;
                    if (strArr[3].charAt(8) != strArr[0].charAt(8)) {
                        String[] strArr2 = A0e;
                        strArr2[1] = "95wFKgRrMS7zF0LnDUBUyEKLdOv2pw0Q";
                        strArr2[6] = "8UM2DR4qd3kvfN0lEIyvKJByOBGtF0J9";
                        if (A0a(405, 31, 90).equals(str) || A0a(436, 38, 100).equals(str)) {
                            return true;
                        }
                    } else {
                        throw new RuntimeException();
                    }
                }
            }
            return false;
        }
        return true;
    }

    public static boolean A0u(String str) {
        return C0466Ig.A02 == 21 && A0a(474, 22, 34).equals(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0048, code lost:
        if (A0a(352, 22, 19).equals(r4) == false) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean A0v(java.lang.String r4) {
        /*
        // Method dump skipped, instructions count: 139
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass3S.A0v(java.lang.String):boolean");
    }

    public static boolean A0w(String str, Format format) {
        return C0466Ig.A02 < 21 && format.A0P.isEmpty() && A0a(261, 25, 36).equals(str);
    }

    public static boolean A0x(String str, Format format) {
        if (C0466Ig.A02 > 18 || format.A05 != 1 || !A0a(236, 25, 17).equals(str)) {
            return false;
        }
        return true;
    }

    private boolean A0y(boolean z) throws A4 {
        if (this.A08 == null || (!z && this.A0c)) {
            return false;
        }
        int A70 = this.A08.A70();
        if (A70 == 1) {
            throw A4.A01(this.A08.A6B(), A10());
        } else if (A70 != 4) {
            return true;
        } else {
            return false;
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0313Cd
    public void A14() {
        this.A07 = null;
        try {
            A1I();
            try {
                if (this.A08 != null) {
                    this.A0Z.ACJ(this.A08);
                }
                try {
                    if (!(this.A09 == null || this.A09 == this.A08)) {
                        this.A0Z.ACJ(this.A09);
                    }
                } finally {
                    this.A08 = null;
                    this.A09 = null;
                }
            } catch (Throwable th) {
                if (!(this.A09 == null || this.A09 == this.A08)) {
                    this.A0Z.ACJ(this.A09);
                }
                throw th;
            } finally {
                this.A08 = null;
                this.A09 = null;
            }
        } catch (Throwable th2) {
            try {
                if (!(this.A09 == null || this.A09 == this.A08)) {
                    this.A0Z.ACJ(this.A09);
                }
                throw th2;
            } finally {
                this.A08 = null;
                this.A09 = null;
            }
        } finally {
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0313Cd
    public void A15() {
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0313Cd
    public void A16() {
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0313Cd
    public void A17(long j, boolean z) throws A4 {
        this.A0M = false;
        this.A0N = false;
        if (this.A06 != null) {
            A1H();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0313Cd
    public void A18(boolean z) throws A4 {
        this.A0U = new C0297Be();
    }

    public int A1C(MediaCodec mediaCodec, C0344Di di, Format format, Format format2) {
        return 0;
    }

    public final MediaCodec A1E() {
        return this.A06;
    }

    public final C0344Di A1F() {
        return this.A0A;
    }

    public C0344Di A1G(AbstractC0350Do r2, Format format, boolean z) throws C0353Dr {
        return r2.A60(format.A0O, z);
    }

    public void A1H() throws A4 {
        this.A05 = -9223372036854775807L;
        A0i();
        A0j();
        this.A0Q = true;
        this.A0R = false;
        this.A0P = false;
        this.A0b.clear();
        this.A0C = false;
        this.A0O = false;
        if (this.A0H || (this.A0E && this.A0K)) {
            A1I();
            A1K();
        } else {
            int i = this.A02;
            if (A0e[7].charAt(4) != 'H') {
                throw new RuntimeException();
            }
            String[] strArr = A0e;
            strArr[1] = "wbouPn2Ftm3cpLG8fvuyld6AKnPflzbx";
            strArr[6] = "bzy96m6ZRNxMDmYLQEfFnOCqhh49XGXp";
            if (i != 0) {
                A1I();
                A1K();
            } else {
                this.A06.flush();
                this.A0J = false;
            }
        }
        if (this.A0L && this.A07 != null) {
            this.A01 = 1;
        }
    }

    public void A1I() {
        this.A05 = -9223372036854775807L;
        A0i();
        A0j();
        this.A0R = false;
        this.A0P = false;
        this.A0b.clear();
        A0h();
        this.A0A = null;
        this.A0L = false;
        this.A0J = false;
        this.A0D = false;
        this.A0H = false;
        this.A00 = 0;
        this.A0G = false;
        this.A0E = false;
        this.A0I = false;
        this.A0C = false;
        this.A0O = false;
        this.A0K = false;
        this.A01 = 0;
        this.A02 = 0;
        if (this.A06 != null) {
            this.A0U.A01++;
            try {
                this.A06.stop();
                try {
                    this.A06.release();
                    this.A06 = null;
                    C3<Y7> c3 = this.A08;
                    if (c3 != null && this.A09 != c3) {
                        try {
                            this.A0Z.ACJ(c3);
                        } finally {
                        }
                    }
                } catch (Throwable th) {
                    this.A06 = null;
                    C3<Y7> c32 = this.A08;
                    if (!(c32 == null || this.A09 == c32)) {
                        this.A0Z.ACJ(c32);
                    }
                    throw th;
                } finally {
                    this.A08 = null;
                }
            } catch (Throwable th2) {
                this.A06 = null;
                C3<Y7> c33 = this.A08;
                if (!(c33 == null || this.A09 == c33)) {
                    try {
                        this.A0Z.ACJ(c33);
                    } finally {
                        this.A08 = null;
                    }
                }
                throw th2;
            } finally {
            }
        }
    }

    public void A1J() throws A4 {
    }

    public final void A1K() throws A4 {
        Format format;
        long j;
        if (this.A06 == null && (format = this.A07) != null) {
            this.A08 = this.A09;
            String str = format.A0O;
            MediaCrypto mediaCrypto = null;
            boolean z = false;
            C3<Y7> c3 = this.A08;
            if (c3 != null) {
                Y7 A6W = c3.A6W();
                if (A0e[5].charAt(22) != 'm') {
                    String[] strArr = A0e;
                    strArr[1] = "HTFGGBgFgI6ylI68q0FeBZ95y7T9Xgss";
                    strArr[6] = "P6HI8GYxdJJ1MGo6JXYXPe6FB7j5p6fI";
                    if (A6W != null) {
                        mediaCrypto = A6W.A00();
                        z = A6W.A01(str);
                    } else if (this.A08.A6B() == null) {
                        return;
                    }
                    if (A0n()) {
                        int A70 = this.A08.A70();
                        if (A70 == 1) {
                            throw A4.A01(this.A08.A6B(), A10());
                        } else if (A0e[7].charAt(4) == 'H') {
                            String[] strArr2 = A0e;
                            strArr2[7] = "zdcyHT7sTCB3al7NiJFn52Vz5qRveBVU";
                            strArr2[7] = "zdcyHT7sTCB3al7NiJFn52Vz5qRveBVU";
                            if (A70 != 4) {
                                return;
                            }
                        } else if (A70 != 4) {
                            return;
                        }
                    }
                } else {
                    throw new RuntimeException();
                }
            }
            if (this.A0A == null) {
                try {
                    this.A0A = A1G(this.A0a, this.A07, z);
                    if (this.A0A == null && z) {
                        this.A0A = A1G(this.A0a, this.A07, false);
                        if (this.A0A != null) {
                            Log.w(A0a(175, 18, 36), A0a(101, 40, 114) + str + A0a(0, 6, 116) + A0a(670, 52, 100) + this.A0A.A02 + A0a(6, 1, 76));
                        }
                    }
                } catch (C0353Dr e) {
                    A0m(new C0346Dk(this.A07, e, z, -49998));
                }
                if (this.A0A == null) {
                    A0m(new C0346Dk(this.A07, (Throwable) null, z, -49999));
                }
            }
            if (A1S(this.A0A)) {
                String str2 = this.A0A.A02;
                this.A00 = A0X(str2);
                this.A0D = A0w(str2, this.A07);
                this.A0H = A0v(str2);
                this.A0G = A0s(this.A0A);
                this.A0E = A0t(str2);
                this.A0F = A0u(str2);
                this.A0I = A0x(str2, this.A07);
                try {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    C0463Id.A02(A0a(IronSourceError.ERROR_BN_INSTANCE_INIT_TIMEOUT, 12, 120) + str2);
                    this.A06 = MediaCodec.createByCodecName(str2);
                    C0463Id.A00();
                    C0463Id.A02(A0a(593, 14, 72));
                    A1P(this.A0A, this.A06, this.A07, mediaCrypto);
                    C0463Id.A00();
                    C0463Id.A02(A0a(722, 10, 17));
                    this.A06.start();
                    C0463Id.A00();
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    A1Q(str2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                    A0d();
                } catch (Exception e2) {
                    A0m(new C0346Dk(this.A07, e2, z, str2));
                }
                if (A70() == 2) {
                    j = SystemClock.elapsedRealtime() + 1000;
                } else {
                    j = -9223372036854775807L;
                }
                this.A05 = j;
                A0i();
                A0j();
                this.A0Q = true;
                this.A0U.A00++;
            }
        }
    }

    public void A1L(long j) {
    }

    public void A1M(MediaCodec mediaCodec, MediaFormat mediaFormat) throws A4 {
    }

    public void A1N(Format format) throws A4 {
        DrmInitData drmInitData;
        MediaCodec mediaCodec;
        int A1C;
        boolean z;
        Format format2 = this.A07;
        this.A07 = format;
        DrmInitData drmInitData2 = this.A07.A0H;
        if (format2 == null) {
            drmInitData = null;
        } else {
            drmInitData = format2.A0H;
        }
        if (!C0466Ig.A0h(drmInitData2, drmInitData)) {
            if (this.A07.A0H != null) {
                C4<Y7> c4 = this.A0Z;
                if (A0e[5].charAt(22) != 'm') {
                    String[] strArr = A0e;
                    strArr[4] = "js0xY6djzstMh1ZGSSFwxrm9J2KEODfF";
                    strArr[2] = "gNDkR57A7pqknHdJ9eFPG5bc7UDUELIy";
                    if (c4 != null) {
                        Looper myLooper = Looper.myLooper();
                        DrmInitData drmInitData3 = this.A07.A0H;
                        if (A0e[5].charAt(22) != 'm') {
                            String[] strArr2 = A0e;
                            strArr2[7] = "L1yeHoCGmaJe3p3nUxagVjwy9TYWwSRI";
                            strArr2[7] = "L1yeHoCGmaJe3p3nUxagVjwy9TYWwSRI";
                            this.A09 = c4.A2Q(myLooper, drmInitData3);
                            C3<Y7> c3 = this.A09;
                            if (c3 == this.A08) {
                                C4<Y7> c42 = this.A0Z;
                                String[] strArr3 = A0e;
                                if (strArr3[1].charAt(9) != strArr3[6].charAt(9)) {
                                    String[] strArr4 = A0e;
                                    strArr4[1] = "PNJFXv8k8SK4Yjj8VNQjLQpnTp0fAy1J";
                                    strArr4[6] = "VCM67JEqNnPycf67Mw9BgN4gUhlxC0Ru";
                                    c42.ACJ(c3);
                                } else {
                                    throw new RuntimeException();
                                }
                            }
                        }
                    } else {
                        throw A4.A01(new IllegalStateException(A0a(141, 34, 103)), A10());
                    }
                }
                throw new RuntimeException();
            }
            this.A09 = null;
        }
        boolean z2 = false;
        if (!(this.A09 != this.A08 || (mediaCodec = this.A06) == null || (A1C = A1C(mediaCodec, this.A0A, format2, this.A07)) == 0)) {
            if (A1C == 1) {
                z2 = true;
            } else if (A1C == 3) {
                z2 = true;
                this.A0L = true;
                this.A01 = 1;
                int i = this.A00;
                if (i == 2 || (i == 1 && this.A07.A0F == format2.A0F && this.A07.A08 == format2.A08)) {
                    z = true;
                } else {
                    z = false;
                }
                this.A0C = z;
            } else {
                throw new IllegalStateException();
            }
        }
        if (z2) {
            return;
        }
        if (this.A0J) {
            this.A02 = 1;
            return;
        }
        A1I();
        A1K();
    }

    public void A1O(C0861Xw xw) {
    }

    public void A1Q(String str, long j, long j2) {
    }

    public boolean A1S(C0344Di di) {
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0844Xf
    public boolean A7Z() {
        return this.A0N;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004d, code lost:
        if (r3 == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0072, code lost:
        if (r3 != 0) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x008c, code lost:
        if (r3 != 0) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008f, code lost:
        if (r3 == false) goto L_0x004f;
     */
    @Override // com.facebook.ads.redexgen.X.AbstractC0844Xf
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean A7i() {
        /*
        // Method dump skipped, instructions count: 154
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass3S.A7i():boolean");
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0844Xf
    public final void ACQ(long j, long j2) throws A4 {
        if (this.A0N) {
            A1J();
            return;
        }
        if (this.A07 == null) {
            this.A0Y.A07();
            int A12 = A12(this.A0W, this.A0Y, true);
            if (A12 == -5) {
                A1N(this.A0W.A00);
            } else if (A12 == -4) {
                I1.A04(this.A0Y.A04());
                this.A0M = true;
                A0e();
                String[] strArr = A0e;
                if (strArr[3].charAt(8) != strArr[0].charAt(8)) {
                    String[] strArr2 = A0e;
                    strArr2[7] = "aKhyH6I995l1LklLucgRLjJ4pFFWcDrl";
                    strArr2[7] = "aKhyH6I995l1LklLucgRLjJ4pFFWcDrl";
                    return;
                }
                throw new RuntimeException();
            } else {
                return;
            }
        }
        A1K();
        if (this.A06 != null) {
            C0463Id.A02(A0a(619, 12, 16));
            do {
            } while (A0r(j, j2));
            do {
            } while (A0o());
            C0463Id.A00();
        } else {
            this.A0U.A07 += A11(j);
            this.A0Y.A07();
            int A122 = A12(this.A0W, this.A0Y, false);
            if (A122 == -5) {
                AH ah = this.A0W;
                if (A0e[7].charAt(4) != 'H') {
                    throw new RuntimeException();
                }
                String[] strArr3 = A0e;
                strArr3[7] = "H5HsHl4f2eN3vdaE4L0NqH64hfjdivD8";
                strArr3[7] = "H5HsHl4f2eN3vdaE4L0NqH64hfjdivD8";
                A1N(ah.A00);
            } else if (A122 == -4) {
                I1.A04(this.A0Y.A04());
                this.A0M = true;
                A0e();
            }
        }
        this.A0U.A00();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0270Ac
    public final int ADS(Format format) throws A4 {
        try {
            return A1D(this.A0a, this.A0Z, format);
        } catch (C0353Dr e) {
            throw A4.A01(e, A10());
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0313Cd, com.facebook.ads.redexgen.X.AbstractC0270Ac
    public final int ADU() {
        return 8;
    }
}
