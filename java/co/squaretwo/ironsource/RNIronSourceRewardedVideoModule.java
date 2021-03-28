package co.squaretwo.ironsource;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.RewardedVideoListener;
import com.ironsource.mediationsdk.utils.IronSourceConstants;

public class RNIronSourceRewardedVideoModule extends ReactContextBaseJavaModule {
    private static final String TAG = "RNIronSourceRewardedVideo";
    private boolean initialized;
    private final ReactApplicationContext reactContext;

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return TAG;
    }

    public RNIronSourceRewardedVideoModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    @ReactMethod
    public void initializeRewardedVideo() {
        if (!this.initialized) {
            this.initialized = true;
            IronSource.setRewardedVideoListener(new RewardedVideoListener() {
                /* class co.squaretwo.ironsource.RNIronSourceRewardedVideoModule.AnonymousClass1 */

                @Override // com.ironsource.mediationsdk.sdk.RewardedVideoListener
                public void onRewardedVideoAdOpened() {
                    Log.d(RNIronSourceRewardedVideoModule.TAG, "onRewardedVideoAdOpened() called!");
                    RNIronSourceRewardedVideoModule.this.sendEvent("ironSourceRewardedVideoDidStart", null);
                    RNIronSourceRewardedVideoModule.this.sendEvent("ironSourceRewardedVideoDidOpen", null);
                }

                @Override // com.ironsource.mediationsdk.sdk.RewardedVideoListener
                public void onRewardedVideoAdClosed() {
                    Log.d(RNIronSourceRewardedVideoModule.TAG, "onRewardedVideoAdClosed() called!");
                    RNIronSourceRewardedVideoModule.this.sendEvent("ironSourceRewardedVideoClosedByUser", null);
                }

                @Override // com.ironsource.mediationsdk.sdk.RewardedVideoListener
                public void onRewardedVideoAvailabilityChanged(boolean z) {
                    Log.d(RNIronSourceRewardedVideoModule.TAG, "onRewardedVideoAvailabilityChanged() called!");
                    if (z) {
                        Log.d(RNIronSourceRewardedVideoModule.TAG, "ironSourceRewardedVideoAvailable!");
                        RNIronSourceRewardedVideoModule.this.sendEvent("ironSourceRewardedVideoAvailable", null);
                        return;
                    }
                    Log.d(RNIronSourceRewardedVideoModule.TAG, "ironSourceRewardedVideoUnavailable!");
                    RNIronSourceRewardedVideoModule.this.sendEvent("ironSourceRewardedVideoUnavailable", null);
                }

                @Override // com.ironsource.mediationsdk.sdk.RewardedVideoListener
                public void onRewardedVideoAdRewarded(Placement placement) {
                    String rewardName = placement.getRewardName();
                    int rewardAmount = placement.getRewardAmount();
                    Log.d(RNIronSourceRewardedVideoModule.TAG, "onRewardedVideoAdRewarded() called! " + rewardName + " " + rewardAmount);
                    WritableMap createMap = Arguments.createMap();
                    createMap.putString(IronSourceConstants.EVENTS_REWARD_NAME, rewardName);
                    createMap.putString(IronSourceConstants.EVENTS_REWARD_AMOUNT, String.valueOf(rewardAmount));
                    RNIronSourceRewardedVideoModule.this.sendEvent("ironSourceRewardedVideoAdRewarded", createMap);
                }

                @Override // com.ironsource.mediationsdk.sdk.RewardedVideoListener
                public void onRewardedVideoAdShowFailed(IronSourceError ironSourceError) {
                    Log.d(RNIronSourceRewardedVideoModule.TAG, "onRewardedVideoAdShowFailed() called!");
                    RNIronSourceRewardedVideoModule.this.sendEvent("ironSourceRewardedVideoClosedByError", null);
                }

                @Override // com.ironsource.mediationsdk.sdk.RewardedVideoListener
                public void onRewardedVideoAdClicked(Placement placement) {
                    Log.d(RNIronSourceRewardedVideoModule.TAG, "onRewardedVideoAdClicked() called!");
                }

                @Override // com.ironsource.mediationsdk.sdk.RewardedVideoListener
                public void onRewardedVideoAdStarted() {
                    Log.d(RNIronSourceRewardedVideoModule.TAG, "onRewardedVideoAdStarted() called!");
                    RNIronSourceRewardedVideoModule.this.sendEvent("ironSourceRewardedVideoAdStarted", null);
                }

                @Override // com.ironsource.mediationsdk.sdk.RewardedVideoListener
                public void onRewardedVideoAdEnded() {
                    Log.d(RNIronSourceRewardedVideoModule.TAG, "onRewardedVideoAdEnded() called!");
                    RNIronSourceRewardedVideoModule.this.sendEvent("ironSourceRewardedVideoAdEnded", null);
                }
            });
        }
    }

    @ReactMethod
    public void showRewardedVideo(final String str) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            /* class co.squaretwo.ironsource.RNIronSourceRewardedVideoModule.AnonymousClass2 */

            public void run() {
                Log.d(RNIronSourceRewardedVideoModule.TAG, "showRewardedVideo() called!!");
                if (IronSource.isRewardedVideoAvailable()) {
                    Log.d(RNIronSourceRewardedVideoModule.TAG, "isRewardedVideoAvailable() = true");
                    IronSource.showRewardedVideo(str);
                    return;
                }
                Log.d(RNIronSourceRewardedVideoModule.TAG, "isRewardedVideoAvailable() = false");
            }
        });
    }

    @ReactMethod
    public void isRewardedVideoAvailable(Promise promise) {
        try {
            Log.d(TAG, "isRewardedVideo() called!!");
            promise.resolve(Boolean.valueOf(IronSource.isRewardedVideoAvailable()));
        } catch (Exception e) {
            Log.d(TAG, "isRewardedVideo error %s", e);
            promise.reject("isRewardedVideoAvailable, Error, " + e);
        }
    }

    @ReactMethod
    public void setDynamicUserId(String str) {
        IronSource.setDynamicUserId(str);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void sendEvent(String str, WritableMap writableMap) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, writableMap);
    }
}
