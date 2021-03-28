package com.tapjoy;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.webkit.WebView;

public class TJWebView extends WebView {
    public TJWebView(Context context) {
        super(context);
        setScrollContainer(false);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        new GestureDetector(new a());
        if (getSettings() != null) {
            getSettings().setJavaScriptEnabled(true);
            if (Build.VERSION.SDK_INT >= 17) {
                getSettings().setMediaPlaybackRequiresUserGesture(false);
            }
        }
        setBackgroundColor(0);
    }

    public TJWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    class a extends GestureDetector.SimpleOnGestureListener {
        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return true;
        }

        a() {
        }
    }
}
