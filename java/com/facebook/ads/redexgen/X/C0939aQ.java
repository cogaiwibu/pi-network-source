package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.facebook.ads.internal.settings.AdSharedPreferences;
import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;

/* renamed from: com.facebook.ads.redexgen.X.aQ  reason: case insensitive filesystem */
public class C0939aQ extends AbstractRunnableC0510Kc {
    public static byte[] A01;
    public static String[] A02;
    public final /* synthetic */ Context A00;

    static {
        A03();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 11);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{86, -123, -123, 98, 126, -125, 104, 121, ByteCompanionObject.MIN_VALUE, 107, 122, -121, -120, 126, -124, -125};
    }

    public static void A03() {
        A02 = new String[]{"562InPUOhACtlwCEtN", "R5lwX4z8RDFVh5E8umVQyGbxSoVGO", "CYUCoKvLVtAS439EMb", "ChKnavF9Nqo0oetaNymcfBGaHAWTYXo2", "g5ZzVDftJQYE4wszTnHA7JY3RdMW3", "1hyLjyvULyVtl4OO", "Eld6CqAd7cnvJnvbiWS", "Re88eRXq7VTIVsZrXxwUq3yVYBRsOkYZ"};
    }

    public C0939aQ(Context context) {
        this.A00 = context;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0510Kc
    public final void A07() {
        int A022;
        if (L1.A02 != L0.A02) {
            SharedPreferences sharedPreferences = AdSharedPreferences.getSharedPreferences(this.A00);
            String A002 = A00(0, 16, 10);
            int returnMinSdkVersion = sharedPreferences.getInt(A002, -1);
            if (returnMinSdkVersion != -1) {
                int unused = L1.A00 = returnMinSdkVersion;
                L1.A02 = L0.A02;
                return;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                A022 = L1.A03(this.A00);
            } else {
                A022 = L1.A02(this.A00);
            }
            int unused2 = L1.A00 = A022;
            if (A02[7].charAt(31) != 71) {
                String[] strArr = A02;
                strArr[3] = "Y4NBnL2AiN9ppE2ANDhRNdYoO8WQhPKC";
                strArr[3] = "Y4NBnL2AiN9ppE2ANDhRNdYoO8WQhPKC";
                sharedPreferences.edit().putInt(A002, A022).commit();
                L1.A02 = L0.A02;
                return;
            }
            throw new RuntimeException();
        }
    }
}
