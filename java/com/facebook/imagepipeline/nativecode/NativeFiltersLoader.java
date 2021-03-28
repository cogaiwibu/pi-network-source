package com.facebook.imagepipeline.nativecode;

import com.facebook.soloader.SoLoader;

public class NativeFiltersLoader {
    public static void load() {
        SoLoader.loadLibrary("native-filters");
    }
}
