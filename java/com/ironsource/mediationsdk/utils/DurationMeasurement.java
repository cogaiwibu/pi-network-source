package com.ironsource.mediationsdk.utils;

import java.util.Date;

public class DurationMeasurement {
    private long mStartedTimestamp = new Date().getTime();

    public static long getMeasuredDuration(DurationMeasurement durationMeasurement) {
        if (durationMeasurement == null) {
            return 0;
        }
        return new Date().getTime() - durationMeasurement.mStartedTimestamp;
    }
}
