package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Nullable;
import kotlin.jvm.internal.ByteCompanionObject;

/* renamed from: com.facebook.ads.redexgen.X.6Z  reason: invalid class name */
public class AnonymousClass6Z {
    public static byte[] A03;
    public static String[] A04;
    public final Context A00;
    public final Intent A01 = this.A00.registerReceiver(null, new IntentFilter(A00(0, 37, 37)));
    public final C01725z A02;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 8);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{-114, -101, -111, -97, -100, -106, -111, 91, -106, -101, -95, -110, -101, -95, 91, -114, -112, -95, -106, -100, -101, 91, 111, 110, -127, -127, 114, ByteCompanionObject.MAX_VALUE, -122, -116, 112, 117, 110, 123, 116, 114, 113};
    }

    public static void A02() {
        A04 = new String[]{"o84FpHzEZxPfIbBPVc3PyJBEasuCfO6c", "JrI1dU8TTdtObirIwzr9PDFTf", "Oz2bxznKOZIoYiu00r0tMjRqahT5L8eX", "WyAMbI9dOM56rsavBzGbIzP4LEeOBa2a", "QAd1wzNDoH5I97BQWX3GR9O2v", "PJ66RTAVo3tttPzwttyvOY4w2twOeZmh", "FZtFZJQ3MyLobIqHR00oY", "wJgkVVpmtRvVSLM2dL7kjEoPPerdmE0p"};
    }

    public AnonymousClass6Z(Context context, C01725z r7) {
        this.A00 = context;
        this.A02 = r7;
    }

    @Nullable
    public final C01946v A03() {
        String packageName;
        if (this.A02.A0a() == EnumC01856m.A0G) {
            return null;
        }
        Context context = this.A00;
        String[] strArr = A04;
        if (strArr[6].length() != strArr[1].length()) {
            String[] strArr2 = A04;
            strArr2[2] = "BdLEpYuR7vP7Yavjfaa4glVMZlrsrS6q";
            strArr2[2] = "BdLEpYuR7vP7Yavjfaa4glVMZlrsrS6q";
            if (context == null) {
                packageName = A00(0, 0, 34);
            } else {
                packageName = context.getPackageName();
            }
            return new C01946v(packageName);
        }
        throw new RuntimeException();
    }

    public final AbstractC01966x A04(float f) {
        return new WT(SystemClock.elapsedRealtime(), A03(), f);
    }

    public final AbstractC01966x A05(int i) {
        return new WV(SystemClock.elapsedRealtime(), A03(), i);
    }

    public final AbstractC01966x A06(int i, HashMap<String, String> hashMap) {
        if (this.A01 == null) {
            return A08(EnumC01926t.A07);
        }
        HashMap<String, Integer> hashMap2 = new HashMap<>();
        for (String str : hashMap.keySet()) {
            String[] strArr = A04;
            if (strArr[7].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[2] = "InQCvX9bMvCeYEwlTxFUxsBs8sRyWh3b";
            strArr2[2] = "InQCvX9bMvCeYEwlTxFUxsBs8sRyWh3b";
            hashMap2.put(str, Integer.valueOf(this.A01.getIntExtra(hashMap.get(str), i)));
        }
        return A0D(hashMap2);
    }

    public final AbstractC01966x A07(long j) {
        return new WX(SystemClock.elapsedRealtime(), A03(), j);
    }

    public final AbstractC01966x A08(EnumC01926t r6) {
        return new WS(SystemClock.elapsedRealtime(), A03(), new C01936u(r6));
    }

    public final AbstractC01966x A09(String str) {
        return new C0813Wa(SystemClock.elapsedRealtime(), A03(), str);
    }

    public final AbstractC01966x A0A(String str) {
        Intent intent = this.A01;
        if (intent != null) {
            return A09(intent.getStringExtra(str));
        }
        return A08(EnumC01926t.A07);
    }

    public final AbstractC01966x A0B(String str, int i) {
        Intent intent = this.A01;
        if (intent == null) {
            return A08(EnumC01926t.A07);
        }
        int intExtra = intent.getIntExtra(str, i);
        if (A04[4].length() != 16) {
            String[] strArr = A04;
            strArr[2] = "oU3Fbet9HTJlYuGSJV9pu56iNwFexhrg";
            strArr[2] = "oU3Fbet9HTJlYuGSJV9pu56iNwFexhrg";
            return A05(intExtra);
        }
        throw new RuntimeException();
    }

    public final AbstractC01966x A0C(String str, boolean z) {
        Intent intent = this.A01;
        if (intent != null) {
            return A0G(intent.getBooleanExtra(str, z));
        }
        return A08(EnumC01926t.A07);
    }

    public final AbstractC01966x A0D(HashMap<String, Integer> hashMap) {
        return new WU(SystemClock.elapsedRealtime(), A03(), hashMap);
    }

    public final AbstractC01966x A0E(List<AbstractC01876o> list) {
        return new WW(SystemClock.elapsedRealtime(), A03(), list, EnumC01956w.A03);
    }

    public final AbstractC01966x A0F(List<String> resultList) {
        return new WW(SystemClock.elapsedRealtime(), A03(), resultList, EnumC01956w.A0C);
    }

    public final AbstractC01966x A0G(boolean z) {
        return new WQ(SystemClock.elapsedRealtime(), A03(), z);
    }
}
