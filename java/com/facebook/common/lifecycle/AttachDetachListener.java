package com.facebook.common.lifecycle;

import android.view.View;

public interface AttachDetachListener {
    void onAttachToView(View view);

    void onDetachFromView(View view);
}
