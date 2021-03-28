package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zac;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class zabe implements zabr, zar {
    private final Context mContext;
    private final Api.AbstractClientBuilder<? extends zac, SignInOptions> zacf;
    final zaaw zaeh;
    private final Lock zaer;
    private final Map<Api<?>, Boolean> zaew;
    private final GoogleApiAvailabilityLight zaey;
    private final ClientSettings zafa;
    final Map<Api.AnyClientKey<?>, Api.Client> zahd;
    private final Condition zahr;
    private final zabg zahs;
    final Map<Api.AnyClientKey<?>, ConnectionResult> zaht = new HashMap();
    private volatile zabb zahu;
    private ConnectionResult zahv = null;
    int zahw;
    final zabs zahx;

    public zabe(Context context, zaaw zaaw, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, Api.AbstractClientBuilder<? extends zac, SignInOptions> abstractClientBuilder, ArrayList<zap> arrayList, zabs zabs) {
        this.mContext = context;
        this.zaer = lock;
        this.zaey = googleApiAvailabilityLight;
        this.zahd = map;
        this.zafa = clientSettings;
        this.zaew = map2;
        this.zacf = abstractClientBuilder;
        this.zaeh = zaaw;
        this.zahx = zabs;
        ArrayList<zap> arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            zap zap = arrayList2.get(i);
            i++;
            zap.zaa(this);
        }
        this.zahs = new zabg(this, looper);
        this.zahr = lock.newCondition();
        this.zahu = new zaat(this);
    }

    @Override // com.google.android.gms.common.api.internal.zabr
    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        return false;
    }

    @Override // com.google.android.gms.common.api.internal.zabr
    public final void maybeSignOut() {
    }

    @Override // com.google.android.gms.common.api.internal.zabr
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        t.zar();
        return (T) this.zahu.enqueue(t);
    }

    @Override // com.google.android.gms.common.api.internal.zabr
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        t.zar();
        return (T) this.zahu.execute(t);
    }

    @Override // com.google.android.gms.common.api.internal.zabr
    public final void connect() {
        this.zahu.connect();
    }

    @Override // com.google.android.gms.common.api.internal.zabr
    public final ConnectionResult blockingConnect() {
        connect();
        while (isConnecting()) {
            try {
                this.zahr.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        if (isConnected()) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        ConnectionResult connectionResult = this.zahv;
        if (connectionResult != null) {
            return connectionResult;
        }
        return new ConnectionResult(13, null);
    }

    @Override // com.google.android.gms.common.api.internal.zabr
    public final ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        connect();
        long nanos = timeUnit.toNanos(j);
        while (isConnecting()) {
            if (nanos <= 0) {
                try {
                    disconnect();
                    return new ConnectionResult(14, null);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return new ConnectionResult(15, null);
                }
            } else {
                nanos = this.zahr.awaitNanos(nanos);
            }
        }
        if (isConnected()) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        ConnectionResult connectionResult = this.zahv;
        if (connectionResult != null) {
            return connectionResult;
        }
        return new ConnectionResult(13, null);
    }

    @Override // com.google.android.gms.common.api.internal.zabr
    public final void disconnect() {
        if (this.zahu.disconnect()) {
            this.zaht.clear();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabr
    public final ConnectionResult getConnectionResult(Api<?> api) {
        Api.AnyClientKey<?> clientKey = api.getClientKey();
        if (!this.zahd.containsKey(clientKey)) {
            return null;
        }
        if (this.zahd.get(clientKey).isConnected()) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        if (this.zaht.containsKey(clientKey)) {
            return this.zaht.get(clientKey);
        }
        return null;
    }

    public final void zaax() {
        this.zaer.lock();
        try {
            this.zahu = new zaak(this, this.zafa, this.zaew, this.zaey, this.zacf, this.zaer, this.mContext);
            this.zahu.begin();
            this.zahr.signalAll();
        } finally {
            this.zaer.unlock();
        }
    }

    public final void zaay() {
        this.zaer.lock();
        try {
            this.zaeh.zaau();
            this.zahu = new zaaf(this);
            this.zahu.begin();
            this.zahr.signalAll();
        } finally {
            this.zaer.unlock();
        }
    }

    public final void zaf(ConnectionResult connectionResult) {
        this.zaer.lock();
        try {
            this.zahv = connectionResult;
            this.zahu = new zaat(this);
            this.zahu.begin();
            this.zahr.signalAll();
        } finally {
            this.zaer.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabr
    public final boolean isConnected() {
        return this.zahu instanceof zaaf;
    }

    @Override // com.google.android.gms.common.api.internal.zabr
    public final boolean isConnecting() {
        return this.zahu instanceof zaak;
    }

    @Override // com.google.android.gms.common.api.internal.zabr
    public final void zau() {
        if (isConnected()) {
            ((zaaf) this.zahu).zaak();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zar
    public final void zaa(ConnectionResult connectionResult, Api<?> api, boolean z) {
        this.zaer.lock();
        try {
            this.zahu.zaa(connectionResult, api, z);
        } finally {
            this.zaer.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        this.zaer.lock();
        try {
            this.zahu.onConnected(bundle);
        } finally {
            this.zaer.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        this.zaer.lock();
        try {
            this.zahu.onConnectionSuspended(i);
        } finally {
            this.zaer.unlock();
        }
    }

    public final void zaa(zabd zabd) {
        this.zahs.sendMessage(this.zahs.obtainMessage(1, zabd));
    }

    public final void zab(RuntimeException runtimeException) {
        this.zahs.sendMessage(this.zahs.obtainMessage(2, runtimeException));
    }

    @Override // com.google.android.gms.common.api.internal.zabr
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        printWriter.append((CharSequence) str).append("mState=").println(this.zahu);
        for (Api<?> api : this.zaew.keySet()) {
            printWriter.append((CharSequence) str).append((CharSequence) api.getName()).println(":");
            this.zahd.get(api.getClientKey()).dump(concat, fileDescriptor, printWriter, strArr);
        }
    }
}
