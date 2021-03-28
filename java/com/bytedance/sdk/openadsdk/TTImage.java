package com.bytedance.sdk.openadsdk;

public class TTImage {
    private int a;
    private int b;
    private String c;

    public TTImage(int i, int i2, String str) {
        this.a = i;
        this.b = i2;
        this.c = str;
    }

    public int getHeight() {
        return this.a;
    }

    public int getWidth() {
        return this.b;
    }

    public String getImageUrl() {
        return this.c;
    }

    public boolean isValid() {
        String str;
        return this.a > 0 && this.b > 0 && (str = this.c) != null && str.length() > 0;
    }
}
