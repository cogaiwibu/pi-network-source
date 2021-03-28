package co.squaretwo.ironsource;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceSegment;

public class RNIronSourceSegmentModule extends ReactContextBaseJavaModule {
    private IronSourceSegment segment;

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNIronSourceSegment";
    }

    public RNIronSourceSegmentModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void create() {
        this.segment = new IronSourceSegment();
    }

    @ReactMethod
    public void setSegmentName(String str) {
        this.segment.setSegmentName(str);
    }

    @ReactMethod
    public void setCustomValue(String str, String str2) {
        this.segment.setCustom(str2, str);
    }

    @ReactMethod
    public void activate() {
        IronSourceSegment ironSourceSegment = this.segment;
        if (ironSourceSegment != null) {
            IronSource.setSegment(ironSourceSegment);
        }
    }
}
