package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.view.View;
import androidx.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.Pc  reason: case insensitive filesystem */
public interface AbstractC0636Pc {
    void A7E();

    boolean A7L();

    boolean A7M();

    boolean A7h();

    void ABX(boolean z, int i);

    void ADE(int i);

    void ADI(EnumC0626Os os, int i);

    void ADO(int i);

    void destroy();

    int getCurrentPosition();

    int getDuration();

    long getInitialBufferTime();

    EnumC0626Os getStartReason();

    EnumC0638Pe getState();

    int getVideoHeight();

    int getVideoWidth();

    View getView();

    float getVolume();

    void seekTo(int i);

    void setBackgroundPlaybackEnabled(boolean z);

    void setControlsAnchorView(View view);

    void setFullScreen(boolean z);

    void setRequestedVolume(float f);

    void setVideoMPD(@Nullable String str);

    void setVideoStateChangeListener(AbstractC0639Pf pf);

    void setup(Uri uri);
}
