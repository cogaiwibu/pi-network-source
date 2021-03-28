package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.source.TrackGroupArray;
import com.ironsource.sdk.analytics.omid.OMIDManager;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: com.facebook.ads.redexgen.X.Ca  reason: case insensitive filesystem */
public final class C0310Ca implements AbstractC0842Xd {
    public static byte[] A0M;
    public static String[] A0N;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public long A04;
    @Nullable
    public A4 A05;
    public AO A06;
    public AP A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public final Handler A0C;
    public final Handler A0D;
    public final CX A0E;
    public final C0274Ah A0F;
    public final C0275Ai A0G;
    public final HB A0H;
    public final HC A0I;
    public final ArrayDeque<A8> A0J;
    public final CopyOnWriteArraySet<AS> A0K;
    public final AbstractC0844Xf[] A0L;

    static {
        A04();
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0M, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A0N[7].length() != 1) {
                String[] strArr = A0N;
                strArr[7] = "NVWBbKH";
                strArr[7] = "NVWBbKH";
                if (i4 >= length) {
                    return new String(copyOfRange);
                }
                copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 75);
                i4++;
            } else {
                throw new RuntimeException();
            }
        }
    }

    public static void A03() {
        A0M = new byte[]{108, 23, 126, 67, 84, 107, 87, 90, 66, 94, 73, 114, 86, 75, 87, 64, 125, 106, 85, 105, 100, 124, 96, 119, 73, 108, 103, 42, 55, 43, 61, 43, 49, 54, 17, 22, 11, 95, 27, 44, 37, 44, 40, 58, 44, 105, 64, 72, 53, 78, 50, 36, 36, 42, 21, 46, 97, 40, 38, 47, 46, 51, 36, 37, 97, 35, 36, 34, 32, 52, 50, 36, 97, 32, 47, 97, 32, 37, 97, 40, 50, 97, 49, 45, 32, 56, 40, 47, 38};
    }

    public static void A04() {
        A0N = new String[]{"FdQu0fmyjo2y", "53g7H5tUmq98heWq", "c", "OWB4F6Jbct6Ly4JY", "NHyc4CVBcI41", "VuRuzyUBfoaB1KqcrIY9ro", "m", "Ea4pNsdJDJP"};
    }

    @SuppressLint({"HandlerLeak"})
    public C0310Ca(AbstractC0844Xf[] xfArr, HB hb, AJ aj, I4 i4) {
        boolean z;
        Looper mainLooper;
        Log.i(A02(2, 13, 112), A02(33, 5, 52) + Integer.toHexString(System.identityHashCode(this)) + A02(0, 2, 7) + A02(15, 18, 78) + A02(47, 3, 94) + C0466Ig.A04 + A02(46, 1, 86));
        if (xfArr.length > 0) {
            z = true;
        } else {
            z = false;
        }
        I1.A04(z);
        this.A0L = (AbstractC0844Xf[]) I1.A01(xfArr);
        this.A0H = (HB) I1.A01(hb);
        this.A0A = false;
        this.A03 = 0;
        this.A0B = false;
        this.A0K = new CopyOnWriteArraySet<>();
        this.A0I = new HC(new C0271Ad[xfArr.length], new H8[xfArr.length], null);
        this.A0G = new C0275Ai();
        this.A0F = new C0274Ah();
        this.A07 = AP.A04;
        if (Looper.myLooper() != null) {
            mainLooper = Looper.myLooper();
        } else {
            mainLooper = Looper.getMainLooper();
        }
        this.A0C = new A7(this, mainLooper);
        this.A06 = new AO(AbstractC0276Aj.A01, 0, TrackGroupArray.A04, this.A0I);
        this.A0J = new ArrayDeque<>();
        this.A0E = new CX(xfArr, hb, this.A0I, aj, this.A0A, this.A03, this.A0B, this.A0C, this, i4);
        this.A0D = new Handler(this.A0E.A0x());
    }

    private long A00(long j) {
        long A012 = C02669y.A01(j);
        if (this.A06.A04.A02()) {
            return A012;
        }
        this.A06.A03.A0A(this.A06.A04.A02, this.A0F);
        return A012 + this.A0F.A08();
    }

    private AO A01(boolean z, boolean z2, int i) {
        if (z) {
            this.A01 = 0;
            this.A00 = 0;
            this.A04 = 0;
        } else {
            this.A01 = A5w();
            this.A00 = A08();
            this.A04 = A5t();
        }
        AO ao = new AO(z2 ? AbstractC0276Aj.A01 : this.A06.A03, z2 ? null : this.A06.A07, this.A06.A04, this.A06.A02, this.A06.A01, i, false, z2 ? TrackGroupArray.A04 : this.A06.A05, z2 ? this.A0I : this.A06.A06);
        String[] strArr = A0N;
        if (strArr[6].length() != strArr[2].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0N;
        strArr2[7] = "Xqr2ExcYOBi8j1Q";
        strArr2[7] = "Xqr2ExcYOBi8j1Q";
        return ao;
    }

    private void A05(AO ao, int i, boolean z, int timelineChangeReason) {
        int i2;
        AO ao2 = ao;
        this.A02 -= i;
        if (this.A02 == 0) {
            if (ao2.A02 == -9223372036854775807L) {
                ao2 = ao2.A04(ao2.A04, 0, ao2.A01);
            }
            if (!this.A06.A03.A0F() || this.A08) {
                AbstractC0276Aj aj = ao2.A03;
                String[] strArr = A0N;
                if (strArr[1].length() == strArr[3].length()) {
                    String[] strArr2 = A0N;
                    strArr2[7] = "oGDG41JiAsT7PCq0";
                    strArr2[7] = "oGDG41JiAsT7PCq0";
                    if (aj.A0F()) {
                        this.A00 = 0;
                        this.A01 = 0;
                        String[] strArr3 = A0N;
                        if (strArr3[6].length() == strArr3[2].length()) {
                            String[] strArr4 = A0N;
                            strArr4[1] = "vrOcQin3pszluGLq";
                            strArr4[3] = "REI4M31lEJcbEC2a";
                            this.A04 = 0;
                        }
                    }
                }
                throw new RuntimeException();
            }
            if (this.A08) {
                i2 = 0;
            } else {
                i2 = 2;
            }
            boolean z2 = this.A09;
            this.A08 = false;
            this.A09 = false;
            A06(ao2, z, timelineChangeReason, i2, z2, false);
        }
    }

    private void A06(AO ao, boolean z, int i, int i2, boolean z2, boolean z3) {
        boolean z4 = !this.A0J.isEmpty();
        this.A0J.addLast(new A8(ao, this.A06, this.A0K, this.A0H, z, i, i2, z2, this.A0A, z3));
        this.A06 = ao;
        if (!z4) {
            while (!this.A0J.isEmpty()) {
                this.A0J.peekFirst().A01();
                this.A0J.removeFirst();
            }
        }
    }

    private boolean A07() {
        return this.A06.A03.A0F() || this.A02 > 0;
    }

    public final int A08() {
        if (A07()) {
            return this.A00;
        }
        return this.A06.A04.A02;
    }

    public final void A09(int i) {
        A0A(i, -9223372036854775807L);
    }

    public final void A0A(int i, long j) {
        long A002;
        long j2;
        AbstractC0276Aj aj = this.A06.A03;
        if (i >= 0) {
            boolean A0F2 = aj.A0F();
            if (A0N[5].length() == 22) {
                String[] strArr = A0N;
                strArr[6] = "k";
                strArr[2] = "F";
                if (A0F2 || i < aj.A02()) {
                    this.A09 = true;
                    this.A02++;
                    boolean A0C2 = A0C();
                    if (A0N[7].length() != 1) {
                        String[] strArr2 = A0N;
                        strArr2[1] = "iOLxdGxzjtj8VTTv";
                        strArr2[3] = "k2rTYfByBhCiNj1b";
                        if (A0C2) {
                            String A022 = A02(2, 13, 112);
                            String[] strArr3 = A0N;
                            if (strArr3[4].length() == strArr3[0].length()) {
                                String[] strArr4 = A0N;
                                strArr4[7] = "fs0FIhTd6T569fWM98lB5KOUS";
                                strArr4[7] = "fs0FIhTd6T569fWM98lB5KOUS";
                                Log.w(A022, A02(50, 39, 10));
                                this.A0C.obtainMessage(0, 1, -1, this.A06).sendToTarget();
                                return;
                            }
                        } else {
                            this.A01 = i;
                            if (aj.A0F()) {
                                int i2 = (j > -9223372036854775807L ? 1 : (j == -9223372036854775807L ? 0 : -1));
                                if (A0N[7].length() != 1) {
                                    String[] strArr5 = A0N;
                                    strArr5[5] = "dOqGbPzaS7jKfyvdUFqkQf";
                                    strArr5[5] = "dOqGbPzaS7jKfyvdUFqkQf";
                                    if (i2 == 0) {
                                        j2 = 0;
                                    } else {
                                        j2 = j;
                                    }
                                    this.A04 = j2;
                                    this.A00 = 0;
                                } else {
                                    throw new RuntimeException();
                                }
                            } else {
                                if (j == -9223372036854775807L) {
                                    A002 = aj.A0C(i, this.A0G).A01();
                                } else {
                                    A002 = C02669y.A00(j);
                                }
                                Pair<Integer, Long> A082 = aj.A08(this.A0G, this.A0F, i, A002);
                                this.A04 = C02669y.A01(A002);
                                this.A00 = ((Integer) A082.first).intValue();
                            }
                            this.A0E.A0z(aj, i, C02669y.A00(j));
                            Iterator<AS> it = this.A0K.iterator();
                            while (it.hasNext()) {
                                AS next = it.next();
                                String[] strArr6 = A0N;
                                if (strArr6[4].length() != strArr6[0].length()) {
                                    throw new RuntimeException();
                                }
                                String[] strArr7 = A0N;
                                strArr7[1] = "l5NWk5x9vooO50uu";
                                strArr7[3] = "FcAzQ8glamB386Jq";
                                next.AAZ(1);
                            }
                            return;
                        }
                    }
                }
            }
            throw new RuntimeException();
        }
        throw new AI(aj, i, j);
    }

    /* JADX INFO: Multiple debug info for r6v0 'this'  com.facebook.ads.redexgen.X.Ca: [D('playbackError' com.facebook.ads.redexgen.X.A4), D('playbackParameters' com.facebook.ads.redexgen.X.AP)] */
    public final void A0B(Message message) {
        int i = message.what;
        boolean z = true;
        if (i != 0) {
            if (i != 1) {
                String[] strArr = A0N;
                if (strArr[4].length() == strArr[0].length()) {
                    String[] strArr2 = A0N;
                    strArr2[5] = "7KT5lT3IIkvardi0cOE285";
                    strArr2[5] = "7KT5lT3IIkvardi0cOE285";
                    if (i == 2) {
                        A4 a4 = (A4) message.obj;
                        this.A05 = a4;
                        Iterator<AS> it = this.A0K.iterator();
                        while (true) {
                            boolean hasNext = it.hasNext();
                            String[] strArr3 = A0N;
                            if (strArr3[4].length() != strArr3[0].length()) {
                                throw new RuntimeException();
                            }
                            String[] strArr4 = A0N;
                            strArr4[7] = "lr70Wm3MPuK1";
                            strArr4[7] = "lr70Wm3MPuK1";
                            if (hasNext) {
                                it.next().AAV(a4);
                            } else {
                                return;
                            }
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                }
            } else {
                AP ap = (AP) message.obj;
                if (!this.A07.equals(ap)) {
                    this.A07 = ap;
                    CopyOnWriteArraySet<AS> copyOnWriteArraySet = this.A0K;
                    String[] strArr5 = A0N;
                    if (strArr5[6].length() == strArr5[2].length()) {
                        String[] strArr6 = A0N;
                        strArr6[1] = "XPkhdR3hZ8JGZkbg";
                        strArr6[3] = "HitM1md97HqEAHyx";
                        Iterator<AS> it2 = copyOnWriteArraySet.iterator();
                        while (it2.hasNext()) {
                            it2.next().AAT(ap);
                        }
                        return;
                    }
                } else {
                    return;
                }
            }
            throw new RuntimeException();
        }
        AO ao = (AO) message.obj;
        int i2 = message.arg1;
        if (message.arg2 == -1) {
            z = false;
        }
        A05(ao, i2, z, message.arg2);
    }

    public final boolean A0C() {
        return !A07() && this.A06.A04.A02();
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final void A3H(AS as) {
        this.A0K.add(as);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0842Xd
    public final C0268Aa A4K(AZ az) {
        return new C0268Aa(this.A0E, az, this.A06.A03, A5w(), this.A0D);
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final int A5W() {
        long A5X = A5X();
        long A64 = A64();
        if (A5X != -9223372036854775807L) {
            int i = (A64 > -9223372036854775807L ? 1 : (A64 == -9223372036854775807L ? 0 : -1));
            String[] strArr = A0N;
            if (strArr[6].length() != strArr[2].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0N;
            strArr2[6] = OMIDManager.OMID_PARTNER_VERSION;
            strArr2[2] = "n";
            if (i != 0) {
                String[] strArr3 = A0N;
                if (strArr3[4].length() != strArr3[0].length()) {
                    throw new RuntimeException();
                }
                String[] strArr4 = A0N;
                strArr4[6] = "w";
                strArr4[2] = "D";
                if (A64 == 0) {
                    return 100;
                }
                return C0466Ig.A06((int) ((100 * A5X) / A64), 0, 100);
            }
        }
        return 0;
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final long A5X() {
        if (A07()) {
            return this.A04;
        }
        return A00(this.A06.A09);
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final long A5o() {
        if (!A0C()) {
            return A5t();
        }
        this.A06.A03.A0A(this.A06.A04.A02, this.A0F);
        return this.A0F.A08() + C02669y.A01(this.A06.A01);
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final int A5q() {
        if (A0C()) {
            return this.A06.A04.A00;
        }
        return -1;
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final int A5r() {
        if (A0C()) {
            return this.A06.A04.A01;
        }
        return -1;
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final long A5t() {
        if (A07()) {
            return this.A04;
        }
        return A00(this.A06.A0A);
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final AbstractC0276Aj A5v() {
        return this.A06.A03;
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final int A5w() {
        if (A07()) {
            return this.A01;
        }
        return this.A06.A03.A0A(this.A06.A04.A02, this.A0F).A00;
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final long A64() {
        AbstractC0276Aj aj = this.A06.A03;
        if (aj.A0F()) {
            return -9223372036854775807L;
        }
        if (!A0C()) {
            return aj.A0C(A5w(), this.A0G).A02();
        }
        FG fg = this.A06.A04;
        aj.A0A(fg.A02, this.A0F);
        return C02669y.A01(this.A0F.A0A(fg.A00, fg.A01));
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final boolean A6k() {
        return this.A0A;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0842Xd
    public final void ABj(FI fi, boolean z, boolean z2) {
        this.A05 = null;
        AO A012 = A01(z, z2, 2);
        this.A08 = true;
        this.A02++;
        this.A0E.A10(fi, z, z2);
        A06(A012, false, 4, 1, false, false);
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final void ACD() {
        StringBuilder sb = new StringBuilder();
        sb.append(A02(38, 8, 2));
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(A02(0, 2, 7));
        sb.append(A02(15, 18, 78));
        String A022 = A02(47, 3, 94);
        sb.append(A022);
        sb.append(C0466Ig.A04);
        sb.append(A022);
        sb.append(AE.A00());
        sb.append(A02(46, 1, 86));
        Log.i(A02(2, 13, 112), sb.toString());
        this.A0E.A0y();
        this.A0C.removeCallbacksAndMessages(null);
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final void ACl(long j) {
        A0A(A5w(), j);
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final void ACm() {
        A09(A5w());
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final void AD2(boolean z) {
        if (this.A0A != z) {
            this.A0A = z;
            this.A0E.A11(z);
            A06(this.A06, false, 4, 1, false, true);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final void ADP(boolean z) {
        if (z) {
            this.A05 = null;
        }
        AO A012 = A01(z, z, 1);
        this.A02++;
        this.A0E.A12(z);
        A06(A012, false, 4, 1, false, false);
    }
}
