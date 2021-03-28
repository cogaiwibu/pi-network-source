package com.ironsource.mediationsdk.timer;

import java.util.Timer;
import java.util.TimerTask;

public abstract class AbstractTimer<T> {
    private long mDuration;
    protected T mListener;
    private Timer mTimer;

    /* access modifiers changed from: package-private */
    public abstract void onTick();

    public AbstractTimer(long j) {
        this.mDuration = j;
    }

    /* access modifiers changed from: protected */
    public boolean isDisabled() {
        return this.mDuration <= 0;
    }

    /* access modifiers changed from: protected */
    public void startTimer(T t) {
        if (!isDisabled() && t != null) {
            this.mListener = t;
            stopTimer();
            Timer timer = new Timer();
            this.mTimer = timer;
            timer.schedule(new TimerTask() {
                /* class com.ironsource.mediationsdk.timer.AbstractTimer.AnonymousClass1 */

                public void run() {
                    AbstractTimer.this.onTick();
                }
            }, this.mDuration);
        }
    }

    /* access modifiers changed from: protected */
    public void stopTimer() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer = null;
        }
    }
}
