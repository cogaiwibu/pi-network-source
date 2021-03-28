package com.facebook.soloader.nativeloader;

public class SystemDelegate implements NativeLoaderDelegate {
    @Override // com.facebook.soloader.nativeloader.NativeLoaderDelegate
    public boolean loadLibrary(String str) {
        System.loadLibrary(str);
        return true;
    }
}
