package com.facebook.ads.redexgen.X;

import android.app.KeyguardManager;
import android.content.Context;
import java.util.Arrays;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.Lf  reason: case insensitive filesystem */
public final class C0536Lf {
    public static byte[] A00;
    public static String[] A01;
    public static final String A02 = C0536Lf.class.getSimpleName();

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 14);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-67, -13, -19, 1, -17, -3, -23, -6, -20, -100, -104, -93, -94, -96, -93, -109, -91, -108, -110, -103, -107, -84, -101, -88, -84, -95};
    }

    public static void A02() {
        A01 = new String[]{"daXn", "1AEGGiZtK9izNwxj0gdNwiRX4yxGSLbl", "jWJWqJI6vm3EcSkucHo8Z2hc4QqQU5eN", "kJ80Vw1lOC47iRluFhEDeBzKcKjW1m8D", "UFa447OZZwRnjgAwYt6DClQrKKYck", "JtTOAq931RuxhQ9Tu1gEBrllAq", "KlezWCwDulS1StSn2NonTUsqgHFd0zlY", "hQC1wn7yR06U4qX9nCxzTugCr"};
    }

    static {
        A02();
        A01();
    }

    public static boolean A03(Context context) {
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService(A00(1, 8, 122));
        return keyguardManager != null && keyguardManager.inKeyguardRestrictedInputMode();
    }

    public static boolean A04(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return false;
        }
        String str = map.get(A00(16, 5, 32));
        String str2 = map.get(A00(21, 5, 39));
        String str3 = map.get(A00(9, 3, 35));
        if (str != null) {
            String[] strArr = A01;
            if (strArr[0].length() != strArr[4].length()) {
                String[] strArr2 = A01;
                strArr2[7] = "KnKdjir99deazR25n";
                strArr2[7] = "KnKdjir99deazR25n";
                String A002 = A00(0, 1, 126);
                if (!str.equals(A002) || str2 == null || !str2.equals(A002) || str3 == null || !str3.equals(A00(12, 4, 32))) {
                    return false;
                }
                return true;
            }
            throw new RuntimeException();
        }
        return false;
    }

    public static boolean A05(Map<String, String> map) {
        String str;
        if (map == null || map.isEmpty()) {
            return false;
        }
        String str2 = map.get(A00(16, 5, 32));
        String str3 = map.get(A00(21, 5, 39));
        String A002 = A00(0, 1, 126);
        if ((str2 == null || !str2.equals(A002)) && ((str3 == null || !str3.equals(A002)) && (str = map.get(A00(9, 3, 35))) != null && str.equals(A00(12, 4, 32)))) {
            return true;
        }
        return false;
    }
}
