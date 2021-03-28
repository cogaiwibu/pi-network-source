package com.facebook.ads.redexgen.X;

import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;
import java.util.Arrays;

public class X2 extends AbstractRunnableC0510Kc {
    public static byte[] A03;
    public final /* synthetic */ AudienceNetworkAds.InitListener A00;
    public final /* synthetic */ C0821Wi A01;
    public final /* synthetic */ MultithreadedBundleWrapper A02;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 8);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{91, 108, 99, 40, 123, 125, 107, 107, 109, 123, 123, 110, 125, 100, 100, 113, 40, 97, 102, 97, 124, 97, 105, 100, 97, 114, 109, 108, 41};
    }

    public X2(C0821Wi wi, MultithreadedBundleWrapper multithreadedBundleWrapper, AudienceNetworkAds.InitListener initListener) {
        this.A01 = wi;
        this.A02 = multithreadedBundleWrapper;
        this.A00 = initListener;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0510Kc
    public final void A07() {
        try {
            XG.A02().A0D(this.A01);
            if (!AnonymousClass95.A06.get() && J8.A12(this.A01)) {
                AnonymousClass9E.A04(this.A01, this.A02);
            }
        } catch (Throwable th) {
            this.A01.A04().A3S(th);
        }
        AnonymousClass95.A0E(this.A01);
        AudienceNetworkAds.InitListener initListener = this.A00;
        if (initListener != null) {
            AnonymousClass95.A06(initListener, new AnonymousClass94(true, A00(0, 29, 0)));
        }
    }
}
