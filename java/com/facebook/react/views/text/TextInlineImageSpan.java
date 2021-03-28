package com.facebook.react.views.text;

import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.style.ReplacementSpan;
import android.widget.TextView;

public abstract class TextInlineImageSpan extends ReplacementSpan implements ReactSpan {
    public abstract Drawable getDrawable();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract void onAttachedToWindow();

    public abstract void onDetachedFromWindow();

    public abstract void onFinishTemporaryDetach();

    public abstract void onStartTemporaryDetach();

    public abstract void setTextView(TextView textView);

    public static void possiblyUpdateInlineImageSpans(Spannable spannable, TextView textView) {
        TextInlineImageSpan[] textInlineImageSpanArr = (TextInlineImageSpan[]) spannable.getSpans(0, spannable.length(), TextInlineImageSpan.class);
        for (TextInlineImageSpan textInlineImageSpan : textInlineImageSpanArr) {
            textInlineImageSpan.onAttachedToWindow();
            textInlineImageSpan.setTextView(textView);
        }
    }
}
