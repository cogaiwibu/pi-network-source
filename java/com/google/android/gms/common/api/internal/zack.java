package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public final class zack<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {
    private final Object zadp = new Object();
    private final WeakReference<GoogleApiClient> zadr;
    private ResultTransform<? super R, ? extends Result> zakr = null;
    private zack<? extends Result> zaks = null;
    private volatile ResultCallbacks<? super R> zakt = null;
    private PendingResult<R> zaku = null;
    private Status zakv = null;
    private final zacm zakw;
    private boolean zakx = false;

    public zack(WeakReference<GoogleApiClient> weakReference) {
        Preconditions.checkNotNull(weakReference, "GoogleApiClient reference must not be null");
        this.zadr = weakReference;
        GoogleApiClient googleApiClient = weakReference.get();
        this.zakw = new zacm(this, googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
    }

    @Override // com.google.android.gms.common.api.TransformedResult
    public final <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> resultTransform) {
        zack<? extends Result> zack;
        synchronized (this.zadp) {
            boolean z = true;
            Preconditions.checkState(this.zakr == null, "Cannot call then() twice.");
            if (this.zakt != null) {
                z = false;
            }
            Preconditions.checkState(z, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.zakr = resultTransform;
            zack = new zack<>(this.zadr);
            this.zaks = zack;
            zabs();
        }
        return zack;
    }

    @Override // com.google.android.gms.common.api.TransformedResult
    public final void andFinally(ResultCallbacks<? super R> resultCallbacks) {
        synchronized (this.zadp) {
            boolean z = true;
            Preconditions.checkState(this.zakt == null, "Cannot call andFinally() twice.");
            if (this.zakr != null) {
                z = false;
            }
            Preconditions.checkState(z, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.zakt = resultCallbacks;
            zabs();
        }
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final void onResult(R r) {
        synchronized (this.zadp) {
            if (!r.getStatus().isSuccess()) {
                zad(r.getStatus());
                zab(r);
            } else if (this.zakr != null) {
                zacb.zaaz().submit(new zacn(this, r));
            } else if (zabu()) {
                this.zakt.onSuccess(r);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.android.gms.common.api.PendingResult<?> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void zaa(PendingResult<?> pendingResult) {
        synchronized (this.zadp) {
            this.zaku = pendingResult;
            zabs();
        }
    }

    private final void zabs() {
        if (this.zakr != null || this.zakt != null) {
            GoogleApiClient googleApiClient = this.zadr.get();
            if (!(this.zakx || this.zakr == null || googleApiClient == null)) {
                googleApiClient.zaa(this);
                this.zakx = true;
            }
            Status status = this.zakv;
            if (status != null) {
                zae(status);
                return;
            }
            PendingResult<R> pendingResult = this.zaku;
            if (pendingResult != null) {
                pendingResult.setResultCallback(this);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zad(Status status) {
        synchronized (this.zadp) {
            this.zakv = status;
            zae(status);
        }
    }

    private final void zae(Status status) {
        synchronized (this.zadp) {
            if (this.zakr != null) {
                Status onFailure = this.zakr.onFailure(status);
                Preconditions.checkNotNull(onFailure, "onFailure must not return null");
                this.zaks.zad(onFailure);
            } else if (zabu()) {
                this.zakt.onFailure(status);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zabt() {
        this.zakt = null;
    }

    private final boolean zabu() {
        return (this.zakt == null || this.zadr.get() == null) ? false : true;
    }

    /* access modifiers changed from: private */
    public static void zab(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                String valueOf = String.valueOf(result);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                Log.w("TransformedResultImpl", sb.toString(), e);
            }
        }
    }
}
