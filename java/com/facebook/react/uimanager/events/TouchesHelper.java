package com.facebook.react.uimanager.events;

import android.view.MotionEvent;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;

public class TouchesHelper {
    public static final String CHANGED_TOUCHES_KEY = "changedTouches";
    private static final String LOCATION_X_KEY = "locationX";
    private static final String LOCATION_Y_KEY = "locationY";
    private static final String PAGE_X_KEY = "pageX";
    private static final String PAGE_Y_KEY = "pageY";
    private static final String POINTER_IDENTIFIER_KEY = "identifier";
    public static final String TARGET_KEY = "target";
    private static final String TIMESTAMP_KEY = "timestamp";
    public static final String TOP_TOUCH_CANCEL_KEY = "topTouchCancel";
    public static final String TOP_TOUCH_END_KEY = "topTouchEnd";
    public static final String TOUCHES_KEY = "touches";

    private static WritableArray createsPointersArray(int i, TouchEvent touchEvent) {
        WritableArray createArray = Arguments.createArray();
        MotionEvent motionEvent = touchEvent.getMotionEvent();
        float x = motionEvent.getX() - touchEvent.getViewX();
        float y = motionEvent.getY() - touchEvent.getViewY();
        for (int i2 = 0; i2 < motionEvent.getPointerCount(); i2++) {
            WritableMap createMap = Arguments.createMap();
            createMap.putDouble(PAGE_X_KEY, (double) PixelUtil.toDIPFromPixel(motionEvent.getX(i2)));
            createMap.putDouble(PAGE_Y_KEY, (double) PixelUtil.toDIPFromPixel(motionEvent.getY(i2)));
            createMap.putDouble(LOCATION_X_KEY, (double) PixelUtil.toDIPFromPixel(motionEvent.getX(i2) - x));
            createMap.putDouble(LOCATION_Y_KEY, (double) PixelUtil.toDIPFromPixel(motionEvent.getY(i2) - y));
            createMap.putInt(TARGET_KEY, i);
            createMap.putDouble("timestamp", (double) touchEvent.getTimestampMs());
            createMap.putDouble(POINTER_IDENTIFIER_KEY, (double) motionEvent.getPointerId(i2));
            createArray.pushMap(createMap);
        }
        return createArray;
    }

    public static void sendTouchEvent(RCTEventEmitter rCTEventEmitter, TouchEventType touchEventType, int i, TouchEvent touchEvent) {
        WritableArray createsPointersArray = createsPointersArray(i, touchEvent);
        MotionEvent motionEvent = touchEvent.getMotionEvent();
        WritableArray createArray = Arguments.createArray();
        if (touchEventType == TouchEventType.MOVE || touchEventType == TouchEventType.CANCEL) {
            for (int i2 = 0; i2 < motionEvent.getPointerCount(); i2++) {
                createArray.pushInt(i2);
            }
        } else if (touchEventType == TouchEventType.START || touchEventType == TouchEventType.END) {
            createArray.pushInt(motionEvent.getActionIndex());
        } else {
            throw new RuntimeException("Unknown touch type: " + touchEventType);
        }
        rCTEventEmitter.receiveTouches(TouchEventType.getJSEventName(touchEventType), createsPointersArray, createArray);
    }
}
