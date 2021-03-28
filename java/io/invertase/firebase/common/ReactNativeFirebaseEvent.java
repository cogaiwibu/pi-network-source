package io.invertase.firebase.common;

import com.facebook.react.bridge.WritableMap;
import io.invertase.firebase.interfaces.NativeEvent;

public class ReactNativeFirebaseEvent implements NativeEvent {
    private WritableMap eventBody;
    private String eventName;
    private String firebaseAppName;

    public ReactNativeFirebaseEvent(String str, WritableMap writableMap) {
        this.eventName = str;
        this.eventBody = writableMap;
    }

    public ReactNativeFirebaseEvent(String str, WritableMap writableMap, String str2) {
        this.eventName = str;
        this.eventBody = writableMap;
        this.firebaseAppName = str2;
    }

    @Override // io.invertase.firebase.interfaces.NativeEvent
    public String getEventName() {
        return this.eventName;
    }

    @Override // io.invertase.firebase.interfaces.NativeEvent
    public WritableMap getEventBody() {
        return this.eventBody;
    }

    @Override // io.invertase.firebase.interfaces.NativeEvent
    public String getFirebaseAppName() {
        return this.firebaseAppName;
    }
}
