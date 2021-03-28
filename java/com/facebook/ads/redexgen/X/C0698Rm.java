package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdError;
import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;

/* renamed from: com.facebook.ads.redexgen.X.Rm  reason: case insensitive filesystem */
public class C0698Rm implements AnonymousClass12 {
    public static byte[] A02;
    public static String[] A03;
    public final /* synthetic */ Eq A00;
    public final /* synthetic */ Runnable A01;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 97);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{52, 3, 17, 7, 20, 2, 3, 2, 70, 48, 15, 2, 3, 9, 70, 15, 11, 22, 20, 3, 21, 21, 15, 9, 8, 70, 0, 15, 20, 3, 2, 68, 26, 20, 64, 22, 16, 65, 70, 71, 123, 76, 94, 72, 91, 77, 76, 77, ByteCompanionObject.MAX_VALUE, 64, 77, 76, 70, 104, 77, 101, 70, 78, 78, 64, 71, 78, 96, 68, 89, 91, 76, 90, 90, 64, 70, 71};
    }

    public static void A02() {
        A03 = new String[]{"gOGPE1XGqnroAJihU7XGAfTAdWa21jWC", "Kcs30m2Uc1eFMAQARd2pOhOOSRswugkg", "xkwB", "vFLx4ryI8nKhSFQKGVnAMH5qObxMihWN", "NnwKyO2XMzRH0BXfVduboZ9DAJ5a5svW", "U3uRLxNZuwH", "U9y6Wp3Jad2LD1", "sOAhAPVwmiqriGnbgM61Uai8lTIQh97W"};
    }

    public C0698Rm(Eq eq, Runnable runnable) {
        this.A00 = eq;
        this.A01 = runnable;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass12
    public final void AAm(RM rm) {
        this.A00.A07.A05();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass12
    public final void AAn(RM rm) {
        this.A00.A07.A06();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass12
    public final void AAo(RM rm) {
        this.A00.A07.A0B();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass12
    public final void AAp(RM rm) {
        this.A00.A0G().removeCallbacks(this.A01);
        Eq eq = this.A00;
        eq.A02 = rm;
        Eq.A04(eq);
        this.A00.A07.A0E(rm);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass12
    public final void AAq(RM rm) {
        K0.A05(A00(38, 34, 72), A00(0, 31, 7), A00(31, 7, 67));
        this.A00.A07.A0C();
        this.A00.A0M();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass12
    public final void AAr(RM rm) {
        this.A00.A07.A07();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass12
    public final void AAs(RM rm, AdError adError) {
        this.A00.A0G().removeCallbacks(this.A01);
        this.A00.A0C.A0A().A4Y(adError.getErrorCode(), adError.getErrorMessage());
        if (!AdError.AD_PRESENTATION_ERROR.equals(adError) || !J8.A16(this.A00.A0C)) {
            Eq eq = this.A00;
            if (A03[2].length() != 4) {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[2] = "s57s";
            strArr[2] = "s57s";
            eq.A07.A0F(C0495Jm.A01(AdErrorType.INTERNAL_ERROR));
        } else {
            this.A00.A07.A0F(C0495Jm.A01(AdErrorType.AD_PRESENTATION_ERROR));
        }
        this.A00.A0P(rm);
        this.A00.A0O();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass12
    public final void onRewardedVideoActivityDestroyed() {
        this.A00.A07.A08();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass12
    public final void onRewardedVideoClosed() {
        this.A00.A07.A09();
    }
}
