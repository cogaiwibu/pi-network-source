package com.facebook.internal.instrument.crashreport;

import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.InstrumentData;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public class CrashShieldHandler {
    private static final Set<Object> sCrashingObjects = Collections.newSetFromMap(new WeakHashMap());

    public static void methodFinished(Object obj) {
    }

    public static void handleThrowable(Throwable th, Object obj) {
        sCrashingObjects.add(obj);
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            new InstrumentData(th, InstrumentData.Type.CrashShield).save();
        }
    }

    public static boolean isObjectCrashing(Object obj) {
        return sCrashingObjects.contains(obj);
    }

    public static void reset() {
        resetCrashingObjects();
    }

    public static void resetCrashingObjects() {
        sCrashingObjects.clear();
    }
}
