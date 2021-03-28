package com.ironsource.mediationsdk.utils;

import com.ironsource.mediationsdk.ProgSmash;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SessionCappingManager {
    private Map<String, Integer> mMaxAdsPerSessionMap = new HashMap();
    private Map<String, Integer> mShowCountMap = new HashMap();

    public SessionCappingManager(List<ProgSmash> list) {
        for (ProgSmash progSmash : list) {
            this.mShowCountMap.put(progSmash.getInstanceName(), 0);
            this.mMaxAdsPerSessionMap.put(progSmash.getInstanceName(), Integer.valueOf(progSmash.getMaxAdsPerSession()));
        }
    }

    public void increaseShowCounter(ProgSmash progSmash) {
        synchronized (this) {
            String instanceName = progSmash.getInstanceName();
            if (this.mShowCountMap.containsKey(instanceName)) {
                this.mShowCountMap.put(instanceName, Integer.valueOf(this.mShowCountMap.get(instanceName).intValue() + 1));
            }
        }
    }

    public boolean isCapped(ProgSmash progSmash) {
        synchronized (this) {
            String instanceName = progSmash.getInstanceName();
            boolean z = false;
            if (!this.mShowCountMap.containsKey(instanceName)) {
                return false;
            }
            if (this.mShowCountMap.get(instanceName).intValue() >= progSmash.getMaxAdsPerSession()) {
                z = true;
            }
            return z;
        }
    }

    public boolean areAllSmashesCapped() {
        for (String str : this.mMaxAdsPerSessionMap.keySet()) {
            if (this.mShowCountMap.get(str).intValue() < this.mMaxAdsPerSessionMap.get(str).intValue()) {
                return false;
            }
        }
        return true;
    }
}
