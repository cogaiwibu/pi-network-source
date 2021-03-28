package com.facebook.ads.redexgen.X;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import java.util.Arrays;
import javax.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.Tm  reason: case insensitive filesystem */
public final class C0747Tm extends AnonymousClass6Z {
    public static byte[] A04;
    @Nullable
    public ConfigurationInfo A00;
    public final ActivityManager.RunningAppProcessInfo A01;
    public final ActivityManager A02 = ((ActivityManager) this.A03.getSystemService(A04(0, 8, 106)));
    public final Context A03;

    static {
        A05();
    }

    public static String A04(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 6);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A04 = new byte[]{13, 15, 24, 5, 26, 5, 24, 21};
    }

    public C0747Tm(Context context, C01725z r6) {
        super(context, r6);
        this.A03 = context;
        ActivityManager activityManager = this.A02;
        if (activityManager != null) {
            this.A00 = activityManager.getDeviceConfigurationInfo();
        }
        this.A01 = new ActivityManager.RunningAppProcessInfo();
    }

    public final AbstractC01816i A0H() {
        return new C0744Tj(this);
    }

    public final AbstractC01816i A0I() {
        return new C0745Tk(this);
    }

    public final AbstractC01816i A0J() {
        return new C0740Tf(this);
    }

    public final AbstractC01816i A0K() {
        return new C0741Tg(this);
    }

    public final AbstractC01816i A0L() {
        return new C0742Th(this);
    }

    public final AbstractC01816i A0M() {
        return new C0739Te(this);
    }

    public final AbstractC01816i A0N() {
        return new C0743Ti(this);
    }

    public final AbstractC01816i A0O() {
        return new C0738Td(this);
    }

    public final AbstractC01816i A0P() {
        return new C0746Tl(this);
    }

    public final AbstractC01816i A0Q() {
        return new C0736Tb(this);
    }

    public final AbstractC01816i A0R() {
        return new C0737Tc(this);
    }
}
