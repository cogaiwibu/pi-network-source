package com.facebook.drawee.backends.pipeline.info;

import java.util.Collection;

public class ForwardingImagePerfDataListener implements ImagePerfDataListener {
    private final Collection<ImagePerfDataListener> mListeners;

    public ForwardingImagePerfDataListener(Collection<ImagePerfDataListener> collection) {
        this.mListeners = collection;
    }

    @Override // com.facebook.drawee.backends.pipeline.info.ImagePerfDataListener
    public void onImageLoadStatusUpdated(ImagePerfData imagePerfData, int i) {
        for (ImagePerfDataListener imagePerfDataListener : this.mListeners) {
            imagePerfDataListener.onImageLoadStatusUpdated(imagePerfData, i);
        }
    }

    @Override // com.facebook.drawee.backends.pipeline.info.ImagePerfDataListener
    public void onImageVisibilityUpdated(ImagePerfData imagePerfData, int i) {
        for (ImagePerfDataListener imagePerfDataListener : this.mListeners) {
            imagePerfDataListener.onImageVisibilityUpdated(imagePerfData, i);
        }
    }
}
