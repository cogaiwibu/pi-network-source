package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacementListener;

public class TapjoyNative {
    public static Object createPlacement(Context context, String str, TJPlacementListener tJPlacementListener) {
        return gc.a().a(context, str, tJPlacementListener);
    }
}
