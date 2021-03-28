package com.facebook.react.views.checkbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.TypedValue;
import android.widget.CompoundButton;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.core.widget.CompoundButtonCompat;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;

public class ReactCheckBoxManager extends SimpleViewManager<ReactCheckBox> {
    private static final CompoundButton.OnCheckedChangeListener ON_CHECKED_CHANGE_LISTENER = new CompoundButton.OnCheckedChangeListener() {
        /* class com.facebook.react.views.checkbox.ReactCheckBoxManager.AnonymousClass1 */

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            ((UIManagerModule) getReactContext(compoundButton).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ReactCheckBoxEvent(compoundButton.getId(), z));
        }

        private ReactContext getReactContext(CompoundButton compoundButton) {
            Context context = compoundButton.getContext();
            if (context instanceof TintContextWrapper) {
                return (ReactContext) ((TintContextWrapper) context).getBaseContext();
            }
            return (ReactContext) compoundButton.getContext();
        }
    };
    public static final String REACT_CLASS = "AndroidCheckBox";

    @Override // com.facebook.react.bridge.NativeModule, com.facebook.react.uimanager.ViewManager
    public String getName() {
        return REACT_CLASS;
    }

    /* access modifiers changed from: protected */
    public void addEventEmitters(ThemedReactContext themedReactContext, ReactCheckBox reactCheckBox) {
        reactCheckBox.setOnCheckedChangeListener(ON_CHECKED_CHANGE_LISTENER);
    }

    /* access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public ReactCheckBox createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactCheckBox(themedReactContext);
    }

    @ReactProp(defaultBoolean = true, name = "enabled")
    public void setEnabled(ReactCheckBox reactCheckBox, boolean z) {
        reactCheckBox.setEnabled(z);
    }

    @ReactProp(name = "on")
    public void setOn(ReactCheckBox reactCheckBox, boolean z) {
        reactCheckBox.setOnCheckedChangeListener(null);
        reactCheckBox.setOn(z);
        reactCheckBox.setOnCheckedChangeListener(ON_CHECKED_CHANGE_LISTENER);
    }

    public void receiveCommand(ReactCheckBox reactCheckBox, String str, ReadableArray readableArray) {
        if (((str.hashCode() == -669744680 && str.equals("setNativeValue")) ? (char) 0 : 65535) == 0 && readableArray != null) {
            setOn(reactCheckBox, readableArray.getBoolean(0));
        }
    }

    private static int getThemeColor(Context context, String str) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(getIdentifier(context, str), typedValue, true);
        return typedValue.data;
    }

    private static int getIdentifier(Context context, String str) {
        return context.getResources().getIdentifier(str, "attr", context.getPackageName());
    }

    @ReactProp(name = "tintColors")
    public void setTintColors(ReactCheckBox reactCheckBox, ReadableMap readableMap) {
        int i;
        int i2;
        if (readableMap == null || !readableMap.hasKey("true")) {
            i = getThemeColor(reactCheckBox.getContext(), "colorAccent");
        } else {
            i = readableMap.getInt("true");
        }
        if (readableMap == null || !readableMap.hasKey("false")) {
            i2 = getThemeColor(reactCheckBox.getContext(), "colorPrimaryDark");
        } else {
            i2 = readableMap.getInt("false");
        }
        CompoundButtonCompat.setButtonTintList(reactCheckBox, new ColorStateList(new int[][]{new int[]{16842912}, new int[]{-16842912}}, new int[]{i, i2}));
    }
}
