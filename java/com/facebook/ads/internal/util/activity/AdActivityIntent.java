package com.facebook.ads.internal.util.activity;

import android.content.Context;
import android.content.Intent;

public final class AdActivityIntent extends Intent {
    public AdActivityIntent(Context context, Class<?> cls) {
        super(context, cls);
    }
}
