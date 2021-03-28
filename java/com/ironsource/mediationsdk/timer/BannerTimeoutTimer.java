package com.ironsource.mediationsdk.timer;

public class BannerTimeoutTimer extends AbstractTimer<TimeoutInterface> {

    public interface TimeoutInterface {
        void onTimeout();
    }

    public BannerTimeoutTimer(long j) {
        super(j);
    }

    /* access modifiers changed from: package-private */
    @Override // com.ironsource.mediationsdk.timer.AbstractTimer
    public void onTick() {
        if (this.mListener != null) {
            ((TimeoutInterface) this.mListener).onTimeout();
        }
    }

    public void startTimeoutTimer(TimeoutInterface timeoutInterface) {
        startTimer(timeoutInterface);
    }

    public void stopTimeoutTimer() {
        stopTimer();
    }
}
