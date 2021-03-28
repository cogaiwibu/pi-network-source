package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.AdError;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.proguard.annotations.DoNotStrip;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONObject;

public final class RD implements AbstractC00340n {
    public static byte[] A0B;
    public static String[] A0C;
    public static final String A0D = RD.class.getSimpleName();
    public AbstractC00420v A00;
    public RK A01;
    public C0331Cv A02;
    @Nullable
    public JE A03;
    @Nullable
    @DoNotStrip
    public NN A04;
    @Nullable
    public C0838Wz A05;
    public String A06;
    public Map<String, Object> A07;
    public boolean A08 = false;
    public boolean A09 = false;
    public boolean A0A = false;

    public static String A05(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0B, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 19);
            if (A0C[2].length() != 29) {
                String[] strArr = A0C;
                strArr[3] = "viF0h1063r6cbXDqGfnWrC6qPBVBGzAv";
                strArr[7] = "3ywSXssJKLxMazlfVUMLvW6ymO505mlb";
            } else {
                throw new RuntimeException();
            }
        }
        return new String(copyOfRange);
    }

    public static void A07() {
        A0B = new byte[]{-27, -30, -11, -30, -40, -39, -38, -35, -30, -35, -24, -35, -29, -30, -69, -84, -65, -69, 118, -81, -69, -76, -77, 5, 4, -10, -67, -56};
    }

    public static void A08() {
        A0C = new String[]{"1VlIdrj3fRAASVh0IRQbA", "AKXoeI10d8PJONEXEmQHjWIEkAB2E", "HfXt1ktTFXNYFvURT1ePpe", "VNbNAjzqH3UXN3t9RrTP5z6I5Qa6gPQJ", "DeawL9PzUIlDumNdtXISYTaSpfy6P3Cj", "KNbO6MhxkLbBAZAqlm1H7U8Ouut8mEhI", "i536pd2CEb7n0lc", "TelURl5RBqiFivFSJRRvco6RCKborqoX"};
    }

    static {
        A08();
        A07();
    }

    /* access modifiers changed from: private */
    public void A06() {
        boolean z;
        if (this.A00 != null && this.A08 && (this.A09 || !this.A0A)) {
            this.A00.A92(this, this.A05);
        }
        AbstractC0685Qz A0F = this.A02.A0A();
        if (this.A00 != null) {
            z = true;
        } else {
            z = false;
        }
        A0F.A3Y(z);
        if (A0C[2].length() != 29) {
            String[] strArr = A0C;
            strArr[2] = "DQYu3GBVfiN4Ml";
            strArr[2] = "DQYu3GBVfiN4Ml";
            return;
        }
        throw new RuntimeException();
    }

    private void A0A(AnonymousClass91 r11) {
        RI A002 = RI.A00((JSONObject) this.A07.get(A05(0, 4, 110)));
        this.A06 = A002.A5j();
        if (C00300j.A04(this.A02, A002, this.A03)) {
            this.A02.A0A().A41();
            this.A00.A93(this, AdError.internalError(2006));
            return;
        }
        this.A04 = new F0(this, A002);
        this.A05 = new C0838Wz(this.A02, new WeakReference(this.A04), r11.A04());
        this.A05.A0C(r11.A07(), r11.A08());
        RC rc = new RC(this);
        C0331Cv cv = this.A02;
        JE je = this.A03;
        C0838Wz wz = this.A05;
        this.A01 = new RK(cv, je, wz, wz.getViewabilityChecker(), rc);
        this.A01.A09(A002);
        this.A05.loadDataWithBaseURL(NQ.A00(), A002.A05(), A05(14, 9, 52), A05(23, 5, 125), null);
        this.A08 = true;
        A06();
    }

    public final void A0D(C0331Cv cv, JE je, EnumC0499Jr jr, AbstractC00420v r8, Map<String, Object> map) {
        cv.A0A().A3X();
        this.A02 = cv;
        this.A03 = je;
        this.A00 = r8;
        this.A07 = map;
        this.A0A = J8.A11(this.A02.getApplicationContext());
        A0A((AnonymousClass91) this.A07.get(A05(4, 10, 97)));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00340n
    public final String A5j() {
        return this.A06;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00340n
    public final AdPlacementType A6i() {
        return AdPlacementType.BANNER;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00340n
    public final void onDestroy() {
        boolean z;
        AbstractC0685Qz A0F = this.A02.A0A();
        if (this.A05 != null) {
            z = true;
        } else {
            z = false;
        }
        A0F.A3V(z);
        C0838Wz wz = this.A05;
        if (wz != null) {
            wz.destroy();
            this.A05 = null;
            this.A04 = null;
        }
    }
}
