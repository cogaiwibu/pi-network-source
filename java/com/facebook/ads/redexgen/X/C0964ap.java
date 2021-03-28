package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;
import org.json.JSONException;

/* renamed from: com.facebook.ads.redexgen.X.ap  reason: case insensitive filesystem */
public class C0964ap implements AbstractC0647Pn {
    public static byte[] A02;
    public final /* synthetic */ long A00;
    public final /* synthetic */ KF A01;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 84);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{8, 15, 94, 89, 9, 88, 10, 14, 89, 9, 10, 93, 11, 14, 95, 12, 16, 9, 21, 20, 31, 34, 57, 63, 42, 46, 51, 53, 52, 96, 122, 83, 101, 114, 118, 101, 114, 32, 101, 114, 114, 111, 114, 32, 111, 99, 99, 117, 114, 114, 101, 100, 117, 67, 84, 80, 67, 84, 6, 84, 67, 86, 74, 79, 67, 66, 6, 85, 83, 69, 69, 67, 85, 85, 64, 83, 74, 74, 95, 19, 18, 63, 19, 17, 12, 16, 25, 8, 25, 61, 60, 23, 32, 32, 61, 32};
    }

    public C0964ap(KF kf, long j) {
        this.A01 = kf;
        this.A00 = j;
    }

    /* JADX INFO: Multiple debug info for r13v0 'this'  com.facebook.ads.redexgen.X.ap: [D('e' org.json.JSONException), D('errorType' com.facebook.ads.internal.protocol.AdErrorType), D('response' com.facebook.ads.redexgen.X.Pl)] */
    private final void A02(C0659Pz pz) {
        KB.A07(KF.A02(this.A01));
        try {
            AbstractC0645Pl A002 = pz.A00();
            if (A002 != null) {
                String A5U = A002.A5U();
                KI A06 = KF.A03(this.A01).A06(KF.A01(this.A01), A5U, this.A00, KF.A08(this.A01));
                if (A06.A01() == KH.A03) {
                    C0943aU aUVar = (C0943aU) A06;
                    String A04 = aUVar.A04();
                    AdErrorType adErrorTypeFromCode = AdErrorType.adErrorTypeFromCode(aUVar.A03(), AdErrorType.ERROR_MESSAGE);
                    if (A04 != null) {
                        A5U = A04;
                    }
                    KF.A01(this.A01).A0A().A2m(LW.A01(KF.A00(this.A01)), adErrorTypeFromCode.getErrorCode(), A5U, adErrorTypeFromCode.isPublicError());
                    KF.A0I(this.A01, C0495Jm.A02(adErrorTypeFromCode, A5U));
                    return;
                }
            }
            AdErrorType adErrorType = AdErrorType.NETWORK_ERROR;
            String message = pz.getMessage();
            KF.A01(this.A01).A0A().A2m(LW.A01(KF.A00(this.A01)), adErrorType.getErrorCode(), message, adErrorType.isPublicError());
            KF.A0I(this.A01, C0495Jm.A02(adErrorType, message));
        } catch (JSONException e) {
            AdErrorType adErrorType2 = AdErrorType.NETWORK_ERROR;
            String message2 = pz.getMessage();
            AnonymousClass0S A0A = KF.A01(this.A01).A0A();
            long A012 = LW.A01(KF.A00(this.A01));
            int errorCode = adErrorType2.getErrorCode();
            A0A.A2m(A012, errorCode, A00(16, 15, 14) + e.getMessage(), adErrorType2.isPublicError());
            KF.A0I(this.A01, C0495Jm.A02(adErrorType2, message2));
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0647Pn
    public final void A9C(AbstractC0645Pl pl) {
        K0.A05(A00(79, 10, 40), A00(52, 27, 114), A00(8, 8, 59));
        if (pl != null) {
            String A5U = pl.A5U();
            KB.A07(KF.A02(this.A01));
            KF.A0L(this.A01, A5U, this.A00);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0647Pn
    public final void A9Y(Exception exc) {
        K0.A05(A00(89, 7, 6), A00(31, 21, 84), A00(0, 8, 104));
        if (C0659Pz.class.equals(exc.getClass())) {
            A02((C0659Pz) exc);
            return;
        }
        AdErrorType adErrorType = AdErrorType.NETWORK_ERROR;
        String message = exc.getMessage();
        KF.A01(this.A01).A0A().A2m(LW.A01(KF.A00(this.A01)), adErrorType.getErrorCode(), message, adErrorType.isPublicError());
        KF.A0I(this.A01, C0495Jm.A02(adErrorType, message));
    }
}
