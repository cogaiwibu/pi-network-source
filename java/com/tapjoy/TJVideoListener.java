package com.tapjoy;

public interface TJVideoListener {
    void onVideoComplete();

    void onVideoError(int i);

    void onVideoStart();
}
