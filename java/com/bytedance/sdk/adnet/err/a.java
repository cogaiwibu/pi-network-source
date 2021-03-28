package com.bytedance.sdk.adnet.err;

import android.content.Intent;
import com.bytedance.sdk.adnet.core.j;

/* compiled from: AuthFailureError */
public class a extends VAdError {
    private Intent a;

    public a() {
    }

    public a(j jVar) {
        super(jVar);
    }

    public String getMessage() {
        if (this.a != null) {
            return "User needs to (re)enter credentials.";
        }
        return super.getMessage();
    }
}
