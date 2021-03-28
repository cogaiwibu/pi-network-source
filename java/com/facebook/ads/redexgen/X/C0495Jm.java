package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.ads.AdError;
import com.facebook.ads.internal.protocol.AdErrorType;

/* renamed from: com.facebook.ads.redexgen.X.Jm  reason: case insensitive filesystem */
public final class C0495Jm {
    public final AdErrorType A00;
    public final String A01;

    public C0495Jm(int i, String str) {
        this(AdErrorType.adErrorTypeFromCode(i), str);
    }

    public C0495Jm(AdErrorType adErrorType, @Nullable String str) {
        str = TextUtils.isEmpty(str) ? adErrorType.getDefaultErrorMessage() : str;
        this.A00 = adErrorType;
        this.A01 = str;
    }

    public static AdError A00(C0495Jm jm) {
        if (jm.A04().isPublicError()) {
            return new AdError(jm.A04().getErrorCode(), jm.A05());
        }
        return new AdError(AdErrorType.UNKNOWN_ERROR.getErrorCode(), AdErrorType.UNKNOWN_ERROR.getDefaultErrorMessage());
    }

    public static C0495Jm A01(AdErrorType adErrorType) {
        return new C0495Jm(adErrorType, (String) null);
    }

    public static C0495Jm A02(AdErrorType adErrorType, @Nullable String str) {
        return new C0495Jm(adErrorType, str);
    }

    public static C0495Jm A03(C0496Jn jn) {
        return new C0495Jm(jn.A00(), jn.A01());
    }

    public final AdErrorType A04() {
        return this.A00;
    }

    public final String A05() {
        return this.A01;
    }
}
