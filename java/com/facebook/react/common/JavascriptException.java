package com.facebook.react.common;

import javax.annotation.Nullable;

public class JavascriptException extends RuntimeException implements HasJavascriptExceptionMetadata {
    @Nullable
    private String extraDataAsJson;

    public JavascriptException(String str) {
        super(str);
    }

    @Override // com.facebook.react.common.HasJavascriptExceptionMetadata
    @Nullable
    public String getExtraDataAsJson() {
        return this.extraDataAsJson;
    }

    public JavascriptException setExtraDataAsJson(@Nullable String str) {
        this.extraDataAsJson = str;
        return this;
    }
}
