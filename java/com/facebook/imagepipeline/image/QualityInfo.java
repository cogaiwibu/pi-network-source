package com.facebook.imagepipeline.image;

public interface QualityInfo {
    int getQuality();

    boolean isOfFullQuality();

    boolean isOfGoodEnoughQuality();
}
