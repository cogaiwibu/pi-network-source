package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.media.NotProvisionedException;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession;
import com.facebook.ads.internal.exoplayer2.drm.DrmInitData;
import com.facebook.ads.redexgen.X.C5;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@TargetApi(18)
/* renamed from: com.facebook.ads.redexgen.X.Xz  reason: case insensitive filesystem */
public final class C0864Xz<T extends C5> implements C3<T> {
    public static byte[] A0K;
    public static String[] A0L;
    public int A00;
    public int A01;
    public HandlerThread A02;
    public C0864Xz<T>.PostRequestHandler A03;
    public C1 A04;
    public T A05;
    public Object A06;
    public Object A07;
    public byte[] A08;
    public byte[] A09;
    public final C0864Xz<T>.PostResponseHandler A0A;
    public final CF A0B;
    public final UUID A0C;
    public final int A0D;
    public final int A0E;
    public final Bl<T> A0F;
    public final C0306Br A0G;
    public final DrmInitData.SchemeData A0H;
    public final CB<T> A0I;
    public final HashMap<String, String> A0J;

    static {
        A05();
        A04();
    }

    /* JADX WARNING: Error to parse debug info: 5 in method: com.facebook.ads.redexgen.X.Xz.A01():long, file: assets/audience_network.dex
    java.lang.ArrayIndexOutOfBoundsException: 5
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:221)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:137)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:111)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:569)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:44)
     */
    private long A01() {
        if (!C02669y.A05.equals(this.A0C)) {
            return Long.MAX_VALUE;
        }
        Pair<Long, Long> A012 = CJ.A01(this);
        return Math.min(((Long) A012.first).longValue(), ((Long) A012.second).longValue());
    }

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0K, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 108);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A0K = new byte[]{38, 71, 72, 67, 87, 78, 86, 38, 84, 79, 53, 71, 85, 85, 75, 81, 80, -51, -5, -10, -37, -18, -6, -2, -18, -4, -3, -47, -22, -9, -19, -11, -18, -5, -55, -10, -10, -13, -10, -92, -8, -10, -3, -19, -14, -21, -92, -8, -13, -92, -10, -23, -9, -8, -13, -10, -23, -92, -37, -19, -24, -23, -6, -19, -14, -23, -92, -17, -23, -3, -9, -78, -23, 0, 0, 6, 3, 8, -1, -70, 6, 3, -3, -1, 8, 13, -1, -70, 2, -5, 13, -70, -1, 18, 10, 3, 12, -1, -2, -70, 9, 12, -70, 17, 3, 6, 6, -70, -1, 18, 10, 3, 12, -1, -70, 13, 9, 9, 8, -56, -70, -20, -1, 7, -5, 3, 8, 3, 8, 1, -70, 13, -1, -3, 9, 8, -2, 13, -44, -70};
    }

    public static void A05() {
        A0L = new String[]{"ygnbftuzQ623Ar", "0dBxCv", "0mS6EqtDw1IrcjMleAT8IB1AlC6o9dAz", "RvmLzAjUPGIONaTchxcxVzTcBBQZgw7Y", "nJTfBRZW6rn0", "sj1G7dKmGRmO2HqivExl", "qBp8iQwY5MoBhJy8uyiyd2Hnkft4tubm", "GRqzAUhZ8aAEJGz"};
    }

    public C0864Xz(UUID uuid, CB<T> cb, Bl<T> bl, @Nullable DrmInitData.SchemeData schemeData, int i, @Nullable byte[] bArr, HashMap<String, String> hashMap, CF cf, Looper looper, C0306Br br, int i2) {
        this.A0C = uuid;
        this.A0F = bl;
        this.A0I = cb;
        this.A0E = i;
        this.A08 = bArr;
        this.A0H = bArr != null ? null : schemeData;
        this.A0J = hashMap;
        this.A0B = cf;
        this.A0D = i2;
        this.A0G = br;
        this.A01 = 2;
        this.A0A = new HandlerC0300Bk(this, looper);
        this.A02 = new HandlerThread(A02(17, 17, 29));
        this.A02.start();
        this.A03 = new HandlerC0299Bj(this, this.A02.getLooper());
    }

    private void A03() {
        if (this.A01 == 4) {
            this.A01 = 3;
            A09(new CE());
        }
    }

    private void A06(int i, boolean z) {
        byte[] bArr;
        if (i == 3) {
            bArr = this.A08;
        } else {
            bArr = this.A09;
        }
        byte[] bArr2 = null;
        String mimeType = null;
        String licenseServerUrl = null;
        DrmInitData.SchemeData schemeData = this.A0H;
        if (schemeData != null) {
            bArr2 = schemeData.A04;
            mimeType = this.A0H.A02;
            licenseServerUrl = this.A0H.A01;
        }
        try {
            this.A06 = Pair.create(this.A0I.getKeyRequest(bArr, bArr2, mimeType, i, this.A0J), licenseServerUrl);
            this.A03.A02(1, this.A06, z);
        } catch (Exception e) {
            A0A(e);
        }
    }

    private void A09(Exception exc) {
        this.A04 = new C1(exc);
        this.A0G.A04(exc);
        if (this.A01 != 4) {
            this.A01 = 1;
        }
    }

    private void A0A(Exception exc) {
        if (exc instanceof NotProvisionedException) {
            this.A0F.ABs(this);
        } else {
            A09(exc);
        }
    }

    /* JADX INFO: Multiple debug info for r4v0 'this'  com.facebook.ads.redexgen.X.Xz<T extends com.facebook.ads.redexgen.X.C5>: [D('responseData' byte[]), D('e' java.lang.Exception)] */
    /* access modifiers changed from: private */
    public void A0B(Object obj, Object obj2) {
        if (obj == this.A06) {
            boolean A0E2 = A0E();
            if (A0L[7].length() != 19) {
                String[] strArr = A0L;
                strArr[4] = "Dj52Xz5E9G6B";
                strArr[0] = "yQtL6VAJC1YqjW";
                if (A0E2) {
                    this.A06 = null;
                    if (obj2 instanceof Exception) {
                        A0A((Exception) obj2);
                        return;
                    }
                    try {
                        byte[] bArr = (byte[]) obj2;
                        if (this.A0E == 3) {
                            this.A0I.provideKeyResponse(this.A08, bArr);
                            this.A0G.A01();
                            return;
                        }
                        byte[] provideKeyResponse = this.A0I.provideKeyResponse(this.A09, bArr);
                        if (!((this.A0E != 2 && (this.A0E != 0 || this.A08 == null)) || provideKeyResponse == null || provideKeyResponse.length == 0)) {
                            this.A08 = provideKeyResponse;
                        }
                        this.A01 = 4;
                        this.A0G.A00();
                    } catch (Exception e) {
                        A0A(e);
                    }
                }
            } else {
                throw new RuntimeException();
            }
        }
    }

    /* access modifiers changed from: private */
    public void A0C(Object obj, Object obj2) {
        if (obj != this.A07) {
            return;
        }
        if (this.A01 == 2 || A0E()) {
            this.A07 = null;
            if (obj2 instanceof Exception) {
                this.A0F.AAf((Exception) obj2);
                return;
            }
            try {
                this.A0I.provideProvisionResponse((byte[]) obj2);
                Bl<T> bl = this.A0F;
                String[] strArr = A0L;
                if (strArr[4].length() != strArr[0].length()) {
                    String[] strArr2 = A0L;
                    strArr2[2] = "a4sDA20kWFGOKzGfRWeaug5eKqIpzvIQ";
                    strArr2[2] = "a4sDA20kWFGOKzGfRWeaug5eKqIpzvIQ";
                    bl.AAe();
                    return;
                }
                throw new RuntimeException();
            } catch (Exception e) {
                this.A0F.AAf(e);
            }
        }
    }

    private void A0D(boolean z) {
        int i = this.A0E;
        if (i == 0 || i == 1) {
            if (this.A08 == null) {
                A06(1, z);
            } else if (this.A01 == 4 || A0F()) {
                long A012 = A01();
                if (this.A0E == 0 && A012 <= 60) {
                    String str = A02(72, 68, 46) + A012;
                    A06(2, z);
                } else if (A012 <= 0) {
                    A09(new CE());
                } else {
                    this.A01 = 4;
                    this.A0G.A02();
                }
            }
        } else if (i == 2) {
            byte[] bArr = this.A08;
            if (A0L[5].length() != 7) {
                String[] strArr = A0L;
                strArr[3] = "nvqtgBbI1rUZtdpDbdJLT2qwzjn5A3EQ";
                strArr[3] = "nvqtgBbI1rUZtdpDbdJLT2qwzjn5A3EQ";
                if (bArr == null) {
                    A06(2, z);
                } else if (A0F()) {
                    A06(2, z);
                }
            } else {
                throw new RuntimeException();
            }
        } else if (i == 3 && A0F()) {
            A06(3, z);
        }
    }

    private boolean A0E() {
        int i = this.A01;
        return i == 3 || i == 4;
    }

    private boolean A0F() {
        try {
            this.A0I.restoreKeys(this.A09, this.A08);
            return true;
        } catch (Exception e) {
            Log.e(A02(0, 17, 118), A02(34, 38, 24), e);
            A09(e);
            return false;
        }
    }

    /* JADX INFO: Multiple debug info for r3v0 'this'  com.facebook.ads.redexgen.X.Xz<T extends com.facebook.ads.redexgen.X.C5>: [D('e' android.media.NotProvisionedException), D('e' java.lang.Exception)] */
    private boolean A0G(boolean z) {
        if (A0E()) {
            return true;
        }
        try {
            this.A09 = this.A0I.openSession();
            this.A05 = this.A0I.createMediaCrypto(this.A09);
            this.A01 = 3;
            return true;
        } catch (NotProvisionedException e) {
            if (z) {
                this.A0F.ABs(this);
                return false;
            }
            A09(e);
            return false;
        } catch (Exception e2) {
            A09(e2);
            return false;
        }
    }

    public final void A0H() {
        int i = this.A00 + 1;
        this.A00 = i;
        if (i == 1 && this.A01 != 1 && A0G(true)) {
            A0D(true);
        }
    }

    public final void A0I() {
        if (A0G(false)) {
            A0D(true);
        }
    }

    public final void A0J() {
        this.A07 = this.A0I.getProvisionRequest();
        this.A03.A02(0, this.A07, true);
    }

    public final void A0K(int i) {
        if (A0E()) {
            DefaultDrmSession<T>[] defaultDrmSessionArr = A0L;
            if (defaultDrmSessionArr[4].length() != defaultDrmSessionArr[0].length()) {
                String[] strArr = A0L;
                strArr[3] = "lZu3kopIqXcrfR3er40TopUaCPNEg1WS";
                strArr[3] = "lZu3kopIqXcrfR3er40TopUaCPNEg1WS";
                if (i == 1) {
                    this.A01 = 3;
                    this.A0F.ABs(this);
                } else if (i == 2) {
                    A0D(false);
                } else if (i == 3) {
                    A03();
                }
            } else {
                throw new RuntimeException<>();
            }
        }
    }

    public final void A0L(Exception exc) {
        A09(exc);
    }

    public final boolean A0M() {
        int i = this.A00 - 1;
        this.A00 = i;
        if (i != 0) {
            return false;
        }
        this.A01 = 0;
        this.A0A.removeCallbacksAndMessages(null);
        this.A03.removeCallbacksAndMessages(null);
        this.A03 = null;
        this.A02.quit();
        this.A02 = null;
        this.A05 = null;
        this.A04 = null;
        this.A06 = null;
        this.A07 = null;
        byte[] bArr = this.A09;
        if (bArr != null) {
            this.A0I.closeSession(bArr);
            this.A09 = null;
        }
        return true;
    }

    public final boolean A0N(byte[] bArr) {
        DrmInitData.SchemeData schemeData = this.A0H;
        return Arrays.equals(schemeData != null ? schemeData.A04 : null, bArr);
    }

    public final boolean A0O(byte[] bArr) {
        return Arrays.equals(this.A09, bArr);
    }

    @Override // com.facebook.ads.redexgen.X.C3
    public final C1 A6B() {
        if (this.A01 == 1) {
            return this.A04;
        }
        return null;
    }

    @Override // com.facebook.ads.redexgen.X.C3
    public final T A6W() {
        return this.A05;
    }

    @Override // com.facebook.ads.redexgen.X.C3
    public final int A70() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.C3
    public final Map<String, String> ABt() {
        byte[] bArr = this.A09;
        if (bArr == null) {
            return null;
        }
        CB<T> cb = this.A0I;
        if (A0L[5].length() != 7) {
            String[] strArr = A0L;
            strArr[7] = "lzhfD5NgGZX1H2DfqRAO4AgkK";
            strArr[7] = "lzhfD5NgGZX1H2DfqRAO4AgkK";
            return cb.queryKeyStatus(bArr);
        }
        throw new RuntimeException<>();
    }
}
