package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
/* renamed from: com.facebook.ads.redexgen.X.0b  reason: invalid class name and case insensitive filesystem */
public class C00220b extends AnonymousClass18 {
    @Override // com.facebook.ads.redexgen.X.C00922t
    public final AnonymousClass3B A09(View view, AnonymousClass3B r4) {
        WindowInsets windowInsets = (WindowInsets) AnonymousClass3B.A01(r4);
        WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsets);
        if (dispatchApplyWindowInsets != windowInsets) {
            windowInsets = new WindowInsets(dispatchApplyWindowInsets);
        }
        return AnonymousClass3B.A00(windowInsets);
    }

    @Override // com.facebook.ads.redexgen.X.C00922t
    public final AnonymousClass3B A0A(View view, AnonymousClass3B r4) {
        WindowInsets windowInsets = (WindowInsets) AnonymousClass3B.A01(r4);
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
        if (onApplyWindowInsets != windowInsets) {
            windowInsets = new WindowInsets(onApplyWindowInsets);
        }
        return AnonymousClass3B.A00(windowInsets);
    }

    @Override // com.facebook.ads.redexgen.X.C00922t
    public final void A0C(View view) {
        view.stopNestedScroll();
    }

    @Override // com.facebook.ads.redexgen.X.C00922t
    public final void A0F(View view, AbstractC00772e r3) {
        if (r3 == null) {
            view.setOnApplyWindowInsetsListener(null);
        } else {
            view.setOnApplyWindowInsetsListener(new View$OnApplyWindowInsetsListenerC00912s(this, r3));
        }
    }
}
