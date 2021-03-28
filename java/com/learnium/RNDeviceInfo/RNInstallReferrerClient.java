package com.learnium.RNDeviceInfo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.RemoteException;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import java.io.PrintStream;

public class RNInstallReferrerClient {
    private InstallReferrerStateListener installReferrerStateListener = new InstallReferrerStateListener() {
        /* class com.learnium.RNDeviceInfo.RNInstallReferrerClient.AnonymousClass1 */

        @Override // com.android.installreferrer.api.InstallReferrerStateListener
        public void onInstallReferrerSetupFinished(int i) {
            if (i == 0) {
                try {
                    ReferrerDetails installReferrer = RNInstallReferrerClient.this.mReferrerClient.getInstallReferrer();
                    installReferrer.getInstallReferrer();
                    installReferrer.getReferrerClickTimestampSeconds();
                    installReferrer.getInstallBeginTimestampSeconds();
                    SharedPreferences.Editor edit = RNInstallReferrerClient.this.sharedPreferences.edit();
                    edit.putString("installReferrer", RNInstallReferrerClient.this.getInstallReferrer());
                    edit.apply();
                    RNInstallReferrerClient.this.mReferrerClient.endConnection();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.android.installreferrer.api.InstallReferrerStateListener
        public void onInstallReferrerServiceDisconnected() {
            RNInstallReferrerClient.this.mReferrerClient.startConnection(RNInstallReferrerClient.this.installReferrerStateListener);
        }
    };
    private InstallReferrerClient mReferrerClient;
    private SharedPreferences sharedPreferences;

    RNInstallReferrerClient(Context context) {
        this.sharedPreferences = context.getSharedPreferences("react-native-device-info", 0);
        InstallReferrerClient build = InstallReferrerClient.newBuilder(context).build();
        this.mReferrerClient = build;
        try {
            build.startConnection(this.installReferrerStateListener);
        } catch (Exception e) {
            PrintStream printStream = System.err;
            printStream.println("InstallReferrer exception. getInstallReferrer will be unavailable: " + e.getMessage());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String getInstallReferrer() {
        try {
            return this.mReferrerClient.getInstallReferrer().getInstallReferrer();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }
}
