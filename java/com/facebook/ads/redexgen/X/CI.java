package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

@TargetApi(16)
public final class CI implements AbstractC0842Xd, AW, AU {
    public static byte[] A0O;
    public static String[] A0P;
    public float A00;
    public int A01;
    public int A02;
    public Surface A03;
    public SurfaceHolder A04;
    public TextureView A05;
    public Format A06;
    public Format A07;
    public C0288Av A08;
    public C0297Be A09;
    public C0297Be A0A;
    public FI A0B;
    public List<GF> A0C;
    public boolean A0D;
    public final Handler A0E;
    public final AbstractC0842Xd A0F;
    public final SurfaceHolder$CallbackC0845Xg A0G;
    public final C0848Xj A0H;
    public final CopyOnWriteArraySet<BB> A0I;
    public final CopyOnWriteArraySet<E1> A0J;
    public final CopyOnWriteArraySet<GJ> A0K;
    public final CopyOnWriteArraySet<J4> A0L;
    public final CopyOnWriteArraySet<AbstractC0479Iv> A0M;
    public final AbstractC0844Xf[] A0N;

    static {
        A0G();
        A0F();
    }

    public static String A07(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0O, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 58);
        }
        return new String(copyOfRange);
    }

    public static void A0F() {
        A0O = new byte[]{45, 23, 19, 14, 18, 27, 59, 6, 17, 46, 18, 31, 7, 27, 12, 9, 47, 40, 60, 59, 57, 63, 14, 63, 34, 46, 47, 40, 63, 22, 51, 41, 46, 63, 52, 63, 40, 122, 59, 54, 40, 63, 59, 62, 35, 122, 47, 52, 41, 63, 46, 122, 53, 40, 122, 40, 63, 42, 54, 59, 57, 63, 62, 116};
    }

    public static void A0G() {
        A0P = new String[]{"p1p2g9mbI7jG28uS1AIjZaN2DuNLisT4", "5M6TC2sONh3rGys5YKd78dMRKX2wOUqH", "h92WNkWPJTM", "jYXxaa6xf7axcTjhEWPmUH7zZsfwsjgI", "vYDSW5DyAu5jQwnIRgw24Ezub5gSEfu7", "VyMVayVAQGyPc0QthTR0tkMwCD52dsyF", "LU4FXKZXpKPxotYf", "puFnwNxTYtdaaLd9gUGAlTVzIEShK4ZY"};
    }

    public CI(AbstractC0272Ae ae, HB hb, AJ aj, @Nullable C4<Y7> c4) {
        this(ae, hb, aj, c4, new C0277Ak());
    }

    public CI(AbstractC0272Ae ae, HB hb, AJ aj, @Nullable C4<Y7> c4, C0277Ak ak) {
        this(ae, hb, aj, c4, ak, I4.A00);
    }

    public CI(AbstractC0272Ae ae, HB hb, AJ aj, @Nullable C4<Y7> c4, C0277Ak ak, I4 i4) {
        Looper mainLooper;
        this.A0G = new SurfaceHolder$CallbackC0845Xg(this);
        this.A0M = new CopyOnWriteArraySet<>();
        this.A0K = new CopyOnWriteArraySet<>();
        this.A0J = new CopyOnWriteArraySet<>();
        this.A0L = new CopyOnWriteArraySet<>();
        this.A0I = new CopyOnWriteArraySet<>();
        if (Looper.myLooper() != null) {
            mainLooper = Looper.myLooper();
        } else {
            mainLooper = Looper.getMainLooper();
        }
        this.A0E = new Handler<>(mainLooper);
        Handler handler = this.A0E;
        SurfaceHolder$CallbackC0845Xg xg = this.A0G;
        this.A0N = ae.A4Q(handler, xg, xg, xg, xg, c4);
        this.A00 = 1.0f;
        this.A01 = 0;
        this.A08 = C0288Av.A04;
        this.A02 = 1;
        this.A0C = Collections.emptyList();
        this.A0F = A02(this.A0N, hb, aj, i4);
        this.A0H = ak.A00(this.A0F, i4);
        A3H(this.A0H);
        this.A0L.add(this.A0H);
        this.A0I.add(this.A0H);
        A0J(this.A0H);
        if (c4 instanceof Y2) {
            ((Y2) c4).A05(this.A0E, this.A0H);
        }
    }

    private final AbstractC0842Xd A02(AbstractC0844Xf[] xfArr, HB hb, AJ aj, I4 i4) {
        return new C0310Ca(xfArr, hb, aj, i4);
    }

    private void A0E() {
        TextureView textureView = this.A05;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.A0G) {
                Log.w(A07(0, 15, 68), A07(15, 49, 96));
            } else {
                this.A05.setSurfaceTextureListener(null);
            }
            this.A05 = null;
        }
        SurfaceHolder surfaceHolder = this.A04;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.A0G);
            this.A04 = null;
        }
    }

    /* access modifiers changed from: private */
    public void A0H(Surface surface, boolean z) {
        ArrayList<C0268Aa> arrayList = new ArrayList();
        AbstractC0844Xf[] xfArr = this.A0N;
        for (AbstractC0844Xf xf : xfArr) {
            int A7A = xf.A7A();
            String[] strArr = A0P;
            if (strArr[5].charAt(24) != strArr[4].charAt(24)) {
                String[] strArr2 = A0P;
                strArr2[6] = "VrJ3McZcw7cn2zeT";
                strArr2[0] = "MNepmlV8OvsHi61EfIBswCx5NcPOIPrl";
                if (A7A == 2) {
                    arrayList.add(this.A0F.A4K(xf).A06(1).A07(surface).A05());
                }
            } else {
                throw new RuntimeException();
            }
        }
        Surface surface2 = this.A03;
        if (!(surface2 == null || surface2 == surface)) {
            try {
                for (C0268Aa aa : arrayList) {
                    aa.A0C();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            if (this.A0D) {
                this.A03.release();
            }
        }
        this.A03 = surface;
        if (A0P[7].charAt(22) != 'V') {
            throw new RuntimeException();
        }
        String[] strArr3 = A0P;
        strArr3[5] = "BcNzrhvciYYCifYD3J0kGNpt4Q56t2ws";
        strArr3[4] = "LBzJc3KMaCoazXjGhEegCXyOf3paMmXp";
        this.A0D = z;
    }

    private final void A0J(E1 e1) {
        this.A0J.add(e1);
    }

    public final int A0K() {
        return this.A01;
    }

    public final Format A0L() {
        return this.A06;
    }

    @Nullable
    public final Format A0M() {
        return this.A07;
    }

    public final void A0N() {
        ADP(false);
    }

    public final void A0O(float f) {
        this.A00 = f;
        AbstractC0844Xf[] xfArr = this.A0N;
        for (AbstractC0844Xf xf : xfArr) {
            String[] strArr = A0P;
            if (strArr[5].charAt(24) != strArr[4].charAt(24)) {
                String[] strArr2 = A0P;
                strArr2[6] = "TZ1OBcEbhXggSiRE";
                strArr2[0] = "o47SCfAcsD46THYYRPii4HELThPbmwG8";
                if (xf.A7A() == 1) {
                    this.A0F.A4K(xf).A06(2).A07(Float.valueOf(f)).A05();
                }
            } else {
                throw new RuntimeException();
            }
        }
    }

    public final void A0P(Surface surface) {
        A0E();
        A0H(surface, false);
    }

    public final void A0Q(FI fi) {
        ABj(fi, true, true);
    }

    public final void A0R(AbstractC0479Iv iv) {
        this.A0M.add(iv);
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final void A3H(AS as) {
        this.A0F.A3H(as);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0842Xd
    public final C0268Aa A4K(AZ az) {
        return this.A0F.A4K(az);
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final int A5W() {
        return this.A0F.A5W();
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final long A5X() {
        return this.A0F.A5X();
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final long A5o() {
        return this.A0F.A5o();
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final int A5q() {
        return this.A0F.A5q();
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final int A5r() {
        return this.A0F.A5r();
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final long A5t() {
        return this.A0F.A5t();
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final AbstractC0276Aj A5v() {
        return this.A0F.A5v();
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final int A5w() {
        return this.A0F.A5w();
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final long A64() {
        return this.A0F.A64();
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final boolean A6k() {
        return this.A0F.A6k();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0842Xd
    public final void ABj(FI fi, boolean z, boolean z2) {
        FI fi2 = this.A0B;
        if (fi2 != fi) {
            if (fi2 != null) {
                fi2.ACM(this.A0H);
                this.A0H.A08();
            }
            fi.A3F(this.A0E, this.A0H);
            this.A0B = fi;
        }
        this.A0F.ABj(fi, z, z2);
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final void ACD() {
        this.A0F.ACD();
        A0E();
        Surface surface = this.A03;
        if (surface != null) {
            if (this.A0D) {
                surface.release();
            }
            this.A03 = null;
        }
        FI fi = this.A0B;
        if (fi != null) {
            fi.ACM(this.A0H);
        }
        this.A0C = Collections.emptyList();
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final void ACl(long j) {
        this.A0H.A07();
        this.A0F.ACl(j);
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final void ACm() {
        this.A0H.A07();
        this.A0F.ACm();
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final void AD2(boolean z) {
        this.A0F.AD2(z);
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final void ADP(boolean z) {
        this.A0F.ADP(z);
        FI fi = this.A0B;
        if (fi != null) {
            fi.ACM(this.A0H);
            this.A0B = null;
            this.A0H.A08();
        }
        this.A0C = Collections.emptyList();
        String[] strArr = A0P;
        if (strArr[6].length() != strArr[0].length()) {
            String[] strArr2 = A0P;
            strArr2[5] = "8NqoZsSfBCZ1v43okD4Pix8d8oY1Moxp";
            strArr2[4] = "VfYOa1CKuZhM9jsFhHY6jw4UB0OoLmrV";
            return;
        }
        throw new RuntimeException();
    }
}
