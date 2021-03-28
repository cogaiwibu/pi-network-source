package com.facebook.ads.redexgen.X;

import android.text.Layout;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;

/* renamed from: com.facebook.ads.redexgen.X.Go  reason: case insensitive filesystem */
public final class C0422Go {
    public static byte[] A0G;
    public static String[] A0H;
    public float A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public Layout.Alignment A08;
    public String A09;
    public String A0A;
    public String A0B;
    public String A0C;
    public List<String> A0D;
    public boolean A0E;
    public boolean A0F;

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0G, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 47);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A0G = new byte[]{-95, -64, -62, -54, -58, -47, -50, -44, -51, -61, ByteCompanionObject.MAX_VALUE, -62, -50, -53, -50, -47, ByteCompanionObject.MAX_VALUE, -51, -50, -45, ByteCompanionObject.MAX_VALUE, -61, -60, -59, -56, -51, -60, -61, -115, -37, 4, 3, 9, -75, -8, 4, 1, 4, 7, -75, 3, 4, 9, -75, -7, -6, -5, -2, 3, -6, -7};
    }

    public static void A03() {
        A0H = new String[]{"gPfaOYEITfuanLdVCW8PPCT70T", "M09L9hJVD3E", "SkJXoKJQHijlm7VqsoHZEZwEmj5TLLCc", "PzoJTbfigDFXx9xueDpeQaPajCaKnfmN", "zy8acRwSmU", "EJIQGv6cByhyLGLfI7fJN1oDm4V", "77NuOZxmpIn29Otv7yNmBxSNaW0583gz", "YbktzD3yqdg7"};
    }

    public C0422Go() {
        A04();
    }

    public static int A00(int i, String str, String str2, int i2) {
        if (str.isEmpty() || i == -1) {
            return i;
        }
        if (str.equals(str2)) {
            return i + i2;
        }
        return -1;
    }

    private final void A04() {
        String A012 = A01(0, 0, 56);
        this.A0A = A012;
        this.A0B = A012;
        this.A0D = Collections.emptyList();
        this.A0C = A012;
        this.A09 = null;
        this.A0F = false;
        this.A0E = false;
        this.A06 = -1;
        this.A07 = -1;
        this.A02 = -1;
        this.A05 = -1;
        this.A04 = -1;
        this.A08 = null;
    }

    public final float A05() {
        return this.A00;
    }

    public final int A06() {
        if (this.A0E) {
            return this.A01;
        }
        throw new IllegalStateException(A01(0, 29, 48));
    }

    public final int A07() {
        if (this.A0F) {
            return this.A03;
        }
        throw new IllegalStateException(A01(29, 22, 102));
    }

    public final int A08() {
        return this.A04;
    }

    public final int A09() {
        if (this.A02 == -1 && this.A05 == -1) {
            return -1;
        }
        int i = 0;
        int i2 = this.A02 == 1 ? 1 : 0;
        if (this.A05 == 1) {
            i = 2;
        }
        return i2 | i;
    }

    public final int A0A(String str, String str2, String[] strArr, String str3) {
        if (this.A0A.isEmpty() && this.A0B.isEmpty() && this.A0D.isEmpty() && this.A0C.isEmpty()) {
            return str2.isEmpty() ? 1 : 0;
        }
        String str4 = this.A0A;
        if (A0H[2].charAt(13) != 'W') {
            String[] strArr2 = A0H;
            strArr2[7] = "TLp9oTSw2za9";
            strArr2[7] = "TLp9oTSw2za9";
            int A002 = A00(A00(A00(0, str4, str, 1073741824), this.A0B, str2, 2), this.A0C, str3, 4);
            if (A002 == -1 || !Arrays.asList(strArr).containsAll(this.A0D)) {
                return 0;
            }
            return A002 + (this.A0D.size() * 4);
        }
        throw new RuntimeException();
    }

    public final Layout.Alignment A0B() {
        return this.A08;
    }

    public final C0422Go A0C(int i) {
        this.A01 = i;
        this.A0E = true;
        return this;
    }

    public final C0422Go A0D(int i) {
        this.A03 = i;
        this.A0F = true;
        return this;
    }

    public final C0422Go A0E(String str) {
        this.A09 = C0466Ig.A0M(str);
        return this;
    }

    public final C0422Go A0F(boolean z) {
        this.A02 = z ? 1 : 0;
        return this;
    }

    public final C0422Go A0G(boolean z) {
        this.A05 = z ? 1 : 0;
        return this;
    }

    public final C0422Go A0H(boolean z) {
        this.A07 = z ? 1 : 0;
        return this;
    }

    public final String A0I() {
        return this.A09;
    }

    public final void A0J(String str) {
        this.A0A = str;
    }

    public final void A0K(String str) {
        this.A0B = str;
    }

    public final void A0L(String str) {
        this.A0C = str;
    }

    public final void A0M(String[] strArr) {
        this.A0D = Arrays.asList(strArr);
    }

    public final boolean A0N() {
        return this.A0E;
    }

    public final boolean A0O() {
        return this.A0F;
    }

    public final boolean A0P() {
        return this.A06 == 1;
    }

    public final boolean A0Q() {
        return this.A07 == 1;
    }
}
