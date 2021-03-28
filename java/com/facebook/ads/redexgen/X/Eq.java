package com.facebook.ads.redexgen.X;

import com.facebook.ads.RewardData;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.Arrays;
import java.util.Map;

public final class Eq extends AbstractC0690Re {
    public static byte[] A00;
    public static String[] A01;

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A01;
            if (strArr[7].charAt(30) != strArr[6].charAt(30)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[1] = "Dg0tZg7IxBj4D2AEunqK4FRxjbaI0pzK";
            strArr2[4] = "5sVR5Q40j80Tm4EH72ZLdFDAQDj0jOHn";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 112);
            i4++;
        }
    }

    public static void A02() {
        A00 = new byte[]{-11, -13, 0, -78, 1, 0, -2, 11, -78, 5, -9, 6, -78, 1, 0, -78, 4, -9, 9, -13, 4, -10, -9, -10, -78, 8, -5, -10, -9, 1, -78, -13, -10, 5, -15, -14, -93, -28, -25, -28, -13, -9, -24, -11, -93, -11, -24, -28, -25, -4, -93, -9, -14, -93, -10, -24, -9, -93, -11, -24, -6, -28, -11, -25, -93, -14, -15};
    }

    public static void A03() {
        A01 = new String[]{"QPajxPBXawZguZvIACdyFqOYUKJhGG1P", "5fhxQ1wmDDZwcYW6vVZtBFGAbpCppeaF", "0C8PIOmzvjBgpmOh8JUWA", "4kKOVZ4CcWBKVljagfvAN2XyBryastSO", "Oy7EzKzQwTS7e9udIDBq4FtqglrDvqBF", "BZaaKRqUw", "6zOS7wuF6dlGz7u6SsHniaRnv53e8kon", "jwUp8OtoUlvjJY1bP74aKb8UsU7a0Ko9"};
    }

    public Eq(C0820Wh wh, C00571k r2) {
        super(wh, r2);
    }

    private AnonymousClass12 A00(Runnable runnable) {
        return new C0698Rm(this, runnable);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0690Re
    public final void A0N() {
        RM rm = (RM) this.A02;
        rm.A00(this.A08.A00);
        rm.A0C();
    }

    /* JADX INFO: Multiple debug info for r3v0 com.facebook.ads.redexgen.X.Rl: [D('adapter' com.facebook.ads.redexgen.X.Ex), D('rewardedVideoTimeout' java.lang.Runnable)] */
    @Override // com.facebook.ads.redexgen.X.AbstractC0690Re
    public final void A0Q(AbstractC00340n r12, AnonymousClass90 r13, C02408y r14, Map<String, Object> map) {
        C0381Ex ex = (C0381Ex) r12;
        Runnable rewardedVideoTimeout = new C0697Rl(this, map, ex);
        if (J8.A1P(this.A0C)) {
            A0G().postDelayed(rewardedVideoTimeout, (long) r13.A05().A05());
        }
        ex.A0D(this.A0C, A00(rewardedVideoTimeout), map, this.A08.A05, this.A08.A03, this.A08.A04);
    }

    public final void A0Y(RewardData rewardData) {
        if (this.A02 == null) {
            throw new IllegalStateException(A01(34, 33, 19));
        } else if (this.A02.A6i() == AdPlacementType.REWARDED_VIDEO) {
            ((RM) this.A02).A01(rewardData);
        } else {
            throw new IllegalStateException(A01(0, 34, 34));
        }
    }
}
