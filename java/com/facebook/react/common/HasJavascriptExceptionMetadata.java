package com.facebook.react.common;

import javax.annotation.Nullable;

public interface HasJavascriptExceptionMetadata {
    @Nullable
    String getExtraDataAsJson();
}
