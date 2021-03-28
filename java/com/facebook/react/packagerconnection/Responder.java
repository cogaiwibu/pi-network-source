package com.facebook.react.packagerconnection;

public interface Responder {
    void error(Object obj);

    void respond(Object obj);
}
