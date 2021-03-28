package com.google.android.gms.auth.api.credentials;

import com.google.android.gms.auth.api.Auth;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
public final class CredentialsOptions extends Auth.AuthCredentialsOptions {
    public static final CredentialsOptions DEFAULT = ((CredentialsOptions) new Builder().zze());

    /* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
    public static final class Builder extends Auth.AuthCredentialsOptions.Builder {
        @Override // com.google.android.gms.auth.api.Auth.AuthCredentialsOptions.Builder
        public final Builder forceEnableSaveDialog() {
            this.zzu = true;
            return this;
        }

        /* renamed from: build */
        public final CredentialsOptions zze() {
            return new CredentialsOptions(this);
        }

        @Override // com.google.android.gms.auth.api.Auth.AuthCredentialsOptions.Builder
        public final /* synthetic */ Auth.AuthCredentialsOptions.Builder zzc(String str) {
            this.zzn = str;
            return this;
        }
    }

    private CredentialsOptions(Builder builder) {
        super(builder);
    }
}
