package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.JavascriptInterface;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

public class NM {
    public static String[] A07;
    public final String A00 = NM.class.getSimpleName();
    public final WeakReference<AtomicBoolean> A01;
    public final WeakReference<AtomicBoolean> A02;
    public final WeakReference<AnonymousClass0S> A03;
    public final WeakReference<NN> A04;
    public final WeakReference<C0641Ph> A05;
    public final WeakReference<C0838Wz> A06;

    static {
        A01();
    }

    public static void A01() {
        A07 = new String[]{"FOFLIt4izaDLaQDOMIXk8qYNT283z5pM", "oiToeohcscvINDKXEsytRf9HFldaqPXB", "4ipPd9h88IiL3d99rWL92oIsRR1k6HBA", "hPx", "0GhefH5NzI2ypbPnqUG75Cq8VmhNX1", "2b6", "snO0JYp8WiAdMwbOevXppfTs6iFhTSIS", "awSLBYFe7Md8cHgboMT9P3Pgh1wlsZGE"};
    }

    public NM(C0838Wz wz, NN nn, C0641Ph ph, AtomicBoolean atomicBoolean, AtomicBoolean atomicBoolean2, C0820Wh wh) {
        this.A06 = new WeakReference<>(wz);
        this.A04 = new WeakReference<>(nn);
        this.A05 = new WeakReference<>(ph);
        this.A01 = new WeakReference<>(atomicBoolean);
        this.A02 = new WeakReference<>(atomicBoolean2);
        this.A03 = new WeakReference<>(wh.A0A());
    }

    private AnonymousClass0S A00() {
        AnonymousClass0S r0 = this.A03.get();
        if (r0 == null) {
            return new R4();
        }
        return r0;
    }

    @JavascriptInterface
    public void alert(String str) {
        Log.e(this.A00, str);
    }

    @JavascriptInterface
    public String getAnalogInfo() {
        return LD.A01(C02338r.A02());
    }

    @JavascriptInterface
    public void onMainAssetLoaded() {
        A00().ADi();
        if (this.A06.get() != null && this.A01.get() != null && this.A02.get() != null) {
            boolean z = this.A02.get().get();
            String[] strArr = A07;
            if (strArr[4].length() != strArr[5].length()) {
                String[] strArr2 = A07;
                strArr2[1] = "xXjDpbk5Vvc7CvrBd08NYXaJ46SIZN7q";
                strArr2[1] = "xXjDpbk5Vvc7CvrBd08NYXaJ46SIZN7q";
                if (z) {
                    this.A01.get().set(true);
                    A00().ADj();
                    if (this.A06.get().isShown()) {
                        A00().ADk();
                        new Handler(Looper.getMainLooper()).post(new X1(this.A05));
                    }
                    NN nn = this.A04.get();
                    if (nn != null) {
                        new Handler(Looper.getMainLooper()).post(new NL(this, nn));
                        return;
                    }
                    return;
                }
                return;
            }
            throw new RuntimeException();
        }
    }

    @JavascriptInterface
    public void onPageInitialized() {
        C0838Wz wz = this.A06.get();
        if (wz == null || wz.A03()) {
            A00().ADl(true);
            return;
        }
        NN nn = this.A04.get();
        if (nn != null) {
            A00().ADl(false);
            nn.AAM();
            return;
        }
        A00().ADl(true);
    }
}
