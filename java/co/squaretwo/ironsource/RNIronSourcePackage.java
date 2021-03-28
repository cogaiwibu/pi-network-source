package co.squaretwo.ironsource;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RNIronSourcePackage implements ReactPackage {
    @Override // com.facebook.react.ReactPackage
    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new RNIronSourceModule(reactApplicationContext), new RNIronSourceSegmentModule(reactApplicationContext), new RNIronSourceRewardedVideoModule(reactApplicationContext), new RNIronSourceOfferwallModule(reactApplicationContext), new RNIronSourceInterstitialsModule(reactApplicationContext), new RNIronSourceBannerModule(reactApplicationContext));
    }

    @Override // com.facebook.react.ReactPackage
    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }
}
