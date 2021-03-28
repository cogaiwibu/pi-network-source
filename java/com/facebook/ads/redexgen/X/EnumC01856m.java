package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.6m  reason: invalid class name and case insensitive filesystem */
public enum EnumC01856m {
    A05(1),
    A0B(2),
    A08(4),
    A0A(8),
    A0N(16),
    A0F(32),
    A06(64),
    A0E(128),
    A0C(256),
    A0D(512),
    A0M(1024),
    A0J(2048),
    A0K(4096),
    A09(8192),
    A0I(16384),
    A0G(32768),
    A0H(65536),
    A0L(131072),
    A07(262144);
    
    public static byte[] A01;
    public static String[] A02;
    public static final Map<Integer, EnumC01856m> A03 = new HashMap();
    public int A00;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 73);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A01 = new byte[]{3, 1, 22, 11, 20, 7, 93, 82, 88, 78, 83, 85, 88, 67, 82, 93, 72, 85, 74, 89, 30, 25, 18, 21, 27, 18, 3, 8, 21, 25, 14, 37, 46, 40, 42, 34, 51, 53, 46, 36, 59, 44, 55, 61, 53, 60, 21, 20, 1, 3, 20, 18, 16, 5, 20, 21, 34, 63, 40, 39, 43, 47, 37, 69, 81, 85, 65, 76, 95, 66, 89, 95, 67, 79, 78, 84, 69, 88, 84, 29, 9, 13, 25, 20, 7, 26, 1, 7, 12, 17, 21, 29, 11, 12, 25, 21, 8, 8, 28, 24, 12, 1, 18, 15, 20, 18, 27, 12, 1, 24, 8, 110, 104, 116, 120, 105, 102, 115, 110, 113, 98, 25, 16, 16, 5, 31, 2, 19, 19, 26, 26, 15, 21, 8, 25, 3, 15, 25, 18, 15, 21, 8, 21, 10, 25, 28, 29, 0, 26, 7, 22, 7, 22, 5, 22, 25, 24, 30, 19, 8, 3, 30, 18, 5, 20, 7, 8, 2, 9, 11, 25, 21, 7, 11, 22, 10, 3, 25, 18, 15, 3, 20, 84, 66, 73, 84, 78, 83, 78, 81, 66, 20, 18, 20, 23, 14, 4, 14, 8, 18, 20, 24, 19, 14, 2, 21, 20, 6, 1};
    }

    public static void A04() {
        A02 = new String[]{"0BJ5h", "uImWw", "eQs5ApErathnGGN0d7eChKCrZd8SdVGS", "kPzS2riknK7ja7wZhtH9DjUAaupVVGy6", "IlkU", "Bv", "wT", "cW"};
    }

    /* access modifiers changed from: public */
    static {
        A04();
        A03();
        EnumC01856m[] values = values();
        for (EnumC01856m type : values) {
            A03.put(Integer.valueOf(type.A00), type);
        }
    }

    /* access modifiers changed from: public */
    EnumC01856m(int i) {
        this.A00 = i;
    }

    @Nullable
    public static EnumC01856m A00(int i) {
        if (A03.containsKey(Integer.valueOf(i))) {
            return A03.get(Integer.valueOf(i));
        }
        return null;
    }

    @SuppressLint({"BadMethodUse-android.util.Log.e", "CatchGeneralException", "EmptyCatchBlock"})
    public static EnumSet<EnumC01856m> A02(int i) throws Exception {
        EnumSet<EnumC01856m> noneOf = EnumSet.noneOf(EnumC01856m.class);
        if (i <= 0) {
            return noneOf;
        }
        EnumC01856m[] values = values();
        while (i != 0) {
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i);
            i ^= Integer.lowestOneBit(i);
            if (numberOfTrailingZeros < values.length) {
                noneOf.add(values[numberOfTrailingZeros]);
            }
        }
        return noneOf;
    }

    public final int A05() {
        return this.A00;
    }
}
