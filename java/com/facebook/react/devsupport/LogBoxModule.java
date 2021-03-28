package com.facebook.react.devsupport;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = LogBoxModule.NAME)
public class LogBoxModule extends ReactContextBaseJavaModule {
    public static final String NAME = "LogBox";
    private final DevSupportManager mDevSupportManager;
    private LogBoxDialog mLogBoxDialog;
    private View mReactRootView;

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    public LogBoxModule(ReactApplicationContext reactApplicationContext, DevSupportManager devSupportManager) {
        super(reactApplicationContext);
        this.mDevSupportManager = devSupportManager;
        UiThreadUtil.runOnUiThread(new Runnable() {
            /* class com.facebook.react.devsupport.LogBoxModule.AnonymousClass1 */

            public void run() {
                if (LogBoxModule.this.mReactRootView == null) {
                    LogBoxModule logBoxModule = LogBoxModule.this;
                    logBoxModule.mReactRootView = logBoxModule.mDevSupportManager.createRootView(LogBoxModule.NAME);
                    if (LogBoxModule.this.mReactRootView == null) {
                        FLog.e(ReactConstants.TAG, "Unable to launch logbox because react was unable to create the root view");
                    }
                }
            }
        });
    }

    @ReactMethod
    public void show() {
        UiThreadUtil.runOnUiThread(new Runnable() {
            /* class com.facebook.react.devsupport.LogBoxModule.AnonymousClass2 */

            public void run() {
                if (LogBoxModule.this.mLogBoxDialog == null) {
                    Activity currentActivity = LogBoxModule.this.getCurrentActivity();
                    if (currentActivity == null || currentActivity.isFinishing()) {
                        FLog.e(ReactConstants.TAG, "Unable to launch logbox because react activity is not available, here is the error that logbox would've displayed: ");
                        return;
                    }
                    LogBoxModule.this.mLogBoxDialog = new LogBoxDialog(currentActivity, LogBoxModule.this.mReactRootView);
                    LogBoxModule.this.mLogBoxDialog.setCancelable(false);
                    LogBoxModule.this.mLogBoxDialog.show();
                }
            }
        });
    }

    @ReactMethod
    public void hide() {
        UiThreadUtil.runOnUiThread(new Runnable() {
            /* class com.facebook.react.devsupport.LogBoxModule.AnonymousClass3 */

            public void run() {
                if (LogBoxModule.this.mLogBoxDialog != null) {
                    if (LogBoxModule.this.mReactRootView.getParent() != null) {
                        ((ViewGroup) LogBoxModule.this.mReactRootView.getParent()).removeView(LogBoxModule.this.mReactRootView);
                    }
                    LogBoxModule.this.mLogBoxDialog.dismiss();
                    LogBoxModule.this.mLogBoxDialog = null;
                }
            }
        });
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void onCatalystInstanceDestroy() {
        UiThreadUtil.runOnUiThread(new Runnable() {
            /* class com.facebook.react.devsupport.LogBoxModule.AnonymousClass4 */

            public void run() {
                if (LogBoxModule.this.mReactRootView != null) {
                    LogBoxModule.this.mDevSupportManager.destroyRootView(LogBoxModule.this.mReactRootView);
                    LogBoxModule.this.mReactRootView = null;
                }
            }
        });
    }
}
