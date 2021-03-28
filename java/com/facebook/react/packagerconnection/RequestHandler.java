package com.facebook.react.packagerconnection;

public interface RequestHandler {
    void onNotification(Object obj);

    void onRequest(Object obj, Responder responder);
}
