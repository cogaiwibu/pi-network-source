package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.io.File;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.facebook.ads.redexgen.X.b2  reason: case insensitive filesystem */
public final class C0976b2 extends C0449Hp {
    public static byte[] A00;
    public static final Pattern A01 = Pattern.compile(A06(8, 29, 107), 32);
    public static final Pattern A02 = Pattern.compile(A06(37, 29, 39), 32);
    public static final Pattern A03 = Pattern.compile(A06(66, 30, 25), 32);

    public static String A06(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 18);
        }
        return new String(copyOfRange);
    }

    public static void A07() {
        A00 = new byte[]{120, 86, 14, 75, 86, 29, 0, 23, 39, 81, 87, 82, 80, 37, 87, 81, 37, 29, 82, 80, 37, 87, 81, 37, 29, 82, 80, 37, 87, 15, 72, 37, 87, 28, 1, 22, 93, 107, 29, 27, 30, 28, 105, 27, 29, 105, 81, 30, 28, 105, 27, 29, 105, 81, 30, 28, 105, 27, 67, 7, 105, 27, 80, 77, 90, 17, 85, 35, 87, 111, 32, 34, 87, 37, 35, 87, 111, 32, 34, 87, 37, 35, 87, 111, 32, 34, 87, 37, 125, 56, 87, 37, 110, 115, 100, 47};
    }

    static {
        A07();
    }

    public C0976b2(String str, long j, long j2, long j3, @Nullable File file) {
        super(str, j, j2, j3, file);
    }

    /* JADX INFO: Multiple debug info for r0v7 int: [D('matcher' java.util.regex.Matcher), D('id' int)] */
    @Nullable
    public static C0976b2 A00(File file, C0453Ht ht) {
        String name = file.getName();
        if (!name.endsWith(A06(1, 7, 106))) {
            file = A05(file, ht);
            if (file == null) {
                return null;
            }
            name = file.getName();
        }
        Matcher matcher = A03.matcher(name);
        if (!matcher.matches()) {
            return null;
        }
        long length = file.length();
        String A0D = ht.A0D(Integer.parseInt(matcher.group(1)));
        if (A0D == null) {
            return null;
        }
        return new C0976b2(A0D, Long.parseLong(matcher.group(2)), length, Long.parseLong(matcher.group(3)), file);
    }

    public static C0976b2 A01(String str, long j) {
        return new C0976b2(str, j, -1, -9223372036854775807L, null);
    }

    public static C0976b2 A02(String str, long j) {
        return new C0976b2(str, j, -1, -9223372036854775807L, null);
    }

    public static C0976b2 A03(String str, long j, long j2) {
        return new C0976b2(str, j, j2, -9223372036854775807L, null);
    }

    public static File A04(File file, int i, long j, long j2) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        String A06 = A06(0, 1, 68);
        sb.append(A06);
        sb.append(j);
        sb.append(A06);
        sb.append(j2);
        sb.append(A06(1, 7, 106));
        return new File(file, sb.toString());
    }

    @Nullable
    public static File A05(File file, C0453Ht ht) {
        String str;
        String name = file.getName();
        Matcher matcher = A02.matcher(name);
        if (matcher.matches()) {
            str = C0466Ig.A0O(matcher.group(1));
            if (str == null) {
                return null;
            }
        } else {
            matcher = A01.matcher(name);
            if (!matcher.matches()) {
                return null;
            }
            str = matcher.group(1);
        }
        File A04 = A04(file.getParentFile(), ht.A09(str), Long.parseLong(matcher.group(2)), Long.parseLong(matcher.group(3)));
        if (!file.renameTo(A04)) {
            return null;
        }
        return A04;
    }

    public final C0976b2 A08(int i) {
        I1.A04(this.A05);
        long now = System.currentTimeMillis();
        return new C0976b2(this.A04, this.A02, this.A01, now, A04(this.A03.getParentFile(), i, this.A02, now));
    }
}
