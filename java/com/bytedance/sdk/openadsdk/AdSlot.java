package com.bytedance.sdk.openadsdk;

public class AdSlot {
    public static final int TYPE_BANNER = 1;
    public static final int TYPE_CACHED_SPLASH = 4;
    public static final int TYPE_DRAW_FEED = 9;
    public static final int TYPE_FEED = 5;
    public static final int TYPE_FULL_SCREEN_VIDEO = 8;
    public static final int TYPE_INTERACTION_AD = 2;
    public static final int TYPE_REWARD_VIDEO = 7;
    public static final int TYPE_SPLASH = 3;
    private String a;
    private int b;
    private int c;
    private int d;
    private boolean e;
    private String f;
    private int g;
    private String h;
    private String i;
    private int j;
    private int k;

    public static int getPosition(int i2) {
        if (i2 == 1) {
            return 2;
        }
        if (i2 != 2) {
            return (i2 == 3 || i2 == 4 || i2 == 7 || i2 == 8) ? 5 : 3;
        }
        return 4;
    }

    private AdSlot() {
        this.j = 2;
    }

    public String getCodeId() {
        return this.a;
    }

    public int getImgAcceptedWidth() {
        return this.b;
    }

    public int getImgAcceptedHeight() {
        return this.c;
    }

    public boolean isSupportDeepLink() {
        return this.e;
    }

    public int getAdCount() {
        return this.d;
    }

    public String getRewardName() {
        return this.f;
    }

    public int getRewardAmount() {
        return this.g;
    }

    public String getMediaExtra() {
        return this.h;
    }

    public String getUserID() {
        return this.i;
    }

    public int getOrientation() {
        return this.j;
    }

    public int getNativeAdType() {
        return this.k;
    }

    public String toString() {
        return "AdSlot{mCodeId='" + String.valueOf(this.a) + '\'' + ", mImgAcceptedWidth=" + this.b + ", mImgAcceptedHeight=" + this.c + ", mAdCount=" + this.d + ", mSupportDeepLink=" + this.e + ", mRewardName='" + String.valueOf(this.f) + '\'' + ", mRewardAmount=" + this.g + ", mMediaExtra='" + String.valueOf(this.h) + '\'' + ", mUserID='" + String.valueOf(this.i) + '\'' + ", mOrientation=" + this.j + ", mNativeAdType=" + this.k + '}';
    }

    public static class Builder {
        private String a;
        private int b;
        private int c;
        private boolean d;
        private int e = 1;
        private String f;
        private int g;
        private String h;
        private String i;
        private int j;
        private int k;

        public Builder setCodeId(String str) {
            this.a = str;
            return this;
        }

        public Builder setImageAcceptedSize(int i2, int i3) {
            this.b = i2;
            this.c = i3;
            return this;
        }

        public Builder setSupportDeepLink(boolean z) {
            this.d = z;
            return this;
        }

        public Builder setAdCount(int i2) {
            this.e = i2;
            return this;
        }

        public Builder setRewardName(String str) {
            this.f = str;
            return this;
        }

        public Builder setRewardAmount(int i2) {
            this.g = i2;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.h = str;
            return this;
        }

        public Builder setUserID(String str) {
            this.i = str;
            return this;
        }

        public Builder setOrientation(int i2) {
            this.j = i2;
            return this;
        }

        public Builder setNativeAdType(int i2) {
            this.k = i2;
            return this;
        }

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.a = this.a;
            adSlot.d = this.e;
            adSlot.e = this.d;
            adSlot.b = this.b;
            adSlot.c = this.c;
            adSlot.f = this.f;
            adSlot.g = this.g;
            adSlot.h = this.h;
            adSlot.i = this.i;
            adSlot.j = this.j;
            adSlot.k = this.k;
            return adSlot;
        }
    }
}
