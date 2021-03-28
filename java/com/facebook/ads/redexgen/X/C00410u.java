package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.anythink.reactnativejs.utils.Const;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.0u  reason: invalid class name and case insensitive filesystem */
public final class C00410u {
    public static C00400t A00;
    public static AnonymousClass8H A01;
    @Nullable
    public static String A02;
    public static CountDownLatch A03 = new CountDownLatch(1);
    public static CountDownLatch A04 = new CountDownLatch(1);
    public static boolean A05;
    public static byte[] A06;
    public static String[] A07;
    public static final String A08 = C00410u.class.getSimpleName();

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 69);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        byte[] bArr = {114, 115, 97, 10, 31, 123, 125, 3, 6, 17, 33, 3, 18, 18, 11, 12, 5, 43, 12, 4, 13, 76, 22, 26, 22, 32, 34, 51, 51, 38, 39, 2, 39, 48, 109, 55, 59, 55, 13, 25, 14, 26, 30, 14, 5, 8, 18, 52, 8, 10, 27, 27, 2, 5, 12};
        if (A07[0].charAt(25) != 's') {
            String[] strArr = A07;
            strArr[6] = "ekiMbk44dvQ4iEpOly1MsU0Tkyq5eij5";
            strArr[6] = "ekiMbk44dvQ4iEpOly1MsU0Tkyq5eij5";
            A06 = bArr;
            return;
        }
        throw new RuntimeException();
    }

    public static void A05() {
        A07 = new String[]{"TOlR5WIHpQxnCrBDCJGIvboS5c1GP2eb", "1A072KPTjzB", "BhIKZU0mEosMUOfZes2VT64q11XJ2Uhn", "3eQHzZddeWPmYl0bNsvnb2WjxREMTE8a", Const.X, "3ukMDhdDleVgfGP2GHVzNRiRwZbG92ZS", "tXOxwX9vQ8QECIpzr41AiGeD6LbiHgO3", "feL0RS1gsJrC9VyxtC"};
    }

    static {
        A05();
        A04();
    }

    public static String A00() {
        C00400t r0 = A00;
        return r0 != null ? r0.A03() : A01(5, 2, 101);
    }

    public static String A02(String str) {
        String A012 = A01(38, 17, 46);
        File file = new File(A01.getFilesDir(), str);
        String A013 = A01(0, 0, 103);
        if (!file.exists() || file.length() <= 0) {
            return A013;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[((int) file.length())];
            fileInputStream.read(bArr);
            fileInputStream.close();
            return new String(bArr, A01(0, 5, 98));
        } catch (FileNotFoundException e) {
            A01.A04().A82(A012, C02248i.A0t, new C02258j(e));
            return A013;
        } catch (IOException e2) {
            A01.A04().A82(A012, C02248i.A0u, new C02258j(e2));
            return A013;
        }
    }

    public static void A03() {
        if (A0I() && A02 != null) {
            ExecutorC0540Lj.A06.execute(new RB(A02));
        }
    }

    public static synchronized void A08() {
        synchronized (C00410u.class) {
            A0F(A01(7, 18, 39));
            A0F(A01(25, 13, 6));
        }
    }

    public static synchronized void A09() {
        synchronized (C00410u.class) {
            try {
                A00.A08(A02(A01(25, 13, 6)));
                A00.A06(A02(A01(7, 18, 39)));
            } catch (JSONException e) {
                A08();
                A01.A04().A82(A01(38, 17, 46), C02248i.A0v, new C02258j(e));
            }
        }
        return;
    }

    public static synchronized void A0A() {
        synchronized (C00410u.class) {
            A0G(A01(25, 13, 6), A00().getBytes());
            A0G(A01(7, 18, 39), A00.A04().toString().getBytes());
        }
    }

    public static synchronized void A0C(AnonymousClass1K r2, String str, boolean z) {
        synchronized (C00410u.class) {
            r2.A07(z);
            if (r2.A08() || r2.A09()) {
                A00.A07(str);
            } else {
                A00.A09(str);
            }
        }
    }

    public static synchronized void A0D(AnonymousClass8H r3) {
        synchronized (C00410u.class) {
            A01 = r3;
            A02 = null;
            ExecutorC0540Lj.A06.execute(new R8());
        }
    }

    public static void A0E(String str) {
        if (A0I()) {
            A02 = str;
            ExecutorC0540Lj.A06.execute(new RA(str));
        }
    }

    public static void A0F(String str) {
        File file = new File(A01.getFilesDir(), str);
        if (file.exists()) {
            file.delete();
        }
    }

    public static synchronized void A0G(String str, byte[] bArr) {
        synchronized (C00410u.class) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(A01.getFilesDir(), str));
                fileOutputStream.write(bArr);
                fileOutputStream.close();
            } catch (FileNotFoundException e) {
                A01.A04().A82(A01(38, 17, 46), C02248i.A0t, new C02258j(e));
            } catch (IOException e2) {
                A01.A04().A82(A01(38, 17, 46), C02248i.A0u, new C02258j(e2));
            }
        }
    }

    public static void A0H(JSONObject jSONObject) {
        A05 = J8.A0r(A01);
        if (A05) {
            ExecutorC0540Lj.A06.execute(new R9(jSONObject));
        }
    }

    public static boolean A0I() {
        return A05;
    }

    public static boolean A0J(String str) {
        boolean z = false;
        try {
            z = A00.A04().get(str) instanceof AnonymousClass1K;
            return z;
        } catch (JSONException e) {
            A01.A04().A82(A01(38, 17, 46), C02248i.A0v, new C02258j(e));
            return z;
        }
    }
}
