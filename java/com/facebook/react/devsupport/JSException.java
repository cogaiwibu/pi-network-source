package com.facebook.react.devsupport;

public class JSException extends Exception {
    private final String mStack;

    public JSException(String str, String str2, Throwable th) {
        super(str, th);
        this.mStack = str2;
    }

    public JSException(String str, String str2) {
        super(str);
        this.mStack = str2;
    }

    public String getStack() {
        return this.mStack;
    }
}
