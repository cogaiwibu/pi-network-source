package com.facebook.ads.redexgen.X;

import android.os.Looper;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: com.facebook.ads.redexgen.X.4j  reason: invalid class name and case insensitive filesystem */
public final class C01314j {
    public static byte[] A00;

    static {
        A03();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 3);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{13, 72, 85, 89, 39, 107, 108, 123, 108, 106, 123, 108, 107, 65, -43, -31, -33, -96, -40, -45, -43, -41, -44, -31, -31, -35, -96, -45, -42, -27};
    }

    @Nullable
    private String A00() {
        StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (stackTraceElement.getClassName().startsWith(A01(14, 16, 111))) {
                return stackTraceElement.toString();
            }
        }
        return null;
    }

    private Map<Thread, StackTraceElement[]> A02() {
        TreeMap treeMap = new TreeMap(new C01304i(this, Looper.getMainLooper().getThread()));
        treeMap.putAll(Thread.getAllStackTraces());
        return treeMap;
    }

    /* JADX INFO: Multiple debug info for r1v4 java.lang.StackTraceElement: [D('element' java.lang.StackTraceElement), D('entry' java.util.Map$Entry<java.lang.Thread, java.lang.StackTraceElement[]>)] */
    public final String A04() {
        StringBuilder sb = new StringBuilder();
        sb.append(A01(1, 13, 4));
        sb.append(A00());
        String A01 = A01(0, 1, 0);
        sb.append(A01);
        for (Map.Entry<Thread, StackTraceElement[]> entry : A02().entrySet()) {
            sb.append(entry.getKey().getName());
            sb.append(A01);
            StackTraceElement[] value = entry.getValue();
            for (StackTraceElement element : value) {
                sb.append('\t');
                sb.append(element.toString());
                sb.append(A01);
            }
        }
        return sb.toString();
    }

    public final boolean A05() {
        return A00() != null;
    }
}
