package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.util.Log;
import androidx.annotation.Nullable;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.redexgen.X.95  reason: invalid class name */
public final class AnonymousClass95 {
    public static boolean A00;
    public static boolean A01;
    public static byte[] A02;
    public static String[] A03;
    public static final AtomicBoolean A04 = new AtomicBoolean();
    public static final AtomicBoolean A05 = new AtomicBoolean();
    public static final AtomicBoolean A06 = new AtomicBoolean();

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A03[1].charAt(3) != 'A') {
                String[] strArr = A03;
                strArr[4] = "IDfTBPjSyvL4biEe7dLkbKSavqcQmadb";
                strArr[2] = "Oy3yacq1X2KDRnpIDSUXWs28RTZJmhMt";
                if (i4 >= length) {
                    return new String(copyOfRange);
                }
                copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 60);
                i4++;
            } else {
                throw new RuntimeException();
            }
        }
    }

    public static void A04() {
        A02 = new byte[]{-60, -10, -10, -7, -58, -12, -54, -7, -66, -70, -71, -19, -36, -31, -35, -26, -37, -35, -58, -35, -20, -17, -25, -22, -29, -62, -77, -70, -113, -40, -35, -40, -29, -40, -48, -37, -40, -23, -48, -29, -40, -34, -35, -113, -30, -29, -48, -31, -29, -44, -45, -60, -43, -36, -111, -24, -46, -28, -111, -46, -35, -29, -42, -46, -43, -22, -111, -38, -33, -38, -27, -38, -46, -35, -38, -21, -42, -43, -110, -111, -60, -36, -38, -31, -31, -38, -33, -40, -97, -62, -40, -34, -119, -51, -40, -41, -112, -35, -119, -52, -54, -43, -43, -119, -86, -34, -51, -46, -50, -41, -52, -50, -73, -50, -35, -32, -40, -37, -44, -86, -51, -36, -105, -46, -41, -46, -35, -46, -54, -43, -46, -29, -50, -111, -110, -105, -119, -68, -40, -42, -50, -119, -49, -34, -41, -52, -35, -46, -40, -41, -54, -43, -46, -35, -30, -119, -42, -54, -30, -119, -41, -40, -35, -119, -32, -40, -37, -44, -119, -39, -37, -40, -39, -50, -37, -43, -30, -105, -66, -51, -58, -31, -33, -24, -33, -20, -29, -35, -9, -4, -9, 2, -9, -17, -6, -9, 8, -13, 5, 10, 5, 16, 5, -3, 8, 5, 22, 1, -60, -59, -68, 10, 11, 16, -68, -1, -3, 8, 8, 1, 0, -54};
    }

    public static void A05() {
        A03 = new String[]{"qrNp1wG", "4f9SKAEMWw8LBpPH9ClfYFaSVVluVAOE", "62aVnpwn360RV3u8SEcmxFYidJmBvefX", "Gce9ySP9MgoEln4cNVrEo5sJO8CSkBrv", "GAv6eBsy68sSiadtgyjEU9blJSusD372", "OMedkGV5dbFzDsS0dZcen", "wlEAAxVLaYYUt0VSnPi", "2B4l1t7rFez9Iyb0KdS6JKEUq9HBo8Fu"};
    }

    static {
        A05();
        A04();
    }

    public static KS A00() {
        return new X5();
    }

    public static AbstractC0516Ki A01(C0821Wi wi) {
        return new X6(wi);
    }

    public static void A06(AudienceNetworkAds.InitListener initListener, AudienceNetworkAds.InitResult initResult) {
        LZ.A01.execute(new X4(initListener, initResult));
    }

    /* JADX INFO: Multiple debug info for r5v0 com.facebook.ads.redexgen.X.Wi: [D('e' java.lang.Exception), D('defaultUncaughtExceptionHandler' java.lang.Thread$UncaughtExceptionHandler)] */
    @SuppressLint({"CatchGeneralException"})
    public static void A08(C0821Wi wi) {
        if (J9.A0Q(wi) && !A05.getAndSet(true)) {
            try {
                Thread.setDefaultUncaughtExceptionHandler(new AnonymousClass8Y(Thread.getDefaultUncaughtExceptionHandler(), wi, new X8()));
            } catch (Exception e) {
                wi.A04().A82(A02(181, 7, 62), C02248i.A1F, new C02258j(e));
            }
        }
    }

    public static void A09(C0821Wi wi) {
        A0H(wi, null, null, 3);
    }

    public static void A0A(C0821Wi wi) {
        A0H(wi, null, null, 3);
    }

    public static void A0B(C0821Wi wi) {
        if (J8.A1G(wi)) {
            A0G(wi, 0);
        }
        if (J8.A1J(wi)) {
            A0D(wi);
        }
    }

    public static void A0C(C0821Wi wi) {
        if (J8.A1H(wi)) {
            A0I(wi, null, null, 3);
        }
    }

    public static void A0D(C0821Wi wi) {
        ExecutorC0540Lj.A06.execute(new X3(wi));
    }

    public static void A0E(C0821Wi wi) {
        C02198c.A0D(wi, new X9(wi), new XA(), BuildConfigApi.isDebug());
        C0988bE.A01(wi);
        C01685v.A05(wi, null);
    }

    public static void A0G(C0821Wi wi, int i) {
        AnonymousClass8G.A01(wi);
        if (!A04.getAndSet(true)) {
            if (AdInternalSettings.isDebugBuild() || AdInternalSettings.isDebuggerOn()) {
                K0.A02();
            }
            A08(wi);
            C0513Kf.A00(J8.A0i(wi), BuildConfigApi.isDebug(), A00(), A01(wi));
            C01615o.A04((long) J8.A02(wi));
            Q4.A0A(new X7(wi));
            if (i == 3) {
                Log.e(A02(8, 17, 60), A02(89, 89, 45));
                wi.A04().A8G(A02(178, 3, 33), C02248i.A0G, new C02258j(A02(198, 24, 96)));
            }
            C0525Ks.A04(wi);
            ExecutorC0540Lj.A06(wi);
            JO.A03(wi);
            C00410u.A0D(wi);
            if (J8.A0o(wi)) {
                C01324k.A00(wi);
            }
        }
    }

    public static void A0H(C0821Wi wi, @Nullable MultithreadedBundleWrapper multithreadedBundleWrapper, @Nullable AudienceNetworkAds.InitListener initListener, int i) {
        K0.A05(A02(188, 10, 82), A02(25, 26, 51), A02(0, 8, 87));
        Q4.A06();
        A0I(wi, multithreadedBundleWrapper, initListener, i);
    }

    @SuppressLint({"CatchGeneralException"})
    public static void A0I(C0821Wi wi, @Nullable MultithreadedBundleWrapper multithreadedBundleWrapper, @Nullable AudienceNetworkAds.InitListener initListener, int i) {
        AnonymousClass8G.A01(wi);
        boolean z = false;
        synchronized (AnonymousClass95.class) {
            if (!A00) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3 && !A01) {
                            A01 = true;
                            z = true;
                        }
                    }
                }
                A00 = true;
                z = true;
            }
        }
        if (z) {
            A0G(wi, i);
            ExecutorC0540Lj.A08.execute(new X2(wi, multithreadedBundleWrapper, initListener));
        } else if (i == 1) {
            String A022 = A02(51, 38, 53);
            if (initListener != null) {
                A06(initListener, new AnonymousClass94(true, A022));
            } else {
                Log.w(A02(8, 17, 60), A022);
            }
        }
    }

    public static synchronized boolean A0J() {
        boolean z;
        synchronized (AnonymousClass95.class) {
            z = A00;
        }
        return z;
    }
}
