package com.google.android.gms.common.api.internal;

import android.app.Activity;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public class zaad extends zak {
    private GoogleApiManager zabo;
    private final ArraySet<ApiKey<?>> zafs = new ArraySet<>();

    public static void zaa(Activity activity, GoogleApiManager googleApiManager, ApiKey<?> apiKey) {
        LifecycleFragment fragment = getFragment(activity);
        zaad zaad = (zaad) fragment.getCallbackOrNull("ConnectionlessLifecycleHelper", zaad.class);
        if (zaad == null) {
            zaad = new zaad(fragment);
        }
        zaad.zabo = googleApiManager;
        Preconditions.checkNotNull(apiKey, "ApiKey cannot be null");
        zaad.zafs.add(apiKey);
        googleApiManager.zaa(zaad);
    }

    private zaad(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        this.mLifecycleFragment.addCallback("ConnectionlessLifecycleHelper", this);
    }

    @Override // com.google.android.gms.common.api.internal.zak, com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStart() {
        super.onStart();
        zaai();
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onResume() {
        super.onResume();
        zaai();
    }

    @Override // com.google.android.gms.common.api.internal.zak, com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStop() {
        super.onStop();
        this.zabo.zab(this);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.zak
    public final void zaa(ConnectionResult connectionResult, int i) {
        this.zabo.zaa(connectionResult, i);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.zak
    public final void zam() {
        this.zabo.zam();
    }

    /* access modifiers changed from: package-private */
    public final ArraySet<ApiKey<?>> zaah() {
        return this.zafs;
    }

    private final void zaai() {
        if (!this.zafs.isEmpty()) {
            this.zabo.zaa(this);
        }
    }
}
