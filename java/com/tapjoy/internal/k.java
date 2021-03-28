package com.tapjoy.internal;

import android.content.SharedPreferences;

public final class k extends m {
    private final int c;

    public k(SharedPreferences sharedPreferences, String str, int i) {
        super(sharedPreferences, str);
        this.c = i;
    }

    public final Integer a() {
        return Integer.valueOf(b());
    }

    public final int b() {
        return this.a.getInt(this.b, this.c);
    }

    public final void a(Integer num) {
        if (num != null) {
            a(num.intValue());
        } else {
            c();
        }
    }

    public final void a(int i) {
        this.a.edit().putInt(this.b, i).apply();
    }

    public final SharedPreferences.Editor a(SharedPreferences.Editor editor, int i) {
        return editor.putInt(this.b, i);
    }
}
