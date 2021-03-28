package com.ironsource.sdk.controller;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.ironsource.environment.ApplicationContext;
import com.ironsource.environment.DeviceStatus;
import com.ironsource.environment.UrlHandler;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.network.ConnectivityService;
import com.ironsource.network.ConnectivityUtils;
import com.ironsource.sdk.Events.ISNEventParams;
import com.ironsource.sdk.Events.ISNEventsBaseData;
import com.ironsource.sdk.Events.ISNEventsTracker;
import com.ironsource.sdk.Events.SDK5Events;
import com.ironsource.sdk.ISNAdView.ISNAdView;
import com.ironsource.sdk.WPAD.AdViewsManager;
import com.ironsource.sdk.constants.Constants;
import com.ironsource.sdk.constants.Events;
import com.ironsource.sdk.data.AdUnitsReady;
import com.ironsource.sdk.data.AdUnitsState;
import com.ironsource.sdk.data.DemandSource;
import com.ironsource.sdk.data.ISNEnums;
import com.ironsource.sdk.data.SSAFile;
import com.ironsource.sdk.data.SSAObj;
import com.ironsource.sdk.listeners.OnOfferWallListener;
import com.ironsource.sdk.listeners.OnWebViewChangeListener;
import com.ironsource.sdk.listeners.internals.DSAdProductListener;
import com.ironsource.sdk.listeners.internals.DSBannerListener;
import com.ironsource.sdk.listeners.internals.DSInterstitialListener;
import com.ironsource.sdk.listeners.internals.DSRewardedVideoListener;
import com.ironsource.sdk.precache.DownloadManager;
import com.ironsource.sdk.precache.OnPreCacheCompletion;
import com.ironsource.sdk.service.Connectivity.ConnectivityAdapter;
import com.ironsource.sdk.service.PackagesInstallationService;
import com.ironsource.sdk.utils.DeviceProperties;
import com.ironsource.sdk.utils.IronSourceSharedPrefHelper;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import com.ironsource.sdk.utils.WebViewUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WebController extends WebView implements IronSourceController, OnPreCacheCompletion, DownloadListener {
    public static String EXTERNAL_URL = "external_url";
    public static String IS_STORE = "is_store";
    private static String JSON_KEY_FAIL = "fail";
    private static String JSON_KEY_SUCCESS = "success";
    public static String SECONDARY_WEB_VIEW = "secondary_web_view";
    public static int mDebugMode;
    private final String GENERIC_MESSAGE = "We're sorry, some error occurred. we will investigate it";
    private String PUB_TAG = IronSourceConstants.IRONSOURCE_CONFIG_NAME;
    private String TAG = WebController.class.getSimpleName();
    private DownloadManager downloadManager;
    private Boolean isKitkatAndAbove = null;
    private boolean isRemoveCloseEventHandler;
    private AdViewsJSAdapter mAdViewsJsAdapter;
    private String mApplicationKey;
    private BannerJSAdapter mBannerJsAdapter;
    private String mCacheDirectory;
    private OnWebViewChangeListener mChangeListener;
    private CountDownTimer mCloseEventTimer;
    private ConnectivityAdapter mConnectivityAdapter;
    ContextProvider mContextProvider;
    private String mControllerKeyPressed = "interrupt";
    private FrameLayout mControllerLayout;
    private ControllerEventListener mControllerListener;
    private View mCustomView;
    private WebChromeClient.CustomViewCallback mCustomViewCallback;
    private FrameLayout mCustomViewContainer;
    private DSBannerListener mDSBannerListener;
    private DSInterstitialListener mDSInterstitialListener;
    private DSRewardedVideoListener mDSRewardedVideoListener;
    private DemandSourceManager mDemandSourceManager;
    private DeviceDataJSAdapter mDeviceDataJsAdapter;
    private int mHiddenForceCloseHeight = 50;
    private String mHiddenForceCloseLocation = Constants.ForceClosePosition.TOP_RIGHT;
    private int mHiddenForceCloseWidth = 50;
    private boolean mIsImmersive = false;
    private boolean mIsWebControllerReady;
    public CountDownTimer mLoadControllerTimer;
    private boolean mOWCreditsMiss;
    private Map<String, String> mOWExtraParameters;
    private boolean mOWmiss;
    private OMIDJSAdapter mOmidJsAdapter;
    private OnOfferWallListener mOnOfferWallListener;
    private String mOrientationState;
    private PermissionsJSAdapter mPermissionsJsAdapter;
    private AdUnitsState mSavedState;
    private Object mSavedStateLocker = new Object();
    private State mState;
    private TokenJSAdapter mTokenJSAdapter;
    Handler mUiHandler;
    private String mUserId;
    private VideoEventsListener mVideoEventsListener;
    private ChromeClient mWebChromeClient;
    private WebViewMessagingMediator mWebViewMessagingMediator;

    /* access modifiers changed from: private */
    public interface OnInitProductHandler {
        void handleInitProductFailed(String str, ISNEnums.ProductType productType, DemandSource demandSource);
    }

    public enum State {
        Display,
        Gone
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private WebView getWebview() {
        return this;
    }

    private Map<String, String> getExtraParamsByProduct(ISNEnums.ProductType productType) {
        if (productType == ISNEnums.ProductType.OfferWall) {
            return this.mOWExtraParameters;
        }
        return null;
    }

    public WebController(Context context, DemandSourceManager demandSourceManager, ContextProvider contextProvider, ControllerEventListener controllerEventListener) {
        super(context);
        Logger.i(this.TAG, "C'tor");
        this.mContextProvider = contextProvider;
        this.mControllerListener = controllerEventListener;
        this.mCacheDirectory = initializeCacheDirectory(context);
        this.mDemandSourceManager = demandSourceManager;
        initLayout(context);
        this.mSavedState = new AdUnitsState();
        DownloadManager downloadManager2 = getDownloadManager();
        this.downloadManager = downloadManager2;
        downloadManager2.setOnPreCacheCompletion(this);
        this.mWebChromeClient = new ChromeClient();
        setWebViewClient(new ViewClient());
        setWebChromeClient(this.mWebChromeClient);
        WebViewUtils.setWebViewSettings(this);
        setWebViewSettings();
        createSecuredCommunication();
        setDownloadListener(this);
        setOnTouchListener(new SupersonicWebViewTouchListener());
        this.mUiHandler = createMainThreadHandler();
        this.mConnectivityAdapter = createConnectivityAdapter(context);
        registerConnectionReceiver(context);
        setDebugMode(FeaturesManager.getInstance().getDebugMode());
    }

    private ConnectivityAdapter createConnectivityAdapter(Context context) {
        return new ConnectivityAdapter(SDKUtils.getControllerConfigAsJSONObject(), context) {
            /* class com.ironsource.sdk.controller.WebController.AnonymousClass1 */

            @Override // com.ironsource.sdk.service.Connectivity.IConnectivityStatus, com.ironsource.sdk.service.Connectivity.ConnectivityAdapter
            public void onConnected(String str, JSONObject jSONObject) {
                if (WebController.this.mIsWebControllerReady) {
                    WebController.this.sendConnectionTypeChanged(str);
                }
            }

            @Override // com.ironsource.sdk.service.Connectivity.IConnectivityStatus, com.ironsource.sdk.service.Connectivity.ConnectivityAdapter
            public void onDisconnected() {
                if (WebController.this.mIsWebControllerReady) {
                    WebController.this.sendConnectionTypeChanged("none");
                }
            }

            @Override // com.ironsource.sdk.service.Connectivity.IConnectivityStatus, com.ironsource.sdk.service.Connectivity.ConnectivityAdapter
            public void onStatusChanged(String str, JSONObject jSONObject) {
                if (jSONObject != null && WebController.this.mIsWebControllerReady) {
                    try {
                        jSONObject.put("connectionType", str);
                        WebController.this.sendConnectionInfoChanged(jSONObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    private void createSecuredCommunication() {
        SecureMessagingService secureMessagingService = new SecureMessagingService(SecureMessagingService.generateToken());
        addJavascriptInterface(createControllerMessageHandler(secureMessagingService), Constants.JAVASCRIPT_INTERFACE_NAME);
        addJavascriptInterface(createSecureMessagingInterface(secureMessagingService), Constants.JAVASCRIPT_INTERFACE_NAME_GENERATE_TOKEN);
    }

    /* access modifiers changed from: package-private */
    public ControllerMessageHandler createControllerMessageHandler(SecureMessagingService secureMessagingService) {
        return new ControllerMessageHandler(new ControllerAdapter(new NativeAPI()), secureMessagingService);
    }

    /* access modifiers changed from: package-private */
    public SecureMessagingInterface createSecureMessagingInterface(SecureMessagingService secureMessagingService) {
        return new SecureMessagingInterface(secureMessagingService);
    }

    /* access modifiers changed from: package-private */
    public Handler createMainThreadHandler() {
        return new Handler(Looper.getMainLooper());
    }

    /* access modifiers changed from: package-private */
    public DownloadManager getDownloadManager() {
        return DownloadManager.getInstance(this.mCacheDirectory);
    }

    /* access modifiers changed from: package-private */
    public String initializeCacheDirectory(Context context) {
        return IronSourceStorageUtils.initializeCacheDirectory(context.getApplicationContext());
    }

    public void addOmidJSInterface(OMIDJSAdapter oMIDJSAdapter) {
        this.mOmidJsAdapter = oMIDJSAdapter;
    }

    public void addPermissionsJSInterface(PermissionsJSAdapter permissionsJSAdapter) {
        this.mPermissionsJsAdapter = permissionsJSAdapter;
    }

    public void addBannerJSInterface(BannerJSAdapter bannerJSAdapter) {
        this.mBannerJsAdapter = bannerJSAdapter;
        bannerJSAdapter.setCommunicationWithController(getControllerDelegate());
    }

    public void addTokenJSInterface(TokenJSAdapter tokenJSAdapter) {
        this.mTokenJSAdapter = tokenJSAdapter;
    }

    public void addDeviceDataJSInterface(DeviceDataJSAdapter deviceDataJSAdapter) {
        this.mDeviceDataJsAdapter = deviceDataJSAdapter;
    }

    public void addAdViewsJSInterface(AdViewsJSAdapter adViewsJSAdapter) {
        this.mAdViewsJsAdapter = adViewsJSAdapter;
        adViewsJSAdapter.setCommunicationWithController(getControllerDelegate());
    }

    public void notifyLifeCycle(String str, String str2) {
        injectJavascript(generateJSToInject(Constants.JSMethods.ON_NATIVE_LIFE_CYCLE_EVENT, parseToJson(Constants.ParametersKeys.LIFE_CYCLE_EVENT, str2, Constants.ParametersKeys.PRODUCT_TYPE, str, null, null, null, null, null, false)));
    }

    public WebViewMessagingMediator getControllerDelegate() {
        if (this.mWebViewMessagingMediator == null) {
            this.mWebViewMessagingMediator = new WebViewMessagingMediator() {
                /* class com.ironsource.sdk.controller.WebController.AnonymousClass2 */

                @Override // com.ironsource.sdk.controller.WebViewMessagingMediator
                public void sendMessageToController(String str, JSONObject jSONObject) {
                    WebController.this.injectJavascript(WebController.this.generateJSToInject(str, jSONObject.toString()));
                }
            };
        }
        return this.mWebViewMessagingMediator;
    }

    private class SupersonicWebViewTouchListener implements View.OnTouchListener {
        private SupersonicWebViewTouchListener() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                String str = WebController.this.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("X:");
                int i = (int) x;
                sb.append(i);
                sb.append(" Y:");
                int i2 = (int) y;
                sb.append(i2);
                Logger.i(str, sb.toString());
                int deviceWidth = DeviceStatus.getDeviceWidth();
                int deviceHeight = DeviceStatus.getDeviceHeight();
                String str2 = WebController.this.TAG;
                Logger.i(str2, "Width:" + deviceWidth + " Height:" + deviceHeight);
                int dpToPx = SDKUtils.dpToPx((long) WebController.this.mHiddenForceCloseWidth);
                int dpToPx2 = SDKUtils.dpToPx((long) WebController.this.mHiddenForceCloseHeight);
                if (Constants.ForceClosePosition.TOP_RIGHT.equalsIgnoreCase(WebController.this.mHiddenForceCloseLocation)) {
                    i = deviceWidth - i;
                } else if (!Constants.ForceClosePosition.TOP_LEFT.equalsIgnoreCase(WebController.this.mHiddenForceCloseLocation)) {
                    if (Constants.ForceClosePosition.BOTTOM_RIGHT.equalsIgnoreCase(WebController.this.mHiddenForceCloseLocation)) {
                        i = deviceWidth - i;
                    } else if (!Constants.ForceClosePosition.BOTTOM_LEFT.equalsIgnoreCase(WebController.this.mHiddenForceCloseLocation)) {
                        i = 0;
                        i2 = 0;
                    }
                    i2 = deviceHeight - i2;
                }
                if (i <= dpToPx && i2 <= dpToPx2) {
                    WebController.this.isRemoveCloseEventHandler = false;
                    if (WebController.this.mCloseEventTimer != null) {
                        WebController.this.mCloseEventTimer.cancel();
                    }
                    WebController.this.mCloseEventTimer = new CountDownTimer(2000, 500) {
                        /* class com.ironsource.sdk.controller.WebController.SupersonicWebViewTouchListener.AnonymousClass1 */

                        public void onTick(long j) {
                            String str = WebController.this.TAG;
                            Logger.i(str, "Close Event Timer Tick " + j);
                        }

                        public void onFinish() {
                            Logger.i(WebController.this.TAG, "Close Event Timer Finish");
                            if (WebController.this.isRemoveCloseEventHandler) {
                                WebController.this.isRemoveCloseEventHandler = false;
                            } else {
                                WebController.this.engageEnd("forceClose");
                            }
                        }
                    }.start();
                }
            }
            return false;
        }
    }

    private void initLayout(Context context) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.mControllerLayout = new FrameLayout(context);
        this.mCustomViewContainer = new FrameLayout(context);
        this.mCustomViewContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.mCustomViewContainer.setVisibility(8);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(this);
        this.mControllerLayout.addView(this.mCustomViewContainer, layoutParams);
        this.mControllerLayout.addView(frameLayout);
    }

    private void setWebViewSettings() {
        WebSettings settings = getSettings();
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        settings.setAllowFileAccess(true);
        settings.setBuiltInZoomControls(false);
        settings.setJavaScriptEnabled(true);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setGeolocationEnabled(true);
        settings.setGeolocationDatabasePath("/data/data/org.itri.html5webview/databases/");
        settings.setDomStorageEnabled(true);
        try {
            setDisplayZoomControls(settings);
            setMediaPlaybackJellyBean(settings);
        } catch (Throwable th) {
            String str = this.TAG;
            Logger.e(str, "setWebSettings - " + th.toString());
        }
    }

    private void setDisplayZoomControls(WebSettings webSettings) {
        if (Build.VERSION.SDK_INT > 11) {
            webSettings.setDisplayZoomControls(false);
        }
    }

    public WebBackForwardList saveState(Bundle bundle) {
        return super.saveState(bundle);
    }

    private void setMediaPlaybackJellyBean(WebSettings webSettings) {
        if (Build.VERSION.SDK_INT >= 17) {
            webSettings.setMediaPlaybackRequiresUserGesture(false);
        }
    }

    private void setWebDebuggingEnabled() {
        if (Build.VERSION.SDK_INT >= 19) {
            setWebContentsDebuggingEnabled(true);
        }
    }

    public void downloadController() {
        IronSourceStorageUtils.deleteFile(this.mCacheDirectory, "", Constants.MOBILE_CONTROLLER_HTML);
        String controllerUrl = SDKUtils.getControllerUrl();
        SSAFile sSAFile = new SSAFile(controllerUrl, "");
        if (!this.downloadManager.isMobileControllerThreadLive()) {
            String str = this.TAG;
            Logger.i(str, "Download Mobile Controller: " + controllerUrl);
            this.downloadManager.downloadMobileControllerFile(sSAFile);
            return;
        }
        Logger.i(this.TAG, "Download Mobile Controller: already alive");
    }

    public void setDebugMode(int i) {
        mDebugMode = i;
    }

    public int getDebugMode() {
        return mDebugMode;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean shouldNotifyDeveloper(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            Logger.d(this.TAG, "Trying to trigger a listener - no product was found");
            return false;
        }
        if (!str.equalsIgnoreCase(ISNEnums.ProductType.Interstitial.toString()) ? !str.equalsIgnoreCase(ISNEnums.ProductType.RewardedVideo.toString()) ? !str.equalsIgnoreCase(ISNEnums.ProductType.Banner.toString()) ? (str.equalsIgnoreCase(ISNEnums.ProductType.OfferWall.toString()) || str.equalsIgnoreCase(ISNEnums.ProductType.OfferWallCredits.toString())) && this.mOnOfferWallListener != null : this.mDSBannerListener != null : this.mDSRewardedVideoListener != null : this.mDSInterstitialListener != null) {
            z = true;
        }
        if (!z) {
            String str2 = this.TAG;
            Logger.d(str2, "Trying to trigger a listener - no listener was found for product " + str);
        }
        return z;
    }

    public void setOrientationState(String str) {
        this.mOrientationState = str;
    }

    public String getOrientationState() {
        return this.mOrientationState;
    }

    private class ViewClient extends WebViewClient {
        private ViewClient() {
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Logger.i("onPageStarted", str);
            super.onPageStarted(webView, str, bitmap);
        }

        public void onPageFinished(WebView webView, String str) {
            Logger.i("onPageFinished", str);
            if (str.contains("adUnit") || str.contains("index.html")) {
                WebController.this.pageFinished();
            }
            super.onPageFinished(webView, str);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Logger.i("onReceivedError", str2 + " " + str);
            if (str2.contains(Constants.MOBILE_CONTROLLER_HTML) && WebController.this.mControllerListener != null) {
                ControllerEventListener controllerEventListener = WebController.this.mControllerListener;
                controllerEventListener.handleControllerFailed("controller html - web-view receivedError on loading - " + str + " (errorCode: " + i + ")");
            }
            super.onReceivedError(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Logger.i("shouldOverrideUrlLoading", str);
            try {
                if (WebController.this.handleSearchKeysURLs(str)) {
                    WebController.this.interceptedUrlToStore();
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            boolean z;
            Logger.i("shouldInterceptRequest", str);
            try {
                z = new URL(str).getFile().contains("mraid.js");
            } catch (MalformedURLException unused) {
                z = false;
            }
            if (z) {
                String str2 = "file://" + WebController.this.mCacheDirectory + File.separator + "mraid.js";
                try {
                    new FileInputStream(new File(str2));
                    return new WebResourceResponse("text/javascript", "UTF-8", getClass().getResourceAsStream(str2));
                } catch (FileNotFoundException unused2) {
                }
            }
            return super.shouldInterceptRequest(webView, str);
        }
    }

    private class ChromeClient extends WebChromeClient {
        private ChromeClient() {
        }

        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            WebView webView2 = new WebView(webView.getContext());
            webView2.setWebChromeClient(this);
            webView2.setWebViewClient(new FrameBustWebViewClient());
            ((WebView.WebViewTransport) message.obj).setWebView(webView2);
            message.sendToTarget();
            Logger.i("onCreateWindow", "onCreateWindow");
            return true;
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            Logger.i("MyApplication", consoleMessage.message() + " -- From line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
            return true;
        }

        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            Logger.i("Test", "onShowCustomView");
            WebController.this.setVisibility(8);
            if (WebController.this.mCustomView != null) {
                Logger.i("Test", "mCustomView != null");
                customViewCallback.onCustomViewHidden();
                return;
            }
            Logger.i("Test", "mCustomView == null");
            WebController.this.mCustomViewContainer.addView(view);
            WebController.this.mCustomView = view;
            WebController.this.mCustomViewCallback = customViewCallback;
            WebController.this.mCustomViewContainer.setVisibility(0);
        }

        public View getVideoLoadingProgressView() {
            FrameLayout frameLayout = new FrameLayout(WebController.this.getCurrentActivityContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            return frameLayout;
        }

        public void onHideCustomView() {
            Logger.i("Test", "onHideCustomView");
            if (WebController.this.mCustomView != null) {
                WebController.this.mCustomView.setVisibility(8);
                WebController.this.mCustomViewContainer.removeView(WebController.this.mCustomView);
                WebController.this.mCustomView = null;
                WebController.this.mCustomViewContainer.setVisibility(8);
                WebController.this.mCustomViewCallback.onCustomViewHidden();
                WebController.this.setVisibility(0);
            }
        }
    }

    private class FrameBustWebViewClient extends WebViewClient {
        private FrameBustWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Context currentActivityContext = WebController.this.getCurrentActivityContext();
            Intent intent = new Intent(currentActivityContext, OpenUrlActivity.class);
            intent.putExtra(WebController.EXTERNAL_URL, str);
            intent.putExtra(WebController.SECONDARY_WEB_VIEW, false);
            currentActivityContext.startActivity(intent);
            return true;
        }
    }

    public class NativeAPI {
        public NativeAPI() {
        }

        @JavascriptInterface
        public void removeMessagingInterface(String str) {
            WebController.this.runOnUiThread(new Runnable() {
                /* class com.ironsource.sdk.controller.WebController.NativeAPI.AnonymousClass1 */

                public void run() {
                    WebController.this.removeJavascriptInterface(Constants.JAVASCRIPT_INTERFACE_NAME_GENERATE_TOKEN);
                }
            });
        }

        @JavascriptInterface
        public void initController(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "initController(" + str + ")");
            SSAObj sSAObj = new SSAObj(str);
            if (WebController.this.mLoadControllerTimer != null) {
                WebController.this.mLoadControllerTimer.cancel();
                WebController.this.mLoadControllerTimer = null;
            }
            if (sSAObj.containsKey(Constants.ParametersKeys.STAGE)) {
                String string = sSAObj.getString(Constants.ParametersKeys.STAGE);
                if (Constants.ParametersKeys.READY.equalsIgnoreCase(string)) {
                    WebController.this.mIsWebControllerReady = true;
                    WebController.this.mControllerListener.handleControllerReady();
                } else if (Constants.ParametersKeys.LOADED.equalsIgnoreCase(string)) {
                    WebController.this.mControllerListener.handleControllerLoaded();
                } else if (Constants.ParametersKeys.FAILED.equalsIgnoreCase(string)) {
                    String string2 = sSAObj.getString("errMsg");
                    ControllerEventListener controllerEventListener = WebController.this.mControllerListener;
                    controllerEventListener.handleControllerFailed("controller js failed to initialize : " + string2);
                } else {
                    Logger.i(WebController.this.TAG, "No STAGE mentioned! should not get here!");
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0051, code lost:
            if (android.text.TextUtils.isEmpty(r0) == false) goto L_0x0055;
         */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x005b  */
        /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
        @android.webkit.JavascriptInterface
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void getDeviceStatus(java.lang.String r5) {
            /*
            // Method dump skipped, instructions count: 107
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.WebController.NativeAPI.getDeviceStatus(java.lang.String):void");
        }

        @JavascriptInterface
        public void getConnectivityInfo(String str) {
            String str2;
            String str3 = WebController.this.TAG;
            Logger.i(str3, "getConnectivityInfo(" + str + ")");
            SSAObj sSAObj = new SSAObj(str);
            String string = sSAObj.getString(WebController.JSON_KEY_SUCCESS);
            String string2 = sSAObj.getString(WebController.JSON_KEY_FAIL);
            JSONObject jSONObject = new JSONObject();
            if (WebController.this.mConnectivityAdapter != null) {
                jSONObject = WebController.this.mConnectivityAdapter.getConnectivityData(WebController.this.getContext());
            }
            if (jSONObject.length() > 0) {
                str2 = WebController.this.generateJSToInject(string, jSONObject.toString());
            } else {
                str2 = WebController.this.generateJSToInject(string2, WebController.this.parseToJson("errMsg", Constants.ErrorCodes.FAILED_TO_RETRIEVE_CONNECTION_INFO, null, null, null, null, null, null, null, false));
            }
            WebController.this.injectJavascript(str2);
        }

        @JavascriptInterface
        public void setMixedContentAlwaysAllow(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "setMixedContentAlwaysAllow(" + str + ")");
            WebController.this.runOnUiThread(new Runnable() {
                /* class com.ironsource.sdk.controller.WebController.NativeAPI.AnonymousClass2 */

                public void run() {
                    if (Build.VERSION.SDK_INT >= 21) {
                        WebController.this.getSettings().setMixedContentMode(0);
                    }
                }
            });
        }

        @JavascriptInterface
        public void getControllerConfig(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "getControllerConfig(" + str + ")");
            String string = new SSAObj(str).getString(WebController.JSON_KEY_SUCCESS);
            if (!TextUtils.isEmpty(string)) {
                JSONObject controllerConfigAsJSONObject = SDKUtils.getControllerConfigAsJSONObject();
                extendControllerConfig(controllerConfigAsJSONObject);
                WebController.this.injectJavascript(WebController.this.generateJSToInject(string, controllerConfigAsJSONObject.toString()));
            }
        }

        private void extendControllerConfig(JSONObject jSONObject) {
            addSupportedNativeFeaturesToConfig(jSONObject);
            addTesterParametersToConfig(jSONObject, SDKUtils.getTesterParameters());
        }

        private void addSupportedNativeFeaturesToConfig(JSONObject jSONObject) {
            try {
                FeaturesManager instance = FeaturesManager.getInstance();
                if (!instance.getSupportedFeatures().isEmpty()) {
                    jSONObject.put(Constants.ControllerConfigurationKeys.NATIVE_FEATURES_KEY, new JSONArray((Collection) instance.getSupportedFeatures()));
                }
            } catch (Exception e) {
                ISNEventsTracker.logEvent(SDK5Events.appendNativeFeaturesDataFailed, new ISNEventParams().addPair(Events.CALL_FAILED_REASON, e.getMessage()).getData());
                Logger.d(WebController.this.TAG, "getControllerConfig Error while adding supported features data from FeaturesManager");
            }
        }

        private void addTesterParametersToConfig(JSONObject jSONObject, String str) {
            if (areTesterParametersValid(str)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str);
                    jSONObject.putOpt("testerABGroup", jSONObject2.get("testerABGroup"));
                    jSONObject.putOpt("testFriendlyName", jSONObject2.get("testFriendlyName"));
                } catch (JSONException unused) {
                    Logger.d(WebController.this.TAG, "getControllerConfig Error while parsing Tester AB Group parameters");
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean areTesterParametersValid(String str) {
            if (TextUtils.isEmpty(str) || str.contains("-1")) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getString("testerABGroup").isEmpty() || jSONObject.getString("testFriendlyName").isEmpty()) {
                    return false;
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x005c, code lost:
            if (android.text.TextUtils.isEmpty(r0) == false) goto L_0x0060;
         */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x0066  */
        /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
        @android.webkit.JavascriptInterface
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void getApplicationInfo(java.lang.String r5) {
            /*
            // Method dump skipped, instructions count: 118
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.WebController.NativeAPI.getApplicationInfo(java.lang.String):void");
        }

        @JavascriptInterface
        public void saveFile(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "saveFile(" + str + ")");
            SSAFile sSAFile = new SSAFile(str);
            if (DeviceStatus.getAvailableMemorySizeInMegaBytes(WebController.this.mCacheDirectory) <= 0) {
                WebController.this.responseBack(str, false, DownloadManager.NO_DISK_SPACE, null);
            } else if (!SDKUtils.isExternalStorageAvailable()) {
                WebController.this.responseBack(str, false, DownloadManager.STORAGE_UNAVAILABLE, null);
            } else if (IronSourceStorageUtils.isFileCached(WebController.this.mCacheDirectory, sSAFile)) {
                WebController.this.responseBack(str, false, DownloadManager.FILE_ALREADY_EXIST, null);
            } else if (!ConnectivityService.isConnected(WebController.this.getContext())) {
                WebController.this.responseBack(str, false, DownloadManager.NO_NETWORK_CONNECTION, null);
            } else {
                WebController.this.responseBack(str, true, null, null);
                String lastUpdateTime = sSAFile.getLastUpdateTime();
                if (lastUpdateTime != null) {
                    String valueOf = String.valueOf(lastUpdateTime);
                    if (!TextUtils.isEmpty(valueOf)) {
                        String path = sSAFile.getPath();
                        if (path.contains("/")) {
                            String[] split = sSAFile.getPath().split("/");
                            path = split[split.length - 1];
                        }
                        IronSourceSharedPrefHelper.getSupersonicPrefHelper().setCampaignLastUpdate(path, valueOf);
                    }
                }
                WebController.this.downloadManager.downloadFile(sSAFile);
            }
        }

        @JavascriptInterface
        public void adUnitsReady(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "adUnitsReady(" + str + ")");
            final String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(new SSAObj(str));
            final AdUnitsReady adUnitsReady = new AdUnitsReady(str);
            if (!adUnitsReady.isNumOfAdUnitsExist()) {
                WebController.this.responseBack(str, false, Constants.ErrorCodes.NUM_OF_AD_UNITS_DO_NOT_EXIST, null);
                return;
            }
            WebController.this.responseBack(str, true, null, null);
            String productType = adUnitsReady.getProductType();
            if (ISNEnums.ProductType.RewardedVideo.toString().equalsIgnoreCase(productType) && WebController.this.shouldNotifyDeveloper(productType)) {
                WebController.this.runOnUiThread(new Runnable() {
                    /* class com.ironsource.sdk.controller.WebController.NativeAPI.AnonymousClass3 */

                    public void run() {
                        if (Integer.parseInt(adUnitsReady.getNumOfAdUnits()) > 0) {
                            Log.d(WebController.this.TAG, "onRVInitSuccess()");
                            WebController.this.mDSRewardedVideoListener.onAdProductInitSuccess(ISNEnums.ProductType.RewardedVideo, fetchDemandSourceId, adUnitsReady);
                            return;
                        }
                        WebController.this.mDSRewardedVideoListener.onRVNoMoreOffers(fetchDemandSourceId);
                    }
                });
            }
        }

        @JavascriptInterface
        public void iabTokenAPI(String str) {
            try {
                String str2 = WebController.this.TAG;
                Logger.i(str2, "iabTokenAPI(" + str + ")");
                WebController.this.mTokenJSAdapter.call(new SSAObj(str).toString(), new JSCallbackTask());
            } catch (Exception e) {
                e.printStackTrace();
                String str3 = WebController.this.TAG;
                Logger.i(str3, "iabTokenAPI failed with exception " + e.getMessage());
            }
        }

        @JavascriptInterface
        public void deleteFolder(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "deleteFolder(" + str + ")");
            SSAFile sSAFile = new SSAFile(str);
            if (!IronSourceStorageUtils.isPathExist(WebController.this.mCacheDirectory, sSAFile.getPath())) {
                WebController.this.responseBack(str, false, Constants.ErrorCodes.FOLDER_NOT_EXIST_MSG, "1");
                return;
            }
            WebController.this.responseBack(str, IronSourceStorageUtils.deleteFolder(WebController.this.mCacheDirectory, sSAFile.getPath()), null, null);
        }

        @JavascriptInterface
        public void deleteFile(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "deleteFile(" + str + ")");
            SSAFile sSAFile = new SSAFile(str);
            if (!IronSourceStorageUtils.isPathExist(WebController.this.mCacheDirectory, sSAFile.getPath())) {
                WebController.this.responseBack(str, false, Constants.ErrorCodes.FILE_NOT_EXIST_MSG, "1");
                return;
            }
            WebController.this.responseBack(str, IronSourceStorageUtils.deleteFile(WebController.this.mCacheDirectory, sSAFile.getPath(), sSAFile.getFile()), null, null);
        }

        @JavascriptInterface
        public void displayWebView(String str) {
            Intent intent;
            String str2 = WebController.this.TAG;
            Logger.i(str2, "displayWebView(" + str + ")");
            WebController.this.responseBack(str, true, null, null);
            SSAObj sSAObj = new SSAObj(str);
            boolean booleanValue = ((Boolean) sSAObj.get("display")).booleanValue();
            String string = sSAObj.getString(Constants.ParametersKeys.PRODUCT_TYPE);
            boolean z = sSAObj.getBoolean(Constants.ParametersKeys.IS_STANDALONE_VIEW);
            String string2 = sSAObj.getString(Constants.ParametersKeys.AD_VIEW_ID);
            String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(sSAObj);
            if (booleanValue) {
                WebController.this.mIsImmersive = sSAObj.getBoolean(Constants.ParametersKeys.IMMERSIVE);
                boolean z2 = sSAObj.getBoolean(Constants.ParametersKeys.ACTIVITY_THEME_TRANSLUCENT);
                if (WebController.this.getState() != State.Display) {
                    WebController.this.setState(State.Display);
                    String str3 = WebController.this.TAG;
                    Logger.i(str3, "State: " + WebController.this.mState);
                    Context currentActivityContext = WebController.this.getCurrentActivityContext();
                    String orientationState = WebController.this.getOrientationState();
                    int applicationRotation = DeviceStatus.getApplicationRotation(currentActivityContext);
                    if (z) {
                        ControllerView controllerView = new ControllerView(currentActivityContext);
                        controllerView.addView(WebController.this.mControllerLayout);
                        controllerView.showInterstitial(WebController.this);
                        return;
                    }
                    if (z2) {
                        intent = new Intent(currentActivityContext, InterstitialActivity.class);
                    } else {
                        intent = new Intent(currentActivityContext, ControllerActivity.class);
                    }
                    if (ISNEnums.ProductType.RewardedVideo.toString().equalsIgnoreCase(string)) {
                        if (Constants.ParametersKeys.ORIENTATION_APPLICATION.equals(orientationState)) {
                            orientationState = SDKUtils.translateRequestedOrientation(DeviceStatus.getActivityRequestedOrientation(currentActivityContext));
                        }
                        intent.putExtra(Constants.ParametersKeys.PRODUCT_TYPE, ISNEnums.ProductType.RewardedVideo.toString());
                        WebController.this.mSavedState.adOpened(ISNEnums.ProductType.RewardedVideo.ordinal());
                        WebController.this.mSavedState.setDisplayedDemandSourceId(fetchDemandSourceId);
                        if (WebController.this.shouldNotifyDeveloper(ISNEnums.ProductType.RewardedVideo.toString())) {
                            WebController.this.mDSRewardedVideoListener.onAdProductOpen(ISNEnums.ProductType.RewardedVideo, fetchDemandSourceId);
                        }
                    } else if (ISNEnums.ProductType.OfferWall.toString().equalsIgnoreCase(string)) {
                        intent.putExtra(Constants.ParametersKeys.PRODUCT_TYPE, ISNEnums.ProductType.OfferWall.toString());
                        WebController.this.mSavedState.adOpened(ISNEnums.ProductType.OfferWall.ordinal());
                    } else if (ISNEnums.ProductType.Interstitial.toString().equalsIgnoreCase(string)) {
                        if (Constants.ParametersKeys.ORIENTATION_APPLICATION.equals(orientationState)) {
                            orientationState = SDKUtils.translateRequestedOrientation(DeviceStatus.getActivityRequestedOrientation(currentActivityContext));
                        }
                        intent.putExtra(Constants.ParametersKeys.PRODUCT_TYPE, ISNEnums.ProductType.Interstitial.toString());
                    }
                    if (string2 != null) {
                        intent.putExtra(Constants.ParametersKeys.AD_VIEW_ID, string2);
                    }
                    intent.setFlags(536870912);
                    intent.putExtra(Constants.ParametersKeys.IMMERSIVE, WebController.this.mIsImmersive);
                    intent.putExtra(Constants.ParametersKeys.ORIENTATION_SET_FLAG, orientationState);
                    intent.putExtra(Constants.ParametersKeys.ROTATION_SET_FLAG, applicationRotation);
                    currentActivityContext.startActivity(intent);
                    return;
                }
                String str4 = WebController.this.TAG;
                Logger.i(str4, "State: " + WebController.this.mState);
                return;
            }
            WebController.this.setState(State.Gone);
            WebController.this.closeWebView();
        }

        @JavascriptInterface
        public void getOrientation(String str) {
            Context currentActivityContext = WebController.this.getCurrentActivityContext();
            if (currentActivityContext != null) {
                String extractSuccessFunctionToCall = WebController.this.extractSuccessFunctionToCall(str);
                String jSONObject = SDKUtils.getOrientation(currentActivityContext).toString();
                if (!TextUtils.isEmpty(extractSuccessFunctionToCall)) {
                    WebController.this.injectJavascript(WebController.this.generateJSToInject(extractSuccessFunctionToCall, jSONObject, Constants.JSMethods.ON_GET_ORIENTATION_SUCCESS, Constants.JSMethods.ON_GET_ORIENTATION_FAIL));
                }
            }
        }

        @JavascriptInterface
        public void setOrientation(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "setOrientation(" + str + ")");
            String string = new SSAObj(str).getString("orientation");
            WebController.this.setOrientationState(string);
            if (WebController.this.mChangeListener != null) {
                WebController.this.mChangeListener.onOrientationChanged(string, DeviceStatus.getApplicationRotation(WebController.this.getContext()));
            }
        }

        @JavascriptInterface
        public void getCachedFilesMap(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "getCachedFilesMap(" + str + ")");
            String extractSuccessFunctionToCall = WebController.this.extractSuccessFunctionToCall(str);
            if (!TextUtils.isEmpty(extractSuccessFunctionToCall)) {
                SSAObj sSAObj = new SSAObj(str);
                if (!sSAObj.containsKey("path")) {
                    WebController.this.responseBack(str, false, Constants.ErrorCodes.PATH_KEY_DOES_NOT_EXIST, null);
                    return;
                }
                String str3 = (String) sSAObj.get("path");
                if (!IronSourceStorageUtils.isPathExist(WebController.this.mCacheDirectory, str3)) {
                    WebController.this.responseBack(str, false, Constants.ErrorCodes.PATH_FILE_DOES_NOT_EXIST_ON_DISK, null);
                    return;
                }
                WebController.this.injectJavascript(WebController.this.generateJSToInject(extractSuccessFunctionToCall, IronSourceStorageUtils.getCachedFilesMap(WebController.this.mCacheDirectory, str3), Constants.JSMethods.ON_GET_CACHED_FILES_MAP_SUCCESS, Constants.JSMethods.ON_GET_CACHED_FILES_MAP_FAIL));
            }
        }

        private void callJavaScriptFunction(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                WebController.this.injectJavascript(WebController.this.generateJSToInject(str, str2));
            }
        }

        @JavascriptInterface
        public void getDemandSourceState(String str) {
            String str2;
            String str3 = WebController.this.TAG;
            Logger.i(str3, "getMediationState(" + str + ")");
            SSAObj sSAObj = new SSAObj(str);
            String string = sSAObj.getString("demandSourceName");
            String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(sSAObj);
            String string2 = sSAObj.getString(Constants.ParametersKeys.PRODUCT_TYPE);
            if (string2 != null && string != null) {
                try {
                    ISNEnums.ProductType productType = SDKUtils.getProductType(string2);
                    if (productType != null) {
                        DemandSource demandSourceById = WebController.this.mDemandSourceManager.getDemandSourceById(productType, fetchDemandSourceId);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(Constants.ParametersKeys.PRODUCT_TYPE, string2);
                        jSONObject.put("demandSourceName", string);
                        jSONObject.put("demandSourceId", fetchDemandSourceId);
                        if (demandSourceById == null || demandSourceById.isMediationState(-1)) {
                            str2 = WebController.this.extractFailFunctionToCall(str);
                        } else {
                            str2 = WebController.this.extractSuccessFunctionToCall(str);
                            jSONObject.put("state", demandSourceById.getMediationState());
                        }
                        callJavaScriptFunction(str2, jSONObject.toString());
                    }
                } catch (Exception e) {
                    WebController.this.responseBack(str, false, e.getMessage(), null);
                    e.printStackTrace();
                }
            }
        }

        @JavascriptInterface
        public void adCredited(final String str) {
            final String str2;
            final boolean z;
            final boolean z2;
            Log.d(WebController.this.PUB_TAG, "adCredited(" + str + ")");
            SSAObj sSAObj = new SSAObj(str);
            String string = sSAObj.getString(Constants.ParametersKeys.CREDITS);
            boolean z3 = false;
            final int parseInt = string != null ? Integer.parseInt(string) : 0;
            final String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(sSAObj);
            final String string2 = sSAObj.getString(Constants.ParametersKeys.PRODUCT_TYPE);
            if (TextUtils.isEmpty(string2)) {
                Log.d(WebController.this.PUB_TAG, "adCredited | product type is missing");
            }
            if (ISNEnums.ProductType.Interstitial.toString().equalsIgnoreCase(string2)) {
                handleAdCreditedOnInterstitial(fetchDemandSourceId, parseInt);
                return;
            }
            String string3 = sSAObj.getString(Constants.ParametersKeys.TOTAL);
            final int parseInt2 = string3 != null ? Integer.parseInt(string3) : 0;
            if (!ISNEnums.ProductType.OfferWall.toString().equalsIgnoreCase(string2)) {
                str2 = null;
                z2 = false;
                z = false;
            } else if (sSAObj.isNull("signature") || sSAObj.isNull("timestamp") || sSAObj.isNull("totalCreditsFlag")) {
                WebController.this.responseBack(str, false, "One of the keys are missing: signature/timestamp/totalCreditsFlag", null);
                return;
            } else {
                if (sSAObj.getString("signature").equalsIgnoreCase(SDKUtils.getMD5(string3 + WebController.this.mApplicationKey + WebController.this.mUserId))) {
                    z3 = true;
                } else {
                    WebController.this.responseBack(str, false, "Controller signature is not equal to SDK signature", null);
                }
                boolean z4 = sSAObj.getBoolean("totalCreditsFlag");
                str2 = sSAObj.getString("timestamp");
                z = z4;
                z2 = z3;
            }
            if (WebController.this.shouldNotifyDeveloper(string2)) {
                WebController.this.runOnUiThread(new Runnable() {
                    /* class com.ironsource.sdk.controller.WebController.NativeAPI.AnonymousClass4 */

                    public void run() {
                        if (string2.equalsIgnoreCase(ISNEnums.ProductType.RewardedVideo.toString())) {
                            WebController.this.mDSRewardedVideoListener.onRVAdCredited(fetchDemandSourceId, parseInt);
                        } else if (string2.equalsIgnoreCase(ISNEnums.ProductType.OfferWall.toString()) && z2 && WebController.this.mOnOfferWallListener.onOWAdCredited(parseInt, parseInt2, z) && !TextUtils.isEmpty(str2)) {
                            if (IronSourceSharedPrefHelper.getSupersonicPrefHelper().setLatestCompletionsTime(str2, WebController.this.mApplicationKey, WebController.this.mUserId)) {
                                WebController.this.responseBack(str, true, null, null);
                            } else {
                                WebController.this.responseBack(str, false, "Time Stamp could not be stored", null);
                            }
                        }
                    }
                });
            }
        }

        private void handleAdCreditedOnInterstitial(final String str, final int i) {
            DemandSource demandSourceById;
            if (WebController.this.shouldNotifyDeveloper(ISNEnums.ProductType.Interstitial.toString()) && (demandSourceById = WebController.this.mDemandSourceManager.getDemandSourceById(ISNEnums.ProductType.Interstitial, str)) != null && demandSourceById.isRewarded()) {
                WebController.this.runOnUiThread(new Runnable() {
                    /* class com.ironsource.sdk.controller.WebController.NativeAPI.AnonymousClass5 */

                    public void run() {
                        WebController.this.mDSInterstitialListener.onInterstitialAdRewarded(str, i);
                    }
                });
            }
        }

        @JavascriptInterface
        public void removeCloseEventHandler(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "removeCloseEventHandler(" + str + ")");
            if (WebController.this.mCloseEventTimer != null) {
                WebController.this.mCloseEventTimer.cancel();
            }
            WebController.this.isRemoveCloseEventHandler = true;
        }

        @JavascriptInterface
        public void onGetDeviceStatusSuccess(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "onGetDeviceStatusSuccess(" + str + ")");
            WebController.this.responseBack(str, true, null, null);
            WebController.this.toastingErrMsg(Constants.JSMethods.ON_GET_DEVICE_STATUS_SUCCESS, str);
        }

        @JavascriptInterface
        public void onGetDeviceStatusFail(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "onGetDeviceStatusFail(" + str + ")");
            WebController.this.responseBack(str, true, null, null);
            WebController.this.toastingErrMsg(Constants.JSMethods.ON_GET_DEVICE_STATUS_FAIL, str);
        }

        @JavascriptInterface
        public void onInitRewardedVideoFail(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "onInitRewardedVideoFail(" + str + ")");
            SSAObj sSAObj = new SSAObj(str);
            final String string = sSAObj.getString("errMsg");
            final String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(sSAObj);
            DemandSource demandSourceById = WebController.this.mDemandSourceManager.getDemandSourceById(ISNEnums.ProductType.RewardedVideo, fetchDemandSourceId);
            if (demandSourceById != null) {
                demandSourceById.setDemandSourceInitState(3);
            }
            if (WebController.this.shouldNotifyDeveloper(ISNEnums.ProductType.RewardedVideo.toString())) {
                WebController.this.runOnUiThread(new Runnable() {
                    /* class com.ironsource.sdk.controller.WebController.NativeAPI.AnonymousClass6 */

                    public void run() {
                        String str = string;
                        if (str == null) {
                            str = "We're sorry, some error occurred. we will investigate it";
                        }
                        String str2 = WebController.this.TAG;
                        Log.d(str2, "onRVInitFail(message:" + str + ")");
                        WebController.this.mDSRewardedVideoListener.onAdProductInitFailed(ISNEnums.ProductType.RewardedVideo, fetchDemandSourceId, str);
                    }
                });
            }
            WebController.this.responseBack(str, true, null, null);
            WebController.this.toastingErrMsg(Constants.JSMethods.ON_INIT_REWARDED_VIDEO_FAIL, str);
        }

        @JavascriptInterface
        public void onGetApplicationInfoSuccess(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "onGetApplicationInfoSuccess(" + str + ")");
            WebController.this.responseBack(str, true, null, null);
            WebController.this.toastingErrMsg(Constants.JSMethods.ON_GET_APPLICATION_INFO_SUCCESS, str);
        }

        @JavascriptInterface
        public void onGetApplicationInfoFail(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "onGetApplicationInfoFail(" + str + ")");
            WebController.this.responseBack(str, true, null, null);
            WebController.this.toastingErrMsg(Constants.JSMethods.ON_GET_APPLICATION_INFO_FAIL, str);
        }

        @JavascriptInterface
        public void onShowRewardedVideoSuccess(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "onShowRewardedVideoSuccess(" + str + ")");
            WebController.this.responseBack(str, true, null, null);
            WebController.this.toastingErrMsg(Constants.JSMethods.ON_SHOW_REWARDED_VIDEO_SUCCESS, str);
        }

        @JavascriptInterface
        public void onShowRewardedVideoFail(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "onShowRewardedVideoFail(" + str + ")");
            SSAObj sSAObj = new SSAObj(str);
            final String string = sSAObj.getString("errMsg");
            final String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(sSAObj);
            if (WebController.this.shouldNotifyDeveloper(ISNEnums.ProductType.RewardedVideo.toString())) {
                WebController.this.runOnUiThread(new Runnable() {
                    /* class com.ironsource.sdk.controller.WebController.NativeAPI.AnonymousClass7 */

                    public void run() {
                        String str = string;
                        if (str == null) {
                            str = "We're sorry, some error occurred. we will investigate it";
                        }
                        String str2 = WebController.this.TAG;
                        Log.d(str2, "onRVShowFail(message:" + string + ")");
                        WebController.this.mDSRewardedVideoListener.onRVShowFail(fetchDemandSourceId, str);
                    }
                });
            }
            WebController.this.responseBack(str, true, null, null);
            WebController.this.toastingErrMsg(Constants.JSMethods.ON_SHOW_REWARDED_VIDEO_FAIL, str);
        }

        @JavascriptInterface
        public void onGetCachedFilesMapSuccess(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "onGetCachedFilesMapSuccess(" + str + ")");
            WebController.this.responseBack(str, true, null, null);
            WebController.this.toastingErrMsg(Constants.JSMethods.ON_GET_CACHED_FILES_MAP_SUCCESS, str);
        }

        @JavascriptInterface
        public void onGetCachedFilesMapFail(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "onGetCachedFilesMapFail(" + str + ")");
            WebController.this.responseBack(str, true, null, null);
            WebController.this.toastingErrMsg(Constants.JSMethods.ON_GET_CACHED_FILES_MAP_FAIL, str);
        }

        @JavascriptInterface
        public void onShowOfferWallSuccess(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "onShowOfferWallSuccess(" + str + ")");
            WebController.this.mSavedState.adOpened(ISNEnums.ProductType.OfferWall.ordinal());
            final String valueFromJsonObject = SDKUtils.getValueFromJsonObject(str, "placementId");
            if (WebController.this.shouldNotifyDeveloper(ISNEnums.ProductType.OfferWall.toString())) {
                WebController.this.runOnUiThread(new Runnable() {
                    /* class com.ironsource.sdk.controller.WebController.NativeAPI.AnonymousClass8 */

                    public void run() {
                        WebController.this.mOnOfferWallListener.onOWShowSuccess(valueFromJsonObject);
                    }
                });
            }
            WebController.this.responseBack(str, true, null, null);
            WebController.this.toastingErrMsg(Constants.JSMethods.ON_SHOW_OFFER_WALL_SUCCESS, str);
        }

        @JavascriptInterface
        public void onShowOfferWallFail(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "onShowOfferWallFail(" + str + ")");
            final String string = new SSAObj(str).getString("errMsg");
            if (WebController.this.shouldNotifyDeveloper(ISNEnums.ProductType.OfferWall.toString())) {
                WebController.this.runOnUiThread(new Runnable() {
                    /* class com.ironsource.sdk.controller.WebController.NativeAPI.AnonymousClass9 */

                    public void run() {
                        String str = string;
                        if (str == null) {
                            str = "We're sorry, some error occurred. we will investigate it";
                        }
                        WebController.this.mOnOfferWallListener.onOWShowFail(str);
                    }
                });
            }
            WebController.this.responseBack(str, true, null, null);
            WebController.this.toastingErrMsg(Constants.JSMethods.ON_SHOW_OFFER_WALL_FAIL, str);
        }

        @JavascriptInterface
        public void onInitInterstitialSuccess(String str) {
            Logger.i(WebController.this.TAG, "onInitInterstitialSuccess()");
            WebController.this.toastingErrMsg(Constants.JSMethods.ON_INIT_INTERSTITIAL_SUCCESS, "true");
            final String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(new SSAObj(str));
            if (TextUtils.isEmpty(fetchDemandSourceId)) {
                Logger.i(WebController.this.TAG, "onInitInterstitialSuccess failed with no demand source");
            } else if (WebController.this.shouldNotifyDeveloper(ISNEnums.ProductType.Interstitial.toString())) {
                WebController.this.runOnUiThread(new Runnable() {
                    /* class com.ironsource.sdk.controller.WebController.NativeAPI.AnonymousClass10 */

                    public void run() {
                        Log.d(WebController.this.TAG, "onInterstitialInitSuccess()");
                        WebController.this.mDSInterstitialListener.onAdProductInitSuccess(ISNEnums.ProductType.Interstitial, fetchDemandSourceId, null);
                    }
                });
            }
        }

        @JavascriptInterface
        public void onInitInterstitialFail(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "onInitInterstitialFail(" + str + ")");
            SSAObj sSAObj = new SSAObj(str);
            final String string = sSAObj.getString("errMsg");
            final String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(sSAObj);
            if (TextUtils.isEmpty(fetchDemandSourceId)) {
                Logger.i(WebController.this.TAG, "onInitInterstitialSuccess failed with no demand source");
                return;
            }
            DemandSource demandSourceById = WebController.this.mDemandSourceManager.getDemandSourceById(ISNEnums.ProductType.Interstitial, fetchDemandSourceId);
            if (demandSourceById != null) {
                demandSourceById.setDemandSourceInitState(3);
            }
            if (WebController.this.shouldNotifyDeveloper(ISNEnums.ProductType.Interstitial.toString())) {
                WebController.this.runOnUiThread(new Runnable() {
                    /* class com.ironsource.sdk.controller.WebController.NativeAPI.AnonymousClass11 */

                    public void run() {
                        String str = string;
                        if (str == null) {
                            str = "We're sorry, some error occurred. we will investigate it";
                        }
                        String str2 = WebController.this.TAG;
                        Log.d(str2, "onInterstitialInitFail(message:" + str + ")");
                        WebController.this.mDSInterstitialListener.onAdProductInitFailed(ISNEnums.ProductType.Interstitial, fetchDemandSourceId, str);
                    }
                });
            }
            WebController.this.responseBack(str, true, null, null);
            WebController.this.toastingErrMsg(Constants.JSMethods.ON_INIT_INTERSTITIAL_FAIL, str);
        }

        @JavascriptInterface
        public void adClicked(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "adClicked(" + str + ")");
            SSAObj sSAObj = new SSAObj(str);
            String string = sSAObj.getString(Constants.ParametersKeys.PRODUCT_TYPE);
            final String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(sSAObj);
            if (!TextUtils.isEmpty(fetchDemandSourceId)) {
                final ISNEnums.ProductType stringProductTypeAsEnum = WebController.this.getStringProductTypeAsEnum(string);
                final DSAdProductListener adProductListenerByProductType = WebController.this.getAdProductListenerByProductType(stringProductTypeAsEnum);
                if (stringProductTypeAsEnum != null && adProductListenerByProductType != null) {
                    WebController.this.runOnUiThread(new Runnable() {
                        /* class com.ironsource.sdk.controller.WebController.NativeAPI.AnonymousClass12 */

                        public void run() {
                            adProductListenerByProductType.onAdProductClick(stringProductTypeAsEnum, fetchDemandSourceId);
                        }
                    });
                }
            }
        }

        @JavascriptInterface
        public void onShowInterstitialSuccess(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "onShowInterstitialSuccess(" + str + ")");
            WebController.this.responseBack(str, true, null, null);
            final String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(new SSAObj(str));
            if (TextUtils.isEmpty(fetchDemandSourceId)) {
                Logger.i(WebController.this.TAG, "onShowInterstitialSuccess called with no demand");
                return;
            }
            WebController.this.mSavedState.adOpened(ISNEnums.ProductType.Interstitial.ordinal());
            WebController.this.mSavedState.setDisplayedDemandSourceId(fetchDemandSourceId);
            if (WebController.this.shouldNotifyDeveloper(ISNEnums.ProductType.Interstitial.toString())) {
                WebController.this.runOnUiThread(new Runnable() {
                    /* class com.ironsource.sdk.controller.WebController.NativeAPI.AnonymousClass13 */

                    public void run() {
                        WebController.this.mDSInterstitialListener.onAdProductOpen(ISNEnums.ProductType.Interstitial, fetchDemandSourceId);
                        WebController.this.mDSInterstitialListener.onInterstitialShowSuccess(fetchDemandSourceId);
                    }
                });
                WebController.this.toastingErrMsg(Constants.JSMethods.ON_SHOW_INTERSTITIAL_SUCCESS, str);
            }
            setInterstitialAvailability(fetchDemandSourceId, false);
        }

        private void setInterstitialAvailability(String str, boolean z) {
            DemandSource demandSourceById = WebController.this.mDemandSourceManager.getDemandSourceById(ISNEnums.ProductType.Interstitial, str);
            if (demandSourceById != null) {
                demandSourceById.setAvailabilityState(z);
            }
        }

        @JavascriptInterface
        public void onInitOfferWallSuccess(String str) {
            WebController.this.toastingErrMsg(Constants.JSMethods.ON_INIT_OFFERWALL_SUCCESS, "true");
            WebController.this.mSavedState.setOfferwallInitSuccess(true);
            if (WebController.this.mSavedState.reportInitOfferwall()) {
                WebController.this.mSavedState.setOfferwallReportInit(false);
                if (WebController.this.shouldNotifyDeveloper(ISNEnums.ProductType.OfferWall.toString())) {
                    WebController.this.runOnUiThread(new Runnable() {
                        /* class com.ironsource.sdk.controller.WebController.NativeAPI.AnonymousClass14 */

                        public void run() {
                            Log.d(WebController.this.TAG, "onOfferWallInitSuccess()");
                            WebController.this.mOnOfferWallListener.onOfferwallInitSuccess();
                        }
                    });
                }
            }
        }

        @JavascriptInterface
        public void onInitOfferWallFail(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "onInitOfferWallFail(" + str + ")");
            WebController.this.mSavedState.setOfferwallInitSuccess(false);
            final String string = new SSAObj(str).getString("errMsg");
            if (WebController.this.mSavedState.reportInitOfferwall()) {
                WebController.this.mSavedState.setOfferwallReportInit(false);
                if (WebController.this.shouldNotifyDeveloper(ISNEnums.ProductType.OfferWall.toString())) {
                    WebController.this.runOnUiThread(new Runnable() {
                        /* class com.ironsource.sdk.controller.WebController.NativeAPI.AnonymousClass15 */

                        public void run() {
                            String str = string;
                            if (str == null) {
                                str = "We're sorry, some error occurred. we will investigate it";
                            }
                            String str2 = WebController.this.TAG;
                            Log.d(str2, "onOfferWallInitFail(message:" + str + ")");
                            WebController.this.mOnOfferWallListener.onOfferwallInitFail(str);
                        }
                    });
                }
            }
            WebController.this.responseBack(str, true, null, null);
            WebController.this.toastingErrMsg(Constants.JSMethods.ON_INIT_OFFERWALL_FAIL, str);
        }

        @JavascriptInterface
        public void onLoadInterstitialSuccess(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "onLoadInterstitialSuccess(" + str + ")");
            final String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(new SSAObj(str));
            setInterstitialAvailability(fetchDemandSourceId, true);
            WebController.this.responseBack(str, true, null, null);
            if (WebController.this.shouldNotifyDeveloper(ISNEnums.ProductType.Interstitial.toString())) {
                WebController.this.runOnUiThread(new Runnable() {
                    /* class com.ironsource.sdk.controller.WebController.NativeAPI.AnonymousClass16 */

                    public void run() {
                        WebController.this.mDSInterstitialListener.onInterstitialLoadSuccess(fetchDemandSourceId);
                    }
                });
            }
            WebController.this.toastingErrMsg(Constants.JSMethods.ON_LOAD_INTERSTITIAL_SUCCESS, "true");
        }

        @JavascriptInterface
        public void onLoadInterstitialFail(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "onLoadInterstitialFail(" + str + ")");
            SSAObj sSAObj = new SSAObj(str);
            final String string = sSAObj.getString("errMsg");
            final String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(sSAObj);
            WebController.this.responseBack(str, true, null, null);
            if (!TextUtils.isEmpty(fetchDemandSourceId)) {
                setInterstitialAvailability(fetchDemandSourceId, false);
                if (WebController.this.shouldNotifyDeveloper(ISNEnums.ProductType.Interstitial.toString())) {
                    WebController.this.runOnUiThread(new Runnable() {
                        /* class com.ironsource.sdk.controller.WebController.NativeAPI.AnonymousClass17 */

                        public void run() {
                            String str = string;
                            if (str == null) {
                                str = "We're sorry, some error occurred. we will investigate it";
                            }
                            WebController.this.mDSInterstitialListener.onInterstitialLoadFailed(fetchDemandSourceId, str);
                        }
                    });
                }
                WebController.this.toastingErrMsg(Constants.JSMethods.ON_LOAD_INTERSTITIAL_FAIL, "true");
            }
        }

        @JavascriptInterface
        public void onShowInterstitialFail(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "onShowInterstitialFail(" + str + ")");
            SSAObj sSAObj = new SSAObj(str);
            final String string = sSAObj.getString("errMsg");
            final String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(sSAObj);
            WebController.this.responseBack(str, true, null, null);
            if (!TextUtils.isEmpty(fetchDemandSourceId)) {
                setInterstitialAvailability(fetchDemandSourceId, false);
                if (WebController.this.shouldNotifyDeveloper(ISNEnums.ProductType.Interstitial.toString())) {
                    WebController.this.runOnUiThread(new Runnable() {
                        /* class com.ironsource.sdk.controller.WebController.NativeAPI.AnonymousClass18 */

                        public void run() {
                            String str = string;
                            if (str == null) {
                                str = "We're sorry, some error occurred. we will investigate it";
                            }
                            WebController.this.mDSInterstitialListener.onInterstitialShowFailed(fetchDemandSourceId, str);
                        }
                    });
                }
                WebController.this.toastingErrMsg(Constants.JSMethods.ON_SHOW_INTERSTITIAL_FAIL, str);
            }
        }

        @JavascriptInterface
        public void onInitBannerSuccess(String str) {
            Logger.i(WebController.this.TAG, "onInitBannerSuccess()");
            WebController.this.toastingErrMsg(Constants.JSMethods.ON_INIT_BANNER_SUCCESS, "true");
            final String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(new SSAObj(str));
            if (TextUtils.isEmpty(fetchDemandSourceId)) {
                Logger.i(WebController.this.TAG, "onInitBannerSuccess failed with no demand source");
            } else if (WebController.this.shouldNotifyDeveloper(ISNEnums.ProductType.Banner.toString())) {
                WebController.this.runOnUiThread(new Runnable() {
                    /* class com.ironsource.sdk.controller.WebController.NativeAPI.AnonymousClass19 */

                    public void run() {
                        Log.d(WebController.this.TAG, "onBannerInitSuccess()");
                        WebController.this.mDSBannerListener.onAdProductInitSuccess(ISNEnums.ProductType.Banner, fetchDemandSourceId, null);
                    }
                });
            }
        }

        @JavascriptInterface
        public void onInitBannerFail(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "onInitBannerFail(" + str + ")");
            SSAObj sSAObj = new SSAObj(str);
            final String string = sSAObj.getString("errMsg");
            final String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(sSAObj);
            if (TextUtils.isEmpty(fetchDemandSourceId)) {
                Logger.i(WebController.this.TAG, "onInitBannerFail failed with no demand source");
                return;
            }
            DemandSource demandSourceById = WebController.this.mDemandSourceManager.getDemandSourceById(ISNEnums.ProductType.Banner, fetchDemandSourceId);
            if (demandSourceById != null) {
                demandSourceById.setDemandSourceInitState(3);
            }
            if (WebController.this.shouldNotifyDeveloper(ISNEnums.ProductType.Banner.toString())) {
                WebController.this.runOnUiThread(new Runnable() {
                    /* class com.ironsource.sdk.controller.WebController.NativeAPI.AnonymousClass20 */

                    public void run() {
                        String str = string;
                        if (str == null) {
                            str = "We're sorry, some error occurred. we will investigate it";
                        }
                        String str2 = WebController.this.TAG;
                        Log.d(str2, "onBannerInitFail(message:" + str + ")");
                        WebController.this.mDSBannerListener.onAdProductInitFailed(ISNEnums.ProductType.Banner, fetchDemandSourceId, str);
                    }
                });
            }
            WebController.this.responseBack(str, true, null, null);
            WebController.this.toastingErrMsg(Constants.JSMethods.ON_INIT_BANNER_FAIL, str);
        }

        @JavascriptInterface
        public void onLoadBannerSuccess(String str) {
            Logger.i(WebController.this.TAG, "onLoadBannerSuccess()");
            final String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(new SSAObj(str));
            WebController.this.responseBack(str, true, null, null);
            if (WebController.this.shouldNotifyDeveloper(ISNEnums.ProductType.Banner.toString())) {
                WebController.this.runOnUiThread(new Runnable() {
                    /* class com.ironsource.sdk.controller.WebController.NativeAPI.AnonymousClass21 */

                    public void run() {
                        Log.d(WebController.this.TAG, "onBannerLoadSuccess()");
                        WebController.this.mDSBannerListener.onBannerLoadSuccess(fetchDemandSourceId);
                    }
                });
            }
        }

        @JavascriptInterface
        public void onLoadBannerFail(String str) {
            Logger.i(WebController.this.TAG, "onLoadBannerFail()");
            SSAObj sSAObj = new SSAObj(str);
            final String string = sSAObj.getString("errMsg");
            final String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(sSAObj);
            WebController.this.responseBack(str, true, null, null);
            if (!TextUtils.isEmpty(fetchDemandSourceId) && WebController.this.shouldNotifyDeveloper(ISNEnums.ProductType.Banner.toString())) {
                WebController.this.runOnUiThread(new Runnable() {
                    /* class com.ironsource.sdk.controller.WebController.NativeAPI.AnonymousClass22 */

                    public void run() {
                        Log.d(WebController.this.TAG, "onLoadBannerFail()");
                        String str = string;
                        if (str == null) {
                            str = "We're sorry, some error occurred. we will investigate it";
                        }
                        WebController.this.mDSBannerListener.onBannerLoadFail(fetchDemandSourceId, str);
                    }
                });
            }
        }

        @JavascriptInterface
        public void openUrl(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "openUrl(" + str + ")");
            SSAObj sSAObj = new SSAObj(str);
            String string = sSAObj.getString("url");
            String string2 = sSAObj.getString("method");
            Context currentActivityContext = WebController.this.getCurrentActivityContext();
            try {
                if (string2.equalsIgnoreCase(Constants.ParametersKeys.EXTERNAL_BROWSER)) {
                    UrlHandler.openUrl(currentActivityContext, string);
                } else if (string2.equalsIgnoreCase(Constants.ParametersKeys.WEB_VIEW)) {
                    Intent intent = new Intent(currentActivityContext, OpenUrlActivity.class);
                    intent.putExtra(WebController.EXTERNAL_URL, string);
                    intent.putExtra(WebController.SECONDARY_WEB_VIEW, true);
                    intent.putExtra(Constants.ParametersKeys.IMMERSIVE, WebController.this.mIsImmersive);
                    currentActivityContext.startActivity(intent);
                } else if (string2.equalsIgnoreCase("store")) {
                    Intent intent2 = new Intent(currentActivityContext, OpenUrlActivity.class);
                    intent2.putExtra(WebController.EXTERNAL_URL, string);
                    intent2.putExtra(WebController.IS_STORE, true);
                    intent2.putExtra(WebController.SECONDARY_WEB_VIEW, true);
                    currentActivityContext.startActivity(intent2);
                }
            } catch (Exception e) {
                WebController.this.responseBack(str, false, e.getMessage(), null);
                e.printStackTrace();
            }
        }

        @JavascriptInterface
        public void setForceClose(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "setForceClose(" + str + ")");
            SSAObj sSAObj = new SSAObj(str);
            String string = sSAObj.getString("width");
            String string2 = sSAObj.getString("height");
            WebController.this.mHiddenForceCloseWidth = Integer.parseInt(string);
            WebController.this.mHiddenForceCloseHeight = Integer.parseInt(string2);
            WebController.this.mHiddenForceCloseLocation = sSAObj.getString("position");
        }

        @JavascriptInterface
        public void setBackButtonState(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "setBackButtonState(" + str + ")");
            IronSourceSharedPrefHelper.getSupersonicPrefHelper().setBackButtonState(new SSAObj(str).getString("state"));
        }

        @JavascriptInterface
        public void setStoreSearchKeys(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "setStoreSearchKeys(" + str + ")");
            IronSourceSharedPrefHelper.getSupersonicPrefHelper().setSearchKeys(str);
        }

        @JavascriptInterface
        public void setWebviewBackgroundColor(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "setWebviewBackgroundColor(" + str + ")");
            WebController.this.setWebviewBackground(str);
        }

        @JavascriptInterface
        public void onOfferWallGeneric(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "onOfferWallGeneric(" + str + ")");
        }

        @JavascriptInterface
        public void setUserData(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "setUserData(" + str + ")");
            SSAObj sSAObj = new SSAObj(str);
            if (!sSAObj.containsKey(Constants.ParametersKeys.KEY)) {
                WebController.this.responseBack(str, false, Constants.ErrorCodes.KEY_DOES_NOT_EXIST, null);
            } else if (!sSAObj.containsKey("value")) {
                WebController.this.responseBack(str, false, Constants.ErrorCodes.VALUE_DOES_NOT_EXIST, null);
            } else {
                String string = sSAObj.getString(Constants.ParametersKeys.KEY);
                String string2 = sSAObj.getString("value");
                if (IronSourceSharedPrefHelper.getSupersonicPrefHelper().setUserData(string, string2)) {
                    WebController.this.injectJavascript(WebController.this.generateJSToInject(WebController.this.extractSuccessFunctionToCall(str), WebController.this.parseToJson(string, string2, null, null, null, null, null, null, null, false)));
                    return;
                }
                WebController.this.responseBack(str, false, "SetUserData failed writing to shared preferences", null);
            }
        }

        @JavascriptInterface
        public void getUserData(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "getUserData(" + str + ")");
            SSAObj sSAObj = new SSAObj(str);
            if (!sSAObj.containsKey(Constants.ParametersKeys.KEY)) {
                WebController.this.responseBack(str, false, Constants.ErrorCodes.KEY_DOES_NOT_EXIST, null);
                return;
            }
            String extractSuccessFunctionToCall = WebController.this.extractSuccessFunctionToCall(str);
            String string = sSAObj.getString(Constants.ParametersKeys.KEY);
            WebController.this.injectJavascript(WebController.this.generateJSToInject(extractSuccessFunctionToCall, WebController.this.parseToJson(string, IronSourceSharedPrefHelper.getSupersonicPrefHelper().getUserData(string), null, null, null, null, null, null, null, false)));
        }

        @JavascriptInterface
        public void onGetUserCreditsFail(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "onGetUserCreditsFail(" + str + ")");
            final String string = new SSAObj(str).getString("errMsg");
            if (WebController.this.shouldNotifyDeveloper(ISNEnums.ProductType.OfferWall.toString())) {
                WebController.this.runOnUiThread(new Runnable() {
                    /* class com.ironsource.sdk.controller.WebController.NativeAPI.AnonymousClass23 */

                    public void run() {
                        String str = string;
                        if (str == null) {
                            str = "We're sorry, some error occurred. we will investigate it";
                        }
                        WebController.this.mOnOfferWallListener.onGetOWCreditsFailed(str);
                    }
                });
            }
            WebController.this.responseBack(str, true, null, null);
            WebController.this.toastingErrMsg(Constants.JSMethods.ON_GET_USER_CREDITS_FAILED, str);
        }

        @JavascriptInterface
        public void onAdWindowsClosed(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "onAdWindowsClosed(" + str + ")");
            WebController.this.mSavedState.adClosed();
            WebController.this.mSavedState.setDisplayedDemandSourceId(null);
            SSAObj sSAObj = new SSAObj(str);
            String string = sSAObj.getString(Constants.ParametersKeys.PRODUCT_TYPE);
            final String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(sSAObj);
            final ISNEnums.ProductType stringProductTypeAsEnum = WebController.this.getStringProductTypeAsEnum(string);
            String str3 = WebController.this.PUB_TAG;
            Log.d(str3, "onAdClosed() with type " + stringProductTypeAsEnum);
            if (WebController.this.shouldNotifyDeveloper(string)) {
                WebController.this.runOnUiThread(new Runnable() {
                    /* class com.ironsource.sdk.controller.WebController.NativeAPI.AnonymousClass24 */

                    public void run() {
                        if (stringProductTypeAsEnum == ISNEnums.ProductType.RewardedVideo || stringProductTypeAsEnum == ISNEnums.ProductType.Interstitial) {
                            DSAdProductListener adProductListenerByProductType = WebController.this.getAdProductListenerByProductType(stringProductTypeAsEnum);
                            if (adProductListenerByProductType != null) {
                                adProductListenerByProductType.onAdProductClose(stringProductTypeAsEnum, fetchDemandSourceId);
                            }
                        } else if (stringProductTypeAsEnum == ISNEnums.ProductType.OfferWall) {
                            WebController.this.mOnOfferWallListener.onOWAdClosed();
                        }
                    }
                });
            }
        }

        @JavascriptInterface
        public void onVideoStatusChanged(String str) {
            String str2 = WebController.this.TAG;
            Log.d(str2, "onVideoStatusChanged(" + str + ")");
            SSAObj sSAObj = new SSAObj(str);
            String string = sSAObj.getString(Constants.ParametersKeys.PRODUCT_TYPE);
            if (WebController.this.mVideoEventsListener != null && !TextUtils.isEmpty(string)) {
                String string2 = sSAObj.getString("status");
                if (Constants.ParametersKeys.VIDEO_STATUS_STARTED.equalsIgnoreCase(string2)) {
                    WebController.this.mVideoEventsListener.onVideoStarted();
                } else if ("paused".equalsIgnoreCase(string2)) {
                    WebController.this.mVideoEventsListener.onVideoPaused();
                } else if ("playing".equalsIgnoreCase(string2)) {
                    WebController.this.mVideoEventsListener.onVideoResumed();
                } else if (Constants.ParametersKeys.VIDEO_STATUS_ENDED.equalsIgnoreCase(string2)) {
                    WebController.this.mVideoEventsListener.onVideoEnded();
                } else if ("stopped".equalsIgnoreCase(string2)) {
                    WebController.this.mVideoEventsListener.onVideoStopped();
                } else {
                    String str3 = WebController.this.TAG;
                    Logger.i(str3, "onVideoStatusChanged: unknown status: " + string2);
                }
            }
        }

        @JavascriptInterface
        public void postAdEventNotification(String str) {
            try {
                String str2 = WebController.this.TAG;
                Logger.i(str2, "postAdEventNotification(" + str + ")");
                SSAObj sSAObj = new SSAObj(str);
                final String string = sSAObj.getString("eventName");
                if (TextUtils.isEmpty(string)) {
                    WebController.this.responseBack(str, false, Constants.ErrorCodes.EVENT_NAME_DOES_NOT_EXIST, null);
                    return;
                }
                String string2 = sSAObj.getString(Constants.ParametersKeys.NOTIFICATION_DEMAND_SOURCE_NAME);
                String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(sSAObj);
                final String str3 = !TextUtils.isEmpty(fetchDemandSourceId) ? fetchDemandSourceId : string2;
                final JSONObject jSONObject = (JSONObject) sSAObj.get(Constants.ParametersKeys.EXTRA_DATA);
                String string3 = sSAObj.getString(Constants.ParametersKeys.PRODUCT_TYPE);
                final ISNEnums.ProductType stringProductTypeAsEnum = WebController.this.getStringProductTypeAsEnum(string3);
                if (WebController.this.shouldNotifyDeveloper(string3)) {
                    String extractSuccessFunctionToCall = WebController.this.extractSuccessFunctionToCall(str);
                    if (!TextUtils.isEmpty(extractSuccessFunctionToCall)) {
                        WebController.this.injectJavascript(WebController.this.generateJSToInject(extractSuccessFunctionToCall, WebController.this.parseToJson(Constants.ParametersKeys.PRODUCT_TYPE, string3, "eventName", string, "demandSourceName", string2, "demandSourceId", str3, null, false), Constants.JSMethods.POST_AD_EVENT_NOTIFICATION_SUCCESS, Constants.JSMethods.POST_AD_EVENT_NOTIFICATION_FAIL));
                    }
                    WebController.this.runOnUiThread(new Runnable() {
                        /* class com.ironsource.sdk.controller.WebController.NativeAPI.AnonymousClass25 */

                        public void run() {
                            if (stringProductTypeAsEnum == ISNEnums.ProductType.Interstitial || stringProductTypeAsEnum == ISNEnums.ProductType.RewardedVideo) {
                                DSAdProductListener adProductListenerByProductType = WebController.this.getAdProductListenerByProductType(stringProductTypeAsEnum);
                                if (adProductListenerByProductType != null) {
                                    adProductListenerByProductType.onAdProductEventNotificationReceived(stringProductTypeAsEnum, str3, string, jSONObject);
                                }
                            } else if (stringProductTypeAsEnum == ISNEnums.ProductType.OfferWall) {
                                WebController.this.mOnOfferWallListener.onOfferwallEventNotificationReceived(string, jSONObject);
                            }
                        }
                    });
                    return;
                }
                WebController.this.responseBack(str, false, Constants.ErrorCodes.PRODUCT_TYPE_DOES_NOT_EXIST, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* access modifiers changed from: package-private */
        public void sendUnauthorizedError(String str) {
            WebController.this.injectJavascript(WebController.this.generateJSToInject(Constants.JSMethods.ON_UNAUTHORIZED_MESSAGE, str, null, null));
        }

        /* access modifiers changed from: package-private */
        public class JSCallbackTask {
            JSCallbackTask() {
            }

            /* access modifiers changed from: package-private */
            public void sendMessage(boolean z, String str, String str2) {
                SSAObj sSAObj = new SSAObj();
                sSAObj.put(z ? WebController.JSON_KEY_SUCCESS : WebController.JSON_KEY_FAIL, str);
                sSAObj.put("data", str2);
                WebController.this.responseBack(sSAObj.toString(), z, null, null);
            }

            /* access modifiers changed from: package-private */
            public void sendMessage(boolean z, String str, SSAObj sSAObj) {
                sSAObj.put(z ? WebController.JSON_KEY_SUCCESS : WebController.JSON_KEY_FAIL, str);
                WebController.this.responseBack(sSAObj.toString(), z, null, null);
            }

            /* access modifiers changed from: package-private */
            public void sendMessage(boolean z, String str, JSONObject jSONObject) {
                String str2;
                if (z) {
                    try {
                        str2 = WebController.JSON_KEY_SUCCESS;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        e.getMessage();
                        return;
                    }
                } else {
                    str2 = WebController.JSON_KEY_FAIL;
                }
                jSONObject.put(str2, str);
                WebController.this.responseBack(jSONObject.toString(), z, null, null);
            }
        }

        @JavascriptInterface
        public void bannerViewAPI(String str) {
            try {
                WebController.this.mBannerJsAdapter.sendMessageToISNAdView(str);
            } catch (Exception e) {
                e.printStackTrace();
                String str2 = WebController.this.TAG;
                Logger.e(str2, "bannerViewAPI failed with exception " + e.getMessage());
            }
        }

        @JavascriptInterface
        public void omidAPI(final String str) {
            WebController.this.runOnUiThread(new Runnable() {
                /* class com.ironsource.sdk.controller.WebController.NativeAPI.AnonymousClass26 */

                public void run() {
                    try {
                        String str = WebController.this.TAG;
                        Logger.i(str, "omidAPI(" + str + ")");
                        WebController.this.mOmidJsAdapter.call(new SSAObj(str).toString(), new JSCallbackTask(), WebController.this.getWebview());
                    } catch (Exception e) {
                        e.printStackTrace();
                        String str2 = WebController.this.TAG;
                        Logger.i(str2, "omidAPI failed with exception " + e.getMessage());
                    }
                }
            });
        }

        @JavascriptInterface
        public void permissionsAPI(String str) {
            try {
                String str2 = WebController.this.TAG;
                Logger.i(str2, "permissionsAPI(" + str + ")");
                WebController.this.mPermissionsJsAdapter.call(new SSAObj(str).toString(), new JSCallbackTask());
            } catch (Exception e) {
                e.printStackTrace();
                String str3 = WebController.this.TAG;
                Logger.i(str3, "permissionsAPI failed with exception " + e.getMessage());
            }
        }

        @JavascriptInterface
        public void deviceDataAPI(String str) {
            try {
                String str2 = WebController.this.TAG;
                Logger.i(str2, "deviceDataAPI(" + str + ")");
                WebController.this.mDeviceDataJsAdapter.call(new SSAObj(str).toString(), new JSCallbackTask());
            } catch (Exception e) {
                e.printStackTrace();
                String str3 = WebController.this.TAG;
                Logger.i(str3, "deviceDataAPI failed with exception " + e.getMessage());
            }
        }

        @JavascriptInterface
        public void adViewAPI(String str) {
            try {
                String str2 = WebController.this.TAG;
                Logger.i(str2, "adViewAPI(" + str + ")");
                WebController.this.mAdViewsJsAdapter.call(new SSAObj(str).toString(), new JSCallbackTask());
            } catch (Exception e) {
                e.printStackTrace();
                String str3 = WebController.this.TAG;
                Logger.i(str3, "adViewAPI failed with exception " + e.getMessage());
            }
        }

        @JavascriptInterface
        public void getDeviceVolume(String str) {
            String str2 = WebController.this.TAG;
            Logger.i(str2, "getDeviceVolume(" + str + ")");
            try {
                float deviceVolume = DeviceProperties.getInstance(WebController.this.getCurrentActivityContext()).getDeviceVolume(WebController.this.getCurrentActivityContext());
                SSAObj sSAObj = new SSAObj(str);
                sSAObj.put("deviceVolume", String.valueOf(deviceVolume));
                WebController.this.responseBack(sSAObj.toString(), true, null, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private DSAdProductListener getAdProductListenerByProductType(ISNEnums.ProductType productType) {
        if (productType == ISNEnums.ProductType.Interstitial) {
            return this.mDSInterstitialListener;
        }
        if (productType == ISNEnums.ProductType.RewardedVideo) {
            return this.mDSRewardedVideoListener;
        }
        if (productType == ISNEnums.ProductType.Banner) {
            return this.mDSBannerListener;
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ISNEnums.ProductType getStringProductTypeAsEnum(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equalsIgnoreCase(ISNEnums.ProductType.Interstitial.toString())) {
            return ISNEnums.ProductType.Interstitial;
        }
        if (str.equalsIgnoreCase(ISNEnums.ProductType.RewardedVideo.toString())) {
            return ISNEnums.ProductType.RewardedVideo;
        }
        if (str.equalsIgnoreCase(ISNEnums.ProductType.OfferWall.toString())) {
            return ISNEnums.ProductType.OfferWall;
        }
        if (str.equalsIgnoreCase(ISNEnums.ProductType.Banner.toString())) {
            return ISNEnums.ProductType.Banner;
        }
        return null;
    }

    public void setVideoEventsListener(VideoEventsListener videoEventsListener) {
        this.mVideoEventsListener = videoEventsListener;
    }

    public void removeVideoEventsListener() {
        this.mVideoEventsListener = null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setWebviewBackground(String str) {
        SSAObj sSAObj = new SSAObj(str);
        String string = sSAObj.getString("color");
        String string2 = sSAObj.getString(Constants.ParametersKeys.AD_VIEW_ID);
        int parseColor = !"transparent".equalsIgnoreCase(string) ? Color.parseColor(string) : 0;
        if (string2 != null) {
            WebView adViewById = AdViewsManager.getInstance().getAdViewById(string2);
            if (adViewById != null) {
                adViewById.setBackgroundColor(parseColor);
                return;
            }
            return;
        }
        setBackgroundColor(parseColor);
    }

    public void load(final int i) {
        try {
            loadUrl("about:blank");
        } catch (Throwable th) {
            Logger.e(this.TAG, "WebViewController:: load: " + th.toString());
        }
        String str = "file://" + this.mCacheDirectory + File.separator + Constants.MOBILE_CONTROLLER_HTML;
        if (new File(this.mCacheDirectory + File.separator + Constants.MOBILE_CONTROLLER_HTML).exists()) {
            JSONObject controllerConfigAsJSONObject = SDKUtils.getControllerConfigAsJSONObject();
            setWebDebuggingEnabled(controllerConfigAsJSONObject);
            String requestParameters = getRequestParameters(controllerConfigAsJSONObject);
            Map<String, String> initSDKParams = SDKUtils.getInitSDKParams();
            if (initSDKParams != null && initSDKParams.containsKey(Events.SESSION_ID)) {
                requestParameters = String.format("%s&sessionid=%s", requestParameters, initSDKParams.get(Events.SESSION_ID));
            }
            String str2 = str + "?" + requestParameters;
            this.mLoadControllerTimer = new CountDownTimer(50000, 1000) {
                /* class com.ironsource.sdk.controller.WebController.AnonymousClass3 */

                public void onTick(long j) {
                    String str = WebController.this.TAG;
                    Logger.i(str, "Loading Controller Timer Tick " + j);
                }

                public void onFinish() {
                    Logger.i(WebController.this.TAG, "Loading Controller Timer Finish");
                    int i = i;
                    if (i == 3) {
                        WebController.this.mControllerListener.handleControllerFailed(Constants.ErrorCodes.CONTROLLER_HTML_FAILED_TO_LOAD);
                    } else {
                        WebController.this.load(i + 1);
                    }
                }
            }.start();
            try {
                loadUrl(str2);
            } catch (Throwable th2) {
                Logger.e(this.TAG, "WebViewController:: load: " + th2.toString());
            }
            Logger.i(this.TAG, "load(): " + str2);
            return;
        }
        Logger.i(this.TAG, "load(): Mobile Controller HTML Does not exist");
    }

    private void setWebDebuggingEnabled(JSONObject jSONObject) {
        if (jSONObject.optBoolean("inspectWebview")) {
            setWebDebuggingEnabled();
        }
    }

    private void initProduct(String str, String str2, ISNEnums.ProductType productType, DemandSource demandSource, OnInitProductHandler onInitProductHandler) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            onInitProductHandler.handleInitProductFailed("User id or Application key are missing", productType, demandSource);
        } else {
            injectJavascript(createInitProductJSMethod(productType, demandSource).script);
        }
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void initRewardedVideo(String str, String str2, DemandSource demandSource, DSRewardedVideoListener dSRewardedVideoListener) {
        this.mApplicationKey = str;
        this.mUserId = str2;
        this.mDSRewardedVideoListener = dSRewardedVideoListener;
        this.mSavedState.setRVAppKey(str);
        this.mSavedState.setRVUserId(str2);
        initProduct(str, str2, ISNEnums.ProductType.RewardedVideo, demandSource, new OnInitProductHandler() {
            /* class com.ironsource.sdk.controller.WebController.AnonymousClass4 */

            @Override // com.ironsource.sdk.controller.WebController.OnInitProductHandler
            public void handleInitProductFailed(String str, ISNEnums.ProductType productType, DemandSource demandSource) {
                WebController.this.triggerOnControllerInitProductFail(str, productType, demandSource);
            }
        });
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void initInterstitial(String str, String str2, DemandSource demandSource, DSInterstitialListener dSInterstitialListener) {
        this.mApplicationKey = str;
        this.mUserId = str2;
        this.mDSInterstitialListener = dSInterstitialListener;
        this.mSavedState.setInterstitialAppKey(str);
        this.mSavedState.setInterstitialUserId(this.mUserId);
        initProduct(this.mApplicationKey, this.mUserId, ISNEnums.ProductType.Interstitial, demandSource, new OnInitProductHandler() {
            /* class com.ironsource.sdk.controller.WebController.AnonymousClass5 */

            @Override // com.ironsource.sdk.controller.WebController.OnInitProductHandler
            public void handleInitProductFailed(String str, ISNEnums.ProductType productType, DemandSource demandSource) {
                WebController.this.triggerOnControllerInitProductFail(str, productType, demandSource);
            }
        });
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void loadInterstitial(String str, DSInterstitialListener dSInterstitialListener) {
        HashMap hashMap = new HashMap();
        hashMap.put("demandSourceName", str);
        String flatMapToJsonAsString = SDKUtils.flatMapToJsonAsString(hashMap);
        this.mSavedState.setReportLoadInterstitial(str, true);
        injectJavascript(generateJSToInject(Constants.JSMethods.LOAD_INTERSTITIAL, flatMapToJsonAsString, Constants.JSMethods.ON_LOAD_INTERSTITIAL_SUCCESS, Constants.JSMethods.ON_LOAD_INTERSTITIAL_FAIL));
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void loadInterstitial(DemandSource demandSource, Map<String, String> map, DSInterstitialListener dSInterstitialListener) {
        handleLoadAd(demandSource, map);
    }

    private void handleLoadAd(DemandSource demandSource, Map<String, String> map) {
        Map<String, String> mergeHashMaps = SDKUtils.mergeHashMaps(new Map[]{map, demandSource.convertToMap()});
        this.mSavedState.setReportLoadInterstitial(demandSource.getId(), true);
        injectJavascript(generateJSToInject(Constants.JSMethods.LOAD_INTERSTITIAL, SDKUtils.flatMapToJsonAsString(mergeHashMaps), Constants.JSMethods.ON_LOAD_INTERSTITIAL_SUCCESS, Constants.JSMethods.ON_LOAD_INTERSTITIAL_FAIL));
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void showInterstitial(JSONObject jSONObject, DSInterstitialListener dSInterstitialListener) {
        injectJavascript(createShowProductJSMethod(ISNEnums.ProductType.Interstitial, jSONObject));
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void showInterstitial(DemandSource demandSource, Map<String, String> map, DSInterstitialListener dSInterstitialListener) {
        injectJavascript(createShowProductJSMethod(ISNEnums.ProductType.Interstitial, new JSONObject(SDKUtils.mergeHashMaps(new Map[]{map, demandSource.convertToMap()}))));
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public boolean isInterstitialAdAvailable(String str) {
        DemandSource demandSourceById = this.mDemandSourceManager.getDemandSourceById(ISNEnums.ProductType.Interstitial, str);
        return demandSourceById != null && demandSourceById.getAvailabilityState();
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public ISNEnums.ControllerType getType() {
        return ISNEnums.ControllerType.Web;
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void initOfferWall(String str, String str2, Map<String, String> map, OnOfferWallListener onOfferWallListener) {
        this.mApplicationKey = str;
        this.mUserId = str2;
        this.mOWExtraParameters = map;
        this.mOnOfferWallListener = onOfferWallListener;
        this.mSavedState.setOfferWallExtraParams(map);
        this.mSavedState.setOfferwallReportInit(true);
        initProduct(this.mApplicationKey, this.mUserId, ISNEnums.ProductType.OfferWall, null, new OnInitProductHandler() {
            /* class com.ironsource.sdk.controller.WebController.AnonymousClass6 */

            @Override // com.ironsource.sdk.controller.WebController.OnInitProductHandler
            public void handleInitProductFailed(String str, ISNEnums.ProductType productType, DemandSource demandSource) {
                WebController.this.triggerOnControllerInitProductFail(str, productType, demandSource);
            }
        });
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void showOfferWall(Map<String, String> map) {
        this.mOWExtraParameters = map;
        injectJavascript(generateJSToInject(Constants.JSMethods.SHOW_OFFER_WALL, Constants.JSMethods.ON_SHOW_OFFER_WALL_SUCCESS, Constants.JSMethods.ON_SHOW_OFFER_WALL_FAIL));
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void getOfferWallCredits(String str, String str2, OnOfferWallListener onOfferWallListener) {
        this.mApplicationKey = str;
        this.mUserId = str2;
        this.mOnOfferWallListener = onOfferWallListener;
        initProduct(str, str2, ISNEnums.ProductType.OfferWallCredits, null, new OnInitProductHandler() {
            /* class com.ironsource.sdk.controller.WebController.AnonymousClass7 */

            @Override // com.ironsource.sdk.controller.WebController.OnInitProductHandler
            public void handleInitProductFailed(String str, ISNEnums.ProductType productType, DemandSource demandSource) {
                WebController.this.triggerOnControllerInitProductFail(str, productType, demandSource);
            }
        });
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void initBanner(String str, String str2, DemandSource demandSource, DSBannerListener dSBannerListener) {
        this.mApplicationKey = str;
        this.mUserId = str2;
        this.mDSBannerListener = dSBannerListener;
        initProduct(str, str2, ISNEnums.ProductType.Banner, demandSource, new OnInitProductHandler() {
            /* class com.ironsource.sdk.controller.WebController.AnonymousClass8 */

            @Override // com.ironsource.sdk.controller.WebController.OnInitProductHandler
            public void handleInitProductFailed(String str, ISNEnums.ProductType productType, DemandSource demandSource) {
                WebController.this.triggerOnControllerInitProductFail(str, productType, demandSource);
            }
        });
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void loadBanner(JSONObject jSONObject, DSBannerListener dSBannerListener) {
        if (jSONObject != null) {
            injectJavascript(generateJSToInject(Constants.JSMethods.LOAD_BANNER, jSONObject.toString(), Constants.JSMethods.ON_LOAD_BANNER_SUCCESS, Constants.JSMethods.ON_LOAD_BANNER_FAIL));
        }
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void updateConsentInfo(JSONObject jSONObject) {
        injectJavascript(generateJSToInject(Constants.JSMethods.UPDATE_CONSENT_INFO, jSONObject != null ? jSONObject.toString() : null));
    }

    /* access modifiers changed from: package-private */
    public static class Result {
        String methodName;
        String script;

        Result() {
        }
    }

    private Result createInitProductJSMethod(ISNEnums.ProductType productType, DemandSource demandSource) {
        Result result = new Result();
        if (productType == ISNEnums.ProductType.RewardedVideo || productType == ISNEnums.ProductType.Interstitial || productType == ISNEnums.ProductType.OfferWall || productType == ISNEnums.ProductType.Banner) {
            HashMap hashMap = new HashMap();
            hashMap.put("applicationKey", this.mApplicationKey);
            hashMap.put("applicationUserId", this.mUserId);
            if (demandSource != null) {
                if (demandSource.getExtraParams() != null) {
                    hashMap.putAll(demandSource.getExtraParams());
                }
                hashMap.put("demandSourceName", demandSource.getDemandSourceName());
                hashMap.put("demandSourceId", demandSource.getId());
            }
            Map<String, String> extraParamsByProduct = getExtraParamsByProduct(productType);
            if (extraParamsByProduct != null) {
                hashMap.putAll(extraParamsByProduct);
            }
            String flatMapToJsonAsString = SDKUtils.flatMapToJsonAsString(hashMap);
            Constants.JSMethods initMethodByProduct = Constants.JSMethods.getInitMethodByProduct(productType);
            String generateJSToInject = generateJSToInject(initMethodByProduct.methodName, flatMapToJsonAsString, initMethodByProduct.successCallbackName, initMethodByProduct.failureCallbackName);
            result.methodName = initMethodByProduct.methodName;
            result.script = generateJSToInject;
        } else if (productType == ISNEnums.ProductType.OfferWallCredits) {
            String generateJSToInject2 = generateJSToInject(Constants.JSMethods.GET_USER_CREDITS, parseToJson(Constants.ParametersKeys.PRODUCT_TYPE, Constants.ParametersKeys.OFFER_WALL, "applicationKey", this.mApplicationKey, "applicationUserId", this.mUserId, null, null, null, false), "null", Constants.JSMethods.ON_GET_USER_CREDITS_FAILED);
            result.methodName = Constants.JSMethods.GET_USER_CREDITS;
            result.script = generateJSToInject2;
        }
        return result;
    }

    private String createShowProductJSMethod(ISNEnums.ProductType productType, JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        hashMap.put("sessionDepth", Integer.toString(jSONObject.optInt("sessionDepth")));
        String optString = jSONObject.optString("demandSourceName");
        String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(jSONObject);
        DemandSource demandSourceById = this.mDemandSourceManager.getDemandSourceById(productType, fetchDemandSourceId);
        if (demandSourceById != null) {
            if (demandSourceById.getExtraParams() != null) {
                hashMap.putAll(demandSourceById.getExtraParams());
            }
            if (!TextUtils.isEmpty(optString)) {
                hashMap.put("demandSourceName", optString);
            }
            if (!TextUtils.isEmpty(fetchDemandSourceId)) {
                hashMap.put("demandSourceId", fetchDemandSourceId);
            }
        }
        Map<String, String> extraParamsByProduct = getExtraParamsByProduct(productType);
        if (extraParamsByProduct != null) {
            hashMap.putAll(extraParamsByProduct);
        }
        String flatMapToJsonAsString = SDKUtils.flatMapToJsonAsString(hashMap);
        Constants.JSMethods showMethodByProduct = Constants.JSMethods.getShowMethodByProduct(productType);
        return generateJSToInject(showMethodByProduct.methodName, flatMapToJsonAsString, showMethodByProduct.successCallbackName, showMethodByProduct.failureCallbackName);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void triggerOnControllerInitProductFail(final String str, final ISNEnums.ProductType productType, final DemandSource demandSource) {
        if (shouldNotifyDeveloper(productType.toString())) {
            runOnUiThread(new Runnable() {
                /* class com.ironsource.sdk.controller.WebController.AnonymousClass9 */

                public void run() {
                    if (ISNEnums.ProductType.RewardedVideo == productType || ISNEnums.ProductType.Interstitial == productType || ISNEnums.ProductType.Banner == productType) {
                        DemandSource demandSource = demandSource;
                        if (demandSource != null && !TextUtils.isEmpty(demandSource.getId())) {
                            DSAdProductListener adProductListenerByProductType = WebController.this.getAdProductListenerByProductType(productType);
                            String str = WebController.this.TAG;
                            Log.d(str, "onAdProductInitFailed (message:" + str + ")(" + productType + ")");
                            if (adProductListenerByProductType != null) {
                                adProductListenerByProductType.onAdProductInitFailed(productType, demandSource.getId(), str);
                            }
                        }
                    } else if (ISNEnums.ProductType.OfferWall == productType) {
                        WebController.this.mOnOfferWallListener.onOfferwallInitFail(str);
                    } else if (ISNEnums.ProductType.OfferWallCredits == productType) {
                        WebController.this.mOnOfferWallListener.onGetOWCreditsFailed(str);
                    }
                }
            });
        }
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void showRewardedVideo(JSONObject jSONObject, DSRewardedVideoListener dSRewardedVideoListener) {
        injectJavascript(createShowProductJSMethod(ISNEnums.ProductType.RewardedVideo, jSONObject));
    }

    public void assetCached(String str, String str2) {
        injectJavascript(generateJSToInject(Constants.JSMethods.ASSET_CACHED, parseToJson("file", str, "path", str2, null, null, null, null, null, false)));
    }

    public void assetCachedFailed(String str, String str2, String str3) {
        injectJavascript(generateJSToInject(Constants.JSMethods.ASSET_CACHED_FAILED, parseToJson("file", str, "path", str2, "errMsg", str3, null, null, null, false)));
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void enterBackground() {
        injectJavascript(generateJSToInject(Constants.JSMethods.ENTER_BACKGROUND));
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void enterForeground() {
        injectJavascript(generateJSToInject(Constants.JSMethods.ENTER_FOREGROUND));
    }

    public void viewableChange(boolean z, String str) {
        injectJavascript(generateJSToInject(Constants.JSMethods.VIEWABLE_CHANGE, parseToJson(Constants.ParametersKeys.WEB_VIEW, str, null, null, null, null, null, null, Constants.ParametersKeys.IS_VIEWABLE, z)));
    }

    public void nativeNavigationPressed(String str) {
        injectJavascript(generateJSToInject(Constants.JSMethods.NATIVE_NAVIGATION_PRESSED, parseToJson("action", str, null, null, null, null, null, null, null, false)));
    }

    public void pageFinished() {
        injectJavascript(generateJSToInject(Constants.JSMethods.PAGE_FINISHED));
    }

    public void interceptedUrlToStore() {
        injectJavascript(generateJSToInject(Constants.JSMethods.INTERCEPTED_URL_TO_STORE));
    }

    public void failedToStartStoreActivity(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = Constants.ErrorCodes.STORE_ACTIVITY_FAILED_UNKNOWN_URL;
        }
        if (TextUtils.isEmpty(str)) {
            str = Constants.ErrorCodes.STORE_ACTIVITY_FAILED_REASON_UNSPECIFIED;
        }
        injectJavascript(generateJSToInject(Constants.JSMethods.FAILED_TO_START_STORE_ACTIVITY, parseToJson("errMsg", str, "url", str2, null, null, null, null, null, false)));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void injectJavascript(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = "console.log(\"JS exeption: \" + JSON.stringify(e));";
            if (getDebugMode() != ISNEnums.DebugMode.MODE_0.getValue() && (getDebugMode() < ISNEnums.DebugMode.MODE_1.getValue() || getDebugMode() > ISNEnums.DebugMode.MODE_3.getValue())) {
                str2 = "empty";
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("try{");
            sb.append(str);
            sb.append("}catch(e){");
            sb.append(str2);
            sb.append("}");
            final String str3 = "javascript:" + sb.toString();
            runOnUiThread(new Runnable() {
                /* class com.ironsource.sdk.controller.WebController.AnonymousClass10 */

                public void run() {
                    Logger.i(WebController.this.TAG, str3);
                    try {
                        if (WebController.this.isKitkatAndAbove != null) {
                            if (WebController.this.isKitkatAndAbove.booleanValue()) {
                                WebController.this.evaluateJavascriptKitKat(sb.toString());
                            } else {
                                WebController.this.loadUrl(str3);
                            }
                        } else if (Build.VERSION.SDK_INT >= 19) {
                            try {
                                WebController.this.evaluateJavascriptKitKat(sb.toString());
                                WebController.this.isKitkatAndAbove = true;
                            } catch (NoSuchMethodError e) {
                                String str = WebController.this.TAG;
                                Logger.e(str, "evaluateJavascrip NoSuchMethodError: SDK version=" + Build.VERSION.SDK_INT + " " + e);
                                WebController.this.loadUrl(str3);
                                WebController.this.isKitkatAndAbove = false;
                            } catch (Throwable th) {
                                String str2 = WebController.this.TAG;
                                Logger.e(str2, "evaluateJavascrip Exception: SDK version=" + Build.VERSION.SDK_INT + " " + th);
                                WebController.this.loadUrl(str3);
                                WebController.this.isKitkatAndAbove = false;
                            }
                        } else {
                            WebController.this.loadUrl(str3);
                            WebController.this.isKitkatAndAbove = false;
                        }
                    } catch (Throwable th2) {
                        String str3 = WebController.this.TAG;
                        Logger.e(str3, "injectJavascript: " + th2.toString());
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void evaluateJavascriptKitKat(String str) {
        evaluateJavascript(str, null);
    }

    public Context getCurrentActivityContext() {
        return this.mContextProvider.getCurrentActivityContext();
    }

    private String getRequestParameters(JSONObject jSONObject) {
        DeviceProperties instance = DeviceProperties.getInstance(getContext());
        StringBuilder sb = new StringBuilder();
        String supersonicSdkVersion = DeviceProperties.getSupersonicSdkVersion();
        if (!TextUtils.isEmpty(supersonicSdkVersion)) {
            sb.append("SDKVersion");
            sb.append(Constants.RequestParameters.EQUAL);
            sb.append(supersonicSdkVersion);
            sb.append(Constants.RequestParameters.AMPERSAND);
        }
        String deviceOsType = instance.getDeviceOsType();
        if (!TextUtils.isEmpty(deviceOsType)) {
            sb.append("deviceOs");
            sb.append(Constants.RequestParameters.EQUAL);
            sb.append(deviceOsType);
        }
        Uri parse = Uri.parse(SDKUtils.getControllerUrl());
        if (parse != null) {
            String str = parse.getScheme() + ":";
            String host = parse.getHost();
            int port = parse.getPort();
            if (port != -1) {
                host = host + ":" + port;
            }
            sb.append(Constants.RequestParameters.AMPERSAND);
            sb.append(Constants.RequestParameters.PROTOCOL);
            sb.append(Constants.RequestParameters.EQUAL);
            sb.append(str);
            sb.append(Constants.RequestParameters.AMPERSAND);
            sb.append(Constants.RequestParameters.DOMAIN);
            sb.append(Constants.RequestParameters.EQUAL);
            sb.append(host);
            if (jSONObject.keys().hasNext()) {
                try {
                    String jSONObject2 = new JSONObject(jSONObject, new String[]{Constants.RequestParameters.IS_SECURED, "applicationKey"}).toString();
                    if (!TextUtils.isEmpty(jSONObject2)) {
                        sb.append(Constants.RequestParameters.AMPERSAND);
                        sb.append(Constants.RequestParameters.CONTROLLER_CONFIG);
                        sb.append(Constants.RequestParameters.EQUAL);
                        sb.append(jSONObject2);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            sb.append(Constants.RequestParameters.AMPERSAND);
            sb.append("debug");
            sb.append(Constants.RequestParameters.EQUAL);
            sb.append(getDebugMode());
        }
        return sb.toString();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void closeWebView() {
        OnWebViewChangeListener onWebViewChangeListener = this.mChangeListener;
        if (onWebViewChangeListener != null) {
            onWebViewChangeListener.onCloseRequested();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0017, code lost:
        if (android.text.TextUtils.isEmpty(r1) == false) goto L_0x0023;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void responseBack(java.lang.String r4, boolean r5, java.lang.String r6, java.lang.String r7) {
        /*
            r3 = this;
            com.ironsource.sdk.data.SSAObj r0 = new com.ironsource.sdk.data.SSAObj
            r0.<init>(r4)
            java.lang.String r1 = com.ironsource.sdk.controller.WebController.JSON_KEY_SUCCESS
            java.lang.String r1 = r0.getString(r1)
            java.lang.String r2 = com.ironsource.sdk.controller.WebController.JSON_KEY_FAIL
            java.lang.String r0 = r0.getString(r2)
            if (r5 == 0) goto L_0x001a
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            if (r5 != 0) goto L_0x0022
            goto L_0x0023
        L_0x001a:
            boolean r5 = android.text.TextUtils.isEmpty(r0)
            if (r5 != 0) goto L_0x0022
            r1 = r0
            goto L_0x0023
        L_0x0022:
            r1 = 0
        L_0x0023:
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            if (r5 != 0) goto L_0x005c
            boolean r5 = android.text.TextUtils.isEmpty(r6)
            if (r5 != 0) goto L_0x0040
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x003f }
            r5.<init>(r4)     // Catch:{ JSONException -> 0x003f }
            java.lang.String r0 = "errMsg"
            org.json.JSONObject r5 = r5.put(r0, r6)     // Catch:{ JSONException -> 0x003f }
            java.lang.String r4 = r5.toString()     // Catch:{ JSONException -> 0x003f }
            goto L_0x0040
        L_0x003f:
        L_0x0040:
            boolean r5 = android.text.TextUtils.isEmpty(r7)
            if (r5 != 0) goto L_0x0055
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0055 }
            r5.<init>(r4)     // Catch:{ JSONException -> 0x0055 }
            java.lang.String r6 = "errCode"
            org.json.JSONObject r5 = r5.put(r6, r7)     // Catch:{ JSONException -> 0x0055 }
            java.lang.String r4 = r5.toString()     // Catch:{ JSONException -> 0x0055 }
        L_0x0055:
            java.lang.String r4 = r3.generateJSToInject(r1, r4)
            r3.injectJavascript(r4)
        L_0x005c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.WebController.responseBack(java.lang.String, boolean, java.lang.String, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String extractSuccessFunctionToCall(String str) {
        return new SSAObj(str).getString(JSON_KEY_SUCCESS);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String extractFailFunctionToCall(String str) {
        return new SSAObj(str).getString(JSON_KEY_FAIL);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String parseToJson(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                jSONObject.put(str, SDKUtils.encodeString(str2));
            }
            if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                jSONObject.put(str3, SDKUtils.encodeString(str4));
            }
            if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
                jSONObject.put(str5, SDKUtils.encodeString(str6));
            }
            if (!TextUtils.isEmpty(str7) && !TextUtils.isEmpty(str8)) {
                jSONObject.put(str7, SDKUtils.encodeString(str8));
            }
            if (!TextUtils.isEmpty(str9)) {
                jSONObject.put(str9, z);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Object[] getDeviceParams(Context context) {
        boolean z;
        JSONException e;
        DeviceProperties instance = DeviceProperties.getInstance(context);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appOrientation", "none");
            jSONObject.put(Constants.RequestParameters.DEVICE_ORIENTATION, SDKUtils.translateDeviceOrientation(DeviceStatus.getDeviceOrientation(context)));
            String deviceOem = instance.getDeviceOem();
            if (deviceOem != null) {
                jSONObject.put(SDKUtils.encodeString("deviceOEM"), SDKUtils.encodeString(deviceOem));
            }
            String deviceModel = instance.getDeviceModel();
            if (deviceModel != null) {
                jSONObject.put(SDKUtils.encodeString("deviceModel"), SDKUtils.encodeString(deviceModel));
                z = false;
            } else {
                z = true;
            }
            try {
                SDKUtils.loadGoogleAdvertiserInfo(context);
                String advertiserId = SDKUtils.getAdvertiserId();
                Boolean valueOf = Boolean.valueOf(SDKUtils.isLimitAdTrackingEnabled());
                if (!TextUtils.isEmpty(advertiserId)) {
                    Logger.i(this.TAG, "add AID and LAT");
                    jSONObject.put("isLimitAdTrackingEnabled", valueOf);
                    jSONObject.put("deviceIds" + Constants.RequestParameters.LEFT_BRACKETS + "AID" + Constants.RequestParameters.RIGHT_BRACKETS, SDKUtils.encodeString(advertiserId));
                }
                String deviceOsType = instance.getDeviceOsType();
                if (deviceOsType != null) {
                    jSONObject.put(SDKUtils.encodeString("deviceOs"), SDKUtils.encodeString(deviceOsType));
                } else {
                    z = true;
                }
                String deviceOsVersion = instance.getDeviceOsVersion();
                if (deviceOsVersion != null) {
                    jSONObject.put(SDKUtils.encodeString("deviceOSVersion"), deviceOsVersion.replaceAll("[^0-9/.]", ""));
                } else {
                    z = true;
                }
                String deviceOsVersion2 = instance.getDeviceOsVersion();
                if (deviceOsVersion2 != null) {
                    jSONObject.put(SDKUtils.encodeString("deviceOSVersionFull"), SDKUtils.encodeString(deviceOsVersion2));
                }
                String valueOf2 = String.valueOf(instance.getDeviceApiLevel());
                if (valueOf2 != null) {
                    jSONObject.put(SDKUtils.encodeString("deviceApiLevel"), valueOf2);
                } else {
                    z = true;
                }
                String supersonicSdkVersion = DeviceProperties.getSupersonicSdkVersion();
                if (supersonicSdkVersion != null) {
                    jSONObject.put(SDKUtils.encodeString("SDKVersion"), SDKUtils.encodeString(supersonicSdkVersion));
                }
                if (instance.getDeviceCarrier() != null && instance.getDeviceCarrier().length() > 0) {
                    jSONObject.put(SDKUtils.encodeString("mobileCarrier"), SDKUtils.encodeString(instance.getDeviceCarrier()));
                }
                String connectionType = ConnectivityUtils.getConnectionType(context);
                if (!connectionType.equals("none")) {
                    jSONObject.put(SDKUtils.encodeString("connectionType"), SDKUtils.encodeString(connectionType));
                } else {
                    z = true;
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    jSONObject.put(SDKUtils.encodeString("hasVPN"), ConnectivityUtils.hasVPN(context));
                }
                String language = context.getResources().getConfiguration().locale.getLanguage();
                if (!TextUtils.isEmpty(language)) {
                    jSONObject.put(SDKUtils.encodeString("deviceLanguage"), SDKUtils.encodeString(language.toUpperCase()));
                }
                if (SDKUtils.isExternalStorageAvailable()) {
                    jSONObject.put(SDKUtils.encodeString("diskFreeSize"), SDKUtils.encodeString(String.valueOf(DeviceStatus.getAvailableMemorySizeInMegaBytes(this.mCacheDirectory))));
                } else {
                    z = true;
                }
                String valueOf3 = String.valueOf(DeviceStatus.getDeviceWidth());
                if (!TextUtils.isEmpty(valueOf3)) {
                    jSONObject.put(SDKUtils.encodeString(Constants.RequestParameters.DEVICE_SCREEN_SIZE) + Constants.RequestParameters.LEFT_BRACKETS + SDKUtils.encodeString("width") + Constants.RequestParameters.RIGHT_BRACKETS, SDKUtils.encodeString(valueOf3));
                } else {
                    z = true;
                }
                String valueOf4 = String.valueOf(DeviceStatus.getDeviceHeight());
                jSONObject.put(SDKUtils.encodeString(Constants.RequestParameters.DEVICE_SCREEN_SIZE) + Constants.RequestParameters.LEFT_BRACKETS + SDKUtils.encodeString("height") + Constants.RequestParameters.RIGHT_BRACKETS, SDKUtils.encodeString(valueOf4));
                String packageName = ApplicationContext.getPackageName(getContext());
                if (!TextUtils.isEmpty(packageName)) {
                    jSONObject.put(SDKUtils.encodeString("bundleId"), SDKUtils.encodeString(packageName));
                }
                String valueOf5 = String.valueOf(DeviceStatus.getDeviceDensity());
                if (!TextUtils.isEmpty(valueOf5)) {
                    jSONObject.put(SDKUtils.encodeString("deviceScreenScale"), SDKUtils.encodeString(valueOf5));
                }
                String valueOf6 = String.valueOf(DeviceStatus.isRootedDevice());
                if (!TextUtils.isEmpty(valueOf6)) {
                    jSONObject.put(SDKUtils.encodeString("unLocked"), SDKUtils.encodeString(valueOf6));
                }
                jSONObject.put(SDKUtils.encodeString("deviceVolume"), (double) DeviceProperties.getInstance(context).getDeviceVolume(context));
                jSONObject.put(SDKUtils.encodeString("batteryLevel"), DeviceStatus.getBatteryLevel(context));
                jSONObject.put(SDKUtils.encodeString("mcc"), ConnectivityService.getNetworkMCC(context));
                jSONObject.put(SDKUtils.encodeString("mnc"), ConnectivityService.getNetworkMNC(context));
                jSONObject.put(SDKUtils.encodeString("phoneType"), ConnectivityService.getPhoneType(context));
                jSONObject.put(SDKUtils.encodeString("simOperator"), SDKUtils.encodeString(ConnectivityService.getSimOperator(context)));
                jSONObject.put(SDKUtils.encodeString("lastUpdateTime"), ApplicationContext.getLastUpdateTime(context));
                jSONObject.put(SDKUtils.encodeString("firstInstallTime"), ApplicationContext.getFirstInstallTime(context));
                jSONObject.put(SDKUtils.encodeString("appVersion"), SDKUtils.encodeString(ApplicationContext.getApplicationVersionName(context)));
                String installerPackageName = ApplicationContext.getInstallerPackageName(context);
                if (!TextUtils.isEmpty(installerPackageName)) {
                    jSONObject.put(SDKUtils.encodeString("installerPackageName"), SDKUtils.encodeString(installerPackageName));
                }
                addGooglePlayInstalledData(jSONObject);
                jSONObject.put(SDKUtils.encodeString(Constants.RequestParameters.SCREEN_BRIGHTNESS), DeviceStatus.getScreenBrightness(context));
            } catch (JSONException e2) {
                e = e2;
                e.printStackTrace();
                return new Object[]{jSONObject.toString(), Boolean.valueOf(z)};
            }
        } catch (JSONException e3) {
            e = e3;
            z = false;
            e.printStackTrace();
            return new Object[]{jSONObject.toString(), Boolean.valueOf(z)};
        }
        return new Object[]{jSONObject.toString(), Boolean.valueOf(z)};
    }

    private void addGooglePlayInstalledData(JSONObject jSONObject) throws JSONException {
        jSONObject.put(SDKUtils.encodeString(Constants.RequestParameters.GOOGLE_PLAY_INSTALLED), PackagesInstallationService.isGooglePlayInstalled(getContext()));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Object[] getApplicationParams(String str, String str2) {
        boolean z;
        JSONObject jSONObject = new JSONObject();
        Map<String, String> map = null;
        if (!TextUtils.isEmpty(str)) {
            ISNEnums.ProductType stringProductTypeAsEnum = getStringProductTypeAsEnum(str);
            if (stringProductTypeAsEnum == ISNEnums.ProductType.OfferWall) {
                map = this.mOWExtraParameters;
            } else {
                DemandSource demandSourceById = this.mDemandSourceManager.getDemandSourceById(stringProductTypeAsEnum, str2);
                if (demandSourceById != null) {
                    Map<String, String> extraParams = demandSourceById.getExtraParams();
                    extraParams.put("demandSourceName", demandSourceById.getDemandSourceName());
                    extraParams.put("demandSourceId", demandSourceById.getId());
                    map = extraParams;
                }
            }
            try {
                jSONObject.put(Constants.ParametersKeys.PRODUCT_TYPE, str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                Map<String, String> initSDKParams = SDKUtils.getInitSDKParams();
                if (initSDKParams != null) {
                    jSONObject = SDKUtils.mergeJSONObjects(jSONObject, new JSONObject(initSDKParams));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            z = false;
        } else {
            z = true;
        }
        if (!TextUtils.isEmpty(this.mUserId)) {
            try {
                jSONObject.put(SDKUtils.encodeString("applicationUserId"), SDKUtils.encodeString(this.mUserId));
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        } else {
            z = true;
        }
        if (!TextUtils.isEmpty(this.mApplicationKey)) {
            try {
                jSONObject.put(SDKUtils.encodeString("applicationKey"), SDKUtils.encodeString(this.mApplicationKey));
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        } else {
            z = true;
        }
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey().equalsIgnoreCase("sdkWebViewCache")) {
                    setWebviewCache(entry.getValue());
                }
                try {
                    jSONObject.put(SDKUtils.encodeString(entry.getKey()), SDKUtils.encodeString(entry.getValue()));
                } catch (JSONException e5) {
                    e5.printStackTrace();
                }
            }
        }
        return new Object[]{jSONObject.toString(), Boolean.valueOf(z)};
    }

    @Override // com.ironsource.sdk.precache.OnPreCacheCompletion
    public void onFileDownloadSuccess(SSAFile sSAFile) {
        if (sSAFile.getFile().contains(Constants.MOBILE_CONTROLLER_HTML)) {
            load(1);
        } else {
            assetCached(sSAFile.getFile(), sSAFile.getPath());
        }
    }

    @Override // com.ironsource.sdk.precache.OnPreCacheCompletion
    public void onFileDownloadFail(SSAFile sSAFile) {
        if (sSAFile.getFile().contains(Constants.MOBILE_CONTROLLER_HTML)) {
            ControllerEventListener controllerEventListener = this.mControllerListener;
            controllerEventListener.handleControllerFailed("controller html - failed to download - " + sSAFile.getErrMsg());
            return;
        }
        assetCachedFailed(sSAFile.getFile(), sSAFile.getPath(), sSAFile.getErrMsg());
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        String str5 = this.TAG;
        Logger.i(str5, str + " " + str4);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void toastingErrMsg(final String str, String str2) {
        final String string = new SSAObj(str2).getString("errMsg");
        if (!TextUtils.isEmpty(string)) {
            runOnUiThread(new Runnable() {
                /* class com.ironsource.sdk.controller.WebController.AnonymousClass11 */

                public void run() {
                    if (WebController.this.getDebugMode() == ISNEnums.DebugMode.MODE_3.getValue()) {
                        Context currentActivityContext = WebController.this.getCurrentActivityContext();
                        Toast.makeText(currentActivityContext, str + " : " + string, 1).show();
                    }
                }
            });
        }
    }

    public void setControllerKeyPressed(String str) {
        this.mControllerKeyPressed = str;
    }

    public void sendConnectionTypeChanged(String str) {
        String str2 = this.TAG;
        Logger.i(str2, "device status changed, connection type " + str);
        ISNEventsBaseData.setConnectionType(str);
        injectJavascript(generateJSToInject(Constants.JSMethods.DEVICE_STATUS_CHANGED, parseToJson("connectionType", str, null, null, null, null, null, null, null, false)));
    }

    public void sendConnectionInfoChanged(JSONObject jSONObject) {
        String str = this.TAG;
        Logger.i(str, "device connection info changed: " + jSONObject.toString());
        injectJavascript(generateJSToInject(Constants.JSMethods.CONNECTION_INFO_CHANGED, parseToJson(Constants.RequestParameters.CONNECTION_INFO, jSONObject.toString(), null, null, null, null, null, null, null, false)));
    }

    public void engageEnd(String str) {
        if (str.equals("forceClose")) {
            closeWebView();
        }
        injectJavascript(generateJSToInject(Constants.JSMethods.ENGAGE_END, parseToJson("action", str, null, null, null, null, null, null, null, false)));
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void registerConnectionReceiver(Context context) {
        ConnectivityAdapter connectivityAdapter = this.mConnectivityAdapter;
        if (connectivityAdapter != null) {
            connectivityAdapter.startListenToNetworkChanges(context);
        }
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void unregisterConnectionReceiver(Context context) {
        ConnectivityAdapter connectivityAdapter = this.mConnectivityAdapter;
        if (connectivityAdapter != null) {
            connectivityAdapter.stopListenToNetworkChanges(context);
        }
    }

    public void pause() {
        if (Build.VERSION.SDK_INT > 10) {
            try {
                onPause();
            } catch (Throwable th) {
                String str = this.TAG;
                Logger.i(str, "WebViewController: pause() - " + th);
            }
        }
    }

    public void resume() {
        if (Build.VERSION.SDK_INT > 10) {
            try {
                onResume();
            } catch (Throwable th) {
                String str = this.TAG;
                Logger.i(str, "WebViewController: onResume() - " + th);
            }
        }
    }

    public void setOnWebViewControllerChangeListener(OnWebViewChangeListener onWebViewChangeListener) {
        this.mChangeListener = onWebViewChangeListener;
    }

    public FrameLayout getLayout() {
        return this.mControllerLayout;
    }

    public boolean inCustomView() {
        return this.mCustomView != null;
    }

    public void hideCustomView() {
        this.mWebChromeClient.onHideCustomView();
    }

    private void setWebviewCache(String str) {
        if (str.equalsIgnoreCase(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            getSettings().setCacheMode(2);
        } else {
            getSettings().setCacheMode(-1);
        }
    }

    public boolean handleSearchKeysURLs(String str) {
        List<String> searchKeys = IronSourceSharedPrefHelper.getSupersonicPrefHelper().getSearchKeys();
        if (searchKeys == null) {
            return false;
        }
        try {
            if (searchKeys.isEmpty()) {
                return false;
            }
            for (String str2 : searchKeys) {
                if (str.contains(str2)) {
                    UrlHandler.openUrl(getCurrentActivityContext(), str);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void setState(State state) {
        this.mState = state;
    }

    public State getState() {
        return this.mState;
    }

    /* renamed from: com.ironsource.sdk.controller.WebController$12  reason: invalid class name */
    static /* synthetic */ class AnonymousClass12 {
        static final /* synthetic */ int[] $SwitchMap$com$ironsource$sdk$data$ISNEnums$ProductType;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.ironsource.sdk.data.ISNEnums$ProductType[] r0 = com.ironsource.sdk.data.ISNEnums.ProductType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.ironsource.sdk.controller.WebController.AnonymousClass12.$SwitchMap$com$ironsource$sdk$data$ISNEnums$ProductType = r0
                com.ironsource.sdk.data.ISNEnums$ProductType r1 = com.ironsource.sdk.data.ISNEnums.ProductType.RewardedVideo     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = com.ironsource.sdk.controller.WebController.AnonymousClass12.$SwitchMap$com$ironsource$sdk$data$ISNEnums$ProductType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.ironsource.sdk.data.ISNEnums$ProductType r1 = com.ironsource.sdk.data.ISNEnums.ProductType.Interstitial     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = com.ironsource.sdk.controller.WebController.AnonymousClass12.$SwitchMap$com$ironsource$sdk$data$ISNEnums$ProductType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.ironsource.sdk.data.ISNEnums$ProductType r1 = com.ironsource.sdk.data.ISNEnums.ProductType.OfferWall     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = com.ironsource.sdk.controller.WebController.AnonymousClass12.$SwitchMap$com$ironsource$sdk$data$ISNEnums$ProductType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.ironsource.sdk.data.ISNEnums$ProductType r1 = com.ironsource.sdk.data.ISNEnums.ProductType.OfferWallCredits     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = com.ironsource.sdk.controller.WebController.AnonymousClass12.$SwitchMap$com$ironsource$sdk$data$ISNEnums$ProductType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.ironsource.sdk.data.ISNEnums$ProductType r1 = com.ironsource.sdk.data.ISNEnums.ProductType.Banner     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.WebController.AnonymousClass12.<clinit>():void");
        }
    }

    private String getErrorCodeByProductType(ISNEnums.ProductType productType) {
        int i = AnonymousClass12.$SwitchMap$com$ironsource$sdk$data$ISNEnums$ProductType[productType.ordinal()];
        if (i == 1) {
            return Constants.ErrorCodes.InitRV;
        }
        if (i == 2) {
            return Constants.ErrorCodes.InitIS;
        }
        if (i == 3) {
            return Constants.ErrorCodes.InitOW;
        }
        if (i != 4) {
            return i != 5 ? "" : Constants.ErrorCodes.InitBN;
        }
        return Constants.ErrorCodes.ShowOWCredits;
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void destroy() {
        super.destroy();
        DownloadManager downloadManager2 = this.downloadManager;
        if (downloadManager2 != null) {
            downloadManager2.release();
        }
        ConnectivityAdapter connectivityAdapter = this.mConnectivityAdapter;
        if (connectivityAdapter != null) {
            connectivityAdapter.release();
        }
        this.mUiHandler = null;
    }

    private String generateJSToInject(String str) {
        return "SSA_CORE.SDKController.runFunction('" + str + "');";
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String generateJSToInject(String str, String str2) {
        return "SSA_CORE.SDKController.runFunction('" + str + "?parameters=" + str2 + "');";
    }

    private String generateJSToInject(String str, String str2, String str3) {
        return "SSA_CORE.SDKController.runFunction('" + str + "','" + str2 + "','" + str3 + "');";
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String generateJSToInject(String str, String str2, String str3, String str4) {
        return "SSA_CORE.SDKController.runFunction('" + str + "?parameters=" + str2 + "','" + str3 + "','" + str4 + "');";
    }

    public AdUnitsState getSavedState() {
        return this.mSavedState;
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void restoreSavedState() {
        restoreState(this.mSavedState);
    }

    public void restoreState(AdUnitsState adUnitsState) {
        synchronized (this.mSavedStateLocker) {
            if (adUnitsState.shouldRestore() && this.mIsWebControllerReady) {
                String str = this.TAG;
                Log.d(str, "restoreState(state:" + adUnitsState + ")");
                int displayedProduct = adUnitsState.getDisplayedProduct();
                if (displayedProduct != -1) {
                    if (displayedProduct == ISNEnums.ProductType.RewardedVideo.ordinal()) {
                        Log.d(this.TAG, "onRVAdClosed()");
                        ISNEnums.ProductType productType = ISNEnums.ProductType.RewardedVideo;
                        String displayedDemandSourceId = adUnitsState.getDisplayedDemandSourceId();
                        DSAdProductListener adProductListenerByProductType = getAdProductListenerByProductType(productType);
                        if (adProductListenerByProductType != null && !TextUtils.isEmpty(displayedDemandSourceId)) {
                            adProductListenerByProductType.onAdProductClose(productType, displayedDemandSourceId);
                        }
                    } else if (displayedProduct == ISNEnums.ProductType.Interstitial.ordinal()) {
                        Log.d(this.TAG, "onInterstitialAdClosed()");
                        ISNEnums.ProductType productType2 = ISNEnums.ProductType.Interstitial;
                        String displayedDemandSourceId2 = adUnitsState.getDisplayedDemandSourceId();
                        DSAdProductListener adProductListenerByProductType2 = getAdProductListenerByProductType(productType2);
                        if (adProductListenerByProductType2 != null && !TextUtils.isEmpty(displayedDemandSourceId2)) {
                            adProductListenerByProductType2.onAdProductClose(productType2, displayedDemandSourceId2);
                        }
                    } else if (displayedProduct == ISNEnums.ProductType.OfferWall.ordinal()) {
                        Log.d(this.TAG, "onOWAdClosed()");
                        if (this.mOnOfferWallListener != null) {
                            this.mOnOfferWallListener.onOWAdClosed();
                        }
                    }
                    adUnitsState.adOpened(-1);
                    adUnitsState.setDisplayedDemandSourceId(null);
                } else {
                    Log.d(this.TAG, "No ad was opened");
                }
                String interstitialAppKey = adUnitsState.getInterstitialAppKey();
                String interstitialUserId = adUnitsState.getInterstitialUserId();
                for (DemandSource demandSource : this.mDemandSourceManager.getDemandSources(ISNEnums.ProductType.Interstitial)) {
                    if (demandSource.getDemandSourceInitState() == 2) {
                        String str2 = this.TAG;
                        Log.d(str2, "initInterstitial(appKey:" + interstitialAppKey + ", userId:" + interstitialUserId + ", demandSource:" + demandSource.getDemandSourceName() + ")");
                        initInterstitial(interstitialAppKey, interstitialUserId, demandSource, this.mDSInterstitialListener);
                    }
                }
                String rVAppKey = adUnitsState.getRVAppKey();
                String rVUserId = adUnitsState.getRVUserId();
                for (DemandSource demandSource2 : this.mDemandSourceManager.getDemandSources(ISNEnums.ProductType.RewardedVideo)) {
                    if (demandSource2.getDemandSourceInitState() == 2) {
                        String demandSourceName = demandSource2.getDemandSourceName();
                        Log.d(this.TAG, "onRVNoMoreOffers()");
                        this.mDSRewardedVideoListener.onRVNoMoreOffers(demandSourceName);
                        String str3 = this.TAG;
                        Log.d(str3, "initRewardedVideo(appKey:" + rVAppKey + ", userId:" + rVUserId + ", demandSource:" + demandSourceName + ")");
                        initRewardedVideo(rVAppKey, rVUserId, demandSource2, this.mDSRewardedVideoListener);
                    }
                }
                adUnitsState.setShouldRestore(false);
            }
            this.mSavedState = adUnitsState;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        if (!this.mChangeListener.onBackButtonPressed()) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void runOnUiThread(Runnable runnable) {
        Handler handler = this.mUiHandler;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void setCommunicationWithAdView(ISNAdView iSNAdView) {
        BannerJSAdapter bannerJSAdapter = this.mBannerJsAdapter;
        if (bannerJSAdapter != null) {
            bannerJSAdapter.setCommunicationWithAdView(iSNAdView);
        }
    }
}
