package com.facebook.drawee.backends.pipeline.info;

public interface ImagePerfDataListener {
    void onImageLoadStatusUpdated(ImagePerfData imagePerfData, int i);

    void onImageVisibilityUpdated(ImagePerfData imagePerfData, int i);
}
