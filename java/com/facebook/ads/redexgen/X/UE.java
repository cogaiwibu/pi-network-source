package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.os.SystemClock;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public final class UE extends AnonymousClass6Z {
    public static byte[] A01;
    public final AudioManager A00;

    static {
        A05();
    }

    public static String A04(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 33);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A01 = new byte[]{-22, -2, -19, -14, -8};
    }

    public UE(Context context, C01725z r5) {
        super(context, r5);
        this.A00 = (AudioManager) context.getSystemService(A04(0, 5, 104));
    }

    /* access modifiers changed from: private */
    @SuppressLint({"Nullable Dereference"})
    public AbstractC01966x A03(HashMap<Integer, UD> hashMap) {
        return new WY(SystemClock.elapsedRealtime(), A03(), hashMap, EnumC01956w.A06);
    }

    public final AbstractC01816i A0H() {
        return new UB(this);
    }

    public final AbstractC01816i A0I() {
        return new U8(this);
    }

    public final AbstractC01816i A0J() {
        return new U9(this);
    }

    public final AbstractC01816i A0K() {
        return new UA(this);
    }

    public final AbstractC01816i A0L(List<C01806h> list) {
        return new UC(this, list);
    }
}
