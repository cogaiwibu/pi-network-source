package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import kotlin.jvm.internal.ByteCompanionObject;

/* renamed from: com.facebook.ads.redexgen.X.Xo  reason: case insensitive filesystem */
public final class C0853Xo implements BG {
    public static boolean A0p = false;
    public static boolean A0q = false;
    public static byte[] A0r;
    public static String[] A0s;
    public float A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public int A09;
    public int A0A;
    public int A0B;
    public int A0C;
    public int A0D;
    public long A0E;
    public long A0F;
    public long A0G;
    public long A0H;
    public long A0I;
    public long A0J;
    public long A0K;
    public long A0L;
    public AudioTrack A0M;
    @Nullable
    public AudioTrack A0N;
    @Nullable
    public AP A0O;
    public AP A0P;
    public C0288Av A0Q;
    @Nullable
    public BE A0R;
    @Nullable
    public ByteBuffer A0S;
    @Nullable
    public ByteBuffer A0T;
    @Nullable
    public ByteBuffer A0U;
    public boolean A0V;
    public boolean A0W;
    public boolean A0X;
    public boolean A0Y;
    public boolean A0Z;
    public boolean A0a;
    public boolean A0b;
    public byte[] A0c;
    public B3[] A0d;
    public ByteBuffer[] A0e;
    public final ConditionVariable A0f;
    @Nullable
    public final C0289Aw A0g;
    public final BM A0h;
    public final C0850Xl A0i;
    public final BP A0j;
    public final C0860Xv A0k;
    public final ArrayDeque<BR> A0l;
    public final boolean A0m;
    public final B3[] A0n;
    public final B3[] A0o;

    public static String A0I(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0r, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 75);
        }
        return new String(copyOfRange);
    }

    public static void A0O() {
        A0r = new byte[]{68, 72, 15, 7, 28, 72, 94, 106, 123, 118, 112, 75, 109, 126, 124, 116, 78, 99, 121, 105, 101, 100, 126, 99, 100, ByteCompanionObject.MAX_VALUE, 99, 126, 115, 42, 110, 111, 126, 111, 105, 126, 111, 110, 42, 81, 111, 114, 122, 111, 105, 126, 111, 110, 42, 14, 22, 9, 4, 9, 1, 8, 63, 41, 63, 46, 46, 51, 52, 61, 122, 41, 46, 59, 54, 54, 63, 62, 122, 59, 47, 62, 51, 53, 122, 46, 40, 59, 57, 49, 102, 93, 86, 75, 67, 86, 80, 71, 86, 87, 19, 82, 70, 87, 90, 92, 19, 86, 93, 80, 92, 87, 90, 93, 84, 9, 19, 96, 91, 70, 64, 69, 69, 90, 71, 65, 80, 81, 21, 86, 93, 84, 91, 91, 80, 89, 21, 86, 90, 64, 91, 65, 15, 21, 101, 10, 3, 31, 24, 9, 30, 59, 40, 58, 40};
    }

    public static void A0P() {
        A0s = new String[]{"5Nyv0guRYVcKSAuezGPcUxg9vJAOBGI4", "vvUbbcGamjazB6O7sNKlV2Due1EGN4h1", "bCdq7Y65nqLa7O1PpyZ9UmfFfim1tIKH", "XSMaSGyqY735xp0uf5mX1ioiT5AfU73", "LbuXdG3g6wlkS0wgubrQcd1EFcxL1vaW", "BfdFnDj7fdcaZnnCNK5XWBslzsEwyMTC", "82TROEAjyC6M053XP3PwF3IgkAnZSWb8", "TH4S9e3rxD8emXavfeipeAwkF3kWLOvQ"};
    }

    static {
        A0P();
        A0O();
    }

    public C0853Xo(@Nullable C0289Aw aw, BP bp, boolean z) {
        this.A0g = aw;
        this.A0j = (BP) I1.A01(bp);
        this.A0m = z;
        this.A0f = new ConditionVariable(true);
        this.A0h = new BM(new C0852Xn(this, null));
        this.A0i = new C0850Xl();
        this.A0k = new C0860Xv();
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new C0856Xr(), this.A0i, this.A0k);
        Collections.addAll(arrayList, bp.A5Q());
        this.A0o = (B3[]) arrayList.toArray(new B3[arrayList.size()]);
        this.A0n = new B3[]{new C0854Xp()};
        this.A00 = 1.0f;
        this.A0D = 0;
        this.A0Q = C0288Av.A04;
        this.A01 = 0;
        this.A0P = AP.A04;
        this.A04 = -1;
        this.A0d = new B3[0];
        this.A0e = new ByteBuffer[0];
        this.A0l = new ArrayDeque<>();
    }

    public C0853Xo(@Nullable C0289Aw aw, B3[] b3Arr) {
        this(aw, b3Arr, false);
    }

    public C0853Xo(@Nullable C0289Aw aw, B3[] b3Arr, boolean z) {
        this(aw, new C0851Xm(b3Arr), z);
    }

    public static int A00(int i, ByteBuffer byteBuffer) {
        if (i == 7 || i == 8) {
            return BT.A00(byteBuffer);
        }
        if (i == 5) {
            return C0285As.A00();
        }
        if (i == 6) {
            return C0285As.A03(byteBuffer);
        }
        if (i == 14) {
            int A022 = C0285As.A02(byteBuffer);
            if (A022 == -1) {
                return 0;
            }
            int A042 = C0285As.A04(byteBuffer, A022);
            String[] strArr = A0s;
            if (strArr[5].charAt(2) != strArr[2].charAt(2)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0s;
            strArr2[3] = "Dqt88CMr8vwwAc3fZIJcRVt2XyhD8Cl";
            strArr2[3] = "Dqt88CMr8vwwAc3fZIJcRVt2XyhD8Cl";
            return A042 * 16;
        }
        throw new IllegalStateException(A0I(84, 27, 120) + i);
    }

    @TargetApi(21)
    public static int A01(AudioTrack audioTrack, ByteBuffer byteBuffer, int i) {
        return audioTrack.write(byteBuffer, i, 1);
    }

    @TargetApi(21)
    private int A02(AudioTrack audioTrack, ByteBuffer byteBuffer, int i, long j) {
        if (this.A0S == null) {
            this.A0S = ByteBuffer.allocate(16);
            this.A0S.order(ByteOrder.BIG_ENDIAN);
            this.A0S.putInt(1431633921);
        }
        if (this.A03 == 0) {
            this.A0S.putInt(4, i);
            this.A0S.putLong(8, 1000 * j);
            this.A0S.position(0);
            this.A03 = i;
        }
        int remaining = this.A0S.remaining();
        if (remaining > 0) {
            int write = audioTrack.write(this.A0S, remaining, 1);
            if (write < 0) {
                this.A03 = 0;
                return write;
            } else if (write < remaining) {
                return 0;
            }
        }
        int A012 = A01(audioTrack, byteBuffer, i);
        String[] strArr = A0s;
        if (strArr[4].charAt(9) != strArr[1].charAt(9)) {
            String[] strArr2 = A0s;
            strArr2[5] = "EGdI4VK4aN1uiBzzsuaeFo7lQ03tB7Gh";
            strArr2[2] = "vodoofn0TiYpLi76FRuwTlDh379TFVaK";
            if (A012 < 0) {
                this.A03 = 0;
                return A012;
            }
            this.A03 -= A012;
            return A012;
        }
        throw new RuntimeException();
    }

    /* access modifiers changed from: private */
    public long A03() {
        return this.A0X ? this.A0J / ((long) this.A0B) : this.A0I;
    }

    /* access modifiers changed from: private */
    public long A04() {
        return this.A0X ? this.A0L / ((long) this.A09) : this.A0K;
    }

    private long A05(long j) {
        return A08(this.A0j.A6z()) + j;
    }

    private long A06(long j) {
        BR br = null;
        while (!this.A0l.isEmpty() && j >= BR.A00(this.A0l.getFirst())) {
            br = this.A0l.remove();
        }
        if (br != null) {
            this.A0P = BR.A02(br);
            this.A0G = BR.A00(br);
            this.A0F = BR.A01(br) - this.A0H;
        }
        if (this.A0P.A01 == 1.0f) {
            return (this.A0F + j) - this.A0G;
        }
        if (this.A0l.isEmpty()) {
            return this.A0F + this.A0j.A6X(j - this.A0G);
        }
        return this.A0F + C0466Ig.A0C(j - this.A0G, this.A0P.A01);
    }

    private long A07(long j) {
        return (((long) this.A0A) * j) / 1000000;
    }

    private long A08(long j) {
        return (1000000 * j) / ((long) this.A0A);
    }

    private long A09(long j) {
        return (1000000 * j) / ((long) this.A06);
    }

    @TargetApi(21)
    private AudioTrack A0D() {
        AudioAttributes A002;
        if (this.A0b) {
            A002 = new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        } else {
            A002 = this.A0Q.A00();
        }
        AudioFormat build = new AudioFormat.Builder().setChannelMask(this.A07).setEncoding(this.A08).setSampleRate(this.A0A).build();
        int i = this.A01;
        if (i == 0) {
            i = 0;
        }
        return new AudioTrack(A002, build, this.A02, 1, i);
    }

    /* JADX INFO: Multiple debug info for r10v0 'this'  com.facebook.ads.redexgen.X.Xo: [D('audioTrack' android.media.AudioTrack), D('streamType' int)] */
    private AudioTrack A0E() throws BD {
        AudioTrack audioTrack;
        if (C0466Ig.A02 >= 21) {
            audioTrack = A0D();
        } else {
            int A032 = C0466Ig.A03(this.A0Q.A03);
            int i = this.A01;
            String[] strArr = A0s;
            if (strArr[4].charAt(9) != strArr[1].charAt(9)) {
                String[] strArr2 = A0s;
                strArr2[4] = "uEqtixTroQ47jvhgXsjygxp317gkhCVZ";
                strArr2[1] = "MeWTB72qJhBmjPGmSmxXQDSK14yx53vJ";
                if (i == 0) {
                    audioTrack = new AudioTrack(A032, this.A0A, this.A07, this.A08, this.A02, 1);
                } else {
                    audioTrack = new AudioTrack(A032, this.A0A, this.A07, this.A08, this.A02, 1, i);
                }
            } else {
                throw new RuntimeException();
            }
        }
        int state = audioTrack.getState();
        if (state == 1) {
            return audioTrack;
        }
        try {
            audioTrack.release();
        } catch (Exception unused) {
        }
        throw new BD(state, this.A0A, this.A07, this.A02);
    }

    private AudioTrack A0F(int i) {
        return new AudioTrack(3, 4000, 4, 2, 2, 0, i);
    }

    private void A0J() {
        int i = 0;
        while (true) {
            B3[] b3Arr = this.A0d;
            if (i < b3Arr.length) {
                B3 b3 = b3Arr[i];
                b3.flush();
                this.A0e[i] = b3.A6a();
                i++;
            } else {
                return;
            }
        }
    }

    private void A0K() throws BD {
        AP ap;
        this.A0f.block();
        this.A0M = A0E();
        int audioSessionId = this.A0M.getAudioSessionId();
        if (A0p && C0466Ig.A02 < 21) {
            AudioTrack audioTrack = this.A0N;
            if (audioTrack != null) {
                int audioSessionId2 = audioTrack.getAudioSessionId();
                String[] strArr = A0s;
                if (strArr[4].charAt(9) != strArr[1].charAt(9)) {
                    String[] strArr2 = A0s;
                    strArr2[7] = "BXErtyYgJXamt9yde7CeLqS26Q9j6Dt3";
                    strArr2[7] = "BXErtyYgJXamt9yde7CeLqS26Q9j6Dt3";
                    if (audioSessionId != audioSessionId2) {
                        A0L();
                    }
                } else {
                    throw new RuntimeException();
                }
            }
            if (this.A0N == null) {
                this.A0N = A0F(audioSessionId);
            }
        }
        if (this.A01 != audioSessionId) {
            this.A01 = audioSessionId;
            BE be = this.A0R;
            if (be != null) {
                be.A8y(audioSessionId);
            }
        }
        if (this.A0V) {
            ap = this.A0j.A3R(this.A0P);
        } else {
            ap = AP.A04;
        }
        this.A0P = ap;
        A0N();
        this.A0h.A0H(this.A0M, this.A08, this.A09, this.A02);
        A0M();
    }

    private void A0L() {
        if (this.A0N != null) {
            AudioTrack audioTrack = this.A0N;
            this.A0N = null;
            new BO(this, audioTrack).start();
        }
    }

    private void A0M() {
        if (A0V()) {
            if (C0466Ig.A02 >= 21) {
                AudioTrack audioTrack = this.A0M;
                float f = this.A00;
                if (A0s[3].length() != 31) {
                    throw new RuntimeException();
                }
                String[] strArr = A0s;
                strArr[7] = "8NL9PZoDB9Ch1WQJQaXfXaVAIVHPoweZ";
                strArr[7] = "8NL9PZoDB9Ch1WQJQaXfXaVAIVHPoweZ";
                A0R(audioTrack, f);
                return;
            }
            A0S(this.A0M, this.A00);
        }
    }

    private void A0N() {
        ArrayList arrayList = new ArrayList();
        B3[] A0W2 = A0W();
        for (B3 b3 : A0W2) {
            if (b3.A7V()) {
                arrayList.add(b3);
            } else {
                b3.flush();
            }
        }
        int size = arrayList.size();
        B3[] b3Arr = new B3[size];
        if (A0s[3].length() != 31) {
            throw new RuntimeException();
        }
        String[] strArr = A0s;
        strArr[5] = "YRdEguSYP1wOqJMzR8T0sEbN9ru3F1GF";
        strArr[2] = "jCd7Ib2fALhdhS4xedSLoMHgXMVbMQ2Z";
        this.A0d = (B3[]) arrayList.toArray(b3Arr);
        this.A0e = new ByteBuffer[size];
        A0J();
    }

    private void A0Q(long j) throws BF {
        ByteBuffer input;
        int length = this.A0d.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                input = this.A0e[i - 1];
            } else {
                input = this.A0T;
                if (input == null) {
                    input = B3.A00;
                }
            }
            if (i == length) {
                A0T(input, j);
            } else {
                B3 audioProcessor = this.A0d[i];
                audioProcessor.ABv(input);
                ByteBuffer A6a = audioProcessor.A6a();
                this.A0e[i] = A6a;
                if (A6a.hasRemaining()) {
                    i++;
                }
            }
            if (!input.hasRemaining()) {
                i--;
            } else {
                return;
            }
        }
    }

    @TargetApi(21)
    public static void A0R(AudioTrack audioTrack, float f) {
        audioTrack.setVolume(f);
    }

    public static void A0S(AudioTrack audioTrack, float f) {
        audioTrack.setStereoVolume(f, f);
    }

    private void A0T(ByteBuffer byteBuffer, long j) throws BF {
        boolean z;
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.A0U;
            boolean z2 = true;
            if (byteBuffer2 != null) {
                if (byteBuffer2 == byteBuffer) {
                    z = true;
                } else {
                    z = false;
                }
                I1.A03(z);
            } else {
                this.A0U = byteBuffer;
                if (C0466Ig.A02 < 21) {
                    int remaining = byteBuffer.remaining();
                    byte[] bArr = this.A0c;
                    if (bArr == null || bArr.length < remaining) {
                        this.A0c = new byte[remaining];
                    }
                    int position = byteBuffer.position();
                    byteBuffer.get(this.A0c, 0, remaining);
                    byteBuffer.position(position);
                    this.A0C = 0;
                }
            }
            int remaining2 = byteBuffer.remaining();
            int i = 0;
            if (C0466Ig.A02 < 21) {
                int bytesWritten = this.A0h.A0C(this.A0L);
                if (bytesWritten > 0 && (i = this.A0M.write(this.A0c, this.A0C, Math.min(remaining2, bytesWritten))) > 0) {
                    this.A0C += i;
                    byteBuffer.position(byteBuffer.position() + i);
                }
            } else if (this.A0b) {
                if (j == -9223372036854775807L) {
                    z2 = false;
                }
                I1.A04(z2);
                String[] strArr = A0s;
                if (strArr[6].charAt(18) != strArr[0].charAt(18)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0s;
                strArr2[6] = "uc8dsziOyfZDdpAIC1PVCulQ3xFiNwSU";
                strArr2[0] = "f1kQp84DxGThwffoyoPMW5CjH544FPQd";
                i = A02(this.A0M, byteBuffer, remaining2, j);
            } else {
                i = A01(this.A0M, byteBuffer, remaining2);
            }
            this.A0E = SystemClock.elapsedRealtime();
            if (i >= 0) {
                if (this.A0X) {
                    this.A0L += (long) i;
                }
                if (i == remaining2) {
                    if (!this.A0X) {
                        this.A0K += (long) this.A05;
                    }
                    this.A0U = null;
                    return;
                }
                return;
            }
            throw new BF(i);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006d, code lost:
        if (r5 != null) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0083, code lost:
        if (r5 != null) goto L_0x006f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean A0U() throws com.facebook.ads.redexgen.X.BF {
        /*
        // Method dump skipped, instructions count: 137
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0853Xo.A0U():boolean");
    }

    private boolean A0V() {
        return this.A0M != null;
    }

    private B3[] A0W() {
        return this.A0a ? this.A0n : this.A0o;
    }

    /* JADX INFO: Multiple debug info for r10v0 'this'  com.facebook.ads.redexgen.X.Xo: [D('encoding' int), D('e' com.facebook.ads.redexgen.X.B2), D('flush' boolean)] */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ee, code lost:
        if (r6 <= 23) goto L_0x00f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0162, code lost:
        if (r6 <= 23) goto L_0x00f0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0198  */
    @Override // com.facebook.ads.redexgen.X.BG
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void A46(int r11, int r12, int r13, int r14, @androidx.annotation.Nullable int[] r15, int r16, int r17) throws com.facebook.ads.redexgen.X.BC {
        /*
        // Method dump skipped, instructions count: 566
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0853Xo.A46(int, int, int, int, int[], int, int):void");
    }

    @Override // com.facebook.ads.redexgen.X.BG
    public final void A4l() {
        if (this.A0b) {
            this.A0b = false;
            this.A01 = 0;
            reset();
        }
    }

    @Override // com.facebook.ads.redexgen.X.BG
    public final void A4u(int i) {
        boolean z;
        if (C0466Ig.A02 >= 21) {
            z = true;
        } else {
            z = false;
        }
        I1.A04(z);
        if (!this.A0b || this.A01 != i) {
            this.A0b = true;
            this.A01 = i;
            reset();
        }
    }

    @Override // com.facebook.ads.redexgen.X.BG
    public final long A5u(boolean z) {
        if (!A0V() || this.A0D == 0) {
            return Long.MIN_VALUE;
        }
        return this.A0H + A05(A06(Math.min(this.A0h.A0D(z), A08(A04()))));
    }

    @Override // com.facebook.ads.redexgen.X.BG
    public final AP A6l() {
        return this.A0P;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0121, code lost:
        if (r12 == 0) goto L_0x0123;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0123, code lost:
        r19.A0H = java.lang.Math.max(0L, r21);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0134, code lost:
        if (com.facebook.ads.redexgen.X.C0853Xo.A0s[3].length() == 31) goto L_0x01dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x013b, code lost:
        throw new java.lang.RuntimeException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0148, code lost:
        if (r12 == 0) goto L_0x0123;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x014b, code lost:
        r4 = r19.A0H + A09(A03());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0159, code lost:
        if (r19.A0D != 1) goto L_0x01ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x015b, code lost:
        r15 = java.lang.Math.abs(r4 - r21);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0170, code lost:
        if (com.facebook.ads.redexgen.X.C0853Xo.A0s[7].charAt(5) == 'v') goto L_0x01cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0172, code lost:
        r9 = com.facebook.ads.redexgen.X.C0853Xo.A0s;
        r9[5] = "Mjd2F7C7kiLCVUTRblLdSlwSo04If9jH";
        r9[2] = "SFdTDB39f2uDBeT9Tbwwt5W5QdPlKJfQ";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0180, code lost:
        if (r15 <= 200000) goto L_0x01ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0182, code lost:
        android.util.Log.e(r10, A0I(16, 33, 65) + r4 + A0I(0, 6, 35) + r21 + A0I(138, 1, 115));
        r19.A0D = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01ba, code lost:
        r13 = r19.A0D;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01c7, code lost:
        if (com.facebook.ads.redexgen.X.C0853Xo.A0s[3].length() == 31) goto L_0x01ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01cb, code lost:
        r9 = com.facebook.ads.redexgen.X.C0853Xo.A0s;
        r9[7] = "vGS91cAAG7hMw0xriamqCYCKlpI1kVhb";
        r9[7] = "vGS91cAAG7hMw0xriamqCYCKlpI1kVhb";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01d9, code lost:
        if (r15 <= 200000) goto L_0x01ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01dc, code lost:
        r4 = com.facebook.ads.redexgen.X.C0853Xo.A0s;
        r4[5] = "k8d1uoKGcn9oqEPcbfqEuDtWZEluvqcv";
        r4[2] = "0FdbLpGzKjPPYkWO7EHSmW7ecHxpzOIE";
        r19.A0D = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01ec, code lost:
        r9 = com.facebook.ads.redexgen.X.C0853Xo.A0s;
        r9[6] = "1n9GuuRZsd3tbftYhBPGe0z5aHsix9eq";
        r9[0] = "CrYGxTKVQxqkoEEYRaPu1U1mUEDoOHWT";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01f8, code lost:
        if (r13 != 2) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01fa, code lost:
        r19.A0H += r21 - r4;
        r19.A0D = 1;
        r2 = r19.A0R;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0205, code lost:
        if (r2 == null) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0207, code lost:
        r2.AAY();
     */
    @Override // com.facebook.ads.redexgen.X.BG
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean A7F(java.nio.ByteBuffer r20, long r21) throws com.facebook.ads.redexgen.X.BD, com.facebook.ads.redexgen.X.BF {
        /*
        // Method dump skipped, instructions count: 555
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0853Xo.A7F(java.nio.ByteBuffer, long):boolean");
    }

    @Override // com.facebook.ads.redexgen.X.BG
    public final void A7G() {
        if (this.A0D == 1) {
            this.A0D = 2;
        }
    }

    @Override // com.facebook.ads.redexgen.X.BG
    public final boolean A7J() {
        return A0V() && this.A0h.A0K(A04());
    }

    @Override // com.facebook.ads.redexgen.X.BG
    public final boolean A7Y(int i) {
        if (!C0466Ig.A0d(i)) {
            C0289Aw aw = this.A0g;
            if (aw == null || !aw.A04(i)) {
                return false;
            }
            return true;
        } else if (i != 4 || C0466Ig.A02 >= 21) {
            return true;
        } else {
            return false;
        }
    }

    @Override // com.facebook.ads.redexgen.X.BG
    public final boolean A7Z() {
        return !A0V() || (this.A0W && !A7J());
    }

    @Override // com.facebook.ads.redexgen.X.BG
    public final void ABg() {
        this.A0Y = true;
        if (A0V()) {
            this.A0h.A0F();
            AudioTrack audioTrack = this.A0M;
            if (A0s[3].length() != 31) {
                throw new RuntimeException();
            }
            String[] strArr = A0s;
            strArr[3] = "NrYH7da7InJYZ7DcifiCDIWgHy9XttZ";
            strArr[3] = "NrYH7da7InJYZ7DcifiCDIWgHy9XttZ";
            audioTrack.play();
        }
    }

    @Override // com.facebook.ads.redexgen.X.BG
    public final void ABh() throws BF {
        if (!this.A0W) {
            boolean A0V2 = A0V();
            String[] strArr = A0s;
            if (strArr[6].charAt(18) != strArr[0].charAt(18)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0s;
            strArr2[6] = "potoNIjJr8c5PhhOHWP3V8xbrUltb98O";
            strArr2[0] = "s7h49TBBG9Upv5zOzLPi805BwVxtpEdY";
            if (A0V2 && A0U()) {
                this.A0h.A0G(A04());
                this.A0M.stop();
                this.A03 = 0;
                this.A0W = true;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.BG
    public final void ACD() {
        reset();
        A0L();
        for (B3 b3 : this.A0o) {
            b3.reset();
            if (A0s[3].length() != 31) {
                throw new RuntimeException();
            }
            String[] strArr = A0s;
            strArr[5] = "qwdTDv5zTd3QZESqVqPfOIKdJj7Lz8kg";
            strArr[2] = "LbdTDWALSGuogzF76GUONHDiI7JL2ED4";
        }
        for (B3 b32 : this.A0n) {
            b32.reset();
        }
        this.A01 = 0;
        this.A0Y = false;
        if (A0s[7].charAt(5) != 'v') {
            String[] strArr2 = A0s;
            strArr2[3] = "7yJp0zMcRreZgWUPzTirOlbpECU1qPL";
            strArr2[3] = "7yJp0zMcRreZgWUPzTirOlbpECU1qPL";
            return;
        }
        String[] strArr3 = A0s;
        strArr3[5] = "IJdzF7l1OUCqcHSZRNfx63TpictB3CeC";
        strArr3[2] = "IidC6PogfV1YW6p29FProDWayU60rDbu";
    }

    @Override // com.facebook.ads.redexgen.X.BG
    public final void ACs(C0288Av av) {
        if (!this.A0Q.equals(av)) {
            this.A0Q = av;
            if (!this.A0b) {
                reset();
                this.A01 = 0;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.BG
    public final void ACz(BE be) {
        this.A0R = be;
    }

    @Override // com.facebook.ads.redexgen.X.BG
    public final AP AD3(AP ap) {
        if (!A0V() || this.A0V) {
            AP ap2 = this.A0O;
            if (ap2 == null) {
                ap2 = !this.A0l.isEmpty() ? BR.A02(this.A0l.getLast()) : this.A0P;
            }
            if (!ap.equals(ap2)) {
                if (A0V()) {
                    this.A0O = ap;
                } else {
                    this.A0P = this.A0j.A3R(ap);
                }
            }
            return this.A0P;
        }
        this.A0P = AP.A04;
        return this.A0P;
    }

    @Override // com.facebook.ads.redexgen.X.BG
    public final void pause() {
        this.A0Y = false;
        if (A0V() && this.A0h.A0J()) {
            this.A0M.pause();
        }
    }

    @Override // com.facebook.ads.redexgen.X.BG
    public final void reset() {
        if (A0V()) {
            this.A0J = 0;
            this.A0I = 0;
            this.A0L = 0;
            this.A0K = 0;
            this.A05 = 0;
            AP ap = this.A0O;
            if (ap != null) {
                this.A0P = ap;
                this.A0O = null;
            } else if (!this.A0l.isEmpty()) {
                ArrayDeque<BR> arrayDeque = this.A0l;
                if (A0s[7].charAt(5) != 'v') {
                    String[] strArr = A0s;
                    strArr[7] = "7Zd0LJuJ8v1AsDIGeh9Ten8e10sO09Lx";
                    strArr[7] = "7Zd0LJuJ8v1AsDIGeh9Ten8e10sO09Lx";
                    this.A0P = BR.A02(arrayDeque.getLast());
                } else {
                    throw new RuntimeException();
                }
            }
            this.A0l.clear();
            this.A0F = 0;
            this.A0G = 0;
            this.A0T = null;
            this.A0U = null;
            A0J();
            this.A0W = false;
            this.A04 = -1;
            this.A0S = null;
            this.A03 = 0;
            this.A0D = 0;
            if (this.A0h.A0I()) {
                this.A0M.pause();
            }
            AudioTrack audioTrack = this.A0M;
            this.A0M = null;
            this.A0h.A0E();
            this.A0f.close();
            new BN(this, audioTrack).start();
        }
    }

    @Override // com.facebook.ads.redexgen.X.BG
    public final void setVolume(float f) {
        if (this.A00 != f) {
            this.A00 = f;
            A0M();
        }
    }
}
