package io.invertase.firebase.interfaces;

import android.app.Activity;
import android.content.Context;
import com.facebook.react.bridge.ReactContext;

public interface ContextProvider {
    Activity getActivity();

    Context getApplicationContext();

    ReactContext getContext();
}
