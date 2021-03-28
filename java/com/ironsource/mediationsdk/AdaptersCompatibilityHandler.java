package com.ironsource.mediationsdk;

import com.ironsource.environment.StringUtils;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AdaptersCompatibilityHandler {
    private static final AdaptersCompatibilityHandler instance = new AdaptersCompatibilityHandler();
    private final ConcurrentHashMap<String, String> mAdapterNameToMinIsVersion;
    private final ConcurrentHashMap<String, String> mAdapterNameToMinRvVersion;

    public static AdaptersCompatibilityHandler getInstance() {
        return instance;
    }

    private AdaptersCompatibilityHandler() {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        this.mAdapterNameToMinIsVersion = concurrentHashMap;
        concurrentHashMap.put("adcolony", "4.1.6");
        this.mAdapterNameToMinIsVersion.put("vungle", "4.1.5");
        this.mAdapterNameToMinIsVersion.put("applovin", "4.3.3");
        this.mAdapterNameToMinIsVersion.put("admob", "4.3.2");
        ConcurrentHashMap<String, String> concurrentHashMap2 = new ConcurrentHashMap<>();
        this.mAdapterNameToMinRvVersion = concurrentHashMap2;
        concurrentHashMap2.put("adcolony", "4.1.6");
        this.mAdapterNameToMinRvVersion.put("admob", "4.3.2");
        this.mAdapterNameToMinRvVersion.put("applovin", "4.3.3");
        this.mAdapterNameToMinRvVersion.put("chartboost", "4.1.9");
        this.mAdapterNameToMinRvVersion.put("fyber", "4.1.0");
        this.mAdapterNameToMinRvVersion.put("hyprmx", "4.1.2");
        this.mAdapterNameToMinRvVersion.put("inmobi", "4.3.1");
        this.mAdapterNameToMinRvVersion.put("maio", "4.1.3");
        this.mAdapterNameToMinRvVersion.put("tapjoy", "4.0.0");
        this.mAdapterNameToMinRvVersion.put("unityads", "4.1.4");
        this.mAdapterNameToMinRvVersion.put("vungle", "4.1.5");
    }

    public boolean isAdapterVersionRVCompatible(AbstractAdapter abstractAdapter) {
        return isAdapterVersionCompatible(abstractAdapter, this.mAdapterNameToMinRvVersion, "rewarded video");
    }

    public boolean isAdapterVersionISCompatible(AbstractAdapter abstractAdapter) {
        return isAdapterVersionCompatible(abstractAdapter, this.mAdapterNameToMinIsVersion, IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE);
    }

    private boolean isAdapterVersionCompatible(AbstractAdapter abstractAdapter, Map<String, String> map, String str) {
        if (abstractAdapter == null) {
            return false;
        }
        String lowerCase = StringUtils.toLowerCase(abstractAdapter.getProviderName());
        if (!map.containsKey(lowerCase)) {
            return true;
        }
        String version = abstractAdapter.getVersion();
        boolean isVersionGreaterOrEqual = isVersionGreaterOrEqual(map.get(lowerCase), version);
        if (!isVersionGreaterOrEqual) {
            IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, abstractAdapter.getProviderName() + " adapter " + version + " is incompatible with SDK version " + IronSourceUtils.getSDKVersion() + " for " + str + " ad unit, please update your adapter to the latest version", 3);
        }
        return isVersionGreaterOrEqual;
    }

    public boolean isBannerAdapterCompatible(AbstractAdapter abstractAdapter) {
        if (abstractAdapter == null) {
            return false;
        }
        String version = abstractAdapter.getVersion();
        boolean isVersionGreaterOrEqual = isVersionGreaterOrEqual("4.3.0", version);
        if (!isVersionGreaterOrEqual) {
            IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, abstractAdapter.getProviderName() + " adapter " + version + " is incompatible with SDK version " + IronSourceUtils.getSDKVersion() + ", please update your adapter to the latest version", 3);
        }
        return isVersionGreaterOrEqual;
    }

    private boolean isVersionGreaterOrEqual(String str, String str2) {
        if (str.equalsIgnoreCase(str2)) {
            return true;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        for (int i = 0; i < 3; i++) {
            int parseInt = Integer.parseInt(split[i]);
            int parseInt2 = Integer.parseInt(split2[i]);
            if (parseInt2 < parseInt) {
                return false;
            }
            if (parseInt2 > parseInt) {
                return true;
            }
        }
        return true;
    }
}
