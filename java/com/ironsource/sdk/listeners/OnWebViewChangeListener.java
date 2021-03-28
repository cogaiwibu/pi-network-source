package com.ironsource.sdk.listeners;

public interface OnWebViewChangeListener {
    boolean onBackButtonPressed();

    void onCloseRequested();

    void onOrientationChanged(String str, int i);
}
