package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdExtendedListener;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.RewardedAdListener;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

public final class S1 implements AbstractC00671u {
    public static byte[] A04;
    public static String[] A05;
    public final AbstractC0702Rq A00;
    public final AbstractC00621p A01;
    public final C00651s A02;
    public final C0820Wh A03;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 57);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{-77, -42, -110, -31, -44, -36, -41, -43, -26, -110, -37, -27, -110, -32, -25, -34, -34, -115, -96, -103, -113, -105, -112, -86, -112, -93, -97, -99, -116, -98, -86, -106, -112, -92, -74, -78, -79, -27, -44, -39, -43, -34, -45, -43, -66, -43, -28, -25, -33, -30, -37, -87, -82, -76, -65, -91, -78, -78, -81, -78, -65, -93, -81, -92, -91, -65, -85, -91, -71, 4, 7, 6, -1, 23, 1, 6, 14, -7, 4, 1, -4, -7, 12, 1, 7, 6, 23, 12, 1, 5, -3, 23, 3, -3, 17, -61, -37, -23, -23, -41, -35, -37, -80, -106, -66, -38, -28, -28, -38, -33, -40, -111, -45, -26, -33, -43, -35, -42, -111, -41, -32, -29, -111, -34, -42, -28, -28, -46, -40, -42, -97, -95, -94, -96, -83, -109, -96, -96, -99, -96, -83, -101, -109, -95, -95, -113, -107, -109, -83, -103, -109, -89, 4, 19, 12};
    }

    public static void A02() {
        A05 = new String[]{"PyT2XUnl", "3EmvKqRjFYzRkizxlD8eotggUBC8U5J9", "Ib6uyfMRsh5ysHZ3i8ryXk3sO16qq9Ys", "q2kkzr74cnXMazMYxmC9c", "9U931lGThJH7Qz6wctlm6EKEWHFtvDAV", "f15MquYM06llw3BWZWASFwAp5egI2HKX", "yMUgiPhi", "t3xZZPMR"};
    }

    public S1(C0820Wh wh, C00651s r2, AbstractC00621p r3, AbstractC0702Rq rq) {
        this.A03 = wh;
        this.A02 = r2;
        this.A01 = r3;
        this.A00 = rq;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.facebook.ads.redexgen.X.AbstractC00671u
    public final void A7I(Message message) {
        InterstitialAd A012 = this.A02.A01();
        String A002 = A00(152, 3, 106);
        if (A012 == null) {
            this.A03.A04().A82(A002, C02248i.A0A, new C02258j(A00(0, 17, 57)));
            return;
        }
        int i = message.what;
        String A003 = A00(95, 9, 61);
        String A004 = A00(104, 27, 56);
        String A005 = A00(17, 17, 18);
        if (i != 10) {
            if (i != 1020) {
                if (A05[4].charAt(15) != 'R') {
                    String[] strArr = A05;
                    strArr[2] = "aJfdsH08DFQiAUsDka0Nh1fTZA9JZGsz";
                    strArr[2] = "aJfdsH08DFQiAUsDka0Nh1fTZA9JZGsz";
                    if (i == 1022) {
                        this.A01.AD6();
                    } else if (i != 1023) {
                        switch (i) {
                        }
                    }
                }
                throw new RuntimeException();
            }
            this.A01.AD0();
            Bundle bundle = message.getData().getBundle(A005);
            if (bundle != null) {
                this.A02.A0B(bundle.getLong(A00(69, 26, 127)));
            } else {
                AbstractC02238h A042 = this.A03.A04();
                int i2 = C02248i.A0K;
                A042.A82(A002, i2, new C02258j(A004, A003 + message));
            }
            this.A02.A0C(null);
            if (this.A02.A02() != null) {
                switch (message.what) {
                    case 1020:
                        this.A02.A02().onAdLoaded(A012);
                        return;
                    case 1021:
                        this.A02.A02().onInterstitialDisplayed(A012);
                        return;
                    case IronSourceError.ERROR_RV_SHOW_CALLED_DURING_SHOW /*{ENCODED_INT: 1022}*/:
                        this.A02.A02().onInterstitialDismissed(A012);
                        return;
                    case 1024:
                        this.A02.A02().onAdClicked(A012);
                        return;
                    case 1025:
                        this.A02.A02().onLoggingImpression(A012);
                        return;
                    case IronSourceError.ERROR_RV_LOAD_DURING_LOAD /*{ENCODED_INT: 1026}*/:
                        if (this.A02.A02() instanceof InterstitialAdExtendedListener) {
                            InterstitialAdListener A022 = this.A02.A02();
                            if (A05[2].charAt(18) == 'n') {
                                ((InterstitialAdExtendedListener) A022).onInterstitialActivityDestroyed();
                                break;
                            } else {
                                String[] strArr2 = A05;
                                strArr2[1] = "4ubpoteMIucGsWyTMsTtOH4ZOdBl9bHr";
                                strArr2[5] = "Xxx4qDjyhZoijrhiIp4u1mFMOEMCLZoL";
                                ((InterstitialAdExtendedListener) A022).onInterstitialActivityDestroyed();
                                break;
                            }
                        }
                        break;
                }
                RewardedAdListener A043 = this.A02.A04();
                String[] strArr3 = A05;
                if (strArr3[3].length() != strArr3[7].length()) {
                    String[] strArr4 = A05;
                    strArr4[4] = "YO9dGq40ZDljeOjTjHA4uB3VVKU9R56I";
                    strArr4[4] = "YO9dGq40ZDljeOjTjHA4uB3VVKU9R56I";
                    if (A043 != null) {
                        switch (message.what) {
                            case 3000:
                                this.A02.A04().onRewardedAdCompleted();
                                if (A05[2].charAt(18) != 'n') {
                                    String[] strArr5 = A05;
                                    strArr5[1] = "IMuRostxJ5htnzhiOcsxYcu1iidsGUgj";
                                    strArr5[5] = "ubJ4M5GxN6FfPval4rtOnbhl8vPUgGKC";
                                    return;
                                }
                                break;
                            case 3001:
                                this.A02.A04().onRewardedAdServerSucceeded();
                                return;
                            case 3002:
                                this.A02.A04().onRewardedAdServerFailed();
                                return;
                            default:
                                return;
                        }
                    } else {
                        return;
                    }
                }
                throw new RuntimeException();
            }
            return;
        }
        Bundle bundle2 = message.getData().getBundle(A005);
        if (bundle2 != null) {
            int i3 = bundle2.getInt(A00(51, 18, 39));
            String string = bundle2.getString(A00(131, 21, 21));
            AdError error = new AdError(i3, string);
            this.A01.ACw(error);
            if (this.A02.A02() != null) {
                this.A02.A02().onError(A012, error);
            } else {
                Log.e(A00(34, 17, 55), string);
            }
        } else {
            this.A01.ACt(EnumC00611o.A05);
            AbstractC02238h A044 = this.A03.A04();
            int i4 = C02248i.A0K;
            A044.A82(A002, i4, new C02258j(A004, A003 + message));
        }
        this.A02.A0C(null);
    }
}
