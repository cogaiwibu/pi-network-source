package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import android.os.SystemClock;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

public final class VA extends AnonymousClass6Z {
    public static byte[] A00;
    public static String[] A01;
    public static final String A02 = VA.class.getSimpleName();

    public static String A05(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 55);
        }
        return new String(copyOfRange);
    }

    public static void A09() {
        A00 = new byte[]{73, 91, 95, 74, 41, 75, 14, 119, 106, 102, 109, 97, 118, 12, 47, 24, 24, 5, 24, 74, 8, 31, 3, 6, 14, 3, 4, 13, 74, 12, 3, 6, 15, 74, 37, 8, 0, 15, 9, 30, 47, 30, 13, 12, 26, 95, 58, 17, 9, 95, 41, 30, 13, 22, 30, 29, 19, 26};
    }

    public static void A0A() {
        A01 = new String[]{"y8Nq67FtAwLOnhnq1UqleBVuRpU5lwEq", "kKy3QSHCMFgMLI4jLKgpj6Ml3G5G", "CtFK8Pc2dFCHV68GnB3BGsunpwsbXZLI", "F24bvZCYxJ", "TOSHYJ1lEJvd7RJrf6C3asPns89jgyAB", "1i4XZgSUiEitKg1uirtbWyvJYEy72451", "xxTjtjFBsKHKUg72VLV3KyKqm", "tv2qbFeBoe5tOdCVBoBS0k7Q0eg7h6FY"};
    }

    static {
        A0A();
        A09();
    }

    public VA(Context context, C01725z r2) {
        super(context, r2);
    }

    /* access modifiers changed from: private */
    @SuppressLint({"Nullable Dereference"})
    public AbstractC01966x A02(HashMap<String, V9> hashMap) {
        return new WY(SystemClock.elapsedRealtime(), A03(), hashMap, EnumC01956w.A0C);
    }

    @Nullable
    @SuppressLint({"CatchGeneralException", "BadMethodUse-android.util.Log.e"})
    public static File A03(String str) {
        try {
            return new File(str.substring(0, str.lastIndexOf(File.separator)), str.substring(str.lastIndexOf(File.separator) + 1));
        } catch (Exception e) {
            Log.e(A02, A05(14, 26, 93), e);
            return null;
        }
    }

    public static String A06(String str) {
        char c;
        if (str.hashCode() == 902502675 && str.equals(A05(6, 8, 5))) {
            c = 0;
        } else {
            c = 65535;
        }
        if (c == 0) {
            return Environment.getExternalStorageDirectory().toString();
        }
        String A05 = A05(0, 0, 28);
        if (A01[0].charAt(3) != 'q') {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[1] = "jdgM3VinY7vKBuJQR961ULiFKj7S";
        strArr[3] = "O0JYmDhqre";
        return A05;
    }

    /* JADX INFO: Multiple debug info for r0v7 java.lang.String: [D('matchedPattern' java.lang.String), D('matcher' java.util.regex.Matcher)] */
    @SuppressLint({"BadMethodUse-android.util.Log.e"})
    public static String A07(String regex) {
        String A05 = A05(0, 6, 66);
        StringBuffer stringBuffer = new StringBuffer();
        Matcher matcher = Pattern.compile(A05).matcher(regex);
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, A06(matcher.group()));
        }
        matcher.appendTail(stringBuffer);
        String regex2 = stringBuffer.toString();
        try {
            regex2 = new File(regex2).getCanonicalPath();
            return regex2;
        } catch (IOException e) {
            Log.e(A02, A05(40, 18, 72), e);
            return regex2;
        }
    }

    public final AbstractC01816i A0H(List<C01806h> list) {
        return new V8(this, list);
    }
}
