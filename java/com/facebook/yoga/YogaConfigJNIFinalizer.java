package com.facebook.yoga;

public class YogaConfigJNIFinalizer extends YogaConfigJNIBase {
    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            freeNatives();
        } finally {
            super.finalize();
        }
    }

    public void freeNatives() {
        if (this.mNativePointer != 0) {
            long j = this.mNativePointer;
            this.mNativePointer = 0;
            YogaNative.jni_YGConfigFreeJNI(j);
        }
    }
}
