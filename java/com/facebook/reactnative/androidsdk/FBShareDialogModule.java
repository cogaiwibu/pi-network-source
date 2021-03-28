package com.facebook.reactnative.androidsdk;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.share.Sharer;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.widget.ShareDialog;

@ReactModule(name = FBShareDialogModule.NAME)
public class FBShareDialogModule extends FBSDKCallbackManagerBaseJavaModule {
    public static final String NAME = "FBShareDialog";
    private ShareDialog.Mode mShareDialogMode;
    private boolean mShouldFailOnError;

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    private class ShareDialogCallback extends ReactNativeFacebookSDKCallback<Sharer.Result> {
        public ShareDialogCallback(Promise promise) {
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

    public FBShareDialogModule(ReactApplicationContext reactApplicationContext, FBActivityEventListener fBActivityEventListener) {
        super(reactApplicationContext, fBActivityEventListener);
    }

    @ReactMethod
    public void canShow(ReadableMap readableMap, Promise promise) {
        boolean z;
        if (getCurrentActivity() != null) {
            ShareDialog shareDialog = new ShareDialog(getCurrentActivity());
            if (this.mShareDialogMode == null) {
                z = shareDialog.canShow(Utility.buildShareContent(readableMap));
            } else {
                z = shareDialog.canShow(Utility.buildShareContent(readableMap), this.mShareDialogMode);
            }
            promise.resolve(Boolean.valueOf(z));
            return;
        }
        promise.reject("No current activity.");
    }

    @ReactMethod
    public void show(ReadableMap readableMap, Promise promise) {
        if (getCurrentActivity() != null) {
            ShareDialog shareDialog = new ShareDialog(getCurrentActivity());
            shareDialog.registerCallback(getCallbackManager(), new ShareDialogCallback(promise));
            shareDialog.setShouldFailOnDataError(this.mShouldFailOnError);
            if (this.mShareDialogMode != null) {
                shareDialog.show(Utility.buildShareContent(readableMap), this.mShareDialogMode);
            } else {
                shareDialog.show(Utility.buildShareContent(readableMap));
            }
        } else {
            promise.reject("No current activity.");
        }
    }

    @ReactMethod
    public void setMode(String str) {
        this.mShareDialogMode = ShareDialog.Mode.valueOf(str.toUpperCase());
    }

    @ReactMethod
    public void setShouldFailOnError(boolean z) {
        this.mShouldFailOnError = z;
    }
}
