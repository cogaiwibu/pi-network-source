package com.tapjoy.internal;

public final class cj {
    private final String[] a = new String[512];

    public final String a(char[] cArr, int i, int i2) {
        boolean z = false;
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 = (i3 * 31) + cArr[i4];
        }
        int i5 = ((i3 >>> 20) ^ (i3 >>> 12)) ^ i3;
        String[] strArr = this.a;
        int length = (i5 ^ ((i5 >>> 7) ^ (i5 >>> 4))) & (strArr.length - 1);
        String str = strArr[length];
        if (str != null) {
            if (str.length() == i2) {
                int i6 = 0;
                while (true) {
                    if (i6 >= i2) {
                        z = true;
                        break;
                    } else if (cArr[i + i6] != str.charAt(i6)) {
                        break;
                    } else {
                        i6++;
                    }
                }
            }
            if (z) {
                return str;
            }
        }
        String str2 = new String(cArr, i, i2);
        this.a[length] = str2;
        return str2;
    }
}
