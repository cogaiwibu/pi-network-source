package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.GoogleApiAvailabilityCache;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.base.zar;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.ironsource.sdk.constants.Constants;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public class GoogleApiManager implements Handler.Callback {
    private static final Object lock = new Object();
    public static final Status zaib = new Status(4, "Sign-out occurred while this API call was in progress.");
    private static final Status zaic = new Status(4, "The user must be signed in to make this API call.");
    private static GoogleApiManager zaig;
    private final Handler handler;
    private long zaid = 5000;
    private long zaie = 120000;
    private long zaif = TapjoyConstants.TIMER_INCREMENT;
    private final Context zaih;
    private final GoogleApiAvailability zaii;
    private final GoogleApiAvailabilityCache zaij;
    private final AtomicInteger zaik = new AtomicInteger(1);
    private final AtomicInteger zail = new AtomicInteger(0);
    private final Map<ApiKey<?>, zaa<?>> zaim = new ConcurrentHashMap(5, 0.75f, 1);
    private zaad zain = null;
    private final Set<ApiKey<?>> zaio = new ArraySet();
    private final Set<ApiKey<?>> zaip = new ArraySet();

    public static GoogleApiManager zab(Context context) {
        GoogleApiManager googleApiManager;
        synchronized (lock) {
            if (zaig == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                zaig = new GoogleApiManager(context.getApplicationContext(), handlerThread.getLooper(), GoogleApiAvailability.getInstance());
            }
            googleApiManager = zaig;
        }
        return googleApiManager;
    }

    /* access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    public static class zac {
        private final ApiKey<?> zajh;
        private final Feature zaji;

        private zac(ApiKey<?> apiKey, Feature feature) {
            this.zajh = apiKey;
            this.zaji = feature;
        }

        public final boolean equals(Object obj) {
            if (obj != null && (obj instanceof zac)) {
                zac zac = (zac) obj;
                if (!Objects.equal(this.zajh, zac.zajh) || !Objects.equal(this.zaji, zac.zaji)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return Objects.hashCode(this.zajh, this.zaji);
        }

        public final String toString() {
            return Objects.toStringHelper(this).add(Constants.ParametersKeys.KEY, this.zajh).add("feature", this.zaji).toString();
        }

        /* synthetic */ zac(ApiKey apiKey, Feature feature, zabh zabh) {
            this(apiKey, feature);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    public class zab implements zacf, BaseGmsClient.ConnectionProgressReportCallbacks {
        private final ApiKey<?> zaft;
        private final Api.Client zais;
        private IAccountAccessor zaje = null;
        private Set<Scope> zajf = null;
        private boolean zajg = false;

        public zab(Api.Client client, ApiKey<?> apiKey) {
            this.zais = client;
            this.zaft = apiKey;
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
        public final void onReportServiceBinding(ConnectionResult connectionResult) {
            GoogleApiManager.this.handler.post(new zabo(this, connectionResult));
        }

        @Override // com.google.android.gms.common.api.internal.zacf
        public final void zag(ConnectionResult connectionResult) {
            ((zaa) GoogleApiManager.this.zaim.get(this.zaft)).zag(connectionResult);
        }

        @Override // com.google.android.gms.common.api.internal.zacf
        public final void zaa(IAccountAccessor iAccountAccessor, Set<Scope> set) {
            if (iAccountAccessor == null || set == null) {
                Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                zag(new ConnectionResult(4));
                return;
            }
            this.zaje = iAccountAccessor;
            this.zajf = set;
            zabp();
        }

        /* access modifiers changed from: private */
        public final void zabp() {
            IAccountAccessor iAccountAccessor;
            if (this.zajg && (iAccountAccessor = this.zaje) != null) {
                this.zais.getRemoteService(iAccountAccessor, this.zajf);
            }
        }
    }

    public static GoogleApiManager zaba() {
        GoogleApiManager googleApiManager;
        synchronized (lock) {
            Preconditions.checkNotNull(zaig, "Must guarantee manager is non-null before using getInstance");
            googleApiManager = zaig;
        }
        return googleApiManager;
    }

    public static void reportSignOut() {
        synchronized (lock) {
            if (zaig != null) {
                GoogleApiManager googleApiManager = zaig;
                googleApiManager.zail.incrementAndGet();
                googleApiManager.handler.sendMessageAtFrontOfQueue(googleApiManager.handler.obtainMessage(10));
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    public class zaa<O extends Api.ApiOptions> implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, zar {
        private final ApiKey<O> zaft;
        private final Queue<zac> zair = new LinkedList();
        private final Api.Client zais;
        private final Api.AnyClient zait;
        private final zaz zaiu;
        private final Set<zaj> zaiv = new HashSet();
        private final Map<ListenerHolder.ListenerKey<?>, zabv> zaiw = new HashMap();
        private final int zaix;
        private final zace zaiy;
        private boolean zaiz;
        private final List<zac> zaja = new ArrayList();
        private ConnectionResult zajb = null;

        public zaa(GoogleApi<O> googleApi) {
            Api.Client zaa = googleApi.zaa(GoogleApiManager.this.handler.getLooper(), this);
            this.zais = zaa;
            if (zaa instanceof SimpleClientAdapter) {
                this.zait = ((SimpleClientAdapter) zaa).getClient();
            } else {
                this.zait = zaa;
            }
            this.zaft = googleApi.getApiKey();
            this.zaiu = new zaz();
            this.zaix = googleApi.getInstanceId();
            if (this.zais.requiresSignIn()) {
                this.zaiy = googleApi.zaa(GoogleApiManager.this.zaih, GoogleApiManager.this.handler);
            } else {
                this.zaiy = null;
            }
        }

        @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
        public final void onConnected(Bundle bundle) {
            if (Looper.myLooper() == GoogleApiManager.this.handler.getLooper()) {
                zabe();
            } else {
                GoogleApiManager.this.handler.post(new zabi(this));
            }
        }

        /* access modifiers changed from: private */
        public final void zabe() {
            zabj();
            zai(ConnectionResult.RESULT_SUCCESS);
            zabl();
            Iterator<zabv> it = this.zaiw.values().iterator();
            while (it.hasNext()) {
                zabv next = it.next();
                if (zaa(next.zakc.getRequiredFeatures()) != null) {
                    it.remove();
                } else {
                    try {
                        next.zakc.registerListener(this.zait, new TaskCompletionSource<>());
                    } catch (DeadObjectException unused) {
                        onConnectionSuspended(1);
                        this.zais.disconnect();
                    } catch (RemoteException unused2) {
                        it.remove();
                    }
                }
            }
            zabg();
            zabm();
        }

        @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
        public final void onConnectionSuspended(int i) {
            if (Looper.myLooper() == GoogleApiManager.this.handler.getLooper()) {
                zabf();
            } else {
                GoogleApiManager.this.handler.post(new zabk(this));
            }
        }

        /* access modifiers changed from: private */
        public final void zabf() {
            zabj();
            this.zaiz = true;
            this.zaiu.zaag();
            GoogleApiManager.this.handler.sendMessageDelayed(Message.obtain(GoogleApiManager.this.handler, 9, this.zaft), GoogleApiManager.this.zaid);
            GoogleApiManager.this.handler.sendMessageDelayed(Message.obtain(GoogleApiManager.this.handler, 11, this.zaft), GoogleApiManager.this.zaie);
            GoogleApiManager.this.zaij.flush();
        }

        public final void zag(ConnectionResult connectionResult) {
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            this.zais.disconnect();
            onConnectionFailed(connectionResult);
        }

        private final boolean zah(ConnectionResult connectionResult) {
            synchronized (GoogleApiManager.lock) {
                if (GoogleApiManager.this.zain == null || !GoogleApiManager.this.zaio.contains(this.zaft)) {
                    return false;
                }
                GoogleApiManager.this.zain.zab(connectionResult, this.zaix);
                return true;
            }
        }

        @Override // com.google.android.gms.common.api.internal.zar
        public final void zaa(ConnectionResult connectionResult, Api<?> api, boolean z) {
            if (Looper.myLooper() == GoogleApiManager.this.handler.getLooper()) {
                onConnectionFailed(connectionResult);
            } else {
                GoogleApiManager.this.handler.post(new zabj(this, connectionResult));
            }
        }

        @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
        public final void onConnectionFailed(ConnectionResult connectionResult) {
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            zace zace = this.zaiy;
            if (zace != null) {
                zace.zabq();
            }
            zabj();
            GoogleApiManager.this.zaij.flush();
            zai(connectionResult);
            if (connectionResult.getErrorCode() == 4) {
                zac(GoogleApiManager.zaic);
            } else if (this.zair.isEmpty()) {
                this.zajb = connectionResult;
            } else if (!zah(connectionResult) && !GoogleApiManager.this.zac(connectionResult, this.zaix)) {
                if (connectionResult.getErrorCode() == 18) {
                    this.zaiz = true;
                }
                if (this.zaiz) {
                    GoogleApiManager.this.handler.sendMessageDelayed(Message.obtain(GoogleApiManager.this.handler, 9, this.zaft), GoogleApiManager.this.zaid);
                    return;
                }
                String apiName = this.zaft.getApiName();
                String valueOf = String.valueOf(connectionResult);
                StringBuilder sb = new StringBuilder(String.valueOf(apiName).length() + 63 + String.valueOf(valueOf).length());
                sb.append("API: ");
                sb.append(apiName);
                sb.append(" is not available on this device. Connection failed with: ");
                sb.append(valueOf);
                zac(new Status(17, sb.toString()));
            }
        }

        private final void zabg() {
            ArrayList arrayList = new ArrayList(this.zair);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                zac zac = (zac) obj;
                if (!this.zais.isConnected()) {
                    return;
                }
                if (zab(zac)) {
                    this.zair.remove(zac);
                }
            }
        }

        public final void zaa(zac zac) {
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            if (!this.zais.isConnected()) {
                this.zair.add(zac);
                ConnectionResult connectionResult = this.zajb;
                if (connectionResult == null || !connectionResult.hasResolution()) {
                    connect();
                } else {
                    onConnectionFailed(this.zajb);
                }
            } else if (zab(zac)) {
                zabm();
            } else {
                this.zair.add(zac);
            }
        }

        public final void zabh() {
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            zac(GoogleApiManager.zaib);
            this.zaiu.zaaf();
            for (ListenerHolder.ListenerKey listenerKey : (ListenerHolder.ListenerKey[]) this.zaiw.keySet().toArray(new ListenerHolder.ListenerKey[this.zaiw.size()])) {
                zaa(new zah(listenerKey, new TaskCompletionSource()));
            }
            zai(new ConnectionResult(4));
            if (this.zais.isConnected()) {
                this.zais.onUserSignOut(new zabm(this));
            }
        }

        public final Api.Client zaad() {
            return this.zais;
        }

        public final Map<ListenerHolder.ListenerKey<?>, zabv> zabi() {
            return this.zaiw;
        }

        public final void zabj() {
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            this.zajb = null;
        }

        public final ConnectionResult zabk() {
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            return this.zajb;
        }

        private final boolean zab(zac zac) {
            if (!(zac instanceof zab)) {
                zac(zac);
                return true;
            }
            zab zab = (zab) zac;
            Feature zaa = zaa(zab.zaa((zaa<?>) this));
            if (zaa == null) {
                zac(zac);
                return true;
            } else if (zab.zab((zaa<?>) this)) {
                zac zac2 = new zac(this.zaft, zaa, null);
                int indexOf = this.zaja.indexOf(zac2);
                if (indexOf >= 0) {
                    zac zac3 = this.zaja.get(indexOf);
                    GoogleApiManager.this.handler.removeMessages(15, zac3);
                    GoogleApiManager.this.handler.sendMessageDelayed(Message.obtain(GoogleApiManager.this.handler, 15, zac3), GoogleApiManager.this.zaid);
                    return false;
                }
                this.zaja.add(zac2);
                GoogleApiManager.this.handler.sendMessageDelayed(Message.obtain(GoogleApiManager.this.handler, 15, zac2), GoogleApiManager.this.zaid);
                GoogleApiManager.this.handler.sendMessageDelayed(Message.obtain(GoogleApiManager.this.handler, 16, zac2), GoogleApiManager.this.zaie);
                ConnectionResult connectionResult = new ConnectionResult(2, null);
                if (zah(connectionResult)) {
                    return false;
                }
                GoogleApiManager.this.zac(connectionResult, this.zaix);
                return false;
            } else {
                zab.zaa(new UnsupportedApiCallException(zaa));
                return false;
            }
        }

        private final void zac(zac zac) {
            zac.zaa(this.zaiu, requiresSignIn());
            try {
                zac.zac(this);
            } catch (DeadObjectException unused) {
                onConnectionSuspended(1);
                this.zais.disconnect();
            }
        }

        public final void zac(Status status) {
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            for (zac zac : this.zair) {
                zac.zaa(status);
            }
            this.zair.clear();
        }

        public final void resume() {
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            if (this.zaiz) {
                connect();
            }
        }

        private final void zabl() {
            if (this.zaiz) {
                GoogleApiManager.this.handler.removeMessages(11, this.zaft);
                GoogleApiManager.this.handler.removeMessages(9, this.zaft);
                this.zaiz = false;
            }
        }

        public final void zaat() {
            Status status;
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            if (this.zaiz) {
                zabl();
                if (GoogleApiManager.this.zaii.isGooglePlayServicesAvailable(GoogleApiManager.this.zaih) == 18) {
                    status = new Status(8, "Connection timed out while waiting for Google Play services update to complete.");
                } else {
                    status = new Status(8, "API failed to connect while resuming due to an unknown error.");
                }
                zac(status);
                this.zais.disconnect();
            }
        }

        private final void zabm() {
            GoogleApiManager.this.handler.removeMessages(12, this.zaft);
            GoogleApiManager.this.handler.sendMessageDelayed(GoogleApiManager.this.handler.obtainMessage(12, this.zaft), GoogleApiManager.this.zaif);
        }

        public final boolean zabn() {
            return zac(true);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final boolean zac(boolean z) {
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            if (!this.zais.isConnected() || this.zaiw.size() != 0) {
                return false;
            }
            if (this.zaiu.zaae()) {
                if (z) {
                    zabm();
                }
                return false;
            }
            this.zais.disconnect();
            return true;
        }

        public final void connect() {
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            if (!this.zais.isConnected() && !this.zais.isConnecting()) {
                int clientAvailability = GoogleApiManager.this.zaij.getClientAvailability(GoogleApiManager.this.zaih, this.zais);
                if (clientAvailability != 0) {
                    onConnectionFailed(new ConnectionResult(clientAvailability, null));
                    return;
                }
                zab zab = new zab(this.zais, this.zaft);
                if (this.zais.requiresSignIn()) {
                    this.zaiy.zaa(zab);
                }
                this.zais.connect(zab);
            }
        }

        public final void zaa(zaj zaj) {
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            this.zaiv.add(zaj);
        }

        private final void zai(ConnectionResult connectionResult) {
            for (zaj zaj : this.zaiv) {
                String str = null;
                if (Objects.equal(connectionResult, ConnectionResult.RESULT_SUCCESS)) {
                    str = this.zais.getEndpointPackageName();
                }
                zaj.zaa(this.zaft, connectionResult, str);
            }
            this.zaiv.clear();
        }

        /* access modifiers changed from: package-private */
        public final boolean isConnected() {
            return this.zais.isConnected();
        }

        public final boolean requiresSignIn() {
            return this.zais.requiresSignIn();
        }

        public final int getInstanceId() {
            return this.zaix;
        }

        /* access modifiers changed from: package-private */
        public final com.google.android.gms.signin.zac zabo() {
            zace zace = this.zaiy;
            if (zace == null) {
                return null;
            }
            return zace.zabo();
        }

        private final Feature zaa(Feature[] featureArr) {
            if (!(featureArr == null || featureArr.length == 0)) {
                Feature[] availableFeatures = this.zais.getAvailableFeatures();
                if (availableFeatures == null) {
                    availableFeatures = new Feature[0];
                }
                ArrayMap arrayMap = new ArrayMap(availableFeatures.length);
                for (Feature feature : availableFeatures) {
                    arrayMap.put(feature.getName(), Long.valueOf(feature.getVersion()));
                }
                for (Feature feature2 : featureArr) {
                    if (!arrayMap.containsKey(feature2.getName()) || ((Long) arrayMap.get(feature2.getName())).longValue() < feature2.getVersion()) {
                        return feature2;
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zaa(zac zac) {
            if (!this.zaja.contains(zac) || this.zaiz) {
                return;
            }
            if (!this.zais.isConnected()) {
                connect();
            } else {
                zabg();
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zab(zac zac) {
            Feature[] zaa;
            if (this.zaja.remove(zac)) {
                GoogleApiManager.this.handler.removeMessages(15, zac);
                GoogleApiManager.this.handler.removeMessages(16, zac);
                Feature feature = zac.zaji;
                ArrayList arrayList = new ArrayList(this.zair.size());
                for (zac zac2 : this.zair) {
                    if ((zac2 instanceof zab) && (zaa = ((zab) zac2).zaa((zaa<?>) this)) != null && ArrayUtils.contains(zaa, feature)) {
                        arrayList.add(zac2);
                    }
                }
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList2.get(i);
                    i++;
                    zac zac3 = (zac) obj;
                    this.zair.remove(zac3);
                    zac3.zaa(new UnsupportedApiCallException(feature));
                }
            }
        }
    }

    private GoogleApiManager(Context context, Looper looper, GoogleApiAvailability googleApiAvailability) {
        this.zaih = context;
        this.handler = new zar(looper, this);
        this.zaii = googleApiAvailability;
        this.zaij = new GoogleApiAvailabilityCache(googleApiAvailability);
        Handler handler2 = this.handler;
        handler2.sendMessage(handler2.obtainMessage(6));
    }

    public final int zabb() {
        return this.zaik.getAndIncrement();
    }

    public final void zaa(GoogleApi<?> googleApi) {
        Handler handler2 = this.handler;
        handler2.sendMessage(handler2.obtainMessage(7, googleApi));
    }

    private final void zab(GoogleApi<?> googleApi) {
        ApiKey<?> apiKey = googleApi.getApiKey();
        zaa<?> zaa2 = this.zaim.get(apiKey);
        if (zaa2 == null) {
            zaa2 = new zaa<>(googleApi);
            this.zaim.put(apiKey, zaa2);
        }
        if (zaa2.requiresSignIn()) {
            this.zaip.add(apiKey);
        }
        zaa2.connect();
    }

    public final void zaa(zaad zaad) {
        synchronized (lock) {
            if (this.zain != zaad) {
                this.zain = zaad;
                this.zaio.clear();
            }
            this.zaio.addAll(zaad.zaah());
        }
    }

    /* access modifiers changed from: package-private */
    public final void zab(zaad zaad) {
        synchronized (lock) {
            if (this.zain == zaad) {
                this.zain = null;
                this.zaio.clear();
            }
        }
    }

    public final Task<Map<ApiKey<?>, String>> zaa(Iterable<? extends HasApiKey<?>> iterable) {
        zaj zaj = new zaj(iterable);
        Handler handler2 = this.handler;
        handler2.sendMessage(handler2.obtainMessage(2, zaj));
        return zaj.getTask();
    }

    public final void zam() {
        Handler handler2 = this.handler;
        handler2.sendMessage(handler2.obtainMessage(3));
    }

    /* access modifiers changed from: package-private */
    public final void maybeSignOut() {
        this.zail.incrementAndGet();
        Handler handler2 = this.handler;
        handler2.sendMessage(handler2.obtainMessage(10));
    }

    public final Task<Boolean> zac(GoogleApi<?> googleApi) {
        zaae zaae = new zaae(googleApi.getApiKey());
        Handler handler2 = this.handler;
        handler2.sendMessage(handler2.obtainMessage(14, zaae));
        return zaae.zaaj().getTask();
    }

    public final <O extends Api.ApiOptions> void zaa(GoogleApi<O> googleApi, int i, BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient> apiMethodImpl) {
        zad zad = new zad(i, apiMethodImpl);
        Handler handler2 = this.handler;
        handler2.sendMessage(handler2.obtainMessage(4, new zabu(zad, this.zail.get(), googleApi)));
    }

    public final <O extends Api.ApiOptions, ResultT> void zaa(GoogleApi<O> googleApi, int i, TaskApiCall<Api.AnyClient, ResultT> taskApiCall, TaskCompletionSource<ResultT> taskCompletionSource, StatusExceptionMapper statusExceptionMapper) {
        zaf zaf = new zaf(i, taskApiCall, taskCompletionSource, statusExceptionMapper);
        Handler handler2 = this.handler;
        handler2.sendMessage(handler2.obtainMessage(4, new zabu(zaf, this.zail.get(), googleApi)));
    }

    public final <O extends Api.ApiOptions> Task<Void> zaa(GoogleApi<O> googleApi, RegisterListenerMethod<Api.AnyClient, ?> registerListenerMethod, UnregisterListenerMethod<Api.AnyClient, ?> unregisterListenerMethod) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zag zag = new zag(new zabv(registerListenerMethod, unregisterListenerMethod), taskCompletionSource);
        Handler handler2 = this.handler;
        handler2.sendMessage(handler2.obtainMessage(8, new zabu(zag, this.zail.get(), googleApi)));
        return taskCompletionSource.getTask();
    }

    public final <O extends Api.ApiOptions> Task<Boolean> zaa(GoogleApi<O> googleApi, ListenerHolder.ListenerKey<?> listenerKey) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zah zah = new zah(listenerKey, taskCompletionSource);
        Handler handler2 = this.handler;
        handler2.sendMessage(handler2.obtainMessage(13, new zabu(zah, this.zail.get(), googleApi)));
        return taskCompletionSource.getTask();
    }

    public boolean handleMessage(Message message) {
        long j = 300000;
        zaa<?> zaa2 = null;
        switch (message.what) {
            case 1:
                if (((Boolean) message.obj).booleanValue()) {
                    j = TapjoyConstants.TIMER_INCREMENT;
                }
                this.zaif = j;
                this.handler.removeMessages(12);
                for (ApiKey<?> apiKey : this.zaim.keySet()) {
                    Handler handler2 = this.handler;
                    handler2.sendMessageDelayed(handler2.obtainMessage(12, apiKey), this.zaif);
                }
                break;
            case 2:
                zaj zaj = (zaj) message.obj;
                Iterator<ApiKey<?>> it = zaj.zan().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else {
                        ApiKey<?> next = it.next();
                        zaa<?> zaa3 = this.zaim.get(next);
                        if (zaa3 == null) {
                            zaj.zaa(next, new ConnectionResult(13), null);
                            break;
                        } else if (zaa3.isConnected()) {
                            zaj.zaa(next, ConnectionResult.RESULT_SUCCESS, zaa3.zaad().getEndpointPackageName());
                        } else if (zaa3.zabk() != null) {
                            zaj.zaa(next, zaa3.zabk(), null);
                        } else {
                            zaa3.zaa(zaj);
                            zaa3.connect();
                        }
                    }
                }
            case 3:
                for (zaa<?> zaa4 : this.zaim.values()) {
                    zaa4.zabj();
                    zaa4.connect();
                }
                break;
            case 4:
            case 8:
            case 13:
                zabu zabu = (zabu) message.obj;
                zaa<?> zaa5 = this.zaim.get(zabu.zajz.getApiKey());
                if (zaa5 == null) {
                    zab(zabu.zajz);
                    zaa5 = this.zaim.get(zabu.zajz.getApiKey());
                }
                if (!zaa5.requiresSignIn() || this.zail.get() == zabu.zajy) {
                    zaa5.zaa(zabu.zajx);
                    break;
                } else {
                    zabu.zajx.zaa(zaib);
                    zaa5.zabh();
                    break;
                }
                break;
            case 5:
                int i = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator<zaa<?>> it2 = this.zaim.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        zaa<?> next2 = it2.next();
                        if (next2.getInstanceId() == i) {
                            zaa2 = next2;
                        }
                    }
                }
                if (zaa2 != null) {
                    String errorString = this.zaii.getErrorString(connectionResult.getErrorCode());
                    String errorMessage = connectionResult.getErrorMessage();
                    StringBuilder sb = new StringBuilder(String.valueOf(errorString).length() + 69 + String.valueOf(errorMessage).length());
                    sb.append("Error resolution was canceled by the user, original error message: ");
                    sb.append(errorString);
                    sb.append(": ");
                    sb.append(errorMessage);
                    zaa2.zac(new Status(17, sb.toString()));
                    break;
                } else {
                    StringBuilder sb2 = new StringBuilder(76);
                    sb2.append("Could not find API instance ");
                    sb2.append(i);
                    sb2.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb2.toString(), new Exception());
                    break;
                }
            case 6:
                if (PlatformVersion.isAtLeastIceCreamSandwich() && (this.zaih.getApplicationContext() instanceof Application)) {
                    BackgroundDetector.initialize((Application) this.zaih.getApplicationContext());
                    BackgroundDetector.getInstance().addListener(new zabh(this));
                    if (!BackgroundDetector.getInstance().readCurrentStateIfPossible(true)) {
                        this.zaif = 300000;
                        break;
                    }
                }
                break;
            case 7:
                zab((GoogleApi) message.obj);
                break;
            case 9:
                if (this.zaim.containsKey(message.obj)) {
                    this.zaim.get(message.obj).resume();
                    break;
                }
                break;
            case 10:
                for (ApiKey<?> apiKey2 : this.zaip) {
                    this.zaim.remove(apiKey2).zabh();
                }
                this.zaip.clear();
                break;
            case 11:
                if (this.zaim.containsKey(message.obj)) {
                    this.zaim.get(message.obj).zaat();
                    break;
                }
                break;
            case 12:
                if (this.zaim.containsKey(message.obj)) {
                    this.zaim.get(message.obj).zabn();
                    break;
                }
                break;
            case 14:
                zaae zaae = (zaae) message.obj;
                ApiKey<?> apiKey3 = zaae.getApiKey();
                if (!this.zaim.containsKey(apiKey3)) {
                    zaae.zaaj().setResult(false);
                    break;
                } else {
                    zaae.zaaj().setResult(Boolean.valueOf(this.zaim.get(apiKey3).zac((zaa) false)));
                    break;
                }
            case 15:
                zac zac2 = (zac) message.obj;
                if (this.zaim.containsKey(zac2.zajh)) {
                    this.zaim.get(zac2.zajh).zaa((zaa) zac2);
                    break;
                }
                break;
            case 16:
                zac zac3 = (zac) message.obj;
                if (this.zaim.containsKey(zac3.zajh)) {
                    this.zaim.get(zac3.zajh).zab((zaa) zac3);
                    break;
                }
                break;
            default:
                int i2 = message.what;
                StringBuilder sb3 = new StringBuilder(31);
                sb3.append("Unknown message id: ");
                sb3.append(i2);
                Log.w("GoogleApiManager", sb3.toString());
                return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final PendingIntent zaa(ApiKey<?> apiKey, int i) {
        com.google.android.gms.signin.zac zabo;
        zaa<?> zaa2 = this.zaim.get(apiKey);
        if (zaa2 == null || (zabo = zaa2.zabo()) == null) {
            return null;
        }
        return PendingIntent.getActivity(this.zaih, i, zabo.getSignInIntent(), 134217728);
    }

    /* access modifiers changed from: package-private */
    public final boolean zac(ConnectionResult connectionResult, int i) {
        return this.zaii.zaa(this.zaih, connectionResult, i);
    }

    public final void zaa(ConnectionResult connectionResult, int i) {
        if (!zac(connectionResult, i)) {
            Handler handler2 = this.handler;
            handler2.sendMessage(handler2.obtainMessage(5, i, 0, connectionResult));
        }
    }
}
