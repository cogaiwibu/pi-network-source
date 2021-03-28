package com.tapjoy;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.TapjoyLog;
import com.tapjoy.internal.al;
import com.tapjoy.internal.eq;
import com.tapjoy.internal.jq;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TJAdUnitJSBridge implements TJWebViewJSInterfaceListener {
    public TJAdUnit a;
    public boolean allowRedirect;
    public WebView b;
    final ConcurrentLinkedQueue c;
    public boolean closeRequested;
    public boolean customClose;
    private TJWebViewJSInterface d;
    public boolean didLaunchOtherActivity;
    private TJAdUnitJSBridge e;
    private Context f;
    private TJAdUnitActivity g;
    private TJSplitWebView h;
    private ProgressDialog i;
    private View j;
    private boolean k;
    private eq l;
    public String otherActivityCallbackID;
    public String splitWebViewCallbackID;

    public interface AdUnitAsyncTaskListner {
        void onComplete(boolean z);
    }

    public void destroy() {
    }

    public TJAdUnitJSBridge(Context context, TJAdUnit tJAdUnit) {
        this(context, tJAdUnit.getWebView());
        this.a = tJAdUnit;
    }

    public TJAdUnitJSBridge(Context context, WebView webView) {
        this.j = null;
        this.didLaunchOtherActivity = false;
        this.allowRedirect = true;
        this.otherActivityCallbackID = null;
        this.customClose = false;
        this.closeRequested = false;
        this.splitWebViewCallbackID = null;
        this.l = new eq(this);
        this.c = new ConcurrentLinkedQueue();
        TapjoyLog.i("TJAdUnitJSBridge", "creating AdUnit/JS Bridge");
        this.f = context;
        this.b = webView;
        this.e = this;
        if (webView == null) {
            TapjoyLog.e("TJAdUnitJSBridge", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, "Cannot create AdUnitJSBridge -- webview is NULL"));
            return;
        }
        TJWebViewJSInterface tJWebViewJSInterface = new TJWebViewJSInterface(webView, this);
        this.d = tJWebViewJSInterface;
        this.b.addJavascriptInterface(tJWebViewJSInterface, TJAdUnitConstants.JAVASCRIPT_INTERFACE_ID);
        setEnabled(true);
    }

    @Override // com.tapjoy.TJWebViewJSInterfaceListener
    public void onDispatchMethod(String str, JSONObject jSONObject) {
        if (this.k) {
            String str2 = null;
            try {
                str2 = jSONObject.optString(TJAdUnitConstants.String.CALLBACK_ID, null);
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                Method method = TJAdUnitJSBridge.class.getMethod(str, JSONObject.class, String.class);
                TapjoyLog.d("TJAdUnitJSBridge", "Dispatching method: " + method + " with data=" + jSONObject2 + "; callbackID=" + str2);
                method.invoke(this.e, jSONObject2, str2);
            } catch (Exception e2) {
                e2.printStackTrace();
                invokeJSCallback(str2, Boolean.FALSE);
            }
        } else {
            TapjoyLog.d("TJAdUnitJSBridge", "Bridge currently disabled. Adding " + str + " to message queue");
            this.c.add(new Pair(str, jSONObject));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void alert(org.json.JSONObject r10, final java.lang.String r11) {
        /*
        // Method dump skipped, instructions count: 198
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.TJAdUnitJSBridge.alert(org.json.JSONObject, java.lang.String):void");
    }

    public void closeRequested(Boolean bool) {
        TJSplitWebView tJSplitWebView = this.h;
        if (tJSplitWebView == null) {
            this.closeRequested = true;
            HashMap hashMap = new HashMap();
            hashMap.put("forceClose", bool);
            invokeJSAdunitMethod(TJAdUnitConstants.String.CLOSE_REQUESTED, hashMap);
        } else if (!tJSplitWebView.goBack()) {
            this.h.a();
        }
    }

    public void getVolume(JSONObject jSONObject, String str) {
        HashMap volumeArgs = getVolumeArgs();
        if (volumeArgs != null) {
            invokeJSCallback(str, volumeArgs);
            return;
        }
        invokeJSCallback(str, false);
    }

    public void onVolumeChanged() {
        invokeJSAdunitMethod(TJAdUnitConstants.String.VOLUME_CHANGED, getVolumeArgs());
    }

    public HashMap getVolumeArgs() {
        TJAdUnit tJAdUnit = this.a;
        if (tJAdUnit == null) {
            TapjoyLog.d("TJAdUnitJSBridge", "No ad unit provided");
            return null;
        }
        String format = String.format("%.2f", Float.valueOf(tJAdUnit.getVolume()));
        boolean isMuted = this.a.isMuted();
        TapjoyLog.d("TJAdUnitJSBridge", "getVolumeArgs: volume=" + format + "; isMuted=" + isMuted);
        HashMap hashMap = new HashMap();
        hashMap.put(TJAdUnitConstants.String.CURRENT_VOLUME, format);
        hashMap.put(TJAdUnitConstants.String.IS_MUTED, Boolean.valueOf(isMuted));
        return hashMap;
    }

    public void dismiss(JSONObject jSONObject, String str) {
        TJAdUnitActivity tJAdUnitActivity = this.g;
        if (tJAdUnitActivity != null) {
            invokeJSCallback(str, true);
            tJAdUnitActivity.finish();
            return;
        }
        TapjoyLog.d("TJAdUnitJSBridge", "Cannot dismiss -- TJAdUnitActivity is null");
        invokeJSCallback(str, false);
    }

    public void display() {
        invokeJSAdunitMethod("display", new Object[0]);
    }

    public void displayStoreURL(JSONObject jSONObject, String str) {
        displayURL(jSONObject, str);
    }

    public void dismissStoreView(JSONObject jSONObject, String str) {
        dismissSplitView(jSONObject, str);
    }

    public void displayURL(final JSONObject jSONObject, final String str) {
        final String str2;
        final String str3;
        try {
            String optString = jSONObject.optString("style");
            final String string = jSONObject.getString("url");
            final JSONObject optJSONObject = jSONObject.optJSONObject(TJAdUnitConstants.String.SPLIT_VIEW_LAYOUT);
            final JSONArray optJSONArray = jSONObject.optJSONArray(TJAdUnitConstants.String.SPLIT_VIEW_EXIT_HOSTS);
            final String optString2 = jSONObject.optString(TJAdUnitConstants.String.USER_AGENT, null);
            JSONObject optJSONObject2 = jSONObject.optJSONObject(TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER);
            if (optJSONObject2 != null) {
                String optString3 = optJSONObject2.optString("on", null);
                str2 = optJSONObject2.optString("to", null);
                str3 = optString3;
            } else {
                str3 = null;
                str2 = null;
            }
            if (TJAdUnitConstants.String.STYLE_SPLIT.equals(optString)) {
                TapjoyUtil.runOnMainThread(new Runnable() {
                    /* class com.tapjoy.TJAdUnitJSBridge.AnonymousClass6 */

                    public final void run() {
                        if (TJAdUnitJSBridge.this.b != null) {
                            if (TJAdUnitJSBridge.this.h == null) {
                                ViewParent parent = TJAdUnitJSBridge.this.b.getParent();
                                if (parent instanceof ViewGroup) {
                                    ViewGroup viewGroup = (ViewGroup) parent;
                                    TJAdUnitJSBridge.this.h = new TJSplitWebView(TJAdUnitJSBridge.this.g, jSONObject, TJAdUnitJSBridge.this);
                                    viewGroup.addView(TJAdUnitJSBridge.this.h, new RelativeLayout.LayoutParams(-1, -1));
                                    TJAdUnitJSBridge.this.h.animateOpen(viewGroup);
                                }
                            } else {
                                TJAdUnitJSBridge.this.h.setExitHosts(optJSONArray);
                                TJAdUnitJSBridge.this.h.applyLayoutOption(optJSONObject);
                            }
                            if (TJAdUnitJSBridge.this.h != null) {
                                if (optString2 != null) {
                                    TJAdUnitJSBridge.this.h.setUserAgent(optString2);
                                }
                                TJAdUnitJSBridge.this.h.setTrigger(str3, str2);
                                TJAdUnitJSBridge.this.splitWebViewCallbackID = str;
                                TJAdUnitJSBridge.this.h.loadUrl(string);
                                return;
                            }
                        }
                        TJAdUnitJSBridge.this.h = null;
                        TJAdUnitJSBridge.this.splitWebViewCallbackID = null;
                        TJAdUnitJSBridge.this.invokeJSCallback(str, Boolean.FALSE);
                    }
                });
                return;
            }
            this.didLaunchOtherActivity = true;
            this.otherActivityCallbackID = str;
            this.f.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(string)));
        } catch (Exception e2) {
            invokeJSCallback(str, Boolean.TRUE);
            e2.printStackTrace();
        }
    }

    public void clearCache(JSONObject jSONObject, String str) {
        if (TapjoyCache.getInstance() != null) {
            TapjoyCache.getInstance().clearTapjoyCache();
            invokeJSCallback(str, Boolean.TRUE);
            return;
        }
        invokeJSCallback(str, Boolean.FALSE);
    }

    public void setPrerenderLimit(JSONObject jSONObject, String str) {
        try {
            TJPlacementManager.setPreRenderedPlacementLimit(jSONObject.getInt(TJAdUnitConstants.String.TJC_PLACEMENT_PRE_RENDERED_LIMIT));
            invokeJSCallback(str, Boolean.TRUE);
        } catch (Exception unused) {
            TapjoyLog.w("TJAdUnitJSBridge", "Unable to set Tapjoy placement pre-render limit. Invalid parameters.");
            invokeJSCallback(str, Boolean.FALSE);
        }
    }

    public void setEventPreloadLimit(JSONObject jSONObject, String str) {
        if (TapjoyCache.getInstance() != null) {
            try {
                TJPlacementManager.setCachedPlacementLimit(jSONObject.getInt(TJAdUnitConstants.String.TJC_PLACEMENT_CACHE_LIMIT));
                invokeJSCallback(str, Boolean.TRUE);
            } catch (Exception unused) {
                TapjoyLog.w("TJAdUnitJSBridge", "Unable to set Tapjoy cache's event preload limit. Invalid parameters.");
                invokeJSCallback(str, Boolean.FALSE);
            }
        } else {
            invokeJSCallback(str, Boolean.FALSE);
        }
    }

    public void removeAssetFromCache(JSONObject jSONObject, String str) {
        try {
            String string = jSONObject.getString("url");
            if (TapjoyCache.getInstance() != null) {
                invokeJSCallback(str, Boolean.valueOf(TapjoyCache.getInstance().removeAssetFromCache(string)));
                return;
            }
            invokeJSCallback(str, Boolean.FALSE);
        } catch (Exception unused) {
            TapjoyLog.w("TJAdUnitJSBridge", "Unable to cache video. Invalid parameters.");
            invokeJSCallback(str, Boolean.FALSE);
        }
    }

    public void cacheAsset(JSONObject jSONObject, String str) {
        String str2;
        Long l2 = 0L;
        try {
            String string = jSONObject.getString("url");
            try {
                str2 = jSONObject.getString(TapjoyConstants.TJC_PLACEMENT_OFFER_ID);
            } catch (Exception unused) {
                str2 = "";
            }
            try {
                l2 = Long.valueOf(jSONObject.getLong(TapjoyConstants.TJC_TIME_TO_LIVE));
            } catch (Exception unused2) {
            }
            if (TapjoyCache.getInstance() != null) {
                invokeJSCallback(str, TapjoyCache.getInstance().cacheAssetFromURL(string, str2, l2.longValue()));
                return;
            }
            invokeJSCallback(str, Boolean.FALSE);
        } catch (Exception unused3) {
            TapjoyLog.w("TJAdUnitJSBridge", "Unable to cache video. Invalid parameters.");
            invokeJSCallback(str, Boolean.FALSE);
        }
    }

    public void cachePathForURL(JSONObject jSONObject, String str) {
        try {
            String string = jSONObject.getString("url");
            if (TapjoyCache.getInstance() != null) {
                invokeJSCallback(str, TapjoyCache.getInstance().getPathOfCachedURL(string));
                return;
            }
            invokeJSCallback(str, "");
        } catch (Exception unused) {
            invokeJSCallback(str, "");
        }
    }

    public void getCachedAssets(JSONObject jSONObject, String str) {
        if (TapjoyCache.getInstance() != null) {
            invokeJSCallback(str, TapjoyCache.getInstance().cachedAssetsToJSON());
            return;
        }
        invokeJSCallback(str, "");
    }

    public void contentReady(JSONObject jSONObject, String str) {
        TJAdUnit tJAdUnit = this.a;
        if (tJAdUnit != null) {
            tJAdUnit.fireContentReady();
            invokeJSCallback(str, true);
            return;
        }
        invokeJSCallback(str, false);
    }

    public void getOrientation(JSONObject jSONObject, String str) {
        TJAdUnit tJAdUnit = this.a;
        if (tJAdUnit == null) {
            TapjoyLog.d("TJAdUnitJSBridge", "No ad unit provided");
            invokeJSCallback(str, JSONObject.NULL);
            return;
        }
        String screenOrientationString = tJAdUnit.getScreenOrientationString();
        HashMap hashMap = new HashMap();
        hashMap.put("orientation", screenOrientationString);
        hashMap.put("width", Integer.valueOf(this.a.getScreenWidth()));
        hashMap.put("height", Integer.valueOf(this.a.getScreenHeight()));
        invokeJSCallback(str, hashMap);
    }

    public void setOrientation(JSONObject jSONObject, String str) {
        int i2;
        if (this.a == null) {
            TapjoyLog.d("TJAdUnitJSBridge", "No ad unit provided");
            invokeJSCallback(str, false);
            return;
        }
        try {
            String string = jSONObject.getString("orientation");
            if (!string.equals("landscape")) {
                if (!string.equals(TJAdUnitConstants.String.LANDSCAPE_LEFT)) {
                    i2 = string.equals(TJAdUnitConstants.String.LANDSCAPE_RIGHT) ? 8 : 1;
                    this.a.setOrientation(i2);
                    invokeJSCallback(str, true);
                }
            }
            i2 = 0;
            this.a.setOrientation(i2);
            invokeJSCallback(str, true);
        } catch (Exception unused) {
            invokeJSCallback(str, false);
        }
    }

    public void unsetOrientation(JSONObject jSONObject, String str) {
        TJAdUnit tJAdUnit = this.a;
        if (tJAdUnit == null) {
            TapjoyLog.d("TJAdUnitJSBridge", "No ad unit provided");
            invokeJSCallback(str, false);
            return;
        }
        try {
            tJAdUnit.unsetOrientation();
            invokeJSCallback(str, true);
        } catch (Exception unused) {
            invokeJSCallback(str, false);
        }
    }

    public void setBackgroundColor(JSONObject jSONObject, final String str) {
        try {
            String string = jSONObject.getString("backgroundColor");
            TJAdUnit tJAdUnit = this.a;
            if (tJAdUnit != null) {
                tJAdUnit.setBackgroundColor(string, new AdUnitAsyncTaskListner() {
                    /* class com.tapjoy.TJAdUnitJSBridge.AnonymousClass7 */

                    @Override // com.tapjoy.TJAdUnitJSBridge.AdUnitAsyncTaskListner
                    public final void onComplete(boolean z) {
                        TJAdUnitJSBridge.this.invokeJSCallback(str, Boolean.valueOf(z));
                    }
                });
                return;
            }
            invokeJSCallback(str, false);
        } catch (Exception unused) {
            TapjoyLog.w("TJAdUnitJSBridge", "Unable to set background color. Invalid parameters.");
            invokeJSCallback(str, false);
        }
    }

    public void setBackgroundWebViewContent(JSONObject jSONObject, final String str) {
        TapjoyLog.d("TJAdUnitJSBridge", "setBackgroundWebViewContent");
        try {
            String string = jSONObject.getString(TJAdUnitConstants.String.BACKGROUND_CONTENT);
            TJAdUnit tJAdUnit = this.a;
            if (tJAdUnit != null) {
                tJAdUnit.setBackgroundContent(string, new AdUnitAsyncTaskListner() {
                    /* class com.tapjoy.TJAdUnitJSBridge.AnonymousClass8 */

                    @Override // com.tapjoy.TJAdUnitJSBridge.AdUnitAsyncTaskListner
                    public final void onComplete(boolean z) {
                        TJAdUnitJSBridge.this.invokeJSCallback(str, Boolean.valueOf(z));
                    }
                });
                return;
            }
            invokeJSCallback(str, false);
        } catch (Exception unused) {
            TapjoyLog.w("TJAdUnitJSBridge", "Unable to set background content. Invalid parameters.");
            invokeJSCallback(str, false);
        }
    }

    public void displayVideo(JSONObject jSONObject, final String str) {
        try {
            String string = jSONObject.getString("url");
            if (string.length() <= 0 || string == "") {
                invokeJSCallback(str, Boolean.FALSE);
                return;
            }
            this.a.loadVideoUrl(string, new AdUnitAsyncTaskListner() {
                /* class com.tapjoy.TJAdUnitJSBridge.AnonymousClass9 */

                @Override // com.tapjoy.TJAdUnitJSBridge.AdUnitAsyncTaskListner
                public final void onComplete(boolean z) {
                    TJAdUnitJSBridge.this.invokeJSCallback(str, Boolean.valueOf(z));
                }
            });
        } catch (Exception e2) {
            invokeJSCallback(str, Boolean.FALSE);
            e2.printStackTrace();
        }
    }

    public void playVideo(JSONObject jSONObject, String str) {
        TJAdUnit tJAdUnit = this.a;
        if (tJAdUnit != null) {
            invokeJSCallback(str, Boolean.valueOf(tJAdUnit.playVideo()));
        }
    }

    public void pauseVideo(JSONObject jSONObject, String str) {
        TJAdUnit tJAdUnit = this.a;
        if (tJAdUnit != null) {
            invokeJSCallback(str, Boolean.valueOf(tJAdUnit.pauseVideo()));
        }
    }

    public void clearVideo(JSONObject jSONObject, final String str) {
        if (this.a != null) {
            this.a.clearVideo(new AdUnitAsyncTaskListner() {
                /* class com.tapjoy.TJAdUnitJSBridge.AnonymousClass10 */

                @Override // com.tapjoy.TJAdUnitJSBridge.AdUnitAsyncTaskListner
                public final void onComplete(boolean z) {
                    TJAdUnitJSBridge.this.invokeJSCallback(str, Boolean.valueOf(z));
                }
            }, jSONObject.optBoolean("visible", false));
        }
    }

    public void setVideoMute(JSONObject jSONObject, String str) {
        try {
            this.a.a(jSONObject.getBoolean("enabled"));
            invokeJSCallback(str, Boolean.TRUE);
        } catch (JSONException unused) {
            TapjoyLog.d("TJAdUnitJSBridge", "Failed to parse 'enabled' from json params.");
            invokeJSCallback(str, Boolean.FALSE);
        }
    }

    public void setVideoMargins(JSONObject jSONObject, String str) {
        try {
            final float optDouble = (float) jSONObject.optDouble("top", 0.0d);
            final float optDouble2 = (float) jSONObject.optDouble("right", 0.0d);
            final float optDouble3 = (float) jSONObject.optDouble("bottom", 0.0d);
            final float optDouble4 = (float) jSONObject.optDouble("left", 0.0d);
            final TJAdUnitActivity tJAdUnitActivity = this.g;
            if (tJAdUnitActivity != null) {
                TapjoyUtil.runOnMainThread(new Runnable() {
                    /* class com.tapjoy.TJAdUnitJSBridge.AnonymousClass11 */

                    public final void run() {
                        TJAdUnitActivity tJAdUnitActivity = tJAdUnitActivity;
                        float f2 = optDouble4;
                        float f3 = optDouble;
                        float f4 = optDouble2;
                        float f5 = optDouble3;
                        DisplayMetrics displayMetrics = tJAdUnitActivity.getResources().getDisplayMetrics();
                        ViewGroup viewGroup = (ViewGroup) tJAdUnitActivity.a.getVideoView().getParent();
                        ((ViewGroup.MarginLayoutParams) viewGroup.getLayoutParams()).setMargins((int) TypedValue.applyDimension(1, f2, displayMetrics), (int) TypedValue.applyDimension(1, f3, displayMetrics), (int) TypedValue.applyDimension(1, f4, displayMetrics), (int) TypedValue.applyDimension(1, f5, displayMetrics));
                        viewGroup.requestLayout();
                    }
                });
                invokeJSCallback(str, true);
                return;
            }
            TapjoyLog.d("TJAdUnitJSBridge", "Cannot setVideoMargins -- TJAdUnitActivity is null");
            invokeJSCallback(str, false);
        } catch (Exception e2) {
            invokeJSCallback(str, false);
            e2.printStackTrace();
        }
    }

    public void log(JSONObject jSONObject, String str) {
        try {
            TapjoyLog.d("TJAdUnitJSBridge", "Logging message=" + jSONObject.getString("message"));
            invokeJSCallback(str, Boolean.TRUE);
        } catch (Exception e2) {
            invokeJSCallback(str, Boolean.FALSE);
            e2.printStackTrace();
        }
    }

    public void openApp(JSONObject jSONObject, String str) {
        try {
            this.f.startActivity(this.f.getPackageManager().getLaunchIntentForPackage(jSONObject.getString(TJAdUnitConstants.String.BUNDLE)));
            invokeJSCallback(str, Boolean.TRUE);
        } catch (Exception e2) {
            invokeJSCallback(str, Boolean.FALSE);
            e2.printStackTrace();
        }
    }

    public void nativeEval(final JSONObject jSONObject, final String str) {
        TapjoyUtil.runOnMainThread(new Runnable() {
            /* class com.tapjoy.TJAdUnitJSBridge.AnonymousClass12 */

            public final void run() {
                try {
                    if (Build.VERSION.SDK_INT >= 19) {
                        TJAdUnitJSBridge.this.b.evaluateJavascript(jSONObject.getString(TJAdUnitConstants.String.COMMAND), null);
                    } else {
                        WebView webView = TJAdUnitJSBridge.this.b;
                        webView.loadUrl("javascript:" + jSONObject.getString(TJAdUnitConstants.String.COMMAND));
                    }
                    TJAdUnitJSBridge.this.invokeJSCallback(str, Boolean.TRUE);
                } catch (Exception unused) {
                    TJAdUnitJSBridge.this.invokeJSCallback(str, Boolean.FALSE);
                }
            }
        });
    }

    public void present(JSONObject jSONObject, String str) {
        try {
            Boolean.valueOf(false);
            boolean z = false;
            Boolean valueOf = Boolean.valueOf(jSONObject.getString("visible"));
            try {
                z = Boolean.valueOf(jSONObject.getString("transparent"));
            } catch (Exception unused) {
            }
            try {
                this.customClose = Boolean.valueOf(jSONObject.getString(TJAdUnitConstants.String.CUSTOM_CLOSE)).booleanValue();
            } catch (Exception unused2) {
            }
            new a(this.b).execute(valueOf, z);
            invokeJSCallback(str, Boolean.TRUE);
        } catch (Exception e2) {
            invokeJSCallback(str, Boolean.FALSE);
            e2.printStackTrace();
        }
    }

    public void triggerEvent(JSONObject jSONObject, String str) {
        if (this.a != null) {
            try {
                String string = jSONObject.getString("eventName");
                if (string.equals("start")) {
                    this.a.fireOnVideoStart();
                } else if (string.equals(TJAdUnitConstants.String.VIDEO_COMPLETE)) {
                    this.a.fireOnVideoComplete();
                } else if (string.equals("error")) {
                    this.a.fireOnVideoError("Error while trying to play video.");
                } else if (string.equals(TJAdUnitConstants.String.CLICK)) {
                    this.a.fireOnClick();
                }
            } catch (Exception unused) {
                TapjoyLog.w("TJAdUnitJSBridge", "Unable to triggerEvent. No event name.");
            }
        }
    }

    public void invokeJSAdunitMethod(String str, Object... objArr) {
        this.d.callback(new ArrayList(Arrays.asList(objArr)), str, (String) null);
    }

    public void invokeJSAdunitMethod(String str, Map map) {
        this.d.callback(map, str, (String) null);
    }

    public void invokeJSCallback(String str, Object... objArr) {
        if (jq.c(str)) {
            TapjoyLog.d("TJAdUnitJSBridge", "invokeJSCallback -- no callbackID provided");
            return;
        }
        this.d.callback(new ArrayList(Arrays.asList(objArr)), "", str);
    }

    public void invokeJSCallback(String str, Map map) {
        this.d.callback(map, "", str);
    }

    public void flushBacklogMessageQueue() {
        while (true) {
            Pair pair = (Pair) this.c.poll();
            if (pair != null) {
                onDispatchMethod((String) pair.first, (JSONObject) pair.second);
            } else {
                return;
            }
        }
    }

    public void flushMessageQueue() {
        this.d.flushMessageQueue();
    }

    public void setAllowRedirect(JSONObject jSONObject, String str) {
        boolean z;
        try {
            z = jSONObject.getBoolean("enabled");
        } catch (Exception unused) {
            z = true;
        }
        this.allowRedirect = z;
        invokeJSCallback(str, Boolean.TRUE);
    }

    public void setAdUnitActivity(TJAdUnitActivity tJAdUnitActivity) {
        this.g = tJAdUnitActivity;
    }

    public void setSpinnerVisible(JSONObject jSONObject, String str) {
        try {
            boolean z = jSONObject.getBoolean("visible");
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString("message");
            TJAdUnitActivity tJAdUnitActivity = this.g;
            if (tJAdUnitActivity != null) {
                if (z) {
                    this.i = ProgressDialog.show(tJAdUnitActivity, optString, optString2);
                } else if (this.i != null) {
                    this.i.dismiss();
                }
                invokeJSCallback(str, Boolean.TRUE);
                return;
            }
            TapjoyLog.d("TJAdUnitJSBridge", "Cannot setSpinnerVisible -- TJAdUnitActivity is null");
            invokeJSCallback(str, Boolean.FALSE);
        } catch (Exception e2) {
            invokeJSCallback(str, Boolean.FALSE);
            e2.printStackTrace();
        }
    }

    public void setCloseButtonVisible(JSONObject jSONObject, String str) {
        try {
            final boolean z = jSONObject.getBoolean("visible");
            TapjoyUtil.runOnMainThread(new Runnable() {
                /* class com.tapjoy.TJAdUnitJSBridge.AnonymousClass13 */

                public final void run() {
                    TJAdUnitActivity tJAdUnitActivity = TJAdUnitJSBridge.this.g;
                    if (tJAdUnitActivity != null) {
                        tJAdUnitActivity.setCloseButtonVisibility(z);
                    } else {
                        TapjoyLog.d("TJAdUnitJSBridge", "Cannot setCloseButtonVisible -- TJAdUnitActivity is null");
                    }
                }
            });
            invokeJSCallback(str, true);
        } catch (Exception e2) {
            invokeJSCallback(str, false);
            e2.printStackTrace();
        }
    }

    public void setCloseButtonClickable(JSONObject jSONObject, String str) {
        try {
            final boolean optBoolean = jSONObject.optBoolean(TJAdUnitConstants.String.CLICKABLE);
            TapjoyUtil.runOnMainThread(new Runnable() {
                /* class com.tapjoy.TJAdUnitJSBridge.AnonymousClass2 */

                public final void run() {
                    TJAdUnitActivity tJAdUnitActivity = TJAdUnitJSBridge.this.g;
                    if (tJAdUnitActivity != null) {
                        tJAdUnitActivity.setCloseButtonClickable(optBoolean);
                    } else {
                        TapjoyLog.d("TJAdUnitJSBridge", "Cannot setCloseButtonClickable -- TJAdUnitActivity is null");
                    }
                }
            });
            invokeJSCallback(str, true);
        } catch (Exception e2) {
            invokeJSCallback(str, false);
            e2.printStackTrace();
        }
    }

    public void shouldClose(JSONObject jSONObject, String str) {
        TJAdUnitActivity tJAdUnitActivity = this.g;
        try {
            Boolean.valueOf(false);
            if (Boolean.valueOf(jSONObject.getString(TJAdUnitConstants.String.CLOSE)).booleanValue() && tJAdUnitActivity != null) {
                tJAdUnitActivity.finish();
            }
            invokeJSCallback(str, Boolean.TRUE);
        } catch (Exception e2) {
            invokeJSCallback(str, Boolean.FALSE);
            if (tJAdUnitActivity != null) {
                tJAdUnitActivity.finish();
            }
            e2.printStackTrace();
        }
        this.closeRequested = false;
    }

    public void setLoggingLevel(JSONObject jSONObject, String str) {
        try {
            TapjoyAppSettings.getInstance().saveLoggingLevel(String.valueOf(jSONObject.getString(TJAdUnitConstants.String.LOGGING_LEVEL)));
        } catch (Exception e2) {
            TapjoyLog.d("TJAdUnitJSBridge", "setLoggingLevel exception " + e2.getLocalizedMessage());
            invokeJSCallback(str, false);
            e2.printStackTrace();
        }
    }

    public void clearLoggingLevel(JSONObject jSONObject, String str) {
        TapjoyAppSettings.getInstance().clearLoggingLevel();
    }

    public void attachVolumeListener(JSONObject jSONObject, String str) {
        try {
            boolean z = jSONObject.getBoolean(TJAdUnitConstants.String.ATTACH);
            int optInt = jSONObject.optInt(TJAdUnitConstants.String.INTERVAL, 500);
            if (optInt > 0) {
                this.a.attachVolumeListener(z, optInt);
                invokeJSCallback(str, true);
                return;
            }
            TapjoyLog.d("TJAdUnitJSBridge", "Invalid `interval` value passed to attachVolumeListener(): interval=" + optInt);
            invokeJSCallback(str, false);
        } catch (Exception e2) {
            TapjoyLog.d("TJAdUnitJSBridge", "attachVolumeListener exception " + e2.toString());
            invokeJSCallback(str, false);
            e2.printStackTrace();
        }
    }

    public void initMoatVideoTracker(JSONObject jSONObject, String str) {
        invokeJSCallback(str, true);
    }

    public void startMoatVideoTracker(JSONObject jSONObject, String str) {
        invokeJSCallback(str, true);
    }

    public void triggerMoatVideoEvent(JSONObject jSONObject, String str) {
        invokeJSCallback(str, true);
    }

    public void initViewabilityTracker(JSONObject jSONObject, String str) {
        eq eqVar = this.l;
        if (!eqVar.a(jSONObject)) {
            eqVar.a.invokeJSCallback(str, false);
            return;
        }
        eq.b(jSONObject);
        if (al.a(eq.b)) {
            eqVar.a.invokeJSCallback(str, false);
            return;
        }
        TapjoyUtil.runOnMainThread(new Runnable(jSONObject, str) {
            /* class com.tapjoy.internal.eq.AnonymousClass1 */
            final /* synthetic */ JSONObject a;
            final /* synthetic */ String b;

            {
                this.a = r2;
                this.b = r3;
            }

            public final void run() {
                try {
                    if (!eq.this.c) {
                        eq eqVar = eq.this;
                        ck.a();
                        eqVar.c = ck.a(eq.this.a.b.getContext());
                    }
                    if (eq.this.c) {
                        TapjoyLog.d("TJOMViewabilityAgent", "initialized");
                        cu a2 = cu.a(eq.this.f, eq.b, eq.b(this.a.optJSONArray(TJAdUnitConstants.String.VENDORS)), "");
                        ct a3 = ct.a(cw.a, cw.a);
                        eq.this.e = cs.a(a3, a2);
                        eq.this.e.a(eq.this.a.a.getWebView());
                        eq.this.g = dc.a(eq.this.e);
                        eq.this.d = cr.a(eq.this.e);
                        eq.this.a.invokeJSCallback(this.b, true);
                        return;
                    }
                    TapjoyLog.d("TJOMViewabilityAgent", "Failed to initialize");
                    eq.this.a.invokeJSCallback(this.b, false);
                } catch (Exception e) {
                    TapjoyLog.d("TJOMViewabilityAgent", "Failed to init with exception: " + e.getMessage());
                    eq.this.a.invokeJSCallback(this.b, false);
                }
            }
        });
    }

    public void startViewabilityTracker(JSONObject jSONObject, String str) {
        eq eqVar = this.l;
        if (!eqVar.c) {
            TapjoyLog.d("TJOMViewabilityAgent", "Can not start -- TJOMViewabilityAgent is not initialized");
            eqVar.a.invokeJSCallback(str, false);
            return;
        }
        eqVar.a.invokeJSCallback(str, true);
        TapjoyUtil.runOnMainThread(new Runnable() {
            /* class com.tapjoy.internal.eq.AnonymousClass2 */

            public final void run() {
                try {
                    eq.this.e.a();
                } catch (Exception e) {
                    TapjoyLog.d("TJOMViewabilityAgent", "Failed to start with exception: " + e.getMessage());
                }
            }
        });
    }

    public void triggerViewabilityEvent(JSONObject jSONObject, String str) {
        eq eqVar = this.l;
        if (!eqVar.c) {
            TapjoyLog.d("TJOMViewabilityAgent", "Can not triggerEvent -- TJOMViewabilityAgent is not initialized");
            eqVar.a.invokeJSCallback(str, false);
        } else if (jSONObject == null) {
            TapjoyLog.d("TJOMViewabilityAgent", "Can not triggerEvent -- json parameter is null");
            eqVar.a.invokeJSCallback(str, false);
        } else {
            String optString = jSONObject.optString("eventName", null);
            if (optString == null) {
                TapjoyLog.d("TJOMViewabilityAgent", "triggerEvent: params json did not contain 'eventName'");
                eqVar.a.invokeJSCallback(str, false);
                return;
            }
            TapjoyUtil.runOnMainThread(new Runnable(optString, str) {
                /* class com.tapjoy.internal.eq.AnonymousClass3 */
                final /* synthetic */ String a;
                final /* synthetic */ String b;

                {
                    this.a = r2;
                    this.b = r3;
                }

                public final void run() {
                    try {
                        if (this.a.equals(TJAdUnitConstants.String.VIDEO_RENDERED)) {
                            eq.this.g.a(db.a(da.d));
                            eq.this.d.a();
                        } else if (this.a.equals(TJAdUnitConstants.String.VIDEO_BUFFER_START)) {
                            eq.this.g.g();
                        } else if (this.a.equals(TJAdUnitConstants.String.VIDEO_BUFFER_END)) {
                            eq.this.g.h();
                        } else if (this.a.equals("start")) {
                            eq.this.g.a((float) eq.this.a.a.getVideoView().getDuration(), eq.this.a.a.getVolume());
                        } else if (this.a.equals(TJAdUnitConstants.String.VIDEO_FIRST_QUARTILE)) {
                            eq.this.g.a();
                        } else if (this.a.equals(TJAdUnitConstants.String.VIDEO_MIDPOINT)) {
                            eq.this.g.b();
                        } else if (this.a.equals(TJAdUnitConstants.String.VIDEO_THIRD_QUARTILE)) {
                            eq.this.g.c();
                        } else if (this.a.equals("paused")) {
                            eq.this.g.e();
                        } else if (this.a.equals("playing")) {
                            eq.this.g.f();
                        } else if (this.a.equals(TJAdUnitConstants.String.VIDEO_SKIPPED)) {
                            eq.this.g.i();
                        } else if (this.a.equals(TJAdUnitConstants.String.VOLUME_CHANGED)) {
                            eq.this.g.a(eq.this.a.a.getVolume());
                        } else if (this.a.equals(TJAdUnitConstants.String.VIDEO_COMPLETE)) {
                            eq.this.g.d();
                            eq.this.e.b();
                            eq.this.e = null;
                        } else {
                            TapjoyLog.d("TJOMViewabilityAgent", "triggerEvent: event name '" + this.a + "' not found");
                            eq.this.a.invokeJSCallback(this.b, false);
                            return;
                        }
                        TapjoyLog.d("TJOMViewabilityAgent", "triggerEvent: event name '" + this.a + "'");
                        eq.this.a.invokeJSCallback(this.b, true);
                    } catch (Exception e) {
                        TapjoyLog.d("TJOMViewabilityAgent", "triggerEvent exception:" + e.getMessage());
                        eq.this.a.invokeJSCallback(this.b, false);
                    }
                }
            });
        }
    }

    public void startUsageTrackingEvent(JSONObject jSONObject, String str) {
        try {
            String string = jSONObject.getString("name");
            if (string.isEmpty()) {
                TapjoyLog.d("TJAdUnitJSBridge", "Empty name for startUsageTrackingEvent");
                invokeJSCallback(str, false);
                return;
            }
            if (this.a != null) {
                this.a.startAdContentTracking(string, jSONObject);
                invokeJSCallback(str, true);
                return;
            }
            invokeJSCallback(str, false);
        } catch (JSONException e2) {
            TapjoyLog.w("TJAdUnitJSBridge", "Unable to startUsageTrackingEvent. Invalid parameters: " + e2);
        }
    }

    public void endUsageTrackingEvent(JSONObject jSONObject, String str) {
        try {
            String string = jSONObject.getString("name");
            if (string.isEmpty()) {
                TapjoyLog.d("TJAdUnitJSBridge", "Empty name for endUsageTrackingEvent");
                invokeJSCallback(str, false);
                return;
            }
            if (this.a != null) {
                this.a.endAdContentTracking(string, jSONObject);
                invokeJSCallback(str, true);
                return;
            }
            invokeJSCallback(str, false);
        } catch (JSONException e2) {
            TapjoyLog.w("TJAdUnitJSBridge", "Unable to endUsageTrackingEvent. Invalid parameters: " + e2);
        }
    }

    public void sendUsageTrackingEvent(JSONObject jSONObject, String str) {
        try {
            String string = jSONObject.getString("name");
            if (string.isEmpty()) {
                TapjoyLog.d("TJAdUnitJSBridge", "Empty name for sendUsageTrackingEvent");
                invokeJSCallback(str, false);
                return;
            }
            if (this.a != null) {
                this.a.sendAdContentTracking(string, jSONObject);
                invokeJSCallback(str, true);
                return;
            }
            invokeJSCallback(str, false);
        } catch (JSONException e2) {
            TapjoyLog.w("TJAdUnitJSBridge", "Unable to sendUsageTrackingEvent. Invalid parameters: " + e2);
        }
    }

    public void hasSplitView(JSONObject jSONObject, final String str) {
        TapjoyUtil.runOnMainThread(new Runnable() {
            /* class com.tapjoy.TJAdUnitJSBridge.AnonymousClass3 */

            public final void run() {
                if (TJAdUnitJSBridge.this.h != null) {
                    TJAdUnitJSBridge.this.invokeJSCallback(str, Boolean.TRUE);
                    return;
                }
                TJAdUnitJSBridge.this.invokeJSCallback(str, Boolean.FALSE);
            }
        });
    }

    public void dismissSplitView(JSONObject jSONObject, final String str) {
        TapjoyUtil.runOnMainThread(new Runnable() {
            /* class com.tapjoy.TJAdUnitJSBridge.AnonymousClass4 */

            public final void run() {
                if (TJAdUnitJSBridge.this.h != null) {
                    String str = str;
                    if (str != null) {
                        TJAdUnitJSBridge.this.invokeJSCallback(str, Boolean.TRUE);
                    }
                    if (TJAdUnitJSBridge.this.splitWebViewCallbackID != null) {
                        TJAdUnitJSBridge tJAdUnitJSBridge = TJAdUnitJSBridge.this;
                        tJAdUnitJSBridge.invokeJSCallback(tJAdUnitJSBridge.splitWebViewCallbackID, Boolean.TRUE);
                        TJAdUnitJSBridge.this.splitWebViewCallbackID = null;
                    }
                    ((ViewGroup) TJAdUnitJSBridge.this.h.getParent()).removeView(TJAdUnitJSBridge.this.h);
                    TJAdUnitJSBridge.this.h = null;
                    return;
                }
                String str2 = str;
                if (str2 != null) {
                    TJAdUnitJSBridge.this.invokeJSCallback(str2, Boolean.FALSE);
                }
            }
        });
    }

    public void getSplitViewURL(JSONObject jSONObject, final String str) {
        TapjoyUtil.runOnMainThread(new Runnable() {
            /* class com.tapjoy.TJAdUnitJSBridge.AnonymousClass5 */

            public final void run() {
                if (TJAdUnitJSBridge.this.h != null) {
                    TJAdUnitJSBridge tJAdUnitJSBridge = TJAdUnitJSBridge.this;
                    tJAdUnitJSBridge.invokeJSCallback(str, tJAdUnitJSBridge.h.getLastUrl());
                    return;
                }
                TJAdUnitJSBridge.this.invokeJSCallback(str, JSONObject.NULL);
            }
        });
    }

    public void isNetworkAvailable(JSONObject jSONObject, String str) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f.getSystemService("connectivity")).getActiveNetworkInfo();
            invokeJSCallback(str, Boolean.valueOf(activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()));
        } catch (Exception unused) {
            invokeJSCallback(str, Boolean.FALSE);
        }
    }

    public void setEnabled(boolean z) {
        this.k = z;
        if (z) {
            flushBacklogMessageQueue();
        }
    }

    class a extends AsyncTask {
        WebView a;

        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
            return (Boolean[]) objArr;
        }

        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ void onPostExecute(Object obj) {
            Boolean[] boolArr = (Boolean[]) obj;
            final boolean booleanValue = boolArr[0].booleanValue();
            final boolean booleanValue2 = boolArr[1].booleanValue();
            if (TJAdUnitJSBridge.this.f instanceof Activity) {
                TapjoyUtil.runOnMainThread(new Runnable() {
                    /* class com.tapjoy.TJAdUnitJSBridge.a.AnonymousClass1 */

                    public final void run() {
                        if (booleanValue) {
                            a.this.a.setVisibility(0);
                            if (booleanValue2) {
                                if (a.this.a.getParent() instanceof RelativeLayout) {
                                    ((RelativeLayout) a.this.a.getParent()).getBackground().setAlpha(0);
                                    ((RelativeLayout) a.this.a.getParent()).setBackgroundColor(0);
                                }
                                if (Build.VERSION.SDK_INT >= 11) {
                                    a.this.a.setLayerType(1, null);
                                    return;
                                }
                                return;
                            }
                            if (a.this.a.getParent() instanceof RelativeLayout) {
                                ((RelativeLayout) a.this.a.getParent()).getBackground().setAlpha(255);
                                ((RelativeLayout) a.this.a.getParent()).setBackgroundColor(-1);
                            }
                            if (Build.VERSION.SDK_INT >= 11) {
                                a.this.a.setLayerType(0, null);
                                return;
                            }
                            return;
                        }
                        a.this.a.setVisibility(4);
                        if (a.this.a.getParent() instanceof RelativeLayout) {
                            ((RelativeLayout) a.this.a.getParent()).getBackground().setAlpha(0);
                            ((RelativeLayout) a.this.a.getParent()).setBackgroundColor(0);
                        }
                    }
                });
            } else {
                TapjoyLog.e("TJAdUnitJSBridge", "Unable to present offerwall. No Activity context provided.");
            }
        }

        public a(WebView webView) {
            this.a = webView;
        }
    }

    public void onVideoReady(int i2, int i3, int i4) {
        HashMap hashMap = new HashMap();
        hashMap.put(TJAdUnitConstants.String.VIDEO_EVENT_NAME, TJAdUnitConstants.String.VIDEO_READY_EVENT);
        hashMap.put(TJAdUnitConstants.String.VIDEO_DURATION, Integer.valueOf(i2));
        hashMap.put(TJAdUnitConstants.String.VIDEO_WIDTH, Integer.valueOf(i3));
        hashMap.put(TJAdUnitConstants.String.VIDEO_HEIGHT, Integer.valueOf(i4));
        invokeJSAdunitMethod(TJAdUnitConstants.String.VIDEO_EVENT, hashMap);
    }

    public void onVideoStarted(int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put(TJAdUnitConstants.String.VIDEO_EVENT_NAME, TJAdUnitConstants.String.VIDEO_START_EVENT);
        hashMap.put(TJAdUnitConstants.String.VIDEO_CURRENT_TIME, Integer.valueOf(i2));
        invokeJSAdunitMethod(TJAdUnitConstants.String.VIDEO_EVENT, hashMap);
    }

    public void onVideoProgress(int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put(TJAdUnitConstants.String.VIDEO_EVENT_NAME, TJAdUnitConstants.String.VIDEO_PROGRESS_EVENT);
        hashMap.put(TJAdUnitConstants.String.VIDEO_CURRENT_TIME, Integer.valueOf(i2));
        invokeJSAdunitMethod(TJAdUnitConstants.String.VIDEO_EVENT, hashMap);
    }

    public void onVideoPaused(int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put(TJAdUnitConstants.String.VIDEO_EVENT_NAME, TJAdUnitConstants.String.VIDEO_PAUSE_EVENT);
        hashMap.put(TJAdUnitConstants.String.VIDEO_CURRENT_TIME, Integer.valueOf(i2));
        invokeJSAdunitMethod(TJAdUnitConstants.String.VIDEO_EVENT, hashMap);
    }

    public void onVideoCompletion() {
        HashMap hashMap = new HashMap();
        hashMap.put(TJAdUnitConstants.String.VIDEO_EVENT_NAME, TJAdUnitConstants.String.VIDEO_COMPLETE_EVENT);
        invokeJSAdunitMethod(TJAdUnitConstants.String.VIDEO_EVENT, hashMap);
    }

    public void onVideoInfo(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(TJAdUnitConstants.String.VIDEO_EVENT_NAME, TJAdUnitConstants.String.VIDEO_INFO_EVENT);
        hashMap.put(TJAdUnitConstants.String.VIDEO_INFO, str);
        invokeJSAdunitMethod(TJAdUnitConstants.String.VIDEO_EVENT, hashMap);
    }

    public void onVideoError(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(TJAdUnitConstants.String.VIDEO_EVENT_NAME, TJAdUnitConstants.String.VIDEO_ERROR_EVENT);
        hashMap.put("error", str);
        invokeJSAdunitMethod(TJAdUnitConstants.String.VIDEO_EVENT, hashMap);
    }

    public void notifyOrientationChanged(String str, int i2, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("orientation", str);
        hashMap.put("width", Integer.valueOf(i2));
        hashMap.put("height", Integer.valueOf(i3));
        invokeJSAdunitMethod(TJAdUnitConstants.String.ORIENTATION_CHANGED_EVENT, hashMap);
    }
}
