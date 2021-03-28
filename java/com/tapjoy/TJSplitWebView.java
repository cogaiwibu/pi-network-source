package com.tapjoy;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.common.util.UriUtil;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.internal.jq;
import java.util.Arrays;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

public class TJSplitWebView extends RelativeLayout {
    private TJWebView a;
    private a b;
    private a c;
    private String d;
    private String e;
    private String f;
    private Uri g;
    private HashSet h;
    private JSONObject i;
    private TJAdUnitJSBridge j;
    private Context k;
    private Boolean l;
    private RelativeLayout m;
    private FrameLayout n;
    private ProgressBar o;
    private TextView p;
    private TJImageButton q;
    private TJImageButton r;
    private String s;
    private boolean t;
    private String u;
    private String v;
    private String w;

    public TJSplitWebView(Context context, JSONObject jSONObject, TJAdUnitJSBridge tJAdUnitJSBridge) {
        super(context);
        this.j = tJAdUnitJSBridge;
        this.k = context;
        JSONObject optJSONObject = jSONObject.optJSONObject(TJAdUnitConstants.String.SPLIT_VIEW_LAYOUT);
        JSONArray optJSONArray = jSONObject.optJSONArray(TJAdUnitConstants.String.SPLIT_VIEW_EXIT_HOSTS);
        JSONObject optJSONObject2 = jSONObject.optJSONObject(TJAdUnitConstants.String.SPLIT_VIEW_ERROR_DIALOG_STRINGS);
        this.s = jSONObject.optString(TJAdUnitConstants.String.SPLIT_VIEW_URL_FOR_EXTERNAL_OPEN);
        this.i = jSONObject.optJSONObject(TJAdUnitConstants.String.SPLIT_VIEW_ANIMATION);
        setLayoutOption(optJSONObject);
        setExitHosts(optJSONArray);
        setErrorDialog(optJSONObject2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        TJWebView tJWebView = new TJWebView(this.k);
        this.a = tJWebView;
        tJWebView.setId(TapjoyUtil.generateViewId());
        this.a.setBackgroundColor(-1);
        WebSettings settings = this.a.getSettings();
        if (settings != null) {
            settings.setUseWideViewPort(true);
        }
        this.a.setWebViewClient(new b(this, (byte) 0));
        Boolean valueOf = Boolean.valueOf(jSONObject.optBoolean(TJAdUnitConstants.String.SPLIT_VIEW_SHOW_TOOLBAR));
        this.l = valueOf;
        if (valueOf.booleanValue()) {
            addToolbar();
            addLineBreak();
            addProgressBar();
            this.a.setWebChromeClient(new WebChromeClient() {
                /* class com.tapjoy.TJSplitWebView.AnonymousClass1 */

                public final void onProgressChanged(WebView webView, int i) {
                    super.onProgressChanged(webView, i);
                    TJSplitWebView.this.o.setProgress(i);
                    TJSplitWebView.this.isFirstOrLastPage();
                }
            });
        }
        addView(this.a, layoutParams);
    }

    public void addToolbar() {
        RelativeLayout relativeLayout = new RelativeLayout(this.k);
        this.m = relativeLayout;
        relativeLayout.setId(TapjoyUtil.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) (new TapjoyDisplayMetricsUtil(getContext()).getScreenDensityScale() * 40.0f));
        layoutParams.addRule(6);
        this.m.setBackgroundColor(-1);
        this.m.setVisibility(0);
        setupToolbarUI();
        addView(this.m, layoutParams);
    }

    public void addProgressBar() {
        ProgressBar progressBar = new ProgressBar(this.k, null, 16842872);
        this.o = progressBar;
        progressBar.setMax(100);
        this.o.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#5d95ff")));
        this.o.setProgressBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#dddddd")));
        addView(this.o);
    }

    public void addLineBreak() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.n = frameLayout;
        frameLayout.setBackgroundColor(Color.parseColor("#dddddd"));
        addView(this.n);
    }

    public void setupToolbarUI() {
        float screenDensityScale = new TapjoyDisplayMetricsUtil(getContext()).getScreenDensityScale();
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        TJImageButton tJImageButton = new TJImageButton(this.k);
        this.q = tJImageButton;
        tJImageButton.setId(TapjoyUtil.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        int i2 = (int) (10.0f * screenDensityScale);
        layoutParams.setMargins(i2, i2, i2, i2);
        int i3 = (int) (5.0f * screenDensityScale);
        this.q.setPadding(i3, i2, i2, i2);
        this.q.setEnabledImageBitmap(TapjoyIcons.getBackEnabledImage(screenDensityScale));
        this.q.setDisableImageBitmap(TapjoyIcons.getBackDisabledImage(screenDensityScale));
        this.q.setBackgroundColor(0);
        this.q.setOnClickListener(new View.OnClickListener() {
            /* class com.tapjoy.TJSplitWebView.AnonymousClass2 */

            public final void onClick(View view) {
                if (TJSplitWebView.this.a.canGoBack()) {
                    TJSplitWebView.this.a.goBack();
                }
            }
        });
        relativeLayout.addView(this.q, layoutParams);
        this.r = new TJImageButton(this.k);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(1, this.q.getId());
        layoutParams2.setMargins(i2, i2, i2, i2);
        this.r.setPadding(i2, i2, i3, i2);
        this.r.setEnabledImageBitmap(TapjoyIcons.getForwardEnabledImage(screenDensityScale));
        this.r.setDisableImageBitmap(TapjoyIcons.getForwardDisabledImage(screenDensityScale));
        this.r.setBackgroundColor(0);
        this.r.setOnClickListener(new View.OnClickListener() {
            /* class com.tapjoy.TJSplitWebView.AnonymousClass3 */

            public final void onClick(View view) {
                TJSplitWebView.this.a.goForward();
            }
        });
        relativeLayout.addView(this.r, layoutParams2);
        ImageButton imageButton = new ImageButton(this.k);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(15);
        layoutParams3.addRule(11);
        layoutParams3.setMargins(i2, i2, i2, i2);
        imageButton.setPadding(i3, i3, i3, i3);
        imageButton.setImageBitmap(TapjoyIcons.getCloseImage(screenDensityScale));
        imageButton.setBackgroundColor(0);
        imageButton.setOnClickListener(new View.OnClickListener() {
            /* class com.tapjoy.TJSplitWebView.AnonymousClass4 */

            public final void onClick(View view) {
                TJSplitWebView.this.a();
            }
        });
        relativeLayout.addView(imageButton, layoutParams3);
        TextView textView = new TextView(this.k);
        this.p = textView;
        textView.setId(TapjoyUtil.generateViewId());
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(13);
        this.p.setMaxLines(1);
        this.p.setMaxEms(200);
        this.p.setTextAlignment(4);
        this.p.setTextColor(Color.parseColor("#5d95ff"));
        this.p.setBackgroundColor(0);
        this.p.setEnabled(false);
        this.p.setTypeface(Typeface.create("sans-serif-medium", 0));
        relativeLayout.addView(this.p, layoutParams4);
        ImageButton imageButton2 = new ImageButton(this.k);
        imageButton2.setId(TapjoyUtil.generateViewId());
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(1, this.p.getId());
        layoutParams5.addRule(15);
        imageButton2.setPadding(i3, i3, i3, i3);
        imageButton2.setImageBitmap(TapjoyIcons.getOpenBrowserImage(screenDensityScale));
        imageButton2.setBackgroundColor(0);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            /* class com.tapjoy.TJSplitWebView.AnonymousClass5 */

            public final void onClick(View view) {
                TJSplitWebView.this.openInExternalBrowser();
            }
        });
        relativeLayout.addView(imageButton2, layoutParams5);
        this.m.addView(relativeLayout, new RelativeLayout.LayoutParams(-1, -2));
    }

    public void openInExternalBrowser() {
        Uri uri;
        if (jq.c(this.s)) {
            uri = Uri.parse(this.a.getUrl());
            if (uri == null) {
                uri = Uri.parse(getLastUrl());
            }
        } else {
            uri = Uri.parse(this.s);
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(uri);
        intent.addFlags(268435456);
        if (this.a.getContext() != null) {
            try {
                this.a.getContext().startActivity(intent);
            } catch (Exception e2) {
                TapjoyLog.d("TJSplitWebView", e2.getMessage());
            }
        }
    }

    public boolean goBack() {
        if (!this.a.canGoBack()) {
            return false;
        }
        this.a.goBack();
        return true;
    }

    public void isFirstOrLastPage() {
        this.q.setEnabled(this.a.canGoBack());
        this.r.setEnabled(this.a.canGoForward());
    }

    public void showErrorDialog() {
        new AlertDialog.Builder(this.k, 16974394).setMessage(this.u).setPositiveButton(this.v, new DialogInterface.OnClickListener() {
            /* class com.tapjoy.TJSplitWebView.AnonymousClass7 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).setNegativeButton(this.w, new DialogInterface.OnClickListener() {
            /* class com.tapjoy.TJSplitWebView.AnonymousClass6 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (jq.c(TJSplitWebView.this.getLastUrl())) {
                    TJSplitWebView tJSplitWebView = TJSplitWebView.this;
                    tJSplitWebView.loadUrl(tJSplitWebView.d);
                } else {
                    TJSplitWebView tJSplitWebView2 = TJSplitWebView.this;
                    tJSplitWebView2.loadUrl(tJSplitWebView2.getLastUrl());
                }
                dialogInterface.cancel();
            }
        }).create().show();
    }

    public void applyLayoutOption(JSONObject jSONObject) {
        setLayoutOption(jSONObject);
        a(getWidth(), getHeight());
    }

    public void setExitHosts(JSONArray jSONArray) {
        if (jSONArray == null) {
            this.h = null;
            return;
        }
        this.h = new HashSet();
        for (int i2 = 0; i2 <= jSONArray.length(); i2++) {
            String optString = jSONArray.optString(i2);
            if (optString != null) {
                this.h.add(optString);
            }
        }
    }

    public void setErrorDialog(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.t = true;
            this.u = jSONObject.optString("description");
            this.v = jSONObject.optString(TJAdUnitConstants.String.CLOSE);
            this.w = jSONObject.optString("reload");
        }
    }

    public void setUserAgent(String str) {
        this.a.getSettings().setUserAgentString(str);
    }

    public void setTrigger(String str, String str2) {
        this.f = jq.b(str);
        this.g = str2 != null ? Uri.parse(str2) : null;
    }

    public void loadUrl(String str) {
        TJWebView tJWebView = this.a;
        if (tJWebView != null) {
            this.d = str;
            this.e = str;
            tJWebView.loadUrl(str);
        }
    }

    public String getLastUrl() {
        return this.e;
    }

    /* access modifiers changed from: protected */
    public final void a() {
        this.j.dismissSplitView(null, null);
    }

    /* access modifiers changed from: protected */
    public void setLayoutOption(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("landscape");
            a aVar = null;
            this.c = optJSONObject != null ? new a(optJSONObject) : null;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("portrait");
            if (optJSONObject2 != null) {
                aVar = new a(optJSONObject2);
            }
            this.b = aVar;
        }
    }

    private void a(int i2, int i3) {
        a aVar = i2 <= i3 ? this.b : this.c;
        if (aVar == null) {
            this.a.setVisibility(4);
            return;
        }
        double d2 = (double) i2;
        double d3 = aVar.a;
        Double.isNaN(d2);
        int i4 = (int) (d3 * d2);
        double d4 = (double) i3;
        double d5 = aVar.b;
        Double.isNaN(d4);
        int i5 = (int) (d5 * d4);
        if (i4 == 0 || i5 == 0) {
            this.a.setVisibility(4);
            return;
        }
        double d6 = aVar.c;
        Double.isNaN(d2);
        int i6 = (int) (d2 * d6);
        double d7 = aVar.d;
        Double.isNaN(d4);
        int i7 = (int) (d4 * d7);
        int i8 = (i2 - i4) - i6;
        int i9 = (i3 - i5) - i7;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.getLayoutParams();
        layoutParams.width = i4;
        layoutParams.height = i5;
        Boolean bool = this.l;
        if (bool == null || !bool.booleanValue()) {
            layoutParams.setMargins(i6, i7, i8, i9);
        } else {
            float screenDensityScale = new TapjoyDisplayMetricsUtil(getContext()).getScreenDensityScale();
            int height = ((int) (40.0f * screenDensityScale)) + this.n.getHeight();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            layoutParams2.setMargins(i6, i7, i8, i9);
            this.m.setLayoutParams(layoutParams2);
            layoutParams.setMargins(i6, i7 + height, i8, i9);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i4, (int) screenDensityScale);
            layoutParams3.setMargins(i6, layoutParams.topMargin - this.o.getHeight(), i8, i9);
            this.o.setLayoutParams(layoutParams3);
            this.n.setLayoutParams(layoutParams3);
        }
        this.a.setLayoutParams(layoutParams);
        this.a.setVisibility(0);
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (aVar.e > 0.0f) {
            float[] fArr = new float[8];
            final float f2 = aVar.e * getResources().getDisplayMetrics().density;
            Boolean bool2 = this.l;
            if (bool2 == null || !bool2.booleanValue()) {
                Arrays.fill(fArr, f2);
                ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, null, null));
                shapeDrawable.getPaint().setColor(-1);
                this.a.setBackground(shapeDrawable);
                this.a.setClipToOutline(true);
                return;
            }
            this.m.setOutlineProvider(new ViewOutlineProvider() {
                /* class com.tapjoy.TJSplitWebView.AnonymousClass8 */

                public final void getOutline(View view, Outline outline) {
                    int width = view.getWidth();
                    float f = f2;
                    outline.setRoundRect(0, 0, width, (int) (((float) view.getHeight()) + f), f);
                }
            });
            this.m.setClipToOutline(true);
            return;
        }
        this.a.setBackground(null);
        this.a.setClipToOutline(false);
        Boolean bool3 = this.l;
        if (bool3 != null && bool3.booleanValue()) {
            this.m.setClipToOutline(false);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        a(View.MeasureSpec.getSize(i2), View.MeasureSpec.getSize(i3));
        super.onMeasure(i2, i3);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        final double a;
        final double b;
        final double c;
        final double d;
        final float e;

        a(JSONObject jSONObject) {
            this.a = jSONObject.optDouble("width", 0.0d);
            this.b = jSONObject.optDouble("height", 0.0d);
            this.c = jSONObject.optDouble("left", 0.0d);
            this.d = jSONObject.optDouble("top", 0.0d);
            this.e = (float) jSONObject.optDouble("cornerRadius", 0.0d);
        }
    }

    public void animateOpen(ViewGroup viewGroup) {
        JSONObject jSONObject = this.i;
        if (jSONObject != null && jSONObject.has(TJAdUnitConstants.String.ANIMATION_EVENT_ON_OPEN) && this.i.optString(TJAdUnitConstants.String.ANIMATION_EVENT_ON_OPEN).equalsIgnoreCase(TJAdUnitConstants.String.ANIMATION_TYPE_SLIDE_UP)) {
            setY((float) viewGroup.getHeight());
            animate().translationY(0.0f);
        }
    }

    class b extends WebViewClient {
        private b() {
        }

        /* synthetic */ b(TJSplitWebView tJSplitWebView, byte b) {
            this();
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (TJSplitWebView.this.l.booleanValue()) {
                TJSplitWebView.this.p.setText(TapjoyUrlFormatter.getDomain(str));
                TJSplitWebView.this.o.setVisibility(0);
            }
            TapjoyLog.d("TJSplitWebView", "onPageStarted: " + str);
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            TapjoyLog.d("TJSplitWebView", "shouldOverrideUrlLoading: " + str);
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String host = parse.getHost();
                String scheme = parse.getScheme();
                if (!(scheme == null || host == null || ((!scheme.equals(UriUtil.HTTP_SCHEME) && !scheme.equals(UriUtil.HTTPS_SCHEME)) || (TJSplitWebView.this.h != null && TJSplitWebView.this.h.contains(host))))) {
                    TJSplitWebView.this.e = str;
                    return false;
                }
            }
            try {
                TJSplitWebView.this.k.startActivity(new Intent("android.intent.action.VIEW", parse));
                if (TJSplitWebView.this.l.booleanValue()) {
                    return true;
                }
                TJSplitWebView.this.a();
                return true;
            } catch (Exception e) {
                TapjoyLog.e("TJSplitWebView", e.getMessage());
                return true;
            }
        }

        @Override // android.webkit.WebViewClient
        public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            String str2 = TJSplitWebView.this.f;
            Uri uri = TJSplitWebView.this.g;
            if (!(str2 == null || uri == null || str == null || !str.startsWith(str2))) {
                TJSplitWebView.this.k.startActivity(new Intent("android.intent.action.VIEW", uri));
                TJSplitWebView.this.a();
            }
            return super.shouldInterceptRequest(webView, str);
        }

        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            TapjoyLog.d("TJSplitWebView", "onReceivedError: " + str2 + " firstUrl:" + TJSplitWebView.this.d);
            if (TJSplitWebView.this.t) {
                TJSplitWebView.this.showErrorDialog();
            } else if (str2.equals(TJSplitWebView.this.d)) {
                TJSplitWebView.this.a();
            }
        }

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (TJSplitWebView.this.l.booleanValue()) {
                if (TJSplitWebView.this.o != null) {
                    TJSplitWebView.this.o.setProgress(0);
                    TJSplitWebView.this.o.setVisibility(8);
                }
                TJSplitWebView.this.isFirstOrLastPage();
            }
        }
    }
}
