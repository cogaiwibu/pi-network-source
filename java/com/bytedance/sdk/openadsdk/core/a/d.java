package com.bytedance.sdk.openadsdk.core.a;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.c.g;

/* compiled from: RewardBarClickListener */
public abstract class d extends a {
    /* access modifiers changed from: protected */
    public abstract void a(View view, int i, int i2, int i3, int i4);

    public d(Context context, g gVar, String str, int i) {
        super(context, gVar, str, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.b, com.bytedance.sdk.openadsdk.core.a.a, com.bytedance.sdk.openadsdk.core.a.c
    public void b(View view, int i, int i2, int i3, int i4) {
        a(view, i, i2, i3, i4);
        super.b(view, i, i2, i3, i4);
    }
}
