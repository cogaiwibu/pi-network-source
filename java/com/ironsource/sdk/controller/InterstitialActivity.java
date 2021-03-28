package com.ironsource.sdk.controller;

import android.os.Bundle;
import com.ironsource.sdk.utils.Logger;

public class InterstitialActivity extends ControllerActivity {
    private static final String TAG = InterstitialActivity.class.getSimpleName();

    /* access modifiers changed from: protected */
    @Override // com.ironsource.sdk.controller.ControllerActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Logger.i(TAG, "onCreate");
    }

    /* access modifiers changed from: protected */
    @Override // com.ironsource.sdk.controller.ControllerActivity
    public void onResume() {
        super.onResume();
        Logger.i(TAG, "onResume");
    }

    /* access modifiers changed from: protected */
    @Override // com.ironsource.sdk.controller.ControllerActivity
    public void onPause() {
        super.onPause();
        Logger.i(TAG, "onPause");
    }
}
