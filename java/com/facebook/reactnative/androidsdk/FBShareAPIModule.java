package com.facebook.reactnative.androidsdk;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.share.ShareApi;
import com.facebook.share.Sharer;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.model.ShareContent;

@ReactModule(name = FBShareAPIModule.NAME)
public class FBShareAPIModule extends ReactContextBaseJavaModule {
    public static final String NAME = "FBShareApi";

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    private class ShareAPICallback extends ReactNativeFacebookSDKCallback<Sharer.Result> {
        public ShareAPICallback(Promise promise) {
            super(promise);
        }

        public void onSuccess(Sharer.Result result) {
            if (this.mPromise != null) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString(ShareConstants.RESULT_POST_ID, result.getPostId());
                this.mPromise.resolve(createMap);
                this.mPromise = null;
            }
        }
    }

    public FBShareAPIModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void share(ReadableMap readableMap, String str, String str2, Promise promise) {
        ShareContent buildShareContent = Utility.buildShareContent(readableMap);
        if (buildShareContent != null) {
            ShareApi shareApi = new ShareApi(buildShareContent);
            shareApi.setGraphNode(str);
            shareApi.setMessage(str2);
            shareApi.share(new ShareAPICallback(promise));
            return;
        }
        promise.reject("ShareContent cannot be null");
    }

    @ReactMethod
    public void canShare(ReadableMap readableMap, Promise promise) {
        ShareContent buildShareContent = Utility.buildShareContent(readableMap);
        if (buildShareContent != null) {
            promise.resolve(Boolean.valueOf(new ShareApi(buildShareContent).canShare()));
        } else {
            promise.reject("ShareContent cannot be null");
        }
    }
}
