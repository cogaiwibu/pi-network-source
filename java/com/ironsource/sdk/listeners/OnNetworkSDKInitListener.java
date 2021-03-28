package com.ironsource.sdk.listeners;

import com.ironsource.sdk.data.ISNError;

public interface OnNetworkSDKInitListener {
    void onFail(ISNError iSNError);

    void onSuccess();
}
