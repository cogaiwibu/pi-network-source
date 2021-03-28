package com.facebook.ads.redexgen.X;

import android.content.Context;
import androidx.annotation.Nullable;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.internal.api.InitApi;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;

/* renamed from: com.facebook.ads.redexgen.X.58  reason: invalid class name */
public final class AnonymousClass58 implements InitApi {
    @Override // com.facebook.ads.internal.api.InitApi
    public final void initialize(Context context, @Nullable MultithreadedBundleWrapper multithreadedBundleWrapper, @Nullable AudienceNetworkAds.InitListener initListener, int i) {
        AnonymousClass95.A0H(AnonymousClass57.A07(context), multithreadedBundleWrapper, initListener, i);
    }

    @Override // com.facebook.ads.internal.api.InitApi
    public final boolean isInitialized() {
        return AnonymousClass95.A0J();
    }

    @Override // com.facebook.ads.internal.api.InitApi
    public final void maybeAttachCrashListener(Context context) {
        AnonymousClass95.A08(AnonymousClass57.A07(context));
    }

    @Override // com.facebook.ads.internal.api.InitApi
    public final void onAdEventManagerCreated(Context context) {
        AnonymousClass95.A09(AnonymousClass57.A07(context));
    }

    @Override // com.facebook.ads.internal.api.InitApi
    public final void onAdLoadInvoked(Context context) {
        AnonymousClass95.A0A(AnonymousClass57.A07(context));
    }

    @Override // com.facebook.ads.internal.api.InitApi
    public final void onContentProviderCreated(Context context) {
        AnonymousClass95.A0B(AnonymousClass57.A07(context));
    }
}
