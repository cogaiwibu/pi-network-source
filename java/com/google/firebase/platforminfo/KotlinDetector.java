package com.google.firebase.platforminfo;

import kotlin.KotlinVersion;

public final class KotlinDetector {
    private KotlinDetector() {
    }

    public static String detectVersion() {
        try {
            return KotlinVersion.CURRENT.toString();
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }
}
