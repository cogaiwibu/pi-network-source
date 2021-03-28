package com.tapjoy.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import javax.annotation.Nullable;

/* access modifiers changed from: package-private */
public abstract class ho implements gl {
    private static final String[] a;

    ho() {
    }

    static {
        String[] strArr = {"reward", FirebaseAnalytics.Event.PURCHASE, "custom_action"};
        a = strArr;
        Arrays.sort(strArr);
    }

    @Override // com.tapjoy.internal.gl
    public final void a(gm gmVar) {
        if (this instanceof gp) {
            gp gpVar = (gp) this;
            gmVar.a(gpVar.a(), gpVar.b());
        } else if (this instanceof gq) {
            gq gqVar = (gq) this;
            gmVar.a(gqVar.a(), gqVar.b(), gqVar.c(), gqVar.d());
        }
    }

    public static boolean a(String str) {
        return Arrays.binarySearch(a, str) >= 0;
    }

    @Nullable
    public static ho a(String str, bn bnVar) {
        if ("reward".equals(str)) {
            return (ho) bnVar.a(hy.a);
        }
        if (FirebaseAnalytics.Event.PURCHASE.equals(str)) {
            return (ho) bnVar.a(hw.a);
        }
        return null;
    }
}
