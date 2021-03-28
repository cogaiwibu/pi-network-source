package com.ironsource.mediationsdk.timer;

public class BannerReloadTimer extends AbstractTimer<ReloadIntervalInterface> {

    public interface ReloadIntervalInterface {
        void onReloadInterval();
    }

    public BannerReloadTimer(int i) {
        super((long) (i * 1000));
    }

    /* access modifiers changed from: package-private */
    @Override // com.ironsource.mediationsdk.timer.AbstractTimer
    public void onTick() {
        if (this.mListener != null) {
            ((ReloadIntervalInterface) this.mListener).onReloadInterval();
        }
    }

    public void startReloadTimer(ReloadIntervalInterface reloadIntervalInterface) {
        startTimer(reloadIntervalInterface);
    }

    public void stopReloadTimer() {
        stopTimer();
    }
}
