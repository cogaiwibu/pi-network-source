package com.bytedance.sdk.openadsdk;

import android.graphics.Bitmap;

public interface TTDrawFeedAd extends TTFeedAd {
    void setCanInterruptVideoPlay(boolean z);

    void setPauseIcon(Bitmap bitmap, int i);
}
