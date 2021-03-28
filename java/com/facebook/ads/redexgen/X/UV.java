package com.facebook.ads.redexgen.X;

import android.bluetooth.BluetoothDevice;
import java.util.ArrayList;

public class UV implements AbstractC01816i {
    public final /* synthetic */ UX A00;

    public UV(UX ux) {
        this.A00 = ux;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() throws Exception {
        if (this.A00.A00 == null) {
            return this.A00.A08(EnumC01926t.A06);
        }
        ArrayList arrayList = new ArrayList();
        for (BluetoothDevice bluetoothDevice : this.A00.A00.getBondedDevices()) {
            arrayList.add(new UW(bluetoothDevice));
        }
        return this.A00.A0E(arrayList);
    }
}
