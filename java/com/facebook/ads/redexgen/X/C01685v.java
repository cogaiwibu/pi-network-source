package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* renamed from: com.facebook.ads.redexgen.X.5v  reason: invalid class name and case insensitive filesystem */
public final class C01685v {
    public static byte[] A00;
    public static String[] A01;
    public static final AtomicReference<AnonymousClass60> A02 = new AtomicReference<>();

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A01[4].charAt(15) != 'H') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[3] = "ewynTuX5etTUvRbKneAORAXWy6m3gfja";
            strArr[0] = "MEXbvG7De7lT0m7kyXT3Vo2bJU5t0LAQ";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 28);
            i4++;
        }
    }

    public static void A01() {
        A00 = new byte[]{60, 40, 57, 52, 56, 51, 62, 56, 2, 51, 56, 41, 42, 50, 47, 54, 115, 57, 56, 37, 45, 47, 36, 47, 56, 35, 41};
    }

    public static void A02() {
        A01 = new String[]{"r7c1s5U0efOStYGowMowhUbuYlQTG1Tt", "4N5luf2P5Kce0fziMzoENYJ9JUsEy4RG", "Zwxj", "L2KmiKnie6D54jPyz7fJn9CofNiJStjg", "Reipc3PbxUqE4G7HYurM4m8tamMVkuwI", "qFHCxa5Kyhox8u", "zslT757DGHQcDkpTRw1DlpZ4hqoBSQOy", "oFLB5GUqllb2V05SIM"};
    }

    static {
        A02();
        A01();
    }

    @SuppressLint({"CatchGeneralException"})
    public static void A03(@Nullable Activity activity, MotionEvent motionEvent) {
        AnonymousClass60 r0;
        try {
            if (C01695w.A0Q(activity) && (r0 = A02.get()) != null) {
                r0.A06(motionEvent);
            }
        } catch (Throwable th) {
            C0821Wi A002 = AnonymousClass8G.A00();
            if (A002 != null) {
                A002.A04().A82(A00(20, 7, 86), C02248i.A10, new C02258j(th));
            }
        }
    }

    public static void A04(Context context) {
        if (context instanceof Application) {
            C0525Ks.A05(new TT());
        }
    }

    public static void A05(C0821Wi wi, @Nullable String str) {
        ExecutorC0540Lj.A06.execute(new TQ(wi, str));
    }

    @SuppressLint({"CatchGeneralException"})
    public static void A06(C0821Wi wi, String str) {
        if (C01695w.A0Q(wi)) {
            if (A02.get() != null || !AnonymousClass76.A0F(AnonymousClass76.A03(str))) {
                AnonymousClass60 r2 = A02.get();
                if (r2 != null) {
                    ExecutorC0540Lj.A06.execute(new TR(r2, str, wi));
                    return;
                }
                return;
            }
            A05(wi, str);
        }
    }

    @SuppressLint({"CatchGeneralException"})
    public static synchronized void A08(C0821Wi wi, @Nullable String str) {
        synchronized (C01685v.class) {
            try {
                if (A02.get() == null) {
                    if (C01695w.A0Q(wi)) {
                        TV tv = new TV(wi);
                        TU tu = new TU(wi);
                        C01725z A0J = new C01715y().A0I(true).A04(C01695w.A05(wi)).A02(C01695w.A03(wi)).A03(C01695w.A04(wi)).A06(C01695w.A07(wi)).A0G(C01695w.A0M()).A0A(tv).A09(tu.A01()).A00(C01695w.A01(wi)).A0C(EnumC01856m.A0G).A0F(C01695w.A0D(wi)).A0H(C01695w.A0N(wi)).A05(C01695w.A06(wi)).A0D(Build.class).A01(C01695w.A02(wi)).A08(C01695w.A09(wi)).A07(C01695w.A08(wi)).A0B(tu).A0E(A00(0, 20, 65)).A0J();
                        if (C01695w.A0R(wi)) {
                            A04(wi.getApplicationContext());
                        }
                        AnonymousClass60 r1 = new AnonymousClass60(wi, A0J, C01695w.A0A(wi));
                        if (str != null) {
                            r1.A07(str);
                        }
                        A02.set(r1);
                    }
                    return;
                }
                return;
            } catch (Throwable th) {
                wi.A04().A82(A00(20, 7, 86), C02248i.A10, new C02258j(th));
            }
        }
    }
}
