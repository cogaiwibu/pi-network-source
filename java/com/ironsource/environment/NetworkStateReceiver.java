package com.ironsource.environment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkStateReceiver extends BroadcastReceiver {
    private boolean mConnected;
    private NetworkStateReceiverListener mListener;
    private ConnectivityManager mManager;

    public NetworkStateReceiver(Context context, NetworkStateReceiverListener networkStateReceiverListener) {
        this.mListener = networkStateReceiverListener;
        this.mManager = (ConnectivityManager) context.getSystemService("connectivity");
        checkAndSetState();
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getExtras() != null && checkAndSetState()) {
            notifyState();
        }
    }

    private boolean checkAndSetState() {
        boolean z = this.mConnected;
        NetworkInfo activeNetworkInfo = this.mManager.getActiveNetworkInfo();
        boolean z2 = activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
        this.mConnected = z2;
        if (z != z2) {
            return true;
        }
        return false;
    }

    private void notifyState() {
        NetworkStateReceiverListener networkStateReceiverListener = this.mListener;
        if (networkStateReceiverListener == null) {
            return;
        }
        if (this.mConnected) {
            networkStateReceiverListener.onNetworkAvailabilityChanged(true);
        } else {
            networkStateReceiverListener.onNetworkAvailabilityChanged(false);
        }
    }
}
