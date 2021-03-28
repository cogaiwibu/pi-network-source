package com.google.firebase.installations;

import com.google.firebase.installations.local.PersistedInstallationEntry;

/* access modifiers changed from: package-private */
public interface StateListener {
    boolean onException(Exception exc);

    boolean onStateReached(PersistedInstallationEntry persistedInstallationEntry);
}
