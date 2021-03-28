package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.facebook.ads.redexgen.X.8c  reason: invalid class name and case insensitive filesystem */
public final class C02198c {
    @VisibleForTesting
    public static SparseIntArray A00 = new SparseIntArray();
    @VisibleForTesting
    public static Executor A01 = Executors.newSingleThreadExecutor();
    public static boolean A02 = false;
    public static boolean A03 = false;
    public static byte[] A04;
    public static String[] A05;
    public static final List<Integer> A06 = Arrays.asList(10, 50, 100, 1000);
    public static final List<C02208d> A07 = Collections.synchronizedList(new ArrayList());
    public static final AtomicBoolean A08 = new AtomicBoolean();
    public static final AtomicInteger A09 = new AtomicInteger();
    public static final AtomicReference<AbstractC02178a> A0A = new AtomicReference<>();
    public static final AtomicReference<AbstractC02188b> A0B = new AtomicReference<>();
    public static final AtomicReference<Boolean> A0C = new AtomicReference<>();

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 39);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A04 = new byte[]{-93, -105, -40, -37, -37, -32, -21, -32, -26, -27, -40, -29, -64, -27, -35, -26, -105, -76, -105, -110, -122, -45, -53, -39, -39, -57, -51, -53, -122, -93, -122, 91, 79, -94, -92, -111, -93, -88, -97, -108, 114, -98, -109, -108, 79, 108, 79, 116, -66, -36, -23, -94, -17, -101, -25, -22, -30, -101, -65, -32, -35, -16, -30, -101, -64, -15, -32, -23, -17, -87, -101, -66, -22, -23, -17, -32, -13, -17, -101, -28, -18, -101, -23, -16, -25, -25, -87, 119, -93, -87, -94, -88, -103, -90, 110, 84, -79, -46, -49, -30, -44, -115, -48, -33, -50, -32, -43, -115, -49, -46, -48, -50, -30, -32, -46, -115, -36, -45, -115, -46, -29, -46, -37, -31, -115, -28, -42, -31, -43, -115, -32, -30, -49, -31, -26, -35, -46, -115, -86, -115, 108, -97, -118, -116, -116, -117, -116, -117, 71, -112, -107, 84, -108, -116, -108, -106, -103, -96, 71, -109, -106, -114, 71, -109, -112, -108, -112, -101, 72, 71, 115, -120, -102, -101, 71, -116, -99, -116, -107, -101, 97, 71, -108, -57, -78, -76, -65, -61, -72, -66, -67, 111, -109, -76, -79, -60, -74, 111, -108, -59, -76, -67, -61, 111, -58, -72, -61, -73, 111, -62, -60, -79, -61, -56, -65, -76, 111, -116, 111, -97, -46, -67, -65, -54, -50, -61, -55, -56, 122, -66, -49, -52, -61, -56, -63, 122, -58, -55, -63, -63, -61, -56, -63, 122, -66, -65, -68, -49, -63, 122, -65, -48, -65, -56, -50, -120, -27, 24, 3, 5, 16, 20, 9, 15, 14, -64, 19, 8, 15, 21, 12, 4, -64, 14, 15, 20, -64, 8, 1, 16, 16, 5, 14, -64, 8, 5, 18, 5, -50, -101, -105, -106, -54, -71, -66, -70, -61, -72, -70, -93, -70, -55, -52, -60, -57, -64, -28, 9, 1, 10, -69, -33, 0, -3, 16, 2, -69, -32, 17, 0, 9, 15, -69, 18, 4, 15, 3, -69, 14, 16, -3, 15, 20, 11, 0, -69, -40, -69, -53, -26, -26, -105, -28, -40, -27, -16, -105, -36, -19, -36, -27, -21, -22, -105, -26, -35, -105, -22, -20, -39, -21, -16, -25, -36, -105, -38, -26, -37, -36, -79, -105, -101, -99, -104, -99, -102, -83, -102, -104, -91, -88, -96, -96, -94, -89, -96, -21, -8, -3, -24, -19, -18, -3, -18, -20, -3, -14, -8, -9, -24, 0, -8, -24, -4, -14, -16, -9, -22, -11, -24, -19, -22, -3, -22, -24, -11, -8, -16, -16, -14, -9, -16, -62, -64, -62, -57, -60, -57, -56, -62, -49, -46, -54, -54, -52, -47, -54, -2, 13, 6, 6, -3, 4, -49, -42, -55, -59, -36, -57, -46, -49, -54, -57, -38, -49, -43, -44, -36, -45, -30, -27, -35, -32, -39};
    }

    public static void A05() {
        A05 = new String[]{"lfqbOpCQc8eNVWWSF0ti", "aQ5ZOD0I", "7f7up0GBGRCd1p0enpCjG4lcj76", "dHBYXWbpLBdqteinvxBO5bOixoP3oT04", "DPNUUQYEctncegz3shse9IBb8Vdl47", "4q0rwT09y0cbatV7Yp", "6l64E9SK9p5G", "edaEIeRSccYYgTnyelVwcwdzoe4C2sfO"};
    }

    static {
        A05();
        A04();
    }

    public static int A00(String str, int i, AnonymousClass8H r6) {
        if ((A01(457, 7, 71).equals(str) && C02248i.A1f == i) || A01(422, 5, 56).equals(str) || A01(437, 6, 113).equals(str)) {
            return 200;
        }
        if (A01(386, 36, 98).equals(str)) {
            return 50;
        }
        if (A01(371, 15, 18).equals(str)) {
            return J9.A05(r6);
        }
        if (A05[3].charAt(3) != 'Y') {
            throw new RuntimeException();
        }
        String[] strArr = A05;
        strArr[7] = "MSKlPe4okWTggpeViHGlBF3nlCraGBz9";
        strArr[7] = "MSKlPe4okWTggpeViHGlBF3nlCraGBz9";
        return -1;
    }

    public static /* synthetic */ List A02() {
        List<C02208d> list = A07;
        String[] strArr = A05;
        if (strArr[4].length() != strArr[0].length()) {
            String[] strArr2 = A05;
            strArr2[1] = "TV2BvPAOYvnRV0R5I88rwwfNZOOU8";
            strArr2[1] = "TV2BvPAOYvnRV0R5I88rwwfNZOOU8";
            return list;
        }
        throw new RuntimeException();
    }

    public static void A06(AnonymousClass8H r7, int i, int i2) {
        r7.A04().A82(A01(427, 10, 60), C02248i.A29, new C02258j(A01(338, 33, 80) + i, A01(87, 9, 13) + i2));
    }

    @Deprecated
    public static void A07(@Nullable AnonymousClass8H r6, String str, int i, C02258j r9) {
        if (r6 == null) {
            A0G(new RuntimeException(A01(48, 39, 84)));
            return;
        }
        AnonymousClass8G.A01(r6.A00());
        if (A02 && r9.A00() == 0) {
            A0E(new RuntimeException(A01(96, 44, 70) + str + A01(31, 16, 8) + i, r9));
        }
        try {
            if (A0I(r6, str, i, Math.random(), r9)) {
                A0A(r6, str, i, r9);
            }
        } catch (Throwable th) {
            A0G(th);
        }
    }

    @SuppressLint({"CatchGeneralException"})
    @Deprecated
    public static void A08(AnonymousClass8H r3, String str, int i, C02258j r6) {
        try {
            r6.A03(2);
            r6.A07(false);
            r6.A04(1);
            if (J9.A0R(r3)) {
                r6.A06(true);
            } else {
                r6.A06(false);
            }
            A07(r3, str, i, r6);
        } catch (Throwable th) {
            A0G(th);
        }
    }

    @Deprecated
    public static void A09(AnonymousClass8H r1, String str, int i, C02258j r4) {
        try {
            r4.A03(2);
            r4.A06(false);
            A07(r1, str, i, r4);
        } catch (Throwable th) {
            A0G(th);
        }
    }

    public static void A0A(AnonymousClass8H r10, String str, int i, C02258j r13) {
        synchronized (C02198c.class) {
            if (!A03) {
                int A012 = J9.A01(r10);
                if (A09.getAndIncrement() < A012 - 1) {
                    A07.add(new C02208d(str, i, r13));
                } else if (A09.get() == A012) {
                    List<C02208d> list = A07;
                    String A013 = A01(427, 10, 60);
                    int i2 = C02248i.A26;
                    list.add(new C02208d(A013, i2, new C02258j(A01(IronSourceConstants.USING_CACHE_FOR_INIT_EVENT, 42, 0) + str + A01(47, 1, 19) + i)));
                }
            } else {
                A0B(r10, str, i, r13, true);
            }
        }
    }

    public static void A0B(AnonymousClass8H r10, String str, int i, C02258j r13, boolean z) {
        boolean z2;
        AbstractC02188b r9 = A0B.get();
        if (r9 == null || !r9.A7k()) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (A08.get() || z2) {
            int A002 = r13.A00();
            String A012 = A01(289, 17, 46);
            String A013 = A01(31, 16, 8);
            if (A002 == 0) {
                Log.e(A012, A01(182, 37, 40) + str + A013 + i, r13);
            } else {
                Log.i(A012, A01(306, 32, 116) + str + A013 + i + A01(19, 12, 63) + r13.getMessage() + A01(0, 19, 80) + r13.A02());
            }
        }
        C0835Ww ww = new C0835Ww(r10, str, i, r13, r9);
        if (z) {
            A01.execute(ww);
        } else {
            ww.run();
        }
    }

    public static void A0D(C0821Wi wi, AbstractC02188b r4, AbstractC02178a r5, boolean z) {
        A0A.set(r5);
        A0B.set(r4);
        A08.set(z);
        synchronized (C02198c.class) {
            if (!A03) {
                A03 = true;
                A01.execute(new C0834Wv(wi));
            }
        }
    }

    public static void A0E(RuntimeException runtimeException) {
        if (A02) {
            new Handler(Looper.getMainLooper()).post(new AnonymousClass8Z(runtimeException));
        }
    }

    @Deprecated
    public static void A0F(Throwable th) {
        if (A02) {
            A0E(new RuntimeException(A01(256, 33, 121), th));
        }
    }

    public static void A0G(Throwable th) {
        Log.e(A01(289, 17, 46), A01(219, 37, 51), th);
        if (A02) {
            A0E(new RuntimeException(th));
        }
    }

    /* JADX INFO: Multiple debug info for r13v0 java.lang.String: [D('additionalDebugLoggingBlackList' java.util.Set<java.lang.String>), D('shouldLogFunnelEvents' java.lang.Boolean)] */
    @SuppressLint({"CatchGeneralException"})
    @VisibleForTesting
    public static boolean A0I(AnonymousClass8H r12, String str, int i, double d, C02258j r17) {
        double logProbability;
        int i2;
        try {
            int A042 = J9.A04(r12);
            if (A042 < 1) {
                return false;
            }
            HashMap<String, Integer> A0M = J9.A0M(r12);
            String str2 = str + A01(47, 1, 19) + i;
            boolean contains = A0M.keySet().contains(str2);
            if (contains) {
                Integer num = A0M.get(str2);
                int intValue = num != null ? num.intValue() : -1;
                if (intValue == 0) {
                    return false;
                }
                if (intValue <= 0) {
                    int A032 = J9.A03(r12);
                    if (A032 < 1) {
                        return false;
                    }
                    logProbability = ((double) (A042 * A032)) / 10000.0d;
                } else if (d <= 1.0d / ((double) intValue)) {
                    return true;
                } else {
                    return false;
                }
            } else if (!r17.A08()) {
                logProbability = 0.0d;
            } else {
                logProbability = ((double) A042) / 100.0d;
            }
            double A002 = r12.A05().A00();
            if (A01(422, 5, 56).equals(str)) {
                if (BuildConfigApi.isDebug()) {
                    return true;
                }
                int A062 = J9.A06(r12);
                if (A062 == 0) {
                    return false;
                }
                if (A062 > 0) {
                    double d2 = 1.0d / ((double) A062);
                    return contains ? A002 <= d2 * logProbability : A002 <= d2;
                }
            }
            if (A01(457, 7, 71).equals(str) && C02248i.A1f == i) {
                if (A08.get()) {
                    i2 = 1;
                } else {
                    i2 = J9.A0E(r12);
                }
                if (i2 == 0) {
                    return false;
                }
                if (i2 > 0) {
                    double d3 = 1.0d / ((double) i2);
                    return contains ? A002 <= d3 * logProbability : A002 <= d3;
                }
            }
            if (A01(437, 6, 113).equals(str)) {
                Boolean bool = A0C.get();
                if (bool != null) {
                    return bool.booleanValue();
                }
                int A0A2 = J9.A0A(r12);
                if (A0A2 == 0) {
                    A0C.set(false);
                    return false;
                } else if (A0A2 > 0) {
                    double d4 = 1.0d / ((double) A0A2);
                    return contains ? A002 <= d4 * logProbability : A002 <= d4;
                }
            }
            if (A01(443, 14, 63).equals(str)) {
                if (BuildConfigApi.isDebug()) {
                    return true;
                }
                int A0B2 = J9.A0B(r12);
                if (A0B2 == 0) {
                    return false;
                }
                if (A0B2 > 0) {
                    double d5 = 1.0d / ((double) A0B2);
                    return contains ? A002 <= d5 * logProbability : A002 <= d5;
                }
            }
            double d6 = 1.0d - logProbability;
            if (A05[3].charAt(3) != 'Y') {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[4] = "UKJjq974XMuOG6VE2UuXyW1KY5FJsZ";
            strArr[0] = "9oDF6i4FckldRw4UZ809";
            return d >= d6;
        } catch (Throwable th) {
            A0G(th);
            return false;
        }
    }

    @VisibleForTesting
    public static boolean A0J(AnonymousClass8H r6, String str, int eventsLimit, C02258j r9) {
        if (!J9.A0Q(r6)) {
            return true;
        }
        int i = A00.get(eventsLimit);
        int A002 = J9.A00(r6);
        if (r9.A01() != -1) {
            A002 = r9.A01();
        } else {
            int A003 = A00(str, eventsLimit, r6);
            if (A002 < A003) {
                A002 = A003;
            }
        }
        if (i >= A002) {
            if (A06.contains(Integer.valueOf(i))) {
                boolean A092 = r9.A09();
                if (A05[3].charAt(3) != 'Y') {
                    throw new RuntimeException();
                }
                String[] strArr = A05;
                strArr[5] = "DtDXz8TrFQQZw1pkgy";
                strArr[2] = "wKGFu6BM2pQR03pr0dyvmA98nTz";
                if (A092) {
                    A06(r6, eventsLimit, i);
                }
            }
            A00.put(eventsLimit, i + 1);
            return true;
        }
        A00.put(eventsLimit, i + 1);
        return false;
    }
}
