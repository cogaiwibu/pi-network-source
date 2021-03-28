package com.facebook.react.modules.fresco;

import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.react.bridge.ReadableMap;

public class ReactNetworkImageRequest extends ImageRequest {
    private final ReadableMap mHeaders;

    public static ReactNetworkImageRequest fromBuilderWithHeaders(ImageRequestBuilder imageRequestBuilder, ReadableMap readableMap) {
        return new ReactNetworkImageRequest(imageRequestBuilder, readableMap);
    }

    protected ReactNetworkImageRequest(ImageRequestBuilder imageRequestBuilder, ReadableMap readableMap) {
        super(imageRequestBuilder);
        this.mHeaders = readableMap;
    }

    public ReadableMap getHeaders() {
        return this.mHeaders;
    }
}
