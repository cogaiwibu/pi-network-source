package com.facebook.react.views.art;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;

public class ARTTextShadowNode extends ARTShapeShadowNode {
    private static final int DEFAULT_FONT_SIZE = 12;
    private static final String PROP_FONT = "font";
    private static final String PROP_FONT_FAMILY = "fontFamily";
    private static final String PROP_FONT_SIZE = "fontSize";
    private static final String PROP_FONT_STYLE = "fontStyle";
    private static final String PROP_FONT_WEIGHT = "fontWeight";
    private static final String PROP_LINES = "lines";
    private static final int TEXT_ALIGNMENT_CENTER = 2;
    private static final int TEXT_ALIGNMENT_LEFT = 0;
    private static final int TEXT_ALIGNMENT_RIGHT = 1;
    private ReadableMap mFrame;
    private int mTextAlignment = 0;

    @ReactProp(name = "frame")
    public void setFrame(ReadableMap readableMap) {
        this.mFrame = readableMap;
    }

    @ReactProp(defaultInt = 0, name = "alignment")
    public void setAlignment(int i) {
        this.mTextAlignment = i;
    }

    @Override // com.facebook.react.views.art.ARTVirtualNode, com.facebook.react.views.art.ARTShapeShadowNode
    public void draw(Canvas canvas, Paint paint, float f) {
        ReadableArray array;
        if (this.mFrame != null) {
            float f2 = f * this.mOpacity;
            if (f2 > 0.01f && this.mFrame.hasKey(PROP_LINES) && (array = this.mFrame.getArray(PROP_LINES)) != null && array.size() != 0) {
                saveAndSetupCanvas(canvas);
                int size = array.size();
                String[] strArr = new String[size];
                for (int i = 0; i < size; i++) {
                    strArr[i] = array.getString(i);
                }
                String join = TextUtils.join(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE, strArr);
                if (setupStrokePaint(paint, f2)) {
                    applyTextPropertiesToPaint(paint);
                    if (this.mPath == null) {
                        canvas.drawText(join, 0.0f, -paint.ascent(), paint);
                    } else {
                        canvas.drawTextOnPath(join, this.mPath, 0.0f, 0.0f, paint);
                    }
                }
                if (setupFillPaint(paint, f2)) {
                    applyTextPropertiesToPaint(paint);
                    if (this.mPath == null) {
                        canvas.drawText(join, 0.0f, -paint.ascent(), paint);
                    } else {
                        canvas.drawTextOnPath(join, this.mPath, 0.0f, 0.0f, paint);
                    }
                }
                restoreCanvas(canvas);
                markUpdateSeen();
            }
        }
    }

    private void applyTextPropertiesToPaint(Paint paint) {
        ReadableMap map;
        int i = this.mTextAlignment;
        int i2 = 2;
        if (i == 0) {
            paint.setTextAlign(Paint.Align.LEFT);
        } else if (i == 1) {
            paint.setTextAlign(Paint.Align.RIGHT);
        } else if (i == 2) {
            paint.setTextAlign(Paint.Align.CENTER);
        }
        ReadableMap readableMap = this.mFrame;
        if (readableMap != null && readableMap.hasKey(PROP_FONT) && (map = this.mFrame.getMap(PROP_FONT)) != null) {
            float f = 12.0f;
            if (map.hasKey("fontSize")) {
                f = (float) map.getDouble("fontSize");
            }
            paint.setTextSize(f * this.mScale);
            boolean z = map.hasKey("fontWeight") && "bold".equals(map.getString("fontWeight"));
            boolean z2 = map.hasKey("fontStyle") && "italic".equals(map.getString("fontStyle"));
            if (z && z2) {
                i2 = 3;
            } else if (z) {
                i2 = 1;
            } else if (!z2) {
                i2 = 0;
            }
            paint.setTypeface(Typeface.create(map.getString("fontFamily"), i2));
        }
    }
}
