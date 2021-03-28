package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.HashSet;
import java.util.Iterator;

public abstract class BaseProgManager {
    private HashSet<ImpressionDataListener> impressionDataListeners = new HashSet<>();

    public BaseProgManager(HashSet<ImpressionDataListener> hashSet) {
        this.impressionDataListeners = hashSet;
    }

    public void addImpressionDataListener(ImpressionDataListener impressionDataListener) {
        synchronized (this) {
            this.impressionDataListeners.add(impressionDataListener);
        }
    }

    public void removeImpressionDataListener(ImpressionDataListener impressionDataListener) {
        synchronized (this) {
            this.impressionDataListeners.remove(impressionDataListener);
        }
    }

    public void removeAllImpressionDataListeners() {
        synchronized (this) {
            this.impressionDataListeners.clear();
        }
    }

    /* access modifiers changed from: protected */
    public void reportImpressionDataToPublisher(AuctionResponseItem auctionResponseItem, String str) {
        if (auctionResponseItem != null) {
            ImpressionData impressionData = auctionResponseItem.getImpressionData(str);
            if (impressionData != null) {
                Iterator<ImpressionDataListener> it = this.impressionDataListeners.iterator();
                while (it.hasNext()) {
                    ImpressionDataListener next = it.next();
                    IronLog ironLog = IronLog.CALLBACK;
                    ironLog.info("onImpressionSuccess " + next.getClass().getSimpleName() + ": " + impressionData);
                    next.onImpressionSuccess(impressionData);
                }
                return;
            }
            return;
        }
        IronLog.INTERNAL.verbose("no auctionResponseItem or listener");
    }

    /* access modifiers changed from: protected */
    public String getAuctionFallbackId() {
        return "fallback_" + System.currentTimeMillis();
    }
}
