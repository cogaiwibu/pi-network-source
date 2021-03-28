package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zar;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zac;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public final class zaq implements zabr {
    private final Context mContext;
    private final Looper zabl;
    private final zaaw zaeh;
    private final zabe zaei;
    private final zabe zaej;
    private final Map<Api.AnyClientKey<?>, zabe> zaek;
    private final Set<SignInConnectionListener> zael = Collections.newSetFromMap(new WeakHashMap());
    private final Api.Client zaem;
    private Bundle zaen;
    private ConnectionResult zaeo = null;
    private ConnectionResult zaep = null;
    private boolean zaeq = false;
    private final Lock zaer;
    private int zaes = 0;

    public static zaq zaa(Context context, zaaw zaaw, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, Api.AbstractClientBuilder<? extends zac, SignInOptions> abstractClientBuilder, ArrayList<zap> arrayList) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        Api.Client client = null;
        for (Map.Entry<Api.AnyClientKey<?>, Api.Client> entry : map.entrySet()) {
            Api.Client value = entry.getValue();
            if (value.providesSignIn()) {
                client = value;
            }
            if (value.requiresSignIn()) {
                arrayMap.put(entry.getKey(), value);
            } else {
                arrayMap2.put(entry.getKey(), value);
            }
        }
        Preconditions.checkState(!arrayMap.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        ArrayMap arrayMap3 = new ArrayMap();
        ArrayMap arrayMap4 = new ArrayMap();
        for (Api<?> api : map2.keySet()) {
            Api.AnyClientKey<?> clientKey = api.getClientKey();
            if (arrayMap.containsKey(clientKey)) {
                arrayMap3.put(api, map2.get(api));
            } else if (arrayMap2.containsKey(clientKey)) {
                arrayMap4.put(api, map2.get(api));
            } else {
                throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList<zap> arrayList4 = arrayList;
        int size = arrayList4.size();
        int i = 0;
        while (i < size) {
            zap zap = arrayList4.get(i);
            i++;
            zap zap2 = zap;
            if (arrayMap3.containsKey(zap2.mApi)) {
                arrayList2.add(zap2);
            } else if (arrayMap4.containsKey(zap2.mApi)) {
                arrayList3.add(zap2);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
            }
        }
        return new zaq(context, zaaw, lock, looper, googleApiAvailabilityLight, arrayMap, arrayMap2, clientSettings, abstractClientBuilder, client, arrayList2, arrayList3, arrayMap3, arrayMap4);
    }

    private zaq(Context context, zaaw zaaw, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, Map<Api.AnyClientKey<?>, Api.Client> map2, ClientSettings clientSettings, Api.AbstractClientBuilder<? extends zac, SignInOptions> abstractClientBuilder, Api.Client client, ArrayList<zap> arrayList, ArrayList<zap> arrayList2, Map<Api<?>, Boolean> map3, Map<Api<?>, Boolean> map4) {
        this.mContext = context;
        this.zaeh = zaaw;
        this.zaer = lock;
        this.zabl = looper;
        this.zaem = client;
        this.zaei = new zabe(context, zaaw, lock, looper, googleApiAvailabilityLight, map2, null, map4, null, arrayList2, new zas(this, null));
        this.zaej = new zabe(context, this.zaeh, lock, looper, googleApiAvailabilityLight, map, clientSettings, map3, abstractClientBuilder, arrayList, new zau(this, null));
        ArrayMap arrayMap = new ArrayMap();
        for (Api.AnyClientKey<?> anyClientKey : map2.keySet()) {
            arrayMap.put(anyClientKey, this.zaei);
        }
        for (Api.AnyClientKey<?> anyClientKey2 : map.keySet()) {
            arrayMap.put(anyClientKey2, this.zaej);
        }
        this.zaek = Collections.unmodifiableMap(arrayMap);
    }

    @Override // com.google.android.gms.common.api.internal.zabr
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        if (!zaa(t)) {
            return (T) this.zaei.enqueue(t);
        }
        if (!zax()) {
            return (T) this.zaej.enqueue(t);
        }
        t.setFailedResult(new Status(4, null, zay()));
        return t;
    }

    @Override // com.google.android.gms.common.api.internal.zabr
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        if (!zaa(t)) {
            return (T) this.zaei.execute(t);
        }
        if (!zax()) {
            return (T) this.zaej.execute(t);
        }
        t.setFailedResult(new Status(4, null, zay()));
        return t;
    }

    @Override // com.google.android.gms.common.api.internal.zabr
    public final ConnectionResult getConnectionResult(Api<?> api) {
        if (!this.zaek.get(api.getClientKey()).equals(this.zaej)) {
            return this.zaei.getConnectionResult(api);
        }
        if (zax()) {
            return new ConnectionResult(4, zay());
        }
        return this.zaej.getConnectionResult(api);
    }

    @Override // com.google.android.gms.common.api.internal.zabr
    public final void connect() {
        this.zaes = 2;
        this.zaeq = false;
        this.zaep = null;
        this.zaeo = null;
        this.zaei.connect();
        this.zaej.connect();
    }

    @Override // com.google.android.gms.common.api.internal.zabr
    public final ConnectionResult blockingConnect() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.common.api.internal.zabr
    public final ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.common.api.internal.zabr
    public final void disconnect() {
        this.zaep = null;
        this.zaeo = null;
        this.zaes = 0;
        this.zaei.disconnect();
        this.zaej.disconnect();
        zaw();
    }

    @Override // com.google.android.gms.common.api.internal.zabr
    public final boolean isConnected() {
        this.zaer.lock();
        try {
            boolean z = true;
            if (!this.zaei.isConnected() || (!this.zaej.isConnected() && !zax() && this.zaes != 1)) {
                z = false;
            }
            return z;
        } finally {
            this.zaer.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabr
    public final boolean isConnecting() {
        this.zaer.lock();
        try {
            return this.zaes == 2;
        } finally {
            this.zaer.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabr
    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        this.zaer.lock();
        try {
            if ((isConnecting() || isConnected()) && !this.zaej.isConnected()) {
                this.zael.add(signInConnectionListener);
                if (this.zaes == 0) {
                    this.zaes = 1;
                }
                this.zaep = null;
                this.zaej.connect();
                return true;
            }
            this.zaer.unlock();
            return false;
        } finally {
            this.zaer.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabr
    public final void zau() {
        this.zaei.zau();
        this.zaej.zau();
    }

    @Override // com.google.android.gms.common.api.internal.zabr
    public final void maybeSignOut() {
        this.zaer.lock();
        try {
            boolean isConnecting = isConnecting();
            this.zaej.disconnect();
            this.zaep = new ConnectionResult(4);
            if (isConnecting) {
                new zar(this.zabl).post(new zat(this));
            } else {
                zaw();
            }
        } finally {
            this.zaer.unlock();
        }
    }

    /* access modifiers changed from: private */
    public final void zav() {
        if (zab(this.zaeo)) {
            if (zab(this.zaep) || zax()) {
                int i = this.zaes;
                if (i != 1) {
                    if (i != 2) {
                        Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                        this.zaes = 0;
                        return;
                    }
                    this.zaeh.zab(this.zaen);
                }
                zaw();
                this.zaes = 0;
                return;
            }
            ConnectionResult connectionResult = this.zaep;
            if (connectionResult == null) {
                return;
            }
            if (this.zaes == 1) {
                zaw();
                return;
            }
            zaa(connectionResult);
            this.zaei.disconnect();
        } else if (this.zaeo == null || !zab(this.zaep)) {
            ConnectionResult connectionResult2 = this.zaeo;
            if (connectionResult2 != null && this.zaep != null) {
                if (this.zaej.zahw < this.zaei.zahw) {
                    connectionResult2 = this.zaep;
                }
                zaa(connectionResult2);
            }
        } else {
            this.zaej.disconnect();
            zaa(this.zaeo);
        }
    }

    private final void zaa(ConnectionResult connectionResult) {
        int i = this.zaes;
        if (i != 1) {
            if (i != 2) {
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                this.zaes = 0;
            }
            this.zaeh.zac(connectionResult);
        }
        zaw();
        this.zaes = 0;
    }

    private final void zaw() {
        for (SignInConnectionListener signInConnectionListener : this.zael) {
            signInConnectionListener.onComplete();
        }
        this.zael.clear();
    }

    /* access modifiers changed from: private */
    public final void zaa(int i, boolean z) {
        this.zaeh.zab(i, z);
        this.zaep = null;
        this.zaeo = null;
    }

    private final boolean zax() {
        ConnectionResult connectionResult = this.zaep;
        return connectionResult != null && connectionResult.getErrorCode() == 4;
    }

    private final boolean zaa(BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient> apiMethodImpl) {
        Api.AnyClientKey<? extends Api.AnyClient> clientKey = apiMethodImpl.getClientKey();
        Preconditions.checkArgument(this.zaek.containsKey(clientKey), "GoogleApiClient is not configured to use the API required for this call.");
        return this.zaek.get(clientKey).equals(this.zaej);
    }

    private final PendingIntent zay() {
        if (this.zaem == null) {
            return null;
        }
        return PendingIntent.getActivity(this.mContext, System.identityHashCode(this.zaeh), this.zaem.getSignInIntent(), 134217728);
    }

    /* access modifiers changed from: private */
    public final void zaa(Bundle bundle) {
        Bundle bundle2 = this.zaen;
        if (bundle2 == null) {
            this.zaen = bundle;
        } else if (bundle != null) {
            bundle2.putAll(bundle);
        }
    }

    private static boolean zab(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.isSuccess();
    }

    @Override // com.google.android.gms.common.api.internal.zabr
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("authClient").println(":");
        this.zaej.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append((CharSequence) str).append("anonClient").println(":");
        this.zaei.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }
}
