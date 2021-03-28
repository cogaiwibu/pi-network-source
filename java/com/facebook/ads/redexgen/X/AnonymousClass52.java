package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.api.AudienceNetworkActivityApi;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.52  reason: invalid class name */
public final class AnonymousClass52 implements AudienceNetworkActivityApi {
    public static byte[] A04;
    public static String[] A05;
    public boolean A00;
    public final AudienceNetworkActivity A01;
    public final AudienceNetworkActivityApi A02;
    public final AnonymousClass51 A03;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 71);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{12, 8, 7, 59, 42, 47, 43, 52, 41, 43, 20, 43, 58, 61, 53, 56, 49, 19, 44, 35, 54, 46, 35, 33, 50, 35, 34, -34, 35, 54, 33, 35, 46, 50, 39, 45, 44, -20, -70, -57, -72, -70, -68, -51, -62, -49, -62, -51, -46};
    }

    public static void A02() {
        A05 = new String[]{"kVVxbIvKBpFLpNMn249evg7U1t5DMrkR", "HNBIISUKPJt5lzvo", "tha", "s0U2IqORDUirQkjYFZUhzDbmHPDS66DK", "4XQ6Ra6x1CsG5mP0jlsGo4Oc8x5GsOh7", "mYQ1yQiLRLlGaSwEYEmmcgt3b9ncmm6M", "URRMMekVjcz4ECsO2XmiMnA4WEVCe5QQ", "lW2qNIOuJVr9bvm7hZsN45J1F7Bnv3JY"};
    }

    public AnonymousClass52(AudienceNetworkActivity audienceNetworkActivity, AudienceNetworkActivityApi audienceNetworkActivityApi, AnonymousClass51 r3) {
        this.A01 = audienceNetworkActivity;
        this.A02 = audienceNetworkActivityApi;
        this.A03 = r3;
    }

    private void A03(Throwable th) {
        this.A00 = true;
        this.A03.A0K();
        finish(8);
        C0820Wh A0J = this.A03.A0J();
        if (A0J != null) {
            A0J.A04().A82(A00(38, 11, 18), C02248i.A04, new C02258j(th));
            return;
        }
        String A002 = A00(0, 17, 127);
        if (A05[3].charAt(1) != '0') {
            throw new RuntimeException();
        }
        String[] strArr = A05;
        strArr[6] = "roakWe6n8CepWvGQKms2st32sM0MtJhe";
        strArr[6] = "roakWe6n8CepWvGQKms2st32sM0MtJhe";
        Log.e(A002, A00(17, 21, 119), th);
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void finish(int i) {
        this.A03.finish(i);
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    @SuppressLint({"CatchGeneralException"})
    public final void onBackPressed() {
        try {
            if (!this.A00) {
                this.A03.onBackPressed();
            }
        } catch (Throwable th) {
            String[] strArr = A05;
            if (strArr[4].charAt(24) != strArr[5].charAt(24)) {
                String[] strArr2 = A05;
                strArr2[7] = "o2QAVIvbVP3X0FiUaWNt1f6t7dHcTRBl";
                strArr2[0] = "vmYtMIbIQwew4451MpW2UPrO9wIbxS87";
                A03(th);
                return;
            }
            throw new RuntimeException();
        }
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    @SuppressLint({"CatchGeneralException"})
    public final void onConfigurationChanged(Configuration configuration) {
        try {
            if (this.A00) {
                this.A02.onConfigurationChanged(configuration);
                return;
            }
            this.A03.onConfigurationChanged(configuration);
            this.A02.onConfigurationChanged(configuration);
        } catch (Throwable th) {
            A03(th);
        }
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    @SuppressLint({"CatchGeneralException"})
    public final void onCreate(Bundle bundle) {
        this.A02.onCreate(bundle);
        try {
            this.A03.onCreate(bundle);
        } catch (Throwable th) {
            A03(th);
        }
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    @SuppressLint({"CatchGeneralException"})
    public final void onDestroy() {
        try {
            if (this.A00) {
                this.A02.onDestroy();
                return;
            }
            this.A03.onDestroy();
            this.A02.onDestroy();
        } catch (Throwable th) {
            A03(th);
        }
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    @SuppressLint({"CatchGeneralException"})
    public final void onPause() {
        try {
            if (this.A00) {
                this.A02.onPause();
                return;
            }
            this.A03.onPause();
            this.A02.onPause();
        } catch (Throwable th) {
            A03(th);
        }
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    @SuppressLint({"CatchGeneralException"})
    public final void onResume() {
        this.A02.onResume();
        try {
            if (!this.A00) {
                this.A03.onResume();
            }
        } catch (Throwable th) {
            A03(th);
        }
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    @SuppressLint({"CatchGeneralException"})
    public final void onSaveInstanceState(Bundle bundle) {
        this.A02.onSaveInstanceState(bundle);
        try {
            if (!this.A00) {
                this.A03.onSaveInstanceState(bundle);
            }
        } catch (Throwable th) {
            String[] strArr = A05;
            if (strArr[4].charAt(24) != strArr[5].charAt(24)) {
                String[] strArr2 = A05;
                strArr2[6] = "46sQaeWUXFUhhsRkoBzMlxezgaVtku4l";
                strArr2[6] = "46sQaeWUXFUhhsRkoBzMlxezgaVtku4l";
                A03(th);
                return;
            }
            throw new RuntimeException();
        }
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    @SuppressLint({"CatchGeneralException"})
    public final void onStart() {
        this.A02.onStart();
        try {
            if (!this.A00) {
                this.A03.onStart();
            }
        } catch (Throwable th) {
            A03(th);
        }
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    @SuppressLint({"CatchGeneralException"})
    public final void onStop() {
        this.A02.onStop();
        try {
            if (!this.A00) {
                this.A03.onStop();
            }
        } catch (Throwable th) {
            A03(th);
        }
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    @SuppressLint({"CatchGeneralException"})
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.A00) {
                return this.A02.onTouchEvent(motionEvent);
            }
            this.A03.onTouchEvent(motionEvent);
            return this.A02.onTouchEvent(motionEvent);
        } catch (Throwable th) {
            A03(th);
        }
    }
}
