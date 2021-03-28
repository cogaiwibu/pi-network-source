package com.facebook.debug.debugoverlay.model;

public class DebugOverlayTag {
    public final int color;
    public final String description;
    public final String name;

    public DebugOverlayTag(String str, String str2, int i) {
        this.name = str;
        this.description = str2;
        this.color = i;
    }
}
