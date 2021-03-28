package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import androidx.annotation.Nullable;
import com.facebook.ads.AdExperienceType;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.imageutils.JfifUtil;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.ByteCompanionObject;
import org.json.JSONObject;

@SuppressLint({"HardcodedIPAddressUse"})
/* renamed from: com.facebook.ads.redexgen.X.Re  reason: case insensitive filesystem */
public abstract class AbstractC0690Re implements KE {
    public static byte[] A0E;
    public static String[] A0F;
    public static final Handler A0G = new Handler(Looper.getMainLooper());
    public static final C00390s A0H = null;
    @SuppressLint({"StaticFieldLeak"})
    public static final KF A0I = null;
    public static final String A0J = AbstractC0690Re.class.getSimpleName();
    public View A00;
    @Nullable
    public AbstractC00340n A01;
    public AbstractC00340n A02;
    @Nullable
    public String A03 = null;
    public long A04 = -1;
    public AnonymousClass90 A05;
    public KC A06;
    public AbstractC00350o A07;
    public final C00571k A08;
    public final JE A09;
    public final C00390s A0A;
    public final KF A0B;
    public final C0820Wh A0C;
    public volatile boolean A0D;

    public static String A08(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0E, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 8);
        }
        return new String(copyOfRange);
    }

    public static void A0A() {
        A0E = new byte[]{75, 110, 107, 122, 126, 111, 120, 42, 110, 101, 111, 121, 42, 100, 101, 126, 42, 111, 114, 99, 121, 126, 78, 107, 110, ByteCompanionObject.MAX_VALUE, 123, 106, 125, 47, 102, 124, 47, 97, 122, 99, 99, 47, 96, 97, 47, 124, 123, 110, 125, 123, 78, 107, 62, 25, 17, 20, 29, 28, 88, 12, 23, 88, 17, 22, 17, 12, 17, 25, 20, 17, 2, 29, 88, 59, 23, 23, 19, 17, 29, 53, 25, 22, 25, 31, 29, 10, 86, 34, 3, 76, 1, 3, 30, 9, 76, 13, 8, 76, 15, 13, 2, 8, 5, 8, 13, 24, 9, 31, 66, 88, 125, 96, 97, 104, 47, 110, 107, 110, ByteCompanionObject.MAX_VALUE, 123, 106, 125, 47, 123, 118, ByteCompanionObject.MAX_VALUE, 106, 33, 42, 47, 107, 42, 39, 57, 46, 42, 47, 50, 107, 56, 63, 42, 57, 63, 46, 47, 76, 93, 68, 44, 59, 91, 94, 75, 94, 49, 52, 33, 52, 10, 56, 58, 49, 48, 57, 10, 33, 44, 37, 48, 29, 28, 31, 16, 23, 16, 13, 16, 22, 23, 74, 65, 76, 93, 86, 95, 91, 74, 75, 112, 70, 75, 75, 64, 88, 71, 92, 65, 64, 67, 75, 64, 90, 14, 71, 93, 14, 75, 67, 94, 90, 87, 37, 49, 38, 50, 54, 38, 45, 32, 58, 28, 32, 34, 51, 51, 42, 45, 36, 115, 112, 126, 123, 64, 107, 118, 114, 122, 64, 114, 108, 48, 44, 33, 35, 37, 45, 37, 46, 52, 9, 36, 7, 16, 4, 0, 16, 6, 1, 33, 28, 24, 16, 20, 3, 23, 19, 3, 21, 18, 57, 15, 2};
    }

    public static void A0B() {
        A0F = new String[]{"4yJhIog9RzpC9w4XHjq79o6hmz2pMXrt", "bLneqHgNlbzxjE", "P7gevZ65hMGDm5VmgpkLcWEi46YxYduR", "Pajg2XTKXpS0pN0AoGLcPnQoa2IWF6Z7", "YyJRdl3XxpBTstTmsw", "OvgbPt0JG7dlaj99kqPbJKVmb9CPKTVr", "21VbiQWRKHmC0d4xB3zoTsbqXtN2ZOxw", "Q3Y9mBD7X4l0uaedlY7FP5X0xCsXbtIX"};
    }

    public abstract void A0N();

    public abstract void A0Q(AbstractC00340n v, AnonymousClass90 v2, C02408y v3, Map<String, Object> map);

    static {
        A0B();
        A0A();
        C0537Lg.A02();
    }

    public AbstractC0690Re(C0820Wh wh, C00571k r7) {
        this.A0C = wh;
        this.A08 = r7;
        KF kf = A0I;
        if (kf != null) {
            this.A0B = kf;
        } else {
            this.A0B = new KF(this.A0C);
        }
        this.A0B.A0R(this);
        C00390s r0 = A0H;
        if (r0 != null) {
            this.A0A = r0;
        } else {
            this.A0A = new C00390s();
        }
        try {
            CookieManager.getInstance();
            if (Build.VERSION.SDK_INT < 21) {
                CookieSyncManager.createInstance(this.A0C);
            }
        } catch (Exception e) {
            Log.w(A0J, A08(48, 35, 112), e);
        }
        DynamicLoaderFactory.makeLoader(this.A0C).getInitApi().onAdLoadInvoked(this.A0C);
        this.A09 = wh.A06();
        this.A0C.A0A().A4W();
    }

    /* JADX INFO: Multiple debug info for r0v37 com.facebook.ads.redexgen.X.Wi: [D('dataObject' org.json.JSONObject), D('sdkContext' com.facebook.ads.redexgen.X.Wi)] */
    /* access modifiers changed from: private */
    public void A09() {
        this.A01 = null;
        AnonymousClass90 r5 = this.A05;
        C02408y A042 = r5.A04();
        String A082 = A08(0, 0, 73);
        if (A042 == null) {
            C0495Jm error = C0495Jm.A02(AdErrorType.NO_FILL, A082);
            this.A0C.A0A().A4Y(error.A04().getErrorCode(), A08(83, 22, 100));
            this.A07.A0F(error);
            return;
        }
        String A032 = A042.A03();
        AbstractC00340n A002 = this.A0A.A00(r5.A05().A0D());
        if (A002 == null) {
            this.A0C.A04().A82(A08(142, 3, 37), C02248i.A0P, new C02258j(A08(0, 22, 2), A032));
            A0O();
        } else if (this.A08.A00() != A002.A6i()) {
            C0495Jm error2 = C0495Jm.A02(AdErrorType.INTERNAL_ERROR, A082);
            this.A0C.A0A().A4Y(error2.A04().getErrorCode(), A08(105, 19, 7));
            this.A07.A0F(error2);
        } else {
            this.A01 = A002;
            AnonymousClass91 A052 = r5.A05();
            JSONObject A062 = A042.A06();
            if (A062 != null) {
                String[] strArr = A0F;
                if (strArr[0].charAt(1) != strArr[5].charAt(1)) {
                    String[] strArr2 = A0F;
                    strArr2[4] = "xCRhnlDAhS4MFpckcT";
                    strArr2[1] = "gHgyVSON2W8zeI";
                    String optString = A062.optString(A08(259, 10, 110));
                    this.A0C.A0A().AD5(optString);
                    this.A0C.A08(optString);
                    C0821Wi sdkContext = AnonymousClass8G.A00();
                    if (sdkContext != null) {
                        sdkContext.A08(optString);
                    }
                    if (A0F[2].charAt(5) != 'Z') {
                        String[] strArr3 = A0F;
                        strArr3[6] = "8Wq26Ceqv565ijof1GdoYggHtr98JF3l";
                        strArr3[6] = "8Wq26Ceqv565ijof1GdoYggHtr98JF3l";
                        A0E(A062.optJSONObject(A08(JfifUtil.MARKER_RST0, 17, 28)));
                    } else {
                        String[] strArr4 = A0F;
                        strArr4[4] = "ECm89W61U2RjXtlAFB";
                        strArr4[1] = "vfVrRI5o8HJ5sJ";
                        A0E(A062.optJSONObject(A08(JfifUtil.MARKER_RST0, 17, 75)));
                    }
                } else {
                    throw new RuntimeException();
                }
            }
            Map<String, Object> hashMap = new HashMap<>();
            hashMap.put(A08(147, 4, 55), A062);
            hashMap.put(A08(166, 10, 113), A052);
            hashMap.put(A08(237, 11, 72), this.A08.A08);
            hashMap.put(A08(248, 11, 125), Long.valueOf(A052.A0C()));
            hashMap.put(A08(151, 15, 93), A042.A04());
            if (this.A06 == null) {
                String A083 = A08(188, 20, 38);
                C0495Jm A022 = C0495Jm.A02(AdErrorType.UNKNOWN_ERROR, A083);
                this.A0C.A0A().A4Y(A022.A04().getErrorCode(), A083);
                this.A07.A0F(A022);
                return;
            }
            A0Q(A002, r5, A042, hashMap);
        }
    }

    /* JADX INFO: Multiple debug info for r5v0 'this'  com.facebook.ads.redexgen.X.Re: [D('e' com.facebook.ads.redexgen.X.Jn), D('bidPayload' com.facebook.ads.redexgen.X.Jx)] */
    private final void A0D(@Nullable String str, @Nullable AdExperienceType adExperienceType) {
        boolean z;
        AnonymousClass0S A0A2 = this.A0C.A0A();
        if (str != null) {
            z = true;
        } else {
            z = false;
        }
        A0A2.A4Z(z);
        this.A04 = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT < 17) {
            A9X(new C0495Jm(AdErrorType.API_NOT_SUPPORTED, A08(0, 0, 73)));
            return;
        }
        try {
            this.A06 = this.A08.A01(this.A0C, new C0505Jx(this.A0C, str, this.A08.A08, this.A08.A07), adExperienceType);
            if (A0F[6].charAt(21) != '6') {
                String[] strArr = A0F;
                strArr[4] = "3q2wB1pMY3UXfOrLgu";
                strArr[1] = "CsXqAZILgfX2KA";
                this.A0B.A0Q(this.A06);
                return;
            }
            throw new RuntimeException();
        } catch (C0496Jn e) {
            A9X(C0495Jm.A03(e));
        }
    }

    private void A0E(@Nullable JSONObject jSONObject) {
        if (jSONObject != null) {
            this.A03 = jSONObject.optString(A08(176, 12, 39));
            C00410u.A0H(jSONObject);
        }
    }

    public final long A0F() {
        AnonymousClass90 r0 = this.A05;
        if (r0 != null) {
            return r0.A03();
        }
        return -1;
    }

    public final Handler A0G() {
        return A0G;
    }

    public final AnonymousClass91 A0H() {
        AnonymousClass90 r0 = this.A05;
        if (r0 == null) {
            return null;
        }
        return r0.A05();
    }

    @Nullable
    public final String A0I() {
        AbstractC00340n r0 = this.A02;
        if (r0 == null) {
            return null;
        }
        return r0.A5j();
    }

    public final void A0J() {
        this.A0C.A0A().A2h(LW.A01(this.A04));
        if (this.A02 != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(A08(JfifUtil.MARKER_APP1, 12, 23), LW.A04(this.A04));
            new JL(this.A02.A5j(), this.A09).A03(JK.A08, hashMap);
        }
    }

    public final void A0K() {
        AbstractC00340n r3 = this.A02;
        String A082 = A08(142, 3, 37);
        if (r3 == null) {
            String A083 = A08(22, 26, 7);
            this.A0C.A04().A82(A082, C02248i.A0F, new C02258j(A083));
            AdErrorType adErrorType = AdErrorType.INTERNAL_ERROR;
            this.A0C.A0A().A4Y(adErrorType.getErrorCode(), A083);
            this.A07.A0F(C0495Jm.A02(adErrorType, adErrorType.getDefaultErrorMessage()));
            this.A0C.A0A().A4b();
        } else if (this.A0D) {
            String A084 = A08(124, 18, 67);
            this.A0C.A04().A82(A082, C02248i.A0C, new C02258j(A084));
            AdErrorType adErrorType2 = AdErrorType.AD_ALREADY_STARTED;
            this.A0C.A0A().A4Y(adErrorType2.getErrorCode(), A084);
            this.A07.A0F(C0495Jm.A02(adErrorType2, adErrorType2.getDefaultErrorMessage()));
            this.A0C.A0A().A4a();
        } else {
            if (!TextUtils.isEmpty(this.A02.A5j())) {
                this.A09.A8H(this.A02.A5j());
            }
            this.A0C.A0A().A4c();
            this.A0D = true;
            A0N();
        }
    }

    public final void A0L() {
        A0W(false);
    }

    public final void A0M() {
        String str = this.A03;
        if (str != null) {
            C00410u.A0E(str);
        }
    }

    public final synchronized void A0O() {
        A0G.post(new C0688Rc(this));
    }

    public final void A0P(AbstractC00340n r1) {
        if (r1 != null) {
            r1.onDestroy();
        }
    }

    public final void A0R(AbstractC00350o r1) {
        this.A07 = r1;
    }

    public void A0S(@Nullable String str) {
        A0D(str, null);
    }

    public final void A0T(@Nullable String str) {
        A0S(str);
    }

    public final void A0U(@Nullable String str, @Nullable AdExperienceType adExperienceType) {
        A0D(str, adExperienceType);
    }

    public final void A0V(Map<String, Object> map) {
        this.A0C.A0A().A4V();
        Object obj = map.get(A08(147, 4, 55));
        if (obj instanceof JSONObject) {
            String optString = ((JSONObject) obj).optString(A08(145, 2, 71));
            if (!TextUtils.isEmpty(optString)) {
                new JL(optString, this.A09).A03(JK.A04, null);
            }
        }
    }

    public final void A0W(boolean z) {
        if (z || this.A0D) {
            this.A0C.A0A().A4d();
            A0P(this.A02);
            this.A00 = null;
            this.A0D = false;
        }
    }

    public final boolean A0X() {
        AnonymousClass90 r0 = this.A05;
        return r0 == null || r0.A0A();
    }

    @Override // com.facebook.ads.redexgen.X.KE
    public final synchronized void A9X(C0495Jm jm) {
        A0G().post(new C0689Rd(this, jm));
    }

    @Override // com.facebook.ads.redexgen.X.KE
    public final synchronized void AB3(C0944aV aVVar) {
        A0G().post(new C0687Rb(this, aVVar));
    }
}
