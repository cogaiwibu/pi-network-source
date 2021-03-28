package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.os.Looper;
import com.facebook.ads.internal.exoplayer2.drm.DrmInitData;
import com.facebook.ads.redexgen.X.C5;

@TargetApi(16)
public interface C4<T extends C5> {
    C3<T> A2Q(Looper looper, DrmInitData drmInitData);

    boolean A3x(DrmInitData drmInitData);

    void ACJ(C3<T> c3);
}
