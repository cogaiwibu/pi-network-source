package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.ads.AdError;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.RewardData;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Map;
import org.json.JSONObject;

public final class RU implements AbstractC00430w {
    public static byte[] A04;
    public static String[] A05;
    @Nullable
    public AnonymousClass7H A00;
    public NV A01 = NV.A06;
    public final RQ A02;
    public final AnonymousClass1Y A03;

    static {
        A06();
        A05();
    }

    public static String A04(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 96);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A04 = new byte[]{-97, -39, -27, -34, -35, -81, -44, -38, -53, -40, -44, -57, -46, -122, -85, -40, -40, -43, -40, -122, -104, -106, -106, -100, -122, -35, -49, -38, -50, -43, -37, -38, -122, -57, -122, -36, -57, -46, -49, -54, -122, -89, -54, -81, -44, -52, -43, -108, 31, 34, 29, 34, 31, 50, 31, 29, 32, 51, 44, 34, 42, 35, -45, -30, -37, -58, -61, -42, -61, -41, -40, -39, -36, -31, -36, -25, -36, -30, -31, -38, -33, -27, -42, -29, -28, -27, -38, -27, -38, -46, -35};
    }

    public static void A06() {
        A05 = new String[]{"jJreqFAWfQsm2UlBXjWleQZy51A8w9r3", "B5vxrqY9e1pfFDILbPSJEQZe5Zep9JAF", "7hwRhDIA2xM98ucsNVPICP0872", "8yYdfjKxcW1uK5E8nS4F9bT", "cwoTvwLLOWGZrFwonmn2qn9xu", "wuc4L", "VoE60CbUCih", "1JGxuEjawtyxaKItdz1AQ1lnM"};
    }

    public RU(C0820Wh wh, Map<String, Object> map, AnonymousClass1Y r6, @Nullable String str) {
        this.A02 = A01(wh, map, str, (JSONObject) map.get(A04(65, 4, 2)));
        this.A03 = r6;
    }

    @Nullable
    private AdError A00(C0820Wh wh) {
        if (!this.A02.A0W().isEmpty()) {
            return null;
        }
        wh.A04().A82(A04(62, 3, 18), C02248i.A0O, new C02258j(A04(5, 43, 6)));
        return AdError.internalError(2006);
    }

    /* JADX INFO: Multiple debug info for r3v1 com.facebook.ads.redexgen.X.RQ: [D('customParams' java.util.Map<java.lang.String, java.lang.Object>), D('adDataBundle' com.facebook.ads.redexgen.X.RQ)] */
    public static RQ A01(C0820Wh wh, Map<String, Object> map, @Nullable String str, JSONObject jSONObject) {
        RQ adDataBundle = RQ.A01(jSONObject, wh);
        adDataBundle.A0b(str);
        AnonymousClass91 r0 = (AnonymousClass91) map.get(A04(69, 10, 19));
        if (r0 != null) {
            adDataBundle.A0Z(r0.A06());
        }
        return adDataBundle;
    }

    private AnonymousClass7H A03(C0820Wh wh) {
        AnonymousClass7H r0 = this.A00;
        return r0 != null ? r0 : new AnonymousClass7H(wh);
    }

    private void A07(C0820Wh wh, EnumSet<CacheFlag> enumSet) {
        NV nv;
        AnonymousClass1S A06 = this.A02.A0M().A0E().A06();
        if (A06 != null) {
            nv = A06.A0B();
        } else {
            nv = NV.A06;
        }
        A09(nv);
        RT rt = new RT(this);
        AnonymousClass7H r6 = new AnonymousClass7H(wh);
        C00501d r5 = new C00501d(this, this.A02, A04(79, 12, 17), r6);
        if (r5.A09()) {
            r6.A0X(new JL(this.A02.A0Q(), wh.A06()));
            r5.A08();
            return;
        }
        RQ rq = this.A02;
        if (A05[5].length() != 5) {
            throw new RuntimeException();
        }
        String[] strArr = A05;
        strArr[5] = "kxumv";
        strArr[5] = "kxumv";
        C00551i.A03(wh, rq, true, rt);
    }

    /* JADX INFO: Multiple debug info for r1v0 com.facebook.ads.redexgen.X.7H: [D('cacheVideos' boolean), D('cacheFileData' com.facebook.ads.redexgen.X.7G)] */
    /* JADX INFO: Multiple debug info for r2v17 com.facebook.ads.redexgen.X.19: [D('funnelLoggingHandler' com.facebook.ads.redexgen.X.JL), D('cacheFlags' java.util.EnumSet<com.facebook.ads.CacheFlag>)] */
    private void A08(C0820Wh wh, EnumSet<CacheFlag> enumSet) {
        AnonymousClass7H A032 = A03(wh);
        A032.A0X(new JL(this.A02.A0Q(), wh.A06()));
        RQ rq = this.A02;
        String A042 = A04(79, 12, 17);
        C00501d r6 = new C00501d(this, rq, A042, A032);
        if (r6.A09()) {
            r6.A08();
            return;
        }
        if (!TextUtils.isEmpty(this.A02.A0R())) {
            AnonymousClass7G r62 = new AnonymousClass7G(this.A02.A0R(), this.A02.A0U(), A042);
            r62.A04 = true;
            r62.A03 = A04(0, 5, 17);
            A032.A0T(r62);
        }
        A032.A0S(new AnonymousClass7E(this.A02.A0O().A01(), OP.A04, OP.A04, this.A02.A0U(), A04(79, 12, 17)));
        boolean contains = enumSet.contains(CacheFlag.VIDEO);
        int i = 0;
        for (AnonymousClass19 r2 : this.A02.A0W()) {
            AnonymousClass7E r11 = new AnonymousClass7E(r2.A0E().A07(), C00511e.A00(r2.A0E()), C00511e.A01(r2.A0E()), this.A02.A0U(), A04(79, 12, 17));
            if (i == 0) {
                A032.A0R(r11);
            } else {
                A032.A0S(r11);
            }
            for (String str : r2.A0H().A00()) {
                A032.A0S(new AnonymousClass7E(str, -1, -1, this.A02.A0U(), A04(79, 12, 17)));
            }
            if (contains && !TextUtils.isEmpty(r2.A0E().A08())) {
                AnonymousClass7G r112 = new AnonymousClass7G(r2.A0E().A08(), this.A02.A0U(), A04(79, 12, 17), r2.A0E().A05());
                r112.A04 = false;
                if (i == 0) {
                    A032.A0W(r112);
                } else {
                    A032.A0V(r112);
                }
            }
            i++;
        }
        A032.A0Q(new RS(this), new AnonymousClass7A(this.A02.A0U(), A042));
    }

    private void A09(NV nv) {
        this.A01 = nv;
    }

    public final KL A0A() {
        if (!TextUtils.isEmpty(this.A02.A0R()) && Build.VERSION.SDK_INT >= 21) {
            KL kl = KL.A03;
            String[] strArr = A05;
            if (strArr[6].length() != strArr[2].length()) {
                String[] strArr2 = A05;
                strArr2[3] = "f4kXngrP8CD5dz";
                strArr2[3] = "f4kXngrP8CD5dz";
                return kl;
            }
        } else if (this.A02.A0W().size() > 1) {
            return KL.A06;
        } else {
            RQ rq = this.A02;
            String[] strArr3 = A05;
            if (strArr3[7].length() == strArr3[4].length()) {
                String[] strArr4 = A05;
                strArr4[3] = "ny";
                strArr4[3] = "ny";
                if (rq.A0M().A0E().A06() != null) {
                    return KL.A08;
                }
                boolean A0G = A0G();
                String[] strArr5 = A05;
                if (strArr5[6].length() != strArr5[2].length()) {
                    String[] strArr6 = A05;
                    strArr6[3] = "JH";
                    strArr6[3] = "JH";
                    if (!A0G) {
                        return KL.A07;
                    }
                    KL kl2 = KL.A09;
                    if (A05[3].length() != 32) {
                        String[] strArr7 = A05;
                        strArr7[1] = "93R6MUXHMTxUt8WfLt1oZ3ea5zubl3sl";
                        strArr7[0] = "9xXPI1nVQC4CSUB4soKlPH985bh9DAt9";
                        return kl2;
                    }
                    String[] strArr8 = A05;
                    strArr8[3] = "ySAy4b6nQ";
                    strArr8[3] = "ySAy4b6nQ";
                    return kl2;
                }
                throw new RuntimeException();
            }
        }
        throw new RuntimeException();
    }

    public final NV A0B() {
        return this.A01;
    }

    public final String A0C() {
        return this.A02.A0Q();
    }

    public final void A0D() {
        this.A03.ADb();
    }

    public final void A0E(Intent intent, RewardData rewardData, String str) {
        this.A02.A0a(rewardData);
        this.A02.A0d(str);
        intent.putExtra(A04(48, 14, 94), this.A02);
    }

    public final void A0F(C0820Wh wh, EnumSet<CacheFlag> enumSet) {
        AdError A002 = A00(wh);
        if (A002 != null) {
            this.A03.A8l(A002);
            return;
        }
        this.A03.ACA();
        if (A0A() == KL.A08) {
            A07(wh, enumSet);
        } else {
            A08(wh, enumSet);
        }
    }

    public final boolean A0G() {
        return !TextUtils.isEmpty(this.A02.A0M().A0E().A08());
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00430w
    public final void A96() {
        this.A03.A8m();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00430w
    public final void A97() {
        this.A03.A8l(AdError.CACHE_ERROR);
    }
}
