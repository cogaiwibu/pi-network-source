package com.facebook.ads.redexgen.X;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.metadata.Metadata;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.Xg  reason: case insensitive filesystem */
public final class SurfaceHolder$CallbackC0845Xg implements J4, BB, GJ, E1, SurfaceHolder.Callback, TextureView.SurfaceTextureListener {
    public static String[] A01;
    public final /* synthetic */ CI A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"tENgV7sVRmCggStQb7ahqyncu3McMlqx", "EBCLDe86SI67l2WgLGk", "Xc2z6PWfFp", "ZjGJvfPpi7mMWyj8ThC73X2hXIQsvVeY", "O", "wm4K2NOZzdg8zteNHm", "uxR1U8t68FFaIgGW", "ZP1sAESULwb937k6ya35I8qp57tsUFN9"};
    }

    public SurfaceHolder$CallbackC0845Xg(CI ci) {
        this.A00 = ci;
    }

    @Override // com.facebook.ads.redexgen.X.BB
    public final void A8u(String str, long j, long j2) {
        Iterator it = this.A00.A0I.iterator();
        while (it.hasNext()) {
            ((BB) it.next()).A8u(str, j, j2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.BB
    public final void A8v(C0297Be be) {
        Iterator it = this.A00.A0I.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            String[] strArr = A01;
            if (strArr[0].charAt(30) != strArr[7].charAt(30)) {
                String[] strArr2 = A01;
                strArr2[4] = "r";
                strArr2[1] = "Pw7sEp82k0vieihjeRw";
                if (hasNext) {
                    BB bb = (BB) it.next();
                    if (A01[3].charAt(20) != '3') {
                        throw new RuntimeException();
                    }
                    String[] strArr3 = A01;
                    strArr3[5] = "rZ";
                    strArr3[5] = "rZ";
                    bb.A8v(be);
                } else {
                    CI ci = this.A00;
                    String[] strArr4 = A01;
                    if (strArr4[0].charAt(30) != strArr4[7].charAt(30)) {
                        String[] strArr5 = A01;
                        strArr5[5] = "AJXnTxM8Cjr";
                        strArr5[5] = "AJXnTxM8Cjr";
                        ci.A06 = null;
                        this.A00.A09 = null;
                        this.A00.A01 = 0;
                        return;
                    }
                    throw new RuntimeException();
                }
            } else {
                throw new RuntimeException();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.BB
    public final void A8w(C0297Be be) {
        this.A00.A09 = be;
        Iterator it = this.A00.A0I.iterator();
        while (it.hasNext()) {
            ((BB) it.next()).A8w(be);
        }
    }

    @Override // com.facebook.ads.redexgen.X.BB
    public final void A8x(Format format) {
        this.A00.A06 = format;
        Iterator it = this.A00.A0I.iterator();
        while (it.hasNext()) {
            ((BB) it.next()).A8x(format);
        }
    }

    @Override // com.facebook.ads.redexgen.X.BB
    public final void A8y(int i) {
        this.A00.A01 = i;
        Iterator it = this.A00.A0I.iterator();
        while (it.hasNext()) {
            BB bb = (BB) it.next();
            if (A01[2].length() != 11) {
                String[] strArr = A01;
                strArr[2] = "0C";
                strArr[2] = "0C";
                bb.A8y(i);
            } else {
                throw new RuntimeException();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.BB
    public final void A8z(int i, long j, long j2) {
        Iterator it = this.A00.A0I.iterator();
        while (it.hasNext()) {
            ((BB) it.next()).A8z(i, j, j2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.GJ
    public final void A9I(List<GF> list) {
        this.A00.A0C = list;
        Iterator it = this.A00.A0K.iterator();
        while (it.hasNext()) {
            ((GJ) it.next()).A9I(list);
        }
    }

    @Override // com.facebook.ads.redexgen.X.J4
    public final void A9T(int i, long j) {
        Iterator it = this.A00.A0L.iterator();
        while (it.hasNext()) {
            ((J4) it.next()).A9T(i, j);
        }
    }

    @Override // com.facebook.ads.redexgen.X.E1
    public final void AAE(Metadata metadata) {
        Iterator it = this.A00.A0J.iterator();
        while (it.hasNext()) {
            ((E1) it.next()).AAE(metadata);
        }
    }

    @Override // com.facebook.ads.redexgen.X.J4
    public final void AAk(Surface surface) {
        if (this.A00.A03 == surface) {
            Iterator it = this.A00.A0M.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        Iterator it2 = this.A00.A0L.iterator();
        while (it2.hasNext()) {
            ((J4) it2.next()).AAk(surface);
        }
    }

    @Override // com.facebook.ads.redexgen.X.J4
    public final void ABF(String str, long j, long j2) {
        Iterator it = this.A00.A0L.iterator();
        while (it.hasNext()) {
            ((J4) it.next()).ABF(str, j, j2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.J4
    public final void ABG(C0297Be be) {
        Iterator it = this.A00.A0L.iterator();
        while (it.hasNext()) {
            ((J4) it.next()).ABG(be);
        }
        this.A00.A07 = null;
        this.A00.A0A = null;
    }

    @Override // com.facebook.ads.redexgen.X.J4
    public final void ABH(C0297Be be) {
        this.A00.A0A = be;
        Iterator it = this.A00.A0L.iterator();
        while (it.hasNext()) {
            J4 j4 = (J4) it.next();
            if (A01[3].charAt(20) != '3') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[5] = "6iGRC7";
            strArr[5] = "6iGRC7";
            j4.ABH(be);
        }
    }

    @Override // com.facebook.ads.redexgen.X.J4
    public final void ABJ(Format format) {
        this.A00.A07 = format;
        Iterator it = this.A00.A0L.iterator();
        while (it.hasNext()) {
            J4 j4 = (J4) it.next();
            String[] strArr = A01;
            if (strArr[0].charAt(30) != strArr[7].charAt(30)) {
                String[] strArr2 = A01;
                strArr2[5] = "M1lNqMtLlEQhDRLPZV8vitTN6y5pnm";
                strArr2[5] = "M1lNqMtLlEQhDRLPZV8vitTN6y5pnm";
                j4.ABJ(format);
            } else {
                throw new RuntimeException();
            }
        }
    }

    /* JADX INFO: Multiple debug info for r3v0 int: [D('videoDebugListener' com.facebook.ads.redexgen.X.J4), D('videoListener' com.facebook.ads.redexgen.X.Iv)] */
    @Override // com.facebook.ads.redexgen.X.J4
    public final void ABM(int i, int i2, int i3, float f) {
        Iterator it = this.A00.A0M.iterator();
        while (it.hasNext()) {
            ((AbstractC0479Iv) it.next()).ABM(i, i2, i3, f);
        }
        Iterator it2 = this.A00.A0L.iterator();
        while (it2.hasNext()) {
            ((J4) it2.next()).ABM(i, i2, i3, f);
        }
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.A00.A0H(new Surface(surfaceTexture), true);
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.A00.A0H(null, true);
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.A00.A0H(surfaceHolder.getSurface(), false);
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.A00.A0H(null, false);
    }
}
