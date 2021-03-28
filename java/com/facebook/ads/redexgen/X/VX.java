package com.facebook.ads.redexgen.X;

public class VX implements AbstractC01816i {
    public final /* synthetic */ C0797Vk A00;

    public VX(C0797Vk vk) {
        this.A00 = vk;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        if (this.A00.A02 == null) {
            return this.A00.A08(EnumC01926t.A07);
        }
        C0797Vk vk = this.A00;
        return vk.A09(vk.A02.getInstallerPackageName(this.A00.A00.getPackageName()));
    }
}
