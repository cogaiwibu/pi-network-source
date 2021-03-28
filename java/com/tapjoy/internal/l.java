package com.tapjoy.internal;

import android.content.SharedPreferences;

public final class l extends m {
    private final long c = 0;

    public l(SharedPreferences sharedPreferences, String str) {
        super(sharedPreferences, str);
    }

    public final long a() {
        return this.a.getLong(this.b, this.c);
    }

    public final void a(long j) {
        this.a.edit().putLong(this.b, j).apply();
    }

    public final SharedPreferences.Editor a(SharedPreferences.Editor editor) {
        return editor.remove(this.b);
    }

    public final SharedPreferences.Editor a(SharedPreferences.Editor editor, long j) {
        return editor.putLong(this.b, j);
    }
}
