package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.os.Handler;
import androidx.annotation.NonNull;

@TargetApi(23)
/* renamed from: com.facebook.ads.redexgen.X.Ir  reason: case insensitive filesystem */
public final class C0475Ir implements MediaCodec.OnFrameRenderedListener {
    public final /* synthetic */ C00711y A00;

    public C0475Ir(C00711y r2, MediaCodec mediaCodec) {
        this.A00 = r2;
        mediaCodec.setOnFrameRenderedListener(this, new Handler());
    }

    public final void onFrameRendered(@NonNull MediaCodec mediaCodec, long j, long j2) {
        if (this == this.A00.A00) {
            this.A00.A1T();
        }
    }
}
