package com.facebook.react.modules.network;

import okhttp3.OkHttpClient;

public interface OkHttpClientFactory {
    OkHttpClient createNewNetworkModuleClient();
}
