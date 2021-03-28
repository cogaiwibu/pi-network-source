package com.bytedance.sdk.adnet.core;

import android.text.TextUtils;
import com.ironsource.sdk.constants.Constants;

public final class Header {
    private final String a;
    private final String b;

    public Header(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final String getName() {
        return this.a;
    }

    public final String getValue() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Header header = (Header) obj;
        if (!TextUtils.equals(this.a, header.a) || !TextUtils.equals(this.b, header.b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.a + ",value=" + this.b + Constants.RequestParameters.RIGHT_BRACKETS;
    }
}
