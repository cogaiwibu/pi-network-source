package co.squaretwo.ironsource;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.integration.IntegrationHelper;

public class RNIronSourceModule extends ReactContextBaseJavaModule {
    private static final String TAG = "RNIronSource";
    private ReactApplicationContext reactContext;

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return TAG;
    }

    public RNIronSourceModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    @ReactMethod
    public void initializeIronSource(final String str, final String str2, final ReadableMap readableMap, final Promise promise) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            /* class co.squaretwo.ironsource.RNIronSourceModule.AnonymousClass1 */

            public void run() {
                Activity currentActivity = RNIronSourceModule.this.reactContext.getCurrentActivity();
                boolean z = readableMap.getBoolean("validateIntegration");
                IronSource.setUserId(str2);
                IronSource.init(currentActivity, str);
                if (currentActivity != null && z) {
                    IntegrationHelper.validateIntegration(currentActivity);
                }
                promise.resolve(null);
            }
        });
    }

    @ReactMethod
    public void setConsent(boolean z) {
        IronSource.setConsent(z);
    }
}
