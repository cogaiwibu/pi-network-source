package com.facebook.ads.redexgen.X;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.ads.AdError;

/* renamed from: com.facebook.ads.redexgen.X.13  reason: invalid class name */
public final class AnonymousClass13 extends BroadcastReceiver {
    public static String[] A03;
    public RM A00;
    public AnonymousClass12 A01;
    public String A02;

    static {
        A00();
    }

    public static void A00() {
        A03 = new String[]{"JgmY627JJ4fVvMUsUI7dBJzvca", "2Fivc7ze9Y6M7vLBAhVCw66dd2zEUTp", "oqNyJxLxp23hnAfKGRpFUMlaCTnSy4au", "HRO7fC4J0U3bXqsrOiWljP6J940cuLTJ", "rhEs9JkkityiMJcgD18RNPKtdGmllPs6", "c8I5EiJJKjWgwuyghylYWruaZ4nXJiut", "YeKDqRnNq5JcEGU0HYsnt6sxK1D4K6hE", "zIQMBMVVQmczFglCifMrZtV9RNUhKeCf"};
    }

    public AnonymousClass13(String str, RM rm, AnonymousClass12 r3) {
        this.A00 = rm;
        this.A01 = r3;
        this.A02 = str;
    }

    public final IntentFilter A01() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(EnumC0628Ou.A06.A03(this.A02));
        intentFilter.addAction(EnumC0628Ou.A09.A03(this.A02));
        intentFilter.addAction(EnumC0628Ou.A04.A03(this.A02));
        intentFilter.addAction(EnumC0628Ou.A0A.A03(this.A02));
        intentFilter.addAction(EnumC0628Ou.A05.A03(this.A02));
        intentFilter.addAction(EnumC0628Ou.A0C.A03(this.A02));
        intentFilter.addAction(EnumC0628Ou.A0B.A03(this.A02));
        intentFilter.addAction(EnumC0628Ou.A03.A03(this.A02));
        return intentFilter;
    }

    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (EnumC0628Ou.A06.A03(this.A02).equals(action)) {
            AnonymousClass12 r4 = this.A01;
            RM rm = this.A00;
            if (A03[1].length() != 11) {
                String[] strArr = A03;
                strArr[0] = "z37hhVYNur1y5njE4t22VYTMbB";
                strArr[0] = "z37hhVYNur1y5njE4t22VYTMbB";
                r4.AAr(rm);
                return;
            }
        } else if (EnumC0628Ou.A09.A03(this.A02).equals(action)) {
            boolean A16 = J8.A16(context);
            String[] strArr2 = A03;
            if (strArr2[3].charAt(16) != strArr2[4].charAt(16)) {
                String[] strArr3 = A03;
                strArr3[0] = "a2nbOp8yH430aeg70B0MHQFnwN";
                strArr3[0] = "a2nbOp8yH430aeg70B0MHQFnwN";
                if (A16) {
                    AnonymousClass12 r5 = this.A01;
                    RM rm2 = this.A00;
                    AdError adError = AdError.AD_PRESENTATION_ERROR;
                    String[] strArr4 = A03;
                    if (strArr4[3].charAt(16) != strArr4[4].charAt(16)) {
                        String[] strArr5 = A03;
                        strArr5[2] = "Smm3aT6IchFgLH9ob00fwQqxHFnPPG6O";
                        strArr5[5] = "wzZfDEncWZ9M4YUYJFr8Gzf2lfnMb6hd";
                        r5.AAs(rm2, adError);
                        return;
                    }
                    String[] strArr6 = A03;
                    strArr6[6] = "douVyTcHxmEKv1YyJqQbVTsvWWCOpXBn";
                    strArr6[7] = "x6yn97aV8hj96Z0WREVv4HAdEeLr9VIY";
                    r5.AAs(rm2, adError);
                    return;
                }
                this.A01.AAs(this.A00, AdError.INTERNAL_ERROR);
                return;
            }
        } else if (EnumC0628Ou.A04.A03(this.A02).equals(action)) {
            this.A01.AAo(this.A00);
            return;
        } else if (EnumC0628Ou.A0A.A03(this.A02).equals(action)) {
            this.A01.AAq(this.A00);
            return;
        } else if (EnumC0628Ou.A05.A03(this.A02).equals(action)) {
            this.A01.onRewardedVideoClosed();
            return;
        } else if (EnumC0628Ou.A0B.A03(this.A02).equals(action)) {
            this.A01.AAm(this.A00);
            return;
        } else if (EnumC0628Ou.A0C.A03(this.A02).equals(action)) {
            this.A01.AAn(this.A00);
            return;
        } else if (EnumC0628Ou.A03.A03(this.A02).equals(action)) {
            this.A01.onRewardedVideoActivityDestroyed();
            return;
        } else {
            return;
        }
        throw new RuntimeException();
    }
}
