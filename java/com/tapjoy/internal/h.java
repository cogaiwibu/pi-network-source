package com.tapjoy.internal;

import android.content.SharedPreferences;

public final class h extends m {
    private final boolean c = false;

    public h(SharedPreferences sharedPreferences, String str) {
        super(sharedPreferences, str);
    }

    public final void a(boolean z) {
        this.a.edit().putBoolean(this.b, z).apply();
    }

    public final Boolean a() {
        return Boolean.valueOf(this.a.getBoolean(this.b, this.c));
    }
}
