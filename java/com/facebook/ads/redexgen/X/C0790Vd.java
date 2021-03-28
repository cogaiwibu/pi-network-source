package com.facebook.ads.redexgen.X;

import android.os.Build;

/* renamed from: com.facebook.ads.redexgen.X.Vd  reason: case insensitive filesystem */
public class C0790Vd implements AbstractC01816i {
    public final /* synthetic */ C0797Vk A00;

    public C0790Vd(C0797Vk vk) {
        this.A00 = vk;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        if (this.A00.A01 == null) {
            return this.A00.A08(EnumC01926t.A07);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            C0797Vk vk = this.A00;
            return vk.A07(vk.A01.getLongVersionCode());
        }
        C0797Vk vk2 = this.A00;
        return vk2.A05(vk2.A01.versionCode);
    }
}
