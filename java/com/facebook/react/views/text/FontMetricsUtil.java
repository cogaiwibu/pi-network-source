package com.facebook.react.views.text;

import android.content.Context;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import com.anythink.reactnativejs.utils.Const;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;

public class FontMetricsUtil {
    private static final float AMPLIFICATION_FACTOR = 100.0f;
    private static final String CAP_HEIGHT_MEASUREMENT_TEXT = "T";
    private static final String X_HEIGHT_MEASUREMENT_TEXT = "x";

    public static WritableArray getFontMetrics(CharSequence charSequence, Layout layout, TextPaint textPaint, Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        WritableArray createArray = Arguments.createArray();
        TextPaint textPaint2 = new TextPaint(textPaint);
        textPaint2.setTextSize(textPaint2.getTextSize() * AMPLIFICATION_FACTOR);
        Rect rect = new Rect();
        textPaint2.getTextBounds(CAP_HEIGHT_MEASUREMENT_TEXT, 0, 1, rect);
        double height = (double) ((((float) rect.height()) / AMPLIFICATION_FACTOR) / displayMetrics.density);
        Rect rect2 = new Rect();
        textPaint2.getTextBounds("x", 0, 1, rect2);
        double height2 = (double) ((((float) rect2.height()) / AMPLIFICATION_FACTOR) / displayMetrics.density);
        for (int i = 0; i < layout.getLineCount(); i++) {
            Rect rect3 = new Rect();
            layout.getLineBounds(i, rect3);
            WritableMap createMap = Arguments.createMap();
            createMap.putDouble("x", (double) (layout.getLineLeft(i) / displayMetrics.density));
            createMap.putDouble(Const.Y, (double) (((float) rect3.top) / displayMetrics.density));
            createMap.putDouble("width", (double) (layout.getLineWidth(i) / displayMetrics.density));
            createMap.putDouble("height", (double) (((float) rect3.height()) / displayMetrics.density));
            createMap.putDouble("descender", (double) (((float) layout.getLineDescent(i)) / displayMetrics.density));
            createMap.putDouble("ascender", (double) (((float) (-layout.getLineAscent(i))) / displayMetrics.density));
            createMap.putDouble("baseline", (double) (((float) layout.getLineBaseline(i)) / displayMetrics.density));
            createMap.putDouble("capHeight", height);
            createMap.putDouble("xHeight", height2);
            createMap.putString("text", charSequence.subSequence(layout.getLineStart(i), layout.getLineEnd(i)).toString());
            createArray.pushMap(createMap);
        }
        return createArray;
    }
}
