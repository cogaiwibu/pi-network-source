package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.facebook.ads.redexgen.X.Gk  reason: case insensitive filesystem */
public final class C0418Gk {
    public static byte[] A02;
    public static String[] A03;
    public static final Pattern A04 = Pattern.compile(A01(11, 19, 40));
    public final IQ A00 = new IQ();
    public final StringBuilder A01 = new StringBuilder();

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A03[3].length() != 12) {
                String[] strArr = A03;
                strArr[1] = "WbeGi2EdgzwyYonzf4wPzmwNCcWtg9MW";
                strArr[6] = "HcL7UN1N9oazqVf2QAldqbU1hHC9CZ0b";
                if (i4 >= length) {
                    return new String(copyOfRange);
                }
                byte b = copyOfRange[i4];
                String[] strArr2 = A03;
                if (strArr2[7].length() != strArr2[0].length()) {
                    String[] strArr3 = A03;
                    strArr3[4] = "JF2Fp1R2vbvas833wDrB0";
                    strArr3[5] = "";
                    copyOfRange[i4] = (byte) ((b - i3) - 66);
                    i4 += 0;
                } else {
                    String[] strArr4 = A03;
                    strArr4[1] = "nmNaQjGJyPE7mmPpZpQG0xjHlUJrvUW4";
                    strArr4[6] = "jsP66PUWr33y4hLthtnL6xZSYxJtrhjf";
                    copyOfRange[i4] = (byte) ((b - i3) - 86);
                    i4++;
                }
            } else {
                throw new RuntimeException();
            }
        }
    }

    public static void A07() {
        A02 = new byte[]{-10, -76, -18, -81, -81, -40, -22, -38, -9, 12, -34, -38, -39, -12, -19, -25, -31, -29, -69, -96, -90, -39, -36, -96, -37, -88, -89, -96, -38, -37, 13, 12, 14, 22, 18, 29, 26, 32, 25, 15, -40, 14, 26, 23, 26, 29, -72, -59, -62, -70, 53, 65, 62, 65, 68, 33, 42, 41, 47, -24, 33, 28, 40, 36, 39, 52, -36, -27, -28, -22, -93, -23, -22, -17, -30, -37, -31, -22, -23, -17, -88, -14, -32, -28, -30, -29, -17, -15, -4, -23, -12, -15, -21, -5, -20, -1, -5, -76, -21, -20, -22, -10, -7, -24, -5, -16, -10, -11, 58, 51, 41, 42, 55, 49, 46, 51, 42, -34, -17};
    }

    public static void A08() {
        A03 = new String[]{"5moU6oTWlMaw1sDVAQ0KQ9vMfu", "p49r3ReMaXkyq3mZFz3vXo8SK9LaCwKA", "zB3eTtV", "qmKjW68jdxdUPQHo", "qXdLPSjDEI4OIDX4GQuIV", "", "iFy7tRn7HMov4f4CYUKnyhY2lj6xewaE", "7WU313Gqg3541KnskWJgurkNM7"};
    }

    static {
        A08();
        A07();
    }

    public static char A00(IQ iq, int i) {
        return (char) iq.A00[i];
    }

    public static String A02(IQ iq) {
        int limit = iq.A07();
        int A08 = iq.A08();
        int position = 0;
        while (limit < A08 && position == 0) {
            int i = limit + 1;
            if (((char) iq.A00[limit]) == 41) {
                position = 1;
            } else {
                position = 0;
            }
            limit = i;
        }
        return iq.A0T((limit - 1) - iq.A07()).trim();
    }

    public static String A03(IQ iq, StringBuilder sb) {
        sb.setLength(0);
        int A07 = iq.A07();
        int A08 = iq.A08();
        boolean z = false;
        while (A07 < A08 && !z) {
            char c = (char) iq.A00[A07];
            if ((c < 'A' || c > 'Z') && ((c < 'a' || c > 'z') && !((c >= '0' && c <= '9') || c == '#' || c == '-' || c == '.' || c == '_'))) {
                z = true;
            } else {
                A07++;
                sb.append(c);
            }
        }
        iq.A0a(A07 - iq.A07());
        return sb.toString();
    }

    public static String A04(IQ iq, StringBuilder sb) {
        A0B(iq);
        if (iq.A05() == 0) {
            return null;
        }
        String A032 = A03(iq, sb);
        String A012 = A01(0, 0, 21);
        if (!A012.equals(A032)) {
            return A032;
        }
        return A012 + ((char) iq.A0F());
    }

    public static String A05(IQ iq, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        boolean z = false;
        while (!z) {
            int A07 = iq.A07();
            String A042 = A04(iq, sb);
            if (A042 == null) {
                return null;
            }
            if (A01(118, 1, 28).equals(A042) || A01(8, 1, 102).equals(A042)) {
                iq.A0Z(A07);
                z = true;
            } else {
                sb2.append(A042);
            }
        }
        String sb3 = sb2.toString();
        String[] strArr = A03;
        if (strArr[7].length() != strArr[0].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A03;
        strArr2[2] = "Zajsfk5";
        strArr2[2] = "Zajsfk5";
        return sb3;
    }

    public static String A06(IQ iq, StringBuilder sb) {
        A0B(iq);
        if (iq.A05() < 5) {
            return null;
        }
        if (!A01(3, 5, 31).equals(iq.A0T(5))) {
            return null;
        }
        int A07 = iq.A07();
        String A042 = A04(iq, sb);
        if (A042 == null) {
            return null;
        }
        if (A01(117, 1, 13).equals(A042)) {
            iq.A0Z(A07);
            return A01(0, 0, 21);
        }
        String str = null;
        if (A01(0, 1, 120).equals(A042)) {
            str = A02(iq);
        }
        String A043 = A04(iq, sb);
        if (!A01(1, 1, 53).equals(A043) || A043 == null) {
            return null;
        }
        return str;
    }

    private void A09(C0422Go go, String str) {
        if (!A01(0, 0, 21).equals(str)) {
            int indexOf = str.indexOf(91);
            if (indexOf != -1) {
                Pattern pattern = A04;
                String[] strArr = A03;
                if (strArr[4].length() != strArr[5].length()) {
                    String[] strArr2 = A03;
                    strArr2[7] = "I8JZnIR9egwAM0HwkjEQFl8l1n";
                    strArr2[0] = "OMVURqNL7mUYh9I5H6Apgp30fA";
                    Matcher matcher = pattern.matcher(str.substring(indexOf));
                    if (matcher.matches()) {
                        go.A0L(matcher.group(1));
                    }
                    str = str.substring(0, indexOf);
                } else {
                    throw new RuntimeException();
                }
            }
            String[] A0m = C0466Ig.A0m(str, A01(9, 2, 90));
            String str2 = A0m[0];
            int indexOf2 = str2.indexOf(35);
            if (indexOf2 != -1) {
                go.A0K(str2.substring(0, indexOf2));
                go.A0J(str2.substring(indexOf2 + 1));
            } else {
                go.A0K(str2);
            }
            if (A0m.length > 1) {
                go.A0M((String[]) Arrays.copyOfRange(A0m, 1, A0m.length));
            }
        }
    }

    public static void A0A(IQ iq) {
        do {
        } while (!TextUtils.isEmpty(iq.A0Q()));
    }

    public static void A0B(IQ iq) {
        boolean z = true;
        while (iq.A05() > 0 && z) {
            if (!A0E(iq)) {
                boolean A0D = A0D(iq);
                String[] strArr = A03;
                if (strArr[4].length() != strArr[5].length()) {
                    String[] strArr2 = A03;
                    strArr2[7] = "hJK3qjOtPloIxgY8vJytqI0HGH";
                    strArr2[0] = "GkPADoSnbvIPHM1na4c3lEMD25";
                    if (!A0D) {
                        z = false;
                    }
                } else {
                    throw new RuntimeException();
                }
            }
            z = true;
        }
    }

    public static void A0C(IQ iq, C0422Go go, StringBuilder sb) {
        A0B(iq);
        String token = A03(iq, sb);
        String A012 = A01(0, 0, 21);
        if (!A012.equals(token)) {
            if (A01(2, 1, 94).equals(A04(iq, sb))) {
                A0B(iq);
                String A05 = A05(iq, sb);
                if (A05 != null && !A012.equals(A05)) {
                    int A07 = iq.A07();
                    String A042 = A04(iq, sb);
                    if (!A01(8, 1, 102).equals(A042)) {
                        if (A01(118, 1, 28).equals(A042)) {
                            iq.A0Z(A07);
                        } else {
                            return;
                        }
                    }
                    if (A01(50, 5, 124).equals(token)) {
                        go.A0D(I6.A02(A05));
                    } else if (A01(30, 16, 85).equals(token)) {
                        go.A0C(I6.A02(A05));
                    } else if (A01(93, 15, 49).equals(token)) {
                        if (A01(108, 9, 111).equals(A05)) {
                            go.A0H(true);
                        }
                    } else if (A01(55, 11, 101).equals(token)) {
                        go.A0E(A05);
                    } else if (A01(76, 11, 37).equals(token)) {
                        if (A01(46, 4, 0).equals(A05)) {
                            go.A0F(true);
                        }
                    } else if (A01(66, 10, 32).equals(token) && A01(87, 6, 50).equals(A05)) {
                        go.A0G(true);
                    }
                }
            }
        }
    }

    public static boolean A0D(IQ iq) {
        int limit = iq.A07();
        int A08 = iq.A08();
        byte[] bArr = iq.A00;
        if (limit + 2 > A08) {
            return false;
        }
        int i = limit + 1;
        if (bArr[limit] != 47) {
            return false;
        }
        int limit2 = i + 1;
        if (bArr[i] != 42) {
            return false;
        }
        while (limit2 + 1 < A08) {
            int i2 = limit2 + 1;
            if (((char) bArr[limit2]) == '*' && ((char) bArr[i2]) == '/') {
                A08 = i2 + 1;
                String[] strArr = A03;
                if (strArr[4].length() != strArr[5].length()) {
                    String[] strArr2 = A03;
                    strArr2[3] = "JvQuY0ttidF2MFD";
                    strArr2[3] = "JvQuY0ttidF2MFD";
                    limit2 = A08;
                } else {
                    throw new RuntimeException();
                }
            } else {
                limit2 = i2;
            }
        }
        iq.A0a(A08 - iq.A07());
        return true;
    }

    public static boolean A0E(IQ iq) {
        char A002 = A00(iq, iq.A07());
        if (!(A002 == '\t' || A002 == '\n' || A002 == '\f' || A002 == '\r')) {
            String[] strArr = A03;
            if (strArr[1].charAt(8) != strArr[6].charAt(8)) {
                String[] strArr2 = A03;
                strArr2[2] = "XdMJqir";
                strArr2[2] = "XdMJqir";
                if (A002 != ' ') {
                    return false;
                }
            } else {
                throw new RuntimeException();
            }
        }
        iq.A0a(1);
        String[] strArr3 = A03;
        if (strArr3[1].charAt(8) != strArr3[6].charAt(8)) {
            String[] strArr4 = A03;
            strArr4[7] = "YUo1DIFuEN1uIrNP3uzwlzTLm0";
            strArr4[0] = "TeHQYLZm1GheElXx48zfUEG6q3";
            return true;
        }
        String[] strArr5 = A03;
        strArr5[3] = "JQij4b";
        strArr5[3] = "JQij4b";
        return true;
    }

    public final C0422Go A0F(IQ iq) {
        this.A01.setLength(0);
        int A07 = iq.A07();
        A0A(iq);
        this.A00.A0c(iq.A00, iq.A07());
        this.A00.A0Z(A07);
        String A06 = A06(this.A00, this.A01);
        if (A06 != null) {
            if (A01(117, 1, 13).equals(A04(this.A00, this.A01))) {
                C0422Go go = new C0422Go();
                A09(go, A06);
                String str = null;
                boolean z = false;
                while (true) {
                    String A012 = A01(118, 1, 28);
                    if (!z) {
                        IQ iq2 = this.A00;
                        if (A03[2].length() != 7) {
                            throw new RuntimeException();
                        }
                        String[] strArr = A03;
                        strArr[7] = "P2Yqf81YsUpWwfjUTZqElTDCCY";
                        strArr[0] = "xGmVLGcPrtNhIWRwMqh3QWIima";
                        int A072 = iq2.A07();
                        str = A04(this.A00, this.A01);
                        if (str == null || A012.equals(str)) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            this.A00.A0Z(A072);
                            A0C(this.A00, go, this.A01);
                        }
                    } else if (A012.equals(str)) {
                        return go;
                    } else {
                        return null;
                    }
                }
            }
        }
        return null;
    }
}
