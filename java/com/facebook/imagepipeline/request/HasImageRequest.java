package com.facebook.imagepipeline.request;

import javax.annotation.Nullable;

public interface HasImageRequest {
    @Nullable
    ImageRequest getImageRequest();
}
