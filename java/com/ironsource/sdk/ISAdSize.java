package com.ironsource.sdk;

public class ISAdSize {
    private int mHeight;
    private String mLabel;
    private int mWidth;

    public ISAdSize(int i, int i2, String str) {
        this.mWidth = i;
        this.mHeight = i2;
        this.mLabel = str;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public String toString() {
        return this.mLabel;
    }
}
