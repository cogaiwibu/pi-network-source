package com.facebook.react.views.picker;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.AndroidDialogPickerManagerDelegate;
import com.facebook.react.viewmanagers.AndroidDialogPickerManagerInterface;
import com.google.firebase.analytics.FirebaseAnalytics;

@ReactModule(name = ReactDialogPickerManager.REACT_CLASS)
public class ReactDialogPickerManager extends ReactPickerManager implements AndroidDialogPickerManagerInterface<ReactPicker> {
    public static final String REACT_CLASS = "AndroidDialogPicker";
    private final ViewManagerDelegate<ReactPicker> mDelegate = new AndroidDialogPickerManagerDelegate(this);

    @Override // com.facebook.react.bridge.NativeModule, com.facebook.react.uimanager.ViewManager
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, java.lang.Integer] */
    @Override // com.facebook.react.viewmanagers.AndroidDialogPickerManagerInterface
    @ReactProp(customType = "Color", name = "color")
    public /* bridge */ /* synthetic */ void setColor(ReactPicker reactPicker, Integer num) {
        super.setColor(reactPicker, num);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, boolean] */
    @Override // com.facebook.react.viewmanagers.AndroidDialogPickerManagerInterface
    @ReactProp(defaultBoolean = true, name = "enabled")
    public /* bridge */ /* synthetic */ void setEnabled(ReactPicker reactPicker, boolean z) {
        super.setEnabled(reactPicker, z);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, com.facebook.react.bridge.ReadableArray] */
    @Override // com.facebook.react.viewmanagers.AndroidDialogPickerManagerInterface
    @ReactProp(name = FirebaseAnalytics.Param.ITEMS)
    public /* bridge */ /* synthetic */ void setItems(ReactPicker reactPicker, ReadableArray readableArray) {
        super.setItems(reactPicker, readableArray);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, java.lang.String] */
    @Override // com.facebook.react.viewmanagers.AndroidDialogPickerManagerInterface
    @ReactProp(name = "prompt")
    public /* bridge */ /* synthetic */ void setPrompt(ReactPicker reactPicker, String str) {
        super.setPrompt(reactPicker, str);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, int] */
    @Override // com.facebook.react.viewmanagers.AndroidDialogPickerManagerInterface
    @ReactProp(name = "selected")
    public /* bridge */ /* synthetic */ void setSelected(ReactPicker reactPicker, int i) {
        super.setSelected(reactPicker, i);
    }

    /* access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public ReactPicker createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactPicker(themedReactContext, 0);
    }

    /* access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public ViewManagerDelegate<ReactPicker> getDelegate() {
        return this.mDelegate;
    }
}
