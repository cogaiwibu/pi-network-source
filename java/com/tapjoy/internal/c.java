package com.tapjoy.internal;

import android.app.Dialog;
import android.content.Context;

public final class c extends Dialog {
    private boolean a = false;

    public c(Context context) {
        super(context, 16973835);
        requestWindowFeature(1);
        getWindow().setBackgroundDrawableResource(17170445);
    }

    public final void show() {
        this.a = false;
        super.show();
    }

    public final void cancel() {
        this.a = true;
        super.cancel();
    }
}
