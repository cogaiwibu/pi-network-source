package com.facebook.ads.redexgen.X;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.facebook.proguard.annotations.DoNotStrip;
import com.ironsource.sdk.precache.DownloadManager;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.facebook.ads.redexgen.X.Wz  reason: case insensitive filesystem */
public final class C0838Wz extends NK {
    public static byte[] A0D;
    public static String[] A0E;
    public static final String A0F = C0838Wz.class.getSimpleName();
    public float A00;
    public LX A01 = new LX();
    @DoNotStrip
    public AbstractC0640Pg A02;
    @Nullable
    public C0641Ph A03;
    public boolean A04 = true;
    public final Path A05 = new Path();
    public final RectF A06 = new RectF();
    public final C0820Wh A07;
    public final WeakReference<NN> A08;
    public final AtomicBoolean A09 = new AtomicBoolean();
    public final AtomicBoolean A0A = new AtomicBoolean(true);
    public final AtomicInteger A0B = new AtomicInteger(DownloadManager.OPERATION_TIMEOUT);
    public final AtomicReference<String> A0C = new AtomicReference<>();

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0D, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A0E;
            if (strArr[7].length() != strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0E;
            strArr2[1] = "qkBM5EbEKD4bLDmS2";
            strArr2[1] = "qkBM5EbEKD4bLDmS2";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 94);
            i4++;
        }
    }

    public static void A05() {
        A0D = new byte[]{-23, 12, -21, 23, 22, 28, 26, 23, 20};
    }

    public static void A06() {
        A0E = new String[]{"8gq0YClbFfezV7VWazRrkmUo5IqHlAe0", "DZEC2fF8R1zbFaxtc", "FhN1N87P5UC3PnJCVDWnxEC", "JmSzPmcyjiRof3lizahs2qZ", "A3Evrr3LcR4BJzz79LIh", "2a6NLKfKqYFtWGCWoigE8lnPrM", "Nz12Z6hGfXPsqa2uThDzH9TN", "eI6gTMB0yvKckA2LC3VZ0zYV"};
    }

    static {
        A06();
        A05();
    }

    public C0838Wz(C0820Wh wh, WeakReference<NN> weakReference, int i) {
        super(wh);
        this.A07 = wh;
        this.A08 = weakReference;
        this.A02 = new XR(this);
        this.A03 = new C0641Ph(this, i, new WeakReference(this.A02), this.A07);
        setWebChromeClient(A0A());
        setWebViewClient(A0B());
        getSettings().setSupportZoom(false);
        getSettings().setCacheMode(1);
        if (Build.VERSION.SDK_INT > 16) {
            addJavascriptInterface(new NM(this, weakReference.get(), this.A03, this.A09, this.A0A, this.A07), A02(0, 9, 74));
        }
    }

    /* access modifiers changed from: private */
    public void A04() {
        this.A07.A0A().ADh();
        this.A09.set(true);
        new Handler(Looper.getMainLooper()).post(new X1(this.A03));
    }

    @VisibleForTesting
    private final boolean A08() {
        return this.A09.get();
    }

    @Override // com.facebook.ads.redexgen.X.NK
    public final WebChromeClient A0A() {
        return new NO();
    }

    @Override // com.facebook.ads.redexgen.X.NK
    public final WebViewClient A0B() {
        return new NP(this.A07, this.A08, new WeakReference(this.A03), new WeakReference(this.A01), new WeakReference(this.A0A), new WeakReference(this), this.A0B, this.A0C);
    }

    public final void A0C(int i, int i2) {
        C0641Ph ph = this.A03;
        if (ph != null) {
            ph.A0Y(i);
            this.A03.A0Z(i2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.NK
    public final void destroy() {
        C0641Ph ph = this.A03;
        if (ph != null) {
            ph.A0X();
            this.A03 = null;
        }
        C0535Le.A0M(this);
        this.A02 = null;
        this.A01 = null;
        NQ.A04(this);
        super.destroy();
    }

    public LX getTouchDataRecorder() {
        return this.A01;
    }

    public C0641Ph getViewabilityChecker() {
        return this.A03;
    }

    public final void onDraw(Canvas canvas) {
        if (this.A00 > 0.0f) {
            this.A06.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.A05.reset();
            Path path = this.A05;
            RectF rectF = this.A06;
            float f = this.A00;
            path.addRoundRect(rectF, f, f, Path.Direction.CW);
            canvas.clipPath(this.A05);
        }
        super.onDraw(canvas);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        this.A01.A07(motionEvent, this, this);
        return super.onTouchEvent(motionEvent);
    }

    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.A08.get() != null) {
            this.A08.get();
        }
        if (this.A03 != null) {
            this.A07.A0A().ADt(i);
            if (A0E[1].length() != 17) {
                throw new RuntimeException();
            }
            String[] strArr = A0E;
            strArr[7] = "DtJWCHxLbH6gtxJRxIB1oyEG";
            strArr[6] = "cIpyg99BbIZ2paT5Gicx86FT";
            if (i == 0 && A08()) {
                this.A03.A0W();
            } else if (i == 8) {
                this.A03.A0X();
            }
        }
    }

    public void setCheckAssetsByJavascriptBridge(boolean z) {
        this.A0A.set(z);
    }

    public void setCornerRadius(float f) {
        this.A00 = f;
        invalidate();
    }

    public void setLogMultipleImpressions(boolean z) {
        this.A04 = z;
    }

    public void setRequestId(String str) {
        this.A0C.set(str);
    }

    public void setWebViewTimeoutInMillis(int i) {
        if (i >= 0) {
            this.A0B.set(i);
        }
    }
}
