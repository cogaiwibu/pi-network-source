package androidx.activity;

import androidx.lifecycle.LifecycleOwner;

public interface OnBackPressedDispatcherOwner extends LifecycleOwner {
    OnBackPressedDispatcher getOnBackPressedDispatcher();
}
