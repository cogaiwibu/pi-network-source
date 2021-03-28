package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public abstract class PersistedEvent {
    public abstract EventInternal getEvent();

    public abstract long getId();

    public abstract TransportContext getTransportContext();

    public static PersistedEvent create(long j, TransportContext transportContext, EventInternal eventInternal) {
        return new AutoValue_PersistedEvent(j, transportContext, eventInternal);
    }
}
