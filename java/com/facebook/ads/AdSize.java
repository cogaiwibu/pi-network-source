package com.facebook.ads;

import com.facebook.ads.internal.api.AdSizeApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import java.io.Serializable;

public class AdSize implements Serializable {
    @Deprecated
    public static final AdSize BANNER_320_50 = new AdSize(4);
    public static final AdSize BANNER_HEIGHT_50 = new AdSize(5);
    public static final AdSize BANNER_HEIGHT_90 = new AdSize(6);
    public static final AdSize INTERSTITIAL = new AdSize(100);
    public static final AdSize RECTANGLE_HEIGHT_250 = new AdSize(7);
    private final int UNDEFINED;
    private AdSizeApi mAdSizeApi;
    private final int mInitHeight;
    private final int mInitSizeType;
    private final int mInitWidth;

    public AdSize(int i, int i2) {
        this.UNDEFINED = -1;
        this.mInitSizeType = -1;
        this.mInitWidth = i;
        this.mInitHeight = i2;
    }

    private AdSize(int i) {
        this.UNDEFINED = -1;
        this.mInitSizeType = i;
        this.mInitWidth = -1;
        this.mInitHeight = -1;
    }

    public int getWidth() {
        int i = this.mInitSizeType;
        if (i != -1) {
            return getAdSizeApi(i).getWidth();
        }
        return this.mInitWidth;
    }

    public int getHeight() {
        int i = this.mInitSizeType;
        if (i != -1) {
            return getAdSizeApi(i).getHeight();
        }
        return this.mInitHeight;
    }

    public static AdSize fromWidthAndHeight(int i, int i2) {
        if (INTERSTITIAL.getHeight() == i2 && INTERSTITIAL.getWidth() == i) {
            return INTERSTITIAL;
        }
        if (BANNER_320_50.getHeight() == i2 && BANNER_320_50.getWidth() == i) {
            return BANNER_320_50;
        }
        if (BANNER_HEIGHT_50.getHeight() == i2 && BANNER_HEIGHT_50.getWidth() == i) {
            return BANNER_HEIGHT_50;
        }
        if (BANNER_HEIGHT_90.getHeight() == i2 && BANNER_HEIGHT_90.getWidth() == i) {
            return BANNER_HEIGHT_90;
        }
        if (RECTANGLE_HEIGHT_250.getHeight() == i2 && RECTANGLE_HEIGHT_250.getWidth() == i) {
            return RECTANGLE_HEIGHT_250;
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AdSize adSize = (AdSize) obj;
        if (getWidth() == adSize.getWidth() && getHeight() == adSize.getHeight()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (getWidth() * 31) + getHeight();
    }

    private AdSizeApi getAdSizeApi(int i) {
        if (this.mAdSizeApi == null) {
            this.mAdSizeApi = DynamicLoaderFactory.makeLoaderUnsafe().createAdSizeApi(i);
        }
        return this.mAdSizeApi;
    }
}
