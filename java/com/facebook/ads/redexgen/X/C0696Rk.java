package com.facebook.ads.redexgen.X;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.Rk  reason: case insensitive filesystem */
public final class C0696Rk implements KE {
    public static byte[] A0E;
    public static String[] A0F;
    public AbstractC00591m A00;
    public AnonymousClass90 A01;
    public String A02;
    public boolean A03;
    public final int A04;
    public final Handler A05;
    @Nullable
    public final AdSize A06;
    public final C00390s A07;
    public final C0820Wh A08;
    public final JE A09;
    public final EnumC0500Js A0A;
    public final KF A0B = new KF(this.A08);
    public final Runnable A0C;
    public final String A0D;

    public static String A03(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0E, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A0F[2].length() != 10) {
                throw new RuntimeException();
            }
            String[] strArr = A0F;
            strArr[1] = "uoxYJqIRleds8fPMMv";
            strArr[1] = "uoxYJqIRleds8fPMMv";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 87);
            i4++;
        }
    }

    public static void A05() {
        byte[] bArr = {54, 51, 70, 51, -20, -19, -18, -15, -10, -15, -4, -15, -9, -10, 8, 9, -70, 10, 6, -5, -3, -1, 7, -1, 8, 14, -70, 3, 8, -70, 12, -1, 13, 10, 9, 8, 13, -1};
        if (A0F[0].length() != 2) {
            throw new RuntimeException();
        }
        String[] strArr = A0F;
        strArr[1] = "dKV76OJFyRmVPWeRzZ";
        strArr[1] = "dKV76OJFyRmVPWeRzZ";
        A0E = bArr;
    }

    public static void A06() {
        A0F = new String[]{"Um", "5O6Pi5UhekEiJBNtL2", "ByBiFstlzS", "VNZICTTmM6bBZ", "I3ykA2cHAONkN", "xnUs6VMzToWHuFoC", "Qkjm3fg24P6DD7pmZ7L4neN1zLjqdukp", "LFB8Dcv49A6aPeUL"};
    }

    static {
        A06();
        A05();
        C0537Lg.A02();
    }

    public C0696Rk(C0820Wh wh, String str, EnumC0500Js js, @Nullable AdSize adSize, int i) {
        this.A08 = wh;
        this.A0D = str;
        this.A0A = js;
        this.A06 = adSize;
        this.A04 = i;
        this.A0B.A0R(this);
        this.A07 = new C00390s();
        this.A03 = true;
        this.A05 = new Handler();
        this.A0C = new C0375Er(this);
        this.A09 = wh.A06();
        DynamicLoaderFactory.makeLoader(this.A08).getInitApi().onAdLoadInvoked(this.A08);
    }

    private List<RG> A04() {
        AnonymousClass90 r5 = this.A01;
        ArrayList arrayList = new ArrayList(r5.A02());
        for (C02408y A042 = r5.A04(); A042 != null; A042 = r5.A04()) {
            AbstractC00340n A002 = this.A07.A00(AdPlacementType.NATIVE);
            if (A002 != null && A002.A6i() == AdPlacementType.NATIVE) {
                HashMap hashMap = new HashMap();
                hashMap.put(A03(0, 4, 123), A042.A06());
                hashMap.put(A03(4, 10, 49), r5.A05());
                RG rg = (RG) A002;
                rg.A0Y(this.A08, new C0695Rj(this, arrayList, rg), this.A09, hashMap, C1007bZ.A0I());
            }
        }
        return arrayList;
    }

    public final void A07() {
        this.A03 = false;
        this.A05.removeCallbacks(this.A0C);
    }

    /* JADX INFO: Multiple debug info for r15v0 'this'  com.facebook.ads.redexgen.X.Rk: [D('adEnvironmentData' com.facebook.ads.redexgen.X.KC), D('e' com.facebook.ads.redexgen.X.Jn)] */
    public final void A08() {
        boolean z;
        try {
            LH lh = null;
            C0505Jx jx = new C0505Jx(this.A08, null, null, null);
            C0820Wh wh = this.A08;
            String str = this.A0D;
            AdSize adSize = this.A06;
            if (adSize != null) {
                lh = new LH(adSize.getHeight(), this.A06.getWidth());
            }
            EnumC0500Js js = this.A0A;
            int i = this.A04;
            boolean isTestMode = AdSettings.isTestMode(this.A08);
            if (AdSettings.isChildDirected() || AdSettings.isMixedAudience()) {
                z = true;
            } else {
                z = false;
            }
            this.A0B.A0Q(new KC(wh, str, lh, js, null, i, isTestMode, z, jx, LN.A01(J8.A0H(this.A08)), this.A02, null));
        } catch (C0496Jn e) {
            A9X(C0495Jm.A03(e));
        }
    }

    public final void A09(AbstractC00591m r1) {
        this.A00 = r1;
    }

    public final void A0A(String str) {
        this.A02 = str;
    }

    public final boolean A0B() {
        AnonymousClass90 r0 = this.A01;
        return r0 == null || r0.A0A();
    }

    @Override // com.facebook.ads.redexgen.X.KE
    public final void A9X(C0495Jm jm) {
        if (this.A03) {
            this.A05.postDelayed(this.A0C, TapjoyConstants.SESSION_ID_INACTIVITY_TIME);
        }
        AbstractC00591m r3 = this.A00;
        if (A0F[2].length() != 10) {
            throw new RuntimeException();
        }
        String[] strArr = A0F;
        strArr[2] = "yGn7NPCZVX";
        strArr[2] = "yGn7NPCZVX";
        if (r3 != null) {
            r3.A9X(jm);
        }
    }

    @Override // com.facebook.ads.redexgen.X.KE
    public final void AB3(C0944aV aVVar) {
        AnonymousClass90 A002 = aVVar.A00();
        if (A002 != null) {
            if (this.A03) {
                long A0A2 = A002.A05().A0A();
                if (A0A2 == 0) {
                    A0A2 = TapjoyConstants.SESSION_ID_INACTIVITY_TIME;
                }
                this.A05.postDelayed(this.A0C, A0A2);
            }
            this.A01 = A002;
            List<RG> A042 = A04();
            if (this.A00 == null) {
                return;
            }
            if (A042.isEmpty()) {
                this.A00.A9X(C0495Jm.A02(AdErrorType.NO_FILL, A03(0, 0, 68)));
            } else {
                this.A00.AAI(A042);
            }
        } else {
            throw new IllegalStateException(A03(14, 24, 67));
        }
    }
}
