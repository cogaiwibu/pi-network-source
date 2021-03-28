package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Kh  reason: case insensitive filesystem */
public final class C0515Kh {
    public static String[] A01;
    public static final ThreadLocal<C0515Kh> A02 = new ThreadLocal<>();
    public final KQ A00 = new KQ();

    public static void A03() {
        A01 = new String[]{"vWOWhJ9TqiA1ty478f", "MWb8A3Nd6tPLcAimCp0hVAmYX6QHiaZm", "Xd3YBUkiMhOleC4V056rVyOXhinwtSii", "tT8mJINbcEXXPPmKiWyTepfA0JHaFg93", "WoudJsrKOqRuVhNYSdRTZjqc00A0B3WY", "YTheXaZSxrm1KPF5Yd", "huHeChgRkwF7QVPgKoMeW6tLhEc13T9K", "ASVM8zHOtJrSOKsDwpZwweqDqvgS8KFW"};
    }

    static {
        A03();
    }

    public static KQ A00() {
        return A02().A00;
    }

    public static KQ A01(C0514Kg kg) {
        KQ kq = new KQ(A00());
        kq.add(kg);
        return kq;
    }

    public static C0515Kh A02() {
        C0515Kh kh = A02.get();
        String[] strArr = A01;
        if (strArr[6].charAt(1) != strArr[2].charAt(1)) {
            String[] strArr2 = A01;
            strArr2[7] = "JnfSkSuIf6osqUQGv4Nkh0Vi2QZsQFPV";
            strArr2[4] = "e9u3CRl6fKpCeCDR9nRPR0cml03xK1Bs";
            if (kh != null) {
                return kh;
            }
            C0515Kh kh2 = new C0515Kh();
            A02.set(kh2);
            return kh2;
        }
        throw new RuntimeException();
    }

    public static void A04(AbstractRunnableC0510Kc kc) {
        KQ createRunnableAsyncStackTrace = kc.A06();
        if (createRunnableAsyncStackTrace != null) {
            A02().A00.addAll(createRunnableAsyncStackTrace);
        }
    }

    public static void A05(AbstractRunnableC0510Kc kc) {
        KQ createRunnableAsyncStackTrace = kc.A06();
        if (createRunnableAsyncStackTrace != null) {
            A02().A00.removeAll(createRunnableAsyncStackTrace);
        }
    }
}
