package com.tapjoy.internal;

import android.content.SharedPreferences;

public final class i extends m {
    private final double c = 0.0d;

    public i(SharedPreferences sharedPreferences, String str) {
        super(sharedPreferences, str);
    }

    public final double a() {
        String string = this.a.getString(this.b, null);
        if (string != null) {
            try {
                return Double.parseDouble(string);
            } catch (NumberFormatException unused) {
            }
        }
        return this.c;
    }

    public final SharedPreferences.Editor a(SharedPreferences.Editor editor) {
        return editor.remove(this.b);
    }

    public final SharedPreferences.Editor a(SharedPreferences.Editor editor, double d) {
        return editor.putString(this.b, Double.toString(d));
    }
}
