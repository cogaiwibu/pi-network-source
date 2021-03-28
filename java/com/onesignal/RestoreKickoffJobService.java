package com.onesignal;

import android.app.job.JobParameters;
import android.app.job.JobService;

public class RestoreKickoffJobService extends OneSignalJobServiceBase {
    @Override // com.onesignal.OneSignalJobServiceBase
    public /* bridge */ /* synthetic */ boolean onStartJob(JobParameters jobParameters) {
        return super.onStartJob(jobParameters);
    }

    @Override // com.onesignal.OneSignalJobServiceBase
    public /* bridge */ /* synthetic */ boolean onStopJob(JobParameters jobParameters) {
        return super.onStopJob(jobParameters);
    }

    /* access modifiers changed from: package-private */
    @Override // com.onesignal.OneSignalJobServiceBase
    public void startProcessing(JobService jobService, JobParameters jobParameters) {
        Thread.currentThread().setPriority(10);
        OneSignal.setAppContext(this);
        NotificationRestorer.restore(getApplicationContext());
    }
}
