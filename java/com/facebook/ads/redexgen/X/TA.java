package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import com.facebook.ads.NativeAdBase;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;

public final class TA implements AbstractC00591m {
    public static byte[] A03;
    public AnonymousClass5H A00;
    public C0820Wh A01;
    public final NativeAdBase.MediaCacheFlag A02;

    static {
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 87);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A03 = new byte[]{59, 52, 33, 60, 35, 48, 100, ByteCompanionObject.MAX_VALUE, 122, ByteCompanionObject.MAX_VALUE, 126, 102, ByteCompanionObject.MAX_VALUE};
    }

    public TA(AnonymousClass5H r1, C0820Wh wh, NativeAdBase.MediaCacheFlag mediaCacheFlag) {
        this.A00 = r1;
        this.A01 = wh;
        this.A02 = mediaCacheFlag;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00591m
    public final void A9X(C0495Jm jm) {
        KT.A00(new T7(this, jm));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00591m
    public final void AAI(List<RG> list) {
        AnonymousClass7H r0 = new AnonymousClass7H(this.A01);
        String A022 = A02(6, 7, 70);
        for (RG rg : list) {
            if (A02(6, 7, 70).equals(A022)) {
                A022 = rg.A0R();
            }
            if (this.A02.equals(NativeAdBase.MediaCacheFlag.ALL)) {
                if (rg.A0K() != null) {
                    r0.A0R(new AnonymousClass7E(rg.A0K().getUrl(), rg.A0K().getHeight(), rg.A0K().getWidth(), rg.A0R(), A02(0, 6, 2)));
                }
                if (rg.A0J() != null) {
                    r0.A0R(new AnonymousClass7E(rg.A0J().getUrl(), rg.A0J().getHeight(), rg.A0J().getWidth(), rg.A0R(), A02(0, 6, 2)));
                }
                if (!TextUtils.isEmpty(rg.A0T())) {
                    r0.A0W(new AnonymousClass7G(rg.A0T(), rg.A0R(), A02(0, 6, 2), rg.A0N().longValue()));
                }
            }
        }
        r0.A0Q(new T9(this, list), new AnonymousClass7A(A022, A02(0, 6, 2)));
    }
}
