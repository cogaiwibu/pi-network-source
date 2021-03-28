package com.tapjoy.internal;

import android.content.SharedPreferences;

public final class o extends m {
    private final String c = null;

    public o(SharedPreferences sharedPreferences, String str) {
        super(sharedPreferences, str);
    }

    public final String a() {
        return this.a.getString(this.b, this.c);
    }

    public final void a(String str) {
        this.a.edit().putString(this.b, str).apply();
    }

    public final SharedPreferences.Editor a(SharedPreferences.Editor editor, String str) {
        return str != null ? editor.putString(this.b, str) : editor.remove(this.b);
    }
}
