package com.google.android.gms.dynamic;

import android.os.Bundle;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
final class zaa implements OnDelegateCreatedListener<T> {
    private final /* synthetic */ DeferredLifecycleHelper zart;

    zaa(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.zart = deferredLifecycleHelper;
    }

    @Override // com.google.android.gms.dynamic.OnDelegateCreatedListener
    public final void onDelegateCreated(T t) {
        DeferredLifecycleHelper.zaa(this.zart, (LifecycleDelegate) t);
        Iterator it = DeferredLifecycleHelper.zaa(this.zart).iterator();
        while (it.hasNext()) {
            ((DeferredLifecycleHelper.zaa) it.next()).zaa(DeferredLifecycleHelper.zab(this.zart));
        }
        DeferredLifecycleHelper.zaa(this.zart).clear();
        DeferredLifecycleHelper.zaa(this.zart, (Bundle) null);
    }
}
