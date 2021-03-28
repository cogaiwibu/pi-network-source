package co.squaretwo.ironsource;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.InterstitialListener;

public class RNIronSourceInterstitialsModule extends ReactContextBaseJavaModule {
    private static final String TAG = "RNIronSourceInterstitials";

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return TAG;
    }

    public RNIronSourceInterstitialsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void loadInterstitial() {
        IronSource.setInterstitialListener(new InterstitialListener() {
            /* class co.squaretwo.ironsource.RNIronSourceInterstitialsModule.AnonymousClass1 */

            @Override // com.ironsource.mediationsdk.sdk.InterstitialListener
            public void onInterstitialAdReady() {
                RNIronSourceInterstitialsModule.this.sendEvent("interstitialDidLoad", null);
            }

            @Override // com.ironsource.mediationsdk.sdk.InterstitialListener
            public void onInterstitialAdLoadFailed(IronSourceError ironSourceError) {
                RNIronSourceInterstitialsModule.this.sendEvent("interstitialDidFailToLoadWithError", Utility.formatIronSourceError(ironSourceError));
            }

            @Override // com.ironsource.mediationsdk.sdk.InterstitialListener
            public void onInterstitialAdOpened() {
                RNIronSourceInterstitialsModule.this.sendEvent("interstitialDidOpen", null);
            }

            @Override // com.ironsource.mediationsdk.sdk.InterstitialListener
            public void onInterstitialAdClosed() {
                RNIronSourceInterstitialsModule.this.sendEvent("interstitialDidClose", null);
            }

            @Override // com.ironsource.mediationsdk.sdk.InterstitialListener
            public void onInterstitialAdShowSucceeded() {
                RNIronSourceInterstitialsModule.this.sendEvent("interstitialDidShow", null);
            }

            @Override // com.ironsource.mediationsdk.sdk.InterstitialListener
            public void onInterstitialAdShowFailed(IronSourceError ironSourceError) {
                RNIronSourceInterstitialsModule.this.sendEvent("interstitialDidFailToShowWithError", Utility.formatIronSourceError(ironSourceError));
            }

            @Override // com.ironsource.mediationsdk.sdk.InterstitialListener
            public void onInterstitialAdClicked() {
                RNIronSourceInterstitialsModule.this.sendEvent("didClickInterstitial", null);
            }
        });
        IronSource.loadInterstitial();
    }

    @ReactMethod
    public void showInterstitial(String str) {
        IronSource.showInterstitial(str);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void sendEvent(String str, WritableMap writableMap) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, writableMap);
    }
}
