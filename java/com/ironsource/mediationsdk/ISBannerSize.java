package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.utils.IronSourceConstants;

public class ISBannerSize {
    public static final ISBannerSize BANNER = new ISBannerSize(size_banner, 320, 50);
    public static final ISBannerSize LARGE = new ISBannerSize(size_large, 320, 90);
    protected static final ISBannerSize LEADERBOARD = new ISBannerSize(size_leaderboard, 728, 90);
    public static final ISBannerSize RECTANGLE = new ISBannerSize(size_rectangle, 300, IronSourceConstants.INTERSTITIAL_DAILY_CAPPED);
    public static final ISBannerSize SMART = new ISBannerSize(size_smart, 0, 0);
    private static final String size_banner = "BANNER";
    private static final String size_custom = "CUSTOM";
    private static final String size_large = "LARGE";
    private static final String size_leaderboard = "LEADERBOARD";
    private static final String size_rectangle = "RECTANGLE";
    private static final String size_smart = "SMART";
    private String mDescription;
    private int mHeight;
    private int mWidth;

    public ISBannerSize(int i, int i2) {
        this(size_custom, i, i2);
    }

    public ISBannerSize(String str, int i, int i2) {
        this.mDescription = str;
        this.mWidth = i;
        this.mHeight = i2;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public boolean isSmart() {
        return this.mDescription.equals(size_smart);
    }
}
