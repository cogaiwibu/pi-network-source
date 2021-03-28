package androidx.lifecycle;

import androidx.lifecycle.ViewModelProvider;

public interface HasDefaultViewModelProviderFactory {
    ViewModelProvider.Factory getDefaultViewModelProviderFactory();
}
