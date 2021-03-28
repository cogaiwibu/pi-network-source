package com.facebook.imagepipeline.debug;

import com.facebook.common.references.SharedReference;
import javax.annotation.Nullable;

public interface CloseableReferenceLeakTracker {

    public interface Listener {
        void onCloseableReferenceLeak(SharedReference<Object> sharedReference, @Nullable Throwable th);
    }

    boolean isSet();

    void setListener(@Nullable Listener listener);

    void trackCloseableReferenceLeak(SharedReference<Object> sharedReference, @Nullable Throwable th);
}
