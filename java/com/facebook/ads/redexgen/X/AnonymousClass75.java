package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX WARN: Init of enum A04 can be incorrect */
/* renamed from: com.facebook.ads.redexgen.X.75  reason: invalid class name */
public enum AnonymousClass75 {
    A06(A00(8, 7, 115)),
    A05(A00(3, 5, 19)),
    A04(r0);
    
    public static byte[] A01;
    public static String[] A02;
    public String A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A02[0].length() != 29) {
                String[] strArr = A02;
                strArr[1] = "";
                strArr[1] = "";
                if (i4 >= length) {
                    return new String(copyOfRange);
                }
                copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 17);
                i4++;
            } else {
                throw new RuntimeException();
            }
        }
    }

    public static void A01() {
        A01 = new byte[]{61, 52, 69, 81, 74, 67, 47, 51, 49, 42, 35, 79, 80, 87, 84, 36, 63, 54, 70, 25, 2, 11, 120, ByteCompanionObject.MAX_VALUE, 124};
    }

    public static void A02() {
        A02 = new String[]{"fU4XiUh", "4ASLCGhodwv3fY7yqE", "BFhkWaiQLcBXUQO4Yi7KFwSjCE1nMNEL", "IBfibZ8IWoONy44J9jH8jZ0p3ibNlB3T", "FmTm3wR2K52Lz7zbwKhVmki4cB", "JxTEYV1Vluo7DhPyeTARHiExSqxbiuYf", "t7Mb3YBBhyhswQ5hXIhgNczDQ93Q9bzO", "oX4F1jUgCDnefIZx9v8TRjWfCJBhCFOT"};
    }

    /* access modifiers changed from: public */
    static {
        A02();
        A01();
        A00(0, 3, 97);
    }

    /* access modifiers changed from: public */
    AnonymousClass75(String str) {
        this.A00 = str;
    }

    public final String A03() {
        return this.A00;
    }
}
