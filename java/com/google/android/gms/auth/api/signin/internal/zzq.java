package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
public final class zzq {
    private static zzq zzcq;
    private Storage zzcr;
    private GoogleSignInAccount zzcs;
    private GoogleSignInOptions zzct = this.zzcr.getSavedDefaultGoogleSignInOptions();

    private zzq(Context context) {
        Storage instance = Storage.getInstance(context);
        this.zzcr = instance;
        this.zzcs = instance.getSavedDefaultGoogleSignInAccount();
    }

    public static synchronized zzq zzd(Context context) {
        zzq zze;
        synchronized (zzq.class) {
            zze = zze(context.getApplicationContext());
        }
        return zze;
    }

    private static synchronized zzq zze(Context context) {
        synchronized (zzq.class) {
            if (zzcq != null) {
                return zzcq;
            }
            zzq zzq = new zzq(context);
            zzcq = zzq;
            return zzq;
        }
    }

    public final synchronized void clear() {
        this.zzcr.clear();
        this.zzcs = null;
        this.zzct = null;
    }

    public final synchronized void zzc(GoogleSignInOptions googleSignInOptions, GoogleSignInAccount googleSignInAccount) {
        this.zzcr.saveDefaultGoogleSignInAccount(googleSignInAccount, googleSignInOptions);
        this.zzcs = googleSignInAccount;
        this.zzct = googleSignInOptions;
    }

    public final synchronized GoogleSignInAccount zzr() {
        return this.zzcs;
    }

    public final synchronized GoogleSignInOptions zzs() {
        return this.zzct;
    }
}
