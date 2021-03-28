package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.ads.AdError;
import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;

/* renamed from: com.facebook.ads.redexgen.X.Rg  reason: case insensitive filesystem */
public class C0692Rg implements AbstractC00440x {
    public static byte[] A02;
    public static String[] A03;
    public final /* synthetic */ C0377Et A00;
    public final /* synthetic */ Runnable A01;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            int i5 = (copyOfRange[i4] ^ i3) ^ 34;
            String[] strArr = A03;
            if (strArr[5].charAt(5) != strArr[1].charAt(5)) {
                String[] strArr2 = A03;
                strArr2[5] = "sVZQ6Ml9fBzEITS5ybXWTtwXQoWqWbAN";
                strArr2[1] = "MwEMOJFXQFuJpU8zWQ85tYeWswvxAO3B";
                copyOfRange[i4] = (byte) i5;
            } else {
                throw new RuntimeException();
            }
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{108, 56, 58, 98, 61, 106, 106, 106, 15, 42, 47, 62, 58, 43, 60, 110, 39, 61, 110, 32, 59, 34, 34, 110, 33, 32, 110, 34, 33, 47, 42, 7, 32, 58, 43, 60, 61, 58, 39, 58, 39, 47, 34, 15, 42, 93, 122, 96, 113, 102, 103, 96, 125, 96, 125, 117, 120, 52, 125, 121, 100, 102, 113, 103, 103, 125, 123, 122, 52, 114, 125, 102, 113, 112, 106, 101, 111, 121, 100, 98, 111, 37, 98, 101, ByteCompanionObject.MAX_VALUE, 110, 101, ByteCompanionObject.MAX_VALUE, 37, 106, 104, ByteCompanionObject.MAX_VALUE, 98, 100, 101, 37, 93, 66, 78, 92, 47, 62, 39, 96, 97, 70, 97, 123, 106, 125, 124, 123, 102, 123, 102, 110, 99, 67, 96, 104, 104, 102, 97, 104, 70, 98, ByteCompanionObject.MAX_VALUE, 125, 106, 124, 124, 102, 96, 97};
    }

    public static void A02() {
        A03 = new String[]{"CodBKn6Rx4Nd2NCJ9VlYeJoUvBmT0K9p", "5Rf8WjvcJZOUdeEvkpnEyeT6h0OK8cqO", "9H9umRBAwWbsUQsHVAjP1GvoefoGWKiv", "nqryT6E7", "BkgpBj4q", "vUmBCwuwnOwC6wDkIlhiKnb32h6Srhe1", "47HB5bdSxtP74yDXUEGozfNjn4WOkRGN", "xids5JFtyjlo4uGEh5DI8Wwgi7h0jVQM"};
    }

    public C0692Rg(C0377Et et, Runnable runnable) {
        this.A00 = et;
        this.A01 = runnable;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00440x
    public final void A9k(RE re, String str, boolean z) {
        this.A00.A07.A0B();
        boolean z2 = !TextUtils.isEmpty(str);
        if (z && z2) {
            Intent intent = new Intent(A00(74, 26, 41));
            intent.setData(Uri.parse(str));
            C0523Kq.A0C(this.A00.A0C, intent);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00440x
    public final void A9l(RE re) {
        this.A00.A07.A02();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00440x
    public final void A9m(RE re) {
        this.A00.A07.A04();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00440x
    public final void A9n(RE re) {
        if (re == this.A00.A01) {
            if (re == null) {
                this.A00.A0C.A04().A82(A00(100, 3, 108), C02248i.A0M, new C02258j(A00(8, 37, 108)));
                A9o(re, AdError.internalError(2004));
                return;
            }
            this.A00.A0G().removeCallbacks(this.A01);
            C0377Et et = this.A00;
            et.A02 = re;
            C0377Et.A01(et);
            this.A00.A07.A0E(re);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00440x
    public final void A9o(RE re, AdError adError) {
        if (re == this.A00.A01) {
            this.A00.A0G().removeCallbacks(this.A01);
            this.A00.A0P(re);
            if (!J8.A0j(this.A00.A0C)) {
                this.A00.A0O();
            }
            this.A00.A0C.A0A().A4Y(adError.getErrorCode(), adError.getErrorMessage());
            this.A00.A07.A0F(new C0495Jm(adError.getErrorCode(), adError.getErrorMessage()));
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00440x
    public final void A9p(RE re) {
        K0.A05(A00(103, 31, 45), A00(45, 29, 54), A00(0, 8, 121));
        this.A00.A07.A0C();
        this.A00.A0M();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00440x
    public final void A9q() {
        this.A00.A07.A07();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00440x
    public final void A9r() {
        this.A00.A07.A05();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00440x
    public final void A9s() {
        this.A00.A07.A06();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00440x
    public final void onInterstitialActivityDestroyed() {
        this.A00.A07.A00();
    }
}
