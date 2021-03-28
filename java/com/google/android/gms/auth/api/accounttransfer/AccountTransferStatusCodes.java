package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.common.api.CommonStatusCodes;

public final class AccountTransferStatusCodes extends CommonStatusCodes {
    public static final int CHALLENGE_NOT_ALLOWED = 20503;
    public static final int INVALID_REQUEST = 20502;
    public static final int NOT_ALLOWED_SECURITY = 20500;
    public static final int NO_DATA_AVAILABLE = 20501;
    public static final int SESSION_INACTIVE = 20504;

    public static String getStatusCodeString(int i) {
        switch (i) {
            case NOT_ALLOWED_SECURITY /*{ENCODED_INT: 20500}*/:
                return "NOT_ALLOWED_SECURITY";
            case NO_DATA_AVAILABLE /*{ENCODED_INT: 20501}*/:
                return "NO_DATA_AVAILABLE";
            case INVALID_REQUEST /*{ENCODED_INT: 20502}*/:
                return "INVALID_REQUEST";
            case CHALLENGE_NOT_ALLOWED /*{ENCODED_INT: 20503}*/:
                return "CHALLENGE_NOT_ALLOWED";
            case SESSION_INACTIVE /*{ENCODED_INT: 20504}*/:
                return "SESSION_INACTIVE";
            default:
                return CommonStatusCodes.getStatusCodeString(i);
        }
    }

    private AccountTransferStatusCodes() {
    }
}
