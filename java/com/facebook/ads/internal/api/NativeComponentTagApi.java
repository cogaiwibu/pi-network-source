package com.facebook.ads.internal.api;

import android.view.View;
import com.facebook.ads.NativeAdBase;

public interface NativeComponentTagApi {
    void tagView(View view, NativeAdBase.NativeComponentTag nativeComponentTag);
}
