package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.ByteCompanionObject;

public final class KF {
    public static byte[] A08;
    public static String[] A09;
    public static final ThreadFactoryC0538Lh A0A = new ThreadFactoryC0538Lh();
    public static final Executor A0B = Executors.newCachedThreadPool(A0A);
    public long A00 = -1;
    public KC A01;
    public KE A02;
    @Nullable
    public String A03;
    public Map<String, String> A04;
    public final C0820Wh A05;
    public final KG A06;
    public final String A07;

    public static String A06(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A08, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 80);
        }
        return new String(copyOfRange);
    }

    public static void A0C() {
        A08 = new byte[]{50, 107, 63, 62, 59, 105, 50, 122, 105, 107, 119, 117, 78, 65, 68, 72, 67, 89, 82, 95, 72, 92, 88, 72, 94, 89, 82, 68, 73, 98, 88, 11, 121, 101, 17, 11, 100, 101, 10, 108, 99, 102, 102, 10, 88, 79, 73, 79, 67, 92, 79, 78, 20, 53, 122, 28, 51, 54, 54, 122, 63, 40, 40, 53, 40, 122, 57, 53, 62, 63, 122, 1, ByteCompanionObject.MAX_VALUE, 41, 7, 122, ByteCompanionObject.MAX_VALUE, 41, 38, 7, 72, 6, 13, 28, 31, 7, 26, 3, 72, 11, 7, 6, 6, 13, 11, 28, 1, 7, 6, 88, 90, 81, 90, 77, 86, 92, 40, 35, 50, 49, 41, 52, 45, 55, 54, 31, 48, 53, 53, 17, 54, 54, 50};
    }

    public static void A0D() {
        A09 = new String[]{"jHqhq9rNYSSw", "oXXasJZKheaqJc0eeEDaqL9fqatR6yjH", "HZfV4vlkHnOHSqnfuZFUyeF6uFp1ZMa", "ctGGwCiuI8x2mhpb6iYaTSYvEv38GMVI", "hooRY0JbS2MOmGEMLhPLLpjKFYik6yA6", "UUaZIloNsnWPLtNmJ6BLiWitv8uuoCfe", "8CdfBsPlUzO8votQ5auuotJRUMhSpJIA", "YHWLBZkCs2mlLEga5omnGJot9WkTYHBz"};
    }

    static {
        A0D();
        A0C();
    }

    public KF(C0820Wh wh) {
        this.A05 = wh;
        this.A06 = KG.A00();
        this.A07 = KJ.A00();
    }

    /* access modifiers changed from: private */
    public AbstractC0647Pn A04(long j) {
        return new C0964ap(this, j);
    }

    private void A0B() {
        C0820Wh wh = this.A05;
        if (wh != null && Q4.A0C(wh)) {
            C02258j r5 = new C02258j(A06(7, 5, 107));
            r5.A03(1);
            this.A05.A04().A82(A06(106, 7, 22), C02248i.A1c, r5);
        }
    }

    private void A0E(int i, String str) {
        String A062 = A06(113, 10, 9);
        K0.A05(A062, A06(36, 16, 122), A06(0, 7, 90));
        K0.A04(A062, String.format(Locale.US, A06(52, 26, 10), Integer.valueOf(i), str));
    }

    /* access modifiers changed from: private */
    public void A0F(C0495Jm jm) {
        KE ke = this.A02;
        if (ke != null) {
            ke.A9X(jm);
        }
    }

    /* access modifiers changed from: private */
    public void A0G(C0495Jm jm) {
        LZ.A00(new C0961am(this, jm));
    }

    /* access modifiers changed from: private */
    public void A0M(C0944aV aVVar) {
        KE ke = this.A02;
        if (ke != null) {
            ke.AB3(aVVar);
        }
    }

    private void A0N(C0944aV aVVar) {
        QN A0C;
        LZ.A00(new C0962an(this, aVVar));
        if (J8.A1O(this.A05) && (A0C = XG.A02().A0C()) != null) {
            A0C.A59();
        }
    }

    /* JADX INFO: Multiple debug info for r12v0 'this'  com.facebook.ads.redexgen.X.KF: [D('serverResponse' com.facebook.ads.redexgen.X.KI), D('e' java.lang.Exception)] */
    /* JADX INFO: Multiple debug info for r8v0 java.lang.String: [D('placement' com.facebook.ads.redexgen.X.90), D('errorMessage' java.lang.String)] */
    /* access modifiers changed from: private */
    public void A0O(String str, long j) {
        String str2;
        try {
            KI A062 = this.A06.A06(this.A05, str, j, this.A03);
            AnonymousClass90 A002 = A062.A00();
            C01685v.A06(this.A05.A00(), str);
            if (A002 != null) {
                J8.A0M(this.A05).A1m(A002.A08());
                DynamicLoaderFactory.makeLoader(this.A05).getInitApi().maybeAttachCrashListener(this.A05);
                AnonymousClass23.A0P(this.A05.A00(), A002.A06());
                KB.A06(A002.A05().A0B(), this.A01);
                C0549Ls.A01(this.A05, A0B, A002);
                C02258j r7 = new C02258j(A06(29, 7, 123) + LA.A02());
                r7.A04(1);
                r7.A07(false);
                this.A05.A04().A8O(A06(99, 7, 111), C02248i.A1E, r7);
            }
            int i = KD.A00[A062.A01().ordinal()];
            if (i == 1) {
                C0944aV aVVar = (C0944aV) A062;
                if (A002 != null) {
                    if (A002.A05().A0E()) {
                        KB.A08(str, this.A01);
                    }
                    if (this.A04 != null) {
                        str2 = this.A04.get(A06(12, 17, 93));
                    } else {
                        str2 = null;
                    }
                    if (!TextUtils.isEmpty(A062.A02()) && !TextUtils.isEmpty(str2)) {
                        new J6(this.A05, str2, A062.A02()).A0C();
                    }
                }
                this.A05.A0A().A2n(LW.A01(this.A00));
                A0N(aVVar);
            } else if (i != 2) {
                AdErrorType adErrorType = AdErrorType.UNKNOWN_RESPONSE;
                this.A05.A0A().A2m(LW.A01(this.A00), adErrorType.getErrorCode(), str, adErrorType.isPublicError());
                A0G(C0495Jm.A02(adErrorType, str));
            } else {
                C0943aU aUVar = (C0943aU) A062;
                String finalErrMessage = aUVar.A04();
                AdErrorType adErrorTypeFromCode = AdErrorType.adErrorTypeFromCode(aUVar.A03(), AdErrorType.ERROR_MESSAGE);
                A0E(aUVar.A03(), finalErrMessage);
                if (finalErrMessage == null) {
                    finalErrMessage = str;
                }
                this.A05.A0A().A2m(LW.A01(this.A00), adErrorTypeFromCode.getErrorCode(), finalErrMessage, adErrorTypeFromCode.isPublicError());
                A0G(C0495Jm.A02(adErrorTypeFromCode, finalErrMessage));
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            AdErrorType adErrorType2 = AdErrorType.PARSER_FAILURE;
            AnonymousClass0S A0A2 = this.A05.A0A();
            long A012 = LW.A01(this.A00);
            int errorCode = adErrorType2.getErrorCode();
            boolean isPublicError = adErrorType2.isPublicError();
            if (A09[2].length() != 31) {
                throw new RuntimeException();
            }
            String[] strArr = A09;
            strArr[3] = "KiE48ndyzelvmzNW6bdZaRvZ6MMpVlPo";
            strArr[1] = "apnThSuxD28F5jipUISQB7XXqWmqfDCi";
            A0A2.A2m(A012, errorCode, errorMessage, isPublicError);
            A0G(C0495Jm.A02(adErrorType2, errorMessage));
        }
    }

    /* access modifiers changed from: private */
    public void A0P(String str, long j) {
        A0B.execute(new C0967as(this, str, j));
    }

    /* JADX INFO: Multiple debug info for r10v0 'this'  com.facebook.ads.redexgen.X.KF: [D('lastResponse' java.lang.String), D('networkError' com.facebook.ads.internal.protocol.AdErrorType)] */
    public final void A0Q(KC kc) {
        this.A00 = System.currentTimeMillis();
        if (LU.A00(this.A05) == LT.A07) {
            A0B();
            AdErrorType adErrorType = AdErrorType.NETWORK_ERROR;
            String A062 = A06(78, 21, 56);
            this.A05.A0A().A2m(LW.A01(this.A00), adErrorType.getErrorCode(), A062, adErrorType.isPublicError());
            A0G(new C0495Jm(adErrorType, A062));
            return;
        }
        this.A01 = kc;
        C02338r.A0B(this.A05);
        if (KB.A09(kc)) {
            String A022 = KB.A02(kc);
            if (A022 != null) {
                this.A05.A0A().ADg();
                A0P(A022, 0);
                return;
            }
            AdErrorType adErrorType2 = AdErrorType.LOAD_TOO_FREQUENTLY;
            this.A05.A0A().A2m(LW.A01(this.A00), adErrorType2.getErrorCode(), adErrorType2.getDefaultErrorMessage(), adErrorType2.isPublicError());
            A0G(C0495Jm.A02(adErrorType2, null));
            return;
        }
        A0B.execute(new C0970av(this, kc));
    }

    public final void A0R(KE ke) {
        this.A02 = ke;
    }
}
