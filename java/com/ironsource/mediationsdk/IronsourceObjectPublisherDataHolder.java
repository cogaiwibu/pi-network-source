package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class IronsourceObjectPublisherDataHolder {
    private static IronsourceObjectPublisherDataHolder sInstance;
    private final HashSet<ImpressionDataListener> impressionDataListeners = new HashSet<>();
    private ConcurrentHashMap<String, List<String>> mediationMetaData = new ConcurrentHashMap<>();

    public static synchronized IronsourceObjectPublisherDataHolder getInstance() {
        IronsourceObjectPublisherDataHolder ironsourceObjectPublisherDataHolder;
        synchronized (IronsourceObjectPublisherDataHolder.class) {
            if (sInstance == null) {
                sInstance = new IronsourceObjectPublisherDataHolder();
            }
            ironsourceObjectPublisherDataHolder = sInstance;
        }
        return ironsourceObjectPublisherDataHolder;
    }

    IronsourceObjectPublisherDataHolder() {
    }

    public HashSet<ImpressionDataListener> getImpressionDataListeners() {
        return this.impressionDataListeners;
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

    public ConcurrentHashMap<String, List<String>> getMediationMetaData() {
        return this.mediationMetaData;
    }

    public void setMetaData(String str, List<String> list) {
        this.mediationMetaData.put(str, list);
    }
}
