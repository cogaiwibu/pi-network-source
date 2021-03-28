package io.invertase.firebase.interfaces;

import com.facebook.react.bridge.WritableMap;

public interface NativeEvent {
    WritableMap getEventBody();

    String getEventName();

    String getFirebaseAppName();
}
