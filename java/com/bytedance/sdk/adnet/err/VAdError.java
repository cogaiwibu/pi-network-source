package com.bytedance.sdk.adnet.err;

import com.bytedance.sdk.adnet.core.j;

public class VAdError extends Exception {
    private long a;
    public final j networkResponse;

    public VAdError() {
        this.networkResponse = null;
    }

    public VAdError(j jVar) {
        this.networkResponse = jVar;
    }

    public VAdError(String str) {
        super(str);
        this.networkResponse = null;
    }

    public VAdError(String str, Throwable th) {
        super(str, th);
        this.networkResponse = null;
    }

    public VAdError(Throwable th) {
        super(th);
        this.networkResponse = null;
    }

    public void setNetworkTimeMs(long j) {
        this.a = j;
    }

    public long getNetworkTimeMs() {
        return this.a;
    }
}
