package com.tapjoy;

public class TJError {
    public int code;
    public String message;

    public TJError(int i, String str) {
        this.code = i;
        this.message = str;
    }
}
