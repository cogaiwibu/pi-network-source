package com.google.android.gms.auth.api.identity;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p001authapi.zzak;
import com.google.android.gms.internal.p001authapi.zzao;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
public final class Identity {
    private Identity() {
    }

    public static SignInClient getSignInClient(Activity activity) {
        return new zzao((Activity) Preconditions.checkNotNull(activity), zzl.zzj().zzk());
    }

    public static SignInClient getSignInClient(Context context) {
        return new zzao((Context) Preconditions.checkNotNull(context), zzl.zzj().zzk());
    }

    public static CredentialSavingClient getCredentialSavingClient(Activity activity) {
        return new zzak((Activity) Preconditions.checkNotNull(activity), zzf.zzg().zzi());
    }

    public static CredentialSavingClient getCredentialSavingClient(Context context) {
        return new zzak((Context) Preconditions.checkNotNull(context), zzf.zzg().zzi());
    }
}
