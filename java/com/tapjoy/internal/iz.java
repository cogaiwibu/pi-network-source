package com.tapjoy.internal;

import android.support.v4.media.session.PlaybackStateCompat;

/* access modifiers changed from: package-private */
public final class iz {
    static iy a;
    static long b;

    private iz() {
    }

    static iy a() {
        synchronized (iz.class) {
            if (a == null) {
                return new iy();
            }
            iy iyVar = a;
            a = iyVar.f;
            iyVar.f = null;
            b -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            return iyVar;
        }
    }

    static void a(iy iyVar) {
        if (iyVar.f != null || iyVar.g != null) {
            throw new IllegalArgumentException();
        } else if (!iyVar.d) {
            synchronized (iz.class) {
                if (b + PlaybackStateCompat.ACTION_PLAY_FROM_URI <= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    b += PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                    iyVar.f = a;
                    iyVar.c = 0;
                    iyVar.b = 0;
                    a = iyVar;
                }
            }
        }
    }
}
