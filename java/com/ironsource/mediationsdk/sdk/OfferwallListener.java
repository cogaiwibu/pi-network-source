package com.ironsource.mediationsdk.sdk;

import com.ironsource.mediationsdk.logger.IronSourceError;

public interface OfferwallListener {
    void onGetOfferwallCreditsFailed(IronSourceError ironSourceError);

    boolean onOfferwallAdCredited(int i, int i2, boolean z);

    void onOfferwallAvailable(boolean z);

    void onOfferwallClosed();

    void onOfferwallOpened();

    void onOfferwallShowFailed(IronSourceError ironSourceError);
}
