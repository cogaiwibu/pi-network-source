package co.squaretwo.ironsource;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.ironsource.adapters.supersonicads.SupersonicConfig;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.OfferwallListener;

public class RNIronSourceOfferwallModule extends ReactContextBaseJavaModule {
    private static final int OFFER_WALL_REQUEST = 1;
    private static final String TAG = "RNIronSourceOfferwall";
    private boolean initialized;
    private ReactApplicationContext reactContext;

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return TAG;
    }

    public RNIronSourceOfferwallModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public void safeInitializeOfferwall() {
        if (!this.initialized) {
            SupersonicConfig.getConfigObj().setClientSideCallbacks(true);
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class co.squaretwo.ironsource.RNIronSourceOfferwallModule.AnonymousClass1 */

                public void run() {
                    IronSource.setOfferwallListener(new OfferwallListener() {
                        /* class co.squaretwo.ironsource.RNIronSourceOfferwallModule.AnonymousClass1.AnonymousClass1 */

                        @Override // com.ironsource.mediationsdk.sdk.OfferwallListener
                        public void onGetOfferwallCreditsFailed(IronSourceError ironSourceError) {
                        }

                        @Override // com.ironsource.mediationsdk.sdk.OfferwallListener
                        public boolean onOfferwallAdCredited(int i, int i2, boolean z) {
                            return false;
                        }

                        @Override // com.ironsource.mediationsdk.sdk.OfferwallListener
                        public void onOfferwallClosed() {
                        }

                        @Override // com.ironsource.mediationsdk.sdk.OfferwallListener
                        public void onOfferwallAvailable(boolean z) {
                            Log.d(RNIronSourceOfferwallModule.TAG, "onOfferwallAvailable() called!");
                            if (z) {
                                Log.d(RNIronSourceOfferwallModule.TAG, "ironSourceOfferwall Available!");
                                RNIronSourceOfferwallModule.this.sendEvent("ironSourceOfferwallAvailable", null);
                                return;
                            }
                            Log.d(RNIronSourceOfferwallModule.TAG, "ironSourceOfferwall Not Available!");
                        }

                        @Override // com.ironsource.mediationsdk.sdk.OfferwallListener
                        public void onOfferwallOpened() {
                            Log.d(RNIronSourceOfferwallModule.TAG, "onOfferwallOpened() called!");
                            RNIronSourceOfferwallModule.this.sendEvent("ironSourceOfferwallDidShow", null);
                        }

                        @Override // com.ironsource.mediationsdk.sdk.OfferwallListener
                        public void onOfferwallShowFailed(IronSourceError ironSourceError) {
                            Log.d(RNIronSourceOfferwallModule.TAG, "onOfferwallShowFailed() called!");
                            RNIronSourceOfferwallModule.this.sendEvent("ironSourceOfferwallClosedByError", Utility.formatIronSourceError(ironSourceError));
                        }
                    });
                }
            });
        }
    }

    @ReactMethod
    public void showOfferwall() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            /* class co.squaretwo.ironsource.RNIronSourceOfferwallModule.AnonymousClass2 */

            public void run() {
                RNIronSourceOfferwallModule.this.safeInitializeOfferwall();
                Log.d(RNIronSourceOfferwallModule.TAG, "showOfferwall() called!!");
                if (IronSource.isOfferwallAvailable()) {
                    Log.d(RNIronSourceOfferwallModule.TAG, "isOfferwallAvailable() = true");
                    IronSource.showOfferwall();
                    RNIronSourceOfferwallModule.this.sendEvent("ironSourceOfferwallAvailable", null);
                    return;
                }
                Log.d(RNIronSourceOfferwallModule.TAG, "isOfferwallAvailable() = false");
                RNIronSourceOfferwallModule.this.sendEvent("ironSourceOfferwallUnavailable", null);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void sendEvent(String str, WritableMap writableMap) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, writableMap);
    }
}
