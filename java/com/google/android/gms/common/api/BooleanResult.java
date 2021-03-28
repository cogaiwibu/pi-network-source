package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.Preconditions;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public class BooleanResult implements Result {
    private final Status mStatus;
    private final boolean zabi;

    public BooleanResult(Status status, boolean z) {
        this.mStatus = (Status) Preconditions.checkNotNull(status, "Status must not be null");
        this.zabi = z;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.mStatus;
    }

    public boolean getValue() {
        return this.zabi;
    }

    public final int hashCode() {
        return ((this.mStatus.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + (this.zabi ? 1 : 0);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BooleanResult)) {
            return false;
        }
        BooleanResult booleanResult = (BooleanResult) obj;
        return this.mStatus.equals(booleanResult.mStatus) && this.zabi == booleanResult.zabi;
    }
}
