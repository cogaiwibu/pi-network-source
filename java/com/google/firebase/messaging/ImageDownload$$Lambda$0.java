package com.google.firebase.messaging;

import java.util.concurrent.Callable;

/* access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
public final /* synthetic */ class ImageDownload$$Lambda$0 implements Callable {
    private final ImageDownload arg$1;

    ImageDownload$$Lambda$0(ImageDownload imageDownload) {
        this.arg$1 = imageDownload;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.arg$1.blockingDownload();
    }
}
