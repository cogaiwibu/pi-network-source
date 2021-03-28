package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.Ww  reason: case insensitive filesystem */
public class C0835Ww extends AbstractRunnableC0510Kc {
    public static byte[] A05;
    public final /* synthetic */ int A00;
    public final /* synthetic */ AnonymousClass8H A01;
    public final /* synthetic */ AbstractC02188b A02;
    public final /* synthetic */ C02258j A03;
    public final /* synthetic */ String A04;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 120);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{-37, -3, 30, 27, 46, 32, -39, 28, 43, 26, 44, 33, -39, 27, 30, 28, 26, 46, 44, 30, -39, 44, -2, 39, 47, 34, 43, 40, 39, 38, 30, 39, 45, -3, 26, 45, 26, 9, 43, 40, 47, 34, 29, 30, 43, -39, 39, 40, 45, -39, 34, 39, 35, 30, 28, 45, 30, 29, -46, -24, -19, -22, -97, -24, -14, -97, -19, -12, -21, -21, -96, 30, 33, 33, 38, 49, 38, 44, 43, 30, 41, 28, 38, 43, 35, 44, 45, 66, 45, 53, 56, 45, 46, 56, 49, 43, 48, 53, 63, 55, 43, 63, 60, 45, 47, 49, 62, 60, 62, 67, 64, 104, 91, 89, 101, 104, 90, 85, 90, 87, 106, 87, 88, 87, 105, 91, -18, -31, -19, -15, -31, -17, -16, -37, -27, -32, 44, 46, 27, 45, 50, 41, 30, 49, 51, 32, 50, 55, 46, 35, 29, 33, 45, 34, 35};
    }

    public C0835Ww(AnonymousClass8H r1, String str, int i, C02258j r4, AbstractC02188b r5) {
        this.A01 = r1;
        this.A04 = str;
        this.A00 = i;
        this.A03 = r4;
        this.A02 = r5;
    }

    /* JADX INFO: Multiple debug info for r0v29 java.util.Map<java.lang.String, java.lang.String>: [D('requestId' java.lang.String), D('lastDiskSpace' java.lang.String), D('debugEventSink' com.facebook.ads.redexgen.X.8a)] */
    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0510Kc
    public final void A07() {
        String stackTrace;
        Map<String, String> A4S;
        String A6R;
        try {
            if (!C02198c.A0J(this.A01, this.A04, this.A00, this.A03)) {
                JO.A06(this.A01, JG.A0A.toString() + A00(0, 1, 41) + this.A04);
                Throwable cause = this.A03.getCause();
                if (cause != null) {
                    stackTrace = LN.A03(this.A01, cause);
                } else if (J9.A0S(this.A01)) {
                    stackTrace = LN.A03(this.A01, this.A03);
                } else {
                    stackTrace = A00(0, 0, 106) + this.A03.getMessage();
                }
                if (J9.A0V(this.A01)) {
                    A4S = this.A01.A02().A4S();
                } else if (this.A02 != null) {
                    A4S = this.A02.A6A();
                } else if (C02198c.A02) {
                    C02198c.A0H(new RuntimeException(A00(1, 57, 65), this.A03));
                    A4S = new HashMap<>();
                } else {
                    A4S = this.A01.A02().A4S();
                }
                A4S.put(A00(136, 7, 65), this.A04);
                A4S.put(A00(143, 12, 70), String.valueOf(this.A00));
                JSONObject A022 = this.A03.A02();
                if (A022 != null) {
                    A4S.put(A00(71, 15, 69), A022.toString());
                }
                if ((A00(106, 5, 99).equals(this.A04) || A00(111, 15, 126).equals(this.A04)) && (A6R = this.A01.A02().A6R()) != null) {
                    A4S.put(A00(86, 20, 84), A6R);
                }
                String A07 = this.A01.A07();
                if (A07 != null && !TextUtils.isEmpty(A07)) {
                    A4S.put(A00(126, 10, 4), A07);
                }
                AbstractC02178a r2 = (AbstractC02178a) C02198c.A03().get();
                if (r2 != null) {
                    r2.ADu(stackTrace, A4S, this.A01);
                } else {
                    C02198c.A0H(new RuntimeException(A00(58, 13, 7)));
                }
            }
        } catch (Throwable th) {
            C02198c.A0H(th);
        }
    }
}
