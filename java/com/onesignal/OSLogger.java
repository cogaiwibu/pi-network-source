package com.onesignal;

public interface OSLogger {
    void debug(String str);

    void error(String str, Throwable th);

    void verbose(String str);

    void warning(String str);
}
