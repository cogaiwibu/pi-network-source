package com.facebook.ads.redexgen.X;

import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;

public class P1 implements AudioManager.OnAudioFocusChangeListener {
    public final /* synthetic */ C02067k A00;

    public P1(C02067k r1) {
        this.A00 = r1;
    }

    public final void onAudioFocusChange(int i) {
        new Handler(Looper.getMainLooper()).post(new C0439Hf(this, i));
    }
}
