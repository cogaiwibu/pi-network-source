package com.facebook.ads.internal.api;

import com.facebook.ads.NativeAdLayout;

public interface NativeAdLayoutApi extends AdComponentViewApiProvider {
    void initialize(NativeAdLayout nativeAdLayout);

    void setMaxWidth(int i);

    void setMinWidth(int i);
}
