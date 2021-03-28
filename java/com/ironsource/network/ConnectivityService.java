package com.ironsource.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

public class ConnectivityService {
    public static final String NETWORK_TYPE_3G = "3g";
    public static final String NETWORK_TYPE_BLUETOOTH = "bluetooth";
    public static final String NETWORK_TYPE_CELLULAR = "cellular";
    public static final String NETWORK_TYPE_ETHERNET = "ethernet";
    public static final String NETWORK_TYPE_LOWPAN = "lowpan";
    public static final String NETWORK_TYPE_NONE = "none";
    public static final String NETWORK_TYPE_VPN = "vpn";
    public static final String NETWORK_TYPE_WIFI = "wifi";
    public static final String NETWORK_TYPE_WIFI_AWARE = "wifiAware";

    public static String getConnectionType(Context context) {
        NetworkInfo activeNetworkInfo;
        StringBuilder sb = new StringBuilder();
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (!(connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected())) {
            String typeName = activeNetworkInfo.getTypeName();
            int type = activeNetworkInfo.getType();
            if (type == 0) {
                sb.append(NETWORK_TYPE_3G);
            } else if (type == 1) {
                sb.append("wifi");
            } else {
                sb.append(typeName);
            }
        }
        return sb.toString();
    }

    public static boolean isConnectedWifi(Context context) {
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1);
        if (networkInfo == null || !networkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    public static boolean isConnectedMobile(Context context) {
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(0);
        if (networkInfo == null || !networkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    public static boolean isConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static String getNetworkOperator(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static int getNetworkMCC(Context context) {
        try {
            return context.getResources().getConfiguration().mcc;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int getNetworkMNC(Context context) {
        try {
            return context.getResources().getConfiguration().mnc;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static String getSimOperator(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return telephonyManager.getSimOperator();
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static int getPhoneType(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getPhoneType();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
