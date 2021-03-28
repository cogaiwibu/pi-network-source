package com.android.installreferrer.api;

public interface InstallReferrerStateListener {
    void onInstallReferrerServiceDisconnected();

    void onInstallReferrerSetupFinished(int i);
}
