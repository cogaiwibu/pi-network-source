package com.tapjoy.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import javax.annotation.Nullable;

public abstract class hg {
    long c;
    boolean d;
    public gs e;
    public String f;
    fq g;

    public abstract void a(ha haVar, fw fwVar);

    public abstract void b();

    public boolean c() {
        return true;
    }

    static void a(Context context, @Nullable String str) {
        if (!jq.c(str)) {
            try {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } catch (Exception unused) {
            }
        }
    }
}
