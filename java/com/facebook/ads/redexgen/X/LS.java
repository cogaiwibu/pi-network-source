package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;

public final class LS implements View.OnSystemUiVisibilityChangeListener {
    public int A00;
    @Nullable
    public Window A01;
    public LR A02 = LR.A03;
    public final View A03;
    public final Runnable A04 = new C0917a4(this);

    public LS(View view) {
        this.A03 = view;
        this.A03.setOnSystemUiVisibilityChangeListener(this);
    }

    private void A00(int i, boolean z) {
        Window window = this.A01;
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (z) {
                attributes.flags |= i;
            } else {
                attributes.flags &= i ^ -1;
            }
            this.A01.setAttributes(attributes);
        }
    }

    /* access modifiers changed from: private */
    public void A02(boolean z) {
        if (!LR.A03.equals(this.A02)) {
            int i = 3840;
            if (!z) {
                i = 3840 | 7;
            }
            Handler handler = this.A03.getHandler();
            if (handler != null && z) {
                handler.removeCallbacks(this.A04);
                handler.postDelayed(this.A04, 2000);
            }
            this.A03.setSystemUiVisibility(i);
        }
    }

    public final void A03() {
        this.A01 = null;
    }

    public final void A04(Window window) {
        this.A01 = window;
    }

    public final void A05(LR lr) {
        this.A02 = lr;
        if (LQ.A00[this.A02.ordinal()] != 1) {
            A00(67108864, false);
            A00(134217728, false);
            this.A03.setSystemUiVisibility(0);
            return;
        }
        A00(67108864, true);
        A00(134217728, true);
        A02(false);
    }

    public final void onSystemUiVisibilityChange(int i) {
        this.A00 = i;
        if (((this.A00 ^ i) & 2) != 0 && (i & 2) == 0) {
            A02(true);
        }
    }
}
