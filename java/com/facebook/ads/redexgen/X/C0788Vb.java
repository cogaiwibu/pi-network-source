package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Vb  reason: case insensitive filesystem */
public class C0788Vb implements AbstractC01816i {
    public final /* synthetic */ C0797Vk A00;

    public C0788Vb(C0797Vk vk) {
        this.A00 = vk;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        if (this.A00.A01 == null) {
            return this.A00.A08(EnumC01926t.A07);
        }
        C0797Vk vk = this.A00;
        return vk.A07(vk.A01.firstInstallTime);
    }
}
