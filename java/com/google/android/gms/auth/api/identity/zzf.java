package com.google.android.gms.auth.api.identity;

import android.os.Bundle;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.tapjoy.TapjoyConstants;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
public class zzf implements Api.ApiOptions.Optional {
    private final String zzau;

    /* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
    public static class zzc {
        private String zzau;

        private zzc() {
        }

        public static zzc zzc(zzf zzf) {
            zzc zzc = new zzc();
            String zzh = zzf.zzh();
            if (zzh != null) {
                zzc.zze(zzh);
            }
            return zzc;
        }

        public final zzc zze(String str) {
            this.zzau = Preconditions.checkNotEmpty(str);
            return this;
        }

        public final zzf zzi() {
            return new zzf(this.zzau);
        }
    }

    public static zzc zzg() {
        return new zzc();
    }

    public zzf(String str) {
        this.zzau = str;
    }

    public final String zzh() {
        return this.zzau;
    }

    public boolean equals(Object obj) {
        return obj instanceof zzf;
    }

    public int hashCode() {
        return Objects.hashCode(zzf.class);
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(TapjoyConstants.TJC_SESSION_ID, this.zzau);
        return bundle;
    }
}
