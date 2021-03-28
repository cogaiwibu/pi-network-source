package com.google.android.datatransport.runtime.backends;

import dagger.Binds;
import dagger.Module;

@Module
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public abstract class BackendRegistryModule {
    /* access modifiers changed from: package-private */
    @Binds
    public abstract BackendRegistry backendRegistry(MetadataBackendRegistry metadataBackendRegistry);
}
