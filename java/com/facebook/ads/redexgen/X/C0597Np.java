package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.HashMap;

/* renamed from: com.facebook.ads.redexgen.X.Np  reason: case insensitive filesystem */
public final class C0597Np {
    public static String[] A00;

    static {
        A01();
    }

    public static void A01() {
        A00 = new String[]{"zHQaRI8Z04iZfuq60cOZ3MtOUQtnyLXk", "Py81lTfXTPvOohagzwztlFMwKgIeaa04", "ZBx", "ff4Sljy7OS0rEQC0yVPpTgSrr8dBXGgO", "WJ7E7dTZMlxiqC9ofw7stZL7dYzOgEyn", "lEp0yqe8iFuZgqtiF5MEL7dQIxoaDf7o", "1LQBU", "K3MGC9Pem9CSlPJADsZARPOkTW1wXgVW"};
    }

    /* JADX INFO: Multiple debug info for r11v0 com.facebook.ads.redexgen.X.Ns: [D('adInfo' com.facebook.ads.redexgen.X.19), D('layout' com.facebook.ads.redexgen.X.No), D('isInLandscape' boolean)] */
    public static AbstractC0596No A00(C0600Ns ns, @Nullable Bundle bundle, boolean z) {
        AbstractC0596No su;
        boolean z2;
        AnonymousClass19 A0M = ns.A04().A0M();
        double A002 = (double) C0595Nn.A00(A0M);
        boolean renderFullscreen = ns.A04().A0M().A0M();
        boolean A05 = C0595Nn.A05(ns.A00(), ns.A01(), A002);
        AbstractC00260f A003 = C00270g.A00(ns.A05(), ns.A06(), "", Uri.parse(ns.A04().A0M().A0G().A04()), new HashMap());
        if (renderFullscreen && (A003 instanceof F1)) {
            su = new C0672Qm(ns);
        } else if (!TextUtils.isEmpty(A0M.A0E().A08())) {
            su = new C02429a(ns);
        } else if (TextUtils.isEmpty(A0M.A0E().A08()) && J8.A1T(ns.A05())) {
            su = new C02499h(ns, A05);
        } else if (A05) {
            if (ns.A00() == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            su = new SV(ns, z2);
        } else {
            su = new SU(ns, C0595Nn.A03(A002));
        }
        if (z) {
            String A0Q = ns.A04().A0Q();
            if (A00[2].length() != 3) {
                throw new RuntimeException();
            }
            String[] strArr = A00;
            strArr[5] = "IYiemLW0pAZJelR9U10I0UE8BphOsSCr";
            strArr[3] = "HZnaFTaa8UnZev8t8IWfBJ4wHjAxjheL";
            su.A0b(A0M, A0Q, A002, bundle);
        }
        return su;
    }
}
