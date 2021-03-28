package com.facebook.soloader;

import com.facebook.soloader.nativeloader.NativeLoaderDelegate;

public class NativeLoaderToSoLoaderDelegate implements NativeLoaderDelegate {
    @Override // com.facebook.soloader.nativeloader.NativeLoaderDelegate
    public boolean loadLibrary(String str) {
        return SoLoader.loadLibrary(str);
    }
}
