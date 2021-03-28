package com.ironsource.sdk.controller;

import com.ironsource.sdk.constants.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FeaturesManager {
    private static final String DEBUG_MODE = "debugMode";
    private static final String TAG = "FeaturesManager";
    private static volatile FeaturesManager sSoleInstance;
    private Map<String, ?> mDebugConfigurations;
    private ArrayList<String> mSupportedFeatures = new ArrayList<String>() {
        /* class com.ironsource.sdk.controller.FeaturesManager.AnonymousClass1 */

        {
            add(Constants.FeaturesManager.WEB_VIEW_PER_AD_V1);
            add(Constants.FeaturesManager.NO_PACKAGES_INSTALLATION_POLLING);
        }
    };

    private FeaturesManager() {
        if (sSoleInstance == null) {
            this.mDebugConfigurations = new HashMap();
            return;
        }
        throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
    }

    public static FeaturesManager getInstance() {
        if (sSoleInstance == null) {
            synchronized (FeaturesManager.class) {
                if (sSoleInstance == null) {
                    sSoleInstance = new FeaturesManager();
                }
            }
        }
        return sSoleInstance;
    }

    public void updateDebugConfigurations(Map<String, Object> map) {
        if (map != null) {
            this.mDebugConfigurations = map;
        }
    }

    public int getDebugMode() {
        Integer num = 0;
        try {
            if (this.mDebugConfigurations.containsKey("debugMode")) {
                num = (Integer) this.mDebugConfigurations.get("debugMode");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public ArrayList<String> getSupportedFeatures() {
        return new ArrayList<>(this.mSupportedFeatures);
    }
}
