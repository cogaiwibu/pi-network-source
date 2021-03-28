package com.facebook.ads.redexgen.X;

import android.content.ActivityNotFoundException;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.Nb  reason: case insensitive filesystem */
public final class C0583Nb {
    public static byte[] A09;
    @Nullable
    public AbstractC0582Na A00;
    public boolean A01 = true;
    public boolean A02;
    public final C0820Wh A03;
    public final JE A04;
    public final LX A05;
    public final M6 A06;
    public final C0641Ph A07;
    public final String A08;

    static {
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A09, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 104);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A09 = new byte[]{31, 8, 29, 30, 41, 40, 40, 51, 50, 31, 48, 53, 63, 55, 16, 53, 47, 40, 57, 50, 57, 46, 114, 69, 69, 88, 69, 23, 82, 79, 82, 84, 66, 67, 94, 89, 80, 23, 86, 84, 67, 94, 88, 89, 73, 126, 126, 99, 126, 44, 123, 100, 101, 96, 105, 44, 99, 124, 105, 98, 101, 98, 107, 44};
    }

    public C0583Nb(C0820Wh wh, String str, C0641Ph ph, LX lx, JE je, M6 m6) {
        this.A03 = wh;
        this.A08 = str;
        this.A07 = ph;
        this.A05 = lx;
        this.A04 = je;
        this.A06 = m6;
    }

    public static void A03(C0820Wh wh, @Nullable C0641Ph ph, LX lx, JE je, AnonymousClass1I r11, String str) {
        AbstractC00260f A012 = C00270g.A01(wh, je, str, Uri.parse(r11.A04()), new NU().A04(ph).A03(lx).A06(), false, false);
        if (A012 != null) {
            A012.A0A();
        }
    }

    private void A05(String str, String str2, Map<String, String> map) {
        this.A04.A8M(str, map);
        L9.A00(new NY(this, map, str, str2), new NZ(this, str, map), C0525Ks.A00());
    }

    /* access modifiers changed from: private */
    public void A06(String str, String str2, Map<String, String> map) {
        String A012 = A01(0, 22, 52);
        try {
            AbstractC00260f A013 = C00270g.A01(this.A03, this.A04, str, Uri.parse(str2), new NU(map).A04(this.A07).A03(this.A05).A06(), this.A01, this.A02);
            if (A013 != null) {
                A013.A0D();
            }
            if (this.A00 != null) {
                this.A00.A9H();
            }
            this.A06.A3s(this.A08);
        } catch (ActivityNotFoundException e) {
            Log.e(A012, A01(44, 20, 100) + str2, e);
        } catch (Exception e2) {
            Log.e(A012, A01(22, 22, 95), e2);
        }
    }

    public final void A07(AbstractC0582Na na) {
        this.A00 = na;
    }

    public final void A08(String str, String str2, Map<String, String> map) {
        new JL(str, this.A04).A03(JK.A0J, null);
        if (this.A05.A0A(this.A03)) {
            this.A04.A7z(str, map);
        } else if (J8.A0z(this.A03)) {
            A05(str, str2, map);
        } else {
            A06(str, str2, map);
        }
    }

    public final void A09(boolean z) {
        this.A02 = z;
    }

    public final void A0A(boolean z) {
        this.A01 = z;
    }
}
