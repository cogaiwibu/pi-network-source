package com.iab.omid.library.ironsrc.a;

public class a {
    public float a(int i, int i2) {
        if (i2 <= 0 || i <= 0) {
            return 0.0f;
        }
        float f = ((float) i) / ((float) i2);
        if (f > 1.0f) {
            return 1.0f;
        }
        return f;
    }
}
