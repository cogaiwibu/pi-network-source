package com.facebook.imagepipeline.common;

public class TooManyBitmapsException extends RuntimeException {
    public TooManyBitmapsException() {
    }

    public TooManyBitmapsException(String str) {
        super(str);
    }
}
