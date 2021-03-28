package com.facebook.react.uimanager;

import com.facebook.yoga.YogaConfig;
import com.facebook.yoga.YogaConfigFactory;

public class ReactYogaConfigProvider {
    private static YogaConfig YOGA_CONFIG;

    public static YogaConfig get() {
        if (YOGA_CONFIG == null) {
            YogaConfig create = YogaConfigFactory.create();
            YOGA_CONFIG = create;
            create.setPointScaleFactor(0.0f);
            YOGA_CONFIG.setUseLegacyStretchBehaviour(true);
        }
        return YOGA_CONFIG;
    }
}
