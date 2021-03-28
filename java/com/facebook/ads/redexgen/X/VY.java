package com.facebook.ads.redexgen.X;

public class VY implements AbstractC01816i {
    public final /* synthetic */ C0797Vk A00;

    public VY(C0797Vk vk) {
        this.A00 = vk;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        if (this.A00.A02 == null) {
            return this.A00.A08(EnumC01926t.A07);
        }
        C0797Vk vk = this.A00;
        return vk.A0G(vk.A02.isSafeMode());
    }
}
