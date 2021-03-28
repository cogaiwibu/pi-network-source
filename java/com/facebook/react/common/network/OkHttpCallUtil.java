package com.facebook.react.common.network;

import okhttp3.Call;
import okhttp3.OkHttpClient;

public class OkHttpCallUtil {
    private OkHttpCallUtil() {
    }

    public static void cancelTag(OkHttpClient okHttpClient, Object obj) {
        for (Call call : okHttpClient.dispatcher().queuedCalls()) {
            if (obj.equals(call.request().tag())) {
                call.cancel();
                return;
            }
        }
        for (Call call2 : okHttpClient.dispatcher().runningCalls()) {
            if (obj.equals(call2.request().tag())) {
                call2.cancel();
                return;
            }
        }
    }
}
