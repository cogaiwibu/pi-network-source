package com.tapjoy;

public interface TJActionRequest {
    void cancelled();

    void completed();

    String getRequestId();

    String getToken();
}
