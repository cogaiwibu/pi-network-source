package com.facebook.ads.redexgen.X;

import java.util.Collections;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.aE  reason: case insensitive filesystem */
public final class C0927aE implements GG {
    public static String[] A01;
    public final List<GF> A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"uyzG6nZhYmNB4VufbjNeT4Wu24aJjB", "gpgsRAJrUCyLiJ0U4KQoajYft8d2IWSs", "V6tp6oNeuWY4Rz4wk", "QxLD6Qr0", "n2jYEAQ7ylPlmaGFo", "iuLvneSMbLfhzIa7Pvm7Ht11vKly078I", "9KvTRZ4e8scFY8IRtC8ize1aHWfIVCyu", "s0mDJJaIHWanY7Mz7gNVqOFT5NJr2uCg"};
    }

    public C0927aE(List<GF> list) {
        this.A00 = list;
    }

    @Override // com.facebook.ads.redexgen.X.GG
    public final List<GF> A5p(long j) {
        return j >= 0 ? this.A00 : Collections.emptyList();
    }

    @Override // com.facebook.ads.redexgen.X.GG
    public final long A6E(int i) {
        boolean z;
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        I1.A03(z);
        String[] strArr = A01;
        if (strArr[6].charAt(12) != strArr[7].charAt(12)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[0] = "k5niKSSkUsmLECakjkbMaTYSf6uR41";
        strArr2[3] = "iDI18Hfk";
        return 0;
    }

    @Override // com.facebook.ads.redexgen.X.GG
    public final int A6F() {
        return 1;
    }

    @Override // com.facebook.ads.redexgen.X.GG
    public final int A6Y(long j) {
        return j < 0 ? 0 : -1;
    }
}
