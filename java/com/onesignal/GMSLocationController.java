package com.onesignal;

import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.onesignal.OneSignal;

/* access modifiers changed from: package-private */
public class GMSLocationController extends LocationController {
    static final int API_FALLBACK_TIME = 30000;
    private static GoogleApiClientCompatProxy googleApiClient;
    static LocationUpdateListener locationUpdateListener;

    /* access modifiers changed from: private */
    public static int getApiFallbackWait() {
        return 30000;
    }

    GMSLocationController() {
    }

    static void startGetLocation() {
        initGoogleLocation();
    }

    private static void initGoogleLocation() {
        if (fallbackFailThread == null) {
            synchronized (syncLock) {
                startFallBackThread();
                if (googleApiClient != null) {
                    if (lastLocation != null) {
                        if (lastLocation != null) {
                            fireCompleteForLocation(lastLocation);
                        }
                    }
                }
                GoogleApiClientListener googleApiClientListener = new GoogleApiClientListener();
                GoogleApiClientCompatProxy googleApiClientCompatProxy = new GoogleApiClientCompatProxy(new GoogleApiClient.Builder(classContext).addApi(LocationServices.API).addConnectionCallbacks(googleApiClientListener).addOnConnectionFailedListener(googleApiClientListener).setHandler(locationHandlerThread.mHandler).build());
                googleApiClient = googleApiClientCompatProxy;
                googleApiClientCompatProxy.connect();
            }
        }
    }

    private static void startFallBackThread() {
        fallbackFailThread = new Thread(new Runnable() {
            /* class com.onesignal.GMSLocationController.AnonymousClass1 */

            public void run() {
                try {
                    Thread.sleep((long) GMSLocationController.getApiFallbackWait());
                    OneSignal.Log(OneSignal.LOG_LEVEL.WARN, "Location permission exists but GoogleApiClient timed out. Maybe related to mismatch google-play aar versions.");
                    LocationController.fireFailedComplete();
                    LocationController.scheduleUpdate(LocationController.classContext);
                } catch (InterruptedException unused) {
                }
            }
        }, "OS_GMS_LOCATION_FALLBACK");
        fallbackFailThread.start();
    }

    static void fireFailedComplete() {
        synchronized (syncLock) {
            if (googleApiClient != null) {
                googleApiClient.disconnect();
            }
            googleApiClient = null;
        }
    }

    static void onFocusChange() {
        synchronized (syncLock) {
            OneSignal.Log(OneSignal.LOG_LEVEL.DEBUG, "GMSLocationController onFocusChange!");
            if (googleApiClient != null) {
                if (googleApiClient.realInstance().isConnected()) {
                    if (googleApiClient != null) {
                        GoogleApiClient realInstance = googleApiClient.realInstance();
                        if (locationUpdateListener != null) {
                            LocationServices.FusedLocationApi.removeLocationUpdates(realInstance, locationUpdateListener);
                        }
                        locationUpdateListener = new LocationUpdateListener(realInstance);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static class GoogleApiClientListener implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
        private GoogleApiClientListener() {
        }

        @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
        public void onConnected(Bundle bundle) {
            synchronized (LocationController.syncLock) {
                PermissionsActivity.answered = false;
                if (GMSLocationController.googleApiClient != null) {
                    if (GMSLocationController.googleApiClient.realInstance() != null) {
                        OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
                        OneSignal.Log(log_level, "LocationController GoogleApiClientListener onConnected lastLocation: " + LocationController.lastLocation);
                        if (LocationController.lastLocation == null) {
                            LocationController.lastLocation = FusedLocationApiWrapper.getLastLocation(GMSLocationController.googleApiClient.realInstance());
                            OneSignal.LOG_LEVEL log_level2 = OneSignal.LOG_LEVEL.DEBUG;
                            OneSignal.Log(log_level2, "LocationController GoogleApiClientListener lastLocation: " + LocationController.lastLocation);
                            if (LocationController.lastLocation != null) {
                                LocationController.fireCompleteForLocation(LocationController.lastLocation);
                            }
                        }
                        GMSLocationController.locationUpdateListener = new LocationUpdateListener(GMSLocationController.googleApiClient.realInstance());
                    }
                }
            }
        }

        @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
        public void onConnectionSuspended(int i) {
            GMSLocationController.fireFailedComplete();
        }

        @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
        public void onConnectionFailed(ConnectionResult connectionResult) {
            GMSLocationController.fireFailedComplete();
        }
    }

    /* access modifiers changed from: package-private */
    public static class LocationUpdateListener implements LocationListener {
        private GoogleApiClient googleApiClient;

        LocationUpdateListener(GoogleApiClient googleApiClient2) {
            this.googleApiClient = googleApiClient2;
            init();
        }

        private void init() {
            long j = OneSignal.isForeground() ? 270000 : 570000;
            if (this.googleApiClient != null) {
                LocationRequest interval = LocationRequest.create().setFastestInterval(j).setInterval(j);
                double d = (double) j;
                Double.isNaN(d);
                LocationRequest priority = interval.setMaxWaitTime((long) (d * 1.5d)).setPriority(102);
                OneSignal.Log(OneSignal.LOG_LEVEL.DEBUG, "GMSLocationController GoogleApiClient requestLocationUpdates!");
                FusedLocationApiWrapper.requestLocationUpdates(this.googleApiClient, priority, this);
            }
        }

        @Override // com.google.android.gms.location.LocationListener
        public void onLocationChanged(Location location) {
            OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
            OneSignal.Log(log_level, "GMSLocationController onLocationChanged: " + location);
            LocationController.lastLocation = location;
        }
    }

    /* access modifiers changed from: package-private */
    public static class FusedLocationApiWrapper {
        FusedLocationApiWrapper() {
        }

        static void requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener) {
            try {
                synchronized (GMSLocationController.syncLock) {
                    if (googleApiClient.isConnected()) {
                        LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, locationListener);
                    }
                }
            } catch (Throwable th) {
                OneSignal.Log(OneSignal.LOG_LEVEL.WARN, "FusedLocationApi.requestLocationUpdates failed!", th);
            }
        }

        static Location getLastLocation(GoogleApiClient googleApiClient) {
            synchronized (GMSLocationController.syncLock) {
                if (!googleApiClient.isConnected()) {
                    return null;
                }
                return LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
            }
        }
    }
}
