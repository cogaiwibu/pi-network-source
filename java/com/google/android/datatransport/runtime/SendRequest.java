package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.runtime.AutoValue_SendRequest;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public abstract class SendRequest {
    public abstract Encoding getEncoding();

    /* access modifiers changed from: package-private */
    public abstract Event<?> getEvent();

    /* access modifiers changed from: package-private */
    public abstract Transformer<?, byte[]> getTransformer();

    public abstract TransportContext getTransportContext();

    public abstract String getTransportName();

    SendRequest() {
    }

    public byte[] getPayload() {
        return getTransformer().apply(getEvent().getPayload());
    }

    public static Builder builder() {
        return new AutoValue_SendRequest.Builder();
    }

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public static abstract class Builder {
        public abstract SendRequest build();

        /* access modifiers changed from: package-private */
        public abstract Builder setEncoding(Encoding encoding);

        /* access modifiers changed from: package-private */
        public abstract Builder setEvent(Event<?> event);

        /* access modifiers changed from: package-private */
        public abstract Builder setTransformer(Transformer<?, byte[]> transformer);

        public abstract Builder setTransportContext(TransportContext transportContext);

        public abstract Builder setTransportName(String str);

        public <T> Builder setEvent(Event<T> event, Encoding encoding, Transformer<T, byte[]> transformer) {
            setEvent(event);
            setEncoding(encoding);
            setTransformer(transformer);
            return this;
        }
    }
}
