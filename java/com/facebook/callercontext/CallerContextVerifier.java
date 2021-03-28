package com.facebook.callercontext;

import javax.annotation.Nullable;

public interface CallerContextVerifier {
    void verifyCallerContext(@Nullable Object obj);
}
