package com.google.android.gms.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

@Deprecated
public interface ActivityRecognitionApi {
    PendingResult<Status> removeActivityUpdates(GoogleApiClient googleApiClient, PendingIntent pendingIntent);

    PendingResult<Status> requestActivityUpdates(GoogleApiClient googleApiClient, long j, PendingIntent pendingIntent);

    PendingResult<Status> zza(GoogleApiClient googleApiClient, PendingIntent pendingIntent);

    PendingResult<Status> zza(GoogleApiClient googleApiClient, ActivityTransitionRequest activityTransitionRequest, PendingIntent pendingIntent);
}
