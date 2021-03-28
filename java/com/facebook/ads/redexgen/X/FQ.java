package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Arrays;

public class FQ extends R3<AnonymousClass0R> {
    public static byte[] A00;
    public static String[] A01;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            byte b = (byte) ((copyOfRange[i4] ^ i3) ^ 53);
            String[] strArr = A01;
            if (strArr[6].charAt(28) != strArr[4].charAt(28)) {
                String[] strArr2 = A01;
                strArr2[6] = "RdAktgh8TRx4T7uGZoOvXD5Nm8OQ26SP";
                strArr2[4] = "NAulEfMGB5fp7nDMqJdUUmABB5JXpKUM";
                copyOfRange[i4] = b;
            } else {
                throw new RuntimeException();
            }
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{17, 10, 19, 19};
    }

    public static void A02() {
        A01 = new String[]{"jR7SgdIzlKHk76CXDj7yskV4BbEyGCpu", "dz14xHNKN2eKa", "osoaj0nOm4U0DksUsx9ydi6yveTqdDmo", "CW4NBbEoC8f", "oKML8tkCm175rZI2zBYjmvrxKy9flX2h", "0JuTJ32H1trbcwgA0tUu0T5MtnfghwR4", "xx3SSYxbJNPIpDYr1BHpXDm7lAtLM5T8", "wtTCE0DbZnhIRkOUKlXj85m9jjBjTzDL"};
    }

    public FQ(String str) {
        super(str);
    }

    /* renamed from: A07 */
    public final AnonymousClass0X A06(@Nullable AnonymousClass0R r6) {
        String str;
        if (r6 == null) {
            str = A00(0, 4, 74);
        } else {
            str = A00(0, 0, 56) + r6.A03();
        }
        AnonymousClass0X r4 = new AnonymousClass0X(this, str);
        if (A01[7].length() != 29) {
            String[] strArr = A01;
            strArr[3] = "ciTvicHW32i";
            strArr[1] = "sW1NMqe52ANNy";
            return r4;
        }
        throw new RuntimeException();
    }
}
