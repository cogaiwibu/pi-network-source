package com.facebook.common.util;

public class ExceptionWithNoStacktrace extends Exception {
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

    public ExceptionWithNoStacktrace(String str) {
        super(str);
    }
}
