package co.squaretwo.ironsource;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.BannerListener;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;

public class RNIronSourceBannerModule extends ReactContextBaseJavaModule implements BannerListener, LifecycleEventListener {
    static HashMap<String, Integer> positionsMap = createPositionsMap();
    static HashMap<String, ISBannerSize> sizeDescriptionMap = createSizeDescriptionMap();
    static HashMap<ISBannerSize, HashMap> sizeMap = createSizeMap();
    private Activity activity;
    private IronSourceBannerLayout bannerLayout;
    private WritableMap bannerSize;
    private boolean initialized;
    private Promise loadPromise;

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNIronSourceBanner";
    }

    public RNIronSourceBannerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private static HashMap<ISBannerSize, HashMap> createSizeMap() {
        HashMap<ISBannerSize, HashMap> hashMap = new HashMap<>();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        HashMap hashMap5 = new HashMap();
        hashMap2.put("width", 320);
        hashMap2.put("height", 50);
        hashMap.put(ISBannerSize.BANNER, hashMap2);
        hashMap3.put("width", 320);
        hashMap3.put("height", 90);
        hashMap.put(ISBannerSize.LARGE, hashMap3);
        hashMap4.put("width", 300);
        hashMap4.put("height", Integer.valueOf((int) IronSourceConstants.INTERSTITIAL_DAILY_CAPPED));
        hashMap.put(ISBannerSize.RECTANGLE, hashMap4);
        hashMap5.put("width", 320);
        hashMap5.put("height", 50);
        hashMap.put(ISBannerSize.SMART, hashMap5);
        hashMap5.put("altWidth", 320);
        hashMap5.put("altHeight", 50);
        hashMap.put(ISBannerSize.SMART, hashMap5);
        return hashMap;
    }

    private static HashMap<String, Integer> createPositionsMap() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("top", 48);
        hashMap.put("bottom", 80);
        return hashMap;
    }

    private static HashMap<String, ISBannerSize> createSizeDescriptionMap() {
        HashMap<String, ISBannerSize> hashMap = new HashMap<>();
        hashMap.put("BANNER", ISBannerSize.BANNER);
        hashMap.put("LARGE", ISBannerSize.LARGE);
        hashMap.put("RECTANGLE", ISBannerSize.RECTANGLE);
        hashMap.put("SMART", ISBannerSize.SMART);
        return hashMap;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private HashMap getBannerSize(ISBannerSize iSBannerSize) {
        if (!iSBannerSize.equals(ISBannerSize.SMART)) {
            return sizeMap.get(iSBannerSize);
        }
        DisplayMetrics displayMetrics = this.activity.getResources().getDisplayMetrics();
        if (((float) displayMetrics.widthPixels) / displayMetrics.density <= 720.0f) {
            return sizeMap.get(ISBannerSize.SMART);
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = sizeMap.get(ISBannerSize.SMART);
        hashMap.put("width", hashMap2.get("altWidth"));
        hashMap.put("height", hashMap2.get("altHeight"));
        return hashMap;
    }

    private void initializeBanner() {
        if (!this.initialized) {
            this.activity = getReactApplicationContext().getCurrentActivity();
            this.initialized = true;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ISBannerSize getBannerSizeDescription(String str) {
        ISBannerSize iSBannerSize = sizeDescriptionMap.get(str);
        return iSBannerSize == null ? ISBannerSize.BANNER : iSBannerSize;
    }

    @ReactMethod
    public void loadBanner(final String str, ReadableMap readableMap, Promise promise) {
        this.loadPromise = promise;
        final String string = readableMap.getString("position");
        final boolean z = readableMap.getBoolean("scaleToFitWidth");
        initializeBanner();
        if (this.activity == null) {
            promise.reject("E_LOAD_ACTIVITY", "Found no activity");
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() {
                /* class co.squaretwo.ironsource.RNIronSourceBannerModule.AnonymousClass1 */

                public void run() {
                    FrameLayout frameLayout = (FrameLayout) RNIronSourceBannerModule.this.activity.findViewById(16908290);
                    ISBannerSize bannerSizeDescription = RNIronSourceBannerModule.this.getBannerSizeDescription(str);
                    if (RNIronSourceBannerModule.this.bannerLayout != null) {
                        RNIronSourceBannerModule.this.destroyBanner();
                        frameLayout.removeView(RNIronSourceBannerModule.this.bannerLayout);
                    }
                    RNIronSourceBannerModule rNIronSourceBannerModule = RNIronSourceBannerModule.this;
                    rNIronSourceBannerModule.bannerLayout = IronSource.createBanner(rNIronSourceBannerModule.activity, bannerSizeDescription);
                    RNIronSourceBannerModule.this.bannerLayout.setBannerListener(RNIronSourceBannerModule.this);
                    IronSource.loadBanner(RNIronSourceBannerModule.this.bannerLayout);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    RNIronSourceBannerModule.this.bannerLayout.setLayoutParams(layoutParams);
                    RNIronSourceBannerModule.this.bannerLayout.setVisibility(4);
                    HashMap bannerSize = RNIronSourceBannerModule.this.getBannerSize(bannerSizeDescription);
                    int intValue = ((Integer) bannerSize.get("width")).intValue();
                    int intValue2 = ((Integer) bannerSize.get("height")).intValue();
                    if (z) {
                        float f = RNIronSourceBannerModule.this.activity.getResources().getDisplayMetrics().density;
                        float f2 = (float) intValue;
                        float width = ((float) ((double) (((float) frameLayout.getWidth()) / f))) / f2;
                        float f3 = (float) intValue2;
                        float f4 = (((1.0f - width) * f3) * f) / 2.0f;
                        if (string.equals("top")) {
                            f4 = -f4;
                        }
                        RNIronSourceBannerModule.this.bannerLayout.setScaleX(width);
                        RNIronSourceBannerModule.this.bannerLayout.setScaleY(width);
                        RNIronSourceBannerModule.this.bannerLayout.setTranslationY(f4);
                        RNIronSourceBannerModule.this.bannerSize = Arguments.createMap();
                        RNIronSourceBannerModule.this.bannerSize.putDouble("width", (double) (f2 * width));
                        RNIronSourceBannerModule.this.bannerSize.putDouble("height", (double) (f3 * width));
                    } else {
                        RNIronSourceBannerModule.this.bannerSize = Arguments.createMap();
                        RNIronSourceBannerModule.this.bannerSize.putDouble("width", (double) intValue);
                        RNIronSourceBannerModule.this.bannerSize.putDouble("height", (double) intValue2);
                    }
                    layoutParams.gravity = RNIronSourceBannerModule.positionsMap.get(string).intValue();
                    frameLayout.addView(RNIronSourceBannerModule.this.bannerLayout);
                }
            });
        }
    }

    @ReactMethod
    public void destroyBanner() {
        IronSourceBannerLayout ironSourceBannerLayout = this.bannerLayout;
        if (ironSourceBannerLayout != null) {
            IronSource.destroyBanner(ironSourceBannerLayout);
        }
    }

    @ReactMethod
    public void showBanner() {
        if (this.bannerLayout != null) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                /* class co.squaretwo.ironsource.RNIronSourceBannerModule.AnonymousClass2 */

                public void run() {
                    RNIronSourceBannerModule.this.bannerLayout.setVisibility(0);
                }
            });
        }
    }

    @ReactMethod
    public void hideBanner() {
        if (this.bannerLayout != null) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                /* class co.squaretwo.ironsource.RNIronSourceBannerModule.AnonymousClass3 */

                public void run() {
                    RNIronSourceBannerModule.this.bannerLayout.setVisibility(4);
                }
            });
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerListener
    public void onBannerAdLoaded() {
        sendEvent("ironSourceBannerDidLoad", null);
        this.loadPromise.resolve(this.bannerSize);
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerListener
    public void onBannerAdLoadFailed(IronSourceError ironSourceError) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            /* class co.squaretwo.ironsource.RNIronSourceBannerModule.AnonymousClass4 */

            public void run() {
                RNIronSourceBannerModule.this.bannerLayout.removeAllViews();
            }
        });
        this.loadPromise.reject("E_LOAD", "Failed to load banner");
        sendEvent("ironSourceBannerDidFailToLoadWithError", Utility.formatIronSourceError(ironSourceError));
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerListener
    public void onBannerAdClicked() {
        sendEvent("ironSourceDidClickBanner", null);
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerListener
    public void onBannerAdScreenPresented() {
        sendEvent("ironSourceBannerWillPresentScreen", null);
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerListener
    public void onBannerAdScreenDismissed() {
        sendEvent("ironSourceBannerDidDismissScreen", null);
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerListener
    public void onBannerAdLeftApplication() {
        sendEvent("ironSourceBannerWillLeaveApplication", null);
    }

    private void sendEvent(String str, WritableMap writableMap) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, writableMap);
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        IronSource.onResume(this.activity);
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
        IronSource.onPause(this.activity);
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        destroyBanner();
    }
}
