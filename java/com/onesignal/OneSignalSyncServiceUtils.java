package com.onesignal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.onesignal.AndroidSupportV4Compat;
import com.onesignal.LocationController;
import com.onesignal.OneSignal;
import java.util.concurrent.ArrayBlockingQueue;

/* access modifiers changed from: package-private */
public class OneSignalSyncServiceUtils {
    private static final long SYNC_AFTER_BG_DELAY_MS = 30000;
    private static final int SYNC_TASK_ID = 2071862118;
    private static boolean needsJobReschedule = false;
    private static Long nextScheduledSyncTimeMs = 0L;
    private static Thread syncBgThread;

    OneSignalSyncServiceUtils() {
    }

    static void scheduleLocationUpdateTask(Context context, long j) {
        OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.VERBOSE;
        OneSignal.Log(log_level, "scheduleLocationUpdateTask:delayMs: " + j);
        scheduleSyncTask(context, j);
    }

    static void scheduleSyncTask(Context context) {
        OneSignal.Log(OneSignal.LOG_LEVEL.VERBOSE, "scheduleSyncTask:SYNC_AFTER_BG_DELAY_MS: 30000");
        scheduleSyncTask(context, SYNC_AFTER_BG_DELAY_MS);
    }

    static synchronized void cancelSyncTask(Context context) {
        synchronized (OneSignalSyncServiceUtils.class) {
            nextScheduledSyncTimeMs = 0L;
            if (!LocationController.scheduleUpdate(context)) {
                if (useJob()) {
                    ((JobScheduler) context.getSystemService("jobscheduler")).cancel(SYNC_TASK_ID);
                } else {
                    ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(syncServicePendingIntent(context));
                }
            }
        }
    }

    private static PendingIntent syncServicePendingIntent(Context context) {
        return PendingIntent.getService(context, SYNC_TASK_ID, new Intent(context, SyncService.class), 134217728);
    }

    private static boolean useJob() {
        return Build.VERSION.SDK_INT >= 21;
    }

    private static synchronized void scheduleSyncTask(Context context, long j) {
        synchronized (OneSignalSyncServiceUtils.class) {
            if (nextScheduledSyncTimeMs.longValue() == 0 || System.currentTimeMillis() + j <= nextScheduledSyncTimeMs.longValue()) {
                if (j < 5000) {
                    j = 5000;
                }
                if (useJob()) {
                    scheduleSyncServiceAsJob(context, j);
                } else {
                    scheduleSyncServiceAsAlarm(context, j);
                }
                nextScheduledSyncTimeMs = Long.valueOf(System.currentTimeMillis() + j);
            }
        }
    }

    private static boolean hasBootPermission(Context context) {
        return AndroidSupportV4Compat.ContextCompat.checkSelfPermission(context, "android.permission.RECEIVE_BOOT_COMPLETED") == 0;
    }

    private static boolean isJobIdRunning(Context context) {
        Thread thread;
        for (JobInfo jobInfo : ((JobScheduler) context.getSystemService("jobscheduler")).getAllPendingJobs()) {
            if (jobInfo.getId() == SYNC_TASK_ID && (thread = syncBgThread) != null && thread.isAlive()) {
                return true;
            }
        }
        return false;
    }

    private static void scheduleSyncServiceAsJob(Context context, long j) {
        OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.VERBOSE;
        OneSignal.Log(log_level, "scheduleSyncServiceAsJob:atTime: " + j);
        if (isJobIdRunning(context)) {
            OneSignal.Log(OneSignal.LOG_LEVEL.VERBOSE, "scheduleSyncServiceAsJob Scheduler already running!");
            needsJobReschedule = true;
            return;
        }
        JobInfo.Builder builder = new JobInfo.Builder(SYNC_TASK_ID, new ComponentName(context, SyncJobService.class));
        builder.setMinimumLatency(j).setRequiredNetworkType(1);
        if (hasBootPermission(context)) {
            builder.setPersisted(true);
        }
        try {
            int schedule = ((JobScheduler) context.getSystemService("jobscheduler")).schedule(builder.build());
            OneSignal.LOG_LEVEL log_level2 = OneSignal.LOG_LEVEL.INFO;
            OneSignal.Log(log_level2, "scheduleSyncServiceAsJob:result: " + schedule);
        } catch (NullPointerException e) {
            OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "scheduleSyncServiceAsJob called JobScheduler.jobScheduler which triggered an internal null Android error. Skipping job.", e);
        }
    }

    private static void scheduleSyncServiceAsAlarm(Context context, long j) {
        OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.VERBOSE;
        OneSignal.Log(log_level, "scheduleServiceSyncTask:atTime: " + j);
        ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).set(0, System.currentTimeMillis() + j + j, syncServicePendingIntent(context));
    }

    static void doBackgroundSync(Context context, SyncRunnable syncRunnable) {
        OneSignal.setAppContext(context);
        Thread thread = new Thread(syncRunnable, "OS_SYNCSRV_BG_SYNC");
        syncBgThread = thread;
        thread.start();
    }

    static boolean stopSyncBgThread() {
        Thread thread = syncBgThread;
        if (thread == null || !thread.isAlive()) {
            return false;
        }
        syncBgThread.interrupt();
        return true;
    }

    static abstract class SyncRunnable implements Runnable {
        /* access modifiers changed from: protected */
        public abstract void stopSync();

        SyncRunnable() {
        }

        public final void run() {
            synchronized (OneSignalSyncServiceUtils.class) {
                Long unused = OneSignalSyncServiceUtils.nextScheduledSyncTimeMs = 0L;
            }
            if (OneSignal.getUserId() == null) {
                stopSync();
                return;
            }
            OneSignal.appId = OneSignal.getSavedAppId();
            OneSignalStateSynchronizer.initUserState();
            try {
                final ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);
                LocationController.getLocation(OneSignal.appContext, false, false, new LocationController.LocationHandler() {
                    /* class com.onesignal.OneSignalSyncServiceUtils.SyncRunnable.AnonymousClass1 */

                    @Override // com.onesignal.LocationController.LocationHandler
                    public LocationController.PermissionType getType() {
                        return LocationController.PermissionType.SYNC_SERVICE;
                    }

                    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:0:0x0000 */
                    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.onesignal.LocationController$LocationPoint */
                    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.lang.Object */
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r2v1 */
                    @Override // com.onesignal.LocationController.LocationHandler
                    public void onComplete(LocationController.LocationPoint locationPoint) {
                        if (locationPoint == 0) {
                            locationPoint = new Object();
                        }
                        arrayBlockingQueue.offer(locationPoint == true ? 1 : 0);
                    }
                });
                Object take = arrayBlockingQueue.take();
                if (take instanceof LocationController.LocationPoint) {
                    OneSignalStateSynchronizer.updateLocation((LocationController.LocationPoint) take);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            OneSignalStateSynchronizer.syncUserState(true);
            FocusTimeController.getInstance().doBlockingBackgroundSyncOfUnsentTime();
            stopSync();
        }
    }

    static class LollipopSyncRunnable extends SyncRunnable {
        private JobParameters jobParameters;
        private JobService jobService;

        LollipopSyncRunnable(JobService jobService2, JobParameters jobParameters2) {
            this.jobService = jobService2;
            this.jobParameters = jobParameters2;
        }

        /* access modifiers changed from: protected */
        @Override // com.onesignal.OneSignalSyncServiceUtils.SyncRunnable
        public void stopSync() {
            OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
            OneSignal.Log(log_level, "LollipopSyncRunnable:JobFinished needsJobReschedule: " + OneSignalSyncServiceUtils.needsJobReschedule);
            boolean z = OneSignalSyncServiceUtils.needsJobReschedule;
            boolean unused = OneSignalSyncServiceUtils.needsJobReschedule = false;
            this.jobService.jobFinished(this.jobParameters, z);
        }
    }

    static class LegacySyncRunnable extends SyncRunnable {
        Service callerService;

        LegacySyncRunnable(Service service) {
            this.callerService = service;
        }

        /* access modifiers changed from: protected */
        @Override // com.onesignal.OneSignalSyncServiceUtils.SyncRunnable
        public void stopSync() {
            OneSignal.Log(OneSignal.LOG_LEVEL.DEBUG, "LegacySyncRunnable:Stopped");
            this.callerService.stopSelf();
        }
    }
}
