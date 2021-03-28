package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.BatteryManager;
import android.os.Build;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import javax.inject.Singleton;

@Singleton
public final class US extends AnonymousClass6Z {
    public static byte[] A01;
    public static String[] A02;
    public final BatteryManager A00;

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 124);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{-7, 19, 18, 37, 37, 22, 35, 42, 30, 18, 31, 18, 24, 22, 35, 42, -11, -18, -1, -18, -11, 60, 81, 0, -16, -18, -7, -14};
    }

    public static void A03() {
        A02 = new String[]{"bPMdIRdGv", "GS1RiQ0Fe2OXcQcIkCuEDku7WILZ5IDY", "TsFhxeN3ooiOzKyGYimy4dCB8t9rX6Qk", "tDBwPFCmRryD0Q4apJFJlrgk6DNKamUD", "oUUA5cBoIxHqACzkd5Y2T9kUvSWODdEm", "FnX3lwsUZnwMMkDv8sp6DIbywwAIHXWj", "YZLb9o623eUfyZOuivTCDkgv5wbAGsEp", "CfH0aVj4RQl6Eoew8HOriE9Hjjy"};
    }

    public US(Context context, C01725z r5) {
        super(context, r5);
        this.A00 = (BatteryManager) context.getSystemService(A01(1, 14, 53));
    }

    public final AbstractC01816i A0H() {
        return new UK(this);
    }

    public final AbstractC01816i A0I() {
        return new UQ(this);
    }

    public final AbstractC01816i A0J() {
        HashMap hashMap = new HashMap();
        hashMap.put(A01(21, 1, 82), 2);
        hashMap.put(A01(0, 1, 28), 3);
        return new UP(this, hashMap);
    }

    public final AbstractC01816i A0K() {
        HashMap hashMap = new HashMap();
        hashMap.put(A01(15, 1, 66), A01(16, 5, 13));
        hashMap.put(A01(22, 1, 98), A01(23, 5, 17));
        return new UF(this, hashMap);
    }

    public final AbstractC01816i A0L() {
        return new UN(this);
    }

    public final AbstractC01816i A0M() {
        return new UI(this);
    }

    public final AbstractC01816i A0N() {
        return new UL(this);
    }

    public final AbstractC01816i A0O() {
        return new UR(this);
    }

    public final AbstractC01816i A0P() {
        return new UJ(this);
    }

    public final AbstractC01816i A0Q() {
        return new UG(this);
    }

    public final AbstractC01816i A0R() {
        return new UM(this);
    }

    public final AbstractC01816i A0S() {
        return new UH(this);
    }

    public final AbstractC01816i A0T() {
        return new UO(this);
    }

    public final AbstractC01966x A0U(int i) {
        if (Build.VERSION.SDK_INT < 21) {
            return A08(EnumC01926t.A05);
        }
        BatteryManager batteryManager = this.A00;
        if (A02[4].charAt(5) != 'c') {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[3] = "Z0BpikLZimvh7GQ0e0YfQZg6u7WmYRcx";
        strArr[6] = "N2CtCcOuXuTLuGr2kU7dW0gd7w3dfDGl";
        if (batteryManager != null) {
            return A05(batteryManager.getIntProperty(i));
        }
        return A08(EnumC01926t.A07);
    }

    @SuppressLint({"Nullable Dereference"})
    public final AbstractC01966x A0V(HashMap<String, Integer> resultMap) {
        if (Build.VERSION.SDK_INT < 21) {
            return A08(EnumC01926t.A05);
        }
        BatteryManager batteryManager = this.A00;
        if (A02[4].charAt(5) != 'c') {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[3] = "VX9OpHMsf9E36khSHc5jiQggPTjCMNcl";
        strArr[6] = "9ZxqnrvyvCCPPfnmtmMIQlgDqEWsMyB8";
        if (batteryManager == null) {
            return A08(EnumC01926t.A07);
        }
        Set<String> keySet = resultMap.keySet();
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String str : keySet) {
            hashMap.put(str, Integer.valueOf(this.A00.getIntProperty(resultMap.get(str).intValue())));
        }
        return A0D(hashMap);
    }
}
