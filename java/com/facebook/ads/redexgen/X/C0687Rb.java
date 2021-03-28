package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Rb  reason: case insensitive filesystem */
public class C0687Rb extends AbstractRunnableC0510Kc {
    public static byte[] A02;
    public static String[] A03;
    public final /* synthetic */ AbstractC0690Re A00;
    public final /* synthetic */ C0944aV A01;

    static {
        A03();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A03;
            if (strArr[4].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[0] = "oScLyKWb3fn2oYJPJdX8D34ZjyUzRvxz";
            strArr2[3] = "G9gk2wDsh72JfZvDy2Lys6UEtMP3Y1SB";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 84);
            i4++;
        }
    }

    public static void A01() {
        A02 = new byte[]{51, 52, 44, 59, 54, 51, 62, 122, 42, 54, 59, 57, 63, 55, 63, 52, 46, 122, 51, 52, 122, 40, 63, 41, 42, 53, 52, 41, 63};
    }

    public static void A03() {
        A03 = new String[]{"rcAoHT8yzEEoCxFmEfFHXcUl0vjpGdgY", "LSTuq6Bu4IKsOuvOF", "N9ND8qL7XSSd32I", "yk3W1HvskfBH2x0X91qy9qW3VKhe7rxg", "6nHANpKnXNhaq6nYT", "xMxpxuwRsi8wtxmAob8T1Ch5JVdvxyTv", "", "PgJ"};
    }

    public C0687Rb(AbstractC0690Re re, C0944aV aVVar) {
        this.A00 = re;
        this.A01 = aVVar;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0510Kc
    public final void A07() {
        AnonymousClass90 A002 = this.A01.A00();
        if (A002 == null || A002.A05() == null) {
            String A003 = A00(0, 29, 14);
            C0495Jm jm = new C0495Jm(AdErrorType.NO_AD_PLACEMENT, A003);
            this.A00.A0C.A0A().A4Y(jm.A04().getErrorCode(), A003);
            this.A00.A07.A0F(jm);
            return;
        }
        this.A00.A05 = A002;
        this.A00.A0O();
    }
}
