package com.ironsource.sdk.data;

public class ISNError {
    public static final int ERROR_CODE_INIT_FAILED = 1001;
    private int mCode;
    private String mMsg;

    public ISNError(int i, String str) {
        this.mCode = i;
        this.mMsg = str == null ? "" : str;
    }

    public int getCode() {
        return this.mCode;
    }

    public String getMessage() {
        return this.mMsg;
    }

    public String toString() {
        return "error - code:" + this.mCode + ", message:" + this.mMsg;
    }
}
