package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.widget.LinearLayout;
import com.facebook.ads.internal.view.ToolbarActionView$ToolbarActionMode;

public abstract class M1 extends LinearLayout {
    public static int A00 = ((int) (C0535Le.A01 * 56.0f));

    public abstract void A05(AnonymousClass1H v, boolean z);

    public abstract boolean A07();

    public abstract int getToolbarHeight();

    public abstract void setAdReportingVisible(boolean z);

    public abstract void setPageDetails(AnonymousClass1Q v, String str, int i, AnonymousClass1X v2);

    public abstract void setPageDetailsVisible(boolean z);

    public abstract void setProgress(float f);

    public abstract void setToolbarActionMessage(String str);

    public abstract void setToolbarActionMode(@ToolbarActionView$ToolbarActionMode int i);

    public abstract void setToolbarListener(M0 m0);

    public M1(Context context) {
        super(context);
    }

    public void A06(MQ mq) {
    }
}
