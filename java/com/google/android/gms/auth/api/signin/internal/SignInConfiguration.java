package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
public final class SignInConfiguration extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInConfiguration> CREATOR = new zzx();
    private final String zzcu;
    private GoogleSignInOptions zzcv;

    public SignInConfiguration(String str, GoogleSignInOptions googleSignInOptions) {
        this.zzcu = Preconditions.checkNotEmpty(str);
        this.zzcv = googleSignInOptions;
    }

    public final GoogleSignInOptions zzu() {
        return this.zzcv;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzcu, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzcv, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SignInConfiguration)) {
            return false;
        }
        SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
        if (this.zzcu.equals(signInConfiguration.zzcu)) {
            GoogleSignInOptions googleSignInOptions = this.zzcv;
            if (googleSignInOptions == null) {
                if (signInConfiguration.zzcv == null) {
                    return true;
                }
            } else if (googleSignInOptions.equals(signInConfiguration.zzcv)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return new HashAccumulator().addObject(this.zzcu).addObject(this.zzcv).hash();
    }
}
