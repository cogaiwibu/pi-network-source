package com.ironsource.mediationsdk;

import com.ironsource.lifecycle.LifecycleSensitiveTimer;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class ExpiredRvAdsManager {
    private static final int EXPIRED_DURATION_DISABLED = -1;
    private Runnable expirationTask;
    private int expiredDurationInMinutes;
    private IRewardedManager manager;
    private LifecycleSensitiveTimer timer;

    private static class ExpiredRvAdsManagerHolder {
        private static volatile ExpiredRvAdsManager instance = new ExpiredRvAdsManager();

        private ExpiredRvAdsManagerHolder() {
        }
    }

    private ExpiredRvAdsManager() {
        this.expiredDurationInMinutes = 0;
    }

    static ExpiredRvAdsManager getInstance() {
        return ExpiredRvAdsManagerHolder.instance;
    }

    /* access modifiers changed from: package-private */
    public void initialize(final IRewardedManager iRewardedManager, int i) {
        this.manager = iRewardedManager;
        if (i > 0) {
            this.expiredDurationInMinutes = i;
            this.expirationTask = new Runnable() {
                /* class com.ironsource.mediationsdk.ExpiredRvAdsManager.AnonymousClass1 */

                public void run() {
                    IronLog.INTERNAL.info("loaded ads are expired");
                    IRewardedManager iRewardedManager = iRewardedManager;
                    if (iRewardedManager != null) {
                        iRewardedManager.reloadRewardedVideos();
                    }
                }
            };
        } else {
            this.expiredDurationInMinutes = -1;
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("initializing with expiredDurationInMinutes=" + this.expiredDurationInMinutes);
    }

    /* access modifiers changed from: package-private */
    public void startExpirationTimerForAds(long j) {
        if (enabled()) {
            long millis = TimeUnit.MINUTES.toMillis((long) this.expiredDurationInMinutes) - Math.max(j, 0L);
            if (millis > 0) {
                cancelExpirationScheduler();
                this.timer = new LifecycleSensitiveTimer(millis, this.expirationTask, true);
                Calendar instance = Calendar.getInstance();
                instance.add(14, (int) millis);
                IronLog ironLog = IronLog.INTERNAL;
                StringBuilder sb = new StringBuilder();
                sb.append("loaded ads will expire on: ");
                sb.append(instance.getTime());
                sb.append(" in ");
                double d = (double) millis;
                Double.isNaN(d);
                sb.append(String.format("%.2f", Double.valueOf((d / 1000.0d) / 60.0d)));
                sb.append(" mins");
                ironLog.info(sb.toString());
                return;
            }
            IronLog.INTERNAL.info("loaded ads are loaded immediately");
            this.manager.reloadRewardedVideos();
        }
    }

    /* access modifiers changed from: package-private */
    public void cancelExpirationScheduler() {
        if (enabled() && this.timer != null) {
            IronLog.INTERNAL.info("canceling expiration timer");
            this.timer.invalidate();
        }
    }

    public boolean enabled() {
        return this.expiredDurationInMinutes != -1;
    }
}
