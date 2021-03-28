package com.onesignal;

import android.content.Context;
import android.webkit.WebView;

public class OSWebView extends WebView {
    public void computeScroll() {
    }

    public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        return false;
    }

    public void scrollTo(int i, int i2) {
    }

    public OSWebView(Context context) {
        super(context);
    }
}
