package com.ironsource.sdk.controller;

public interface VideoEventsListener {
    void onVideoEnded();

    void onVideoPaused();

    void onVideoResumed();

    void onVideoStarted();

    void onVideoStopped();
}
