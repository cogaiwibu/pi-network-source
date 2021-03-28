package io.invertase.firebase.common;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import io.invertase.firebase.app.ReactNativeFirebaseApp;
import javax.annotation.OverridingMethodsMustInvokeSuper;

public class ReactNativeFirebaseInitProvider extends ContentProvider {
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
    }

    @OverridingMethodsMustInvokeSuper
    public boolean onCreate() {
        if (ReactNativeFirebaseApp.getApplicationContext() != null) {
            return false;
        }
        Context context = getContext();
        if (!(context == null || context.getApplicationContext() == null)) {
            context = context.getApplicationContext();
        }
        ReactNativeFirebaseApp.setApplicationContext(context);
        return false;
    }
}
