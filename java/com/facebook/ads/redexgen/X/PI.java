package com.facebook.ads.redexgen.X;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

public class PI extends AnimatorListenerAdapter {
    public static String[] A01;
    public final /* synthetic */ C0416Gi A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"3J5cDVad4mW9vkElMc3OsUS7r8EZlE39", "h6bRkPy553bCAy1amrHUM8RqxgIOW2o8", "fpksqhdo9EiL3TJLaFmG7oCu1r9K", "lJjW0qitu5NILdXsS3BRz5RQsDn5loSa", "jrjPtqo2TtT08iP8QxuH9QitSJIqaNJp", "hUMcZshotDkSaD7wdQ9kJfmyHpwJvjMA", "tSCKCWomP5vbOsQQ1Yiozev7D3nD5ATQ", "aWL5kyBMd9kZhCXXBXyyL0Q3N4I1ZWNc"};
    }

    public PI(C0416Gi gi) {
        this.A00 = gi;
    }

    public final void onAnimationCancel(Animator animator) {
        if (C0416Gi.A07(this.A00)) {
            View A002 = C0416Gi.A00(this.A00);
            String[] strArr = A01;
            if (strArr[7].charAt(14) != strArr[3].charAt(14)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[1] = "5h3ewWtRejeXOmvUGpWApkn5USeyTQr7";
            strArr2[6] = "VmmYRwr0EoTUCeedPY4atWiJqM07FMep";
            C0535Le.A0K(A002);
        }
        C0416Gi.A00(this.A00).setAlpha(0.0f);
        C0416Gi.A03(this.A00, PD.A05);
        if (C0416Gi.A01(this.A00) != null) {
            C0416Gi.A01(this.A00).setListener(null);
            C0416Gi.A02(this.A00, null);
        }
    }

    public final void onAnimationEnd(Animator animator) {
        C0416Gi.A03(this.A00, PD.A03);
        if (C0416Gi.A01(this.A00) != null) {
            C0416Gi.A01(this.A00).setListener(null);
            C0416Gi.A02(this.A00, null);
        }
    }
}
