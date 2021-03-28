package com.facebook.ads.redexgen.X;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import kotlin.UByte;

/* renamed from: com.facebook.ads.redexgen.X.2i  reason: invalid class name and case insensitive filesystem */
public final class C00812i extends AbstractC0290Ax {
    public static byte[] A07;
    public static final int A08 = C0466Ig.A08(A00(69, 4, 19));
    public static final int A09 = C0466Ig.A08(A00(73, 4, 85));
    public float A00;
    public int A01;
    public int A02;
    public int A03;
    public String A04;
    public boolean A05;
    public final IQ A06 = new IQ();

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 21);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A07 = new byte[]{120, -118, -105, -114, -117, 116, -104, 83, -121, 100, -123, -125, -113, -124, -123, -110, -67, -68, -82, -107, -103, -98, -49, -50, -64, -89, -78, 119, -112, -121, -102, -110, -121, -123, -106, -121, -122, 66, -107, -105, -124, -106, -117, -106, -114, -121, 66, -120, -111, -108, -113, -125, -106, 80, -1, -19, -6, -1, -71, -1, -15, -2, -11, -14, -93, -107, -94, -103, -106, -101, -100, -95, -108, -34, -52, -39, -30};
    }

    static {
        A02();
    }

    public C00812i(List<byte[]> list) {
        super(A00(5, 11, 11));
        A07(list);
    }

    public static String A01(IQ iq) throws GH {
        boolean z;
        char A032;
        if (iq.A05() >= 2) {
            z = true;
        } else {
            z = false;
        }
        A08(z);
        int A0J = iq.A0J();
        if (A0J == 0) {
            return A00(0, 0, 91);
        }
        if (iq.A05() < 2 || ((A032 = iq.A03()) != 65279 && A032 != 65534)) {
            return iq.A0U(A0J, Charset.forName(A00(22, 5, 101)));
        }
        return iq.A0U(A0J, Charset.forName(A00(16, 6, 83)));
    }

    public static void A03(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(((i & 255) << 24) | (i >>> 8)), i3, i4, i5 | 33);
        }
    }

    public static void A04(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        boolean z;
        boolean z2;
        if (i != i2) {
            int i6 = i5 | 33;
            boolean z3 = true;
            if ((i & 1) != 0) {
                z = true;
            } else {
                z = false;
            }
            if ((i & 2) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z) {
                if (z2) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i3, i4, i6);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i3, i4, i6);
                }
            } else if (z2) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i3, i4, i6);
            }
            if ((i & 4) == 0) {
                z3 = false;
            }
            if (z3) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i3, i4, i6);
            }
            if (!z3 && !z && !z2) {
                spannableStringBuilder.setSpan(new StyleSpan(0), i3, i4, i6);
            }
        }
    }

    public static void A05(SpannableStringBuilder spannableStringBuilder, String str, String str2, int i, int i2, int i3) {
        if (str != str2) {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), i, i2, i3 | 33);
        }
    }

    private void A06(IQ iq, SpannableStringBuilder spannableStringBuilder) throws GH {
        boolean z;
        if (iq.A05() >= 12) {
            z = true;
        } else {
            z = false;
        }
        A08(z);
        int A0J = iq.A0J();
        int end = iq.A0J();
        iq.A0a(2);
        int A0F = iq.A0F();
        iq.A0a(1);
        int A092 = iq.A09();
        A04(spannableStringBuilder, A0F, this.A03, A0J, end, 0);
        A03(spannableStringBuilder, A092, this.A02, A0J, end, 0);
    }

    private void A07(List<byte[]> list) {
        String A002 = A00(54, 10, 119);
        boolean z = false;
        if (list != null && list.size() == 1 && (list.get(0).length == 48 || list.get(0).length == 53)) {
            byte[] bArr = list.get(0);
            this.A03 = bArr[24];
            this.A02 = ((bArr[26] & UByte.MAX_VALUE) << 24) | ((bArr[27] & UByte.MAX_VALUE) << 16) | ((bArr[28] & UByte.MAX_VALUE) << 8) | (bArr[29] & UByte.MAX_VALUE);
            if (A00(0, 5, 16).equals(C0466Ig.A0R(bArr, 43, bArr.length - 43))) {
                A002 = A00(64, 5, 27);
            }
            this.A04 = A002;
            this.A01 = bArr[25] * 20;
            if ((bArr[0] & 32) != 0) {
                z = true;
            }
            this.A05 = z;
            if (this.A05) {
                this.A00 = ((float) (((bArr[10] & UByte.MAX_VALUE) << 8) | (bArr[11] & UByte.MAX_VALUE))) / ((float) this.A01);
                this.A00 = C0466Ig.A00(this.A00, 0.0f, 0.95f);
                return;
            }
            this.A00 = 0.85f;
            return;
        }
        this.A03 = 0;
        this.A02 = -1;
        this.A04 = A002;
        this.A05 = false;
        this.A00 = 0.85f;
    }

    public static void A08(boolean z) throws GH {
        if (!z) {
            throw new GH(A00(27, 27, 13));
        }
    }

    /* JADX INFO: Multiple debug info for r0v17 int: [D('styleRecordCount' int), D('requestedVerticalPlacement' int)] */
    @Override // com.facebook.ads.redexgen.X.AbstractC0290Ax
    public final GG A0d(byte[] bArr, int i, boolean z) throws GH {
        this.A06.A0c(bArr, i);
        String A012 = A01(this.A06);
        if (A012.isEmpty()) {
            return C0933aK.A01;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(A012);
        A04(spannableStringBuilder, this.A03, 0, 0, spannableStringBuilder.length(), 16711680);
        A03(spannableStringBuilder, this.A02, -1, 0, spannableStringBuilder.length(), 16711680);
        A05(spannableStringBuilder, this.A04, A00(54, 10, 119), 0, spannableStringBuilder.length(), 16711680);
        float verticalPlacement = this.A00;
        while (this.A06.A05() >= 8) {
            int A072 = this.A06.A07();
            int A092 = this.A06.A09();
            int A093 = this.A06.A09();
            boolean z2 = false;
            if (A093 == A08) {
                if (this.A06.A05() >= 2) {
                    z2 = true;
                }
                A08(z2);
                int atomSize = this.A06.A0J();
                for (int i2 = 0; i2 < atomSize; i2++) {
                    A06(this.A06, spannableStringBuilder);
                }
            } else if (A093 == A09 && this.A05) {
                if (this.A06.A05() >= 2) {
                    z2 = true;
                }
                A08(z2);
                verticalPlacement = C0466Ig.A00(((float) this.A06.A0J()) / ((float) this.A01), 0.0f, 0.95f);
            }
            this.A06.A0Z(A072 + A092);
        }
        return new C0933aK(new GF(spannableStringBuilder, null, verticalPlacement, 0, 0, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE));
    }
}
