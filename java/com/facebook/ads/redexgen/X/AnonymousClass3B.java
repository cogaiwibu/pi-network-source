package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.view.WindowInsets;

/* renamed from: com.facebook.ads.redexgen.X.3B  reason: invalid class name */
public final class AnonymousClass3B {
    public static String[] A01;
    public final Object A00;

    static {
        A02();
    }

    public static void A02() {
        A01 = new String[]{"el7YtyQobuGYp8qUnEWwGAo9eb5IMR8f", "BjlmtcQqBka41jhChDLZKaESgBphWA9m", "aKAY7r1GVGPP18xn5ioe", "SajdHZC8", "nRs3vifuwuv", "vQYmc1GWKj3CI1v3wMvKFH0VmcpB3A8S", "tuFyi1rHy9z46G0g3HP9J8Pe4WgIo7s9", "jDUjvWDGqsgivCcWfJbzlnhujFfNRoy6"};
    }

    public AnonymousClass3B(Object obj) {
        this.A00 = obj;
    }

    public static AnonymousClass3B A00(Object obj) {
        if (obj == null) {
            return null;
        }
        return new AnonymousClass3B(obj);
    }

    public static Object A01(AnonymousClass3B r0) {
        if (r0 == null) {
            return null;
        }
        return r0.A00;
    }

    public final int A03() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.A00).getSystemWindowInsetBottom();
        }
        return 0;
    }

    public final int A04() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.A00).getSystemWindowInsetLeft();
        }
        return 0;
    }

    public final int A05() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.A00).getSystemWindowInsetRight();
        }
        return 0;
    }

    public final int A06() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.A00).getSystemWindowInsetTop();
        }
        return 0;
    }

    public final AnonymousClass3B A07(int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 20) {
            return new AnonymousClass3B(((WindowInsets) this.A00).replaceSystemWindowInsets(i, i2, i3, i4));
        }
        return null;
    }

    public final boolean A08() {
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        Object obj = this.A00;
        if (A01[7].charAt(25) != 'F') {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[7] = "MrGsAgnRdViYEdRwgZNSAOYKXFurzaLs";
        strArr[7] = "MrGsAgnRdViYEdRwgZNSAOYKXFurzaLs";
        return ((WindowInsets) obj).isConsumed();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AnonymousClass3B r5 = (AnonymousClass3B) obj;
        Object obj2 = this.A00;
        if (obj2 != null) {
            return obj2.equals(r5.A00);
        }
        if (r5.A00 == null) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.A00;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }
}
