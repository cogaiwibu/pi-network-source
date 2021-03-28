package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdError;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.1i  reason: invalid class name and case insensitive filesystem */
public final class C00551i {
    public static byte[] A00;
    public static String[] A01;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A01;
            if (strArr[6].charAt(12) != strArr[5].charAt(12)) {
                break;
            }
            String[] strArr2 = A01;
            strArr2[2] = "wyIfRhN1EoOdsBbK5VRzuRP5Lc7uqmgb";
            strArr2[2] = "wyIfRhN1EoOdsBbK5VRzuRP5Lc7uqmgb";
            if (i4 < length) {
                byte b = (byte) ((copyOfRange[i4] - i3) - 100);
                if (A01[0].length() == 15) {
                    break;
                }
                String[] strArr3 = A01;
                strArr3[3] = "fUzr4JaNgjTtoWHz8k6HkVts9HpSP1Qi";
                strArr3[1] = "zuQx1GaumRIGoFj6MrcQJkCLkICnzrhi";
                copyOfRange[i4] = b;
                i4++;
            } else {
                return new String(copyOfRange);
            }
        }
        throw new RuntimeException();
    }

    public static void A01() {
        A00 = new byte[]{-88, -30, -18, -25, -26};
    }

    public static void A02() {
        A01 = new String[]{"kdNZsDbIr2FjUgQ6", "G4tbE8YXKkBHtbRzjHgF1iVs8BhQX3ki", "rgsd1nh14jUfY0oEDkCzVbJlkUwrdBXO", "6d8i19T6TQ9xRiUYh6SOmARBfT83lkdi", "2FsjHYpAfMpiihTdUse", "xtyrzkpFCSmXtl0pVvZtRxgukiiALNOU", "PnjWz3Ubzat8tEiN6RTB47L4MZQANY1H", "IONaBzwOxfylvpW8Ch"};
    }

    public static void A03(C0820Wh wh, AnonymousClass16 r13, boolean z, AbstractC00531g r15) {
        if (J8.A1A(wh)) {
            r15.AAS();
            return;
        }
        AnonymousClass7H r9 = new AnonymousClass7H(wh);
        AnonymousClass1S playableAdData = r13.A0M().A0E().A06();
        r9.A0X(new JL(r13.A0Q(), wh.A06()));
        if (playableAdData == null) {
            r15.AAR(AdError.CACHE_ERROR);
            return;
        }
        AnonymousClass7G r2 = new AnonymousClass7G(playableAdData.A0F(), r13.A0U(), r13.A0T());
        r2.A04 = true;
        if (J8.A17(wh)) {
            if (A01[2].charAt(7) != '1') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[0] = "84TqyqDRqUmJCVM8";
            strArr[0] = "84TqyqDRqUmJCVM8";
            r2.A03 = A00(0, 5, 22);
        }
        int i = C00521f.A00[playableAdData.A0A().ordinal()];
        if (i == 1 || i == 2) {
            r9.A0T(r2);
        }
        r9.A0R(new AnonymousClass7E(r13.A0O().A01(), -1, -1, r13.A0U(), r13.A0T()));
        r9.A0R(new AnonymousClass7E(playableAdData.A0E(), -1, -1, r13.A0U(), r13.A0T()));
        r9.A0Q(new RW(wh, r15, r9, playableAdData, z, null), new AnonymousClass7A(r13.A0U(), r13.A0T()));
    }
}
