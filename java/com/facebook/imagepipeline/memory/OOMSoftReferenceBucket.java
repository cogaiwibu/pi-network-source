package com.facebook.imagepipeline.memory;

import com.facebook.common.references.OOMSoftReference;
import java.util.LinkedList;

class OOMSoftReferenceBucket<V> extends Bucket<V> {
    private LinkedList<OOMSoftReference<V>> mSpareReferences = new LinkedList<>();

    public OOMSoftReferenceBucket(int i, int i2, int i3) {
        super(i, i2, i3, false);
    }

    @Override // com.facebook.imagepipeline.memory.Bucket
    public V pop() {
        OOMSoftReference<V> oOMSoftReference = (OOMSoftReference) this.mFreeList.poll();
        V v = oOMSoftReference.get();
        oOMSoftReference.clear();
        this.mSpareReferences.add(oOMSoftReference);
        return v;
    }

    /* access modifiers changed from: package-private */
    @Override // com.facebook.imagepipeline.memory.Bucket
    public void addToFreeList(V v) {
        OOMSoftReference<V> poll = this.mSpareReferences.poll();
        if (poll == null) {
            poll = new OOMSoftReference<>();
        }
        poll.set(v);
        this.mFreeList.add(poll);
    }
}
