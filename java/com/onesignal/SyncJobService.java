package com.onesignal;

import android.app.job.JobParameters;
import android.app.job.JobService;
import com.onesignal.OneSignal;
import com.onesignal.OneSignalSyncServiceUtils;

public class SyncJobService extends JobService {
    public boolean onStartJob(JobParameters jobParameters) {
        OneSignalSyncServiceUtils.doBackgroundSync(this, new OneSignalSyncServiceUtils.LollipopSyncRunnable(this, jobParameters));
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        boolean stopSyncBgThread = OneSignalSyncServiceUtils.stopSyncBgThread();
        OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
        OneSignal.Log(log_level, "SyncJobService onStopJob called, system conditions not available reschedule: " + stopSyncBgThread);
        return stopSyncBgThread;
    }
}
