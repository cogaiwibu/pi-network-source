package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"ViewConstructor"})
public final class OY extends FrameLayout {
    public static byte[] A0C;
    public static String[] A0D;
    public static final float A0E = ((float) ((int) (C0535Le.A01 * 4.0f)));
    public static final RelativeLayout.LayoutParams A0F = new RelativeLayout.LayoutParams(-1, -1);
    public int A00 = 0;
    public long A01 = -1;
    public Map<String, String> A02;
    public final AnonymousClass16 A03;
    public final AnonymousClass1S A04;
    public final C0820Wh A05;
    public final JE A06;
    public final NN A07 = new AnonymousClass82(this);
    public final C0838Wz A08;
    public final OW A09;
    public final AtomicBoolean A0A = new AtomicBoolean(false);
    public final AtomicBoolean A0B = new AtomicBoolean(false);

    public static String A06(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0C, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            int i5 = copyOfRange[i4] ^ i3;
            if (A0D[5].length() != 25) {
                throw new RuntimeException();
            }
            String[] strArr = A0D;
            strArr[4] = "2xsSJQdmJTzWNKbVkLPVv70adF3crTtp";
            strArr[4] = "2xsSJQdmJTzWNKbVkLPVv70adF3crTtp";
            copyOfRange[i4] = (byte) (i5 ^ 37);
        }
        return new String(copyOfRange);
    }

    public static void A09() {
        A0C = new byte[]{11, 47, 29, 33, 44, 52, 44, 47, 33, 40, 12, 41, 52, 5, 22, 23, 13, 10, 3, 68, 1, 22, 22, 11, 22, 52, 8, 5, 29, 5, 6, 8, 1, 68, 0, 11, 39, 16, 5, 39, 8, 13, 7, 15, 68, 16, 22, 13, 3, 3, 1, 22, 1, 0, 68, 19, 13, 16, 12, 68, 20, 22, 1, 73, 1, 18, 1, 10, 16, 68, 7, 8, 13, 7, 15, 23, 68, 7, 11, 17, 10, 16, 68, 5, 10, 0, 68, 32, 1, 8, 5, 29, 106, 86, 91, 67, 91, 88, 86, 95, 123, 94, 73, 108, 83, 95, 77, 103, 104, 109, 103, 111, 119, 58, 59, 50, 63, 39, 100, 120, 117, 109, 117, 118, 120, 113, 89, 66, 70, 72, 67, 48, 34, 37, 24, 49, 46, 34, 48};
    }

    public static void A0A() {
        A0D = new String[]{"2LrpfYyae0azpeRldXrTpIs5j5WolZYJ", "aTWFoH17M5HvBaS06GyoTMgY8LK09kB1", "ZT9jJV1ne", "vwbwskwEgIVHj6V8wHV", "a8UIfMhCahgZVDol7QIaAFMNjSR7v8Rm", "pauq9xVSe1TSbn6Nh8iDWIypG", "tig0s2h3zWgeN1kA13N6tuAlrnUP1dby", "gu60Pcp0oAdbO9RcUpkXMIBgrMh0CW0V"};
    }

    static {
        A0A();
        A09();
    }

    public OY(C0820Wh wh, AnonymousClass16 r5, AnonymousClass1S r6, JE je, OW ow, Map<String, String> map) {
        super(wh);
        this.A05 = wh;
        this.A03 = r5;
        this.A04 = r6;
        this.A06 = je;
        this.A09 = ow;
        this.A02 = map;
        this.A08 = A04();
        addView(this.A08, A0F);
    }

    public static /* synthetic */ int A00(OY oy) {
        int i = oy.A00;
        oy.A00 = i + 1;
        return i;
    }

    @SuppressLint({"AddJavascriptInterface", "ClickableViewAccessibility"})
    private C0838Wz A04() {
        C0838Wz wz = new C0838Wz(this.A05, new WeakReference(this.A07), 10);
        wz.setCornerRadius(A0E);
        wz.setLogMultipleImpressions(false);
        wz.setCheckAssetsByJavascriptBridge(false);
        wz.setWebViewTimeoutInMillis(this.A04.A09());
        wz.setRequestId(this.A03.A0U());
        wz.setOnTouchListener(new OX(this, null));
        WebSettings settings = wz.getSettings();
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(true);
        }
        if (Build.VERSION.SDK_INT > 16) {
            wz.addJavascriptInterface(new OZ(this.A05, this, this.A06, this.A02, this.A03.A0Q()), A06(0, 12, 104));
        }
        return wz;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x00b4, code lost:
        if (r3 <= ((long) com.facebook.ads.redexgen.X.J8.A0F(r7))) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00f3, code lost:
        if (r3 <= ((long) com.facebook.ads.redexgen.X.J8.A0F(r7))) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00f6, code lost:
        r9.A05.A04().A82(r5, com.facebook.ads.redexgen.X.C02248i.A1s, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void A0B() {
        /*
        // Method dump skipped, instructions count: 270
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.OY.A0B():void");
    }

    public final void A0C() {
        String A0F2;
        try {
            C0838Wz wz = this.A08;
            if (!TextUtils.isEmpty(this.A04.A0C())) {
                A0F2 = this.A04.A0C();
            } else {
                A0F2 = this.A04.A0F();
            }
            wz.loadUrl(A0F2);
        } catch (Exception e) {
            this.A05.A04().A82(A06(131, 8, 98), C02248i.A2D, new C02258j(e));
        }
    }

    public final void A0D() {
        this.A08.removeJavascriptInterface(A06(0, 12, 104));
        this.A08.destroy();
    }

    public LX getTouchDataRecorder() {
        return this.A08.getTouchDataRecorder();
    }

    @Nullable
    public C0641Ph getViewabilityChecker() {
        return this.A08.getViewabilityChecker();
    }
}
