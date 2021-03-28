package com.facebook.react.modules.network;

import okhttp3.Interceptor;

public interface NetworkInterceptorCreator {
    Interceptor create();
}
