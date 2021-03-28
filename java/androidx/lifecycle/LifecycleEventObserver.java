package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

public interface LifecycleEventObserver extends LifecycleObserver {
    void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event);
}
