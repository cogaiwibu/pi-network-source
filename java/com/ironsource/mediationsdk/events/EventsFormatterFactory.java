package com.ironsource.mediationsdk.events;

import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;

class EventsFormatterFactory {
    static final int AD_UNIT_INTERSTITIAL = 2;
    static final int AD_UNIT_REWARDED_VIDEO = 3;
    static final String TYPE_IRONBEAST = "ironbeast";
    static final String TYPE_OUTCOME = "outcome";

    EventsFormatterFactory() {
    }

    static AbstractEventsFormatter getFormatter(String str, int i) {
        if (TYPE_IRONBEAST.equals(str)) {
            return new IronbeastEventsFormatter(i);
        }
        if ("outcome".equals(str)) {
            return new OutcomeEventsFormatter(i);
        }
        if (i == 2) {
            return new IronbeastEventsFormatter(i);
        }
        if (i == 3) {
            return new OutcomeEventsFormatter(i);
        }
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
        logger.log(ironSourceTag, "EventsFormatterFactory failed to instantiate a formatter (type: " + str + ", adUnit: " + i + ")", 2);
        return null;
    }
}
