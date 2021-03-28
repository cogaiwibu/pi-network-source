package com.facebook.ads.redexgen.X;

import android.os.Build;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Ue  reason: case insensitive filesystem */
public class C0765Ue implements AbstractC01816i {
    public final /* synthetic */ C0785Uy A00;

    public C0765Ue(C0785Uy uy) {
        this.A00 = uy;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        if (Build.VERSION.SDK_INT < 21) {
            return this.A00.A08(EnumC01926t.A05);
        }
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr != null) {
            return this.A00.A0F(Arrays.asList(strArr));
        }
        return this.A00.A08(EnumC01926t.A07);
    }
}
