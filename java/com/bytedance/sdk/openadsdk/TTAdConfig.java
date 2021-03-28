package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.adnet.face.IHttpStack;

public final class TTAdConfig {
    private String a;
    private String b;
    private boolean c;
    private String d;
    private String e;
    private int f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private IHttpStack k;
    private int l;
    private int m;

    private TTAdConfig() {
        this.c = false;
        this.f = 0;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = false;
        this.l = 0;
        this.m = -1;
    }

    public void setCoppa(int i2) {
        this.l = i2;
    }

    public int getCoppa() {
        return this.l;
    }

    public void setGDPR(int i2) {
        this.m = i2;
    }

    public int getGDPR() {
        return this.m;
    }

    public String getAppId() {
        return this.a;
    }

    public void setAppId(String str) {
        this.a = str;
    }

    public String getAppName() {
        return this.b;
    }

    public void setAppName(String str) {
        this.b = str;
    }

    public boolean isPaid() {
        return this.c;
    }

    public void setPaid(boolean z) {
        this.c = z;
    }

    public String getKeywords() {
        return this.d;
    }

    public void setKeywords(String str) {
        this.d = str;
    }

    public String getData() {
        return this.e;
    }

    public void setData(String str) {
        this.e = str;
    }

    public int getTitleBarTheme() {
        return this.f;
    }

    public void setTitleBarTheme(int i2) {
        this.f = i2;
    }

    public boolean isDebug() {
        return this.g;
    }

    public void setDebug(boolean z) {
        this.g = z;
    }

    public boolean isAllowShowPageWhenScreenLock() {
        return this.h;
    }

    public void setAllowShowPageWhenScreenLock(boolean z) {
        this.h = z;
    }

    public boolean isUseTextureView() {
        return this.i;
    }

    public void setUseTextureView(boolean z) {
        this.i = z;
    }

    public boolean isSupportMultiProcess() {
        return this.j;
    }

    public void setSupportMultiProcess(boolean z) {
        this.j = z;
    }

    public IHttpStack getHttpStack() {
        return this.k;
    }

    public void setHttpStack(IHttpStack iHttpStack) {
        this.k = iHttpStack;
    }

    public static class Builder {
        private String a;
        private String b;
        private boolean c = false;
        private String d;
        private String e;
        private int f = 0;
        private boolean g = false;
        private boolean h = false;
        private boolean i = false;
        private boolean j = false;
        private IHttpStack k;
        private int l = 0;
        private int m = -1;

        @Deprecated
        public Builder globalDownloadListener(TTGlobalAppDownloadListener tTGlobalAppDownloadListener) {
            return this;
        }

        public Builder coppa(int i2) {
            this.l = i2;
            return this;
        }

        public Builder setGDPR(int i2) {
            this.m = i2;
            return this;
        }

        public Builder appId(String str) {
            this.a = str;
            return this;
        }

        public Builder appName(String str) {
            this.b = str;
            return this;
        }

        public Builder paid(boolean z) {
            this.c = z;
            return this;
        }

        public Builder keywords(String str) {
            this.d = str;
            return this;
        }

        public Builder data(String str) {
            this.e = str;
            return this;
        }

        public Builder titleBarTheme(int i2) {
            this.f = i2;
            return this;
        }

        public Builder debug(boolean z) {
            this.g = z;
            return this;
        }

        public Builder allowShowPageWhenScreenLock(boolean z) {
            this.h = z;
            return this;
        }

        public Builder useTextureView(boolean z) {
            this.i = z;
            return this;
        }

        public Builder supportMultiProcess(boolean z) {
            this.j = z;
            return this;
        }

        public Builder httpStack(IHttpStack iHttpStack) {
            this.k = iHttpStack;
            return this;
        }

        public TTAdConfig build() {
            TTAdConfig tTAdConfig = new TTAdConfig();
            tTAdConfig.setAppId(this.a);
            tTAdConfig.setCoppa(this.l);
            tTAdConfig.setAppName(this.b);
            tTAdConfig.setPaid(this.c);
            tTAdConfig.setKeywords(this.d);
            tTAdConfig.setData(this.e);
            tTAdConfig.setTitleBarTheme(this.f);
            tTAdConfig.setDebug(this.g);
            tTAdConfig.setAllowShowPageWhenScreenLock(this.h);
            tTAdConfig.setUseTextureView(this.i);
            tTAdConfig.setSupportMultiProcess(this.j);
            tTAdConfig.setHttpStack(this.k);
            tTAdConfig.setGDPR(this.m);
            return tTAdConfig;
        }
    }
}
