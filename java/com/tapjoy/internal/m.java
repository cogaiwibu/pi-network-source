package com.tapjoy.internal;

import android.content.SharedPreferences;

public abstract class m {
    protected SharedPreferences a;
    protected String b;

    public m(SharedPreferences sharedPreferences, String str) {
        this.a = sharedPreferences;
        this.b = str;
    }

    public final void c() {
        this.a.edit().remove(this.b).apply();
    }
}
