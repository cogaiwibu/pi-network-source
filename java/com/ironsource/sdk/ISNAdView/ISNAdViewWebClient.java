package com.ironsource.sdk.ISNAdView;

import android.os.Build;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ironsource.sdk.WPAD.ISNAdViewProtocol;

public class ISNAdViewWebClient extends WebViewClient {
    private ISNAdViewProtocol.IErrorReportDelegate mDelegate;

    private String getMessage(String str, String str2) {
        return "ISNAdViewWebClient | External Adunit failed to load." + str + " " + "Status code: " + str2;
    }

    public ISNAdViewWebClient(ISNAdViewProtocol.IErrorReportDelegate iErrorReportDelegate) {
        this.mDelegate = iErrorReportDelegate;
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        String str = "";
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                str = String.valueOf(webResourceResponse.getStatusCode());
            }
            this.mDelegate.reportOnError(getMessage("onReceivedHttpError", str));
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        try {
            this.mDelegate.reportOnError(getMessage("onReceivedError", String.valueOf(i)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onReceivedError(webView, i, str, str2);
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        try {
            this.mDelegate.reportOnError(getMessage("onReceivedErrorM", String.valueOf(webResourceError.getErrorCode())));
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onReceivedError(webView, webResourceRequest, webResourceError);
    }
}
