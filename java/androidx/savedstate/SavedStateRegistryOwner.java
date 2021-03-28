package androidx.savedstate;

import androidx.lifecycle.LifecycleOwner;

public interface SavedStateRegistryOwner extends LifecycleOwner {
    SavedStateRegistry getSavedStateRegistry();
}
