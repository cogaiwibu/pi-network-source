package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import java.util.Arrays;

public class WO implements AbstractC01816i {
    public static byte[] A01;
    public final /* synthetic */ WP A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 2);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{84, 91, 81, 71, 90, 92, 81, 27, 93, 84, 71, 81, 66, 84, 71, 80, 27, 64, 70, 87, 27, 84, 86, 65, 92, 90, 91, 27, 96, 102, 119, 106, 102, 97, 116, 97, 112, 28, 16, 17, 17, 26, 28, 11, 26, 27};
    }

    public WO(WP wp) {
        this.A00 = wp;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        Bundle bundle = null;
        Intent intent = this.A00.A00.registerReceiver(null, new IntentFilter(A00(0, 37, 55)));
        if (intent != null) {
            bundle = intent.getExtras();
        }
        if (bundle != null) {
            return this.A00.A0G(bundle.getBoolean(A00(37, 9, 125)));
        }
        return this.A00.A08(EnumC01926t.A07);
    }
}
