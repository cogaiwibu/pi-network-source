package io.invertase.firebase.app;

import android.content.Context;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

public class ReactNativeFirebaseApp {
    private static Context applicationContext;

    public static Context getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(Context context) {
        Log.d("ReactNativeFirebaseApp", "received application context.");
        applicationContext = context;
    }

    public static void initializeSecondaryApp(String str) {
        FirebaseApp.initializeApp(applicationContext, FirebaseOptions.fromResource(applicationContext), str);
    }

    public static void initializeSecondaryApp(String str, Context context) {
        FirebaseApp.initializeApp(context, FirebaseOptions.fromResource(context), str);
    }
}
