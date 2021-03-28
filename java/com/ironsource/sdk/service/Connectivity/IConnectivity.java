package com.ironsource.sdk.service.Connectivity;

import android.content.Context;
import org.json.JSONObject;

public interface IConnectivity {
    JSONObject getConnectivityInfo(Context context);

    void release();

    void startListenToNetworkChanges(Context context);

    void stopListenToNetworkChanges(Context context);
}
