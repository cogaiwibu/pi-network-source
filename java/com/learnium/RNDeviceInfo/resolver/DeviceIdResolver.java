package com.learnium.RNDeviceInfo.resolver;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;

public class DeviceIdResolver {
    private final Context context;

    public DeviceIdResolver(Context context2) {
        this.context = context2;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x000c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getInstanceIdSync() {
        /*
            r2 = this;
            java.lang.String r0 = r2.getFirebaseInstanceId()     // Catch:{ ClassNotFoundException -> 0x000c, IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0005 }
            return r0
        L_0x0005:
            java.io.PrintStream r0 = java.lang.System.err
            java.lang.String r1 = "N/A: Unsupported version of com.google.firebase:firebase-iid in your project."
            r0.println(r1)
        L_0x000c:
            java.lang.String r0 = r2.getGmsInstanceId()     // Catch:{ ClassNotFoundException -> 0x0018, IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0011 }
            return r0
        L_0x0011:
            java.io.PrintStream r0 = java.lang.System.err
            java.lang.String r1 = "N/A: Unsupported version of com.google.android.gms.iid in your project."
            r0.println(r1)
        L_0x0018:
            java.io.PrintStream r0 = java.lang.System.err
            java.lang.String r1 = "Can't generate id. Please add com.google.firebase:firebase-iid to your project."
            r0.println(r1)
            java.lang.String r0 = "unknown"
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.learnium.RNDeviceInfo.resolver.DeviceIdResolver.getInstanceIdSync():java.lang.String");
    }

    /* access modifiers changed from: package-private */
    public String getGmsInstanceId() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object invoke = Class.forName("com.google.android.gms.iid.InstanceID").getDeclaredMethod("getInstance", Context.class).invoke(null, this.context);
        return (String) invoke.getClass().getMethod("getId", new Class[0]).invoke(invoke, new Object[0]);
    }

    /* access modifiers changed from: package-private */
    public String getFirebaseInstanceId() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object invoke = Class.forName("com.google.firebase.iid.FirebaseInstanceId").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        return (String) invoke.getClass().getMethod("getId", new Class[0]).invoke(invoke, new Object[0]);
    }
}
