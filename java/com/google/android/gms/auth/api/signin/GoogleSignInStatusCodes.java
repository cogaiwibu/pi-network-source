package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.CommonStatusCodes;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
public final class GoogleSignInStatusCodes extends CommonStatusCodes {
    public static final int SIGN_IN_CANCELLED = 12501;
    public static final int SIGN_IN_CURRENTLY_IN_PROGRESS = 12502;
    public static final int SIGN_IN_FAILED = 12500;

    public static String getStatusCodeString(int i) {
        switch (i) {
            case SIGN_IN_FAILED /*{ENCODED_INT: 12500}*/:
                return "A non-recoverable sign in failure occurred";
            case SIGN_IN_CANCELLED /*{ENCODED_INT: 12501}*/:
                return "Sign in action cancelled";
            case SIGN_IN_CURRENTLY_IN_PROGRESS /*{ENCODED_INT: 12502}*/:
                return "Sign-in in progress";
            default:
                return CommonStatusCodes.getStatusCodeString(i);
        }
    }

    private GoogleSignInStatusCodes() {
    }
}
