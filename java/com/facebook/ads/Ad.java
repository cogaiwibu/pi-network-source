package com.facebook.ads;

public interface Ad {

    public interface LoadAdConfig {
    }

    public interface LoadConfigBuilder {
        LoadAdConfig build();

        LoadConfigBuilder withBid(String str);
    }

    void destroy();

    String getPlacementId();

    boolean isAdInvalidated();

    void loadAd();

    @Deprecated
    void loadAdFromBid(String str);

    @Deprecated
    void setExtraHints(ExtraHints extraHints);
}
