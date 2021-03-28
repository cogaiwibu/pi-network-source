package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ironsource.environment.DeviceStatus;
import com.ironsource.sdk.constants.Constants;
import com.ironsource.sdk.controller.WebController;
import com.ironsource.sdk.handlers.BackButtonHandler;
import com.ironsource.sdk.listeners.OnWebViewChangeListener;

public class ControllerView extends FrameLayout implements OnWebViewChangeListener {
    private Context mContext;
    private WebController mWebViewController;

    @Override // com.ironsource.sdk.listeners.OnWebViewChangeListener
    public void onOrientationChanged(String str, int i) {
    }

    public ControllerView(Context context) {
        super(context);
        this.mContext = context;
        setClickable(true);
    }

    public void showInterstitial(WebController webController) {
        this.mWebViewController = webController;
        webController.setOnWebViewControllerChangeListener(this);
        this.mWebViewController.requestFocus();
        this.mContext = this.mWebViewController.getCurrentActivityContext();
        setPaddingByOrientation(getStatusBarPadding(), getNavigationBarPadding());
        addViewToWindow();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mWebViewController.resume();
        this.mWebViewController.viewableChange(true, Constants.ParametersKeys.MAIN);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mWebViewController.pause();
        this.mWebViewController.viewableChange(false, Constants.ParametersKeys.MAIN);
        WebController webController = this.mWebViewController;
        if (webController != null) {
            webController.setState(WebController.State.Gone);
            this.mWebViewController.removeVideoEventsListener();
        }
        removeAllViews();
    }

    private void addViewToWindow() {
        ((Activity) this.mContext).runOnUiThread(new Runnable() {
            /* class com.ironsource.sdk.controller.ControllerView.AnonymousClass1 */

            public void run() {
                ViewGroup windowDecorViewGroup = ControllerView.this.getWindowDecorViewGroup();
                if (windowDecorViewGroup != null) {
                    windowDecorViewGroup.addView(ControllerView.this);
                }
            }
        });
    }

    private void removeViewFromWindow() {
        ((Activity) this.mContext).runOnUiThread(new Runnable() {
            /* class com.ironsource.sdk.controller.ControllerView.AnonymousClass2 */

            public void run() {
                ViewGroup windowDecorViewGroup = ControllerView.this.getWindowDecorViewGroup();
                if (windowDecorViewGroup != null) {
                    windowDecorViewGroup.removeView(ControllerView.this);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ViewGroup getWindowDecorViewGroup() {
        Activity activity = (Activity) this.mContext;
        if (activity != null) {
            return (ViewGroup) activity.getWindow().getDecorView();
        }
        return null;
    }

    private void setPaddingByOrientation(int i, int i2) {
        try {
            if (this.mContext != null) {
                int deviceOrientation = DeviceStatus.getDeviceOrientation(this.mContext);
                if (deviceOrientation == 1) {
                    setPadding(0, i, 0, i2);
                } else if (deviceOrientation == 2) {
                    setPadding(0, i, i2, 0);
                }
            }
        } catch (Exception unused) {
        }
    }

    private int getStatusBarPadding() {
        int statusBarHeight;
        if (!((((Activity) this.mContext).getWindow().getAttributes().flags & 1024) != 0) && (statusBarHeight = getStatusBarHeight()) > 0) {
            return statusBarHeight;
        }
        return 0;
    }

    private int getStatusBarHeight() {
        int identifier;
        try {
            if (this.mContext == null || (identifier = this.mContext.getResources().getIdentifier("status_bar_height", "dimen", "android")) <= 0) {
                return 0;
            }
            return this.mContext.getResources().getDimensionPixelSize(identifier);
        } catch (Exception unused) {
            return 0;
        }
    }

    private int getNavigationBarPadding() {
        Activity activity = (Activity) this.mContext;
        try {
            if (Build.VERSION.SDK_INT <= 9) {
                return 0;
            }
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getDrawingRect(rect);
            Rect rect2 = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect2);
            if (DeviceStatus.getDeviceOrientation(activity) == 1) {
                if (rect.bottom - rect2.bottom > 0) {
                    return rect.bottom - rect2.bottom;
                }
                return 0;
            } else if (rect.right - rect2.right > 0) {
                return rect.right - rect2.right;
            } else {
                return 0;
            }
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // com.ironsource.sdk.listeners.OnWebViewChangeListener
    public void onCloseRequested() {
        removeViewFromWindow();
    }

    @Override // com.ironsource.sdk.listeners.OnWebViewChangeListener
    public boolean onBackButtonPressed() {
        return BackButtonHandler.getInstance().handleBackButton((Activity) this.mContext);
    }
}
