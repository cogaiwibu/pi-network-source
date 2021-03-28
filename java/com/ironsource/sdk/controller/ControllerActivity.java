package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.ironsource.environment.DeviceStatus;
import com.ironsource.sdk.Events.ISNEventParams;
import com.ironsource.sdk.Events.ISNEventsTracker;
import com.ironsource.sdk.Events.SDK5Events;
import com.ironsource.sdk.WPAD.AdViewsManager;
import com.ironsource.sdk.agent.IronSourceAdsPublisherAgent;
import com.ironsource.sdk.constants.Constants;
import com.ironsource.sdk.constants.Events;
import com.ironsource.sdk.controller.WebController;
import com.ironsource.sdk.data.AdUnitsState;
import com.ironsource.sdk.data.ISNEnums;
import com.ironsource.sdk.handlers.BackButtonHandler;
import com.ironsource.sdk.listeners.OnWebViewChangeListener;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import com.ironsource.sdk.utils.WebViewUtils;

public class ControllerActivity extends Activity implements OnWebViewChangeListener, VideoEventsListener {
    private static String CONTAINAER_IS_NULL = "removeWebViewContainerView | mContainer is null";
    private static final int CONTROLLER_WEB_VIEW_ID = 1;
    private static final String TAG = ControllerActivity.class.getSimpleName();
    private static String VIEW_IS_NULL = "removeWebViewContainerView | view is null";
    private String AD_WEB_VIEW_ID;
    final RelativeLayout.LayoutParams MATCH_PARENT_LAYOUT_PARAMS = new RelativeLayout.LayoutParams(-1, -1);
    private boolean calledFromOnCreate = false;
    public int currentRequestedRotation = -1;
    private final Runnable decorViewSettings = new Runnable() {
        /* class com.ironsource.sdk.controller.ControllerActivity.AnonymousClass1 */

        public void run() {
            ControllerActivity.this.getWindow().getDecorView().setSystemUiVisibility(SDKUtils.getActivityUIFlags(ControllerActivity.this.mIsImmersive));
        }
    };
    private RelativeLayout mContainer;
    private boolean mControllerClearedFromOnPause;
    private boolean mIsImmersive = false;
    private String mProductType;
    private AdUnitsState mState;
    private Handler mUiThreadHandler = new Handler();
    private WebController mWebViewController;
    private FrameLayout mWebViewFrameContainer;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Logger.i(TAG, "onCreate");
            hideActivityTitle();
            hideActivtiyStatusBar();
            WebController webController = (WebController) IronSourceAdsPublisherAgent.getInstance(this).getControllerManager().getController();
            this.mWebViewController = webController;
            webController.getLayout().setId(1);
            this.mWebViewController.setOnWebViewControllerChangeListener(this);
            this.mWebViewController.setVideoEventsListener(this);
            Intent intent = getIntent();
            this.mProductType = intent.getStringExtra(Constants.ParametersKeys.PRODUCT_TYPE);
            this.mIsImmersive = intent.getBooleanExtra(Constants.ParametersKeys.IMMERSIVE, false);
            this.AD_WEB_VIEW_ID = intent.getStringExtra(Constants.ParametersKeys.AD_VIEW_ID);
            this.mControllerClearedFromOnPause = false;
            if (this.mIsImmersive) {
                getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
                    /* class com.ironsource.sdk.controller.ControllerActivity.AnonymousClass2 */

                    public void onSystemUiVisibilityChange(int i) {
                        if ((i & InputDeviceCompat.SOURCE_TOUCHSCREEN) == 0) {
                            ControllerActivity.this.mUiThreadHandler.removeCallbacks(ControllerActivity.this.decorViewSettings);
                            ControllerActivity.this.mUiThreadHandler.postDelayed(ControllerActivity.this.decorViewSettings, 500);
                        }
                    }
                });
                runOnUiThread(this.decorViewSettings);
            }
            if (!TextUtils.isEmpty(this.mProductType) && ISNEnums.ProductType.OfferWall.toString().equalsIgnoreCase(this.mProductType)) {
                if (bundle != null) {
                    AdUnitsState adUnitsState = (AdUnitsState) bundle.getParcelable("state");
                    if (adUnitsState != null) {
                        this.mState = adUnitsState;
                        this.mWebViewController.restoreState(adUnitsState);
                    }
                    finish();
                } else {
                    this.mState = this.mWebViewController.getSavedState();
                }
            }
            RelativeLayout relativeLayout = new RelativeLayout(this);
            this.mContainer = relativeLayout;
            setContentView(relativeLayout, this.MATCH_PARENT_LAYOUT_PARAMS);
            this.mWebViewFrameContainer = createWebViewFrameContainer(this.AD_WEB_VIEW_ID);
            if (this.mContainer.findViewById(1) == null && this.mWebViewFrameContainer.getParent() != null) {
                this.calledFromOnCreate = true;
                finish();
            }
            initOrientationState();
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
    }

    private FrameLayout createWebViewFrameContainer(String str) {
        if (str == null || str.isEmpty() || str.equals(Integer.toString(1))) {
            return this.mWebViewController.getLayout();
        }
        return WebViewUtils.createLayout(getApplicationContext(), AdViewsManager.getInstance().getAdViewById(str));
    }

    private void initOrientationState() {
        Intent intent = getIntent();
        handleOrientationState(intent.getStringExtra(Constants.ParametersKeys.ORIENTATION_SET_FLAG), intent.getIntExtra(Constants.ParametersKeys.ROTATION_SET_FLAG, 0));
    }

    private void handleOrientationState(String str, int i) {
        if (str == null) {
            return;
        }
        if ("landscape".equalsIgnoreCase(str)) {
            setInitiateLandscapeOrientation();
        } else if ("portrait".equalsIgnoreCase(str)) {
            setInitiatePortraitOrientation();
        } else if ("device".equalsIgnoreCase(str)) {
            if (DeviceStatus.isDeviceOrientationLocked(this)) {
                setRequestedOrientation(1);
            }
        } else if (getRequestedOrientation() == -1) {
            setRequestedOrientation(4);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!TextUtils.isEmpty(this.mProductType) && ISNEnums.ProductType.OfferWall.toString().equalsIgnoreCase(this.mProductType)) {
            this.mState.setShouldRestore(true);
            bundle.putParcelable("state", this.mState);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        Logger.i(TAG, "onResume");
        this.mContainer.addView(this.mWebViewFrameContainer, this.MATCH_PARENT_LAYOUT_PARAMS);
        WebController webController = this.mWebViewController;
        if (webController != null) {
            webController.registerConnectionReceiver(this);
            this.mWebViewController.resume();
            this.mWebViewController.viewableChange(true, Constants.ParametersKeys.MAIN);
        }
        ((AudioManager) getSystemService("audio")).requestAudioFocus(null, 3, 2);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        Logger.i(TAG, "onPause");
        boolean isFinishing = isFinishing();
        ((AudioManager) getSystemService("audio")).abandonAudioFocus(null);
        WebController webController = this.mWebViewController;
        if (webController != null) {
            webController.unregisterConnectionReceiver(this);
            this.mWebViewController.pause();
            this.mWebViewController.viewableChange(false, Constants.ParametersKeys.MAIN);
        }
        removeWebViewContainerView(isFinishing);
        if (isFinishing) {
            this.mControllerClearedFromOnPause = true;
            Logger.i(TAG, "onPause | isFinishing");
            clearWebviewController();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        Logger.i(TAG, "onDestroy");
        if (this.calledFromOnCreate) {
            removeWebViewContainerView(true);
        }
        if (!this.mControllerClearedFromOnPause) {
            Logger.i(TAG, "onDestroy | destroyedFromBackground");
            clearWebviewController();
        }
    }

    private void clearWebviewController() {
        if (this.mWebViewController != null) {
            Logger.i(TAG, "clearWebviewController");
            this.mWebViewController.setState(WebController.State.Gone);
            this.mWebViewController.removeVideoEventsListener();
            this.mWebViewController.notifyLifeCycle(this.mProductType, "onDestroy");
        }
    }

    private void removeWebViewContainerView(boolean z) {
        try {
            if (!isControllerView() && z) {
                return;
            }
            if (this.mContainer != null) {
                ViewGroup viewGroup = (ViewGroup) this.mWebViewFrameContainer.getParent();
                View currentView = getCurrentView(viewGroup);
                if (currentView != null) {
                    if (z) {
                        ((ViewGroup) currentView.getParent()).removeView(currentView);
                    }
                    viewGroup.removeView(this.mWebViewFrameContainer);
                    return;
                }
                throw new Exception(VIEW_IS_NULL);
            }
            throw new Exception(CONTAINAER_IS_NULL);
        } catch (Exception e) {
            ISNEventsTracker.logEvent(SDK5Events.removeWebViewFailed, new ISNEventParams().addPair(Events.CALL_FAILED_REASON, e.getMessage()).getData());
            String str = TAG;
            Logger.i(str, "removeWebViewContainerView fail " + e.getMessage());
        }
    }

    private View getCurrentView(ViewGroup viewGroup) {
        if (isControllerView()) {
            return viewGroup.findViewById(1);
        }
        return AdViewsManager.getInstance().getAdViewById(this.AD_WEB_VIEW_ID);
    }

    private boolean isControllerView() {
        return this.AD_WEB_VIEW_ID == null;
    }

    @Override // com.ironsource.sdk.listeners.OnWebViewChangeListener
    public void onCloseRequested() {
        finish();
    }

    @Override // com.ironsource.sdk.listeners.OnWebViewChangeListener
    public void onOrientationChanged(String str, int i) {
        handleOrientationState(str, i);
    }

    @Override // com.ironsource.sdk.listeners.OnWebViewChangeListener
    public boolean onBackButtonPressed() {
        onBackPressed();
        return true;
    }

    public void onBackPressed() {
        Logger.i(TAG, "onBackPressed");
        if (!BackButtonHandler.getInstance().handleBackButton(this)) {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        Logger.i(TAG, "onUserLeaveHint");
    }

    private void hideActivityTitle() {
        requestWindowFeature(1);
    }

    private void hideActivtiyStatusBar() {
        getWindow().setFlags(1024, 1024);
    }

    private void keepScreenOn() {
        runOnUiThread(new Runnable() {
            /* class com.ironsource.sdk.controller.ControllerActivity.AnonymousClass3 */

            public void run() {
                ControllerActivity.this.getWindow().addFlags(128);
            }
        });
    }

    private void cancelScreenOn() {
        runOnUiThread(new Runnable() {
            /* class com.ironsource.sdk.controller.ControllerActivity.AnonymousClass4 */

            public void run() {
                ControllerActivity.this.getWindow().clearFlags(128);
            }
        });
    }

    private void setInitiateLandscapeOrientation() {
        int applicationRotation = DeviceStatus.getApplicationRotation(this);
        Logger.i(TAG, "setInitiateLandscapeOrientation");
        if (applicationRotation == 0) {
            Logger.i(TAG, "ROTATION_0");
            setRequestedOrientation(0);
        } else if (applicationRotation == 2) {
            Logger.i(TAG, "ROTATION_180");
            setRequestedOrientation(8);
        } else if (applicationRotation == 3) {
            Logger.i(TAG, "ROTATION_270 Right Landscape");
            setRequestedOrientation(8);
        } else if (applicationRotation == 1) {
            Logger.i(TAG, "ROTATION_90 Left Landscape");
            setRequestedOrientation(0);
        } else {
            Logger.i(TAG, "No Rotation");
        }
    }

    private void setInitiatePortraitOrientation() {
        int applicationRotation = DeviceStatus.getApplicationRotation(this);
        Logger.i(TAG, "setInitiatePortraitOrientation");
        if (applicationRotation == 0) {
            Logger.i(TAG, "ROTATION_0");
            setRequestedOrientation(1);
        } else if (applicationRotation == 2) {
            Logger.i(TAG, "ROTATION_180");
            setRequestedOrientation(9);
        } else if (applicationRotation == 1) {
            Logger.i(TAG, "ROTATION_270 Right Landscape");
            setRequestedOrientation(1);
        } else if (applicationRotation == 3) {
            Logger.i(TAG, "ROTATION_90 Left Landscape");
            setRequestedOrientation(1);
        } else {
            Logger.i(TAG, "No Rotation");
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !this.mWebViewController.inCustomView()) {
            if (this.mIsImmersive && (i == 25 || i == 24)) {
                this.mUiThreadHandler.removeCallbacks(this.decorViewSettings);
                this.mUiThreadHandler.postDelayed(this.decorViewSettings, 500);
            }
            return super.onKeyDown(i, keyEvent);
        }
        this.mWebViewController.hideCustomView();
        return true;
    }

    public void setRequestedOrientation(int i) {
        if (this.currentRequestedRotation != i) {
            String str = TAG;
            Logger.i(str, "Rotation: Req = " + i + " Curr = " + this.currentRequestedRotation);
            this.currentRequestedRotation = i;
            super.setRequestedOrientation(i);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.mIsImmersive && z) {
            runOnUiThread(this.decorViewSettings);
        }
    }

    @Override // com.ironsource.sdk.controller.VideoEventsListener
    public void onVideoStarted() {
        toggleKeepScreen(true);
    }

    @Override // com.ironsource.sdk.controller.VideoEventsListener
    public void onVideoPaused() {
        toggleKeepScreen(false);
    }

    @Override // com.ironsource.sdk.controller.VideoEventsListener
    public void onVideoResumed() {
        toggleKeepScreen(true);
    }

    @Override // com.ironsource.sdk.controller.VideoEventsListener
    public void onVideoEnded() {
        toggleKeepScreen(false);
    }

    @Override // com.ironsource.sdk.controller.VideoEventsListener
    public void onVideoStopped() {
        toggleKeepScreen(false);
    }

    public void toggleKeepScreen(boolean z) {
        if (z) {
            keepScreenOn();
        } else {
            cancelScreenOn();
        }
    }
}
