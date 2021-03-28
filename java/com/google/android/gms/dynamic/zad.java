package com.google.android.gms.dynamic;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
final class zad implements View.OnClickListener {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ Intent zasa;

    zad(Context context, Intent intent) {
        this.val$context = context;
        this.zasa = intent;
    }

    public final void onClick(View view) {
        try {
            this.val$context.startActivity(this.zasa);
        } catch (ActivityNotFoundException e) {
            Log.e("DeferredLifecycleHelper", "Failed to start resolution intent", e);
        }
    }
}
