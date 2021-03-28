package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.bridge.JSApplicationCausedNativeException;

public class IllegalViewOperationException extends JSApplicationCausedNativeException {
    private View mView;

    public IllegalViewOperationException(String str) {
        super(str);
    }

    public IllegalViewOperationException(String str, View view, Throwable th) {
        super(str, th);
        this.mView = view;
    }

    public View getView() {
        return this.mView;
    }
}
