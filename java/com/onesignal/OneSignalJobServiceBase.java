package com.onesignal;

import android.app.job.JobParameters;
import android.app.job.JobService;

abstract class OneSignalJobServiceBase extends JobService {
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }

    /* access modifiers changed from: package-private */
    public abstract void startProcessing(JobService jobService, JobParameters jobParameters);

    OneSignalJobServiceBase() {
    }

    public boolean onStartJob(final JobParameters jobParameters) {
        if (jobParameters.getExtras() == null) {
            return false;
        }
        new Thread(new Runnable() {
            /* class com.onesignal.OneSignalJobServiceBase.AnonymousClass1 */

            public void run() {
                OneSignalJobServiceBase.this.startProcessing(this, jobParameters);
                OneSignalJobServiceBase.this.jobFinished(jobParameters, false);
            }
        }, "OS_JOBSERVICE_BASE").start();
        return true;
    }
}
