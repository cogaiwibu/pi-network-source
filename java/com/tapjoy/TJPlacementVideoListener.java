package com.tapjoy;

public interface TJPlacementVideoListener {
    void onVideoComplete(TJPlacement tJPlacement);

    void onVideoError(TJPlacement tJPlacement, String str);

    void onVideoStart(TJPlacement tJPlacement);
}
