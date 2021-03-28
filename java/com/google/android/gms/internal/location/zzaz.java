package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.StatusCallback;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.zzal;
import javax.annotation.Nullable;

public final class zzaz extends zzk {
    private final zzas zzde;

    public zzaz(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str) {
        this(context, looper, connectionCallbacks, onConnectionFailedListener, str, ClientSettings.createDefault(context));
    }

    public zzaz(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, @Nullable ClientSettings clientSettings) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, str, clientSettings);
        this.zzde = new zzas(context, this.zzcb);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void disconnect() {
        synchronized (this.zzde) {
            if (isConnected()) {
                try {
                    this.zzde.removeAllListeners();
                    this.zzde.zzb();
                } catch (Exception e) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e);
                }
            }
            super.disconnect();
        }
    }

    public final Location getLastLocation() throws RemoteException {
        return this.zzde.getLastLocation();
    }

    public final LocationAvailability zza() throws RemoteException {
        return this.zzde.zza();
    }

    public final void zza(long j, PendingIntent pendingIntent) throws RemoteException {
        checkConnected();
        Preconditions.checkNotNull(pendingIntent);
        Preconditions.checkArgument(j >= 0, "detectionIntervalMillis must be >= 0");
        ((zzao) getService()).zza(j, true, pendingIntent);
    }

    public final void zza(PendingIntent pendingIntent, BaseImplementation.ResultHolder<Status> resultHolder) throws RemoteException {
        checkConnected();
        Preconditions.checkNotNull(resultHolder, "ResultHolder not provided.");
        ((zzao) getService()).zza(pendingIntent, new StatusCallback(resultHolder));
    }

    public final void zza(PendingIntent pendingIntent, zzaj zzaj) throws RemoteException {
        this.zzde.zza(pendingIntent, zzaj);
    }

    public final void zza(Location location) throws RemoteException {
        this.zzde.zza(location);
    }

    public final void zza(ListenerHolder.ListenerKey<LocationListener> listenerKey, zzaj zzaj) throws RemoteException {
        this.zzde.zza(listenerKey, zzaj);
    }

    public final void zza(zzaj zzaj) throws RemoteException {
        this.zzde.zza(zzaj);
    }

    public final void zza(zzbd zzbd, ListenerHolder<LocationCallback> listenerHolder, zzaj zzaj) throws RemoteException {
        synchronized (this.zzde) {
            this.zzde.zza(zzbd, listenerHolder, zzaj);
        }
    }

    public final void zza(ActivityTransitionRequest activityTransitionRequest, PendingIntent pendingIntent, BaseImplementation.ResultHolder<Status> resultHolder) throws RemoteException {
        checkConnected();
        Preconditions.checkNotNull(resultHolder, "ResultHolder not provided.");
        ((zzao) getService()).zza(activityTransitionRequest, pendingIntent, new StatusCallback(resultHolder));
    }

    public final void zza(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, BaseImplementation.ResultHolder<Status> resultHolder) throws RemoteException {
        checkConnected();
        Preconditions.checkNotNull(geofencingRequest, "geofencingRequest can't be null.");
        Preconditions.checkNotNull(pendingIntent, "PendingIntent must be specified.");
        Preconditions.checkNotNull(resultHolder, "ResultHolder not provided.");
        ((zzao) getService()).zza(geofencingRequest, pendingIntent, new zzba(resultHolder));
    }

    public final void zza(LocationRequest locationRequest, PendingIntent pendingIntent, zzaj zzaj) throws RemoteException {
        this.zzde.zza(locationRequest, pendingIntent, zzaj);
    }

    public final void zza(LocationRequest locationRequest, ListenerHolder<LocationListener> listenerHolder, zzaj zzaj) throws RemoteException {
        synchronized (this.zzde) {
            this.zzde.zza(locationRequest, listenerHolder, zzaj);
        }
    }

    public final void zza(LocationSettingsRequest locationSettingsRequest, BaseImplementation.ResultHolder<LocationSettingsResult> resultHolder, @Nullable String str) throws RemoteException {
        checkConnected();
        boolean z = true;
        Preconditions.checkArgument(locationSettingsRequest != null, "locationSettingsRequest can't be null nor empty.");
        if (resultHolder == null) {
            z = false;
        }
        Preconditions.checkArgument(z, "listener can't be null.");
        ((zzao) getService()).zza(locationSettingsRequest, new zzbc(resultHolder), str);
    }

    public final void zza(zzal zzal, BaseImplementation.ResultHolder<Status> resultHolder) throws RemoteException {
        checkConnected();
        Preconditions.checkNotNull(zzal, "removeGeofencingRequest can't be null.");
        Preconditions.checkNotNull(resultHolder, "ResultHolder not provided.");
        ((zzao) getService()).zza(zzal, new zzbb(resultHolder));
    }

    public final void zza(boolean z) throws RemoteException {
        this.zzde.zza(z);
    }

    public final void zzb(PendingIntent pendingIntent) throws RemoteException {
        checkConnected();
        Preconditions.checkNotNull(pendingIntent);
        ((zzao) getService()).zzb(pendingIntent);
    }

    public final void zzb(ListenerHolder.ListenerKey<LocationCallback> listenerKey, zzaj zzaj) throws RemoteException {
        this.zzde.zzb(listenerKey, zzaj);
    }
}
