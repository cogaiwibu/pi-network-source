package com.google.zxing.oned.rss.expanded.decoders;

/* access modifiers changed from: package-private */
public abstract class DecodedObject {
    private final int newPosition;

    DecodedObject(int i) {
        this.newPosition = i;
    }

    /* access modifiers changed from: package-private */
    public final int getNewPosition() {
        return this.newPosition;
    }
}
