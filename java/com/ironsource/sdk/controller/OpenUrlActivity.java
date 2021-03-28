package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.ironsource.sdk.agent.IronSourceAdsPublisherAgent;
import com.ironsource.sdk.constants.Constants;
import com.ironsource.sdk.utils.IronSourceSharedPrefHelper;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.List;

public class OpenUrlActivity extends Activity {
    private static final int PROGRESS_BAR_VIEW_ID = SDKUtils.generateViewId();
    private static final String TAG = "OpenUrlActivity";
    private static final int WEB_VIEW_VIEW_ID = SDKUtils.generateViewId();
    private final Runnable decorViewSettings = new Runnable() {
        /* class com.ironsource.sdk.controller.OpenUrlActivity.AnonymousClass2 */

        public void run() {
            OpenUrlActivity.this.getWindow().getDecorView().setSystemUiVisibility(SDKUtils.getActivityUIFlags(OpenUrlActivity.this.mIsImmersive));
        }
    };
    boolean isSecondaryWebview;
    private boolean mIsImmersive = false;
    private ProgressBar mProgressBar;
    private Handler mUiThreadHandler = new Handler();
    private String mUrl;
    private WebController mWebViewController;
    private RelativeLayout mainLayout;
    private WebView webView = null;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Logger.i(TAG, "onCreate()");
        try {
            this.mWebViewController = (WebController) IronSourceAdsPublisherAgent.getInstance(this).getControllerManager().getController();
            hideActivityTitle();
            hideActivtiyStatusBar();
            Bundle extras = getIntent().getExtras();
            this.mUrl = extras.getString(WebController.EXTERNAL_URL);
            this.isSecondaryWebview = extras.getBoolean(WebController.SECONDARY_WEB_VIEW);
            boolean booleanExtra = getIntent().getBooleanExtra(Constants.ParametersKeys.IMMERSIVE, false);
            this.mIsImmersive = booleanExtra;
            if (booleanExtra) {
                getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
                    /* class com.ironsource.sdk.controller.OpenUrlActivity.AnonymousClass1 */

                    public void onSystemUiVisibilityChange(int i) {
                        if ((i & InputDeviceCompat.SOURCE_TOUCHSCREEN) == 0) {
                            OpenUrlActivity.this.mUiThreadHandler.removeCallbacks(OpenUrlActivity.this.decorViewSettings);
                            OpenUrlActivity.this.mUiThreadHandler.postDelayed(OpenUrlActivity.this.decorViewSettings, 500);
                        }
                    }
                });
                runOnUiThread(this.decorViewSettings);
            }
            RelativeLayout relativeLayout = new RelativeLayout(this);
            this.mainLayout = relativeLayout;
            setContentView(relativeLayout, new ViewGroup.LayoutParams(-1, -1));
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        createWebView();
    }

    private void createWebView() {
        if (this.webView == null) {
            WebView webView2 = new WebView(getApplicationContext());
            this.webView = webView2;
            webView2.setId(WEB_VIEW_VIEW_ID);
            this.webView.getSettings().setJavaScriptEnabled(true);
            this.webView.setWebViewClient(new Client());
            loadUrl(this.mUrl);
        }
        if (findViewById(WEB_VIEW_VIEW_ID) == null) {
            this.mainLayout.addView(this.webView, new RelativeLayout.LayoutParams(-1, -1));
        }
        createProgressBarForWebView();
        WebController webController = this.mWebViewController;
        if (webController != null) {
            webController.viewableChange(true, Constants.ParametersKeys.SECONDARY);
        }
    }

    private void createProgressBarForWebView() {
        if (this.mProgressBar == null) {
            if (Build.VERSION.SDK_INT >= 11) {
                this.mProgressBar = new ProgressBar(new ContextThemeWrapper(this, 16973939));
            } else {
                this.mProgressBar = new ProgressBar(this);
            }
            this.mProgressBar.setId(PROGRESS_BAR_VIEW_ID);
        }
        if (findViewById(PROGRESS_BAR_VIEW_ID) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.mProgressBar.setLayoutParams(layoutParams);
            this.mProgressBar.setVisibility(4);
            this.mainLayout.addView(this.mProgressBar);
        }
    }

    private void removeWebViewFromLayout() {
        ViewGroup viewGroup;
        WebController webController = this.mWebViewController;
        if (webController != null) {
            webController.viewableChange(false, Constants.ParametersKeys.SECONDARY);
            if (this.mainLayout != null && (viewGroup = (ViewGroup) this.webView.getParent()) != null) {
                if (viewGroup.findViewById(WEB_VIEW_VIEW_ID) != null) {
                    viewGroup.removeView(this.webView);
                }
                if (viewGroup.findViewById(PROGRESS_BAR_VIEW_ID) != null) {
                    viewGroup.removeView(this.mProgressBar);
                }
            }
        }
    }

    private void destroyWebView() {
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.destroy();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        removeWebViewFromLayout();
    }

    public void loadUrl(String str) {
        this.webView.stopLoading();
        this.webView.clearHistory();
        try {
            this.webView.loadUrl(str);
        } catch (Throwable th) {
            Logger.e(TAG, "OpenUrlActivity:: loadUrl: " + th.toString());
        }
    }

    /* access modifiers changed from: private */
    public class Client extends WebViewClient {
        private Client() {
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            OpenUrlActivity.this.mProgressBar.setVisibility(0);
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            OpenUrlActivity.this.mProgressBar.setVisibility(4);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            List<String> searchKeys = IronSourceSharedPrefHelper.getSupersonicPrefHelper().getSearchKeys();
            if (searchKeys != null && !searchKeys.isEmpty()) {
                for (String str2 : searchKeys) {
                    if (str.contains(str2)) {
                        try {
                            OpenUrlActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                            OpenUrlActivity.this.mWebViewController.interceptedUrlToStore();
                        } catch (Exception e) {
                            StringBuilder sb = new StringBuilder();
                            if (e instanceof ActivityNotFoundException) {
                                sb.append(Constants.ErrorCodes.STORE_ACTIVITY_FAILED_REASON_NO_ACTIVITY);
                            } else {
                                sb.append(Constants.ErrorCodes.STORE_ACTIVITY_FAILED_REASON_UNSPECIFIED);
                            }
                            if (OpenUrlActivity.this.mWebViewController != null) {
                                OpenUrlActivity.this.mWebViewController.failedToStartStoreActivity(sb.toString(), str);
                            }
                        }
                        OpenUrlActivity.this.finish();
                        return true;
                    }
                }
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    private void hideActivityTitle() {
        requestWindowFeature(1);
    }

    private void hideActivtiyStatusBar() {
        getWindow().setFlags(1024, 1024);
    }

    private void disableTouch() {
        getWindow().addFlags(16);
    }

    public void onBackPressed() {
        if (this.webView.canGoBack()) {
            this.webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        destroyWebView();
    }

    public void finish() {
        WebController webController;
        if (this.isSecondaryWebview && (webController = this.mWebViewController) != null) {
            webController.engageEnd(Constants.ParametersKeys.SECONDARY_CLOSE);
        }
        super.finish();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.mIsImmersive && z) {
            runOnUiThread(this.decorViewSettings);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.mIsImmersive && (i == 25 || i == 24)) {
            this.mUiThreadHandler.postDelayed(this.decorViewSettings, 500);
        }
        return super.onKeyDown(i, keyEvent);
    }
}
