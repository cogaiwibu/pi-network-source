package com.ironsource.sdk.service.Connectivity;

import android.content.Context;
import android.os.Build;
import com.ironsource.environment.ApplicationContext;
import com.ironsource.sdk.constants.Constants;
import com.ironsource.sdk.utils.Logger;
import org.json.JSONObject;

public abstract class ConnectivityAdapter implements IConnectivityStatus {
    private IConnectivity currentStrategy;

    @Override // com.ironsource.sdk.service.Connectivity.IConnectivityStatus
    public void onConnected(String str, JSONObject jSONObject) {
    }

    @Override // com.ironsource.sdk.service.Connectivity.IConnectivityStatus
    public void onDisconnected() {
    }

    @Override // com.ironsource.sdk.service.Connectivity.IConnectivityStatus
    public void onStatusChanged(String str, JSONObject jSONObject) {
    }

    protected ConnectivityAdapter(JSONObject jSONObject, Context context) {
        this.currentStrategy = decideStrategy(jSONObject, context);
        String simpleName = ConnectivityAdapter.class.getSimpleName();
        Logger.i(simpleName, "created ConnectivityAdapter with strategy " + this.currentStrategy.getClass().getSimpleName());
    }

    public void startListenToNetworkChanges(Context context) {
        this.currentStrategy.startListenToNetworkChanges(context);
    }

    public void stopListenToNetworkChanges(Context context) {
        this.currentStrategy.stopListenToNetworkChanges(context);
    }

    public JSONObject getConnectivityData(Context context) {
        return this.currentStrategy.getConnectivityInfo(context);
    }

    public void release() {
        this.currentStrategy.release();
    }

    private IConnectivity decideStrategy(JSONObject jSONObject, Context context) {
        if (jSONObject.optInt(Constants.RequestParameters.CONNECTIVITY_STRATEGY) == 1) {
            return new BroadcastReceiverStrategy(this);
        }
        boolean isPermissionGranted = ApplicationContext.isPermissionGranted(context, "android.permission.ACCESS_NETWORK_STATE");
        if (Build.VERSION.SDK_INT < 23 || !isPermissionGranted) {
            return new BroadcastReceiverStrategy(this);
        }
        return new NetworkCallbackStrategy(this);
    }
}
