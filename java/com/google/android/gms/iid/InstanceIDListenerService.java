package com.google.android.gms.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

@Deprecated
public class InstanceIDListenerService extends zze {
    public void onTokenRefresh() {
    }

    @Override // com.google.android.gms.iid.zze
    public void handleIntent(Intent intent) {
        if ("com.google.android.gms.iid.InstanceID".equals(intent.getAction())) {
            Bundle bundle = null;
            String stringExtra = intent.getStringExtra("subtype");
            if (stringExtra != null) {
                bundle = new Bundle();
                bundle.putString("subtype", stringExtra);
            }
            InstanceID instance = InstanceID.getInstance(this, bundle);
            String stringExtra2 = intent.getStringExtra("CMD");
            if (Log.isLoggable("InstanceID", 3)) {
                StringBuilder sb = new StringBuilder(String.valueOf(stringExtra).length() + 34 + String.valueOf(stringExtra2).length());
                sb.append("Service command. subtype:");
                sb.append(stringExtra);
                sb.append(" command:");
                sb.append(stringExtra2);
                Log.d("InstanceID", sb.toString());
            }
            if ("RST".equals(stringExtra2)) {
                instance.zzo();
                onTokenRefresh();
            } else if ("RST_FULL".equals(stringExtra2)) {
                if (!InstanceID.zzp().isEmpty()) {
                    InstanceID.zzp().zzz();
                    onTokenRefresh();
                }
            } else if ("SYNC".equals(stringExtra2)) {
                zzak zzp = InstanceID.zzp();
                String valueOf = String.valueOf(stringExtra);
                zzp.zzi("|T|".length() != 0 ? valueOf.concat("|T|") : new String(valueOf));
                String valueOf2 = String.valueOf(stringExtra);
                zzp.zzi("|T-timestamp|".length() != 0 ? valueOf2.concat("|T-timestamp|") : new String(valueOf2));
                onTokenRefresh();
            }
        }
    }

    static void zzd(Context context, zzak zzak) {
        zzak.zzz();
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.putExtra("CMD", "RST");
        intent.setClassName(context, "com.google.android.gms.gcm.GcmReceiver");
        context.sendBroadcast(intent);
    }
}
