package com.ironsource.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class ConnectivityUtils {
    public static String getConnectionType(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return getConnectionType(getActiveNetwork(context), context);
        }
        return getConnectionTypePreMOSVersion(context);
    }

    public static String getConnectionType(Network network, Context context) {
        String connectionTypePreMOSVersion;
        if (context == null) {
            return "none";
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (network == null || connectivityManager == null) {
            return "none";
        }
        try {
            if (Build.VERSION.SDK_INT < 21) {
                return getConnectionTypePreMOSVersion(context);
            }
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
            if (networkCapabilities == null) {
                return getConnectionTypePreMOSVersion(context);
            }
            if (networkCapabilities.hasTransport(1)) {
                connectionTypePreMOSVersion = "wifi";
            } else if (networkCapabilities.hasTransport(0)) {
                connectionTypePreMOSVersion = ConnectivityService.NETWORK_TYPE_3G;
            } else {
                connectionTypePreMOSVersion = getConnectionTypePreMOSVersion(context);
            }
            return connectionTypePreMOSVersion;
        } catch (Exception e) {
            e.printStackTrace();
            return "none";
        }
    }

    public static Network getActiveNetwork(Context context) {
        if (context == null) {
            return null;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (Build.VERSION.SDK_INT < 23 || connectivityManager == null) {
            return null;
        }
        return connectivityManager.getActiveNetwork();
    }

    public static JSONObject getNetworkData(Context context, Network network) {
        NetworkCapabilities networkCapabilities;
        if (context == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        if (Build.VERSION.SDK_INT >= 23 && network != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (!(connectivityManager == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(network)) == null)) {
                    jSONObject.put("networkCapabilities", networkCapabilities.toString());
                    jSONObject.put("downloadSpeed", networkCapabilities.getLinkDownstreamBandwidthKbps());
                    jSONObject.put("uploadSpeed", networkCapabilities.getLinkUpstreamBandwidthKbps());
                    jSONObject.put("hasVPN", hasVPN(context));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    private static String getConnectionTypePreMOSVersion(Context context) {
        String connectionType = ConnectivityService.getConnectionType(context);
        return TextUtils.isEmpty(connectionType) ? "none" : connectionType;
    }

    public static boolean hasVPN(Context context) {
        return getNetworkTransport(context, getActiveNetwork(context)).equals("vpn");
    }

    private static String getNetworkTransport(Context context, Network network) {
        NetworkCapabilities networkCapabilities;
        if (!(Build.VERSION.SDK_INT < 23 || network == null || context == null)) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(network)) == null) {
                    return "";
                }
                if (networkCapabilities.hasTransport(1)) {
                    return "wifi";
                }
                if (networkCapabilities.hasTransport(0)) {
                    return ConnectivityService.NETWORK_TYPE_CELLULAR;
                }
                if (networkCapabilities.hasTransport(4)) {
                    return "vpn";
                }
                if (networkCapabilities.hasTransport(3)) {
                    return ConnectivityService.NETWORK_TYPE_ETHERNET;
                }
                if (networkCapabilities.hasTransport(5)) {
                    return ConnectivityService.NETWORK_TYPE_WIFI_AWARE;
                }
                if (networkCapabilities.hasTransport(6)) {
                    return ConnectivityService.NETWORK_TYPE_LOWPAN;
                }
                if (networkCapabilities.hasTransport(2)) {
                    return ConnectivityService.NETWORK_TYPE_BLUETOOTH;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }
}
