package com.facebook.ads.redexgen.X;

import android.os.Build;

/* renamed from: com.facebook.ads.redexgen.X.Va  reason: case insensitive filesystem */
public class C0787Va implements AbstractC01816i {
    public final /* synthetic */ C0797Vk A00;

    public C0787Va(C0797Vk vk) {
        this.A00 = vk;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        if (Build.VERSION.SDK_INT < 26) {
            return this.A00.A08(EnumC01926t.A05);
        }
        if (this.A00.A02 == null) {
            return this.A00.A08(EnumC01926t.A07);
        }
        C0797Vk vk = this.A00;
        return vk.A0G(vk.A02.canRequestPackageInstalls());
    }
}
