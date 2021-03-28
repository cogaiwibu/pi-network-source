package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.bT  reason: case insensitive filesystem */
public class C1002bT implements AnonymousClass79 {
    public static byte[] A03;
    public static String[] A04;
    public final /* synthetic */ RG A00;
    public final /* synthetic */ C1007bZ A01;
    public final /* synthetic */ boolean A02;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 96);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{-41, -14, -6, -3, -10, -11, -79, 5, 0, -79, -11, 0, 8, -1, -3, 0, -14, -11, -79, -14, -79, -2, -10, -11, -6, -14, -65};
    }

    public static void A02() {
        A04 = new String[]{"8KjqebZv60QJkTDxRMgw9", "thfRn5pDzJN70UFYfVIlaB6cN7Gudk2R", "C9BVpw9UV8RgNssPir2gScGxH", "7AiIJI7TwWfHsESFux14U5S4ACJbRhuU", "Q7zUSmRtSU1V7fItr4R7SI8x29M95mvp", "Azfz", "38Oiuq4LYjnMY2HJpsmmy", "sSYHnhmgAc6ueqp"};
    }

    public C1002bT(C1007bZ bZVar, RG rg, boolean z) {
        this.A01 = bZVar;
        this.A00 = rg;
        this.A02 = z;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass79
    public final void A97() {
        if (this.A01.A0W != null) {
            this.A01.A0W.A0W();
            this.A01.A0W = null;
        }
        AdErrorType adErrorType = AdErrorType.CACHE_FAILURE_ERROR;
        String A002 = A00(0, 27, 49);
        this.A01.A0Y.A0A().A2d(LW.A01(this.A01.A00), adErrorType.getErrorCode(), A002);
        if (this.A01.A0F != null) {
            this.A01.A0F.A9X(C0495Jm.A02(adErrorType, A002));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x006d, code lost:
        if (r3.A0D.equals(com.facebook.ads.redexgen.X.JU.A04) != false) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00a4, code lost:
        if (r3.A0D.equals(com.facebook.ads.redexgen.X.JU.A04) != false) goto L_0x006f;
     */
    @Override // com.facebook.ads.redexgen.X.AnonymousClass79
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void A9E() {
        /*
        // Method dump skipped, instructions count: 173
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1002bT.A9E():void");
    }
}
