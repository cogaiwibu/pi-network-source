package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
final class zzk extends zzc {
    private final /* synthetic */ zzh zzcn;

    zzk(zzh zzh) {
        this.zzcn = zzh;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzr, com.google.android.gms.auth.api.signin.internal.zzc
    public final void zzc(GoogleSignInAccount googleSignInAccount, Status status) throws RemoteException {
        if (googleSignInAccount != null) {
            zzq.zzd(this.zzcn.val$context).zzc(this.zzcn.zzcm, googleSignInAccount);
        }
        this.zzcn.setResult((Result) new GoogleSignInResult(googleSignInAccount, status));
    }
}
