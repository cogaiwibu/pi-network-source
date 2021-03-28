package com.ironsource.mediationsdk.sdk;

import com.ironsource.mediationsdk.logger.IronSourceError;

public interface InternalOfferwallListener extends OfferwallListener {
    void onOfferwallAvailable(boolean z, IronSourceError ironSourceError);
}
