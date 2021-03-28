package com.facebook.ads.redexgen.X;

import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.facebook.ads.redexgen.X.2k  reason: invalid class name and case insensitive filesystem */
public final class C00832k extends AbstractC0290Ax {
    public static byte[] A01;
    public static String[] A02;
    public static final Pattern A03 = Pattern.compile(A02(80, 76, 14));
    public final StringBuilder A00 = new StringBuilder();

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 61);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A01 = new byte[]{46, 112, 96, 44, 78, 118, 116, 109, 109, 116, 115, 122, 61, 116, 115, 107, 124, 113, 116, 121, 61, 116, 115, 121, 120, 101, 39, 61, 40, 16, 18, 11, 11, 18, 21, 28, 91, 18, 21, 13, 26, 23, 18, 31, 91, 15, 18, 22, 18, 21, 28, 65, 91, 59, 29, 10, 26, 1, 24, 44, 13, 11, 7, 12, 13, 26, 14, 53, 62, 35, 43, 62, 56, 47, 62, 63, 123, 62, 53, 63, 111, 64, 25, 27, 27, 12, 9, 27, 111, 87, 24, 26, 9, 26, 12, 27, 111, 87, 24, 26, 9, 27, 111, 87, 24, 26, 31, 27, 111, 87, 24, 26, 26, 111, 64, 25, 30, 30, 13, 111, 64, 25, 27, 27, 12, 9, 27, 111, 87, 24, 26, 9, 26, 12, 27, 111, 87, 24, 26, 9, 27, 111, 87, 24, 26, 31, 27, 111, 87, 24, 26, 26, 12, 111, 64, 25};
    }

    public static void A04() {
        A02 = new String[]{"3MOBlr", "0DhiPEnslefQ61m7AjWKH0Dx7dIlVLH6", "rp7TRUp2Utk2Kzh0KXhj1OM3FBWO", "kN44IufTXn3JrEQj4nNHg0bfvC0oTmjD", "OifCwo2rldbue0L51wUPSBWzKiQKf6dm", "cz3ck9zx8XU8dqptbmXcRQWSnweik5k", "6fY6w3uzibwvfWVjzeUSGJKNywar3ei2", "sygTD4E3XWLeExwvPEtpnqdNQjJK5lOm"};
    }

    static {
        A04();
        A03();
    }

    public C00832k() {
        super(A02(53, 13, 85));
    }

    public static long A00(Matcher matcher, int i) {
        return 1000 * ((Long.parseLong(matcher.group(i + 1)) * 60 * 60 * 1000) + (Long.parseLong(matcher.group(i + 2)) * 60 * 1000) + (Long.parseLong(matcher.group(i + 3)) * 1000) + Long.parseLong(matcher.group(i + 4)));
    }

    /* access modifiers changed from: private */
    /* renamed from: A01 */
    public final C0931aI A0d(byte[] bArr, int i, boolean z) {
        String A022 = A02(53, 13, 85);
        ArrayList arrayList = new ArrayList();
        IG ig = new IG();
        IQ iq = new IQ(bArr, i);
        while (true) {
            String A0Q = iq.A0Q();
            if (A0Q == null) {
                break;
            } else if (A0Q.length() != 0) {
                try {
                    Integer.parseInt(A0Q);
                    boolean z2 = false;
                    String A0Q2 = iq.A0Q();
                    if (A0Q2 == null) {
                        Log.w(A022, A02(66, 14, 102));
                        break;
                    }
                    Matcher matcher = A03.matcher(A0Q2);
                    if (!matcher.matches()) {
                        Log.w(A022, A02(28, 25, 70) + A0Q2);
                    } else if (A02[2].length() != 5) {
                        String[] strArr = A02;
                        strArr[5] = "w8SSp6GDTl1u71HT2BYG3nb3Lg3oTFs";
                        strArr[5] = "w8SSp6GDTl1u71HT2BYG3nb3Lg3oTFs";
                        ig.A04(A00(matcher, 1));
                        if (!TextUtils.isEmpty(matcher.group(6))) {
                            z2 = true;
                            ig.A04(A00(matcher, 6));
                        }
                        this.A00.setLength(0);
                        while (true) {
                            String A0Q3 = iq.A0Q();
                            if (TextUtils.isEmpty(A0Q3)) {
                                break;
                            }
                            if (this.A00.length() > 0) {
                                this.A00.append(A02(0, 4, 47));
                            }
                            this.A00.append(A0Q3.trim());
                        }
                        arrayList.add(new GF(Html.fromHtml(this.A00.toString())));
                        if (z2) {
                            arrayList.add(null);
                        }
                    } else {
                        throw new RuntimeException();
                    }
                } catch (NumberFormatException unused) {
                    Log.w(A022, A02(4, 24, 32) + A0Q);
                }
            }
        }
        GF[] gfArr = new GF[arrayList.size()];
        arrayList.toArray(gfArr);
        return new C0931aI(gfArr, ig.A05());
    }
}
