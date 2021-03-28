package com.ironsource.lifecycle;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class LifecycleSensitiveTimer implements IronsourceLifecycleListener {
    private String TAG = "INTERNAL";
    private Long fireTimestamp;
    private boolean started;
    private long timeIntervalInMs;
    private Timer timer;
    private Runnable timerTask;

    @Override // com.ironsource.lifecycle.IronsourceLifecycleListener
    public void appPaused() {
    }

    @Override // com.ironsource.lifecycle.IronsourceLifecycleListener
    public void appResumed() {
    }

    public LifecycleSensitiveTimer(long j, Runnable runnable, boolean z) {
        this.timeIntervalInMs = j;
        this.timerTask = runnable;
        this.started = false;
        this.fireTimestamp = null;
        if (z) {
            startNow();
        }
    }

    public void startNow() {
        if (!this.started) {
            this.started = true;
            IronsourceLifecycleManager.getInstance().addObserver(this);
            this.fireTimestamp = Long.valueOf(System.currentTimeMillis() + this.timeIntervalInMs);
            if (!IronsourceLifecycleManager.getInstance().isAppInBackground()) {
                startTimer();
            }
        }
    }

    public void invalidate() {
        invalidateTimer();
        this.started = false;
        this.fireTimestamp = null;
        IronsourceLifecycleManager.getInstance().removeObserver(this);
    }

    @Override // com.ironsource.lifecycle.IronsourceLifecycleListener
    public void appStarted() {
        Long l;
        if (this.timer == null && (l = this.fireTimestamp) != null) {
            long longValue = l.longValue() - System.currentTimeMillis();
            this.timeIntervalInMs = longValue;
            if (longValue <= 0) {
                invalidate();
                this.timerTask.run();
                return;
            }
            startTimer();
        }
    }

    @Override // com.ironsource.lifecycle.IronsourceLifecycleListener
    public void appStopped() {
        if (this.timer != null) {
            invalidateTimer();
        }
    }

    private void startTimer() {
        if (this.timer == null) {
            Timer timer2 = new Timer();
            this.timer = timer2;
            timer2.schedule(new TimerTask() {
                /* class com.ironsource.lifecycle.LifecycleSensitiveTimer.AnonymousClass1 */

                public void run() {
                    LifecycleSensitiveTimer.this.timerTask.run();
                }
            }, this.timeIntervalInMs);
            Calendar.getInstance().setTimeInMillis(this.fireTimestamp.longValue());
        }
    }

    private void invalidateTimer() {
        Timer timer2 = this.timer;
        if (timer2 != null) {
            timer2.cancel();
            this.timer = null;
        }
    }
}
