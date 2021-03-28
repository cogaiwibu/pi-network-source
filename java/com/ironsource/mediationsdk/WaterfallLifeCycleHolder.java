package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class WaterfallLifeCycleHolder {
    private static String TAG = "WaterfallLifeCycleHolder";
    private String currentWaterfallId = "";
    private List<String> disableLoadWhileShowSupportNetworks;
    private String previousWaterfallId = "";
    private LWSProgRvSmash showingSmash;
    private int timeToDeleteOldWaterfallAfterAuction;
    private Timer timer = new Timer();
    ConcurrentHashMap<String, CopyOnWriteArrayList<LWSProgRvSmash>> waterfalls = new ConcurrentHashMap<>();

    public WaterfallLifeCycleHolder(List<String> list, int i) {
        this.disableLoadWhileShowSupportNetworks = list;
        this.timeToDeleteOldWaterfallAfterAuction = i;
    }

    public void setShowingSmash(LWSProgRvSmash lWSProgRvSmash) {
        this.showingSmash = lWSProgRvSmash;
    }

    public LWSProgRvSmash getShowingSmash() {
        return this.showingSmash;
    }

    public CopyOnWriteArrayList<LWSProgRvSmash> getCurrentWaterfall() {
        CopyOnWriteArrayList<LWSProgRvSmash> copyOnWriteArrayList = this.waterfalls.get(this.currentWaterfallId);
        return copyOnWriteArrayList == null ? new CopyOnWriteArrayList<>() : copyOnWriteArrayList;
    }

    public String getCurrentWaterfallId() {
        return this.currentWaterfallId;
    }

    public boolean shouldAddSmashToWaterfallRequest(LWSProgRvSmash lWSProgRvSmash) {
        boolean z = false;
        if (lWSProgRvSmash == null || (this.showingSmash != null && ((lWSProgRvSmash.getLoadWhileShowSupportState() == LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_NETWORK && this.showingSmash.getInstanceName().equals(lWSProgRvSmash.getInstanceName())) || ((lWSProgRvSmash.getLoadWhileShowSupportState() == LoadWhileShowSupportState.NONE || this.disableLoadWhileShowSupportNetworks.contains(lWSProgRvSmash.getNameForReflection())) && this.showingSmash.getNameForReflection().equals(lWSProgRvSmash.getNameForReflection()))))) {
            z = true;
        }
        if (z && lWSProgRvSmash != null) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.info(lWSProgRvSmash.getInstanceName() + " does not support load while show and will not be added to the auction request");
        }
        return !z;
    }

    public void updateWaterFall(CopyOnWriteArrayList<LWSProgRvSmash> copyOnWriteArrayList, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.info("updating new  waterfall with id " + str);
        this.waterfalls.put(str, copyOnWriteArrayList);
        if (!TextUtils.isEmpty(this.previousWaterfallId)) {
            if (isPreviousWaterfallShowing()) {
                IronLog ironLog2 = IronLog.INTERNAL;
                ironLog2.info("ad from previous waterfall " + this.previousWaterfallId + " is still showing - the current waterfall " + this.currentWaterfallId + " will be deleted instead");
                String str2 = this.currentWaterfallId;
                this.currentWaterfallId = this.previousWaterfallId;
                this.previousWaterfallId = str2;
            }
            final String str3 = this.previousWaterfallId;
            this.timer.schedule(new TimerTask() {
                /* class com.ironsource.mediationsdk.WaterfallLifeCycleHolder.AnonymousClass1 */

                public void run() {
                    try {
                        IronLog ironLog = IronLog.INTERNAL;
                        ironLog.info("removing waterfall with id " + str3 + " from memory");
                        WaterfallLifeCycleHolder.this.waterfalls.remove(str3);
                        IronLog ironLog2 = IronLog.INTERNAL;
                        ironLog2.info("waterfall size is currently " + WaterfallLifeCycleHolder.this.waterfalls.size());
                    } finally {
                        cancel();
                    }
                }
            }, (long) this.timeToDeleteOldWaterfallAfterAuction);
        }
        this.previousWaterfallId = this.currentWaterfallId;
        this.currentWaterfallId = str;
    }

    public int getNumberOfWaterfalls() {
        return this.waterfalls.size();
    }

    public boolean areWaterFallsOverMaximum() {
        return this.waterfalls.size() > 5;
    }

    public boolean isPreviousWaterfallShowing() {
        LWSProgRvSmash lWSProgRvSmash = this.showingSmash;
        return lWSProgRvSmash != null && lWSProgRvSmash.getAuctionId().equals(this.previousWaterfallId);
    }
}
