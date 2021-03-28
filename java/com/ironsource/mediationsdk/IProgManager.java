package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;

public interface IProgManager {
    void addImpressionDataListener(ImpressionDataListener impressionDataListener);

    void removeAllImpressionDataListeners();

    void removeImpressionDataListener(ImpressionDataListener impressionDataListener);
}
