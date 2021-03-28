package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public final class zau implements zabs {
    private final /* synthetic */ zaq zaet;

    private zau(zaq zaq) {
        this.zaet = zaq;
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void zab(Bundle bundle) {
        this.zaet.zaer.lock();
        try {
            this.zaet.zaep = ConnectionResult.RESULT_SUCCESS;
            this.zaet.zav();
        } finally {
            this.zaet.zaer.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void zac(ConnectionResult connectionResult) {
        this.zaet.zaer.lock();
        try {
            this.zaet.zaep = connectionResult;
            this.zaet.zav();
        } finally {
            this.zaet.zaer.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void zab(int i, boolean z) {
        this.zaet.zaer.lock();
        try {
            if (this.zaet.zaeq) {
                this.zaet.zaeq = false;
                this.zaet.zaa((zaq) i, (int) z);
                return;
            }
            this.zaet.zaeq = true;
            this.zaet.zaei.onConnectionSuspended(i);
            this.zaet.zaer.unlock();
        } finally {
            this.zaet.zaer.unlock();
        }
    }

    /* synthetic */ zau(zaq zaq, zat zat) {
        this(zaq);
    }
}
