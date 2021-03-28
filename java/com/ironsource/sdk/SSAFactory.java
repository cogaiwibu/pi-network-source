package com.ironsource.sdk;

import android.app.Activity;
import com.ironsource.sdk.agent.IronSourceAdsPublisherAgent;

@Deprecated
public class SSAFactory {
    public static SSAPublisher getPublisherInstance(Activity activity) throws Exception {
        return IronSourceAdsPublisherAgent.getInstance(activity);
    }

    public static SSAPublisher getPublisherTestInstance(Activity activity, int i) throws Exception {
        return IronSourceAdsPublisherAgent.getInstance(activity, i);
    }
}
