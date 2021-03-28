package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.4W  reason: invalid class name */
public class AnonymousClass4W implements Runnable {
    public static byte[] A07;
    public static String[] A08;
    public Interpolator A00 = ES.A1A;
    public OverScroller A01;
    public int A02;
    public int A03;
    public boolean A04 = false;
    public boolean A05 = false;
    public final /* synthetic */ ES A06;

    static {
        A04();
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 32);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A07 = new byte[]{-46, -42, -96, -45, -29, -14, -17, -20, -20};
    }

    public static void A04() {
        A08 = new String[]{"c4xSVVt4fNiIZ9aJ0ftrOCVpKy2EJW", "bj77oS7wYHzhrY124YppwtIfPTuDoAHL", "mRmZUQV2DMpprRsDQaH8Mtbq5JuQtR14", "UXM5", "qfxFRQLCBxpF20va4RNO9ygLlTXV5cTV", "Bw29gSSAA0erG37CQVEqOkFPeCj6ZZr8", "KVIri1u0fbW7r5jnncTGzAnirlJcKx", "TA0EOfT3Z02jNldii3VIEnkki3"};
    }

    public AnonymousClass4W(ES es) {
        this.A06 = es;
        this.A01 = new OverScroller(es.getContext(), ES.A1A);
    }

    private float A00(float f) {
        return (float) Math.sin((double) ((f - 0.5f) * 0.47123894f));
    }

    private int A01(int absDx, int absDy, int i, int i2) {
        boolean z;
        int height;
        int i3;
        int containerSize = Math.abs(absDx);
        int halfContainerSize = Math.abs(absDy);
        if (containerSize > halfContainerSize) {
            z = true;
        } else {
            z = false;
        }
        int sqrt = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
        int sqrt2 = (int) Math.sqrt((double) ((absDx * absDx) + (absDy * absDy)));
        ES es = this.A06;
        if (z) {
            height = es.getWidth();
        } else {
            height = es.getHeight();
        }
        int delta = height / 2;
        float A002 = ((float) delta) + (((float) delta) * A00(Math.min(1.0f, (((float) sqrt2) * 1.0f) / ((float) height))));
        if (sqrt > 0) {
            i3 = Math.round(Math.abs(A002 / ((float) sqrt)) * 1000.0f) * 4;
        } else {
            if (!z) {
                containerSize = halfContainerSize;
            }
            i3 = (int) (((((float) containerSize) / ((float) height)) + 1.0f) * 300.0f);
        }
        return Math.min(i3, 2000);
    }

    private final void A05() {
        this.A05 = false;
        this.A04 = true;
    }

    private final void A06() {
        this.A04 = false;
        if (this.A05) {
            A08();
        }
    }

    private final void A07(int i, int i2, int i3, int i4) {
        A0C(i, i2, A01(i, i2, i3, i4));
    }

    public final void A08() {
        if (this.A04) {
            this.A05 = true;
            return;
        }
        this.A06.removeCallbacks(this);
        if (A08[4].charAt(10) != 'o') {
            String[] strArr = A08;
            strArr[2] = "DBTzn4opHB64KJUt1kyQdTPFEm6jko5S";
            strArr[2] = "DBTzn4opHB64KJUt1kyQdTPFEm6jko5S";
            AnonymousClass2u.A0C(this.A06, this);
            return;
        }
        throw new RuntimeException();
    }

    public final void A09() {
        this.A06.removeCallbacks(this);
        this.A01.abortAnimation();
    }

    public final void A0A(int i, int i2) {
        this.A06.setScrollState(2);
        this.A03 = 0;
        this.A02 = 0;
        this.A01.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        A08();
    }

    public final void A0B(int i, int i2) {
        A07(i, i2, 0, 0);
    }

    public final void A0C(int i, int i2, int i3) {
        A0D(i, i2, i3, ES.A1A);
    }

    public final void A0D(int i, int i2, int i3, Interpolator interpolator) {
        if (this.A00 != interpolator) {
            this.A00 = interpolator;
            this.A01 = new OverScroller(this.A06.getContext(), interpolator);
        }
        this.A06.setScrollState(2);
        this.A03 = 0;
        this.A02 = 0;
        this.A01.startScroll(0, 0, i, i2, i3);
        if (Build.VERSION.SDK_INT < 23) {
            OverScroller overScroller = this.A01;
            if (A08[7].length() != 26) {
                throw new RuntimeException();
            }
            String[] strArr = A08;
            strArr[2] = "UeYo97OquvC2FnZv3LivDSVIricXCoYT";
            strArr[2] = "UeYo97OquvC2FnZv3LivDSVIricXCoYT";
            overScroller.computeScrollOffset();
        }
        A08();
    }

    public final void A0E(int i, int i2, Interpolator interpolator) {
        int A012 = A01(i, i2, 0, 0);
        if (interpolator == null) {
            interpolator = ES.A1A;
        }
        A0D(i, i2, A012, interpolator);
    }

    /* JADX INFO: Multiple debug info for r1v5 'dx'  int: [D('velY' int), D('overscrollY' int)] */
    /* JADX INFO: Multiple debug info for r0v20 'overscrollX'  int: [D('vel' int), D('overscrollX' int)] */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x02a6, code lost:
        if (r15 != 2) goto L_0x0192;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x02e8, code lost:
        if (r9 != null) goto L_0x00ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00ec, code lost:
        if (r9 != null) goto L_0x00ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0190, code lost:
        if (r15 != 2) goto L_0x0192;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        // Method dump skipped, instructions count: 766
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass4W.run():void");
    }
}
