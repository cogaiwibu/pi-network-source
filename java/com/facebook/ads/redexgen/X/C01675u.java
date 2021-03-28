package com.facebook.ads.redexgen.X;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.facebook.ads.internal.api.BidderTokenProviderApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.5u  reason: invalid class name and case insensitive filesystem */
public final class C01675u implements BidderTokenProviderApi {
    public static byte[] A03;
    public C0821Wi A00;
    public String A01;
    @VisibleForTesting
    public final LG A02 = new LG(300000000000L, new TP(this));

    static {
        A03();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 5);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A03 = new byte[]{-100, -87, -100, -89, -86, -94, 112, 103, 118, 121, 113, 116, 109, -127, 118, 123, 114, 103, 119, 105, 119, 119, 109, 115, 114, -125, 120, 109, 113, 105};
    }

    public static AnonymousClass99 A00(C0821Wi wi) {
        if (!J8.A0p(wi)) {
            return AnonymousClass9A.A00();
        }
        return AnonymousClass9A.A01(A01(0, 6, 86), A01(18, 12, 31), A01(6, 12, 29));
    }

    /* access modifiers changed from: private */
    public void A02() {
        C0821Wi wi;
        synchronized (this) {
            wi = this.A00;
        }
        if (wi != null) {
            String A73 = AnonymousClass9C.A00().A01(wi, true).A73(A00(wi));
            synchronized (this) {
                this.A01 = A73;
            }
        }
    }

    public final void A05() {
        this.A02.A05();
    }

    @Override // com.facebook.ads.internal.api.BidderTokenProviderApi
    public final synchronized String getBidderToken(Context context) {
        this.A00 = AnonymousClass57.A07(context);
        DynamicLoaderFactory.makeLoader(this.A00).getInitApi().maybeAttachCrashListener(this.A00);
        if (XG.A02().A0B(this.A00).AD9() || this.A01 == null) {
            A02();
            this.A02.A04().A03();
        }
        this.A02.A06();
        return this.A01;
    }
}
