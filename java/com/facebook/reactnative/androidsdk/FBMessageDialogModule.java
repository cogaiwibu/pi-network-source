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
import com.facebook.share.model.ShareContent;
import com.facebook.share.widget.MessageDialog;

@ReactModule(name = FBMessageDialogModule.NAME)
public class FBMessageDialogModule extends FBSDKCallbackManagerBaseJavaModule {
    public static final String NAME = "FBMessageDialog";
    private boolean mShouldFailOnDataError;

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    private class MessageDialogCallback extends ReactNativeFacebookSDKCallback<Sharer.Result> {
        public MessageDialogCallback(Promise promise) {
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

    public FBMessageDialogModule(ReactApplicationContext reactApplicationContext, FBActivityEventListener fBActivityEventListener) {
        super(reactApplicationContext, fBActivityEventListener);
    }

    @ReactMethod
    public void canShow(ReadableMap readableMap, Promise promise) {
        if (getCurrentActivity() != null) {
            promise.resolve(Boolean.valueOf(new MessageDialog(getCurrentActivity()).canShow(Utility.buildShareContent(readableMap))));
            return;
        }
        promise.reject("No current activity.");
    }

    @ReactMethod
    public void show(ReadableMap readableMap, Promise promise) {
        if (getCurrentActivity() != null) {
            ShareContent buildShareContent = Utility.buildShareContent(readableMap);
            MessageDialog messageDialog = new MessageDialog(getCurrentActivity());
            messageDialog.setShouldFailOnDataError(this.mShouldFailOnDataError);
            messageDialog.registerCallback(getCallbackManager(), new MessageDialogCallback(promise));
            messageDialog.show(buildShareContent);
            return;
        }
        promise.reject("No current activity.");
    }

    @ReactMethod
    public void setShouldFailOnDataError(boolean z) {
        this.mShouldFailOnDataError = z;
    }
}
