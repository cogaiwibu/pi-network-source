package com.facebook.ads.redexgen.X;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.Om  reason: case insensitive filesystem */
public interface AbstractC0620Om {
    boolean A7b();

    boolean A7d();

    int getCurrentPositionInMillis();

    boolean getGlobalVisibleRect(Rect rect);

    long getInitialBufferTime();

    int getMeasuredHeight();

    int getMeasuredWidth();

    EnumC0626Os getVideoStartReason();

    @Nullable
    View getView();

    float getVolume();
}
