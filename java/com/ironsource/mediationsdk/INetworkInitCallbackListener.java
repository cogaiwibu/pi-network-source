package com.ironsource.mediationsdk;

public interface INetworkInitCallbackListener {
    void onNetworkInitCallbackFailed(String str);

    void onNetworkInitCallbackLoadSuccess(String str);

    void onNetworkInitCallbackSuccess();
}
