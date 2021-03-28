package com.facebook.ads.redexgen.X;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class TT implements AbstractC0524Kr {
    @Override // com.facebook.ads.redexgen.X.AbstractC0524Kr
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Window.Callback callback;
        if (activity.getWindow() != null) {
            callback = activity.getWindow().getCallback();
        } else {
            callback = null;
        }
        if (callback != null) {
            Window$CallbackC0521Ko ko = new Window$CallbackC0521Ko(callback, activity);
            Window$CallbackC0521Ko.A00(new TS(this));
            activity.getWindow().setCallback(ko);
        }
    }
}
